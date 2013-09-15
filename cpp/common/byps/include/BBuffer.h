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

	bool isCompressInteger() const;
	bool setCompressInteger(bool v);

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

    void serialize(wstring& str);

    void serialize(string& str);

    bool isEmpty();

	virtual ~BBuffer();

private:

	void ensureRemaining(int32_t size) {
		if (isWrite && pBytes) {
			pBytes->check();
		}

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

	template<typename _int3264> void serializeIntegerCompressed(_int3264& v1) {

		register _int3264 v = v1;

		if (isWrite) {

			if (v == 0) {
				ensureRemaining(1);
				pBytes->data[pos++] = 0;
			}
			else {
				ensureRemaining(sizeof(v) + 1);
				int8_t *p = pBytes->data + pos;

				bool neg = v < 0;
				if (neg) v = -v;

				int i = 0;
				for (; i < sizeof(v) && v != 0; i++) {
					p[i+1] = (int8_t) (v & 0xFF);
					v >>= 8;
				}

				p[0] = (int8_t) (neg ? -i : i);
				pos += i+1;
			}
		}

		else {
				
			int8_t *p = pBytes->data + pos;
				
			v = 0;
			int i = *p;

			if (i == 0) {
				ensureRemaining(1);
				pos++;
			}
			else {
				bool neg = i < 0;
				if (neg) i = -i;

				ensureRemaining(i+1);
				pos += i+1;
				p++;

				while (i-- > 0) {
					v <<= 8;
					v |= ((int)(p[i])) & 0xFF;
				}
    
				if (neg) v = -v;

				v1 = v;
			}
		}
	}

	int32_t getStringLengthUtf8(const ::std::wstring& str);

    BBinaryModel bmodel;
    bool isWrite;
    BByteOrder byteOrder;
    PBytes pBytes;
    int32_t pos, limit, capacity;
    int32_t grow;
	bool compressInteger;
};

} /* namespace byps */
} /* namespace wilutions */
} /* namespace com */
#endif /* BMEM_H_ */
