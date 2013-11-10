#ifndef BTRANSPORT_HPP_
#define BTRANSPORT_HPP_

#include "BTransport.h"

namespace byps {

using namespace std::chrono;

BINLINE BTransport::BTransport(PApiDescriptor apiDesc, const PWire& wire, const PRemoteRegistry &remoteRegistry)
    : wire(wire)
	, remoteRegistry(remoteRegistry)
	, apiDesc(apiDesc)
	, protocol(PProtocol())
{
}

BINLINE BTransport::BTransport(const BTransport &rhs, const BTargetId &targetId)
    : wire(rhs.wire)
	, remoteRegistry(rhs.remoteRegistry)
	, apiDesc(rhs.apiDesc)
	, protocol(rhs.protocol)
	, targetId(targetId)
	, authentication(rhs.authentication)
{
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

class BTransport_ReloginAndRetrySend;
typedef BTransport_ReloginAndRetrySend* PTransport_BAsyncOuterResult;

class BTransport_ReloginAndRetrySend : public BAsyncResult {
	PTransport transport;
	PSerializable requestObject; 
	PAsyncResult innerResult;
public:
	BTransport_ReloginAndRetrySend(PTransport transport, PSerializable requestObject, PAsyncResult innerResult) 
		: transport(transport)
		, requestObject(requestObject)
		, innerResult(innerResult)
	{
	}

    virtual void setAsyncResult(const BVariant& result) {
		try {
            if (result.isException()) {
                innerResult->setAsyncResult(BVariant(result.getException()));
            }
            else {
				transport->assignSessionThenSendMethod(requestObject, innerResult);
            }
		}
        catch (const exception& ex) {
            innerResult->setAsyncResult(BVariant(ex));
		}
		delete this;
	}

};

class BTransport_MyNegoAsyncResult : public BAsyncResult {
public:
	PTransport transport;
    PAsyncResult innerResult;

    BTransport_MyNegoAsyncResult(PTransport transport, const PAsyncResult& innerResult)
		: transport(transport), innerResult(innerResult) {
	}
	virtual ~BTransport_MyNegoAsyncResult() {
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

				transport->internalAuthenticate(innerResult);
            }
		}
        catch (const exception& ex) {
            innerResult->setAsyncResult(BVariant(ex));
		}
		delete this;
	}

};

class BTransport_DeserlializeMethodResultMaybeRelogin : public BAsyncResult {
	PTransport transport;
	PSerializable requestObject; 
	PAsyncResult innerResult;
public:
	BTransport_DeserlializeMethodResultMaybeRelogin(PTransport transport, PSerializable requestObject, PAsyncResult innerResult) 
		: transport(transport)
		, requestObject(requestObject)
		, innerResult(innerResult)
	{
	}

	virtual ~BTransport_DeserlializeMethodResultMaybeRelogin() {}

    virtual void setAsyncResult(const BVariant& result) { 
		bool relogin = false;

		try {
            if (result.isException()) {
				relogin = internalIsReloginException(result.getException());
				if (!relogin) {
					innerResult->setAsyncResult(BVariant(result.getException()));
				}
            }
            else {
				try {
					POBJECT obj;
					result.get(obj);
                    if (obj) {
                        PMessage msg = byps_static_ptr_cast<BMessage>(obj);

                        PInput inp = transport->getInput(msg->header, msg->buf);
                        PSerializable sobj = inp->load();
                        innerResult->setAsyncResult(BVariant(sobj));
                    }
                    else {
                        BException ex(EX_CORRUPT, L"Missing message object in result.");
                        innerResult->setAsyncResult(BVariant(ex));
                    }
				}
				catch (const BException& e) {
					relogin = internalIsReloginException(e);
					if (!relogin) {
						innerResult->setAsyncResult(BVariant(e));
					}
				}
            }

			if (relogin) {
				transport->loginAndRetrySend(requestObject, innerResult);
 			}
		}
        catch (const exception& ex) {
            innerResult->setAsyncResult(BVariant(ex));
		}

		delete this;
	}

private:
	bool internalIsReloginException(BException e) {
		BTYPEID typeId = requestObject->BSerializable_getTypeId();
        return transport->internalIsReloginException(e, typeId);
    }

};

BINLINE void BTransport::loginAndRetrySend(PSerializable requestObject, PAsyncResult asyncResult) {
	// Cancel long-polls.
	// They will be restarted over negotiateProtocolClient and BClient::authentication.
	wire->cancelAllRequests();

	PAsyncResult loginResult(new BTransport_ReloginAndRetrySend(shared_from_this(), requestObject, asyncResult));

    negotiateProtocolClient(loginResult);
}


BINLINE void BTransport::negotiateProtocolClient(PAsyncResult asyncResult) {
	PTransport pthis = shared_from_this();
	if (!pthis) return;

	PBytes bytes = BBytes::create(NEGOTIATE_MAX_SIZE);
	BNegotiate nego(apiDesc);
    nego.version = apiDesc->version;
    nego.write(bytes);

    PAsyncResult outerResult = new BTransport_MyNegoAsyncResult(pthis, asyncResult);

    BMessageHeader header;
    header.messageId = wire->makeMessageId();
    vector<PStreamRequest> streams;
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
    catch (const exception& ex) {
        asyncResult->setAsyncResult(BVariant(ex));
	}
    return protocol;
}

BINLINE PProtocol BTransport::createNegotiatedProtocol(BNegotiate& nego) {
	PProtocol protocol;

    if (nego.protocols.size() == 0) {
		throw BException(EX_CORRUPT, L"Protocol negotiation failed. Cannot detect protocol.");
	}

    if (nego.protocols.find(BBinaryModel::MEDIUM().getProtocolId()) != string::npos) {
        BVERSION negotiatedVersion = min(nego.version, apiDesc->version);
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

BINLINE void BTransport::sendMethod(const PMethodRequest& methodRequest, PAsyncResult asyncResult) {
	assignSessionThenSendMethod(methodRequest, asyncResult);
}

BINLINE void BTransport::send(const PSerializable& obj, PAsyncResult asyncResult) {

	PTransport pthis = shared_from_this();
	if (!pthis) throw BException(EX_CANCELLED);

	try {
        POutput outp = getOutput();
		outp->store(obj);

        PAsyncResult outerResult = new BTransport_DeserlializeMethodResultMaybeRelogin(pthis, obj, asyncResult);

        PMessage msg = outp->toMessage();
        
		wire->send(msg, outerResult);

	}
    catch (const exception& ex) {
        asyncResult->setAsyncResult(BVariant(ex));
	}
}

class BTransport_AssingSessionThenSendMethod : public BAsyncResult {
	PTransport pTransport;
	PSerializable requestObject;
	PAsyncResult asyncResult;
public:
	BTransport_AssingSessionThenSendMethod(PTransport pTransport, PSerializable requestObject, PAsyncResult asyncResult) 
		: pTransport(pTransport), requestObject(requestObject), asyncResult(asyncResult) {
	}
	virtual void setAsyncResult(const BVariant& result) {
		if (result.isException()) {
			asyncResult->setAsyncResult(result);
		}
		else {
			PMethodRequest methodRequest = byps_ptr_cast<BMethodRequest>(requestObject);
			if (methodRequest) {
				PSerializable session;
				result.get(session);
				methodRequest->setSession(session);
			}
			pTransport->send(methodRequest, asyncResult);
		}
		delete this;
	}
};

BINLINE void BTransport::assignSessionThenSendMethod(PSerializable requestObject, PAsyncResult asyncResult) {
	if (this->authentication) {
		try {
			BTYPEID typeId = getObjectTypeId(requestObject);
			PAsyncResult sessionResult(new BTransport_AssingSessionThenSendMethod(shared_from_this(), requestObject, asyncResult));
			this->authentication->getSession(PClient(), typeId, sessionResult);
		}
		catch (const BException& ex) {
			asyncResult->setAsyncResult(BVariant(ex));
		}
	}
	else {
		this->send(requestObject, asyncResult);
	}
}

BINLINE BTYPEID BTransport::getObjectTypeId(PSerializable ser)
{
	BTYPEID typeId = 0;
	protocol->getRegistry()->getSerializer(typeid(*ser.get()), typeId);
	return typeId;
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
		catch (const exception& ex) {
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

BINLINE bool BTransport::internalIsReloginException(BException ex, BTYPEID typeId) {
	bool ret = false;

	if (authentication && ex) {
		ret = authentication->isReloginException(PClient(), ex, typeId);
	}

	return ret;
}

BINLINE bool BTransport::isReloginException(BException ex, int ) {
    bool ret = false;
    
    // Check exception
    if (ex) 
    {
        ret = ex.getCode() == EX_UNAUTHORIZED;
    }
      
    return ret;
}


class BTransport_InternalAuthenticate_BAsyncResult : public BAsyncResult
{
public:
	BTransport_InternalAuthenticate_BAsyncResult(PTransport transport)
		: transport(transport)
    {
    }

    virtual void setAsyncResult(const BVariant& result) {

		BException ex = result.getException();
		std::vector<PAsyncResult> copyResults;

		{
			byps_unique_lock lock(transport->mtx);
            copyResults = transport->asyncResultsWaitingForAuthentication;
            transport->asyncResultsWaitingForAuthentication.clear();
            transport->lastAuthenticationTime = system_clock::now();
			transport->lastAuthenticationException = ex;
        }

        for (size_t i = 0; i < copyResults.size(); i++)
        {
            copyResults[i]->setAsyncResult(result);
        }

		delete this;
    }

private:
	PTransport transport;
};


const unsigned RETRY_AUTHENTICATION_AFTER_MILLIS = 1 * 1000;

BINLINE void BTransport::internalAuthenticate(PAsyncResult innerResult) {

	if (authentication) {
		
		bool first = false;
		bool assumeAuthenticationIsValid = false;

		{
			byps_unique_lock lock(mtx);

			system_clock::time_point now = system_clock::now();
			milliseconds diff = duration_cast<milliseconds>(now - lastAuthenticationTime);
			assumeAuthenticationIsValid = RETRY_AUTHENTICATION_AFTER_MILLIS >= diff.count();

			if (!assumeAuthenticationIsValid)
			{
				first = asyncResultsWaitingForAuthentication.size() == 0;
				asyncResultsWaitingForAuthentication.push_back(innerResult);
			}
		}

		if (first) {
			
			PAsyncResult authResult(new BTransport_InternalAuthenticate_BAsyncResult(shared_from_this()));
			authentication->authenticate(PClient(), authResult);

		}
		else if (assumeAuthenticationIsValid) {
			innerResult->setAsyncResult(BVariant(lastAuthenticationException));
		}
		else {
            // innerResult has been added to asyncResultsWaitingForAuthentication 
            // and will be called in InternalAuthenticate_BAsyncResult
		}

	}
	else {
		innerResult->setAsyncResult(BVariant(true));
	}
}

void BTransport::setAuthentication(PAuthentication auth, bool onlyIfNull) {
	byps_unique_lock lock(mtx);
	if (onlyIfNull && authentication) return;
	authentication = auth;
	lastAuthenticationException = BException();
	lastAuthenticationTime = system_clock::time_point();
	asyncResultsWaitingForAuthentication.clear();
}


}



#endif
