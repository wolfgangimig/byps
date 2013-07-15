#ifndef METHODREQUEST_H_
#define METHODREQUEST_H_

#include "Byps.h"
#include "BSerializable.h"
#include "BRemote.h"

namespace com { namespace wilutions { namespace byps {

class BMethodRequest : public BSerializable {
public:
    const BTYPEID remoteId;
    BMethodRequest(BTYPEID remoteId) : remoteId(remoteId) {}
    virtual void execute(PRemote remote, PAsyncResult methodResult) = 0;
};

//template <BTYPEID _remoteId> class BMethodRequestT : public BMethodRequest {
//public:
//    BMethodRequestT() : BMethodRequest(_remoteId) {}
//};

}}}

#endif
