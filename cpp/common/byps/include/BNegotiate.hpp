/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BNEGOTIATE_HPP_
#define BNEGOTIATE_HPP_

#include "BNegotiate.h"
#include "BBytes.h"
#include "BByteOrder.h"
#include <algorithm>
#include <string.h>

// If Windows.h is included, min is defined as a macro. 
// This causes a compiler error at min.
#undef min


namespace byps {

  BINLINE BNegotiate::BNegotiate(PApiDescriptor apiDesc) {
    version = 0;
    protocols = apiDesc->getProtocolIds();
    bversion = BHEADER_BYPS_VERSION_CURRENT;
  }

  BINLINE BNegotiate::BNegotiate() {
    version = 0;
    bversion = BHEADER_BYPS_VERSION_CURRENT;
  }

  BINLINE void BNegotiate::write(const PBytes& bytes) {
    stringstream ss;
    ss	<< NEGOTIATE_MAGIC_DOUBLE_QUOTES << ",\""
      << protocols << "\","
      << "\"" << BVersioning::longToString<char>(version) << "\",\""
      << ((BByteOrder::getMyEndian() == BLITTLE_ENDIAN) ? "L" : "B")
      << "\",\"\"";
    if (bversion) ss << "," << bversion;
    if (sessionId.size()) ss << "," << sessionId;
    ss << "]";

    string str = ss.str();
    size_t len = min(str.size(), bytes->length);
    memcpy(bytes->data, str.c_str(), len);
    bytes->length = len;
  }

  BINLINE void BNegotiate::read(const PBytes& bytes) {
    char* p = (char*)bytes->data;
    size_t idx = 0;

    // Magic ["N"

    size_t len = min((size_t)4, bytes->length);
    if (strncmp(p, NEGOTIATE_MAGIC_DOUBLE_QUOTES, len) != 0) throw BException(BExceptionC::CORRUPT);

    idx += len;
    if (idx >= bytes->length) throw BException(BExceptionC::CORRUPT);

    if (p[idx] != ',') throw BException(BExceptionC::CORRUPT);
    if (++idx >= bytes->length) throw BException(BExceptionC::CORRUPT);

    // Protokolle

    if (p[idx] != '\"') throw BException(BExceptionC::CORRUPT);
    if (++idx >= bytes->length) throw BException(BExceptionC::CORRUPT);

    for (; idx < bytes->length && p[idx] != '\"'; idx++) {
      protocols += p[idx];
    }

    if (++idx >= bytes->length) throw BException(BExceptionC::CORRUPT);
    if (p[idx] != ',') throw BException(BExceptionC::CORRUPT);
    if (++idx >= bytes->length) throw BException(BExceptionC::CORRUPT);

    // Version

    if (p[idx] != '\"') throw BException(BExceptionC::CORRUPT);
    if (++idx >= bytes->length) throw BException(BExceptionC::CORRUPT);

    std::stringstream ssversion;
    for (; idx < bytes->length && p[idx] != '\"'; idx++) {
      ssversion << p[idx];
    }
    version = BVersioning::stringToLong(ssversion.str());

    if (++idx >= bytes->length) throw BException(BExceptionC::CORRUPT);
    if (p[idx] != ',') throw BException(BExceptionC::CORRUPT);
    if (++idx >= bytes->length) throw BException(BExceptionC::CORRUPT);

    // Byteorder

    if (p[idx] != '\"') throw BException(BExceptionC::CORRUPT);
    if (++idx >= bytes->length) throw BException(BExceptionC::CORRUPT);

    byteOrder = p[idx] == 'B' ? BBIG_ENDIAN : BLITTLE_ENDIAN;

    if (++idx >= bytes->length) throw BException(BExceptionC::CORRUPT);
    if (p[idx] != '\"') throw BException(BExceptionC::CORRUPT);
    if (++idx >= bytes->length) throw BException(BExceptionC::CORRUPT);
    if (p[idx] != ',') throw BException(BExceptionC::CORRUPT);
    if (++idx >= bytes->length) throw BException(BExceptionC::CORRUPT);

    // Target-ID

    if (p[idx] != '\"') throw BException(BExceptionC::CORRUPT);
    if (++idx >= bytes->length) throw BException(BExceptionC::CORRUPT);

    size_t idxTargetIdBegin = idx;
    for (; idx < bytes->length && p[idx] != '\"'; idx++) {}

    targetId = BTargetId::parseString(std::string(p + idxTargetIdBegin, idx - idxTargetIdBegin));

    idx++; // skip \"

    // BYPS Version.
    // Due to a bug in versions before BYPS_VERSION_WITH_SESSIONID, 
    // this value is not correctly negotiated. If no sessionId is
    // found, the bversion is ignored and set to the version number
    // prior to BYPS_VERSION_WITH_SESSIONID.
    if (idx < bytes->length && p[idx] == ',') {
      idx++;
      stringstream ss;
      for (; idx < bytes->length; idx++) {
        char c = p[idx];
        if (c < '0' || c > '9') break;
        ss << c;
      }
      ss >> bversion;
    }

    if (idx < bytes->length && p[idx] == ',') {
      if (p[++idx] == '\"') {
        idx++;
        stringstream ss;
        for (; idx < bytes->length; idx++) {
          char c = p[idx];
          if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'))) break;
          ss << c;
        }
        sessionId = ss.str();
        idx++; // skip \"
      }
    }
    else if (bversion >= BHEADER_BYPS_VERSION_CURRENT) {
      bversion = BHEADER_BYPS_VERSION_CURRENT-1;
    }
  }

  BINLINE bool BNegotiate::isNegotiateMessage(PBytes bytes) {
    char* p = (char*)bytes->data;
    size_t len = min((size_t)4, bytes->length);
    if (len < 4) return false;
    return strncmp(p, NEGOTIATE_MAGIC_DOUBLE_QUOTES, len) == 0 ;
  }

}

#endif
