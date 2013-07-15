/*
 * x86.h
 *
 *  Created on: 23.07.2012
 *      Author: Wolfgang
 */

#ifndef BMSVC_X86_X64_H_
#define BMSVC_X86_X64_H_

#ifdef _MSC_VER

#include "../Byps.h"

namespace com { namespace wilutions { namespace byps {


#ifndef BSWAP_FUNCTIONS
#define BSWAP_FUNCTIONS

#include <stdlib.h> 

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


#endif  /* BSWAP_FUNCTIONS */

#if (defined (_M_IX86) || defined (_M_X64)) && !defined(_M_IA64) 

#ifndef BSERIALIZE_UNALIGNED_FUNCTIONS
#define BSERIALIZE_UNALIGNED_FUNCTIONS


template<typename _int163264> void writeUnalignedInt163264(void* p, _int163264& v) {
	*((_int163264*)p) = v;
}
template<typename _int163264> void readUnalignedInt163264(void* p, _int163264& v) {
	v = *((_int163264*)p);
}

#endif

#endif // _M_IX86


}}}

#endif // _MSC_VER

#endif /* MSVC_X86_X64_H_ */
