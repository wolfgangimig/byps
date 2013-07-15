#ifndef BPROTOCOL_H_
#define BPROTOCOL_H_

#include "Byps.h"

namespace com { namespace wilutions { namespace byps {

class BProtocol {
public:
    BProtocol(PApiDescriptor apiDesc, int32_t negotiatedVersion, BByteOrder negotiatedByteOrder);
    virtual ~BProtocol() {}

    virtual POutput getOutput(PTransport transport, const BMessageHeader& responseHeader);
    virtual PInput getInput(PTransport transport, const BMessageHeader& header, PBytes& pBytes);

protected:
	PApiDescriptor apiDesc;

    int32_t m_nNegotiatedVersion;

    BByteOrder m_negotiatedByteOrder;

};

}}}

#endif
