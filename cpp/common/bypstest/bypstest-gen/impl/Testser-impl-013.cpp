#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;


namespace byps { namespace test { namespace api { namespace inherit { 

BStub_LemonService::BStub_LemonService(PTransport transport) 
	: BStub(transport) {}

::std::wstring BStub_LemonService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_LemonService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
::std::wstring BStub_LemonService::pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree)  {
	BSyncResultT< ::std::wstring > syncResult;	
	pick(sess, fromTree, [&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_LemonService::pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree, ::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_LemonService_pick(sess, fromTree));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
::std::wstring BStub_LemonService::squeeze()  {
	BSyncResultT< ::std::wstring > syncResult;	
	squeeze([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_LemonService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_FruitService_squeeze());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
namespace byps { namespace test { namespace api { 
void BSerializer_605543968(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::inherit::BStub_LemonService(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}

namespace byps { namespace test { namespace api { namespace inherit { 

BStub_BioLemonService::BStub_BioLemonService(PTransport transport) 
	: BStub(transport) {}

bool BStub_BioLemonService::certify(const ::std::wstring& param)  {
	BSyncResultT< bool > syncResult;	
	certify(param, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::certify(const ::std::wstring& param, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_BioFruitService_certify(param));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_1 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
::std::wstring BStub_BioLemonService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
::std::wstring BStub_BioLemonService::squeeze()  {
	BSyncResultT< ::std::wstring > syncResult;	
	squeeze([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_FruitService_squeeze());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
::std::wstring BStub_BioLemonService::pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree)  {
	BSyncResultT< ::std::wstring > syncResult;	
	pick(sess, fromTree, [&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree, ::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_LemonService_pick(sess, fromTree));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
int32_t BStub_BioLemonService::useParing()  {
	BSyncResultT< int32_t > syncResult;	
	useParing([&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::useParing(::std::function< void (int32_t, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_BioLemonService_useParing());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, byps::test::api::BResult_5 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
namespace byps { namespace test { namespace api { 
void BSerializer_474058508(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::inherit::BStub_BioLemonService(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}

namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteArrayTypes1dim::BStub_RemoteArrayTypes1dim(PTransport transport) 
	: BStub(transport) {}

void BStub_RemoteArrayTypes1dim::setBool(const byps_ptr< BArray1< bool > >& v)  {
	BSyncResultT< bool > syncResult;	
	setBool(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setBool(const byps_ptr< BArray1< bool > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setBool(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setByte(const PBytes& v)  {
	BSyncResultT< bool > syncResult;	
	setByte(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setByte(const PBytes& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setByte(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setChar(const byps_ptr< BArray1< wchar_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setChar(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setChar(const byps_ptr< BArray1< wchar_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setChar(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setShort(const byps_ptr< BArray1< int16_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setShort(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setShort(const byps_ptr< BArray1< int16_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setShort(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setInt(const byps_ptr< BArray1< int32_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setInt(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setInt(const byps_ptr< BArray1< int32_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setInt(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setLong(const byps_ptr< BArray1< int64_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setLong(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setLong(const byps_ptr< BArray1< int64_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setLong(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setFloat(const byps_ptr< BArray1< float > >& v)  {
	BSyncResultT< bool > syncResult;	
	setFloat(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setFloat(const byps_ptr< BArray1< float > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setFloat(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setDouble(const byps_ptr< BArray1< double > >& v)  {
	BSyncResultT< bool > syncResult;	
	setDouble(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setDouble(const byps_ptr< BArray1< double > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setDouble(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setString(const byps_ptr< BArray1< ::std::wstring > >& v)  {
	BSyncResultT< bool > syncResult;	
	setString(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setString(const byps_ptr< BArray1< ::std::wstring > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setString(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setPrimitiveTypes(const byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > >& v)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setPrimitiveTypes(const byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setPrimitiveTypes(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setObject(const byps_ptr< BArray1< PSerializable > >& v)  {
	BSyncResultT< bool > syncResult;	
	setObject(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setObject(const byps_ptr< BArray1< PSerializable > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setObject(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setDate(const byps_ptr< BArray1< BDateTime > >& v)  {
	BSyncResultT< bool > syncResult;	
	setDate(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setDate(const byps_ptr< BArray1< BDateTime > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setDate(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray1< bool > > BStub_RemoteArrayTypes1dim::getBool()  {
	BSyncResultT< byps_ptr< BArray1< bool > > > syncResult;	
	getBool([&syncResult](byps_ptr< BArray1< bool > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getBool(::std::function< void (byps_ptr< BArray1< bool > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getBool());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< bool > >, byps::test::api::BResult_2058423690 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
PBytes BStub_RemoteArrayTypes1dim::getByte()  {
	BSyncResultT< PBytes > syncResult;	
	getByte([&syncResult](PBytes v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getByte(::std::function< void (PBytes, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getByte());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PBytes, byps::test::api::BResult_1374008726 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray1< wchar_t > > BStub_RemoteArrayTypes1dim::getChar()  {
	BSyncResultT< byps_ptr< BArray1< wchar_t > > > syncResult;	
	getChar([&syncResult](byps_ptr< BArray1< wchar_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getChar(::std::function< void (byps_ptr< BArray1< wchar_t > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getChar());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< wchar_t > >, byps::test::api::BResult_1361632968 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray1< int16_t > > BStub_RemoteArrayTypes1dim::getShort()  {
	BSyncResultT< byps_ptr< BArray1< int16_t > > > syncResult;	
	getShort([&syncResult](byps_ptr< BArray1< int16_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getShort(::std::function< void (byps_ptr< BArray1< int16_t > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getShort());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< int16_t > >, byps::test::api::BResult_2067161310 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray1< int32_t > > BStub_RemoteArrayTypes1dim::getInt()  {
	BSyncResultT< byps_ptr< BArray1< int32_t > > > syncResult;	
	getInt([&syncResult](byps_ptr< BArray1< int32_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getInt(::std::function< void (byps_ptr< BArray1< int32_t > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getInt());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< int32_t > >, byps::test::api::BResult_100361105 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray1< int64_t > > BStub_RemoteArrayTypes1dim::getLong()  {
	BSyncResultT< byps_ptr< BArray1< int64_t > > > syncResult;	
	getLong([&syncResult](byps_ptr< BArray1< int64_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getLong(::std::function< void (byps_ptr< BArray1< int64_t > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getLong());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< int64_t > >, byps::test::api::BResult_1097129250 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray1< float > > BStub_RemoteArrayTypes1dim::getFloat()  {
	BSyncResultT< byps_ptr< BArray1< float > > > syncResult;	
	getFloat([&syncResult](byps_ptr< BArray1< float > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getFloat(::std::function< void (byps_ptr< BArray1< float > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getFloat());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< float > >, byps::test::api::BResult_766441794 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray1< double > > BStub_RemoteArrayTypes1dim::getDouble()  {
	BSyncResultT< byps_ptr< BArray1< double > > > syncResult;	
	getDouble([&syncResult](byps_ptr< BArray1< double > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getDouble(::std::function< void (byps_ptr< BArray1< double > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getDouble());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< double > >, byps::test::api::BResult_1359468275 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray1< ::std::wstring > > BStub_RemoteArrayTypes1dim::getString()  {
	BSyncResultT< byps_ptr< BArray1< ::std::wstring > > > syncResult;	
	getString([&syncResult](byps_ptr< BArray1< ::std::wstring > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getString(::std::function< void (byps_ptr< BArray1< ::std::wstring > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getString());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< ::std::wstring > >, byps::test::api::BResult_1888107655 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteArrayTypes1dim::getPrimitiveTypes()  {
	BSyncResultT< byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	getPrimitiveTypes([&syncResult](byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getPrimitiveTypes(::std::function< void (byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getPrimitiveTypes());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > >, byps::test::api::BResult_2053507648 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray1< PSerializable > > BStub_RemoteArrayTypes1dim::getObject()  {
	BSyncResultT< byps_ptr< BArray1< PSerializable > > > syncResult;	
	getObject([&syncResult](byps_ptr< BArray1< PSerializable > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getObject(::std::function< void (byps_ptr< BArray1< PSerializable > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getObject());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< PSerializable > >, byps::test::api::BResult_183594037 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray1< BDateTime > > BStub_RemoteArrayTypes1dim::getDate()  {
	BSyncResultT< byps_ptr< BArray1< BDateTime > > > syncResult;	
	getDate([&syncResult](byps_ptr< BArray1< BDateTime > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getDate(::std::function< void (byps_ptr< BArray1< BDateTime > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getDate());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< BDateTime > >, byps::test::api::BResult_1406664368 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
namespace byps { namespace test { namespace api { 
void BSerializer_963816328(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::remote::BStub_RemoteArrayTypes1dim(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}

namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteArrayTypes23::BStub_RemoteArrayTypes23(PTransport transport) 
	: BStub(transport) {}

byps_ptr< BArray1< int32_t > > BStub_RemoteArrayTypes23::sendArraysInt(const byps_ptr< BArray2< int32_t > >& arr2, const byps_ptr< BArray3< int32_t > >& arr3, const byps_ptr< BArray4< int32_t > >& arr4)  {
	BSyncResultT< byps_ptr< BArray1< int32_t > > > syncResult;	
	sendArraysInt(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< int32_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysInt(const byps_ptr< BArray2< int32_t > >& arr2, const byps_ptr< BArray3< int32_t > >& arr3, const byps_ptr< BArray4< int32_t > >& arr4, ::std::function< void (byps_ptr< BArray1< int32_t > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes23_sendArraysInt(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< int32_t > >, byps::test::api::BResult_100361105 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray1< ::std::wstring > > BStub_RemoteArrayTypes23::sendArraysString(const byps_ptr< BArray2< ::std::wstring > >& arr2, const byps_ptr< BArray3< ::std::wstring > >& arr3, const byps_ptr< BArray4< ::std::wstring > >& arr4)  {
	BSyncResultT< byps_ptr< BArray1< ::std::wstring > > > syncResult;	
	sendArraysString(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< ::std::wstring > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysString(const byps_ptr< BArray2< ::std::wstring > >& arr2, const byps_ptr< BArray3< ::std::wstring > >& arr3, const byps_ptr< BArray4< ::std::wstring > >& arr4, ::std::function< void (byps_ptr< BArray1< ::std::wstring > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes23_sendArraysString(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< ::std::wstring > >, byps::test::api::BResult_1888107655 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteArrayTypes23::sendArraysClass(const byps_ptr< BArray2< byps::test::api::prim::PPrimitiveTypes > >& arr2, const byps_ptr< BArray3< byps::test::api::prim::PPrimitiveTypes > >& arr3, const byps_ptr< BArray4< byps::test::api::prim::PPrimitiveTypes > >& arr4)  {
	BSyncResultT< byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	sendArraysClass(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysClass(const byps_ptr< BArray2< byps::test::api::prim::PPrimitiveTypes > >& arr2, const byps_ptr< BArray3< byps::test::api::prim::PPrimitiveTypes > >& arr3, const byps_ptr< BArray4< byps::test::api::prim::PPrimitiveTypes > >& arr4, ::std::function< void (byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes23_sendArraysClass(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > >, byps::test::api::BResult_2053507648 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray1< PSerializable > > BStub_RemoteArrayTypes23::sendArraysObject(const byps_ptr< BArray2< PSerializable > >& arr2, const byps_ptr< BArray3< PSerializable > >& arr3, const byps_ptr< BArray4< PSerializable > >& arr4)  {
	BSyncResultT< byps_ptr< BArray1< PSerializable > > > syncResult;	
	sendArraysObject(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< PSerializable > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysObject(const byps_ptr< BArray2< PSerializable > >& arr2, const byps_ptr< BArray3< PSerializable > >& arr3, const byps_ptr< BArray4< PSerializable > >& arr4, ::std::function< void (byps_ptr< BArray1< PSerializable > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes23_sendArraysObject(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< PSerializable > >, byps::test::api::BResult_183594037 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray1< byps::test::api::inl::Point2D > > BStub_RemoteArrayTypes23::sendArraysInline(const byps_ptr< BArray2< byps::test::api::inl::Point2D > >& arr2, const byps_ptr< BArray3< byps::test::api::inl::Point2D > >& arr3, const byps_ptr< BArray4< byps::test::api::inl::Point2D > >& arr4)  {
	BSyncResultT< byps_ptr< BArray1< byps::test::api::inl::Point2D > > > syncResult;	
	sendArraysInline(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< byps::test::api::inl::Point2D > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysInline(const byps_ptr< BArray2< byps::test::api::inl::Point2D > >& arr2, const byps_ptr< BArray3< byps::test::api::inl::Point2D > >& arr3, const byps_ptr< BArray4< byps::test::api::inl::Point2D > >& arr4, ::std::function< void (byps_ptr< BArray1< byps::test::api::inl::Point2D > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes23_sendArraysInline(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< byps::test::api::inl::Point2D > >, byps::test::api::BResult_184101377 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
namespace byps { namespace test { namespace api { 
void BSerializer_769717182(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::remote::BStub_RemoteArrayTypes23(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}

namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteArrayTypes4dim::BStub_RemoteArrayTypes4dim(PTransport transport) 
	: BStub(transport) {}

void BStub_RemoteArrayTypes4dim::setBool(const byps_ptr< BArray4< bool > >& v)  {
	BSyncResultT< bool > syncResult;	
	setBool(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setBool(const byps_ptr< BArray4< bool > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setBool(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setByte(const byps_ptr< BArray4< int8_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setByte(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setByte(const byps_ptr< BArray4< int8_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setByte(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setChar(const byps_ptr< BArray4< wchar_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setChar(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setChar(const byps_ptr< BArray4< wchar_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setChar(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setShort(const byps_ptr< BArray4< int16_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setShort(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setShort(const byps_ptr< BArray4< int16_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setShort(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setInt(const byps_ptr< BArray4< int32_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setInt(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setInt(const byps_ptr< BArray4< int32_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setInt(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setLong(const byps_ptr< BArray4< int64_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setLong(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setLong(const byps_ptr< BArray4< int64_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setLong(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setFloat(const byps_ptr< BArray4< float > >& v)  {
	BSyncResultT< bool > syncResult;	
	setFloat(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setFloat(const byps_ptr< BArray4< float > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setFloat(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setDouble(const byps_ptr< BArray4< double > >& v)  {
	BSyncResultT< bool > syncResult;	
	setDouble(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setDouble(const byps_ptr< BArray4< double > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setDouble(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setString(const byps_ptr< BArray4< ::std::wstring > >& v)  {
	BSyncResultT< bool > syncResult;	
	setString(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setString(const byps_ptr< BArray4< ::std::wstring > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setString(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setPrimitiveTypes(const byps_ptr< BArray4< byps::test::api::prim::PPrimitiveTypes > >& v)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setPrimitiveTypes(const byps_ptr< BArray4< byps::test::api::prim::PPrimitiveTypes > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setPrimitiveTypes(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setObject(const byps_ptr< BArray4< PSerializable > >& v)  {
	BSyncResultT< bool > syncResult;	
	setObject(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setObject(const byps_ptr< BArray4< PSerializable > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setObject(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setDate(const byps_ptr< BArray4< BDateTime > >& v)  {
	BSyncResultT< bool > syncResult;	
	setDate(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setDate(const byps_ptr< BArray4< BDateTime > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setDate(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray4< bool > > BStub_RemoteArrayTypes4dim::getBool()  {
	BSyncResultT< byps_ptr< BArray4< bool > > > syncResult;	
	getBool([&syncResult](byps_ptr< BArray4< bool > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getBool(::std::function< void (byps_ptr< BArray4< bool > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getBool());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< bool > >, byps::test::api::BResult_945713488 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray4< int8_t > > BStub_RemoteArrayTypes4dim::getByte()  {
	BSyncResultT< byps_ptr< BArray4< int8_t > > > syncResult;	
	getByte([&syncResult](byps_ptr< BArray4< int8_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getByte(::std::function< void (byps_ptr< BArray4< int8_t > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getByte());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< int8_t > >, byps::test::api::BResult_1201775504 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray4< wchar_t > > BStub_RemoteArrayTypes4dim::getChar()  {
	BSyncResultT< byps_ptr< BArray4< wchar_t > > > syncResult;	
	getChar([&syncResult](byps_ptr< BArray4< wchar_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getChar(::std::function< void (byps_ptr< BArray4< wchar_t > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getChar());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< wchar_t > >, byps::test::api::BResult_769021986 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray4< int16_t > > BStub_RemoteArrayTypes4dim::getShort()  {
	BSyncResultT< byps_ptr< BArray4< int16_t > > > syncResult;	
	getShort([&syncResult](byps_ptr< BArray4< int16_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getShort(::std::function< void (byps_ptr< BArray4< int16_t > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getShort());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< int16_t > >, byps::test::api::BResult_1859644668 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray4< int32_t > > BStub_RemoteArrayTypes4dim::getInt()  {
	BSyncResultT< byps_ptr< BArray4< int32_t > > > syncResult;	
	getInt([&syncResult](byps_ptr< BArray4< int32_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getInt(::std::function< void (byps_ptr< BArray4< int32_t > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getInt());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< int32_t > >, byps::test::api::BResult_39910537 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray4< int64_t > > BStub_RemoteArrayTypes4dim::getLong()  {
	BSyncResultT< byps_ptr< BArray4< int64_t > > > syncResult;	
	getLong([&syncResult](byps_ptr< BArray4< int64_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getLong(::std::function< void (byps_ptr< BArray4< int64_t > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getLong());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< int64_t > >, byps::test::api::BResult_846419204 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray4< float > > BStub_RemoteArrayTypes4dim::getFloat()  {
	BSyncResultT< byps_ptr< BArray4< float > > > syncResult;	
	getFloat([&syncResult](byps_ptr< BArray4< float > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getFloat(::std::function< void (byps_ptr< BArray4< float > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getFloat());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< float > >, byps::test::api::BResult_1516687588 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray4< double > > BStub_RemoteArrayTypes4dim::getDouble()  {
	BSyncResultT< byps_ptr< BArray4< double > > > syncResult;	
	getDouble([&syncResult](byps_ptr< BArray4< double > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getDouble(::std::function< void (byps_ptr< BArray4< double > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getDouble());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< double > >, byps::test::api::BResult_2087445849 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray4< ::std::wstring > > BStub_RemoteArrayTypes4dim::getString()  {
	BSyncResultT< byps_ptr< BArray4< ::std::wstring > > > syncResult;	
	getString([&syncResult](byps_ptr< BArray4< ::std::wstring > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getString(::std::function< void (byps_ptr< BArray4< ::std::wstring > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getString());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< ::std::wstring > >, byps::test::api::BResult_588723219 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray4< byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteArrayTypes4dim::getPrimitiveTypes()  {
	BSyncResultT< byps_ptr< BArray4< byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	getPrimitiveTypes([&syncResult](byps_ptr< BArray4< byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getPrimitiveTypes(::std::function< void (byps_ptr< BArray4< byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getPrimitiveTypes());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< byps::test::api::prim::PPrimitiveTypes > >, byps::test::api::BResult_758319514 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray4< PSerializable > > BStub_RemoteArrayTypes4dim::getObject()  {
	BSyncResultT< byps_ptr< BArray4< PSerializable > > > syncResult;	
	getObject([&syncResult](byps_ptr< BArray4< PSerializable > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getObject(::std::function< void (byps_ptr< BArray4< PSerializable > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getObject());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< PSerializable > >, byps::test::api::BResult_124584219 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
byps_ptr< BArray4< BDateTime > > BStub_RemoteArrayTypes4dim::getDate()  {
	BSyncResultT< byps_ptr< BArray4< BDateTime > > > syncResult;	
	getDate([&syncResult](byps_ptr< BArray4< BDateTime > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getDate(::std::function< void (byps_ptr< BArray4< BDateTime > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getDate());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< BDateTime > >, byps::test::api::BResult_51898890 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
namespace byps { namespace test { namespace api { 
void BSerializer_963726955(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::remote::BStub_RemoteArrayTypes4dim(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}

namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteConstants::BStub_RemoteConstants(PTransport transport) 
	: BStub(transport) {}

void BStub_RemoteConstants::compare_HebrewC(const byps::test::api::cons::PHebrewZ& ALEPH, const byps::test::api::cons::PHebrewZ& BETH)  {
	BSyncResultT< bool > syncResult;	
	compare_HebrewC(ALEPH, BETH, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteConstants::compare_HebrewC(const byps::test::api::cons::PHebrewZ& ALEPH, const byps::test::api::cons::PHebrewZ& BETH, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteConstants_compare_HebrewC(ALEPH, BETH));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
bool BStub_RemoteConstants::compare_AllTypesC(bool bool1s, bool bool2s, wchar_t char1s, const ::std::wstring& stringNull, wchar_t char2s, int16_t short1s, int32_t int1s, int64_t long1s, float float1s, double double1s, const ::std::wstring& string1s, const byps::test::api::cons::PAllTypesZ& ALL, const byps_ptr< BArray1< int32_t > >& arrInt, const byps_ptr< BArray4< int32_t > >& arrInt4, const byps_ptr< BArray1< ::std::wstring > >& arrStrings, const byps_ptr< BArray4< ::std::wstring > >& arrStrings4, const byps_ptr< BArray2< byps::test::api::cons::PAllTypesZ > >& arrAll)  {
	BSyncResultT< bool > syncResult;	
	compare_AllTypesC(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteConstants::compare_AllTypesC(bool bool1s, bool bool2s, wchar_t char1s, const ::std::wstring& stringNull, wchar_t char2s, int16_t short1s, int32_t int1s, int64_t long1s, float float1s, double double1s, const ::std::wstring& string1s, const byps::test::api::cons::PAllTypesZ& ALL, const byps_ptr< BArray1< int32_t > >& arrInt, const byps_ptr< BArray4< int32_t > >& arrInt4, const byps_ptr< BArray1< ::std::wstring > >& arrStrings, const byps_ptr< BArray4< ::std::wstring > >& arrStrings4, const byps_ptr< BArray2< byps::test::api::cons::PAllTypesZ > >& arrAll, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteConstants_compare_AllTypesC(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_1 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
namespace byps { namespace test { namespace api { 
void BSerializer_2045242510(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::remote::BStub_RemoteConstants(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}

namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteEnums::BStub_RemoteEnums(PTransport transport) 
	: BStub(transport) {}

byps::test::api::enu::EnumPlanets BStub_RemoteEnums::getPlanet()  {
	BSyncResultT< byps::test::api::enu::EnumPlanets > syncResult;	
	getPlanet([&syncResult](byps::test::api::enu::EnumPlanets v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteEnums::getPlanet(::std::function< void (byps::test::api::enu::EnumPlanets, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteEnums_getPlanet());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::test::api::enu::EnumPlanets, byps::test::api::BResult_1375035164 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
void BStub_RemoteEnums::setPlanet(byps::test::api::enu::EnumPlanets planet)  {
	BSyncResultT< bool > syncResult;	
	setPlanet(planet, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteEnums::setPlanet(byps::test::api::enu::EnumPlanets planet, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteEnums_setPlanet(planet));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
namespace byps { namespace test { namespace api { 
void BSerializer_485761455(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::remote::BStub_RemoteEnums(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}
