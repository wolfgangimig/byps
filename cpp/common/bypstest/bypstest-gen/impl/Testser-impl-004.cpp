#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getShort
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort::BRequest_RemoteArrayTypes1dim_getShort() : BMethodRequest(1557084481) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_getShort([__byps__asyncResult](byps_ptr< BArray1< int16_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2067161310(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_510386133(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getString
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString::BRequest_RemoteArrayTypes1dim_getString() : BMethodRequest(1557084481) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_getString([__byps__asyncResult](byps_ptr< BArray1< ::std::wstring > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1888107655(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1369061954(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setBool
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool::BRequest_RemoteArrayTypes1dim_setBool() : BMethodRequest(1557084481) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool::BRequest_RemoteArrayTypes1dim_setBool(byps_ptr< BArray1< bool > > v)
	: BMethodRequest(1557084481) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_setBool(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_589253529(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setByte
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte::BRequest_RemoteArrayTypes1dim_setByte() : BMethodRequest(1557084481) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte::BRequest_RemoteArrayTypes1dim_setByte(PBytes v)
	: BMethodRequest(1557084481) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_setByte(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_589243771(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setChar
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setChar::BRequest_RemoteArrayTypes1dim_setChar() : BMethodRequest(1557084481) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setChar::BRequest_RemoteArrayTypes1dim_setChar(byps_ptr< BArray1< wchar_t > > v)
	: BMethodRequest(1557084481) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setChar::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setChar::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_setChar(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_589230893(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setChar& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setChar*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setChar());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setDouble
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDouble::BRequest_RemoteArrayTypes1dim_setDouble() : BMethodRequest(1557084481) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDouble::BRequest_RemoteArrayTypes1dim_setDouble(byps_ptr< BArray1< double > > v)
	: BMethodRequest(1557084481) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDouble::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDouble::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_setDouble(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_720472590(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDouble& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDouble*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDouble());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setFloat
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setFloat::BRequest_RemoteArrayTypes1dim_setFloat() : BMethodRequest(1557084481) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setFloat::BRequest_RemoteArrayTypes1dim_setFloat(byps_ptr< BArray1< float > > v)
	: BMethodRequest(1557084481) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setFloat::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setFloat::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_setFloat(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1083385729(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setFloat& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setFloat*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setFloat());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setInt
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setInt::BRequest_RemoteArrayTypes1dim_setInt() : BMethodRequest(1557084481) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setInt::BRequest_RemoteArrayTypes1dim_setInt(byps_ptr< BArray1< int32_t > > v)
	: BMethodRequest(1557084481) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setInt::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setInt::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_setInt(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1265927470(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setInt& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setInt*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setInt());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setLong
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setLong::BRequest_RemoteArrayTypes1dim_setLong() : BMethodRequest(1557084481) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setLong::BRequest_RemoteArrayTypes1dim_setLong(byps_ptr< BArray1< int64_t > > v)
	: BMethodRequest(1557084481) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setLong::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setLong::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_setLong(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_588955655(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setLong& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setLong*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setLong());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setObject
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setObject::BRequest_RemoteArrayTypes1dim_setObject() : BMethodRequest(1557084481) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setObject::BRequest_RemoteArrayTypes1dim_setObject(byps_ptr< BArray1< PSerializable > > v)
	: BMethodRequest(1557084481) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setObject::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setObject::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_setObject(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1023062396(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setObject& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setObject*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setObject());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setPrimitiveTypes
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes() : BMethodRequest(1557084481) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes(byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v)
	: BMethodRequest(1557084481) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_setPrimitiveTypes(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1765354225(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setShort
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setShort::BRequest_RemoteArrayTypes1dim_setShort() : BMethodRequest(1557084481) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setShort::BRequest_RemoteArrayTypes1dim_setShort(byps_ptr< BArray1< int16_t > > v)
	: BMethodRequest(1557084481) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setShort::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setShort::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_setShort(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1071498593(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setShort& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setShort*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setShort());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setString
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setString::BRequest_RemoteArrayTypes1dim_setString() : BMethodRequest(1557084481) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setString::BRequest_RemoteArrayTypes1dim_setString(byps_ptr< BArray1< ::std::wstring > > v)
	: BMethodRequest(1557084481) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setString::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setString::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->async_setString(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1154444878(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setString& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setString*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setString());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes23_sendArraysClass
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysClass::BRequest_RemoteArrayTypes23_sendArraysClass() : BMethodRequest(2081058997) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysClass::BRequest_RemoteArrayTypes23_sendArraysClass(byps_ptr< BArray2< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr2, byps_ptr< BArray3< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr3, byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > arr4)
	: BMethodRequest(2081058997) 
	, arr2(arr2)
	, arr3(arr3)
	, arr4(arr4)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysClass::serialize(BIO& ar, const BVERSION version) {
	ar & arr2;
	ar & arr3;
	ar & arr4;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysClass::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes23 __byps__remoteT = byps_ptr_cast<RemoteArrayTypes23>(__byps__remote);
	__byps__remoteT->async_sendArraysClass(arr2, arr3, arr4, [__byps__asyncResult](byps_ptr< BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_801243127(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1004457221(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysClass& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysClass*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysClass());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes23_sendArraysInline
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInline::BRequest_RemoteArrayTypes23_sendArraysInline() : BMethodRequest(2081058997) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInline::BRequest_RemoteArrayTypes23_sendArraysInline(byps_ptr< BArray2< com::wilutions::byps::test::api::inl::Point2D > > arr2, byps_ptr< BArray3< com::wilutions::byps::test::api::inl::Point2D > > arr3, byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > > arr4)
	: BMethodRequest(2081058997) 
	, arr2(arr2)
	, arr3(arr3)
	, arr4(arr4)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInline::serialize(BIO& ar, const BVERSION version) {
	ar & arr2;
	ar & arr3;
	ar & arr4;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInline::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes23 __byps__remoteT = byps_ptr_cast<RemoteArrayTypes23>(__byps__remote);
	__byps__remoteT->async_sendArraysInline(arr2, arr3, arr4, [__byps__asyncResult](byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2049740106(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_899462794(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInline& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInline*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInline());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes23_sendArraysInt
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInt::BRequest_RemoteArrayTypes23_sendArraysInt() : BMethodRequest(2081058997) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInt::BRequest_RemoteArrayTypes23_sendArraysInt(byps_ptr< BArray2< int32_t > > arr2, byps_ptr< BArray3< int32_t > > arr3, byps_ptr< BArray4< int32_t > > arr4)
	: BMethodRequest(2081058997) 
	, arr2(arr2)
	, arr3(arr3)
	, arr4(arr4)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInt::serialize(BIO& ar, const BVERSION version) {
	ar & arr2;
	ar & arr3;
	ar & arr4;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInt::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes23 __byps__remoteT = byps_ptr_cast<RemoteArrayTypes23>(__byps__remote);
	__byps__remoteT->async_sendArraysInt(arr2, arr3, arr4, [__byps__asyncResult](byps_ptr< BArray1< int32_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_100361105(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1748523470(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInt& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInt*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInt());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes23_sendArraysObject
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysObject::BRequest_RemoteArrayTypes23_sendArraysObject() : BMethodRequest(2081058997) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysObject::BRequest_RemoteArrayTypes23_sendArraysObject(byps_ptr< BArray2< PSerializable > > arr2, byps_ptr< BArray3< PSerializable > > arr3, byps_ptr< BArray4< PSerializable > > arr4)
	: BMethodRequest(2081058997) 
	, arr2(arr2)
	, arr3(arr3)
	, arr4(arr4)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysObject::serialize(BIO& ar, const BVERSION version) {
	ar & arr2;
	ar & arr3;
	ar & arr4;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysObject::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes23 __byps__remoteT = byps_ptr_cast<RemoteArrayTypes23>(__byps__remote);
	__byps__remoteT->async_sendArraysObject(arr2, arr3, arr4, [__byps__asyncResult](byps_ptr< BArray1< PSerializable > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_183594037(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_738833892(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysObject& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysObject*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysObject());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes23_sendArraysString
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysString::BRequest_RemoteArrayTypes23_sendArraysString() : BMethodRequest(2081058997) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysString::BRequest_RemoteArrayTypes23_sendArraysString(byps_ptr< BArray2< ::std::wstring > > arr2, byps_ptr< BArray3< ::std::wstring > > arr3, byps_ptr< BArray4< ::std::wstring > > arr4)
	: BMethodRequest(2081058997) 
	, arr2(arr2)
	, arr3(arr3)
	, arr4(arr4)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysString::serialize(BIO& ar, const BVERSION version) {
	ar & arr2;
	ar & arr3;
	ar & arr4;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysString::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes23 __byps__remoteT = byps_ptr_cast<RemoteArrayTypes23>(__byps__remote);
	__byps__remoteT->async_sendArraysString(arr2, arr3, arr4, [__byps__asyncResult](byps_ptr< BArray1< ::std::wstring > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1888107655(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_607451410(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysString& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysString*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysString());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getBool
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getBool::BRequest_RemoteArrayTypes4dim_getBool() : BMethodRequest(1557173854) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getBool::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getBool::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->async_getBool([__byps__asyncResult](byps_ptr< BArray4< bool > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_945713488(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2032852344(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getBool& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getBool*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getBool());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getByte
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getByte::BRequest_RemoteArrayTypes4dim_getByte() : BMethodRequest(1557173854) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getByte::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getByte::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->async_getByte([__byps__asyncResult](byps_ptr< BArray4< int8_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1201775504(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2032862102(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getByte& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getByte*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getByte());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getChar
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getChar::BRequest_RemoteArrayTypes4dim_getChar() : BMethodRequest(1557173854) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getChar::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getChar::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->async_getChar([__byps__asyncResult](byps_ptr< BArray4< wchar_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_769021986(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2032874980(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getChar& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getChar*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getChar());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getDouble
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDouble::BRequest_RemoteArrayTypes4dim_getDouble() : BMethodRequest(1557173854) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDouble::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDouble::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->async_getDouble([__byps__asyncResult](byps_ptr< BArray4< double > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2087445849(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_581586209(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDouble& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDouble*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDouble());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getFloat
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getFloat::BRequest_RemoteArrayTypes4dim_getFloat() : BMethodRequest(1557173854) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getFloat::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getFloat::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->async_getFloat([__byps__asyncResult](byps_ptr< BArray4< float > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1516687588(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1402482290(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getFloat& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getFloat*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getFloat());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getInt
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getInt::BRequest_RemoteArrayTypes4dim_getInt() : BMethodRequest(1557173854) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:820
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getInt::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getInt::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->async_getInt([__byps__asyncResult](byps_ptr< BArray4< int32_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_39910537(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1589603233(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getInt& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getInt*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getInt());
	}
}
}}}}}
