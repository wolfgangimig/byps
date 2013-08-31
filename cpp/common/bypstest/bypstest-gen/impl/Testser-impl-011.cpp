﻿#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ClientIF_incrementInt
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ClientIF_incrementInt::BRequest_ClientIF_incrementInt() : BMethodRequest(1784257353) {
	a = 0;
}
com::wilutions::byps::test::api::srvr::BRequest_ClientIF_incrementInt::BRequest_ClientIF_incrementInt(int32_t a)
	: BMethodRequest(1784257353) 
	, a(a)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::srvr::BRequest_ClientIF_incrementInt::serialize(BIO& ar, const BVERSION version) {
	ar & a;
}
void com::wilutions::byps::test::api::srvr::BRequest_ClientIF_incrementInt::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PClientIF __byps__remoteT = byps_ptr_cast<ClientIF>(__byps__remote);
	__byps__remoteT->async_incrementInt(a, [__byps__asyncResult](int32_t __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_5(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1461829915(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ClientIF_incrementInt& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ClientIF_incrementInt*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ClientIF_incrementInt());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ClientIF_putStreams
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ClientIF_putStreams::BRequest_ClientIF_putStreams() : BMethodRequest(1784257353) {
	ctrl = 0;
}
com::wilutions::byps::test::api::srvr::BRequest_ClientIF_putStreams::BRequest_ClientIF_putStreams(byps_ptr< ::std::vector< PContentStream > > strm, int32_t ctrl)
	: BMethodRequest(1784257353) 
	, strm(strm)
	, ctrl(ctrl)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::srvr::BRequest_ClientIF_putStreams::serialize(BIO& ar, const BVERSION version) {
	ar & ctrl;
	ar & strm;
}
void com::wilutions::byps::test::api::srvr::BRequest_ClientIF_putStreams::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PClientIF __byps__remoteT = byps_ptr_cast<ClientIF>(__byps__remote);
	__byps__remoteT->async_putStreams(strm, ctrl, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_242798857(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ClientIF_putStreams& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ClientIF_putStreams*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ClientIF_putStreams());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ClientIF_sendChat
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ClientIF_sendChat::BRequest_ClientIF_sendChat() : BMethodRequest(1784257353) {
}
com::wilutions::byps::test::api::srvr::BRequest_ClientIF_sendChat::BRequest_ClientIF_sendChat(com::wilutions::byps::test::api::srvr::PChatStructure cs)
	: BMethodRequest(1784257353) 
	, cs(cs)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::srvr::BRequest_ClientIF_sendChat::serialize(BIO& ar, const BVERSION version) {
	ar & cs;
}
void com::wilutions::byps::test::api::srvr::BRequest_ClientIF_sendChat::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PClientIF __byps__remoteT = byps_ptr_cast<ClientIF>(__byps__remote);
	__byps__remoteT->async_sendChat(cs, [__byps__asyncResult](PChatStructure __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_7007(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1352392091(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ClientIF_sendChat& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ClientIF_sendChat*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ClientIF_sendChat());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_callClientIncrementInt
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt::BRequest_ServerIF_callClientIncrementInt() : BMethodRequest(1313562065) {
	v = 0;
}
com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt::BRequest_ServerIF_callClientIncrementInt(int32_t v)
	: BMethodRequest(1313562065) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->async_callClientIncrementInt(v, [__byps__asyncResult](int32_t __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_5(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1252575894(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_callClientParallel
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientParallel::BRequest_ServerIF_callClientParallel() : BMethodRequest(1313562065) {
	v = 0;
}
com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientParallel::BRequest_ServerIF_callClientParallel(int32_t v)
	: BMethodRequest(1313562065) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientParallel::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientParallel::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->async_callClientParallel(v, [__byps__asyncResult](int32_t __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_5(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1340180893(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientParallel& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientParallel*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientParallel());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getClient
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClient::BRequest_ServerIF_getClient() : BMethodRequest(1313562065) {
	id = 0;
}
com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClient::BRequest_ServerIF_getClient(int32_t id)
	: BMethodRequest(1313562065) 
	, id(id)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClient::serialize(BIO& ar, const BVERSION version) {
	ar & id;
}
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClient::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->async_getClient(id, [__byps__asyncResult](PClientIF __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1784257353(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2107407220(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClient& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClient*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClient());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getClientIds
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClientIds::BRequest_ServerIF_getClientIds() : BMethodRequest(1313562065) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClientIds::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClientIds::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->async_getClientIds([__byps__asyncResult](byps_ptr< ::std::set< int32_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1493282670(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2063368540(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClientIds& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClientIds*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClientIds());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getPartner
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getPartner::BRequest_ServerIF_getPartner() : BMethodRequest(1313562065) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getPartner::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getPartner::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->async_getPartner([__byps__asyncResult](PClientIF __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1784257353(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_748402113(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getPartner& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getPartner*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getPartner());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getStreamsFromClient
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient::BRequest_ServerIF_getStreamsFromClient() : BMethodRequest(1313562065) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->async_getStreamsFromClient([__byps__asyncResult](byps_ptr< ::std::vector< PContentStream > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1218831438(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1415283169(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_putStreamsOnClient
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient::BRequest_ServerIF_putStreamsOnClient() : BMethodRequest(1313562065) {
}
com::wilutions::byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient::BRequest_ServerIF_putStreamsOnClient(byps_ptr< ::std::vector< PContentStream > > streams)
	: BMethodRequest(1313562065) 
	, streams(streams)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient::serialize(BIO& ar, const BVERSION version) {
	ar & streams;
}
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->async_putStreamsOnClient(streams, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1367013829(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_registerWithClientMap
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap::BRequest_ServerIF_registerWithClientMap() : BMethodRequest(1313562065) {
	id = 0;
}
com::wilutions::byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap::BRequest_ServerIF_registerWithClientMap(int32_t id)
	: BMethodRequest(1313562065) 
	, id(id)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap::serialize(BIO& ar, const BVERSION version) {
	ar & id;
}
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->async_registerWithClientMap(id, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1921080901(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_setPartner
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ServerIF_setPartner::BRequest_ServerIF_setPartner() : BMethodRequest(1313562065) {
}
com::wilutions::byps::test::api::srvr::BRequest_ServerIF_setPartner::BRequest_ServerIF_setPartner(com::wilutions::byps::test::api::srvr::PClientIF client)
	: BMethodRequest(1313562065) 
	, client(client)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_setPartner::serialize(BIO& ar, const BVERSION version) {
	ar & client;
}
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_setPartner::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->async_setPartner(client, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1188403123(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ServerIF_setPartner& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ServerIF_setPartner*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ServerIF_setPartner());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class ChatStructure
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::ChatStructure::ChatStructure() {
	sentAt = 0;
	receivedAt = 0;
}
com::wilutions::byps::test::api::srvr::ChatStructure::ChatStructure(::std::wstring msg, double sentAt, double receivedAt)
	: msg(msg)
	, sentAt(sentAt)
	, receivedAt(receivedAt)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::srvr::ChatStructure::serialize(BIO& ar, const BVERSION version) {
	ar & msg;
	ar & receivedAt;
	ar & sentAt;
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_7007(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::ChatStructure& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::ChatStructure*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::ChatStructure());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace strm { 

//-------------------------------------------------
// Implementation of class Stream1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::strm::Stream1::Stream1() {
}
com::wilutions::byps::test::api::strm::Stream1::Stream1(PContentStream is1, ::std::wstring contentType, byps_ptr< BArray1< PContentStream > > arrStream, byps_ptr< ::std::vector< PContentStream > > listStream, byps_ptr< ::std::map< int32_t , PContentStream > > mapStream)
	: is1(is1)
	, contentType(contentType)
	, arrStream(arrStream)
	, listStream(listStream)
	, mapStream(mapStream)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::strm::Stream1::serialize(BIO& ar, const BVERSION version) {
	ar & contentType;
	ar & arrStream;
	ar & is1;
	ar & listStream;
	ar & mapStream;
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1541129345(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::strm::Stream1& r = * dynamic_cast< com::wilutions::byps::test::api::strm::Stream1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::strm::Stream1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_getClient
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::ver::BRequest_EvolveIF_getClient::BRequest_EvolveIF_getClient() : BMethodRequest(2078696281) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::ver::BRequest_EvolveIF_getClient::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::ver::BRequest_EvolveIF_getClient::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PEvolveIF __byps__remoteT = byps_ptr_cast<EvolveIF>(__byps__remote);
	__byps__remoteT->async_getClient([__byps__asyncResult](PEvolveIF __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2078696281(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_98720592(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::ver::BRequest_EvolveIF_getClient& r = * dynamic_cast< com::wilutions::byps::test::api::ver::BRequest_EvolveIF_getClient*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::ver::BRequest_EvolveIF_getClient());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_getEvolve
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::ver::BRequest_EvolveIF_getEvolve::BRequest_EvolveIF_getEvolve() : BMethodRequest(2078696281) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::ver::BRequest_EvolveIF_getEvolve::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::ver::BRequest_EvolveIF_getEvolve::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PEvolveIF __byps__remoteT = byps_ptr_cast<EvolveIF>(__byps__remote);
	__byps__remoteT->async_getEvolve([__byps__asyncResult](PEvolve __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1391985860(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_32041374(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::ver::BRequest_EvolveIF_getEvolve& r = * dynamic_cast< com::wilutions::byps::test::api::ver::BRequest_EvolveIF_getEvolve*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::ver::BRequest_EvolveIF_getEvolve());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_sendEvolveToClient
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::ver::BRequest_EvolveIF_sendEvolveToClient::BRequest_EvolveIF_sendEvolveToClient() : BMethodRequest(2078696281) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::ver::BRequest_EvolveIF_sendEvolveToClient::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::ver::BRequest_EvolveIF_sendEvolveToClient::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PEvolveIF __byps__remoteT = byps_ptr_cast<EvolveIF>(__byps__remote);
	__byps__remoteT->async_sendEvolveToClient([__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1425170268(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::ver::BRequest_EvolveIF_sendEvolveToClient& r = * dynamic_cast< com::wilutions::byps::test::api::ver::BRequest_EvolveIF_sendEvolveToClient*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::ver::BRequest_EvolveIF_sendEvolveToClient());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_setClient
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::ver::BRequest_EvolveIF_setClient::BRequest_EvolveIF_setClient() : BMethodRequest(2078696281) {
}
com::wilutions::byps::test::api::ver::BRequest_EvolveIF_setClient::BRequest_EvolveIF_setClient(com::wilutions::byps::test::api::ver::PEvolveIF partner)
	: BMethodRequest(2078696281) 
	, partner(partner)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::ver::BRequest_EvolveIF_setClient::serialize(BIO& ar, const BVERSION version) {
	ar & partner;
}
void com::wilutions::byps::test::api::ver::BRequest_EvolveIF_setClient::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PEvolveIF __byps__remoteT = byps_ptr_cast<EvolveIF>(__byps__remote);
	__byps__remoteT->async_setClient(partner, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_313337668(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::ver::BRequest_EvolveIF_setClient& r = * dynamic_cast< com::wilutions::byps::test::api::ver::BRequest_EvolveIF_setClient*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::ver::BRequest_EvolveIF_setClient());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_setEvolve
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::ver::BRequest_EvolveIF_setEvolve::BRequest_EvolveIF_setEvolve() : BMethodRequest(2078696281) {
}
com::wilutions::byps::test::api::ver::BRequest_EvolveIF_setEvolve::BRequest_EvolveIF_setEvolve(com::wilutions::byps::test::api::ver::PEvolve obj)
	: BMethodRequest(2078696281) 
	, obj(obj)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::ver::BRequest_EvolveIF_setEvolve::serialize(BIO& ar, const BVERSION version) {
	ar & obj;
}
void com::wilutions::byps::test::api::ver::BRequest_EvolveIF_setEvolve::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PEvolveIF __byps__remoteT = byps_ptr_cast<EvolveIF>(__byps__remote);
	__byps__remoteT->async_setEvolve(obj, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_246658450(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::ver::BRequest_EvolveIF_setEvolve& r = * dynamic_cast< com::wilutions::byps::test::api::ver::BRequest_EvolveIF_setEvolve*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::ver::BRequest_EvolveIF_setEvolve());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class Evolve
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::ver::Evolve::Evolve() {
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
com::wilutions::byps::test::api::ver::Evolve::Evolve(bool bool1, int8_t byte1, wchar_t char1, int16_t short1, int32_t int1, int64_t long1, float float1, double double1, byps_ptr< BArray1< bool > > bools1, PBytes bytes1, byps_ptr< BArray1< wchar_t > > chars1, byps_ptr< BArray1< int16_t > > shorts1, byps_ptr< BArray1< int32_t > > ints1, byps_ptr< BArray1< int64_t > > longs1, byps_ptr< BArray1< float > > floats1, byps_ptr< BArray1< double > > doubles1, ::std::wstring str1, PSerializable obj1, com::wilutions::byps::test::api::ver::PEvolve2 evo1, byps_ptr< ::std::vector< int32_t > > list1, byps_ptr< ::std::set< int32_t > > set1, byps_ptr< ::std::map< int32_t , int32_t > > map1, bool bool2, int8_t byte2, wchar_t char2, int16_t short2, int32_t int2, int64_t long2, float float2, double double2, byps_ptr< BArray1< bool > > bools2, PBytes bytes2, byps_ptr< BArray1< wchar_t > > chars2, byps_ptr< BArray1< int16_t > > shorts2, byps_ptr< BArray1< int32_t > > ints2, byps_ptr< BArray1< int64_t > > longs2, byps_ptr< BArray1< float > > floats2, byps_ptr< BArray1< double > > doubles2, ::std::wstring str2, PSerializable obj2, com::wilutions::byps::test::api::ver::PEvolve2 evo2, byps_ptr< ::std::vector< int32_t > > list2, byps_ptr< ::std::set< int32_t > > set2, byps_ptr< ::std::map< int32_t , int32_t > > map2, bool bool3, int8_t byte3, wchar_t char3, int16_t short3, int32_t int3, int64_t long3, float float3, double double3, byps_ptr< BArray1< bool > > bools3, PBytes bytes3, byps_ptr< BArray1< wchar_t > > chars3, byps_ptr< BArray1< int16_t > > shorts3, byps_ptr< BArray1< int32_t > > ints3, byps_ptr< BArray1< int64_t > > longs3, byps_ptr< BArray1< float > > floats3, byps_ptr< BArray1< double > > doubles3, ::std::wstring str3, PSerializable obj3, com::wilutions::byps::test::api::ver::PEvolve2 evo3, byps_ptr< ::std::vector< int32_t > > list3, byps_ptr< ::std::set< int32_t > > set3, byps_ptr< ::std::map< int32_t , int32_t > > map3)
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
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::ver::Evolve::serialize(BIO& ar, const BVERSION version) {
	ar & bool1;
	ar & byte1;
	ar & char1;
	ar & double1;
	ar & float1;
	ar & int1;
	ar & long1;
	ar & short1;
	ar & str1;
	if (version >= 2) {
		ar & bool2;
		ar & byte2;
		ar & char2;
		ar & double2;
		ar & float2;
		ar & int2;
		ar & long2;
		ar & short2;
		ar & str2;
		if (version >= 3) {
			ar & bool3;
			ar & byte3;
			ar & char3;
			ar & double3;
			ar & float3;
			ar & int3;
			ar & long3;
			ar & short3;
			ar & str3;
		}
	}
	ar & bools1;
	ar & bytes1;
	ar & chars1;
	ar & doubles1;
	ar & evo1;
	ar & floats1;
	ar & ints1;
	ar & list1;
	ar & longs1;
	ar & map1;
	ar & obj1;
	ar & set1;
	ar & shorts1;
	if (version >= 2) {
		ar & bools2;
		ar & bytes2;
		ar & chars2;
		ar & doubles2;
		ar & evo2;
		ar & floats2;
		ar & ints2;
		ar & list2;
		ar & longs2;
		ar & map2;
		ar & obj2;
		ar & set2;
		ar & shorts2;
		if (version >= 3) {
			ar & bools3;
			ar & bytes3;
			ar & chars3;
			ar & doubles3;
			ar & evo3;
			ar & floats3;
			ar & ints3;
			ar & list3;
			ar & longs3;
			ar & map3;
			ar & obj3;
			ar & set3;
			ar & shorts3;
		}
	}
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1391985860(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::ver::Evolve& r = * dynamic_cast< com::wilutions::byps::test::api::ver::Evolve*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::ver::Evolve());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class Evolve2
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::ver::Evolve2::Evolve2() {
	n1 = 0;
}
com::wilutions::byps::test::api::ver::Evolve2::Evolve2(int32_t n1)
	: n1(n1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::ver::Evolve2::serialize(BIO& ar, const BVERSION version) {
	ar & n1;
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_573592593(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::ver::Evolve2& r = * dynamic_cast< com::wilutions::byps::test::api::ver::Evolve2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::ver::Evolve2());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1359468275(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< double > & r = * reinterpret_cast< BArray1< double > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< double > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2087445849(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< double > & r = * reinterpret_cast< BArray4< double > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< double > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_766441794(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< float > & r = * reinterpret_cast< BArray1< float > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< float > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1516687588(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< float > & r = * reinterpret_cast< BArray4< float > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< float > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_100361105(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< int32_t > & r = * reinterpret_cast< BArray1< int32_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< int32_t > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1957744307(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray2< int32_t > & r = * reinterpret_cast< BArray2< int32_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray2< int32_t > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_196606293(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray3< int32_t > & r = * reinterpret_cast< BArray3< int32_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray3< int32_t > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_39910537(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< int32_t > & r = * reinterpret_cast< BArray4< int32_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< int32_t > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1950626768(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< PContentStream > & r = * reinterpret_cast< BArray1< PContentStream > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< PContentStream > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_183594037(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< PSerializable > & r = * reinterpret_cast< BArray1< PSerializable > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< PSerializable > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_340213335(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray2< PSerializable > & r = * reinterpret_cast< BArray2< PSerializable > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray2< PSerializable > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_527503353(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray3< PSerializable > & r = * reinterpret_cast< BArray3< PSerializable > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray3< PSerializable > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_124584219(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< PSerializable > & r = * reinterpret_cast< BArray4< PSerializable > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< PSerializable > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1888107655(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< ::std::wstring > & r = * reinterpret_cast< BArray1< ::std::wstring > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< ::std::wstring > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1995260457(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray2< ::std::wstring > & r = * reinterpret_cast< BArray2< ::std::wstring > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray2< ::std::wstring > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1889888075(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray3< ::std::wstring > & r = * reinterpret_cast< BArray3< ::std::wstring > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray3< ::std::wstring > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_588723219(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< ::std::wstring > & r = * reinterpret_cast< BArray4< ::std::wstring > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< ::std::wstring > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1590740862(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::vector< com::wilutions::byps::test::api::enu::EnumPlanets >& r = * reinterpret_cast< ::std::vector< com::wilutions::byps::test::api::enu::EnumPlanets >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::vector< com::wilutions::byps::test::api::enu::EnumPlanets >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1972793385(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< double , int8_t >& r = * reinterpret_cast< ::std::map< double , int8_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< double , int8_t >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_31512998(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int8_t >& r = * reinterpret_cast< ::std::set< int8_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int8_t >());
	}
}
}}}}}
