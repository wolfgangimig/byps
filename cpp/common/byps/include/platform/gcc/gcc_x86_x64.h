#ifndef BGCC_X86_H_
#define BGCC_X86_H_

#if ((defined(__i386__) || defined(__x86_64__))) && __GNUC__

///////////////////////////////////////////////////////////////////////////////
// Include C++11 symbols for shared pointer etc.

#ifndef BSTD_SYMBOLS
#define BSTD_SYMBOLS

#include <memory>

#define byps_ptr ::std::shared_ptr
#define byps_weak_ptr ::std::weak_ptr
#define byps_ptr_cast ::std::dynamic_pointer_cast
#define byps_static_ptr_cast ::std::static_pointer_cast
#define byps_enable_shared_from_this ::std::enable_shared_from_this

#include <mutex>
#define byps_mutex ::std::mutex
#define byps_unique_lock ::std::unique_lock< byps_mutex>

#include <condition_variable>
#define byps_condition_variable ::std::condition_variable

#include <atomic>
#define byps_atomic ::std::atomic

#include <ctime>
#include <string.h>

inline struct tm* byps_localtime(struct tm* buf, const ::std::time_t* t) {
    memcpy(buf, localtime(t), sizeof(struct tm));
    return buf;
}

#define CPP11_LAMBDA

#endif // BSTD_SYMBOLS


///////////////////////////////////////////////////////////////////////////////
// Define bitswap functions.

#ifndef BSWAP_FUNCTIONS
#define BSWAP_FUNCTIONS

#include <stdint.h>

namespace byps {

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

#endif // __x86_64__

}

#endif // BSWAP_FUNCTIONS

#endif  /* ((defined(__i386__) || defined(__x86_64__))) && __GNUC__ */

#endif /* BGCC_X86_H_ */
