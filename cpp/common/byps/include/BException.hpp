#ifndef BEXCEPTION_HPP_
#define BEXCEPTION_HPP_

#include "BException.h"

namespace com {namespace wilutions {namespace byps {

BINLINE void BException::serialize(BIO& bio, unsigned int version) {
	bio & code;
	bio & msg;
	bio & details;
}

}}}

#endif