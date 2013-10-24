#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1633750383(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , byps_ptr< BArray1< int32_t > > >& r = * reinterpret_cast< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , byps_ptr< BArray1< int32_t > > >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_779528402(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , PContentStream >& r = * reinterpret_cast< ::std::map< int32_t , PContentStream >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , PContentStream >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1347703734(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , int32_t >& r = * reinterpret_cast< ::std::map< int32_t , int32_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , int32_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_132175071(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , byps_ptr< ::std::vector< ::std::wstring > > >& r = * reinterpret_cast< ::std::map< int32_t , byps_ptr< ::std::vector< ::std::wstring > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , byps_ptr< ::std::vector< ::std::wstring > > >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_49984088(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > >& r = * reinterpret_cast< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_601099730(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int64_t , int16_t >& r = * reinterpret_cast< ::std::map< int64_t , int16_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int64_t , int16_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1973996106(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int16_t , int64_t >& r = * reinterpret_cast< ::std::map< int16_t , int64_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int16_t , int64_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_493795497(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , byps::test::api::enu::EnumPlanets >& r = * reinterpret_cast< ::std::map< ::std::wstring , byps::test::api::enu::EnumPlanets >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , byps::test::api::enu::EnumPlanets >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_2058676657(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , byps::test::api::inherit::PClass1 >& r = * reinterpret_cast< ::std::map< ::std::wstring , byps::test::api::inherit::PClass1 >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , byps::test::api::inherit::PClass1 >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_2011881553(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , byps::test::api::refs::PNode >& r = * reinterpret_cast< ::std::map< ::std::wstring , byps::test::api::refs::PNode >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , byps::test::api::refs::PNode >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1279823631(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , bool >& r = * reinterpret_cast< ::std::map< ::std::wstring , bool >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , bool >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1488550492(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , PSerializable >& r = * reinterpret_cast< ::std::map< ::std::wstring , PSerializable >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , PSerializable >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1710660846(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , ::std::wstring >& r = * reinterpret_cast< ::std::map< ::std::wstring , ::std::wstring >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , ::std::wstring >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_484881308(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< byps::test::api::inherit::PClass1 >& r = * reinterpret_cast< ::std::set< byps::test::api::inherit::PClass1 >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< byps::test::api::inherit::PClass1 >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_673917574(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< byps::test::api::prim::PPrimitiveTypes >& r = * reinterpret_cast< ::std::set< byps::test::api::prim::PPrimitiveTypes >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< byps::test::api::prim::PPrimitiveTypes >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_2052431866(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< PBytes >& r = * reinterpret_cast< ::std::set< PBytes >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< PBytes >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1406124761(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< byps_ptr< BArray1< int32_t > > >& r = * reinterpret_cast< ::std::set< byps_ptr< BArray1< int32_t > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< byps_ptr< BArray1< int32_t > > >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1365696060(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< bool >& r = * reinterpret_cast< ::std::set< bool >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< bool >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1320560671(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< double >& r = * reinterpret_cast< ::std::set< double >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< double >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1898022288(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< float >& r = * reinterpret_cast< ::std::set< float >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< float >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1493282670(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int32_t >& r = * reinterpret_cast< ::std::set< int32_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int32_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1457164460(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int64_t >& r = * reinterpret_cast< ::std::set< int64_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int64_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_2028443792(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int16_t >& r = * reinterpret_cast< ::std::set< int16_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int16_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1888799711(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< ::std::wstring >& r = * reinterpret_cast< ::std::set< ::std::wstring >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< ::std::wstring >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_8789515(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< float , wchar_t >& r = * reinterpret_cast< ::std::map< float , wchar_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< float , wchar_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_476459792(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , PContentStream >& r = * reinterpret_cast< ::std::map< int32_t , PContentStream >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , PContentStream >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_936607009(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< wchar_t >& r = * reinterpret_cast< ::std::set< wchar_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< wchar_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_855786668(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int32_t >& r = * reinterpret_cast< ::std::set< int32_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int32_t >());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1097129250(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< int64_t > & r = * reinterpret_cast< BArray1< int64_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< int64_t > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_846419204(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< int64_t > & r = * reinterpret_cast< BArray4< int64_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< int64_t > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_2067161310(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< int16_t > & r = * reinterpret_cast< BArray1< int16_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< int16_t > ());
	}
}
}}}
// checkpoint byps.gen.cpp.GenApiClass:929
namespace byps { namespace test { namespace api { 
void BSerializer_1859644668(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< int16_t > & r = * reinterpret_cast< BArray4< int16_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< int16_t > ());
	}
}
}}}

namespace byps { namespace test { namespace api { namespace inherit { 

BStub_PlantService::BStub_PlantService(PTransport transport) 
	: BStub(transport) {}

::std::wstring BStub_PlantService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_PlantService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
namespace byps { namespace test { namespace api { 
void BSerializer_1954605928(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::inherit::BStub_PlantService(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}

namespace byps { namespace test { namespace api { namespace inherit { 

BStub_FruitService::BStub_FruitService(PTransport transport) 
	: BStub(transport) {}

::std::wstring BStub_FruitService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_FruitService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
::std::wstring BStub_FruitService::squeeze()  {
	BSyncResultT< ::std::wstring > syncResult;	
	squeeze([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_FruitService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_FruitService_squeeze());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
namespace byps { namespace test { namespace api { 
void BSerializer_715959905(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::inherit::BStub_FruitService(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}

namespace byps { namespace test { namespace api { namespace inherit { 

bool BSkeleton_BioFruitService::certify(const ::std::wstring& param)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_BioFruitService::certify(const ::std::wstring& param, ::std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = bool();
	try {
		ret = certify(param);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
::std::wstring BSkeleton_BioFruitService::grow()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_BioFruitService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	::std::wstring ret = ::std::wstring();
	try {
		ret = grow();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
::std::wstring BSkeleton_BioFruitService::squeeze()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_BioFruitService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	::std::wstring ret = ::std::wstring();
	try {
		ret = squeeze();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
}}}}


namespace byps { namespace test { namespace api { namespace inherit { 

BStub_BioFruitService::BStub_BioFruitService(PTransport transport) 
	: BStub(transport) {}

::std::wstring BStub_BioFruitService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioFruitService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
bool BStub_BioFruitService::certify(const ::std::wstring& param)  {
	BSyncResultT< bool > syncResult;	
	certify(param, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioFruitService::certify(const ::std::wstring& param, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_BioFruitService_certify(param));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_1 >(asyncResult) );
	transport->send(req, outerResult);
}
::std::wstring BStub_BioFruitService::squeeze()  {
	BSyncResultT< ::std::wstring > syncResult;	
	squeeze([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioFruitService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_FruitService_squeeze());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
namespace byps { namespace test { namespace api { 
void BSerializer_363642571(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::inherit::BStub_BioFruitService(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}

namespace byps { namespace test { namespace api { namespace inherit { 

BStub_LemonService::BStub_LemonService(PTransport transport) 
	: BStub(transport) {}

::std::wstring BStub_LemonService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_LemonService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
::std::wstring BStub_LemonService::pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree)  {
	BSyncResultT< ::std::wstring > syncResult;	
	pick(sess, fromTree, [&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_LemonService::pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree, ::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_LemonService_pick(sess, fromTree));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
::std::wstring BStub_LemonService::squeeze()  {
	BSyncResultT< ::std::wstring > syncResult;	
	squeeze([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_LemonService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_FruitService_squeeze());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
namespace byps { namespace test { namespace api { 
void BSerializer_605543968(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::inherit::BStub_LemonService(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}

namespace byps { namespace test { namespace api { namespace inherit { 

bool BSkeleton_BioLemonService::certify(const ::std::wstring& param)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_BioLemonService::certify(const ::std::wstring& param, ::std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = bool();
	try {
		ret = certify(param);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
::std::wstring BSkeleton_BioLemonService::grow()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_BioLemonService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	::std::wstring ret = ::std::wstring();
	try {
		ret = grow();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
::std::wstring BSkeleton_BioLemonService::squeeze()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_BioLemonService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	::std::wstring ret = ::std::wstring();
	try {
		ret = squeeze();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
::std::wstring BSkeleton_BioLemonService::pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_BioLemonService::pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree, ::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	::std::wstring ret = ::std::wstring();
	try {
		ret = pick(sess, fromTree);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
int32_t BSkeleton_BioLemonService::useParing()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_BioLemonService::useParing(::std::function< void (int32_t, BException ex) > asyncResult)  {
	int32_t ret = int32_t();
	try {
		ret = useParing();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
}}}}


namespace byps { namespace test { namespace api { namespace inherit { 

BStub_BioLemonService::BStub_BioLemonService(PTransport transport) 
	: BStub(transport) {}

bool BStub_BioLemonService::certify(const ::std::wstring& param)  {
	BSyncResultT< bool > syncResult;	
	certify(param, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::certify(const ::std::wstring& param, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_BioFruitService_certify(param));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_1 >(asyncResult) );
	transport->send(req, outerResult);
}
::std::wstring BStub_BioLemonService::grow()  {
	BSyncResultT< ::std::wstring > syncResult;	
	grow([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::grow(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_PlantService_grow());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
::std::wstring BStub_BioLemonService::squeeze()  {
	BSyncResultT< ::std::wstring > syncResult;	
	squeeze([&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::squeeze(::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_FruitService_squeeze());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
::std::wstring BStub_BioLemonService::pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree)  {
	BSyncResultT< ::std::wstring > syncResult;	
	pick(sess, fromTree, [&syncResult](::std::wstring v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::pick(const byps::test::api::auth::PSessionInfo& sess, const ::std::wstring& fromTree, ::std::function< void (::std::wstring, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_LemonService_pick(sess, fromTree));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< ::std::wstring, byps::test::api::BResult_10 >(asyncResult) );
	transport->send(req, outerResult);
}
int32_t BStub_BioLemonService::useParing()  {
	BSyncResultT< int32_t > syncResult;	
	useParing([&syncResult](int32_t v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_BioLemonService::useParing(::std::function< void (int32_t, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_BioLemonService_useParing());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< int32_t, byps::test::api::BResult_5 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
namespace byps { namespace test { namespace api { 
void BSerializer_474058508(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::inherit::BStub_BioLemonService(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}

namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteArrayTypes1dim::BStub_RemoteArrayTypes1dim(PTransport transport) 
	: BStub(transport) {}

void BStub_RemoteArrayTypes1dim::setBool(const byps_ptr< BArray1< bool > >& v)  {
	BSyncResultT< bool > syncResult;	
	setBool(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setBool(const byps_ptr< BArray1< bool > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setBool(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setByte(const PBytes& v)  {
	BSyncResultT< bool > syncResult;	
	setByte(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setByte(const PBytes& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setByte(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setChar(const byps_ptr< BArray1< wchar_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setChar(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setChar(const byps_ptr< BArray1< wchar_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setChar(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setShort(const byps_ptr< BArray1< int16_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setShort(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setShort(const byps_ptr< BArray1< int16_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setShort(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setInt(const byps_ptr< BArray1< int32_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setInt(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setInt(const byps_ptr< BArray1< int32_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setInt(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setLong(const byps_ptr< BArray1< int64_t > >& v)  {
	BSyncResultT< bool > syncResult;	
	setLong(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setLong(const byps_ptr< BArray1< int64_t > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setLong(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setFloat(const byps_ptr< BArray1< float > >& v)  {
	BSyncResultT< bool > syncResult;	
	setFloat(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setFloat(const byps_ptr< BArray1< float > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setFloat(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setDouble(const byps_ptr< BArray1< double > >& v)  {
	BSyncResultT< bool > syncResult;	
	setDouble(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setDouble(const byps_ptr< BArray1< double > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setDouble(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setString(const byps_ptr< BArray1< ::std::wstring > >& v)  {
	BSyncResultT< bool > syncResult;	
	setString(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setString(const byps_ptr< BArray1< ::std::wstring > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setString(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setPrimitiveTypes(const byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > >& v)  {
	BSyncResultT< bool > syncResult;	
	setPrimitiveTypes(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setPrimitiveTypes(const byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setPrimitiveTypes(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setObject(const byps_ptr< BArray1< PSerializable > >& v)  {
	BSyncResultT< bool > syncResult;	
	setObject(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::setObject(const byps_ptr< BArray1< PSerializable > >& v, ::std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setObject(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, byps::test::api::BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< bool > > BStub_RemoteArrayTypes1dim::getBool()  {
	BSyncResultT< byps_ptr< BArray1< bool > > > syncResult;	
	getBool([&syncResult](byps_ptr< BArray1< bool > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getBool(::std::function< void (byps_ptr< BArray1< bool > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getBool());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< bool > >, byps::test::api::BResult_2058423690 >(asyncResult) );
	transport->send(req, outerResult);
}
PBytes BStub_RemoteArrayTypes1dim::getByte()  {
	BSyncResultT< PBytes > syncResult;	
	getByte([&syncResult](PBytes v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getByte(::std::function< void (PBytes, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getByte());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PBytes, byps::test::api::BResult_1374008726 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< wchar_t > > BStub_RemoteArrayTypes1dim::getChar()  {
	BSyncResultT< byps_ptr< BArray1< wchar_t > > > syncResult;	
	getChar([&syncResult](byps_ptr< BArray1< wchar_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getChar(::std::function< void (byps_ptr< BArray1< wchar_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getChar());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< wchar_t > >, byps::test::api::BResult_1361632968 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< int16_t > > BStub_RemoteArrayTypes1dim::getShort()  {
	BSyncResultT< byps_ptr< BArray1< int16_t > > > syncResult;	
	getShort([&syncResult](byps_ptr< BArray1< int16_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getShort(::std::function< void (byps_ptr< BArray1< int16_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getShort());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< int16_t > >, byps::test::api::BResult_2067161310 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< int32_t > > BStub_RemoteArrayTypes1dim::getInt()  {
	BSyncResultT< byps_ptr< BArray1< int32_t > > > syncResult;	
	getInt([&syncResult](byps_ptr< BArray1< int32_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getInt(::std::function< void (byps_ptr< BArray1< int32_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getInt());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< int32_t > >, byps::test::api::BResult_100361105 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< int64_t > > BStub_RemoteArrayTypes1dim::getLong()  {
	BSyncResultT< byps_ptr< BArray1< int64_t > > > syncResult;	
	getLong([&syncResult](byps_ptr< BArray1< int64_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getLong(::std::function< void (byps_ptr< BArray1< int64_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getLong());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< int64_t > >, byps::test::api::BResult_1097129250 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< float > > BStub_RemoteArrayTypes1dim::getFloat()  {
	BSyncResultT< byps_ptr< BArray1< float > > > syncResult;	
	getFloat([&syncResult](byps_ptr< BArray1< float > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getFloat(::std::function< void (byps_ptr< BArray1< float > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getFloat());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< float > >, byps::test::api::BResult_766441794 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< double > > BStub_RemoteArrayTypes1dim::getDouble()  {
	BSyncResultT< byps_ptr< BArray1< double > > > syncResult;	
	getDouble([&syncResult](byps_ptr< BArray1< double > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getDouble(::std::function< void (byps_ptr< BArray1< double > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getDouble());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< double > >, byps::test::api::BResult_1359468275 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< ::std::wstring > > BStub_RemoteArrayTypes1dim::getString()  {
	BSyncResultT< byps_ptr< BArray1< ::std::wstring > > > syncResult;	
	getString([&syncResult](byps_ptr< BArray1< ::std::wstring > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getString(::std::function< void (byps_ptr< BArray1< ::std::wstring > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getString());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< ::std::wstring > >, byps::test::api::BResult_1888107655 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteArrayTypes1dim::getPrimitiveTypes()  {
	BSyncResultT< byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	getPrimitiveTypes([&syncResult](byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getPrimitiveTypes(::std::function< void (byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getPrimitiveTypes());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > >, byps::test::api::BResult_2053507648 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< PSerializable > > BStub_RemoteArrayTypes1dim::getObject()  {
	BSyncResultT< byps_ptr< BArray1< PSerializable > > > syncResult;	
	getObject([&syncResult](byps_ptr< BArray1< PSerializable > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::getObject(::std::function< void (byps_ptr< BArray1< PSerializable > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getObject());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< PSerializable > >, byps::test::api::BResult_183594037 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
namespace byps { namespace test { namespace api { 
void BSerializer_963816328(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::remote::BStub_RemoteArrayTypes1dim(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}

namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteArrayTypes23::BStub_RemoteArrayTypes23(PTransport transport) 
	: BStub(transport) {}

byps_ptr< BArray1< int32_t > > BStub_RemoteArrayTypes23::sendArraysInt(const byps_ptr< BArray2< int32_t > >& arr2, const byps_ptr< BArray3< int32_t > >& arr3, const byps_ptr< BArray4< int32_t > >& arr4)  {
	BSyncResultT< byps_ptr< BArray1< int32_t > > > syncResult;	
	sendArraysInt(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< int32_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysInt(const byps_ptr< BArray2< int32_t > >& arr2, const byps_ptr< BArray3< int32_t > >& arr3, const byps_ptr< BArray4< int32_t > >& arr4, ::std::function< void (byps_ptr< BArray1< int32_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysInt(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< int32_t > >, byps::test::api::BResult_100361105 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< ::std::wstring > > BStub_RemoteArrayTypes23::sendArraysString(const byps_ptr< BArray2< ::std::wstring > >& arr2, const byps_ptr< BArray3< ::std::wstring > >& arr3, const byps_ptr< BArray4< ::std::wstring > >& arr4)  {
	BSyncResultT< byps_ptr< BArray1< ::std::wstring > > > syncResult;	
	sendArraysString(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< ::std::wstring > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysString(const byps_ptr< BArray2< ::std::wstring > >& arr2, const byps_ptr< BArray3< ::std::wstring > >& arr3, const byps_ptr< BArray4< ::std::wstring > >& arr4, ::std::function< void (byps_ptr< BArray1< ::std::wstring > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysString(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< ::std::wstring > >, byps::test::api::BResult_1888107655 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteArrayTypes23::sendArraysClass(const byps_ptr< BArray2< byps::test::api::prim::PPrimitiveTypes > >& arr2, const byps_ptr< BArray3< byps::test::api::prim::PPrimitiveTypes > >& arr3, const byps_ptr< BArray4< byps::test::api::prim::PPrimitiveTypes > >& arr4)  {
	BSyncResultT< byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	sendArraysClass(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysClass(const byps_ptr< BArray2< byps::test::api::prim::PPrimitiveTypes > >& arr2, const byps_ptr< BArray3< byps::test::api::prim::PPrimitiveTypes > >& arr3, const byps_ptr< BArray4< byps::test::api::prim::PPrimitiveTypes > >& arr4, ::std::function< void (byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysClass(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > >, byps::test::api::BResult_2053507648 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< PSerializable > > BStub_RemoteArrayTypes23::sendArraysObject(const byps_ptr< BArray2< PSerializable > >& arr2, const byps_ptr< BArray3< PSerializable > >& arr3, const byps_ptr< BArray4< PSerializable > >& arr4)  {
	BSyncResultT< byps_ptr< BArray1< PSerializable > > > syncResult;	
	sendArraysObject(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< PSerializable > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysObject(const byps_ptr< BArray2< PSerializable > >& arr2, const byps_ptr< BArray3< PSerializable > >& arr3, const byps_ptr< BArray4< PSerializable > >& arr4, ::std::function< void (byps_ptr< BArray1< PSerializable > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysObject(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< PSerializable > >, byps::test::api::BResult_183594037 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< byps::test::api::inl::Point2D > > BStub_RemoteArrayTypes23::sendArraysInline(const byps_ptr< BArray2< byps::test::api::inl::Point2D > >& arr2, const byps_ptr< BArray3< byps::test::api::inl::Point2D > >& arr3, const byps_ptr< BArray4< byps::test::api::inl::Point2D > >& arr4)  {
	BSyncResultT< byps_ptr< BArray1< byps::test::api::inl::Point2D > > > syncResult;	
	sendArraysInline(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< byps::test::api::inl::Point2D > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::sendArraysInline(const byps_ptr< BArray2< byps::test::api::inl::Point2D > >& arr2, const byps_ptr< BArray3< byps::test::api::inl::Point2D > >& arr3, const byps_ptr< BArray4< byps::test::api::inl::Point2D > >& arr4, ::std::function< void (byps_ptr< BArray1< byps::test::api::inl::Point2D > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysInline(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< byps::test::api::inl::Point2D > >, byps::test::api::BResult_184101377 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}

// checkpoint byps.gen.cpp.GenRemoteStub:225
namespace byps { namespace test { namespace api { 
void BSerializer_769717182(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new byps::test::api::remote::BStub_RemoteArrayTypes23(transport));
	}
	else {
		BRemote* r = dynamic_cast<BRemote*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}
