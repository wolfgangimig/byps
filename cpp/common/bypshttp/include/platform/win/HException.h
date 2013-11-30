/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef HEXCEPTION_H_
#define HEXCEPTION_H_

#include "Bypshttp.h"

namespace byps { namespace http { namespace winhttp {

using namespace byps;

class HException : public BException {
public:
	HException(LPCWSTR fnctName, DWORD err);
	HException(DWORD httpStatus);
private:
	LPCWSTR getWinHttpErrorMessage(DWORD err);
};

}}}

#endif