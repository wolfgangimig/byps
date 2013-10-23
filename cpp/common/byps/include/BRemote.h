#ifndef BRemote_H_
#define BRemote_H_

#include "Byps.h"

namespace byps {

class BRemote : public virtual BSerializable
{
public:
     virtual BTargetId BRemote_getTargetId() = 0;
};

class BRemoteRegistry;
typedef byps_ptr<BRemoteRegistry> PRemoteRegistry;

class BRemoteRegistry {
public:
    virtual ~BRemoteRegistry() {}
    virtual PRemote getRemote(const BTargetId& targetId, BTYPEID remoteId) = 0;
};

}


#endif
