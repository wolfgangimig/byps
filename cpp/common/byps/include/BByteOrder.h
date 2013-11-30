/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BBYTEORDER_H_
#define BBYTEORDER_H_

#include "BException.h"

#include "platform/platform-api.h"

namespace byps {

enum BEndian {
	BLITTLE_ENDIAN, BBIG_ENDIAN
};

class BByteOrder {

public:

    BByteOrder()
        : endian(getMyEndian())
        , myEndian(getMyEndian()){
	}

    BByteOrder(BEndian endian)
        : endian(endian)
        , myEndian(getMyEndian()){
	}

    BByteOrder(const BByteOrder& rhs)
        : endian(rhs.endian)
        , myEndian(getMyEndian()){
	}

	BByteOrder& operator=(BEndian n) {
        endian = n;
		return *this;
	}

    bool operator==(const BByteOrder& rhs) const {
        return endian == rhs.endian;
	}

    bool needSwap() {
        return endian != myEndian;
	}

    int8_t swapIf(register int8_t v) {
		return v;
	}
    int16_t swapIf(register int16_t v) {
        return needSwap() ? BSWAP2(v) : v;
	}
    int32_t swapIf(register int32_t v) {
        return needSwap() ? BSWAP4(v) : v;
	}

    int64_t swapIf(register int64_t v) {
        return needSwap() ? BSWAP8(v) : v;
	}

    static BEndian getMyEndian() {
#ifdef __ORDER_LITTLE_ENDIAN__
		return BLITTLE_ENDIAN;
#elif __ORDER_BIG_ENDIAN__
		return BIG_ENDIAN;
#else
		int16_t v = 1;
		char* p = (char*)(&v);
		return (*p == 0) ? BBIG_ENDIAN : BLITTLE_ENDIAN;
#endif
	}

private:

    BEndian endian;
    BEndian myEndian;
};

}

#endif /* BBYTEORDER_H_ */
