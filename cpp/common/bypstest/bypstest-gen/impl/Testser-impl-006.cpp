#include "Testser-impl.h"
using namespace ::std;
using namespace ::com::wilutions::byps;

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteEnums_setPlanet
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteEnums_setPlanet::BRequest_RemoteEnums_setPlanet() : BMethodRequest(359349400) {
	planet = com::wilutions::byps::test::api::enu::EnumPlanets::Mercury;
}
com::wilutions::byps::test::api::remote::BRequest_RemoteEnums_setPlanet::BRequest_RemoteEnums_setPlanet(com::wilutions::byps::test::api::enu::EnumPlanets planet)
	: BMethodRequest(359349400) 
	, planet(planet)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteEnums_setPlanet::serialize(BIO& ar, const BVERSION version) {
	ar & planet;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteEnums_setPlanet::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteEnums __byps__remoteT = byps_ptr_cast<RemoteEnums>(__byps__remote);
	__byps__remoteT->setPlanet(planet, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_412393386(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteEnums_setPlanet& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteEnums_setPlanet*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteEnums_setPlanet());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_getActor
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getActor::BRequest_RemoteInlineInstance_getActor() : BMethodRequest(1206670536) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getActor::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getActor::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->getActor([__byps__asyncResult](com::wilutions::byps::test::api::inl::PActor __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_171948703(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_261822861(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getActor& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getActor*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getActor());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_getPoint2DArray1dim
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray1dim::BRequest_RemoteInlineInstance_getPoint2DArray1dim() : BMethodRequest(1206670536) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray1dim::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray1dim::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->getPoint2DArray1dim([__byps__asyncResult](byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_2049740106(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1011970102(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray1dim& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray1dim*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray1dim());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_getPoint2DArray4dim
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray4dim::BRequest_RemoteInlineInstance_getPoint2DArray4dim() : BMethodRequest(1206670536) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray4dim::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray4dim::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->getPoint2DArray4dim([__byps__asyncResult](byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_487702928(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1012059475(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray4dim& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray4dim*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray4dim());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_getPoint2DList
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DList::BRequest_RemoteInlineInstance_getPoint2DList() : BMethodRequest(1206670536) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DList::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DList::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->getPoint2DList([__byps__asyncResult](byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_172221196(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1996093752(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DList& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DList*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DList());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_getPoint2DListList
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DListList::BRequest_RemoteInlineInstance_getPoint2DListList() : BMethodRequest(1206670536) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DListList::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DListList::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->getPoint2DListList([__byps__asyncResult](byps_ptr< ::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1463615848(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_177127926(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DListList& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DListList*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DListList());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_getPoint2DMap
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DMap::BRequest_RemoteInlineInstance_getPoint2DMap() : BMethodRequest(1206670536) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DMap::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DMap::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->getPoint2DMap([__byps__asyncResult](byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1851881336(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1321082494(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DMap& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DMap*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DMap());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_setActor
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setActor::BRequest_RemoteInlineInstance_setActor() : BMethodRequest(1206670536) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setActor::BRequest_RemoteInlineInstance_setActor(com::wilutions::byps::test::api::inl::PActor act)
	: BMethodRequest(1206670536) 
	, act(act)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setActor::serialize(BIO& ar, const BVERSION version) {
	ar & act;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setActor::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->setActor(act, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_299289599(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setActor& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setActor*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setActor());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_setPoint2DArray1dim
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray1dim::BRequest_RemoteInlineInstance_setPoint2DArray1dim() : BMethodRequest(1206670536) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray1dim::BRequest_RemoteInlineInstance_setPoint2DArray1dim(byps_ptr< BArray1< com::wilutions::byps::test::api::inl::Point2D > > pointArray)
	: BMethodRequest(1206670536) 
	, pointArray(pointArray)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray1dim::serialize(BIO& ar, const BVERSION version) {
	ar & pointArray;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray1dim::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->setPoint2DArray1dim(pointArray, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_531757758(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray1dim& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray1dim*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray1dim());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_setPoint2DArray4dim
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray4dim::BRequest_RemoteInlineInstance_setPoint2DArray4dim() : BMethodRequest(1206670536) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray4dim::BRequest_RemoteInlineInstance_setPoint2DArray4dim(byps_ptr< BArray4< com::wilutions::byps::test::api::inl::Point2D > > pointArray)
	: BMethodRequest(1206670536) 
	, pointArray(pointArray)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray4dim::serialize(BIO& ar, const BVERSION version) {
	ar & pointArray;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray4dim::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->setPoint2DArray4dim(pointArray, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_531668385(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray4dim& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray4dim*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray4dim());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_setPoint2DList
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DList::BRequest_RemoteInlineInstance_setPoint2DList() : BMethodRequest(1206670536) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DList::BRequest_RemoteInlineInstance_setPoint2DList(byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > pointList)
	: BMethodRequest(1206670536) 
	, pointList(pointList)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DList::serialize(BIO& ar, const BVERSION version) {
	ar & pointList;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DList::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->setPoint2DList(pointList, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_224357548(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DList& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DList*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DList());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_setPoint2DListList
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DListList::BRequest_RemoteInlineInstance_setPoint2DListList() : BMethodRequest(1206670536) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DListList::BRequest_RemoteInlineInstance_setPoint2DListList(byps_ptr< ::std::vector< byps_ptr< ::std::vector< com::wilutions::byps::test::api::inl::Point2D > > > > pointListList)
	: BMethodRequest(1206670536) 
	, pointListList(pointListList)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DListList::serialize(BIO& ar, const BVERSION version) {
	ar & pointListList;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DListList::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->setPoint2DListList(pointListList, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_1097161578(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DListList& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DListList*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DListList());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_setPoint2DMap
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DMap::BRequest_RemoteInlineInstance_setPoint2DMap() : BMethodRequest(1206670536) {
}
com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DMap::BRequest_RemoteInlineInstance_setPoint2DMap(byps_ptr< ::std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D > > pointMap)
	: BMethodRequest(1206670536) 
	, pointMap(pointMap)
	{}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DMap::serialize(BIO& ar, const BVERSION version) {
	ar & pointMap;
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DMap::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->setPoint2DMap(pointMap, [__byps__asyncResult](bool __byps__result, BException __byps__ex) {
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
void BSerializer_546951282(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DMap& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DMap*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DMap());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getBoolean1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getBoolean1::BRequest_RemoteListTypes_getBoolean1() : BMethodRequest(380156079) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getBoolean1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getBoolean1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getBoolean1([__byps__asyncResult](byps_ptr< ::std::vector< bool > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1617670280(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1794077576(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getBoolean1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getBoolean1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getBoolean1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getByte1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getByte1::BRequest_RemoteListTypes_getByte1() : BMethodRequest(380156079) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getByte1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getByte1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getByte1([__byps__asyncResult](byps_ptr< ::std::vector< int8_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1059148284(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1319541530(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getByte1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getByte1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getByte1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getByte2
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getByte2::BRequest_RemoteListTypes_getByte2() : BMethodRequest(380156079) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getByte2::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getByte2::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getByte2([__byps__asyncResult](byps_ptr< ::std::vector< PBytes > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1174971318(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1319541531(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getByte2& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getByte2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getByte2());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getChar1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getChar1::BRequest_RemoteListTypes_getChar1() : BMethodRequest(380156079) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getChar1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getChar1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getChar1([__byps__asyncResult](byps_ptr< ::std::vector< wchar_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1661807911(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1319940748(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getChar1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getChar1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getChar1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getDouble1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getDouble1::BRequest_RemoteListTypes_getDouble1() : BMethodRequest(380156079) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getDouble1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getDouble1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getDouble1([__byps__asyncResult](byps_ptr< ::std::vector< double > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1555345627(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1741299407(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getDouble1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getDouble1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getDouble1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getFloat1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getFloat1::BRequest_RemoteListTypes_getFloat1() : BMethodRequest(380156079) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getFloat1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getFloat1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getFloat1([__byps__asyncResult](byps_ptr< ::std::vector< float > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1628501332(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1941525372(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getFloat1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getFloat1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getFloat1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getInt1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt1::BRequest_RemoteListTypes_getInt1() : BMethodRequest(380156079) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getInt1([__byps__asyncResult](byps_ptr< ::std::vector< int32_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_181681714(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_874047761(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getInt2
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt2::BRequest_RemoteListTypes_getInt2() : BMethodRequest(380156079) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt2::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt2::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getInt2([__byps__asyncResult](byps_ptr< ::std::vector< byps_ptr< BArray1< int32_t > > > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1752158699(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_874047762(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt2& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt2());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getInt3
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt3::BRequest_RemoteListTypes_getInt3() : BMethodRequest(380156079) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt3::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt3::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getInt3([__byps__asyncResult](byps_ptr< ::std::vector< byps_ptr< ::std::vector< int32_t > > > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1746702954(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_874047763(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt3& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt3*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt3());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getInt4
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt4::BRequest_RemoteListTypes_getInt4() : BMethodRequest(380156079) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt4::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt4::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getInt4([__byps__asyncResult](byps_ptr< ::std::vector< byps_ptr< ::std::map< int32_t , byps_ptr< ::std::vector< byps_ptr< ::std::set< int32_t > > > > > > > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1633500852(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_874047764(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt4& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt4*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt4());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getLong1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getLong1::BRequest_RemoteListTypes_getLong1() : BMethodRequest(380156079) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getLong1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getLong1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getLong1([__byps__asyncResult](byps_ptr< ::std::vector< int64_t > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1050216688(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_1328473126(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getLong1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getLong1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getLong1());
	}
}
}}}}}
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getObj1
// Generated from class com.wilutions.byps.gen.cpp.GenApiClass

com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getObj1::BRequest_RemoteListTypes_getObj1() : BMethodRequest(380156079) {
}
// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:860
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getObj1::serialize(BIO& ar, const BVERSION version) {
}
void com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getObj1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getObj1([__byps__asyncResult](byps_ptr< ::std::vector< PSerializable > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_12(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}}}

// checkpoint com.wilutions.byps.gen.cpp.GenApiClass:917
namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_874214665(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getObj1& r = * dynamic_cast< com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getObj1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getObj1());
	}
}
}}}}}
