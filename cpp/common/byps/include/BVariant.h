/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BVARIANT_H
#define BVARIANT_H

#include "Byps.h"
#include "BRegistry.h"

namespace byps {

class BVariant {
public:
    BVariant();
    BVariant(const BVariant& rhs);
    BVariant(bool);
    BVariant(wchar_t);
    BVariant(int8_t);
    BVariant(int16_t);
    BVariant(int32_t);
    BVariant(int64_t);
    BVariant(float);
    BVariant(double);
    BVariant(const wstring&);
    template <typename _Type> BVariant(byps_ptr<_Type>);
	BVariant(PSerializable);

    BVariant(const BException&);
    BVariant(const exception&);

    void setType(BTYPEID);
    BTYPEID getType() const ;
    bool isException() const ;

    BException getException() const ;

    template<typename _Type> void get(_Type& v) const;
    void get(wstring& v) const;
    template<typename _Type> void get(byps_ptr<_Type>& v) const;
	void get(PSerializable& v) const;
    void get(BException& v) const;

    void serialize(BIO&, BVERSION);

    std::wstring toString() const;

	void clear();

private:
    BTYPEID type;
    union {
        bool boolVal;
        wchar_t charVal;
        int8_t byteVal;
        int16_t shortVal;
        int32_t intVal;
        int64_t longVal;
        float floatVal;
        double doubleVal;
    } u;
    wstring strVal;
    POBJECT objVal;
	PSerializable sobjVal;
    BException exVal;
};



inline BVariant::BVariant() : type(BTYPEID_INT64) { clear(); u.longVal = 0; }

inline BVariant::BVariant(const BVariant& rhs)
    : type(rhs.type)
    , strVal(rhs.strVal)
    , objVal(rhs.objVal)
    , exVal(rhs.exVal) {
	u.longVal = rhs.u.longVal;
}

inline BVariant::BVariant(bool v) : type(BTYPEID_BOOL) { clear(); u.boolVal = v; }
inline BVariant::BVariant(wchar_t v) : type(BTYPEID_WCHAR) { clear(); u.charVal = v; }
inline BVariant::BVariant(int8_t v) : type(BTYPEID_INT8) { clear(); u.byteVal = v; }
inline BVariant::BVariant(int16_t v) : type(BTYPEID_INT16) { clear(); u.shortVal = v; }
inline BVariant::BVariant(int32_t v) : type(BTYPEID_INT32) { clear(); u.intVal = v; }
inline BVariant::BVariant(int64_t v) : type(BTYPEID_INT64) { clear(); u.longVal = v; }
inline BVariant::BVariant(float v) : type(BTYPEID_FLOAT) { clear(); u.floatVal = v; }
inline BVariant::BVariant(double v) : type(BTYPEID_DOUBLE) { clear(); u.doubleVal = v; }
inline BVariant::BVariant(const wstring& v) : type(BTYPEID_STRING), strVal(v) {clear(); }
template<typename _Type> BVariant::BVariant(byps_ptr<_Type> v) : type(BTYPEID_OBJECT), objVal(byps_static_ptr_cast<void>(v)) {clear(); }
inline BVariant::BVariant(PSerializable v) : type(BTYPEID_OBJECT), sobjVal(v) {clear(); }
inline BVariant::BVariant(const BException& v) : type(BTYPEID_EXCEPTION), exVal(v) {clear(); }

inline BVariant::BVariant(const exception& v)
	: type(BTYPEID_EXCEPTION)
	, exVal( typeid(v) == typeid(BException) ? static_cast<const BException&>(v) : BException(v) )
{
	clear(); 
}

inline void BVariant::setType(BTYPEID v) { this->type = v; }
inline BTYPEID BVariant::getType() const { return type; }
inline bool BVariant::isException() const { return type == BTYPEID_EXCEPTION; }


inline BException BVariant::getException() const { return exVal; }

template<typename _Type> void BVariant::get(_Type& v) const { 
	// http://stackoverflow.com/questions/6352199/memory-layout-of-union-of-different-sized-member
	_Type* pv = (_Type*)(&this->u);
	v = *pv;
}

inline void BVariant::get(wstring& v) const { v = strVal; }
template<typename _Type> void BVariant::get(byps_ptr<_Type>& v) const { v = byps_static_ptr_cast<_Type>(objVal); }
inline void BVariant::get(BException& v) const { v = exVal; }
inline void BVariant::get(PSerializable& v) const { v = sobjVal; }


}

#endif // BVARIANT_H
