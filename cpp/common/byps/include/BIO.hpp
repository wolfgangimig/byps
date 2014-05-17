/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BIO_HPP
#define BIO_HPP

#include "BIO.h"

namespace byps {

BINLINE BIO::BIO(PTransport transport, const BBinaryModel& bmodel, int32_t bversion, BVERSION negotiatedVersion, BByteOrder negotiatedByteOrder)
    : transport(transport)
    , registry(transport->getApiDesc()->getRegistry(bmodel))
    , is_loading(false)
    , header(BMAGIC_BINARY_STREAM, bversion, negotiatedVersion, negotiatedByteOrder, transport->getWire()->makeMessageId())
    , bbuf(bmodel, negotiatedByteOrder) {

}

BINLINE BIO::BIO(PTransport transport, const BBinaryModel& bmodel, PBytes& pBytes, BMessageHeader header)
    : transport(transport)
    , registry(transport->getApiDesc()->getRegistry(bmodel))
    , is_loading(true)
    , header(header)
    , bbuf(bmodel, pBytes, header.byteOrder) {

}

BINLINE BIO::~BIO() {

}

BINLINE void BIO::operator&(int8_t& v) {
    bbuf.serialize(v);
}
BINLINE void BIO::operator&(int16_t& v) {
    bbuf.serialize(v);
}
BINLINE void BIO::operator&(int32_t& v) {
    bbuf.serialize(v);
}
BINLINE void BIO::operator&(int64_t& v) {
    bbuf.serialize(v);
}
BINLINE void BIO::operator&(bool& v) {
	bbuf.serialize(v);
}
BINLINE void BIO::operator&(wchar_t& v) {
	bbuf.serialize(v);
}
BINLINE void BIO::operator&(float& v) {
    bbuf.serialize(v);
}
BINLINE void BIO::operator&(double& v) {
    bbuf.serialize(v);
}
BINLINE void BIO::serialize(PBytes& v) {
	bbuf.serialize(v);
}

BINLINE void BIO::operator&(BVariant& obj) {
    obj.serialize(*this, header.version);
}

BINLINE void BIO::operator&(BTargetId& obj) {
    obj.serialize(bbuf, header.bversion);
}

BINLINE void BIO::operator&(BDateTime& obj) {
    bbuf.serialize(obj);
}

BINLINE void BIO::operator&(PBytes& ptr) {
	POBJECT pObj = ptr;
	serializeObj(pObj, ptr && !is_loading ? &typeid(*ptr.get()) : NULL);
	if (is_loading) ptr = byps_static_ptr_cast<BBytes>(pObj);
}
 
BINLINE PContentStream BIO::createStreamRequest(PContentStream ) {
	return PContentStream();
}

BINLINE void BIO::serializeObjS(PSerializable& pObjS) {
    if (is_loading) {
		internalLoadObjS(pObjS);
    }
    else {
		BTYPEID typeId = 0;
		BSERIALIZER ser = NULL;

		if (pObjS) {
			typeId = pObjS->BSerializable_getTypeId();
			ser = registry->getSerializer(typeId);
			internalStoreObjS(pObjS, false, ser, typeId);
		}
		else {
			internalStoreObjS(PSerializable(), false, NULL, 0);
		}
    }
}

BINLINE void BIO::serializeObj(POBJECT& pObj, const type_info* tinfo) {
    if (is_loading) {
		internalLoadObj(pObj);
    }
    else {
		BTYPEID typeId = 0;
		BSERIALIZER ser = NULL;

		if (pObj) {
			ser = registry->getSerializer(*tinfo, typeId);
		}

		internalStoreObj(pObj, false, ser, typeId);
    }
}

}


#endif // BIO_HPP
