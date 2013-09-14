#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_981592984(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , com::wilutions::byps::test::api::inherit::PClass1 >& r = * reinterpret_cast< ::std::map< ::std::wstring , com::wilutions::byps::test::api::inherit::PClass1 >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , com::wilutions::byps::test::api::inherit::PClass1 >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1768677016(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , com::wilutions::byps::test::api::refs::PNode >& r = * reinterpret_cast< ::std::map< ::std::wstring , com::wilutions::byps::test::api::refs::PNode >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , com::wilutions::byps::test::api::refs::PNode >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1279823631(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , bool >& r = * reinterpret_cast< ::std::map< ::std::wstring , bool >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , bool >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1488550492(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , PSerializable >& r = * reinterpret_cast< ::std::map< ::std::wstring , PSerializable >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , PSerializable >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1710660846(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , ::std::wstring >& r = * reinterpret_cast< ::std::map< ::std::wstring , ::std::wstring >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , ::std::wstring >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2052431866(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< PBytes >& r = * reinterpret_cast< ::std::set< PBytes >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< PBytes >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2114305573(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< com::wilutions::byps::test::api::inherit::PClass1 >& r = * reinterpret_cast< ::std::set< com::wilutions::byps::test::api::inherit::PClass1 >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< com::wilutions::byps::test::api::inherit::PClass1 >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1280571537(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes >& r = * reinterpret_cast< ::std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1406124761(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< byps_ptr< BArray1< int32_t > > >& r = * reinterpret_cast< ::std::set< byps_ptr< BArray1< int32_t > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< byps_ptr< BArray1< int32_t > > >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1365696060(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< bool >& r = * reinterpret_cast< ::std::set< bool >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< bool >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1320560671(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< double >& r = * reinterpret_cast< ::std::set< double >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< double >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1898022288(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< float >& r = * reinterpret_cast< ::std::set< float >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< float >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1493282670(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int32_t >& r = * reinterpret_cast< ::std::set< int32_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int32_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1457164460(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int64_t >& r = * reinterpret_cast< ::std::set< int64_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int64_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2028443792(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int16_t >& r = * reinterpret_cast< ::std::set< int16_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int16_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1888799711(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< ::std::wstring >& r = * reinterpret_cast< ::std::set< ::std::wstring >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< ::std::wstring >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_8789515(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< float , wchar_t >& r = * reinterpret_cast< ::std::map< float , wchar_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< float , wchar_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_476459792(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , PContentStream >& r = * reinterpret_cast< ::std::map< int32_t , PContentStream >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , PContentStream >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_936607009(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< wchar_t >& r = * reinterpret_cast< ::std::set< wchar_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< wchar_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_855786668(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int32_t >& r = * reinterpret_cast< ::std::set< int32_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int32_t >());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1097129250(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< int64_t > & r = * reinterpret_cast< BArray1< int64_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< int64_t > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_846419204(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< int64_t > & r = * reinterpret_cast< BArray4< int64_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< int64_t > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2067161310(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< int16_t > & r = * reinterpret_cast< BArray1< int16_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< int16_t > ());
	}
}
}}}}}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1859644668(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< int16_t > & r = * reinterpret_cast< BArray4< int16_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< int16_t > ());
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteArrayTypes1dim::BStub_RemoteArrayTypes1dim(PTransport transport) 
	: BStub(transport) {}

void BStub_RemoteArrayTypes1dim::setBool(byps_ptr< BArray1< bool > > v)  {
	BSyncResultT< bool > syncResult;	
	setBool(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setBool(byps_ptr< BArray1< bool > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setBool(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setByte(PBytes v)  {
	BSyncResultT< bool > syncResult;	
	setByte(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setByte(PBytes v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setByte(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setChar(byps_ptr< BArray1< wchar_t > > v)  {
	BSyncResultT< bool > syncResult;	
	setChar(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setChar(byps_ptr< BArray1< wchar_t > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setChar(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setShort(byps_ptr< BArray1< int16_t > > v)  {
	BSyncResultT< bool > syncResult;	
	setShort(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setShort(byps_ptr< BArray1< int16_t > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setShort(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setInt(byps_ptr< BArray1< int32_t > > v)  {
	BSyncResultT< bool > syncResult;	
	setInt(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setInt(byps_ptr< BArray1< int32_t > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setInt(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setLong(byps_ptr< BArray1< int64_t > > v)  {
	BSyncResultT< bool > syncResult;	
	setLong(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setLong(byps_ptr< BArray1< int64_t > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setLong(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setFloat(byps_ptr< BArray1< float > > v)  {
	BSyncResultT< bool > syncResult;	
	setFloat(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setFloat(byps_ptr< BArray1< float > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setFloat(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setDouble(byps_ptr< BArray1< double > > v)  {
	BSyncResultT< bool > syncResult;	
	setDouble(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setDouble(byps_ptr< BArray1< double > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setDouble(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setString(byps_ptr< BArray1< ::std::wstring > > v)  {
	BSyncResultT< bool > syncResult;	
	setString(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setString(byps_ptr< BArray1< ::std::wstring > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setString(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setPrimitiveTypes(byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setPrimitiveTypes(byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setPrimitiveTypes(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setObject(byps_ptr< BArray1< PSerializable > > v)  {
	BSyncResultT< bool > syncResult;	
	setObject(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setObject(byps_ptr< BArray1< PSerializable > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
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

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:223
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
		com::wilutions::byps::test::api::remote::RemoteArrayTypes1dim* r = dynamic_cast<com::wilutions::byps::test::api::remote::RemoteArrayTypes1dim*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteArrayTypes23::BStub_RemoteArrayTypes23(PTransport transport) 
	: BStub(transport) {}

byps_ptr< BArray1< int32_t > > BStub_RemoteArrayTypes23::sendArraysInt(byps_ptr< BArray2< int32_t > > arr2, byps_ptr< BArray3< int32_t > > arr3, byps_ptr< BArray4< int32_t > > arr4)  {
	BSyncResultT< byps_ptr< BArray1< int32_t > > > syncResult;	
	sendArraysInt(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< int32_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysInt(byps_ptr< BArray2< int32_t > > arr2, byps_ptr< BArray3< int32_t > > arr3, byps_ptr< BArray4< int32_t > > arr4, ::std::function< void (byps_ptr< BArray1< int32_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysInt(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< int32_t > >, com::wilutions::byps::test::api::BResult_100361105 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< ::std::wstring > > BStub_RemoteArrayTypes23::sendArraysString(byps_ptr< BArray2< ::std::wstring > > arr2, byps_ptr< BArray3< ::std::wstring > > arr3, byps_ptr< BArray4< ::std::wstring > > arr4)  {
	BSyncResultT< byps_ptr< BArray1< ::std::wstring > > > syncResult;	
	sendArraysString(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< ::std::wstring > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysString(byps_ptr< BArray2< ::std::wstring > > arr2, byps_ptr< BArray3< ::std::wstring > > arr3, byps_ptr< BArray4< ::std::wstring > > arr4, ::std::function< void (byps_ptr< BArray1< ::std::wstring > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysString(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< ::std::wstring > >, com::wilutions::byps::test::api::BResult_1888107655 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteArrayTypes23::sendArraysClass(byps_ptr< BArray2< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr2, byps_ptr< BArray3< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr3, byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr4)  {
	BSyncResultT< byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	sendArraysClass(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysClass(byps_ptr< BArray2< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr2, byps_ptr< BArray3< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr3, byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr4, ::std::function< void (byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysClass(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, com::wilutions::byps::test::api::BResult_801243127 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< PSerializable > > BStub_RemoteArrayTypes23::sendArraysObject(byps_ptr< BArray2< PSerializable > > arr2, byps_ptr< BArray3< PSerializable > > arr3, byps_ptr< BArray4< PSerializable > > arr4)  {
	BSyncResultT< byps_ptr< BArray1< PSerializable > > > syncResult;	
	sendArraysObject(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< PSerializable > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysObject(byps_ptr< BArray2< PSerializable > > arr2, byps_ptr< BArray3< PSerializable > > arr3, byps_ptr< BArray4< PSerializable > > arr4, ::std::function< void (byps_ptr< BArray1< PSerializable > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysObject(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< PSerializable > >, com::wilutions::byps::test::api::BResult_183594037 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > BStub_RemoteArrayTypes23::sendArraysInline(byps_ptr< BArray2< com::wilutions::byps::test::api::inl::Point2D > > arr2, byps_ptr< BArray3< com::wilutions::byps::test::api::inl::Point2D > > arr3, byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > > arr4)  {
	BSyncResultT< byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > > syncResult;	
	sendArraysInline(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysInline(byps_ptr< BArray2< com::wilutions::byps::test::api::inl::Point2D > > arr2, byps_ptr< BArray3< com::wilutions::byps::test::api::inl::Point2D > > arr3, byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > > arr4, ::std::function< void (byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysInline(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > >, com::wilutions::byps::test::api::BResult_2049740106 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:223
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
		com::wilutions::byps::test::api::remote::RemoteArrayTypes23* r = dynamic_cast<com::wilutions::byps::test::api::remote::RemoteArrayTypes23*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteArrayTypes4dim::BStub_RemoteArrayTypes4dim(PTransport transport) 
	: BStub(transport) {}

void BStub_RemoteArrayTypes4dim::setBool(byps_ptr< BArray4< bool > > v)  {
	BSyncResultT< bool > syncResult;	
	setBool(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setBool(byps_ptr< BArray4< bool > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setBool(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setByte(byps_ptr< BArray4< int8_t > > v)  {
	BSyncResultT< bool > syncResult;	
	setByte(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setByte(byps_ptr< BArray4< int8_t > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setByte(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setChar(byps_ptr< BArray4< wchar_t > > v)  {
	BSyncResultT< bool > syncResult;	
	setChar(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setChar(byps_ptr< BArray4< wchar_t > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setChar(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setShort(byps_ptr< BArray4< int16_t > > v)  {
	BSyncResultT< bool > syncResult;	
	setShort(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setShort(byps_ptr< BArray4< int16_t > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setShort(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setInt(byps_ptr< BArray4< int32_t > > v)  {
	BSyncResultT< bool > syncResult;	
	setInt(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setInt(byps_ptr< BArray4< int32_t > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setInt(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setLong(byps_ptr< BArray4< int64_t > > v)  {
	BSyncResultT< bool > syncResult;	
	setLong(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setLong(byps_ptr< BArray4< int64_t > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setLong(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setFloat(byps_ptr< BArray4< float > > v)  {
	BSyncResultT< bool > syncResult;	
	setFloat(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setFloat(byps_ptr< BArray4< float > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setFloat(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setDouble(byps_ptr< BArray4< double > > v)  {
	BSyncResultT< bool > syncResult;	
	setDouble(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setDouble(byps_ptr< BArray4< double > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setDouble(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setString(byps_ptr< BArray4< ::std::wstring > > v)  {
	BSyncResultT< bool > syncResult;	
	setString(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setString(byps_ptr< BArray4< ::std::wstring > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setString(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setPrimitiveTypes(byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setPrimitiveTypes(byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setPrimitiveTypes(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setObject(byps_ptr< BArray4< PSerializable > > v)  {
	BSyncResultT< bool > syncResult;	
	setObject(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setObject(byps_ptr< BArray4< PSerializable > > v, ::std::function< void (bool, BException ex) > asyncResult)  {
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

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:223
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
		com::wilutions::byps::test::api::remote::RemoteArrayTypes4dim* r = dynamic_cast<com::wilutions::byps::test::api::remote::RemoteArrayTypes4dim*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteConstants::BStub_RemoteConstants(PTransport transport) 
	: BStub(transport) {}

void BStub_RemoteConstants::compare_HebrewC(com::wilutions::byps::test::api::cons::PHebrewZ ALEPH, com::wilutions::byps::test::api::cons::PHebrewZ BETH)  {
	BSyncResultT< bool > syncResult;	
	compare_HebrewC(ALEPH, BETH, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteConstants::compare_HebrewC(com::wilutions::byps::test::api::cons::PHebrewZ ALEPH, com::wilutions::byps::test::api::cons::PHebrewZ BETH, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteConstants_compare_HebrewC(ALEPH, BETH));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
bool BStub_RemoteConstants::compare_AllTypesC(bool bool1s, bool bool2s, wchar_t char1s, ::std::wstring stringNull, wchar_t char2s, int16_t short1s, int32_t int1s, int64_t long1s, float float1s, double double1s, ::std::wstring string1s, com::wilutions::byps::test::api::cons::PAllTypesZ ALL, byps_ptr< BArray1< int32_t > > arrInt, byps_ptr< BArray4< int32_t > > arrInt4, byps_ptr< BArray1< ::std::wstring > > arrStrings, byps_ptr< BArray4< ::std::wstring > > arrStrings4, byps_ptr< BArray2< com::wilutions::byps::test::api::cons::PAllTypesZ > > arrAll)  {
	BSyncResultT< bool > syncResult;	
	compare_AllTypesC(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteConstants::compare_AllTypesC(bool bool1s, bool bool2s, wchar_t char1s, ::std::wstring stringNull, wchar_t char2s, int16_t short1s, int32_t int1s, int64_t long1s, float float1s, double double1s, ::std::wstring string1s, com::wilutions::byps::test::api::cons::PAllTypesZ ALL, byps_ptr< BArray1< int32_t > > arrInt, byps_ptr< BArray4< int32_t > > arrInt4, byps_ptr< BArray1< ::std::wstring > > arrStrings, byps_ptr< BArray4< ::std::wstring > > arrStrings4, byps_ptr< BArray2< com::wilutions::byps::test::api::cons::PAllTypesZ > > arrAll, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteConstants_compare_AllTypesC(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_1 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:223
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
		com::wilutions::byps::test::api::remote::RemoteConstants* r = dynamic_cast<com::wilutions::byps::test::api::remote::RemoteConstants*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}
