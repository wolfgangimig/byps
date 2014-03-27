#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

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

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_363642571(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::inherit::BStub_BioFruitService(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}



namespace byps { namespace test { namespace api { namespace inherit { 
BStub_LemonService::BStub_LemonService(PTransport transport) 
	: BStub(transport) {}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_LemonService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_LemonService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_LemonService::pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree)  {
	BSyncResultT< ::std::wstring > syncResult;	
	pick(sess, fromTree, [&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_LemonService::pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree, ::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_LemonService_pick(sess, fromTree));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_LemonService::squeeze()  {
	BSyncResultT< ::std::wstring > syncResult;	
	squeeze([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_LemonService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_FruitService_squeeze());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_605543968(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::inherit::BStub_LemonService(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}



namespace byps { namespace test { namespace api { namespace inherit { 
BStub_BioLemonService::BStub_BioLemonService(PTransport transport) 
	: BStub(transport) {}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
bool BStub_BioLemonService::certify(const ::std::wstring& param)  {
	BSyncResultT< bool > syncResult;	
	certify(param, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::certify(const ::std::wstring& param, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_BioFruitService_certify(param));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_1 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_BioLemonService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_BioLemonService::squeeze()  {
	BSyncResultT< ::std::wstring > syncResult;	
	squeeze([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_FruitService_squeeze());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_BioLemonService::pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree)  {
	BSyncResultT< ::std::wstring > syncResult;	
	pick(sess, fromTree, [&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree, ::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_LemonService_pick(sess, fromTree));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
int32_t BStub_BioLemonService::useParing()  {
	BSyncResultT< int32_t > syncResult;	
	useParing([&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::useParing(::std::function< void (int32_t, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_BioLemonService_useParing());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, byps::test::api::BResult_5 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_474058508(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::inherit::BStub_BioLemonService(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}

