#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;


namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteReferences::BStub_RemoteReferences(PTransport transport) 
	: BStub(transport) {}

com::wilutions::byps::test::api::refs::PNode BStub_RemoteReferences::getNode()  {
	BSyncResultT< com::wilutions::byps::test::api::refs::PNode > syncResult;	
	getNode([&syncResult](com::wilutions::byps::test::api::refs::PNode v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteReferences::getNode(::std::function< void (com::wilutions::byps::test::api::refs::PNode, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteReferences_getNode());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< com::wilutions::byps::test::api::refs::PNode, com::wilutions::byps::test::api::BResult_9001 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteReferences::setNode(const com::wilutions::byps::test::api::refs::PNode& v)  {
	BSyncResultT< bool > syncResult;	
	setNode(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteReferences::setNode(const com::wilutions::byps::test::api::refs::PNode& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteReferences_setNode(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2086824050(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BStub_RemoteReferences(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteServerCtrl::BStub_RemoteServerCtrl(PTransport transport) 
	: BStub(transport) {}

void BStub_RemoteServerCtrl::publishRemote(const ::std::wstring& name, const PRemote& remote, bool fowardToOtherServers)  {
	BSyncResultT< bool > syncResult;	
	publishRemote(name, remote, fowardToOtherServers, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteServerCtrl::publishRemote(const ::std::wstring& name, const PRemote& remote, bool fowardToOtherServers, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteServerCtrl_publishRemote(name, remote, fowardToOtherServers));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
PRemote BStub_RemoteServerCtrl::getPublishedRemote(const ::std::wstring& name)  {
	BSyncResultT< PRemote > syncResult;	
	getPublishedRemote(name, [&syncResult](PRemote v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteServerCtrl::getPublishedRemote(const ::std::wstring& name, ::std::function< void (PRemote, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteServerCtrl_getPublishedRemote(name));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PRemote, com::wilutions::byps::test::api::BResult_16 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteServerCtrl::removePublishedRemote(const ::std::wstring& name)  {
	BSyncResultT< bool > syncResult;	
	removePublishedRemote(name, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteServerCtrl::removePublishedRemote(const ::std::wstring& name, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteServerCtrl_removePublishedRemote(name));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1124545992(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BStub_RemoteServerCtrl(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteSetTypes::BStub_RemoteSetTypes(PTransport transport) 
	: BStub(transport) {}

byps_ptr< ::std::set< bool > > BStub_RemoteSetTypes::getBoolean1()  {
	BSyncResultT< byps_ptr< ::std::set< bool > > > syncResult;	
	getBoolean1([&syncResult](byps_ptr< ::std::set< bool > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getBoolean1(::std::function< void (byps_ptr< ::std::set< bool > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_getBoolean1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< bool > >, com::wilutions::byps::test::api::BResult_1365696060 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteSetTypes::setBoolean1(const byps_ptr< ::std::set< bool > >& boolean1)  {
	BSyncResultT< bool > syncResult;	
	setBoolean1(boolean1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setBoolean1(const byps_ptr< ::std::set< bool > >& boolean1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_setBoolean1(boolean1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::set< int8_t > > BStub_RemoteSetTypes::getByte1()  {
	BSyncResultT< byps_ptr< ::std::set< int8_t > > > syncResult;	
	getByte1([&syncResult](byps_ptr< ::std::set< int8_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getByte1(::std::function< void (byps_ptr< ::std::set< int8_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_getByte1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< int8_t > >, com::wilutions::byps::test::api::BResult_31512998 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteSetTypes::setByte1(const byps_ptr< ::std::set< int8_t > >& byte1)  {
	BSyncResultT< bool > syncResult;	
	setByte1(byte1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setByte1(const byps_ptr< ::std::set< int8_t > >& byte1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_setByte1(byte1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::set< wchar_t > > BStub_RemoteSetTypes::getChar1()  {
	BSyncResultT< byps_ptr< ::std::set< wchar_t > > > syncResult;	
	getChar1([&syncResult](byps_ptr< ::std::set< wchar_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getChar1(::std::function< void (byps_ptr< ::std::set< wchar_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_getChar1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< wchar_t > >, com::wilutions::byps::test::api::BResult_936607009 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteSetTypes::setChar1(const byps_ptr< ::std::set< wchar_t > >& char1)  {
	BSyncResultT< bool > syncResult;	
	setChar1(char1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setChar1(const byps_ptr< ::std::set< wchar_t > >& char1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_setChar1(char1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::set< int16_t > > BStub_RemoteSetTypes::getShort1()  {
	BSyncResultT< byps_ptr< ::std::set< int16_t > > > syncResult;	
	getShort1([&syncResult](byps_ptr< ::std::set< int16_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getShort1(::std::function< void (byps_ptr< ::std::set< int16_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_getShort1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< int16_t > >, com::wilutions::byps::test::api::BResult_2028443792 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteSetTypes::setShort1(const byps_ptr< ::std::set< int16_t > >& short1)  {
	BSyncResultT< bool > syncResult;	
	setShort1(short1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setShort1(const byps_ptr< ::std::set< int16_t > >& short1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_setShort1(short1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::set< int32_t > > BStub_RemoteSetTypes::getInt1()  {
	BSyncResultT< byps_ptr< ::std::set< int32_t > > > syncResult;	
	getInt1([&syncResult](byps_ptr< ::std::set< int32_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getInt1(::std::function< void (byps_ptr< ::std::set< int32_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_getInt1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< int32_t > >, com::wilutions::byps::test::api::BResult_1493282670 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteSetTypes::setInt1(const byps_ptr< ::std::set< int32_t > >& int1)  {
	BSyncResultT< bool > syncResult;	
	setInt1(int1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setInt1(const byps_ptr< ::std::set< int32_t > >& int1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_setInt1(int1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::set< int64_t > > BStub_RemoteSetTypes::getLong1()  {
	BSyncResultT< byps_ptr< ::std::set< int64_t > > > syncResult;	
	getLong1([&syncResult](byps_ptr< ::std::set< int64_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getLong1(::std::function< void (byps_ptr< ::std::set< int64_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_getLong1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< int64_t > >, com::wilutions::byps::test::api::BResult_1457164460 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteSetTypes::setLong1(const byps_ptr< ::std::set< int64_t > >& long1)  {
	BSyncResultT< bool > syncResult;	
	setLong1(long1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setLong1(const byps_ptr< ::std::set< int64_t > >& long1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_setLong1(long1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::set< float > > BStub_RemoteSetTypes::getFloat1()  {
	BSyncResultT< byps_ptr< ::std::set< float > > > syncResult;	
	getFloat1([&syncResult](byps_ptr< ::std::set< float > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getFloat1(::std::function< void (byps_ptr< ::std::set< float > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_getFloat1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< float > >, com::wilutions::byps::test::api::BResult_1898022288 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteSetTypes::setFloat1(const byps_ptr< ::std::set< float > >& float1)  {
	BSyncResultT< bool > syncResult;	
	setFloat1(float1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setFloat1(const byps_ptr< ::std::set< float > >& float1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_setFloat1(float1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::set< double > > BStub_RemoteSetTypes::getDouble1()  {
	BSyncResultT< byps_ptr< ::std::set< double > > > syncResult;	
	getDouble1([&syncResult](byps_ptr< ::std::set< double > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getDouble1(::std::function< void (byps_ptr< ::std::set< double > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_getDouble1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< double > >, com::wilutions::byps::test::api::BResult_1320560671 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteSetTypes::setDouble1(const byps_ptr< ::std::set< double > >& double1)  {
	BSyncResultT< bool > syncResult;	
	setDouble1(double1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setDouble1(const byps_ptr< ::std::set< double > >& double1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_setDouble1(double1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::set< ::std::wstring > > BStub_RemoteSetTypes::getString1()  {
	BSyncResultT< byps_ptr< ::std::set< ::std::wstring > > > syncResult;	
	getString1([&syncResult](byps_ptr< ::std::set< ::std::wstring > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getString1(::std::function< void (byps_ptr< ::std::set< ::std::wstring > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_getString1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< ::std::wstring > >, com::wilutions::byps::test::api::BResult_1888799711 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteSetTypes::setString1(const byps_ptr< ::std::set< ::std::wstring > >& string1)  {
	BSyncResultT< bool > syncResult;	
	setString1(string1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setString1(const byps_ptr< ::std::set< ::std::wstring > >& string1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_setString1(string1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteSetTypes::getPrimitiveTypes1()  {
	BSyncResultT< byps_ptr< ::std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	getPrimitiveTypes1([&syncResult](byps_ptr< ::std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getPrimitiveTypes1(::std::function< void (byps_ptr< ::std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_getPrimitiveTypes1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, com::wilutions::byps::test::api::BResult_1280571537 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteSetTypes::setPrimitiveTypes1(const byps_ptr< ::std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes1(primitiveTypes1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setPrimitiveTypes1(const byps_ptr< ::std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_setPrimitiveTypes1(primitiveTypes1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::set< PBytes > > BStub_RemoteSetTypes::getByte2()  {
	BSyncResultT< byps_ptr< ::std::set< PBytes > > > syncResult;	
	getByte2([&syncResult](byps_ptr< ::std::set< PBytes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getByte2(::std::function< void (byps_ptr< ::std::set< PBytes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_getByte2());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< PBytes > >, com::wilutions::byps::test::api::BResult_2052431866 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteSetTypes::setByte2(const byps_ptr< ::std::set< PBytes > >& byte2)  {
	BSyncResultT< bool > syncResult;	
	setByte2(byte2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setByte2(const byps_ptr< ::std::set< PBytes > >& byte2, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_setByte2(byte2));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::set< byps_ptr< BArray1< int32_t > > > > BStub_RemoteSetTypes::getInt2()  {
	BSyncResultT< byps_ptr< ::std::set< byps_ptr< BArray1< int32_t > > > > > syncResult;	
	getInt2([&syncResult](byps_ptr< ::std::set< byps_ptr< BArray1< int32_t > > > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getInt2(::std::function< void (byps_ptr< ::std::set< byps_ptr< BArray1< int32_t > > > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_getInt2());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< byps_ptr< BArray1< int32_t > > > >, com::wilutions::byps::test::api::BResult_1406124761 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteSetTypes::setInt2(const byps_ptr< ::std::set< byps_ptr< BArray1< int32_t > > > >& int2)  {
	BSyncResultT< bool > syncResult;	
	setInt2(int2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setInt2(const byps_ptr< ::std::set< byps_ptr< BArray1< int32_t > > > >& int2, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_setInt2(int2));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::set< PSerializable > > BStub_RemoteSetTypes::getObj1()  {
	BSyncResultT< byps_ptr< ::std::set< PSerializable > > > syncResult;	
	getObj1([&syncResult](byps_ptr< ::std::set< PSerializable > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getObj1(::std::function< void (byps_ptr< ::std::set< PSerializable > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_getObj1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< PSerializable > >, com::wilutions::byps::test::api::BResult_14 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteSetTypes::setObj1(const byps_ptr< ::std::set< PSerializable > >& obj1)  {
	BSyncResultT< bool > syncResult;	
	setObj1(obj1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setObj1(const byps_ptr< ::std::set< PSerializable > >& obj1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_setObj1(obj1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1156008353(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BStub_RemoteSetTypes(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteStreams::BStub_RemoteStreams(PTransport transport) 
	: BStub(transport) {}

PContentStream BStub_RemoteStreams::getImage()  {
	BSyncResultT< PContentStream > syncResult;	
	getImage([&syncResult](PContentStream v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteStreams::getImage(::std::function< void (PContentStream, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteStreams_getImage());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PContentStream, com::wilutions::byps::test::api::BResult_15 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteStreams::setImage(const PContentStream& istrm)  {
	BSyncResultT< bool > syncResult;	
	setImage(istrm, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteStreams::setImage(const PContentStream& istrm, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteStreams_setImage(istrm));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< int32_t , PContentStream > > BStub_RemoteStreams::getImages()  {
	BSyncResultT< byps_ptr< ::std::map< int32_t , PContentStream > > > syncResult;	
	getImages([&syncResult](byps_ptr< ::std::map< int32_t , PContentStream > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteStreams::getImages(::std::function< void (byps_ptr< ::std::map< int32_t , PContentStream > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteStreams_getImages());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int32_t , PContentStream > >, com::wilutions::byps::test::api::BResult_476459792 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteStreams::setImages(const byps_ptr< ::std::map< int32_t , PContentStream > >& istrms, int32_t doNotReadStreamAtKey)  {
	BSyncResultT< bool > syncResult;	
	setImages(istrms, doNotReadStreamAtKey, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteStreams::setImages(const byps_ptr< ::std::map< int32_t , PContentStream > >& istrms, int32_t doNotReadStreamAtKey, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteStreams_setImages(istrms, doNotReadStreamAtKey));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteStreams::throwLastException()  {
	BSyncResultT< bool > syncResult;	
	throwLastException([&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteStreams::throwLastException(::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteStreams_throwLastException());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
PContentStream BStub_RemoteStreams::getTextStream()  {
	BSyncResultT< PContentStream > syncResult;	
	getTextStream([&syncResult](PContentStream v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteStreams::getTextStream(::std::function< void (PContentStream, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteStreams_getTextStream());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PContentStream, com::wilutions::byps::test::api::BResult_15 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2028487863(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BStub_RemoteStreams(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

void BSkeleton_RemoteWithAuthentication::setUseAuthentication(bool useAuth)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteWithAuthentication::setUseAuthentication(bool useAuth, ::std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setUseAuthentication(useAuth);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
com::wilutions::byps::test::api::auth::PSessionInfo BSkeleton_RemoteWithAuthentication::login(const com::wilutions::byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& userName, const ::std::wstring& userPwd)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteWithAuthentication::login(const com::wilutions::byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& userName, const ::std::wstring& userPwd, ::std::function< void (com::wilutions::byps::test::api::auth::PSessionInfo, BException ex) > asyncResult)  {
	com::wilutions::byps::test::api::auth::PSessionInfo ret = com::wilutions::byps::test::api::auth::PSessionInfo();
	try {
		ret = login(sess, userName, userPwd);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
int32_t BSkeleton_RemoteWithAuthentication::doit(const com::wilutions::byps::test::api::auth::PSessionInfo& sess, int32_t value)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteWithAuthentication::doit(const com::wilutions::byps::test::api::auth::PSessionInfo& sess, int32_t value, ::std::function< void (int32_t, BException ex) > asyncResult)  {
	int32_t ret = int32_t();
	try {
		ret = doit(sess, value);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteWithAuthentication::expire(const com::wilutions::byps::test::api::auth::PSessionInfo& sess)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteWithAuthentication::expire(const com::wilutions::byps::test::api::auth::PSessionInfo& sess, ::std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		expire(sess);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteWithAuthentication::setReloginCount(int32_t count)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteWithAuthentication::setReloginCount(int32_t count, ::std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setReloginCount(count);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
}}}}}}


namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteWithAuthentication::BStub_RemoteWithAuthentication(PTransport transport) 
	: BStub(transport) {}

void BStub_RemoteWithAuthentication::setUseAuthentication(bool useAuth)  {
	BSyncResultT< bool > syncResult;	
	setUseAuthentication(useAuth, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteWithAuthentication::setUseAuthentication(bool useAuth, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteWithAuthentication_setUseAuthentication(useAuth));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
com::wilutions::byps::test::api::auth::PSessionInfo BStub_RemoteWithAuthentication::login(const ::std::wstring& userName, const ::std::wstring& userPwd)  {
	BSyncResultT< com::wilutions::byps::test::api::auth::PSessionInfo > syncResult;	
	login(userName, userPwd, [&syncResult](com::wilutions::byps::test::api::auth::PSessionInfo v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteWithAuthentication::login(const ::std::wstring& userName, const ::std::wstring& userPwd, ::std::function< void (com::wilutions::byps::test::api::auth::PSessionInfo, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteWithAuthentication_login(userName, userPwd));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< com::wilutions::byps::test::api::auth::PSessionInfo, com::wilutions::byps::test::api::BResult_65775978 >(asyncResult) );
	transport->send(req, outerResult);
}
int32_t BStub_RemoteWithAuthentication::doit(int32_t value)  {
	BSyncResultT< int32_t > syncResult;	
	doit(value, [&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteWithAuthentication::doit(int32_t value, ::std::function< void (int32_t, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteWithAuthentication_doit(value));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, com::wilutions::byps::test::api::BResult_5 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteWithAuthentication::expire()  {
	BSyncResultT< bool > syncResult;	
	expire([&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteWithAuthentication::expire(::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteWithAuthentication_expire());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteWithAuthentication::setReloginCount(int32_t count)  {
	BSyncResultT< bool > syncResult;	
	setReloginCount(count, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteWithAuthentication::setReloginCount(int32_t count, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteWithAuthentication_setReloginCount(count));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1677934392(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BStub_RemoteWithAuthentication(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

int32_t BSkeleton_ClientIF::incrementInt(int32_t a)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_ClientIF::incrementInt(int32_t a, ::std::function< void (int32_t, BException ex) > asyncResult)  {
	int32_t ret = int32_t();
	try {
		ret = incrementInt(a);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< ::std::vector< PContentStream > > BSkeleton_ClientIF::getStreams(int32_t ctrl)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_ClientIF::getStreams(int32_t ctrl, ::std::function< void (byps_ptr< ::std::vector< PContentStream > >, BException ex) > asyncResult)  {
	byps_ptr< ::std::vector< PContentStream > > ret = byps_ptr< ::std::vector< PContentStream > >();
	try {
		ret = getStreams(ctrl);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_ClientIF::putStreams(const byps_ptr< ::std::vector< PContentStream > >& strm, int32_t ctrl)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_ClientIF::putStreams(const byps_ptr< ::std::vector< PContentStream > >& strm, int32_t ctrl, ::std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		putStreams(strm, ctrl);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
PChatStructure BSkeleton_ClientIF::sendChat(const PChatStructure& cs)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_ClientIF::sendChat(const PChatStructure& cs, ::std::function< void (PChatStructure, BException ex) > asyncResult)  {
	PChatStructure ret = PChatStructure();
	try {
		ret = sendChat(cs);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
}}}}}}


namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

BStub_ClientIF::BStub_ClientIF(PTransport transport) 
	: BStub(transport) {}

int32_t BStub_ClientIF::incrementInt(int32_t a)  {
	BSyncResultT< int32_t > syncResult;	
	incrementInt(a, [&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_ClientIF::incrementInt(int32_t a, ::std::function< void (int32_t, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_ClientIF_incrementInt(a));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, com::wilutions::byps::test::api::BResult_5 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< PContentStream > > BStub_ClientIF::getStreams(int32_t ctrl)  {
	BSyncResultT< byps_ptr< ::std::vector< PContentStream > > > syncResult;	
	getStreams(ctrl, [&syncResult](byps_ptr< ::std::vector< PContentStream > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_ClientIF::getStreams(int32_t ctrl, ::std::function< void (byps_ptr< ::std::vector< PContentStream > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_ClientIF_getStreams(ctrl));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< PContentStream > >, com::wilutions::byps::test::api::BResult_1218831438 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_ClientIF::putStreams(const byps_ptr< ::std::vector< PContentStream > >& strm, int32_t ctrl)  {
	BSyncResultT< bool > syncResult;	
	putStreams(strm, ctrl, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_ClientIF::putStreams(const byps_ptr< ::std::vector< PContentStream > >& strm, int32_t ctrl, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_ClientIF_putStreams(strm, ctrl));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
PChatStructure BStub_ClientIF::sendChat(const PChatStructure& cs)  {
	BSyncResultT< PChatStructure > syncResult;	
	sendChat(cs, [&syncResult](PChatStructure v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_ClientIF::sendChat(const PChatStructure& cs, ::std::function< void (PChatStructure, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_ClientIF_sendChat(cs));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PChatStructure, com::wilutions::byps::test::api::BResult_7007 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1784257353(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BStub_ClientIF(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

BStub_ServerIF::BStub_ServerIF(PTransport transport) 
	: BStub(transport) {}

int32_t BStub_ServerIF::callClientIncrementInt(int32_t v)  {
	BSyncResultT< int32_t > syncResult;	
	callClientIncrementInt(v, [&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_ServerIF::callClientIncrementInt(int32_t v, ::std::function< void (int32_t, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_ServerIF_callClientIncrementInt(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, com::wilutions::byps::test::api::BResult_5 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_ServerIF::setPartner(const PClientIF& client)  {
	BSyncResultT< bool > syncResult;	
	setPartner(client, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_ServerIF::setPartner(const PClientIF& client, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_ServerIF_setPartner(client));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
PClientIF BStub_ServerIF::getPartner()  {
	BSyncResultT< PClientIF > syncResult;	
	getPartner([&syncResult](PClientIF v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_ServerIF::getPartner(::std::function< void (PClientIF, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_ServerIF_getPartner());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PClientIF, com::wilutions::byps::test::api::BResult_1473575576 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< PContentStream > > BStub_ServerIF::getStreamsFromClient()  {
	BSyncResultT< byps_ptr< ::std::vector< PContentStream > > > syncResult;	
	getStreamsFromClient([&syncResult](byps_ptr< ::std::vector< PContentStream > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_ServerIF::getStreamsFromClient(::std::function< void (byps_ptr< ::std::vector< PContentStream > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_ServerIF_getStreamsFromClient());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< PContentStream > >, com::wilutions::byps::test::api::BResult_1218831438 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_ServerIF::putStreamsOnClient(const byps_ptr< ::std::vector< PContentStream > >& streams)  {
	BSyncResultT< bool > syncResult;	
	putStreamsOnClient(streams, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_ServerIF::putStreamsOnClient(const byps_ptr< ::std::vector< PContentStream > >& streams, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_ServerIF_putStreamsOnClient(streams));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_ServerIF::registerWithClientMap(int32_t id)  {
	BSyncResultT< bool > syncResult;	
	registerWithClientMap(id, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_ServerIF::registerWithClientMap(int32_t id, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_ServerIF_registerWithClientMap(id));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
PClientIF BStub_ServerIF::getClient(int32_t id)  {
	BSyncResultT< PClientIF > syncResult;	
	getClient(id, [&syncResult](PClientIF v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_ServerIF::getClient(int32_t id, ::std::function< void (PClientIF, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_ServerIF_getClient(id));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PClientIF, com::wilutions::byps::test::api::BResult_1473575576 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::set< int32_t > > BStub_ServerIF::getClientIds()  {
	BSyncResultT< byps_ptr< ::std::set< int32_t > > > syncResult;	
	getClientIds([&syncResult](byps_ptr< ::std::set< int32_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_ServerIF::getClientIds(::std::function< void (byps_ptr< ::std::set< int32_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_ServerIF_getClientIds());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< int32_t > >, com::wilutions::byps::test::api::BResult_1493282670 >(asyncResult) );
	transport->send(req, outerResult);
}
int32_t BStub_ServerIF::callClientParallel(int32_t v)  {
	BSyncResultT< int32_t > syncResult;	
	callClientParallel(v, [&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_ServerIF::callClientParallel(int32_t v, ::std::function< void (int32_t, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_ServerIF_callClientParallel(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, com::wilutions::byps::test::api::BResult_5 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1313562065(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BStub_ServerIF(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace ver { 

BStub_EvolveIF::BStub_EvolveIF(PTransport transport) 
	: BStub(transport) {}

void BStub_EvolveIF::setEvolve(const PEvolve& obj)  {
	BSyncResultT< bool > syncResult;	
	setEvolve(obj, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_EvolveIF::setEvolve(const PEvolve& obj, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_EvolveIF_setEvolve(obj));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
PEvolve BStub_EvolveIF::getEvolve()  {
	BSyncResultT< PEvolve > syncResult;	
	getEvolve([&syncResult](PEvolve v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_EvolveIF::getEvolve(::std::function< void (PEvolve, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_EvolveIF_getEvolve());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PEvolve, com::wilutions::byps::test::api::BResult_1391985860 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_EvolveIF::setClient(const PEvolveIF& partner)  {
	BSyncResultT< bool > syncResult;	
	setClient(partner, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_EvolveIF::setClient(const PEvolveIF& partner, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_EvolveIF_setClient(partner));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
PEvolveIF BStub_EvolveIF::getClient()  {
	BSyncResultT< PEvolveIF > syncResult;	
	getClient([&syncResult](PEvolveIF v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_EvolveIF::getClient(::std::function< void (PEvolveIF, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_EvolveIF_getClient());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PEvolveIF, com::wilutions::byps::test::api::BResult_1178379224 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_EvolveIF::sendEvolveToClient()  {
	BSyncResultT< bool > syncResult;	
	sendEvolveToClient([&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_EvolveIF::sendEvolveToClient(::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_EvolveIF_sendEvolveToClient());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2078696281(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::ver::BStub_EvolveIF(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}
