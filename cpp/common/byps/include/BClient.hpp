#ifndef BCLIENT_HPP
#define BCLIENT_HPP

#include "BClient.h"

namespace com { namespace wilutions { namespace byps {

BINLINE BClient::BClient(PTransport transport, PServerR serverR)
    : transport(transport), serverR(serverR) {
}

BINLINE BClient::~BClient() {

}

BINLINE void BClient::done() {

    if (serverR) {
        serverR->done();
    }

	// Close the wire connection.
	// In HWireClient it will call internalCancelAllRequests which cancels 
	// all messages - inclusive long polls from serverR - for this session.
	transport->wire->done();
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
	
	if (!transport->authentication) {
		setAuthentication(PAuthentication());
	}

    BClient_MyNegoAsyncResult* outerResult = new BClient_MyNegoAsyncResult(shared_from_this(), asyncResult);
    transport->negotiateProtocolClient(outerResult);
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
            
	virtual void authenticate(PClient , function<void (bool, BException)> asyncResult) {
		PClient client = this->client.lock();
		if (client) {

			if (innerAuth) {
				innerAuth->authenticate(client, [client, asyncResult](bool, BException ex) {
					if (!ex) {
						try {
							if (client->serverR) {
								client->serverR->start();
							}
						}
						catch (const BException& e) {
							ex = e;
						}
					}
					asyncResult(false, ex);
				});
			}
			else {
				asyncResult(false, BException());
			}
		}
		else {
			asyncResult(false, BException(EX_CANCELLED));
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
				ret = client->transport->isReloginException(ex, typeId);
			}
		}

        return ret;
    }

    virtual PSerializable getSession()
    {
        PSerializable ret;
        if (innerAuth)
        {
            ret = innerAuth->getSession();
        }
        return ret;
    }

};

BINLINE void BClient::setAuthentication(PAuthentication innerAuth) {
	transport->authentication = PAuthentication(new BClient_ClientAuthentication(shared_from_this(), innerAuth));
}

BINLINE PAuthentication BClient::getAuthentication() {
	return transport->authentication;
}


}}}

#endif // BCLIENT_HPP
