#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;


namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace inherit { 

BStub_BioLemonService::BStub_BioLemonService(PTransport transport) 
	: BStub(transport) {}

::std::wstring BStub_BioLemonService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, com::wilutions::byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
::std::wstring BStub_BioLemonService::pick(const ::std::wstring& fromTree)  {
	BSyncResultT< ::std::wstring > syncResult;	
	pick(fromTree, [&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::pick(const ::std::wstring& fromTree, ::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_LemonService_pick(fromTree));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, com::wilutions::byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
int32_t BStub_BioLemonService::useParing()  {
	BSyncResultT< int32_t > syncResult;	
	useParing([&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::useParing(::std::function< void (int32_t, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_BioLemonService_useParing());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, com::wilutions::byps::test::api::BResult_5 >(asyncResult) );
	transport->send(req, outerResult);
}
bool BStub_BioLemonService::certify(const ::std::wstring& param)  {
	BSyncResultT< bool > syncResult;	
	certify(param, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::certify(const ::std::wstring& param, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_BioFruitService_certify(param));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_1 >(asyncResult) );
	transport->send(req, outerResult);
}
::std::wstring BStub_BioLemonService::squeeze()  {
	BSyncResultT< ::std::wstring > syncResult;	
	squeeze([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_FruitService_squeeze());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, com::wilutions::byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1992245333(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::inherit::BStub_BioLemonService(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

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
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setBool(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setByte(const PBytes& v)  {
	BSyncResultT< bool > syncResult;	
	setByte(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setByte(const PBytes& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setByte(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setChar(const byps_ptr< BArray1< wchar_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setChar(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setChar(const byps_ptr< BArray1< wchar_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setChar(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setShort(const byps_ptr< BArray1< int16_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setShort(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setShort(const byps_ptr< BArray1< int16_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setShort(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setInt(const byps_ptr< BArray1< int32_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setInt(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setInt(const byps_ptr< BArray1< int32_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setInt(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setLong(const byps_ptr< BArray1< int64_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setLong(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setLong(const byps_ptr< BArray1< int64_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setLong(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setFloat(const byps_ptr< BArray1< float > >& v)  {
	BSyncResultT< bool > syncResult;	
	setFloat(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setFloat(const byps_ptr< BArray1< float > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setFloat(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setDouble(const byps_ptr< BArray1< double > >& v)  {
	BSyncResultT< bool > syncResult;	
	setDouble(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setDouble(const byps_ptr< BArray1< double > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setDouble(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setString(const byps_ptr< BArray1< ::std::wstring > >& v)  {
	BSyncResultT< bool > syncResult;	
	setString(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setString(const byps_ptr< BArray1< ::std::wstring > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setString(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setPrimitiveTypes(const byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >& v)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setPrimitiveTypes(const byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setPrimitiveTypes(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setObject(const byps_ptr< BArray1< PSerializable > >& v)  {
	BSyncResultT< bool > syncResult;	
	setObject(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setObject(const byps_ptr< BArray1< PSerializable > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setObject(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< bool > > BStub_RemoteArrayTypes1dim::getBool()  {
	BSyncResultT< byps_ptr< BArray1< bool > > > syncResult;	
	getBool([&syncResult](byps_ptr< BArray1< bool > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getBool(::std::function< void (byps_ptr< BArray1< bool > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getBool());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< bool > >, com::wilutions::byps::test::api::BResult_2058423690 >(asyncResult) );
	transport->send(req, outerResult);
}
PBytes BStub_RemoteArrayTypes1dim::getByte()  {
	BSyncResultT< PBytes > syncResult;	
	getByte([&syncResult](PBytes v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getByte(::std::function< void (PBytes, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getByte());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PBytes, com::wilutions::byps::test::api::BResult_1374008726 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< wchar_t > > BStub_RemoteArrayTypes1dim::getChar()  {
	BSyncResultT< byps_ptr< BArray1< wchar_t > > > syncResult;	
	getChar([&syncResult](byps_ptr< BArray1< wchar_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getChar(::std::function< void (byps_ptr< BArray1< wchar_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getChar());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< wchar_t > >, com::wilutions::byps::test::api::BResult_1361632968 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< int16_t > > BStub_RemoteArrayTypes1dim::getShort()  {
	BSyncResultT< byps_ptr< BArray1< int16_t > > > syncResult;	
	getShort([&syncResult](byps_ptr< BArray1< int16_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getShort(::std::function< void (byps_ptr< BArray1< int16_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getShort());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< int16_t > >, com::wilutions::byps::test::api::BResult_2067161310 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< int32_t > > BStub_RemoteArrayTypes1dim::getInt()  {
	BSyncResultT< byps_ptr< BArray1< int32_t > > > syncResult;	
	getInt([&syncResult](byps_ptr< BArray1< int32_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getInt(::std::function< void (byps_ptr< BArray1< int32_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getInt());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< int32_t > >, com::wilutions::byps::test::api::BResult_100361105 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< int64_t > > BStub_RemoteArrayTypes1dim::getLong()  {
	BSyncResultT< byps_ptr< BArray1< int64_t > > > syncResult;	
	getLong([&syncResult](byps_ptr< BArray1< int64_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getLong(::std::function< void (byps_ptr< BArray1< int64_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getLong());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< int64_t > >, com::wilutions::byps::test::api::BResult_1097129250 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< float > > BStub_RemoteArrayTypes1dim::getFloat()  {
	BSyncResultT< byps_ptr< BArray1< float > > > syncResult;	
	getFloat([&syncResult](byps_ptr< BArray1< float > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getFloat(::std::function< void (byps_ptr< BArray1< float > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getFloat());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< float > >, com::wilutions::byps::test::api::BResult_766441794 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< double > > BStub_RemoteArrayTypes1dim::getDouble()  {
	BSyncResultT< byps_ptr< BArray1< double > > > syncResult;	
	getDouble([&syncResult](byps_ptr< BArray1< double > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getDouble(::std::function< void (byps_ptr< BArray1< double > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getDouble());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< double > >, com::wilutions::byps::test::api::BResult_1359468275 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< ::std::wstring > > BStub_RemoteArrayTypes1dim::getString()  {
	BSyncResultT< byps_ptr< BArray1< ::std::wstring > > > syncResult;	
	getString([&syncResult](byps_ptr< BArray1< ::std::wstring > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getString(::std::function< void (byps_ptr< BArray1< ::std::wstring > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getString());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< ::std::wstring > >, com::wilutions::byps::test::api::BResult_1888107655 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteArrayTypes1dim::getPrimitiveTypes()  {
	BSyncResultT< byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	getPrimitiveTypes([&syncResult](byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getPrimitiveTypes(::std::function< void (byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getPrimitiveTypes());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, com::wilutions::byps::test::api::BResult_801243127 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< PSerializable > > BStub_RemoteArrayTypes1dim::getObject()  {
	BSyncResultT< byps_ptr< BArray1< PSerializable > > > syncResult;	
	getObject([&syncResult](byps_ptr< BArray1< PSerializable > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getObject(::std::function< void (byps_ptr< BArray1< PSerializable > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getObject());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< PSerializable > >, com::wilutions::byps::test::api::BResult_183594037 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1557084481(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BStub_RemoteArrayTypes1dim(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

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
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysInt(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< int32_t > >, com::wilutions::byps::test::api::BResult_100361105 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< ::std::wstring > > BStub_RemoteArrayTypes23::sendArraysString(const byps_ptr< BArray2< ::std::wstring > >& arr2, const byps_ptr< BArray3< ::std::wstring > >& arr3, const byps_ptr< BArray4< ::std::wstring > >& arr4)  {
	BSyncResultT< byps_ptr< BArray1< ::std::wstring > > > syncResult;	
	sendArraysString(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< ::std::wstring > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysString(const byps_ptr< BArray2< ::std::wstring > >& arr2, const byps_ptr< BArray3< ::std::wstring > >& arr3, const byps_ptr< BArray4< ::std::wstring > >& arr4, ::std::function< void (byps_ptr< BArray1< ::std::wstring > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysString(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< ::std::wstring > >, com::wilutions::byps::test::api::BResult_1888107655 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteArrayTypes23::sendArraysClass(const byps_ptr< BArray2< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >& arr2, const byps_ptr< BArray3< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >& arr3, const byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >& arr4)  {
	BSyncResultT< byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	sendArraysClass(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysClass(const byps_ptr< BArray2< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >& arr2, const byps_ptr< BArray3< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >& arr3, const byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >& arr4, ::std::function< void (byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysClass(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, com::wilutions::byps::test::api::BResult_801243127 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< PSerializable > > BStub_RemoteArrayTypes23::sendArraysObject(const byps_ptr< BArray2< PSerializable > >& arr2, const byps_ptr< BArray3< PSerializable > >& arr3, const byps_ptr< BArray4< PSerializable > >& arr4)  {
	BSyncResultT< byps_ptr< BArray1< PSerializable > > > syncResult;	
	sendArraysObject(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< PSerializable > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysObject(const byps_ptr< BArray2< PSerializable > >& arr2, const byps_ptr< BArray3< PSerializable > >& arr3, const byps_ptr< BArray4< PSerializable > >& arr4, ::std::function< void (byps_ptr< BArray1< PSerializable > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysObject(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< PSerializable > >, com::wilutions::byps::test::api::BResult_183594037 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > BStub_RemoteArrayTypes23::sendArraysInline(const byps_ptr< BArray2< com::wilutions::byps::test::api::inl::Point2D > >& arr2, const byps_ptr< BArray3< com::wilutions::byps::test::api::inl::Point2D > >& arr3, const byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > >& arr4)  {
	BSyncResultT< byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > > syncResult;	
	sendArraysInline(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysInline(const byps_ptr< BArray2< com::wilutions::byps::test::api::inl::Point2D > >& arr2, const byps_ptr< BArray3< com::wilutions::byps::test::api::inl::Point2D > >& arr3, const byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > >& arr4, ::std::function< void (byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysInline(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > >, com::wilutions::byps::test::api::BResult_2049740106 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2081058997(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BStub_RemoteArrayTypes23(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

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
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setBool(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setByte(const byps_ptr< BArray4< int8_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setByte(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setByte(const byps_ptr< BArray4< int8_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setByte(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setChar(const byps_ptr< BArray4< wchar_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setChar(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setChar(const byps_ptr< BArray4< wchar_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setChar(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setShort(const byps_ptr< BArray4< int16_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setShort(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setShort(const byps_ptr< BArray4< int16_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setShort(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setInt(const byps_ptr< BArray4< int32_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setInt(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setInt(const byps_ptr< BArray4< int32_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setInt(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setLong(const byps_ptr< BArray4< int64_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setLong(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setLong(const byps_ptr< BArray4< int64_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setLong(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setFloat(const byps_ptr< BArray4< float > >& v)  {
	BSyncResultT< bool > syncResult;	
	setFloat(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setFloat(const byps_ptr< BArray4< float > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setFloat(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setDouble(const byps_ptr< BArray4< double > >& v)  {
	BSyncResultT< bool > syncResult;	
	setDouble(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setDouble(const byps_ptr< BArray4< double > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setDouble(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setString(const byps_ptr< BArray4< ::std::wstring > >& v)  {
	BSyncResultT< bool > syncResult;	
	setString(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setString(const byps_ptr< BArray4< ::std::wstring > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setString(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setPrimitiveTypes(const byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >& v)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setPrimitiveTypes(const byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setPrimitiveTypes(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setObject(const byps_ptr< BArray4< PSerializable > >& v)  {
	BSyncResultT< bool > syncResult;	
	setObject(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setObject(const byps_ptr< BArray4< PSerializable > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setObject(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< bool > > BStub_RemoteArrayTypes4dim::getBool()  {
	BSyncResultT< byps_ptr< BArray4< bool > > > syncResult;	
	getBool([&syncResult](byps_ptr< BArray4< bool > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getBool(::std::function< void (byps_ptr< BArray4< bool > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getBool());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< bool > >, com::wilutions::byps::test::api::BResult_945713488 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< int8_t > > BStub_RemoteArrayTypes4dim::getByte()  {
	BSyncResultT< byps_ptr< BArray4< int8_t > > > syncResult;	
	getByte([&syncResult](byps_ptr< BArray4< int8_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getByte(::std::function< void (byps_ptr< BArray4< int8_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getByte());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< int8_t > >, com::wilutions::byps::test::api::BResult_1201775504 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< wchar_t > > BStub_RemoteArrayTypes4dim::getChar()  {
	BSyncResultT< byps_ptr< BArray4< wchar_t > > > syncResult;	
	getChar([&syncResult](byps_ptr< BArray4< wchar_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getChar(::std::function< void (byps_ptr< BArray4< wchar_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getChar());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< wchar_t > >, com::wilutions::byps::test::api::BResult_769021986 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< int16_t > > BStub_RemoteArrayTypes4dim::getShort()  {
	BSyncResultT< byps_ptr< BArray4< int16_t > > > syncResult;	
	getShort([&syncResult](byps_ptr< BArray4< int16_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getShort(::std::function< void (byps_ptr< BArray4< int16_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getShort());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< int16_t > >, com::wilutions::byps::test::api::BResult_1859644668 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< int32_t > > BStub_RemoteArrayTypes4dim::getInt()  {
	BSyncResultT< byps_ptr< BArray4< int32_t > > > syncResult;	
	getInt([&syncResult](byps_ptr< BArray4< int32_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getInt(::std::function< void (byps_ptr< BArray4< int32_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getInt());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< int32_t > >, com::wilutions::byps::test::api::BResult_39910537 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< int64_t > > BStub_RemoteArrayTypes4dim::getLong()  {
	BSyncResultT< byps_ptr< BArray4< int64_t > > > syncResult;	
	getLong([&syncResult](byps_ptr< BArray4< int64_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getLong(::std::function< void (byps_ptr< BArray4< int64_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getLong());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< int64_t > >, com::wilutions::byps::test::api::BResult_846419204 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< float > > BStub_RemoteArrayTypes4dim::getFloat()  {
	BSyncResultT< byps_ptr< BArray4< float > > > syncResult;	
	getFloat([&syncResult](byps_ptr< BArray4< float > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getFloat(::std::function< void (byps_ptr< BArray4< float > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getFloat());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< float > >, com::wilutions::byps::test::api::BResult_1516687588 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< double > > BStub_RemoteArrayTypes4dim::getDouble()  {
	BSyncResultT< byps_ptr< BArray4< double > > > syncResult;	
	getDouble([&syncResult](byps_ptr< BArray4< double > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getDouble(::std::function< void (byps_ptr< BArray4< double > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getDouble());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< double > >, com::wilutions::byps::test::api::BResult_2087445849 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< ::std::wstring > > BStub_RemoteArrayTypes4dim::getString()  {
	BSyncResultT< byps_ptr< BArray4< ::std::wstring > > > syncResult;	
	getString([&syncResult](byps_ptr< BArray4< ::std::wstring > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getString(::std::function< void (byps_ptr< BArray4< ::std::wstring > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getString());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< ::std::wstring > >, com::wilutions::byps::test::api::BResult_588723219 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteArrayTypes4dim::getPrimitiveTypes()  {
	BSyncResultT< byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	getPrimitiveTypes([&syncResult](byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getPrimitiveTypes(::std::function< void (byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getPrimitiveTypes());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, com::wilutions::byps::test::api::BResult_1503107601 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< PSerializable > > BStub_RemoteArrayTypes4dim::getObject()  {
	BSyncResultT< byps_ptr< BArray4< PSerializable > > > syncResult;	
	getObject([&syncResult](byps_ptr< BArray4< PSerializable > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getObject(::std::function< void (byps_ptr< BArray4< PSerializable > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getObject());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< PSerializable > >, com::wilutions::byps::test::api::BResult_124584219 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1557173854(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BStub_RemoteArrayTypes4dim(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteConstants::BStub_RemoteConstants(PTransport transport) 
	: BStub(transport) {}

void BStub_RemoteConstants::compare_HebrewC(const com::wilutions::byps::test::api::cons::PHebrewZ& ALEPH, const com::wilutions::byps::test::api::cons::PHebrewZ& BETH)  {
	BSyncResultT< bool > syncResult;	
	compare_HebrewC(ALEPH, BETH, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteConstants::compare_HebrewC(const com::wilutions::byps::test::api::cons::PHebrewZ& ALEPH, const com::wilutions::byps::test::api::cons::PHebrewZ& BETH, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteConstants_compare_HebrewC(ALEPH, BETH));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
bool BStub_RemoteConstants::compare_AllTypesC(bool bool1s, bool bool2s, wchar_t char1s, const ::std::wstring& stringNull, wchar_t char2s, int16_t short1s, int32_t int1s, int64_t long1s, float float1s, double double1s, const ::std::wstring& string1s, const com::wilutions::byps::test::api::cons::PAllTypesZ& ALL, const byps_ptr< BArray1< int32_t > >& arrInt, const byps_ptr< BArray4< int32_t > >& arrInt4, const byps_ptr< BArray1< ::std::wstring > >& arrStrings, const byps_ptr< BArray4< ::std::wstring > >& arrStrings4, const byps_ptr< BArray2< com::wilutions::byps::test::api::cons::PAllTypesZ > >& arrAll)  {
	BSyncResultT< bool > syncResult;	
	compare_AllTypesC(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteConstants::compare_AllTypesC(bool bool1s, bool bool2s, wchar_t char1s, const ::std::wstring& stringNull, wchar_t char2s, int16_t short1s, int32_t int1s, int64_t long1s, float float1s, double double1s, const ::std::wstring& string1s, const com::wilutions::byps::test::api::cons::PAllTypesZ& ALL, const byps_ptr< BArray1< int32_t > >& arrInt, const byps_ptr< BArray4< int32_t > >& arrInt4, const byps_ptr< BArray1< ::std::wstring > >& arrStrings, const byps_ptr< BArray4< ::std::wstring > >& arrStrings4, const byps_ptr< BArray2< com::wilutions::byps::test::api::cons::PAllTypesZ > >& arrAll, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteConstants_compare_AllTypesC(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_1 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_431648293(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BStub_RemoteConstants(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteEnums::BStub_RemoteEnums(PTransport transport) 
	: BStub(transport) {}

com::wilutions::byps::test::api::enu::EnumPlanets BStub_RemoteEnums::getPlanet()  {
	BSyncResultT< com::wilutions::byps::test::api::enu::EnumPlanets > syncResult;	
	getPlanet([&syncResult](com::wilutions::byps::test::api::enu::EnumPlanets v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteEnums::getPlanet(::std::function< void (com::wilutions::byps::test::api::enu::EnumPlanets, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteEnums_getPlanet());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< com::wilutions::byps::test::api::enu::EnumPlanets, com::wilutions::byps::test::api::BResult_1042475995 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteEnums::setPlanet(com::wilutions::byps::test::api::enu::EnumPlanets planet)  {
	BSyncResultT< bool > syncResult;	
	setPlanet(planet, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteEnums::setPlanet(com::wilutions::byps::test::api::enu::EnumPlanets planet, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteEnums_setPlanet(planet));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_359349400(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BStub_RemoteEnums(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteInlineInstance::BStub_RemoteInlineInstance(PTransport transport) 
	: BStub(transport) {}

void BStub_RemoteInlineInstance::setActor(const com::wilutions::byps::test::api::inl::PActor& act)  {
	BSyncResultT< bool > syncResult;	
	setActor(act, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteInlineInstance::setActor(const com::wilutions::byps::test::api::inl::PActor& act, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteInlineInstance_setActor(act));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
com::wilutions::byps::test::api::inl::PActor BStub_RemoteInlineInstance::getActor()  {
	BSyncResultT< com::wilutions::byps::test::api::inl::PActor > syncResult;	
	getActor([&syncResult](com::wilutions::byps::test::api::inl::PActor v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteInlineInstance::getActor(::std::function< void (com::wilutions::byps::test::api::inl::PActor, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteInlineInstance_getActor());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< com::wilutions::byps::test::api::inl::PActor, com::wilutions::byps::test::api::BResult_171948703 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteInlineInstance::setPoint2DArray1dim(const byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > >& pointArray)  {
	BSyncResultT< bool > syncResult;	
	setPoint2DArray1dim(pointArray, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteInlineInstance::setPoint2DArray1dim(const byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > >& pointArray, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteInlineInstance_setPoint2DArray1dim(pointArray));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > BStub_RemoteInlineInstance::getPoint2DArray1dim()  {
	BSyncResultT< byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > > syncResult;	
	getPoint2DArray1dim([&syncResult](byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteInlineInstance::getPoint2DArray1dim(::std::function< void (byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteInlineInstance_getPoint2DArray1dim());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > >, com::wilutions::byps::test::api::BResult_2049740106 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteInlineInstance::setPoint2DArray4dim(const byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > >& pointArray)  {
	BSyncResultT< bool > syncResult;	
	setPoint2DArray4dim(pointArray, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteInlineInstance::setPoint2DArray4dim(const byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > >& pointArray, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteInlineInstance_setPoint2DArray4dim(pointArray));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > > BStub_RemoteInlineInstance::getPoint2DArray4dim()  {
	BSyncResultT< byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > > > syncResult;	
	getPoint2DArray4dim([&syncResult](byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteInlineInstance::getPoint2DArray4dim(::std::function< void (byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteInlineInstance_getPoint2DArray4dim());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > >, com::wilutions::byps::test::api::BResult_487702928 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteInlineInstance::setPoint2DList(const byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > >& pointList)  {
	BSyncResultT< bool > syncResult;	
	setPoint2DList(pointList, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteInlineInstance::setPoint2DList(const byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > >& pointList, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteInlineInstance_setPoint2DList(pointList));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > BStub_RemoteInlineInstance::getPoint2DList()  {
	BSyncResultT< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > > syncResult;	
	getPoint2DList([&syncResult](byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteInlineInstance::getPoint2DList(::std::function< void (byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteInlineInstance_getPoint2DList());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > >, com::wilutions::byps::test::api::BResult_172221196 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteInlineInstance::setPoint2DListList(const byps_ptr< ::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > > >& pointListList)  {
	BSyncResultT< bool > syncResult;	
	setPoint2DListList(pointListList, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteInlineInstance::setPoint2DListList(const byps_ptr< ::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > > >& pointListList, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteInlineInstance_setPoint2DListList(pointListList));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > > > BStub_RemoteInlineInstance::getPoint2DListList()  {
	BSyncResultT< byps_ptr< ::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > > > > syncResult;	
	getPoint2DListList([&syncResult](byps_ptr< ::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteInlineInstance::getPoint2DListList(::std::function< void (byps_ptr< ::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteInlineInstance_getPoint2DListList());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > > >, com::wilutions::byps::test::api::BResult_1463615848 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteInlineInstance::setPoint2DMap(const byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D > >& pointMap)  {
	BSyncResultT< bool > syncResult;	
	setPoint2DMap(pointMap, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteInlineInstance::setPoint2DMap(const byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D > >& pointMap, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteInlineInstance_setPoint2DMap(pointMap));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D > > BStub_RemoteInlineInstance::getPoint2DMap()  {
	BSyncResultT< byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D > > > syncResult;	
	getPoint2DMap([&syncResult](byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteInlineInstance::getPoint2DMap(::std::function< void (byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteInlineInstance_getPoint2DMap());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D > >, com::wilutions::byps::test::api::BResult_1851881336 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1206670536(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BStub_RemoteInlineInstance(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}
