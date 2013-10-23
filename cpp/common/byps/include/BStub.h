#ifndef BSTUB_H
#define BSTUB_H

#include "Byps.h"

namespace byps {


class BStub : public virtual BRemote {
public:
    const PTransport transport;

    BStub(PTransport transport);
    virtual ~BStub();
    virtual BTargetId BRemote_getTargetId();
};

template <typename _Type> POBJECT BSERIALIZER_BStub(BIO& bio, _Type* pStub, BTYPEID typeId) {
    POBJECT remote;
    if (bio.is_loading) {
        if (pStub) {
            // All work is done in previsious call with pObj==NULL
        }
        else {
            BTargetId targetId;
            bio & targetId;
            PRemoteRegistry rreg = bio.transport->remoteRegistry;
            if (rreg) {
                remote = rreg->getRemote(targetId, typeId);
            }
            else {
                PTransport transport(new BTransport(*bio.transport, targetId));
                remote = PSerializable(new _Type(transport));
            }
        }
    }
    else {
        BTargetId targetId = pStub->BRemote_getTargetId();
        bio & targetId;
    }
    return remote;
}


}

#endif // BSTUB_H
