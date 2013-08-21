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

BINLINE void BClient::start() {
	BSyncResultT<PClient> syncResult;
	internalStart(&syncResult);
	syncResult.getResult();
}

#ifdef CPP11_LAMBDA

class BClientStart_BAsyncResultT : public BAsyncResultT<PClient> {
	function<void (const PClient, BException ex)> innerResult;
public:
	BClientStart_BAsyncResultT(function<void (const PClient, BException ex)> innerResult) 
		: innerResult(innerResult) {
	}
	virtual void setAsyncResult(PClient result, BException ex) {
		innerResult(result, ex);
		delete this;
	}
};

BINLINE void BClient::start(PClient client, function<void (PClient, BException)> asyncResult) {
	PAsyncResult outerResult = new BClientStart_BAsyncResultT(asyncResult);
	client->internalStart(outerResult);
}

#else

BINLINE void BClient::start(PClient client, byps_ptr<BAsyncResultT<PClient> > asyncResult) {
	client->internalStart(client, asyncResult);
}

#endif

class  BClient_Start_BAsyncOuterResult : public BAsyncResult {
    PClient client;
    PAsyncResult innerResult;
public:
    BClient_Start_BAsyncOuterResult(PClient client, PAsyncResult asyncResult)
        : client(client), innerResult(asyncResult) {
    }
	virtual ~BClient_Start_BAsyncOuterResult() {
		client.reset();
		innerResult = NULL;
	}
    virtual void setAsyncResult(const BVariant& result) {
        try {
            if (result.isException()) {
                innerResult->setAsyncResult(result);
            }
            else {
                if (client->serverR) {
                    client->serverR->start();
                }
                innerResult->setAsyncResult(BVariant(client));
            }
        }
        catch (const exception& e) {
            innerResult->setAsyncResult(BVariant(e));
        }
		delete this;
    }
};

BINLINE void BClient::internalStart(PAsyncResult asyncResult) {

	PClient client = shared_from_this();
    BClient_Start_BAsyncOuterResult* outerResult = new BClient_Start_BAsyncOuterResult(client, asyncResult);

    transport->negotiateProtocolClient(outerResult);

}

}}}

#endif // BCLIENT_HPP
