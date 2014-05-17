#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace remote { 
byps_ptr< ::std::set< PArrayInt > > BStub_RemoteSetTypes::getInt2()  {
	BSyncResultT< byps_ptr< ::std::set< PArrayInt > > > syncResult;	
	getInt2([&syncResult](byps_ptr< ::std::set< PArrayInt > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getInt2(::std::function< void (byps_ptr< ::std::set< PArrayInt > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_getInt2());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< PArrayInt > >, byps::test::api::BResult_1406124761 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteSetTypes::setInt2(const byps_ptr< ::std::set< PArrayInt > >& int2)  {
	BSyncResultT< bool > syncResult;	
	setInt2(int2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setInt2(const byps_ptr< ::std::set< PArrayInt > >& int2, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_setInt2(int2));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps_ptr< ::std::set< PSerializable > > BStub_RemoteSetTypes::getObj1()  {
	BSyncResultT< byps_ptr< ::std::set< PSerializable > > > syncResult;	
	getObj1([&syncResult](byps_ptr< ::std::set< PSerializable > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getObj1(::std::function< void (byps_ptr< ::std::set< PSerializable > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_getObj1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< PSerializable > >, byps::test::api::BResult_14 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteSetTypes::setObj1(const byps_ptr< ::std::set< PSerializable > >& obj1)  {
	BSyncResultT< bool > syncResult;	
	setObj1(obj1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setObj1(const byps_ptr< ::std::set< PSerializable > >& obj1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_setObj1(obj1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteSetTypes::setDate1(const byps::PSetDate& obj1)  {
	BSyncResultT< bool > syncResult;	
	setDate1(obj1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setDate1(const byps::PSetDate& obj1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_setDate1(obj1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PSetDate BStub_RemoteSetTypes::getDate1()  {
	BSyncResultT< byps::PSetDate > syncResult;	
	getDate1([&syncResult](byps::PSetDate v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getDate1(::std::function< void (byps::PSetDate, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_getDate1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PSetDate, byps::test::api::BResult_1097919350 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_1900796440(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::remote::BStub_RemoteSetTypes(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}



namespace byps { namespace test { namespace api { namespace remote { 
BStub_RemoteStreams::BStub_RemoteStreams(PTransport transport) 
	: BStub(transport) {}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PContentStream BStub_RemoteStreams::getImage()  {
	BSyncResultT< PContentStream > syncResult;	
	getImage([&syncResult](PContentStream v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteStreams::getImage(::std::function< void (PContentStream, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteStreams_getImage());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PContentStream, byps::test::api::BResult_15 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteStreams::setImage(const PContentStream& istrm)  {
	BSyncResultT< bool > syncResult;	
	setImage(istrm, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteStreams::setImage(const PContentStream& istrm, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteStreams_setImage(istrm));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PMapIntegerInputStream BStub_RemoteStreams::getImages()  {
	BSyncResultT< byps::PMapIntegerInputStream > syncResult;	
	getImages([&syncResult](byps::PMapIntegerInputStream v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteStreams::getImages(::std::function< void (byps::PMapIntegerInputStream, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteStreams_getImages());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PMapIntegerInputStream, byps::test::api::BResult_476459792 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteStreams::setImages(const byps::PMapIntegerInputStream& istrms, int32_t doNotReadStreamAtKey)  {
	BSyncResultT< bool > syncResult;	
	setImages(istrms, doNotReadStreamAtKey, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteStreams::setImages(const byps::PMapIntegerInputStream& istrms, int32_t doNotReadStreamAtKey, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteStreams_setImages(istrms, doNotReadStreamAtKey));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteStreams::throwLastException()  {
	BSyncResultT< bool > syncResult;	
	throwLastException([&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteStreams::throwLastException(::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteStreams_throwLastException());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PContentStream BStub_RemoteStreams::getTextStream()  {
	BSyncResultT< PContentStream > syncResult;	
	getTextStream([&syncResult](PContentStream v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteStreams::getTextStream(::std::function< void (PContentStream, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteStreams_getTextStream());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PContentStream, byps::test::api::BResult_15 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PContentStream BStub_RemoteStreams::getStreamDeferedProperies()  {
	BSyncResultT< PContentStream > syncResult;	
	getStreamDeferedProperies([&syncResult](PContentStream v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteStreams::getStreamDeferedProperies(::std::function< void (PContentStream, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteStreams_getStreamDeferedProperies());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PContentStream, byps::test::api::BResult_15 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteStreams::setStreamDoNotMaterialize(const PContentStream& stream)  {
	BSyncResultT< bool > syncResult;	
	setStreamDoNotMaterialize(stream, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteStreams::setStreamDoNotMaterialize(const PContentStream& stream, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteStreams_setStreamDoNotMaterialize(stream));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PContentStream BStub_RemoteStreams::getStreamDoNotClone()  {
	BSyncResultT< PContentStream > syncResult;	
	getStreamDoNotClone([&syncResult](PContentStream v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteStreams::getStreamDoNotClone(::std::function< void (PContentStream, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteStreams_getStreamDoNotClone());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PContentStream, byps::test::api::BResult_15 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_1043578866(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::remote::BStub_RemoteStreams(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}



namespace byps { namespace test { namespace api { namespace remote { 
BStub_RemoteWithAuthentication::BStub_RemoteWithAuthentication(PTransport transport) 
	: BStub(transport) {}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteWithAuthentication::setUseAuthentication(bool useAuth)  {
	BSyncResultT< bool > syncResult;	
	setUseAuthentication(useAuth, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteWithAuthentication::setUseAuthentication(bool useAuth, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteWithAuthentication_setUseAuthentication(useAuth));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::test::api::auth::PSessionInfo BStub_RemoteWithAuthentication::login(const ::std::wstring& userName, const ::std::wstring& userPwd)  {
	BSyncResultT< byps::test::api::auth::PSessionInfo > syncResult;	
	login(userName, userPwd, [&syncResult](byps::test::api::auth::PSessionInfo v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteWithAuthentication::login(const ::std::wstring& userName, const ::std::wstring& userPwd, ::std::function< void (byps::test::api::auth::PSessionInfo, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteWithAuthentication_login(userName, userPwd));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::test::api::auth::PSessionInfo, byps::test::api::BResult_65775978 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
int32_t BStub_RemoteWithAuthentication::doit(int32_t value)  {
	BSyncResultT< int32_t > syncResult;	
	doit(value, [&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteWithAuthentication::doit(int32_t value, ::std::function< void (int32_t, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteWithAuthentication_doit(value));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, byps::test::api::BResult_5 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteWithAuthentication::expire()  {
	BSyncResultT< bool > syncResult;	
	expire([&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteWithAuthentication::expire(::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteWithAuthentication_expire());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteWithAuthentication::setReloginCount(int32_t count)  {
	BSyncResultT< bool > syncResult;	
	setReloginCount(count, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteWithAuthentication::setReloginCount(int32_t count, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteWithAuthentication_setReloginCount(count));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_1983670399(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::remote::BStub_RemoteWithAuthentication(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}


namespace byps { namespace test { namespace api { namespace srvr { 

int32_t BSkeleton_ClientIF::incrementInt(int32_t a)  {
	throw BException(BExceptionC::UNSUPPORTED_METHOD, L"");
}
void BSkeleton_ClientIF::incrementInt(int32_t a, ::std::function< void (int32_t, BException ex) > asyncResult)  {
	int32_t __byps__ret = int32_t();
	try {
		__byps__ret = incrementInt(a);
		asyncResult(__byps__ret, BException());
	} catch (const std::exception& __byps__ex) {
		asyncResult(__byps__ret, __byps__ex);
	}
}
byps::PVectorInputStream BSkeleton_ClientIF::getStreams(int32_t ctrl)  {
	throw BException(BExceptionC::UNSUPPORTED_METHOD, L"");
}
void BSkeleton_ClientIF::getStreams(int32_t ctrl, ::std::function< void (byps::PVectorInputStream, BException ex) > asyncResult)  {
	byps::PVectorInputStream __byps__ret = byps::PVectorInputStream();
	try {
		__byps__ret = getStreams(ctrl);
		asyncResult(__byps__ret, BException());
	} catch (const std::exception& __byps__ex) {
		asyncResult(__byps__ret, __byps__ex);
	}
}
void BSkeleton_ClientIF::putStreams(const byps::PVectorInputStream& strm, int32_t ctrl)  {
	throw BException(BExceptionC::UNSUPPORTED_METHOD, L"");
}
void BSkeleton_ClientIF::putStreams(const byps::PVectorInputStream& strm, int32_t ctrl, ::std::function< void (bool, BException ex) > asyncResult)  {
	bool __byps__ret = false;
	try {
		putStreams(strm, ctrl);
		asyncResult(__byps__ret, BException());
	} catch (const std::exception& __byps__ex) {
		asyncResult(__byps__ret, __byps__ex);
	}
}
PChatStructure BSkeleton_ClientIF::sendChat(const PChatStructure& cs)  {
	throw BException(BExceptionC::UNSUPPORTED_METHOD, L"");
}
void BSkeleton_ClientIF::sendChat(const PChatStructure& cs, ::std::function< void (PChatStructure, BException ex) > asyncResult)  {
	PChatStructure __byps__ret = PChatStructure();
	try {
		__byps__ret = sendChat(cs);
		asyncResult(__byps__ret, BException());
	} catch (const std::exception& __byps__ex) {
		asyncResult(__byps__ret, __byps__ex);
	}
}
}}}}



namespace byps { namespace test { namespace api { namespace srvr { 
BStub_ClientIF::BStub_ClientIF(PTransport transport) 
	: BStub(transport) {}
}}}}

namespace byps { namespace test { namespace api { namespace srvr { 
int32_t BStub_ClientIF::incrementInt(int32_t a)  {
	BSyncResultT< int32_t > syncResult;	
	incrementInt(a, [&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_ClientIF::incrementInt(int32_t a, ::std::function< void (int32_t, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_ClientIF_incrementInt(a));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, byps::test::api::BResult_5 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace srvr { 
byps::PVectorInputStream BStub_ClientIF::getStreams(int32_t ctrl)  {
	BSyncResultT< byps::PVectorInputStream > syncResult;	
	getStreams(ctrl, [&syncResult](byps::PVectorInputStream v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_ClientIF::getStreams(int32_t ctrl, ::std::function< void (byps::PVectorInputStream, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_ClientIF_getStreams(ctrl));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PVectorInputStream, byps::test::api::BResult_1218831438 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace srvr { 
void BStub_ClientIF::putStreams(const byps::PVectorInputStream& strm, int32_t ctrl)  {
	BSyncResultT< bool > syncResult;	
	putStreams(strm, ctrl, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_ClientIF::putStreams(const byps::PVectorInputStream& strm, int32_t ctrl, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_ClientIF_putStreams(strm, ctrl));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace srvr { 
PChatStructure BStub_ClientIF::sendChat(const PChatStructure& cs)  {
	BSyncResultT< PChatStructure > syncResult;	
	sendChat(cs, [&syncResult](PChatStructure v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_ClientIF::sendChat(const PChatStructure& cs, ::std::function< void (PChatStructure, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_ClientIF_sendChat(cs));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PChatStructure, byps::test::api::BResult_7007 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_2049072174(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::srvr::BStub_ClientIF(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}



namespace byps { namespace test { namespace api { namespace srvr { 
BStub_ServerIF::BStub_ServerIF(PTransport transport) 
	: BStub(transport) {}
}}}}

namespace byps { namespace test { namespace api { namespace srvr { 
int32_t BStub_ServerIF::callClientIncrementInt(int32_t v)  {
	BSyncResultT< int32_t > syncResult;	
	callClientIncrementInt(v, [&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_ServerIF::callClientIncrementInt(int32_t v, ::std::function< void (int32_t, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_ServerIF_callClientIncrementInt(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, byps::test::api::BResult_5 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace srvr { 
void BStub_ServerIF::setPartner(const PClientIF& client)  {
	BSyncResultT< bool > syncResult;	
	setPartner(client, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_ServerIF::setPartner(const PClientIF& client, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_ServerIF_setPartner(client));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace srvr { 
PClientIF BStub_ServerIF::getPartner()  {
	BSyncResultT< PClientIF > syncResult;	
	getPartner([&syncResult](PClientIF v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_ServerIF::getPartner(::std::function< void (PClientIF, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_ServerIF_getPartner());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PClientIF, byps::test::api::BResult_955752991 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace srvr { 
byps::PVectorInputStream BStub_ServerIF::getStreamsFromClient(bool materializeOnServer)  {
	BSyncResultT< byps::PVectorInputStream > syncResult;	
	getStreamsFromClient(materializeOnServer, [&syncResult](byps::PVectorInputStream v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_ServerIF::getStreamsFromClient(bool materializeOnServer, ::std::function< void (byps::PVectorInputStream, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_ServerIF_getStreamsFromClient(materializeOnServer));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PVectorInputStream, byps::test::api::BResult_1218831438 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace srvr { 
void BStub_ServerIF::putStreamsOnClient(const byps::PVectorInputStream& streams)  {
	BSyncResultT< bool > syncResult;	
	putStreamsOnClient(streams, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_ServerIF::putStreamsOnClient(const byps::PVectorInputStream& streams, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_ServerIF_putStreamsOnClient(streams));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace srvr { 
void BStub_ServerIF::registerWithClientMap(int32_t id)  {
	BSyncResultT< bool > syncResult;	
	registerWithClientMap(id, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_ServerIF::registerWithClientMap(int32_t id, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_ServerIF_registerWithClientMap(id));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace srvr { 
PClientIF BStub_ServerIF::getClient(int32_t id)  {
	BSyncResultT< PClientIF > syncResult;	
	getClient(id, [&syncResult](PClientIF v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_ServerIF::getClient(int32_t id, ::std::function< void (PClientIF, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_ServerIF_getClient(id));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PClientIF, byps::test::api::BResult_955752991 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace srvr { 
byps::PSetInteger BStub_ServerIF::getClientIds()  {
	BSyncResultT< byps::PSetInteger > syncResult;	
	getClientIds([&syncResult](byps::PSetInteger v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_ServerIF::getClientIds(::std::function< void (byps::PSetInteger, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_ServerIF_getClientIds());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PSetInteger, byps::test::api::BResult_1493282670 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace srvr { 
int32_t BStub_ServerIF::callClientParallel(int32_t v)  {
	BSyncResultT< int32_t > syncResult;	
	callClientParallel(v, [&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_ServerIF::callClientParallel(int32_t v, ::std::function< void (int32_t, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_ServerIF_callClientParallel(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, byps::test::api::BResult_5 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_1775199834(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::srvr::BStub_ServerIF(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}



namespace byps { namespace test { namespace api { namespace ver { 
BStub_EvolveIF::BStub_EvolveIF(PTransport transport) 
	: BStub(transport) {}
}}}}

namespace byps { namespace test { namespace api { namespace ver { 
void BStub_EvolveIF::setEvolve(const PEvolve& obj)  {
	BSyncResultT< bool > syncResult;	
	setEvolve(obj, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_EvolveIF::setEvolve(const PEvolve& obj, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_EvolveIF_setEvolve(obj));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace ver { 
PEvolve BStub_EvolveIF::getEvolve()  {
	BSyncResultT< PEvolve > syncResult;	
	getEvolve([&syncResult](PEvolve v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_EvolveIF::getEvolve(::std::function< void (PEvolve, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_EvolveIF_getEvolve());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PEvolve, byps::test::api::BResult_1391985860 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace ver { 
void BStub_EvolveIF::setClient(const PEvolveIF& partner)  {
	BSyncResultT< bool > syncResult;	
	setClient(partner, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_EvolveIF::setClient(const PEvolveIF& partner, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_EvolveIF_setClient(partner));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace ver { 
PEvolveIF BStub_EvolveIF::getClient()  {
	BSyncResultT< PEvolveIF > syncResult;	
	getClient([&syncResult](PEvolveIF v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_EvolveIF::getClient(::std::function< void (PEvolveIF, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_EvolveIF_getClient());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PEvolveIF, byps::test::api::BResult_564008001 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace ver { 
void BStub_EvolveIF::sendEvolveToClient()  {
	BSyncResultT< bool > syncResult;	
	sendEvolveToClient([&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_EvolveIF::sendEvolveToClient(::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_EvolveIF_sendEvolveToClient());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_15377840(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::ver::BStub_EvolveIF(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}

//-------------------------------------------------
// Registry 

byps::test::api::BRegistry_Testser::BRegistry_Testser()
{
	registerClass(typeid(::byps::BArray1< bool > ), byps::test::api::BSerializer_2058423690, 2058423690);
	registerClass(typeid(::byps::BArray4< bool > ), byps::test::api::BSerializer_945713488, 945713488);
	registerClass(typeid(byps::test::api::BResult_1), byps::test::api::BSerializer_432867947, 432867947);
	registerClass(typeid(byps::test::api::BResult_10), byps::test::api::BSerializer_534004421, 534004421);
	registerClass(typeid(byps::test::api::BResult_1000), byps::test::api::BSerializer_2077138821, 2077138821);
	registerClass(typeid(byps::test::api::BResult_100361105), byps::test::api::BSerializer_498939805, 498939805);
	registerClass(typeid(byps::test::api::BResult_1050216688), byps::test::api::BSerializer_70523627, 70523627);
	registerClass(typeid(byps::test::api::BResult_1059148284), byps::test::api::BSerializer_698727944, 698727944);
	registerClass(typeid(byps::test::api::BResult_1097129250), byps::test::api::BSerializer_200721390, 200721390);
	registerClass(typeid(byps::test::api::BResult_1097919350), byps::test::api::BSerializer_428832038, 428832038);
	registerClass(typeid(byps::test::api::BResult_1174971318), byps::test::api::BSerializer_1068483136, 1068483136);
	registerClass(typeid(byps::test::api::BResult_12), byps::test::api::BSerializer_534004419, 534004419);
	registerClass(typeid(byps::test::api::BResult_1201775504), byps::test::api::BSerializer_1521577218, 1521577218);
	registerClass(typeid(byps::test::api::BResult_1218831438), byps::test::api::BSerializer_911793767, 911793767);
	registerClass(typeid(byps::test::api::BResult_124584219), byps::test::api::BSerializer_996163680, 996163680);
	registerClass(typeid(byps::test::api::BResult_1279823631), byps::test::api::BSerializer_629604454, 629604454);
	registerClass(typeid(byps::test::api::BResult_1320560671), byps::test::api::BSerializer_2041057155, 2041057155);
	registerClass(typeid(byps::test::api::BResult_1347703734), byps::test::api::BSerializer_881037921, 881037921);
	registerClass(typeid(byps::test::api::BResult_1358523233), byps::test::api::BSerializer_1693860029, 1693860029);
	registerClass(typeid(byps::test::api::BResult_1359468275), byps::test::api::BSerializer_1738389572, 1738389572);
	registerClass(typeid(byps::test::api::BResult_1361632968), byps::test::api::BSerializer_1548641599, 1548641599);
	registerClass(typeid(byps::test::api::BResult_1365696060), byps::test::api::BSerializer_809340660, 809340660);
	registerClass(typeid(byps::test::api::BResult_1366799209), byps::test::api::BSerializer_1725564610, 1725564610);
	registerClass(typeid(byps::test::api::BResult_1374008726), byps::test::api::BSerializer_1484626910, 1484626910);
	registerClass(typeid(byps::test::api::BResult_1375035164), byps::test::api::BSerializer_1920161159, 1920161159);
	registerClass(typeid(byps::test::api::BResult_1391985860), byps::test::api::BSerializer_1722268526, 1722268526);
	registerClass(typeid(byps::test::api::BResult_14), byps::test::api::BSerializer_534004417, 534004417);
	registerClass(typeid(byps::test::api::BResult_1406124761), byps::test::api::BSerializer_2127200796, 2127200796);
	registerClass(typeid(byps::test::api::BResult_1406664368), byps::test::api::BSerializer_1980364794, 1980364794);
	registerClass(typeid(byps::test::api::BResult_1457164460), byps::test::api::BSerializer_1111888832, 1111888832);
	registerClass(typeid(byps::test::api::BResult_1487265161), byps::test::api::BSerializer_149769063, 149769063);
	registerClass(typeid(byps::test::api::BResult_1488550492), byps::test::api::BSerializer_822552572, 822552572);
	registerClass(typeid(byps::test::api::BResult_1493282670), byps::test::api::BSerializer_1955210948, 1955210948);
	registerClass(typeid(byps::test::api::BResult_15), byps::test::api::BSerializer_534004416, 534004416);
	registerClass(typeid(byps::test::api::BResult_1504867122), byps::test::api::BSerializer_1210513700, 1210513700);
	registerClass(typeid(byps::test::api::BResult_1516687588), byps::test::api::BSerializer_2043070523, 2043070523);
	registerClass(typeid(byps::test::api::BResult_1555345627), byps::test::api::BSerializer_343940505, 343940505);
	registerClass(typeid(byps::test::api::BResult_1596367810), byps::test::api::BSerializer_1073221568, 1073221568);
	registerClass(typeid(byps::test::api::BResult_16), byps::test::api::BSerializer_534004415, 534004415);
	registerClass(typeid(byps::test::api::BResult_1617670280), byps::test::api::BSerializer_1330811042, 1330811042);
	registerClass(typeid(byps::test::api::BResult_1628501332), byps::test::api::BSerializer_368905437, 368905437);
	registerClass(typeid(byps::test::api::BResult_1633500852), byps::test::api::BSerializer_1231328865, 1231328865);
	registerClass(typeid(byps::test::api::BResult_1633750383), byps::test::api::BSerializer_1293200061, 1293200061);
	registerClass(typeid(byps::test::api::BResult_1661807911), byps::test::api::BSerializer_475882038, 475882038);
	registerClass(typeid(byps::test::api::BResult_17), byps::test::api::BSerializer_534004414, 534004414);
	registerClass(typeid(byps::test::api::BResult_1710660846), byps::test::api::BSerializer_1899847531, 1899847531);
	registerClass(typeid(byps::test::api::BResult_171948703), byps::test::api::BSerializer_871356108, 871356108);
	registerClass(typeid(byps::test::api::BResult_1746702954), byps::test::api::BSerializer_408452669, 408452669);
	registerClass(typeid(byps::test::api::BResult_1752158699), byps::test::api::BSerializer_1912328929, 1912328929);
	registerClass(typeid(byps::test::api::BResult_1799280818), byps::test::api::BSerializer_2052610089, 2052610089);
	registerClass(typeid(byps::test::api::BResult_181681714), byps::test::api::BSerializer_1763202727, 1763202727);
	registerClass(typeid(byps::test::api::BResult_1823330785), byps::test::api::BSerializer_114088296, 114088296);
	registerClass(typeid(byps::test::api::BResult_1831201218), byps::test::api::BSerializer_50516327, 50516327);
	registerClass(typeid(byps::test::api::BResult_183594037), byps::test::api::BSerializer_15818284, 15818284);
	registerClass(typeid(byps::test::api::BResult_184101377), byps::test::api::BSerializer_748770738, 748770738);
	registerClass(typeid(byps::test::api::BResult_1859644668), byps::test::api::BSerializer_2130431383, 2130431383);
	registerClass(typeid(byps::test::api::BResult_1888107655), byps::test::api::BSerializer_2063745441, 2063745441);
	registerClass(typeid(byps::test::api::BResult_1888799711), byps::test::api::BSerializer_2051074845, 2051074845);
	registerClass(typeid(byps::test::api::BResult_1898022288), byps::test::api::BSerializer_515346332, 515346332);
	registerClass(typeid(byps::test::api::BResult_19), byps::test::api::BSerializer_534004412, 534004412);
	registerClass(typeid(byps::test::api::BResult_1972793385), byps::test::api::BSerializer_1958357790, 1958357790);
	registerClass(typeid(byps::test::api::BResult_1973996106), byps::test::api::BSerializer_1391760319, 1391760319);
	registerClass(typeid(byps::test::api::BResult_1997002548), byps::test::api::BSerializer_1082818537, 1082818537);
	registerClass(typeid(byps::test::api::BResult_2), byps::test::api::BSerializer_432867946, 432867946);
	registerClass(typeid(byps::test::api::BResult_2028443792), byps::test::api::BSerializer_1664501789, 1664501789);
	registerClass(typeid(byps::test::api::BResult_2052431866), byps::test::api::BSerializer_1566928477, 1566928477);
	registerClass(typeid(byps::test::api::BResult_2053507648), byps::test::api::BSerializer_1814499786, 1814499786);
	registerClass(typeid(byps::test::api::BResult_2058423690), byps::test::api::BSerializer_1698849803, 1698849803);
	registerClass(typeid(byps::test::api::BResult_2064980445), byps::test::api::BSerializer_937508540, 937508540);
	registerClass(typeid(byps::test::api::BResult_2067161310), byps::test::api::BSerializer_925799231, 925799231);
	registerClass(typeid(byps::test::api::BResult_2087445849), byps::test::api::BSerializer_1650981375, 1650981375);
	registerClass(typeid(byps::test::api::BResult_21), byps::test::api::BSerializer_534004389, 534004389);
	registerClass(typeid(byps::test::api::BResult_2123584667), byps::test::api::BSerializer_253151806, 253151806);
	registerClass(typeid(byps::test::api::BResult_3), byps::test::api::BSerializer_432867945, 432867945);
	registerClass(typeid(byps::test::api::BResult_31512998), byps::test::api::BSerializer_1620912700, 1620912700);
	registerClass(typeid(byps::test::api::BResult_39910537), byps::test::api::BSerializer_245460547, 245460547);
	registerClass(typeid(byps::test::api::BResult_4), byps::test::api::BSerializer_432867944, 432867944);
	registerClass(typeid(byps::test::api::BResult_476459792), byps::test::api::BSerializer_255681041, 255681041);
	registerClass(typeid(byps::test::api::BResult_5), byps::test::api::BSerializer_432867943, 432867943);
	registerClass(typeid(byps::test::api::BResult_51898890), byps::test::api::BSerializer_905019472, 905019472);
	registerClass(typeid(byps::test::api::BResult_564008001), byps::test::api::BSerializer_1405156912, 1405156912);
	registerClass(typeid(byps::test::api::BResult_588723219), byps::test::api::BSerializer_1537615291, 1537615291);
	registerClass(typeid(byps::test::api::BResult_6), byps::test::api::BSerializer_432867942, 432867942);
	registerClass(typeid(byps::test::api::BResult_601099730), byps::test::api::BSerializer_856233055, 856233055);
	registerClass(typeid(byps::test::api::BResult_65775978), byps::test::api::BSerializer_1872312576, 1872312576);
	registerClass(typeid(byps::test::api::BResult_673917574), byps::test::api::BSerializer_2098743607, 2098743607);
	registerClass(typeid(byps::test::api::BResult_7), byps::test::api::BSerializer_432867941, 432867941);
	registerClass(typeid(byps::test::api::BResult_7007), byps::test::api::BSerializer_2076960068, 2076960068);
	registerClass(typeid(byps::test::api::BResult_758319514), byps::test::api::BSerializer_1168951451, 1168951451);
	registerClass(typeid(byps::test::api::BResult_766441794), byps::test::api::BSerializer_1167917980, 1167917980);
	registerClass(typeid(byps::test::api::BResult_769021986), byps::test::api::BSerializer_580900026, 580900026);
	registerClass(typeid(byps::test::api::BResult_8), byps::test::api::BSerializer_432867940, 432867940);
	registerClass(typeid(byps::test::api::BResult_846419204), byps::test::api::BSerializer_167272824, 167272824);
	registerClass(typeid(byps::test::api::BResult_8789515), byps::test::api::BSerializer_323111619, 323111619);
	registerClass(typeid(byps::test::api::BResult_9001), byps::test::api::BSerializer_2076900492, 2076900492);
	registerClass(typeid(byps::test::api::BResult_936607009), byps::test::api::BSerializer_968248604, 968248604);
	registerClass(typeid(byps::test::api::BResult_94341197), byps::test::api::BSerializer_1800858646, 1800858646);
	registerClass(typeid(byps::test::api::BResult_945713488), byps::test::api::BSerializer_1852992857, 1852992857);
	registerClass(typeid(byps::test::api::BResult_949340697), byps::test::api::BSerializer_996206823, 996206823);
	registerClass(typeid(byps::test::api::BResult_955752991), byps::test::api::BSerializer_695494982, 695494982);
	registerClass(typeid(byps::test::api::arr::ArrayTypes1dim), byps::test::api::BSerializer_2001, 2001);
	registerClass(typeid(byps::test::api::arr::ArrayTypes4dim), byps::test::api::BSerializer_2004, 2004);
	registerClass(typeid(byps::test::api::auth::SessionInfo), byps::test::api::BSerializer_65775978, 65775978);
	registerClass(typeid(byps::test::api::cons::AllTypesC), byps::test::api::BSerializer_930294276, 930294276);
	registerClass(typeid(byps::test::api::cons::AllTypesZ), byps::test::api::BSerializer_142458, 142458);
	registerClass(typeid(::byps::BArray2< byps::test::api::cons::PAllTypesZ > ), byps::test::api::BSerializer_81775365, 81775365);
	registerClass(typeid(byps::test::api::cons::HebrewC), byps::test::api::BSerializer_1770673942, 1770673942);
	registerClass(typeid(byps::test::api::cons::HebrewZ), byps::test::api::BSerializer_1518668429, 1518668429);
	registerClass(typeid(::byps::BArray1< byps::test::api::cons::PHebrewZ > ), byps::test::api::BSerializer_92445340, 92445340);
	registerClass(typeid(::byps::BArray1< byps::test::api::enu::EnumPlanets > ), byps::test::api::BSerializer_1441131650, 1441131650);
	registerClass(typeid(byps::test::api::enu::UsePlanets), byps::test::api::BSerializer_10000, 10000);
	registerClass(typeid(byps::test::api::inherit::BRequest_BioFruitService_certify), byps::test::api::BSerializer_1435417025, 1435417025);
	registerClass(typeid(byps::test::api::inherit::BRequest_BioLemonService_useParing), byps::test::api::BSerializer_2108700976, 2108700976);
	registerClass(typeid(byps::test::api::inherit::BRequest_FruitService_squeeze), byps::test::api::BSerializer_1290167289, 1290167289);
	registerClass(typeid(byps::test::api::inherit::BRequest_LemonService_pick), byps::test::api::BSerializer_1022088379, 1022088379);
	registerClass(typeid(byps::test::api::inherit::BRequest_PlantService_grow), byps::test::api::BSerializer_695716901, 695716901);
	registerClass(typeid(byps::test::api::inherit::BStub_BioFruitService), byps::test::api::BSerializer_363642571, 363642571);
	registerClass(typeid(byps::test::api::inherit::BStub_BioLemonService), byps::test::api::BSerializer_474058508, 474058508);
	registerClass(typeid(byps::test::api::inherit::BStub_FruitService), byps::test::api::BSerializer_715959905, 715959905);
	registerClass(typeid(byps::test::api::inherit::BStub_LemonService), byps::test::api::BSerializer_605543968, 605543968);
	registerClass(typeid(byps::test::api::inherit::BStub_PlantService), byps::test::api::BSerializer_1954605928, 1954605928);
	registerClass(typeid(byps::test::api::inherit::Class1), byps::test::api::BSerializer_6001, 6001);
	registerClass(typeid(byps::test::api::inherit::Class1Collections), byps::test::api::BSerializer_6004, 6004);
	registerClass(typeid(byps::test::api::inherit::Class2), byps::test::api::BSerializer_6002, 6002);
	registerClass(typeid(byps::test::api::inherit::Class3), byps::test::api::BSerializer_6003, 6003);
	registerClass(typeid(byps::test::api::inl::Actor), byps::test::api::BSerializer_171948703, 171948703);
	registerClass(typeid(byps::test::api::inl::Matrix2D), byps::test::api::BSerializer_135329019, 135329019);
	registerClass(typeid(byps::test::api::inl::Point2D), byps::test::api::BSerializer_1835035436, 1835035436);
	registerClass(typeid(::byps::BArray1< byps::test::api::inl::Point2D > ), byps::test::api::BSerializer_184101377, 184101377);
	registerClass(typeid(::byps::BArray2< byps::test::api::inl::Point2D > ), byps::test::api::BSerializer_827767075, 827767075);
	registerClass(typeid(::byps::BArray3< byps::test::api::inl::Point2D > ), byps::test::api::BSerializer_915212229, 915212229);
	registerClass(typeid(::byps::BArray4< byps::test::api::inl::Point2D > ), byps::test::api::BSerializer_949340697, 949340697);
	registerClass(typeid(byps::test::api::list::ListListTypes), byps::test::api::BSerializer_3002, 3002);
	registerClass(typeid(byps::test::api::list::ListTypes), byps::test::api::BSerializer_3001, 3001);
	registerClass(typeid(byps::test::api::map::MapTypes), byps::test::api::BSerializer_4001, 4001);
	registerClass(typeid(byps::test::api::prim::PrimitiveTypes), byps::test::api::BSerializer_1000, 1000);
	registerClass(typeid(::byps::BArray1< byps::test::api::prim::PPrimitiveTypes > ), byps::test::api::BSerializer_2053507648, 2053507648);
	registerClass(typeid(::byps::BArray2< byps::test::api::prim::PPrimitiveTypes > ), byps::test::api::BSerializer_2030857950, 2030857950);
	registerClass(typeid(::byps::BArray3< byps::test::api::prim::PPrimitiveTypes > ), byps::test::api::BSerializer_1739334652, 1739334652);
	registerClass(typeid(::byps::BArray4< byps::test::api::prim::PPrimitiveTypes > ), byps::test::api::BSerializer_758319514, 758319514);
	registerClass(typeid(byps::test::api::priv::PrivateMembers), byps::test::api::BSerializer_8001, 8001);
	registerClass(typeid(byps::test::api::refs::Node), byps::test::api::BSerializer_9001, 9001);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getBool), byps::test::api::BSerializer_2033416644, 2033416644);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getByte), byps::test::api::BSerializer_2033426402, 2033426402);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getChar), byps::test::api::BSerializer_2033439280, 2033439280);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDate), byps::test::api::BSerializer_2033462920, 2033462920);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDouble), byps::test::api::BSerializer_39293909, 39293909);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getFloat), byps::test::api::BSerializer_1384988990, 1384988990);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getInt), byps::test::api::BSerializer_1874061867, 1874061867);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getLong), byps::test::api::BSerializer_2033714518, 2033714518);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getObject), byps::test::api::BSerializer_263295897, 263295897);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes), byps::test::api::BSerializer_1992537556, 1992537556);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort), byps::test::api::BSerializer_1373101854, 1373101854);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString), byps::test::api::BSerializer_394678379, 394678379);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool), byps::test::api::BSerializer_201441072, 201441072);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte), byps::test::api::BSerializer_201431314, 201431314);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setChar), byps::test::api::BSerializer_201418436, 201418436);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDate), byps::test::api::BSerializer_201394796, 201394796);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDouble), byps::test::api::BSerializer_253910985, 253910985);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setFloat), byps::test::api::BSerializer_1946101450, 1946101450);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setInt), byps::test::api::BSerializer_1530512055, 1530512055);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setLong), byps::test::api::BSerializer_201143198, 201143198);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setObject), byps::test::api::BSerializer_48678821, 48678821);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes), byps::test::api::BSerializer_1362276920, 1362276920);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setShort), byps::test::api::BSerializer_1934214314, 1934214314);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setString), byps::test::api::BSerializer_180061303, 180061303);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysClass), byps::test::api::BSerializer_330036060, 330036060);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInline), byps::test::api::BSerializer_1467243283, 1467243283);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInt), byps::test::api::BSerializer_1828268517, 1828268517);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysObject), byps::test::api::BSerializer_1306614381, 1306614381);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysString), byps::test::api::BSerializer_1175231899, 1175231899);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getBool), byps::test::api::BSerializer_1874302495, 1874302495);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getByte), byps::test::api::BSerializer_1874292737, 1874292737);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getChar), byps::test::api::BSerializer_1874279859, 1874279859);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDate), byps::test::api::BSerializer_1874256219, 1874256219);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDouble), byps::test::api::BSerializer_1555969784, 1555969784);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getFloat), byps::test::api::BSerializer_2029769285, 2029769285);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getInt), byps::test::api::BSerializer_1325018648, 1325018648);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getLong), byps::test::api::BSerializer_1874004621, 1874004621);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getObject), byps::test::api::BSerializer_1253379978, 1253379978);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getPrimitiveTypes), byps::test::api::BSerializer_483228169, 483228169);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getShort), byps::test::api::BSerializer_2041656421, 2041656421);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getString), byps::test::api::BSerializer_1121997496, 1121997496);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setBool), byps::test::api::BSerializer_185807085, 185807085);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setByte), byps::test::api::BSerializer_185816843, 185816843);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setChar), byps::test::api::BSerializer_185829721, 185829721);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDate), byps::test::api::BSerializer_185853361, 185853361);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDouble), byps::test::api::BSerializer_1770586860, 1770586860);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setFloat), byps::test::api::BSerializer_1468656825, 1468656825);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setInt), byps::test::api::BSerializer_1668568460, 1668568460);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setLong), byps::test::api::BSerializer_186104959, 186104959);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setObject), byps::test::api::BSerializer_1467997054, 1467997054);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setPrimitiveTypes), byps::test::api::BSerializer_456924651, 456924651);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setShort), byps::test::api::BSerializer_1480543961, 1480543961);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setString), byps::test::api::BSerializer_1336614572, 1336614572);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteConstants_compare_AllTypesC), byps::test::api::BSerializer_1609344203, 1609344203);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteConstants_compare_HebrewC), byps::test::api::BSerializer_1711871378, 1711871378);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteEnums_getPlanet), byps::test::api::BSerializer_6352043, 6352043);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteEnums_setPlanet), byps::test::api::BSerializer_220969119, 220969119);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteInlineInstance_getActor), byps::test::api::BSerializer_600892860, 600892860);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray1dim), byps::test::api::BSerializer_188393247, 188393247);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray4dim), byps::test::api::BSerializer_188482620, 188482620);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DList), byps::test::api::BSerializer_1428313263, 1428313263);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DListList), byps::test::api::BSerializer_1650554387, 1650554387);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DMap), byps::test::api::BSerializer_646661333, 646661333);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteInlineInstance_setActor), byps::test::api::BSerializer_1162005320, 1162005320);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray1dim), byps::test::api::BSerializer_1355334613, 1355334613);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray4dim), byps::test::api::BSerializer_1355245240, 1355245240);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DList), byps::test::api::BSerializer_343422941, 343422941);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DListList), byps::test::api::BSerializer_730520735, 730520735);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DMap), byps::test::api::BSerializer_127469879, 127469879);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_getBoolean1), byps::test::api::BSerializer_2058662161, 2058662161);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_getByte1), byps::test::api::BSerializer_608486403, 608486403);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_getByte2), byps::test::api::BSerializer_608486404, 608486404);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_getChar1), byps::test::api::BSerializer_608885621, 608885621);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_getDate1), byps::test::api::BSerializer_609618461, 609618461);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_getDouble1), byps::test::api::BSerializer_2129490906, 2129490906);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_getFloat1), byps::test::api::BSerializer_1785569467, 1785569467);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_getInt1), byps::test::api::BSerializer_2098036488, 2098036488);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_getInt2), byps::test::api::BSerializer_2098036489, 2098036489);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_getInt3), byps::test::api::BSerializer_2098036490, 2098036490);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_getInt4), byps::test::api::BSerializer_2098036491, 2098036491);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_getLong1), byps::test::api::BSerializer_617417999, 617417999);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_getObj1), byps::test::api::BSerializer_2098203392, 2098203392);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_getPrimitiveTypes1), byps::test::api::BSerializer_1679973895, 1679973895);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_getShort1), byps::test::api::BSerializer_2140896613, 2140896613);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_getString1), byps::test::api::BSerializer_1597237350, 1597237350);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_setBoolean1), byps::test::api::BSerializer_2147241989, 2147241989);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_setByte1), byps::test::api::BSerializer_47373943, 47373943);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_setByte2), byps::test::api::BSerializer_47373944, 47373944);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_setChar1), byps::test::api::BSerializer_47773161, 47773161);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_setDate1), byps::test::api::BSerializer_48506001, 48506001);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_setDouble1), byps::test::api::BSerializer_228671154, 228671154);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_setFloat1), byps::test::api::BSerializer_1570952391, 1570952391);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_setInt1), byps::test::api::BSerializer_136821228, 136821228);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_setInt2), byps::test::api::BSerializer_136821227, 136821227);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_setInt3), byps::test::api::BSerializer_136821226, 136821226);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_setInt4), byps::test::api::BSerializer_136821225, 136821225);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_setLong1), byps::test::api::BSerializer_56305539, 56305539);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_setObj1), byps::test::api::BSerializer_136654324, 136654324);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_setPrimitiveTypes1), byps::test::api::BSerializer_759940243, 759940243);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_setShort1), byps::test::api::BSerializer_1939453607, 1939453607);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteListTypes_setString1), byps::test::api::BSerializer_339567886, 339567886);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_getBoolean1), byps::test::api::BSerializer_885803255, 885803255);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_getByte1), byps::test::api::BSerializer_124722647, 124722647);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_getByte2), byps::test::api::BSerializer_124722646, 124722646);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_getChar1), byps::test::api::BSerializer_124323429, 124323429);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_getDate1), byps::test::api::BSerializer_123590589, 123590589);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_getDouble1), byps::test::api::BSerializer_1890230400, 1890230400);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_getFloat1), byps::test::api::BSerializer_530925397, 530925397);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_getInt1), byps::test::api::BSerializer_827458594, 827458594);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_getInt2), byps::test::api::BSerializer_827458595, 827458595);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_getLong1), byps::test::api::BSerializer_115791051, 115791051);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_getObj1), byps::test::api::BSerializer_827625498, 827625498);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_getPrimitiveTypes1), byps::test::api::BSerializer_1745799327, 1745799327);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_getShort1), byps::test::api::BSerializer_899426613, 899426613);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_getString1), byps::test::api::BSerializer_1836497856, 1836497856);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_setBoolean1), byps::test::api::BSerializer_974383083, 974383083);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_setByte1), byps::test::api::BSerializer_685835107, 685835107);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_setByte2), byps::test::api::BSerializer_685835106, 685835106);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_setChar1), byps::test::api::BSerializer_685435889, 685435889);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_setDate1), byps::test::api::BSerializer_684703049, 684703049);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1), byps::test::api::BSerializer_467931660, 467931660);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1), byps::test::api::BSerializer_316308321, 316308321);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_setInt1), byps::test::api::BSerializer_1407399122, 1407399122);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_setInt2), byps::test::api::BSerializer_1407399121, 1407399121);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_setLong1), byps::test::api::BSerializer_676903511, 676903511);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_setObj1), byps::test::api::BSerializer_1407232218, 1407232218);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_setPrimitiveTypes1), byps::test::api::BSerializer_1629134317, 1629134317);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_setShort1), byps::test::api::BSerializer_684809537, 684809537);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteMapTypes_setString1), byps::test::api::BSerializer_100307380, 100307380);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_add), byps::test::api::BSerializer_362528512, 362528512);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_getBool), byps::test::api::BSerializer_1816157633, 1816157633);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_getByte), byps::test::api::BSerializer_1816147875, 1816147875);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_getChar), byps::test::api::BSerializer_1816134997, 1816134997);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_getDate), byps::test::api::BSerializer_1816111357, 1816111357);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_getDouble), byps::test::api::BSerializer_1513332250, 1513332250);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_getFloat), byps::test::api::BSerializer_462707289, 462707289);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_getInt), byps::test::api::BSerializer_1582599686, 1582599686);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_getLong), byps::test::api::BSerializer_1815859759, 1815859759);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_getObject), byps::test::api::BSerializer_1210742444, 1210742444);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_getPrimitiveTypes), byps::test::api::BSerializer_714626279, 714626279);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_getShort), byps::test::api::BSerializer_450820153, 450820153);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_getString), byps::test::api::BSerializer_1079359962, 1079359962);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_makeDate), byps::test::api::BSerializer_1918934973, 1918934973);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_parseDate), byps::test::api::BSerializer_578007072, 578007072);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_sendAllTypes), byps::test::api::BSerializer_677876863, 677876863);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_setBool), byps::test::api::BSerializer_243951947, 243951947);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_setByte), byps::test::api::BSerializer_243961705, 243961705);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_setChar), byps::test::api::BSerializer_243974583, 243974583);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDate), byps::test::api::BSerializer_243998223, 243998223);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDouble), byps::test::api::BSerializer_1727949326, 1727949326);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_setFloat), byps::test::api::BSerializer_1023819749, 1023819749);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_setInt), byps::test::api::BSerializer_1239049874, 1239049874);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_setLong), byps::test::api::BSerializer_244249821, 244249821);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_setObject), byps::test::api::BSerializer_1425359520, 1425359520);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_setPrimitiveTypes), byps::test::api::BSerializer_225526541, 225526541);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_setShort), byps::test::api::BSerializer_1011932613, 1011932613);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_setString), byps::test::api::BSerializer_1293977038, 1293977038);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_throwException), byps::test::api::BSerializer_1278149706, 1278149706);
	registerClass(typeid(byps::test::api::remote::BRequest_RemotePrimitiveTypes_voidFunctionVoid), byps::test::api::BSerializer_2033139391, 2033139391);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteReferences_getNode), byps::test::api::BSerializer_1366991859, 1366991859);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteReferences_setNode), byps::test::api::BSerializer_693117721, 693117721);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteServerCtrl_getPublishedRemote), byps::test::api::BSerializer_648762723, 648762723);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteServerCtrl_publishRemote), byps::test::api::BSerializer_1543768912, 1543768912);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteServerCtrl_removePublishedRemote), byps::test::api::BSerializer_135366859, 135366859);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_getBoolean1), byps::test::api::BSerializer_2114990909, 2114990909);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_getByte1), byps::test::api::BSerializer_901695825, 901695825);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_getByte2), byps::test::api::BSerializer_901695824, 901695824);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_getChar1), byps::test::api::BSerializer_901296607, 901296607);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_getDate1), byps::test::api::BSerializer_900563767, 900563767);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_getDouble1), byps::test::api::BSerializer_1751651450, 1751651450);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_getFloat1), byps::test::api::BSerializer_2080406641, 2080406641);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_getInt1), byps::test::api::BSerializer_1772226268, 1772226268);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_getInt2), byps::test::api::BSerializer_1772226269, 1772226269);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_getLong1), byps::test::api::BSerializer_892764229, 892764229);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_getObj1), byps::test::api::BSerializer_1772393172, 1772393172);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_getPrimitiveTypes1), byps::test::api::BSerializer_669274715, 669274715);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_getShort1), byps::test::api::BSerializer_1711905425, 1711905425);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_getString1), byps::test::api::BSerializer_1183412410, 1183412410);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_setBoolean1), byps::test::api::BSerializer_2091396559, 2091396559);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_setByte1), byps::test::api::BSerializer_1462808285, 1462808285);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_setByte2), byps::test::api::BSerializer_1462808284, 1462808284);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_setChar1), byps::test::api::BSerializer_1462409067, 1462409067);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_setDate1), byps::test::api::BSerializer_1461676227, 1461676227);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_setDouble1), byps::test::api::BSerializer_185153786, 185153786);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_setFloat1), byps::test::api::BSerializer_1999943579, 1999943579);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_setInt1), byps::test::api::BSerializer_462631448, 462631448);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_setInt2), byps::test::api::BSerializer_462631447, 462631447);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_setLong1), byps::test::api::BSerializer_1453876689, 1453876689);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_setObj1), byps::test::api::BSerializer_462464544, 462464544);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_setPrimitiveTypes1), byps::test::api::BSerializer_250758937, 250758937);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_setShort1), byps::test::api::BSerializer_1926522501, 1926522501);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteSetTypes_setString1), byps::test::api::BSerializer_753392826, 753392826);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteStreams_getImage), byps::test::api::BSerializer_61677379, 61677379);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteStreams_getImages), byps::test::api::BSerializer_1911998634, 1911998634);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteStreams_getStreamDeferedProperies), byps::test::api::BSerializer_1205766796, 1205766796);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteStreams_getStreamDoNotClone), byps::test::api::BSerializer_692369677, 692369677);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteStreams_getTextStream), byps::test::api::BSerializer_818823403, 818823403);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteStreams_setImage), byps::test::api::BSerializer_622789839, 622789839);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteStreams_setImages), byps::test::api::BSerializer_2126615710, 2126615710);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteStreams_setStreamDoNotMaterialize), byps::test::api::BSerializer_199832593, 199832593);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteStreams_throwLastException), byps::test::api::BSerializer_2127402965, 2127402965);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteWithAuthentication_doit), byps::test::api::BSerializer_1251509013, 1251509013);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteWithAuthentication_expire), byps::test::api::BSerializer_72176172, 72176172);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteWithAuthentication_login), byps::test::api::BSerializer_134687724, 134687724);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteWithAuthentication_setReloginCount), byps::test::api::BSerializer_802968058, 802968058);
	registerClass(typeid(byps::test::api::remote::BRequest_RemoteWithAuthentication_setUseAuthentication), byps::test::api::BSerializer_946544530, 946544530);
	registerClass(typeid(byps::test::api::remote::BStub_RemoteArrayTypes1dim), byps::test::api::BSerializer_963816328, 963816328);
	registerClass(typeid(byps::test::api::remote::BStub_RemoteArrayTypes23), byps::test::api::BSerializer_769717182, 769717182);
	registerClass(typeid(byps::test::api::remote::BStub_RemoteArrayTypes4dim), byps::test::api::BSerializer_963726955, 963726955);
	registerClass(typeid(byps::test::api::remote::BStub_RemoteConstants), byps::test::api::BSerializer_2045242510, 2045242510);
	registerClass(typeid(byps::test::api::remote::BStub_RemoteEnums), byps::test::api::BSerializer_485761455, 485761455);
	registerClass(typeid(byps::test::api::remote::BStub_RemoteInlineInstance), byps::test::api::BSerializer_567395951, 567395951);
	registerClass(typeid(byps::test::api::remote::BStub_RemoteListTypes), byps::test::api::BSerializer_1233438138, 1233438138);
	registerClass(typeid(byps::test::api::remote::BStub_RemoteMapTypes), byps::test::api::BSerializer_664304990, 664304990);
	registerClass(typeid(byps::test::api::remote::BStub_RemotePrimitiveTypes), byps::test::api::BSerializer_1178916877, 1178916877);
	registerClass(typeid(byps::test::api::remote::BStub_RemoteReferences), byps::test::api::BSerializer_568637225, 568637225);
	registerClass(typeid(byps::test::api::remote::BStub_RemoteServerCtrl), byps::test::api::BSerializer_1652234479, 1652234479);
	registerClass(typeid(byps::test::api::remote::BStub_RemoteSetTypes), byps::test::api::BSerializer_1900796440, 1900796440);
	registerClass(typeid(byps::test::api::remote::BStub_RemoteStreams), byps::test::api::BSerializer_1043578866, 1043578866);
	registerClass(typeid(byps::test::api::remote::BStub_RemoteWithAuthentication), byps::test::api::BSerializer_1983670399, 1983670399);
	registerClass(typeid(byps::test::api::set::SetTypes), byps::test::api::BSerializer_5001, 5001);
	registerClass(typeid(byps::test::api::srvr::BRequest_ClientIF_getStreams), byps::test::api::BSerializer_1654980071, 1654980071);
	registerClass(typeid(byps::test::api::srvr::BRequest_ClientIF_incrementInt), byps::test::api::BSerializer_1685952420, 1685952420);
	registerClass(typeid(byps::test::api::srvr::BRequest_ClientIF_putStreams), byps::test::api::BSerializer_2016865344, 2016865344);
	registerClass(typeid(byps::test::api::srvr::BRequest_ClientIF_sendChat), byps::test::api::BSerializer_41050276, 41050276);
	registerClass(typeid(byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt), byps::test::api::BSerializer_389860173, 389860173);
	registerClass(typeid(byps::test::api::srvr::BRequest_ServerIF_callClientParallel), byps::test::api::BSerializer_772308436, 772308436);
	registerClass(typeid(byps::test::api::srvr::BRequest_ServerIF_getClient), byps::test::api::BSerializer_190669475, 190669475);
	registerClass(typeid(byps::test::api::srvr::BRequest_ServerIF_getClientIds), byps::test::api::BSerializer_2007476251, 2007476251);
	registerClass(typeid(byps::test::api::srvr::BRequest_ServerIF_getPartner), byps::test::api::BSerializer_1025664374, 1025664374);
	registerClass(typeid(byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient), byps::test::api::BSerializer_1679867754, 1679867754);
	registerClass(typeid(byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient), byps::test::api::BSerializer_1934886286, 1934886286);
	registerClass(typeid(byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap), byps::test::api::BSerializer_1533268444, 1533268444);
	registerClass(typeid(byps::test::api::srvr::BRequest_ServerIF_setPartner), byps::test::api::BSerializer_1332497686, 1332497686);
	registerClass(typeid(byps::test::api::srvr::BStub_ClientIF), byps::test::api::BSerializer_2049072174, 2049072174);
	registerClass(typeid(byps::test::api::srvr::BStub_ServerIF), byps::test::api::BSerializer_1775199834, 1775199834);
	registerClass(typeid(byps::test::api::srvr::ChatStructure), byps::test::api::BSerializer_7007, 7007);
	registerClass(typeid(byps::test::api::strm::Stream1), byps::test::api::BSerializer_1541129345, 1541129345);
	registerClass(typeid(byps::test::api::ver::BRequest_EvolveIF_getClient), byps::test::api::BSerializer_1212621223, 1212621223);
	registerClass(typeid(byps::test::api::ver::BRequest_EvolveIF_getEvolve), byps::test::api::BSerializer_1279300441, 1279300441);
	registerClass(typeid(byps::test::api::ver::BRequest_EvolveIF_sendEvolveToClient), byps::test::api::BSerializer_714115141, 714115141);
	registerClass(typeid(byps::test::api::ver::BRequest_EvolveIF_setClient), byps::test::api::BSerializer_998004147, 998004147);
	registerClass(typeid(byps::test::api::ver::BRequest_EvolveIF_setEvolve), byps::test::api::BSerializer_1064683365, 1064683365);
	registerClass(typeid(byps::test::api::ver::BStub_EvolveIF), byps::test::api::BSerializer_15377840, 15377840);
	registerClass(typeid(byps::test::api::ver::Evolve), byps::test::api::BSerializer_1391985860, 1391985860);
	registerClass(typeid(byps::test::api::ver::Evolve2), byps::test::api::BSerializer_573592593, 573592593);
	registerClass(typeid(BBytes), byps::test::api::BSerializer_1374008726, 1374008726);
	registerClass(typeid(::byps::BArray4< int8_t > ), byps::test::api::BSerializer_1201775504, 1201775504);
	registerClass(typeid(::byps::BArray1< wchar_t > ), byps::test::api::BSerializer_1361632968, 1361632968);
	registerClass(typeid(::byps::BArray4< wchar_t > ), byps::test::api::BSerializer_769021986, 769021986);
	registerClass(typeid(::byps::BArray1< double > ), byps::test::api::BSerializer_1359468275, 1359468275);
	registerClass(typeid(::byps::BArray4< double > ), byps::test::api::BSerializer_2087445849, 2087445849);
	registerClass(typeid(::byps::BArray1< float > ), byps::test::api::BSerializer_766441794, 766441794);
	registerClass(typeid(::byps::BArray4< float > ), byps::test::api::BSerializer_1516687588, 1516687588);
	registerClass(typeid(::byps::BArray1< int32_t > ), byps::test::api::BSerializer_100361105, 100361105);
	registerClass(typeid(::byps::BArray2< int32_t > ), byps::test::api::BSerializer_1957744307, 1957744307);
	registerClass(typeid(::byps::BArray3< int32_t > ), byps::test::api::BSerializer_196606293, 196606293);
	registerClass(typeid(::byps::BArray4< int32_t > ), byps::test::api::BSerializer_39910537, 39910537);
	registerClass(typeid(::byps::BArray1< PContentStream > ), byps::test::api::BSerializer_1950626768, 1950626768);
	registerClass(typeid(::byps::BArray1< PSerializable > ), byps::test::api::BSerializer_183594037, 183594037);
	registerClass(typeid(::byps::BArray2< PSerializable > ), byps::test::api::BSerializer_340213335, 340213335);
	registerClass(typeid(::byps::BArray3< PSerializable > ), byps::test::api::BSerializer_527503353, 527503353);
	registerClass(typeid(::byps::BArray4< PSerializable > ), byps::test::api::BSerializer_124584219, 124584219);
	registerClass(typeid(::byps::BArray1< ::std::wstring > ), byps::test::api::BSerializer_1888107655, 1888107655);
	registerClass(typeid(::byps::BArray2< ::std::wstring > ), byps::test::api::BSerializer_1995260457, 1995260457);
	registerClass(typeid(::byps::BArray3< ::std::wstring > ), byps::test::api::BSerializer_1889888075, 1889888075);
	registerClass(typeid(::byps::BArray4< ::std::wstring > ), byps::test::api::BSerializer_588723219, 588723219);
	registerClass(typeid(::std::vector< byps::test::api::enu::EnumPlanets >), byps::test::api::BSerializer_819140569, 819140569);
	registerClass(typeid(::byps::BArray1< BDateTime > ), byps::test::api::BSerializer_1406664368, 1406664368);
	registerClass(typeid(::byps::BArray4< BDateTime > ), byps::test::api::BSerializer_51898890, 51898890);
	registerClass(typeid(::std::map< double , int8_t >), byps::test::api::BSerializer_1972793385, 1972793385);
	registerClass(typeid(::std::set< int8_t >), byps::test::api::BSerializer_31512998, 31512998);
	registerClass(typeid(::std::vector< byps::test::api::inherit::PClass1 >), byps::test::api::BSerializer_510524840, 510524840);
	registerClass(typeid(::std::vector< byps::test::api::inl::Point2D >), byps::test::api::BSerializer_2064980445, 2064980445);
	registerClass(typeid(::std::vector< byps::test::api::prim::PPrimitiveTypes >), byps::test::api::BSerializer_1596367810, 1596367810);
	registerClass(typeid(::std::vector< byps::test::api::refs::PNode >), byps::test::api::BSerializer_1442786648, 1442786648);
	registerClass(typeid(::std::vector< PBytes >), byps::test::api::BSerializer_1174971318, 1174971318);
	registerClass(typeid(::std::vector< PArrayInt >), byps::test::api::BSerializer_1752158699, 1752158699);
	registerClass(typeid(::std::vector< PArray4Int >), byps::test::api::BSerializer_1088217157, 1088217157);
	registerClass(typeid(::std::vector< PContentStream >), byps::test::api::BSerializer_1218831438, 1218831438);
	registerClass(typeid(::std::vector< bool >), byps::test::api::BSerializer_1617670280, 1617670280);
	registerClass(typeid(::std::vector< int8_t >), byps::test::api::BSerializer_1059148284, 1059148284);
	registerClass(typeid(::std::vector< wchar_t >), byps::test::api::BSerializer_1661807911, 1661807911);
	registerClass(typeid(::std::vector< double >), byps::test::api::BSerializer_1555345627, 1555345627);
	registerClass(typeid(::std::vector< float >), byps::test::api::BSerializer_1628501332, 1628501332);
	registerClass(typeid(::std::vector< int32_t >), byps::test::api::BSerializer_181681714, 181681714);
	registerClass(typeid(::std::vector< int64_t >), byps::test::api::BSerializer_1050216688, 1050216688);
	registerClass(typeid(::std::vector< int16_t >), byps::test::api::BSerializer_1997002548, 1997002548);
	registerClass(typeid(::std::vector< ::std::wstring >), byps::test::api::BSerializer_2123584667, 2123584667);
	registerClass(typeid(::std::vector< BDateTime >), byps::test::api::BSerializer_1504867122, 1504867122);
	registerClass(typeid(::std::vector< byps::test::api::inl::PVectorPoint2D >), byps::test::api::BSerializer_1823330785, 1823330785);
	registerClass(typeid(::std::vector< byps_ptr< ::std::vector< PArray4Int > > >), byps::test::api::BSerializer_1865834185, 1865834185);
	registerClass(typeid(::std::vector< byps::PVectorInteger >), byps::test::api::BSerializer_1746702954, 1746702954);
	registerClass(typeid(::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > >), byps::test::api::BSerializer_1633500852, 1633500852);
	registerClass(typeid(::std::vector< byps::PSetInteger >), byps::test::api::BSerializer_724129228, 724129228);
	registerClass(typeid(::std::map< int8_t , double >), byps::test::api::BSerializer_1487265161, 1487265161);
	registerClass(typeid(::std::map< wchar_t , float >), byps::test::api::BSerializer_94341197, 94341197);
	registerClass(typeid(::std::map< int32_t , byps::test::api::inl::Point2D >), byps::test::api::BSerializer_1358523233, 1358523233);
	registerClass(typeid(::std::map< int32_t , byps::test::api::prim::PPrimitiveTypes >), byps::test::api::BSerializer_1831201218, 1831201218);
	registerClass(typeid(::std::map< int32_t , PBytes >), byps::test::api::BSerializer_1799280818, 1799280818);
	registerClass(typeid(::std::map< int32_t , PArrayInt >), byps::test::api::BSerializer_1633750383, 1633750383);
	registerClass(typeid(::std::map< int32_t , PContentStream >), byps::test::api::BSerializer_779528402, 779528402);
	registerClass(typeid(::std::map< int32_t , int32_t >), byps::test::api::BSerializer_1347703734, 1347703734);
	registerClass(typeid(::std::map< int32_t , byps::PVectorString >), byps::test::api::BSerializer_132175071, 132175071);
	registerClass(typeid(::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > >), byps::test::api::BSerializer_49984088, 49984088);
	registerClass(typeid(::std::map< int64_t , int16_t >), byps::test::api::BSerializer_601099730, 601099730);
	registerClass(typeid(::std::map< int16_t , int64_t >), byps::test::api::BSerializer_1973996106, 1973996106);
	registerClass(typeid(::std::map< ::std::wstring , byps::test::api::enu::EnumPlanets >), byps::test::api::BSerializer_493795497, 493795497);
	registerClass(typeid(::std::map< ::std::wstring , byps::test::api::inherit::PClass1 >), byps::test::api::BSerializer_2058676657, 2058676657);
	registerClass(typeid(::std::map< ::std::wstring , byps::test::api::refs::PNode >), byps::test::api::BSerializer_2011881553, 2011881553);
	registerClass(typeid(::std::map< ::std::wstring , bool >), byps::test::api::BSerializer_1279823631, 1279823631);
	registerClass(typeid(::std::map< ::std::wstring , PSerializable >), byps::test::api::BSerializer_1488550492, 1488550492);
	registerClass(typeid(::std::map< ::std::wstring , ::std::wstring >), byps::test::api::BSerializer_1710660846, 1710660846);
	registerClass(typeid(::std::map< ::std::wstring , BDateTime >), byps::test::api::BSerializer_1366799209, 1366799209);
	registerClass(typeid(::std::set< byps::test::api::inherit::PClass1 >), byps::test::api::BSerializer_484881308, 484881308);
	registerClass(typeid(::std::set< byps::test::api::prim::PPrimitiveTypes >), byps::test::api::BSerializer_673917574, 673917574);
	registerClass(typeid(::std::set< PBytes >), byps::test::api::BSerializer_2052431866, 2052431866);
	registerClass(typeid(::std::set< PArrayInt >), byps::test::api::BSerializer_1406124761, 1406124761);
	registerClass(typeid(::std::set< bool >), byps::test::api::BSerializer_1365696060, 1365696060);
	registerClass(typeid(::std::set< double >), byps::test::api::BSerializer_1320560671, 1320560671);
	registerClass(typeid(::std::set< float >), byps::test::api::BSerializer_1898022288, 1898022288);
	registerClass(typeid(::std::set< int32_t >), byps::test::api::BSerializer_1493282670, 1493282670);
	registerClass(typeid(::std::set< int64_t >), byps::test::api::BSerializer_1457164460, 1457164460);
	registerClass(typeid(::std::set< int16_t >), byps::test::api::BSerializer_2028443792, 2028443792);
	registerClass(typeid(::std::set< ::std::wstring >), byps::test::api::BSerializer_1888799711, 1888799711);
	registerClass(typeid(::std::set< BDateTime >), byps::test::api::BSerializer_1097919350, 1097919350);
	registerClass(typeid(::std::map< float , wchar_t >), byps::test::api::BSerializer_8789515, 8789515);
	registerClass(typeid(::std::map< int32_t , PContentStream >), byps::test::api::BSerializer_476459792, 476459792);
	registerClass(typeid(::std::set< wchar_t >), byps::test::api::BSerializer_936607009, 936607009);
	registerClass(typeid(::std::set< int32_t >), byps::test::api::BSerializer_855786668, 855786668);
	registerClass(typeid(::byps::BArray1< int64_t > ), byps::test::api::BSerializer_1097129250, 1097129250);
	registerClass(typeid(::byps::BArray4< int64_t > ), byps::test::api::BSerializer_846419204, 846419204);
	registerClass(typeid(::byps::BArray1< int16_t > ), byps::test::api::BSerializer_2067161310, 2067161310);
	registerClass(typeid(::byps::BArray4< int16_t > ), byps::test::api::BSerializer_1859644668, 1859644668);
}
