/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BSKELETON_H
#define BSKELETON_H

#include "Byps.h"

namespace byps {


class BSkeleton : public virtual BRemote {
public:
    virtual ~BSkeleton();
    virtual BTargetId BRemote_getTargetId();

    void BSkeleton_setTargetId(BTargetId targetId);

private:
    BTargetId targetId;
};

}

#endif // BSKELETON_H
