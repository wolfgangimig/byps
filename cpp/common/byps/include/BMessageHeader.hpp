#ifndef BMESSAGEHEADER_HPP_
#define BMESSAGEHEADER_HPP_

#include "BMessageHeader.h"

namespace com { namespace wilutions { namespace byps {

BINLINE BMessageHeader::BMessageHeader(int32_t nMagic, int32_t nNegotiatedVersion, BByteOrder negotiatedByteOrder, int64_t messageId)
    : magic(nMagic),
        error(0),
        flags(0),
        version(nNegotiatedVersion),
        byteOrder(negotiatedByteOrder),
        messageId(messageId) {
}

BINLINE BMessageHeader::BMessageHeader()
    : magic(0),
    error(0),
    flags(0),
    version(0),
    byteOrder(BBIG_ENDIAN),
    messageId(0) {
}

BINLINE BMessageHeader::BMessageHeader(const BMessageHeader& rhs)
    : magic(rhs.magic)
    , error(rhs.error)
    , flags(rhs.flags)
    , version(rhs.version)
    , byteOrder(rhs.byteOrder)
    , messageId(rhs.messageId)
    , targetId(rhs.targetId){
}

BINLINE void BMessageHeader::write(BBuffer& bbuf) {
    bbuf.setByteOrder(byteOrder);
    bbuf.serialize(magic);
    bbuf.serialize(error);
    bbuf.serialize(flags);
    bbuf.serialize(version);
	targetId.serialize(bbuf);
    bbuf.serialize(messageId);
}

BINLINE void BMessageHeader::read(BBuffer& bbuf) {
    bbuf.setByteOrder(BBIG_ENDIAN);
    bbuf.serialize(magic);

    switch(magic) {
	case BMAGIC_BINARY_STREAM:
		break;
	case BMAGIC_BINARY_STREAM_LE:
		magic = BMAGIC_BINARY_STREAM;
        bbuf.setByteOrder(BLITTLE_ENDIAN);
		break;
	default:
		throw BException(EX_CORRUPT, L"Stream must start with BYPS, BYPC, SPYB, CPYB");
	}

    bbuf.serialize(error);
	bbuf.serialize(flags);
	bbuf.serialize(version);
 	targetId.serialize(bbuf);
    bbuf.serialize(messageId);
}

}}}

#endif