#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setPrimitiveTypes1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_setPrimitiveTypes1::BRequest_RemoteListTypes_setPrimitiveTypes1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteListTypes_setPrimitiveTypes1::BRequest_RemoteListTypes_setPrimitiveTypes1(const byps::test::api::prim::PVectorPrimitiveTypes& primitiveTypes1)
	: BMethodRequest(1233438138) 
	, primitiveTypes1(primitiveTypes1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_setPrimitiveTypes1::BSerializable_getTypeId() {
	return 759940243; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_setPrimitiveTypes1::serialize(BIO& ar, const BVERSION version) {
	ar & this->primitiveTypes1;
}
void byps::test::api::remote::BRequest_RemoteListTypes_setPrimitiveTypes1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->setPrimitiveTypes1(primitiveTypes1, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_759940243(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_setPrimitiveTypes1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setShort1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_setShort1::BRequest_RemoteListTypes_setShort1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteListTypes_setShort1::BRequest_RemoteListTypes_setShort1(const byps::PVectorShort& short1)
	: BMethodRequest(1233438138) 
	, short1(short1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_setShort1::BSerializable_getTypeId() {
	return 1939453607; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_setShort1::serialize(BIO& ar, const BVERSION version) {
	ar & this->short1;
}
void byps::test::api::remote::BRequest_RemoteListTypes_setShort1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->setShort1(short1, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_1939453607(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_setShort1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setString1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_setString1::BRequest_RemoteListTypes_setString1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteListTypes_setString1::BRequest_RemoteListTypes_setString1(const byps::PVectorString& string1)
	: BMethodRequest(1233438138) 
	, string1(string1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_setString1::BSerializable_getTypeId() {
	return 339567886; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_setString1::serialize(BIO& ar, const BVERSION version) {
	ar & this->string1;
}
void byps::test::api::remote::BRequest_RemoteListTypes_setString1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->setString1(string1, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_339567886(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_setString1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getBoolean1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_getBoolean1::BRequest_RemoteMapTypes_getBoolean1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_getBoolean1::BSerializable_getTypeId() {
	return 885803255; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_getBoolean1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteMapTypes_getBoolean1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getBoolean1([__byps__asyncResult](byps::PMapStringBoolean __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1279823631(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_885803255(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_getBoolean1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getByte1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_getByte1::BRequest_RemoteMapTypes_getByte1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_getByte1::BSerializable_getTypeId() {
	return 124722647; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_getByte1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteMapTypes_getByte1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getByte1([__byps__asyncResult](byps::PMapDoubleByte __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1972793385(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_124722647(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_getByte1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getByte2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_getByte2::BRequest_RemoteMapTypes_getByte2() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_getByte2::BSerializable_getTypeId() {
	return 124722646; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_getByte2::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteMapTypes_getByte2::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getByte2([__byps__asyncResult](byps_ptr< ::std::map< int32_t , PBytes > > __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1799280818(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_124722646(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_getByte2>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getChar1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_getChar1::BRequest_RemoteMapTypes_getChar1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_getChar1::BSerializable_getTypeId() {
	return 124323429; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_getChar1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteMapTypes_getChar1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getChar1([__byps__asyncResult](byps::PMapFloatCharacter __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_8789515(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_124323429(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_getChar1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getDate1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_getDate1::BRequest_RemoteMapTypes_getDate1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_getDate1::BSerializable_getTypeId() {
	return 123590589; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_getDate1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteMapTypes_getDate1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getDate1([__byps__asyncResult](byps::PMapStringDate __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1366799209(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_123590589(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_getDate1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getDouble1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_getDouble1::BRequest_RemoteMapTypes_getDouble1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_getDouble1::BSerializable_getTypeId() {
	return 1890230400; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_getDouble1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteMapTypes_getDouble1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getDouble1([__byps__asyncResult](byps::PMapByteDouble __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1487265161(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1890230400(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_getDouble1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getFloat1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_getFloat1::BRequest_RemoteMapTypes_getFloat1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_getFloat1::BSerializable_getTypeId() {
	return 530925397; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_getFloat1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteMapTypes_getFloat1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getFloat1([__byps__asyncResult](byps::PMapCharacterFloat __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_94341197(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_530925397(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_getFloat1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getInt1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_getInt1::BRequest_RemoteMapTypes_getInt1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_getInt1::BSerializable_getTypeId() {
	return 827458594; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_getInt1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteMapTypes_getInt1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getInt1([__byps__asyncResult](byps::PMapIntegerInteger __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1347703734(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_827458594(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_getInt1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getInt2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_getInt2::BRequest_RemoteMapTypes_getInt2() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_getInt2::BSerializable_getTypeId() {
	return 827458595; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_getInt2::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteMapTypes_getInt2::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getInt2([__byps__asyncResult](byps_ptr< ::std::map< int32_t , PArrayInt > > __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1633750383(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_827458595(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_getInt2>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getLong1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_getLong1::BRequest_RemoteMapTypes_getLong1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_getLong1::BSerializable_getTypeId() {
	return 115791051; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_getLong1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteMapTypes_getLong1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getLong1([__byps__asyncResult](byps::PMapShortLong __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1973996106(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_115791051(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_getLong1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getObj1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_getObj1::BRequest_RemoteMapTypes_getObj1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_getObj1::BSerializable_getTypeId() {
	return 827625498; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_getObj1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteMapTypes_getObj1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getObj1([__byps__asyncResult](byps::PMapStringObject __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1488550492(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_827625498(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_getObj1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getPrimitiveTypes1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_getPrimitiveTypes1::BRequest_RemoteMapTypes_getPrimitiveTypes1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_getPrimitiveTypes1::BSerializable_getTypeId() {
	return 1745799327; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_getPrimitiveTypes1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteMapTypes_getPrimitiveTypes1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getPrimitiveTypes1([__byps__asyncResult](byps::test::api::prim::PMapIntegerPrimitiveTypes __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1831201218(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1745799327(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_getPrimitiveTypes1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getShort1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_getShort1::BRequest_RemoteMapTypes_getShort1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_getShort1::BSerializable_getTypeId() {
	return 899426613; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_getShort1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteMapTypes_getShort1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getShort1([__byps__asyncResult](byps::PMapLongShort __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_601099730(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_899426613(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_getShort1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getString1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_getString1::BRequest_RemoteMapTypes_getString1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_getString1::BSerializable_getTypeId() {
	return 1836497856; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_getString1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteMapTypes_getString1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getString1([__byps__asyncResult](byps::PMapStringString __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1710660846(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1836497856(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_getString1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setBoolean1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setBoolean1::BRequest_RemoteMapTypes_setBoolean1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setBoolean1::BRequest_RemoteMapTypes_setBoolean1(const byps::PMapStringBoolean& boolean1)
	: BMethodRequest(664304990) 
	, boolean1(boolean1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_setBoolean1::BSerializable_getTypeId() {
	return 974383083; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_setBoolean1::serialize(BIO& ar, const BVERSION version) {
	ar & this->boolean1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setBoolean1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->setBoolean1(boolean1, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_974383083(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_setBoolean1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setByte1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setByte1::BRequest_RemoteMapTypes_setByte1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setByte1::BRequest_RemoteMapTypes_setByte1(const byps::PMapDoubleByte& byte1)
	: BMethodRequest(664304990) 
	, byte1(byte1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_setByte1::BSerializable_getTypeId() {
	return 685835107; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_setByte1::serialize(BIO& ar, const BVERSION version) {
	ar & this->byte1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setByte1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->setByte1(byte1, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_685835107(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_setByte1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setByte2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setByte2::BRequest_RemoteMapTypes_setByte2() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setByte2::BRequest_RemoteMapTypes_setByte2(const byps_ptr< ::std::map< int32_t , PBytes > >& byte2)
	: BMethodRequest(664304990) 
	, byte2(byte2)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_setByte2::BSerializable_getTypeId() {
	return 685835106; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_setByte2::serialize(BIO& ar, const BVERSION version) {
	ar & this->byte2;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setByte2::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->setByte2(byte2, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_685835106(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_setByte2>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setChar1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setChar1::BRequest_RemoteMapTypes_setChar1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setChar1::BRequest_RemoteMapTypes_setChar1(const byps::PMapFloatCharacter& char1)
	: BMethodRequest(664304990) 
	, char1(char1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_setChar1::BSerializable_getTypeId() {
	return 685435889; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_setChar1::serialize(BIO& ar, const BVERSION version) {
	ar & this->char1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setChar1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->setChar1(char1, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_685435889(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_setChar1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setDate1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setDate1::BRequest_RemoteMapTypes_setDate1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setDate1::BRequest_RemoteMapTypes_setDate1(const byps::PMapStringDate& obj1)
	: BMethodRequest(664304990) 
	, obj1(obj1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_setDate1::BSerializable_getTypeId() {
	return 684703049; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_setDate1::serialize(BIO& ar, const BVERSION version) {
	ar & this->obj1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setDate1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->setDate1(obj1, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_684703049(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_setDate1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setDouble1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setDouble1::BRequest_RemoteMapTypes_setDouble1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1::BRequest_RemoteMapTypes_setDouble1(const byps::PMapByteDouble& double1)
	: BMethodRequest(664304990) 
	, double1(double1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1::BSerializable_getTypeId() {
	return 467931660; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_setDouble1::serialize(BIO& ar, const BVERSION version) {
	ar & this->double1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->setDouble1(double1, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_467931660(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setFloat1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setFloat1::BRequest_RemoteMapTypes_setFloat1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1::BRequest_RemoteMapTypes_setFloat1(const byps::PMapCharacterFloat& float1)
	: BMethodRequest(664304990) 
	, float1(float1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1::BSerializable_getTypeId() {
	return 316308321; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_setFloat1::serialize(BIO& ar, const BVERSION version) {
	ar & this->float1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->setFloat1(float1, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_316308321(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setInt1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setInt1::BRequest_RemoteMapTypes_setInt1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setInt1::BRequest_RemoteMapTypes_setInt1(const byps::PMapIntegerInteger& int1)
	: BMethodRequest(664304990) 
	, int1(int1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_setInt1::BSerializable_getTypeId() {
	return 1407399122; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_setInt1::serialize(BIO& ar, const BVERSION version) {
	ar & this->int1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setInt1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->setInt1(int1, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_1407399122(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_setInt1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setInt2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setInt2::BRequest_RemoteMapTypes_setInt2() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setInt2::BRequest_RemoteMapTypes_setInt2(const byps_ptr< ::std::map< int32_t , PArrayInt > >& int2)
	: BMethodRequest(664304990) 
	, int2(int2)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_setInt2::BSerializable_getTypeId() {
	return 1407399121; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_setInt2::serialize(BIO& ar, const BVERSION version) {
	ar & this->int2;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setInt2::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->setInt2(int2, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_1407399121(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_setInt2>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setLong1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setLong1::BRequest_RemoteMapTypes_setLong1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setLong1::BRequest_RemoteMapTypes_setLong1(const byps::PMapShortLong& long1)
	: BMethodRequest(664304990) 
	, long1(long1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_setLong1::BSerializable_getTypeId() {
	return 676903511; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_setLong1::serialize(BIO& ar, const BVERSION version) {
	ar & this->long1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setLong1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->setLong1(long1, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_676903511(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_setLong1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setObj1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setObj1::BRequest_RemoteMapTypes_setObj1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setObj1::BRequest_RemoteMapTypes_setObj1(const byps::PMapStringObject& obj1)
	: BMethodRequest(664304990) 
	, obj1(obj1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_setObj1::BSerializable_getTypeId() {
	return 1407232218; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_setObj1::serialize(BIO& ar, const BVERSION version) {
	ar & this->obj1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setObj1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->setObj1(obj1, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_1407232218(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_setObj1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setPrimitiveTypes1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setPrimitiveTypes1::BRequest_RemoteMapTypes_setPrimitiveTypes1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setPrimitiveTypes1::BRequest_RemoteMapTypes_setPrimitiveTypes1(const byps::test::api::prim::PMapIntegerPrimitiveTypes& primitiveTypes1)
	: BMethodRequest(664304990) 
	, primitiveTypes1(primitiveTypes1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteMapTypes_setPrimitiveTypes1::BSerializable_getTypeId() {
	return 1629134317; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteMapTypes_setPrimitiveTypes1::serialize(BIO& ar, const BVERSION version) {
	ar & this->primitiveTypes1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setPrimitiveTypes1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->setPrimitiveTypes1(primitiveTypes1, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_1629134317(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteMapTypes_setPrimitiveTypes1>(bio, pObj, pObjS, pBase);	
}
}}}
