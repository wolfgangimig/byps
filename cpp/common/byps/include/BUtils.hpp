#ifndef BUTILS_HPP_
#define BUTILS_HPP_

#include "BUtils.h"

namespace com { namespace wilutions { namespace byps {

BINLINE std::wstring BToStdWString(const std::string& str) {
	return BToStdWString(str.c_str(), str.length());
}

BINLINE std::wstring BToStdWString(const char* str, size_t len) {
	if (str == NULL || len == 0) return std::wstring();
	if (len == std::string::npos) len = strlen(str);
	std::wstringstream ss;
	for (size_t i = 0; i < len; i++) {
		ss << (wchar_t)str[i];
	}
	return ss.str();
}

}}}


#endif /* BUTILS_H_ */
