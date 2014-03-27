/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BINPUT_HPP
#define BINPUT_HPP

#include "Byps.h"

namespace byps {


BINLINE BInput::BInput(PTransport transport, const BMessageHeader &header, PBytes& pBytes)
    : BIO(transport, BBinaryModel::MEDIUM(), pBytes, header)
    , currentId(0) {
}

BINLINE BInput::~BInput() {
}

BINLINE PSerializable BInput::load() {

    PSerializable ptr;

	if (header.messageId == 0) {
        header.read(bbuf);
    }

	if (header.error != 0) {
		BTYPEID typeId = 0;
		BPOINTER id = 0;
		bbuf.serializePointer(id);
		bbuf.serializeTypeId(typeId);

		BException ex;
		*this & ex;

		throw ex;
	}
	else {

		(*this) & ptr;
	}

    return ptr;
}

BINLINE void BInput::internalLoadObj(POBJECT& pObj) {

    BPOINTER id = 0;
    bbuf.serializePointer(id);
    if (id > 0) {
        PSerializable NULLS;

        // Read type and size from stream
        BTYPEID typeId = 0;
        bbuf.serializeTypeId(typeId);
        if (typeId < 0) throw BException(BExceptionC::CORRUPT);

        BSERIALIZER ser = registry->getSerializer(typeId);

        // Create
        currentId = id;
        ser(*this, pObj, NULLS, NULL);
 
        idMap.insert(IDMAP::value_type(id, pObj));
       
		// Read
        ser(*this, pObj, NULLS, NULL);

    }
    else if (id < 0) {
        IDMAP::iterator it = idMap.find(-id);
        if (it == idMap.end()) throw BException(BExceptionC::CORRUPT);
        pObj = (*it).second;
    }
    else {
        // NULL reference
    }

}

BINLINE void BInput::internalLoadObjS(PSerializable& pObjS) {

    BPOINTER id = 0;
    bbuf.serializePointer(id);
    if (id > 0) {
        POBJECT NULLO;

        // Read type and size from stream
        BTYPEID typeId = 0;
        bbuf.serializeTypeId(typeId);
        if (typeId < 0) throw BException(BExceptionC::CORRUPT);

        BSERIALIZER ser = registry->getSerializer(typeId);

        // Create
        currentId = id;
        ser(*this, NULLO, pObjS, NULL);
 
        idMap.insert(IDMAP::value_type(id, pObjS));
       
		// Read
        ser(*this, NULLO, pObjS, NULL);

    }
    else if (id < 0) {
        IDMAP::iterator it = idMap.find(-id);
        if (it == idMap.end()) throw BException(BExceptionC::CORRUPT);
		pObjS = byps_static_ptr_cast<BSerializable>((*it).second);
    }
    else {
        // NULL reference
    }

}

}

#endif // BINPUT_HPP
