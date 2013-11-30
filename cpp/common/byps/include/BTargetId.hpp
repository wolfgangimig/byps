/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BTARGETID_HPP
#define BTARGETID_HPP

#include "BTargetId.h"
#include "BBuffer.h"

namespace byps {

BINLINE BTargetId::BTargetId() : serverId(0), v1(0), v2(0) {
}

BINLINE BTargetId::BTargetId(int32_t serverId, int64_t v1, int64_t v2) 
	: serverId(serverId), v1(v1), v2(v2) {
}

BINLINE bool BTargetId::isZero() {
    return serverId == 0 && v1 == 0 && v2 == 0;
}

BINLINE bool BTargetId::operator==(const BTargetId& rhs) const {
    return serverId == rhs.serverId && v1 == rhs.v1 && v2 == rhs.v2;
}

BINLINE std::wstring BTargetId::toString() const {
	std::wstringstream ss;
	ss << (*this);
	return ss.str();
}

BINLINE BTargetId BTargetId::parseString(const string& s) {
	int32_t serverId = 0;
	int64_t v1 = 0, v2 = 0;

	stringstream ss;
	for (string::const_iterator it = s.begin(); it != s.end(); it++) {
		ss << ((*it == '.') ? ' ' : *it);
	}

	ss >> serverId >> v1 >> v2;

	return BTargetId(serverId, v1, v2);
}

BINLINE void BTargetId::serialize(BBuffer& bbuf) {
	bool cmpr = bbuf.setCompressInteger(false);
	bbuf.serialize(serverId);
	bbuf.serialize(v1);
	bbuf.serialize(v2);
	bbuf.setCompressInteger(cmpr);
}



}

#endif // BTARGETID_HPP
