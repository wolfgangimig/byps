/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BMESSAGEHEADER_H_
#define BMESSAGEHEADER_H_

#include "Byps.h"
#include "BBuffer.h"

namespace byps {

const int32_t BMAGIC_BINARY_STREAM = 1113149523; // { 'B', 'Y', 'P', 'S' }

// { 'B', 'Y', 'P', 'N' } ist belegt für BNegotiate

const int32_t BMAGIC_BINARY_STREAM_LE = 1397774658; // 0x53505942

const int32_t BHEADER_BYPS_VERSION_EXTENDED_STREAM_INFORMATION = 1;
const int32_t BHEADER_BYPS_VERSION_CURRENT = BHEADER_BYPS_VERSION_EXTENDED_STREAM_INFORMATION;

const int32_t BHEADER_FLAG_BYPS_VERSION = 1;
const int32_t BHEADER_FLAG_RESPONSE = 2;

class BMessageHeader {
public:
    int32_t magic;
    int32_t error;
    int32_t flags;
    int32_t bversion;
    BVERSION version;
    BByteOrder byteOrder;
    int64_t messageId;
    BTargetId targetId;

    BMessageHeader(int32_t nMagic, int32_t bversion, BVERSION nNegotiatedVersion, BByteOrder negotiatedByteOrder, int64_t messageId);
    BMessageHeader();
    BMessageHeader(const BMessageHeader& rhs);
    void write(BBuffer& bbuf);
    void read(BBuffer& bbuf);
};

}

#endif
