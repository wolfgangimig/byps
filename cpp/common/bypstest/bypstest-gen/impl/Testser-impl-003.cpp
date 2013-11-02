#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace inherit { 

//-------------------------------------------------
// Implementation of class BRequest_BioLemonService_useParing
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::inherit::BRequest_BioLemonService_useParing::BRequest_BioLemonService_useParing() : BMethodRequest(474058508) {
}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::inherit::BRequest_BioLemonService_useParing::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::inherit::BRequest_BioLemonService_useParing::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PBioLemonService __byps__remoteT = byps_ptr_cast<BioLemonService>(__byps__remote);
	__byps__remoteT->useParing([__byps__asyncResult](int32_t __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_5(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_2108700976(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::inherit::BRequest_BioLemonService_useParing& r = * dynamic_cast< byps::test::api::inherit::BRequest_BioLemonService_useParing*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::inherit::BRequest_BioLemonService_useParing());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace inherit { 

//-------------------------------------------------
// Implementation of class BRequest_FruitService_squeeze
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::inherit::BRequest_FruitService_squeeze::BRequest_FruitService_squeeze() : BMethodRequest(715959905) {
}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::inherit::BRequest_FruitService_squeeze::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::inherit::BRequest_FruitService_squeeze::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PFruitService __byps__remoteT = byps_ptr_cast<FruitService>(__byps__remote);
	__byps__remoteT->squeeze([__byps__asyncResult](::std::wstring __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_10(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_1290167289(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::inherit::BRequest_FruitService_squeeze& r = * dynamic_cast< byps::test::api::inherit::BRequest_FruitService_squeeze*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::inherit::BRequest_FruitService_squeeze());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace inherit { 

//-------------------------------------------------
// Implementation of class BRequest_LemonService_pick
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::inherit::BRequest_LemonService_pick::BRequest_LemonService_pick() : BMethodRequest(605543968) {
}
// checkpoint byps.gen.cpp.GenApiClass:534
byps::test::api::inherit::BRequest_LemonService_pick::BRequest_LemonService_pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree)
	: BMethodRequest(605543968) 
	, sess(sess)
	, fromTree(fromTree)
	{}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::inherit::BRequest_LemonService_pick::serialize(BIO& ar, const BVERSION version) {
	ar & fromTree;
	ar & sess;
}
void byps::test::api::inherit::BRequest_LemonService_pick::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PLemonService __byps__remoteT = byps_ptr_cast<LemonService>(__byps__remote);
	__byps__remoteT->pick(sess, fromTree, [__byps__asyncResult](::std::wstring __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_10(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_1022088379(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::inherit::BRequest_LemonService_pick& r = * dynamic_cast< byps::test::api::inherit::BRequest_LemonService_pick*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::inherit::BRequest_LemonService_pick());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace inherit { 

//-------------------------------------------------
// Implementation of class BRequest_PlantService_grow
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::inherit::BRequest_PlantService_grow::BRequest_PlantService_grow() : BMethodRequest(1954605928) {
}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::inherit::BRequest_PlantService_grow::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::inherit::BRequest_PlantService_grow::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PPlantService __byps__remoteT = byps_ptr_cast<PlantService>(__byps__remote);
	__byps__remoteT->grow([__byps__asyncResult](::std::wstring __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_10(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_695716901(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::inherit::BRequest_PlantService_grow& r = * dynamic_cast< byps::test::api::inherit::BRequest_PlantService_grow*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::inherit::BRequest_PlantService_grow());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace inherit { 

//-------------------------------------------------
// Implementation of class Class1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::inherit::Class1::Class1() {
	int1 = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:534
byps::test::api::inherit::Class1::Class1(int32_t int1, const PClass1& nextClass1)
	: int1(int1)
	, nextClass1(nextClass1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::inherit::Class1::serialize(BIO& ar, const BVERSION version) {
	ar & int1;
	ar & nextClass1;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_6001(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::inherit::Class1& r = * dynamic_cast< byps::test::api::inherit::Class1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::inherit::Class1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace inherit { 

//-------------------------------------------------
// Implementation of class Class1Collections
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::inherit::Class1Collections::Class1Collections() {
}
// checkpoint byps.gen.cpp.GenApiClass:534
byps::test::api::inherit::Class1Collections::Class1Collections(const byps_ptr< ::std::vector< PClass1 > >& list1, const byps_ptr< ::std::map< ::std::wstring , PClass1 > >& map1, const byps_ptr< ::std::set< PClass1 > >& set1)
	: list1(list1)
	, map1(map1)
	, set1(set1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::inherit::Class1Collections::serialize(BIO& ar, const BVERSION version) {
	ar & list1;
	ar & map1;
	ar & set1;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_6004(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::inherit::Class1Collections& r = * dynamic_cast< byps::test::api::inherit::Class1Collections*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::inherit::Class1Collections());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace inherit { 

//-------------------------------------------------
// Implementation of class Class2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::inherit::Class2::Class2() {
	int2 = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:534
byps::test::api::inherit::Class2::Class2(int32_t int2)
	: int2(int2)
	{}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::inherit::Class2::serialize(BIO& ar, const BVERSION version) {
	Class1::serialize(ar, version);
	ar & int2;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_6002(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::inherit::Class2& r = * dynamic_cast< byps::test::api::inherit::Class2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::inherit::Class2());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace inherit { 

//-------------------------------------------------
// Implementation of class Class3
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::inherit::Class3::Class3() {
	int3 = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:534
byps::test::api::inherit::Class3::Class3(int32_t int3)
	: int3(int3)
	{}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::inherit::Class3::serialize(BIO& ar, const BVERSION version) {
	Class2::serialize(ar, version);
	ar & int3;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_6003(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::inherit::Class3& r = * dynamic_cast< byps::test::api::inherit::Class3*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::inherit::Class3());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace inl { 

//-------------------------------------------------
// Implementation of class Actor
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::inl::Actor::Actor() {
}
// checkpoint byps.gen.cpp.GenApiClass:534
byps::test::api::inl::Actor::Actor(const byps_ptr< BArray1< Point2D > >& shape, const Matrix2D& position)
	: shape(shape)
	, position(position)
	{}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::inl::Actor::serialize(BIO& ar, const BVERSION version) {
	ar & position;
	ar & shape;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_171948703(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::inl::Actor& r = * dynamic_cast< byps::test::api::inl::Actor*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::inl::Actor());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace list { 

//-------------------------------------------------
// Implementation of class ListListTypes
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::list::ListListTypes::ListListTypes() {
}
// checkpoint byps.gen.cpp.GenApiClass:534
byps::test::api::list::ListListTypes::ListListTypes(const byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > >& int2, const byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > >& int3, const byps_ptr< ::std::vector< byps_ptr< ::std::vector< byps_ptr< BArray4< int32_t > > > > > >& int24)
	: int2(int2)
	, int3(int3)
	, int24(int24)
	{}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::list::ListListTypes::serialize(BIO& ar, const BVERSION version) {
	ar & int2;
	ar & int24;
	ar & int3;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_3002(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::list::ListListTypes& r = * dynamic_cast< byps::test::api::list::ListListTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::list::ListListTypes());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace list { 

//-------------------------------------------------
// Implementation of class ListTypes
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::list::ListTypes::ListTypes() {
}
// checkpoint byps.gen.cpp.GenApiClass:534
byps::test::api::list::ListTypes::ListTypes(const byps_ptr< ::std::vector< bool > >& boolean1, const byps_ptr< ::std::vector< int8_t > >& byte1, const byps_ptr< ::std::vector< wchar_t > >& char1, const byps_ptr< ::std::vector< int16_t > >& short1, const byps_ptr< ::std::vector< int32_t > >& int1, const byps_ptr< ::std::vector< int64_t > >& long1, const byps_ptr< ::std::vector< float > >& float1, const byps_ptr< ::std::vector< double > >& double1, const byps_ptr< ::std::vector< ::std::wstring > >& string1, const byps_ptr< ::std::vector< byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1, const byps_ptr< ::std::vector< PBytes > >& byte2, const byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > >& int2, const byps_ptr< ::std::vector< byps_ptr< BArray4< int32_t > > > >& int4, const byps_ptr< ::std::vector< PSerializable > >& obj1)
	: boolean1(boolean1)
	, byte1(byte1)
	, char1(char1)
	, short1(short1)
	, int1(int1)
	, long1(long1)
	, float1(float1)
	, double1(double1)
	, string1(string1)
	, primitiveTypes1(primitiveTypes1)
	, byte2(byte2)
	, int2(int2)
	, int4(int4)
	, obj1(obj1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::list::ListTypes::serialize(BIO& ar, const BVERSION version) {
	ar & boolean1;
	ar & byte1;
	ar & byte2;
	ar & char1;
	ar & double1;
	ar & float1;
	ar & int1;
	ar & int2;
	ar & int4;
	ar & long1;
	ar & obj1;
	ar & primitiveTypes1;
	ar & short1;
	ar & string1;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_3001(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::list::ListTypes& r = * dynamic_cast< byps::test::api::list::ListTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::list::ListTypes());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace map { 

//-------------------------------------------------
// Implementation of class MapTypes
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::map::MapTypes::MapTypes() {
}
// checkpoint byps.gen.cpp.GenApiClass:534
byps::test::api::map::MapTypes::MapTypes(const byps_ptr< ::std::map< ::std::wstring , bool > >& boolean1, const byps_ptr< ::std::map< double , int8_t > >& byte1, const byps_ptr< ::std::map< float , wchar_t > >& char1, const byps_ptr< ::std::map< int64_t , int16_t > >& short1, const byps_ptr< ::std::map< int32_t , int32_t > >& int1, const byps_ptr< ::std::map< int16_t , int64_t > >& long1, const byps_ptr< ::std::map< wchar_t , float > >& float1, const byps_ptr< ::std::map< int8_t , double > >& double1, const byps_ptr< ::std::map< ::std::wstring , ::std::wstring > >& string1, const byps_ptr< ::std::map< int32_t , byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1, const byps_ptr< ::std::map< int32_t , PBytes > >& byte2, const byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > >& int2, const byps_ptr< ::std::map< ::std::wstring , PSerializable > >& obj1)
	: boolean1(boolean1)
	, byte1(byte1)
	, char1(char1)
	, short1(short1)
	, int1(int1)
	, long1(long1)
	, float1(float1)
	, double1(double1)
	, string1(string1)
	, primitiveTypes1(primitiveTypes1)
	, byte2(byte2)
	, int2(int2)
	, obj1(obj1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::map::MapTypes::serialize(BIO& ar, const BVERSION version) {
	ar & boolean1;
	ar & byte1;
	ar & byte2;
	ar & char1;
	ar & double1;
	ar & float1;
	ar & int1;
	ar & int2;
	ar & long1;
	ar & obj1;
	ar & primitiveTypes1;
	ar & short1;
	ar & string1;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_4001(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::map::MapTypes& r = * dynamic_cast< byps::test::api::map::MapTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::map::MapTypes());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace prim { 

//-------------------------------------------------
// Implementation of class PrimitiveTypes
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::prim::PrimitiveTypes::PrimitiveTypes() {
	boolVal = false;
	byteVal = 0;
	charVal = '\0';
	shortVal = 0;
	intVal = 0;
	longVal = 0;
	floatVal = 0;
	doubleVal = 0;
	value = false;
}
// checkpoint byps.gen.cpp.GenApiClass:534
byps::test::api::prim::PrimitiveTypes::PrimitiveTypes(bool boolVal, int8_t byteVal, wchar_t charVal, int16_t shortVal, int32_t intVal, int64_t longVal, float floatVal, double doubleVal, const ::std::wstring& stringVal, const PSerializable& objVal, const PSerializable& objVal2, bool value, const PSerializable& temp)
	: boolVal(boolVal)
	, byteVal(byteVal)
	, charVal(charVal)
	, shortVal(shortVal)
	, intVal(intVal)
	, longVal(longVal)
	, floatVal(floatVal)
	, doubleVal(doubleVal)
	, stringVal(stringVal)
	, objVal(objVal)
	, objVal2(objVal2)
	, value(value)
	, temp(temp)
	{}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::prim::PrimitiveTypes::serialize(BIO& ar, const BVERSION version) {
	ar & boolVal;
	ar & byteVal;
	ar & charVal;
	ar & doubleVal;
	ar & floatVal;
	ar & intVal;
	ar & longVal;
	ar & shortVal;
	ar & stringVal;
	ar & value;
	ar & objVal;
	ar & objVal2;
	// skip transient member temp
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_1000(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::prim::PrimitiveTypes& r = * dynamic_cast< byps::test::api::prim::PrimitiveTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::prim::PrimitiveTypes());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_2053507648(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< byps::test::api::prim::PPrimitiveTypes > & r = * reinterpret_cast< BArray1< byps::test::api::prim::PPrimitiveTypes > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< byps::test::api::prim::PPrimitiveTypes > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_2030857950(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray2< byps::test::api::prim::PPrimitiveTypes > & r = * reinterpret_cast< BArray2< byps::test::api::prim::PPrimitiveTypes > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray2< byps::test::api::prim::PPrimitiveTypes > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_1739334652(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray3< byps::test::api::prim::PPrimitiveTypes > & r = * reinterpret_cast< BArray3< byps::test::api::prim::PPrimitiveTypes > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray3< byps::test::api::prim::PPrimitiveTypes > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_758319514(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< byps::test::api::prim::PPrimitiveTypes > & r = * reinterpret_cast< BArray4< byps::test::api::prim::PPrimitiveTypes > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< byps::test::api::prim::PPrimitiveTypes > ());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace priv { 

//-------------------------------------------------
// Implementation of class PrivateMembers
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::priv::PrivateMembers::PrivateMembers() {
	boolVal = false;
	byteVal = 0;
	charVal = '\0';
	shortVal = 0;
	intVal = 0;
	longVal = 0;
	floatVal = 0;
	doubleVal = 0;
	protInt = 0;
	pprotInt = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:534
byps::test::api::priv::PrivateMembers::PrivateMembers(bool boolVal, int8_t byteVal, wchar_t charVal, int16_t shortVal, int32_t intVal, int64_t longVal, float floatVal, double doubleVal, const ::std::wstring& stringVal, const byps::test::api::prim::PPrimitiveTypes& primitiveTypes, const byps_ptr< BArray1< bool > >& arrBool, const byps_ptr< BArray1< int32_t > >& arrInt, const byps_ptr< BArray1< ::std::wstring > >& arrString, const byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > >& arrPrimitiveTypes, const byps_ptr< ::std::vector< bool > >& listBool, const byps_ptr< ::std::vector< int32_t > >& listInt, const byps_ptr< ::std::vector< ::std::wstring > >& listString, const byps_ptr< ::std::vector< byps::test::api::prim::PPrimitiveTypes > >& listPrimitiveTypes, const byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< ::std::wstring > > > >& mapIntListString, int32_t protInt, int32_t pprotInt)
	: boolVal(boolVal)
	, byteVal(byteVal)
	, charVal(charVal)
	, shortVal(shortVal)
	, intVal(intVal)
	, longVal(longVal)
	, floatVal(floatVal)
	, doubleVal(doubleVal)
	, stringVal(stringVal)
	, primitiveTypes(primitiveTypes)
	, arrBool(arrBool)
	, arrInt(arrInt)
	, arrString(arrString)
	, arrPrimitiveTypes(arrPrimitiveTypes)
	, listBool(listBool)
	, listInt(listInt)
	, listString(listString)
	, listPrimitiveTypes(listPrimitiveTypes)
	, mapIntListString(mapIntListString)
	, protInt(protInt)
	, pprotInt(pprotInt)
	{}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::priv::PrivateMembers::serialize(BIO& ar, const BVERSION version) {
	ar & boolVal;
	ar & byteVal;
	ar & charVal;
	ar & doubleVal;
	ar & floatVal;
	ar & intVal;
	ar & longVal;
	ar & pprotInt;
	ar & protInt;
	ar & shortVal;
	ar & stringVal;
	ar & arrBool;
	ar & arrInt;
	ar & arrPrimitiveTypes;
	ar & arrString;
	ar & listBool;
	ar & listInt;
	ar & listPrimitiveTypes;
	ar & listString;
	ar & mapIntListString;
	ar & primitiveTypes;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_8001(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::priv::PrivateMembers& r = * dynamic_cast< byps::test::api::priv::PrivateMembers*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::priv::PrivateMembers());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace refs { 

//-------------------------------------------------
// Implementation of class Node
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::refs::Node::Node() {
}
// checkpoint byps.gen.cpp.GenApiClass:534
byps::test::api::refs::Node::Node(const PNode& next, const PNode& me, const byps_ptr< ::std::map< ::std::wstring , PNode > >& mapOfNodes, const byps_ptr< ::std::vector< PNode > >& listOfNodes)
	: next(next)
	, me(me)
	, mapOfNodes(mapOfNodes)
	, listOfNodes(listOfNodes)
	{}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::refs::Node::serialize(BIO& ar, const BVERSION version) {
	ar & listOfNodes;
	ar & mapOfNodes;
	ar & me;
	ar & next;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_9001(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::refs::Node& r = * dynamic_cast< byps::test::api::refs::Node*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::refs::Node());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getBool
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getBool::BRequest_RemoteArrayTypes1dim_getBool() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getBool::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getBool::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getBool([__byps__asyncResult](byps_ptr< BArray1< bool > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2058423690(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_2033416644(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getBool& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getBool*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getBool());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getByte
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getByte::BRequest_RemoteArrayTypes1dim_getByte() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getByte::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getByte::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getByte([__byps__asyncResult](PBytes __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1374008726(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_2033426402(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getByte& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getByte*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getByte());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getChar
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getChar::BRequest_RemoteArrayTypes1dim_getChar() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getChar::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getChar::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getChar([__byps__asyncResult](byps_ptr< BArray1< wchar_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1361632968(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_2033439280(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getChar& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getChar*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getChar());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getDouble
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDouble::BRequest_RemoteArrayTypes1dim_getDouble() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDouble::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDouble::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getDouble([__byps__asyncResult](byps_ptr< BArray1< double > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1359468275(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_39293909(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDouble& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDouble*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDouble());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getFloat
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getFloat::BRequest_RemoteArrayTypes1dim_getFloat() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getFloat::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getFloat::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getFloat([__byps__asyncResult](byps_ptr< BArray1< float > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_766441794(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_1384988990(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getFloat& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getFloat*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getFloat());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getInt
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getInt::BRequest_RemoteArrayTypes1dim_getInt() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getInt::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getInt::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getInt([__byps__asyncResult](byps_ptr< BArray1< int32_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_100361105(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_1874061867(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getInt& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getInt*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getInt());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getLong
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getLong::BRequest_RemoteArrayTypes1dim_getLong() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getLong::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getLong::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getLong([__byps__asyncResult](byps_ptr< BArray1< int64_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1097129250(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_2033714518(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getLong& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getLong*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getLong());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getObject
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getObject::BRequest_RemoteArrayTypes1dim_getObject() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getObject::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getObject::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getObject([__byps__asyncResult](byps_ptr< BArray1< PSerializable > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_183594037(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_263295897(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getObject& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getObject*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getObject());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getPrimitiveTypes
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getPrimitiveTypes([__byps__asyncResult](byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2053507648(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_1992537556(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getShort
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort::BRequest_RemoteArrayTypes1dim_getShort() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getShort([__byps__asyncResult](byps_ptr< BArray1< int16_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2067161310(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_1373101854(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getString
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString::BRequest_RemoteArrayTypes1dim_getString() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getString([__byps__asyncResult](byps_ptr< BArray1< ::std::wstring > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1888107655(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_394678379(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setBool
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool::BRequest_RemoteArrayTypes1dim_setBool() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:534
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool::BRequest_RemoteArrayTypes1dim_setBool(const byps_ptr< BArray1< bool > >& v)
	: BMethodRequest(963816328) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->setBool(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_201441072(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setByte
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte::BRequest_RemoteArrayTypes1dim_setByte() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:534
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte::BRequest_RemoteArrayTypes1dim_setByte(const PBytes& v)
	: BMethodRequest(963816328) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:875
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->setByte(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:932
namespace byps { namespace test { namespace api { 
void BSerializer_201431314(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte());
	}
}
}}}
