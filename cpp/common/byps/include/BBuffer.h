#ifndef BBUFFER_H_
#define BBUFFER_H_

#include "Byps.h"
#include "BException.h"
#include "BByteOrder.h"
#include "BApiDescriptor.h"
#include "BBytes.h"
#include "BAsyncResult.h"
#include <string>
#include <vector>

namespace com {
namespace wilutions {
namespace byps {

// wird als Version von BInputC und BOutputC verwendet
const int32_t BDISABLE_VERSION_CHECK = 0x7FFFFFFF;

class BBuffer {
public:

    BBuffer(const BBinaryModel& bmodel, BByteOrder byteOrder);
    BBuffer(const BBinaryModel& bmodel, PBytes& pBytes, BByteOrder byteOrder);

    const PBytes& getBytes() const;

	void clear();

    BByteOrder getByteOrder() const;

    void setByteOrder(BByteOrder byteOrder);

	void serialize(PBytes& v);

	void serialize(int8_t& v);
	void serialize(int16_t& v);
	void serialize(int32_t& v);
	void serialize(int64_t& v);
	void serialize(bool& b);
	void serialize(wchar_t& c);
    void serialize (float& v);
    void serialize (double& v);

    void serializePointer(BPOINTER& p);

    void serializeTypeId(BTYPEID& p);

    void serializeLength(BLENGTH& p);

    void serialize(std::wstring& str);

    void serialize(std::string& str);

    bool isEmpty();

	virtual ~BBuffer();

private:

	void ensureRemaining(int32_t size) {
		if (pos + size > capacity) {
			growForRemaining(size);
		}
	}

    void growForRemaining(int32_t size);

	template<typename _int163264> void serializeIntegerUnaligned(_int163264& v) {
		
		ensureRemaining(sizeof(v));
		
		{
			int8_t* p = pBytes->data + pos;
			if (isWrite) {
				_int163264 v1 = byteOrder.swapIf(v);
				writeUnalignedInt163264(p, v1);
			}
			else {
				_int163264 v1 = _int163264();
				readUnalignedInt163264(p, v1);
				v = byteOrder.swapIf(v1);
			}

			pos += sizeof(_int163264);
		}
	}

    BBinaryModel bmodel;
    bool isWrite;
    BByteOrder byteOrder;
    PBytes pBytes;
    int32_t pos, limit, capacity;
    int32_t grow;
};

} /* namespace byps */
} /* namespace wilutions */
} /* namespace com */
#endif /* BMEM_H_ */
