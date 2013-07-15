/*
 * BRegistry.h
 *
 *  Created on: 29.07.2012
 *      Author: Wolfgang
 */

#ifndef BREGISTRY_HPP_
#define BREGISTRY_HPP_

#include "BRegistry.h"

namespace com { namespace wilutions { namespace byps {


BINLINE void BSerializer_12(BIO& bio, POBJECT& pObj, PSerializable& , void* ){
	void* p = pObj.get();
	if (p) { 
		std::vector< PSerializable >& r = * reinterpret_cast<std::vector< PSerializable >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new std::vector< PSerializable >());
	}
}

BINLINE void BSerializer_14(BIO& bio, POBJECT& pObj, PSerializable& , void* ){
	void* p = pObj.get();
	if (p) { 
		std::set< PSerializable >& r = * reinterpret_cast<std::set< PSerializable >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new std::set< PSerializable >());
	}
}


BINLINE BRegistry::BRegistry() {
	registerClass(typeid(BContentStream), BContentStream::serialize, BTYPEID_STREAM);
	registerClass(typeid(std::vector<PSerializable>), BSerializer_12, BTYPEID_LIST);
	registerClass(typeid(std::set<PSerializable>), BSerializer_14, BTYPEID_SET);
}

BINLINE BRegistry::~BRegistry() {
}

BINLINE void BRegistry::registerClass(const std::type_info& tinfo, BSERIALIZER ser, BTYPEID typeId) {
    mapSerializer[typeId] = ser;
    size_t hc = tinfo.hash_code();
    mapTypeIds[hc] = typeId;
}


BINLINE BSERIALIZER BRegistry::getSerializer(const std::type_info& tinfo, BTYPEID &typeId) {
    BSERIALIZER ser = NULL;
    size_t hc = tinfo.hash_code();
    typeId = mapTypeIds[hc];
    if (typeId != 0) {
        ser = mapSerializer[typeId];
    }
    if (!ser) {
        std::wstringstream ss; ss << L"Missing serializer for " << BToStdWString(tinfo.name());
        throw BException(EX_NO_SERIALIZER, ss.str());
    }
    return ser;
}

BINLINE BSERIALIZER BRegistry::getSerializer(BTYPEID typeId) {
    BSERIALIZER ser = mapSerializer[typeId];
    if (!ser) {
        std::wstringstream ss; ss << L"Missing serializer for typeId=" << typeId;
        throw BException(EX_NO_SERIALIZER, ss.str());
    }
    return ser;
}

}}}

#endif /* BREGISTRY_H_ */
