/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BVALUECLASS_HPP_
#define BVALUECLASS_HPP_

#include "BValueClass.h"

namespace byps {

void BValueClass::serialize(BIO& ar, const BVERSION ) {
	ar & changedMembers;
}


}

#endif
