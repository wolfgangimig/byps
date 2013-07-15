#ifndef BNEGOTIATE_HPP_
#define BNEGOTIATE_HPP_

#include "BNegotiate.h"
#include "BBytes.h"
#include "BByteOrder.h"
#include <algorithm>
#include <string.h>

// If Windows.h is included, min is defined as a macro. 
// This causes a compiler error at std::min.
#undef min


namespace com { namespace wilutions { namespace byps {

BINLINE BNegotiate::BNegotiate() {
    version = 0;
}

BINLINE void BNegotiate::write(const PBytes& bytes) {
	std::stringstream ss;
    ss	<< NEGOTIATE_MAGIC_DOUBLE_QUOTES << ",\""
		<< NEGOTIATE_BINARY_STREAM << "\","
        << version << ",\""
        << ((BByteOrder::getMyEndian() == BLITTLE_ENDIAN) ? "L" : "B")
		<< "\", \"\"]";

	std::string str = ss.str();
	size_t len = std::min(str.size(), bytes->length);
	memcpy(bytes->data, str.c_str(), len);
	bytes->length = len;
}

BINLINE void BNegotiate::read(const PBytes& bytes) {
	char* p = (char*)bytes->data;
	size_t idx = 0;

	// Magic ["N"

	size_t len = std::min((size_t)4, bytes->length);
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

	size_t idxVersionBegin = idx;
	for (; idx < bytes->length && p[idx] != ','; idx++) {}
	
	p[idx] = 0;
	version = atoi(p + idxVersionBegin);
		
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

	targetId = BTargetId::parseString(p + idxTargetIdBegin, idx - idxTargetIdBegin);

}

BINLINE bool BNegotiate::isNegotiateMessage(PBytes bytes) {
	char* p = (char*)bytes->data;
	size_t len = std::min((size_t)4, bytes->length);
    return strncmp(p, NEGOTIATE_MAGIC_DOUBLE_QUOTES, len) == 0 ;
}

}}}

#endif
