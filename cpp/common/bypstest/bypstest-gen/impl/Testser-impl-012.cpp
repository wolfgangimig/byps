#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_setEvolve
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_EvolveIF_setEvolve::BRequest_EvolveIF_setEvolve() : BMethodRequest(15377840) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::ver::BRequest_EvolveIF_setEvolve::BRequest_EvolveIF_setEvolve(const PEvolve& obj)
	: BMethodRequest(15377840) 
	, obj(obj)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::ver::BRequest_EvolveIF_setEvolve::serialize(BIO& ar, const BVERSION version) {
	ar & this->obj;
}
void byps::test::api::ver::BRequest_EvolveIF_setEvolve::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PEvolveIF __byps__remoteT = byps_ptr_cast<EvolveIF>(__byps__remote);
	__byps__remoteT->setEvolve(obj, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1064683365(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::ver::BRequest_EvolveIF_setEvolve& r = * dynamic_cast< byps::test::api::ver::BRequest_EvolveIF_setEvolve*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::ver::BRequest_EvolveIF_setEvolve());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class Evolve
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
Evolve::Evolve() {
	bool1 = false;
	byte1 = 0;
	char1 = '\0';
	short1 = 0;
	int1 = 0;
	long1 = 0;
	float1 = 0;
	double1 = 0;
	bool2 = false;
	byte2 = 0;
	char2 = '\0';
	short2 = 0;
	int2 = 0;
	long2 = 0;
	float2 = 0;
	double2 = 0;
	bool3 = false;
	byte3 = 0;
	char3 = '\0';
	short3 = 0;
	int3 = 0;
	long3 = 0;
	float3 = 0;
	double3 = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::ver::Evolve::Evolve(bool bool1, int8_t byte1, wchar_t char1, int16_t short1, int32_t int1, int64_t long1, float float1, double double1, const PArrayBoolean& bools1, const PBytes& bytes1, const PArrayChar& chars1, const PArrayShort& shorts1, const PArrayInt& ints1, const PArrayLong& longs1, const PArrayFloat& floats1, const PArrayDouble& doubles1, const ::std::wstring& str1, const PSerializable& obj1, const PEvolve2& evo1, const byps::PVectorInteger& list1, const byps::PSetInteger& set1, const byps::PMapIntegerInteger& map1, bool bool2, int8_t byte2, wchar_t char2, int16_t short2, int32_t int2, int64_t long2, float float2, double double2, const PArrayBoolean& bools2, const PBytes& bytes2, const PArrayChar& chars2, const PArrayShort& shorts2, const PArrayInt& ints2, const PArrayLong& longs2, const PArrayFloat& floats2, const PArrayDouble& doubles2, const ::std::wstring& str2, const PSerializable& obj2, const PEvolve2& evo2, const byps::PVectorInteger& list2, const byps::PSetInteger& set2, const byps::PMapIntegerInteger& map2, bool bool3, int8_t byte3, wchar_t char3, int16_t short3, int32_t int3, int64_t long3, float float3, double double3, const PArrayBoolean& bools3, const PBytes& bytes3, const PArrayChar& chars3, const PArrayShort& shorts3, const PArrayInt& ints3, const PArrayLong& longs3, const PArrayFloat& floats3, const PArrayDouble& doubles3, const ::std::wstring& str3, const PSerializable& obj3, const PEvolve2& evo3, const byps::PVectorInteger& list3, const byps::PSetInteger& set3, const byps::PMapIntegerInteger& map3)
	: bool1(bool1)
	, byte1(byte1)
	, char1(char1)
	, short1(short1)
	, int1(int1)
	, long1(long1)
	, float1(float1)
	, double1(double1)
	, bools1(bools1)
	, bytes1(bytes1)
	, chars1(chars1)
	, shorts1(shorts1)
	, ints1(ints1)
	, longs1(longs1)
	, floats1(floats1)
	, doubles1(doubles1)
	, str1(str1)
	, obj1(obj1)
	, evo1(evo1)
	, list1(list1)
	, set1(set1)
	, map1(map1)
	, bool2(bool2)
	, byte2(byte2)
	, char2(char2)
	, short2(short2)
	, int2(int2)
	, long2(long2)
	, float2(float2)
	, double2(double2)
	, bools2(bools2)
	, bytes2(bytes2)
	, chars2(chars2)
	, shorts2(shorts2)
	, ints2(ints2)
	, longs2(longs2)
	, floats2(floats2)
	, doubles2(doubles2)
	, str2(str2)
	, obj2(obj2)
	, evo2(evo2)
	, list2(list2)
	, set2(set2)
	, map2(map2)
	, bool3(bool3)
	, byte3(byte3)
	, char3(char3)
	, short3(short3)
	, int3(int3)
	, long3(long3)
	, float3(float3)
	, double3(double3)
	, bools3(bools3)
	, bytes3(bytes3)
	, chars3(chars3)
	, shorts3(shorts3)
	, ints3(ints3)
	, longs3(longs3)
	, floats3(floats3)
	, doubles3(doubles3)
	, str3(str3)
	, obj3(obj3)
	, evo3(evo3)
	, list3(list3)
	, set3(set3)
	, map3(map3)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::ver::Evolve::serialize(BIO& ar, const BVERSION version) {
	ar & this->bool1;
	ar & this->byte1;
	ar & this->char1;
	ar & this->double1;
	ar & this->float1;
	ar & this->int1;
	ar & this->long1;
	ar & this->short1;
	ar & this->str1;
	if (version >= 2) {
		ar & this->bool2;
		ar & this->byte2;
		ar & this->char2;
		ar & this->double2;
		ar & this->float2;
		ar & this->int2;
		ar & this->long2;
		ar & this->short2;
		ar & this->str2;
		if (version >= 3) {
			ar & this->bool3;
			ar & this->byte3;
			ar & this->char3;
			ar & this->double3;
			ar & this->float3;
			ar & this->int3;
			ar & this->long3;
			ar & this->short3;
			ar & this->str3;
		}
	}
	ar & this->bools1;
	ar & this->bytes1;
	ar & this->chars1;
	ar & this->doubles1;
	ar & this->evo1;
	ar & this->floats1;
	ar & this->ints1;
	ar & this->list1;
	ar & this->longs1;
	ar & this->map1;
	ar & this->obj1;
	ar & this->set1;
	ar & this->shorts1;
	if (version >= 2) {
		ar & this->bools2;
		ar & this->bytes2;
		ar & this->chars2;
		ar & this->doubles2;
		ar & this->evo2;
		ar & this->floats2;
		ar & this->ints2;
		ar & this->list2;
		ar & this->longs2;
		ar & this->map2;
		ar & this->obj2;
		ar & this->set2;
		ar & this->shorts2;
		if (version >= 3) {
			ar & this->bools3;
			ar & this->bytes3;
			ar & this->chars3;
			ar & this->doubles3;
			ar & this->evo3;
			ar & this->floats3;
			ar & this->ints3;
			ar & this->list3;
			ar & this->longs3;
			ar & this->map3;
			ar & this->obj3;
			ar & this->set3;
			ar & this->shorts3;
		}
	}
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1391985860(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::ver::Evolve& r = * dynamic_cast< byps::test::api::ver::Evolve*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::ver::Evolve());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class Evolve2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
Evolve2::Evolve2() {
	n1 = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::ver::Evolve2::Evolve2(int32_t n1)
	: n1(n1)
	{}
void Evolve2::setN1(int32_t v) {
	n1 = v;
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::ver::Evolve2::serialize(BIO& ar, const BVERSION version) {
	ar & this->n1;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_573592593(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::ver::Evolve2& r = * dynamic_cast< byps::test::api::ver::Evolve2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::ver::Evolve2());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:902
namespace byps { namespace test { namespace api { 
void BSerializer_1374008726(BIO& bio, POBJECT& pObj, PSerializable&, void* ){
	PBytes p = byps_static_ptr_cast<BBytes>(pObj);
	if (bio.is_loading) {
		if (p) return;
		bio.serialize(p);
		pObj = p;
	}
	else {
		bio.serialize(p);
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1201775504(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray4< int8_t > & r = * reinterpret_cast< ::byps::BArray4< int8_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray4< int8_t > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1361632968(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray1< wchar_t > & r = * reinterpret_cast< ::byps::BArray1< wchar_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray1< wchar_t > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_769021986(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray4< wchar_t > & r = * reinterpret_cast< ::byps::BArray4< wchar_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray4< wchar_t > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1359468275(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray1< double > & r = * reinterpret_cast< ::byps::BArray1< double > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray1< double > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2087445849(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray4< double > & r = * reinterpret_cast< ::byps::BArray4< double > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray4< double > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_766441794(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray1< float > & r = * reinterpret_cast< ::byps::BArray1< float > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray1< float > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1516687588(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray4< float > & r = * reinterpret_cast< ::byps::BArray4< float > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray4< float > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_100361105(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray1< int32_t > & r = * reinterpret_cast< ::byps::BArray1< int32_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray1< int32_t > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1957744307(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray2< int32_t > & r = * reinterpret_cast< ::byps::BArray2< int32_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray2< int32_t > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_196606293(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray3< int32_t > & r = * reinterpret_cast< ::byps::BArray3< int32_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray3< int32_t > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_39910537(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray4< int32_t > & r = * reinterpret_cast< ::byps::BArray4< int32_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray4< int32_t > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1950626768(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray1< PContentStream > & r = * reinterpret_cast< ::byps::BArray1< PContentStream > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray1< PContentStream > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_183594037(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray1< PSerializable > & r = * reinterpret_cast< ::byps::BArray1< PSerializable > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray1< PSerializable > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_340213335(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray2< PSerializable > & r = * reinterpret_cast< ::byps::BArray2< PSerializable > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray2< PSerializable > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_527503353(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray3< PSerializable > & r = * reinterpret_cast< ::byps::BArray3< PSerializable > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray3< PSerializable > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_124584219(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray4< PSerializable > & r = * reinterpret_cast< ::byps::BArray4< PSerializable > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray4< PSerializable > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1888107655(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray1< ::std::wstring > & r = * reinterpret_cast< ::byps::BArray1< ::std::wstring > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray1< ::std::wstring > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1995260457(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray2< ::std::wstring > & r = * reinterpret_cast< ::byps::BArray2< ::std::wstring > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray2< ::std::wstring > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1889888075(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray3< ::std::wstring > & r = * reinterpret_cast< ::byps::BArray3< ::std::wstring > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray3< ::std::wstring > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_588723219(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray4< ::std::wstring > & r = * reinterpret_cast< ::byps::BArray4< ::std::wstring > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray4< ::std::wstring > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_819140569(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< byps::test::api::enu::EnumPlanets >& r = * reinterpret_cast< ::std::vector< byps::test::api::enu::EnumPlanets >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< byps::test::api::enu::EnumPlanets >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1406664368(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray1< BDateTime > & r = * reinterpret_cast< ::byps::BArray1< BDateTime > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray1< BDateTime > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_51898890(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray4< BDateTime > & r = * reinterpret_cast< ::byps::BArray4< BDateTime > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray4< BDateTime > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1972793385(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< double , int8_t >& r = * reinterpret_cast< ::std::map< double , int8_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< double , int8_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_31512998(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int8_t >& r = * reinterpret_cast< ::std::set< int8_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int8_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_510524840(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< byps::test::api::inherit::PClass1 >& r = * reinterpret_cast< ::std::vector< byps::test::api::inherit::PClass1 >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< byps::test::api::inherit::PClass1 >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2064980445(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< byps::test::api::inl::Point2D >& r = * reinterpret_cast< ::std::vector< byps::test::api::inl::Point2D >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< byps::test::api::inl::Point2D >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1596367810(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< byps::test::api::prim::PPrimitiveTypes >& r = * reinterpret_cast< ::std::vector< byps::test::api::prim::PPrimitiveTypes >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< byps::test::api::prim::PPrimitiveTypes >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1442786648(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< byps::test::api::refs::PNode >& r = * reinterpret_cast< ::std::vector< byps::test::api::refs::PNode >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< byps::test::api::refs::PNode >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1174971318(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< PBytes >& r = * reinterpret_cast< ::std::vector< PBytes >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< PBytes >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1752158699(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< PArrayInt >& r = * reinterpret_cast< ::std::vector< PArrayInt >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< PArrayInt >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1088217157(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< PArray4Int >& r = * reinterpret_cast< ::std::vector< PArray4Int >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< PArray4Int >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1218831438(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< PContentStream >& r = * reinterpret_cast< ::std::vector< PContentStream >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< PContentStream >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1617670280(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< bool >& r = * reinterpret_cast< ::std::vector< bool >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< bool >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1059148284(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< int8_t >& r = * reinterpret_cast< ::std::vector< int8_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< int8_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1661807911(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< wchar_t >& r = * reinterpret_cast< ::std::vector< wchar_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< wchar_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1555345627(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< double >& r = * reinterpret_cast< ::std::vector< double >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< double >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1628501332(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< float >& r = * reinterpret_cast< ::std::vector< float >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< float >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_181681714(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< int32_t >& r = * reinterpret_cast< ::std::vector< int32_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< int32_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1050216688(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< int64_t >& r = * reinterpret_cast< ::std::vector< int64_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< int64_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1997002548(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< int16_t >& r = * reinterpret_cast< ::std::vector< int16_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< int16_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2123584667(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< ::std::wstring >& r = * reinterpret_cast< ::std::vector< ::std::wstring >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< ::std::wstring >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1504867122(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< BDateTime >& r = * reinterpret_cast< ::std::vector< BDateTime >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< BDateTime >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1823330785(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< byps::test::api::inl::PVectorPoint2D >& r = * reinterpret_cast< ::std::vector< byps::test::api::inl::PVectorPoint2D >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< byps::test::api::inl::PVectorPoint2D >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1865834185(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< byps_ptr< ::std::vector< PArray4Int > > >& r = * reinterpret_cast< ::std::vector< byps_ptr< ::std::vector< PArray4Int > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< byps_ptr< ::std::vector< PArray4Int > > >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1746702954(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< byps::PVectorInteger >& r = * reinterpret_cast< ::std::vector< byps::PVectorInteger >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< byps::PVectorInteger >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1633500852(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > >& r = * reinterpret_cast< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_724129228(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< byps::PSetInteger >& r = * reinterpret_cast< ::std::vector< byps::PSetInteger >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< byps::PSetInteger >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1487265161(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int8_t , double >& r = * reinterpret_cast< ::std::map< int8_t , double >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int8_t , double >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_94341197(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< wchar_t , float >& r = * reinterpret_cast< ::std::map< wchar_t , float >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< wchar_t , float >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1358523233(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , byps::test::api::inl::Point2D >& r = * reinterpret_cast< ::std::map< int32_t , byps::test::api::inl::Point2D >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , byps::test::api::inl::Point2D >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1831201218(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , byps::test::api::prim::PPrimitiveTypes >& r = * reinterpret_cast< ::std::map< int32_t , byps::test::api::prim::PPrimitiveTypes >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , byps::test::api::prim::PPrimitiveTypes >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1799280818(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , PBytes >& r = * reinterpret_cast< ::std::map< int32_t , PBytes >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , PBytes >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1633750383(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , PArrayInt >& r = * reinterpret_cast< ::std::map< int32_t , PArrayInt >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , PArrayInt >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_779528402(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , PContentStream >& r = * reinterpret_cast< ::std::map< int32_t , PContentStream >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , PContentStream >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1347703734(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , int32_t >& r = * reinterpret_cast< ::std::map< int32_t , int32_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , int32_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_132175071(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , byps::PVectorString >& r = * reinterpret_cast< ::std::map< int32_t , byps::PVectorString >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , byps::PVectorString >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_49984088(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > >& r = * reinterpret_cast< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_601099730(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int64_t , int16_t >& r = * reinterpret_cast< ::std::map< int64_t , int16_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int64_t , int16_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1973996106(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int16_t , int64_t >& r = * reinterpret_cast< ::std::map< int16_t , int64_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int16_t , int64_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_493795497(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , byps::test::api::enu::EnumPlanets >& r = * reinterpret_cast< ::std::map< ::std::wstring , byps::test::api::enu::EnumPlanets >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , byps::test::api::enu::EnumPlanets >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2058676657(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , byps::test::api::inherit::PClass1 >& r = * reinterpret_cast< ::std::map< ::std::wstring , byps::test::api::inherit::PClass1 >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , byps::test::api::inherit::PClass1 >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2011881553(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , byps::test::api::refs::PNode >& r = * reinterpret_cast< ::std::map< ::std::wstring , byps::test::api::refs::PNode >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , byps::test::api::refs::PNode >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1279823631(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , bool >& r = * reinterpret_cast< ::std::map< ::std::wstring , bool >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , bool >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1488550492(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , PSerializable >& r = * reinterpret_cast< ::std::map< ::std::wstring , PSerializable >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , PSerializable >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1710660846(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , ::std::wstring >& r = * reinterpret_cast< ::std::map< ::std::wstring , ::std::wstring >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , ::std::wstring >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1366799209(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , BDateTime >& r = * reinterpret_cast< ::std::map< ::std::wstring , BDateTime >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , BDateTime >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_484881308(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< byps::test::api::inherit::PClass1 >& r = * reinterpret_cast< ::std::set< byps::test::api::inherit::PClass1 >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< byps::test::api::inherit::PClass1 >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_673917574(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< byps::test::api::prim::PPrimitiveTypes >& r = * reinterpret_cast< ::std::set< byps::test::api::prim::PPrimitiveTypes >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< byps::test::api::prim::PPrimitiveTypes >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2052431866(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< PBytes >& r = * reinterpret_cast< ::std::set< PBytes >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< PBytes >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1406124761(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< PArrayInt >& r = * reinterpret_cast< ::std::set< PArrayInt >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< PArrayInt >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1365696060(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< bool >& r = * reinterpret_cast< ::std::set< bool >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< bool >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1320560671(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< double >& r = * reinterpret_cast< ::std::set< double >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< double >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1898022288(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< float >& r = * reinterpret_cast< ::std::set< float >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< float >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1493282670(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int32_t >& r = * reinterpret_cast< ::std::set< int32_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int32_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1457164460(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int64_t >& r = * reinterpret_cast< ::std::set< int64_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int64_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2028443792(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int16_t >& r = * reinterpret_cast< ::std::set< int16_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int16_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1888799711(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< ::std::wstring >& r = * reinterpret_cast< ::std::set< ::std::wstring >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< ::std::wstring >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1097919350(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< BDateTime >& r = * reinterpret_cast< ::std::set< BDateTime >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< BDateTime >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_8789515(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< float , wchar_t >& r = * reinterpret_cast< ::std::map< float , wchar_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< float , wchar_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_476459792(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , PContentStream >& r = * reinterpret_cast< ::std::map< int32_t , PContentStream >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , PContentStream >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_936607009(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< wchar_t >& r = * reinterpret_cast< ::std::set< wchar_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< wchar_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_855786668(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int32_t >& r = * reinterpret_cast< ::std::set< int32_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int32_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1097129250(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray1< int64_t > & r = * reinterpret_cast< ::byps::BArray1< int64_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray1< int64_t > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_846419204(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray4< int64_t > & r = * reinterpret_cast< ::byps::BArray4< int64_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray4< int64_t > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2067161310(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray1< int16_t > & r = * reinterpret_cast< ::byps::BArray1< int16_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray1< int16_t > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1859644668(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::byps::BArray4< int16_t > & r = * reinterpret_cast< ::byps::BArray4< int16_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::byps::BArray4< int16_t > ());
	}
}
}}}


namespace byps { namespace test { namespace api { namespace inherit { 
BStub_PlantService::BStub_PlantService(PTransport transport) 
	: BStub(transport) {}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_PlantService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_PlantService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_1954605928(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::inherit::BStub_PlantService(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}



namespace byps { namespace test { namespace api { namespace inherit { 
BStub_FruitService::BStub_FruitService(PTransport transport) 
	: BStub(transport) {}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_FruitService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_FruitService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_FruitService::squeeze()  {
	BSyncResultT< ::std::wstring > syncResult;	
	squeeze([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_FruitService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_FruitService_squeeze());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_715959905(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::inherit::BStub_FruitService(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}



namespace byps { namespace test { namespace api { namespace inherit { 
BStub_BioFruitService::BStub_BioFruitService(PTransport transport) 
	: BStub(transport) {}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_BioFruitService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioFruitService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
bool BStub_BioFruitService::certify(const ::std::wstring& param)  {
	BSyncResultT< bool > syncResult;	
	certify(param, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioFruitService::certify(const ::std::wstring& param, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_BioFruitService_certify(param));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_1 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_BioFruitService::squeeze()  {
	BSyncResultT< ::std::wstring > syncResult;	
	squeeze([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioFruitService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_FruitService_squeeze());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

