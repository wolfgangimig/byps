#ifndef BTARGETID_HPP
#define BTARGETID_HPP

#include "BTargetId.h"
#include "BBuffer.h"

namespace com { namespace wilutions { namespace byps {

BINLINE BTargetId::BTargetId() : v1(0), v2(0) {
}

BINLINE BTargetId::BTargetId(int64_t v1, int64_t v2) : v1(v1), v2(v2) {
}

BINLINE bool BTargetId::isZero() {
    return v1 == 0 && v2 == 0;
}

BINLINE bool BTargetId::operator==(const BTargetId& rhs) const {
    return v1 == rhs.v1 && v2 == rhs.v2;
}

BINLINE BTargetId BTargetId::parseString(const char* sz, size_t len) {
	if (!sz || len < 32) return BTargetId();

	stringstream ss;
	ss << string(sz, 16);
	ss << " ";
	ss << string(sz+16, len-16);

	uint64_t v0 = 0, v1 = 0;
	ss >> hex >> v0 >> hex >> v1;

	return BTargetId((int64_t)v0, (int64_t)v1);
}

void BTargetId::serialize(BBuffer& bbuf) {
	bbuf.serialize(v1);
	bbuf.serialize(v2);
}



}}}

#endif // BTARGETID_HPP
