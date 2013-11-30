/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
/*
 * BInput.h
 *
 *  Created on: 29.07.2012
 *      Author: Wolfgang
 */

#ifndef BINPUT_H_
#define BINPUT_H_

#include "Byps.h"

namespace byps {

using namespace ::std;

class BInput : public BIO {
public:
    BMessageHeader header;

    BInput(PTransport transport, const BMessageHeader& header, PBytes& pBytes);

    virtual ~BInput();

    PSerializable load();

protected:
	 
    typedef unordered_map<BPOINTER, POBJECT > IDMAP;
    IDMAP idMap;
    BPOINTER currentId;

    virtual void internalLoadObj(POBJECT&);
    virtual void internalLoadObjS(PSerializable&);
    
};


}

#endif /* BINPUT_H_ */
