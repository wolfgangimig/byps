#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setChar1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setChar1::BRequest_RemoteMapTypes_setChar1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setChar1::BRequest_RemoteMapTypes_setChar1(const byps::PMapFloatCharacter& char1)
	: BMethodRequest(664304990) 
	, char1(char1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteMapTypes_setChar1::serialize(BIO& ar, const BVERSION version) {
	ar & this->char1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setChar1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_685435889(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteMapTypes_setChar1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteMapTypes_setChar1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteMapTypes_setChar1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setDate1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setDate1::BRequest_RemoteMapTypes_setDate1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setDate1::BRequest_RemoteMapTypes_setDate1(const byps::PMapStringDate& obj1)
	: BMethodRequest(664304990) 
	, obj1(obj1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteMapTypes_setDate1::serialize(BIO& ar, const BVERSION version) {
	ar & this->obj1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setDate1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteMapTypes __byps__remoteT = byps_ptr_cast<RemoteMapTypes>(__byps__remote);
	__byps__remoteT->setDate1(obj1, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_684703049(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteMapTypes_setDate1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteMapTypes_setDate1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteMapTypes_setDate1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setDouble1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setDouble1::BRequest_RemoteMapTypes_setDouble1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1::BRequest_RemoteMapTypes_setDouble1(const byps::PMapByteDouble& double1)
	: BMethodRequest(664304990) 
	, double1(double1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1::serialize(BIO& ar, const BVERSION version) {
	ar & this->double1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_467931660(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setFloat1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setFloat1::BRequest_RemoteMapTypes_setFloat1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1::BRequest_RemoteMapTypes_setFloat1(const byps::PMapCharacterFloat& float1)
	: BMethodRequest(664304990) 
	, float1(float1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1::serialize(BIO& ar, const BVERSION version) {
	ar & this->float1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_316308321(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setInt1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setInt1::BRequest_RemoteMapTypes_setInt1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setInt1::BRequest_RemoteMapTypes_setInt1(const byps::PMapIntegerInteger& int1)
	: BMethodRequest(664304990) 
	, int1(int1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteMapTypes_setInt1::serialize(BIO& ar, const BVERSION version) {
	ar & this->int1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setInt1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1407399122(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteMapTypes_setInt1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteMapTypes_setInt1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteMapTypes_setInt1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setInt2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setInt2::BRequest_RemoteMapTypes_setInt2() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setInt2::BRequest_RemoteMapTypes_setInt2(const byps_ptr< ::std::map< int32_t , PArrayInt > >& int2)
	: BMethodRequest(664304990) 
	, int2(int2)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteMapTypes_setInt2::serialize(BIO& ar, const BVERSION version) {
	ar & this->int2;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setInt2::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1407399121(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteMapTypes_setInt2& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteMapTypes_setInt2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteMapTypes_setInt2());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setLong1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setLong1::BRequest_RemoteMapTypes_setLong1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setLong1::BRequest_RemoteMapTypes_setLong1(const byps::PMapShortLong& long1)
	: BMethodRequest(664304990) 
	, long1(long1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteMapTypes_setLong1::serialize(BIO& ar, const BVERSION version) {
	ar & this->long1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setLong1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_676903511(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteMapTypes_setLong1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteMapTypes_setLong1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteMapTypes_setLong1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setObj1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setObj1::BRequest_RemoteMapTypes_setObj1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setObj1::BRequest_RemoteMapTypes_setObj1(const byps::PMapStringObject& obj1)
	: BMethodRequest(664304990) 
	, obj1(obj1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteMapTypes_setObj1::serialize(BIO& ar, const BVERSION version) {
	ar & this->obj1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setObj1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1407232218(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteMapTypes_setObj1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteMapTypes_setObj1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteMapTypes_setObj1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setPrimitiveTypes1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setPrimitiveTypes1::BRequest_RemoteMapTypes_setPrimitiveTypes1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setPrimitiveTypes1::BRequest_RemoteMapTypes_setPrimitiveTypes1(const byps::test::api::prim::PMapIntegerPrimitiveTypes& primitiveTypes1)
	: BMethodRequest(664304990) 
	, primitiveTypes1(primitiveTypes1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteMapTypes_setPrimitiveTypes1::serialize(BIO& ar, const BVERSION version) {
	ar & this->primitiveTypes1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setPrimitiveTypes1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1629134317(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteMapTypes_setPrimitiveTypes1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteMapTypes_setPrimitiveTypes1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteMapTypes_setPrimitiveTypes1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setShort1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setShort1::BRequest_RemoteMapTypes_setShort1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setShort1::BRequest_RemoteMapTypes_setShort1(const byps::PMapLongShort& short1)
	: BMethodRequest(664304990) 
	, short1(short1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteMapTypes_setShort1::serialize(BIO& ar, const BVERSION version) {
	ar & this->short1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setShort1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_684809537(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteMapTypes_setShort1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteMapTypes_setShort1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteMapTypes_setShort1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteMapTypes_setString1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteMapTypes_setString1::BRequest_RemoteMapTypes_setString1() : BMethodRequest(664304990) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteMapTypes_setString1::BRequest_RemoteMapTypes_setString1(const byps::PMapStringString& string1)
	: BMethodRequest(664304990) 
	, string1(string1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteMapTypes_setString1::serialize(BIO& ar, const BVERSION version) {
	ar & this->string1;
}
void byps::test::api::remote::BRequest_RemoteMapTypes_setString1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_100307380(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteMapTypes_setString1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteMapTypes_setString1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteMapTypes_setString1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_add
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_add::BRequest_RemotePrimitiveTypes_add() : BMethodRequest(1178916877) {
	a = 0;
	b = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemotePrimitiveTypes_add::BRequest_RemotePrimitiveTypes_add(int32_t a, int32_t b)
	: BMethodRequest(1178916877) 
	, a(a)
	, b(b)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_add::serialize(BIO& ar, const BVERSION version) {
	ar & this->a;
	ar & this->b;
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_add::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_362528512(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_add& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_add*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_add());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getBool
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_getBool::BRequest_RemotePrimitiveTypes_getBool() : BMethodRequest(1178916877) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getBool::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getBool::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1816157633(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_getBool& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_getBool*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_getBool());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getByte
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_getByte::BRequest_RemotePrimitiveTypes_getByte() : BMethodRequest(1178916877) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getByte::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getByte::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1816147875(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_getByte& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_getByte*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_getByte());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getChar
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_getChar::BRequest_RemotePrimitiveTypes_getChar() : BMethodRequest(1178916877) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getChar::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getChar::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1816134997(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_getChar& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_getChar*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_getChar());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getDate
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_getDate::BRequest_RemotePrimitiveTypes_getDate() : BMethodRequest(1178916877) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getDate::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getDate::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->getDate([__byps__asyncResult](BDateTime __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_17(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1816111357(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_getDate& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_getDate*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_getDate());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getDouble
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_getDouble::BRequest_RemotePrimitiveTypes_getDouble() : BMethodRequest(1178916877) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getDouble::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getDouble::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1513332250(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_getDouble& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_getDouble*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_getDouble());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getFloat
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_getFloat::BRequest_RemotePrimitiveTypes_getFloat() : BMethodRequest(1178916877) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getFloat::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getFloat::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_462707289(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_getFloat& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_getFloat*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_getFloat());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getInt
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_getInt::BRequest_RemotePrimitiveTypes_getInt() : BMethodRequest(1178916877) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getInt::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getInt::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1582599686(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_getInt& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_getInt*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_getInt());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getLong
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_getLong::BRequest_RemotePrimitiveTypes_getLong() : BMethodRequest(1178916877) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getLong::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getLong::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1815859759(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_getLong& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_getLong*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_getLong());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getObject
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_getObject::BRequest_RemotePrimitiveTypes_getObject() : BMethodRequest(1178916877) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getObject::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getObject::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1210742444(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_getObject& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_getObject*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_getObject());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getPrimitiveTypes
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_getPrimitiveTypes::BRequest_RemotePrimitiveTypes_getPrimitiveTypes() : BMethodRequest(1178916877) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getPrimitiveTypes::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getPrimitiveTypes::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->getPrimitiveTypes([__byps__asyncResult](byps::test::api::prim::PPrimitiveTypes __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1000(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_714626279(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_getPrimitiveTypes& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_getPrimitiveTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_getPrimitiveTypes());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getShort
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_getShort::BRequest_RemotePrimitiveTypes_getShort() : BMethodRequest(1178916877) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getShort::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getShort::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_450820153(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_getShort& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_getShort*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_getShort());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_getString
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_getString::BRequest_RemotePrimitiveTypes_getString() : BMethodRequest(1178916877) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getString::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_getString::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1079359962(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_getString& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_getString*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_getString());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_makeDate
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_makeDate::BRequest_RemotePrimitiveTypes_makeDate() : BMethodRequest(1178916877) {
	year = 0;
	month = 0;
	day = 0;
	hour = 0;
	minute = 0;
	second = 0;
	millisecond = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemotePrimitiveTypes_makeDate::BRequest_RemotePrimitiveTypes_makeDate(int32_t year, int32_t month, int32_t day, int32_t hour, int32_t minute, int32_t second, int32_t millisecond)
	: BMethodRequest(1178916877) 
	, year(year)
	, month(month)
	, day(day)
	, hour(hour)
	, minute(minute)
	, second(second)
	, millisecond(millisecond)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_makeDate::serialize(BIO& ar, const BVERSION version) {
	ar & this->day;
	ar & this->hour;
	ar & this->millisecond;
	ar & this->minute;
	ar & this->month;
	ar & this->second;
	ar & this->year;
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_makeDate::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->makeDate(year, month, day, hour, minute, second, millisecond, [__byps__asyncResult](BDateTime __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_17(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1918934973(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_makeDate& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_makeDate*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_makeDate());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_parseDate
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_parseDate::BRequest_RemotePrimitiveTypes_parseDate() : BMethodRequest(1178916877) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemotePrimitiveTypes_parseDate::BRequest_RemotePrimitiveTypes_parseDate(const BDateTime& date)
	: BMethodRequest(1178916877) 
	, date(date)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_parseDate::serialize(BIO& ar, const BVERSION version) {
	ar & this->date;
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_parseDate::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->parseDate(date, [__byps__asyncResult](PArrayInt __byps__result, BException __byps__ex) {
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
void BSerializer_578007072(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_parseDate& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_parseDate*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_parseDate());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_sendAllTypes
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_sendAllTypes::BRequest_RemotePrimitiveTypes_sendAllTypes() : BMethodRequest(1178916877) {
	b = false;
	c = '\0';
	s = 0;
	i = 0;
	l = 0;
	f = 0;
	d = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemotePrimitiveTypes_sendAllTypes::BRequest_RemotePrimitiveTypes_sendAllTypes(bool b, wchar_t c, int16_t s, int32_t i, int64_t l, float f, double d, const ::std::wstring& str, const byps::test::api::prim::PPrimitiveTypes& pt, const PSerializable& o)
	: BMethodRequest(1178916877) 
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
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_sendAllTypes::serialize(BIO& ar, const BVERSION version) {
	ar & this->b;
	ar & this->c;
	ar & this->d;
	ar & this->f;
	ar & this->i;
	ar & this->l;
	ar & this->s;
	ar & this->str;
	ar & this->o;
	ar & this->pt;
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_sendAllTypes::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_677876863(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_sendAllTypes& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_sendAllTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_sendAllTypes());
	}
}
}}}
