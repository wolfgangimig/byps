#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace cons { 

//-------------------------------------------------
// Implementation of class AllTypesZ
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::cons::AllTypesZ::AllTypesZ() {
	bool1 = false;
	byte1 = 0;
	char1 = '\0';
	short1 = 0;
	int1 = 0;
	long1 = 0;
	float1 = 0;
	double1 = 0;
}
com::wilutions::byps::test::api::cons::AllTypesZ::AllTypesZ(bool bool1, int8_t byte1, wchar_t char1, int16_t short1, int32_t int1, int64_t long1, float float1, double double1, ::std::wstring string1, com::wilutions::byps::test::api::cons::PHebrewZ hebrew1, PBytes byte2, byps_ptr< BArray1< int32_t > > int2, byps_ptr< BArray1< ::std::wstring > > string2, byps_ptr< BArray1< com::wilutions::byps::test::api::cons::PHebrewZ > > hebrew2)
	: bool1(bool1)
	, byte1(byte1)
	, char1(char1)
	, short1(short1)
	, int1(int1)
	, long1(long1)
	, float1(float1)
	, double1(double1)
	, string1(string1)
	, hebrew1(hebrew1)
	, byte2(byte2)
	, int2(int2)
	, string2(string2)
	, hebrew2(hebrew2)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::cons::AllTypesZ::serialize(BIO& ar, const BVERSION version) {
	ar & bool1;
	ar & byte1;
	ar & char1;
	ar & double1;
	ar & float1;
	ar & int1;
	ar & long1;
	ar & short1;
	ar & string1;
	ar & byte2;
	ar & hebrew1;
	ar & hebrew2;
	ar & int2;
	ar & string2;
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_142458(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::cons::AllTypesZ& r = * dynamic_cast< com::wilutions::byps::test::api::cons::AllTypesZ*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::cons::AllTypesZ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1981543076(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray2< com::wilutions::byps::test::api::cons::PAllTypesZ > & r = * reinterpret_cast< BArray2< com::wilutions::byps::test::api::cons::PAllTypesZ > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray2< com::wilutions::byps::test::api::cons::PAllTypesZ > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace cons { 

//-------------------------------------------------
// Implementation of class HebrewC
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

const ::std::wstring HebrewC::aleph = std::wstring(L"\u05d0");

const ::std::wstring HebrewC::beth = std::wstring(L"\u05d1");

const PHebrewZ HebrewC::ALEPH = PHebrewZ(new HebrewZ(
	std::wstring(L"\u05d0")));

const PHebrewZ HebrewC::BETH = PHebrewZ(new HebrewZ(
	std::wstring(L"\u05d1")));

com::wilutions::byps::test::api::cons::HebrewC::HebrewC() {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::cons::HebrewC::serialize(BIO& ar, const BVERSION version) {
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_691741677(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::cons::HebrewC& r = * dynamic_cast< com::wilutions::byps::test::api::cons::HebrewC*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::cons::HebrewC());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace cons { 

//-------------------------------------------------
// Implementation of class HebrewZ
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::cons::HebrewZ::HebrewZ() {
}
com::wilutions::byps::test::api::cons::HebrewZ::HebrewZ(::std::wstring core)
	: core(core)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::cons::HebrewZ::serialize(BIO& ar, const BVERSION version) {
	ar & core;
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1518668429(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::cons::HebrewZ& r = * dynamic_cast< com::wilutions::byps::test::api::cons::HebrewZ*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::cons::HebrewZ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2092671091(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< com::wilutions::byps::test::api::cons::PHebrewZ > & r = * reinterpret_cast< BArray1< com::wilutions::byps::test::api::cons::PHebrewZ > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< com::wilutions::byps::test::api::cons::PHebrewZ > ());
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace enu { 

void operator & (BIO& ar, EnumPlanets& e) {
	int32_t v = static_cast<int32_t>(e);
	ar & v;
	if (ar.is_loading) e = static_cast<EnumPlanets>(v);
}

}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1092048313(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< com::wilutions::byps::test::api::enu::EnumPlanets > & r = * reinterpret_cast< BArray1< com::wilutions::byps::test::api::enu::EnumPlanets > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< com::wilutions::byps::test::api::enu::EnumPlanets > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace enu { 

//-------------------------------------------------
// Implementation of class UsePlanets
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::enu::UsePlanets::UsePlanets() {
	planet = com::wilutions::byps::test::api::enu::EnumPlanets::Mercury;
	planet2 = com::wilutions::byps::test::api::enu::EnumPlanets::Mercury;
}
com::wilutions::byps::test::api::enu::UsePlanets::UsePlanets(com::wilutions::byps::test::api::enu::EnumPlanets planet, com::wilutions::byps::test::api::enu::EnumPlanets planet2, byps_ptr< BArray1< com::wilutions::byps::test::api::enu::EnumPlanets > > arrayOfPlanets, byps_ptr< ::std::vector< com::wilutions::byps::test::api::enu::EnumPlanets > > listOfPlanets, byps_ptr< ::std::map< ::std::wstring , com::wilutions::byps::test::api::enu::EnumPlanets > > mapOfPlanets)
	: planet(planet)
	, planet2(planet2)
	, arrayOfPlanets(arrayOfPlanets)
	, listOfPlanets(listOfPlanets)
	, mapOfPlanets(mapOfPlanets)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::enu::UsePlanets::serialize(BIO& ar, const BVERSION version) {
	ar & planet;
	ar & planet2;
	ar & arrayOfPlanets;
	ar & listOfPlanets;
	ar & mapOfPlanets;
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_10000(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::enu::UsePlanets& r = * dynamic_cast< com::wilutions::byps::test::api::enu::UsePlanets*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::enu::UsePlanets());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace inherit { 

//-------------------------------------------------
// Implementation of class Class1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::inherit::Class1::Class1() {
	int1 = 0;
}
com::wilutions::byps::test::api::inherit::Class1::Class1(int32_t int1, com::wilutions::byps::test::api::inherit::PClass1 nextClass1)
	: int1(int1)
	, nextClass1(nextClass1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::inherit::Class1::serialize(BIO& ar, const BVERSION version) {
	ar & int1;
	ar & nextClass1;
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_6001(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::inherit::Class1& r = * dynamic_cast< com::wilutions::byps::test::api::inherit::Class1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::inherit::Class1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace inherit { 

//-------------------------------------------------
// Implementation of class Class1Collections
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::inherit::Class1Collections::Class1Collections() {
}
com::wilutions::byps::test::api::inherit::Class1Collections::Class1Collections(byps_ptr< ::std::vector< com::wilutions::byps::test::api::inherit::PClass1 > > list1, byps_ptr< ::std::map< ::std::wstring , com::wilutions::byps::test::api::inherit::PClass1 > > map1, byps_ptr< ::std::set< com::wilutions::byps::test::api::inherit::PClass1 > > set1)
	: list1(list1)
	, map1(map1)
	, set1(set1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::inherit::Class1Collections::serialize(BIO& ar, const BVERSION version) {
	ar & list1;
	ar & map1;
	ar & set1;
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_6004(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::inherit::Class1Collections& r = * dynamic_cast< com::wilutions::byps::test::api::inherit::Class1Collections*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::inherit::Class1Collections());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace inherit { 

//-------------------------------------------------
// Implementation of class Class2
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::inherit::Class2::Class2() {
	int2 = 0;
}
com::wilutions::byps::test::api::inherit::Class2::Class2(int32_t int2)
	: int2(int2)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::inherit::Class2::serialize(BIO& ar, const BVERSION version) {
	Class1::serialize(ar, version);
	ar & int2;
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_6002(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::inherit::Class2& r = * dynamic_cast< com::wilutions::byps::test::api::inherit::Class2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::inherit::Class2());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace inherit { 

//-------------------------------------------------
// Implementation of class Class3
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::inherit::Class3::Class3() {
	int3 = 0;
}
com::wilutions::byps::test::api::inherit::Class3::Class3(int32_t int3)
	: int3(int3)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::inherit::Class3::serialize(BIO& ar, const BVERSION version) {
	Class2::serialize(ar, version);
	ar & int3;
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_6003(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::inherit::Class3& r = * dynamic_cast< com::wilutions::byps::test::api::inherit::Class3*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::inherit::Class3());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace inl { 

//-------------------------------------------------
// Implementation of class Actor
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::inl::Actor::Actor() {
}
com::wilutions::byps::test::api::inl::Actor::Actor(byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > shape, com::wilutions::byps::test::api::inl::Matrix2D position)
	: shape(shape)
	, position(position)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::inl::Actor::serialize(BIO& ar, const BVERSION version) {
	ar & position;
	ar & shape;
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_171948703(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::inl::Actor& r = * dynamic_cast< com::wilutions::byps::test::api::inl::Actor*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::inl::Actor());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace list { 

//-------------------------------------------------
// Implementation of class ListListTypes
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::list::ListListTypes::ListListTypes() {
}
com::wilutions::byps::test::api::list::ListListTypes::ListListTypes(byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > > int2, byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > > int3, byps_ptr< ::std::vector< byps_ptr< ::std::vector< byps_ptr< BArray4< int32_t > > > > > > int24)
	: int2(int2)
	, int3(int3)
	, int24(int24)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::list::ListListTypes::serialize(BIO& ar, const BVERSION version) {
	ar & int2;
	ar & int24;
	ar & int3;
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_3002(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::list::ListListTypes& r = * dynamic_cast< com::wilutions::byps::test::api::list::ListListTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::list::ListListTypes());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace list { 

//-------------------------------------------------
// Implementation of class ListTypes
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::list::ListTypes::ListTypes() {
}
com::wilutions::byps::test::api::list::ListTypes::ListTypes(byps_ptr< ::std::vector< bool > > boolean1, byps_ptr< ::std::vector< int8_t > > byte1, byps_ptr< ::std::vector< wchar_t > > char1, byps_ptr< ::std::vector< int16_t > > short1, byps_ptr< ::std::vector< int32_t > > int1, byps_ptr< ::std::vector< int64_t > > long1, byps_ptr< ::std::vector< float > > float1, byps_ptr< ::std::vector< double > > double1, byps_ptr< ::std::vector< ::std::wstring > > string1, byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > primitiveTypes1, byps_ptr< ::std::vector< PBytes > > byte2, byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > > int2, byps_ptr< ::std::vector< byps_ptr< BArray4< int32_t > > > > int4, byps_ptr< ::std::vector< PSerializable > > obj1)
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
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::list::ListTypes::serialize(BIO& ar, const BVERSION version) {
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
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_3001(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::list::ListTypes& r = * dynamic_cast< com::wilutions::byps::test::api::list::ListTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::list::ListTypes());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace map { 

//-------------------------------------------------
// Implementation of class MapTypes
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::map::MapTypes::MapTypes() {
}
com::wilutions::byps::test::api::map::MapTypes::MapTypes(byps_ptr< ::std::map< ::std::wstring , bool > > boolean1, byps_ptr< ::std::map< double , int8_t > > byte1, byps_ptr< ::std::map< float , wchar_t > > char1, byps_ptr< ::std::map< int64_t , int16_t > > short1, byps_ptr< ::std::map< int32_t , int32_t > > int1, byps_ptr< ::std::map< int16_t , int64_t > > long1, byps_ptr< ::std::map< wchar_t , float > > float1, byps_ptr< ::std::map< int8_t , double > > double1, byps_ptr< ::std::map< ::std::wstring , ::std::wstring > > string1, byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > > primitiveTypes1, byps_ptr< ::std::map< int32_t , PBytes > > byte2, byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > > int2, byps_ptr< ::std::map< ::std::wstring , PSerializable > > obj1)
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
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::map::MapTypes::serialize(BIO& ar, const BVERSION version) {
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
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_4001(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::map::MapTypes& r = * dynamic_cast< com::wilutions::byps::test::api::map::MapTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::map::MapTypes());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace prim { 

//-------------------------------------------------
// Implementation of class PrimitiveTypes
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::prim::PrimitiveTypes::PrimitiveTypes() {
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
com::wilutions::byps::test::api::prim::PrimitiveTypes::PrimitiveTypes(bool boolVal, int8_t byteVal, wchar_t charVal, int16_t shortVal, int32_t intVal, int64_t longVal, float floatVal, double doubleVal, ::std::wstring stringVal, PSerializable objVal, PSerializable objVal2, bool value, PSerializable temp)
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
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::prim::PrimitiveTypes::serialize(BIO& ar, const BVERSION version) {
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
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1000(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::prim::PrimitiveTypes& r = * dynamic_cast< com::wilutions::byps::test::api::prim::PrimitiveTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::prim::PrimitiveTypes());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_801243127(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > & r = * reinterpret_cast< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1195496149(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray2< com::wilutions::byps::test::api::prim::PPrimitiveTypes > & r = * reinterpret_cast< BArray2< com::wilutions::byps::test::api::prim::PPrimitiveTypes > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray2< com::wilutions::byps::test::api::prim::PPrimitiveTypes > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2115528243(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray3< com::wilutions::byps::test::api::prim::PPrimitiveTypes > & r = * reinterpret_cast< BArray3< com::wilutions::byps::test::api::prim::PPrimitiveTypes > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray3< com::wilutions::byps::test::api::prim::PPrimitiveTypes > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1503107601(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > & r = * reinterpret_cast< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace priv { 

//-------------------------------------------------
// Implementation of class PrivateMembers
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::priv::PrivateMembers::PrivateMembers() {
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
com::wilutions::byps::test::api::priv::PrivateMembers::PrivateMembers(bool boolVal, int8_t byteVal, wchar_t charVal, int16_t shortVal, int32_t intVal, int64_t longVal, float floatVal, double doubleVal, ::std::wstring stringVal, com::wilutions::byps::test::api::prim::PPrimitiveTypes primitiveTypes, byps_ptr< BArray1< bool > > arrBool, byps_ptr< BArray1< int32_t > > arrInt, byps_ptr< BArray1< ::std::wstring > > arrString, byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arrPrimitiveTypes, byps_ptr< ::std::vector< bool > > listBool, byps_ptr< ::std::vector< int32_t > > listInt, byps_ptr< ::std::vector< ::std::wstring > > listString, byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > listPrimitiveTypes, byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< ::std::wstring > > > > mapIntListString, int32_t protInt, int32_t pprotInt)
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
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::priv::PrivateMembers::serialize(BIO& ar, const BVERSION version) {
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
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_8001(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::priv::PrivateMembers& r = * dynamic_cast< com::wilutions::byps::test::api::priv::PrivateMembers*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::priv::PrivateMembers());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace refs { 

//-------------------------------------------------
// Implementation of class Node
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::refs::Node::Node() {
}
com::wilutions::byps::test::api::refs::Node::Node(com::wilutions::byps::test::api::refs::PNode next, com::wilutions::byps::test::api::refs::PNode me, byps_ptr< ::std::map< ::std::wstring , com::wilutions::byps::test::api::refs::PNode > > mapOfNodes, byps_ptr< ::std::vector< com::wilutions::byps::test::api::refs::PNode > > listOfNodes)
	: next(next)
	, me(me)
	, mapOfNodes(mapOfNodes)
	, listOfNodes(listOfNodes)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::refs::Node::serialize(BIO& ar, const BVERSION version) {
	ar & listOfNodes;
	ar & mapOfNodes;
	ar & me;
	ar & next;
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_9001(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::refs::Node& r = * dynamic_cast< com::wilutions::byps::test::api::refs::Node*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::refs::Node());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getBool
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getBool::BRequest_RemoteArrayTypes1dim_getBool() : BMethodRequest(1557084481) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getBool::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getBool::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_getBool([__byps__asyncResult](byps_ptr< BArray1< bool > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2058423690(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1645604187(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getBool& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getBool*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getBool());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getByte
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getByte::BRequest_RemoteArrayTypes1dim_getByte() : BMethodRequest(1557084481) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getByte::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getByte::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_getByte([__byps__asyncResult](PBytes __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1374008726(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1645613945(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getByte& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getByte*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getByte());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getChar
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getChar::BRequest_RemoteArrayTypes1dim_getChar() : BMethodRequest(1557084481) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getChar::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getChar::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_getChar([__byps__asyncResult](byps_ptr< BArray1< wchar_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1361632968(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1645626823(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getChar& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getChar*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getChar());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getDouble
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDouble::BRequest_RemoteArrayTypes1dim_getDouble() : BMethodRequest(1557084481) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDouble::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDouble::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_getDouble([__byps__asyncResult](byps_ptr< BArray1< double > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1359468275(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_935089666(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDouble& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDouble*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDouble());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getFloat
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getFloat::BRequest_RemoteArrayTypes1dim_getFloat() : BMethodRequest(1557084481) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getFloat::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getFloat::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_getFloat([__byps__asyncResult](byps_ptr< BArray1< float > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_766441794(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_522273269(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getFloat& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getFloat*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getFloat());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getInt
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getInt::BRequest_RemoteArrayTypes1dim_getInt() : BMethodRequest(1557084481) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getInt::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getInt::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_getInt([__byps__asyncResult](byps_ptr< BArray1< int32_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_100361105(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1609477282(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getInt& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getInt*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getInt());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getLong
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getLong::BRequest_RemoteArrayTypes1dim_getLong() : BMethodRequest(1557084481) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getLong::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getLong::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_getLong([__byps__asyncResult](byps_ptr< BArray1< int64_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1097129250(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1645902061(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getLong& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getLong*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getLong());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getObject
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getObject::BRequest_RemoteArrayTypes1dim_getObject() : BMethodRequest(1557084481) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getObject::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getObject::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_getObject([__byps__asyncResult](byps_ptr< BArray1< PSerializable > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_183594037(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1237679472(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getObject& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getObject*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getObject());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getPrimitiveTypes
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes() : BMethodRequest(1557084481) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_getPrimitiveTypes([__byps__asyncResult](byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_801243127(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_825201405(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getShort
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort::BRequest_RemoteArrayTypes1dim_getShort() : BMethodRequest(1557084481) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_getShort([__byps__asyncResult](byps_ptr< BArray1< int16_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2067161310(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_510386133(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getString
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString::BRequest_RemoteArrayTypes1dim_getString() : BMethodRequest(1557084481) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_getString([__byps__asyncResult](byps_ptr< BArray1< ::std::wstring > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1888107655(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1369061954(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString());
	}
}
}}}}}
