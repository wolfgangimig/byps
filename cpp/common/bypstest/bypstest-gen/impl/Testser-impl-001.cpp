#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace inl { 

//-------------------------------------------------
// Implementation of class Matrix2D
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::inl::Matrix2D::Matrix2D() {
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
// checkpoint byps.gen.cpp.GenApiClass:534
byps::test::api::inl::Matrix2D::Matrix2D(float _11, float _12, float _13, float _21, float _22, float _23, float _31, float _32, float _33)
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
// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::inl::Matrix2D::serialize(BIO& ar, const BVERSION version) {
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
}}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_135329019(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		byps::test::api::inl::Matrix2D& r = * reinterpret_cast< byps::test::api::inl::Matrix2D*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new byps::test::api::inl::Matrix2D());
	}
}
}
namespace byps { namespace test { namespace api { namespace inl { 

//-------------------------------------------------
// Implementation of class Point2D
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:488
byps::test::api::inl::Point2D::Point2D() {
	x = 0;
	y = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:534
byps::test::api::inl::Point2D::Point2D(int16_t x, int16_t y)
	: x(x)
	, y(y)
	{}
// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::inl::Point2D::serialize(BIO& ar, const BVERSION version) {
	ar & x;
	ar & y;
}
}}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1835035436(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		byps::test::api::inl::Point2D& r = * reinterpret_cast< byps::test::api::inl::Point2D*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new byps::test::api::inl::Point2D());
	}
}
}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_184101377(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< byps::test::api::inl::Point2D > & r = * reinterpret_cast< BArray1< byps::test::api::inl::Point2D > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< byps::test::api::inl::Point2D > ());
	}
}
}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_827767075(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray2< byps::test::api::inl::Point2D > & r = * reinterpret_cast< BArray2< byps::test::api::inl::Point2D > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray2< byps::test::api::inl::Point2D > ());
	}
}
}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_915212229(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray3< byps::test::api::inl::Point2D > & r = * reinterpret_cast< BArray3< byps::test::api::inl::Point2D > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray3< byps::test::api::inl::Point2D > ());
	}
}
}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_949340697(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< byps::test::api::inl::Point2D > & r = * reinterpret_cast< BArray4< byps::test::api::inl::Point2D > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< byps::test::api::inl::Point2D > ());
	}
}
}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_2058423690(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< bool > & r = * reinterpret_cast< BArray1< bool > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< bool > ());
	}
}
}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_945713488(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< bool > & r = * reinterpret_cast< BArray4< bool > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< bool > ());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_432867947(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1& r = * dynamic_cast< byps::test::api::BResult_1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_10
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_10::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_534004421(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_10& r = * dynamic_cast< byps::test::api::BResult_10*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_10());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1000
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1000::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_2077138821(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1000& r = * dynamic_cast< byps::test::api::BResult_1000*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1000());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_100361105
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_100361105::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_498939805(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_100361105& r = * dynamic_cast< byps::test::api::BResult_100361105*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_100361105());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1050216688
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1050216688::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_70523627(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1050216688& r = * dynamic_cast< byps::test::api::BResult_1050216688*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1050216688());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1059148284
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1059148284::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_698727944(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1059148284& r = * dynamic_cast< byps::test::api::BResult_1059148284*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1059148284());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1097129250
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1097129250::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_200721390(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1097129250& r = * dynamic_cast< byps::test::api::BResult_1097129250*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1097129250());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1174971318
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1174971318::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1068483136(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1174971318& r = * dynamic_cast< byps::test::api::BResult_1174971318*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1174971318());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_12
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_12::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_534004419(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_12& r = * dynamic_cast< byps::test::api::BResult_12*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_12());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1201775504
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1201775504::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1521577218(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1201775504& r = * dynamic_cast< byps::test::api::BResult_1201775504*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1201775504());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1218831438
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1218831438::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_911793767(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1218831438& r = * dynamic_cast< byps::test::api::BResult_1218831438*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1218831438());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_124584219
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_124584219::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_996163680(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_124584219& r = * dynamic_cast< byps::test::api::BResult_124584219*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_124584219());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1279823631
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1279823631::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_629604454(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1279823631& r = * dynamic_cast< byps::test::api::BResult_1279823631*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1279823631());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1320560671
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1320560671::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_2041057155(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1320560671& r = * dynamic_cast< byps::test::api::BResult_1320560671*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1320560671());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1347703734
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1347703734::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_881037921(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1347703734& r = * dynamic_cast< byps::test::api::BResult_1347703734*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1347703734());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1358523233
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1358523233::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1693860029(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1358523233& r = * dynamic_cast< byps::test::api::BResult_1358523233*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1358523233());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1359468275
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1359468275::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1738389572(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1359468275& r = * dynamic_cast< byps::test::api::BResult_1359468275*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1359468275());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1361632968
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1361632968::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1548641599(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1361632968& r = * dynamic_cast< byps::test::api::BResult_1361632968*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1361632968());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1365696060
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1365696060::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_809340660(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1365696060& r = * dynamic_cast< byps::test::api::BResult_1365696060*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1365696060());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1374008726
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1374008726::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1484626910(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1374008726& r = * dynamic_cast< byps::test::api::BResult_1374008726*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1374008726());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1375035164
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1375035164::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1920161159(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1375035164& r = * dynamic_cast< byps::test::api::BResult_1375035164*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1375035164());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1391985860
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1391985860::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1722268526(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1391985860& r = * dynamic_cast< byps::test::api::BResult_1391985860*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1391985860());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_14
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_14::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_534004417(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_14& r = * dynamic_cast< byps::test::api::BResult_14*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_14());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1406124761
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1406124761::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_2127200796(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1406124761& r = * dynamic_cast< byps::test::api::BResult_1406124761*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1406124761());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1457164460
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1457164460::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1111888832(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1457164460& r = * dynamic_cast< byps::test::api::BResult_1457164460*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1457164460());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1487265161
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1487265161::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_149769063(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1487265161& r = * dynamic_cast< byps::test::api::BResult_1487265161*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1487265161());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1488550492
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1488550492::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_822552572(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1488550492& r = * dynamic_cast< byps::test::api::BResult_1488550492*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1488550492());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1493282670
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1493282670::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1955210948(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1493282670& r = * dynamic_cast< byps::test::api::BResult_1493282670*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1493282670());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_15
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_15::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_534004416(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_15& r = * dynamic_cast< byps::test::api::BResult_15*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_15());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1516687588
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1516687588::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_2043070523(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1516687588& r = * dynamic_cast< byps::test::api::BResult_1516687588*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1516687588());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1555345627
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1555345627::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_343940505(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1555345627& r = * dynamic_cast< byps::test::api::BResult_1555345627*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1555345627());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1596367810
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1596367810::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1073221568(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1596367810& r = * dynamic_cast< byps::test::api::BResult_1596367810*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1596367810());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_16
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_16::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_534004415(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_16& r = * dynamic_cast< byps::test::api::BResult_16*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_16());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1617670280
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1617670280::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1330811042(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1617670280& r = * dynamic_cast< byps::test::api::BResult_1617670280*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1617670280());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1628501332
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1628501332::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_368905437(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1628501332& r = * dynamic_cast< byps::test::api::BResult_1628501332*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1628501332());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1633500852
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1633500852::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1231328865(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1633500852& r = * dynamic_cast< byps::test::api::BResult_1633500852*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1633500852());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1633750383
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1633750383::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1293200061(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1633750383& r = * dynamic_cast< byps::test::api::BResult_1633750383*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1633750383());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1661807911
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1661807911::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_475882038(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1661807911& r = * dynamic_cast< byps::test::api::BResult_1661807911*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1661807911());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1710660846
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1710660846::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1899847531(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1710660846& r = * dynamic_cast< byps::test::api::BResult_1710660846*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1710660846());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_171948703
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_171948703::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_871356108(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_171948703& r = * dynamic_cast< byps::test::api::BResult_171948703*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_171948703());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1746702954
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1746702954::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_408452669(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1746702954& r = * dynamic_cast< byps::test::api::BResult_1746702954*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1746702954());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1752158699
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1752158699::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1912328929(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1752158699& r = * dynamic_cast< byps::test::api::BResult_1752158699*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1752158699());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1799280818
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1799280818::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_2052610089(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1799280818& r = * dynamic_cast< byps::test::api::BResult_1799280818*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1799280818());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_181681714
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_181681714::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1763202727(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_181681714& r = * dynamic_cast< byps::test::api::BResult_181681714*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_181681714());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1823330785
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1823330785::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_114088296(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1823330785& r = * dynamic_cast< byps::test::api::BResult_1823330785*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1823330785());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1831201218
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1831201218::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_50516327(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1831201218& r = * dynamic_cast< byps::test::api::BResult_1831201218*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1831201218());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_183594037
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_183594037::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_15818284(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_183594037& r = * dynamic_cast< byps::test::api::BResult_183594037*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_183594037());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_184101377
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_184101377::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_748770738(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_184101377& r = * dynamic_cast< byps::test::api::BResult_184101377*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_184101377());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1859644668
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1859644668::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_2130431383(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1859644668& r = * dynamic_cast< byps::test::api::BResult_1859644668*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1859644668());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1888107655
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1888107655::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_2063745441(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1888107655& r = * dynamic_cast< byps::test::api::BResult_1888107655*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1888107655());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1888799711
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1888799711::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_2051074845(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1888799711& r = * dynamic_cast< byps::test::api::BResult_1888799711*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1888799711());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1898022288
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1898022288::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_515346332(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1898022288& r = * dynamic_cast< byps::test::api::BResult_1898022288*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1898022288());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_19
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_19::serialize(BIO& ar, const BVERSION version) {
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_534004412(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_19& r = * dynamic_cast< byps::test::api::BResult_19*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_19());
	}
}
}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1972793385
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:872
void byps::test::api::BResult_1972793385::serialize(BIO& ar, const BVERSION version) {
	ar & result;
}
}

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1958357790(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::BResult_1972793385& r = * dynamic_cast< byps::test::api::BResult_1972793385*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::BResult_1972793385());
	}
}
}
