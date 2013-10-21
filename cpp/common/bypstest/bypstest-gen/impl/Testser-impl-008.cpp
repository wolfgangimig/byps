#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setPrimitiveTypes1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setPrimitiveTypes1::BRequest_RemoteListTypes_setPrimitiveTypes1() : BMethodRequest(380156079) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:534
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setPrimitiveTypes1::BRequest_RemoteListTypes_setPrimitiveTypes1(const byps_ptr< ::std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1)
	: BMethodRequest(380156079) 
	, primitiveTypes1(primitiveTypes1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setShort1::BRequest_RemoteListTypes_setShort1() : BMethodRequest(380156079) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:534
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setShort1::BRequest_RemoteListTypes_setShort1(const byps_ptr< ::std::vector< int16_t > >& short1)
	: BMethodRequest(380156079) 
	, short1(short1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setString1::BRequest_RemoteListTypes_setString1() : BMethodRequest(380156079) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:534
com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setString1::BRequest_RemoteListTypes_setString1(const byps_ptr< ::std::vector< ::std::wstring > >& string1)
	: BMethodRequest(380156079) 
	, string1(string1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getBoolean1::BRequest_RemoteMapTypes_getBoolean1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getByte1::BRequest_RemoteMapTypes_getByte1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getByte2::BRequest_RemoteMapTypes_getByte2() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getChar1::BRequest_RemoteMapTypes_getChar1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getDouble1::BRequest_RemoteMapTypes_getDouble1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getFloat1::BRequest_RemoteMapTypes_getFloat1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getInt1::BRequest_RemoteMapTypes_getInt1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_getInt2
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getInt2::BRequest_RemoteMapTypes_getInt2() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getLong1::BRequest_RemoteMapTypes_getLong1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getObj1::BRequest_RemoteMapTypes_getObj1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getPrimitiveTypes1::BRequest_RemoteMapTypes_getPrimitiveTypes1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getShort1::BRequest_RemoteMapTypes_getShort1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getString1::BRequest_RemoteMapTypes_getString1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setBoolean1::BRequest_RemoteMapTypes_setBoolean1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:534
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setBoolean1::BRequest_RemoteMapTypes_setBoolean1(const byps_ptr< ::std::map< ::std::wstring , bool > >& boolean1)
	: BMethodRequest(80483097) 
	, boolean1(boolean1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte1::BRequest_RemoteMapTypes_setByte1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:534
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte1::BRequest_RemoteMapTypes_setByte1(const byps_ptr< ::std::map< double , int8_t > >& byte1)
	: BMethodRequest(80483097) 
	, byte1(byte1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte2::BRequest_RemoteMapTypes_setByte2() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:534
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte2::BRequest_RemoteMapTypes_setByte2(const byps_ptr< ::std::map< int32_t , PBytes > >& byte2)
	: BMethodRequest(80483097) 
	, byte2(byte2)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setChar1::BRequest_RemoteMapTypes_setChar1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:534
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setChar1::BRequest_RemoteMapTypes_setChar1(const byps_ptr< ::std::map< float , wchar_t > >& char1)
	: BMethodRequest(80483097) 
	, char1(char1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1::BRequest_RemoteMapTypes_setDouble1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:534
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1::BRequest_RemoteMapTypes_setDouble1(const byps_ptr< ::std::map< int8_t , double > >& double1)
	: BMethodRequest(80483097) 
	, double1(double1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1::BRequest_RemoteMapTypes_setFloat1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:534
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1::BRequest_RemoteMapTypes_setFloat1(const byps_ptr< ::std::map< wchar_t , float > >& float1)
	: BMethodRequest(80483097) 
	, float1(float1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt1::BRequest_RemoteMapTypes_setInt1() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:534
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt1::BRequest_RemoteMapTypes_setInt1(const byps_ptr< ::std::map< int32_t , int32_t > >& int1)
	: BMethodRequest(80483097) 
	, int1(int1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:488
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt2::BRequest_RemoteMapTypes_setInt2() : BMethodRequest(80483097) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:534
com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt2::BRequest_RemoteMapTypes_setInt2(const byps_ptr< ::std::map< int32_t , byps_ptr< BArray1< int32_t > > > >& int2)
	: BMethodRequest(80483097) 
	, int2(int2)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:872
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:929
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
