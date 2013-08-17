#ifndef BBUFFER_HPP_
#define BBUFFER_HPP_

#include "BBuffer.h"

namespace com {
namespace wilutions {
namespace byps {

using namespace ::std;

BINLINE BBuffer::BBuffer(const BBinaryModel& bmodel, BByteOrder byteOrder) :
    bmodel(bmodel),
    isWrite(true), byteOrder(byteOrder),
    pos(0), limit(0), capacity(0), grow(10000) {
}

BINLINE BBuffer::BBuffer(const BBinaryModel& bmodel, PBytes& pBytes, BByteOrder byteOrder) :
    bmodel(bmodel),
    isWrite(false), byteOrder(byteOrder),
    pBytes(pBytes), pos(0), limit((int32_t)pBytes->length), capacity((int32_t)pBytes->length), grow(0) {
}

BINLINE const PBytes& BBuffer::getBytes() const {
    pBytes->length = (size_t)pos;
    return pBytes;
}

BINLINE void BBuffer::clear() {
	pos = 0;
	limit = 0;
}

BINLINE BByteOrder BBuffer::getByteOrder() const {
    return byteOrder;
}

BINLINE void BBuffer::setByteOrder(BByteOrder byteOrder) {
    this->byteOrder = byteOrder;
}

BINLINE void BBuffer::serialize(PBytes& v) {
	BLENGTH n = (BLENGTH)(isWrite ? v->length : 0);
	
	ensureRemaining(n + sizeof(BLENGTH));

	serializeLength(n);

	{
        int8_t* buf = pBytes->data;
        if (isWrite) {
			memcpy(buf + pos, v->data, n);
        }
        else {
			v = BBytes::create(n);
			memcpy(v->data, buf + pos, n);
        }
        pos += n;
	}
}

BINLINE void BBuffer::serialize(int8_t& v) {
	ensureRemaining(1);

	{
		if (isWrite) {
			pBytes->data[pos] = v;
		}
		else {
			v = pBytes->data[pos];
		}
		pos++;
	}
}

BINLINE void BBuffer::serialize(int16_t& v) {
	serializeIntegerUnaligned(v);
}

BINLINE void BBuffer::serialize(int32_t& v) {
	serializeIntegerUnaligned(v);
}

BINLINE void BBuffer::serialize(int64_t& v) {
	serializeIntegerUnaligned(v);
}

BINLINE void BBuffer::serialize(bool& b) {
	if (isWrite) {
		int8_t v = b ? 1 : 0;
		serialize(v);
	}
	else {
		int8_t v = 0;
		serialize(v);
		b = v != 0;
	}
}

BINLINE void BBuffer::serialize(wchar_t& c) {
	if (isWrite) {
		int16_t v = (int16_t)c;
		serialize(v);
	}
	else {
		int16_t v = 0;
		serialize(v);
		c = (int16_t)v;
	}
}

BINLINE void BBuffer::serialize (float& v) {
    if (isWrite) {
		int32_t IEEE = floatToIEEE(v);
        serialize(IEEE);
	}
	else {
		int32_t IEEE = 0;
        serialize(IEEE);
		v = floatFromIEEE(IEEE);
	}
}

BINLINE void BBuffer::serialize (double& v) {
    if (isWrite) {
		int64_t IEEE = doubleToIEEE(v);
        serialize(IEEE);
	}
	else {
		int64_t IEEE = 0;
        serialize(IEEE);
		v = doubleFromIEEE(IEEE);
	}
}

BINLINE void BBuffer::serializePointer(BPOINTER& p) {
    int32_t v = p;
	serialize(v);
	if (!isWrite) p = v;
}

BINLINE void BBuffer::serializeTypeId(BTYPEID& p) {
    int32_t v = p;
	serialize(v);
	if (!isWrite) p = v;
}

BINLINE void BBuffer::serializeLength(BLENGTH& p) {
    int32_t v = p;
	serialize(v);
	if (!isWrite) p = v;
}

BINLINE void BBuffer::serialize(wstring& str) {
    if (isWrite) {

        int32_t n = 0;
        serialize(n);
		int32_t lengthPos = pos - 4;

		if (str.size() != 0) {
			
			int32_t blen = (int32_t) (3 * (str.size()) + 1);
			ensureRemaining(blen);

			int8_t* buf = pBytes->data;
			int8_t* p = buf + pos;

            for (wstring::iterator it = str.begin(); it != str.end(); it++) {

				wchar_t c = (*it);

				if (c <= 0x7F) {
					*p++ = (int8_t)c;
				}
				else if (c >= 0x80 && c <= 0x07FF) {
					*p++ = (int8_t)(((c >> 6) & 0x1F) | 0xC0);
					*p++ = (int8_t)((c & 0x3F) | 0x80);
				}
				else { // if (c >= 0x800 && c <= 0xFFFF) {
					*p++ = (int8_t)(((c >> 12) & 0xF) | 0xE0);
					*p++ = (int8_t)(((c >> 6) & 0x3F) | 0x80);
					*p++ = (int8_t)((c & 0x3F) | 0x80);
				}
			}

			// correct length
			n = (int32_t)(p - buf) - pos;
			pos = lengthPos;
			serialize(n);

	       *p++ = 0;
			pos = (int32_t)(p - buf);
		}
		else {
			pBytes->data[pos++] = 0;
		}

    }
    else {
        int32_t blen = 0;
        serialize(blen);

        str.reserve((size_t)blen);

        int8_t* buf = pBytes->data;
        int8_t* p = buf + pos;
		int8_t* pend = p + blen;

        while (p < pend) {
            wchar_t c = (wchar_t)(*p);
            p++;
            int16_t u4bits = (c & 0xF0);
            if (u4bits == 0xC0) {
                c &= 0x1F;
                c <<= 6;
                c |= (wchar_t)((*p++ & 0x3F));
            }
            else if (u4bits == 0xE0) {
                c &= 0xF;
                c <<= 6;
                c |= (wchar_t)((*p++ & 0x3F));
                c <<= 6;
                c |= (wchar_t)((*p++ & 0x3F));
            }

            str += c;
        }

        char _0 = *p++;
        if (_0 != 0) throw new BException(EX_CORRUPT);

        pos = (int32_t)(p - buf);
    }

}

BINLINE void BBuffer::serialize(string& str) {
    if (isWrite) {
        int32_t n = (int32_t)str.size();
        serialize(n);

        int32_t blen = n+1;
        ensureRemaining(blen);

        int8_t* buf = pBytes->data;
        int8_t* p = buf + pos;
        memcpy(p, str.c_str(), blen);

        pos += blen;

    }
    else {
        int32_t n = 0;
        serialize(n);

        int8_t* buf = pBytes->data;
        int8_t* p = buf + pos;
        str = string((char*)p, (size_t)n);

        char _0 = *(p + n);
        if (_0 != 0) throw new BException(EX_CORRUPT);

        pos += n + 1;
    }
}

BINLINE bool BBuffer::isEmpty() {
    return pos == 0;
}

BINLINE BBuffer::~BBuffer() {
}

BINLINE void BBuffer::growForRemaining(int32_t size) {
	const int32_t requiredCapacity = pos + size;
    if (isWrite) {
        int32_t growNow = requiredCapacity - capacity;
        growNow = ((growNow / grow) + 1) * grow;
        int32_t newCap = capacity + growNow;
        pBytes = BBytes::create(pBytes, newCap);
		if (!pBytes) throw BException(EX_INTERNAL, L"Out of memory");
        capacity = newCap;
        limit = capacity;
	}
	else {
		throw BException(EX_CORRUPT);
	}
}


} /* namespace byps */
} /* namespace wilutions */
} /* namespace com */
#endif 
