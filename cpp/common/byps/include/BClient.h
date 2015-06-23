/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BCLIENT_H
#define BCLIENT_H

#include "Byps.h"

namespace byps {

using namespace ::std;

class BClient : public byps_enable_shared_from_this<BClient> {
protected:
	PTransport transport;
	volatile bool startRVal;
public:

    BClient(PTransport transport, PServerR serverR);
    virtual ~BClient();

    virtual PRemote getStub(int remoteId) = 0;
	virtual PTransport getTransport();

	void start(bool startR = true);

	void startR();

#ifdef CPP11_LAMBDA
    void start(function<void (bool, BException)> asyncResult, bool startR = true);
#else
	void start(byps_ptr<BAsyncResultT<bool> > asyncResult);
#endif

    virtual void done();
	virtual void setAuthentication(PAuthentication auth);
	virtual PAuthentication getAuthentication();

#ifdef CPP11_LAMBDA
	virtual void setLostReverseConnectionHandler(function<void (BException ex)> lostConnectionHandler);
#endif
	virtual void setLostReverseConnectionHandler(PLostConnectionHandler lostConnectionHandler);


protected:   

    virtual void internalStart(PAsyncResult asyncResult, bool startR);
	virtual void internalStartR();
	static void internalDone(PClient client);

	const PServerR serverR;

    friend class BClient_MyNegoAsyncResult;
	friend class BClient_ClientAuthentication;
};


}

#endif // BCLIENT_H
