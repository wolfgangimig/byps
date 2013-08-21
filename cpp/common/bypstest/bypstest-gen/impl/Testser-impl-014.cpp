#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;


namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteListTypes::BStub_RemoteListTypes(PTransport transport) 
	: BStub(transport) {}

byps_ptr< ::std::vector< bool > > BStub_RemoteListTypes::getBoolean1()  {
	BSyncResultT< byps_ptr< ::std::vector< bool > > > syncResult;	
	async_getBoolean1([&syncResult](byps_ptr< ::std::vector< bool > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::async_getBoolean1(std::function< void (byps_ptr< ::std::vector< bool > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getBoolean1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< bool > >, BResult_1617670280 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setBoolean1(byps_ptr< ::std::vector< bool > > boolean1)  {
	BSyncResultT< bool > syncResult;	
	async_setBoolean1(boolean1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::async_setBoolean1(byps_ptr< ::std::vector< bool > > boolean1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setBoolean1(boolean1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< int8_t > > BStub_RemoteListTypes::getByte1()  {
	BSyncResultT< byps_ptr< ::std::vector< int8_t > > > syncResult;	
	async_getByte1([&syncResult](byps_ptr< ::std::vector< int8_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::async_getByte1(std::function< void (byps_ptr< ::std::vector< int8_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getByte1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< int8_t > >, BResult_1059148284 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setByte1(byps_ptr< ::std::vector< int8_t > > byte1)  {
	BSyncResultT< bool > syncResult;	
	async_setByte1(byte1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::async_setByte1(byps_ptr< ::std::vector< int8_t > > byte1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setByte1(byte1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< wchar_t > > BStub_RemoteListTypes::getChar1()  {
	BSyncResultT< byps_ptr< ::std::vector< wchar_t > > > syncResult;	
	async_getChar1([&syncResult](byps_ptr< ::std::vector< wchar_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::async_getChar1(std::function< void (byps_ptr< ::std::vector< wchar_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getChar1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< wchar_t > >, BResult_1661807911 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setChar1(byps_ptr< ::std::vector< wchar_t > > char1)  {
	BSyncResultT< bool > syncResult;	
	async_setChar1(char1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::async_setChar1(byps_ptr< ::std::vector< wchar_t > > char1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setChar1(char1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< int16_t > > BStub_RemoteListTypes::getShort1()  {
	BSyncResultT< byps_ptr< ::std::vector< int16_t > > > syncResult;	
	async_getShort1([&syncResult](byps_ptr< ::std::vector< int16_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::async_getShort1(std::function< void (byps_ptr< ::std::vector< int16_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getShort1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< int16_t > >, BResult_1997002548 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setShort1(byps_ptr< ::std::vector< int16_t > > short1)  {
	BSyncResultT< bool > syncResult;	
	async_setShort1(short1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::async_setShort1(byps_ptr< ::std::vector< int16_t > > short1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setShort1(short1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< int32_t > > BStub_RemoteListTypes::getInt1()  {
	BSyncResultT< byps_ptr< ::std::vector< int32_t > > > syncResult;	
	async_getInt1([&syncResult](byps_ptr< ::std::vector< int32_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::async_getInt1(std::function< void (byps_ptr< ::std::vector< int32_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getInt1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< int32_t > >, BResult_181681714 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setInt1(byps_ptr< ::std::vector< int32_t > > int1)  {
	BSyncResultT< bool > syncResult;	
	async_setInt1(int1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::async_setInt1(byps_ptr< ::std::vector< int32_t > > int1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setInt1(int1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< int64_t > > BStub_RemoteListTypes::getLong1()  {
	BSyncResultT< byps_ptr< ::std::vector< int64_t > > > syncResult;	
	async_getLong1([&syncResult](byps_ptr< ::std::vector< int64_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::async_getLong1(std::function< void (byps_ptr< ::std::vector< int64_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getLong1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< int64_t > >, BResult_1050216688 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setLong1(byps_ptr< ::std::vector< int64_t > > long1)  {
	BSyncResultT< bool > syncResult;	
	async_setLong1(long1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::async_setLong1(byps_ptr< ::std::vector< int64_t > > long1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setLong1(long1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< float > > BStub_RemoteListTypes::getFloat1()  {
	BSyncResultT< byps_ptr< ::std::vector< float > > > syncResult;	
	async_getFloat1([&syncResult](byps_ptr< ::std::vector< float > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::async_getFloat1(std::function< void (byps_ptr< ::std::vector< float > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getFloat1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< float > >, BResult_1628501332 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setFloat1(byps_ptr< ::std::vector< float > > float1)  {
	BSyncResultT< bool > syncResult;	
	async_setFloat1(float1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::async_setFloat1(byps_ptr< ::std::vector< float > > float1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setFloat1(float1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< double > > BStub_RemoteListTypes::getDouble1()  {
	BSyncResultT< byps_ptr< ::std::vector< double > > > syncResult;	
	async_getDouble1([&syncResult](byps_ptr< ::std::vector< double > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::async_getDouble1(std::function< void (byps_ptr< ::std::vector< double > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getDouble1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< double > >, BResult_1555345627 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setDouble1(byps_ptr< ::std::vector< double > > double1)  {
	BSyncResultT< bool > syncResult;	
	async_setDouble1(double1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::async_setDouble1(byps_ptr< ::std::vector< double > > double1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setDouble1(double1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< ::std::wstring > > BStub_RemoteListTypes::getString1()  {
	BSyncResultT< byps_ptr< ::std::vector< ::std::wstring > > > syncResult;	
	async_getString1([&syncResult](byps_ptr< ::std::vector< ::std::wstring > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::async_getString1(std::function< void (byps_ptr< ::std::vector< ::std::wstring > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getString1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< ::std::wstring > >, BResult_2123584667 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setString1(byps_ptr< ::std::vector< ::std::wstring > > string1)  {
	BSyncResultT< bool > syncResult;	
	async_setString1(string1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::async_setString1(byps_ptr< ::std::vector< ::std::wstring > > string1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setString1(string1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteListTypes::getPrimitiveTypes1()  {
	BSyncResultT< byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	async_getPrimitiveTypes1([&syncResult](byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::async_getPrimitiveTypes1(std::function< void (byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getPrimitiveTypes1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BResult_1544333227 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setPrimitiveTypes1(byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > primitiveTypes1)  {
	BSyncResultT< bool > syncResult;	
	async_setPrimitiveTypes1(primitiveTypes1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::async_setPrimitiveTypes1(byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > primitiveTypes1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setPrimitiveTypes1(primitiveTypes1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< PBytes > > BStub_RemoteListTypes::getByte2()  {
	BSyncResultT< byps_ptr< ::std::vector< PBytes > > > syncResult;	
	async_getByte2([&syncResult](byps_ptr< ::std::vector< PBytes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::async_getByte2(std::function< void (byps_ptr< ::std::vector< PBytes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getByte2());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< PBytes > >, BResult_1174971318 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setByte2(byps_ptr< ::std::vector< PBytes > > byte2)  {
	BSyncResultT< bool > syncResult;	
	async_setByte2(byte2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::async_setByte2(byps_ptr< ::std::vector< PBytes > > byte2, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setByte2(byte2));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > > BStub_RemoteListTypes::getInt2()  {
	BSyncResultT< byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > > > syncResult;	
	async_getInt2([&syncResult](byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::async_getInt2(std::function< void (byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getInt2());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > >, BResult_1752158699 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setInt2(byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > > int2)  {
	BSyncResultT< bool > syncResult;	
	async_setInt2(int2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::async_setInt2(byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > > int2, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setInt2(int2));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< PSerializable > > BStub_RemoteListTypes::getObj1()  {
	BSyncResultT< byps_ptr< ::std::vector< PSerializable > > > syncResult;	
	async_getObj1([&syncResult](byps_ptr< ::std::vector< PSerializable > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::async_getObj1(std::function< void (byps_ptr< ::std::vector< PSerializable > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getObj1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< PSerializable > >, BResult_12 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setObj1(byps_ptr< ::std::vector< PSerializable > > obj1)  {
	BSyncResultT< bool > syncResult;	
	async_setObj1(obj1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::async_setObj1(byps_ptr< ::std::vector< PSerializable > > obj1, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setObj1(obj1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > > BStub_RemoteListTypes::getInt3()  {
	BSyncResultT< byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > > > syncResult;	
	async_getInt3([&syncResult](byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::async_getInt3(std::function< void (byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getInt3());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > >, BResult_1746702954 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setInt3(byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > > int3)  {
	BSyncResultT< bool > syncResult;	
	async_setInt3(int3, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::async_setInt3(byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > > int3, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setInt3(int3));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > > BStub_RemoteListTypes::getInt4()  {
	BSyncResultT< byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > > > syncResult;	
	async_getInt4([&syncResult](byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::async_getInt4(std::function< void (byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getInt4());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > >, BResult_1633500852 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setInt4(byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > > int4)  {
	BSyncResultT< bool > syncResult;	
	async_setInt4(int4, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::async_setInt4(byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > > int4, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setInt4(int4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_380156079(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BStub_RemoteListTypes(transport));
	}
	else {
		com::wilutions::byps::test::api::remote::RemoteListTypes* r = dynamic_cast<com::wilutions::byps::test::api::remote::RemoteListTypes*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

byps_ptr< ::std::map< ::std::wstring , bool > > BSkeleton_RemoteMapTypes::getBoolean1()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_getBoolean1(std::function< void (byps_ptr< ::std::map< ::std::wstring , bool > >, BException ex) > asyncResult)  {
	byps_ptr< ::std::map< ::std::wstring , bool > > ret = byps_ptr< ::std::map< ::std::wstring , bool > >();
	try {
		ret = getBoolean1();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteMapTypes::setBoolean1(byps_ptr< ::std::map< ::std::wstring , bool > > boolean1)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_setBoolean1(byps_ptr< ::std::map< ::std::wstring , bool > > boolean1, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setBoolean1(boolean1);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< ::std::map< double , int8_t > > BSkeleton_RemoteMapTypes::getByte1()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_getByte1(std::function< void (byps_ptr< ::std::map< double , int8_t > >, BException ex) > asyncResult)  {
	byps_ptr< ::std::map< double , int8_t > > ret = byps_ptr< ::std::map< double , int8_t > >();
	try {
		ret = getByte1();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteMapTypes::setByte1(byps_ptr< ::std::map< double , int8_t > > byte1)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_setByte1(byps_ptr< ::std::map< double , int8_t > > byte1, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setByte1(byte1);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< ::std::map< float , wchar_t > > BSkeleton_RemoteMapTypes::getChar1()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_getChar1(std::function< void (byps_ptr< ::std::map< float , wchar_t > >, BException ex) > asyncResult)  {
	byps_ptr< ::std::map< float , wchar_t > > ret = byps_ptr< ::std::map< float , wchar_t > >();
	try {
		ret = getChar1();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteMapTypes::setChar1(byps_ptr< ::std::map< float , wchar_t > > char1)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_setChar1(byps_ptr< ::std::map< float , wchar_t > > char1, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setChar1(char1);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< ::std::map< int64_t , int16_t > > BSkeleton_RemoteMapTypes::getShort1()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_getShort1(std::function< void (byps_ptr< ::std::map< int64_t , int16_t > >, BException ex) > asyncResult)  {
	byps_ptr< ::std::map< int64_t , int16_t > > ret = byps_ptr< ::std::map< int64_t , int16_t > >();
	try {
		ret = getShort1();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteMapTypes::setShort1(byps_ptr< ::std::map< int64_t , int16_t > > short1)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_setShort1(byps_ptr< ::std::map< int64_t , int16_t > > short1, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setShort1(short1);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< ::std::map< int32_t , int32_t > > BSkeleton_RemoteMapTypes::getInt1()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_getInt1(std::function< void (byps_ptr< ::std::map< int32_t , int32_t > >, BException ex) > asyncResult)  {
	byps_ptr< ::std::map< int32_t , int32_t > > ret = byps_ptr< ::std::map< int32_t , int32_t > >();
	try {
		ret = getInt1();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteMapTypes::setInt1(byps_ptr< ::std::map< int32_t , int32_t > > int1)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_setInt1(byps_ptr< ::std::map< int32_t , int32_t > > int1, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setInt1(int1);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< ::std::map< int16_t , int64_t > > BSkeleton_RemoteMapTypes::getLong1()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_getLong1(std::function< void (byps_ptr< ::std::map< int16_t , int64_t > >, BException ex) > asyncResult)  {
	byps_ptr< ::std::map< int16_t , int64_t > > ret = byps_ptr< ::std::map< int16_t , int64_t > >();
	try {
		ret = getLong1();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteMapTypes::setLong1(byps_ptr< ::std::map< int16_t , int64_t > > long1)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_setLong1(byps_ptr< ::std::map< int16_t , int64_t > > long1, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setLong1(long1);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< ::std::map< wchar_t , float > > BSkeleton_RemoteMapTypes::getFloat1()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_getFloat1(std::function< void (byps_ptr< ::std::map< wchar_t , float > >, BException ex) > asyncResult)  {
	byps_ptr< ::std::map< wchar_t , float > > ret = byps_ptr< ::std::map< wchar_t , float > >();
	try {
		ret = getFloat1();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteMapTypes::setFloat1(byps_ptr< ::std::map< wchar_t , float > > float1)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_setFloat1(byps_ptr< ::std::map< wchar_t , float > > float1, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setFloat1(float1);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< ::std::map< int8_t , double > > BSkeleton_RemoteMapTypes::getDouble1()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_getDouble1(std::function< void (byps_ptr< ::std::map< int8_t , double > >, BException ex) > asyncResult)  {
	byps_ptr< ::std::map< int8_t , double > > ret = byps_ptr< ::std::map< int8_t , double > >();
	try {
		ret = getDouble1();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteMapTypes::setDouble1(byps_ptr< ::std::map< int8_t , double > > double1)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_setDouble1(byps_ptr< ::std::map< int8_t , double > > double1, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setDouble1(double1);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< ::std::map< ::std::wstring , ::std::wstring > > BSkeleton_RemoteMapTypes::getString1()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_getString1(std::function< void (byps_ptr< ::std::map< ::std::wstring , ::std::wstring > >, BException ex) > asyncResult)  {
	byps_ptr< ::std::map< ::std::wstring , ::std::wstring > > ret = byps_ptr< ::std::map< ::std::wstring , ::std::wstring > >();
	try {
		ret = getString1();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteMapTypes::setString1(byps_ptr< ::std::map< ::std::wstring , ::std::wstring > > string1)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_setString1(byps_ptr< ::std::map< ::std::wstring , ::std::wstring > > string1, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setString1(string1);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > > BSkeleton_RemoteMapTypes::getPrimitiveTypes1()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_getPrimitiveTypes1(std::function< void (byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > > ret = byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > >();
	try {
		ret = getPrimitiveTypes1();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteMapTypes::setPrimitiveTypes1(byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > > primitiveTypes1)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_setPrimitiveTypes1(byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > > primitiveTypes1, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setPrimitiveTypes1(primitiveTypes1);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< ::std::map< int32_t , PBytes > > BSkeleton_RemoteMapTypes::getByte2()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_getByte2(std::function< void (byps_ptr< ::std::map< int32_t , PBytes > >, BException ex) > asyncResult)  {
	byps_ptr< ::std::map< int32_t , PBytes > > ret = byps_ptr< ::std::map< int32_t , PBytes > >();
	try {
		ret = getByte2();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteMapTypes::setByte2(byps_ptr< ::std::map< int32_t , PBytes > > byte2)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_setByte2(byps_ptr< ::std::map< int32_t , PBytes > > byte2, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setByte2(byte2);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > > BSkeleton_RemoteMapTypes::getInt2()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_getInt2(std::function< void (byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > >, BException ex) > asyncResult)  {
	byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > > ret = byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > >();
	try {
		ret = getInt2();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteMapTypes::setInt2(byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > > int2)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_setInt2(byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > > int2, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setInt2(int2);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< ::std::map< ::std::wstring , PSerializable > > BSkeleton_RemoteMapTypes::getObj1()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_getObj1(std::function< void (byps_ptr< ::std::map< ::std::wstring , PSerializable > >, BException ex) > asyncResult)  {
	byps_ptr< ::std::map< ::std::wstring , PSerializable > > ret = byps_ptr< ::std::map< ::std::wstring , PSerializable > >();
	try {
		ret = getObj1();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteMapTypes::setObj1(byps_ptr< ::std::map< ::std::wstring , PSerializable > > obj1)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteMapTypes::async_setObj1(byps_ptr< ::std::map< ::std::wstring , PSerializable > > obj1, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setObj1(obj1);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
}}}}}}


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
