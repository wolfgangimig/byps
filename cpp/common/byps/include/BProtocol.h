/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BPROTOCOL_H_
#define BPROTOCOL_H_

#include "Byps.h"

namespace byps {

class BProtocol {
public:
    BProtocol(PApiDescriptor apiDesc, int32_t negotiatedBypsVersion, BVERSION negotiatedVersion, BByteOrder negotiatedByteOrder);
    virtual ~BProtocol() {}

    virtual POutput getOutput(PTransport transport, const BMessageHeader& responseHeader);
    virtual PInput getInput(PTransport transport, const BMessageHeader& header, PBytes& pBytes);
	virtual PRegistry getRegistry();

protected:
	PApiDescriptor apiDesc;

    int32_t negotiatedBypsVersion;

    BVERSION negotiatedVersion;

    BByteOrder negotiatedByteOrder;

};

}

#endif
