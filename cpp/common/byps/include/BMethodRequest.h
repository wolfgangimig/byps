/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
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
    virtual void execute(const PRemote& remote, PAsyncResult methodResult) = 0;
    virtual void setSession(const PSerializable& ) {}
};

//template <BTYPEID _remoteId> class BMethodRequestT : public BMethodRequest {
//public:
//    BMethodRequestT() : BMethodRequest(_remoteId) {}
//};

}

#endif
