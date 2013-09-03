#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace inl { 

//-------------------------------------------------
// Implementation of class Matrix2D
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::inl::Matrix2D::Matrix2D() {
	_11 = 0;
	_12 = 0;
	_13 = 0;
	_21 = 0;
	_22 = 0;
	_23 = 0;
	_31 = 0;
	_32 = 0;
	_33 = 0;
}
com::wilutions::byps::test::api::inl::Matrix2D::Matrix2D(float _11, float _12, float _13, float _21, float _22, float _23, float _31, float _32, float _33)
	: _11(_11)
	, _12(_12)
	, _13(_13)
	, _21(_21)
	, _22(_22)
	, _23(_23)
	, _31(_31)
	, _32(_32)
	, _33(_33)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::inl::Matrix2D::serialize(BIO& ar, const BVERSION version) {
	ar & _11;
	ar & _12;
	ar & _13;
	ar & _21;
	ar & _22;
	ar & _23;
	ar & _31;
	ar & _32;
	ar & _33;
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_135329019(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		com::wilutions::byps::test::api::inl::Matrix2D& r = * reinterpret_cast< com::wilutions::byps::test::api::inl::Matrix2D*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new com::wilutions::byps::test::api::inl::Matrix2D());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace inl { 

//-------------------------------------------------
// Implementation of class Point2D
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::inl::Point2D::Point2D() {
	x = 0;
	y = 0;
}
com::wilutions::byps::test::api::inl::Point2D::Point2D(int16_t x, int16_t y)
	: x(x)
	, y(y)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::inl::Point2D::serialize(BIO& ar, const BVERSION version) {
	ar & x;
	ar & y;
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1835035436(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		com::wilutions::byps::test::api::inl::Point2D& r = * reinterpret_cast< com::wilutions::byps::test::api::inl::Point2D*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new com::wilutions::byps::test::api::inl::Point2D());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2049740106(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< com::wilutions::byps::test::api::inl::Point2D > & r = * reinterpret_cast< BArray1< com::wilutions::byps::test::api::inl::Point2D > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< com::wilutions::byps::test::api::inl::Point2D > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1589744084(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray2< com::wilutions::byps::test::api::inl::Point2D > & r = * reinterpret_cast< BArray2< com::wilutions::byps::test::api::inl::Point2D > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray2< com::wilutions::byps::test::api::inl::Point2D > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1264295566(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray3< com::wilutions::byps::test::api::inl::Point2D > & r = * reinterpret_cast< BArray3< com::wilutions::byps::test::api::inl::Point2D > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray3< com::wilutions::byps::test::api::inl::Point2D > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_487702928(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< com::wilutions::byps::test::api::inl::Point2D > & r = * reinterpret_cast< BArray4< com::wilutions::byps::test::api::inl::Point2D > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< com::wilutions::byps::test::api::inl::Point2D > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2058423690(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< bool > & r = * reinterpret_cast< BArray1< bool > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< bool > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_945713488(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< bool > & r = * reinterpret_cast< BArray4< bool > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< bool > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
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
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1201775504(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< int8_t > & r = * reinterpret_cast< BArray4< int8_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< int8_t > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1361632968(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< wchar_t > & r = * reinterpret_cast< BArray1< wchar_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< wchar_t > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_769021986(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< wchar_t > & r = * reinterpret_cast< BArray4< wchar_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< wchar_t > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_148544162(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_10
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_10::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_309901678(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_10& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_10*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_10());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1000
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1000::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1462767598(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1000& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1000*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1000());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_100361105
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_100361105::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_848023142(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_100361105& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_100361105*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_100361105());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1042475995
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1042475995::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2038872493(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1042475995& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1042475995*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1042475995());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1050216688
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1050216688::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2133842068(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1050216688& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1050216688*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1050216688());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1059148284
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1059148284::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1532920911(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1059148284& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1059148284*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1059148284());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1097129250
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1097129250::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1862597051(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1097129250& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1097129250*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1097129250());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1174971318
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1174971318::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_994835305(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1174971318& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1174971318*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1174971318());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1178379224
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1178379224::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1911325389(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1178379224& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1178379224*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1178379224());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_12
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_12::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_309901676(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_12& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_12*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_12());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1201775504
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1201775504::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_541741223(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1201775504& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1201775504*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1201775504());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1218831438
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1218831438::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1151524674(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1218831438& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1218831438*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1218831438());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_124584219
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_124584219::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_647080343(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_124584219& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_124584219*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_124584219());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1279823631
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1279823631::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1602044401(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1279823631& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1279823631*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1279823631());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1280571537
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1280571537::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_429041482(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1280571537& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1280571537*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1280571537());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1320560671
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1320560671::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_190591700(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1320560671& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1320560671*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1320560671());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1347703734
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1347703734::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1350610934(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1347703734& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1347703734*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1347703734());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1359468275
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1359468275::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_493259283(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1359468275& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1359468275*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1359468275());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1361632968
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1361632968::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_514676842(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1361632968& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1361632968*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1361632968());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1365696060
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1365696060::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1253977781(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1365696060& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1365696060*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1365696060());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1374008726
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1374008726::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_578691531(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1374008726& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1374008726*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1374008726());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1391985860
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1391985860::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_509380329(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1391985860& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1391985860*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1391985860());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_14
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_14::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_309901674(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_14& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_14*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_14());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1406124761
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1406124761::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_104448059(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1406124761& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1406124761*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1406124761());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1457164460
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1457164460::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1119760023(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1457164460& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1457164460*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1457164460());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1463615848
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1463615848::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_548882635(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1463615848& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1463615848*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1463615848());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1473575576
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1473575576::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1170836883(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1473575576& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1473575576*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1473575576());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1487265161
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1487265161::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2081879792(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1487265161& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1487265161*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1487265161());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1488550492
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1488550492::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1240765869(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1488550492& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1488550492*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1488550492());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1493282670
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1493282670::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_276437907(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1493282670& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1493282670*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1493282670());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_15
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_15::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_309901673(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_15& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_15*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_15());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1503107601
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1503107601::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_72308967(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1503107601& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1503107601*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1503107601());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1516687588
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1516687588::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_188578332(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1516687588& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1516687588*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1516687588());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1544333227
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1544333227::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_743592613(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1544333227& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1544333227*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1544333227());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1555345627
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1555345627::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1887708350(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1555345627& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1555345627*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1555345627());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_16
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_16::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_309901672(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_16& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_16*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_16());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1617670280
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1617670280::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_732507399(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1617670280& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1617670280*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1617670280());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1628501332
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1628501332::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1862743418(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1628501332& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1628501332*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1628501332());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1633500852
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1633500852::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_831989576(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1633500852& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1633500852*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1633500852());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1633750383
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1633750383::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_770118380(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1633750383& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1633750383*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1633750383());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1661807911
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1661807911::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1587436403(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1661807911& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1661807911*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1661807911());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1710660846
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_1710660846::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_163470910(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_1710660846& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_1710660846*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_1710660846());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_171948703
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_171948703::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1220439445(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_171948703& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_171948703*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_171948703());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_172221196
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::BResult_172221196::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1905478006(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::BResult_172221196& r = * dynamic_cast< com::wilutions::byps::test::api::BResult_172221196*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::BResult_172221196());
	}
}
}}}}}
