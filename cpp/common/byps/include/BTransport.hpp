#ifndef BTRANSPORT_HPP_
#define BTRANSPORT_HPP_

#include "BTransport.h"

namespace com { namespace wilutions { namespace byps {

BINLINE BTransport::BTransport(PApiDescriptor apiDesc, const PWire& wire, const PRemoteRegistry &remoteRegistry)
    : wire(wire), remoteRegistry(remoteRegistry), apiDesc(apiDesc), protocol(PProtocol()) {
}

BINLINE BTransport::BTransport(const BTransport &rhs, const BTargetId &targetId)
    : wire(rhs.wire), remoteRegistry(rhs.remoteRegistry), apiDesc(rhs.apiDesc), protocol(rhs.protocol), targetId(targetId){
}

BINLINE BTransport::~BTransport() {
}

BINLINE POutput BTransport::getOutput() {
    byps_unique_lock lock(mtx);
    if (!protocol) throw BException(EX_INTERNAL, L"No protocol negotiated.");
	
	PTransport pthis = shared_from_this();
	if (!pthis) throw BException(EX_CANCELLED);

    return protocol->getOutput(pthis, BMessageHeader());
}

BINLINE POutput BTransport::getResponse(BMessageHeader& requestHeader) {
    byps_unique_lock lock(mtx);
    if (!protocol) throw BException(EX_INTERNAL, L"No protocol negotiated.");

	PTransport pthis = shared_from_this();
	if (!pthis) throw BException(EX_CANCELLED);

	BMessageHeader responseHeader(requestHeader);
	responseHeader.flags |= BHEADER_FLAG_RESPONSE;
    return protocol->getOutput(pthis, responseHeader);
}

BINLINE PInput BTransport::getInput(BMessageHeader& header, PBytes& buf) {
    byps_unique_lock lock(mtx);
    if (!protocol) throw BException(EX_INTERNAL, L"No protocol negotiated.");
    return protocol->getInput(shared_from_this(), header, buf);
}

BINLINE BTargetId BTransport::getTargetId() {
    byps_unique_lock lock(mtx);
    return targetId;
}

BINLINE void BTransport::setTargetId(BTargetId targetId) {
    byps_unique_lock lock(mtx);
    targetId = targetId;
}

BINLINE PProtocol BTransport::getProtocol() {
    byps_unique_lock lock(mtx);
    return protocol;
}

class BTransport_BAsyncOuterResult;
typedef BTransport_BAsyncOuterResult* PTransport_BAsyncOuterResult;

class BTransport_BAsyncOuterResult : public BAsyncResult {
public:
	PTransport transport;
    PAsyncResult innerResult;

    virtual void setAsyncResult(const BVariant& result) {
		try {
            if (result.isException()) {
                innerResult->setAsyncResult(BVariant(result.getException()));
            }
            else {
				POBJECT obj;
				result.get(obj);
                PMessage msg = byps_static_ptr_cast<BMessage>(obj);

                PInput inp = transport->getInput(msg->header, msg->buf);
                PSerializable sobj = inp->load();
                innerResult->setAsyncResult(BVariant(sobj));
            }
		}
        catch (const std::exception& ex) {
            innerResult->setAsyncResult(BVariant(ex));
		}
		delete this;
	}

};

class BTransport_NegotiateClient_BAsyncOuterResult : public BAsyncResult {
public:
	PTransport transport;
    PAsyncResult innerResult;

    BTransport_NegotiateClient_BAsyncOuterResult(PTransport transport, const PAsyncResult& innerResult)
		: transport(transport), innerResult(innerResult) {
	}
	virtual ~BTransport_NegotiateClient_BAsyncOuterResult() {
	}

    virtual void setAsyncResult(const BVariant& result) {
		try {
            if (result.isException()) {
                innerResult->setAsyncResult(result);
            }
            else {
				POBJECT obj;
				result.get(obj);
                PMessage msg = byps_static_ptr_cast<BMessage>(obj);

                BNegotiate nego;
                nego.read(msg->buf);
                {
                    byps_unique_lock lock(transport->mtx);
                    transport->protocol = transport->createNegotiatedProtocol(nego);
                    transport->targetId = nego.targetId;
                }
                innerResult->setAsyncResult(BVariant(true));
            }
		}
        catch (const std::exception& ex) {
            innerResult->setAsyncResult(BVariant(ex));
		}
		delete this;
	}

};

BINLINE void BTransport::negotiateProtocolClient(PAsyncResult asyncResult) {
	PTransport pthis = shared_from_this();
	if (!pthis) return;

	PBytes bytes = BBytes::create(NEGOTIATE_MAX_SIZE);
	BNegotiate nego(apiDesc);
    nego.version = apiDesc->version;
    nego.write(bytes);

    PAsyncResult outerResult = new BTransport_NegotiateClient_BAsyncOuterResult(pthis, asyncResult);

    BMessageHeader header;
    header.messageId = wire->makeMessageId();
    std::vector<PStreamRequest> streams;
    PMessage msg(new BMessage(header, bytes, streams));

    wire->send(msg, outerResult);
}

BINLINE PProtocol BTransport::negotiateProtocolServer(const BTargetId& targetId, PBytes& buf, PAsyncResult asyncResult) {
	try {
        bool succ = BNegotiate::isNegotiateMessage(buf);
		if (succ) {
			BNegotiate nego;
            nego.read(buf);

            {
                byps_unique_lock lock(mtx);
                protocol = createNegotiatedProtocol(nego);
                this->targetId = targetId;
            }

			PBytes bytes = BBytes::create(NEGOTIATE_MAX_SIZE);
            nego.targetId = targetId;
            nego.write(bytes);

            asyncResult->setAsyncResult(BVariant(bytes));
		}
	}
    catch (const std::exception& ex) {
        asyncResult->setAsyncResult(BVariant(ex));
	}
    return protocol;
}

BINLINE PProtocol BTransport::createNegotiatedProtocol(BNegotiate& nego) {
	PProtocol protocol;

    if (nego.protocols.size() == 0) {
		throw BException(EX_CORRUPT, L"Protocol negotiation failed. Cannot detect protocol.");
	}

    if (nego.protocols.find(BBinaryModel::MEDIUM().getProtocolId()) != std::string::npos) {
        int32_t negotiatedVersion = std::min(nego.version, apiDesc->version);
        protocol = PProtocol(new BProtocol(apiDesc, negotiatedVersion, nego.byteOrder));
        nego.protocols = BBinaryModel::MEDIUM().getProtocolId();
        nego.version = negotiatedVersion;
	}
	else {
		throw BException(EX_CORRUPT, L"Protocol negotiation failed. Cannot detect protocol.");
	}
	return protocol;
}

BINLINE PProtocol BTransport::detectProtocolFromInputBuffer(const PBytes&) {
    return PProtocol();
}

BINLINE void BTransport::send(const PSerializable& obj, PAsyncResult asyncResult) {

	PTransport pthis = shared_from_this();
	if (!pthis) throw BException(EX_CANCELLED);

	try {
        POutput outp = getOutput();
		outp->store(obj);

        PTransport_BAsyncOuterResult outerResult(new BTransport_BAsyncOuterResult());
		outerResult->transport = pthis;
		outerResult->innerResult = asyncResult;

        PMessage msg = outp->toMessage();
        
		wire->send(msg, outerResult);

	}
    catch (const std::exception& ex) {
        asyncResult->setAsyncResult(BVariant(ex));
	}
}

class BTransport_MethodResult : public BAsyncResult {
	POutput outp;
    PAsyncResult innerResult;
public:
	BTransport_MethodResult(POutput outp, PAsyncResult innerResult)
		: outp(outp), innerResult(innerResult) {
	}
	virtual void setAsyncResult(const BVariant& var) {
		try {
			if (var.isException()) {
				outp->setException(var.getException());
			}
			else {
				PSerializable obj;
				var.get(obj);
				outp->store(obj);
			}
			PMessage msg = outp->toMessage();

			innerResult->setAsyncResult(BVariant(msg));
		}
		catch (const std::exception& ex) {
			innerResult->setAsyncResult(BVariant(ex));
		}
		delete this;
	}
};

BINLINE void BTransport::recv(PServer server, PMessage message, PAsyncResult asyncResult) {

	PInput bin = getInput(message->header, message->buf);
	PSerializable methodObject = bin->load();

	POutput bout = getResponse(bin->header);
	PAsyncResult methodResult(new BTransport_MethodResult(bout, asyncResult));

	BTargetId clientTargetId = bin->header.targetId;
	server->recv(clientTargetId, methodObject, methodResult);

}

}}}



#endif
