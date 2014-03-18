/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
/*
 * BRegistry.h
 *
 *  Created on: 29.07.2012
 *      Author: Wolfgang
 */

#ifndef BREGISTRY_HPP_
#define BREGISTRY_HPP_

#include "BRegistry.h"

namespace byps {


BINLINE void BSerializer_12(BIO& bio, POBJECT& pObj, PSerializable& , void* ){
	void* p = pObj.get();
	if (p) { 
		vector< PSerializable >& r = * reinterpret_cast<vector< PSerializable >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new vector< PSerializable >());
	}
}

BINLINE void BSerializer_14(BIO& bio, POBJECT& pObj, PSerializable& , void* ){
	void* p = pObj.get();
	if (p) { 
		set< PSerializable >& r = * reinterpret_cast<set< PSerializable >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new set< PSerializable >());
	}
}


BINLINE BRegistry::BRegistry() {
	registerClass(typeid(BContentStream), BContentStream::serialize, BTYPEID_STREAM);
	registerClass(typeid(vector<PSerializable>), BSerializer_12, BTYPEID_LIST);
	registerClass(typeid(set<PSerializable>), BSerializer_14, BTYPEID_SET);
}

BINLINE BRegistry::~BRegistry() {
}

BINLINE void BRegistry::registerClass(const type_info& tinfo, BSERIALIZER ser, BTYPEID typeId) {
    mapSerializer[typeId] = ser;
    size_t hc = tinfo.hash_code();
    mapTypeIds[hc] = typeId;
}


BINLINE BSERIALIZER BRegistry::getSerializer(const type_info& tinfo, BTYPEID &typeId) {
    BSERIALIZER ser = NULL;
    size_t hc = tinfo.hash_code();
    typeId = mapTypeIds[hc];
    if (typeId != 0) {
        ser = mapSerializer[typeId];
    }
    if (!ser) {
        wstringstream ss; ss << L"Missing serializer for " << fromUtf8(tinfo.name());
        throw BException(EX_CORRUPT, ss.str());
    }
    return ser;
}

BINLINE BSERIALIZER BRegistry::getSerializer(BTYPEID typeId) {
    BSERIALIZER ser = mapSerializer[typeId];
    if (!ser) {
        wstringstream ss; ss << L"Missing serializer for typeId=" << typeId;
        throw BException(EX_CORRUPT, ss.str());
    }
    return ser;
}

}

#endif /* BREGISTRY_H_ */
