#ifndef BVALUECLASS_HPP_
#define BVALUECLASS_HPP_

#include "BValueClass.h"

namespace byps {

void BValueClass::serialize(BIO& ar, const BVERSION version) {
	ar & changedMembers;
}


}

#endif