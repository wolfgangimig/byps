/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BUTILS_HPP_
#define BUTILS_HPP_

#include "BUtils.h"

namespace byps {

BINLINE wstring BToStdWString(const string& str) {
	return BToStdWString(str.c_str(), str.length());
}

BINLINE wstring BToStdWString(const char* str, size_t len) {
	if (str == NULL || len == 0) return wstring();
	if (len == string::npos) len = strlen(str);
	wstringstream ss;
	for (size_t i = 0; i < len; i++) {
		ss << (wchar_t)str[i];
	}
	return ss.str();
}

}


#endif /* BUTILS_H_ */
