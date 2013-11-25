#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_makeDate
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_makeDate::BRequest_RemotePrimitiveTypes_makeDate() : BMethodRequest(1391241180) {
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
	: BMethodRequest(1391241180) 
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
BRequest_RemotePrimitiveTypes_parseDate::BRequest_RemotePrimitiveTypes_parseDate() : BMethodRequest(1391241180) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemotePrimitiveTypes_parseDate::BRequest_RemotePrimitiveTypes_parseDate(const BDateTime& date)
	: BMethodRequest(1391241180) 
	, date(date)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_parseDate::serialize(BIO& ar, const BVERSION version) {
	ar & this->date;
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_parseDate::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->parseDate(date, [__byps__asyncResult](byps_ptr< BArray1< int32_t > > __byps__result, BException __byps__ex) {
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
BRequest_RemotePrimitiveTypes_sendAllTypes::BRequest_RemotePrimitiveTypes_sendAllTypes() : BMethodRequest(1391241180) {
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
	: BMethodRequest(1391241180) 
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
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setBool
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_setBool::BRequest_RemotePrimitiveTypes_setBool() : BMethodRequest(1391241180) {
	v = false;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemotePrimitiveTypes_setBool::BRequest_RemotePrimitiveTypes_setBool(bool v)
	: BMethodRequest(1391241180) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setBool::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setBool::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_243951947(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_setBool& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_setBool*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_setBool());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setByte
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_setByte::BRequest_RemotePrimitiveTypes_setByte() : BMethodRequest(1391241180) {
	v = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemotePrimitiveTypes_setByte::BRequest_RemotePrimitiveTypes_setByte(int8_t v)
	: BMethodRequest(1391241180) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setByte::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setByte::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_243961705(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_setByte& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_setByte*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_setByte());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setChar
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_setChar::BRequest_RemotePrimitiveTypes_setChar() : BMethodRequest(1391241180) {
	v = '\0';
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemotePrimitiveTypes_setChar::BRequest_RemotePrimitiveTypes_setChar(wchar_t v)
	: BMethodRequest(1391241180) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setChar::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setChar::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_243974583(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_setChar& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_setChar*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_setChar());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setDate
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_setDate::BRequest_RemotePrimitiveTypes_setDate() : BMethodRequest(1391241180) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDate::BRequest_RemotePrimitiveTypes_setDate(const BDateTime& v)
	: BMethodRequest(1391241180) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDate::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDate::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
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
void BSerializer_243998223(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDate& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDate*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDate());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setDouble
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_setDouble::BRequest_RemotePrimitiveTypes_setDouble() : BMethodRequest(1391241180) {
	v = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDouble::BRequest_RemotePrimitiveTypes_setDouble(double v)
	: BMethodRequest(1391241180) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDouble::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDouble::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1727949326(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDouble& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDouble*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDouble());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setFloat
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_setFloat::BRequest_RemotePrimitiveTypes_setFloat() : BMethodRequest(1391241180) {
	v = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemotePrimitiveTypes_setFloat::BRequest_RemotePrimitiveTypes_setFloat(float v)
	: BMethodRequest(1391241180) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setFloat::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setFloat::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1023819749(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_setFloat& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_setFloat*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_setFloat());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setInt
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_setInt::BRequest_RemotePrimitiveTypes_setInt() : BMethodRequest(1391241180) {
	v = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemotePrimitiveTypes_setInt::BRequest_RemotePrimitiveTypes_setInt(int32_t v)
	: BMethodRequest(1391241180) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setInt::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setInt::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1239049874(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_setInt& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_setInt*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_setInt());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setLong
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_setLong::BRequest_RemotePrimitiveTypes_setLong() : BMethodRequest(1391241180) {
	v = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemotePrimitiveTypes_setLong::BRequest_RemotePrimitiveTypes_setLong(int64_t v)
	: BMethodRequest(1391241180) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setLong::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setLong::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_244249821(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_setLong& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_setLong*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_setLong());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setObject
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_setObject::BRequest_RemotePrimitiveTypes_setObject() : BMethodRequest(1391241180) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemotePrimitiveTypes_setObject::BRequest_RemotePrimitiveTypes_setObject(const PSerializable& v)
	: BMethodRequest(1391241180) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setObject::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setObject::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1425359520(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_setObject& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_setObject*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_setObject());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setPrimitiveTypes
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_setPrimitiveTypes::BRequest_RemotePrimitiveTypes_setPrimitiveTypes() : BMethodRequest(1391241180) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemotePrimitiveTypes_setPrimitiveTypes::BRequest_RemotePrimitiveTypes_setPrimitiveTypes(const byps::test::api::prim::PPrimitiveTypes& v)
	: BMethodRequest(1391241180) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setPrimitiveTypes::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setPrimitiveTypes::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_225526541(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_setPrimitiveTypes& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_setPrimitiveTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_setPrimitiveTypes());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setShort
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_setShort::BRequest_RemotePrimitiveTypes_setShort() : BMethodRequest(1391241180) {
	v = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemotePrimitiveTypes_setShort::BRequest_RemotePrimitiveTypes_setShort(int16_t v)
	: BMethodRequest(1391241180) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setShort::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setShort::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1011932613(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_setShort& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_setShort*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_setShort());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_setString
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_setString::BRequest_RemotePrimitiveTypes_setString() : BMethodRequest(1391241180) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemotePrimitiveTypes_setString::BRequest_RemotePrimitiveTypes_setString(const ::std::wstring& v)
	: BMethodRequest(1391241180) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setString::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_setString::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1293977038(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_setString& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_setString*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_setString());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_throwException
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_throwException::BRequest_RemotePrimitiveTypes_throwException() : BMethodRequest(1391241180) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_throwException::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_throwException::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemotePrimitiveTypes __byps__remoteT = byps_ptr_cast<RemotePrimitiveTypes>(__byps__remote);
	__byps__remoteT->throwException([__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1278149706(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_throwException& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_throwException*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_throwException());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemotePrimitiveTypes_voidFunctionVoid
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemotePrimitiveTypes_voidFunctionVoid::BRequest_RemotePrimitiveTypes_voidFunctionVoid() : BMethodRequest(1391241180) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_voidFunctionVoid::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemotePrimitiveTypes_voidFunctionVoid::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2033139391(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemotePrimitiveTypes_voidFunctionVoid& r = * dynamic_cast< byps::test::api::remote::BRequest_RemotePrimitiveTypes_voidFunctionVoid*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemotePrimitiveTypes_voidFunctionVoid());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteReferences_getNode
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteReferences_getNode::BRequest_RemoteReferences_getNode() : BMethodRequest(1173792730) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteReferences_getNode::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteReferences_getNode::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteReferences __byps__remoteT = byps_ptr_cast<RemoteReferences>(__byps__remote);
	__byps__remoteT->getNode([__byps__asyncResult](byps::test::api::refs::PNode __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_9001(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1366991859(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteReferences_getNode& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteReferences_getNode*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteReferences_getNode());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteReferences_setNode
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteReferences_setNode::BRequest_RemoteReferences_setNode() : BMethodRequest(1173792730) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteReferences_setNode::BRequest_RemoteReferences_setNode(const byps::test::api::refs::PNode& v)
	: BMethodRequest(1173792730) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteReferences_setNode::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::remote::BRequest_RemoteReferences_setNode::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_693117721(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteReferences_setNode& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteReferences_setNode*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteReferences_setNode());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteServerCtrl_getPublishedRemote
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteServerCtrl_getPublishedRemote::BRequest_RemoteServerCtrl_getPublishedRemote() : BMethodRequest(2037577312) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteServerCtrl_getPublishedRemote::BRequest_RemoteServerCtrl_getPublishedRemote(const ::std::wstring& name)
	: BMethodRequest(2037577312) 
	, name(name)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteServerCtrl_getPublishedRemote::serialize(BIO& ar, const BVERSION version) {
	ar & this->name;
}
void byps::test::api::remote::BRequest_RemoteServerCtrl_getPublishedRemote::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_648762723(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteServerCtrl_getPublishedRemote& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteServerCtrl_getPublishedRemote*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteServerCtrl_getPublishedRemote());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteServerCtrl_publishRemote
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteServerCtrl_publishRemote::BRequest_RemoteServerCtrl_publishRemote() : BMethodRequest(2037577312) {
	fowardToOtherServers = false;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteServerCtrl_publishRemote::BRequest_RemoteServerCtrl_publishRemote(const ::std::wstring& name, const PRemote& remote, bool fowardToOtherServers)
	: BMethodRequest(2037577312) 
	, name(name)
	, remote(remote)
	, fowardToOtherServers(fowardToOtherServers)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteServerCtrl_publishRemote::serialize(BIO& ar, const BVERSION version) {
	ar & this->fowardToOtherServers;
	ar & this->name;
	ar & this->remote;
}
void byps::test::api::remote::BRequest_RemoteServerCtrl_publishRemote::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1543768912(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteServerCtrl_publishRemote& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteServerCtrl_publishRemote*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteServerCtrl_publishRemote());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteServerCtrl_removePublishedRemote
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteServerCtrl_removePublishedRemote::BRequest_RemoteServerCtrl_removePublishedRemote() : BMethodRequest(2037577312) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteServerCtrl_removePublishedRemote::BRequest_RemoteServerCtrl_removePublishedRemote(const ::std::wstring& name)
	: BMethodRequest(2037577312) 
	, name(name)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteServerCtrl_removePublishedRemote::serialize(BIO& ar, const BVERSION version) {
	ar & this->name;
}
void byps::test::api::remote::BRequest_RemoteServerCtrl_removePublishedRemote::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_135366859(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteServerCtrl_removePublishedRemote& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteServerCtrl_removePublishedRemote*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteServerCtrl_removePublishedRemote());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getBoolean1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_getBoolean1::BRequest_RemoteSetTypes_getBoolean1() : BMethodRequest(1781251319) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteSetTypes_getBoolean1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteSetTypes_getBoolean1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2114990909(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteSetTypes_getBoolean1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteSetTypes_getBoolean1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteSetTypes_getBoolean1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getByte1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_getByte1::BRequest_RemoteSetTypes_getByte1() : BMethodRequest(1781251319) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteSetTypes_getByte1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteSetTypes_getByte1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_901695825(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteSetTypes_getByte1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteSetTypes_getByte1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteSetTypes_getByte1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getByte2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_getByte2::BRequest_RemoteSetTypes_getByte2() : BMethodRequest(1781251319) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteSetTypes_getByte2::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteSetTypes_getByte2::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_901695824(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteSetTypes_getByte2& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteSetTypes_getByte2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteSetTypes_getByte2());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_getChar1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteSetTypes_getChar1::BRequest_RemoteSetTypes_getChar1() : BMethodRequest(1781251319) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteSetTypes_getChar1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteSetTypes_getChar1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_901296607(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteSetTypes_getChar1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteSetTypes_getChar1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteSetTypes_getChar1());
	}
}
}}}
