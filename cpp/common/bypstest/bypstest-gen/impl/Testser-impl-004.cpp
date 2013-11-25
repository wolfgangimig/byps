#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getPrimitiveTypes
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getPrimitiveTypes::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes() : BMethodRequest(1176140631) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getPrimitiveTypes([__byps__asyncResult](byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2053507648(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1992537556(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getShort
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getShort::BRequest_RemoteArrayTypes1dim_getShort() : BMethodRequest(1176140631) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getShort([__byps__asyncResult](byps_ptr< BArray1< int16_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2067161310(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1373101854(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_getString
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_getString::BRequest_RemoteArrayTypes1dim_getString() : BMethodRequest(1176140631) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->getString([__byps__asyncResult](byps_ptr< BArray1< ::std::wstring > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1888107655(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_394678379(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setBool
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setBool::BRequest_RemoteArrayTypes1dim_setBool() : BMethodRequest(1176140631) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool::BRequest_RemoteArrayTypes1dim_setBool(const byps_ptr< BArray1< bool > >& v)
	: BMethodRequest(1176140631) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_201441072(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setByte
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setByte::BRequest_RemoteArrayTypes1dim_setByte() : BMethodRequest(1176140631) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte::BRequest_RemoteArrayTypes1dim_setByte(const PBytes& v)
	: BMethodRequest(1176140631) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_201431314(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setChar
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setChar::BRequest_RemoteArrayTypes1dim_setChar() : BMethodRequest(1176140631) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setChar::BRequest_RemoteArrayTypes1dim_setChar(const byps_ptr< BArray1< wchar_t > >& v)
	: BMethodRequest(1176140631) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setChar::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setChar::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_201418436(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setChar& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setChar*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setChar());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setDate
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setDate::BRequest_RemoteArrayTypes1dim_setDate() : BMethodRequest(1176140631) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDate::BRequest_RemoteArrayTypes1dim_setDate(const byps_ptr< BArray1< BDateTime > >& v)
	: BMethodRequest(1176140631) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDate::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDate::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
	__byps__remoteT->setDate(v, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_201394796(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDate& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDate*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDate());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setDouble
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setDouble::BRequest_RemoteArrayTypes1dim_setDouble() : BMethodRequest(1176140631) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDouble::BRequest_RemoteArrayTypes1dim_setDouble(const byps_ptr< BArray1< double > >& v)
	: BMethodRequest(1176140631) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDouble::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDouble::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_253910985(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDouble& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDouble*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDouble());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setFloat
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setFloat::BRequest_RemoteArrayTypes1dim_setFloat() : BMethodRequest(1176140631) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setFloat::BRequest_RemoteArrayTypes1dim_setFloat(const byps_ptr< BArray1< float > >& v)
	: BMethodRequest(1176140631) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setFloat::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setFloat::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1946101450(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setFloat& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setFloat*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setFloat());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setInt
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setInt::BRequest_RemoteArrayTypes1dim_setInt() : BMethodRequest(1176140631) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setInt::BRequest_RemoteArrayTypes1dim_setInt(const byps_ptr< BArray1< int32_t > >& v)
	: BMethodRequest(1176140631) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setInt::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setInt::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1530512055(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setInt& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setInt*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setInt());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setLong
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setLong::BRequest_RemoteArrayTypes1dim_setLong() : BMethodRequest(1176140631) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setLong::BRequest_RemoteArrayTypes1dim_setLong(const byps_ptr< BArray1< int64_t > >& v)
	: BMethodRequest(1176140631) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setLong::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setLong::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_201143198(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setLong& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setLong*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setLong());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setObject
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setObject::BRequest_RemoteArrayTypes1dim_setObject() : BMethodRequest(1176140631) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setObject::BRequest_RemoteArrayTypes1dim_setObject(const byps_ptr< BArray1< PSerializable > >& v)
	: BMethodRequest(1176140631) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setObject::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setObject::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_48678821(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setObject& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setObject*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setObject());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setPrimitiveTypes
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setPrimitiveTypes::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes() : BMethodRequest(1176140631) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes(const byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > >& v)
	: BMethodRequest(1176140631) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1362276920(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setShort
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setShort::BRequest_RemoteArrayTypes1dim_setShort() : BMethodRequest(1176140631) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setShort::BRequest_RemoteArrayTypes1dim_setShort(const byps_ptr< BArray1< int16_t > >& v)
	: BMethodRequest(1176140631) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setShort::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setShort::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1934214314(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setShort& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setShort*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setShort());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes1dim_setString
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes1dim_setString::BRequest_RemoteArrayTypes1dim_setString() : BMethodRequest(1176140631) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setString::BRequest_RemoteArrayTypes1dim_setString(const byps_ptr< BArray1< ::std::wstring > >& v)
	: BMethodRequest(1176140631) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setString::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setString::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes1dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes1dim>(__byps__remote);
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_180061303(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setString& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setString*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setString());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes23_sendArraysClass
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes23_sendArraysClass::BRequest_RemoteArrayTypes23_sendArraysClass() : BMethodRequest(964138163) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysClass::BRequest_RemoteArrayTypes23_sendArraysClass(const byps_ptr< BArray2< byps::test::api::prim::PPrimitiveTypes > >& arr2, const byps_ptr< BArray3< byps::test::api::prim::PPrimitiveTypes > >& arr3, const byps_ptr< BArray4< byps::test::api::prim::PPrimitiveTypes > >& arr4)
	: BMethodRequest(964138163) 
	, arr2(arr2)
	, arr3(arr3)
	, arr4(arr4)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysClass::serialize(BIO& ar, const BVERSION version) {
	ar & this->arr2;
	ar & this->arr3;
	ar & this->arr4;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysClass::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes23 __byps__remoteT = byps_ptr_cast<RemoteArrayTypes23>(__byps__remote);
	__byps__remoteT->sendArraysClass(arr2, arr3, arr4, [__byps__asyncResult](byps_ptr< BArray1< byps::test::api::prim::PPrimitiveTypes > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2053507648(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_330036060(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysClass& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysClass*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysClass());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes23_sendArraysInline
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes23_sendArraysInline::BRequest_RemoteArrayTypes23_sendArraysInline() : BMethodRequest(964138163) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInline::BRequest_RemoteArrayTypes23_sendArraysInline(const byps_ptr< BArray2< byps::test::api::inl::Point2D > >& arr2, const byps_ptr< BArray3< byps::test::api::inl::Point2D > >& arr3, const byps_ptr< BArray4< byps::test::api::inl::Point2D > >& arr4)
	: BMethodRequest(964138163) 
	, arr2(arr2)
	, arr3(arr3)
	, arr4(arr4)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInline::serialize(BIO& ar, const BVERSION version) {
	ar & this->arr2;
	ar & this->arr3;
	ar & this->arr4;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInline::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes23 __byps__remoteT = byps_ptr_cast<RemoteArrayTypes23>(__byps__remote);
	__byps__remoteT->sendArraysInline(arr2, arr3, arr4, [__byps__asyncResult](byps_ptr< BArray1< byps::test::api::inl::Point2D > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_184101377(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1467243283(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInline& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInline*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInline());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes23_sendArraysInt
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes23_sendArraysInt::BRequest_RemoteArrayTypes23_sendArraysInt() : BMethodRequest(964138163) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInt::BRequest_RemoteArrayTypes23_sendArraysInt(const byps_ptr< BArray2< int32_t > >& arr2, const byps_ptr< BArray3< int32_t > >& arr3, const byps_ptr< BArray4< int32_t > >& arr4)
	: BMethodRequest(964138163) 
	, arr2(arr2)
	, arr3(arr3)
	, arr4(arr4)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInt::serialize(BIO& ar, const BVERSION version) {
	ar & this->arr2;
	ar & this->arr3;
	ar & this->arr4;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInt::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes23 __byps__remoteT = byps_ptr_cast<RemoteArrayTypes23>(__byps__remote);
	__byps__remoteT->sendArraysInt(arr2, arr3, arr4, [__byps__asyncResult](byps_ptr< BArray1< int32_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_100361105(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1828268517(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInt& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInt*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInt());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes23_sendArraysObject
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes23_sendArraysObject::BRequest_RemoteArrayTypes23_sendArraysObject() : BMethodRequest(964138163) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysObject::BRequest_RemoteArrayTypes23_sendArraysObject(const byps_ptr< BArray2< PSerializable > >& arr2, const byps_ptr< BArray3< PSerializable > >& arr3, const byps_ptr< BArray4< PSerializable > >& arr4)
	: BMethodRequest(964138163) 
	, arr2(arr2)
	, arr3(arr3)
	, arr4(arr4)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysObject::serialize(BIO& ar, const BVERSION version) {
	ar & this->arr2;
	ar & this->arr3;
	ar & this->arr4;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysObject::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes23 __byps__remoteT = byps_ptr_cast<RemoteArrayTypes23>(__byps__remote);
	__byps__remoteT->sendArraysObject(arr2, arr3, arr4, [__byps__asyncResult](byps_ptr< BArray1< PSerializable > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_183594037(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1306614381(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysObject& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysObject*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysObject());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes23_sendArraysString
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes23_sendArraysString::BRequest_RemoteArrayTypes23_sendArraysString() : BMethodRequest(964138163) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysString::BRequest_RemoteArrayTypes23_sendArraysString(const byps_ptr< BArray2< ::std::wstring > >& arr2, const byps_ptr< BArray3< ::std::wstring > >& arr3, const byps_ptr< BArray4< ::std::wstring > >& arr4)
	: BMethodRequest(964138163) 
	, arr2(arr2)
	, arr3(arr3)
	, arr4(arr4)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysString::serialize(BIO& ar, const BVERSION version) {
	ar & this->arr2;
	ar & this->arr3;
	ar & this->arr4;
}
void byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysString::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes23 __byps__remoteT = byps_ptr_cast<RemoteArrayTypes23>(__byps__remote);
	__byps__remoteT->sendArraysString(arr2, arr3, arr4, [__byps__asyncResult](byps_ptr< BArray1< ::std::wstring > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1888107655(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1175231899(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysString& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysString*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysString());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getBool
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_getBool::BRequest_RemoteArrayTypes4dim_getBool() : BMethodRequest(1176051258) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getBool::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getBool::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getBool([__byps__asyncResult](byps_ptr< BArray4< bool > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_945713488(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1874302495(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getBool& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getBool*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getBool());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getByte
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_getByte::BRequest_RemoteArrayTypes4dim_getByte() : BMethodRequest(1176051258) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getByte::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getByte::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1874292737(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getByte& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getByte*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getByte());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getChar
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_getChar::BRequest_RemoteArrayTypes4dim_getChar() : BMethodRequest(1176051258) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getChar::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getChar::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1874279859(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getChar& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getChar*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getChar());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getDate
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_getDate::BRequest_RemoteArrayTypes4dim_getDate() : BMethodRequest(1176051258) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDate::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDate::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteArrayTypes4dim __byps__remoteT = byps_ptr_cast<RemoteArrayTypes4dim>(__byps__remote);
	__byps__remoteT->getDate([__byps__asyncResult](byps_ptr< BArray4< BDateTime > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_51898890(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1874256219(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDate& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDate*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDate());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getDouble
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_getDouble::BRequest_RemoteArrayTypes4dim_getDouble() : BMethodRequest(1176051258) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDouble::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDouble::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1555969784(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDouble& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDouble*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDouble());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteArrayTypes4dim_getFloat
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteArrayTypes4dim_getFloat::BRequest_RemoteArrayTypes4dim_getFloat() : BMethodRequest(1176051258) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getFloat::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getFloat::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2029769285(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getFloat& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getFloat*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getFloat());
	}
}
}}}
