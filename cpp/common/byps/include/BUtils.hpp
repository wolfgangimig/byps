/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BUTILS_HPP_
#define BUTILS_HPP_

#include "BUtils.h"

namespace byps {

//BINLINE wstring BToStdWString(const string& str) {
//	return BToStdWString(str.c_str(), str.length());
//}
//
//BINLINE wstring BToStdWString(const char* str, size_t blen, bool isUtf8) {
//	if (str == NULL || blen == 0) return wstring();
//	if (blen == string::npos) blen = strlen(str);
//	
//  wstring wstr;
//  wstr.reserve(blen);
//
//  if (isUtf8) {
//    const int8_t* buf = (int8_t*)str;
//    const int8_t* p = buf;
//    const int8_t* pend = p + blen;
//
//    while (p < pend) {
//        wchar_t c = (wchar_t)(*p);
//        p++;
//        int16_t u4bits = (c & 0xF0);
//        if (u4bits == 0xC0) {
//            c &= 0x1F;
//            c <<= 6;
//            c |= (wchar_t)((*p++ & 0x3F));
//        }
//        else if (u4bits == 0xE0) {
//            c &= 0xF;
//            c <<= 6;
//            c |= (wchar_t)((*p++ & 0x3F));
//            c <<= 6;
//            c |= (wchar_t)((*p++ & 0x3F));
//        }
//
//        wstr += c;
//    }
//
//  }
//  else {
//    for (size_t i = 0; i < blen; i++) {
//      wstr += (wchar_t)str[i];
//    }
//  }
//
//	return wstr;
//}


BINLINE string toUtf8(const wstring& str) {
	stringstream ss;
    for (wstring::const_iterator it = str.begin(); it != str.end(); it++) {

		wchar_t c = (*it);

		if (c <= 0x7F) {
			ss << (char)c;
		}
		else if (c >= 0x80 && c <= 0x07FF) {
			ss << (char)(((c >> 6) & 0x1F) | 0xC0);
			ss << (char)((c & 0x3F) | 0x80);
		}
		else { // if (c >= 0x800 && c <= 0xFFFF) {
			ss << (char)(((c >> 12) & 0xF) | 0xE0);
			ss << (char)(((c >> 6) & 0x3F) | 0x80);
			ss << (char)((c & 0x3F) | 0x80);
		}
	}
	return ss.str();
}

BINLINE wstring fromUtf8(const string& str) {
	wstringstream ss;

	const char* p = str.c_str();
	const char* pend = p + str.size();

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

        ss << c;
    }

	return ss.str();
}


}


#endif /* BUTILS_H_ */
