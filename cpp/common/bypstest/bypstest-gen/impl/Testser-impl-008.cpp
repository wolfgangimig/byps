#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getInt2
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getInt2::BRequest_RemoteMapTypes_getInt2() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getInt2::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getInt2::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getInt2([__byps__asyncResult](byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1633750383(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1013140230(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getInt2& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getInt2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getInt2());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getLong1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getLong1::BRequest_RemoteMapTypes_getLong1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getLong1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getLong1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getLong1([__byps__asyncResult](byps_ptr< ::std::map< int16_t , int64_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1973996106(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1339779778(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getLong1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getLong1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getLong1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getObj1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getObj1::BRequest_RemoteMapTypes_getObj1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getObj1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getObj1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getObj1([__byps__asyncResult](byps_ptr< ::std::map< ::std::wstring , PSerializable > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1488550492(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1012973327(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getObj1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getObj1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getObj1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getPrimitiveTypes1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getPrimitiveTypes1::BRequest_RemoteMapTypes_getPrimitiveTypes1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getPrimitiveTypes1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getPrimitiveTypes1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getPrimitiveTypes1([__byps__asyncResult](byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_703065817(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_77071512(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getPrimitiveTypes1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getPrimitiveTypes1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getPrimitiveTypes1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getShort1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getShort1::BRequest_RemoteMapTypes_getShort1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getShort1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getShort1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getShort1([__byps__asyncResult](byps_ptr< ::std::map< int64_t , int16_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_601099730(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1610481740(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getShort1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getShort1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getShort1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getString1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getString1::BRequest_RemoteMapTypes_getString1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getString1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getString1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getString1([__byps__asyncResult](byps_ptr< ::std::map< ::std::wstring , ::std::wstring > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1710660846(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1268625399(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getString1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getString1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getString1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setBoolean1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setBoolean1::BRequest_RemoteMapTypes_setBoolean1() : BMethodRequest(80483097) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setBoolean1::BRequest_RemoteMapTypes_setBoolean1(byps_ptr< ::std::map< ::std::wstring , bool > > boolean1)
	: BMethodRequest(80483097) 
	, boolean1(boolean1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setBoolean1::serialize(BIO& ar, const BVERSION version) {
	ar & boolean1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setBoolean1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_550206100(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setBoolean1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setBoolean1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setBoolean1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setByte1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte1::BRequest_RemoteMapTypes_setByte1() : BMethodRequest(80483097) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte1::BRequest_RemoteMapTypes_setByte1(byps_ptr< ::std::map< double , int8_t > > byte1)
	: BMethodRequest(80483097) 
	, byte1(byte1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte1::serialize(BIO& ar, const BVERSION version) {
	ar & byte1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1909823834(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setByte2
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte2::BRequest_RemoteMapTypes_setByte2() : BMethodRequest(80483097) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte2::BRequest_RemoteMapTypes_setByte2(byps_ptr< ::std::map< int32_t , PBytes > > byte2)
	: BMethodRequest(80483097) 
	, byte2(byte2)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte2::serialize(BIO& ar, const BVERSION version) {
	ar & byte2;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte2::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1909823833(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte2& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte2());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setChar1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setChar1::BRequest_RemoteMapTypes_setChar1() : BMethodRequest(80483097) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setChar1::BRequest_RemoteMapTypes_setChar1(byps_ptr< ::std::map< float , wchar_t > > char1)
	: BMethodRequest(80483097) 
	, char1(char1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setChar1::serialize(BIO& ar, const BVERSION version) {
	ar & char1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setChar1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1909424616(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setChar1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setChar1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setChar1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setDouble1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1::BRequest_RemoteMapTypes_setDouble1() : BMethodRequest(80483097) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1::BRequest_RemoteMapTypes_setDouble1(byps_ptr< ::std::map< int8_t , double > > double1)
	: BMethodRequest(80483097) 
	, double1(double1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1::serialize(BIO& ar, const BVERSION version) {
	ar & double1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_99940797(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setFloat1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1::BRequest_RemoteMapTypes_setFloat1() : BMethodRequest(80483097) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1::BRequest_RemoteMapTypes_setFloat1(byps_ptr< ::std::map< wchar_t , float > > float1)
	: BMethodRequest(80483097) 
	, float1(float1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1::serialize(BIO& ar, const BVERSION version) {
	ar & float1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1027363448(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setInt1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt1::BRequest_RemoteMapTypes_setInt1() : BMethodRequest(80483097) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt1::BRequest_RemoteMapTypes_setInt1(byps_ptr< ::std::map< int32_t , int32_t > > int1)
	: BMethodRequest(80483097) 
	, int1(int1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt1::serialize(BIO& ar, const BVERSION version) {
	ar & int1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1046969349(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setInt2
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt2::BRequest_RemoteMapTypes_setInt2() : BMethodRequest(80483097) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt2::BRequest_RemoteMapTypes_setInt2(byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > > int2)
	: BMethodRequest(80483097) 
	, int2(int2)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt2::serialize(BIO& ar, const BVERSION version) {
	ar & int2;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt2::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1046969350(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt2& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt2());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setLong1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setLong1::BRequest_RemoteMapTypes_setLong1() : BMethodRequest(80483097) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setLong1::BRequest_RemoteMapTypes_setLong1(byps_ptr< ::std::map< int16_t , int64_t > > long1)
	: BMethodRequest(80483097) 
	, long1(long1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setLong1::serialize(BIO& ar, const BVERSION version) {
	ar & long1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setLong1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1900892238(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setLong1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setLong1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setLong1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setObj1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setObj1::BRequest_RemoteMapTypes_setObj1() : BMethodRequest(80483097) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setObj1::BRequest_RemoteMapTypes_setObj1(byps_ptr< ::std::map< ::std::wstring , PSerializable > > obj1)
	: BMethodRequest(80483097) 
	, obj1(obj1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setObj1::serialize(BIO& ar, const BVERSION version) {
	ar & obj1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setObj1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1047136253(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setObj1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setObj1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setObj1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setPrimitiveTypes1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setPrimitiveTypes1::BRequest_RemoteMapTypes_setPrimitiveTypes1() : BMethodRequest(80483097) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setPrimitiveTypes1::BRequest_RemoteMapTypes_setPrimitiveTypes1(byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes > > primitiveTypes1)
	: BMethodRequest(80483097) 
	, primitiveTypes1(primitiveTypes1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setPrimitiveTypes1::serialize(BIO& ar, const BVERSION version) {
	ar & primitiveTypes1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setPrimitiveTypes1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_842962140(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setPrimitiveTypes1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setPrimitiveTypes1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setPrimitiveTypes1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setShort1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setShort1::BRequest_RemoteMapTypes_setShort1() : BMethodRequest(80483097) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setShort1::BRequest_RemoteMapTypes_setShort1(byps_ptr< ::std::map< int64_t , int16_t > > short1)
	: BMethodRequest(80483097) 
	, short1(short1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setShort1::serialize(BIO& ar, const BVERSION version) {
	ar & short1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setShort1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1395864664(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setShort1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setShort1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setShort1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setString1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setString1::BRequest_RemoteMapTypes_setString1() : BMethodRequest(80483097) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setString1::BRequest_RemoteMapTypes_setString1(byps_ptr< ::std::map< ::std::wstring , ::std::wstring > > string1)
	: BMethodRequest(80483097) 
	, string1(string1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setString1::serialize(BIO& ar, const BVERSION version) {
	ar & string1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setString1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->setString1(string1, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_668179837(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setString1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setString1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setString1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_add
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_add::BRequest_RemotePrimitiveTypes_add() : BMethodRequest(1341983932) {
	a = 0;
	b = 0;
}
com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_add::BRequest_RemotePrimitiveTypes_add(int32_t a, int32_t b)
	: BMethodRequest(1341983932) 
	, a(a)
	, b(b)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_add::serialize(BIO& ar, const BVERSION version) {
	ar & a;
	ar & b;
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_add::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->add(a, b, [__byps__asyncResult](int32_t __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_5(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1073583639(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_add& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_add*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_add());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getBool
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getBool::BRequest_RemotePrimitiveTypes_getBool() : BMethodRequest(1341983932) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getBool::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getBool::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->getBool([__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2090997206(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getBool& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getBool*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getBool());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getByte
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getByte::BRequest_RemotePrimitiveTypes_getByte() : BMethodRequest(1341983932) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getByte::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getByte::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->getByte([__byps__asyncResult](int8_t __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2091006964(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getByte& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getByte*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getByte());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getChar
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getChar::BRequest_RemotePrimitiveTypes_getChar() : BMethodRequest(1341983932) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getChar::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getChar::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->getChar([__byps__asyncResult](wchar_t __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_4(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2091019842(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getChar& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getChar*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getChar());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getDouble
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getDouble::BRequest_RemotePrimitiveTypes_getDouble() : BMethodRequest(1341983932) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getDouble::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getDouble::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->getDouble([__byps__asyncResult](double __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_8(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_538948675(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getDouble& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getDouble*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getDouble());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getFloat
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getFloat::BRequest_RemotePrimitiveTypes_getFloat() : BMethodRequest(1341983932) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getFloat::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getFloat::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->getFloat([__byps__asyncResult](float __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_7(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_400008432(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getFloat& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getFloat*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getFloat());
	}
}
}}}}}
