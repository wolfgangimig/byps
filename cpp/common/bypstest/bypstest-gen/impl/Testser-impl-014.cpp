#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteInlineInstance::setPoint2DList(const byps::test::api::inl::PVectorPoint2D& pointList)  {
	BSyncResultT< bool > syncResult;	
	setPoint2DList(pointList, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteInlineInstance::setPoint2DList(const byps::test::api::inl::PVectorPoint2D& pointList, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteInlineInstance_setPoint2DList(pointList));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::test::api::inl::PVectorPoint2D BStub_RemoteInlineInstance::getPoint2DList()  {
	BSyncResultT< byps::test::api::inl::PVectorPoint2D > syncResult;	
	getPoint2DList([&syncResult](byps::test::api::inl::PVectorPoint2D v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteInlineInstance::getPoint2DList(::std::function< void (byps::test::api::inl::PVectorPoint2D, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteInlineInstance_getPoint2DList());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::test::api::inl::PVectorPoint2D, byps::test::api::BResult_2064980445 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteInlineInstance::setPoint2DListList(const byps_ptr< ::std::vector< byps::test::api::inl::PVectorPoint2D > >& pointListList)  {
	BSyncResultT< bool > syncResult;	
	setPoint2DListList(pointListList, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteInlineInstance::setPoint2DListList(const byps_ptr< ::std::vector< byps::test::api::inl::PVectorPoint2D > >& pointListList, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteInlineInstance_setPoint2DListList(pointListList));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps_ptr< ::std::vector< byps::test::api::inl::PVectorPoint2D > > BStub_RemoteInlineInstance::getPoint2DListList()  {
	BSyncResultT< byps_ptr< ::std::vector< byps::test::api::inl::PVectorPoint2D > > > syncResult;	
	getPoint2DListList([&syncResult](byps_ptr< ::std::vector< byps::test::api::inl::PVectorPoint2D > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteInlineInstance::getPoint2DListList(::std::function< void (byps_ptr< ::std::vector< byps::test::api::inl::PVectorPoint2D > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteInlineInstance_getPoint2DListList());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< byps::test::api::inl::PVectorPoint2D > >, byps::test::api::BResult_1823330785 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteInlineInstance::setPoint2DMap(const byps::test::api::inl::PMapIntegerPoint2D& pointMap)  {
	BSyncResultT< bool > syncResult;	
	setPoint2DMap(pointMap, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteInlineInstance::setPoint2DMap(const byps::test::api::inl::PMapIntegerPoint2D& pointMap, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteInlineInstance_setPoint2DMap(pointMap));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::test::api::inl::PMapIntegerPoint2D BStub_RemoteInlineInstance::getPoint2DMap()  {
	BSyncResultT< byps::test::api::inl::PMapIntegerPoint2D > syncResult;	
	getPoint2DMap([&syncResult](byps::test::api::inl::PMapIntegerPoint2D v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteInlineInstance::getPoint2DMap(::std::function< void (byps::test::api::inl::PMapIntegerPoint2D, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteInlineInstance_getPoint2DMap());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::test::api::inl::PMapIntegerPoint2D, byps::test::api::BResult_1358523233 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_567395951(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::remote::BStub_RemoteInlineInstance(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}



namespace byps { namespace test { namespace api { namespace remote { 
BStub_RemoteListTypes::BStub_RemoteListTypes(PTransport transport) 
	: BStub(transport) {}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PVectorBoolean BStub_RemoteListTypes::getBoolean1()  {
	BSyncResultT< byps::PVectorBoolean > syncResult;	
	getBoolean1([&syncResult](byps::PVectorBoolean v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getBoolean1(::std::function< void (byps::PVectorBoolean, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_getBoolean1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PVectorBoolean, byps::test::api::BResult_1617670280 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteListTypes::setBoolean1(const byps::PVectorBoolean& boolean1)  {
	BSyncResultT< bool > syncResult;	
	setBoolean1(boolean1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setBoolean1(const byps::PVectorBoolean& boolean1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_setBoolean1(boolean1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PVectorByte BStub_RemoteListTypes::getByte1()  {
	BSyncResultT< byps::PVectorByte > syncResult;	
	getByte1([&syncResult](byps::PVectorByte v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getByte1(::std::function< void (byps::PVectorByte, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_getByte1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PVectorByte, byps::test::api::BResult_1059148284 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteListTypes::setByte1(const byps::PVectorByte& byte1)  {
	BSyncResultT< bool > syncResult;	
	setByte1(byte1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setByte1(const byps::PVectorByte& byte1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_setByte1(byte1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PVectorCharacter BStub_RemoteListTypes::getChar1()  {
	BSyncResultT< byps::PVectorCharacter > syncResult;	
	getChar1([&syncResult](byps::PVectorCharacter v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getChar1(::std::function< void (byps::PVectorCharacter, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_getChar1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PVectorCharacter, byps::test::api::BResult_1661807911 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteListTypes::setChar1(const byps::PVectorCharacter& char1)  {
	BSyncResultT< bool > syncResult;	
	setChar1(char1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setChar1(const byps::PVectorCharacter& char1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_setChar1(char1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PVectorShort BStub_RemoteListTypes::getShort1()  {
	BSyncResultT< byps::PVectorShort > syncResult;	
	getShort1([&syncResult](byps::PVectorShort v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getShort1(::std::function< void (byps::PVectorShort, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_getShort1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PVectorShort, byps::test::api::BResult_1997002548 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteListTypes::setShort1(const byps::PVectorShort& short1)  {
	BSyncResultT< bool > syncResult;	
	setShort1(short1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setShort1(const byps::PVectorShort& short1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_setShort1(short1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PVectorInteger BStub_RemoteListTypes::getInt1()  {
	BSyncResultT< byps::PVectorInteger > syncResult;	
	getInt1([&syncResult](byps::PVectorInteger v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getInt1(::std::function< void (byps::PVectorInteger, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_getInt1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PVectorInteger, byps::test::api::BResult_181681714 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteListTypes::setInt1(const byps::PVectorInteger& int1)  {
	BSyncResultT< bool > syncResult;	
	setInt1(int1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setInt1(const byps::PVectorInteger& int1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_setInt1(int1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PVectorLong BStub_RemoteListTypes::getLong1()  {
	BSyncResultT< byps::PVectorLong > syncResult;	
	getLong1([&syncResult](byps::PVectorLong v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getLong1(::std::function< void (byps::PVectorLong, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_getLong1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PVectorLong, byps::test::api::BResult_1050216688 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteListTypes::setLong1(const byps::PVectorLong& long1)  {
	BSyncResultT< bool > syncResult;	
	setLong1(long1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setLong1(const byps::PVectorLong& long1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_setLong1(long1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PVectorFloat BStub_RemoteListTypes::getFloat1()  {
	BSyncResultT< byps::PVectorFloat > syncResult;	
	getFloat1([&syncResult](byps::PVectorFloat v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getFloat1(::std::function< void (byps::PVectorFloat, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_getFloat1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PVectorFloat, byps::test::api::BResult_1628501332 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteListTypes::setFloat1(const byps::PVectorFloat& float1)  {
	BSyncResultT< bool > syncResult;	
	setFloat1(float1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setFloat1(const byps::PVectorFloat& float1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_setFloat1(float1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PVectorDouble BStub_RemoteListTypes::getDouble1()  {
	BSyncResultT< byps::PVectorDouble > syncResult;	
	getDouble1([&syncResult](byps::PVectorDouble v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getDouble1(::std::function< void (byps::PVectorDouble, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_getDouble1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PVectorDouble, byps::test::api::BResult_1555345627 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteListTypes::setDouble1(const byps::PVectorDouble& double1)  {
	BSyncResultT< bool > syncResult;	
	setDouble1(double1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setDouble1(const byps::PVectorDouble& double1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_setDouble1(double1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PVectorString BStub_RemoteListTypes::getString1()  {
	BSyncResultT< byps::PVectorString > syncResult;	
	getString1([&syncResult](byps::PVectorString v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getString1(::std::function< void (byps::PVectorString, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_getString1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PVectorString, byps::test::api::BResult_2123584667 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteListTypes::setString1(const byps::PVectorString& string1)  {
	BSyncResultT< bool > syncResult;	
	setString1(string1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setString1(const byps::PVectorString& string1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_setString1(string1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::test::api::prim::PVectorPrimitiveTypes BStub_RemoteListTypes::getPrimitiveTypes1()  {
	BSyncResultT< byps::test::api::prim::PVectorPrimitiveTypes > syncResult;	
	getPrimitiveTypes1([&syncResult](byps::test::api::prim::PVectorPrimitiveTypes v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getPrimitiveTypes1(::std::function< void (byps::test::api::prim::PVectorPrimitiveTypes, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_getPrimitiveTypes1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::test::api::prim::PVectorPrimitiveTypes, byps::test::api::BResult_1596367810 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteListTypes::setPrimitiveTypes1(const byps::test::api::prim::PVectorPrimitiveTypes& primitiveTypes1)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes1(primitiveTypes1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setPrimitiveTypes1(const byps::test::api::prim::PVectorPrimitiveTypes& primitiveTypes1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_setPrimitiveTypes1(primitiveTypes1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps_ptr< ::std::vector< PBytes > > BStub_RemoteListTypes::getByte2()  {
	BSyncResultT< byps_ptr< ::std::vector< PBytes > > > syncResult;	
	getByte2([&syncResult](byps_ptr< ::std::vector< PBytes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getByte2(::std::function< void (byps_ptr< ::std::vector< PBytes > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_getByte2());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< PBytes > >, byps::test::api::BResult_1174971318 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteListTypes::setByte2(const byps_ptr< ::std::vector< PBytes > >& byte2)  {
	BSyncResultT< bool > syncResult;	
	setByte2(byte2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setByte2(const byps_ptr< ::std::vector< PBytes > >& byte2, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_setByte2(byte2));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps_ptr< ::std::vector< PArrayInt > > BStub_RemoteListTypes::getInt2()  {
	BSyncResultT< byps_ptr< ::std::vector< PArrayInt > > > syncResult;	
	getInt2([&syncResult](byps_ptr< ::std::vector< PArrayInt > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getInt2(::std::function< void (byps_ptr< ::std::vector< PArrayInt > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_getInt2());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< PArrayInt > >, byps::test::api::BResult_1752158699 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteListTypes::setInt2(const byps_ptr< ::std::vector< PArrayInt > >& int2)  {
	BSyncResultT< bool > syncResult;	
	setInt2(int2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setInt2(const byps_ptr< ::std::vector< PArrayInt > >& int2, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_setInt2(int2));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PVectorObject BStub_RemoteListTypes::getObj1()  {
	BSyncResultT< byps::PVectorObject > syncResult;	
	getObj1([&syncResult](byps::PVectorObject v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getObj1(::std::function< void (byps::PVectorObject, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_getObj1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PVectorObject, byps::test::api::BResult_12 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteListTypes::setObj1(const byps::PVectorObject& obj1)  {
	BSyncResultT< bool > syncResult;	
	setObj1(obj1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setObj1(const byps::PVectorObject& obj1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_setObj1(obj1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteListTypes::setDate1(const byps::PVectorDate& obj1)  {
	BSyncResultT< bool > syncResult;	
	setDate1(obj1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setDate1(const byps::PVectorDate& obj1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_setDate1(obj1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PVectorDate BStub_RemoteListTypes::getDate1()  {
	BSyncResultT< byps::PVectorDate > syncResult;	
	getDate1([&syncResult](byps::PVectorDate v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getDate1(::std::function< void (byps::PVectorDate, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_getDate1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PVectorDate, byps::test::api::BResult_1504867122 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps_ptr< ::std::vector< byps::PVectorInteger > > BStub_RemoteListTypes::getInt3()  {
	BSyncResultT< byps_ptr< ::std::vector< byps::PVectorInteger > > > syncResult;	
	getInt3([&syncResult](byps_ptr< ::std::vector< byps::PVectorInteger > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getInt3(::std::function< void (byps_ptr< ::std::vector< byps::PVectorInteger > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_getInt3());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< byps::PVectorInteger > >, byps::test::api::BResult_1746702954 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteListTypes::setInt3(const byps_ptr< ::std::vector< byps::PVectorInteger > >& int3)  {
	BSyncResultT< bool > syncResult;	
	setInt3(int3, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setInt3(const byps_ptr< ::std::vector< byps::PVectorInteger > >& int3, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_setInt3(int3));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > > BStub_RemoteListTypes::getInt4()  {
	BSyncResultT< byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > > > syncResult;	
	getInt4([&syncResult](byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteListTypes::getInt4(::std::function< void (byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_getInt4());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > >, byps::test::api::BResult_1633500852 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteListTypes::setInt4(const byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > >& int4)  {
	BSyncResultT< bool > syncResult;	
	setInt4(int4, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setInt4(const byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps::PSetInteger > > > > > >& int4, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteListTypes_setInt4(int4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_1233438138(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::remote::BStub_RemoteListTypes(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}



namespace byps { namespace test { namespace api { namespace remote { 
BStub_RemoteMapTypes::BStub_RemoteMapTypes(PTransport transport) 
	: BStub(transport) {}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PMapStringBoolean BStub_RemoteMapTypes::getBoolean1()  {
	BSyncResultT< byps::PMapStringBoolean > syncResult;	
	getBoolean1([&syncResult](byps::PMapStringBoolean v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getBoolean1(::std::function< void (byps::PMapStringBoolean, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_getBoolean1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PMapStringBoolean, byps::test::api::BResult_1279823631 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteMapTypes::setBoolean1(const byps::PMapStringBoolean& boolean1)  {
	BSyncResultT< bool > syncResult;	
	setBoolean1(boolean1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setBoolean1(const byps::PMapStringBoolean& boolean1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_setBoolean1(boolean1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PMapDoubleByte BStub_RemoteMapTypes::getByte1()  {
	BSyncResultT< byps::PMapDoubleByte > syncResult;	
	getByte1([&syncResult](byps::PMapDoubleByte v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getByte1(::std::function< void (byps::PMapDoubleByte, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_getByte1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PMapDoubleByte, byps::test::api::BResult_1972793385 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteMapTypes::setByte1(const byps::PMapDoubleByte& byte1)  {
	BSyncResultT< bool > syncResult;	
	setByte1(byte1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setByte1(const byps::PMapDoubleByte& byte1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_setByte1(byte1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PMapFloatCharacter BStub_RemoteMapTypes::getChar1()  {
	BSyncResultT< byps::PMapFloatCharacter > syncResult;	
	getChar1([&syncResult](byps::PMapFloatCharacter v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getChar1(::std::function< void (byps::PMapFloatCharacter, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_getChar1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PMapFloatCharacter, byps::test::api::BResult_8789515 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteMapTypes::setChar1(const byps::PMapFloatCharacter& char1)  {
	BSyncResultT< bool > syncResult;	
	setChar1(char1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setChar1(const byps::PMapFloatCharacter& char1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_setChar1(char1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PMapLongShort BStub_RemoteMapTypes::getShort1()  {
	BSyncResultT< byps::PMapLongShort > syncResult;	
	getShort1([&syncResult](byps::PMapLongShort v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getShort1(::std::function< void (byps::PMapLongShort, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_getShort1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PMapLongShort, byps::test::api::BResult_601099730 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteMapTypes::setShort1(const byps::PMapLongShort& short1)  {
	BSyncResultT< bool > syncResult;	
	setShort1(short1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setShort1(const byps::PMapLongShort& short1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_setShort1(short1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PMapIntegerInteger BStub_RemoteMapTypes::getInt1()  {
	BSyncResultT< byps::PMapIntegerInteger > syncResult;	
	getInt1([&syncResult](byps::PMapIntegerInteger v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getInt1(::std::function< void (byps::PMapIntegerInteger, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_getInt1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PMapIntegerInteger, byps::test::api::BResult_1347703734 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteMapTypes::setInt1(const byps::PMapIntegerInteger& int1)  {
	BSyncResultT< bool > syncResult;	
	setInt1(int1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setInt1(const byps::PMapIntegerInteger& int1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_setInt1(int1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PMapShortLong BStub_RemoteMapTypes::getLong1()  {
	BSyncResultT< byps::PMapShortLong > syncResult;	
	getLong1([&syncResult](byps::PMapShortLong v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getLong1(::std::function< void (byps::PMapShortLong, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_getLong1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PMapShortLong, byps::test::api::BResult_1973996106 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteMapTypes::setLong1(const byps::PMapShortLong& long1)  {
	BSyncResultT< bool > syncResult;	
	setLong1(long1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setLong1(const byps::PMapShortLong& long1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_setLong1(long1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PMapCharacterFloat BStub_RemoteMapTypes::getFloat1()  {
	BSyncResultT< byps::PMapCharacterFloat > syncResult;	
	getFloat1([&syncResult](byps::PMapCharacterFloat v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getFloat1(::std::function< void (byps::PMapCharacterFloat, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_getFloat1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PMapCharacterFloat, byps::test::api::BResult_94341197 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteMapTypes::setFloat1(const byps::PMapCharacterFloat& float1)  {
	BSyncResultT< bool > syncResult;	
	setFloat1(float1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setFloat1(const byps::PMapCharacterFloat& float1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_setFloat1(float1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PMapByteDouble BStub_RemoteMapTypes::getDouble1()  {
	BSyncResultT< byps::PMapByteDouble > syncResult;	
	getDouble1([&syncResult](byps::PMapByteDouble v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getDouble1(::std::function< void (byps::PMapByteDouble, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_getDouble1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PMapByteDouble, byps::test::api::BResult_1487265161 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteMapTypes::setDouble1(const byps::PMapByteDouble& double1)  {
	BSyncResultT< bool > syncResult;	
	setDouble1(double1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setDouble1(const byps::PMapByteDouble& double1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_setDouble1(double1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PMapStringString BStub_RemoteMapTypes::getString1()  {
	BSyncResultT< byps::PMapStringString > syncResult;	
	getString1([&syncResult](byps::PMapStringString v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getString1(::std::function< void (byps::PMapStringString, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_getString1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PMapStringString, byps::test::api::BResult_1710660846 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteMapTypes::setString1(const byps::PMapStringString& string1)  {
	BSyncResultT< bool > syncResult;	
	setString1(string1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setString1(const byps::PMapStringString& string1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_setString1(string1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::test::api::prim::PMapIntegerPrimitiveTypes BStub_RemoteMapTypes::getPrimitiveTypes1()  {
	BSyncResultT< byps::test::api::prim::PMapIntegerPrimitiveTypes > syncResult;	
	getPrimitiveTypes1([&syncResult](byps::test::api::prim::PMapIntegerPrimitiveTypes v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getPrimitiveTypes1(::std::function< void (byps::test::api::prim::PMapIntegerPrimitiveTypes, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_getPrimitiveTypes1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::test::api::prim::PMapIntegerPrimitiveTypes, byps::test::api::BResult_1831201218 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteMapTypes::setPrimitiveTypes1(const byps::test::api::prim::PMapIntegerPrimitiveTypes& primitiveTypes1)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes1(primitiveTypes1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setPrimitiveTypes1(const byps::test::api::prim::PMapIntegerPrimitiveTypes& primitiveTypes1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_setPrimitiveTypes1(primitiveTypes1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps_ptr< ::std::map< int32_t , PBytes > > BStub_RemoteMapTypes::getByte2()  {
	BSyncResultT< byps_ptr< ::std::map< int32_t , PBytes > > > syncResult;	
	getByte2([&syncResult](byps_ptr< ::std::map< int32_t , PBytes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getByte2(::std::function< void (byps_ptr< ::std::map< int32_t , PBytes > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_getByte2());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int32_t , PBytes > >, byps::test::api::BResult_1799280818 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteMapTypes::setByte2(const byps_ptr< ::std::map< int32_t , PBytes > >& byte2)  {
	BSyncResultT< bool > syncResult;	
	setByte2(byte2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setByte2(const byps_ptr< ::std::map< int32_t , PBytes > >& byte2, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_setByte2(byte2));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps_ptr< ::std::map< int32_t , PArrayInt > > BStub_RemoteMapTypes::getInt2()  {
	BSyncResultT< byps_ptr< ::std::map< int32_t , PArrayInt > > > syncResult;	
	getInt2([&syncResult](byps_ptr< ::std::map< int32_t , PArrayInt > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getInt2(::std::function< void (byps_ptr< ::std::map< int32_t , PArrayInt > >, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_getInt2());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< ::std::map< int32_t , PArrayInt > >, byps::test::api::BResult_1633750383 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteMapTypes::setInt2(const byps_ptr< ::std::map< int32_t , PArrayInt > >& int2)  {
	BSyncResultT< bool > syncResult;	
	setInt2(int2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setInt2(const byps_ptr< ::std::map< int32_t , PArrayInt > >& int2, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_setInt2(int2));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PMapStringObject BStub_RemoteMapTypes::getObj1()  {
	BSyncResultT< byps::PMapStringObject > syncResult;	
	getObj1([&syncResult](byps::PMapStringObject v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getObj1(::std::function< void (byps::PMapStringObject, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_getObj1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PMapStringObject, byps::test::api::BResult_1488550492 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteMapTypes::setObj1(const byps::PMapStringObject& obj1)  {
	BSyncResultT< bool > syncResult;	
	setObj1(obj1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setObj1(const byps::PMapStringObject& obj1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_setObj1(obj1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PMapStringDate BStub_RemoteMapTypes::getDate1()  {
	BSyncResultT< byps::PMapStringDate > syncResult;	
	getDate1([&syncResult](byps::PMapStringDate v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteMapTypes::getDate1(::std::function< void (byps::PMapStringDate, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_getDate1());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PMapStringDate, byps::test::api::BResult_1366799209 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteMapTypes::setDate1(const byps::PMapStringDate& obj1)  {
	BSyncResultT< bool > syncResult;	
	setDate1(obj1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setDate1(const byps::PMapStringDate& obj1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteMapTypes_setDate1(obj1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
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

