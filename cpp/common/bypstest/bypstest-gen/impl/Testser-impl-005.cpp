#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setChar
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteArrayTypes4dim_setChar::BRequest_RemoteArrayTypes4dim_setChar() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.GenApiClass:552
byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setChar::BRequest_RemoteArrayTypes4dim_setChar(const PArray4Char& v)
	: BMethodRequest(963726955) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setChar::BSerializable_getTypeId() {
	return 185829721; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteArrayTypes4dim_setChar::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setChar::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setChar(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_185829721(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setChar>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setDate
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteArrayTypes4dim_setDate::BRequest_RemoteArrayTypes4dim_setDate() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.GenApiClass:552
byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDate::BRequest_RemoteArrayTypes4dim_setDate(const PArray4Date& v)
	: BMethodRequest(963726955) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDate::BSerializable_getTypeId() {
	return 185853361; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteArrayTypes4dim_setDate::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDate::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setDate(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_185853361(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDate>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setDouble
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteArrayTypes4dim_setDouble::BRequest_RemoteArrayTypes4dim_setDouble() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.GenApiClass:552
byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDouble::BRequest_RemoteArrayTypes4dim_setDouble(const PArray4Double& v)
	: BMethodRequest(963726955) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDouble::BSerializable_getTypeId() {
	return 1770586860; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteArrayTypes4dim_setDouble::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDouble::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setDouble(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_1770586860(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDouble>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setFloat
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteArrayTypes4dim_setFloat::BRequest_RemoteArrayTypes4dim_setFloat() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.GenApiClass:552
byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setFloat::BRequest_RemoteArrayTypes4dim_setFloat(const PArray4Float& v)
	: BMethodRequest(963726955) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setFloat::BSerializable_getTypeId() {
	return 1468656825; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteArrayTypes4dim_setFloat::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setFloat::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setFloat(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_1468656825(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setFloat>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setInt
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteArrayTypes4dim_setInt::BRequest_RemoteArrayTypes4dim_setInt() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.GenApiClass:552
byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setInt::BRequest_RemoteArrayTypes4dim_setInt(const PArray4Int& v)
	: BMethodRequest(963726955) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setInt::BSerializable_getTypeId() {
	return 1668568460; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteArrayTypes4dim_setInt::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setInt::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setInt(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_1668568460(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setInt>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setLong
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteArrayTypes4dim_setLong::BRequest_RemoteArrayTypes4dim_setLong() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.GenApiClass:552
byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setLong::BRequest_RemoteArrayTypes4dim_setLong(const PArray4Long& v)
	: BMethodRequest(963726955) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setLong::BSerializable_getTypeId() {
	return 186104959; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteArrayTypes4dim_setLong::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setLong::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setLong(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_186104959(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setLong>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setObject
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteArrayTypes4dim_setObject::BRequest_RemoteArrayTypes4dim_setObject() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.GenApiClass:552
byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setObject::BRequest_RemoteArrayTypes4dim_setObject(const byps::PArray4Object& v)
	: BMethodRequest(963726955) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setObject::BSerializable_getTypeId() {
	return 1467997054; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteArrayTypes4dim_setObject::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setObject::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setObject(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_1467997054(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setObject>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setPrimitiveTypes
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteArrayTypes4dim_setPrimitiveTypes::BRequest_RemoteArrayTypes4dim_setPrimitiveTypes() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.GenApiClass:552
byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setPrimitiveTypes::BRequest_RemoteArrayTypes4dim_setPrimitiveTypes(const byps::test::api::prim::PArray4PrimitiveTypes& v)
	: BMethodRequest(963726955) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setPrimitiveTypes::BSerializable_getTypeId() {
	return 456924651; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteArrayTypes4dim_setPrimitiveTypes::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setPrimitiveTypes::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setPrimitiveTypes(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_456924651(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setPrimitiveTypes>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setShort
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteArrayTypes4dim_setShort::BRequest_RemoteArrayTypes4dim_setShort() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.GenApiClass:552
byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setShort::BRequest_RemoteArrayTypes4dim_setShort(const PArray4Short& v)
	: BMethodRequest(963726955) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setShort::BSerializable_getTypeId() {
	return 1480543961; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteArrayTypes4dim_setShort::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setShort::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setShort(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_1480543961(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setShort>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setString
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteArrayTypes4dim_setString::BRequest_RemoteArrayTypes4dim_setString() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.GenApiClass:552
byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setString::BRequest_RemoteArrayTypes4dim_setString(const PArray4String& v)
	: BMethodRequest(963726955) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setString::BSerializable_getTypeId() {
	return 1336614572; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteArrayTypes4dim_setString::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setString::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setString(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_1336614572(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setString>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteConstants_compare_AllTypesC
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteConstants_compare_AllTypesC::BRequest_RemoteConstants_compare_AllTypesC() : BMethodRequest(2045242510) {
	bool1s = false;
	bool2s = false;
	char1s = '\0';
	char2s = '\0';
	short1s = 0;
	int1s = 0;
	long1s = 0;
	float1s = 0;
	double1s = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:552
byps::test::api::remote::BRequest_RemoteConstants_compare_AllTypesC::BRequest_RemoteConstants_compare_AllTypesC(bool bool1s, bool bool2s, wchar_t char1s, const ::std::wstring& stringNull, wchar_t char2s, int16_t short1s, int32_t int1s, int64_t long1s, float float1s, double double1s, const ::std::wstring& string1s, const byps::test::api::cons::PAllTypesZ& ALL, const PArrayInt& arrInt, const PArray4Int& arrInt4, const PArrayString& arrStrings, const PArray4String& arrStrings4, const byps::test::api::cons::PArray2AllTypesZ& arrAll)
	: BMethodRequest(2045242510) 
	, bool1s(bool1s)
	, bool2s(bool2s)
	, char1s(char1s)
	, stringNull(stringNull)
	, char2s(char2s)
	, short1s(short1s)
	, int1s(int1s)
	, long1s(long1s)
	, float1s(float1s)
	, double1s(double1s)
	, string1s(string1s)
	, ALL(ALL)
	, arrInt(arrInt)
	, arrInt4(arrInt4)
	, arrStrings(arrStrings)
	, arrStrings4(arrStrings4)
	, arrAll(arrAll)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteConstants_compare_AllTypesC::BSerializable_getTypeId() {
	return 1609344203; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteConstants_compare_AllTypesC::serialize(BIO& ar, const BVERSION version) {
	ar & this->bool1s;
	ar & this->bool2s;
	ar & this->char1s;
	ar & this->char2s;
	ar & this->double1s;
	ar & this->float1s;
	ar & this->int1s;
	ar & this->long1s;
	ar & this->short1s;
	ar & this->string1s;
	ar & this->stringNull;
	ar & this->ALL;
	ar & this->arrAll;
	ar & this->arrInt;
	ar & this->arrInt4;
	ar & this->arrStrings;
	ar & this->arrStrings4;
}
void byps::test::api::remote::BRequest_RemoteConstants_compare_AllTypesC::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteConstants __byps__remoteT = byps_ptr_cast<RemoteConstants>(__byps__remote);
	__byps__remoteT->compare_AllTypesC(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_1609344203(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteConstants_compare_AllTypesC>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteConstants_compare_HebrewC
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteConstants_compare_HebrewC::BRequest_RemoteConstants_compare_HebrewC() : BMethodRequest(2045242510) {
}
// checkpoint byps.gen.cpp.GenApiClass:552
byps::test::api::remote::BRequest_RemoteConstants_compare_HebrewC::BRequest_RemoteConstants_compare_HebrewC(const byps::test::api::cons::PHebrewZ& ALEPH, const byps::test::api::cons::PHebrewZ& BETH)
	: BMethodRequest(2045242510) 
	, ALEPH(ALEPH)
	, BETH(BETH)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteConstants_compare_HebrewC::BSerializable_getTypeId() {
	return 1711871378; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteConstants_compare_HebrewC::serialize(BIO& ar, const BVERSION version) {
	ar & this->ALEPH;
	ar & this->BETH;
}
void byps::test::api::remote::BRequest_RemoteConstants_compare_HebrewC::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteConstants __byps__remoteT = byps_ptr_cast<RemoteConstants>(__byps__remote);
	__byps__remoteT->compare_HebrewC(ALEPH, BETH, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_1711871378(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteConstants_compare_HebrewC>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteEnums_getPlanet
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteEnums_getPlanet::BRequest_RemoteEnums_getPlanet() : BMethodRequest(485761455) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteEnums_getPlanet::BSerializable_getTypeId() {
	return 6352043; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteEnums_getPlanet::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteEnums_getPlanet::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteEnums __byps__remoteT = byps_ptr_cast<RemoteEnums>(__byps__remote);
	__byps__remoteT->getPlanet([__byps__asyncResult](byps::test::api::enu::EnumPlanets __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1375035164(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_6352043(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteEnums_getPlanet>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteEnums_setPlanet
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteEnums_setPlanet::BRequest_RemoteEnums_setPlanet() : BMethodRequest(485761455) {
	planet = byps::test::api::enu::EnumPlanets::Mercury;
}
// checkpoint byps.gen.cpp.GenApiClass:552
byps::test::api::remote::BRequest_RemoteEnums_setPlanet::BRequest_RemoteEnums_setPlanet(byps::test::api::enu::EnumPlanets planet)
	: BMethodRequest(485761455) 
	, planet(planet)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteEnums_setPlanet::BSerializable_getTypeId() {
	return 220969119; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteEnums_setPlanet::serialize(BIO& ar, const BVERSION version) {
	ar & this->planet;
}
void byps::test::api::remote::BRequest_RemoteEnums_setPlanet::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteEnums __byps__remoteT = byps_ptr_cast<RemoteEnums>(__byps__remote);
	__byps__remoteT->setPlanet(planet, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_220969119(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteEnums_setPlanet>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_getActor
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteInlineInstance_getActor::BRequest_RemoteInlineInstance_getActor() : BMethodRequest(567395951) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteInlineInstance_getActor::BSerializable_getTypeId() {
	return 600892860; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteInlineInstance_getActor::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_getActor::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->getActor([__byps__asyncResult](byps::test::api::inl::PActor __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_171948703(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_600892860(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteInlineInstance_getActor>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_getPoint2DArray1dim
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteInlineInstance_getPoint2DArray1dim::BRequest_RemoteInlineInstance_getPoint2DArray1dim() : BMethodRequest(567395951) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray1dim::BSerializable_getTypeId() {
	return 188393247; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteInlineInstance_getPoint2DArray1dim::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray1dim::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->getPoint2DArray1dim([__byps__asyncResult](byps::test::api::inl::PArrayPoint2D __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_184101377(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_188393247(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray1dim>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_getPoint2DArray4dim
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteInlineInstance_getPoint2DArray4dim::BRequest_RemoteInlineInstance_getPoint2DArray4dim() : BMethodRequest(567395951) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray4dim::BSerializable_getTypeId() {
	return 188482620; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteInlineInstance_getPoint2DArray4dim::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray4dim::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->getPoint2DArray4dim([__byps__asyncResult](byps::test::api::inl::PArray4Point2D __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_949340697(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_188482620(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray4dim>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_getPoint2DList
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteInlineInstance_getPoint2DList::BRequest_RemoteInlineInstance_getPoint2DList() : BMethodRequest(567395951) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DList::BSerializable_getTypeId() {
	return 1428313263; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteInlineInstance_getPoint2DList::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DList::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->getPoint2DList([__byps__asyncResult](byps::test::api::inl::PVectorPoint2D __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2064980445(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_1428313263(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DList>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_getPoint2DListList
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteInlineInstance_getPoint2DListList::BRequest_RemoteInlineInstance_getPoint2DListList() : BMethodRequest(567395951) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DListList::BSerializable_getTypeId() {
	return 1650554387; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteInlineInstance_getPoint2DListList::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DListList::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->getPoint2DListList([__byps__asyncResult](byps_ptr< ::std::vector< byps::test::api::inl::PVectorPoint2D > > __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1823330785(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_1650554387(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DListList>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_getPoint2DMap
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteInlineInstance_getPoint2DMap::BRequest_RemoteInlineInstance_getPoint2DMap() : BMethodRequest(567395951) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DMap::BSerializable_getTypeId() {
	return 646661333; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteInlineInstance_getPoint2DMap::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DMap::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->getPoint2DMap([__byps__asyncResult](byps::test::api::inl::PMapIntegerPoint2D __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1358523233(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_646661333(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DMap>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_setActor
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteInlineInstance_setActor::BRequest_RemoteInlineInstance_setActor() : BMethodRequest(567395951) {
}
// checkpoint byps.gen.cpp.GenApiClass:552
byps::test::api::remote::BRequest_RemoteInlineInstance_setActor::BRequest_RemoteInlineInstance_setActor(const byps::test::api::inl::PActor& act)
	: BMethodRequest(567395951) 
	, act(act)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteInlineInstance_setActor::BSerializable_getTypeId() {
	return 1162005320; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteInlineInstance_setActor::serialize(BIO& ar, const BVERSION version) {
	ar & this->act;
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_setActor::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->setActor(act, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_1162005320(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteInlineInstance_setActor>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_setPoint2DArray1dim
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteInlineInstance_setPoint2DArray1dim::BRequest_RemoteInlineInstance_setPoint2DArray1dim() : BMethodRequest(567395951) {
}
// checkpoint byps.gen.cpp.GenApiClass:552
byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray1dim::BRequest_RemoteInlineInstance_setPoint2DArray1dim(const byps::test::api::inl::PArrayPoint2D& pointArray)
	: BMethodRequest(567395951) 
	, pointArray(pointArray)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray1dim::BSerializable_getTypeId() {
	return 1355334613; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteInlineInstance_setPoint2DArray1dim::serialize(BIO& ar, const BVERSION version) {
	ar & this->pointArray;
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray1dim::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->setPoint2DArray1dim(pointArray, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_1355334613(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray1dim>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_setPoint2DArray4dim
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteInlineInstance_setPoint2DArray4dim::BRequest_RemoteInlineInstance_setPoint2DArray4dim() : BMethodRequest(567395951) {
}
// checkpoint byps.gen.cpp.GenApiClass:552
byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray4dim::BRequest_RemoteInlineInstance_setPoint2DArray4dim(const byps::test::api::inl::PArray4Point2D& pointArray)
	: BMethodRequest(567395951) 
	, pointArray(pointArray)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray4dim::BSerializable_getTypeId() {
	return 1355245240; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteInlineInstance_setPoint2DArray4dim::serialize(BIO& ar, const BVERSION version) {
	ar & this->pointArray;
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray4dim::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->setPoint2DArray4dim(pointArray, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_1355245240(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray4dim>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_setPoint2DList
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteInlineInstance_setPoint2DList::BRequest_RemoteInlineInstance_setPoint2DList() : BMethodRequest(567395951) {
}
// checkpoint byps.gen.cpp.GenApiClass:552
byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DList::BRequest_RemoteInlineInstance_setPoint2DList(const byps::test::api::inl::PVectorPoint2D& pointList)
	: BMethodRequest(567395951) 
	, pointList(pointList)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DList::BSerializable_getTypeId() {
	return 343422941; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteInlineInstance_setPoint2DList::serialize(BIO& ar, const BVERSION version) {
	ar & this->pointList;
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DList::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->setPoint2DList(pointList, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_343422941(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DList>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_setPoint2DListList
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteInlineInstance_setPoint2DListList::BRequest_RemoteInlineInstance_setPoint2DListList() : BMethodRequest(567395951) {
}
// checkpoint byps.gen.cpp.GenApiClass:552
byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DListList::BRequest_RemoteInlineInstance_setPoint2DListList(const byps_ptr< ::std::vector< byps::test::api::inl::PVectorPoint2D > >& pointListList)
	: BMethodRequest(567395951) 
	, pointListList(pointListList)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DListList::BSerializable_getTypeId() {
	return 730520735; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteInlineInstance_setPoint2DListList::serialize(BIO& ar, const BVERSION version) {
	ar & this->pointListList;
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DListList::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->setPoint2DListList(pointListList, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_730520735(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DListList>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_setPoint2DMap
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteInlineInstance_setPoint2DMap::BRequest_RemoteInlineInstance_setPoint2DMap() : BMethodRequest(567395951) {
}
// checkpoint byps.gen.cpp.GenApiClass:552
byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DMap::BRequest_RemoteInlineInstance_setPoint2DMap(const byps::test::api::inl::PMapIntegerPoint2D& pointMap)
	: BMethodRequest(567395951) 
	, pointMap(pointMap)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DMap::BSerializable_getTypeId() {
	return 127469879; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteInlineInstance_setPoint2DMap::serialize(BIO& ar, const BVERSION version) {
	ar & this->pointMap;
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DMap::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->setPoint2DMap(pointMap, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_127469879(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DMap>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getBoolean1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:505
BRequest_RemoteListTypes_getBoolean1::BRequest_RemoteListTypes_getBoolean1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_getBoolean1::BSerializable_getTypeId() {
	return 2058662161; 
}
// checkpoint byps.gen.cpp.GenApiClass:892
void BRequest_RemoteListTypes_getBoolean1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getBoolean1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getBoolean1([__byps__asyncResult](byps::PVectorBoolean __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1617670280(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:949
namespace byps { namespace test { namespace api { 
void BSerializer_2058662161(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_getBoolean1>(bio, pObj, pObjS, pBase);	
}
}}}
