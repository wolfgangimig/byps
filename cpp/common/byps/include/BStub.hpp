#ifndef BSTUB_HPP
#define BSTUB_HPP

#include "BStub.h"

namespace com { namespace wilutions { namespace byps {

BINLINE BStub::BStub(PTransport transport)
    : transport(transport) {
}

BINLINE BStub::~BStub() {
}

BINLINE BTargetId BStub::BRemote_getTargetId() {
    return transport->getTargetId();
}


}}}

#endif // BSTUB_HPP
