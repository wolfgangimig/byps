﻿#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1097919350(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::set< BDateTime >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_8789515(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::map< float , wchar_t >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_476459792(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::map< int32_t , PContentStream >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_936607009(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::set< wchar_t >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_855786668(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::std::set< int32_t >>(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1097129250(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< int64_t > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_846419204(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray4< int64_t > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_2067161310(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray1< int16_t > >(bio, pObj, pObjS, pBase);	
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:933
namespace byps { namespace test { namespace api { 
void BSerializer_1859644668(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* pBase) {
	BSerializer_Obj_Template<::byps::BArray4< int16_t > >(bio, pObj, pObjS, pBase);	
}
}}}


namespace byps { namespace test { namespace api { namespace inherit { 
BStub_PlantService::BStub_PlantService(PTransport transport) 
	: BStub(transport) {}
}}}}

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::inherit::BStub_PlantService::BSerializable_getTypeId() {
	return 1954605928; 
}
namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_PlantService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_PlantService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_1954605928(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved){
	BSerializer_16_Template<byps::test::api::inherit::BStub_PlantService, 1954605928>(bio, pObj, pObjS, reserved);
}
}}}



namespace byps { namespace test { namespace api { namespace inherit { 
BStub_FruitService::BStub_FruitService(PTransport transport) 
	: BStub(transport) {}
}}}}

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::inherit::BStub_FruitService::BSerializable_getTypeId() {
	return 715959905; 
}
namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_FruitService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_FruitService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_FruitService::squeeze()  {
	BSyncResultT< ::std::wstring > syncResult;	
	squeeze([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_FruitService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_FruitService_squeeze());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_715959905(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved){
	BSerializer_16_Template<byps::test::api::inherit::BStub_FruitService, 715959905>(bio, pObj, pObjS, reserved);
}
}}}



namespace byps { namespace test { namespace api { namespace inherit { 
BStub_BioFruitService::BStub_BioFruitService(PTransport transport) 
	: BStub(transport) {}
}}}}

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::inherit::BStub_BioFruitService::BSerializable_getTypeId() {
	return 363642571; 
}
namespace byps { namespace test { namespace api { namespace inherit { 
bool BStub_BioFruitService::certify(const ::std::wstring& param)  {
	BSyncResultT< bool > syncResult;	
	certify(param, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioFruitService::certify(const ::std::wstring& param, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_BioFruitService_certify(param));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_1 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_BioFruitService::squeeze()  {
	BSyncResultT< ::std::wstring > syncResult;	
	squeeze([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioFruitService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_FruitService_squeeze());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_BioFruitService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioFruitService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_363642571(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved){
	BSerializer_16_Template<byps::test::api::inherit::BStub_BioFruitService, 363642571>(bio, pObj, pObjS, reserved);
}
}}}



namespace byps { namespace test { namespace api { namespace inherit { 
BStub_LemonService::BStub_LemonService(PTransport transport) 
	: BStub(transport) {}
}}}}

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::inherit::BStub_LemonService::BSerializable_getTypeId() {
	return 605543968; 
}
namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_LemonService::squeeze()  {
	BSyncResultT< ::std::wstring > syncResult;	
	squeeze([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_LemonService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_FruitService_squeeze());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_LemonService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_LemonService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_LemonService::pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree)  {
	BSyncResultT< ::std::wstring > syncResult;	
	pick(sess, fromTree, [&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_LemonService::pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree, ::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_LemonService_pick(sess, fromTree));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_605543968(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved){
	BSerializer_16_Template<byps::test::api::inherit::BStub_LemonService, 605543968>(bio, pObj, pObjS, reserved);
}
}}}



namespace byps { namespace test { namespace api { namespace inherit { 
BStub_BioLemonService::BStub_BioLemonService(PTransport transport) 
	: BStub(transport) {}
}}}}

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::inherit::BStub_BioLemonService::BSerializable_getTypeId() {
	return 474058508; 
}
namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_BioLemonService::squeeze()  {
	BSyncResultT< ::std::wstring > syncResult;	
	squeeze([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_FruitService_squeeze());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_BioLemonService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
int32_t BStub_BioLemonService::useParing()  {
	BSyncResultT< int32_t > syncResult;	
	useParing([&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::useParing(::std::function< void (int32_t, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_BioLemonService_useParing());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, byps::test::api::BResult_5 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
::std::wstring BStub_BioLemonService::pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree)  {
	BSyncResultT< ::std::wstring > syncResult;	
	pick(sess, fromTree, [&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree, ::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_LemonService_pick(sess, fromTree));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace inherit { 
bool BStub_BioLemonService::certify(const ::std::wstring& param)  {
	BSyncResultT< bool > syncResult;	
	certify(param, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::certify(const ::std::wstring& param, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_BioFruitService_certify(param));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_1 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_474058508(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved){
	BSerializer_16_Template<byps::test::api::inherit::BStub_BioLemonService, 474058508>(bio, pObj, pObjS, reserved);
}
}}}



namespace byps { namespace test { namespace api { namespace remote { 
BStub_RemoteArrayTypes1dim::BStub_RemoteArrayTypes1dim(PTransport transport) 
	: BStub(transport) {}
}}}}

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BStub_RemoteArrayTypes1dim::BSerializable_getTypeId() {
	return 123123; 
}
namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes1dim::setBool(const PArrayBoolean& v)  {
	BSyncResultT< bool > syncResult;	
	setBool(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setBool(const PArrayBoolean& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setBool(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes1dim::setByte(const PBytes& v)  {
	BSyncResultT< bool > syncResult;	
	setByte(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setByte(const PBytes& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setByte(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes1dim::setChar(const PArrayChar& v)  {
	BSyncResultT< bool > syncResult;	
	setChar(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setChar(const PArrayChar& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setChar(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes1dim::setShort(const PArrayShort& v)  {
	BSyncResultT< bool > syncResult;	
	setShort(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setShort(const PArrayShort& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setShort(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes1dim::setInt(const PArrayInt& v)  {
	BSyncResultT< bool > syncResult;	
	setInt(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setInt(const PArrayInt& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setInt(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes1dim::setLong(const PArrayLong& v)  {
	BSyncResultT< bool > syncResult;	
	setLong(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setLong(const PArrayLong& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setLong(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes1dim::setFloat(const PArrayFloat& v)  {
	BSyncResultT< bool > syncResult;	
	setFloat(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setFloat(const PArrayFloat& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setFloat(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes1dim::setDouble(const PArrayDouble& v)  {
	BSyncResultT< bool > syncResult;	
	setDouble(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setDouble(const PArrayDouble& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setDouble(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes1dim::setString(const PArrayString& v)  {
	BSyncResultT< bool > syncResult;	
	setString(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setString(const PArrayString& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setString(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes1dim::setPrimitiveTypes(const byps::test::api::prim::PArrayPrimitiveTypes& v)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setPrimitiveTypes(const byps::test::api::prim::PArrayPrimitiveTypes& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setPrimitiveTypes(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes1dim::setObject(const byps::PArrayObject& v)  {
	BSyncResultT< bool > syncResult;	
	setObject(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setObject(const byps::PArrayObject& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setObject(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes1dim::setDate(const PArrayDate& v)  {
	BSyncResultT< bool > syncResult;	
	setDate(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setDate(const PArrayDate& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_setDate(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArrayBoolean BStub_RemoteArrayTypes1dim::getBool()  {
	BSyncResultT< PArrayBoolean > syncResult;	
	getBool([&syncResult](PArrayBoolean v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getBool(::std::function< void (PArrayBoolean, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getBool());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArrayBoolean, byps::test::api::BResult_2058423690 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PBytes BStub_RemoteArrayTypes1dim::getByte()  {
	BSyncResultT< PBytes > syncResult;	
	getByte([&syncResult](PBytes v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getByte(::std::function< void (PBytes, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getByte());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PBytes, byps::test::api::BResult_1374008726 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArrayChar BStub_RemoteArrayTypes1dim::getChar()  {
	BSyncResultT< PArrayChar > syncResult;	
	getChar([&syncResult](PArrayChar v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getChar(::std::function< void (PArrayChar, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getChar());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArrayChar, byps::test::api::BResult_1361632968 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArrayShort BStub_RemoteArrayTypes1dim::getShort()  {
	BSyncResultT< PArrayShort > syncResult;	
	getShort([&syncResult](PArrayShort v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getShort(::std::function< void (PArrayShort, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getShort());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArrayShort, byps::test::api::BResult_2067161310 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArrayInt BStub_RemoteArrayTypes1dim::getInt()  {
	BSyncResultT< PArrayInt > syncResult;	
	getInt([&syncResult](PArrayInt v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getInt(::std::function< void (PArrayInt, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getInt());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArrayInt, byps::test::api::BResult_100361105 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArrayLong BStub_RemoteArrayTypes1dim::getLong()  {
	BSyncResultT< PArrayLong > syncResult;	
	getLong([&syncResult](PArrayLong v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getLong(::std::function< void (PArrayLong, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getLong());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArrayLong, byps::test::api::BResult_1097129250 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArrayFloat BStub_RemoteArrayTypes1dim::getFloat()  {
	BSyncResultT< PArrayFloat > syncResult;	
	getFloat([&syncResult](PArrayFloat v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getFloat(::std::function< void (PArrayFloat, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getFloat());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArrayFloat, byps::test::api::BResult_766441794 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArrayDouble BStub_RemoteArrayTypes1dim::getDouble()  {
	BSyncResultT< PArrayDouble > syncResult;	
	getDouble([&syncResult](PArrayDouble v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getDouble(::std::function< void (PArrayDouble, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getDouble());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArrayDouble, byps::test::api::BResult_1359468275 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArrayString BStub_RemoteArrayTypes1dim::getString()  {
	BSyncResultT< PArrayString > syncResult;	
	getString([&syncResult](PArrayString v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getString(::std::function< void (PArrayString, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getString());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArrayString, byps::test::api::BResult_1888107655 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::test::api::prim::PArrayPrimitiveTypes BStub_RemoteArrayTypes1dim::getPrimitiveTypes()  {
	BSyncResultT< byps::test::api::prim::PArrayPrimitiveTypes > syncResult;	
	getPrimitiveTypes([&syncResult](byps::test::api::prim::PArrayPrimitiveTypes v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getPrimitiveTypes(::std::function< void (byps::test::api::prim::PArrayPrimitiveTypes, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getPrimitiveTypes());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::test::api::prim::PArrayPrimitiveTypes, byps::test::api::BResult_2053507648 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PArrayObject BStub_RemoteArrayTypes1dim::getObject()  {
	BSyncResultT< byps::PArrayObject > syncResult;	
	getObject([&syncResult](byps::PArrayObject v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getObject(::std::function< void (byps::PArrayObject, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getObject());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PArrayObject, byps::test::api::BResult_183594037 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArrayDate BStub_RemoteArrayTypes1dim::getDate()  {
	BSyncResultT< PArrayDate > syncResult;	
	getDate([&syncResult](PArrayDate v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getDate(::std::function< void (PArrayDate, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes1dim_getDate());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArrayDate, byps::test::api::BResult_1406664368 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_123123(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved){
	BSerializer_16_Template<byps::test::api::remote::BStub_RemoteArrayTypes1dim, 123123>(bio, pObj, pObjS, reserved);
}
}}}



namespace byps { namespace test { namespace api { namespace remote { 
BStub_RemoteArrayTypes23::BStub_RemoteArrayTypes23(PTransport transport) 
	: BStub(transport) {}
}}}}

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BStub_RemoteArrayTypes23::BSerializable_getTypeId() {
	return 769717182; 
}
namespace byps { namespace test { namespace api { namespace remote { 
PArrayInt BStub_RemoteArrayTypes23::sendArraysInt(const PArray2Int& arr2, const PArray3Int& arr3, const PArray4Int& arr4)  {
	BSyncResultT< PArrayInt > syncResult;	
	sendArraysInt(arr2, arr3, arr4, [&syncResult](PArrayInt v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysInt(const PArray2Int& arr2, const PArray3Int& arr3, const PArray4Int& arr4, ::std::function< void (PArrayInt, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes23_sendArraysInt(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArrayInt, byps::test::api::BResult_100361105 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
PArrayString BStub_RemoteArrayTypes23::sendArraysString(const PArray2String& arr2, const PArray3String& arr3, const PArray4String& arr4)  {
	BSyncResultT< PArrayString > syncResult;	
	sendArraysString(arr2, arr3, arr4, [&syncResult](PArrayString v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysString(const PArray2String& arr2, const PArray3String& arr3, const PArray4String& arr4, ::std::function< void (PArrayString, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes23_sendArraysString(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PArrayString, byps::test::api::BResult_1888107655 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::test::api::prim::PArrayPrimitiveTypes BStub_RemoteArrayTypes23::sendArraysClass(const byps::test::api::prim::PArray2PrimitiveTypes& arr2, const byps::test::api::prim::PArray3PrimitiveTypes& arr3, const byps::test::api::prim::PArray4PrimitiveTypes& arr4)  {
	BSyncResultT< byps::test::api::prim::PArrayPrimitiveTypes > syncResult;	
	sendArraysClass(arr2, arr3, arr4, [&syncResult](byps::test::api::prim::PArrayPrimitiveTypes v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysClass(const byps::test::api::prim::PArray2PrimitiveTypes& arr2, const byps::test::api::prim::PArray3PrimitiveTypes& arr3, const byps::test::api::prim::PArray4PrimitiveTypes& arr4, ::std::function< void (byps::test::api::prim::PArrayPrimitiveTypes, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes23_sendArraysClass(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::test::api::prim::PArrayPrimitiveTypes, byps::test::api::BResult_2053507648 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::PArrayObject BStub_RemoteArrayTypes23::sendArraysObject(const byps::PArray2Object& arr2, const byps::PArray3Object& arr3, const byps::PArray4Object& arr4)  {
	BSyncResultT< byps::PArrayObject > syncResult;	
	sendArraysObject(arr2, arr3, arr4, [&syncResult](byps::PArrayObject v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysObject(const byps::PArray2Object& arr2, const byps::PArray3Object& arr3, const byps::PArray4Object& arr4, ::std::function< void (byps::PArrayObject, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes23_sendArraysObject(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::PArrayObject, byps::test::api::BResult_183594037 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
byps::test::api::inl::PArrayPoint2D BStub_RemoteArrayTypes23::sendArraysInline(const byps::test::api::inl::PArray2Point2D& arr2, const byps::test::api::inl::PArray3Point2D& arr3, const byps::test::api::inl::PArray4Point2D& arr4)  {
	BSyncResultT< byps::test::api::inl::PArrayPoint2D > syncResult;	
	sendArraysInline(arr2, arr3, arr4, [&syncResult](byps::test::api::inl::PArrayPoint2D v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysInline(const byps::test::api::inl::PArray2Point2D& arr2, const byps::test::api::inl::PArray3Point2D& arr3, const byps::test::api::inl::PArray4Point2D& arr4, ::std::function< void (byps::test::api::inl::PArrayPoint2D, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes23_sendArraysInline(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps::test::api::inl::PArrayPoint2D, byps::test::api::BResult_184101377 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:224
namespace byps { namespace test { namespace api { 
void BSerializer_769717182(BIO& bio, POBJECT& pObj, PSerializable& pObjS, void* reserved){
	BSerializer_16_Template<byps::test::api::remote::BStub_RemoteArrayTypes23, 769717182>(bio, pObj, pObjS, reserved);
}
}}}



namespace byps { namespace test { namespace api { namespace remote { 
BStub_RemoteArrayTypes4dim::BStub_RemoteArrayTypes4dim(PTransport transport) 
	: BStub(transport) {}
}}}}

// checkpoint byps.gen.cpp.PrintContext:496
BTYPEID byps::test::api::remote::BStub_RemoteArrayTypes4dim::BSerializable_getTypeId() {
	return 963726955; 
}
namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes4dim::setBool(const PArray4Boolean& v)  {
	BSyncResultT< bool > syncResult;	
	setBool(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setBool(const PArray4Boolean& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setBool(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes4dim::setByte(const PArray4Byte& v)  {
	BSyncResultT< bool > syncResult;	
	setByte(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setByte(const PArray4Byte& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setByte(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

namespace byps { namespace test { namespace api { namespace remote { 
void BStub_RemoteArrayTypes4dim::setChar(const PArray4Char& v)  {
	BSyncResultT< bool > syncResult;	
	setChar(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::setChar(const PArray4Char& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PMethodRequest req(new BRequest_RemoteArrayTypes4dim_setChar(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->sendMethod(req, outerResult);
}
}}}}

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

