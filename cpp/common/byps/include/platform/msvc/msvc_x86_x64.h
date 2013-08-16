#ifndef BMSVC_X86_X64_H_
#define BMSVC_X86_X64_H_

///////////////////////////////////////////////////////////////////////////////
// Include C++11 symbols for shared pointer etc.

#ifdef _MSC_VER

#ifndef BSTD_SYMBOLS
#define BSTD_SYMBOLS

#include <memory>

#define byps_ptr std::shared_ptr
#define byps_weak_ptr std::weak_ptr
#define byps_ptr_cast std::dynamic_pointer_cast
#define byps_static_ptr_cast std::static_pointer_cast
#define byps_enable_shared_from_this std::enable_shared_from_this

#include <mutex>
#define byps_mutex std::mutex
#define byps_unique_lock std::unique_lock<std::mutex>

#include <condition_variable>
#define byps_condition_variable std::condition_variable

#include <atomic>
#define byps_atomic std::atomic

#define CPP11_LAMBDA

#define BFSTREAM_WCHAR

#include "msvc_x86_x64.h"

#ifdef _DEBUG
#define BDEBUG
#endif

#include <ctime>

namespace com { namespace wilutions { namespace byps {
inline struct tm* byps_localtime(struct tm* buf, const std::time_t* t) {
    localtime_s(buf, t);
    return buf;
}
}}}

#endif // BSTD_SYMBOLS


///////////////////////////////////////////////////////////////////////////////
// Define bitswap functions.

#ifndef BSWAP_FUNCTIONS
#define BSWAP_FUNCTIONS

#include <stdint.h>
#include <stdlib.h> 

namespace com { namespace wilutions { namespace byps {

inline int16_t BSWAP2(register int16_t v) {
	return _byteswap_ushort((uint16_t)v);
}

inline int32_t BSWAP4(register int32_t v) {
	return _byteswap_ulong((uint32_t)v);
}

inline int64_t BSWAP8(register int64_t v) {
	return _byteswap_uint64((uint64_t)v);
}

//inline int16_t BSWAP2(register int16_t v) {
//	__asm 
//	{
//		mov ax, v;
//		xchg ah, al;
//		mov v, ax;
//	}
//	return v;
//}
//
//inline int32_t BSWAP4(register int32_t v) {
//	__asm 
//	{
//		mov eax, v;
//		bswap eax;
//		mov v, eax;
//	}
//	return v;
//}
//
//#if _M_X64
//
//inline int64_t BSWAP8(register int64_t v) {
//	__asm 
//	{
//		mov rax, v;
//		bswap rax;
//		mov v, rax;
//	}
//	return v;}
//
//#else

}}}

#endif  /* BSWAP_FUNCTIONS */


///////////////////////////////////////////////////////////////////////////////
// Define functions to serialize integers to unaligned memory adresses.


#if (defined (_M_IX86) || defined (_M_X64)) && !defined(_M_IA64) 

#ifndef BSERIALIZE_UNALIGNED_FUNCTIONS
#define BSERIALIZE_UNALIGNED_FUNCTIONS

namespace com { namespace wilutions { namespace byps {

template<typename _int163264> void writeUnalignedInt163264(void* p, _int163264& v) {
	*((_int163264*)p) = v;
}
template<typename _int163264> void readUnalignedInt163264(void* p, _int163264& v) {
	v = *((_int163264*)p);
}


}}}


#endif  // BSERIALIZE_UNALIGNED_FUNCTIONS

#endif // _M_IX86...

#endif // _MSC_VER

#endif /* MSVC_X86_X64_H_ */
