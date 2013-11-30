/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BSERIALIZABLE_H_
#define BSERIALIZABLE_H_

#include "Byps.h"

namespace byps {

class BSerializable {
public:
    virtual ~BSerializable() {}
	virtual BTYPEID BSerializable_getTypeId() = 0;
};


}

#endif /* BSERIALIZABLE_H_ */
