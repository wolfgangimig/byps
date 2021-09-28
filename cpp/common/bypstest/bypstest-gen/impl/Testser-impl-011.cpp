#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteWithAuthentication_setUseAuthentication
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
BRequest_RemoteWithAuthentication_setUseAuthentication::BRequest_RemoteWithAuthentication_setUseAuthentication() : BMethodRequest(1983670399) {
	useAuth = false;
}
// checkpoint byps.gen.cpp.GenApiClass:548
byps::test::api::remote::BRequest_RemoteWithAuthentication_setUseAuthentication::BRequest_RemoteWithAuthentication_setUseAuthentication(bool useAuth)
	: BMethodRequest(1983670399) 
	, useAuth(useAuth)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BRequest_RemoteWithAuthentication_setUseAuthentication::BSerializable_getTypeId() {
	return 946544530; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void BRequest_RemoteWithAuthentication_setUseAuthentication::serialize(BIO& ar, const BVERSION version) {
	ar & this->useAuth;
}
void byps::test::api::remote::BRequest_RemoteWithAuthentication_setUseAuthentication::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteWithAuthentication __byps__remoteT = byps_ptr_cast<RemoteWithAuthentication>(__byps__remote);
	__byps__remoteT->setUseAuthentication(useAuth, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_946544530(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::remote::BRequest_RemoteWithAuthentication_setUseAuthentication>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace set { 

//-------------------------------------------------
// Implementation of class SetTypes
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
SetTypes::SetTypes() {
}
// checkpoint byps.gen.cpp.GenApiClass:548
byps::test::api::set::SetTypes::SetTypes(const byps::PSetBoolean& boolean1, const byps::PSetByte& byte1, const byps::PSetCharacter& char1, const byps::PSetShort& short1, const byps::PSetInteger& int1, const byps::PSetLong& long1, const byps::PSetFloat& float1, const byps::PSetDouble& double1, const byps::PSetString& string1, const byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1, const byps_ptr< ::std::set< PBytes > >& byte2, const byps_ptr< ::std::set< PArrayInt > >& int2, const byps_ptr< ::std::set< PSerializable > >& obj1, const byps::PSetDate& date1)
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
BTYPEID byps::test::api::set::SetTypes::BSerializable_getTypeId() {
	return 5001; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void SetTypes::serialize(BIO& ar, const BVERSION version) {
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

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_5001(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::set::SetTypes>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ClientIF_getStreams
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
BRequest_ClientIF_getStreams::BRequest_ClientIF_getStreams() : BMethodRequest(2049072174) {
	ctrl = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:548
byps::test::api::srvr::BRequest_ClientIF_getStreams::BRequest_ClientIF_getStreams(int32_t ctrl)
	: BMethodRequest(2049072174) 
	, ctrl(ctrl)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ClientIF_getStreams::BSerializable_getTypeId() {
	return 1654980071; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void BRequest_ClientIF_getStreams::serialize(BIO& ar, const BVERSION version) {
	ar & this->ctrl;
}
void byps::test::api::srvr::BRequest_ClientIF_getStreams::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PClientIF __byps__remoteT = byps_ptr_cast<ClientIF>(__byps__remote);
	__byps__remoteT->getStreams(ctrl, [__byps__asyncResult](byps::PVectorInputStream __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1218831438(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_1654980071(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ClientIF_getStreams>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ClientIF_incrementInt
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
BRequest_ClientIF_incrementInt::BRequest_ClientIF_incrementInt() : BMethodRequest(2049072174) {
	a = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:548
byps::test::api::srvr::BRequest_ClientIF_incrementInt::BRequest_ClientIF_incrementInt(int32_t a)
	: BMethodRequest(2049072174) 
	, a(a)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ClientIF_incrementInt::BSerializable_getTypeId() {
	return 1685952420; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void BRequest_ClientIF_incrementInt::serialize(BIO& ar, const BVERSION version) {
	ar & this->a;
}
void byps::test::api::srvr::BRequest_ClientIF_incrementInt::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PClientIF __byps__remoteT = byps_ptr_cast<ClientIF>(__byps__remote);
	__byps__remoteT->incrementInt(a, [__byps__asyncResult](int32_t __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_5(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_1685952420(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ClientIF_incrementInt>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ClientIF_putStreams
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
BRequest_ClientIF_putStreams::BRequest_ClientIF_putStreams() : BMethodRequest(2049072174) {
	ctrl = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:548
byps::test::api::srvr::BRequest_ClientIF_putStreams::BRequest_ClientIF_putStreams(const byps::PVectorInputStream& strm, int32_t ctrl)
	: BMethodRequest(2049072174) 
	, strm(strm)
	, ctrl(ctrl)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ClientIF_putStreams::BSerializable_getTypeId() {
	return 2016865344; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void BRequest_ClientIF_putStreams::serialize(BIO& ar, const BVERSION version) {
	ar & this->ctrl;
	ar & this->strm;
}
void byps::test::api::srvr::BRequest_ClientIF_putStreams::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PClientIF __byps__remoteT = byps_ptr_cast<ClientIF>(__byps__remote);
	__byps__remoteT->putStreams(strm, ctrl, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_2016865344(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ClientIF_putStreams>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ClientIF_sendChat
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
BRequest_ClientIF_sendChat::BRequest_ClientIF_sendChat() : BMethodRequest(2049072174) {
}
// checkpoint byps.gen.cpp.GenApiClass:548
byps::test::api::srvr::BRequest_ClientIF_sendChat::BRequest_ClientIF_sendChat(const PChatStructure& cs)
	: BMethodRequest(2049072174) 
	, cs(cs)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ClientIF_sendChat::BSerializable_getTypeId() {
	return 41050276; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void BRequest_ClientIF_sendChat::serialize(BIO& ar, const BVERSION version) {
	ar & this->cs;
}
void byps::test::api::srvr::BRequest_ClientIF_sendChat::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PClientIF __byps__remoteT = byps_ptr_cast<ClientIF>(__byps__remote);
	__byps__remoteT->sendChat(cs, [__byps__asyncResult](PChatStructure __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_7007(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_41050276(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ClientIF_sendChat>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_callClientIncrementInt
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
BRequest_ServerIF_callClientIncrementInt::BRequest_ServerIF_callClientIncrementInt() : BMethodRequest(1775199834) {
	v = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:548
byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt::BRequest_ServerIF_callClientIncrementInt(int32_t v)
	: BMethodRequest(1775199834) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt::BSerializable_getTypeId() {
	return 389860173; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void BRequest_ServerIF_callClientIncrementInt::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->callClientIncrementInt(v, [__byps__asyncResult](int32_t __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_5(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_389860173(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_callClientParallel
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
BRequest_ServerIF_callClientParallel::BRequest_ServerIF_callClientParallel() : BMethodRequest(1775199834) {
	v = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:548
byps::test::api::srvr::BRequest_ServerIF_callClientParallel::BRequest_ServerIF_callClientParallel(int32_t v)
	: BMethodRequest(1775199834) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ServerIF_callClientParallel::BSerializable_getTypeId() {
	return 772308436; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void BRequest_ServerIF_callClientParallel::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::srvr::BRequest_ServerIF_callClientParallel::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->callClientParallel(v, [__byps__asyncResult](int32_t __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_5(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_772308436(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ServerIF_callClientParallel>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getClient
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
BRequest_ServerIF_getClient::BRequest_ServerIF_getClient() : BMethodRequest(1775199834) {
	id = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:548
byps::test::api::srvr::BRequest_ServerIF_getClient::BRequest_ServerIF_getClient(int32_t id)
	: BMethodRequest(1775199834) 
	, id(id)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ServerIF_getClient::BSerializable_getTypeId() {
	return 190669475; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void BRequest_ServerIF_getClient::serialize(BIO& ar, const BVERSION version) {
	ar & this->id;
}
void byps::test::api::srvr::BRequest_ServerIF_getClient::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->getClient(id, [__byps__asyncResult](PClientIF __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_955752991(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_190669475(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ServerIF_getClient>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getClientIds
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
BRequest_ServerIF_getClientIds::BRequest_ServerIF_getClientIds() : BMethodRequest(1775199834) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ServerIF_getClientIds::BSerializable_getTypeId() {
	return 2007476251; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void BRequest_ServerIF_getClientIds::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::srvr::BRequest_ServerIF_getClientIds::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->getClientIds([__byps__asyncResult](byps::PSetInteger __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_2007476251(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ServerIF_getClientIds>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getPartner
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
BRequest_ServerIF_getPartner::BRequest_ServerIF_getPartner() : BMethodRequest(1775199834) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ServerIF_getPartner::BSerializable_getTypeId() {
	return 1025664374; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void BRequest_ServerIF_getPartner::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::srvr::BRequest_ServerIF_getPartner::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->getPartner([__byps__asyncResult](PClientIF __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_955752991(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_1025664374(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ServerIF_getPartner>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getStreamsFromClient
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
BRequest_ServerIF_getStreamsFromClient::BRequest_ServerIF_getStreamsFromClient() : BMethodRequest(1775199834) {
	materializeOnServer = false;
}
// checkpoint byps.gen.cpp.GenApiClass:548
byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient::BRequest_ServerIF_getStreamsFromClient(bool materializeOnServer)
	: BMethodRequest(1775199834) 
	, materializeOnServer(materializeOnServer)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient::BSerializable_getTypeId() {
	return 1679867754; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void BRequest_ServerIF_getStreamsFromClient::serialize(BIO& ar, const BVERSION version) {
	ar & this->materializeOnServer;
}
void byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->getStreamsFromClient(materializeOnServer, [__byps__asyncResult](byps::PVectorInputStream __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1218831438(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_1679867754(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_putStreamsOnClient
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
BRequest_ServerIF_putStreamsOnClient::BRequest_ServerIF_putStreamsOnClient() : BMethodRequest(1775199834) {
}
// checkpoint byps.gen.cpp.GenApiClass:548
byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient::BRequest_ServerIF_putStreamsOnClient(const byps::PVectorInputStream& streams)
	: BMethodRequest(1775199834) 
	, streams(streams)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient::BSerializable_getTypeId() {
	return 1934886286; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void BRequest_ServerIF_putStreamsOnClient::serialize(BIO& ar, const BVERSION version) {
	ar & this->streams;
}
void byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->putStreamsOnClient(streams, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_1934886286(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_registerWithClientMap
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
BRequest_ServerIF_registerWithClientMap::BRequest_ServerIF_registerWithClientMap() : BMethodRequest(1775199834) {
	id = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:548
byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap::BRequest_ServerIF_registerWithClientMap(int32_t id)
	: BMethodRequest(1775199834) 
	, id(id)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap::BSerializable_getTypeId() {
	return 1533268444; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void BRequest_ServerIF_registerWithClientMap::serialize(BIO& ar, const BVERSION version) {
	ar & this->id;
}
void byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->registerWithClientMap(id, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_1533268444(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_setPartner
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
BRequest_ServerIF_setPartner::BRequest_ServerIF_setPartner() : BMethodRequest(1775199834) {
}
// checkpoint byps.gen.cpp.GenApiClass:548
byps::test::api::srvr::BRequest_ServerIF_setPartner::BRequest_ServerIF_setPartner(const PClientIF& client)
	: BMethodRequest(1775199834) 
	, client(client)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ServerIF_setPartner::BSerializable_getTypeId() {
	return 1332497686; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void BRequest_ServerIF_setPartner::serialize(BIO& ar, const BVERSION version) {
	ar & this->client;
}
void byps::test::api::srvr::BRequest_ServerIF_setPartner::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->setPartner(client, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_1332497686(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ServerIF_setPartner>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class ChatStructure
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
ChatStructure::ChatStructure() {
	sentAt = 0;
	receivedAt = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:548
byps::test::api::srvr::ChatStructure::ChatStructure(const ::std::wstring& msg, double sentAt, double receivedAt)
	: msg(msg)
	, sentAt(sentAt)
	, receivedAt(receivedAt)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::ChatStructure::BSerializable_getTypeId() {
	return 7007; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void ChatStructure::serialize(BIO& ar, const BVERSION version) {
	ar & this->msg;
	ar & this->receivedAt;
	ar & this->sentAt;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_7007(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::ChatStructure>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace strm { 

//-------------------------------------------------
// Implementation of class Stream1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
Stream1::Stream1() {
}
// checkpoint byps.gen.cpp.GenApiClass:548
byps::test::api::strm::Stream1::Stream1(const PContentStream& is1, const ::std::wstring& contentType, const byps::PArrayInputStream& arrStream, const byps::PVectorInputStream& listStream, const byps::PMapIntegerInputStream& mapStream)
	: is1(is1)
	, contentType(contentType)
	, arrStream(arrStream)
	, listStream(listStream)
	, mapStream(mapStream)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::strm::Stream1::BSerializable_getTypeId() {
	return 1541129345; 
}
void Stream1::setContentType(::std::wstring v) {
	contentType = v;
}
void Stream1::setArrStream(byps::PArrayInputStream v) {
	arrStream = v;
}
void Stream1::setListStream(byps::PVectorInputStream v) {
	listStream = v;
}
// checkpoint byps.gen.cpp.GenApiClass:888
void Stream1::serialize(BIO& ar, const BVERSION version) {
	ar & this->contentType;
	ar & this->arrStream;
	ar & this->is1;
	ar & this->listStream;
	ar & this->mapStream;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_1541129345(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::strm::Stream1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_getClient
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
BRequest_EvolveIF_getClient::BRequest_EvolveIF_getClient() : BMethodRequest(15377840) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::ver::BRequest_EvolveIF_getClient::BSerializable_getTypeId() {
	return 1212621223; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void BRequest_EvolveIF_getClient::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::ver::BRequest_EvolveIF_getClient::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PEvolveIF __byps__remoteT = byps_ptr_cast<EvolveIF>(__byps__remote);
	__byps__remoteT->getClient([__byps__asyncResult](PEvolveIF __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_564008001(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_1212621223(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::ver::BRequest_EvolveIF_getClient>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_getEvolve
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
BRequest_EvolveIF_getEvolve::BRequest_EvolveIF_getEvolve() : BMethodRequest(15377840) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::ver::BRequest_EvolveIF_getEvolve::BSerializable_getTypeId() {
	return 1279300441; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void BRequest_EvolveIF_getEvolve::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::ver::BRequest_EvolveIF_getEvolve::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PEvolveIF __byps__remoteT = byps_ptr_cast<EvolveIF>(__byps__remote);
	__byps__remoteT->getEvolve([__byps__asyncResult](PEvolve __byps__result, const BException& __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1391985860(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_1279300441(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::ver::BRequest_EvolveIF_getEvolve>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_sendEvolveToClient
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
BRequest_EvolveIF_sendEvolveToClient::BRequest_EvolveIF_sendEvolveToClient() : BMethodRequest(15377840) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::ver::BRequest_EvolveIF_sendEvolveToClient::BSerializable_getTypeId() {
	return 714115141; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void BRequest_EvolveIF_sendEvolveToClient::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::ver::BRequest_EvolveIF_sendEvolveToClient::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PEvolveIF __byps__remoteT = byps_ptr_cast<EvolveIF>(__byps__remote);
	__byps__remoteT->sendEvolveToClient([__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_714115141(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::ver::BRequest_EvolveIF_sendEvolveToClient>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_setClient
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
BRequest_EvolveIF_setClient::BRequest_EvolveIF_setClient() : BMethodRequest(15377840) {
}
// checkpoint byps.gen.cpp.GenApiClass:548
byps::test::api::ver::BRequest_EvolveIF_setClient::BRequest_EvolveIF_setClient(const PEvolveIF& partner)
	: BMethodRequest(15377840) 
	, partner(partner)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::ver::BRequest_EvolveIF_setClient::BSerializable_getTypeId() {
	return 998004147; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void BRequest_EvolveIF_setClient::serialize(BIO& ar, const BVERSION version) {
	ar & this->partner;
}
void byps::test::api::ver::BRequest_EvolveIF_setClient::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PEvolveIF __byps__remoteT = byps_ptr_cast<EvolveIF>(__byps__remote);
	__byps__remoteT->setClient(partner, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_998004147(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::ver::BRequest_EvolveIF_setClient>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_setEvolve
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
BRequest_EvolveIF_setEvolve::BRequest_EvolveIF_setEvolve() : BMethodRequest(15377840) {
}
// checkpoint byps.gen.cpp.GenApiClass:548
byps::test::api::ver::BRequest_EvolveIF_setEvolve::BRequest_EvolveIF_setEvolve(const PEvolve& obj)
	: BMethodRequest(15377840) 
	, obj(obj)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::ver::BRequest_EvolveIF_setEvolve::BSerializable_getTypeId() {
	return 1064683365; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void BRequest_EvolveIF_setEvolve::serialize(BIO& ar, const BVERSION version) {
	ar & this->obj;
}
void byps::test::api::ver::BRequest_EvolveIF_setEvolve::execute(const PRemote& __byps__remote, PAsyncResult __byps__asyncResult) {
	PEvolveIF __byps__remoteT = byps_ptr_cast<EvolveIF>(__byps__remote);
	__byps__remoteT->setEvolve(obj, [__byps__asyncResult](bool __byps__result, const BException& __byps__ex) {
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

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_1064683365(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::ver::BRequest_EvolveIF_setEvolve>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class Evolve
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
Evolve::Evolve() {
	bool1 = false;
	byte1 = 0;
	char1 = '\0';
	short1 = 0;
	int1 = 0;
	long1 = 0;
	float1 = 0;
	double1 = 0;
	bool2 = false;
	byte2 = 0;
	char2 = '\0';
	short2 = 0;
	int2 = 0;
	long2 = 0;
	float2 = 0;
	double2 = 0;
	bool3 = false;
	byte3 = 0;
	char3 = '\0';
	short3 = 0;
	int3 = 0;
	long3 = 0;
	float3 = 0;
	double3 = 0;
	since793 = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:548
byps::test::api::ver::Evolve::Evolve(bool bool1, int8_t byte1, wchar_t char1, int16_t short1, int32_t int1, int64_t long1, float float1, double double1, const PArrayBoolean& bools1, const PBytes& bytes1, const PArrayChar& chars1, const PArrayShort& shorts1, const PArrayInt& ints1, const PArrayLong& longs1, const PArrayFloat& floats1, const PArrayDouble& doubles1, const ::std::wstring& str1, const PSerializable& obj1, const PEvolve2& evo1, const byps::PVectorInteger& list1, const byps::PSetInteger& set1, const byps::PMapIntegerInteger& map1, bool bool2, int8_t byte2, wchar_t char2, int16_t short2, int32_t int2, int64_t long2, float float2, double double2, const PArrayBoolean& bools2, const PBytes& bytes2, const PArrayChar& chars2, const PArrayShort& shorts2, const PArrayInt& ints2, const PArrayLong& longs2, const PArrayFloat& floats2, const PArrayDouble& doubles2, const ::std::wstring& str2, const PSerializable& obj2, const PEvolve2& evo2, const byps::PVectorInteger& list2, const byps::PSetInteger& set2, const byps::PMapIntegerInteger& map2, bool bool3, int8_t byte3, wchar_t char3, int16_t short3, int32_t int3, int64_t long3, float float3, double double3, const PArrayBoolean& bools3, const PBytes& bytes3, const PArrayChar& chars3, const PArrayShort& shorts3, const PArrayInt& ints3, const PArrayLong& longs3, const PArrayFloat& floats3, const PArrayDouble& doubles3, const ::std::wstring& str3, const PSerializable& obj3, const PEvolve2& evo3, const byps::PVectorInteger& list3, const byps::PSetInteger& set3, const byps::PMapIntegerInteger& map3, int32_t since793)
	: bool1(bool1)
	, byte1(byte1)
	, char1(char1)
	, short1(short1)
	, int1(int1)
	, long1(long1)
	, float1(float1)
	, double1(double1)
	, bools1(bools1)
	, bytes1(bytes1)
	, chars1(chars1)
	, shorts1(shorts1)
	, ints1(ints1)
	, longs1(longs1)
	, floats1(floats1)
	, doubles1(doubles1)
	, str1(str1)
	, obj1(obj1)
	, evo1(evo1)
	, list1(list1)
	, set1(set1)
	, map1(map1)
	, bool2(bool2)
	, byte2(byte2)
	, char2(char2)
	, short2(short2)
	, int2(int2)
	, long2(long2)
	, float2(float2)
	, double2(double2)
	, bools2(bools2)
	, bytes2(bytes2)
	, chars2(chars2)
	, shorts2(shorts2)
	, ints2(ints2)
	, longs2(longs2)
	, floats2(floats2)
	, doubles2(doubles2)
	, str2(str2)
	, obj2(obj2)
	, evo2(evo2)
	, list2(list2)
	, set2(set2)
	, map2(map2)
	, bool3(bool3)
	, byte3(byte3)
	, char3(char3)
	, short3(short3)
	, int3(int3)
	, long3(long3)
	, float3(float3)
	, double3(double3)
	, bools3(bools3)
	, bytes3(bytes3)
	, chars3(chars3)
	, shorts3(shorts3)
	, ints3(ints3)
	, longs3(longs3)
	, floats3(floats3)
	, doubles3(doubles3)
	, str3(str3)
	, obj3(obj3)
	, evo3(evo3)
	, list3(list3)
	, set3(set3)
	, map3(map3)
	, since793(since793)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::ver::Evolve::BSerializable_getTypeId() {
	return 1391985860; 
}
// checkpoint byps.gen.cpp.GenApiClass:888
void Evolve::serialize(BIO& ar, const BVERSION version) {
	ar & this->bool1;
	ar & this->byte1;
	ar & this->char1;
	ar & this->double1;
	ar & this->float1;
	ar & this->int1;
	ar & this->long1;
	ar & this->short1;
	ar & this->str1;
	if (version >= 200000000000000) {
		ar & this->bool2;
		ar & this->byte2;
		ar & this->char2;
		ar & this->double2;
		ar & this->float2;
		ar & this->int2;
		ar & this->long2;
		ar & this->short2;
		ar & this->str2;
		if (version >= 300000000000000) {
			ar & this->bool3;
			ar & this->byte3;
			ar & this->char3;
			ar & this->double3;
			ar & this->float3;
			ar & this->int3;
			ar & this->long3;
			ar & this->short3;
			ar & this->str3;
			if (version >= 79300000000000000) {
				ar & this->since793;
			}
		}
	}
	ar & this->bools1;
	ar & this->bytes1;
	ar & this->chars1;
	ar & this->doubles1;
	ar & this->evo1;
	ar & this->floats1;
	ar & this->ints1;
	ar & this->list1;
	ar & this->longs1;
	ar & this->map1;
	ar & this->obj1;
	ar & this->set1;
	ar & this->shorts1;
	if (version >= 200000000000000) {
		ar & this->bools2;
		ar & this->bytes2;
		ar & this->chars2;
		ar & this->doubles2;
		ar & this->evo2;
		ar & this->floats2;
		ar & this->ints2;
		ar & this->list2;
		ar & this->longs2;
		ar & this->map2;
		ar & this->obj2;
		ar & this->set2;
		ar & this->shorts2;
		if (version >= 300000000000000) {
			ar & this->bools3;
			ar & this->bytes3;
			ar & this->chars3;
			ar & this->doubles3;
			ar & this->evo3;
			ar & this->floats3;
			ar & this->ints3;
			ar & this->list3;
			ar & this->longs3;
			ar & this->map3;
			ar & this->obj3;
			ar & this->set3;
			ar & this->shorts3;
		}
	}
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_1391985860(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::ver::Evolve>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class Evolve2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:501
Evolve2::Evolve2() {
	n1 = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:548
byps::test::api::ver::Evolve2::Evolve2(int32_t n1)
	: n1(n1)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::ver::Evolve2::BSerializable_getTypeId() {
	return 573592593; 
}
void Evolve2::setN1(int32_t v) {
	n1 = v;
}
// checkpoint byps.gen.cpp.GenApiClass:888
void Evolve2::serialize(BIO& ar, const BVERSION version) {
	ar & this->n1;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_573592593(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::ver::Evolve2>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:913
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
// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_1201775504(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray4< int8_t > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_1361632968(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< wchar_t > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_769021986(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray4< wchar_t > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_1359468275(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< double > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_2087445849(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray4< double > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_766441794(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< float > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_1516687588(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray4< float > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_100361105(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< int32_t > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_1957744307(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray2< int32_t > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_196606293(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray3< int32_t > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_39910537(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray4< int32_t > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_1950626768(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< PContentStream > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_183594037(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< PSerializable > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_340213335(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray2< PSerializable > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_527503353(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray3< PSerializable > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_124584219(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray4< PSerializable > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:945
namespace byps { namespace test { namespace api { 
void BSerializer_819140569(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< byps::test::api::enu::EnumPlanets >>(bio, pObj, pObjS, pBase);	
}
}}}
