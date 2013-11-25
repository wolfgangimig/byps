#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_getPoint2DListList
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteInlineInstance_getPoint2DListList::BRequest_RemoteInlineInstance_getPoint2DListList() : BMethodRequest(355071648) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DListList::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DListList::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->getPoint2DListList([__byps__asyncResult](byps_ptr< ::std::vector< byps_ptr< ::std::vector< byps::test::api::inl::Point2D > > > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1823330785(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1650554387(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DListList& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DListList*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DListList());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_getPoint2DMap
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteInlineInstance_getPoint2DMap::BRequest_RemoteInlineInstance_getPoint2DMap() : BMethodRequest(355071648) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DMap::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DMap::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteInlineInstance __byps__remoteT = byps_ptr_cast<RemoteInlineInstance>(__byps__remote);
	__byps__remoteT->getPoint2DMap([__byps__asyncResult](byps_ptr< ::std::map< int32_t , byps::test::api::inl::Point2D > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1358523233(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_646661333(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DMap& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DMap*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DMap());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_setActor
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteInlineInstance_setActor::BRequest_RemoteInlineInstance_setActor() : BMethodRequest(355071648) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteInlineInstance_setActor::BRequest_RemoteInlineInstance_setActor(const byps::test::api::inl::PActor& act)
	: BMethodRequest(355071648) 
	, act(act)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteInlineInstance_setActor::serialize(BIO& ar, const BVERSION version) {
	ar & this->act;
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_setActor::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1162005320(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteInlineInstance_setActor& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteInlineInstance_setActor*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteInlineInstance_setActor());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_setPoint2DArray1dim
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteInlineInstance_setPoint2DArray1dim::BRequest_RemoteInlineInstance_setPoint2DArray1dim() : BMethodRequest(355071648) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray1dim::BRequest_RemoteInlineInstance_setPoint2DArray1dim(const byps_ptr< BArray1< byps::test::api::inl::Point2D > >& pointArray)
	: BMethodRequest(355071648) 
	, pointArray(pointArray)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray1dim::serialize(BIO& ar, const BVERSION version) {
	ar & this->pointArray;
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray1dim::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1355334613(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray1dim& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray1dim*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray1dim());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_setPoint2DArray4dim
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteInlineInstance_setPoint2DArray4dim::BRequest_RemoteInlineInstance_setPoint2DArray4dim() : BMethodRequest(355071648) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray4dim::BRequest_RemoteInlineInstance_setPoint2DArray4dim(const byps_ptr< BArray4< byps::test::api::inl::Point2D > >& pointArray)
	: BMethodRequest(355071648) 
	, pointArray(pointArray)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray4dim::serialize(BIO& ar, const BVERSION version) {
	ar & this->pointArray;
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray4dim::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1355245240(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray4dim& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray4dim*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray4dim());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_setPoint2DList
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteInlineInstance_setPoint2DList::BRequest_RemoteInlineInstance_setPoint2DList() : BMethodRequest(355071648) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DList::BRequest_RemoteInlineInstance_setPoint2DList(const byps_ptr< ::std::vector< byps::test::api::inl::Point2D > >& pointList)
	: BMethodRequest(355071648) 
	, pointList(pointList)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DList::serialize(BIO& ar, const BVERSION version) {
	ar & this->pointList;
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DList::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_343422941(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DList& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DList*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DList());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_setPoint2DListList
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteInlineInstance_setPoint2DListList::BRequest_RemoteInlineInstance_setPoint2DListList() : BMethodRequest(355071648) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DListList::BRequest_RemoteInlineInstance_setPoint2DListList(const byps_ptr< ::std::vector< byps_ptr< ::std::vector< byps::test::api::inl::Point2D > > > >& pointListList)
	: BMethodRequest(355071648) 
	, pointListList(pointListList)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DListList::serialize(BIO& ar, const BVERSION version) {
	ar & this->pointListList;
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DListList::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_730520735(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DListList& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DListList*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DListList());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteInlineInstance_setPoint2DMap
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteInlineInstance_setPoint2DMap::BRequest_RemoteInlineInstance_setPoint2DMap() : BMethodRequest(355071648) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DMap::BRequest_RemoteInlineInstance_setPoint2DMap(const byps_ptr< ::std::map< int32_t , byps::test::api::inl::Point2D > >& pointMap)
	: BMethodRequest(355071648) 
	, pointMap(pointMap)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DMap::serialize(BIO& ar, const BVERSION version) {
	ar & this->pointMap;
}
void byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DMap::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_127469879(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DMap& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DMap*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DMap());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getBoolean1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getBoolean1::BRequest_RemoteListTypes_getBoolean1() : BMethodRequest(1240892695) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteListTypes_getBoolean1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getBoolean1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2058662161(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteListTypes_getBoolean1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteListTypes_getBoolean1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteListTypes_getBoolean1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getByte1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getByte1::BRequest_RemoteListTypes_getByte1() : BMethodRequest(1240892695) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteListTypes_getByte1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getByte1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_608486403(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteListTypes_getByte1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteListTypes_getByte1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteListTypes_getByte1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getByte2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getByte2::BRequest_RemoteListTypes_getByte2() : BMethodRequest(1240892695) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteListTypes_getByte2::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getByte2::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_608486404(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteListTypes_getByte2& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteListTypes_getByte2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteListTypes_getByte2());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getChar1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getChar1::BRequest_RemoteListTypes_getChar1() : BMethodRequest(1240892695) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteListTypes_getChar1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getChar1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_608885621(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteListTypes_getChar1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteListTypes_getChar1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteListTypes_getChar1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getDate1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getDate1::BRequest_RemoteListTypes_getDate1() : BMethodRequest(1240892695) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteListTypes_getDate1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getDate1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getDate1([__byps__asyncResult](byps_ptr< ::std::vector< BDateTime > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1504867122(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_609618461(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteListTypes_getDate1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteListTypes_getDate1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteListTypes_getDate1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getDouble1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getDouble1::BRequest_RemoteListTypes_getDouble1() : BMethodRequest(1240892695) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteListTypes_getDouble1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getDouble1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2129490906(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteListTypes_getDouble1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteListTypes_getDouble1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteListTypes_getDouble1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getFloat1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getFloat1::BRequest_RemoteListTypes_getFloat1() : BMethodRequest(1240892695) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteListTypes_getFloat1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getFloat1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1785569467(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteListTypes_getFloat1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteListTypes_getFloat1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteListTypes_getFloat1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getInt1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getInt1::BRequest_RemoteListTypes_getInt1() : BMethodRequest(1240892695) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteListTypes_getInt1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getInt1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2098036488(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteListTypes_getInt1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteListTypes_getInt1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteListTypes_getInt1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getInt2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getInt2::BRequest_RemoteListTypes_getInt2() : BMethodRequest(1240892695) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteListTypes_getInt2::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getInt2::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2098036489(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteListTypes_getInt2& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteListTypes_getInt2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteListTypes_getInt2());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getInt3
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getInt3::BRequest_RemoteListTypes_getInt3() : BMethodRequest(1240892695) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteListTypes_getInt3::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getInt3::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2098036490(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteListTypes_getInt3& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteListTypes_getInt3*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteListTypes_getInt3());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getInt4
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getInt4::BRequest_RemoteListTypes_getInt4() : BMethodRequest(1240892695) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteListTypes_getInt4::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getInt4::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2098036491(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteListTypes_getInt4& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteListTypes_getInt4*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteListTypes_getInt4());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getLong1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getLong1::BRequest_RemoteListTypes_getLong1() : BMethodRequest(1240892695) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteListTypes_getLong1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getLong1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_617417999(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteListTypes_getLong1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteListTypes_getLong1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteListTypes_getLong1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getObj1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getObj1::BRequest_RemoteListTypes_getObj1() : BMethodRequest(1240892695) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteListTypes_getObj1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getObj1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2098203392(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteListTypes_getObj1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteListTypes_getObj1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteListTypes_getObj1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getPrimitiveTypes1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getPrimitiveTypes1::BRequest_RemoteListTypes_getPrimitiveTypes1() : BMethodRequest(1240892695) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteListTypes_getPrimitiveTypes1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getPrimitiveTypes1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
	PRemoteListTypes __byps__remoteT = byps_ptr_cast<RemoteListTypes>(__byps__remote);
	__byps__remoteT->getPrimitiveTypes1([__byps__asyncResult](byps_ptr< ::std::vector< byps::test::api::prim::PPrimitiveTypes > > __byps__result, BException __byps__ex) {
		if (__byps__ex) {
			__byps__asyncResult->setAsyncResult(BVariant(__byps__ex));
		}
		else {
			PSerializable __byps__methodResult(new BResult_1596367810(__byps__result));
			__byps__asyncResult->setAsyncResult(BVariant(__byps__methodResult));
		}
	});
}
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1679973895(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteListTypes_getPrimitiveTypes1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteListTypes_getPrimitiveTypes1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteListTypes_getPrimitiveTypes1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getShort1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getShort1::BRequest_RemoteListTypes_getShort1() : BMethodRequest(1240892695) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteListTypes_getShort1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getShort1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2140896613(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteListTypes_getShort1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteListTypes_getShort1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteListTypes_getShort1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_getString1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_getString1::BRequest_RemoteListTypes_getString1() : BMethodRequest(1240892695) {
}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteListTypes_getString1::serialize(BIO& ar, const BVERSION version) {
}
void byps::test::api::remote::BRequest_RemoteListTypes_getString1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_1597237350(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteListTypes_getString1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteListTypes_getString1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteListTypes_getString1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setBoolean1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_setBoolean1::BRequest_RemoteListTypes_setBoolean1() : BMethodRequest(1240892695) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteListTypes_setBoolean1::BRequest_RemoteListTypes_setBoolean1(const byps_ptr< ::std::vector< bool > >& boolean1)
	: BMethodRequest(1240892695) 
	, boolean1(boolean1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteListTypes_setBoolean1::serialize(BIO& ar, const BVERSION version) {
	ar & this->boolean1;
}
void byps::test::api::remote::BRequest_RemoteListTypes_setBoolean1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_2147241989(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteListTypes_setBoolean1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteListTypes_setBoolean1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteListTypes_setBoolean1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setByte1
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_setByte1::BRequest_RemoteListTypes_setByte1() : BMethodRequest(1240892695) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteListTypes_setByte1::BRequest_RemoteListTypes_setByte1(const byps_ptr< ::std::vector< int8_t > >& byte1)
	: BMethodRequest(1240892695) 
	, byte1(byte1)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteListTypes_setByte1::serialize(BIO& ar, const BVERSION version) {
	ar & this->byte1;
}
void byps::test::api::remote::BRequest_RemoteListTypes_setByte1::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_47373943(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteListTypes_setByte1& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteListTypes_setByte1*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteListTypes_setByte1());
	}
}
}}}
namespace byps { namespace test { namespace api { namespace remote { 

//-------------------------------------------------
// Implementation of class BRequest_RemoteListTypes_setByte2
// Generated from class byps.gen.cpp.GenApiClass

// checkpoint byps.gen.cpp.GenApiClass:489
BRequest_RemoteListTypes_setByte2::BRequest_RemoteListTypes_setByte2() : BMethodRequest(1240892695) {
}
// checkpoint byps.gen.cpp.GenApiClass:536
byps::test::api::remote::BRequest_RemoteListTypes_setByte2::BRequest_RemoteListTypes_setByte2(const byps_ptr< ::std::vector< PBytes > >& byte2)
	: BMethodRequest(1240892695) 
	, byte2(byte2)
	{}
// checkpoint byps.gen.cpp.GenApiClass:877
void byps::test::api::remote::BRequest_RemoteListTypes_setByte2::serialize(BIO& ar, const BVERSION version) {
	ar & this->byte2;
}
void byps::test::api::remote::BRequest_RemoteListTypes_setByte2::execute(PRemote __byps__remote, PAsyncResult __byps__asyncResult) {
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
}}}}

// checkpoint byps.gen.cpp.GenApiClass:934
namespace byps { namespace test { namespace api { 
void BSerializer_47373944(BIO& bio, POBJECT& , PSerializable& pObjS, void* pBase) {
	BSerializable* p = pBase ? reinterpret_cast<BSerializable*>(pBase) : pObjS.get();
	if (p) { 
		byps::test::api::remote::BRequest_RemoteListTypes_setByte2& r = * dynamic_cast< byps::test::api::remote::BRequest_RemoteListTypes_setByte2*>(p);
		bio & r;
	} else {
		pObjS = PSerializable(new byps::test::api::remote::BRequest_RemoteListTypes_setByte2());
	}
}
}}}
