/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BCLIENT_HPP
#define BCLIENT_HPP

#include "BClient.h"
#include <thread>

namespace byps {

BINLINE BClient::BClient(PTransport transport, PServerR serverR)
    : transport(transport), serverR(serverR) {
}

BINLINE BClient::~BClient() {

}

BINLINE PTransport BClient::getTransport() {
	return transport;
}

BINLINE void BClient::internalDone(PClient client) {
	// Close the wire connection.
	// In HWireClient it will call internalCancelAllRequests which cancels 
	// all messages - inclusive long polls from serverR - for this session.
	client->getTransport()->wire->done();
}

BINLINE void BClient::done() {

    if (serverR) {
        serverR->done();
    }

	// Call BWire::done in background thread, since this function
	// could be called in a thread that belongs to the internal thread pool
	// and would kill itself.
	{
		std::thread th(internalDone, shared_from_this());
		th.detach();
	}

	getTransport()->setAuthentication(PAuthentication(), false);
}

#ifdef CPP11_LAMBDA

class BClientStart_BAsyncResultT : public BAsyncResultT<bool> {
	function<void (const bool, BException ex)> innerResult;
public:
	BClientStart_BAsyncResultT(function<void (const bool, BException ex)> innerResult) 
		: innerResult(innerResult) {
	}
	virtual void setAsyncResult(bool result, BException ex) {
		innerResult(result, ex);
		delete this;
	}
};

BINLINE void BClient::start(function<void (bool, BException)> asyncResult) {
	PAsyncResult outerResult = new BClientStart_BAsyncResultT(asyncResult);
	internalStart(outerResult);
}

#else

BINLINE void BClient::start(PClient client, byps_ptr<BAsyncResultT<bool> > asyncResult) {
	client->internalStart(client, asyncResult);
}

#endif

BINLINE void BClient::start() {
	BSyncResultT<PClient> syncResult;
	internalStart(&syncResult);
	syncResult.getResult();
}

class  BClient_MyNegoAsyncResult : public BAsyncResult {
    PClient client;
    PAsyncResult innerResult;
public:

    BClient_MyNegoAsyncResult(PClient client, PAsyncResult innerResult)
        : client(client), innerResult(innerResult) {
    }

	virtual ~BClient_MyNegoAsyncResult() {
		client.reset();
	}

	void internalSetAsyncResult(const BVariant& result) {
		innerResult->setAsyncResult(result);
	}

	virtual void setAsyncResult(const BVariant& result) {
        try {
            if (result.isException()) {
                internalSetAsyncResult(result);
            }
            else {
                if (client->serverR) {
                    client->serverR->start();
                }
                internalSetAsyncResult(result);
            }
        }
        catch (const exception& e) {
            internalSetAsyncResult(BVariant(e));
        }
		delete this;
    }
};


BINLINE void BClient::internalStart(PAsyncResult asyncResult) {
	setAuthentication(PAuthentication());
    getTransport()->negotiateProtocolClient(asyncResult);
}

class BClient_ClientAuthentication : public BAuthentication
{
	byps_weak_ptr<BClient> client;
    PAuthentication innerAuth;

public:
	BClient_ClientAuthentication(PClient client, PAuthentication innerAuth)
		: client(client)
		, innerAuth(innerAuth)
    {
    }

	PAuthentication getInnerAuthentication() {
		return innerAuth;
	}
            
	virtual void authenticate(PClient , PAsyncResult asyncResult) {
		PClient client = this->client.lock();
		if (client) {

			PAsyncResult startClientResult(new BClient_MyNegoAsyncResult(client, asyncResult));
			if (innerAuth) {
				innerAuth->authenticate(client, startClientResult);
			}
			else {
				startClientResult->setAsyncResult(BVariant());
			}
		}
		else {
			asyncResult->setAsyncResult(BVariant(BException(BExceptionC::CANCELLED)));
		}
    }

    virtual bool isReloginException(PClient , BException ex, BTYPEID typeId) 
    {
        bool ret = false;

		PClient client = this->client.lock();
		if (client) {

			if (innerAuth)
			{
				ret = innerAuth->isReloginException(client, ex, typeId);
			}
			else
			{
				ret = client->getTransport()->isReloginException(ex, typeId);
			}
		}

        return ret;
    }

    virtual void getSession(PClient , BTYPEID typeId, PAsyncResult asyncResult)
    {
        if (innerAuth) {
            innerAuth->getSession(this->client.lock(), typeId, asyncResult);
        }
		else {
			asyncResult->setAsyncResult(BVariant());
		}
    }

#ifdef CPP11_LAMBDA
	virtual void authenticate(PClient , function<void (bool, BException)> ) {
	}

	virtual void getSession(PClient , BTYPEID , function<void (PSerializable, BException)> ) {
	}
#endif

};

BINLINE void BClient::setAuthentication(PAuthentication innerAuth) {
	getTransport()->setAuthentication(
		PAuthentication(new BClient_ClientAuthentication(shared_from_this(), innerAuth)),
		innerAuth == NULL); // onlyIfNull
}

BINLINE PAuthentication BClient::getAuthentication() {
	PAuthentication auth = getTransport()->authentication;
	if (auth) {
		BClient_ClientAuthentication* clientAuth = dynamic_cast<BClient_ClientAuthentication*>(auth.get());
		if (clientAuth) {
			auth = clientAuth->getInnerAuthentication();
		}
	}
	return auth;
}

BINLINE void BClient::setLostReverseConnectionHandler(function<void (BException ex)> lostConnectionHandler) {
	PLostConnectionHandler handler(new BLostConnectionHandlerL(lostConnectionHandler));
	setLostReverseConnectionHandler(handler);
}

BINLINE void BClient::setLostReverseConnectionHandler(PLostConnectionHandler lostConnectionHandler) {
	if (serverR) {
		serverR->setLostConnectionHandler(lostConnectionHandler);
	}
}

}

#endif // BCLIENT_HPP
