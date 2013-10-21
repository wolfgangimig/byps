#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;


namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteListTypes::BStub_RemoteListTypes(PTransport transport) 
	: BStub(transport) {}

byps_ptr< ::std::vector< bool > > BStub_RemoteListTypes::getBoolean1()  {
	BSyncResultT< byps_ptr< ::std::vector< bool > > > syncResult;	
	getBoolean1([&syncResult](byps_ptr< ::std::vector< bool > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getBoolean1(::std::function< void (byps_ptr< ::std::vector< bool > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getBoolean1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< bool > >, com::wilutions::byps::test::api::BResult_1617670280 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setBoolean1(const byps_ptr< ::std::vector< bool > >& boolean1)  {
	BSyncResultT< bool > syncResult;	
	setBoolean1(boolean1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setBoolean1(const byps_ptr< ::std::vector< bool > >& boolean1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setBoolean1(boolean1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< int8_t > > BStub_RemoteListTypes::getByte1()  {
	BSyncResultT< byps_ptr< ::std::vector< int8_t > > > syncResult;	
	getByte1([&syncResult](byps_ptr< ::std::vector< int8_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getByte1(::std::function< void (byps_ptr< ::std::vector< int8_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getByte1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< int8_t > >, com::wilutions::byps::test::api::BResult_1059148284 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setByte1(const byps_ptr< ::std::vector< int8_t > >& byte1)  {
	BSyncResultT< bool > syncResult;	
	setByte1(byte1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setByte1(const byps_ptr< ::std::vector< int8_t > >& byte1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setByte1(byte1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< wchar_t > > BStub_RemoteListTypes::getChar1()  {
	BSyncResultT< byps_ptr< ::std::vector< wchar_t > > > syncResult;	
	getChar1([&syncResult](byps_ptr< ::std::vector< wchar_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getChar1(::std::function< void (byps_ptr< ::std::vector< wchar_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getChar1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< wchar_t > >, com::wilutions::byps::test::api::BResult_1661807911 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setChar1(const byps_ptr< ::std::vector< wchar_t > >& char1)  {
	BSyncResultT< bool > syncResult;	
	setChar1(char1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setChar1(const byps_ptr< ::std::vector< wchar_t > >& char1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setChar1(char1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< int16_t > > BStub_RemoteListTypes::getShort1()  {
	BSyncResultT< byps_ptr< ::std::vector< int16_t > > > syncResult;	
	getShort1([&syncResult](byps_ptr< ::std::vector< int16_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getShort1(::std::function< void (byps_ptr< ::std::vector< int16_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getShort1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< int16_t > >, com::wilutions::byps::test::api::BResult_1997002548 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setShort1(const byps_ptr< ::std::vector< int16_t > >& short1)  {
	BSyncResultT< bool > syncResult;	
	setShort1(short1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setShort1(const byps_ptr< ::std::vector< int16_t > >& short1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setShort1(short1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< int32_t > > BStub_RemoteListTypes::getInt1()  {
	BSyncResultT< byps_ptr< ::std::vector< int32_t > > > syncResult;	
	getInt1([&syncResult](byps_ptr< ::std::vector< int32_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getInt1(::std::function< void (byps_ptr< ::std::vector< int32_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getInt1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< int32_t > >, com::wilutions::byps::test::api::BResult_181681714 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setInt1(const byps_ptr< ::std::vector< int32_t > >& int1)  {
	BSyncResultT< bool > syncResult;	
	setInt1(int1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setInt1(const byps_ptr< ::std::vector< int32_t > >& int1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setInt1(int1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< int64_t > > BStub_RemoteListTypes::getLong1()  {
	BSyncResultT< byps_ptr< ::std::vector< int64_t > > > syncResult;	
	getLong1([&syncResult](byps_ptr< ::std::vector< int64_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getLong1(::std::function< void (byps_ptr< ::std::vector< int64_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getLong1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< int64_t > >, com::wilutions::byps::test::api::BResult_1050216688 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setLong1(const byps_ptr< ::std::vector< int64_t > >& long1)  {
	BSyncResultT< bool > syncResult;	
	setLong1(long1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setLong1(const byps_ptr< ::std::vector< int64_t > >& long1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setLong1(long1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< float > > BStub_RemoteListTypes::getFloat1()  {
	BSyncResultT< byps_ptr< ::std::vector< float > > > syncResult;	
	getFloat1([&syncResult](byps_ptr< ::std::vector< float > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getFloat1(::std::function< void (byps_ptr< ::std::vector< float > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getFloat1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< float > >, com::wilutions::byps::test::api::BResult_1628501332 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setFloat1(const byps_ptr< ::std::vector< float > >& float1)  {
	BSyncResultT< bool > syncResult;	
	setFloat1(float1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setFloat1(const byps_ptr< ::std::vector< float > >& float1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setFloat1(float1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< double > > BStub_RemoteListTypes::getDouble1()  {
	BSyncResultT< byps_ptr< ::std::vector< double > > > syncResult;	
	getDouble1([&syncResult](byps_ptr< ::std::vector< double > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getDouble1(::std::function< void (byps_ptr< ::std::vector< double > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getDouble1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< double > >, com::wilutions::byps::test::api::BResult_1555345627 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setDouble1(const byps_ptr< ::std::vector< double > >& double1)  {
	BSyncResultT< bool > syncResult;	
	setDouble1(double1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setDouble1(const byps_ptr< ::std::vector< double > >& double1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setDouble1(double1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< ::std::wstring > > BStub_RemoteListTypes::getString1()  {
	BSyncResultT< byps_ptr< ::std::vector< ::std::wstring > > > syncResult;	
	getString1([&syncResult](byps_ptr< ::std::vector< ::std::wstring > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getString1(::std::function< void (byps_ptr< ::std::vector< ::std::wstring > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getString1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< ::std::wstring > >, com::wilutions::byps::test::api::BResult_2123584667 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setString1(const byps_ptr< ::std::vector< ::std::wstring > >& string1)  {
	BSyncResultT< bool > syncResult;	
	setString1(string1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setString1(const byps_ptr< ::std::vector< ::std::wstring > >& string1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setString1(string1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteListTypes::getPrimitiveTypes1()  {
	BSyncResultT< byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	getPrimitiveTypes1([&syncResult](byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getPrimitiveTypes1(::std::function< void (byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getPrimitiveTypes1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, com::wilutions::byps::test::api::BResult_1544333227 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setPrimitiveTypes1(const byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes1(primitiveTypes1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setPrimitiveTypes1(const byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setPrimitiveTypes1(primitiveTypes1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< PBytes > > BStub_RemoteListTypes::getByte2()  {
	BSyncResultT< byps_ptr< ::std::vector< PBytes > > > syncResult;	
	getByte2([&syncResult](byps_ptr< ::std::vector< PBytes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getByte2(::std::function< void (byps_ptr< ::std::vector< PBytes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getByte2());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< PBytes > >, com::wilutions::byps::test::api::BResult_1174971318 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setByte2(const byps_ptr< ::std::vector< PBytes > >& byte2)  {
	BSyncResultT< bool > syncResult;	
	setByte2(byte2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setByte2(const byps_ptr< ::std::vector< PBytes > >& byte2, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setByte2(byte2));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > > BStub_RemoteListTypes::getInt2()  {
	BSyncResultT< byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > > > syncResult;	
	getInt2([&syncResult](byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getInt2(::std::function< void (byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getInt2());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > >, com::wilutions::byps::test::api::BResult_1752158699 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setInt2(const byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > >& int2)  {
	BSyncResultT< bool > syncResult;	
	setInt2(int2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setInt2(const byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > >& int2, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setInt2(int2));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< PSerializable > > BStub_RemoteListTypes::getObj1()  {
	BSyncResultT< byps_ptr< ::std::vector< PSerializable > > > syncResult;	
	getObj1([&syncResult](byps_ptr< ::std::vector< PSerializable > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getObj1(::std::function< void (byps_ptr< ::std::vector< PSerializable > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getObj1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< PSerializable > >, com::wilutions::byps::test::api::BResult_12 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setObj1(const byps_ptr< ::std::vector< PSerializable > >& obj1)  {
	BSyncResultT< bool > syncResult;	
	setObj1(obj1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setObj1(const byps_ptr< ::std::vector< PSerializable > >& obj1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setObj1(obj1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > > BStub_RemoteListTypes::getInt3()  {
	BSyncResultT< byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > > > syncResult;	
	getInt3([&syncResult](byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getInt3(::std::function< void (byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getInt3());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > >, com::wilutions::byps::test::api::BResult_1746702954 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setInt3(const byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > >& int3)  {
	BSyncResultT< bool > syncResult;	
	setInt3(int3, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setInt3(const byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > >& int3, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setInt3(int3));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > > BStub_RemoteListTypes::getInt4()  {
	BSyncResultT< byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > > > syncResult;	
	getInt4([&syncResult](byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getInt4(::std::function< void (byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_getInt4());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > >, com::wilutions::byps::test::api::BResult_1633500852 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteListTypes::setInt4(const byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > >& int4)  {
	BSyncResultT< bool > syncResult;	
	setInt4(int4, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setInt4(const byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > >& int4, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setInt4(int4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
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
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< ::std::wstring , bool > >, com::wilutions::byps::test::api::BResult_1279823631 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< double , int8_t > >, com::wilutions::byps::test::api::BResult_1972793385 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< float , wchar_t > >, com::wilutions::byps::test::api::BResult_8789515 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int64_t , int16_t > >, com::wilutions::byps::test::api::BResult_601099730 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int32_t , int32_t > >, com::wilutions::byps::test::api::BResult_1347703734 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int16_t , int64_t > >, com::wilutions::byps::test::api::BResult_1973996106 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< wchar_t , float > >, com::wilutions::byps::test::api::BResult_94341197 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int8_t , double > >, com::wilutions::byps::test::api::BResult_1487265161 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< ::std::wstring , ::std::wstring > >, com::wilutions::byps::test::api::BResult_1710660846 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteMapTypes::getPrimitiveTypes1()  {
	BSyncResultT< byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	getPrimitiveTypes1([&syncResult](byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getPrimitiveTypes1(::std::function< void (byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_getPrimitiveTypes1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, com::wilutions::byps::test::api::BResult_703065817 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteMapTypes::setPrimitiveTypes1(const byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes1(primitiveTypes1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setPrimitiveTypes1(const byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setPrimitiveTypes1(primitiveTypes1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int32_t , PBytes > >, com::wilutions::byps::test::api::BResult_1799280818 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > >, com::wilutions::byps::test::api::BResult_1633750383 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< ::std::wstring , PSerializable > >, com::wilutions::byps::test::api::BResult_1488550492 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
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
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::setPrimitiveTypes(const com::wilutions::byps::test::api::prim::PPrimitiveTypes& v)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setPrimitiveTypes(const com::wilutions::byps::test::api::prim::PPrimitiveTypes& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_setPrimitiveTypes(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_1 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int8_t, com::wilutions::byps::test::api::BResult_2 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< wchar_t, com::wilutions::byps::test::api::BResult_4 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int16_t, com::wilutions::byps::test::api::BResult_3 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, com::wilutions::byps::test::api::BResult_5 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int64_t, com::wilutions::byps::test::api::BResult_6 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< float, com::wilutions::byps::test::api::BResult_7 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< double, com::wilutions::byps::test::api::BResult_8 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, com::wilutions::byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
com::wilutions::byps::test::api::prim::PPrimitiveTypes BStub_RemotePrimitiveTypes::getPrimitiveTypes()  {
	BSyncResultT< com::wilutions::byps::test::api::prim::PPrimitiveTypes > syncResult;	
	getPrimitiveTypes([&syncResult](com::wilutions::byps::test::api::prim::PPrimitiveTypes v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getPrimitiveTypes(::std::function< void (com::wilutions::byps::test::api::prim::PPrimitiveTypes, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_getPrimitiveTypes());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< com::wilutions::byps::test::api::prim::PPrimitiveTypes, com::wilutions::byps::test::api::BResult_1000 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PSerializable, com::wilutions::byps::test::api::BResult_21 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemotePrimitiveTypes::sendAllTypes(bool b, wchar_t c, int16_t s, int32_t i, int64_t l, float f, double d, const ::std::wstring& str, const com::wilutions::byps::test::api::prim::PPrimitiveTypes& pt, const PSerializable& o)  {
	BSyncResultT< bool > syncResult;	
	sendAllTypes(b, c, s, i, l, f, d, str, pt, o, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::sendAllTypes(bool b, wchar_t c, int16_t s, int32_t i, int64_t l, float f, double d, const ::std::wstring& str, const com::wilutions::byps::test::api::prim::PPrimitiveTypes& pt, const PSerializable& o, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemotePrimitiveTypes_sendAllTypes(b, c, s, i, l, f, d, str, pt, o));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, com::wilutions::byps::test::api::BResult_5 >(asyncResult) );
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
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:225
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
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}
