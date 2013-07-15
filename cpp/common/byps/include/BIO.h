#ifndef BIO_H
#define BIO_H


#include "Byps.h"
#include "BMessageHeader.h"

namespace com { namespace wilutions { namespace byps {

class BIO {
public:
    const PTransport transport;
    const PRegistry registry;
    const bool is_loading;

    virtual ~BIO();
	virtual PStreamRequest createStreamRequest(PContentStream inputStream);

    void operator&(int8_t& v);
    void operator&(int16_t& v);
    void operator&(int32_t& v);
    void operator&(int64_t& v);
    void operator&(bool& v);
    void operator&(wchar_t& v);
    void operator&(float& v);
    void operator&(double& v);
    void operator&(BVariant& v);
    void operator&(BTargetId& v);

    template<typename _Type> void operator&(_Type& obj);
    template<typename _Type> void operator&(std::basic_string<_Type>& obj);
    template<typename _Type> void operator&(std::vector<_Type>& obj);
    template<typename _Key, typename _Type> void operator&(std::map<_Key,_Type>& obj);
    template<typename _Type> void operator&(std::set<_Type>& obj);

    template<typename _Type> void operator&(byps_ptr<_Type>& ptr);
    template<typename _Type> void operator&(byps_ptr<std::set<_Type> >& obj);
    template<typename _Type> void operator&(byps_ptr<std::vector<_Type> >& obj);
    template<typename _Key, typename _Type> void operator&(byps_ptr<std::map<_Key,_Type> >& obj);
	template<typename _Type> void operator&(byps_ptr<BArray1<_Type> >& obj);
	template<typename _Type> void operator&(byps_ptr<BArray2<_Type> >& obj);
	template<typename _Type> void operator&(byps_ptr<BArray3<_Type> >& obj);
	template<typename _Type> void operator&(byps_ptr<BArray4<_Type> >& obj);
    void operator&(PBytes& ptr);

	void serialize(PBytes& v);

	BMessageHeader header;

protected:
    BIO(PTransport transport, const BBinaryModel& bmodel, int32_t negotiatedVersion, BByteOrder negotiatedByteOrder);
    BIO(PTransport transport, const BBinaryModel& bmodel, PBytes& pBytes, BMessageHeader header);

    virtual void internalLoadObj(POBJECT&) { }
    virtual void internalLoadObjS(PSerializable&) { }
    virtual void internalStoreObj(POBJECT, bool , BSERIALIZER, BTYPEID) {}
    virtual void internalStoreObjS(PSerializable, bool , BSERIALIZER, BTYPEID) {}

	void serializeObjS(PSerializable& pObjS);
	void serializeObj(POBJECT& pObj, const std::type_info* tinfo);

    BBuffer bbuf;

};

template<typename _Type> void BIO::operator&(std::basic_string<_Type>& obj) {
    bbuf.serialize(obj);
}

template<typename _Type> void BIO::operator&(_Type& obj) {
    obj.serialize(*this, header.version);
}

template<typename _Type> void BIO::operator&(std::vector<_Type>& obj) {
    if (is_loading) {
        BLENGTH n0 = 0;
        bbuf.serialize(n0);
        obj.reserve((size_t)n0);
        for (BLENGTH i0 = 0; i0 < n0; i0++) {
            _Type elm = _Type();
            (*this) & elm;
            obj.push_back(elm);
        }
    }
    else {
        BLENGTH n0 = (BLENGTH)obj.size();
        bbuf.serialize(n0);
        for (BLENGTH i0 = 0; i0 < n0; i0++) {
            _Type elm = obj[i0];
            (*this) & elm;
        }
    }
}

template<typename _Key, typename _Type> void BIO::operator&(std::map<_Key, _Type>& obj) {
    if (is_loading) {
        BLENGTH n0 = 0;
        bbuf.serialize(n0);
        for (BLENGTH i0 = 0; i0 < n0; i0++) {
            _Key k = _Key();
            _Type v = _Type();
            (*this) & k;
            (*this) & v;
            obj[k] = v;
        }
    }
    else {
        BLENGTH n0 = (BLENGTH)obj.size();
        bbuf.serialize(n0);
        for (typename std::map<_Key, _Type>::iterator it = obj.begin(); it != obj.end(); it++) {
            _Key k = (*it).first;
            _Type& v = (*it).second;
            (*this) & k;
            (*this) & v;
        }
    }
}

template<typename _Type> void BIO::operator&(std::set<_Type>& obj) {
    if (is_loading) {
        BLENGTH n0 = 0;
        bbuf.serialize(n0);
        for (BLENGTH i0 = 0; i0 < n0; i0++) {
            _Type v = _Type();
            (*this) & v;
            obj.insert(typename std::set<_Type>::value_type(v));
        }
    }
    else {
        BLENGTH n0 = (BLENGTH)obj.size();
        bbuf.serialize(n0);
        for (typename std::set<_Type>::iterator it = obj.begin(); it != obj.end(); it++) {
            _Type v = (*it);
            (*this) & v;
        }
    }
}

template<typename _Type> void BIO::operator&(byps_ptr<std::set<_Type> >& ptr) {
	POBJECT pObj = ptr;
	serializeObj(pObj, ptr && !is_loading ? &typeid(*ptr.get()) : NULL);
	if (is_loading) ptr = byps_static_ptr_cast<std::set<_Type> >(pObj);
}

template<typename _Type> void BIO::operator&(byps_ptr<std::vector<_Type> >& ptr) {
	POBJECT pObj = ptr;
	serializeObj(pObj, ptr && !is_loading ? &typeid(*ptr.get()) : NULL);
	if (is_loading) ptr = byps_static_ptr_cast<std::vector<_Type> >(pObj);
}

template<typename _Key, typename _Type> void BIO::operator&(byps_ptr<std::map<_Key,_Type> >& ptr) {
	POBJECT pObj = ptr;
	serializeObj(pObj, ptr && !is_loading ? &typeid(*ptr.get()) : NULL);
	if (is_loading) ptr = byps_static_ptr_cast<std::map<_Key,_Type> >(pObj);
}

template<typename _Type> void BIO::operator&(byps_ptr<BArray1<_Type> >& ptr) {
	POBJECT pObj = ptr;
	serializeObj(pObj, ptr && !is_loading ? &typeid(*ptr.get()) : NULL);
	if (is_loading) ptr = byps_static_ptr_cast<BArray1<_Type> >(pObj);
}

template<typename _Type> void BIO::operator&(byps_ptr<BArray2<_Type> >& ptr) {
	POBJECT pObj = ptr;
	serializeObj(pObj, ptr && !is_loading ? &typeid(*ptr.get()) : NULL);
	if (is_loading) ptr = byps_static_ptr_cast<BArray2<_Type> >(pObj);
}

template<typename _Type> void BIO::operator&(byps_ptr<BArray3<_Type> >& ptr) {
	POBJECT pObj = ptr;
	serializeObj(pObj, ptr && !is_loading ? &typeid(*ptr.get()) : NULL);
	if (is_loading) ptr = byps_static_ptr_cast<BArray3<_Type> >(pObj);
}

template<typename _Type> void BIO::operator&(byps_ptr<BArray4<_Type> >& ptr) {
	POBJECT pObj = ptr;
	serializeObj(pObj, ptr && !is_loading ? &typeid(*ptr.get()) : NULL);
	if (is_loading) ptr = byps_static_ptr_cast<BArray4<_Type> >(pObj);
}

template<typename _Type> void BIO::operator&(byps_ptr<_Type>& ptr) {
	PSerializable pObjS = byps_ptr_cast<_Type>(ptr);
	serializeObjS(pObjS);
    if (is_loading) ptr = byps_ptr_cast<_Type>(pObjS);
}


}}}

#endif // BIO_H
