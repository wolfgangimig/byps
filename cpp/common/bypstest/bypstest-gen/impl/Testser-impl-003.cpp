#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

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
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::inherit::BRequest_LemonService_pick::BSerializable_getTypeId() {
	return 1022088379; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_LemonService_pick::serialize(BIO& ar, const BVERSION version) {
	ar & this->fromTree;
	ar & this->sess;
}
void byps::test::api::inherit::BRequest_LemonService_pick::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PLemonService __byps__remoteT = byps_ptr_cast<LemonService>(__byps__remote);
	__byps__remoteT->pick(sess, fromTree, [__byps__asyncResult](::std::wstring __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1022088379(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::inherit::BRequest_LemonService_pick>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace inherit { 

//-------------------------------------------------
// Implementation of class BRequest_PlantService_grow
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_PlantService_grow::BRequest_PlantService_grow() : BMethodRequest(1954605928) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::inherit::BRequest_PlantService_grow::BSerializable_getTypeId() {
	return 695716901; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_PlantService_grow::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::inherit::BRequest_PlantService_grow::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PPlantService __byps__remoteT = byps_ptr_cast<PlantService>(__byps__remote);
	__byps__remoteT->grow([__byps__asyncResult](::std::wstring __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_695716901(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::inherit::BRequest_PlantService_grow>(bio, pObj, pObjS, pBase);	
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
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::inherit::Class1::BSerializable_getTypeId() {
	return 6001; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void Class1::serialize(BIO& ar, const BVERSION version) {
	ar & this->int1;
	ar & this->nextClass1;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_6001(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::inherit::Class1>(bio, pObj, pObjS, pBase);	
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
byps::test::api::inherit::Class1Collections::Class1Collections(const PVectorClass1& list1, const PMapStringClass1& map1, const byps_ptr< ::std::set< PClass1 > >& set1)
	: list1(list1)
	, map1(map1)
	, set1(set1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::inherit::Class1Collections::BSerializable_getTypeId() {
	return 6004; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void Class1Collections::serialize(BIO& ar, const BVERSION version) {
	ar & this->list1;
	ar & this->map1;
	ar & this->set1;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_6004(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::inherit::Class1Collections>(bio, pObj, pObjS, pBase);	
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
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::inherit::Class2::BSerializable_getTypeId() {
	return 6002; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void Class2::serialize(BIO& ar, const BVERSION version) {
	Class1::serialize(ar, version);
	ar & this->int2;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_6002(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::inherit::Class2>(bio, pObj, pObjS, pBase);	
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
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::inherit::Class3::BSerializable_getTypeId() {
	return 6003; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void Class3::serialize(BIO& ar, const BVERSION version) {
	Class2::serialize(ar, version);
	ar & this->int3;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_6003(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::inherit::Class3>(bio, pObj, pObjS, pBase);	
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
byps::test::api::inl::Actor::Actor(const PArrayPoint2D& shape, const Matrix2D& position)
	: shape(shape)
	, position(position)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::inl::Actor::BSerializable_getTypeId() {
	return 171948703; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void Actor::serialize(BIO& ar, const BVERSION version) {
	ar & this->position;
	ar & this->shape;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_171948703(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::inl::Actor>(bio, pObj, pObjS, pBase);	
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
byps::test::api::list::ListListTypes::ListListTypes(const byps_ptr< ::std::vector< byps::PVectorInteger > >& int2, const byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > >& int3, const byps_ptr< ::std::vector< byps_ptr< ::std::vector< PArray4Int > > > >& int24)
	: int2(int2)
	, int3(int3)
	, int24(int24)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::list::ListListTypes::BSerializable_getTypeId() {
	return 3002; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void ListListTypes::serialize(BIO& ar, const BVERSION version) {
	ar & this->int2;
	ar & this->int24;
	ar & this->int3;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_3002(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::list::ListListTypes>(bio, pObj, pObjS, pBase);	
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
byps::test::api::list::ListTypes::ListTypes(const byps::PVectorBoolean& boolean1, const byps::PVectorByte& byte1, const byps::PVectorCharacter& char1, const byps::PVectorShort& short1, const byps::PVectorInteger& int1, const byps::PVectorLong& long1, const byps::PVectorFloat& float1, const byps::PVectorDouble& double1, const byps::PVectorString& string1, const byps::PVectorDate& date1, const byps::test::api::prim::PVectorPrimitiveTypes& primitiveTypes1, const byps_ptr< ::std::vector< PBytes > >& byte2, const byps_ptr< ::std::vector< PArrayInt > >& int2, const byps_ptr< ::std::vector< PArray4Int > >& int4, const byps::PVectorObject& obj1)
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
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::list::ListTypes::BSerializable_getTypeId() {
	return 3001; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void ListTypes::serialize(BIO& ar, const BVERSION version) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_3001(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::list::ListTypes>(bio, pObj, pObjS, pBase);	
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
byps::test::api::map::MapTypes::MapTypes(const byps::PMapStringBoolean& boolean1, const byps::PMapDoubleByte& byte1, const byps::PMapFloatCharacter& char1, const byps::PMapLongShort& short1, const byps::PMapIntegerInteger& int1, const byps::PMapShortLong& long1, const byps::PMapCharacterFloat& float1, const byps::PMapByteDouble& double1, const byps::PMapStringString& string1, const byps::test::api::prim::PMapIntegerPrimitiveTypes& primitiveTypes1, const byps_ptr< ::std::map< int32_t , PBytes > >& byte2, const byps_ptr< ::std::map< int32_t , PArrayInt > >& int2, const byps::PMapStringObject& obj1, const byps::PMapStringDate& date1)
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
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::map::MapTypes::BSerializable_getTypeId() {
	return 4001; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void MapTypes::serialize(BIO& ar, const BVERSION version) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_4001(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::map::MapTypes>(bio, pObj, pObjS, pBase);	
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
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::prim::PrimitiveTypes::BSerializable_getTypeId() {
	return 1000; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void PrimitiveTypes::serialize(BIO& ar, const BVERSION version) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1000(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::prim::PrimitiveTypes>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2053507648(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< byps::test::api::prim::PPrimitiveTypes > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2030857950(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray2< byps::test::api::prim::PPrimitiveTypes > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1739334652(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray3< byps::test::api::prim::PPrimitiveTypes > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_758319514(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray4< byps::test::api::prim::PPrimitiveTypes > >(bio, pObj, pObjS, pBase);	
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
byps::test::api::priv::PrivateMembers::PrivateMembers(bool boolVal, int8_t byteVal, wchar_t charVal, int16_t shortVal, int32_t intVal, int64_t longVal, float floatVal, double doubleVal, const ::std::wstring& stringVal, const byps::test::api::prim::PPrimitiveTypes& primitiveTypes, const PArrayBoolean& arrBool, const PArrayInt& arrInt, const PArrayString& arrString, const byps::test::api::prim::PArrayPrimitiveTypes& arrPrimitiveTypes, const byps::PVectorBoolean& listBool, const byps::PVectorInteger& listInt, const byps::PVectorString& listString, const byps::test::api::prim::PVectorPrimitiveTypes& listPrimitiveTypes, const byps_ptr< ::std::map< int32_t , byps::PVectorString > >& mapIntListString, int32_t protInt, int32_t pprotInt)
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
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::priv::PrivateMembers::BSerializable_getTypeId() {
	return 8001; 
}
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
void PrivateMembers::setArrBool(PArrayBoolean v) {
	arrBool = v;
}
void PrivateMembers::setArrInt(PArrayInt v) {
	arrInt = v;
}
void PrivateMembers::setArrString(PArrayString v) {
	arrString = v;
}
void PrivateMembers::setArrPrimitiveTypes(byps::test::api::prim::PArrayPrimitiveTypes v) {
	arrPrimitiveTypes = v;
}
void PrivateMembers::setListBool(byps::PVectorBoolean v) {
	listBool = v;
}
void PrivateMembers::setListInt(byps::PVectorInteger v) {
	listInt = v;
}
void PrivateMembers::setListString(byps::PVectorString v) {
	listString = v;
}
void PrivateMembers::setListPrimitiveTypes(byps::test::api::prim::PVectorPrimitiveTypes v) {
	listPrimitiveTypes = v;
}
void PrivateMembers::setMapIntListString(byps_ptr< ::std::map< int32_t , byps::PVectorString > > v) {
	mapIntListString = v;
}
void PrivateMembers::setProtInt(int32_t v) {
	protInt = v;
}
void PrivateMembers::setPprotInt(int32_t v) {
	pprotInt = v;
}
// checkpoint byps.gen.cpp.GenApiClass:876
void PrivateMembers::serialize(BIO& ar, const BVERSION version) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_8001(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::priv::PrivateMembers>(bio, pObj, pObjS, pBase);	
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
byps::test::api::refs::Node::Node(const PNode& next, const PNode& me, const PMapStringNode& mapOfNodes, const PVectorNode& listOfNodes)
	: next(next)
	, me(me)
	, mapOfNodes(mapOfNodes)
	, listOfNodes(listOfNodes)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::refs::Node::BSerializable_getTypeId() {
	return 9001; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void Node::serialize(BIO& ar, const BVERSION version) {
	ar & this->listOfNodes;
	ar & this->mapOfNodes;
	ar & this->me;
	ar & this->next;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_9001(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::refs::Node>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getBool
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getBool::BRequest_RemoteArrayTypes1dim_getBool() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getBool::BSerializable_getTypeId() {
	return 2033416644; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_getBool::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getBool::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getBool([__byps__asyncResult](PArrayBoolean __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2033416644(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getBool>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getByte
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getByte::BRequest_RemoteArrayTypes1dim_getByte() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getByte::BSerializable_getTypeId() {
	return 2033426402; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_getByte::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getByte::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getByte([__byps__asyncResult](PBytes __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2033426402(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getByte>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getChar
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getChar::BRequest_RemoteArrayTypes1dim_getChar() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getChar::BSerializable_getTypeId() {
	return 2033439280; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_getChar::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getChar::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getChar([__byps__asyncResult](PArrayChar __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2033439280(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getChar>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getDate
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getDate::BRequest_RemoteArrayTypes1dim_getDate() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDate::BSerializable_getTypeId() {
	return 2033462920; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_getDate::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDate::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getDate([__byps__asyncResult](PArrayDate __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2033462920(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDate>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getDouble
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getDouble::BRequest_RemoteArrayTypes1dim_getDouble() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDouble::BSerializable_getTypeId() {
	return 39293909; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_getDouble::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDouble::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getDouble([__byps__asyncResult](PArrayDouble __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_39293909(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDouble>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getFloat
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getFloat::BRequest_RemoteArrayTypes1dim_getFloat() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getFloat::BSerializable_getTypeId() {
	return 1384988990; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_getFloat::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getFloat::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getFloat([__byps__asyncResult](PArrayFloat __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1384988990(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getFloat>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getInt
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getInt::BRequest_RemoteArrayTypes1dim_getInt() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getInt::BSerializable_getTypeId() {
	return 1874061867; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_getInt::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getInt::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getInt([__byps__asyncResult](PArrayInt __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1874061867(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getInt>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getLong
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getLong::BRequest_RemoteArrayTypes1dim_getLong() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getLong::BSerializable_getTypeId() {
	return 2033714518; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_getLong::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getLong::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getLong([__byps__asyncResult](PArrayLong __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2033714518(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getLong>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getObject
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getObject::BRequest_RemoteArrayTypes1dim_getObject() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getObject::BSerializable_getTypeId() {
	return 263295897; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_getObject::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getObject::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getObject([__byps__asyncResult](byps::PArrayObject __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_263295897(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getObject>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getPrimitiveTypes
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getPrimitiveTypes::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes::BSerializable_getTypeId() {
	return 1992537556; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_getPrimitiveTypes::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getPrimitiveTypes([__byps__asyncResult](byps::test::api::prim::PArrayPrimitiveTypes __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1992537556(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getShort
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getShort::BRequest_RemoteArrayTypes1dim_getShort() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort::BSerializable_getTypeId() {
	return 1373101854; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_getShort::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getShort([__byps__asyncResult](PArrayShort __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1373101854(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getString
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getString::BRequest_RemoteArrayTypes1dim_getString() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString::BSerializable_getTypeId() {
	return 394678379; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_getString::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getString([__byps__asyncResult](PArrayString __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_394678379(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setBool
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setBool::BRequest_RemoteArrayTypes1dim_setBool() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool::BRequest_RemoteArrayTypes1dim_setBool(const PArrayBoolean& v)
	: BMethodRequest(963816328) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool::BSerializable_getTypeId() {
	return 201441072; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_setBool::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->setBool(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_201441072(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setByte
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setByte::BRequest_RemoteArrayTypes1dim_setByte() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte::BRequest_RemoteArrayTypes1dim_setByte(const PBytes& v)
	: BMethodRequest(963816328) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte::BSerializable_getTypeId() {
	return 201431314; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_setByte::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->setByte(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_201431314(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setChar
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setChar::BRequest_RemoteArrayTypes1dim_setChar() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setChar::BRequest_RemoteArrayTypes1dim_setChar(const PArrayChar& v)
	: BMethodRequest(963816328) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setChar::BSerializable_getTypeId() {
	return 201418436; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_setChar::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setChar::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_201418436(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setChar>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setDate
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setDate::BRequest_RemoteArrayTypes1dim_setDate() : BMethodRequest(963816328) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDate::BRequest_RemoteArrayTypes1dim_setDate(const PArrayDate& v)
	: BMethodRequest(963816328) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDate::BSerializable_getTypeId() {
	return 201394796; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_setDate::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDate::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
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

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_201394796(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDate>(bio, pObj, pObjS, pBase);	
}
}}}
