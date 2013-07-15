/*
 * x86.h
 *
 *  Created on: 23.07.2012
 *      Author: Wolfgang
 */

#ifndef BGCC_X86_H_
#define BGCC_X86_H_

#if ((defined(__i386__) || defined(__x86_64__))) && __GNUC__

#include "../Byps.h"


namespace com { namespace wilutions { namespace byps {

#ifndef BSWAP_FUNCTIONS
#define BSWAP_FUNCTIONS

inline int16_t BSWAP2(register int16_t v) {
	__asm__ ("xchg %%ah,%%al; "	: "=a"(v) : "0"(v) );
	return v;
}

inline int32_t BSWAP4(register int32_t v) {
	__asm__ ("bswapl %0" : "=r"(v) : "0"(v)	);
	return v;
}

#if __x86_64__

inline int64_t BSWAP8(register int64_t v) {
	__asm__ ("bswapq %0" : "=r"(v) : "0"(v)	);
	return v;
}

#else

inline int64_t BSWAP8(register int64_t v) {
	register int32_t v1 = (int32_t)(v >> 32);
	register int32_t v2 = (int32_t)(v & 0xFFFFFFFF);
	v = ((int64_t)BSWAP4(v1)) | ((int64_t)(BSWAP4(v2)) << 32);
	return v;
}

#endif

#endif

}}}

#endif  /* ((defined(__i386__) || defined(__x86_64__))) && __GNUC__ */

#endif /* X86_H_ */
