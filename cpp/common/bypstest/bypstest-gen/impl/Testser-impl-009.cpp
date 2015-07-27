#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setString
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_setString::BRequest_RemotePrimitiveTypes_setString() : BMethodRequest(1178916877) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemotePrimitiveTypes_setString::BRequest_RemotePrimitiveTypes_setString(const ::std::wstring& v)
	: BMethodRequest(1178916877) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemotePrimitiveTypes_setString::BSerializable_getTypeId() {
	return 1293977038; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemotePrimitiveTypes_setString::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setString::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1293977038(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemotePrimitiveTypes_setString>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_throwException
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_throwException::BRequest_RemotePrimitiveTypes_throwException() : BMethodRequest(1178916877) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemotePrimitiveTypes_throwException::BSerializable_getTypeId() {
	return 1278149706; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemotePrimitiveTypes_throwException::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_throwException::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->throwException([__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1278149706(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemotePrimitiveTypes_throwException>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_voidFunctionVoid
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_voidFunctionVoid::BRequest_RemotePrimitiveTypes_voidFunctionVoid() : BMethodRequest(1178916877) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemotePrimitiveTypes_voidFunctionVoid::BSerializable_getTypeId() {
	return 2033139391; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemotePrimitiveTypes_voidFunctionVoid::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_voidFunctionVoid::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->voidFunctionVoid([__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_2033139391(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemotePrimitiveTypes_voidFunctionVoid>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteReferences_getNode
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteReferences_getNode::BRequest_RemoteReferences_getNode() : BMethodRequest(568637225) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteReferences_getNode::BSerializable_getTypeId() {
	return 1366991859; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteReferences_getNode::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteReferences_getNode::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteReferences __byps__remoteT = byps_ptr_cast<RemoteReferences>(__byps__remote);
	__byps__remoteT->getNode([__byps__asyncResult](byps::test::api::refs::PNode __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_9001(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1366991859(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteReferences_getNode>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteReferences_setNode
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteReferences_setNode::BRequest_RemoteReferences_setNode() : BMethodRequest(568637225) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteReferences_setNode::BRequest_RemoteReferences_setNode(const byps::test::api::refs::PNode& v)
	: BMethodRequest(568637225) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteReferences_setNode::BSerializable_getTypeId() {
	return 693117721; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteReferences_setNode::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteReferences_setNode::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteReferences __byps__remoteT = byps_ptr_cast<RemoteReferences>(__byps__remote);
	__byps__remoteT->setNode(v, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_693117721(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteReferences_setNode>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteServerCtrl_getPublishedRemote
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteServerCtrl_getPublishedRemote::BRequest_RemoteServerCtrl_getPublishedRemote() : BMethodRequest(1652234479) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteServerCtrl_getPublishedRemote::BRequest_RemoteServerCtrl_getPublishedRemote(const ::std::wstring& name)
	: BMethodRequest(1652234479) 
	, name(name)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteServerCtrl_getPublishedRemote::BSerializable_getTypeId() {
	return 648762723; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteServerCtrl_getPublishedRemote::serialize(BIO& ar, const BVERSION version) {
	ar & this->name;
}
void byps::test::api::remote::BRequest_RemoteServerCtrl_getPublishedRemote::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteServerCtrl __byps__remoteT = byps_ptr_cast<RemoteServerCtrl>(__byps__remote);
	__byps__remoteT->getPublishedRemote(name, [__byps__asyncResult](PRemote __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_16(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_648762723(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteServerCtrl_getPublishedRemote>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteServerCtrl_publishRemote
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteServerCtrl_publishRemote::BRequest_RemoteServerCtrl_publishRemote() : BMethodRequest(1652234479) {
	fowardToOtherServers = false;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteServerCtrl_publishRemote::BRequest_RemoteServerCtrl_publishRemote(const ::std::wstring& name, const PRemote& remote, bool fowardToOtherServers)
	: BMethodRequest(1652234479) 
	, name(name)
	, remote(remote)
	, fowardToOtherServers(fowardToOtherServers)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteServerCtrl_publishRemote::BSerializable_getTypeId() {
	return 1543768912; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteServerCtrl_publishRemote::serialize(BIO& ar, const BVERSION version) {
	ar & this->fowardToOtherServers;
	ar & this->name;
	ar & this->remote;
}
void byps::test::api::remote::BRequest_RemoteServerCtrl_publishRemote::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteServerCtrl __byps__remoteT = byps_ptr_cast<RemoteServerCtrl>(__byps__remote);
	__byps__remoteT->publishRemote(name, remote, fowardToOtherServers, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1543768912(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteServerCtrl_publishRemote>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteServerCtrl_removePublishedRemote
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteServerCtrl_removePublishedRemote::BRequest_RemoteServerCtrl_removePublishedRemote() : BMethodRequest(1652234479) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteServerCtrl_removePublishedRemote::BRequest_RemoteServerCtrl_removePublishedRemote(const ::std::wstring& name)
	: BMethodRequest(1652234479) 
	, name(name)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteServerCtrl_removePublishedRemote::BSerializable_getTypeId() {
	return 135366859; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteServerCtrl_removePublishedRemote::serialize(BIO& ar, const BVERSION version) {
	ar & this->name;
}
void byps::test::api::remote::BRequest_RemoteServerCtrl_removePublishedRemote::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteServerCtrl __byps__remoteT = byps_ptr_cast<RemoteServerCtrl>(__byps__remote);
	__byps__remoteT->removePublishedRemote(name, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_135366859(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteServerCtrl_removePublishedRemote>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getBoolean1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_getBoolean1::BRequest_RemoteSetTypes_getBoolean1() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_getBoolean1::BSerializable_getTypeId() {
	return 2114990909; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_getBoolean1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteSetTypes_getBoolean1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getBoolean1([__byps__asyncResult](byps::PSetBoolean __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1365696060(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_2114990909(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_getBoolean1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getByte1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_getByte1::BRequest_RemoteSetTypes_getByte1() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_getByte1::BSerializable_getTypeId() {
	return 901695825; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_getByte1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteSetTypes_getByte1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getByte1([__byps__asyncResult](byps::PSetByte __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_31512998(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_901695825(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_getByte1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getByte2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_getByte2::BRequest_RemoteSetTypes_getByte2() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_getByte2::BSerializable_getTypeId() {
	return 901695824; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_getByte2::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteSetTypes_getByte2::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getByte2([__byps__asyncResult](byps_ptr< ::std::set< PBytes > > __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2052431866(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_901695824(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_getByte2>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getChar1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_getChar1::BRequest_RemoteSetTypes_getChar1() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_getChar1::BSerializable_getTypeId() {
	return 901296607; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_getChar1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteSetTypes_getChar1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getChar1([__byps__asyncResult](byps::PSetCharacter __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_936607009(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_901296607(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_getChar1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getDate1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_getDate1::BRequest_RemoteSetTypes_getDate1() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_getDate1::BSerializable_getTypeId() {
	return 900563767; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_getDate1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteSetTypes_getDate1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getDate1([__byps__asyncResult](byps::PSetDate __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1097919350(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_900563767(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_getDate1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getDouble1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_getDouble1::BRequest_RemoteSetTypes_getDouble1() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_getDouble1::BSerializable_getTypeId() {
	return 1751651450; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_getDouble1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteSetTypes_getDouble1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getDouble1([__byps__asyncResult](byps::PSetDouble __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1320560671(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1751651450(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_getDouble1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getFloat1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_getFloat1::BRequest_RemoteSetTypes_getFloat1() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_getFloat1::BSerializable_getTypeId() {
	return 2080406641; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_getFloat1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteSetTypes_getFloat1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getFloat1([__byps__asyncResult](byps::PSetFloat __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1898022288(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_2080406641(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_getFloat1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getInt1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_getInt1::BRequest_RemoteSetTypes_getInt1() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_getInt1::BSerializable_getTypeId() {
	return 1772226268; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_getInt1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteSetTypes_getInt1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getInt1([__byps__asyncResult](byps::PSetInteger __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1493282670(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1772226268(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_getInt1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getInt2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_getInt2::BRequest_RemoteSetTypes_getInt2() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_getInt2::BSerializable_getTypeId() {
	return 1772226269; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_getInt2::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteSetTypes_getInt2::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getInt2([__byps__asyncResult](byps_ptr< ::std::set< PArrayInt > > __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1406124761(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1772226269(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_getInt2>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getLong1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_getLong1::BRequest_RemoteSetTypes_getLong1() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_getLong1::BSerializable_getTypeId() {
	return 892764229; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_getLong1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteSetTypes_getLong1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getLong1([__byps__asyncResult](byps::PSetLong __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1457164460(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_892764229(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_getLong1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getObj1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_getObj1::BRequest_RemoteSetTypes_getObj1() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_getObj1::BSerializable_getTypeId() {
	return 1772393172; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_getObj1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteSetTypes_getObj1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getObj1([__byps__asyncResult](byps_ptr< ::std::set< PSerializable > > __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_14(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1772393172(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_getObj1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getPrimitiveTypes1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_getPrimitiveTypes1::BRequest_RemoteSetTypes_getPrimitiveTypes1() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_getPrimitiveTypes1::BSerializable_getTypeId() {
	return 669274715; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_getPrimitiveTypes1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteSetTypes_getPrimitiveTypes1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getPrimitiveTypes1([__byps__asyncResult](byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > > __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_673917574(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_669274715(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_getPrimitiveTypes1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getShort1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_getShort1::BRequest_RemoteSetTypes_getShort1() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_getShort1::BSerializable_getTypeId() {
	return 1711905425; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_getShort1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteSetTypes_getShort1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getShort1([__byps__asyncResult](byps::PSetShort __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2028443792(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1711905425(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_getShort1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getString1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_getString1::BRequest_RemoteSetTypes_getString1() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_getString1::BSerializable_getTypeId() {
	return 1183412410; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_getString1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteSetTypes_getString1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getString1([__byps__asyncResult](byps::PSetString __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1888799711(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1183412410(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_getString1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setBoolean1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_setBoolean1::BRequest_RemoteSetTypes_setBoolean1() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteSetTypes_setBoolean1::BRequest_RemoteSetTypes_setBoolean1(const byps::PSetBoolean& boolean1)
	: BMethodRequest(1900796440) 
	, boolean1(boolean1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_setBoolean1::BSerializable_getTypeId() {
	return 2091396559; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_setBoolean1::serialize(BIO& ar, const BVERSION version) {
	ar & this->boolean1;
}
void byps::test::api::remote::BRequest_RemoteSetTypes_setBoolean1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_2091396559(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_setBoolean1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setByte1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_setByte1::BRequest_RemoteSetTypes_setByte1() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteSetTypes_setByte1::BRequest_RemoteSetTypes_setByte1(const byps::PSetByte& byte1)
	: BMethodRequest(1900796440) 
	, byte1(byte1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_setByte1::BSerializable_getTypeId() {
	return 1462808285; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_setByte1::serialize(BIO& ar, const BVERSION version) {
	ar & this->byte1;
}
void byps::test::api::remote::BRequest_RemoteSetTypes_setByte1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1462808285(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_setByte1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setByte2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_setByte2::BRequest_RemoteSetTypes_setByte2() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteSetTypes_setByte2::BRequest_RemoteSetTypes_setByte2(const byps_ptr< ::std::set< PBytes > >& byte2)
	: BMethodRequest(1900796440) 
	, byte2(byte2)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_setByte2::BSerializable_getTypeId() {
	return 1462808284; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_setByte2::serialize(BIO& ar, const BVERSION version) {
	ar & this->byte2;
}
void byps::test::api::remote::BRequest_RemoteSetTypes_setByte2::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1462808284(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_setByte2>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setChar1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_setChar1::BRequest_RemoteSetTypes_setChar1() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteSetTypes_setChar1::BRequest_RemoteSetTypes_setChar1(const byps::PSetCharacter& char1)
	: BMethodRequest(1900796440) 
	, char1(char1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_setChar1::BSerializable_getTypeId() {
	return 1462409067; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_setChar1::serialize(BIO& ar, const BVERSION version) {
	ar & this->char1;
}
void byps::test::api::remote::BRequest_RemoteSetTypes_setChar1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1462409067(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_setChar1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setDate1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_setDate1::BRequest_RemoteSetTypes_setDate1() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteSetTypes_setDate1::BRequest_RemoteSetTypes_setDate1(const byps::PSetDate& obj1)
	: BMethodRequest(1900796440) 
	, obj1(obj1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_setDate1::BSerializable_getTypeId() {
	return 1461676227; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_setDate1::serialize(BIO& ar, const BVERSION version) {
	ar & this->obj1;
}
void byps::test::api::remote::BRequest_RemoteSetTypes_setDate1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1461676227(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_setDate1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setDouble1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_setDouble1::BRequest_RemoteSetTypes_setDouble1() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteSetTypes_setDouble1::BRequest_RemoteSetTypes_setDouble1(const byps::PSetDouble& double1)
	: BMethodRequest(1900796440) 
	, double1(double1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_setDouble1::BSerializable_getTypeId() {
	return 185153786; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_setDouble1::serialize(BIO& ar, const BVERSION version) {
	ar & this->double1;
}
void byps::test::api::remote::BRequest_RemoteSetTypes_setDouble1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_185153786(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_setDouble1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setFloat1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_setFloat1::BRequest_RemoteSetTypes_setFloat1() : BMethodRequest(1900796440) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteSetTypes_setFloat1::BRequest_RemoteSetTypes_setFloat1(const byps::PSetFloat& float1)
	: BMethodRequest(1900796440) 
	, float1(float1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteSetTypes_setFloat1::BSerializable_getTypeId() {
	return 1999943579; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void BRequest_RemoteSetTypes_setFloat1::serialize(BIO& ar, const BVERSION version) {
	ar & this->float1;
}
void byps::test::api::remote::BRequest_RemoteSetTypes_setFloat1::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1999943579(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteSetTypes_setFloat1>(bio, pObj, pObjS, pBase);	
}
}}}
