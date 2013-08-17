#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;


namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteMapTypes::BStub_RemoteMapTypes(PTransport transport) 
	: BStub(transport) {}

byps_ptr< ::std::map< ::std::wstring , bool > > BStub_RemoteMapTypes::getBoolean1()  {
	BSyncResultT< byps_ptr< ::std::map< ::std::wstring , bool > > > syncResult;	
	async_getBoolean1([&syncResult](byps_ptr< ::std::map< ::std::wstring , bool > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::async_getBoolean1(std::function< void (byps_ptr< ::std::map< ::std::wstring , bool > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getBoolean1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< ::std::wstring , bool > >, BResult_1279823631 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setBoolean1(byps_ptr< ::std::map< ::std::wstring , bool > > boolean1)  {
	BSyncResultT< bool > syncResult;	
	async_setBoolean1(boolean1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::async_setBoolean1(byps_ptr< ::std::map< ::std::wstring , bool > > boolean1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setBoolean1(boolean1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< double , int8_t > > BStub_RemoteMapTypes::getByte1()  {
	BSyncResultT< byps_ptr< ::std::map< double , int8_t > > > syncResult;	
	async_getByte1([&syncResult](byps_ptr< ::std::map< double , int8_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::async_getByte1(std::function< void (byps_ptr< ::std::map< double , int8_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getByte1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< double , int8_t > >, BResult_1972793385 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setByte1(byps_ptr< ::std::map< double , int8_t > > byte1)  {
	BSyncResultT< bool > syncResult;	
	async_setByte1(byte1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::async_setByte1(byps_ptr< ::std::map< double , int8_t > > byte1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setByte1(byte1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< float , wchar_t > > BStub_RemoteMapTypes::getChar1()  {
	BSyncResultT< byps_ptr< ::std::map< float , wchar_t > > > syncResult;	
	async_getChar1([&syncResult](byps_ptr< ::std::map< float , wchar_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::async_getChar1(std::function< void (byps_ptr< ::std::map< float , wchar_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getChar1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< float , wchar_t > >, BResult_8789515 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setChar1(byps_ptr< ::std::map< float , wchar_t > > char1)  {
	BSyncResultT< bool > syncResult;	
	async_setChar1(char1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::async_setChar1(byps_ptr< ::std::map< float , wchar_t > > char1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setChar1(char1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< int64_t , int16_t > > BStub_RemoteMapTypes::getShort1()  {
	BSyncResultT< byps_ptr< ::std::map< int64_t , int16_t > > > syncResult;	
	async_getShort1([&syncResult](byps_ptr< ::std::map< int64_t , int16_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::async_getShort1(std::function< void (byps_ptr< ::std::map< int64_t , int16_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getShort1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int64_t , int16_t > >, BResult_601099730 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setShort1(byps_ptr< ::std::map< int64_t , int16_t > > short1)  {
	BSyncResultT< bool > syncResult;	
	async_setShort1(short1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::async_setShort1(byps_ptr< ::std::map< int64_t , int16_t > > short1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setShort1(short1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< int32_t , int32_t > > BStub_RemoteMapTypes::getInt1()  {
	BSyncResultT< byps_ptr< ::std::map< int32_t , int32_t > > > syncResult;	
	async_getInt1([&syncResult](byps_ptr< ::std::map< int32_t , int32_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::async_getInt1(std::function< void (byps_ptr< ::std::map< int32_t , int32_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getInt1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int32_t , int32_t > >, BResult_1347703734 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setInt1(byps_ptr< ::std::map< int32_t , int32_t > > int1)  {
	BSyncResultT< bool > syncResult;	
	async_setInt1(int1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::async_setInt1(byps_ptr< ::std::map< int32_t , int32_t > > int1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setInt1(int1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< int16_t , int64_t > > BStub_RemoteMapTypes::getLong1()  {
	BSyncResultT< byps_ptr< ::std::map< int16_t , int64_t > > > syncResult;	
	async_getLong1([&syncResult](byps_ptr< ::std::map< int16_t , int64_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::async_getLong1(std::function< void (byps_ptr< ::std::map< int16_t , int64_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getLong1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int16_t , int64_t > >, BResult_1973996106 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setLong1(byps_ptr< ::std::map< int16_t , int64_t > > long1)  {
	BSyncResultT< bool > syncResult;	
	async_setLong1(long1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::async_setLong1(byps_ptr< ::std::map< int16_t , int64_t > > long1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setLong1(long1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< wchar_t , float > > BStub_RemoteMapTypes::getFloat1()  {
	BSyncResultT< byps_ptr< ::std::map< wchar_t , float > > > syncResult;	
	async_getFloat1([&syncResult](byps_ptr< ::std::map< wchar_t , float > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::async_getFloat1(std::function< void (byps_ptr< ::std::map< wchar_t , float > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getFloat1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< wchar_t , float > >, BResult_94341197 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setFloat1(byps_ptr< ::std::map< wchar_t , float > > float1)  {
	BSyncResultT< bool > syncResult;	
	async_setFloat1(float1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::async_setFloat1(byps_ptr< ::std::map< wchar_t , float > > float1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setFloat1(float1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< int8_t , double > > BStub_RemoteMapTypes::getDouble1()  {
	BSyncResultT< byps_ptr< ::std::map< int8_t , double > > > syncResult;	
	async_getDouble1([&syncResult](byps_ptr< ::std::map< int8_t , double > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::async_getDouble1(std::function< void (byps_ptr< ::std::map< int8_t , double > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getDouble1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int8_t , double > >, BResult_1487265161 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setDouble1(byps_ptr< ::std::map< int8_t , double > > double1)  {
	BSyncResultT< bool > syncResult;	
	async_setDouble1(double1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::async_setDouble1(byps_ptr< ::std::map< int8_t , double > > double1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setDouble1(double1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< ::std::wstring , ::std::wstring > > BStub_RemoteMapTypes::getString1()  {
	BSyncResultT< byps_ptr< ::std::map< ::std::wstring , ::std::wstring > > > syncResult;	
	async_getString1([&syncResult](byps_ptr< ::std::map< ::std::wstring , ::std::wstring > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::async_getString1(std::function< void (byps_ptr< ::std::map< ::std::wstring , ::std::wstring > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getString1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< ::std::wstring , ::std::wstring > >, BResult_1710660846 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setString1(byps_ptr< ::std::map< ::std::wstring , ::std::wstring > > string1)  {
	BSyncResultT< bool > syncResult;	
	async_setString1(string1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::async_setString1(byps_ptr< ::std::map< ::std::wstring , ::std::wstring > > string1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setString1(string1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteMapTypes::getPrimitiveTypes1()  {
	BSyncResultT< byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	async_getPrimitiveTypes1([&syncResult](byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::async_getPrimitiveTypes1(std::function< void (byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getPrimitiveTypes1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BResult_703065817 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setPrimitiveTypes1(byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > > primitiveTypes1)  {
	BSyncResultT< bool > syncResult;	
	async_setPrimitiveTypes1(primitiveTypes1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::async_setPrimitiveTypes1(byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > > primitiveTypes1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setPrimitiveTypes1(primitiveTypes1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< int32_t , PBytes > > BStub_RemoteMapTypes::getByte2()  {
	BSyncResultT< byps_ptr< ::std::map< int32_t , PBytes > > > syncResult;	
	async_getByte2([&syncResult](byps_ptr< ::std::map< int32_t , PBytes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::async_getByte2(std::function< void (byps_ptr< ::std::map< int32_t , PBytes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getByte2());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int32_t , PBytes > >, BResult_1799280818 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setByte2(byps_ptr< ::std::map< int32_t , PBytes > > byte2)  {
	BSyncResultT< bool > syncResult;	
	async_setByte2(byte2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::async_setByte2(byps_ptr< ::std::map< int32_t , PBytes > > byte2, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setByte2(byte2));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > > BStub_RemoteMapTypes::getInt2()  {
	BSyncResultT< byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > > > syncResult;	
	async_getInt2([&syncResult](byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::async_getInt2(std::function< void (byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getInt2());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > >, BResult_1633750383 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setInt2(byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > > int2)  {
	BSyncResultT< bool > syncResult;	
	async_setInt2(int2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::async_setInt2(byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > > int2, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setInt2(int2));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< ::std::wstring , PSerializable > > BStub_RemoteMapTypes::getObj1()  {
	BSyncResultT< byps_ptr< ::std::map< ::std::wstring , PSerializable > > > syncResult;	
	async_getObj1([&syncResult](byps_ptr< ::std::map< ::std::wstring , PSerializable > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::async_getObj1(std::function< void (byps_ptr< ::std::map< ::std::wstring , PSerializable > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getObj1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< ::std::wstring , PSerializable > >, BResult_1488550492 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setObj1(byps_ptr< ::std::map< ::std::wstring , PSerializable > > obj1)  {
	BSyncResultT< bool > syncResult;	
	async_setObj1(obj1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::async_setObj1(byps_ptr< ::std::map< ::std::wstring , PSerializable > > obj1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setObj1(obj1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_80483097(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BStub_RemoteMapTypes(transport));
	}
	else {
		com::wilutions::byps::test::api::remote::RemoteMapTypes* r = dynamic_cast<com::wilutions::byps::test::api::remote::RemoteMapTypes*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

void BSkeleton_RemotePrimitiveTypes::voidFunctionVoid()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_voidFunctionVoid(std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		voidFunctionVoid();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemotePrimitiveTypes::setBool(bool v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_setBool(bool v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setBool(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemotePrimitiveTypes::setByte(int8_t v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_setByte(int8_t v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setByte(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemotePrimitiveTypes::setChar(wchar_t v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_setChar(wchar_t v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setChar(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemotePrimitiveTypes::setShort(int16_t v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_setShort(int16_t v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setShort(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemotePrimitiveTypes::setInt(int32_t v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_setInt(int32_t v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setInt(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemotePrimitiveTypes::setLong(int64_t v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_setLong(int64_t v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setLong(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemotePrimitiveTypes::setFloat(float v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_setFloat(float v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setFloat(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemotePrimitiveTypes::setDouble(double v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_setDouble(double v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setDouble(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemotePrimitiveTypes::setString(::std::wstring v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_setString(::std::wstring v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setString(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemotePrimitiveTypes::setPrimitiveTypes(com::wilutions::byps::test::api::prim::PPrimitiveTypes v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_setPrimitiveTypes(com::wilutions::byps::test::api::prim::PPrimitiveTypes v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setPrimitiveTypes(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemotePrimitiveTypes::setObject(PSerializable v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_setObject(PSerializable v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setObject(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
bool BSkeleton_RemotePrimitiveTypes::getBool()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_getBool(std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = bool();
	try {
		ret = getBool();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
int8_t BSkeleton_RemotePrimitiveTypes::getByte()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_getByte(std::function< void (int8_t, BException ex) > asyncResult)  {
	int8_t ret = int8_t();
	try {
		ret = getByte();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
wchar_t BSkeleton_RemotePrimitiveTypes::getChar()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_getChar(std::function< void (wchar_t, BException ex) > asyncResult)  {
	wchar_t ret = wchar_t();
	try {
		ret = getChar();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
int16_t BSkeleton_RemotePrimitiveTypes::getShort()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_getShort(std::function< void (int16_t, BException ex) > asyncResult)  {
	int16_t ret = int16_t();
	try {
		ret = getShort();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
int32_t BSkeleton_RemotePrimitiveTypes::getInt()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_getInt(std::function< void (int32_t, BException ex) > asyncResult)  {
	int32_t ret = int32_t();
	try {
		ret = getInt();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
int64_t BSkeleton_RemotePrimitiveTypes::getLong()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_getLong(std::function< void (int64_t, BException ex) > asyncResult)  {
	int64_t ret = int64_t();
	try {
		ret = getLong();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
float BSkeleton_RemotePrimitiveTypes::getFloat()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_getFloat(std::function< void (float, BException ex) > asyncResult)  {
	float ret = float();
	try {
		ret = getFloat();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
double BSkeleton_RemotePrimitiveTypes::getDouble()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_getDouble(std::function< void (double, BException ex) > asyncResult)  {
	double ret = double();
	try {
		ret = getDouble();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
::std::wstring BSkeleton_RemotePrimitiveTypes::getString()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_getString(std::function< void (::std::wstring, BException ex) > asyncResult)  {
	::std::wstring ret = ::std::wstring();
	try {
		ret = getString();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
com::wilutions::byps::test::api::prim::PPrimitiveTypes BSkeleton_RemotePrimitiveTypes::getPrimitiveTypes()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_getPrimitiveTypes(std::function< void (com::wilutions::byps::test::api::prim::PPrimitiveTypes, BException ex) > asyncResult)  {
	com::wilutions::byps::test::api::prim::PPrimitiveTypes ret = com::wilutions::byps::test::api::prim::PPrimitiveTypes();
	try {
		ret = getPrimitiveTypes();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
PSerializable BSkeleton_RemotePrimitiveTypes::getObject()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_getObject(std::function< void (PSerializable, BException ex) > asyncResult)  {
	PSerializable ret = PSerializable();
	try {
		ret = getObject();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemotePrimitiveTypes::sendAllTypes(bool b, wchar_t c, int16_t s, int32_t i, int64_t l, float f, double d, ::std::wstring str, com::wilutions::byps::test::api::prim::PPrimitiveTypes pt, PSerializable o)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_sendAllTypes(bool b, wchar_t c, int16_t s, int32_t i, int64_t l, float f, double d, ::std::wstring str, com::wilutions::byps::test::api::prim::PPrimitiveTypes pt, PSerializable o, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		sendAllTypes(b, c, s, i, l, f, d, str, pt, o);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
int32_t BSkeleton_RemotePrimitiveTypes::add(int32_t a, int32_t b)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemotePrimitiveTypes::async_add(int32_t a, int32_t b, std::function< void (int32_t, BException ex) > asyncResult)  {
	int32_t ret = int32_t();
	try {
		ret = add(a, b);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
}}}}}}


namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemotePrimitiveTypes::BStub_RemotePrimitiveTypes(PTransport transport) 
	: BStub(transport) {}

void BStub_RemotePrimitiveTypes::voidFunctionVoid()  {
	BSyncResultT< bool > syncResult;	
	async_voidFunctionVoid([&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_voidFunctionVoid(std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_voidFunctionVoid());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setBool(bool v)  {
	BSyncResultT< bool > syncResult;	
	async_setBool(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_setBool(bool v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setBool(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setByte(int8_t v)  {
	BSyncResultT< bool > syncResult;	
	async_setByte(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_setByte(int8_t v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setByte(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setChar(wchar_t v)  {
	BSyncResultT< bool > syncResult;	
	async_setChar(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_setChar(wchar_t v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setChar(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setShort(int16_t v)  {
	BSyncResultT< bool > syncResult;	
	async_setShort(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_setShort(int16_t v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setShort(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setInt(int32_t v)  {
	BSyncResultT< bool > syncResult;	
	async_setInt(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_setInt(int32_t v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setInt(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setLong(int64_t v)  {
	BSyncResultT< bool > syncResult;	
	async_setLong(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_setLong(int64_t v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setLong(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setFloat(float v)  {
	BSyncResultT< bool > syncResult;	
	async_setFloat(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_setFloat(float v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setFloat(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setDouble(double v)  {
	BSyncResultT< bool > syncResult;	
	async_setDouble(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_setDouble(double v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setDouble(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setString(::std::wstring v)  {
	BSyncResultT< bool > syncResult;	
	async_setString(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_setString(::std::wstring v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setString(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setPrimitiveTypes(com::wilutions::byps::test::api::prim::PPrimitiveTypes v)  {
	BSyncResultT< bool > syncResult;	
	async_setPrimitiveTypes(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_setPrimitiveTypes(com::wilutions::byps::test::api::prim::PPrimitiveTypes v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setPrimitiveTypes(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setObject(PSerializable v)  {
	BSyncResultT< bool > syncResult;	
	async_setObject(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_setObject(PSerializable v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setObject(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
bool BStub_RemotePrimitiveTypes::getBool()  {
	BSyncResultT< bool > syncResult;	
	async_getBool([&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_getBool(std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getBool());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_1 >(asyncResult) );
	transport->send(req, outerResult);
}
int8_t BStub_RemotePrimitiveTypes::getByte()  {
	BSyncResultT< int8_t > syncResult;	
	async_getByte([&syncResult](int8_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_getByte(std::function< void (int8_t, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getByte());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int8_t, BResult_2 >(asyncResult) );
	transport->send(req, outerResult);
}
wchar_t BStub_RemotePrimitiveTypes::getChar()  {
	BSyncResultT< wchar_t > syncResult;	
	async_getChar([&syncResult](wchar_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_getChar(std::function< void (wchar_t, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getChar());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< wchar_t, BResult_4 >(asyncResult) );
	transport->send(req, outerResult);
}
int16_t BStub_RemotePrimitiveTypes::getShort()  {
	BSyncResultT< int16_t > syncResult;	
	async_getShort([&syncResult](int16_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_getShort(std::function< void (int16_t, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getShort());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int16_t, BResult_3 >(asyncResult) );
	transport->send(req, outerResult);
}
int32_t BStub_RemotePrimitiveTypes::getInt()  {
	BSyncResultT< int32_t > syncResult;	
	async_getInt([&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_getInt(std::function< void (int32_t, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getInt());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, BResult_5 >(asyncResult) );
	transport->send(req, outerResult);
}
int64_t BStub_RemotePrimitiveTypes::getLong()  {
	BSyncResultT< int64_t > syncResult;	
	async_getLong([&syncResult](int64_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_getLong(std::function< void (int64_t, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getLong());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int64_t, BResult_6 >(asyncResult) );
	transport->send(req, outerResult);
}
float BStub_RemotePrimitiveTypes::getFloat()  {
	BSyncResultT< float > syncResult;	
	async_getFloat([&syncResult](float v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_getFloat(std::function< void (float, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getFloat());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< float, BResult_7 >(asyncResult) );
	transport->send(req, outerResult);
}
double BStub_RemotePrimitiveTypes::getDouble()  {
	BSyncResultT< double > syncResult;	
	async_getDouble([&syncResult](double v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_getDouble(std::function< void (double, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getDouble());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< double, BResult_8 >(asyncResult) );
	transport->send(req, outerResult);
}
::std::wstring BStub_RemotePrimitiveTypes::getString()  {
	BSyncResultT< ::std::wstring > syncResult;	
	async_getString([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_getString(std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getString());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
com::wilutions::byps::test::api::prim::PPrimitiveTypes BStub_RemotePrimitiveTypes::getPrimitiveTypes()  {
	BSyncResultT< com::wilutions::byps::test::api::prim::PPrimitiveTypes > syncResult;	
	async_getPrimitiveTypes([&syncResult](com::wilutions::byps::test::api::prim::PPrimitiveTypes v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_getPrimitiveTypes(std::function< void (com::wilutions::byps::test::api::prim::PPrimitiveTypes, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getPrimitiveTypes());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< com::wilutions::byps::test::api::prim::PPrimitiveTypes, BResult_1000 >(asyncResult) );
	transport->send(req, outerResult);
}
PSerializable BStub_RemotePrimitiveTypes::getObject()  {
	BSyncResultT< PSerializable > syncResult;	
	async_getObject([&syncResult](PSerializable v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_getObject(std::function< void (PSerializable, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getObject());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PSerializable, BResult_21 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::sendAllTypes(bool b, wchar_t c, int16_t s, int32_t i, int64_t l, float f, double d, ::std::wstring str, com::wilutions::byps::test::api::prim::PPrimitiveTypes pt, PSerializable o)  {
	BSyncResultT< bool > syncResult;	
	async_sendAllTypes(b, c, s, i, l, f, d, str, pt, o, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_sendAllTypes(bool b, wchar_t c, int16_t s, int32_t i, int64_t l, float f, double d, ::std::wstring str, com::wilutions::byps::test::api::prim::PPrimitiveTypes pt, PSerializable o, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_sendAllTypes(b, c, s, i, l, f, d, str, pt, o));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
int32_t BStub_RemotePrimitiveTypes::add(int32_t a, int32_t b)  {
	BSyncResultT< int32_t > syncResult;	
	async_add(a, b, [&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::async_add(int32_t a, int32_t b, std::function< void (int32_t, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_add(a, b));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, BResult_5 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1341983932(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BStub_RemotePrimitiveTypes(transport));
	}
	else {
		com::wilutions::byps::test::api::remote::RemotePrimitiveTypes* r = dynamic_cast<com::wilutions::byps::test::api::remote::RemotePrimitiveTypes*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

com::wilutions::byps::test::api::refs::PNode BSkeleton_RemoteReferences::getNode()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteReferences::async_getNode(std::function< void (com::wilutions::byps::test::api::refs::PNode, BException ex) > asyncResult)  {
	com::wilutions::byps::test::api::refs::PNode ret = com::wilutions::byps::test::api::refs::PNode();
	try {
		ret = getNode();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteReferences::setNode(com::wilutions::byps::test::api::refs::PNode v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteReferences::async_setNode(com::wilutions::byps::test::api::refs::PNode v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setNode(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
}}}}}}


namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteReferences::BStub_RemoteReferences(PTransport transport) 
	: BStub(transport) {}

com::wilutions::byps::test::api::refs::PNode BStub_RemoteReferences::getNode()  {
	BSyncResultT< com::wilutions::byps::test::api::refs::PNode > syncResult;	
	async_getNode([&syncResult](com::wilutions::byps::test::api::refs::PNode v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteReferences::async_getNode(std::function< void (com::wilutions::byps::test::api::refs::PNode, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteReferences_getNode());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< com::wilutions::byps::test::api::refs::PNode, BResult_9001 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteReferences::setNode(com::wilutions::byps::test::api::refs::PNode v)  {
	BSyncResultT< bool > syncResult;	
	async_setNode(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteReferences::async_setNode(com::wilutions::byps::test::api::refs::PNode v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteReferences_setNode(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

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
		com::wilutions::byps::test::api::remote::RemoteReferences* r = dynamic_cast<com::wilutions::byps::test::api::remote::RemoteReferences*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

void BSkeleton_RemoteServerCtrl::publishRemote(::std::wstring name, PRemote remote, bool fowardToOtherServers)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteServerCtrl::async_publishRemote(::std::wstring name, PRemote remote, bool fowardToOtherServers, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		publishRemote(name, remote, fowardToOtherServers);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
PRemote BSkeleton_RemoteServerCtrl::getPublishedRemote(::std::wstring name)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteServerCtrl::async_getPublishedRemote(::std::wstring name, std::function< void (PRemote, BException ex) > asyncResult)  {
	PRemote ret = PRemote();
	try {
		ret = getPublishedRemote(name);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteServerCtrl::removePublishedRemote(::std::wstring name)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteServerCtrl::async_removePublishedRemote(::std::wstring name, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		removePublishedRemote(name);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
}}}}}}


namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteServerCtrl::BStub_RemoteServerCtrl(PTransport transport) 
	: BStub(transport) {}

void BStub_RemoteServerCtrl::publishRemote(::std::wstring name, PRemote remote, bool fowardToOtherServers)  {
	BSyncResultT< bool > syncResult;	
	async_publishRemote(name, remote, fowardToOtherServers, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteServerCtrl::async_publishRemote(::std::wstring name, PRemote remote, bool fowardToOtherServers, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteServerCtrl_publishRemote(name, remote, fowardToOtherServers));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
PRemote BStub_RemoteServerCtrl::getPublishedRemote(::std::wstring name)  {
	BSyncResultT< PRemote > syncResult;	
	async_getPublishedRemote(name, [&syncResult](PRemote v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteServerCtrl::async_getPublishedRemote(::std::wstring name, std::function< void (PRemote, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteServerCtrl_getPublishedRemote(name));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PRemote, BResult_16 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteServerCtrl::removePublishedRemote(::std::wstring name)  {
	BSyncResultT< bool > syncResult;	
	async_removePublishedRemote(name, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteServerCtrl::async_removePublishedRemote(::std::wstring name, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteServerCtrl_removePublishedRemote(name));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

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
		com::wilutions::byps::test::api::remote::RemoteServerCtrl* r = dynamic_cast<com::wilutions::byps::test::api::remote::RemoteServerCtrl*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}
