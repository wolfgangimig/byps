#ifndef HEXCEPTION_H_
#define HEXCEPTION_H_

#include "Bypshttp.h"

namespace com { namespace wilutions { namespace byps { namespace http {

using namespace com::wilutions::byps;

class HException : public BException {
public:
	HException(LPCWSTR fnctName, DWORD err);
	HException(DWORD httpStatus);
private:
	LPCWSTR getWinHttpErrorMessage(DWORD err);
};

}}}}

#endif