/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BANY_H_
#define BANY_H__

///////////////////////////////////////////////////////////////////////////////
// Include shared pointer etc. from BOOST library

#ifndef BSTD_SYMBOLS
#define BSTD_SYMBOLS

#if __GNUC__
#pragma GCC diagnostic push
#pragma GCC diagnostic ignored "-Wpointer-arith"
#endif

#include <boost/shared_ptr.hpp>

#if __GNUC__
#pragma GCC diagnostic pop
#endif

#define byps_ptr boost::shared_ptr
#define byps_weak_ptr boost::weak_ptr
#define byps_ptr_cast boost::dynamic_pointer_cast
#define byps_static_ptr_cast boost::static_pointer_cast
#define byps_enable_shared_from_this boost::enable_shared_from_this

#pragma GCC diagnostic push
#pragma GCC diagnostic ignored "-Wmissing-field-initializers"
#include <boost/thread/shared_mutex.hpp>
#define byps_mutex boost::shared_mutex
#pragma GCC diagnostic pop

#endif // BSTD_SYMBOLS

///////////////////////////////////////////////////////////////////////////////
// Define bitswap functions.

#ifndef BSWAP_FUNCTIONS
#define BSWAP_FUNCTIONS

namespace byps {

inline int16_t BSWAP2(register int16_t v) {
	return ((v & 0xFF) << 8) | ((v >> 8) & 0xFF);
}

inline int32_t BSWAP4(register int32_t v) {
	return ((v & 0xFF) << 24) |
			((v & 0xFF00) << 8) |
			((v & 0xFF0000) >> 8) |
			((v & 0xFF000000) >> 24);
}

inline int64_t BSWAP8(register int64_t v) {
	return ((v & 0xFF) << 56) |
			((v & 0xFF00) << 40) |
			((v & 0xFF0000) << 24) |
			((v & 0xFF000000) << 8) |
			((v & 0xFF00000000LL) >> 8) |
			((v & 0xFF0000000000LL) >> 24) |
			((v & 0xFF000000000000LL) >> 40) |
			((v & 0xFF00000000000000LL) >> 56);
}

}

#endif // BSWAP_FUNCTIONS

///////////////////////////////////////////////////////////////////////////////
// Define functions to serialize floating point types in IEEE format.

#ifndef BFLOAT_IEEE_FUNCTIONS
#define BFLOAT_IEEE_FUNCTIONS

namespace byps {

union float_int32_t {
	float f;
	int32_t i;
};

inline int32_t floatToIEEE(float v) {
	float_int32_t fi;
	fi.f = v;
	return fi.i;
}

inline float floatFromIEEE(int32_t v) {
	float_int32_t fi;
	fi.i = v;
	return fi.f;
}

union double_int64_t {
	double f;
	int64_t i;
};

inline int64_t doubleToIEEE(double v) {
	double_int64_t fi;
	fi.f = v;
	return fi.i;
}

inline double doubleFromIEEE(int64_t v) {
	double_int64_t fi;
	fi.i = v;
	return fi.f;
}

}

#endif /* BFLOAT_IEEE_FUNCTIONS */

///////////////////////////////////////////////////////////////////////////////
// Define functions to serialize integers to unaligned memory adresses.

#ifndef BSERIALIZE_UNALIGNED_FUNCTIONS
#define BSERIALIZE_UNALIGNED_FUNCTIONS

namespace byps {

template<typename _int163264> void writeUnalignedInt163264(void* p, _int163264& v) {
	memcpy(p, &v, sizeof(_int163264));
}
template<typename _int163264> void readUnalignedInt163264(void* p, _int163264& v) {
	memcpy(&v, p, sizeof(_int163264));
}

}

#endif // BSERIALIZE_UNALIGNED_FUNCTIONS

#ifndef BFILE_SPLIT_PATH
#define BFILE_SPLIT_PATH

namespace byps {

  template<typename _ch> void splitpath(const std::basic_string<_ch>& path, std::basic_string<_ch>& dir, std::basic_string<_ch>& name) {
    int p = (int)path.size() - 1;
    for (std::basic_string<_ch>::const_reverse_iterator it = path.rbegin(); it != path.rend(); it++, p--) {
      if (*it == '\\' || *it == '/') break;
    }
    p++;
    dir = path.substr(0, p);
    name = path.substr(p);
  }

}

#endif // BFILE_SPLIT_PATH

#ifndef BFILE_CONTENT_TYPE
#define BFILE_CONTENT_TYPE

namespace byps {

   inline std::wstring getFileContentType(const std::wstring& fname) {
     std::wstring contentType;
     
     std::wstring ext;
     size_t p = fname.find_last_of(L'.');
     if (p != std::wstring::npos) {
       ext = fname.substr(p+1);
       // tolower
       {
         std::wstringstream ss; 
         for (unsigned i = 0; i < ext.size(); i++) {
           wchar_t c = ext[i];
           if (c >= L'A' && c <= L'Z') {
             c = (c - L'A') + L'a';
           }
           ss << c;
         }
         ext = ss.str();
       }
     }
     else {
       ext = fname;
     }

     if (ext == L"txt") {
       contentType = L"text/plain";
     }
     else if (ext == L"jpg" || ext == L"jpeg") {
       contentType = L"image/jpeg";
     }
     //else if (...) {
     //  contentType = ...
     //}
     else {
       contentType = L"application/octet-stream";
     }

     return contentType;
   }
}

#endif // BFILE_CONTENT_TYPE

#endif // BANY_H__
