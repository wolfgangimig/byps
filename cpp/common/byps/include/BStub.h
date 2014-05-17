/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
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

}

#endif // BSTUB_H
