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
}

BINLINE BNegotiate::BNegotiate() {
    version = 0;
}

BINLINE void BNegotiate::write(const PBytes& bytes) {
	stringstream ss;
    ss	<< NEGOTIATE_MAGIC_DOUBLE_QUOTES << ",\""
		<< protocols << "\","
        << "\"" << BVersioning::longToString<char>(version) << "\",\""
        << ((BByteOrder::getMyEndian() == BLITTLE_ENDIAN) ? "L" : "B")
		<< "\", \"\"]";

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
    if (strncmp(p, NEGOTIATE_MAGIC_DOUBLE_QUOTES, len) != 0) throw BException(EX_CORRUPT);

	idx += len;
	if (idx >= bytes->length) throw BException(EX_CORRUPT);

	if (p[idx] != ',') throw BException(EX_CORRUPT);
	if (++idx >= bytes->length) throw BException(EX_CORRUPT);

	// Protokolle

	if (p[idx] != '\"') throw BException(EX_CORRUPT);
	if (++idx >= bytes->length) throw BException(EX_CORRUPT);

	for (; idx < bytes->length && p[idx] != '\"'; idx++) {
        protocols += p[idx];
	}

	if (++idx >= bytes->length) throw BException(EX_CORRUPT);
	if (p[idx] != ',') throw BException(EX_CORRUPT);
	if (++idx >= bytes->length) throw BException(EX_CORRUPT);

	// Version

	if (p[idx] != '\"') throw BException(EX_CORRUPT);
	if (++idx >= bytes->length) throw BException(EX_CORRUPT);

	std::stringstream ssversion;
	for (; idx < bytes->length && p[idx] != '\"'; idx++) {
        ssversion << p[idx];
	}
	version = BVersioning::stringToLong(ssversion.str());

	if (++idx >= bytes->length) throw BException(EX_CORRUPT);
	if (p[idx] != ',') throw BException(EX_CORRUPT);
	if (++idx >= bytes->length) throw BException(EX_CORRUPT);

	// Byteorder

	if (p[idx] != '\"') throw BException(EX_CORRUPT);
	if (++idx >= bytes->length) throw BException(EX_CORRUPT);

	byteOrder = p[idx] == 'B' ? BBIG_ENDIAN : BLITTLE_ENDIAN;

	if (++idx >= bytes->length) throw BException(EX_CORRUPT);
	if (p[idx] != '\"') throw BException(EX_CORRUPT);
	if (++idx >= bytes->length) throw BException(EX_CORRUPT);
	if (p[idx] != ',') throw BException(EX_CORRUPT);
	if (++idx >= bytes->length) throw BException(EX_CORRUPT);

	// Target-ID

	if (p[idx] != '\"') throw BException(EX_CORRUPT);
	if (++idx >= bytes->length) throw BException(EX_CORRUPT);

	size_t idxTargetIdBegin = idx;
	for (; idx < bytes->length && p[idx] != '\"'; idx++) {}

	targetId = BTargetId::parseString(std::string(p + idxTargetIdBegin, idx - idxTargetIdBegin));

}

BINLINE bool BNegotiate::isNegotiateMessage(PBytes bytes) {
	char* p = (char*)bytes->data;
	size_t len = min((size_t)4, bytes->length);
    if (len < 4) return false;
    return strncmp(p, NEGOTIATE_MAGIC_DOUBLE_QUOTES, len) == 0 ;
}

}

#endif
