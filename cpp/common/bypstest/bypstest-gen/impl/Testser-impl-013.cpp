#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes4dim::setShort(const PArray4Short& v)  {
	BSyncResultT< bool > syncResult;	
	setShort(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setShort(const PArray4Short& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setShort(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes4dim::setInt(const PArray4Int& v)  {
	BSyncResultT< bool > syncResult;	
	setInt(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setInt(const PArray4Int& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setInt(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes4dim::setLong(const PArray4Long& v)  {
	BSyncResultT< bool > syncResult;	
	setLong(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setLong(const PArray4Long& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setLong(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes4dim::setFloat(const PArray4Float& v)  {
	BSyncResultT< bool > syncResult;	
	setFloat(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setFloat(const PArray4Float& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setFloat(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes4dim::setDouble(const PArray4Double& v)  {
	BSyncResultT< bool > syncResult;	
	setDouble(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setDouble(const PArray4Double& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setDouble(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes4dim::setString(const PArray4String& v)  {
	BSyncResultT< bool > syncResult;	
	setString(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setString(const PArray4String& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setString(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes4dim::setPrimitiveTypes(const byps::test::api::prim::PArray4PrimitiveTypes& v)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setPrimitiveTypes(const byps::test::api::prim::PArray4PrimitiveTypes& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setPrimitiveTypes(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes4dim::setObject(const byps::PArray4Object& v)  {
	BSyncResultT< bool > syncResult;	
	setObject(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setObject(const byps::PArray4Object& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setObject(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes4dim::setDate(const PArray4Date& v)  {
	BSyncResultT< bool > syncResult;	
	setDate(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setDate(const PArray4Date& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setDate(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArray4Boolean BStub_RemoteArrayTypes4dim::getBool()  {
	BSyncResultT< PArray4Boolean > syncResult;	
	getBool([&syncResult](PArray4Boolean v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getBool(::std::function< void (PArray4Boolean, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getBool());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArray4Boolean, byps::test::api::BResult_945713488 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArray4Byte BStub_RemoteArrayTypes4dim::getByte()  {
	BSyncResultT< PArray4Byte > syncResult;	
	getByte([&syncResult](PArray4Byte v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getByte(::std::function< void (PArray4Byte, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getByte());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArray4Byte, byps::test::api::BResult_1201775504 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArray4Char BStub_RemoteArrayTypes4dim::getChar()  {
	BSyncResultT< PArray4Char > syncResult;	
	getChar([&syncResult](PArray4Char v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getChar(::std::function< void (PArray4Char, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getChar());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArray4Char, byps::test::api::BResult_769021986 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArray4Short BStub_RemoteArrayTypes4dim::getShort()  {
	BSyncResultT< PArray4Short > syncResult;	
	getShort([&syncResult](PArray4Short v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getShort(::std::function< void (PArray4Short, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getShort());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArray4Short, byps::test::api::BResult_1859644668 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArray4Int BStub_RemoteArrayTypes4dim::getInt()  {
	BSyncResultT< PArray4Int > syncResult;	
	getInt([&syncResult](PArray4Int v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getInt(::std::function< void (PArray4Int, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getInt());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArray4Int, byps::test::api::BResult_39910537 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArray4Long BStub_RemoteArrayTypes4dim::getLong()  {
	BSyncResultT< PArray4Long > syncResult;	
	getLong([&syncResult](PArray4Long v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getLong(::std::function< void (PArray4Long, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getLong());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArray4Long, byps::test::api::BResult_846419204 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArray4Float BStub_RemoteArrayTypes4dim::getFloat()  {
	BSyncResultT< PArray4Float > syncResult;	
	getFloat([&syncResult](PArray4Float v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getFloat(::std::function< void (PArray4Float, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getFloat());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArray4Float, byps::test::api::BResult_1516687588 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArray4Double BStub_RemoteArrayTypes4dim::getDouble()  {
	BSyncResultT< PArray4Double > syncResult;	
	getDouble([&syncResult](PArray4Double v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getDouble(::std::function< void (PArray4Double, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getDouble());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArray4Double, byps::test::api::BResult_2087445849 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArray4String BStub_RemoteArrayTypes4dim::getString()  {
	BSyncResultT< PArray4String > syncResult;	
	getString([&syncResult](PArray4String v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getString(::std::function< void (PArray4String, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getString());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArray4String, byps::test::api::BResult_588723219 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::test::api::prim::PArray4PrimitiveTypes BStub_RemoteArrayTypes4dim::getPrimitiveTypes()  {
	BSyncResultT< byps::test::api::prim::PArray4PrimitiveTypes > syncResult;	
	getPrimitiveTypes([&syncResult](byps::test::api::prim::PArray4PrimitiveTypes v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getPrimitiveTypes(::std::function< void (byps::test::api::prim::PArray4PrimitiveTypes, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getPrimitiveTypes());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::test::api::prim::PArray4PrimitiveTypes, byps::test::api::BResult_758319514 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PArray4Object BStub_RemoteArrayTypes4dim::getObject()  {
	BSyncResultT< byps::PArray4Object > syncResult;	
	getObject([&syncResult](byps::PArray4Object v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getObject(::std::function< void (byps::PArray4Object, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getObject());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PArray4Object, byps::test::api::BResult_124584219 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArray4Date BStub_RemoteArrayTypes4dim::getDate()  {
	BSyncResultT< PArray4Date > syncResult;	
	getDate([&syncResult](PArray4Date v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::getDate(::std::function< void (PArray4Date, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_getDate());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArray4Date, byps::test::api::BResult_51898890 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_963726955(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved){
	BSerializer_16_Template<byps::test::api::remote::BStub_RemoteArrayTypes4dim, 963726955>(bio, pObj, pObjS, reserved);
}
}}}



namespace byps { namespace test { namespace api { namespace remote { 
BStub_RemoteConstants::BStub_RemoteConstants(PTransport transport) 
	: BStub(transport) {}
}}}}

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BStub_RemoteConstants::BSerializable_getTypeId() {
	return 2045242510; 
}
namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteConstants::compare_HebrewC(const byps::test::api::cons::PHebrewZ& ALEPH, const byps::test::api::cons::PHebrewZ& BETH)  {
	BSyncResultT< bool > syncResult;	
	compare_HebrewC(ALEPH, BETH, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteConstants::compare_HebrewC(const byps::test::api::cons::PHebrewZ& ALEPH, const byps::test::api::cons::PHebrewZ& BETH, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteConstants_compare_HebrewC(ALEPH, BETH));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
bool BStub_RemoteConstants::compare_AllTypesC(bool bool1s, bool bool2s, wchar_t char1s, const ::std::wstring& stringNull, wchar_t char2s, int16_t short1s, int32_t int1s, int64_t long1s, float float1s, double double1s, const ::std::wstring& string1s, const byps::test::api::cons::PAllTypesZ& ALL, const PArrayInt& arrInt, const PArray4Int& arrInt4, const PArrayString& arrStrings, const PArray4String& arrStrings4, const byps::test::api::cons::PArray2AllTypesZ& arrAll)  {
	BSyncResultT< bool > syncResult;	
	compare_AllTypesC(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteConstants::compare_AllTypesC(bool bool1s, bool bool2s, wchar_t char1s, const ::std::wstring& stringNull, wchar_t char2s, int16_t short1s, int32_t int1s, int64_t long1s, float float1s, double double1s, const ::std::wstring& string1s, const byps::test::api::cons::PAllTypesZ& ALL, const PArrayInt& arrInt, const PArray4Int& arrInt4, const PArrayString& arrStrings, const PArray4String& arrStrings4, const byps::test::api::cons::PArray2AllTypesZ& arrAll, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteConstants_compare_AllTypesC(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_1 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_2045242510(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved){
	BSerializer_16_Template<byps::test::api::remote::BStub_RemoteConstants, 2045242510>(bio, pObj, pObjS, reserved);
}
}}}



namespace byps { namespace test { namespace api { namespace remote { 
BStub_RemoteEnums::BStub_RemoteEnums(PTransport transport) 
	: BStub(transport) {}
}}}}

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BStub_RemoteEnums::BSerializable_getTypeId() {
	return 485761455; 
}
namespace byps { namespace test { namespace api { namespace remote { 
byps::test::api::enu::EnumPlanets BStub_RemoteEnums::getPlanet()  {
	BSyncResultT< byps::test::api::enu::EnumPlanets > syncResult;	
	getPlanet([&syncResult](byps::test::api::enu::EnumPlanets v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteEnums::getPlanet(::std::function< void (byps::test::api::enu::EnumPlanets, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteEnums_getPlanet());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::test::api::enu::EnumPlanets, byps::test::api::BResult_1375035164 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteEnums::setPlanet(byps::test::api::enu::EnumPlanets planet)  {
	BSyncResultT< bool > syncResult;	
	setPlanet(planet, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteEnums::setPlanet(byps::test::api::enu::EnumPlanets planet, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteEnums_setPlanet(planet));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_485761455(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved){
	BSerializer_16_Template<byps::test::api::remote::BStub_RemoteEnums, 485761455>(bio, pObj, pObjS, reserved);
}
}}}



namespace byps { namespace test { namespace api { namespace remote { 
BStub_RemoteInlineInstance::BStub_RemoteInlineInstance(PTransport transport) 
	: BStub(transport) {}
}}}}

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BStub_RemoteInlineInstance::BSerializable_getTypeId() {
	return 567395951; 
}
namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteInlineInstance::setActor(const byps::test::api::inl::PActor& act)  {
	BSyncResultT< bool > syncResult;	
	setActor(act, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteInlineInstance::setActor(const byps::test::api::inl::PActor& act, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteInlineInstance_setActor(act));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::test::api::inl::PActor BStub_RemoteInlineInstance::getActor()  {
	BSyncResultT< byps::test::api::inl::PActor > syncResult;	
	getActor([&syncResult](byps::test::api::inl::PActor v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteInlineInstance::getActor(::std::function< void (byps::test::api::inl::PActor, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteInlineInstance_getActor());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::test::api::inl::PActor, byps::test::api::BResult_171948703 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteInlineInstance::setPoint2DArray1dim(const byps::test::api::inl::PArrayPoint2D& pointArray)  {
	BSyncResultT< bool > syncResult;	
	setPoint2DArray1dim(pointArray, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteInlineInstance::setPoint2DArray1dim(const byps::test::api::inl::PArrayPoint2D& pointArray, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteInlineInstance_setPoint2DArray1dim(pointArray));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::test::api::inl::PArrayPoint2D BStub_RemoteInlineInstance::getPoint2DArray1dim()  {
	BSyncResultT< byps::test::api::inl::PArrayPoint2D > syncResult;	
	getPoint2DArray1dim([&syncResult](byps::test::api::inl::PArrayPoint2D v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteInlineInstance::getPoint2DArray1dim(::std::function< void (byps::test::api::inl::PArrayPoint2D, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteInlineInstance_getPoint2DArray1dim());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::test::api::inl::PArrayPoint2D, byps::test::api::BResult_184101377 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteInlineInstance::setPoint2DArray4dim(const byps::test::api::inl::PArray4Point2D& pointArray)  {
	BSyncResultT< bool > syncResult;	
	setPoint2DArray4dim(pointArray, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteInlineInstance::setPoint2DArray4dim(const byps::test::api::inl::PArray4Point2D& pointArray, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteInlineInstance_setPoint2DArray4dim(pointArray));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::test::api::inl::PArray4Point2D BStub_RemoteInlineInstance::getPoint2DArray4dim()  {
	BSyncResultT< byps::test::api::inl::PArray4Point2D > syncResult;	
	getPoint2DArray4dim([&syncResult](byps::test::api::inl::PArray4Point2D v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteInlineInstance::getPoint2DArray4dim(::std::function< void (byps::test::api::inl::PArray4Point2D, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteInlineInstance_getPoint2DArray4dim());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::test::api::inl::PArray4Point2D, byps::test::api::BResult_949340697 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

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
void BSerializer_567395951(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved){
	BSerializer_16_Template<byps::test::api::remote::BStub_RemoteInlineInstance, 567395951>(bio, pObj, pObjS, reserved);
}
}}}



namespace byps { namespace test { namespace api { namespace remote { 
BStub_RemoteListTypes::BStub_RemoteListTypes(PTransport transport) 
	: BStub(transport) {}
}}}}

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BStub_RemoteListTypes::BSerializable_getTypeId() {
	return 1233438138; 
}
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

