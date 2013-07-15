#ifndef BVARIANT_H
#define BVARIANT_H

#include "Byps.h"
#include "BRegistry.h"

namespace com { namespace wilutions { namespace byps {

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
    BVariant(const std::wstring&);
    template <typename _Type> BVariant(byps_ptr<_Type>);
	BVariant(PSerializable);
	//template <typename _Type> BVariant(BTYPEID, byps_ptr<_Type>);
 //   template <typename _Type> BVariant(_Type*);
    BVariant(const BException&);
	BVariant(const std::exception&);

    void setType(BTYPEID);
    BTYPEID getType() const ;
    bool isException() const ;

    //bool getBool() const ;
    //wchar_t getChar() const ;
    //int8_t getByte() const ;
    //int16_t getShort() const ;
    //int32_t getInt() const ;
    //int64_t getLong() const ;
    //float getFloat() const ;
    //double getDouble() const ;
    //const std::wstring& getStr() const ;
    //POBJECT getObject() const ;
    //void* getPtr() const ;
    BException getException() const ;

    void get(bool& v) const;
    void get(wchar_t& v) const;
    void get(int8_t& v) const;
    void get(int16_t& v) const;
    void get(int32_t& v) const;
    void get(int64_t& v) const;
    void get(float& v) const;
    void get(double& v) const;
    void get(std::wstring& v) const;
    template<typename _Type> void get(byps_ptr<_Type>& v) const;
	void get(PSerializable& v) const;
    void get(BException& v) const;

    void serialize(BIO&, const unsigned int);

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
    };
    std::wstring strVal;
    POBJECT objVal;
	PSerializable sobjVal;
    BException exVal;
};



inline BVariant::BVariant() : type(BTYPEID_INT64), longVal(0) {}

inline BVariant::BVariant(const BVariant& rhs)
    : type(rhs.type)
    , longVal(rhs.longVal)
    , strVal(rhs.strVal)
    , objVal(rhs.objVal)
    , exVal(rhs.exVal) {
}

inline BVariant::BVariant(bool v) : type(BTYPEID_BOOL), boolVal(v) {}
inline BVariant::BVariant(wchar_t v) : type(BTYPEID_WCHAR), charVal(v) {}
inline BVariant::BVariant(int8_t v) : type(BTYPEID_INT8), byteVal(v) {}
inline BVariant::BVariant(int16_t v) : type(BTYPEID_INT16), shortVal(v) {}
inline BVariant::BVariant(int32_t v) : type(BTYPEID_INT32), intVal(v) {}
inline BVariant::BVariant(int64_t v) : type(BTYPEID_INT64), longVal(v) {}
inline BVariant::BVariant(float v) : type(BTYPEID_FLOAT), floatVal(v) {}
inline BVariant::BVariant(double v) : type(BTYPEID_DOUBLE), doubleVal(v) {}
inline BVariant::BVariant(const std::wstring& v) : type(BTYPEID_STRING), strVal(v) {}
template<typename _Type> BVariant::BVariant(byps_ptr<_Type> v) : type(BTYPEID_OBJECT), objVal(byps_static_ptr_cast<void>(v)) {}
inline BVariant::BVariant(PSerializable v) : type(BTYPEID_OBJECT), sobjVal(v) {}
inline BVariant::BVariant(const BException& v) : type(BTYPEID_EXCEPTION), exVal(v) {}

inline BVariant::BVariant(const std::exception& v) 
	: type(BTYPEID_EXCEPTION)
	, exVal( typeid(v) == typeid(BException) ? static_cast<const BException&>(v) : BException(v) )
{
}

inline void BVariant::setType(BTYPEID v) { this->type = v; }
inline BTYPEID BVariant::getType() const { return type; }
inline bool BVariant::isException() const { return type == BTYPEID_EXCEPTION; }

//inline bool BVariant::getBool() const { return boolVal; }
//inline wchar_t BVariant::getChar() const { return charVal; }
//inline int8_t BVariant::getByte() const { return byteVal; }
//inline int16_t BVariant::getShort() const { return shortVal; }
//inline int32_t BVariant::getInt() const { return intVal; }
//inline int64_t BVariant::getLong() const { return longVal; }
//inline float BVariant::getFloat() const { return floatVal; }
//inline double BVariant::getDouble() const { return doubleVal; }
//inline const std::wstring& BVariant::getStr() const { return strVal; }
//inline POBJECT BVariant::getObject() const { return objVal; }
inline BException BVariant::getException() const { return exVal; }

inline void BVariant::get(bool& v) const { v = boolVal; }
inline void BVariant::get(wchar_t& v) const { v = charVal; }
inline void BVariant::get(int8_t& v) const { v = byteVal; }
inline void BVariant::get(int16_t& v) const { v = shortVal; }
inline void BVariant::get(int32_t& v) const { v = intVal; }
inline void BVariant::get(int64_t& v) const { v = longVal; }
inline void BVariant::get(float& v) const { v = floatVal; }
inline void BVariant::get(double& v) const { v  = doubleVal; }
inline void BVariant::get(std::wstring& v) const { v = strVal; }
template<typename _Type> void BVariant::get(byps_ptr<_Type>& v) const { v = byps_static_ptr_cast<_Type>(objVal); }
inline void BVariant::get(BException& v) const { v = exVal; }
inline void BVariant::get(PSerializable& v) const { v = sobjVal; }


}}}

#endif // BVARIANT_H
