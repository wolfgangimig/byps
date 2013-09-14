#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getByte
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getByte::BRequest_RemoteArrayTypes4dim_getByte() : BMethodRequest(1557173854) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getByte::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getByte::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getByte([__byps__asyncResult](byps_ptr< BArray4< int8_t > > __byps__result, BException __byps__ex) {
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
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
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getChar::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getChar::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getChar([__byps__asyncResult](byps_ptr< BArray4< wchar_t > > __byps__result, BException __byps__ex) {
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
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
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDouble::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDouble::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getDouble([__byps__asyncResult](byps_ptr< BArray4< double > > __byps__result, BException __byps__ex) {
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
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
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getFloat::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getFloat::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getFloat([__byps__asyncResult](byps_ptr< BArray4< float > > __byps__result, BException __byps__ex) {
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
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
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getInt::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getInt::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getInt([__byps__asyncResult](byps_ptr< BArray4< int32_t > > __byps__result, BException __byps__ex) {
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
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
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getLong
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getLong::BRequest_RemoteArrayTypes4dim_getLong() : BMethodRequest(1557173854) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getLong::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getLong::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getLong([__byps__asyncResult](byps_ptr< BArray4< int64_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_846419204(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2033150218(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getLong& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getLong*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getLong());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getObject
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getObject::BRequest_RemoteArrayTypes4dim_getObject() : BMethodRequest(1557173854) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getObject::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getObject::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getObject([__byps__asyncResult](byps_ptr< BArray4< PSerializable > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_124584219(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_278996403(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getObject& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getObject*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getObject());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getPrimitiveTypes
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getPrimitiveTypes::BRequest_RemoteArrayTypes4dim_getPrimitiveTypes() : BMethodRequest(1557173854) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getPrimitiveTypes::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getPrimitiveTypes::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getPrimitiveTypes([__byps__asyncResult](byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1503107601(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1650564320(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getPrimitiveTypes& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getPrimitiveTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getPrimitiveTypes());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getShort
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getShort::BRequest_RemoteArrayTypes4dim_getShort() : BMethodRequest(1557173854) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getShort::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getShort::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getShort([__byps__asyncResult](byps_ptr< BArray4< int16_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1859644668(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1390595154(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getShort& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getShort*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getShort());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getString
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getString::BRequest_RemoteArrayTypes4dim_getString() : BMethodRequest(1557173854) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getString::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getString::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getString([__byps__asyncResult](byps_ptr< BArray4< ::std::wstring > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_588723219(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_147613921(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getString& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getString*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getString());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setBool
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setBool::BRequest_RemoteArrayTypes4dim_setBool() : BMethodRequest(1557173854) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setBool::BRequest_RemoteArrayTypes4dim_setBool(byps_ptr< BArray4< bool > > v)
	: BMethodRequest(1557173854) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setBool::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setBool::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setBool(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_202005372(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setBool& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setBool*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setBool());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setByte
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setByte::BRequest_RemoteArrayTypes4dim_setByte() : BMethodRequest(1557173854) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setByte::BRequest_RemoteArrayTypes4dim_setByte(byps_ptr< BArray4< int8_t > > v)
	: BMethodRequest(1557173854) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setByte::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setByte::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setByte(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_201995614(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setByte& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setByte*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setByte());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setChar
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setChar::BRequest_RemoteArrayTypes4dim_setChar() : BMethodRequest(1557173854) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setChar::BRequest_RemoteArrayTypes4dim_setChar(byps_ptr< BArray4< wchar_t > > v)
	: BMethodRequest(1557173854) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setChar::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setChar::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setChar(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_201982736(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setChar& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setChar*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setChar());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setDouble
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDouble::BRequest_RemoteArrayTypes4dim_setDouble() : BMethodRequest(1557173854) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDouble::BRequest_RemoteArrayTypes4dim_setDouble(byps_ptr< BArray4< double > > v)
	: BMethodRequest(1557173854) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDouble::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDouble::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setDouble(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_796203285(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDouble& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDouble*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDouble());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setFloat
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setFloat::BRequest_RemoteArrayTypes4dim_setFloat() : BMethodRequest(1557173854) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setFloat::BRequest_RemoteArrayTypes4dim_setFloat(byps_ptr< BArray4< float > > v)
	: BMethodRequest(1557173854) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setFloat::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setFloat::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setFloat(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1963594750(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setFloat& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setFloat*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setFloat());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setInt
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setInt::BRequest_RemoteArrayTypes4dim_setInt() : BMethodRequest(1557173854) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setInt::BRequest_RemoteArrayTypes4dim_setInt(byps_ptr< BArray4< int32_t > > v)
	: BMethodRequest(1557173854) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setInt::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setInt::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setInt(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1933153045(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setInt& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setInt*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setInt());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setLong
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setLong::BRequest_RemoteArrayTypes4dim_setLong() : BMethodRequest(1557173854) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setLong::BRequest_RemoteArrayTypes4dim_setLong(byps_ptr< BArray4< int64_t > > v)
	: BMethodRequest(1557173854) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setLong::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setLong::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setLong(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_201707498(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setLong& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setLong*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setLong());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setObject
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setObject::BRequest_RemoteArrayTypes4dim_setObject() : BMethodRequest(1557173854) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setObject::BRequest_RemoteArrayTypes4dim_setObject(byps_ptr< BArray4< PSerializable > > v)
	: BMethodRequest(1557173854) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setObject::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setObject::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setObject(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_493613479(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setObject& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setObject*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setObject());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setPrimitiveTypes
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setPrimitiveTypes::BRequest_RemoteArrayTypes4dim_setPrimitiveTypes() : BMethodRequest(1557173854) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setPrimitiveTypes::BRequest_RemoteArrayTypes4dim_setPrimitiveTypes(byps_ptr< BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > v)
	: BMethodRequest(1557173854) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setPrimitiveTypes::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setPrimitiveTypes::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setPrimitiveTypes(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_710411500(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setPrimitiveTypes& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setPrimitiveTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setPrimitiveTypes());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setShort
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setShort::BRequest_RemoteArrayTypes4dim_setShort() : BMethodRequest(1557173854) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setShort::BRequest_RemoteArrayTypes4dim_setShort(byps_ptr< BArray4< int16_t > > v)
	: BMethodRequest(1557173854) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setShort::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setShort::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setShort(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1951707614(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setShort& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setShort*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setShort());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_setString
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setString::BRequest_RemoteArrayTypes4dim_setString() : BMethodRequest(1557173854) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setString::BRequest_RemoteArrayTypes4dim_setString(byps_ptr< BArray4< ::std::wstring > > v)
	: BMethodRequest(1557173854) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setString::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setString::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->setString(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_362230997(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setString& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setString*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setString());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteConstants_compare_AllTypesC
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteConstants_compare_AllTypesC::BRequest_RemoteConstants_compare_AllTypesC() : BMethodRequest(431648293) {
	bool1s = false;
	bool2s = false;
	char1s = '\0';
	char2s = '\0';
	short1s = 0;
	int1s = 0;
	long1s = 0;
	float1s = 0;
	double1s = 0;
}
com::wilutions::byps::test::api::remote::BRequest_RemoteConstants_compare_AllTypesC::BRequest_RemoteConstants_compare_AllTypesC(bool bool1s, bool bool2s, wchar_t char1s, ::std::wstring stringNull, wchar_t char2s, int16_t short1s, int32_t int1s, int64_t long1s, float float1s, double double1s, ::std::wstring string1s, com::wilutions::byps::test::api::cons::PAllTypesZ ALL, byps_ptr< BArray1< int32_t > > arrInt, byps_ptr< BArray4< int32_t > > arrInt4, byps_ptr< BArray1< ::std::wstring > > arrStrings, byps_ptr< BArray4< ::std::wstring > > arrStrings4, byps_ptr< BArray2< com::wilutions::byps::test::api::cons::PAllTypesZ > > arrAll)
	: BMethodRequest(431648293) 
	, bool1s(bool1s)
	, bool2s(bool2s)
	, char1s(char1s)
	, stringNull(stringNull)
	, char2s(char2s)
	, short1s(short1s)
	, int1s(int1s)
	, long1s(long1s)
	, float1s(float1s)
	, double1s(double1s)
	, string1s(string1s)
	, ALL(ALL)
	, arrInt(arrInt)
	, arrInt4(arrInt4)
	, arrStrings(arrStrings)
	, arrStrings4(arrStrings4)
	, arrAll(arrAll)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteConstants_compare_AllTypesC::serialize(BIO& ar, const BVERSION version) {
	ar & bool1s;
	ar & bool2s;
	ar & char1s;
	ar & char2s;
	ar & double1s;
	ar & float1s;
	ar & int1s;
	ar & long1s;
	ar & short1s;
	ar & string1s;
	ar & stringNull;
	ar & ALL;
	ar & arrAll;
	ar & arrInt;
	ar & arrInt4;
	ar & arrStrings;
	ar & arrStrings4;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteConstants_compare_AllTypesC::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteConstants __byps__remoteT = byps_ptr_cast<RemoteConstants>(__byps__remote);
	__byps__remoteT->compare_AllTypesC(bool1s, bool2s, char1s, stringNull, char2s, short1s, int1s, long1s, float1s, double1s, string1s, ALL, arrInt, arrInt4, arrStrings, arrStrings4, arrAll, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_862752254(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteConstants_compare_AllTypesC& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteConstants_compare_AllTypesC*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteConstants_compare_AllTypesC());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteConstants_compare_HebrewC
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteConstants_compare_HebrewC::BRequest_RemoteConstants_compare_HebrewC() : BMethodRequest(431648293) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteConstants_compare_HebrewC::BRequest_RemoteConstants_compare_HebrewC(com::wilutions::byps::test::api::cons::PHebrewZ ALEPH, com::wilutions::byps::test::api::cons::PHebrewZ BETH)
	: BMethodRequest(431648293) 
	, ALEPH(ALEPH)
	, BETH(BETH)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteConstants_compare_HebrewC::serialize(BIO& ar, const BVERSION version) {
	ar & ALEPH;
	ar & BETH;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteConstants_compare_HebrewC::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteConstants __byps__remoteT = byps_ptr_cast<RemoteConstants>(__byps__remote);
	__byps__remoteT->compare_HebrewC(ALEPH, BETH, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1570751625(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteConstants_compare_HebrewC& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteConstants_compare_HebrewC*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteConstants_compare_HebrewC());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteEnums_getPlanet
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteEnums_getPlanet::BRequest_RemoteEnums_getPlanet() : BMethodRequest(359349400) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteEnums_getPlanet::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteEnums_getPlanet::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteEnums __byps__remoteT = byps_ptr_cast<RemoteEnums>(__byps__remote);
	__byps__remoteT->getPlanet([__byps__asyncResult](com::wilutions::byps::test::api::enu::EnumPlanets __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1042475995(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_627010462(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteEnums_getPlanet& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteEnums_getPlanet*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteEnums_getPlanet());
	}
}
}}}}}
