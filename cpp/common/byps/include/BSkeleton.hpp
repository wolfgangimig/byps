/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BSKELETON_HPP
#define BSKELETON_HPP

#include "BSkeleton.h"

namespace byps {

BINLINE BSkeleton::~BSkeleton() {
}

BINLINE BTargetId BSkeleton::BRemote_getTargetId() {
    return targetId;
}

BINLINE void BSkeleton::BSkeleton_setTargetId(BTargetId targetId) {
    this->targetId = targetId;
}

}
#endif // BSKELETON_HPP
