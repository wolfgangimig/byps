#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace inl { 

//-------------------------------------------------
// Implementation of class Matrix2D
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
Matrix2D::Matrix2D() {
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
// checkpoint byps.gen.cpp.GenApiClass:536
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
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::inl::Matrix2D::BSerializable_getTypeId() {
	return 135329019; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void Matrix2D::serialize(BIO& ar, const BVERSION version) {
	ar & this->_11;
	ar & this->_12;
	ar & this->_13;
	ar & this->_21;
	ar & this->_22;
	ar & this->_23;
	ar & this->_31;
	ar & this->_32;
	ar & this->_33;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_135329019(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<byps::test::api::inl::Matrix2D>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace inl { 

//-------------------------------------------------
// Implementation of class Point2D
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
Point2D::Point2D() {
	x = 0;
	y = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::inl::Point2D::Point2D(int16_t x, int16_t y)
	: x(x)
	, y(y)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::inl::Point2D::BSerializable_getTypeId() {
	return 1835035436; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void Point2D::serialize(BIO& ar, const BVERSION version) {
	ar & this->x;
	ar & this->y;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1835035436(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<byps::test::api::inl::Point2D>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_184101377(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< byps::test::api::inl::Point2D > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_827767075(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray2< byps::test::api::inl::Point2D > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_915212229(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray3< byps::test::api::inl::Point2D > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_949340697(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray4< byps::test::api::inl::Point2D > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1441131650(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< byps::test::api::enu::EnumPlanets > >(bio, pObj, pObjS, pBase);	
}
}}}

namespace byps { namespace test { namespace api { namespace enu { 

void operator & (BIO& ar, EnumPlanets& e) {
	int32_t v = static_cast<int32_t>(e);
	ar & v;
	if (ar.is_loading) e = static_cast<EnumPlanets>(v);
}

}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2058423690(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< bool > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_945713488(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray4< bool > >(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1::BSerializable_getTypeId() {
	return 432867947; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_432867947(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_10
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_10::BSerializable_getTypeId() {
	return 534004421; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_10::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_534004421(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_10>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1000
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1000::BSerializable_getTypeId() {
	return 2077138821; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1000::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2077138821(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1000>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_100361105
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_100361105::BSerializable_getTypeId() {
	return 498939805; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_100361105::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_498939805(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_100361105>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1050216688
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1050216688::BSerializable_getTypeId() {
	return 70523627; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1050216688::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_70523627(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1050216688>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1059148284
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1059148284::BSerializable_getTypeId() {
	return 698727944; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1059148284::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_698727944(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1059148284>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1097129250
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1097129250::BSerializable_getTypeId() {
	return 200721390; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1097129250::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_200721390(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1097129250>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1097919350
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1097919350::BSerializable_getTypeId() {
	return 428832038; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1097919350::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_428832038(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1097919350>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1174971318
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1174971318::BSerializable_getTypeId() {
	return 1068483136; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1174971318::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1068483136(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1174971318>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_12
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_12::BSerializable_getTypeId() {
	return 534004419; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_12::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_534004419(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_12>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1201775504
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1201775504::BSerializable_getTypeId() {
	return 1521577218; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1201775504::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1521577218(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1201775504>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1218831438
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1218831438::BSerializable_getTypeId() {
	return 911793767; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1218831438::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_911793767(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1218831438>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_124584219
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_124584219::BSerializable_getTypeId() {
	return 996163680; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_124584219::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_996163680(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_124584219>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1279823631
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1279823631::BSerializable_getTypeId() {
	return 629604454; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1279823631::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_629604454(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1279823631>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1320560671
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1320560671::BSerializable_getTypeId() {
	return 2041057155; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1320560671::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2041057155(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1320560671>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1347703734
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1347703734::BSerializable_getTypeId() {
	return 881037921; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1347703734::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_881037921(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1347703734>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1358523233
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1358523233::BSerializable_getTypeId() {
	return 1693860029; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1358523233::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1693860029(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1358523233>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1359468275
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1359468275::BSerializable_getTypeId() {
	return 1738389572; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1359468275::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1738389572(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1359468275>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1361632968
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1361632968::BSerializable_getTypeId() {
	return 1548641599; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1361632968::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1548641599(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1361632968>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1365696060
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1365696060::BSerializable_getTypeId() {
	return 809340660; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1365696060::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_809340660(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1365696060>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1366799209
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1366799209::BSerializable_getTypeId() {
	return 1725564610; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1366799209::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1725564610(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1366799209>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1374008726
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1374008726::BSerializable_getTypeId() {
	return 1484626910; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1374008726::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1484626910(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1374008726>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1375035164
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1375035164::BSerializable_getTypeId() {
	return 1920161159; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1375035164::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1920161159(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1375035164>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1391985860
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1391985860::BSerializable_getTypeId() {
	return 1722268526; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1391985860::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1722268526(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1391985860>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_14
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_14::BSerializable_getTypeId() {
	return 534004417; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_14::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_534004417(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_14>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1406124761
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1406124761::BSerializable_getTypeId() {
	return 2127200796; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1406124761::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2127200796(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1406124761>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1406664368
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1406664368::BSerializable_getTypeId() {
	return 1980364794; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1406664368::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1980364794(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1406664368>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1457164460
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1457164460::BSerializable_getTypeId() {
	return 1111888832; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1457164460::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1111888832(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1457164460>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1487265161
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1487265161::BSerializable_getTypeId() {
	return 149769063; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1487265161::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_149769063(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1487265161>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1488550492
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1488550492::BSerializable_getTypeId() {
	return 822552572; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1488550492::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_822552572(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1488550492>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1493282670
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1493282670::BSerializable_getTypeId() {
	return 1955210948; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1493282670::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1955210948(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1493282670>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_15
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_15::BSerializable_getTypeId() {
	return 534004416; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_15::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_534004416(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_15>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1504867122
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1504867122::BSerializable_getTypeId() {
	return 1210513700; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1504867122::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1210513700(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1504867122>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1516687588
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1516687588::BSerializable_getTypeId() {
	return 2043070523; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1516687588::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2043070523(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1516687588>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1555345627
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1555345627::BSerializable_getTypeId() {
	return 343940505; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1555345627::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_343940505(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1555345627>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1596367810
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1596367810::BSerializable_getTypeId() {
	return 1073221568; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1596367810::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1073221568(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1596367810>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_16
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_16::BSerializable_getTypeId() {
	return 534004415; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_16::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_534004415(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_16>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1617670280
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1617670280::BSerializable_getTypeId() {
	return 1330811042; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1617670280::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1330811042(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1617670280>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1628501332
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1628501332::BSerializable_getTypeId() {
	return 368905437; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1628501332::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_368905437(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1628501332>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1633500852
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1633500852::BSerializable_getTypeId() {
	return 1231328865; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1633500852::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1231328865(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1633500852>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1633750383
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1633750383::BSerializable_getTypeId() {
	return 1293200061; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1633750383::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1293200061(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1633750383>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1661807911
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1661807911::BSerializable_getTypeId() {
	return 475882038; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1661807911::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_475882038(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1661807911>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_17
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_17::BSerializable_getTypeId() {
	return 534004414; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_17::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_534004414(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_17>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1710660846
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1710660846::BSerializable_getTypeId() {
	return 1899847531; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1710660846::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1899847531(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1710660846>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_171948703
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_171948703::BSerializable_getTypeId() {
	return 871356108; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_171948703::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_871356108(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_171948703>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1746702954
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1746702954::BSerializable_getTypeId() {
	return 408452669; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1746702954::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_408452669(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1746702954>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1752158699
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1752158699::BSerializable_getTypeId() {
	return 1912328929; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1752158699::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1912328929(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1752158699>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1799280818
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1799280818::BSerializable_getTypeId() {
	return 2052610089; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1799280818::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2052610089(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1799280818>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_181681714
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_181681714::BSerializable_getTypeId() {
	return 1763202727; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_181681714::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1763202727(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_181681714>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1823330785
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1823330785::BSerializable_getTypeId() {
	return 114088296; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1823330785::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_114088296(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1823330785>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1831201218
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1831201218::BSerializable_getTypeId() {
	return 50516327; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1831201218::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_50516327(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1831201218>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_183594037
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_183594037::BSerializable_getTypeId() {
	return 15818284; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_183594037::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_15818284(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_183594037>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_184101377
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_184101377::BSerializable_getTypeId() {
	return 748770738; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_184101377::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_748770738(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_184101377>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1859644668
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1859644668::BSerializable_getTypeId() {
	return 2130431383; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1859644668::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2130431383(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1859644668>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1888107655
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1888107655::BSerializable_getTypeId() {
	return 2063745441; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1888107655::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2063745441(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1888107655>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1888799711
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1888799711::BSerializable_getTypeId() {
	return 2051074845; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1888799711::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2051074845(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1888799711>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1898022288
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1898022288::BSerializable_getTypeId() {
	return 515346332; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1898022288::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_515346332(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1898022288>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_19
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_19::BSerializable_getTypeId() {
	return 534004412; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_19::serialize(BIO& ar, const BVERSION version) {
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_534004412(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_19>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { 

//-------------------------------------------------
// Implementation of class BResult_1972793385
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::BResult_1972793385::BSerializable_getTypeId() {
	return 1958357790; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BResult_1972793385::serialize(BIO& ar, const BVERSION version) {
	ar & this->result;
}
}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1958357790(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::BResult_1972793385>(bio, pObj, pObjS, pBase);	
}
}}}
