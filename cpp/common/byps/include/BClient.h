#ifndef BCLIENT_H
#define BCLIENT_H

#include "Byps.h"

namespace com { namespace wilutions { namespace byps {

class BClient : public byps_enable_shared_from_this<BClient> {
public:
    const PTransport transport;

    BClient(PTransport transport, PServerR serverR);
    virtual ~BClient();

    virtual PRemote getStub(int remoteId) = 0;

	void start();

#ifdef CPP11_LAMBDA
	static void start(PClient client, std::function<void (PClient, BException)> asyncResult); 
#else
	static void start(PClient client, byps_ptr<BAsyncResultT<PClient> > asyncResult);
#endif

    virtual void done();

protected:   
    virtual void internalStart(PAsyncResult asyncResult);

	const PServerR serverR;

    friend class BClient_Start_BAsyncOuterResult;
};


}}}

#endif // BCLIENT_H
