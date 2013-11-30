#ifndef METHODREQUEST_H_
#define METHODREQUEST_H_

#include "Byps.h"
#include "BSerializable.h"
#include "BRemote.h"

namespace byps {

class BMethodRequest : public BSerializable {
public:
    const BTYPEID remoteId;
    BMethodRequest(BTYPEID remoteId) : remoteId(remoteId) {}
    virtual void execute(PRemote remote, PAsyncResult methodResult) = 0;
    virtual void setSession(PSerializable) {}
};

//template <BTYPEID _remoteId> class BMethodRequestT : public BMethodRequest {
//public:
//    BMethodRequestT() : BMethodRequest(_remoteId) {}
//};

}

#endif
