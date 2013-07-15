#ifndef BPROTOCOL_HPP_
#define BPROTOCOL_HPP_

#include "BProtocol.h"
#include "BOutput.h"
#include "BInput.h"

namespace com { namespace wilutions { namespace byps {

BINLINE BProtocol::BProtocol(PApiDescriptor apiDesc, int32_t negotiatedVersion, BByteOrder negotiatedByteOrder)
: apiDesc(apiDesc), m_nNegotiatedVersion(negotiatedVersion), m_negotiatedByteOrder(negotiatedByteOrder) {
}

BINLINE POutput BProtocol::getOutput(PTransport transport, const BMessageHeader& responseHeader) {
    if (responseHeader.magic != 0) {
        return POutput(new BOutput(transport, responseHeader));
    }
    else {
        return POutput(new BOutput(transport, m_nNegotiatedVersion, m_negotiatedByteOrder));
    }
}
BINLINE PInput BProtocol::getInput(PTransport transport, const BMessageHeader &header, PBytes& pBytes) {
    return PInput(new BInput(transport, header, pBytes));
}


}}}

#endif
