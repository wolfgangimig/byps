/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BMSVC_X86_X64_H_
#define BMSVC_X86_X64_H_

///////////////////////////////////////////////////////////////////////////////
// Include C++11 symbols for shared pointer etc.

#ifdef _MSC_VER

// Assignment operators cannot be generated due to const members in some classes.
#pragma warning (disable : 4512) 

// Two or more members have the same name. 
// "... inherits 'byps::BStub::byps::BStub::BRemote_getTargetId' via dominance"
// This warning is printed for BRemote_getTargetId.
#pragma warning( disable : 4250 ) 

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

#ifdef _DEBUG
#define BDEBUG
#endif

#define _CRTDBG_MAP_ALLOC
#include <stdlib.h>
#include <crtdbg.h>

#include <ctime>

namespace byps {


  inline bool byps_localtime(struct tm* buf, const std::time_t* t) {
    return localtime_s(buf, t) == 0;
  }

  inline bool byps_gmtime(struct tm* buf, const std::time_t* t) {
    return gmtime_s(buf, t) == 0;
  }


}

#endif // BSTD_SYMBOLS


///////////////////////////////////////////////////////////////////////////////
// Define bitswap functions.

#ifndef BSWAP_FUNCTIONS
#define BSWAP_FUNCTIONS

#include <stdint.h>
#include <stdlib.h> 

namespace byps {

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

}

#endif  /* BSWAP_FUNCTIONS */


///////////////////////////////////////////////////////////////////////////////
// Define functions to serialize integers to unaligned memory adresses.


#if (defined (_M_IX86) || defined (_M_X64)) && !defined(_M_IA64) 

#ifndef BSERIALIZE_UNALIGNED_FUNCTIONS
#define BSERIALIZE_UNALIGNED_FUNCTIONS

namespace byps {

  template<typename _int163264> void writeUnalignedInt163264(void* p, _int163264& v) {
    *((_int163264*)p) = v;
  }
  template<typename _int163264> void readUnalignedInt163264(void* p, _int163264& v) {
    v = *((_int163264*)p);
  }


}


#endif  // BSERIALIZE_UNALIGNED_FUNCTIONS

#ifndef BFILE_CONTENT_TYPE
#define BFILE_CONTENT_TYPE

#include <windows.h>

namespace byps {

  inline std::wstring getFileContentType(const std::wstring& fname) {
    std::wstring contentType;

    std::wstring ext;
    size_t p = fname.find_last_of(L'.');
    if (p != std::wstring::npos) {
      ext = fname.substr(p);
    }
    else {
      ext = fname;
    }

    HKEY hkey = NULL;
    if (::RegOpenKeyEx(HKEY_CLASSES_ROOT, ext.c_str(), 0, KEY_READ, &hkey) == ERROR_SUCCESS) {
      WCHAR buf[100] = {0};
      DWORD len = sizeof(buf)-2;
      DWORD err = ::RegQueryValueEx(hkey, L"Content Type", NULL, NULL, (LPBYTE)buf, &len);
      if (err == ERROR_SUCCESS) {
        contentType = std::wstring(buf);
      }
      ::RegCloseKey(hkey);
    }

    if (contentType.size() == 0) {
      contentType = L"application/octet-stream";
    }

    return contentType;
  }
}

#endif // BFILE_CONTENT_TYPE

#endif // _M_IX86...

#endif // _MSC_VER

////////////////////////////////////////////////////////////////////////
// Undefine constants defined by Windows

#undef REGISTERED
#undef ERROR
#undef RGB

#endif /* MSVC_X86_X64_H_ */
