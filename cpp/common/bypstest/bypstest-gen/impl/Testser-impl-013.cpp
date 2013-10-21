#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class Evolve2
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::ver::Evolve2::Evolve2() {
	n1 = 0;
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:534
com::wilutions::byps::test::api::ver::Evolve2::Evolve2(int32_t n1)
	: n1(n1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
void com::wilutions::byps::test::api::ver::Evolve2::serialize(BIO& ar, const BVERSION version) {
	ar & n1;
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_573592593(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::ver::Evolve2& r = * dynamic_cast< com::wilutions::byps::test::api::ver::Evolve2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::ver::Evolve2());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1359468275(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< double > & r = * reinterpret_cast< BArray1< double > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< double > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2087445849(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< double > & r = * reinterpret_cast< BArray4< double > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< double > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_766441794(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< float > & r = * reinterpret_cast< BArray1< float > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< float > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1516687588(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< float > & r = * reinterpret_cast< BArray4< float > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< float > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_100361105(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< int32_t > & r = * reinterpret_cast< BArray1< int32_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< int32_t > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1957744307(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray2< int32_t > & r = * reinterpret_cast< BArray2< int32_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray2< int32_t > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_196606293(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray3< int32_t > & r = * reinterpret_cast< BArray3< int32_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray3< int32_t > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_39910537(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< int32_t > & r = * reinterpret_cast< BArray4< int32_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< int32_t > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1950626768(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< PContentStream > & r = * reinterpret_cast< BArray1< PContentStream > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< PContentStream > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_183594037(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< PSerializable > & r = * reinterpret_cast< BArray1< PSerializable > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< PSerializable > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_340213335(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray2< PSerializable > & r = * reinterpret_cast< BArray2< PSerializable > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray2< PSerializable > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_527503353(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray3< PSerializable > & r = * reinterpret_cast< BArray3< PSerializable > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray3< PSerializable > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_124584219(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< PSerializable > & r = * reinterpret_cast< BArray4< PSerializable > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< PSerializable > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1888107655(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< ::std::wstring > & r = * reinterpret_cast< BArray1< ::std::wstring > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< ::std::wstring > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1995260457(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray2< ::std::wstring > & r = * reinterpret_cast< BArray2< ::std::wstring > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray2< ::std::wstring > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1889888075(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray3< ::std::wstring > & r = * reinterpret_cast< BArray3< ::std::wstring > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray3< ::std::wstring > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_588723219(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< ::std::wstring > & r = * reinterpret_cast< BArray4< ::std::wstring > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< ::std::wstring > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1590740862(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< com::wilutions::byps::test::api::enu::EnumPlanets >& r = * reinterpret_cast< ::std::vector< com::wilutions::byps::test::api::enu::EnumPlanets >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< com::wilutions::byps::test::api::enu::EnumPlanets >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1972793385(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< double , int8_t >& r = * reinterpret_cast< ::std::map< double , int8_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< double , int8_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_31512998(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int8_t >& r = * reinterpret_cast< ::std::set< int8_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int8_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1174971318(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< PBytes >& r = * reinterpret_cast< ::std::vector< PBytes >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< PBytes >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_317887457(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< com::wilutions::byps::test::api::inherit::PClass1 >& r = * reinterpret_cast< ::std::vector< com::wilutions::byps::test::api::inherit::PClass1 >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< com::wilutions::byps::test::api::inherit::PClass1 >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_172221196(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< com::wilutions::byps::test::api::inl::Point2D >& r = * reinterpret_cast< ::std::vector< com::wilutions::byps::test::api::inl::Point2D >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< com::wilutions::byps::test::api::inl::Point2D >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1544333227(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes >& r = * reinterpret_cast< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_202657921(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< com::wilutions::byps::test::api::refs::PNode >& r = * reinterpret_cast< ::std::vector< com::wilutions::byps::test::api::refs::PNode >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< com::wilutions::byps::test::api::refs::PNode >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1752158699(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< byps_ptr< BArray1< int32_t > > >& r = * reinterpret_cast< ::std::vector< byps_ptr< BArray1< int32_t > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< byps_ptr< BArray1< int32_t > > >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1088217157(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< byps_ptr< BArray4< int32_t > > >& r = * reinterpret_cast< ::std::vector< byps_ptr< BArray4< int32_t > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< byps_ptr< BArray4< int32_t > > >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1218831438(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< PContentStream >& r = * reinterpret_cast< ::std::vector< PContentStream >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< PContentStream >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1617670280(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< bool >& r = * reinterpret_cast< ::std::vector< bool >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< bool >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1059148284(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< int8_t >& r = * reinterpret_cast< ::std::vector< int8_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< int8_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1661807911(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< wchar_t >& r = * reinterpret_cast< ::std::vector< wchar_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< wchar_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1555345627(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< double >& r = * reinterpret_cast< ::std::vector< double >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< double >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1628501332(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< float >& r = * reinterpret_cast< ::std::vector< float >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< float >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_181681714(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< int32_t >& r = * reinterpret_cast< ::std::vector< int32_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< int32_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1050216688(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< int64_t >& r = * reinterpret_cast< ::std::vector< int64_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< int64_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1997002548(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< int16_t >& r = * reinterpret_cast< ::std::vector< int16_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< int16_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2123584667(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< ::std::wstring >& r = * reinterpret_cast< ::std::vector< ::std::wstring >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< ::std::wstring >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1463615848(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > >& r = * reinterpret_cast< ::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1865834185(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< byps_ptr< ::std::vector< byps_ptr< BArray4< int32_t > > > > >& r = * reinterpret_cast< ::std::vector< byps_ptr< ::std::vector< byps_ptr< BArray4< int32_t > > > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< byps_ptr< ::std::vector< byps_ptr< BArray4< int32_t > > > > >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1746702954(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< byps_ptr< ::std::vector< int32_t > > >& r = * reinterpret_cast< ::std::vector< byps_ptr< ::std::vector< int32_t > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< byps_ptr< ::std::vector< int32_t > > >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1633500852(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > >& r = * reinterpret_cast< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_724129228(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< byps_ptr< ::std::set< int32_t > > >& r = * reinterpret_cast< ::std::vector< byps_ptr< ::std::set< int32_t > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< byps_ptr< ::std::set< int32_t > > >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1487265161(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int8_t , double >& r = * reinterpret_cast< ::std::map< int8_t , double >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int8_t , double >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_94341197(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< wchar_t , float >& r = * reinterpret_cast< ::std::map< wchar_t , float >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< wchar_t , float >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1799280818(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , PBytes >& r = * reinterpret_cast< ::std::map< int32_t , PBytes >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , PBytes >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1851881336(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D >& r = * reinterpret_cast< ::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_703065817(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes >& r = * reinterpret_cast< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1633750383(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , byps_ptr< BArray1< int32_t > > >& r = * reinterpret_cast< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , byps_ptr< BArray1< int32_t > > >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_779528402(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , PContentStream >& r = * reinterpret_cast< ::std::map< int32_t , PContentStream >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , PContentStream >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1347703734(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , int32_t >& r = * reinterpret_cast< ::std::map< int32_t , int32_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , int32_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_132175071(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , byps_ptr< ::std::vector< ::std::wstring > > >& r = * reinterpret_cast< ::std::map< int32_t , byps_ptr< ::std::vector< ::std::wstring > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , byps_ptr< ::std::vector< ::std::wstring > > >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_49984088(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > >& r = * reinterpret_cast< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_601099730(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int64_t , int16_t >& r = * reinterpret_cast< ::std::map< int64_t , int16_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int64_t , int16_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1973996106(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int16_t , int64_t >& r = * reinterpret_cast< ::std::map< int16_t , int64_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int16_t , int64_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_252873856(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , com::wilutions::byps::test::api::enu::EnumPlanets >& r = * reinterpret_cast< ::std::map< ::std::wstring , com::wilutions::byps::test::api::enu::EnumPlanets >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , com::wilutions::byps::test::api::enu::EnumPlanets >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_981592984(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , com::wilutions::byps::test::api::inherit::PClass1 >& r = * reinterpret_cast< ::std::map< ::std::wstring , com::wilutions::byps::test::api::inherit::PClass1 >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , com::wilutions::byps::test::api::inherit::PClass1 >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1768677016(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , com::wilutions::byps::test::api::refs::PNode >& r = * reinterpret_cast< ::std::map< ::std::wstring , com::wilutions::byps::test::api::refs::PNode >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , com::wilutions::byps::test::api::refs::PNode >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1279823631(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , bool >& r = * reinterpret_cast< ::std::map< ::std::wstring , bool >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , bool >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1488550492(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , PSerializable >& r = * reinterpret_cast< ::std::map< ::std::wstring , PSerializable >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , PSerializable >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1710660846(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , ::std::wstring >& r = * reinterpret_cast< ::std::map< ::std::wstring , ::std::wstring >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , ::std::wstring >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2052431866(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< PBytes >& r = * reinterpret_cast< ::std::set< PBytes >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< PBytes >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2114305573(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< com::wilutions::byps::test::api::inherit::PClass1 >& r = * reinterpret_cast< ::std::set< com::wilutions::byps::test::api::inherit::PClass1 >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< com::wilutions::byps::test::api::inherit::PClass1 >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1280571537(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes >& r = * reinterpret_cast< ::std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1406124761(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< byps_ptr< BArray1< int32_t > > >& r = * reinterpret_cast< ::std::set< byps_ptr< BArray1< int32_t > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< byps_ptr< BArray1< int32_t > > >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1365696060(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< bool >& r = * reinterpret_cast< ::std::set< bool >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< bool >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1320560671(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< double >& r = * reinterpret_cast< ::std::set< double >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< double >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1898022288(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< float >& r = * reinterpret_cast< ::std::set< float >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< float >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1493282670(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int32_t >& r = * reinterpret_cast< ::std::set< int32_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int32_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1457164460(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int64_t >& r = * reinterpret_cast< ::std::set< int64_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int64_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2028443792(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int16_t >& r = * reinterpret_cast< ::std::set< int16_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int16_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1888799711(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< ::std::wstring >& r = * reinterpret_cast< ::std::set< ::std::wstring >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< ::std::wstring >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_8789515(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< float , wchar_t >& r = * reinterpret_cast< ::std::map< float , wchar_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< float , wchar_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_476459792(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , PContentStream >& r = * reinterpret_cast< ::std::map< int32_t , PContentStream >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , PContentStream >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_936607009(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< wchar_t >& r = * reinterpret_cast< ::std::set< wchar_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< wchar_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_855786668(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int32_t >& r = * reinterpret_cast< ::std::set< int32_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int32_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1097129250(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< int64_t > & r = * reinterpret_cast< BArray1< int64_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< int64_t > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_846419204(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< int64_t > & r = * reinterpret_cast< BArray4< int64_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< int64_t > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2067161310(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< int16_t > & r = * reinterpret_cast< BArray1< int16_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< int16_t > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1859644668(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< int16_t > & r = * reinterpret_cast< BArray4< int16_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< int16_t > ());
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace inherit { 

BStub_PlantService::BStub_PlantService(PTransport transport) 
	: BStub(transport) {}

::std::wstring BStub_PlantService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_PlantService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, com::wilutions::byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1117460801(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::inherit::BStub_PlantService(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace inherit { 

BStub_FruitService::BStub_FruitService(PTransport transport) 
	: BStub(transport) {}

::std::wstring BStub_FruitService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_FruitService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, com::wilutions::byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
::std::wstring BStub_FruitService::squeeze()  {
	BSyncResultT< ::std::wstring > syncResult;	
	squeeze([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_FruitService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_FruitService_squeeze());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, com::wilutions::byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_506940662(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::inherit::BStub_FruitService(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace inherit { 

::std::wstring BSkeleton_BioFruitService::grow()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_BioFruitService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	::std::wstring ret = ::std::wstring();
	try {
		ret = grow();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
bool BSkeleton_BioFruitService::certify(const ::std::wstring& param)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_BioFruitService::certify(const ::std::wstring& param, ::std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = bool();
	try {
		ret = certify(param);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
::std::wstring BSkeleton_BioFruitService::squeeze()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_BioFruitService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	::std::wstring ret = ::std::wstring();
	try {
		ret = squeeze();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
}}}}}}


namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace inherit { 

BStub_BioFruitService::BStub_BioFruitService(PTransport transport) 
	: BStub(transport) {}

::std::wstring BStub_BioFruitService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioFruitService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, com::wilutions::byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
bool BStub_BioFruitService::certify(const ::std::wstring& param)  {
	BSyncResultT< bool > syncResult;	
	certify(param, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioFruitService::certify(const ::std::wstring& param, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_BioFruitService_certify(param));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_1 >(asyncResult) );
	transport->send(req, outerResult);
}
::std::wstring BStub_BioFruitService::squeeze()  {
	BSyncResultT< ::std::wstring > syncResult;	
	squeeze([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioFruitService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_FruitService_squeeze());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, com::wilutions::byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1881829396(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::inherit::BStub_BioFruitService(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace inherit { 

BStub_LemonService::BStub_LemonService(PTransport transport) 
	: BStub(transport) {}

::std::wstring BStub_LemonService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_LemonService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, com::wilutions::byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
::std::wstring BStub_LemonService::pick(const ::std::wstring& fromTree)  {
	BSyncResultT< ::std::wstring > syncResult;	
	pick(fromTree, [&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_LemonService::pick(const ::std::wstring& fromTree, ::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_LemonService_pick(fromTree));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, com::wilutions::byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
::std::wstring BStub_LemonService::squeeze()  {
	BSyncResultT< ::std::wstring > syncResult;	
	squeeze([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_LemonService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_FruitService_squeeze());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, com::wilutions::byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_617356599(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::inherit::BStub_LemonService(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace inherit { 

::std::wstring BSkeleton_BioLemonService::grow()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_BioLemonService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	::std::wstring ret = ::std::wstring();
	try {
		ret = grow();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
::std::wstring BSkeleton_BioLemonService::pick(const com::wilutions::byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_BioLemonService::pick(const com::wilutions::byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree, ::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	::std::wstring ret = ::std::wstring();
	try {
		ret = pick(sess, fromTree);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
int32_t BSkeleton_BioLemonService::useParing()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_BioLemonService::useParing(::std::function< void (int32_t, BException ex) > asyncResult)  {
	int32_t ret = int32_t();
	try {
		ret = useParing();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
bool BSkeleton_BioLemonService::certify(const ::std::wstring& param)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_BioLemonService::certify(const ::std::wstring& param, ::std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = bool();
	try {
		ret = certify(param);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
::std::wstring BSkeleton_BioLemonService::squeeze()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_BioLemonService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	::std::wstring ret = ::std::wstring();
	try {
		ret = squeeze();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
}}}}}}

