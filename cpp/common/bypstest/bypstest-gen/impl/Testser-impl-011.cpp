#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteSetTypes_setString1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setString1::BRequest_RemoteSetTypes_setString1() : BMethodRequest(1156008353) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setString1::BRequest_RemoteSetTypes_setString1(byps_ptr< ::std::set< ::std::wstring > > string1)
	: BMethodRequest(1156008353) 
	, string1(string1)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setString1::serialize(BIO& ar, const BVERSION version) {
	ar & string1;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setString1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteSetTypes __byps__remoteT = byps_ptr_cast<RemoteSetTypes>(__byps__remote);
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

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1321265283(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setString1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setString1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setString1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteStreams_getImage
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getImage::BRequest_RemoteStreams_getImage() : BMethodRequest(2028487863) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getImage::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getImage::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteStreams __byps__remoteT = byps_ptr_cast<RemoteStreams>(__byps__remote);
	__byps__remoteT->getImage([__byps__asyncResult](PContentStream __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_15(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1902276204(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getImage& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getImage*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getImage());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteStreams_getImages
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getImages::BRequest_RemoteStreams_getImages() : BMethodRequest(2028487863) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getImages::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getImages::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteStreams __byps__remoteT = byps_ptr_cast<RemoteStreams>(__byps__remote);
	__byps__remoteT->getImages([__byps__asyncResult](byps_ptr< ::std::map< int32_t , PContentStream > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_476459792(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1158979935(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getImages& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getImages*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getImages());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteStreams_getTextStream
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getTextStream::BRequest_RemoteStreams_getTextStream() : BMethodRequest(2028487863) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getTextStream::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getTextStream::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteStreams __byps__remoteT = byps_ptr_cast<RemoteStreams>(__byps__remote);
	__byps__remoteT->getTextStream([__byps__asyncResult](PContentStream __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_15(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1083407988(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getTextStream& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getTextStream*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getTextStream());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteStreams_setImage
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_setImage::BRequest_RemoteStreams_setImage() : BMethodRequest(2028487863) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_setImage::BRequest_RemoteStreams_setImage(PContentStream istrm)
	: BMethodRequest(2028487863) 
	, istrm(istrm)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_setImage::serialize(BIO& ar, const BVERSION version) {
	ar & istrm;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_setImage::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteStreams __byps__remoteT = byps_ptr_cast<RemoteStreams>(__byps__remote);
	__byps__remoteT->setImage(istrm, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1831578632(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_setImage& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_setImage*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_setImage());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteStreams_setImages
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_setImages::BRequest_RemoteStreams_setImages() : BMethodRequest(2028487863) {
	doNotReadStreamAtKey = 0;
}
com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_setImages::BRequest_RemoteStreams_setImages(byps_ptr< ::std::map< int32_t , PContentStream > > istrms, int32_t doNotReadStreamAtKey)
	: BMethodRequest(2028487863) 
	, istrms(istrms)
	, doNotReadStreamAtKey(doNotReadStreamAtKey)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_setImages::serialize(BIO& ar, const BVERSION version) {
	ar & doNotReadStreamAtKey;
	ar & istrms;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_setImages::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteStreams __byps__remoteT = byps_ptr_cast<RemoteStreams>(__byps__remote);
	__byps__remoteT->setImages(istrms, doNotReadStreamAtKey, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_944362859(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_setImages& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_setImages*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_setImages());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteStreams_throwLastException
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_throwLastException::BRequest_RemoteStreams_throwLastException() : BMethodRequest(2028487863) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_throwLastException::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_throwLastException::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2047657918(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_throwLastException& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_throwLastException*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_throwLastException());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteWithAuthentication_doit
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_doit::BRequest_RemoteWithAuthentication_doit() : BMethodRequest(1677934392) {
	value = 0;
}
com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_doit::BRequest_RemoteWithAuthentication_doit(int32_t value)
	: BMethodRequest(1677934392) 
	, value(value)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_doit::serialize(BIO& ar, const BVERSION version) {
	ar & value;
	ar & sess;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_doit::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:828
void com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_doit::setSession(PSerializable __byps__sess) {
	sess = byps_ptr_cast<com::wilutions::byps::test::api::auth::SessionInfo>(__byps__sess);
}

}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_388793292(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_doit& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_doit*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_doit());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteWithAuthentication_expire
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_expire::BRequest_RemoteWithAuthentication_expire() : BMethodRequest(1677934392) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_expire::serialize(BIO& ar, const BVERSION version) {
	ar & sess;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_expire::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:828
void com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_expire::setSession(PSerializable __byps__sess) {
	sess = byps_ptr_cast<com::wilutions::byps::test::api::auth::SessionInfo>(__byps__sess);
}

}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_68943581(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_expire& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_expire*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_expire());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteWithAuthentication_login
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_login::BRequest_RemoteWithAuthentication_login() : BMethodRequest(1677934392) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_login::BRequest_RemoteWithAuthentication_login(::std::wstring userName, ::std::wstring userPwd)
	: BMethodRequest(1677934392) 
	, userName(userName)
	, userPwd(userPwd)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_login::serialize(BIO& ar, const BVERSION version) {
	ar & userName;
	ar & userPwd;
	ar & sess;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_login::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteWithAuthentication __byps__remoteT = byps_ptr_cast<RemoteWithAuthentication>(__byps__remote);
	__byps__remoteT->login(sess, userName, userPwd, [__byps__asyncResult](com::wilutions::byps::test::api::auth::PSessionInfo __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_65775978(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:828
void com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_login::setSession(PSerializable __byps__sess) {
	sess = byps_ptr_cast<com::wilutions::byps::test::api::auth::SessionInfo>(__byps__sess);
}

}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_839695851(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_login& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_login*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_login());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteWithAuthentication_setReloginCount
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_setReloginCount::BRequest_RemoteWithAuthentication_setReloginCount() : BMethodRequest(1677934392) {
	count = 0;
}
com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_setReloginCount::BRequest_RemoteWithAuthentication_setReloginCount(int32_t count)
	: BMethodRequest(1677934392) 
	, count(count)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_setReloginCount::serialize(BIO& ar, const BVERSION version) {
	ar & count;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_setReloginCount::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_20608797(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_setReloginCount& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_setReloginCount*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_setReloginCount());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteWithAuthentication_setUseAuthentication
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_setUseAuthentication::BRequest_RemoteWithAuthentication_setUseAuthentication() : BMethodRequest(1677934392) {
	useAuth = false;
}
com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_setUseAuthentication::BRequest_RemoteWithAuthentication_setUseAuthentication(bool useAuth)
	: BMethodRequest(1677934392) 
	, useAuth(useAuth)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_setUseAuthentication::serialize(BIO& ar, const BVERSION version) {
	ar & useAuth;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_setUseAuthentication::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1785294043(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_setUseAuthentication& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_setUseAuthentication*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteWithAuthentication_setUseAuthentication());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace set { 

//-------------------------------------------------
// Implementation of class SetTypes
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::set::SetTypes::SetTypes() {
}
com::wilutions::byps::test::api::set::SetTypes::SetTypes(byps_ptr< ::std::set< bool > > boolean1, byps_ptr< ::std::set< int8_t > > byte1, byps_ptr< ::std::set< wchar_t > > char1, byps_ptr< ::std::set< int16_t > > short1, byps_ptr< ::std::set< int32_t > > int1, byps_ptr< ::std::set< int64_t > > long1, byps_ptr< ::std::set< float > > float1, byps_ptr< ::std::set< double > > double1, byps_ptr< ::std::set< ::std::wstring > > string1, byps_ptr< ::std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes > > primitiveTypes1, byps_ptr< ::std::set< PBytes > > byte2, byps_ptr< ::std::set< byps_ptr< BArray1< int32_t > > > > int2, byps_ptr< ::std::set< PSerializable > > obj1)
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
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::set::SetTypes::serialize(BIO& ar, const BVERSION version) {
	ar & boolean1;
	ar & byte1;
	ar & byte2;
	ar & char1;
	ar & double1;
	ar & float1;
	ar & int1;
	ar & int2;
	ar & long1;
	ar & obj1;
	ar & primitiveTypes1;
	ar & short1;
	ar & string1;
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_5001(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::set::SetTypes& r = * dynamic_cast< com::wilutions::byps::test::api::set::SetTypes*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::set::SetTypes());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ClientIF_getStreams
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ClientIF_getStreams::BRequest_ClientIF_getStreams() : BMethodRequest(1784257353) {
	ctrl = 0;
}
com::wilutions::byps::test::api::srvr::BRequest_ClientIF_getStreams::BRequest_ClientIF_getStreams(int32_t ctrl)
	: BMethodRequest(1784257353) 
	, ctrl(ctrl)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::srvr::BRequest_ClientIF_getStreams::serialize(BIO& ar, const BVERSION version) {
	ar & ctrl;
}
void com::wilutions::byps::test::api::srvr::BRequest_ClientIF_getStreams::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PClientIF __byps__remoteT = byps_ptr_cast<ClientIF>(__byps__remote);
	__byps__remoteT->getStreams(ctrl, [__byps__asyncResult](byps_ptr< ::std::vector< PContentStream > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1218831438(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_865920738(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ClientIF_getStreams& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ClientIF_getStreams*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ClientIF_getStreams());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ClientIF_incrementInt
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ClientIF_incrementInt::BRequest_ClientIF_incrementInt() : BMethodRequest(1784257353) {
	a = 0;
}
com::wilutions::byps::test::api::srvr::BRequest_ClientIF_incrementInt::BRequest_ClientIF_incrementInt(int32_t a)
	: BMethodRequest(1784257353) 
	, a(a)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::srvr::BRequest_ClientIF_incrementInt::serialize(BIO& ar, const BVERSION version) {
	ar & a;
}
void com::wilutions::byps::test::api::srvr::BRequest_ClientIF_incrementInt::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1461829915(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ClientIF_incrementInt& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ClientIF_incrementInt*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ClientIF_incrementInt());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ClientIF_putStreams
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ClientIF_putStreams::BRequest_ClientIF_putStreams() : BMethodRequest(1784257353) {
	ctrl = 0;
}
com::wilutions::byps::test::api::srvr::BRequest_ClientIF_putStreams::BRequest_ClientIF_putStreams(byps_ptr< ::std::vector< PContentStream > > strm, int32_t ctrl)
	: BMethodRequest(1784257353) 
	, strm(strm)
	, ctrl(ctrl)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::srvr::BRequest_ClientIF_putStreams::serialize(BIO& ar, const BVERSION version) {
	ar & ctrl;
	ar & strm;
}
void com::wilutions::byps::test::api::srvr::BRequest_ClientIF_putStreams::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_242798857(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ClientIF_putStreams& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ClientIF_putStreams*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ClientIF_putStreams());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ClientIF_sendChat
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ClientIF_sendChat::BRequest_ClientIF_sendChat() : BMethodRequest(1784257353) {
}
com::wilutions::byps::test::api::srvr::BRequest_ClientIF_sendChat::BRequest_ClientIF_sendChat(com::wilutions::byps::test::api::srvr::PChatStructure cs)
	: BMethodRequest(1784257353) 
	, cs(cs)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::srvr::BRequest_ClientIF_sendChat::serialize(BIO& ar, const BVERSION version) {
	ar & cs;
}
void com::wilutions::byps::test::api::srvr::BRequest_ClientIF_sendChat::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1352392091(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ClientIF_sendChat& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ClientIF_sendChat*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ClientIF_sendChat());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_callClientIncrementInt
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt::BRequest_ServerIF_callClientIncrementInt() : BMethodRequest(1313562065) {
	v = 0;
}
com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt::BRequest_ServerIF_callClientIncrementInt(int32_t v)
	: BMethodRequest(1313562065) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1252575894(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_callClientParallel
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientParallel::BRequest_ServerIF_callClientParallel() : BMethodRequest(1313562065) {
	v = 0;
}
com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientParallel::BRequest_ServerIF_callClientParallel(int32_t v)
	: BMethodRequest(1313562065) 
	, v(v)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientParallel::serialize(BIO& ar, const BVERSION version) {
	ar & v;
}
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientParallel::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1340180893(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientParallel& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientParallel*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientParallel());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getClient
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClient::BRequest_ServerIF_getClient() : BMethodRequest(1313562065) {
	id = 0;
}
com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClient::BRequest_ServerIF_getClient(int32_t id)
	: BMethodRequest(1313562065) 
	, id(id)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClient::serialize(BIO& ar, const BVERSION version) {
	ar & id;
}
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClient::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->getClient(id, [__byps__asyncResult](PClientIF __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1473575576(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2107407220(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClient& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClient*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClient());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getClientIds
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClientIds::BRequest_ServerIF_getClientIds() : BMethodRequest(1313562065) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClientIds::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClientIds::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->getClientIds([__byps__asyncResult](byps_ptr< ::std::set< int32_t > > __byps__result, BException __byps__ex) {
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
void BSerializer_2063368540(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClientIds& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClientIds*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClientIds());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getPartner
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getPartner::BRequest_ServerIF_getPartner() : BMethodRequest(1313562065) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getPartner::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getPartner::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->getPartner([__byps__asyncResult](PClientIF __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1473575576(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_748402113(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getPartner& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getPartner*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getPartner());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_getStreamsFromClient
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient::BRequest_ServerIF_getStreamsFromClient() : BMethodRequest(1313562065) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PServerIF __byps__remoteT = byps_ptr_cast<ServerIF>(__byps__remote);
	__byps__remoteT->getStreamsFromClient([__byps__asyncResult](byps_ptr< ::std::vector< PContentStream > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1218831438(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1415283169(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace srvr { 

//-------------------------------------------------
// Implementation of class BRequest_ServerIF_putStreamsOnClient
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient::BRequest_ServerIF_putStreamsOnClient() : BMethodRequest(1313562065) {
}
com::wilutions::byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient::BRequest_ServerIF_putStreamsOnClient(byps_ptr< ::std::vector< PContentStream > > streams)
	: BMethodRequest(1313562065) 
	, streams(streams)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient::serialize(BIO& ar, const BVERSION version) {
	ar & streams;
}
void com::wilutions::byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1367013829(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient& r = * dynamic_cast< com::wilutions::byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient());
	}
}
}}}}}
