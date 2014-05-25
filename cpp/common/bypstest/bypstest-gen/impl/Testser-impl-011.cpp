#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_callClientParallel
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ServerIF_callClientParallel::BRequest_ServerIF_callClientParallel() : BMethodRequest(1775199834) {
	v = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::srvr::BRequest_ServerIF_callClientParallel::BRequest_ServerIF_callClientParallel(int32_t v)
	: BMethodRequest(1775199834) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ServerIF_callClientParallel::BSerializable_getTypeId() {
	return 772308436; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_772308436(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ServerIF_callClientParallel>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getClient
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ServerIF_getClient::BRequest_ServerIF_getClient() : BMethodRequest(1775199834) {
	id = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::srvr::BRequest_ServerIF_getClient::BRequest_ServerIF_getClient(int32_t id)
	: BMethodRequest(1775199834) 
	, id(id)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ServerIF_getClient::BSerializable_getTypeId() {
	return 190669475; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_190669475(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ServerIF_getClient>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getClientIds
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ServerIF_getClientIds::BRequest_ServerIF_getClientIds() : BMethodRequest(1775199834) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ServerIF_getClientIds::BSerializable_getTypeId() {
	return 2007476251; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_2007476251(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ServerIF_getClientIds>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getPartner
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ServerIF_getPartner::BRequest_ServerIF_getPartner() : BMethodRequest(1775199834) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ServerIF_getPartner::BSerializable_getTypeId() {
	return 1025664374; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1025664374(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ServerIF_getPartner>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getStreamsFromClient
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ServerIF_getStreamsFromClient::BRequest_ServerIF_getStreamsFromClient() : BMethodRequest(1775199834) {
	materializeOnServer = false;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient::BRequest_ServerIF_getStreamsFromClient(bool materializeOnServer)
	: BMethodRequest(1775199834) 
	, materializeOnServer(materializeOnServer)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient::BSerializable_getTypeId() {
	return 1679867754; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1679867754(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_putStreamsOnClient
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ServerIF_putStreamsOnClient::BRequest_ServerIF_putStreamsOnClient() : BMethodRequest(1775199834) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient::BRequest_ServerIF_putStreamsOnClient(const byps::PVectorInputStream& streams)
	: BMethodRequest(1775199834) 
	, streams(streams)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient::BSerializable_getTypeId() {
	return 1934886286; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1934886286(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_registerWithClientMap
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ServerIF_registerWithClientMap::BRequest_ServerIF_registerWithClientMap() : BMethodRequest(1775199834) {
	id = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap::BRequest_ServerIF_registerWithClientMap(int32_t id)
	: BMethodRequest(1775199834) 
	, id(id)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap::BSerializable_getTypeId() {
	return 1533268444; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1533268444(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_setPartner
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ServerIF_setPartner::BRequest_ServerIF_setPartner() : BMethodRequest(1775199834) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::srvr::BRequest_ServerIF_setPartner::BRequest_ServerIF_setPartner(const PClientIF& client)
	: BMethodRequest(1775199834) 
	, client(client)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BRequest_ServerIF_setPartner::BSerializable_getTypeId() {
	return 1332497686; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1332497686(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::BRequest_ServerIF_setPartner>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class ChatStructure
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
ChatStructure::ChatStructure() {
	sentAt = 0;
	receivedAt = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::srvr::ChatStructure::ChatStructure(const ::std::wstring& msg, double sentAt, double receivedAt)
	: msg(msg)
	, sentAt(sentAt)
	, receivedAt(receivedAt)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::ChatStructure::BSerializable_getTypeId() {
	return 7007; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
void ChatStructure::serialize(BIO& ar, const BVERSION version) {
	ar & this->msg;
	ar & this->receivedAt;
	ar & this->sentAt;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_7007(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::srvr::ChatStructure>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace strm { 

//-------------------------------------------------
// Implementation of class Stream1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
Stream1::Stream1() {
}
// checkpoint byps.gen.cpp.GenApiClass:536
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
// checkpoint byps.gen.cpp.GenApiClass:878
void Stream1::serialize(BIO& ar, const BVERSION version) {
	ar & this->contentType;
	ar & this->arrStream;
	ar & this->is1;
	ar & this->listStream;
	ar & this->mapStream;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1541129345(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::strm::Stream1>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_getClient
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_EvolveIF_getClient::BRequest_EvolveIF_getClient() : BMethodRequest(15377840) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::ver::BRequest_EvolveIF_getClient::BSerializable_getTypeId() {
	return 1212621223; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1212621223(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::ver::BRequest_EvolveIF_getClient>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_getEvolve
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_EvolveIF_getEvolve::BRequest_EvolveIF_getEvolve() : BMethodRequest(15377840) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::ver::BRequest_EvolveIF_getEvolve::BSerializable_getTypeId() {
	return 1279300441; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1279300441(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::ver::BRequest_EvolveIF_getEvolve>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_sendEvolveToClient
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_EvolveIF_sendEvolveToClient::BRequest_EvolveIF_sendEvolveToClient() : BMethodRequest(15377840) {
}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::ver::BRequest_EvolveIF_sendEvolveToClient::BSerializable_getTypeId() {
	return 714115141; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_714115141(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::ver::BRequest_EvolveIF_sendEvolveToClient>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_setClient
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_EvolveIF_setClient::BRequest_EvolveIF_setClient() : BMethodRequest(15377840) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::ver::BRequest_EvolveIF_setClient::BRequest_EvolveIF_setClient(const PEvolveIF& partner)
	: BMethodRequest(15377840) 
	, partner(partner)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::ver::BRequest_EvolveIF_setClient::BSerializable_getTypeId() {
	return 998004147; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_998004147(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::ver::BRequest_EvolveIF_setClient>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_setEvolve
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_EvolveIF_setEvolve::BRequest_EvolveIF_setEvolve() : BMethodRequest(15377840) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::ver::BRequest_EvolveIF_setEvolve::BRequest_EvolveIF_setEvolve(const PEvolve& obj)
	: BMethodRequest(15377840) 
	, obj(obj)
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::ver::BRequest_EvolveIF_setEvolve::BSerializable_getTypeId() {
	return 1064683365; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1064683365(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::ver::BRequest_EvolveIF_setEvolve>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class Evolve
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
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
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::ver::Evolve::Evolve(bool bool1, int8_t byte1, wchar_t char1, int16_t short1, int32_t int1, int64_t long1, float float1, double double1, const PArrayBoolean& bools1, const PBytes& bytes1, const PArrayChar& chars1, const PArrayShort& shorts1, const PArrayInt& ints1, const PArrayLong& longs1, const PArrayFloat& floats1, const PArrayDouble& doubles1, const ::std::wstring& str1, const PSerializable& obj1, const PEvolve2& evo1, const byps::PVectorInteger& list1, const byps::PSetInteger& set1, const byps::PMapIntegerInteger& map1, bool bool2, int8_t byte2, wchar_t char2, int16_t short2, int32_t int2, int64_t long2, float float2, double double2, const PArrayBoolean& bools2, const PBytes& bytes2, const PArrayChar& chars2, const PArrayShort& shorts2, const PArrayInt& ints2, const PArrayLong& longs2, const PArrayFloat& floats2, const PArrayDouble& doubles2, const ::std::wstring& str2, const PSerializable& obj2, const PEvolve2& evo2, const byps::PVectorInteger& list2, const byps::PSetInteger& set2, const byps::PMapIntegerInteger& map2, bool bool3, int8_t byte3, wchar_t char3, int16_t short3, int32_t int3, int64_t long3, float float3, double double3, const PArrayBoolean& bools3, const PBytes& bytes3, const PArrayChar& chars3, const PArrayShort& shorts3, const PArrayInt& ints3, const PArrayLong& longs3, const PArrayFloat& floats3, const PArrayDouble& doubles3, const ::std::wstring& str3, const PSerializable& obj3, const PEvolve2& evo3, const byps::PVectorInteger& list3, const byps::PSetInteger& set3, const byps::PMapIntegerInteger& map3)
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
	{}
// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::ver::Evolve::BSerializable_getTypeId() {
	return 1391985860; 
}
// checkpoint byps.gen.cpp.GenApiClass:878
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
	if (version >= 2) {
		ar & this->bool2;
		ar & this->byte2;
		ar & this->char2;
		ar & this->double2;
		ar & this->float2;
		ar & this->int2;
		ar & this->long2;
		ar & this->short2;
		ar & this->str2;
		if (version >= 3) {
			ar & this->bool3;
			ar & this->byte3;
			ar & this->char3;
			ar & this->double3;
			ar & this->float3;
			ar & this->int3;
			ar & this->long3;
			ar & this->short3;
			ar & this->str3;
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
	if (version >= 2) {
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
		if (version >= 3) {
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

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1391985860(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::ver::Evolve>(bio, pObj, pObjS, pBase);	
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class Evolve2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
Evolve2::Evolve2() {
	n1 = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
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
// checkpoint byps.gen.cpp.GenApiClass:878
void Evolve2::serialize(BIO& ar, const BVERSION version) {
	ar & this->n1;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_573592593(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_ObjS_Template<byps::test::api::ver::Evolve2>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:903
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
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1201775504(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray4< int8_t > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1361632968(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< wchar_t > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_769021986(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray4< wchar_t > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1359468275(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< double > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_2087445849(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray4< double > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_766441794(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< float > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1516687588(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray4< float > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_100361105(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< int32_t > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1957744307(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray2< int32_t > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_196606293(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray3< int32_t > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_39910537(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray4< int32_t > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1950626768(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< PContentStream > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_183594037(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< PSerializable > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_340213335(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray2< PSerializable > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_527503353(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray3< PSerializable > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_124584219(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray4< PSerializable > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1888107655(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< ::std::wstring > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1995260457(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray2< ::std::wstring > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1889888075(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray3< ::std::wstring > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_588723219(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray4< ::std::wstring > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_819140569(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< byps::test::api::enu::EnumPlanets >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1406664368(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< BDateTime > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_51898890(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray4< BDateTime > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1972793385(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::map< double , int8_t >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_31512998(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::set< int8_t >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_510524840(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< byps::test::api::inherit::PClass1 >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_2064980445(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< byps::test::api::inl::Point2D >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1596367810(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< byps::test::api::prim::PPrimitiveTypes >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1442786648(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< byps::test::api::refs::PNode >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1174971318(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< PBytes >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1752158699(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< PArrayInt >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1088217157(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< PArray4Int >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1218831438(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< PContentStream >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1617670280(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< bool >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1059148284(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< int8_t >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1661807911(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< wchar_t >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1555345627(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< double >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1628501332(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< float >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_181681714(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< int32_t >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1050216688(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< int64_t >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1997002548(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< int16_t >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_2123584667(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< ::std::wstring >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1504867122(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< BDateTime >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1823330785(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< byps::test::api::inl::PVectorPoint2D >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1865834185(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< byps_ptr< ::std::vector< PArray4Int > > >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1746702954(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< byps::PVectorInteger >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1633500852(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_724129228(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::vector< byps::PSetInteger >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1487265161(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::map< int8_t , double >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_94341197(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::map< wchar_t , float >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1358523233(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::map< int32_t , byps::test::api::inl::Point2D >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1831201218(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::map< int32_t , byps::test::api::prim::PPrimitiveTypes >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1799280818(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::map< int32_t , PBytes >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1633750383(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::map< int32_t , PArrayInt >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_779528402(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::map< int32_t , PContentStream >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1347703734(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::map< int32_t , int32_t >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_132175071(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::map< int32_t , byps::PVectorString >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_49984088(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_601099730(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::map< int64_t , int16_t >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_1973996106(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::map< int16_t , int64_t >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_493795497(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::map< ::std::wstring , byps::test::api::enu::EnumPlanets >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_2058676657(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::map< ::std::wstring , byps::test::api::inherit::PClass1 >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:935
namespace byps { namespace test { namespace api { 
void BSerializer_2011881553(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::map< ::std::wstring , byps::test::api::refs::PNode >>(bio, pObj, pObjS, pBase);	
}
}}}
