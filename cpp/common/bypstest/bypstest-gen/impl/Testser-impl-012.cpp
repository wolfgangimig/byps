#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1768677016(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , com::wilutions::byps::test::api::refs::PNode >& r = * reinterpret_cast< ::std::map< ::std::wstring , com::wilutions::byps::test::api::refs::PNode >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , com::wilutions::byps::test::api::refs::PNode >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1279823631(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , bool >& r = * reinterpret_cast< ::std::map< ::std::wstring , bool >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , bool >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1488550492(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , PSerializable >& r = * reinterpret_cast< ::std::map< ::std::wstring , PSerializable >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , PSerializable >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1710660846(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< ::std::wstring , ::std::wstring >& r = * reinterpret_cast< ::std::map< ::std::wstring , ::std::wstring >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< ::std::wstring , ::std::wstring >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2052431866(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< PBytes >& r = * reinterpret_cast< ::std::set< PBytes >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< PBytes >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2114305573(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< com::wilutions::byps::test::api::inherit::PClass1 >& r = * reinterpret_cast< ::std::set< com::wilutions::byps::test::api::inherit::PClass1 >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< com::wilutions::byps::test::api::inherit::PClass1 >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1280571537(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes >& r = * reinterpret_cast< ::std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1406124761(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< byps_ptr< BArray1< int32_t > > >& r = * reinterpret_cast< ::std::set< byps_ptr< BArray1< int32_t > > >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< byps_ptr< BArray1< int32_t > > >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1365696060(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< bool >& r = * reinterpret_cast< ::std::set< bool >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< bool >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1320560671(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< double >& r = * reinterpret_cast< ::std::set< double >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< double >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1898022288(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< float >& r = * reinterpret_cast< ::std::set< float >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< float >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1493282670(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int32_t >& r = * reinterpret_cast< ::std::set< int32_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int32_t >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1457164460(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int64_t >& r = * reinterpret_cast< ::std::set< int64_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int64_t >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2028443792(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int16_t >& r = * reinterpret_cast< ::std::set< int16_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int16_t >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1888799711(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< ::std::wstring >& r = * reinterpret_cast< ::std::set< ::std::wstring >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< ::std::wstring >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_8789515(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< float , wchar_t >& r = * reinterpret_cast< ::std::map< float , wchar_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< float , wchar_t >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_476459792(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::map< int32_t , PContentStream >& r = * reinterpret_cast< ::std::map< int32_t , PContentStream >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::map< int32_t , PContentStream >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_936607009(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< wchar_t >& r = * reinterpret_cast< ::std::set< wchar_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< wchar_t >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_855786668(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		::std::set< int32_t >& r = * reinterpret_cast< ::std::set< int32_t >*>(p);
		bio & r;
	} else {
		pObj = POBJECT(new ::std::set< int32_t >());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1097129250(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< int64_t > & r = * reinterpret_cast< BArray1< int64_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< int64_t > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_846419204(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< int64_t > & r = * reinterpret_cast< BArray4< int64_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< int64_t > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2067161310(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray1< int16_t > & r = * reinterpret_cast< BArray1< int16_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray1< int16_t > ());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1859644668(BIO& bio, POBJECT& pObj, PSerializable& , void* ) {
	void* p = pObj.get();
	if (p) { 
		BArray4< int16_t > & r = * reinterpret_cast< BArray4< int16_t > *>(p);
		bio & r;
	} else {
		pObj = POBJECT(new BArray4< int16_t > ());
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

void BSkeleton_RemoteArrayTypes1dim::setBool(byps_ptr< BArray1< bool > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_setBool(byps_ptr< BArray1< bool > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setBool(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes1dim::setByte(PBytes v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_setByte(PBytes v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setByte(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes1dim::setChar(byps_ptr< BArray1< wchar_t > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_setChar(byps_ptr< BArray1< wchar_t > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setChar(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes1dim::setShort(byps_ptr< BArray1< int16_t > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_setShort(byps_ptr< BArray1< int16_t > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setShort(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes1dim::setInt(byps_ptr< BArray1< int32_t > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_setInt(byps_ptr< BArray1< int32_t > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setInt(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes1dim::setLong(byps_ptr< BArray1< int64_t > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_setLong(byps_ptr< BArray1< int64_t > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setLong(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes1dim::setFloat(byps_ptr< BArray1< float > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_setFloat(byps_ptr< BArray1< float > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setFloat(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes1dim::setDouble(byps_ptr< BArray1< double > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_setDouble(byps_ptr< BArray1< double > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setDouble(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes1dim::setString(byps_ptr< BArray1< ::std::wstring > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_setString(byps_ptr< BArray1< ::std::wstring > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setString(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes1dim::setPrimitiveTypes(byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_setPrimitiveTypes(byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setPrimitiveTypes(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes1dim::setObject(byps_ptr< BArray1< PSerializable > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_setObject(byps_ptr< BArray1< PSerializable > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setObject(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray1< bool > > BSkeleton_RemoteArrayTypes1dim::getBool()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_getBool(std::function< void (byps_ptr< BArray1< bool > >, BException ex) > asyncResult)  {
	byps_ptr< BArray1< bool > > ret = byps_ptr< BArray1< bool > >();
	try {
		ret = getBool();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
PBytes BSkeleton_RemoteArrayTypes1dim::getByte()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_getByte(std::function< void (PBytes, BException ex) > asyncResult)  {
	PBytes ret = PBytes();
	try {
		ret = getByte();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray1< wchar_t > > BSkeleton_RemoteArrayTypes1dim::getChar()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_getChar(std::function< void (byps_ptr< BArray1< wchar_t > >, BException ex) > asyncResult)  {
	byps_ptr< BArray1< wchar_t > > ret = byps_ptr< BArray1< wchar_t > >();
	try {
		ret = getChar();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray1< int16_t > > BSkeleton_RemoteArrayTypes1dim::getShort()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_getShort(std::function< void (byps_ptr< BArray1< int16_t > >, BException ex) > asyncResult)  {
	byps_ptr< BArray1< int16_t > > ret = byps_ptr< BArray1< int16_t > >();
	try {
		ret = getShort();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray1< int32_t > > BSkeleton_RemoteArrayTypes1dim::getInt()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_getInt(std::function< void (byps_ptr< BArray1< int32_t > >, BException ex) > asyncResult)  {
	byps_ptr< BArray1< int32_t > > ret = byps_ptr< BArray1< int32_t > >();
	try {
		ret = getInt();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray1< int64_t > > BSkeleton_RemoteArrayTypes1dim::getLong()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_getLong(std::function< void (byps_ptr< BArray1< int64_t > >, BException ex) > asyncResult)  {
	byps_ptr< BArray1< int64_t > > ret = byps_ptr< BArray1< int64_t > >();
	try {
		ret = getLong();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray1< float > > BSkeleton_RemoteArrayTypes1dim::getFloat()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_getFloat(std::function< void (byps_ptr< BArray1< float > >, BException ex) > asyncResult)  {
	byps_ptr< BArray1< float > > ret = byps_ptr< BArray1< float > >();
	try {
		ret = getFloat();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray1< double > > BSkeleton_RemoteArrayTypes1dim::getDouble()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_getDouble(std::function< void (byps_ptr< BArray1< double > >, BException ex) > asyncResult)  {
	byps_ptr< BArray1< double > > ret = byps_ptr< BArray1< double > >();
	try {
		ret = getDouble();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray1< ::std::wstring > > BSkeleton_RemoteArrayTypes1dim::getString()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_getString(std::function< void (byps_ptr< BArray1< ::std::wstring > >, BException ex) > asyncResult)  {
	byps_ptr< BArray1< ::std::wstring > > ret = byps_ptr< BArray1< ::std::wstring > >();
	try {
		ret = getString();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > BSkeleton_RemoteArrayTypes1dim::getPrimitiveTypes()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_getPrimitiveTypes(std::function< void (byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > ret = byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >();
	try {
		ret = getPrimitiveTypes();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray1< PSerializable > > BSkeleton_RemoteArrayTypes1dim::getObject()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes1dim::async_getObject(std::function< void (byps_ptr< BArray1< PSerializable > >, BException ex) > asyncResult)  {
	byps_ptr< BArray1< PSerializable > > ret = byps_ptr< BArray1< PSerializable > >();
	try {
		ret = getObject();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
}}}}}}


namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteArrayTypes1dim::BStub_RemoteArrayTypes1dim(PTransport transport) 
	: BStub(transport) {}

void BStub_RemoteArrayTypes1dim::setBool(byps_ptr< BArray1< bool > > v)  {
	BSyncResultT< bool > syncResult;	
	async_setBool(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_setBool(byps_ptr< BArray1< bool > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setBool(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setByte(PBytes v)  {
	BSyncResultT< bool > syncResult;	
	async_setByte(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_setByte(PBytes v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setByte(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setChar(byps_ptr< BArray1< wchar_t > > v)  {
	BSyncResultT< bool > syncResult;	
	async_setChar(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_setChar(byps_ptr< BArray1< wchar_t > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setChar(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setShort(byps_ptr< BArray1< int16_t > > v)  {
	BSyncResultT< bool > syncResult;	
	async_setShort(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_setShort(byps_ptr< BArray1< int16_t > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setShort(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setInt(byps_ptr< BArray1< int32_t > > v)  {
	BSyncResultT< bool > syncResult;	
	async_setInt(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_setInt(byps_ptr< BArray1< int32_t > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setInt(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setLong(byps_ptr< BArray1< int64_t > > v)  {
	BSyncResultT< bool > syncResult;	
	async_setLong(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_setLong(byps_ptr< BArray1< int64_t > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setLong(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setFloat(byps_ptr< BArray1< float > > v)  {
	BSyncResultT< bool > syncResult;	
	async_setFloat(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_setFloat(byps_ptr< BArray1< float > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setFloat(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setDouble(byps_ptr< BArray1< double > > v)  {
	BSyncResultT< bool > syncResult;	
	async_setDouble(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_setDouble(byps_ptr< BArray1< double > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setDouble(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setString(byps_ptr< BArray1< ::std::wstring > > v)  {
	BSyncResultT< bool > syncResult;	
	async_setString(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_setString(byps_ptr< BArray1< ::std::wstring > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setString(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setPrimitiveTypes(byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v)  {
	BSyncResultT< bool > syncResult;	
	async_setPrimitiveTypes(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_setPrimitiveTypes(byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setPrimitiveTypes(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes1dim::setObject(byps_ptr< BArray1< PSerializable > > v)  {
	BSyncResultT< bool > syncResult;	
	async_setObject(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_setObject(byps_ptr< BArray1< PSerializable > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_setObject(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< bool > > BStub_RemoteArrayTypes1dim::getBool()  {
	BSyncResultT< byps_ptr< BArray1< bool > > > syncResult;	
	async_getBool([&syncResult](byps_ptr< BArray1< bool > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_getBool(std::function< void (byps_ptr< BArray1< bool > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getBool());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< bool > >, BResult_2058423690 >(asyncResult) );
	transport->send(req, outerResult);
}
PBytes BStub_RemoteArrayTypes1dim::getByte()  {
	BSyncResultT< PBytes > syncResult;	
	async_getByte([&syncResult](PBytes v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_getByte(std::function< void (PBytes, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getByte());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PBytes, BResult_1374008726 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< wchar_t > > BStub_RemoteArrayTypes1dim::getChar()  {
	BSyncResultT< byps_ptr< BArray1< wchar_t > > > syncResult;	
	async_getChar([&syncResult](byps_ptr< BArray1< wchar_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_getChar(std::function< void (byps_ptr< BArray1< wchar_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getChar());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< wchar_t > >, BResult_1361632968 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< int16_t > > BStub_RemoteArrayTypes1dim::getShort()  {
	BSyncResultT< byps_ptr< BArray1< int16_t > > > syncResult;	
	async_getShort([&syncResult](byps_ptr< BArray1< int16_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_getShort(std::function< void (byps_ptr< BArray1< int16_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getShort());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< int16_t > >, BResult_2067161310 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< int32_t > > BStub_RemoteArrayTypes1dim::getInt()  {
	BSyncResultT< byps_ptr< BArray1< int32_t > > > syncResult;	
	async_getInt([&syncResult](byps_ptr< BArray1< int32_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_getInt(std::function< void (byps_ptr< BArray1< int32_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getInt());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< int32_t > >, BResult_100361105 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< int64_t > > BStub_RemoteArrayTypes1dim::getLong()  {
	BSyncResultT< byps_ptr< BArray1< int64_t > > > syncResult;	
	async_getLong([&syncResult](byps_ptr< BArray1< int64_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_getLong(std::function< void (byps_ptr< BArray1< int64_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getLong());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< int64_t > >, BResult_1097129250 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< float > > BStub_RemoteArrayTypes1dim::getFloat()  {
	BSyncResultT< byps_ptr< BArray1< float > > > syncResult;	
	async_getFloat([&syncResult](byps_ptr< BArray1< float > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_getFloat(std::function< void (byps_ptr< BArray1< float > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getFloat());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< float > >, BResult_766441794 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< double > > BStub_RemoteArrayTypes1dim::getDouble()  {
	BSyncResultT< byps_ptr< BArray1< double > > > syncResult;	
	async_getDouble([&syncResult](byps_ptr< BArray1< double > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_getDouble(std::function< void (byps_ptr< BArray1< double > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getDouble());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< double > >, BResult_1359468275 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< ::std::wstring > > BStub_RemoteArrayTypes1dim::getString()  {
	BSyncResultT< byps_ptr< BArray1< ::std::wstring > > > syncResult;	
	async_getString([&syncResult](byps_ptr< BArray1< ::std::wstring > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_getString(std::function< void (byps_ptr< BArray1< ::std::wstring > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getString());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< ::std::wstring > >, BResult_1888107655 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteArrayTypes1dim::getPrimitiveTypes()  {
	BSyncResultT< byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	async_getPrimitiveTypes([&syncResult](byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_getPrimitiveTypes(std::function< void (byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getPrimitiveTypes());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BResult_801243127 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< PSerializable > > BStub_RemoteArrayTypes1dim::getObject()  {
	BSyncResultT< byps_ptr< BArray1< PSerializable > > > syncResult;	
	async_getObject([&syncResult](byps_ptr< BArray1< PSerializable > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes1dim::async_getObject(std::function< void (byps_ptr< BArray1< PSerializable > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes1dim_getObject());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< PSerializable > >, BResult_183594037 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1557084481(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BStub_RemoteArrayTypes1dim(transport));
	}
	else {
		com::wilutions::byps::test::api::remote::RemoteArrayTypes1dim* r = dynamic_cast<com::wilutions::byps::test::api::remote::RemoteArrayTypes1dim*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

byps_ptr< BArray1< int32_t > > BSkeleton_RemoteArrayTypes23::sendArraysInt(byps_ptr< BArray2< int32_t > > arr2, byps_ptr< BArray3< int32_t > > arr3, byps_ptr< BArray4< int32_t > > arr4)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes23::async_sendArraysInt(byps_ptr< BArray2< int32_t > > arr2, byps_ptr< BArray3< int32_t > > arr3, byps_ptr< BArray4< int32_t > > arr4, std::function< void (byps_ptr< BArray1< int32_t > >, BException ex) > asyncResult)  {
	byps_ptr< BArray1< int32_t > > ret = byps_ptr< BArray1< int32_t > >();
	try {
		ret = sendArraysInt(arr2, arr3, arr4);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray1< ::std::wstring > > BSkeleton_RemoteArrayTypes23::sendArraysString(byps_ptr< BArray2< ::std::wstring > > arr2, byps_ptr< BArray3< ::std::wstring > > arr3, byps_ptr< BArray4< ::std::wstring > > arr4)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes23::async_sendArraysString(byps_ptr< BArray2< ::std::wstring > > arr2, byps_ptr< BArray3< ::std::wstring > > arr3, byps_ptr< BArray4< ::std::wstring > > arr4, std::function< void (byps_ptr< BArray1< ::std::wstring > >, BException ex) > asyncResult)  {
	byps_ptr< BArray1< ::std::wstring > > ret = byps_ptr< BArray1< ::std::wstring > >();
	try {
		ret = sendArraysString(arr2, arr3, arr4);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > BSkeleton_RemoteArrayTypes23::sendArraysClass(byps_ptr< BArray2< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr2, byps_ptr< BArray3< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr3, byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr4)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes23::async_sendArraysClass(byps_ptr< BArray2< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr2, byps_ptr< BArray3< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr3, byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr4, std::function< void (byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > ret = byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >();
	try {
		ret = sendArraysClass(arr2, arr3, arr4);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray1< PSerializable > > BSkeleton_RemoteArrayTypes23::sendArraysObject(byps_ptr< BArray2< PSerializable > > arr2, byps_ptr< BArray3< PSerializable > > arr3, byps_ptr< BArray4< PSerializable > > arr4)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes23::async_sendArraysObject(byps_ptr< BArray2< PSerializable > > arr2, byps_ptr< BArray3< PSerializable > > arr3, byps_ptr< BArray4< PSerializable > > arr4, std::function< void (byps_ptr< BArray1< PSerializable > >, BException ex) > asyncResult)  {
	byps_ptr< BArray1< PSerializable > > ret = byps_ptr< BArray1< PSerializable > >();
	try {
		ret = sendArraysObject(arr2, arr3, arr4);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > BSkeleton_RemoteArrayTypes23::sendArraysInline(byps_ptr< BArray2< com::wilutions::byps::test::api::inl::Point2D > > arr2, byps_ptr< BArray3< com::wilutions::byps::test::api::inl::Point2D > > arr3, byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > > arr4)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes23::async_sendArraysInline(byps_ptr< BArray2< com::wilutions::byps::test::api::inl::Point2D > > arr2, byps_ptr< BArray3< com::wilutions::byps::test::api::inl::Point2D > > arr3, byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > > arr4, std::function< void (byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > >, BException ex) > asyncResult)  {
	byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > ret = byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > >();
	try {
		ret = sendArraysInline(arr2, arr3, arr4);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
}}}}}}


namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteArrayTypes23::BStub_RemoteArrayTypes23(PTransport transport) 
	: BStub(transport) {}

byps_ptr< BArray1< int32_t > > BStub_RemoteArrayTypes23::sendArraysInt(byps_ptr< BArray2< int32_t > > arr2, byps_ptr< BArray3< int32_t > > arr3, byps_ptr< BArray4< int32_t > > arr4)  {
	BSyncResultT< byps_ptr< BArray1< int32_t > > > syncResult;	
	async_sendArraysInt(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< int32_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::async_sendArraysInt(byps_ptr< BArray2< int32_t > > arr2, byps_ptr< BArray3< int32_t > > arr3, byps_ptr< BArray4< int32_t > > arr4, std::function< void (byps_ptr< BArray1< int32_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysInt(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< int32_t > >, BResult_100361105 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< ::std::wstring > > BStub_RemoteArrayTypes23::sendArraysString(byps_ptr< BArray2< ::std::wstring > > arr2, byps_ptr< BArray3< ::std::wstring > > arr3, byps_ptr< BArray4< ::std::wstring > > arr4)  {
	BSyncResultT< byps_ptr< BArray1< ::std::wstring > > > syncResult;	
	async_sendArraysString(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< ::std::wstring > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::async_sendArraysString(byps_ptr< BArray2< ::std::wstring > > arr2, byps_ptr< BArray3< ::std::wstring > > arr3, byps_ptr< BArray4< ::std::wstring > > arr4, std::function< void (byps_ptr< BArray1< ::std::wstring > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysString(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< ::std::wstring > >, BResult_1888107655 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteArrayTypes23::sendArraysClass(byps_ptr< BArray2< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr2, byps_ptr< BArray3< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr3, byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr4)  {
	BSyncResultT< byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	async_sendArraysClass(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::async_sendArraysClass(byps_ptr< BArray2< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr2, byps_ptr< BArray3< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr3, byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr4, std::function< void (byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysClass(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BResult_801243127 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< PSerializable > > BStub_RemoteArrayTypes23::sendArraysObject(byps_ptr< BArray2< PSerializable > > arr2, byps_ptr< BArray3< PSerializable > > arr3, byps_ptr< BArray4< PSerializable > > arr4)  {
	BSyncResultT< byps_ptr< BArray1< PSerializable > > > syncResult;	
	async_sendArraysObject(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< PSerializable > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::async_sendArraysObject(byps_ptr< BArray2< PSerializable > > arr2, byps_ptr< BArray3< PSerializable > > arr3, byps_ptr< BArray4< PSerializable > > arr4, std::function< void (byps_ptr< BArray1< PSerializable > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysObject(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< PSerializable > >, BResult_183594037 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > BStub_RemoteArrayTypes23::sendArraysInline(byps_ptr< BArray2< com::wilutions::byps::test::api::inl::Point2D > > arr2, byps_ptr< BArray3< com::wilutions::byps::test::api::inl::Point2D > > arr3, byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > > arr4)  {
	BSyncResultT< byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > > syncResult;	
	async_sendArraysInline(arr2, arr3, arr4, [&syncResult](byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes23::async_sendArraysInline(byps_ptr< BArray2< com::wilutions::byps::test::api::inl::Point2D > > arr2, byps_ptr< BArray3< com::wilutions::byps::test::api::inl::Point2D > > arr3, byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > > arr4, std::function< void (byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes23_sendArraysInline(arr2, arr3, arr4));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > >, BResult_2049740106 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2081058997(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BStub_RemoteArrayTypes23(transport));
	}
	else {
		com::wilutions::byps::test::api::remote::RemoteArrayTypes23* r = dynamic_cast<com::wilutions::byps::test::api::remote::RemoteArrayTypes23*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

void BSkeleton_RemoteArrayTypes4dim::setBool(byps_ptr< BArray4< bool > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_setBool(byps_ptr< BArray4< bool > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setBool(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes4dim::setByte(byps_ptr< BArray4< int8_t > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_setByte(byps_ptr< BArray4< int8_t > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setByte(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes4dim::setChar(byps_ptr< BArray4< wchar_t > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_setChar(byps_ptr< BArray4< wchar_t > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setChar(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes4dim::setShort(byps_ptr< BArray4< int16_t > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_setShort(byps_ptr< BArray4< int16_t > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setShort(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes4dim::setInt(byps_ptr< BArray4< int32_t > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_setInt(byps_ptr< BArray4< int32_t > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setInt(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes4dim::setLong(byps_ptr< BArray4< int64_t > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_setLong(byps_ptr< BArray4< int64_t > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setLong(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes4dim::setFloat(byps_ptr< BArray4< float > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_setFloat(byps_ptr< BArray4< float > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setFloat(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes4dim::setDouble(byps_ptr< BArray4< double > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_setDouble(byps_ptr< BArray4< double > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setDouble(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes4dim::setString(byps_ptr< BArray4< ::std::wstring > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_setString(byps_ptr< BArray4< ::std::wstring > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setString(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes4dim::setPrimitiveTypes(byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_setPrimitiveTypes(byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setPrimitiveTypes(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteArrayTypes4dim::setObject(byps_ptr< BArray4< PSerializable > > v)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_setObject(byps_ptr< BArray4< PSerializable > > v, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setObject(v);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray4< bool > > BSkeleton_RemoteArrayTypes4dim::getBool()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_getBool(std::function< void (byps_ptr< BArray4< bool > >, BException ex) > asyncResult)  {
	byps_ptr< BArray4< bool > > ret = byps_ptr< BArray4< bool > >();
	try {
		ret = getBool();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray4< int8_t > > BSkeleton_RemoteArrayTypes4dim::getByte()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_getByte(std::function< void (byps_ptr< BArray4< int8_t > >, BException ex) > asyncResult)  {
	byps_ptr< BArray4< int8_t > > ret = byps_ptr< BArray4< int8_t > >();
	try {
		ret = getByte();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray4< wchar_t > > BSkeleton_RemoteArrayTypes4dim::getChar()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_getChar(std::function< void (byps_ptr< BArray4< wchar_t > >, BException ex) > asyncResult)  {
	byps_ptr< BArray4< wchar_t > > ret = byps_ptr< BArray4< wchar_t > >();
	try {
		ret = getChar();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray4< int16_t > > BSkeleton_RemoteArrayTypes4dim::getShort()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_getShort(std::function< void (byps_ptr< BArray4< int16_t > >, BException ex) > asyncResult)  {
	byps_ptr< BArray4< int16_t > > ret = byps_ptr< BArray4< int16_t > >();
	try {
		ret = getShort();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray4< int32_t > > BSkeleton_RemoteArrayTypes4dim::getInt()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_getInt(std::function< void (byps_ptr< BArray4< int32_t > >, BException ex) > asyncResult)  {
	byps_ptr< BArray4< int32_t > > ret = byps_ptr< BArray4< int32_t > >();
	try {
		ret = getInt();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray4< int64_t > > BSkeleton_RemoteArrayTypes4dim::getLong()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_getLong(std::function< void (byps_ptr< BArray4< int64_t > >, BException ex) > asyncResult)  {
	byps_ptr< BArray4< int64_t > > ret = byps_ptr< BArray4< int64_t > >();
	try {
		ret = getLong();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray4< float > > BSkeleton_RemoteArrayTypes4dim::getFloat()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_getFloat(std::function< void (byps_ptr< BArray4< float > >, BException ex) > asyncResult)  {
	byps_ptr< BArray4< float > > ret = byps_ptr< BArray4< float > >();
	try {
		ret = getFloat();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray4< double > > BSkeleton_RemoteArrayTypes4dim::getDouble()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_getDouble(std::function< void (byps_ptr< BArray4< double > >, BException ex) > asyncResult)  {
	byps_ptr< BArray4< double > > ret = byps_ptr< BArray4< double > >();
	try {
		ret = getDouble();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray4< ::std::wstring > > BSkeleton_RemoteArrayTypes4dim::getString()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_getString(std::function< void (byps_ptr< BArray4< ::std::wstring > >, BException ex) > asyncResult)  {
	byps_ptr< BArray4< ::std::wstring > > ret = byps_ptr< BArray4< ::std::wstring > >();
	try {
		ret = getString();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > BSkeleton_RemoteArrayTypes4dim::getPrimitiveTypes()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_getPrimitiveTypes(std::function< void (byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > ret = byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >();
	try {
		ret = getPrimitiveTypes();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray4< PSerializable > > BSkeleton_RemoteArrayTypes4dim::getObject()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteArrayTypes4dim::async_getObject(std::function< void (byps_ptr< BArray4< PSerializable > >, BException ex) > asyncResult)  {
	byps_ptr< BArray4< PSerializable > > ret = byps_ptr< BArray4< PSerializable > >();
	try {
		ret = getObject();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
}}}}}}

