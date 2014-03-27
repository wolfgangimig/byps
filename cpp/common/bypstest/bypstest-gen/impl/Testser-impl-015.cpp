#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;



namespace byps { namespace test { namespace api { namespace remote { 
BStub_RemotePrimitiveTypes::BStub_RemotePrimitiveTypes(PTransport transport) 
	: BStub(transport) {}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemotePrimitiveTypes::voidFunctionVoid()  {
	BSyncResultT< bool > syncResult;	
	voidFunctionVoid([&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::voidFunctionVoid(::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_voidFunctionVoid());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemotePrimitiveTypes::setBool(bool v)  {
	BSyncResultT< bool > syncResult;	
	setBool(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setBool(bool v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_setBool(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemotePrimitiveTypes::setByte(int8_t v)  {
	BSyncResultT< bool > syncResult;	
	setByte(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setByte(int8_t v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_setByte(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemotePrimitiveTypes::setChar(wchar_t v)  {
	BSyncResultT< bool > syncResult;	
	setChar(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setChar(wchar_t v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_setChar(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemotePrimitiveTypes::setShort(int16_t v)  {
	BSyncResultT< bool > syncResult;	
	setShort(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setShort(int16_t v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_setShort(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemotePrimitiveTypes::setInt(int32_t v)  {
	BSyncResultT< bool > syncResult;	
	setInt(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setInt(int32_t v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_setInt(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemotePrimitiveTypes::setLong(int64_t v)  {
	BSyncResultT< bool > syncResult;	
	setLong(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setLong(int64_t v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_setLong(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemotePrimitiveTypes::setFloat(float v)  {
	BSyncResultT< bool > syncResult;	
	setFloat(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setFloat(float v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_setFloat(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemotePrimitiveTypes::setDouble(double v)  {
	BSyncResultT< bool > syncResult;	
	setDouble(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setDouble(double v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_setDouble(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemotePrimitiveTypes::setString(const ::std::wstring& v)  {
	BSyncResultT< bool > syncResult;	
	setString(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setString(const ::std::wstring& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_setString(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemotePrimitiveTypes::setPrimitiveTypes(const byps::test::api::prim::PPrimitiveTypes& v)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setPrimitiveTypes(const byps::test::api::prim::PPrimitiveTypes& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_setPrimitiveTypes(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemotePrimitiveTypes::setObject(const PSerializable& v)  {
	BSyncResultT< bool > syncResult;	
	setObject(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setObject(const PSerializable& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_setObject(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemotePrimitiveTypes::setDate(const BDateTime& v)  {
	BSyncResultT< bool > syncResult;	
	setDate(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::setDate(const BDateTime& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_setDate(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
bool BStub_RemotePrimitiveTypes::getBool()  {
	BSyncResultT< bool > syncResult;	
	getBool([&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getBool(::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_getBool());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_1 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
int8_t BStub_RemotePrimitiveTypes::getByte()  {
	BSyncResultT< int8_t > syncResult;	
	getByte([&syncResult](int8_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getByte(::std::function< void (int8_t, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_getByte());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int8_t, byps::test::api::BResult_2 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
wchar_t BStub_RemotePrimitiveTypes::getChar()  {
	BSyncResultT< wchar_t > syncResult;	
	getChar([&syncResult](wchar_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getChar(::std::function< void (wchar_t, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_getChar());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< wchar_t, byps::test::api::BResult_4 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
int16_t BStub_RemotePrimitiveTypes::getShort()  {
	BSyncResultT< int16_t > syncResult;	
	getShort([&syncResult](int16_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getShort(::std::function< void (int16_t, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_getShort());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int16_t, byps::test::api::BResult_3 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
int32_t BStub_RemotePrimitiveTypes::getInt()  {
	BSyncResultT< int32_t > syncResult;	
	getInt([&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getInt(::std::function< void (int32_t, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_getInt());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, byps::test::api::BResult_5 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
int64_t BStub_RemotePrimitiveTypes::getLong()  {
	BSyncResultT< int64_t > syncResult;	
	getLong([&syncResult](int64_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getLong(::std::function< void (int64_t, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_getLong());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int64_t, byps::test::api::BResult_6 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
float BStub_RemotePrimitiveTypes::getFloat()  {
	BSyncResultT< float > syncResult;	
	getFloat([&syncResult](float v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getFloat(::std::function< void (float, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_getFloat());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< float, byps::test::api::BResult_7 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
double BStub_RemotePrimitiveTypes::getDouble()  {
	BSyncResultT< double > syncResult;	
	getDouble([&syncResult](double v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getDouble(::std::function< void (double, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_getDouble());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< double, byps::test::api::BResult_8 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
::std::wstring BStub_RemotePrimitiveTypes::getString()  {
	BSyncResultT< ::std::wstring > syncResult;	
	getString([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getString(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_getString());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::test::api::prim::PPrimitiveTypes BStub_RemotePrimitiveTypes::getPrimitiveTypes()  {
	BSyncResultT< byps::test::api::prim::PPrimitiveTypes > syncResult;	
	getPrimitiveTypes([&syncResult](byps::test::api::prim::PPrimitiveTypes v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getPrimitiveTypes(::std::function< void (byps::test::api::prim::PPrimitiveTypes, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_getPrimitiveTypes());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::test::api::prim::PPrimitiveTypes, byps::test::api::BResult_1000 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PSerializable BStub_RemotePrimitiveTypes::getObject()  {
	BSyncResultT< PSerializable > syncResult;	
	getObject([&syncResult](PSerializable v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getObject(::std::function< void (PSerializable, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_getObject());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PSerializable, byps::test::api::BResult_21 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
BDateTime BStub_RemotePrimitiveTypes::getDate()  {
	BSyncResultT< BDateTime > syncResult;	
	getDate([&syncResult](BDateTime v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::getDate(::std::function< void (BDateTime, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_getDate());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< BDateTime, byps::test::api::BResult_17 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemotePrimitiveTypes::sendAllTypes(bool b, wchar_t c, int16_t s, int32_t i, int64_t l, float f, double d, const ::std::wstring& str, const byps::test::api::prim::PPrimitiveTypes& pt, const PSerializable& o)  {
	BSyncResultT< bool > syncResult;	
	sendAllTypes(b, c, s, i, l, f, d, str, pt, o, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::sendAllTypes(bool b, wchar_t c, int16_t s, int32_t i, int64_t l, float f, double d, const ::std::wstring& str, const byps::test::api::prim::PPrimitiveTypes& pt, const PSerializable& o, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_sendAllTypes(b, c, s, i, l, f, d, str, pt, o));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
int32_t BStub_RemotePrimitiveTypes::add(int32_t a, int32_t b)  {
	BSyncResultT< int32_t > syncResult;	
	add(a, b, [&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::add(int32_t a, int32_t b, ::std::function< void (int32_t, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_add(a, b));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, byps::test::api::BResult_5 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
BDateTime BStub_RemotePrimitiveTypes::makeDate(int32_t year, int32_t month, int32_t day, int32_t hour, int32_t minute, int32_t second, int32_t millisecond)  {
	BSyncResultT< BDateTime > syncResult;	
	makeDate(year, month, day, hour, minute, second, millisecond, [&syncResult](BDateTime v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemotePrimitiveTypes::makeDate(int32_t year, int32_t month, int32_t day, int32_t hour, int32_t minute, int32_t second, int32_t millisecond, ::std::function< void (BDateTime, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemotePrimitiveTypes_makeDate(year, month, day, hour, minute, second, millisecond));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< BDateTime, byps::test::api::BResult_17 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

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

// checkpoint byps.gen.cpp.GenRemoteStub:224
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
}}}}

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
}}}}

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
}}}}

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

