/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BIO_H
#define BIO_H


#include "Byps.h"
#include "BMessageHeader.h"

namespace byps {

  class BIO {
    //#ifdef _DEBUG
    //	char watchForMemLeak[1000*1000];
    //#endif
  public:
    const PTransport transport;
    const PRegistry registry;
    const bool is_loading;

    virtual ~BIO();
    virtual PContentStream createStreamRequest(PContentStream inputStream);

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
    void operator&(BDateTime& v);

    template<typename _Type> void operator&(_Type& obj);
    template<typename _Type> void operator&(basic_string<_Type>& obj);
    template<typename _Type> void operator&(vector<_Type>& obj);
    template<typename _Key, typename _Type> void operator&(map<_Key,_Type>& obj);
    template<typename _Type> void operator&(set<_Type>& obj);

    template<typename _Type> void operator&(byps_ptr<_Type>& ptr);
    template<typename _Type> void operator&(byps_ptr<set<_Type> >& obj);
    template<typename _Type> void operator&(byps_ptr<vector<_Type> >& obj);
    template<typename _Key, typename _Type> void operator&(byps_ptr<map<_Key,_Type> >& obj);
    template<typename _Type> void operator&(byps_ptr<BArray1<_Type> >& obj);
    template<typename _Type> void operator&(byps_ptr<BArray2<_Type> >& obj);
    template<typename _Type> void operator&(byps_ptr<BArray3<_Type> >& obj);
    template<typename _Type> void operator&(byps_ptr<BArray4<_Type> >& obj);
    void operator&(PBytes& ptr);

    void serialize(PBytes& v);

    BMessageHeader header;

  protected:
    BIO(PTransport transport, const BBinaryModel& bmodel, int32_t bversion, BVERSION negotiatedVersion, BByteOrder negotiatedByteOrder);
    BIO(PTransport transport, const BBinaryModel& bmodel, PBytes& pBytes, BMessageHeader header);

    virtual void internalLoadObj(POBJECT&) { }
    virtual void internalLoadObjS(PSerializable&) { }
    virtual void internalStoreObj(POBJECT, bool , BSERIALIZER, BTYPEID) {}
    virtual void internalStoreObjS(PSerializable, bool , BSERIALIZER, BTYPEID) {}

    void serializeObjS(PSerializable& pObjS);
    void serializeObj(POBJECT& pObj, const type_info* tinfo);

    BBuffer bbuf;

  };

  template<typename _Type> void BIO::operator&(basic_string<_Type>& obj) {
    bbuf.serialize(obj);
  }

  template<typename _Type> void BIO::operator&(_Type& obj) {
    obj.serialize(*this, header.version);
  }

  template<typename _Type> void BIO::operator&(vector<_Type>& obj) {
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

  template<typename _Key, typename _Type> void BIO::operator&(map<_Key, _Type>& obj) {
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
      for (typename map<_Key, _Type>::iterator it = obj.begin(); it != obj.end(); it++) {
        _Key k = (*it).first;
        _Type& v = (*it).second;
        (*this) & k;
        (*this) & v;
      }
    }
  }

  template<typename _Type> void BIO::operator&(set<_Type>& obj) {
    if (is_loading) {
      BLENGTH n0 = 0;
      bbuf.serialize(n0);
      for (BLENGTH i0 = 0; i0 < n0; i0++) {
        _Type v = _Type();
        (*this) & v;
        obj.insert(typename set<_Type>::value_type(v));
      }
    }
    else {
      BLENGTH n0 = (BLENGTH)obj.size();
      bbuf.serialize(n0);
      for (typename set<_Type>::iterator it = obj.begin(); it != obj.end(); it++) {
        _Type v = (*it);
        (*this) & v;
      }
    }
  }

  template<typename _Type> void BIO::operator&(byps_ptr<set<_Type> >& ptr) {
    POBJECT pObj = ptr;
    serializeObj(pObj, ptr && !is_loading ? &typeid(*ptr.get()) : NULL);
    if (is_loading) ptr = byps_static_ptr_cast<set<_Type> >(pObj);
  }

  template<typename _Type> void BIO::operator&(byps_ptr<vector<_Type> >& ptr) {
    POBJECT pObj = ptr;
    serializeObj(pObj, ptr && !is_loading ? &typeid(*ptr.get()) : NULL);
    if (is_loading) ptr = byps_static_ptr_cast<vector<_Type> >(pObj);
  }

  template<typename _Key, typename _Type> void BIO::operator&(byps_ptr<map<_Key,_Type> >& ptr) {
    POBJECT pObj = ptr;
    serializeObj(pObj, ptr && !is_loading ? &typeid(*ptr.get()) : NULL);
    if (is_loading) ptr = byps_static_ptr_cast<map<_Key,_Type> >(pObj);
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


}

#endif // BIO_H
