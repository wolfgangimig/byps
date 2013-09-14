#ifndef BTargetId_H_
#define BTargetId_H_

#include "Byps.h"
#include <iomanip>

namespace com { namespace wilutions { namespace byps {

class BBuffer;

class BTargetId
{
    int64_t v1;
    int64_t v2;

public:
    BTargetId();

    BTargetId(int64_t v1, int64_t v2);

    bool isZero();

    void serialize(BBuffer& bbuf);

    bool operator == (const BTargetId& rhs) const;

	static BTargetId parseString(const char* sz, size_t len);

	std::wstring toString() const {
		std::wstringstream ss;
		ss << (*this);
		return ss.str();
	}

	template <typename _CHAR> 
	friend static std::basic_ostream<_CHAR>& operator << (std::basic_ostream<_CHAR>& os, const BTargetId& targetId) {
		os << (_CHAR)'[' << (_CHAR)'0' << (_CHAR)'x' << std::hex << std::setw(8) << targetId.v1 << targetId.v2 << (_CHAR)']';
		return os << std::dec << std::setw(0);
	}
};



}}}


#endif
