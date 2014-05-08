/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BPROTOCOL_HPP_
#define BPROTOCOL_HPP_

#include "BProtocol.h"
#include "BOutput.h"
#include "BInput.h"

namespace byps {

BINLINE BProtocol::BProtocol(PApiDescriptor apiDesc, int32_t negotiatedBypsVersion, BVERSION negotiatedVersion, BByteOrder negotiatedByteOrder)
    : apiDesc(apiDesc)
    , negotiatedBypsVersion(negotiatedBypsVersion)
    , negotiatedVersion(negotiatedVersion)
    , negotiatedByteOrder(negotiatedByteOrder) {
}

BINLINE POutput BProtocol::getOutput(PTransport transport, const BMessageHeader& responseHeader) {
    if (responseHeader.magic != 0) {
        return POutput(new BOutput(transport, responseHeader));
    }
    else {
        return POutput(new BOutput(transport, negotiatedBypsVersion, negotiatedVersion, negotiatedByteOrder));
    }
}
BINLINE PInput BProtocol::getInput(PTransport transport, const BMessageHeader &header, PBytes& pBytes) {
    return PInput(new BInput(transport, header, pBytes));
}

BINLINE PRegistry BProtocol::getRegistry() {
	return apiDesc->getRegistry(BBinaryModel::MEDIUM());
}

}

#endif
