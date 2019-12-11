#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getBoolean1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getBoolean1::BRequest_RemoteListTypes_getBoolean1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_getBoolean1::BSerializable_getTypeId() {
	return 2058662161; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_getBoolean1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getBoolean1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getBoolean1([__byps__asyncResult](byps::PVectorBoolean __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1617670280(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2058662161(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_getBoolean1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getByte1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getByte1::BRequest_RemoteListTypes_getByte1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_getByte1::BSerializable_getTypeId() {
	return 608486403; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_getByte1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getByte1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getByte1([__byps__asyncResult](byps::PVectorByte __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1059148284(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_608486403(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_getByte1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getByte2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getByte2::BRequest_RemoteListTypes_getByte2() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_getByte2::BSerializable_getTypeId() {
	return 608486404; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_getByte2::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getByte2::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getByte2([__byps__asyncResult](byps_ptr< ::std::vector< PBytes > > __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1174971318(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_608486404(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_getByte2>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getChar1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getChar1::BRequest_RemoteListTypes_getChar1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_getChar1::BSerializable_getTypeId() {
	return 608885621; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_getChar1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getChar1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getChar1([__byps__asyncResult](byps::PVectorCharacter __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1661807911(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_608885621(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_getChar1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getDate1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getDate1::BRequest_RemoteListTypes_getDate1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_getDate1::BSerializable_getTypeId() {
	return 609618461; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_getDate1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getDate1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getDate1([__byps__asyncResult](byps::PVectorDate __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1504867122(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_609618461(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_getDate1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getDouble1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getDouble1::BRequest_RemoteListTypes_getDouble1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_getDouble1::BSerializable_getTypeId() {
	return 2129490906; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_getDouble1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getDouble1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getDouble1([__byps__asyncResult](byps::PVectorDouble __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1555345627(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2129490906(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_getDouble1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getFloat1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getFloat1::BRequest_RemoteListTypes_getFloat1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_getFloat1::BSerializable_getTypeId() {
	return 1785569467; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_getFloat1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getFloat1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getFloat1([__byps__asyncResult](byps::PVectorFloat __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1628501332(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1785569467(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_getFloat1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getInt1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getInt1::BRequest_RemoteListTypes_getInt1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_getInt1::BSerializable_getTypeId() {
	return 2098036488; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_getInt1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getInt1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getInt1([__byps__asyncResult](byps::PVectorInteger __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_181681714(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2098036488(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_getInt1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getInt2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getInt2::BRequest_RemoteListTypes_getInt2() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_getInt2::BSerializable_getTypeId() {
	return 2098036489; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_getInt2::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getInt2::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getInt2([__byps__asyncResult](byps_ptr< ::std::vector< PArrayInt > > __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1752158699(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2098036489(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_getInt2>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getInt3
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getInt3::BRequest_RemoteListTypes_getInt3() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_getInt3::BSerializable_getTypeId() {
	return 2098036490; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_getInt3::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getInt3::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getInt3([__byps__asyncResult](byps_ptr< ::std::vector< byps::PVectorInteger > > __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1746702954(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2098036490(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_getInt3>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getInt4
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getInt4::BRequest_RemoteListTypes_getInt4() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_getInt4::BSerializable_getTypeId() {
	return 2098036491; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_getInt4::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getInt4::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getInt4([__byps__asyncResult](byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > > __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1633500852(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2098036491(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_getInt4>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getLong1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getLong1::BRequest_RemoteListTypes_getLong1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_getLong1::BSerializable_getTypeId() {
	return 617417999; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_getLong1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getLong1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getLong1([__byps__asyncResult](byps::PVectorLong __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1050216688(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_617417999(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_getLong1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getObj1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getObj1::BRequest_RemoteListTypes_getObj1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_getObj1::BSerializable_getTypeId() {
	return 2098203392; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_getObj1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getObj1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getObj1([__byps__asyncResult](byps::PVectorObject __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_12(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2098203392(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_getObj1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getPrimitiveTypes1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getPrimitiveTypes1::BRequest_RemoteListTypes_getPrimitiveTypes1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_getPrimitiveTypes1::BSerializable_getTypeId() {
	return 1679973895; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_getPrimitiveTypes1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getPrimitiveTypes1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getPrimitiveTypes1([__byps__asyncResult](byps::test::api::prim::PVectorPrimitiveTypes __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1596367810(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1679973895(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_getPrimitiveTypes1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getShort1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getShort1::BRequest_RemoteListTypes_getShort1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_getShort1::BSerializable_getTypeId() {
	return 2140896613; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_getShort1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getShort1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getShort1([__byps__asyncResult](byps::PVectorShort __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1997002548(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2140896613(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_getShort1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getString1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getString1::BRequest_RemoteListTypes_getString1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_getString1::BSerializable_getTypeId() {
	return 1597237350; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_getString1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getString1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getString1([__byps__asyncResult](byps::PVectorString __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2123584667(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1597237350(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_getString1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setBoolean1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_setBoolean1::BRequest_RemoteListTypes_setBoolean1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteListTypes_setBoolean1::BRequest_RemoteListTypes_setBoolean1(const byps::PVectorBoolean& boolean1)
	: BMethodRequest(1233438138) 
	, boolean1(boolean1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_setBoolean1::BSerializable_getTypeId() {
	return 2147241989; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_setBoolean1::serialize(BIO& ar, const BVERSION version) {
	ar & this->boolean1;
}
void byps::test::api::remote::BRequest_RemoteListTypes_setBoolean1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_2147241989(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_setBoolean1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setByte1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_setByte1::BRequest_RemoteListTypes_setByte1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteListTypes_setByte1::BRequest_RemoteListTypes_setByte1(const byps::PVectorByte& byte1)
	: BMethodRequest(1233438138) 
	, byte1(byte1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_setByte1::BSerializable_getTypeId() {
	return 47373943; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_setByte1::serialize(BIO& ar, const BVERSION version) {
	ar & this->byte1;
}
void byps::test::api::remote::BRequest_RemoteListTypes_setByte1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_47373943(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_setByte1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setByte2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_setByte2::BRequest_RemoteListTypes_setByte2() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteListTypes_setByte2::BRequest_RemoteListTypes_setByte2(const byps_ptr< ::std::vector< PBytes > >& byte2)
	: BMethodRequest(1233438138) 
	, byte2(byte2)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_setByte2::BSerializable_getTypeId() {
	return 47373944; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_setByte2::serialize(BIO& ar, const BVERSION version) {
	ar & this->byte2;
}
void byps::test::api::remote::BRequest_RemoteListTypes_setByte2::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_47373944(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_setByte2>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setChar1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_setChar1::BRequest_RemoteListTypes_setChar1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteListTypes_setChar1::BRequest_RemoteListTypes_setChar1(const byps::PVectorCharacter& char1)
	: BMethodRequest(1233438138) 
	, char1(char1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_setChar1::BSerializable_getTypeId() {
	return 47773161; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_setChar1::serialize(BIO& ar, const BVERSION version) {
	ar & this->char1;
}
void byps::test::api::remote::BRequest_RemoteListTypes_setChar1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_47773161(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_setChar1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setDate1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_setDate1::BRequest_RemoteListTypes_setDate1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteListTypes_setDate1::BRequest_RemoteListTypes_setDate1(const byps::PVectorDate& obj1)
	: BMethodRequest(1233438138) 
	, obj1(obj1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_setDate1::BSerializable_getTypeId() {
	return 48506001; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_setDate1::serialize(BIO& ar, const BVERSION version) {
	ar & this->obj1;
}
void byps::test::api::remote::BRequest_RemoteListTypes_setDate1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_48506001(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_setDate1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setDouble1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_setDouble1::BRequest_RemoteListTypes_setDouble1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteListTypes_setDouble1::BRequest_RemoteListTypes_setDouble1(const byps::PVectorDouble& double1)
	: BMethodRequest(1233438138) 
	, double1(double1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_setDouble1::BSerializable_getTypeId() {
	return 228671154; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_setDouble1::serialize(BIO& ar, const BVERSION version) {
	ar & this->double1;
}
void byps::test::api::remote::BRequest_RemoteListTypes_setDouble1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_228671154(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_setDouble1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setFloat1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_setFloat1::BRequest_RemoteListTypes_setFloat1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteListTypes_setFloat1::BRequest_RemoteListTypes_setFloat1(const byps::PVectorFloat& float1)
	: BMethodRequest(1233438138) 
	, float1(float1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_setFloat1::BSerializable_getTypeId() {
	return 1570952391; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_setFloat1::serialize(BIO& ar, const BVERSION version) {
	ar & this->float1;
}
void byps::test::api::remote::BRequest_RemoteListTypes_setFloat1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_1570952391(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_setFloat1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setInt1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_setInt1::BRequest_RemoteListTypes_setInt1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteListTypes_setInt1::BRequest_RemoteListTypes_setInt1(const byps::PVectorInteger& int1)
	: BMethodRequest(1233438138) 
	, int1(int1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_setInt1::BSerializable_getTypeId() {
	return 136821228; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_setInt1::serialize(BIO& ar, const BVERSION version) {
	ar & this->int1;
}
void byps::test::api::remote::BRequest_RemoteListTypes_setInt1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_136821228(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_setInt1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setInt2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_setInt2::BRequest_RemoteListTypes_setInt2() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteListTypes_setInt2::BRequest_RemoteListTypes_setInt2(const byps_ptr< ::std::vector< PArrayInt > >& int2)
	: BMethodRequest(1233438138) 
	, int2(int2)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_setInt2::BSerializable_getTypeId() {
	return 136821227; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_setInt2::serialize(BIO& ar, const BVERSION version) {
	ar & this->int2;
}
void byps::test::api::remote::BRequest_RemoteListTypes_setInt2::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_136821227(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_setInt2>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setInt3
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_setInt3::BRequest_RemoteListTypes_setInt3() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteListTypes_setInt3::BRequest_RemoteListTypes_setInt3(const byps_ptr< ::std::vector< byps::PVectorInteger > >& int3)
	: BMethodRequest(1233438138) 
	, int3(int3)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_setInt3::BSerializable_getTypeId() {
	return 136821226; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_setInt3::serialize(BIO& ar, const BVERSION version) {
	ar & this->int3;
}
void byps::test::api::remote::BRequest_RemoteListTypes_setInt3::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->setInt3(int3, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_136821226(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_setInt3>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setInt4
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_setInt4::BRequest_RemoteListTypes_setInt4() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteListTypes_setInt4::BRequest_RemoteListTypes_setInt4(const byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > >& int4)
	: BMethodRequest(1233438138) 
	, int4(int4)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_setInt4::BSerializable_getTypeId() {
	return 136821225; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_setInt4::serialize(BIO& ar, const BVERSION version) {
	ar & this->int4;
}
void byps::test::api::remote::BRequest_RemoteListTypes_setInt4::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->setInt4(int4, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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
void BSerializer_136821225(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_setInt4>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setLong1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_setLong1::BRequest_RemoteListTypes_setLong1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteListTypes_setLong1::BRequest_RemoteListTypes_setLong1(const byps::PVectorLong& long1)
	: BMethodRequest(1233438138) 
	, long1(long1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_setLong1::BSerializable_getTypeId() {
	return 56305539; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_setLong1::serialize(BIO& ar, const BVERSION version) {
	ar & this->long1;
}
void byps::test::api::remote::BRequest_RemoteListTypes_setLong1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_56305539(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_setLong1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setObj1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_setObj1::BRequest_RemoteListTypes_setObj1() : BMethodRequest(1233438138) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteListTypes_setObj1::BRequest_RemoteListTypes_setObj1(const byps::PVectorObject& obj1)
	: BMethodRequest(1233438138) 
	, obj1(obj1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteListTypes_setObj1::BSerializable_getTypeId() {
	return 136654324; 
}
// checkpoint byps.gen.cpp.GenApiClass:876
void BRequest_RemoteListTypes_setObj1::serialize(BIO& ar, const BVERSION version) {
	ar & this->obj1;
}
void byps::test::api::remote::BRequest_RemoteListTypes_setObj1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_136654324(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteListTypes_setObj1>(bio, pObj, pObjS, pBase);	
}
}}}
