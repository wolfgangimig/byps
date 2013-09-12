#ifndef BCLIENT_H
#define BCLIENT_H

#include "Byps.h"

namespace com { namespace wilutions { namespace byps {

using namespace ::std;

class BClient : public byps_enable_shared_from_this<BClient> {
public:
    const PTransport transport;

    BClient(PTransport transport, PServerR serverR);
    virtual ~BClient();

    virtual PRemote getStub(int remoteId) = 0;

	void start();

#ifdef CPP11_LAMBDA
    void start(function<void (bool, BException)> asyncResult);
#else
	void start(byps_ptr<BAsyncResultT<bool> > asyncResult);
#endif

    virtual void done();

protected:   
    virtual void internalStart(PAsyncResult asyncResult);

	const PServerR serverR;

    friend class BClient_Start_BAsyncOuterResult;
};


}}}

#endif // BCLIENT_H
