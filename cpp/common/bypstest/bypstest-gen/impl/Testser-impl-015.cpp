#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace remote { 
PArrayInt BStub_RemotePrimitiveTypes::parseDate(const BDateTime& date)  {
	BSyncResultT< PArrayInt > syncResult;	
	parseDate(date, [&syncResult](PArrayInt v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::parseDate(const BDateTime& date, ::std::function< void (PArrayInt, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_parseDate(date));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArrayInt, byps::test::api::BResult_100361105 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemotePrimitiveTypes::throwException()  {
	BSyncResultT< bool > syncResult;	
	throwException([&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::throwException(::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_throwException());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
int32_t BStub_RemotePrimitiveTypes::getDeferredValueFromServer(int32_t param1, const ::std::wstring& param2)  {
	BSyncResultT< int32_t > syncResult;	
	getDeferredValueFromServer(param1, param2, [&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getDeferredValueFromServer(int32_t param1, const ::std::wstring& param2, ::std::function< void (int32_t, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_getDeferredValueFromServer(param1, param2));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, byps::test::api::BResult_5 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_456456(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved){
	BSerializer_16_Template<byps::test::api::remote::BStub_RemotePrimitiveTypes, 456456>(bio, pObj, pObjS, reserved);
}
}}}



namespace byps { namespace test { namespace api { namespace remote { 
BStub_RemoteProcessingEx::BStub_RemoteProcessingEx(PTransport transport) 
	: BStub(transport) {}
}}}}

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BStub_RemoteProcessingEx::BSerializable_getTypeId() {
	return 790485113; 
}
namespace byps { namespace test { namespace api { namespace remote { 
bool BStub_RemoteProcessingEx::getValueAfterProcessingExceptions(int32_t sleepSeconds)  {
	BSyncResultT< bool > syncResult;	
	getValueAfterProcessingExceptions(sleepSeconds, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteProcessingEx::getValueAfterProcessingExceptions(int32_t sleepSeconds, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteProcessingEx_getValueAfterProcessingExceptions(sleepSeconds));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_1 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_790485113(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved){
	BSerializer_16_Template<byps::test::api::remote::BStub_RemoteProcessingEx, 790485113>(bio, pObj, pObjS, reserved);
}
}}}



namespace byps { namespace test { namespace api { namespace remote { 
BStub_RemoteReferences::BStub_RemoteReferences(PTransport transport) 
	: BStub(transport) {}
}}}}

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BStub_RemoteReferences::BSerializable_getTypeId() {
	return 568637225; 
}
namespace byps { namespace test { namespace api { namespace remote { 
byps::test::api::refs::PNode BStub_RemoteReferences::getNode()  {
	BSyncResultT< byps::test::api::refs::PNode > syncResult;	
	getNode([&syncResult](byps::test::api::refs::PNode v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteReferences::getNode(::std::function< void (byps::test::api::refs::PNode, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteReferences_getNode());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::test::api::refs::PNode, byps::test::api::BResult_9001 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteReferences::setNode(const byps::test::api::refs::PNode& v)  {
	BSyncResultT< bool > syncResult;	
	setNode(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteReferences::setNode(const byps::test::api::refs::PNode& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteReferences_setNode(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_568637225(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved){
	BSerializer_16_Template<byps::test::api::remote::BStub_RemoteReferences, 568637225>(bio, pObj, pObjS, reserved);
}
}}}



namespace byps { namespace test { namespace api { namespace remote { 
BStub_RemoteServerCtrl::BStub_RemoteServerCtrl(PTransport transport) 
	: BStub(transport) {}
}}}}

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BStub_RemoteServerCtrl::BSerializable_getTypeId() {
	return 1652234479; 
}
namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteServerCtrl::publishRemote(const ::std::wstring& name, const PRemote& remote, bool fowardToOtherServers)  {
	BSyncResultT< bool > syncResult;	
	publishRemote(name, remote, fowardToOtherServers, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteServerCtrl::publishRemote(const ::std::wstring& name, const PRemote& remote, bool fowardToOtherServers, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteServerCtrl_publishRemote(name, remote, fowardToOtherServers));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PRemote BStub_RemoteServerCtrl::getPublishedRemote(const ::std::wstring& name)  {
	BSyncResultT< PRemote > syncResult;	
	getPublishedRemote(name, [&syncResult](PRemote v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteServerCtrl::getPublishedRemote(const ::std::wstring& name, ::std::function< void (PRemote, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteServerCtrl_getPublishedRemote(name));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PRemote, byps::test::api::BResult_16 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteServerCtrl::removePublishedRemote(const ::std::wstring& name)  {
	BSyncResultT< bool > syncResult;	
	removePublishedRemote(name, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteServerCtrl::removePublishedRemote(const ::std::wstring& name, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteServerCtrl_removePublishedRemote(name));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_1652234479(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved){
	BSerializer_16_Template<byps::test::api::remote::BStub_RemoteServerCtrl, 1652234479>(bio, pObj, pObjS, reserved);
}
}}}



namespace byps { namespace test { namespace api { namespace remote { 
BStub_RemoteSetTypes::BStub_RemoteSetTypes(PTransport transport) 
	: BStub(transport) {}
}}}}

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BStub_RemoteSetTypes::BSerializable_getTypeId() {
	return 1900796440; 
}
namespace byps { namespace test { namespace api { namespace remote { 
byps::PSetBoolean BStub_RemoteSetTypes::getBoolean1()  {
	BSyncResultT< byps::PSetBoolean > syncResult;	
	getBoolean1([&syncResult](byps::PSetBoolean v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getBoolean1(::std::function< void (byps::PSetBoolean, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_getBoolean1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PSetBoolean, byps::test::api::BResult_1365696060 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteSetTypes::setBoolean1(const byps::PSetBoolean& boolean1)  {
	BSyncResultT< bool > syncResult;	
	setBoolean1(boolean1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setBoolean1(const byps::PSetBoolean& boolean1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_setBoolean1(boolean1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PSetByte BStub_RemoteSetTypes::getByte1()  {
	BSyncResultT< byps::PSetByte > syncResult;	
	getByte1([&syncResult](byps::PSetByte v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getByte1(::std::function< void (byps::PSetByte, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_getByte1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PSetByte, byps::test::api::BResult_31512998 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteSetTypes::setByte1(const byps::PSetByte& byte1)  {
	BSyncResultT< bool > syncResult;	
	setByte1(byte1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setByte1(const byps::PSetByte& byte1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_setByte1(byte1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PSetCharacter BStub_RemoteSetTypes::getChar1()  {
	BSyncResultT< byps::PSetCharacter > syncResult;	
	getChar1([&syncResult](byps::PSetCharacter v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getChar1(::std::function< void (byps::PSetCharacter, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_getChar1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PSetCharacter, byps::test::api::BResult_936607009 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteSetTypes::setChar1(const byps::PSetCharacter& char1)  {
	BSyncResultT< bool > syncResult;	
	setChar1(char1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setChar1(const byps::PSetCharacter& char1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_setChar1(char1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PSetShort BStub_RemoteSetTypes::getShort1()  {
	BSyncResultT< byps::PSetShort > syncResult;	
	getShort1([&syncResult](byps::PSetShort v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getShort1(::std::function< void (byps::PSetShort, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_getShort1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PSetShort, byps::test::api::BResult_2028443792 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteSetTypes::setShort1(const byps::PSetShort& short1)  {
	BSyncResultT< bool > syncResult;	
	setShort1(short1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setShort1(const byps::PSetShort& short1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_setShort1(short1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PSetInteger BStub_RemoteSetTypes::getInt1()  {
	BSyncResultT< byps::PSetInteger > syncResult;	
	getInt1([&syncResult](byps::PSetInteger v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getInt1(::std::function< void (byps::PSetInteger, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_getInt1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PSetInteger, byps::test::api::BResult_1493282670 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteSetTypes::setInt1(const byps::PSetInteger& int1)  {
	BSyncResultT< bool > syncResult;	
	setInt1(int1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setInt1(const byps::PSetInteger& int1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_setInt1(int1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PSetLong BStub_RemoteSetTypes::getLong1()  {
	BSyncResultT< byps::PSetLong > syncResult;	
	getLong1([&syncResult](byps::PSetLong v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getLong1(::std::function< void (byps::PSetLong, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_getLong1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PSetLong, byps::test::api::BResult_1457164460 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteSetTypes::setLong1(const byps::PSetLong& long1)  {
	BSyncResultT< bool > syncResult;	
	setLong1(long1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setLong1(const byps::PSetLong& long1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_setLong1(long1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PSetFloat BStub_RemoteSetTypes::getFloat1()  {
	BSyncResultT< byps::PSetFloat > syncResult;	
	getFloat1([&syncResult](byps::PSetFloat v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getFloat1(::std::function< void (byps::PSetFloat, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_getFloat1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PSetFloat, byps::test::api::BResult_1898022288 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteSetTypes::setFloat1(const byps::PSetFloat& float1)  {
	BSyncResultT< bool > syncResult;	
	setFloat1(float1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setFloat1(const byps::PSetFloat& float1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_setFloat1(float1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PSetDouble BStub_RemoteSetTypes::getDouble1()  {
	BSyncResultT< byps::PSetDouble > syncResult;	
	getDouble1([&syncResult](byps::PSetDouble v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getDouble1(::std::function< void (byps::PSetDouble, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_getDouble1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PSetDouble, byps::test::api::BResult_1320560671 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteSetTypes::setDouble1(const byps::PSetDouble& double1)  {
	BSyncResultT< bool > syncResult;	
	setDouble1(double1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setDouble1(const byps::PSetDouble& double1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_setDouble1(double1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PSetString BStub_RemoteSetTypes::getString1()  {
	BSyncResultT< byps::PSetString > syncResult;	
	getString1([&syncResult](byps::PSetString v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getString1(::std::function< void (byps::PSetString, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_getString1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PSetString, byps::test::api::BResult_1888799711 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteSetTypes::setString1(const byps::PSetString& string1)  {
	BSyncResultT< bool > syncResult;	
	setString1(string1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setString1(const byps::PSetString& string1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_setString1(string1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteSetTypes::getPrimitiveTypes1()  {
	BSyncResultT< byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	getPrimitiveTypes1([&syncResult](byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getPrimitiveTypes1(::std::function< void (byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_getPrimitiveTypes1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > >, byps::test::api::BResult_673917574 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteSetTypes::setPrimitiveTypes1(const byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes1(primitiveTypes1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setPrimitiveTypes1(const byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_setPrimitiveTypes1(primitiveTypes1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps_ptr< ::std::set< PBytes > > BStub_RemoteSetTypes::getByte2()  {
	BSyncResultT< byps_ptr< ::std::set< PBytes > > > syncResult;	
	getByte2([&syncResult](byps_ptr< ::std::set< PBytes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteSetTypes::getByte2(::std::function< void (byps_ptr< ::std::set< PBytes > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_getByte2());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::set< PBytes > >, byps::test::api::BResult_2052431866 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteSetTypes::setByte2(const byps_ptr< ::std::set< PBytes > >& byte2)  {
	BSyncResultT< bool > syncResult;	
	setByte2(byte2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteSetTypes::setByte2(const byps_ptr< ::std::set< PBytes > >& byte2, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteSetTypes_setByte2(byte2));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

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
void BSerializer_1900796440(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved){
	BSerializer_16_Template<byps::test::api::remote::BStub_RemoteSetTypes, 1900796440>(bio, pObj, pObjS, reserved);
}
}}}



namespace byps { namespace test { namespace api { namespace remote { 
BStub_RemoteStreams::BStub_RemoteStreams(PTransport transport) 
	: BStub(transport) {}
}}}}

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BStub_RemoteStreams::BSerializable_getTypeId() {
	return 1043578866; 
}
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
PContentStream BStub_RemoteStreams::getVideoCheckSupportByteRange()  {
	BSyncResultT< PContentStream > syncResult;	
	getVideoCheckSupportByteRange([&syncResult](PContentStream v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteStreams::getVideoCheckSupportByteRange(::std::function< void (PContentStream, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteStreams_getVideoCheckSupportByteRange());
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

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteStreams::putSharedStream(int64_t id, const PContentStream& stream)  {
	BSyncResultT< bool > syncResult;	
	putSharedStream(id, stream, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteStreams::putSharedStream(int64_t id, const PContentStream& stream, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteStreams_putSharedStream(id, stream));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PContentStream BStub_RemoteStreams::getSharedStream(int64_t id)  {
	BSyncResultT< PContentStream > syncResult;	
	getSharedStream(id, [&syncResult](PContentStream v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteStreams::getSharedStream(int64_t id, ::std::function< void (PContentStream, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteStreams_getSharedStream(id));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PContentStream, byps::test::api::BResult_15 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_1043578866(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved){
	BSerializer_16_Template<byps::test::api::remote::BStub_RemoteStreams, 1043578866>(bio, pObj, pObjS, reserved);
}
}}}



namespace byps { namespace test { namespace api { namespace remote { 
BStub_RemoteWithAuthentication::BStub_RemoteWithAuthentication(PTransport transport) 
	: BStub(transport) {}
}}}}

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BStub_RemoteWithAuthentication::BSerializable_getTypeId() {
	return 1983670399; 
}
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
void BSerializer_1983670399(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved){
	BSerializer_16_Template<byps::test::api::remote::BStub_RemoteWithAuthentication, 1983670399>(bio, pObj, pObjS, reserved);
}
}}}


namespace byps { namespace test { namespace api { namespace srvr { 

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BSkeleton_ClientIF::BSerializable_getTypeId() {
	return 2049072174; 
}
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

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BStub_ClientIF::BSerializable_getTypeId() {
	return 2049072174; 
}
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
void BSerializer_2049072174(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved){
	BSerializer_16_Template<byps::test::api::srvr::BStub_ClientIF, 2049072174>(bio, pObj, pObjS, reserved);
}
}}}



namespace byps { namespace test { namespace api { namespace srvr { 
BStub_ServerIF::BStub_ServerIF(PTransport transport) 
	: BStub(transport) {}
}}}}

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::srvr::BStub_ServerIF::BSerializable_getTypeId() {
	return 1775199834; 
}
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

