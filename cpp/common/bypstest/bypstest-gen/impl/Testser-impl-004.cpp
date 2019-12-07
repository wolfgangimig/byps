#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setLong
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setLong::BRequest_RemoteArrayTypes1dim_setLong() : BMethodRequest(123123) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setLong::BRequest_RemoteArrayTypes1dim_setLong(const PArrayLong& v)
	: BMethodRequest(123123) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setLong::BSerializable_getTypeId() {
	return 201143198; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_setLong::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setLong::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->setLong(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_201143198(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setLong>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setObject
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setObject::BRequest_RemoteArrayTypes1dim_setObject() : BMethodRequest(123123) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setObject::BRequest_RemoteArrayTypes1dim_setObject(const byps::PArrayObject& v)
	: BMethodRequest(123123) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setObject::BSerializable_getTypeId() {
	return 48678821; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_setObject::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setObject::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->setObject(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_48678821(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setObject>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setPrimitiveTypes
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setPrimitiveTypes::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes() : BMethodRequest(123123) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes(const byps::test::api::prim::PArrayPrimitiveTypes& v)
	: BMethodRequest(123123) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes::BSerializable_getTypeId() {
	return 1362276920; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_setPrimitiveTypes::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->setPrimitiveTypes(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_1362276920(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setShort
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setShort::BRequest_RemoteArrayTypes1dim_setShort() : BMethodRequest(123123) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setShort::BRequest_RemoteArrayTypes1dim_setShort(const PArrayShort& v)
	: BMethodRequest(123123) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setShort::BSerializable_getTypeId() {
	return 1934214314; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_setShort::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setShort::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->setShort(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_1934214314(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setShort>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setString
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setString::BRequest_RemoteArrayTypes1dim_setString() : BMethodRequest(123123) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setString::BRequest_RemoteArrayTypes1dim_setString(const PArrayString& v)
	: BMethodRequest(123123) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setString::BSerializable_getTypeId() {
	return 180061303; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes1dim_setString::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setString::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->setString(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_180061303(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setString>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes23_sendArraysClass
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes23_sendArraysClass::BRequest_RemoteArrayTypes23_sendArraysClass() : BMethodRequest(769717182) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysClass::BRequest_RemoteArrayTypes23_sendArraysClass(const byps::test::api::prim::PArray2PrimitiveTypes& arr2, const byps::test::api::prim::PArray3PrimitiveTypes& arr3, const byps::test::api::prim::PArray4PrimitiveTypes& arr4)
	: BMethodRequest(769717182) 
	, arr2(arr2)
	, arr3(arr3)
	, arr4(arr4)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysClass::BSerializable_getTypeId() {
	return 330036060; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes23_sendArraysClass::serialize(BIO& ar, const BVERSION version) {
	ar & this->arr2;
	ar & this->arr3;
	ar & this->arr4;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysClass::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes23 __byps__remoteT = byps_ptr_cast<RemoteArrayTypes23>(__byps__remote);
	__byps__remoteT->sendArraysClass(arr2, arr3, arr4, [__byps__asyncResult](byps::test::api::prim::PArrayPrimitiveTypes __byps__result, const BException& __byps__ex) {
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
void BSerializer_330036060(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysClass>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes23_sendArraysInline
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes23_sendArraysInline::BRequest_RemoteArrayTypes23_sendArraysInline() : BMethodRequest(769717182) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInline::BRequest_RemoteArrayTypes23_sendArraysInline(const byps::test::api::inl::PArray2Point2D& arr2, const byps::test::api::inl::PArray3Point2D& arr3, const byps::test::api::inl::PArray4Point2D& arr4)
	: BMethodRequest(769717182) 
	, arr2(arr2)
	, arr3(arr3)
	, arr4(arr4)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInline::BSerializable_getTypeId() {
	return 1467243283; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes23_sendArraysInline::serialize(BIO& ar, const BVERSION version) {
	ar & this->arr2;
	ar & this->arr3;
	ar & this->arr4;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInline::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes23 __byps__remoteT = byps_ptr_cast<RemoteArrayTypes23>(__byps__remote);
	__byps__remoteT->sendArraysInline(arr2, arr3, arr4, [__byps__asyncResult](byps::test::api::inl::PArrayPoint2D __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_184101377(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1467243283(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInline>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes23_sendArraysInt
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes23_sendArraysInt::BRequest_RemoteArrayTypes23_sendArraysInt() : BMethodRequest(769717182) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInt::BRequest_RemoteArrayTypes23_sendArraysInt(const PArray2Int& arr2, const PArray3Int& arr3, const PArray4Int& arr4)
	: BMethodRequest(769717182) 
	, arr2(arr2)
	, arr3(arr3)
	, arr4(arr4)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInt::BSerializable_getTypeId() {
	return 1828268517; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes23_sendArraysInt::serialize(BIO& ar, const BVERSION version) {
	ar & this->arr2;
	ar & this->arr3;
	ar & this->arr4;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInt::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes23 __byps__remoteT = byps_ptr_cast<RemoteArrayTypes23>(__byps__remote);
	__byps__remoteT->sendArraysInt(arr2, arr3, arr4, [__byps__asyncResult](PArrayInt __byps__result, const BException& __byps__ex) {
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
void BSerializer_1828268517(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInt>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes23_sendArraysObject
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes23_sendArraysObject::BRequest_RemoteArrayTypes23_sendArraysObject() : BMethodRequest(769717182) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysObject::BRequest_RemoteArrayTypes23_sendArraysObject(const byps::PArray2Object& arr2, const byps::PArray3Object& arr3, const byps::PArray4Object& arr4)
	: BMethodRequest(769717182) 
	, arr2(arr2)
	, arr3(arr3)
	, arr4(arr4)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysObject::BSerializable_getTypeId() {
	return 1306614381; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes23_sendArraysObject::serialize(BIO& ar, const BVERSION version) {
	ar & this->arr2;
	ar & this->arr3;
	ar & this->arr4;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysObject::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes23 __byps__remoteT = byps_ptr_cast<RemoteArrayTypes23>(__byps__remote);
	__byps__remoteT->sendArraysObject(arr2, arr3, arr4, [__byps__asyncResult](byps::PArrayObject __byps__result, const BException& __byps__ex) {
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
void BSerializer_1306614381(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysObject>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes23_sendArraysString
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes23_sendArraysString::BRequest_RemoteArrayTypes23_sendArraysString() : BMethodRequest(769717182) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysString::BRequest_RemoteArrayTypes23_sendArraysString(const PArray2String& arr2, const PArray3String& arr3, const PArray4String& arr4)
	: BMethodRequest(769717182) 
	, arr2(arr2)
	, arr3(arr3)
	, arr4(arr4)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysString::BSerializable_getTypeId() {
	return 1175231899; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes23_sendArraysString::serialize(BIO& ar, const BVERSION version) {
	ar & this->arr2;
	ar & this->arr3;
	ar & this->arr4;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysString::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes23 __byps__remoteT = byps_ptr_cast<RemoteArrayTypes23>(__byps__remote);
	__byps__remoteT->sendArraysString(arr2, arr3, arr4, [__byps__asyncResult](PArrayString __byps__result, const BException& __byps__ex) {
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
void BSerializer_1175231899(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysString>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getBool
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_getBool::BRequest_RemoteArrayTypes4dim_getBool() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getBool::BSerializable_getTypeId() {
	return 1874302495; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes4dim_getBool::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getBool::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getBool([__byps__asyncResult](PArray4Boolean __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_945713488(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1874302495(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getBool>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getByte
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_getByte::BRequest_RemoteArrayTypes4dim_getByte() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getByte::BSerializable_getTypeId() {
	return 1874292737; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes4dim_getByte::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getByte::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getByte([__byps__asyncResult](PArray4Byte __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1201775504(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1874292737(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getByte>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getChar
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_getChar::BRequest_RemoteArrayTypes4dim_getChar() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getChar::BSerializable_getTypeId() {
	return 1874279859; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes4dim_getChar::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getChar::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getChar([__byps__asyncResult](PArray4Char __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_769021986(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1874279859(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getChar>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getDate
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_getDate::BRequest_RemoteArrayTypes4dim_getDate() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDate::BSerializable_getTypeId() {
	return 1874256219; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes4dim_getDate::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDate::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getDate([__byps__asyncResult](PArray4Date __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_51898890(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1874256219(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDate>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getDouble
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_getDouble::BRequest_RemoteArrayTypes4dim_getDouble() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDouble::BSerializable_getTypeId() {
	return 1555969784; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes4dim_getDouble::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDouble::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getDouble([__byps__asyncResult](PArray4Double __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2087445849(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1555969784(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDouble>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getFloat
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_getFloat::BRequest_RemoteArrayTypes4dim_getFloat() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getFloat::BSerializable_getTypeId() {
	return 2029769285; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes4dim_getFloat::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getFloat::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getFloat([__byps__asyncResult](PArray4Float __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1516687588(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2029769285(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getFloat>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getInt
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_getInt::BRequest_RemoteArrayTypes4dim_getInt() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getInt::BSerializable_getTypeId() {
	return 1325018648; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes4dim_getInt::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getInt::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getInt([__byps__asyncResult](PArray4Int __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_39910537(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1325018648(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getInt>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getLong
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_getLong::BRequest_RemoteArrayTypes4dim_getLong() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getLong::BSerializable_getTypeId() {
	return 1874004621; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes4dim_getLong::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getLong::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getLong([__byps__asyncResult](PArray4Long __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_846419204(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1874004621(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getLong>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getObject
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_getObject::BRequest_RemoteArrayTypes4dim_getObject() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getObject::BSerializable_getTypeId() {
	return 1253379978; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes4dim_getObject::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getObject::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getObject([__byps__asyncResult](byps::PArray4Object __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_124584219(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1253379978(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getObject>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getPrimitiveTypes
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_getPrimitiveTypes::BRequest_RemoteArrayTypes4dim_getPrimitiveTypes() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getPrimitiveTypes::BSerializable_getTypeId() {
	return 483228169; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes4dim_getPrimitiveTypes::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getPrimitiveTypes::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getPrimitiveTypes([__byps__asyncResult](byps::test::api::prim::PArray4PrimitiveTypes __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_758319514(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_483228169(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getPrimitiveTypes>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getShort
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_getShort::BRequest_RemoteArrayTypes4dim_getShort() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getShort::BSerializable_getTypeId() {
	return 2041656421; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes4dim_getShort::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getShort::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getShort([__byps__asyncResult](PArray4Short __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1859644668(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2041656421(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getShort>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getString
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_getString::BRequest_RemoteArrayTypes4dim_getString() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getString::BSerializable_getTypeId() {
	return 1121997496; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes4dim_getString::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getString::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getString([__byps__asyncResult](PArray4String __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_588723219(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1121997496(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getString>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setBool
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_setBool::BRequest_RemoteArrayTypes4dim_setBool() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setBool::BRequest_RemoteArrayTypes4dim_setBool(const PArray4Boolean& v)
	: BMethodRequest(963726955) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setBool::BSerializable_getTypeId() {
	return 185807085; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes4dim_setBool::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setBool::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
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
void BSerializer_185807085(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setBool>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setByte
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_setByte::BRequest_RemoteArrayTypes4dim_setByte() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setByte::BRequest_RemoteArrayTypes4dim_setByte(const PArray4Byte& v)
	: BMethodRequest(963726955) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setByte::BSerializable_getTypeId() {
	return 185816843; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes4dim_setByte::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setByte::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
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
void BSerializer_185816843(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setByte>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setChar
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_setChar::BRequest_RemoteArrayTypes4dim_setChar() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setChar::BRequest_RemoteArrayTypes4dim_setChar(const PArray4Char& v)
	: BMethodRequest(963726955) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setChar::BSerializable_getTypeId() {
	return 185829721; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes4dim_setChar::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setChar::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
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
void BSerializer_185829721(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setChar>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setDate
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_setDate::BRequest_RemoteArrayTypes4dim_setDate() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDate::BRequest_RemoteArrayTypes4dim_setDate(const PArray4Date& v)
	: BMethodRequest(963726955) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDate::BSerializable_getTypeId() {
	return 185853361; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes4dim_setDate::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDate::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
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
void BSerializer_185853361(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDate>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setDouble
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_setDouble::BRequest_RemoteArrayTypes4dim_setDouble() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDouble::BRequest_RemoteArrayTypes4dim_setDouble(const PArray4Double& v)
	: BMethodRequest(963726955) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDouble::BSerializable_getTypeId() {
	return 1770586860; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes4dim_setDouble::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDouble::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setDouble(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_1770586860(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDouble>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setFloat
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_setFloat::BRequest_RemoteArrayTypes4dim_setFloat() : BMethodRequest(963726955) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setFloat::BRequest_RemoteArrayTypes4dim_setFloat(const PArray4Float& v)
	: BMethodRequest(963726955) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setFloat::BSerializable_getTypeId() {
	return 1468656825; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteArrayTypes4dim_setFloat::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setFloat::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setFloat(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_1468656825(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setFloat>(bio, pObj, pObjS, pBase);	
}
}}}
