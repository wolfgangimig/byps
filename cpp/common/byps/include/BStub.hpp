/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BSTUB_HPP
#define BSTUB_HPP

#include "BStub.h"

namespace byps {

BINLINE BStub::BStub(PTransport transport)
    : transport(transport) {
}

BINLINE BStub::~BStub() {
}

BINLINE BTargetId BStub::BRemote_getTargetId() {
    return transport->getTargetId();
}


}

#endif // BSTUB_HPP
