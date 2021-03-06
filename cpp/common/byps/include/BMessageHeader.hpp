/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BMESSAGEHEADER_HPP_
#define BMESSAGEHEADER_HPP_

#include "BMessageHeader.h"

namespace byps {

  BINLINE BMessageHeader::BMessageHeader(int32_t nMagic, int32_t bversion, BVERSION nNegotiatedVersion, BByteOrder negotiatedByteOrder, int64_t messageId)
    : magic(nMagic),
    error(0),
    flags(bversion ? BHEADER_FLAG_BYPS_VERSION : 0),
    bversion(bversion),
    version(nNegotiatedVersion),
    byteOrder(negotiatedByteOrder),
    messageId(messageId) {
  }

  BINLINE BMessageHeader::BMessageHeader()
    : magic(0),
    error(0),
    flags(0),
    bversion(0),
    version(0),
    byteOrder(BBIG_ENDIAN),
    messageId(0){
  }

  BINLINE BMessageHeader::BMessageHeader(const BMessageHeader& rhs)
    : magic(rhs.magic)
    , error(rhs.error)
    , flags(rhs.flags)
    , bversion(rhs.bversion)
    , version(rhs.version)
    , byteOrder(rhs.byteOrder)
    , messageId(rhs.messageId)
    , targetId(rhs.targetId)
    , sessionId(rhs.sessionId)
  {
  }

  BINLINE void BMessageHeader::write(BBuffer& bbuf) {
    bool cmpr = bbuf.setCompressInteger(false);
    bbuf.setByteOrder(byteOrder);
    bbuf.serialize(magic);
    bbuf.serialize(error);
    bbuf.serialize(flags);

    if (flags & BHEADER_FLAG_BYPS_VERSION) {
      bbuf.serialize(bversion);
    }

    bbuf.serialize(version);
    targetId.serialize(bbuf, bversion);
    bbuf.serialize(messageId);
    bbuf.setCompressInteger(cmpr);

    if (bversion >= BHEADER_BYPS_VERSION_WITH_SESSIONID) {
      BTargetId::writeSessionId(bbuf, sessionId);
    }
  }

  BINLINE void BMessageHeader::read(BBuffer& bbuf) {
    bbuf.setByteOrder(BBIG_ENDIAN);
    bool cmpr = bbuf.setCompressInteger(false);

    bbuf.serialize(magic);

    switch(magic) {
    case BMAGIC_BINARY_STREAM:
      break;
    case BMAGIC_BINARY_STREAM_LE:
      magic = BMAGIC_BINARY_STREAM;
      bbuf.setByteOrder(BLITTLE_ENDIAN);
      break;
    default:
      throw BException(BExceptionC::CORRUPT, L"Stream must start with BYPS or SPYB");
    }

    bbuf.serialize(error);
    bbuf.serialize(flags);

    if (flags & BHEADER_FLAG_BYPS_VERSION) {
      bbuf.serialize(bversion);
    }

    bbuf.serialize(version);
    targetId.serialize(bbuf, bversion);
    bbuf.serialize(messageId);

    bbuf.setCompressInteger(cmpr);

    if (bversion >= BHEADER_BYPS_VERSION_WITH_SESSIONID) {
      sessionId = BTargetId::readSessionId(bbuf);
    }
  }

}

#endif