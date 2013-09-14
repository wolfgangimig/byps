#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;


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

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:223
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
		com::wilutions::byps::test::api::remote::RemoteEnums* r = dynamic_cast<com::wilutions::byps::test::api::remote::RemoteEnums*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteInlineInstance::BStub_RemoteInlineInstance(PTransport transport) 
	: BStub(transport) {}

void BStub_RemoteInlineInstance::setActor(com::wilutions::byps::test::api::inl::PActor act)  {
	BSyncResultT< bool > syncResult;	
	setActor(act, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteInlineInstance::setActor(com::wilutions::byps::test::api::inl::PActor act, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteInlineInstance::setPoint2DArray1dim(byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > pointArray)  {
	BSyncResultT< bool > syncResult;	
	setPoint2DArray1dim(pointArray, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteInlineInstance::setPoint2DArray1dim(byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > pointArray, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteInlineInstance::setPoint2DArray4dim(byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > > pointArray)  {
	BSyncResultT< bool > syncResult;	
	setPoint2DArray4dim(pointArray, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteInlineInstance::setPoint2DArray4dim(byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > > pointArray, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteInlineInstance::setPoint2DList(byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > pointList)  {
	BSyncResultT< bool > syncResult;	
	setPoint2DList(pointList, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteInlineInstance::setPoint2DList(byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > pointList, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteInlineInstance::setPoint2DListList(byps_ptr< ::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > > > pointListList)  {
	BSyncResultT< bool > syncResult;	
	setPoint2DListList(pointListList, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteInlineInstance::setPoint2DListList(byps_ptr< ::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > > > pointListList, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteInlineInstance::setPoint2DMap(byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D > > pointMap)  {
	BSyncResultT< bool > syncResult;	
	setPoint2DMap(pointMap, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteInlineInstance::setPoint2DMap(byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D > > pointMap, ::std::function< void (bool, BException ex) > asyncResult)  {
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

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:223
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
		com::wilutions::byps::test::api::remote::RemoteInlineInstance* r = dynamic_cast<com::wilutions::byps::test::api::remote::RemoteInlineInstance*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

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
void BStub_RemoteListTypes::setBoolean1(byps_ptr< ::std::vector< bool > > boolean1)  {
	BSyncResultT< bool > syncResult;	
	setBoolean1(boolean1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setBoolean1(byps_ptr< ::std::vector< bool > > boolean1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteListTypes::setByte1(byps_ptr< ::std::vector< int8_t > > byte1)  {
	BSyncResultT< bool > syncResult;	
	setByte1(byte1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setByte1(byps_ptr< ::std::vector< int8_t > > byte1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteListTypes::setChar1(byps_ptr< ::std::vector< wchar_t > > char1)  {
	BSyncResultT< bool > syncResult;	
	setChar1(char1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setChar1(byps_ptr< ::std::vector< wchar_t > > char1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteListTypes::setShort1(byps_ptr< ::std::vector< int16_t > > short1)  {
	BSyncResultT< bool > syncResult;	
	setShort1(short1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setShort1(byps_ptr< ::std::vector< int16_t > > short1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteListTypes::setInt1(byps_ptr< ::std::vector< int32_t > > int1)  {
	BSyncResultT< bool > syncResult;	
	setInt1(int1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setInt1(byps_ptr< ::std::vector< int32_t > > int1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteListTypes::setLong1(byps_ptr< ::std::vector< int64_t > > long1)  {
	BSyncResultT< bool > syncResult;	
	setLong1(long1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setLong1(byps_ptr< ::std::vector< int64_t > > long1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteListTypes::setFloat1(byps_ptr< ::std::vector< float > > float1)  {
	BSyncResultT< bool > syncResult;	
	setFloat1(float1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setFloat1(byps_ptr< ::std::vector< float > > float1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteListTypes::setDouble1(byps_ptr< ::std::vector< double > > double1)  {
	BSyncResultT< bool > syncResult;	
	setDouble1(double1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setDouble1(byps_ptr< ::std::vector< double > > double1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteListTypes::setString1(byps_ptr< ::std::vector< ::std::wstring > > string1)  {
	BSyncResultT< bool > syncResult;	
	setString1(string1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setString1(byps_ptr< ::std::vector< ::std::wstring > > string1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteListTypes::setPrimitiveTypes1(byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > primitiveTypes1)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes1(primitiveTypes1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setPrimitiveTypes1(byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > primitiveTypes1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteListTypes::setByte2(byps_ptr< ::std::vector< PBytes > > byte2)  {
	BSyncResultT< bool > syncResult;	
	setByte2(byte2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setByte2(byps_ptr< ::std::vector< PBytes > > byte2, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteListTypes::setInt2(byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > > int2)  {
	BSyncResultT< bool > syncResult;	
	setInt2(int2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setInt2(byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > > int2, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteListTypes::setObj1(byps_ptr< ::std::vector< PSerializable > > obj1)  {
	BSyncResultT< bool > syncResult;	
	setObj1(obj1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setObj1(byps_ptr< ::std::vector< PSerializable > > obj1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteListTypes::setInt3(byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > > int3)  {
	BSyncResultT< bool > syncResult;	
	setInt3(int3, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setInt3(byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > > int3, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteListTypes::setInt4(byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > > int4)  {
	BSyncResultT< bool > syncResult;	
	setInt4(int4, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteListTypes::setInt4(byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > > int4, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteListTypes_setInt4(int4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:223
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
void BStub_RemoteMapTypes::setBoolean1(byps_ptr< ::std::map< ::std::wstring , bool > > boolean1)  {
	BSyncResultT< bool > syncResult;	
	setBoolean1(boolean1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setBoolean1(byps_ptr< ::std::map< ::std::wstring , bool > > boolean1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteMapTypes::setByte1(byps_ptr< ::std::map< double , int8_t > > byte1)  {
	BSyncResultT< bool > syncResult;	
	setByte1(byte1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setByte1(byps_ptr< ::std::map< double , int8_t > > byte1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteMapTypes::setChar1(byps_ptr< ::std::map< float , wchar_t > > char1)  {
	BSyncResultT< bool > syncResult;	
	setChar1(char1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setChar1(byps_ptr< ::std::map< float , wchar_t > > char1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteMapTypes::setShort1(byps_ptr< ::std::map< int64_t , int16_t > > short1)  {
	BSyncResultT< bool > syncResult;	
	setShort1(short1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setShort1(byps_ptr< ::std::map< int64_t , int16_t > > short1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteMapTypes::setInt1(byps_ptr< ::std::map< int32_t , int32_t > > int1)  {
	BSyncResultT< bool > syncResult;	
	setInt1(int1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setInt1(byps_ptr< ::std::map< int32_t , int32_t > > int1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteMapTypes::setLong1(byps_ptr< ::std::map< int16_t , int64_t > > long1)  {
	BSyncResultT< bool > syncResult;	
	setLong1(long1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setLong1(byps_ptr< ::std::map< int16_t , int64_t > > long1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteMapTypes::setFloat1(byps_ptr< ::std::map< wchar_t , float > > float1)  {
	BSyncResultT< bool > syncResult;	
	setFloat1(float1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setFloat1(byps_ptr< ::std::map< wchar_t , float > > float1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteMapTypes::setDouble1(byps_ptr< ::std::map< int8_t , double > > double1)  {
	BSyncResultT< bool > syncResult;	
	setDouble1(double1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setDouble1(byps_ptr< ::std::map< int8_t , double > > double1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteMapTypes::setString1(byps_ptr< ::std::map< ::std::wstring , ::std::wstring > > string1)  {
	BSyncResultT< bool > syncResult;	
	setString1(string1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setString1(byps_ptr< ::std::map< ::std::wstring , ::std::wstring > > string1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteMapTypes::setPrimitiveTypes1(byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > > primitiveTypes1)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes1(primitiveTypes1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setPrimitiveTypes1(byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > > primitiveTypes1, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteMapTypes::setByte2(byps_ptr< ::std::map< int32_t , PBytes > > byte2)  {
	BSyncResultT< bool > syncResult;	
	setByte2(byte2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setByte2(byps_ptr< ::std::map< int32_t , PBytes > > byte2, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteMapTypes::setInt2(byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > > int2)  {
	BSyncResultT< bool > syncResult;	
	setInt2(int2, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setInt2(byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > > int2, ::std::function< void (bool, BException ex) > asyncResult)  {
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
void BStub_RemoteMapTypes::setObj1(byps_ptr< ::std::map< ::std::wstring , PSerializable > > obj1)  {
	BSyncResultT< bool > syncResult;	
	setObj1(obj1, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteMapTypes::setObj1(byps_ptr< ::std::map< ::std::wstring , PSerializable > > obj1, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteMapTypes_setObj1(obj1));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, com::wilutions::byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenRemoteStub:223
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
