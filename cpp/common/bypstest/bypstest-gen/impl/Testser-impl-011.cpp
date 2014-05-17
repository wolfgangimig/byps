#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteStreams_setStreamDoNotMaterialize
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteStreams_setStreamDoNotMaterialize::BRequest_RemoteStreams_setStreamDoNotMaterialize() : BMethodRequest(1043578866) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteStreams_setStreamDoNotMaterialize::BRequest_RemoteStreams_setStreamDoNotMaterialize(const PContentStream& stream)
	: BMethodRequest(1043578866) 
	, stream(stream)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteStreams_setStreamDoNotMaterialize::serialize(BIO& ar, const BVERSION version) {
	ar & this->stream;
}
void byps::test::api::remote::BRequest_RemoteStreams_setStreamDoNotMaterialize::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteStreams __byps__remoteT = byps_ptr_cast<RemoteStreams>(__byps__remote);
	__byps__remoteT->setStreamDoNotMaterialize(stream, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_199832593(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteStreams_setStreamDoNotMaterialize& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteStreams_setStreamDoNotMaterialize*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteStreams_setStreamDoNotMaterialize());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteStreams_throwLastException
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteStreams_throwLastException::BRequest_RemoteStreams_throwLastException() : BMethodRequest(1043578866) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteStreams_throwLastException::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteStreams_throwLastException::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteStreams __byps__remoteT = byps_ptr_cast<RemoteStreams>(__byps__remote);
	__byps__remoteT->throwLastException([__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_2127402965(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteStreams_throwLastException& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteStreams_throwLastException*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteStreams_throwLastException());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteWithAuthentication_doit
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteWithAuthentication_doit::BRequest_RemoteWithAuthentication_doit() : BMethodRequest(1983670399) {
	value = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteWithAuthentication_doit::BRequest_RemoteWithAuthentication_doit(int32_t value)
	: BMethodRequest(1983670399) 
	, value(value)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteWithAuthentication_doit::serialize(BIO& ar, const BVERSION version) {
	ar & this->value;
	ar & this->sess;
}
void byps::test::api::remote::BRequest_RemoteWithAuthentication_doit::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteWithAuthentication __byps__remoteT = byps_ptr_cast<RemoteWithAuthentication>(__byps__remote);
	__byps__remoteT->doit(sess, value, [__byps__asyncResult](int32_t __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_5(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
// checkpoint byps.gen.cpp.GenApiClass:845
void byps::test::api::remote::BRequest_RemoteWithAuthentication_doit::setSession(PSerializable __byps__sess) {
	sess = byps_ptr_cast<byps::test::api::auth::SessionInfo>(__byps__sess);
}

}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1251509013(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteWithAuthentication_doit& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteWithAuthentication_doit*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteWithAuthentication_doit());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteWithAuthentication_expire
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteWithAuthentication_expire::BRequest_RemoteWithAuthentication_expire() : BMethodRequest(1983670399) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteWithAuthentication_expire::serialize(BIO& ar, const BVERSION version) {
	ar & this->sess;
}
void byps::test::api::remote::BRequest_RemoteWithAuthentication_expire::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteWithAuthentication __byps__remoteT = byps_ptr_cast<RemoteWithAuthentication>(__byps__remote);
	__byps__remoteT->expire(sess, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_19(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
// checkpoint byps.gen.cpp.GenApiClass:845
void byps::test::api::remote::BRequest_RemoteWithAuthentication_expire::setSession(PSerializable __byps__sess) {
	sess = byps_ptr_cast<byps::test::api::auth::SessionInfo>(__byps__sess);
}

}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_72176172(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteWithAuthentication_expire& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteWithAuthentication_expire*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteWithAuthentication_expire());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteWithAuthentication_login
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteWithAuthentication_login::BRequest_RemoteWithAuthentication_login() : BMethodRequest(1983670399) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteWithAuthentication_login::BRequest_RemoteWithAuthentication_login(const ::std::wstring& userName, const ::std::wstring& userPwd)
	: BMethodRequest(1983670399) 
	, userName(userName)
	, userPwd(userPwd)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteWithAuthentication_login::serialize(BIO& ar, const BVERSION version) {
	ar & this->userName;
	ar & this->userPwd;
	ar & this->sess;
}
void byps::test::api::remote::BRequest_RemoteWithAuthentication_login::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteWithAuthentication __byps__remoteT = byps_ptr_cast<RemoteWithAuthentication>(__byps__remote);
	__byps__remoteT->login(sess, userName, userPwd, [__byps__asyncResult](byps::test::api::auth::PSessionInfo __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_65775978(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
// checkpoint byps.gen.cpp.GenApiClass:845
void byps::test::api::remote::BRequest_RemoteWithAuthentication_login::setSession(PSerializable __byps__sess) {
	sess = byps_ptr_cast<byps::test::api::auth::SessionInfo>(__byps__sess);
}

}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_134687724(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteWithAuthentication_login& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteWithAuthentication_login*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteWithAuthentication_login());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteWithAuthentication_setReloginCount
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteWithAuthentication_setReloginCount::BRequest_RemoteWithAuthentication_setReloginCount() : BMethodRequest(1983670399) {
	count = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteWithAuthentication_setReloginCount::BRequest_RemoteWithAuthentication_setReloginCount(int32_t count)
	: BMethodRequest(1983670399) 
	, count(count)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteWithAuthentication_setReloginCount::serialize(BIO& ar, const BVERSION version) {
	ar & this->count;
}
void byps::test::api::remote::BRequest_RemoteWithAuthentication_setReloginCount::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteWithAuthentication __byps__remoteT = byps_ptr_cast<RemoteWithAuthentication>(__byps__remote);
	__byps__remoteT->setReloginCount(count, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_802968058(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteWithAuthentication_setReloginCount& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteWithAuthentication_setReloginCount*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteWithAuthentication_setReloginCount());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteWithAuthentication_setUseAuthentication
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteWithAuthentication_setUseAuthentication::BRequest_RemoteWithAuthentication_setUseAuthentication() : BMethodRequest(1983670399) {
	useAuth = false;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteWithAuthentication_setUseAuthentication::BRequest_RemoteWithAuthentication_setUseAuthentication(bool useAuth)
	: BMethodRequest(1983670399) 
	, useAuth(useAuth)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteWithAuthentication_setUseAuthentication::serialize(BIO& ar, const BVERSION version) {
	ar & this->useAuth;
}
void byps::test::api::remote::BRequest_RemoteWithAuthentication_setUseAuthentication::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteWithAuthentication __byps__remoteT = byps_ptr_cast<RemoteWithAuthentication>(__byps__remote);
	__byps__remoteT->setUseAuthentication(useAuth, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_946544530(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteWithAuthentication_setUseAuthentication& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteWithAuthentication_setUseAuthentication*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteWithAuthentication_setUseAuthentication());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace set { 

//-------------------------------------------------
// Implementation of class SetTypes
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
SetTypes::SetTypes() {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::set::SetTypes::SetTypes(const byps::PSetBoolean& boolean1, const byps::PSetByte& byte1, const byps::PSetCharacter& char1, const byps::PSetShort& short1, const byps::PSetInteger& int1, const byps::PSetLong& long1, const byps::PSetFloat& float1, const byps::PSetDouble& double1, const byps::PSetString& string1, const byps_ptr< ::std::set< byps::test::api::prim::PPrimitiveTypes > >& primitiveTypes1, const byps_ptr< ::std::set< PBytes > >& byte2, const byps_ptr< ::std::set< PArrayInt > >& int2, const byps_ptr< ::std::set< PSerializable > >& obj1, const byps::PSetDate& date1)
	: boolean1(boolean1)
	, byte1(byte1)
	, char1(char1)
	, short1(short1)
	, int1(int1)
	, long1(long1)
	, float1(float1)
	, double1(double1)
	, string1(string1)
	, primitiveTypes1(primitiveTypes1)
	, byte2(byte2)
	, int2(int2)
	, obj1(obj1)
	, date1(date1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::set::SetTypes::serialize(BIO& ar, const BVERSION version) {
	ar & this->boolean1;
	ar & this->byte1;
	ar & this->byte2;
	ar & this->char1;
	ar & this->date1;
	ar & this->double1;
	ar & this->float1;
	ar & this->int1;
	ar & this->int2;
	ar & this->long1;
	ar & this->obj1;
	ar & this->primitiveTypes1;
	ar & this->short1;
	ar & this->string1;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_5001(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::set::SetTypes& r = * dynamic_cast< byps::test::api::set::SetTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::set::SetTypes());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ClientIF_getStreams
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ClientIF_getStreams::BRequest_ClientIF_getStreams() : BMethodRequest(2049072174) {
	ctrl = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::srvr::BRequest_ClientIF_getStreams::BRequest_ClientIF_getStreams(int32_t ctrl)
	: BMethodRequest(2049072174) 
	, ctrl(ctrl)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::srvr::BRequest_ClientIF_getStreams::serialize(BIO& ar, const BVERSION version) {
	ar & this->ctrl;
}
void byps::test::api::srvr::BRequest_ClientIF_getStreams::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PClientIF __byps__remoteT = byps_ptr_cast<ClientIF>(__byps__remote);
	__byps__remoteT->getStreams(ctrl, [__byps__asyncResult](byps::PVectorInputStream __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1218831438(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1654980071(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::srvr::BRequest_ClientIF_getStreams& r = * dynamic_cast< byps::test::api::srvr::BRequest_ClientIF_getStreams*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::srvr::BRequest_ClientIF_getStreams());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ClientIF_incrementInt
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ClientIF_incrementInt::BRequest_ClientIF_incrementInt() : BMethodRequest(2049072174) {
	a = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::srvr::BRequest_ClientIF_incrementInt::BRequest_ClientIF_incrementInt(int32_t a)
	: BMethodRequest(2049072174) 
	, a(a)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::srvr::BRequest_ClientIF_incrementInt::serialize(BIO& ar, const BVERSION version) {
	ar & this->a;
}
void byps::test::api::srvr::BRequest_ClientIF_incrementInt::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PClientIF __byps__remoteT = byps_ptr_cast<ClientIF>(__byps__remote);
	__byps__remoteT->incrementInt(a, [__byps__asyncResult](int32_t __byps__result, BException __byps__ex) {
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
void BSerializer_1685952420(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::srvr::BRequest_ClientIF_incrementInt& r = * dynamic_cast< byps::test::api::srvr::BRequest_ClientIF_incrementInt*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::srvr::BRequest_ClientIF_incrementInt());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ClientIF_putStreams
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ClientIF_putStreams::BRequest_ClientIF_putStreams() : BMethodRequest(2049072174) {
	ctrl = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::srvr::BRequest_ClientIF_putStreams::BRequest_ClientIF_putStreams(const byps::PVectorInputStream& strm, int32_t ctrl)
	: BMethodRequest(2049072174) 
	, strm(strm)
	, ctrl(ctrl)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::srvr::BRequest_ClientIF_putStreams::serialize(BIO& ar, const BVERSION version) {
	ar & this->ctrl;
	ar & this->strm;
}
void byps::test::api::srvr::BRequest_ClientIF_putStreams::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PClientIF __byps__remoteT = byps_ptr_cast<ClientIF>(__byps__remote);
	__byps__remoteT->putStreams(strm, ctrl, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_2016865344(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::srvr::BRequest_ClientIF_putStreams& r = * dynamic_cast< byps::test::api::srvr::BRequest_ClientIF_putStreams*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::srvr::BRequest_ClientIF_putStreams());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ClientIF_sendChat
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ClientIF_sendChat::BRequest_ClientIF_sendChat() : BMethodRequest(2049072174) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::srvr::BRequest_ClientIF_sendChat::BRequest_ClientIF_sendChat(const PChatStructure& cs)
	: BMethodRequest(2049072174) 
	, cs(cs)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::srvr::BRequest_ClientIF_sendChat::serialize(BIO& ar, const BVERSION version) {
	ar & this->cs;
}
void byps::test::api::srvr::BRequest_ClientIF_sendChat::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PClientIF __byps__remoteT = byps_ptr_cast<ClientIF>(__byps__remote);
	__byps__remoteT->sendChat(cs, [__byps__asyncResult](PChatStructure __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_7007(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_41050276(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::srvr::BRequest_ClientIF_sendChat& r = * dynamic_cast< byps::test::api::srvr::BRequest_ClientIF_sendChat*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::srvr::BRequest_ClientIF_sendChat());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_callClientIncrementInt
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ServerIF_callClientIncrementInt::BRequest_ServerIF_callClientIncrementInt() : BMethodRequest(1775199834) {
	v = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt::BRequest_ServerIF_callClientIncrementInt(int32_t v)
	: BMethodRequest(1775199834) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->callClientIncrementInt(v, [__byps__asyncResult](int32_t __byps__result, BException __byps__ex) {
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
void BSerializer_389860173(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt& r = * dynamic_cast< byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_callClientParallel
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ServerIF_callClientParallel::BRequest_ServerIF_callClientParallel() : BMethodRequest(1775199834) {
	v = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::srvr::BRequest_ServerIF_callClientParallel::BRequest_ServerIF_callClientParallel(int32_t v)
	: BMethodRequest(1775199834) 
	, v(v)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::srvr::BRequest_ServerIF_callClientParallel::serialize(BIO& ar, const BVERSION version) {
	ar & this->v;
}
void byps::test::api::srvr::BRequest_ServerIF_callClientParallel::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->callClientParallel(v, [__byps__asyncResult](int32_t __byps__result, BException __byps__ex) {
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
void BSerializer_772308436(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::srvr::BRequest_ServerIF_callClientParallel& r = * dynamic_cast< byps::test::api::srvr::BRequest_ServerIF_callClientParallel*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::srvr::BRequest_ServerIF_callClientParallel());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getClient
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ServerIF_getClient::BRequest_ServerIF_getClient() : BMethodRequest(1775199834) {
	id = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::srvr::BRequest_ServerIF_getClient::BRequest_ServerIF_getClient(int32_t id)
	: BMethodRequest(1775199834) 
	, id(id)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::srvr::BRequest_ServerIF_getClient::serialize(BIO& ar, const BVERSION version) {
	ar & this->id;
}
void byps::test::api::srvr::BRequest_ServerIF_getClient::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->getClient(id, [__byps__asyncResult](PClientIF __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_955752991(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_190669475(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::srvr::BRequest_ServerIF_getClient& r = * dynamic_cast< byps::test::api::srvr::BRequest_ServerIF_getClient*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::srvr::BRequest_ServerIF_getClient());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getClientIds
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ServerIF_getClientIds::BRequest_ServerIF_getClientIds() : BMethodRequest(1775199834) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::srvr::BRequest_ServerIF_getClientIds::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::srvr::BRequest_ServerIF_getClientIds::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->getClientIds([__byps__asyncResult](byps::PSetInteger __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1493282670(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2007476251(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::srvr::BRequest_ServerIF_getClientIds& r = * dynamic_cast< byps::test::api::srvr::BRequest_ServerIF_getClientIds*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::srvr::BRequest_ServerIF_getClientIds());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getPartner
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ServerIF_getPartner::BRequest_ServerIF_getPartner() : BMethodRequest(1775199834) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::srvr::BRequest_ServerIF_getPartner::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::srvr::BRequest_ServerIF_getPartner::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->getPartner([__byps__asyncResult](PClientIF __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_955752991(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1025664374(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::srvr::BRequest_ServerIF_getPartner& r = * dynamic_cast< byps::test::api::srvr::BRequest_ServerIF_getPartner*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::srvr::BRequest_ServerIF_getPartner());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getStreamsFromClient
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ServerIF_getStreamsFromClient::BRequest_ServerIF_getStreamsFromClient() : BMethodRequest(1775199834) {
	materializeOnServer = false;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient::BRequest_ServerIF_getStreamsFromClient(bool materializeOnServer)
	: BMethodRequest(1775199834) 
	, materializeOnServer(materializeOnServer)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient::serialize(BIO& ar, const BVERSION version) {
	ar & this->materializeOnServer;
}
void byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->getStreamsFromClient(materializeOnServer, [__byps__asyncResult](byps::PVectorInputStream __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1218831438(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1679867754(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient& r = * dynamic_cast< byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_putStreamsOnClient
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ServerIF_putStreamsOnClient::BRequest_ServerIF_putStreamsOnClient() : BMethodRequest(1775199834) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient::BRequest_ServerIF_putStreamsOnClient(const byps::PVectorInputStream& streams)
	: BMethodRequest(1775199834) 
	, streams(streams)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient::serialize(BIO& ar, const BVERSION version) {
	ar & this->streams;
}
void byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->putStreamsOnClient(streams, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1934886286(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient& r = * dynamic_cast< byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_registerWithClientMap
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ServerIF_registerWithClientMap::BRequest_ServerIF_registerWithClientMap() : BMethodRequest(1775199834) {
	id = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap::BRequest_ServerIF_registerWithClientMap(int32_t id)
	: BMethodRequest(1775199834) 
	, id(id)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap::serialize(BIO& ar, const BVERSION version) {
	ar & this->id;
}
void byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->registerWithClientMap(id, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1533268444(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap& r = * dynamic_cast< byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_setPartner
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_ServerIF_setPartner::BRequest_ServerIF_setPartner() : BMethodRequest(1775199834) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::srvr::BRequest_ServerIF_setPartner::BRequest_ServerIF_setPartner(const PClientIF& client)
	: BMethodRequest(1775199834) 
	, client(client)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::srvr::BRequest_ServerIF_setPartner::serialize(BIO& ar, const BVERSION version) {
	ar & this->client;
}
void byps::test::api::srvr::BRequest_ServerIF_setPartner::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->setPartner(client, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1332497686(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::srvr::BRequest_ServerIF_setPartner& r = * dynamic_cast< byps::test::api::srvr::BRequest_ServerIF_setPartner*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::srvr::BRequest_ServerIF_setPartner());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class ChatStructure
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
ChatStructure::ChatStructure() {
	sentAt = 0;
	receivedAt = 0;
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::srvr::ChatStructure::ChatStructure(const ::std::wstring& msg, double sentAt, double receivedAt)
	: msg(msg)
	, sentAt(sentAt)
	, receivedAt(receivedAt)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::srvr::ChatStructure::serialize(BIO& ar, const BVERSION version) {
	ar & this->msg;
	ar & this->receivedAt;
	ar & this->sentAt;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_7007(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::srvr::ChatStructure& r = * dynamic_cast< byps::test::api::srvr::ChatStructure*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::srvr::ChatStructure());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace strm { 

//-------------------------------------------------
// Implementation of class Stream1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
Stream1::Stream1() {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::strm::Stream1::Stream1(const PContentStream& is1, const ::std::wstring& contentType, const byps::PArrayInputStream& arrStream, const byps::PVectorInputStream& listStream, const byps::PMapIntegerInputStream& mapStream)
	: is1(is1)
	, contentType(contentType)
	, arrStream(arrStream)
	, listStream(listStream)
	, mapStream(mapStream)
	{}
void Stream1::setContentType(::std::wstring v) {
	contentType = v;
}
void Stream1::setArrStream(byps::PArrayInputStream v) {
	arrStream = v;
}
void Stream1::setListStream(byps::PVectorInputStream v) {
	listStream = v;
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::strm::Stream1::serialize(BIO& ar, const BVERSION version) {
	ar & this->contentType;
	ar & this->arrStream;
	ar & this->is1;
	ar & this->listStream;
	ar & this->mapStream;
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1541129345(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::strm::Stream1& r = * dynamic_cast< byps::test::api::strm::Stream1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::strm::Stream1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_getClient
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_EvolveIF_getClient::BRequest_EvolveIF_getClient() : BMethodRequest(15377840) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::ver::BRequest_EvolveIF_getClient::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::ver::BRequest_EvolveIF_getClient::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PEvolveIF __byps__remoteT = byps_ptr_cast<EvolveIF>(__byps__remote);
	__byps__remoteT->getClient([__byps__asyncResult](PEvolveIF __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_564008001(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1212621223(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::ver::BRequest_EvolveIF_getClient& r = * dynamic_cast< byps::test::api::ver::BRequest_EvolveIF_getClient*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::ver::BRequest_EvolveIF_getClient());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_getEvolve
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_EvolveIF_getEvolve::BRequest_EvolveIF_getEvolve() : BMethodRequest(15377840) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::ver::BRequest_EvolveIF_getEvolve::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::ver::BRequest_EvolveIF_getEvolve::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PEvolveIF __byps__remoteT = byps_ptr_cast<EvolveIF>(__byps__remote);
	__byps__remoteT->getEvolve([__byps__asyncResult](PEvolve __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1391985860(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1279300441(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::ver::BRequest_EvolveIF_getEvolve& r = * dynamic_cast< byps::test::api::ver::BRequest_EvolveIF_getEvolve*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::ver::BRequest_EvolveIF_getEvolve());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_sendEvolveToClient
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_EvolveIF_sendEvolveToClient::BRequest_EvolveIF_sendEvolveToClient() : BMethodRequest(15377840) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::ver::BRequest_EvolveIF_sendEvolveToClient::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::ver::BRequest_EvolveIF_sendEvolveToClient::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PEvolveIF __byps__remoteT = byps_ptr_cast<EvolveIF>(__byps__remote);
	__byps__remoteT->sendEvolveToClient([__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_714115141(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::ver::BRequest_EvolveIF_sendEvolveToClient& r = * dynamic_cast< byps::test::api::ver::BRequest_EvolveIF_sendEvolveToClient*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::ver::BRequest_EvolveIF_sendEvolveToClient());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace ver { 

//-------------------------------------------------
// Implementation of class BRequest_EvolveIF_setClient
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_EvolveIF_setClient::BRequest_EvolveIF_setClient() : BMethodRequest(15377840) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::ver::BRequest_EvolveIF_setClient::BRequest_EvolveIF_setClient(const PEvolveIF& partner)
	: BMethodRequest(15377840) 
	, partner(partner)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::ver::BRequest_EvolveIF_setClient::serialize(BIO& ar, const BVERSION version) {
	ar & this->partner;
}
void byps::test::api::ver::BRequest_EvolveIF_setClient::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PEvolveIF __byps__remoteT = byps_ptr_cast<EvolveIF>(__byps__remote);
	__byps__remoteT->setClient(partner, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_998004147(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::ver::BRequest_EvolveIF_setClient& r = * dynamic_cast< byps::test::api::ver::BRequest_EvolveIF_setClient*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::ver::BRequest_EvolveIF_setClient());
	}
}
}}}
