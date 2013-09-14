#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getBoolean1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getBoolean1::BRequest_RemoteSetTypes_getBoolean1() : BMethodRequest(1156008353) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getBoolean1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getBoolean1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getBoolean1([__byps__asyncResult](byps_ptr< ::std::set< bool > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1365696060(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1690813926(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getBoolean1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getBoolean1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getBoolean1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getByte1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getByte1::BRequest_RemoteSetTypes_getByte1() : BMethodRequest(1156008353) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getByte1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getByte1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getByte1([__byps__asyncResult](byps_ptr< ::std::set< int8_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_31512998(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2125684552(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getByte1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getByte1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getByte1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getByte2
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getByte2::BRequest_RemoteSetTypes_getByte2() : BMethodRequest(1156008353) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getByte2::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getByte2::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getByte2([__byps__asyncResult](byps_ptr< ::std::set< PBytes > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2052431866(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2125684551(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getByte2& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getByte2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getByte2());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getChar1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getChar1::BRequest_RemoteSetTypes_getChar1() : BMethodRequest(1156008353) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getChar1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getChar1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getChar1([__byps__asyncResult](byps_ptr< ::std::set< wchar_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_936607009(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2125285334(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getChar1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getChar1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getChar1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getDouble1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getDouble1::BRequest_RemoteSetTypes_getDouble1() : BMethodRequest(1156008353) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getDouble1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getDouble1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getDouble1([__byps__asyncResult](byps_ptr< ::std::set< double > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1320560671(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1183778993(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getDouble1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getDouble1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getDouble1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getFloat1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getFloat1::BRequest_RemoteSetTypes_getFloat1() : BMethodRequest(1156008353) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getFloat1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getFloat1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getFloat1([__byps__asyncResult](byps_ptr< ::std::set< float > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1898022288(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1369351514(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getFloat1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getFloat1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getFloat1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getInt1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getInt1::BRequest_RemoteSetTypes_getInt1() : BMethodRequest(1156008353) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getInt1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getInt1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getInt1([__byps__asyncResult](byps_ptr< ::std::set< int32_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1493282670(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_68372557(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getInt1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getInt1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getInt1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getInt2
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getInt2::BRequest_RemoteSetTypes_getInt2() : BMethodRequest(1156008353) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getInt2::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getInt2::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getInt2([__byps__asyncResult](byps_ptr< ::std::set< byps_ptr< BArray1< int32_t > > > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1406124761(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_68372556(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getInt2& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getInt2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getInt2());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getLong1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getLong1::BRequest_RemoteSetTypes_getLong1() : BMethodRequest(1156008353) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getLong1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getLong1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getLong1([__byps__asyncResult](byps_ptr< ::std::set< int64_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1457164460(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2116752956(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getLong1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getLong1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getLong1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getObj1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getObj1::BRequest_RemoteSetTypes_getObj1() : BMethodRequest(1156008353) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getObj1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getObj1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getObj1([__byps__asyncResult](byps_ptr< ::std::set< PSerializable > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_14(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_68205653(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getObj1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getObj1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getObj1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getPrimitiveTypes1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getPrimitiveTypes1::BRequest_RemoteSetTypes_getPrimitiveTypes1() : BMethodRequest(1156008353) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getPrimitiveTypes1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getPrimitiveTypes1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getPrimitiveTypes1([__byps__asyncResult](byps_ptr< ::std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1280571537(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1802821742(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getPrimitiveTypes1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getPrimitiveTypes1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getPrimitiveTypes1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getShort1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getShort1::BRequest_RemoteSetTypes_getShort1() : BMethodRequest(1156008353) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getShort1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getShort1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getShort1([__byps__asyncResult](byps_ptr< ::std::set< int16_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2028443792(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1000850298(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getShort1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getShort1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getShort1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getString1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getString1::BRequest_RemoteSetTypes_getString1() : BMethodRequest(1156008353) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getString1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getString1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->getString1([__byps__asyncResult](byps_ptr< ::std::set< ::std::wstring > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1888799711(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_615539953(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getString1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getString1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getString1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setBoolean1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setBoolean1::BRequest_RemoteSetTypes_setBoolean1() : BMethodRequest(1156008353) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setBoolean1::BRequest_RemoteSetTypes_setBoolean1(byps_ptr< ::std::set< bool > > boolean1)
	: BMethodRequest(1156008353) 
	, boolean1(boolean1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setBoolean1::serialize(BIO& ar, const BVERSION version) {
	ar & boolean1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setBoolean1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->setBoolean1(boolean1, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1779393754(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setBoolean1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setBoolean1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setBoolean1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setByte1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setByte1::BRequest_RemoteSetTypes_setByte1() : BMethodRequest(1156008353) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setByte1::BRequest_RemoteSetTypes_setByte1(byps_ptr< ::std::set< int8_t > > byte1)
	: BMethodRequest(1156008353) 
	, byte1(byte1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setByte1::serialize(BIO& ar, const BVERSION version) {
	ar & byte1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setByte1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->setByte1(byte1, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1608170284(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setByte1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setByte1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setByte1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setByte2
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setByte2::BRequest_RemoteSetTypes_setByte2() : BMethodRequest(1156008353) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setByte2::BRequest_RemoteSetTypes_setByte2(byps_ptr< ::std::set< PBytes > > byte2)
	: BMethodRequest(1156008353) 
	, byte2(byte2)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setByte2::serialize(BIO& ar, const BVERSION version) {
	ar & byte2;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setByte2::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->setByte2(byte2, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1608170285(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setByte2& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setByte2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setByte2());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setChar1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setChar1::BRequest_RemoteSetTypes_setChar1() : BMethodRequest(1156008353) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setChar1::BRequest_RemoteSetTypes_setChar1(byps_ptr< ::std::set< wchar_t > > char1)
	: BMethodRequest(1156008353) 
	, char1(char1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setChar1::serialize(BIO& ar, const BVERSION version) {
	ar & char1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setChar1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->setChar1(char1, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1608569502(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setChar1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setChar1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setChar1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setDouble1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setDouble1::BRequest_RemoteSetTypes_setDouble1() : BMethodRequest(1156008353) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setDouble1::BRequest_RemoteSetTypes_setDouble1(byps_ptr< ::std::set< double > > double1)
	: BMethodRequest(1156008353) 
	, double1(double1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setDouble1::serialize(BIO& ar, const BVERSION version) {
	ar & double1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setDouble1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->setDouble1(double1, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_753026243(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setDouble1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setDouble1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setDouble1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setFloat1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setFloat1::BRequest_RemoteSetTypes_setFloat1() : BMethodRequest(1156008353) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setFloat1::BRequest_RemoteSetTypes_setFloat1(byps_ptr< ::std::set< float > > float1)
	: BMethodRequest(1156008353) 
	, float1(float1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setFloat1::serialize(BIO& ar, const BVERSION version) {
	ar & float1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setFloat1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->setFloat1(float1, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1583968590(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setFloat1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setFloat1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setFloat1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setInt1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setInt1::BRequest_RemoteSetTypes_setInt1() : BMethodRequest(1156008353) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setInt1::BRequest_RemoteSetTypes_setInt1(byps_ptr< ::std::set< int32_t > > int1)
	: BMethodRequest(1156008353) 
	, int1(int1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setInt1::serialize(BIO& ar, const BVERSION version) {
	ar & int1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setInt1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->setInt1(int1, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1991737023(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setInt1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setInt1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setInt1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setInt2
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setInt2::BRequest_RemoteSetTypes_setInt2() : BMethodRequest(1156008353) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setInt2::BRequest_RemoteSetTypes_setInt2(byps_ptr< ::std::set< byps_ptr< BArray1< int32_t > > > > int2)
	: BMethodRequest(1156008353) 
	, int2(int2)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setInt2::serialize(BIO& ar, const BVERSION version) {
	ar & int2;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setInt2::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->setInt2(int2, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1991737024(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setInt2& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setInt2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setInt2());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setLong1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setLong1::BRequest_RemoteSetTypes_setLong1() : BMethodRequest(1156008353) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setLong1::BRequest_RemoteSetTypes_setLong1(byps_ptr< ::std::set< int64_t > > long1)
	: BMethodRequest(1156008353) 
	, long1(long1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setLong1::serialize(BIO& ar, const BVERSION version) {
	ar & long1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setLong1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->setLong1(long1, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1617101880(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setLong1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setLong1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setLong1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setObj1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setObj1::BRequest_RemoteSetTypes_setObj1() : BMethodRequest(1156008353) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setObj1::BRequest_RemoteSetTypes_setObj1(byps_ptr< ::std::set< PSerializable > > obj1)
	: BMethodRequest(1156008353) 
	, obj1(obj1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setObj1::serialize(BIO& ar, const BVERSION version) {
	ar & obj1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setObj1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->setObj1(obj1, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1991903927(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setObj1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setObj1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setObj1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setPrimitiveTypes1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setPrimitiveTypes1::BRequest_RemoteSetTypes_setPrimitiveTypes1() : BMethodRequest(1156008353) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setPrimitiveTypes1::BRequest_RemoteSetTypes_setPrimitiveTypes1(byps_ptr< ::std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > primitiveTypes1)
	: BMethodRequest(1156008353) 
	, primitiveTypes1(primitiveTypes1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setPrimitiveTypes1::serialize(BIO& ar, const BVERSION version) {
	ar & primitiveTypes1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setPrimitiveTypes1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->setPrimitiveTypes1(primitiveTypes1, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1572111902(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setPrimitiveTypes1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setPrimitiveTypes1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setPrimitiveTypes1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setShort1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setShort1::BRequest_RemoteSetTypes_setShort1() : BMethodRequest(1156008353) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setShort1::BRequest_RemoteSetTypes_setShort1(byps_ptr< ::std::set< int16_t > > short1)
	: BMethodRequest(1156008353) 
	, short1(short1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setShort1::serialize(BIO& ar, const BVERSION version) {
	ar & short1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setShort1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
	__byps__remoteT->setShort1(short1, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1215467374(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setShort1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setShort1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setShort1());
	}
}
}}}}}
