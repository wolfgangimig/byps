/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BSERVER_H
#define BSERVER_H

#include "Byps.h"

namespace byps {

using namespace ::std;

class BServer {
public:
    const PTransport transport;
    const PClient clientR;

    BServer(PTransport transport, PClient clientR);
    virtual ~BServer();

    void addRemote(BTYPEID typeId, PSkeleton remote);

    void recv(const BTargetId& clientTargetId, PSerializable methodObj, PAsyncResult methodResult);
	 
	PProtocol negotiate(const BTargetId& targetId, PBytes& buf, PAsyncResult& asyncResult);

protected:
    unordered_map<BTYPEID, PRemote> remotes;
};

class BServerR {
public:
    const PTransport transport;
    const PServer server;

    BServerR(PTransport transport, PServer server);
    virtual ~BServerR();

    virtual void start();
    virtual void done();

	virtual void setLostConnectionHandler(PLostConnectionHandler lostConnectionHandler) = 0;
};

}


#endif // BSERVER_H
