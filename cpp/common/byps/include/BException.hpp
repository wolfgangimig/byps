#ifndef BEXCEPTION_HPP_
#define BEXCEPTION_HPP_

#include "BException.h"

namespace byps {

BINLINE void BException::serialize(BIO& bio, const BVERSION version) {
	bio & code;
	bio & msg;
	bio & details;
}

}

#endif