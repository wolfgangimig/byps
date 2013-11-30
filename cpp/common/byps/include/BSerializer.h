/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
/*
 * BSerializer.h
 *
 *  Created on: 29.07.2012
 *      Author: Wolfgang
 */

#ifndef BSERIALIZER_H_
#define BSERIALIZER_H_

#include "Byps.h"

namespace byps {



class BSerializer {
public:
    const BTYPEID typeId;

    BSerializer(BTYPEID typeId);
    virtual POBJECT serialize(BIO& bio, void* pObj) = 0;
};

template<typename _Type> class BSerializerT : public BSerializer {
public:
    BSerializerT(BTYPEID typeId);
    virtual POBJECT serialize(BIO& bio, void* pObj);
};


template<typename _Type> BSerializerT<_Type>::BSerializerT(BTYPEID typeId)
    : BSerializer(typeId) {
}

template<typename _Type> POBJECT BSerializerT<_Type>::serialize(BIO &bio, void *pObj) {
    if (!pObj) return POBJECT(new _Type());
    _Type* p = reinterpret_cast<_Type*>(pObj);
    _Type& r = *p;
    bio & r;
    return POBJECT();
}

}

#endif /* BSERIALIZER_H_ */
