#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getInt
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getInt::BRequest_RemotePrimitiveTypes_getInt() : BMethodRequest(1341983932) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getInt::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getInt::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->getInt([__byps__asyncResult](int32_t __byps__result, BException __byps__ex) {
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
void BSerializer_1318015101(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getInt& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getInt*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getInt());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getLong
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getLong::BRequest_RemotePrimitiveTypes_getLong() : BMethodRequest(1341983932) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getLong::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getLong::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->getLong([__byps__asyncResult](int64_t __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_6(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2091295080(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getLong& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getLong*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getLong());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getObject
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getObject::BRequest_RemotePrimitiveTypes_getObject() : BMethodRequest(1341983932) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getObject::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getObject::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->getObject([__byps__asyncResult](PSerializable __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_21(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_236358869(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getObject& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getObject*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getObject());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getPrimitiveTypes
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getPrimitiveTypes::BRequest_RemotePrimitiveTypes_getPrimitiveTypes() : BMethodRequest(1341983932) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getPrimitiveTypes::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getPrimitiveTypes::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->getPrimitiveTypes([__byps__asyncResult](com::wilutions::byps::test::api::prim::PPrimitiveTypes __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1000(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1881962430(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getPrimitiveTypes& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getPrimitiveTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getPrimitiveTypes());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getShort
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getShort::BRequest_RemotePrimitiveTypes_getShort() : BMethodRequest(1341983932) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getShort::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getShort::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->getShort([__byps__asyncResult](int16_t __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_3(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_411895568(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getShort& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getShort*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getShort());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getString
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getString::BRequest_RemotePrimitiveTypes_getString() : BMethodRequest(1341983932) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getString::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getString::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->getString([__byps__asyncResult](::std::wstring __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_10(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_104976387(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getString& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getString*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getString());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_sendAllTypes
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_sendAllTypes::BRequest_RemotePrimitiveTypes_sendAllTypes() : BMethodRequest(1341983932) {
	b = false;
	c = '\0';
	s = 0;
	i = 0;
	l = 0;
	f = 0;
	d = 0;
}
com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_sendAllTypes::BRequest_RemotePrimitiveTypes_sendAllTypes(bool b, wchar_t c, int16_t s, int32_t i, int64_t l, float f, double d, ::std::wstring str, com::wilutions::byps::test::api::prim::PPrimitiveTypes pt, PSerializable o)
	: BMethodRequest(1341983932) 
	, b(b)
	, c(c)
	, s(s)
	, i(i)
	, l(l)
	, f(f)
	, d(d)
	, str(str)
	, pt(pt)
	, o(o)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_sendAllTypes::serialize(BIO& ar, const BVERSION version) {
	ar & b;
	ar & c;
	ar & d;
	ar & f;
	ar & i;
	ar & l;
	ar & s;
	ar & str;
	ar & o;
	ar & pt;
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_sendAllTypes::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->sendAllTypes(b, c, s, i, l, f, d, str, pt, o, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1794219594(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_sendAllTypes& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_sendAllTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_sendAllTypes());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setBool
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setBool::BRequest_RemotePrimitiveTypes_setBool() : BMethodRequest(1341983932) {
	v = false;
}
com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setBool::BRequest_RemotePrimitiveTypes_setBool(bool v)
	: BMethodRequest(1341983932) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setBool::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setBool::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_143860510(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setBool& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setBool*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setBool());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setByte
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setByte::BRequest_RemotePrimitiveTypes_setByte() : BMethodRequest(1341983932) {
	v = 0;
}
com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setByte::BRequest_RemotePrimitiveTypes_setByte(int8_t v)
	: BMethodRequest(1341983932) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setByte::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setByte::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_143850752(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setByte& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setByte*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setByte());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setChar
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setChar::BRequest_RemotePrimitiveTypes_setChar() : BMethodRequest(1341983932) {
	v = '\0';
}
com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setChar::BRequest_RemotePrimitiveTypes_setChar(wchar_t v)
	: BMethodRequest(1341983932) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setChar::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setChar::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_143837874(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setChar& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setChar*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setChar());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setDouble
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDouble::BRequest_RemotePrimitiveTypes_setDouble() : BMethodRequest(1341983932) {
	v = 0;
}
com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDouble::BRequest_RemotePrimitiveTypes_setDouble(double v)
	: BMethodRequest(1341983932) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDouble::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDouble::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_753565751(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDouble& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDouble*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDouble());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setFloat
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setFloat::BRequest_RemotePrimitiveTypes_setFloat() : BMethodRequest(1341983932) {
	v = 0;
}
com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setFloat::BRequest_RemotePrimitiveTypes_setFloat(float v)
	: BMethodRequest(1341983932) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setFloat::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setFloat::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_161104028(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setFloat& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setFloat*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setFloat());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setInt
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setInt::BRequest_RemotePrimitiveTypes_setInt() : BMethodRequest(1341983932) {
	v = 0;
}
com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setInt::BRequest_RemotePrimitiveTypes_setInt(int32_t v)
	: BMethodRequest(1341983932) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setInt::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setInt::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_974465289(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setInt& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setInt*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setInt());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setLong
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setLong::BRequest_RemotePrimitiveTypes_setLong() : BMethodRequest(1341983932) {
	v = 0;
}
com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setLong::BRequest_RemotePrimitiveTypes_setLong(int64_t v)
	: BMethodRequest(1341983932) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setLong::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setLong::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_143562636(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setLong& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setLong*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setLong());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setObject
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setObject::BRequest_RemotePrimitiveTypes_setObject() : BMethodRequest(1341983932) {
}
com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setObject::BRequest_RemotePrimitiveTypes_setObject(PSerializable v)
	: BMethodRequest(1341983932) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setObject::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setObject::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_450975945(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setObject& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setObject*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setObject());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setPrimitiveTypes
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setPrimitiveTypes::BRequest_RemotePrimitiveTypes_setPrimitiveTypes() : BMethodRequest(1341983932) {
}
com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setPrimitiveTypes::BRequest_RemotePrimitiveTypes_setPrimitiveTypes(com::wilutions::byps::test::api::prim::PPrimitiveTypes v)
	: BMethodRequest(1341983932) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setPrimitiveTypes::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setPrimitiveTypes::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_941809610(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setPrimitiveTypes& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setPrimitiveTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setPrimitiveTypes());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setShort
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setShort::BRequest_RemotePrimitiveTypes_setShort() : BMethodRequest(1341983932) {
	v = 0;
}
com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setShort::BRequest_RemotePrimitiveTypes_setShort(int16_t v)
	: BMethodRequest(1341983932) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setShort::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setShort::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_149216892(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setShort& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setShort*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setShort());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setString
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setString::BRequest_RemotePrimitiveTypes_setString() : BMethodRequest(1341983932) {
}
com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setString::BRequest_RemotePrimitiveTypes_setString(::std::wstring v)
	: BMethodRequest(1341983932) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setString::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setString::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_319593463(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setString& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setString*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setString());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_voidFunctionVoid
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_voidFunctionVoid::BRequest_RemotePrimitiveTypes_voidFunctionVoid() : BMethodRequest(1341983932) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_voidFunctionVoid::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_voidFunctionVoid::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->voidFunctionVoid([__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1856936054(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_voidFunctionVoid& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_voidFunctionVoid*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_voidFunctionVoid());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteReferences_getNode
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteReferences_getNode::BRequest_RemoteReferences_getNode() : BMethodRequest(2086824050) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteReferences_getNode::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteReferences_getNode::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteReferences __byps__remoteT = byps_ptr_cast<RemoteReferences>(__byps__remote);
	__byps__remoteT->getNode([__byps__asyncResult](com::wilutions::byps::test::api::refs::PNode __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_9001(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_655936732(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteReferences_getNode& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteReferences_getNode*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteReferences_getNode());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteReferences_setNode
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteReferences_setNode::BRequest_RemoteReferences_setNode() : BMethodRequest(2086824050) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteReferences_setNode::BRequest_RemoteReferences_setNode(com::wilutions::byps::test::api::refs::PNode v)
	: BMethodRequest(2086824050) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteReferences_setNode::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteReferences_setNode::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteReferences __byps__remoteT = byps_ptr_cast<RemoteReferences>(__byps__remote);
	__byps__remoteT->setNode(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1404172848(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteReferences_setNode& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteReferences_setNode*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteReferences_setNode());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteServerCtrl_getPublishedRemote
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_getPublishedRemote::BRequest_RemoteServerCtrl_getPublishedRemote() : BMethodRequest(1124545992) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_getPublishedRemote::BRequest_RemoteServerCtrl_getPublishedRemote(::std::wstring name)
	: BMethodRequest(1124545992) 
	, name(name)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_getPublishedRemote::serialize(BIO& ar, const BVERSION version) {
	ar & name;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_getPublishedRemote::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteServerCtrl __byps__remoteT = byps_ptr_cast<RemoteServerCtrl>(__byps__remote);
	__byps__remoteT->getPublishedRemote(name, [__byps__asyncResult](PRemote __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_16(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:916
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1216543212(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_getPublishedRemote& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_getPublishedRemote*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_getPublishedRemote());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteServerCtrl_publishRemote
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_publishRemote::BRequest_RemoteServerCtrl_publishRemote() : BMethodRequest(1124545992) {
	fowardToOtherServers = false;
}
com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_publishRemote::BRequest_RemoteServerCtrl_publishRemote(::std::wstring name, PRemote remote, bool fowardToOtherServers)
	: BMethodRequest(1124545992) 
	, name(name)
	, remote(remote)
	, fowardToOtherServers(fowardToOtherServers)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_publishRemote::serialize(BIO& ar, const BVERSION version) {
	ar & fowardToOtherServers;
	ar & name;
	ar & remote;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_publishRemote::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteServerCtrl __byps__remoteT = byps_ptr_cast<RemoteServerCtrl>(__byps__remote);
	__byps__remoteT->publishRemote(name, remote, fowardToOtherServers, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1776814809(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_publishRemote& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_publishRemote*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_publishRemote());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteServerCtrl_removePublishedRemote
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_removePublishedRemote::BRequest_RemoteServerCtrl_removePublishedRemote() : BMethodRequest(1124545992) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_removePublishedRemote::BRequest_RemoteServerCtrl_removePublishedRemote(::std::wstring name)
	: BMethodRequest(1124545992) 
	, name(name)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:859
void com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_removePublishedRemote::serialize(BIO& ar, const BVERSION version) {
	ar & name;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_removePublishedRemote::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteServerCtrl __byps__remoteT = byps_ptr_cast<RemoteServerCtrl>(__byps__remote);
	__byps__remoteT->removePublishedRemote(name, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1302703010(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_removePublishedRemote& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_removePublishedRemote*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_removePublishedRemote());
	}
}
}}}}}
