#ifndef BSERVER_H
#define BSERVER_H

#include "Byps.h"

namespace com { namespace wilutions { namespace byps {

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
};

}}}


#endif // BSERVER_H
