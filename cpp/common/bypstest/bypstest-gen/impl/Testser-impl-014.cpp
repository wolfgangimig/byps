#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;


namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteMapTypes::BStub_RemoteMapTypes(PTransport transport) 
	: BStub(transport) {}

byps_ptr< ::std::map< ::std::wstring , bool > > BStub_RemoteMapTypes::getBoolean1()  {
	BSyncResultT< byps_ptr< ::std::map< ::std::wstring , bool > > > syncResult;	
	getBoolean1([&syncResult](byps_ptr< ::std::map< ::std::wstring , bool > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getBoolean1(::std::function< void (byps_ptr< ::std::map< ::std::wstring , bool > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getBoolean1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< ::std::wstring , bool > >, byps::test::api::BResult_1279823631 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setBoolean1(const byps_ptr< ::std::map< ::std::wstring , bool > >& boolean1)  {
	BSyncResultT< bool > syncResult;	
	setBoolean1(boolean1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setBoolean1(const byps_ptr< ::std::map< ::std::wstring , bool > >& boolean1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setBoolean1(boolean1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< double , int8_t > > BStub_RemoteMapTypes::getByte1()  {
	BSyncResultT< byps_ptr< ::std::map< double , int8_t > > > syncResult;	
	getByte1([&syncResult](byps_ptr< ::std::map< double , int8_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getByte1(::std::function< void (byps_ptr< ::std::map< double , int8_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getByte1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< double , int8_t > >, byps::test::api::BResult_1972793385 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setByte1(const byps_ptr< ::std::map< double , int8_t > >& byte1)  {
	BSyncResultT< bool > syncResult;	
	setByte1(byte1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setByte1(const byps_ptr< ::std::map< double , int8_t > >& byte1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setByte1(byte1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< float , wchar_t > > BStub_RemoteMapTypes::getChar1()  {
	BSyncResultT< byps_ptr< ::std::map< float , wchar_t > > > syncResult;	
	getChar1([&syncResult](byps_ptr< ::std::map< float , wchar_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getChar1(::std::function< void (byps_ptr< ::std::map< float , wchar_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getChar1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< float , wchar_t > >, byps::test::api::BResult_8789515 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setChar1(const byps_ptr< ::std::map< float , wchar_t > >& char1)  {
	BSyncResultT< bool > syncResult;	
	setChar1(char1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setChar1(const byps_ptr< ::std::map< float , wchar_t > >& char1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setChar1(char1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< int64_t , int16_t > > BStub_RemoteMapTypes::getShort1()  {
	BSyncResultT< byps_ptr< ::std::map< int64_t , int16_t > > > syncResult;	
	getShort1([&syncResult](byps_ptr< ::std::map< int64_t , int16_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getShort1(::std::function< void (byps_ptr< ::std::map< int64_t , int16_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getShort1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int64_t , int16_t > >, byps::test::api::BResult_601099730 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setShort1(const byps_ptr< ::std::map< int64_t , int16_t > >& short1)  {
	BSyncResultT< bool > syncResult;	
	setShort1(short1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setShort1(const byps_ptr< ::std::map< int64_t , int16_t > >& short1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setShort1(short1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< int32_t , int32_t > > BStub_RemoteMapTypes::getInt1()  {
	BSyncResultT< byps_ptr< ::std::map< int32_t , int32_t > > > syncResult;	
	getInt1([&syncResult](byps_ptr< ::std::map< int32_t , int32_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getInt1(::std::function< void (byps_ptr< ::std::map< int32_t , int32_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getInt1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int32_t , int32_t > >, byps::test::api::BResult_1347703734 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setInt1(const byps_ptr< ::std::map< int32_t , int32_t > >& int1)  {
	BSyncResultT< bool > syncResult;	
	setInt1(int1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setInt1(const byps_ptr< ::std::map< int32_t , int32_t > >& int1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setInt1(int1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< int16_t , int64_t > > BStub_RemoteMapTypes::getLong1()  {
	BSyncResultT< byps_ptr< ::std::map< int16_t , int64_t > > > syncResult;	
	getLong1([&syncResult](byps_ptr< ::std::map< int16_t , int64_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getLong1(::std::function< void (byps_ptr< ::std::map< int16_t , int64_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getLong1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int16_t , int64_t > >, byps::test::api::BResult_1973996106 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setLong1(const byps_ptr< ::std::map< int16_t , int64_t > >& long1)  {
	BSyncResultT< bool > syncResult;	
	setLong1(long1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setLong1(const byps_ptr< ::std::map< int16_t , int64_t > >& long1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setLong1(long1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< wchar_t , float > > BStub_RemoteMapTypes::getFloat1()  {
	BSyncResultT< byps_ptr< ::std::map< wchar_t , float > > > syncResult;	
	getFloat1([&syncResult](byps_ptr< ::std::map< wchar_t , float > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getFloat1(::std::function< void (byps_ptr< ::std::map< wchar_t , float > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getFloat1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< wchar_t , float > >, byps::test::api::BResult_94341197 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setFloat1(const byps_ptr< ::std::map< wchar_t , float > >& float1)  {
	BSyncResultT< bool > syncResult;	
	setFloat1(float1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setFloat1(const byps_ptr< ::std::map< wchar_t , float > >& float1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setFloat1(float1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< int8_t , double > > BStub_RemoteMapTypes::getDouble1()  {
	BSyncResultT< byps_ptr< ::std::map< int8_t , double > > > syncResult;	
	getDouble1([&syncResult](byps_ptr< ::std::map< int8_t , double > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getDouble1(::std::function< void (byps_ptr< ::std::map< int8_t , double > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getDouble1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int8_t , double > >, byps::test::api::BResult_1487265161 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setDouble1(const byps_ptr< ::std::map< int8_t , double > >& double1)  {
	BSyncResultT< bool > syncResult;	
	setDouble1(double1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setDouble1(const byps_ptr< ::std::map< int8_t , double > >& double1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setDouble1(double1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< ::std::wstring , ::std::wstring > > BStub_RemoteMapTypes::getString1()  {
	BSyncResultT< byps_ptr< ::std::map< ::std::wstring , ::std::wstring > > > syncResult;	
	getString1([&syncResult](byps_ptr< ::std::map< ::std::wstring , ::std::wstring > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getString1(::std::function< void (byps_ptr< ::std::map< ::std::wstring , ::std::wstring > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getString1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< ::std::wstring , ::std::wstring > >, byps::test::api::BResult_1710660846 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setString1(const byps_ptr< ::std::map< ::std::wstring , ::std::wstring > >& string1)  {
	BSyncResultT< bool > syncResult;	
	setString1(string1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setString1(const byps_ptr< ::std::map< ::std::wstring , ::std::wstring > >& string1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setString1(string1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< int32_t , byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteMapTypes::getPrimitiveTypes1()  {
	BSyncResultT< byps_ptr< ::std::map< int32_t , byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	getPrimitiveTypes1([&syncResult](byps_ptr< ::std::map< int32_t , byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getPrimitiveTypes1(::std::function< void (byps_ptr< ::std::map< int32_t , byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getPrimitiveTypes1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int32_t , byps::test::api::prim::PPrimitiveTypes > >, byps::test::api::BResult_1831201218 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setPrimitiveTypes1(const byps_ptr< ::std::map< int32_t , byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes1(primitiveTypes1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setPrimitiveTypes1(const byps_ptr< ::std::map< int32_t , byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setPrimitiveTypes1(primitiveTypes1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< int32_t , PBytes > > BStub_RemoteMapTypes::getByte2()  {
	BSyncResultT< byps_ptr< ::std::map< int32_t , PBytes > > > syncResult;	
	getByte2([&syncResult](byps_ptr< ::std::map< int32_t , PBytes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getByte2(::std::function< void (byps_ptr< ::std::map< int32_t , PBytes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getByte2());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int32_t , PBytes > >, byps::test::api::BResult_1799280818 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setByte2(const byps_ptr< ::std::map< int32_t , PBytes > >& byte2)  {
	BSyncResultT< bool > syncResult;	
	setByte2(byte2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setByte2(const byps_ptr< ::std::map< int32_t , PBytes > >& byte2, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setByte2(byte2));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > > BStub_RemoteMapTypes::getInt2()  {
	BSyncResultT< byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > > > syncResult;	
	getInt2([&syncResult](byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getInt2(::std::function< void (byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getInt2());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > >, byps::test::api::BResult_1633750383 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setInt2(const byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > >& int2)  {
	BSyncResultT< bool > syncResult;	
	setInt2(int2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setInt2(const byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > >& int2, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setInt2(int2));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< ::std::wstring , PSerializable > > BStub_RemoteMapTypes::getObj1()  {
	BSyncResultT< byps_ptr< ::std::map< ::std::wstring , PSerializable > > > syncResult;	
	getObj1([&syncResult](byps_ptr< ::std::map< ::std::wstring , PSerializable > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getObj1(::std::function< void (byps_ptr< ::std::map< ::std::wstring , PSerializable > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getObj1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< ::std::wstring , PSerializable > >, byps::test::api::BResult_1488550492 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setObj1(const byps_ptr< ::std::map< ::std::wstring , PSerializable > >& obj1)  {
	BSyncResultT< bool > syncResult;	
	setObj1(obj1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setObj1(const byps_ptr< ::std::map< ::std::wstring , PSerializable > >& obj1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setObj1(obj1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
namespace byps { namespace test { namespace api { 
void BSerializer_664304990(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::remote::BStub_RemoteMapTypes(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}

namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemotePrimitiveTypes::BStub_RemotePrimitiveTypes(PTransport transport) 
	: BStub(transport) {}

void BStub_RemotePrimitiveTypes::voidFunctionVoid()  {
	BSyncResultT< bool > syncResult;	
	voidFunctionVoid([&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::voidFunctionVoid(::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_voidFunctionVoid());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setBool(bool v)  {
	BSyncResultT< bool > syncResult;	
	setBool(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setBool(bool v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setBool(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setByte(int8_t v)  {
	BSyncResultT< bool > syncResult;	
	setByte(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setByte(int8_t v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setByte(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setChar(wchar_t v)  {
	BSyncResultT< bool > syncResult;	
	setChar(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setChar(wchar_t v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setChar(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setShort(int16_t v)  {
	BSyncResultT< bool > syncResult;	
	setShort(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setShort(int16_t v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setShort(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setInt(int32_t v)  {
	BSyncResultT< bool > syncResult;	
	setInt(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setInt(int32_t v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setInt(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setLong(int64_t v)  {
	BSyncResultT< bool > syncResult;	
	setLong(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setLong(int64_t v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setLong(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setFloat(float v)  {
	BSyncResultT< bool > syncResult;	
	setFloat(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setFloat(float v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setFloat(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setDouble(double v)  {
	BSyncResultT< bool > syncResult;	
	setDouble(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setDouble(double v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setDouble(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setString(const ::std::wstring& v)  {
	BSyncResultT< bool > syncResult;	
	setString(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setString(const ::std::wstring& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setString(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setPrimitiveTypes(const byps::test::api::prim::PPrimitiveTypes& v)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setPrimitiveTypes(const byps::test::api::prim::PPrimitiveTypes& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setPrimitiveTypes(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setObject(const PSerializable& v)  {
	BSyncResultT< bool > syncResult;	
	setObject(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setObject(const PSerializable& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setObject(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
bool BStub_RemotePrimitiveTypes::getBool()  {
	BSyncResultT< bool > syncResult;	
	getBool([&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getBool(::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getBool());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_1 >(asyncResult) );
	transport->send(req, outerResult);
}
int8_t BStub_RemotePrimitiveTypes::getByte()  {
	BSyncResultT< int8_t > syncResult;	
	getByte([&syncResult](int8_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getByte(::std::function< void (int8_t, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getByte());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int8_t, byps::test::api::BResult_2 >(asyncResult) );
	transport->send(req, outerResult);
}
wchar_t BStub_RemotePrimitiveTypes::getChar()  {
	BSyncResultT< wchar_t > syncResult;	
	getChar([&syncResult](wchar_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getChar(::std::function< void (wchar_t, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getChar());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< wchar_t, byps::test::api::BResult_4 >(asyncResult) );
	transport->send(req, outerResult);
}
int16_t BStub_RemotePrimitiveTypes::getShort()  {
	BSyncResultT< int16_t > syncResult;	
	getShort([&syncResult](int16_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getShort(::std::function< void (int16_t, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getShort());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int16_t, byps::test::api::BResult_3 >(asyncResult) );
	transport->send(req, outerResult);
}
int32_t BStub_RemotePrimitiveTypes::getInt()  {
	BSyncResultT< int32_t > syncResult;	
	getInt([&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getInt(::std::function< void (int32_t, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getInt());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, byps::test::api::BResult_5 >(asyncResult) );
	transport->send(req, outerResult);
}
int64_t BStub_RemotePrimitiveTypes::getLong()  {
	BSyncResultT< int64_t > syncResult;	
	getLong([&syncResult](int64_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getLong(::std::function< void (int64_t, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getLong());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int64_t, byps::test::api::BResult_6 >(asyncResult) );
	transport->send(req, outerResult);
}
float BStub_RemotePrimitiveTypes::getFloat()  {
	BSyncResultT< float > syncResult;	
	getFloat([&syncResult](float v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getFloat(::std::function< void (float, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getFloat());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< float, byps::test::api::BResult_7 >(asyncResult) );
	transport->send(req, outerResult);
}
double BStub_RemotePrimitiveTypes::getDouble()  {
	BSyncResultT< double > syncResult;	
	getDouble([&syncResult](double v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getDouble(::std::function< void (double, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getDouble());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< double, byps::test::api::BResult_8 >(asyncResult) );
	transport->send(req, outerResult);
}
::std::wstring BStub_RemotePrimitiveTypes::getString()  {
	BSyncResultT< ::std::wstring > syncResult;	
	getString([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getString(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getString());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
byps::test::api::prim::PPrimitiveTypes BStub_RemotePrimitiveTypes::getPrimitiveTypes()  {
	BSyncResultT< byps::test::api::prim::PPrimitiveTypes > syncResult;	
	getPrimitiveTypes([&syncResult](byps::test::api::prim::PPrimitiveTypes v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getPrimitiveTypes(::std::function< void (byps::test::api::prim::PPrimitiveTypes, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getPrimitiveTypes());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::test::api::prim::PPrimitiveTypes, byps::test::api::BResult_1000 >(asyncResult) );
	transport->send(req, outerResult);
}
PSerializable BStub_RemotePrimitiveTypes::getObject()  {
	BSyncResultT< PSerializable > syncResult;	
	getObject([&syncResult](PSerializable v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getObject(::std::function< void (PSerializable, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getObject());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PSerializable, byps::test::api::BResult_21 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::sendAllTypes(bool b, wchar_t c, int16_t s, int32_t i, int64_t l, float f, double d, const ::std::wstring& str, const byps::test::api::prim::PPrimitiveTypes& pt, const PSerializable& o)  {
	BSyncResultT< bool > syncResult;	
	sendAllTypes(b, c, s, i, l, f, d, str, pt, o, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::sendAllTypes(bool b, wchar_t c, int16_t s, int32_t i, int64_t l, float f, double d, const ::std::wstring& str, const byps::test::api::prim::PPrimitiveTypes& pt, const PSerializable& o, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_sendAllTypes(b, c, s, i, l, f, d, str, pt, o));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
int32_t BStub_RemotePrimitiveTypes::add(int32_t a, int32_t b)  {
	BSyncResultT< int32_t > syncResult;	
	add(a, b, [&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::add(int32_t a, int32_t b, ::std::function< void (int32_t, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_add(a, b));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, byps::test::api::BResult_5 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::throwException()  {
	BSyncResultT< bool > syncResult;	
	throwException([&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::throwException(::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_throwException());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
namespace byps { namespace test { namespace api { 
void BSerializer_1178916877(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::remote::BStub_RemotePrimitiveTypes(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}

namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteReferences::BStub_RemoteReferences(PTransport transport) 
	: BStub(transport) {}

byps::test::api::refs::PNode BStub_RemoteReferences::getNode()  {
	BSyncResultT< byps::test::api::refs::PNode > syncResult;	
	getNode([&syncResult](byps::test::api::refs::PNode v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteReferences::getNode(::std::function< void (byps::test::api::refs::PNode, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteReferences_getNode());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::test::api::refs::PNode, byps::test::api::BResult_9001 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteReferences::setNode(const byps::test::api::refs::PNode& v)  {
	BSyncResultT< bool > syncResult;	
	setNode(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteReferences::setNode(const byps::test::api::refs::PNode& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteReferences_setNode(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
namespace byps { namespace test { namespace api { 
void BSerializer_568637225(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::remote::BStub_RemoteReferences(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}

namespace byps { namespace test { namespace api { namespace remote { 

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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PRemote, byps::test::api::BResult_16 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
namespace byps { namespace test { namespace api { 
void BSerializer_1652234479(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::remote::BStub_RemoteServerCtrl(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}

namespace byps { namespace test { namespace api { namespace remote { 

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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< bool > >, byps::test::api::BResult_1365696060 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< int8_t > >, byps::test::api::BResult_31512998 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< wchar_t > >, byps::test::api::BResult_936607009 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< int16_t > >, byps::test::api::BResult_2028443792 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< int32_t > >, byps::test::api::BResult_1493282670 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< int64_t > >, byps::test::api::BResult_1457164460 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< float > >, byps::test::api::BResult_1898022288 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< double > >, byps::test::api::BResult_1320560671 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< ::std::wstring > >, byps::test::api::BResult_1888799711 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteSetTypes::getPrimitiveTypes1()  {
	BSyncResultT< byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	getPrimitiveTypes1([&syncResult](byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getPrimitiveTypes1(::std::function< void (byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_getPrimitiveTypes1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > >, byps::test::api::BResult_673917574 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteSetTypes::setPrimitiveTypes1(const byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes1(primitiveTypes1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setPrimitiveTypes1(const byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteSetTypes_setPrimitiveTypes1(primitiveTypes1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< PBytes > >, byps::test::api::BResult_2052431866 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< byps_ptr< BArray1< int32_t > > > >, byps::test::api::BResult_1406124761 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< PSerializable > >, byps::test::api::BResult_14 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
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
