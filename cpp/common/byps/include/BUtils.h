#ifndef BUTILS_H_
#define BUTILS_H_

#include "Byps.h"

namespace com { namespace wilutions { namespace byps {

#ifndef BHASH_CSTRING
#define BHASH_CSTRING
	
inline BTYPEID BHash(const char* s, int bias) {
	if (!s) return 0;
	int h = bias;
	while (*s) {
         h = 31*h + *s;
         s++;
	}
	return (BTYPEID)h;
}

#endif

std::wstring BToStdWString(const std::string& str);
std::wstring BToStdWString(const char* str, size_t len = std::string::npos);

}}}


#endif /* BUTILS_H_ */
