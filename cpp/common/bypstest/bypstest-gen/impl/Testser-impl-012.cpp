#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;


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
	BSyncResultT<byps_ptr< BArray1< int32_t > > > syncResult;	
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
	BSyncResultT<byps_ptr< BArray1< ::std::wstring > > > syncResult;	
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
	BSyncResultT<byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
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
	BSyncResultT<byps_ptr< BArray1< PSerializable > > > syncResult;	
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
	BSyncResultT<byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > > syncResult;	
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


namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteArrayTypes4dim::BStub_RemoteArrayTypes4dim(PTransport transport) 
	: BStub(transport) {}

void BStub_RemoteArrayTypes4dim::setBool(byps_ptr< BArray4< bool > > v)  {
	BSyncResultT<bool > syncResult;	
	async_setBool(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_setBool(byps_ptr< BArray4< bool > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setBool(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setByte(byps_ptr< BArray4< int8_t > > v)  {
	BSyncResultT<bool > syncResult;	
	async_setByte(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_setByte(byps_ptr< BArray4< int8_t > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setByte(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setChar(byps_ptr< BArray4< wchar_t > > v)  {
	BSyncResultT<bool > syncResult;	
	async_setChar(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_setChar(byps_ptr< BArray4< wchar_t > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setChar(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setShort(byps_ptr< BArray4< int16_t > > v)  {
	BSyncResultT<bool > syncResult;	
	async_setShort(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_setShort(byps_ptr< BArray4< int16_t > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setShort(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setInt(byps_ptr< BArray4< int32_t > > v)  {
	BSyncResultT<bool > syncResult;	
	async_setInt(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_setInt(byps_ptr< BArray4< int32_t > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setInt(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setLong(byps_ptr< BArray4< int64_t > > v)  {
	BSyncResultT<bool > syncResult;	
	async_setLong(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_setLong(byps_ptr< BArray4< int64_t > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setLong(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setFloat(byps_ptr< BArray4< float > > v)  {
	BSyncResultT<bool > syncResult;	
	async_setFloat(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_setFloat(byps_ptr< BArray4< float > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setFloat(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setDouble(byps_ptr< BArray4< double > > v)  {
	BSyncResultT<bool > syncResult;	
	async_setDouble(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_setDouble(byps_ptr< BArray4< double > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setDouble(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setString(byps_ptr< BArray4< ::std::wstring > > v)  {
	BSyncResultT<bool > syncResult;	
	async_setString(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_setString(byps_ptr< BArray4< ::std::wstring > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setString(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setPrimitiveTypes(byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v)  {
	BSyncResultT<bool > syncResult;	
	async_setPrimitiveTypes(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_setPrimitiveTypes(byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setPrimitiveTypes(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteArrayTypes4dim::setObject(byps_ptr< BArray4< PSerializable > > v)  {
	BSyncResultT<bool > syncResult;	
	async_setObject(v, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_setObject(byps_ptr< BArray4< PSerializable > > v, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_setObject(v));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< bool > > BStub_RemoteArrayTypes4dim::getBool()  {
	BSyncResultT<byps_ptr< BArray4< bool > > > syncResult;	
	async_getBool([&syncResult](byps_ptr< BArray4< bool > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_getBool(std::function< void (byps_ptr< BArray4< bool > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getBool());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< bool > >, BResult_945713488 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< int8_t > > BStub_RemoteArrayTypes4dim::getByte()  {
	BSyncResultT<byps_ptr< BArray4< int8_t > > > syncResult;	
	async_getByte([&syncResult](byps_ptr< BArray4< int8_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_getByte(std::function< void (byps_ptr< BArray4< int8_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getByte());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< int8_t > >, BResult_1201775504 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< wchar_t > > BStub_RemoteArrayTypes4dim::getChar()  {
	BSyncResultT<byps_ptr< BArray4< wchar_t > > > syncResult;	
	async_getChar([&syncResult](byps_ptr< BArray4< wchar_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_getChar(std::function< void (byps_ptr< BArray4< wchar_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getChar());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< wchar_t > >, BResult_769021986 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< int16_t > > BStub_RemoteArrayTypes4dim::getShort()  {
	BSyncResultT<byps_ptr< BArray4< int16_t > > > syncResult;	
	async_getShort([&syncResult](byps_ptr< BArray4< int16_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_getShort(std::function< void (byps_ptr< BArray4< int16_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getShort());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< int16_t > >, BResult_1859644668 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< int32_t > > BStub_RemoteArrayTypes4dim::getInt()  {
	BSyncResultT<byps_ptr< BArray4< int32_t > > > syncResult;	
	async_getInt([&syncResult](byps_ptr< BArray4< int32_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_getInt(std::function< void (byps_ptr< BArray4< int32_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getInt());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< int32_t > >, BResult_39910537 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< int64_t > > BStub_RemoteArrayTypes4dim::getLong()  {
	BSyncResultT<byps_ptr< BArray4< int64_t > > > syncResult;	
	async_getLong([&syncResult](byps_ptr< BArray4< int64_t > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_getLong(std::function< void (byps_ptr< BArray4< int64_t > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getLong());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< int64_t > >, BResult_846419204 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< float > > BStub_RemoteArrayTypes4dim::getFloat()  {
	BSyncResultT<byps_ptr< BArray4< float > > > syncResult;	
	async_getFloat([&syncResult](byps_ptr< BArray4< float > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_getFloat(std::function< void (byps_ptr< BArray4< float > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getFloat());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< float > >, BResult_1516687588 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< double > > BStub_RemoteArrayTypes4dim::getDouble()  {
	BSyncResultT<byps_ptr< BArray4< double > > > syncResult;	
	async_getDouble([&syncResult](byps_ptr< BArray4< double > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_getDouble(std::function< void (byps_ptr< BArray4< double > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getDouble());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< double > >, BResult_2087445849 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< ::std::wstring > > BStub_RemoteArrayTypes4dim::getString()  {
	BSyncResultT<byps_ptr< BArray4< ::std::wstring > > > syncResult;	
	async_getString([&syncResult](byps_ptr< BArray4< ::std::wstring > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_getString(std::function< void (byps_ptr< BArray4< ::std::wstring > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getString());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< ::std::wstring > >, BResult_588723219 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > BStub_RemoteArrayTypes4dim::getPrimitiveTypes()  {
	BSyncResultT<byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > > syncResult;	
	async_getPrimitiveTypes([&syncResult](byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_getPrimitiveTypes(std::function< void (byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getPrimitiveTypes());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >, BResult_1503107601 >(asyncResult) );
	transport->send(req, outerResult);
}
byps_ptr< BArray4< PSerializable > > BStub_RemoteArrayTypes4dim::getObject()  {
	BSyncResultT<byps_ptr< BArray4< PSerializable > > > syncResult;	
	async_getObject([&syncResult](byps_ptr< BArray4< PSerializable > > v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteArrayTypes4dim::async_getObject(std::function< void (byps_ptr< BArray4< PSerializable > >, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteArrayTypes4dim_getObject());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< byps_ptr< BArray4< PSerializable > >, BResult_124584219 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1557173854(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BStub_RemoteArrayTypes4dim(transport));
	}
	else {
		com::wilutions::byps::test::api::remote::RemoteArrayTypes4dim* r = dynamic_cast<com::wilutions::byps::test::api::remote::RemoteArrayTypes4dim*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

void BSkeleton_RemoteConstants::compare_HebrewC(com::wilutions::byps::test::api::cons::PHebrewZ ALEPH, com::wilutions::byps::test::api::cons::PHebrewZ BETH)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteConstants::async_compare_HebrewC(com::wilutions::byps::test::api::cons::PHebrewZ ALEPH, com::wilutions::byps::test::api::cons::PHebrewZ BETH, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		compare_HebrewC(ALEPH, BETH);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
bool BSkeleton_RemoteConstants::compare_AllTypesC(bool bool1s, bool bool2s, wchar_t char1s, ::std::wstring stringNull, wchar_t char2s, int16_t short1s, int32_t int1s, int64_t long1s, float float1s, double double1s, ::std::wstring string1s, com::wilutions::byps::test::api::cons::PAllTypesZ ALL, byps_ptr< BArray1< int32_t > > arrInt, byps_ptr< BArray4< int32_t > > arrInt4, byps_ptr< BArray1< ::std::wstring > > arrStrings, byps_ptr< BArray4< ::std::wstring > > arrStrings4, byps_ptr< BArray2< com::wilutions::byps::test::api::cons::PAllTypesZ > > arrAll)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteConstants::async_compare_AllTypesC(bool bool1s, bool bool2s, wchar_t char1s, ::std::wstring stringNull, wchar_t char2s, int16_t short1s, int32_t int1s, int64_t long1s, float float1s, double double1s, ::std::wstring string1s, com::wilutions::byps::test::api::cons::PAllTypesZ ALL, byps_ptr< BArray1< int32_t > > arrInt, byps_ptr< BArray4< int32_t > > arrInt4, byps_ptr< BArray1< ::std::wstring > > arrStrings, byps_ptr< BArray4< ::std::wstring > > arrStrings4, byps_ptr< BArray2< com::wilutions::byps::test::api::cons::PAllTypesZ > > arrAll, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = bool();
	try {
		ret = compare_AllTypesC(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
}}}}}}


namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteConstants::BStub_RemoteConstants(PTransport transport) 
	: BStub(transport) {}

void BStub_RemoteConstants::compare_HebrewC(com::wilutions::byps::test::api::cons::PHebrewZ ALEPH, com::wilutions::byps::test::api::cons::PHebrewZ BETH)  {
	BSyncResultT<bool > syncResult;	
	async_compare_HebrewC(ALEPH, BETH, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteConstants::async_compare_HebrewC(com::wilutions::byps::test::api::cons::PHebrewZ ALEPH, com::wilutions::byps::test::api::cons::PHebrewZ BETH, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteConstants_compare_HebrewC(ALEPH, BETH));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
bool BStub_RemoteConstants::compare_AllTypesC(bool bool1s, bool bool2s, wchar_t char1s, ::std::wstring stringNull, wchar_t char2s, int16_t short1s, int32_t int1s, int64_t long1s, float float1s, double double1s, ::std::wstring string1s, com::wilutions::byps::test::api::cons::PAllTypesZ ALL, byps_ptr< BArray1< int32_t > > arrInt, byps_ptr< BArray4< int32_t > > arrInt4, byps_ptr< BArray1< ::std::wstring > > arrStrings, byps_ptr< BArray4< ::std::wstring > > arrStrings4, byps_ptr< BArray2< com::wilutions::byps::test::api::cons::PAllTypesZ > > arrAll)  {
	BSyncResultT<bool > syncResult;	
	async_compare_AllTypesC(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteConstants::async_compare_AllTypesC(bool bool1s, bool bool2s, wchar_t char1s, ::std::wstring stringNull, wchar_t char2s, int16_t short1s, int32_t int1s, int64_t long1s, float float1s, double double1s, ::std::wstring string1s, com::wilutions::byps::test::api::cons::PAllTypesZ ALL, byps_ptr< BArray1< int32_t > > arrInt, byps_ptr< BArray4< int32_t > > arrInt4, byps_ptr< BArray1< ::std::wstring > > arrStrings, byps_ptr< BArray4< ::std::wstring > > arrStrings4, byps_ptr< BArray2< com::wilutions::byps::test::api::cons::PAllTypesZ > > arrAll, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteConstants_compare_AllTypesC(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_1 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_431648293(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BStub_RemoteConstants(transport));
	}
	else {
		com::wilutions::byps::test::api::remote::RemoteConstants* r = dynamic_cast<com::wilutions::byps::test::api::remote::RemoteConstants*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

com::wilutions::byps::test::api::enu::EnumPlanets BSkeleton_RemoteEnums::getPlanet()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteEnums::async_getPlanet(std::function< void (com::wilutions::byps::test::api::enu::EnumPlanets, BException ex) > asyncResult)  {
	com::wilutions::byps::test::api::enu::EnumPlanets ret = com::wilutions::byps::test::api::enu::EnumPlanets();
	try {
		ret = getPlanet();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteEnums::setPlanet(com::wilutions::byps::test::api::enu::EnumPlanets planet)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteEnums::async_setPlanet(com::wilutions::byps::test::api::enu::EnumPlanets planet, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setPlanet(planet);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
}}}}}}


namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

BStub_RemoteEnums::BStub_RemoteEnums(PTransport transport) 
	: BStub(transport) {}

com::wilutions::byps::test::api::enu::EnumPlanets BStub_RemoteEnums::getPlanet()  {
	BSyncResultT<com::wilutions::byps::test::api::enu::EnumPlanets > syncResult;	
	async_getPlanet([&syncResult](com::wilutions::byps::test::api::enu::EnumPlanets v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_RemoteEnums::async_getPlanet(std::function< void (com::wilutions::byps::test::api::enu::EnumPlanets, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteEnums_getPlanet());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< com::wilutions::byps::test::api::enu::EnumPlanets, BResult_1042475995 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_RemoteEnums::setPlanet(com::wilutions::byps::test::api::enu::EnumPlanets planet)  {
	BSyncResultT<bool > syncResult;	
	async_setPlanet(planet, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_RemoteEnums::async_setPlanet(com::wilutions::byps::test::api::enu::EnumPlanets planet, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_RemoteEnums_setPlanet(planet));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

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

void BSkeleton_RemoteInlineInstance::setActor(com::wilutions::byps::test::api::inl::PActor act)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteInlineInstance::async_setActor(com::wilutions::byps::test::api::inl::PActor act, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setActor(act);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
com::wilutions::byps::test::api::inl::PActor BSkeleton_RemoteInlineInstance::getActor()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteInlineInstance::async_getActor(std::function< void (com::wilutions::byps::test::api::inl::PActor, BException ex) > asyncResult)  {
	com::wilutions::byps::test::api::inl::PActor ret = com::wilutions::byps::test::api::inl::PActor();
	try {
		ret = getActor();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteInlineInstance::setPoint2DArray1dim(byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > pointArray)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteInlineInstance::async_setPoint2DArray1dim(byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > pointArray, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setPoint2DArray1dim(pointArray);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > BSkeleton_RemoteInlineInstance::getPoint2DArray1dim()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteInlineInstance::async_getPoint2DArray1dim(std::function< void (byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > >, BException ex) > asyncResult)  {
	byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > ret = byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > >();
	try {
		ret = getPoint2DArray1dim();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteInlineInstance::setPoint2DArray4dim(byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > > pointArray)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteInlineInstance::async_setPoint2DArray4dim(byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > > pointArray, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setPoint2DArray4dim(pointArray);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > > BSkeleton_RemoteInlineInstance::getPoint2DArray4dim()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteInlineInstance::async_getPoint2DArray4dim(std::function< void (byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > >, BException ex) > asyncResult)  {
	byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > > ret = byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > >();
	try {
		ret = getPoint2DArray4dim();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteInlineInstance::setPoint2DList(byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > pointList)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteInlineInstance::async_setPoint2DList(byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > pointList, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setPoint2DList(pointList);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > BSkeleton_RemoteInlineInstance::getPoint2DList()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteInlineInstance::async_getPoint2DList(std::function< void (byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > >, BException ex) > asyncResult)  {
	byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > ret = byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > >();
	try {
		ret = getPoint2DList();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteInlineInstance::setPoint2DListList(byps_ptr< ::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > > > pointListList)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteInlineInstance::async_setPoint2DListList(byps_ptr< ::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > > > pointListList, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setPoint2DListList(pointListList);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< ::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > > > BSkeleton_RemoteInlineInstance::getPoint2DListList()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteInlineInstance::async_getPoint2DListList(std::function< void (byps_ptr< ::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > > >, BException ex) > asyncResult)  {
	byps_ptr< ::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > > > ret = byps_ptr< ::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > > >();
	try {
		ret = getPoint2DListList();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_RemoteInlineInstance::setPoint2DMap(byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D > > pointMap)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteInlineInstance::async_setPoint2DMap(byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D > > pointMap, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setPoint2DMap(pointMap);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D > > BSkeleton_RemoteInlineInstance::getPoint2DMap()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_RemoteInlineInstance::async_getPoint2DMap(std::function< void (byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D > >, BException ex) > asyncResult)  {
	byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D > > ret = byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D > >();
	try {
		ret = getPoint2DMap();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
}}}}}}

