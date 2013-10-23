#ifndef BCLIENT_H
#define BCLIENT_H

#include "Byps.h"

namespace byps {

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

	virtual void setAuthentication(PAuthentication auth);
	virtual PAuthentication getAuthentication();

protected:   

    virtual void internalStart(PAsyncResult asyncResult);

	const PServerR serverR;

    friend class BClient_MyNegoAsyncResult;
	friend class BClient_ClientAuthentication;
};


}

#endif // BCLIENT_H
