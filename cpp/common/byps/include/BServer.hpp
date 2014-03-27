/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BSERVER_HPP
#define BSERVER_HPP

#include "Byps.h"

namespace byps {


BINLINE BServer::BServer(PTransport transport, PClient clientR)
    : transport(transport), clientR(clientR) {
}

BINLINE BServer::~BServer() {
}

BINLINE void BServer::addRemote(BTYPEID typeId, PSkeleton remote) {
	if (remote) {
		remotes[typeId] = remote;
		remote->BSkeleton_setTargetId(transport->getTargetId());
	}
	else {
		auto it = remotes.find(typeId);
		if (it != remotes.end()) {
			remotes.erase(it);
		}
	}
}


BINLINE PProtocol BServer::negotiate(const BTargetId& targetId, PBytes& buf, PAsyncResult &asyncResult) {
    return transport->negotiateProtocolServer(targetId, buf, asyncResult);
}

BINLINE void BServer::recv(const BTargetId& clientTargetId, PSerializable methodObj, PAsyncResult methodResult) {

    try {
        PMethodRequest method = byps_ptr_cast<BMethodRequest>(methodObj);
        if (!method) {
            throw BException(BExceptionC::CORRUPT, L"Message is not a method");
        }

        PRemote remote;
        const BTYPEID remoteId = method->remoteId;
        const BTargetId serverTargetId = this->transport->getTargetId();

        if (clientTargetId == serverTargetId) {
            remote = remotes[remoteId];
        }
        else if (transport->getRemoteRegistry()) {
            remote = transport->getRemoteRegistry()->getRemote(clientTargetId, remoteId);
        }

        if (!remote) {
            wstringstream ss;
            ss << L"Service not implemented: remoteId=" << remoteId;
            throw BException(BExceptionC::SERVICE_NOT_IMPLEMENTED, ss.str());
        }

        method->execute(remote, methodResult);
    }
    catch (const BException& ex) {
        methodResult->setAsyncResult(BVariant(ex));
    }
    catch (...) {
        BException ex(BExceptionC::CORRUPT);
        methodResult->setAsyncResult(BVariant(ex));
    }
}



BINLINE BServerR::BServerR(PTransport transport, PServer server)
    : transport(transport), server(server) {
}

BINLINE BServerR::~BServerR() {
}

BINLINE void BServerR::start() {
}

BINLINE void BServerR::done() {
}


}

#endif // BSERVER_HPP
