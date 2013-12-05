#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace cons { 

//-------------------------------------------------
// Implementation of class HebrewC
// Generated from class byps.gen.cpp.GenApiClass

const ::std::wstring HebrewC::aleph = std::wstring(L"\u05d0");

const ::std::wstring HebrewC::beth = std::wstring(L"\u05d1");

const PHebrewZ HebrewC::ALEPH = PHebrewZ(new HebrewZ(
	std::wstring(L"\u05d0")));

const PHebrewZ HebrewC::BETH = PHebrewZ(new HebrewZ(
	std::wstring(L"\u05d1")));

// checkpoint byps.gen.cpp.GenApiClass:489
HebrewC::HebrewC() {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::cons::HebrewC::serialize(BIO& ar, const BVERSION version) {
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1770673942(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::cons::HebrewC& r = * dynamic_cast< byps::test::api::cons::HebrewC*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::cons::HebrewC());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace cons { 

//-------------------------------------------------
// Implementation of class HebrewZ
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
HebrewZ::HebrewZ() {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::cons::HebrewZ::HebrewZ(const ::std::wstring& core)
	: core(core)
	{}
void HebrewZ::setCore(::std::wstring v) {
	core = v;
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::cons::HebrewZ::serialize(BIO& ar, const BVERSION version) {
	ar & this->core;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1518668429(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::cons::HebrewZ& r = * dynamic_cast< byps::test::api::cons::HebrewZ*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::cons::HebrewZ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_92445340(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< byps::test::api::cons::PHebrewZ > & r = * reinterpret_cast< BArray1< byps::test::api::cons::PHebrewZ > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< byps::test::api::cons::PHebrewZ > ());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace enu { 

//-------------------------------------------------
// Implementation of class UsePlanets
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
UsePlanets::UsePlanets() {
	planet = byps::test::api::enu::EnumPlanets::Mercury;
	planet2 = byps::test::api::enu::EnumPlanets::Mercury;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::enu::UsePlanets::UsePlanets(EnumPlanets planet, EnumPlanets planet2, const byps_ptr< BArray1< EnumPlanets > >& arrayOfPlanets, const byps_ptr< ::std::vector< EnumPlanets > >& listOfPlanets, const byps_ptr< ::std::map< ::std::wstring , EnumPlanets > >& mapOfPlanets)
	: planet(planet)
	, planet2(planet2)
	, arrayOfPlanets(arrayOfPlanets)
	, listOfPlanets(listOfPlanets)
	, mapOfPlanets(mapOfPlanets)
	{}
void UsePlanets::setPlanet2(EnumPlanets v) {
	planet2 = v;
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::enu::UsePlanets::serialize(BIO& ar, const BVERSION version) {
	ar & this->planet;
	ar & this->planet2;
	ar & this->arrayOfPlanets;
	ar & this->listOfPlanets;
	ar & this->mapOfPlanets;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_10000(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::enu::UsePlanets& r = * dynamic_cast< byps::test::api::enu::UsePlanets*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::enu::UsePlanets());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace inherit { 

//-------------------------------------------------
// Implementation of class BRequest_BioFruitService_certify
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_BioFruitService_certify::BRequest_BioFruitService_certify() : BMethodRequest(363642571) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::inherit::BRequest_BioFruitService_certify::BRequest_BioFruitService_certify(const ::std::wstring& param)
	: BMethodRequest(363642571) 
	, param(param)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::inherit::BRequest_BioFruitService_certify::serialize(BIO& ar, const BVERSION version) {
	ar & this->param;
}
void byps::test::api::inherit::BRequest_BioFruitService_certify::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PBioFruitService __byps__remoteT = byps_ptr_cast<BioFruitService>(__byps__remote);
	__byps__remoteT->certify(param, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1435417025(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::inherit::BRequest_BioFruitService_certify& r = * dynamic_cast< byps::test::api::inherit::BRequest_BioFruitService_certify*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::inherit::BRequest_BioFruitService_certify());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace inherit { 

//-------------------------------------------------
// Implementation of class BRequest_BioLemonService_useParing
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_BioLemonService_useParing::BRequest_BioLemonService_useParing() : BMethodRequest(474058508) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
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

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_FruitService_squeeze::BRequest_FruitService_squeeze() : BMethodRequest(715959905) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
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

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_LemonService_pick::BRequest_LemonService_pick() : BMethodRequest(605543968) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::inherit::BRequest_LemonService_pick::BRequest_LemonService_pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree)
	: BMethodRequest(605543968) 
	, sess(sess)
	, fromTree(fromTree)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::inherit::BRequest_LemonService_pick::serialize(BIO& ar, const BVERSION version) {
	ar & this->fromTree;
	ar & this->sess;
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

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_PlantService_grow::BRequest_PlantService_grow() : BMethodRequest(1954605928) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
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

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
Class1::Class1() {
	int1 = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::inherit::Class1::Class1(int32_t int1, const PClass1& nextClass1)
	: int1(int1)
	, nextClass1(nextClass1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::inherit::Class1::serialize(BIO& ar, const BVERSION version) {
	ar & this->int1;
	ar & this->nextClass1;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
Class1Collections::Class1Collections() {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::inherit::Class1Collections::Class1Collections(const byps_ptr< ::std::vector< PClass1 > >& list1, const byps_ptr< ::std::map< ::std::wstring , PClass1 > >& map1, const byps_ptr< ::std::set< PClass1 > >& set1)
	: list1(list1)
	, map1(map1)
	, set1(set1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::inherit::Class1Collections::serialize(BIO& ar, const BVERSION version) {
	ar & this->list1;
	ar & this->map1;
	ar & this->set1;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
Class2::Class2() {
	int2 = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::inherit::Class2::Class2(int32_t int2)
	: int2(int2)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::inherit::Class2::serialize(BIO& ar, const BVERSION version) {
	Class1::serialize(ar, version);
	ar & this->int2;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
Class3::Class3() {
	int3 = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::inherit::Class3::Class3(int32_t int3)
	: int3(int3)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::inherit::Class3::serialize(BIO& ar, const BVERSION version) {
	Class2::serialize(ar, version);
	ar & this->int3;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
Actor::Actor() {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::inl::Actor::Actor(const byps_ptr< BArray1< Point2D > >& shape, const Matrix2D& position)
	: shape(shape)
	, position(position)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::inl::Actor::serialize(BIO& ar, const BVERSION version) {
	ar & this->position;
	ar & this->shape;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
ListListTypes::ListListTypes() {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::list::ListListTypes::ListListTypes(const byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > >& int2, const byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > >& int3, const byps_ptr< ::std::vector< byps_ptr< ::std::vector< byps_ptr< BArray4< int32_t > > > > > >& int24)
	: int2(int2)
	, int3(int3)
	, int24(int24)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::list::ListListTypes::serialize(BIO& ar, const BVERSION version) {
	ar & this->int2;
	ar & this->int24;
	ar & this->int3;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
ListTypes::ListTypes() {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::list::ListTypes::ListTypes(const byps_ptr< ::std::vector< bool > >& boolean1, const byps_ptr< ::std::vector< int8_t > >& byte1, const byps_ptr< ::std::vector< wchar_t > >& char1, const byps_ptr< ::std::vector< int16_t > >& short1, const byps_ptr< ::std::vector< int32_t > >& int1, const byps_ptr< ::std::vector< int64_t > >& long1, const byps_ptr< ::std::vector< float > >& float1, const byps_ptr< ::std::vector< double > >& double1, const byps_ptr< ::std::vector< ::std::wstring > >& string1, const byps_ptr< ::std::vector< BDateTime > >& date1, const byps_ptr< ::std::vector< byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1, const byps_ptr< ::std::vector< PBytes > >& byte2, const byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > >& int2, const byps_ptr< ::std::vector< byps_ptr< BArray4< int32_t > > > >& int4, const byps_ptr< ::std::vector< PSerializable > >& obj1)
	: boolean1(boolean1)
	, byte1(byte1)
	, char1(char1)
	, short1(short1)
	, int1(int1)
	, long1(long1)
	, float1(float1)
	, double1(double1)
	, string1(string1)
	, date1(date1)
	, primitiveTypes1(primitiveTypes1)
	, byte2(byte2)
	, int2(int2)
	, int4(int4)
	, obj1(obj1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::list::ListTypes::serialize(BIO& ar, const BVERSION version) {
	ar & this->boolean1;
	ar & this->byte1;
	ar & this->byte2;
	ar & this->char1;
	ar & this->date1;
	ar & this->double1;
	ar & this->float1;
	ar & this->int1;
	ar & this->int2;
	ar & this->int4;
	ar & this->long1;
	ar & this->obj1;
	ar & this->primitiveTypes1;
	ar & this->short1;
	ar & this->string1;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
MapTypes::MapTypes() {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::map::MapTypes::MapTypes(const byps_ptr< ::std::map< ::std::wstring , bool > >& boolean1, const byps_ptr< ::std::map< double , int8_t > >& byte1, const byps_ptr< ::std::map< float , wchar_t > >& char1, const byps_ptr< ::std::map< int64_t , int16_t > >& short1, const byps_ptr< ::std::map< int32_t , int32_t > >& int1, const byps_ptr< ::std::map< int16_t , int64_t > >& long1, const byps_ptr< ::std::map< wchar_t , float > >& float1, const byps_ptr< ::std::map< int8_t , double > >& double1, const byps_ptr< ::std::map< ::std::wstring , ::std::wstring > >& string1, const byps_ptr< ::std::map< int32_t , byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1, const byps_ptr< ::std::map< int32_t , PBytes > >& byte2, const byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > >& int2, const byps_ptr< ::std::map< ::std::wstring , PSerializable > >& obj1, const byps_ptr< ::std::map< ::std::wstring , BDateTime > >& date1)
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
	, date1(date1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::map::MapTypes::serialize(BIO& ar, const BVERSION version) {
	ar & this->boolean1;
	ar & this->byte1;
	ar & this->byte2;
	ar & this->char1;
	ar & this->date1;
	ar & this->double1;
	ar & this->float1;
	ar & this->int1;
	ar & this->int2;
	ar & this->long1;
	ar & this->obj1;
	ar & this->primitiveTypes1;
	ar & this->short1;
	ar & this->string1;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
PrimitiveTypes::PrimitiveTypes() {
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
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::prim::PrimitiveTypes::PrimitiveTypes(bool boolVal, int8_t byteVal, wchar_t charVal, int16_t shortVal, int32_t intVal, int64_t longVal, float floatVal, double doubleVal, const ::std::wstring& stringVal, const BDateTime& dateVal, const PSerializable& objVal, const PSerializable& objVal2, bool value, const PSerializable& temp)
	: boolVal(boolVal)
	, byteVal(byteVal)
	, charVal(charVal)
	, shortVal(shortVal)
	, intVal(intVal)
	, longVal(longVal)
	, floatVal(floatVal)
	, doubleVal(doubleVal)
	, stringVal(stringVal)
	, dateVal(dateVal)
	, objVal(objVal)
	, objVal2(objVal2)
	, value(value)
	, temp(temp)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::prim::PrimitiveTypes::serialize(BIO& ar, const BVERSION version) {
	ar & this->boolVal;
	ar & this->byteVal;
	ar & this->charVal;
	ar & this->dateVal;
	ar & this->doubleVal;
	ar & this->floatVal;
	ar & this->intVal;
	ar & this->longVal;
	ar & this->shortVal;
	ar & this->stringVal;
	ar & this->value;
	ar & this->objVal;
	ar & this->objVal2;
	// skip transient member temp
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
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
// checkpoint byps.gen.cpp.GenApiClass:934
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
// checkpoint byps.gen.cpp.GenApiClass:934
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
// checkpoint byps.gen.cpp.GenApiClass:934
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
// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
PrivateMembers::PrivateMembers() {
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
// checkpoint byps.gen.cpp.GenApiClass:536
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
void PrivateMembers::setBoolVal(bool v) {
	boolVal = v;
}
void PrivateMembers::setByteVal(int8_t v) {
	byteVal = v;
}
void PrivateMembers::setCharVal(wchar_t v) {
	charVal = v;
}
void PrivateMembers::setShortVal(int16_t v) {
	shortVal = v;
}
void PrivateMembers::setIntVal(int32_t v) {
	intVal = v;
}
void PrivateMembers::setLongVal(int64_t v) {
	longVal = v;
}
void PrivateMembers::setFloatVal(float v) {
	floatVal = v;
}
void PrivateMembers::setDoubleVal(double v) {
	doubleVal = v;
}
void PrivateMembers::setStringVal(::std::wstring v) {
	stringVal = v;
}
void PrivateMembers::setPrimitiveTypes(byps::test::api::prim::PPrimitiveTypes v) {
	primitiveTypes = v;
}
void PrivateMembers::setArrBool(byps_ptr< BArray1< bool > > v) {
	arrBool = v;
}
void PrivateMembers::setArrInt(byps_ptr< BArray1< int32_t > > v) {
	arrInt = v;
}
void PrivateMembers::setArrString(byps_ptr< BArray1< ::std::wstring > > v) {
	arrString = v;
}
void PrivateMembers::setArrPrimitiveTypes(byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > > v) {
	arrPrimitiveTypes = v;
}
void PrivateMembers::setListBool(byps_ptr< ::std::vector< bool > > v) {
	listBool = v;
}
void PrivateMembers::setListInt(byps_ptr< ::std::vector< int32_t > > v) {
	listInt = v;
}
void PrivateMembers::setListString(byps_ptr< ::std::vector< ::std::wstring > > v) {
	listString = v;
}
void PrivateMembers::setListPrimitiveTypes(byps_ptr< ::std::vector< byps::test::api::prim::PPrimitiveTypes > > v) {
	listPrimitiveTypes = v;
}
void PrivateMembers::setMapIntListString(byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< ::std::wstring > > > > v) {
	mapIntListString = v;
}
void PrivateMembers::setProtInt(int32_t v) {
	protInt = v;
}
void PrivateMembers::setPprotInt(int32_t v) {
	pprotInt = v;
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::priv::PrivateMembers::serialize(BIO& ar, const BVERSION version) {
	ar & this->boolVal;
	ar & this->byteVal;
	ar & this->charVal;
	ar & this->doubleVal;
	ar & this->floatVal;
	ar & this->intVal;
	ar & this->longVal;
	ar & this->pprotInt;
	ar & this->protInt;
	ar & this->shortVal;
	ar & this->stringVal;
	ar & this->arrBool;
	ar & this->arrInt;
	ar & this->arrPrimitiveTypes;
	ar & this->arrString;
	ar & this->listBool;
	ar & this->listInt;
	ar & this->listPrimitiveTypes;
	ar & this->listString;
	ar & this->mapIntListString;
	ar & this->primitiveTypes;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
Node::Node() {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::refs::Node::Node(const PNode& next, const PNode& me, const byps_ptr< ::std::map< ::std::wstring , PNode > >& mapOfNodes, const byps_ptr< ::std::vector< PNode > >& listOfNodes)
	: next(next)
	, me(me)
	, mapOfNodes(mapOfNodes)
	, listOfNodes(listOfNodes)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::refs::Node::serialize(BIO& ar, const BVERSION version) {
	ar & this->listOfNodes;
	ar & this->mapOfNodes;
	ar & this->me;
	ar & this->next;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getBool::BRequest_RemoteArrayTypes1dim_getBool() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
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

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getByte::BRequest_RemoteArrayTypes1dim_getByte() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
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

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getChar::BRequest_RemoteArrayTypes1dim_getChar() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
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

// checkpoint byps.gen.cpp.GenApiClass:934
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
// Implementation of class BRequest_RemoteArrayTypes1dim_getDate
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getDate::BRequest_RemoteArrayTypes1dim_getDate() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDate::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDate::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getDate([__byps__asyncResult](byps_ptr< BArray1< BDateTime > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1406664368(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2033462920(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDate& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDate*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDate());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getDouble
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getDouble::BRequest_RemoteArrayTypes1dim_getDouble() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
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

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getFloat::BRequest_RemoteArrayTypes1dim_getFloat() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
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

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getInt::BRequest_RemoteArrayTypes1dim_getInt() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
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

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getLong::BRequest_RemoteArrayTypes1dim_getLong() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
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

// checkpoint byps.gen.cpp.GenApiClass:934
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

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getObject::BRequest_RemoteArrayTypes1dim_getObject() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
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

// checkpoint byps.gen.cpp.GenApiClass:934
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
