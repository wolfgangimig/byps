#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getPrimitiveTypes1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getPrimitiveTypes1::BRequest_RemoteListTypes_getPrimitiveTypes1() : BMethodRequest(380156079) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getPrimitiveTypes1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getPrimitiveTypes1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getPrimitiveTypes1([__byps__asyncResult](byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1544333227(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1940572240(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getPrimitiveTypes1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getPrimitiveTypes1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getPrimitiveTypes1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getShort1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getShort1::BRequest_RemoteListTypes_getShort1() : BMethodRequest(380156079) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getShort1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getShort1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getShort1([__byps__asyncResult](byps_ptr< ::std::vector< int16_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1997002548(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1573024156(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getShort1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getShort1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getShort1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getString1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getString1::BRequest_RemoteListTypes_getString1() : BMethodRequest(380156079) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getString1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getString1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getString1([__byps__asyncResult](byps_ptr< ::std::vector< ::std::wstring > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2123584667(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1173060367(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getString1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getString1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getString1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setBoolean1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setBoolean1::BRequest_RemoteListTypes_setBoolean1() : BMethodRequest(380156079) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setBoolean1::BRequest_RemoteListTypes_setBoolean1(byps_ptr< ::std::vector< bool > > boolean1)
	: BMethodRequest(380156079) 
	, boolean1(boolean1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setBoolean1::serialize(BIO& ar, const BVERSION version) {
	ar & boolean1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setBoolean1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_1882657404(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setBoolean1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setBoolean1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setBoolean1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setByte1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setByte1::BRequest_RemoteListTypes_setByte1() : BMethodRequest(380156079) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setByte1::BRequest_RemoteListTypes_setByte1(byps_ptr< ::std::vector< int8_t > > byte1)
	: BMethodRequest(380156079) 
	, byte1(byte1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setByte1::serialize(BIO& ar, const BVERSION version) {
	ar & byte1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setByte1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_758429070(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setByte1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setByte1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setByte1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setByte2
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setByte2::BRequest_RemoteListTypes_setByte2() : BMethodRequest(380156079) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setByte2::BRequest_RemoteListTypes_setByte2(byps_ptr< ::std::vector< PBytes > > byte2)
	: BMethodRequest(380156079) 
	, byte2(byte2)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setByte2::serialize(BIO& ar, const BVERSION version) {
	ar & byte2;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setByte2::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_758429071(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setByte2& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setByte2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setByte2());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setChar1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setChar1::BRequest_RemoteListTypes_setChar1() : BMethodRequest(380156079) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setChar1::BRequest_RemoteListTypes_setChar1(byps_ptr< ::std::vector< wchar_t > > char1)
	: BMethodRequest(380156079) 
	, char1(char1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setChar1::serialize(BIO& ar, const BVERSION version) {
	ar & char1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setChar1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_758828288(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setChar1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setChar1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setChar1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setDouble1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setDouble1::BRequest_RemoteListTypes_setDouble1() : BMethodRequest(380156079) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setDouble1::BRequest_RemoteListTypes_setDouble1(byps_ptr< ::std::vector< double > > double1)
	: BMethodRequest(380156079) 
	, double1(double1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setDouble1::serialize(BIO& ar, const BVERSION version) {
	ar & double1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setDouble1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_195505829(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setDouble1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setDouble1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setDouble1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setFloat1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setFloat1::BRequest_RemoteListTypes_setFloat1() : BMethodRequest(380156079) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setFloat1::BRequest_RemoteListTypes_setFloat1(byps_ptr< ::std::vector< float > > float1)
	: BMethodRequest(380156079) 
	, float1(float1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setFloat1::serialize(BIO& ar, const BVERSION version) {
	ar & float1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setFloat1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_2138824848(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setFloat1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setFloat1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setFloat1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setInt1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt1::BRequest_RemoteListTypes_setInt1() : BMethodRequest(380156079) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt1::BRequest_RemoteListTypes_setInt1(byps_ptr< ::std::vector< int32_t > > int1)
	: BMethodRequest(380156079) 
	, int1(int1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt1::serialize(BIO& ar, const BVERSION version) {
	ar & int1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_1360809955(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setInt2
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt2::BRequest_RemoteListTypes_setInt2() : BMethodRequest(380156079) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt2::BRequest_RemoteListTypes_setInt2(byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > > int2)
	: BMethodRequest(380156079) 
	, int2(int2)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt2::serialize(BIO& ar, const BVERSION version) {
	ar & int2;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt2::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_1360809954(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt2& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt2());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setInt3
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt3::BRequest_RemoteListTypes_setInt3() : BMethodRequest(380156079) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt3::BRequest_RemoteListTypes_setInt3(byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > > int3)
	: BMethodRequest(380156079) 
	, int3(int3)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt3::serialize(BIO& ar, const BVERSION version) {
	ar & int3;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt3::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->setInt3(int3, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1360809953(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt3& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt3*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt3());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setInt4
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt4::BRequest_RemoteListTypes_setInt4() : BMethodRequest(380156079) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt4::BRequest_RemoteListTypes_setInt4(byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > > int4)
	: BMethodRequest(380156079) 
	, int4(int4)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt4::serialize(BIO& ar, const BVERSION version) {
	ar & int4;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt4::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->setInt4(int4, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1360809952(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt4& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt4*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt4());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setLong1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setLong1::BRequest_RemoteListTypes_setLong1() : BMethodRequest(380156079) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setLong1::BRequest_RemoteListTypes_setLong1(byps_ptr< ::std::vector< int64_t > > long1)
	: BMethodRequest(380156079) 
	, long1(long1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setLong1::serialize(BIO& ar, const BVERSION version) {
	ar & long1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setLong1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_767360666(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setLong1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setLong1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setLong1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setObj1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setObj1::BRequest_RemoteListTypes_setObj1() : BMethodRequest(380156079) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setObj1::BRequest_RemoteListTypes_setObj1(byps_ptr< ::std::vector< PSerializable > > obj1)
	: BMethodRequest(380156079) 
	, obj1(obj1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setObj1::serialize(BIO& ar, const BVERSION version) {
	ar & obj1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setObj1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_1360643051(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setObj1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setObj1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setObj1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setPrimitiveTypes1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setPrimitiveTypes1::BRequest_RemoteListTypes_setPrimitiveTypes1() : BMethodRequest(380156079) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setPrimitiveTypes1::BRequest_RemoteListTypes_setPrimitiveTypes1(byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > primitiveTypes1)
	: BMethodRequest(380156079) 
	, primitiveTypes1(primitiveTypes1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setPrimitiveTypes1::serialize(BIO& ar, const BVERSION version) {
	ar & primitiveTypes1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setPrimitiveTypes1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_1434361404(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setPrimitiveTypes1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setPrimitiveTypes1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setPrimitiveTypes1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setShort1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setShort1::BRequest_RemoteListTypes_setShort1() : BMethodRequest(380156079) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setShort1::BRequest_RemoteListTypes_setShort1(byps_ptr< ::std::vector< int16_t > > short1)
	: BMethodRequest(380156079) 
	, short1(short1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setShort1::serialize(BIO& ar, const BVERSION version) {
	ar & short1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setShort1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_1787641232(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setShort1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setShort1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setShort1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setString1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setString1::BRequest_RemoteListTypes_setString1() : BMethodRequest(380156079) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setString1::BRequest_RemoteListTypes_setString1(byps_ptr< ::std::vector< ::std::wstring > > string1)
	: BMethodRequest(380156079) 
	, string1(string1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setString1::serialize(BIO& ar, const BVERSION version) {
	ar & string1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setString1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
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
void BSerializer_763744869(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setString1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setString1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setString1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getBoolean1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getBoolean1::BRequest_RemoteMapTypes_getBoolean1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getBoolean1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getBoolean1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getBoolean1([__byps__asyncResult](byps_ptr< ::std::map< ::std::wstring , bool > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1279823631(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_461626272(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getBoolean1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getBoolean1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getBoolean1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getByte1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getByte1::BRequest_RemoteMapTypes_getByte1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getByte1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getByte1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getByte1([__byps__asyncResult](byps_ptr< ::std::map< double , int8_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1972793385(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1348711374(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getByte1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getByte1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getByte1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getByte2
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getByte2::BRequest_RemoteMapTypes_getByte2() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getByte2::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getByte2::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getByte2([__byps__asyncResult](byps_ptr< ::std::map< int32_t , PBytes > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1799280818(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1348711373(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getByte2& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getByte2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getByte2());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getChar1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getChar1::BRequest_RemoteMapTypes_getChar1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getChar1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getChar1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getChar1([__byps__asyncResult](byps_ptr< ::std::map< float , wchar_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_8789515(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1348312156(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getChar1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getChar1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getChar1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getDouble1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getDouble1::BRequest_RemoteMapTypes_getDouble1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getDouble1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getDouble1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getDouble1([__byps__asyncResult](byps_ptr< ::std::map< int8_t , double > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1487265161(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1836864439(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getDouble1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getDouble1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getDouble1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getFloat1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getFloat1::BRequest_RemoteMapTypes_getFloat1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getFloat1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getFloat1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getFloat1([__byps__asyncResult](byps_ptr< ::std::map< wchar_t , float > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_94341197(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1241980524(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getFloat1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getFloat1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getFloat1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getInt1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getInt1::BRequest_RemoteMapTypes_getInt1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getInt1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getInt1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->getInt1([__byps__asyncResult](byps_ptr< ::std::map< int32_t , int32_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1347703734(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1013140231(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getInt1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getInt1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getInt1());
	}
}
}}}}}
