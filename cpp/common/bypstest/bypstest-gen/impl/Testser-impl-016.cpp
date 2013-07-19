#include "Testser-impl.h"
using namespace std;
using namespace com::wilutions::byps;


namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace ver { 

void BSkeleton_EvolveIF::setEvolve(PEvolve obj)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_EvolveIF::async_setEvolve(PEvolve obj, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setEvolve(obj);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
PEvolve BSkeleton_EvolveIF::getEvolve()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_EvolveIF::async_getEvolve(std::function< void (PEvolve, BException ex) > asyncResult)  {
	PEvolve ret = PEvolve();
	try {
		ret = getEvolve();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_EvolveIF::setClient(PEvolveIF partner)  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_EvolveIF::async_setClient(PEvolveIF partner, std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		setClient(partner);
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
PEvolveIF BSkeleton_EvolveIF::getClient()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_EvolveIF::async_getClient(std::function< void (PEvolveIF, BException ex) > asyncResult)  {
	PEvolveIF ret = PEvolveIF();
	try {
		ret = getClient();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
void BSkeleton_EvolveIF::sendEvolveToClient()  {
	throw BException(EX_UNSUPPORTED_METHOD, L"");
}
void BSkeleton_EvolveIF::async_sendEvolveToClient(std::function< void (bool, BException ex) > asyncResult)  {
	bool ret = false;
	try {
		sendEvolveToClient();
		asyncResult(ret, BException());
	} catch (const std::exception& ex) {
		asyncResult(ret, ex);
	}
}
}}}}}}


namespace com { namespace wilutions { namespace byps { namespace test { namespace api { namespace ver { 

BStub_EvolveIF::BStub_EvolveIF(PTransport transport) 
	: BStub(transport) {}

void BStub_EvolveIF::setEvolve(PEvolve obj)  {
	BSyncResultT<bool > syncResult;	
	async_setEvolve(obj, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_EvolveIF::async_setEvolve(PEvolve obj, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_EvolveIF_setEvolve(obj));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
PEvolve BStub_EvolveIF::getEvolve()  {
	BSyncResultT<PEvolve > syncResult;	
	async_getEvolve([&syncResult](PEvolve v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_EvolveIF::async_getEvolve(std::function< void (PEvolve, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_EvolveIF_getEvolve());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PEvolve, BResult_1391985860 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_EvolveIF::setClient(PEvolveIF partner)  {
	BSyncResultT<bool > syncResult;	
	async_setClient(partner, [&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_EvolveIF::async_setClient(PEvolveIF partner, std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_EvolveIF_setClient(partner));
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
PEvolveIF BStub_EvolveIF::getClient()  {
	BSyncResultT<PEvolveIF > syncResult;	
	async_getClient([&syncResult](PEvolveIF v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	return syncResult.getResult();
}
void BStub_EvolveIF::async_getClient(std::function< void (PEvolveIF, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_EvolveIF_getClient());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< PEvolveIF, BResult_2078696281 >(asyncResult) );
	transport->send(req, outerResult);
}
void BStub_EvolveIF::sendEvolveToClient()  {
	BSyncResultT<bool > syncResult;	
	async_sendEvolveToClient([&syncResult](bool v, BException ex) {
		syncResult.setAsyncResult(v, ex);
	});
	syncResult.getResult();
}
void BStub_EvolveIF::async_sendEvolveToClient(std::function< void (bool, BException ex) > asyncResult)  {
	PSerializable req(new BRequest_EvolveIF_sendEvolveToClient());
	PAsyncResult outerResult( new BAsyncResultReceiveMethodL< bool, BResult_19 >(asyncResult) );
	transport->send(req, outerResult);
}
}}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 
void BSerializer_2078696281(BIO& bio, POBJECT& , PSerializable& pObjS, void* ){
	BSerializable* p = pObjS.get();
	if (bio.is_loading) {
		if (p) return;
		BTargetId targetId;
		bio & targetId;
		PTransport transport(new BTransport(*bio.transport, targetId));
		pObjS = PSerializable(new com::wilutions::byps::test::api::ver::BStub_EvolveIF(transport));
	}
	else {
		com::wilutions::byps::test::api::ver::EvolveIF* r = dynamic_cast<com::wilutions::byps::test::api::ver::EvolveIF*>(p);
		BTargetId targetId = r->BRemote_getTargetId();
		bio & targetId;
	}
}
}}}}}
//-------------------------------------------------
// Registry 

com::wilutions::byps::test::api::BRegistry_Testser::BRegistry_Testser()
{
	registerClass(typeid(BArray1< bool > ), com::wilutions::byps::test::api::BSerializer_2058423690, 2058423690);
	registerClass(typeid(BArray4< bool > ), com::wilutions::byps::test::api::BSerializer_945713488, 945713488);
	registerClass(typeid(BBytes), com::wilutions::byps::test::api::BSerializer_1374008726, 1374008726);
	registerClass(typeid(BArray4< int8_t > ), com::wilutions::byps::test::api::BSerializer_1201775504, 1201775504);
	registerClass(typeid(BArray1< wchar_t > ), com::wilutions::byps::test::api::BSerializer_1361632968, 1361632968);
	registerClass(typeid(BArray4< wchar_t > ), com::wilutions::byps::test::api::BSerializer_769021986, 769021986);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1), com::wilutions::byps::test::api::BSerializer_148544162, 148544162);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_10), com::wilutions::byps::test::api::BSerializer_309901678, 309901678);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1000), com::wilutions::byps::test::api::BSerializer_1462767598, 1462767598);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_100361105), com::wilutions::byps::test::api::BSerializer_848023142, 848023142);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1042475995), com::wilutions::byps::test::api::BSerializer_2038872493, 2038872493);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1050216688), com::wilutions::byps::test::api::BSerializer_2133842068, 2133842068);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1059148284), com::wilutions::byps::test::api::BSerializer_1532920911, 1532920911);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1097129250), com::wilutions::byps::test::api::BSerializer_1862597051, 1862597051);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1174971318), com::wilutions::byps::test::api::BSerializer_994835305, 994835305);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_12), com::wilutions::byps::test::api::BSerializer_309901676, 309901676);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1201775504), com::wilutions::byps::test::api::BSerializer_541741223, 541741223);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1218831438), com::wilutions::byps::test::api::BSerializer_1151524674, 1151524674);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_124584219), com::wilutions::byps::test::api::BSerializer_647080343, 647080343);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1279823631), com::wilutions::byps::test::api::BSerializer_1602044401, 1602044401);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1280571537), com::wilutions::byps::test::api::BSerializer_429041482, 429041482);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1320560671), com::wilutions::byps::test::api::BSerializer_190591700, 190591700);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1347703734), com::wilutions::byps::test::api::BSerializer_1350610934, 1350610934);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1359468275), com::wilutions::byps::test::api::BSerializer_493259283, 493259283);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1361632968), com::wilutions::byps::test::api::BSerializer_514676842, 514676842);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1365696060), com::wilutions::byps::test::api::BSerializer_1253977781, 1253977781);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1374008726), com::wilutions::byps::test::api::BSerializer_578691531, 578691531);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1391985860), com::wilutions::byps::test::api::BSerializer_509380329, 509380329);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_14), com::wilutions::byps::test::api::BSerializer_309901674, 309901674);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1406124761), com::wilutions::byps::test::api::BSerializer_104448059, 104448059);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1457164460), com::wilutions::byps::test::api::BSerializer_1119760023, 1119760023);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1463615848), com::wilutions::byps::test::api::BSerializer_548882635, 548882635);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1487265161), com::wilutions::byps::test::api::BSerializer_2081879792, 2081879792);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1488550492), com::wilutions::byps::test::api::BSerializer_1240765869, 1240765869);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1493282670), com::wilutions::byps::test::api::BSerializer_276437907, 276437907);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_15), com::wilutions::byps::test::api::BSerializer_309901673, 309901673);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1503107601), com::wilutions::byps::test::api::BSerializer_72308967, 72308967);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1516687588), com::wilutions::byps::test::api::BSerializer_188578332, 188578332);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1544333227), com::wilutions::byps::test::api::BSerializer_743592613, 743592613);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1555345627), com::wilutions::byps::test::api::BSerializer_1887708350, 1887708350);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_16), com::wilutions::byps::test::api::BSerializer_309901672, 309901672);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1617670280), com::wilutions::byps::test::api::BSerializer_732507399, 732507399);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1628501332), com::wilutions::byps::test::api::BSerializer_1862743418, 1862743418);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1633500852), com::wilutions::byps::test::api::BSerializer_831989576, 831989576);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1633750383), com::wilutions::byps::test::api::BSerializer_770118380, 770118380);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1661807911), com::wilutions::byps::test::api::BSerializer_1587436403, 1587436403);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1710660846), com::wilutions::byps::test::api::BSerializer_163470910, 163470910);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_171948703), com::wilutions::byps::test::api::BSerializer_1220439445, 1220439445);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_172221196), com::wilutions::byps::test::api::BSerializer_1905478006, 1905478006);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1746702954), com::wilutions::byps::test::api::BSerializer_1823196186, 1823196186);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1752158699), com::wilutions::byps::test::api::BSerializer_150989512, 150989512);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1784257353), com::wilutions::byps::test::api::BSerializer_1708889390, 1708889390);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1799280818), com::wilutions::byps::test::api::BSerializer_179038766, 179038766);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_181681714), com::wilutions::byps::test::api::BSerializer_1414119390, 1414119390);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_183594037), com::wilutions::byps::test::api::BSerializer_333265053, 333265053);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1851881336), com::wilutions::byps::test::api::BSerializer_1651982651, 1651982651);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1859644668), com::wilutions::byps::test::api::BSerializer_101217472, 101217472);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1888107655), com::wilutions::byps::test::api::BSerializer_427000, 427000);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1888799711), com::wilutions::byps::test::api::BSerializer_180574010, 180574010);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1898022288), com::wilutions::byps::test::api::BSerializer_1716302523, 1716302523);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_19), com::wilutions::byps::test::api::BSerializer_309901669, 309901669);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1972793385), com::wilutions::byps::test::api::BSerializer_104960651, 104960651);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1973996106), com::wilutions::byps::test::api::BSerializer_839888536, 839888536);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_1997002548), com::wilutions::byps::test::api::BSerializer_980499904, 980499904);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_2), com::wilutions::byps::test::api::BSerializer_148544161, 148544161);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_2028443792), com::wilutions::byps::test::api::BSerializer_398816652, 398816652);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_2049740106), com::wilutions::byps::test::api::BSerializer_234867558, 234867558);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_2052431866), com::wilutions::byps::test::api::BSerializer_496389964, 496389964);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_2058423690), com::wilutions::byps::test::api::BSerializer_532799052, 532799052);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_2067161310), com::wilutions::byps::test::api::BSerializer_1305849624, 1305849624);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_2078696281), com::wilutions::byps::test::api::BSerializer_212739126, 212739126);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_2087445849), com::wilutions::byps::test::api::BSerializer_580667480, 580667480);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_21), com::wilutions::byps::test::api::BSerializer_309901646, 309901646);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_2123584667), com::wilutions::byps::test::api::BSerializer_1978497049, 1978497049);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_3), com::wilutions::byps::test::api::BSerializer_148544160, 148544160);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_31512998), com::wilutions::byps::test::api::BSerializer_307489197, 307489197);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_39910537), com::wilutions::byps::test::api::BSerializer_1682941350, 1682941350);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_4), com::wilutions::byps::test::api::BSerializer_148544159, 148544159);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_476459792), com::wilutions::byps::test::api::BSerializer_93402296, 93402296);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_487702928), com::wilutions::byps::test::api::BSerializer_1490187962, 1490187962);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_5), com::wilutions::byps::test::api::BSerializer_148544158, 148544158);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_588723219), com::wilutions::byps::test::api::BSerializer_1886698628, 1886698628);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_6), com::wilutions::byps::test::api::BSerializer_148544157, 148544157);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_601099730), com::wilutions::byps::test::api::BSerializer_1205316392, 1205316392);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_7), com::wilutions::byps::test::api::BSerializer_148544156, 148544156);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_7007), com::wilutions::byps::test::api::BSerializer_1462588845, 1462588845);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_703065817), com::wilutions::byps::test::api::BSerializer_1169980470, 1169980470);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_766441794), com::wilutions::byps::test::api::BSerializer_1517001317, 1517001317);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_769021986), com::wilutions::byps::test::api::BSerializer_231816689, 231816689);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_8), com::wilutions::byps::test::api::BSerializer_148544155, 148544155);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_801243127), com::wilutions::byps::test::api::BSerializer_1937830923, 1937830923);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_846419204), com::wilutions::byps::test::api::BSerializer_516356161, 516356161);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_8789515), com::wilutions::byps::test::api::BSerializer_1554344518, 1554344518);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_9001), com::wilutions::byps::test::api::BSerializer_1462529269, 1462529269);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_936607009), com::wilutions::byps::test::api::BSerializer_1317331941, 1317331941);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_94341197), com::wilutions::byps::test::api::BSerializer_127543251, 127543251);
	registerClass(typeid(com::wilutions::byps::test::api::BResult_945713488), com::wilutions::byps::test::api::BSerializer_2092891102, 2092891102);
	registerClass(typeid(com::wilutions::byps::test::api::arr::ArrayTypes1dim), com::wilutions::byps::test::api::BSerializer_2001, 2001);
	registerClass(typeid(com::wilutions::byps::test::api::arr::ArrayTypes4dim), com::wilutions::byps::test::api::BSerializer_2004, 2004);
	registerClass(typeid(com::wilutions::byps::test::api::cons::AllTypesC), com::wilutions::byps::test::api::BSerializer_930294276, 930294276);
	registerClass(typeid(com::wilutions::byps::test::api::cons::AllTypesZ), com::wilutions::byps::test::api::BSerializer_142458, 142458);
	registerClass(typeid(BArray2< com::wilutions::byps::test::api::cons::PAllTypesZ > ), com::wilutions::byps::test::api::BSerializer_1981543076, 1981543076);
	registerClass(typeid(com::wilutions::byps::test::api::cons::HebrewC), com::wilutions::byps::test::api::BSerializer_691741677, 691741677);
	registerClass(typeid(com::wilutions::byps::test::api::cons::HebrewZ), com::wilutions::byps::test::api::BSerializer_1518668429, 1518668429);
	registerClass(typeid(BArray1< com::wilutions::byps::test::api::cons::PHebrewZ > ), com::wilutions::byps::test::api::BSerializer_2092671091, 2092671091);
	registerClass(typeid(BArray1< com::wilutions::byps::test::api::enu::EnumPlanets > ), com::wilutions::byps::test::api::BSerializer_1092048313, 1092048313);
	registerClass(typeid(com::wilutions::byps::test::api::enu::UsePlanets), com::wilutions::byps::test::api::BSerializer_10000, 10000);
	registerClass(typeid(com::wilutions::byps::test::api::inherit::Class1), com::wilutions::byps::test::api::BSerializer_6001, 6001);
	registerClass(typeid(com::wilutions::byps::test::api::inherit::Class1Collections), com::wilutions::byps::test::api::BSerializer_6004, 6004);
	registerClass(typeid(com::wilutions::byps::test::api::inherit::Class2), com::wilutions::byps::test::api::BSerializer_6002, 6002);
	registerClass(typeid(com::wilutions::byps::test::api::inherit::Class3), com::wilutions::byps::test::api::BSerializer_6003, 6003);
	registerClass(typeid(com::wilutions::byps::test::api::inl::Actor), com::wilutions::byps::test::api::BSerializer_171948703, 171948703);
	registerClass(typeid(com::wilutions::byps::test::api::inl::Matrix2D), com::wilutions::byps::test::api::BSerializer_135329019, 135329019);
	registerClass(typeid(com::wilutions::byps::test::api::inl::Point2D), com::wilutions::byps::test::api::BSerializer_1835035436, 1835035436);
	registerClass(typeid(BArray1< com::wilutions::byps::test::api::inl::Point2D > ), com::wilutions::byps::test::api::BSerializer_2049740106, 2049740106);
	registerClass(typeid(BArray2< com::wilutions::byps::test::api::inl::Point2D > ), com::wilutions::byps::test::api::BSerializer_1589744084, 1589744084);
	registerClass(typeid(BArray3< com::wilutions::byps::test::api::inl::Point2D > ), com::wilutions::byps::test::api::BSerializer_1264295566, 1264295566);
	registerClass(typeid(BArray4< com::wilutions::byps::test::api::inl::Point2D > ), com::wilutions::byps::test::api::BSerializer_487702928, 487702928);
	registerClass(typeid(com::wilutions::byps::test::api::list::ListListTypes), com::wilutions::byps::test::api::BSerializer_3002, 3002);
	registerClass(typeid(com::wilutions::byps::test::api::list::ListTypes), com::wilutions::byps::test::api::BSerializer_3001, 3001);
	registerClass(typeid(com::wilutions::byps::test::api::map::MapTypes), com::wilutions::byps::test::api::BSerializer_4001, 4001);
	registerClass(typeid(com::wilutions::byps::test::api::prim::PrimitiveTypes), com::wilutions::byps::test::api::BSerializer_1000, 1000);
	registerClass(typeid(BArray1< com::wilutions::byps::test::api::prim::PPrimitiveTypes > ), com::wilutions::byps::test::api::BSerializer_801243127, 801243127);
	registerClass(typeid(BArray2< com::wilutions::byps::test::api::prim::PPrimitiveTypes > ), com::wilutions::byps::test::api::BSerializer_1195496149, 1195496149);
	registerClass(typeid(BArray3< com::wilutions::byps::test::api::prim::PPrimitiveTypes > ), com::wilutions::byps::test::api::BSerializer_2115528243, 2115528243);
	registerClass(typeid(BArray4< com::wilutions::byps::test::api::prim::PPrimitiveTypes > ), com::wilutions::byps::test::api::BSerializer_1503107601, 1503107601);
	registerClass(typeid(com::wilutions::byps::test::api::priv::PrivateMembers), com::wilutions::byps::test::api::BSerializer_8001, 8001);
	registerClass(typeid(com::wilutions::byps::test::api::refs::Node), com::wilutions::byps::test::api::BSerializer_9001, 9001);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getBool), com::wilutions::byps::test::api::BSerializer_1645604187, 1645604187);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getByte), com::wilutions::byps::test::api::BSerializer_1645613945, 1645613945);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getChar), com::wilutions::byps::test::api::BSerializer_1645626823, 1645626823);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getDouble), com::wilutions::byps::test::api::BSerializer_935089666, 935089666);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getFloat), com::wilutions::byps::test::api::BSerializer_522273269, 522273269);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getInt), com::wilutions::byps::test::api::BSerializer_1609477282, 1609477282);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getLong), com::wilutions::byps::test::api::BSerializer_1645902061, 1645902061);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getObject), com::wilutions::byps::test::api::BSerializer_1237679472, 1237679472);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getPrimitiveTypes), com::wilutions::byps::test::api::BSerializer_825201405, 825201405);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getShort), com::wilutions::byps::test::api::BSerializer_510386133, 510386133);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_getString), com::wilutions::byps::test::api::BSerializer_1369061954, 1369061954);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setBool), com::wilutions::byps::test::api::BSerializer_589253529, 589253529);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setByte), com::wilutions::byps::test::api::BSerializer_589243771, 589243771);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setChar), com::wilutions::byps::test::api::BSerializer_589230893, 589230893);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setDouble), com::wilutions::byps::test::api::BSerializer_720472590, 720472590);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setFloat), com::wilutions::byps::test::api::BSerializer_1083385729, 1083385729);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setInt), com::wilutions::byps::test::api::BSerializer_1265927470, 1265927470);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setLong), com::wilutions::byps::test::api::BSerializer_588955655, 588955655);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setObject), com::wilutions::byps::test::api::BSerializer_1023062396, 1023062396);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setPrimitiveTypes), com::wilutions::byps::test::api::BSerializer_1765354225, 1765354225);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setShort), com::wilutions::byps::test::api::BSerializer_1071498593, 1071498593);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes1dim_setString), com::wilutions::byps::test::api::BSerializer_1154444878, 1154444878);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysClass), com::wilutions::byps::test::api::BSerializer_1004457221, 1004457221);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInline), com::wilutions::byps::test::api::BSerializer_899462794, 899462794);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysInt), com::wilutions::byps::test::api::BSerializer_1748523470, 1748523470);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysObject), com::wilutions::byps::test::api::BSerializer_738833892, 738833892);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes23_sendArraysString), com::wilutions::byps::test::api::BSerializer_607451410, 607451410);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getBool), com::wilutions::byps::test::api::BSerializer_2032852344, 2032852344);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getByte), com::wilutions::byps::test::api::BSerializer_2032862102, 2032862102);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getChar), com::wilutions::byps::test::api::BSerializer_2032874980, 2032874980);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getDouble), com::wilutions::byps::test::api::BSerializer_581586209, 581586209);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getFloat), com::wilutions::byps::test::api::BSerializer_1402482290, 1402482290);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getInt), com::wilutions::byps::test::api::BSerializer_1589603233, 1589603233);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getLong), com::wilutions::byps::test::api::BSerializer_2033150218, 2033150218);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getObject), com::wilutions::byps::test::api::BSerializer_278996403, 278996403);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getPrimitiveTypes), com::wilutions::byps::test::api::BSerializer_1650564320, 1650564320);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getShort), com::wilutions::byps::test::api::BSerializer_1390595154, 1390595154);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_getString), com::wilutions::byps::test::api::BSerializer_147613921, 147613921);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setBool), com::wilutions::byps::test::api::BSerializer_202005372, 202005372);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setByte), com::wilutions::byps::test::api::BSerializer_201995614, 201995614);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setChar), com::wilutions::byps::test::api::BSerializer_201982736, 201982736);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setDouble), com::wilutions::byps::test::api::BSerializer_796203285, 796203285);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setFloat), com::wilutions::byps::test::api::BSerializer_1963594750, 1963594750);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setInt), com::wilutions::byps::test::api::BSerializer_1933153045, 1933153045);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setLong), com::wilutions::byps::test::api::BSerializer_201707498, 201707498);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setObject), com::wilutions::byps::test::api::BSerializer_493613479, 493613479);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setPrimitiveTypes), com::wilutions::byps::test::api::BSerializer_710411500, 710411500);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setShort), com::wilutions::byps::test::api::BSerializer_1951707614, 1951707614);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteArrayTypes4dim_setString), com::wilutions::byps::test::api::BSerializer_362230997, 362230997);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteConstants_compare_AllTypesC), com::wilutions::byps::test::api::BSerializer_862752254, 862752254);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteConstants_compare_HebrewC), com::wilutions::byps::test::api::BSerializer_1570751625, 1570751625);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteEnums_getPlanet), com::wilutions::byps::test::api::BSerializer_627010462, 627010462);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteEnums_setPlanet), com::wilutions::byps::test::api::BSerializer_412393386, 412393386);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getActor), com::wilutions::byps::test::api::BSerializer_261822861, 261822861);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray1dim), com::wilutions::byps::test::api::BSerializer_1011970102, 1011970102);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DArray4dim), com::wilutions::byps::test::api::BSerializer_1012059475, 1012059475);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DList), com::wilutions::byps::test::api::BSerializer_1996093752, 1996093752);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DListList), com::wilutions::byps::test::api::BSerializer_177127926, 177127926);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_getPoint2DMap), com::wilutions::byps::test::api::BSerializer_1321082494, 1321082494);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setActor), com::wilutions::byps::test::api::BSerializer_299289599, 299289599);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray1dim), com::wilutions::byps::test::api::BSerializer_531757758, 531757758);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DArray4dim), com::wilutions::byps::test::api::BSerializer_531668385, 531668385);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DList), com::wilutions::byps::test::api::BSerializer_224357548, 224357548);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DListList), com::wilutions::byps::test::api::BSerializer_1097161578, 1097161578);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteInlineInstance_setPoint2DMap), com::wilutions::byps::test::api::BSerializer_546951282, 546951282);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getBoolean1), com::wilutions::byps::test::api::BSerializer_1794077576, 1794077576);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getByte1), com::wilutions::byps::test::api::BSerializer_1319541530, 1319541530);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getByte2), com::wilutions::byps::test::api::BSerializer_1319541531, 1319541531);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getChar1), com::wilutions::byps::test::api::BSerializer_1319940748, 1319940748);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getDouble1), com::wilutions::byps::test::api::BSerializer_1741299407, 1741299407);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getFloat1), com::wilutions::byps::test::api::BSerializer_1941525372, 1941525372);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt1), com::wilutions::byps::test::api::BSerializer_874047761, 874047761);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt2), com::wilutions::byps::test::api::BSerializer_874047762, 874047762);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt3), com::wilutions::byps::test::api::BSerializer_874047763, 874047763);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getInt4), com::wilutions::byps::test::api::BSerializer_874047764, 874047764);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getLong1), com::wilutions::byps::test::api::BSerializer_1328473126, 1328473126);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getObj1), com::wilutions::byps::test::api::BSerializer_874214665, 874214665);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getPrimitiveTypes1), com::wilutions::byps::test::api::BSerializer_1940572240, 1940572240);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getShort1), com::wilutions::byps::test::api::BSerializer_1573024156, 1573024156);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_getString1), com::wilutions::byps::test::api::BSerializer_1173060367, 1173060367);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setBoolean1), com::wilutions::byps::test::api::BSerializer_1882657404, 1882657404);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setByte1), com::wilutions::byps::test::api::BSerializer_758429070, 758429070);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setByte2), com::wilutions::byps::test::api::BSerializer_758429071, 758429071);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setChar1), com::wilutions::byps::test::api::BSerializer_758828288, 758828288);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setDouble1), com::wilutions::byps::test::api::BSerializer_195505829, 195505829);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setFloat1), com::wilutions::byps::test::api::BSerializer_2138824848, 2138824848);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt1), com::wilutions::byps::test::api::BSerializer_1360809955, 1360809955);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt2), com::wilutions::byps::test::api::BSerializer_1360809954, 1360809954);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt3), com::wilutions::byps::test::api::BSerializer_1360809953, 1360809953);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setInt4), com::wilutions::byps::test::api::BSerializer_1360809952, 1360809952);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setLong1), com::wilutions::byps::test::api::BSerializer_767360666, 767360666);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setObj1), com::wilutions::byps::test::api::BSerializer_1360643051, 1360643051);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setPrimitiveTypes1), com::wilutions::byps::test::api::BSerializer_1434361404, 1434361404);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setShort1), com::wilutions::byps::test::api::BSerializer_1787641232, 1787641232);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteListTypes_setString1), com::wilutions::byps::test::api::BSerializer_763744869, 763744869);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getBoolean1), com::wilutions::byps::test::api::BSerializer_461626272, 461626272);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getByte1), com::wilutions::byps::test::api::BSerializer_1348711374, 1348711374);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getByte2), com::wilutions::byps::test::api::BSerializer_1348711373, 1348711373);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getChar1), com::wilutions::byps::test::api::BSerializer_1348312156, 1348312156);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getDouble1), com::wilutions::byps::test::api::BSerializer_1836864439, 1836864439);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getFloat1), com::wilutions::byps::test::api::BSerializer_1241980524, 1241980524);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getInt1), com::wilutions::byps::test::api::BSerializer_1013140231, 1013140231);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getInt2), com::wilutions::byps::test::api::BSerializer_1013140230, 1013140230);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getLong1), com::wilutions::byps::test::api::BSerializer_1339779778, 1339779778);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getObj1), com::wilutions::byps::test::api::BSerializer_1012973327, 1012973327);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getPrimitiveTypes1), com::wilutions::byps::test::api::BSerializer_77071512, 77071512);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getShort1), com::wilutions::byps::test::api::BSerializer_1610481740, 1610481740);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_getString1), com::wilutions::byps::test::api::BSerializer_1268625399, 1268625399);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setBoolean1), com::wilutions::byps::test::api::BSerializer_550206100, 550206100);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte1), com::wilutions::byps::test::api::BSerializer_1909823834, 1909823834);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setByte2), com::wilutions::byps::test::api::BSerializer_1909823833, 1909823833);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setChar1), com::wilutions::byps::test::api::BSerializer_1909424616, 1909424616);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setDouble1), com::wilutions::byps::test::api::BSerializer_99940797, 99940797);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setFloat1), com::wilutions::byps::test::api::BSerializer_1027363448, 1027363448);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt1), com::wilutions::byps::test::api::BSerializer_1046969349, 1046969349);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setInt2), com::wilutions::byps::test::api::BSerializer_1046969350, 1046969350);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setLong1), com::wilutions::byps::test::api::BSerializer_1900892238, 1900892238);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setObj1), com::wilutions::byps::test::api::BSerializer_1047136253, 1047136253);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setPrimitiveTypes1), com::wilutions::byps::test::api::BSerializer_842962140, 842962140);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setShort1), com::wilutions::byps::test::api::BSerializer_1395864664, 1395864664);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteMapTypes_setString1), com::wilutions::byps::test::api::BSerializer_668179837, 668179837);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_add), com::wilutions::byps::test::api::BSerializer_1073583639, 1073583639);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getBool), com::wilutions::byps::test::api::BSerializer_2090997206, 2090997206);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getByte), com::wilutions::byps::test::api::BSerializer_2091006964, 2091006964);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getChar), com::wilutions::byps::test::api::BSerializer_2091019842, 2091019842);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getDouble), com::wilutions::byps::test::api::BSerializer_538948675, 538948675);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getFloat), com::wilutions::byps::test::api::BSerializer_400008432, 400008432);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getInt), com::wilutions::byps::test::api::BSerializer_1318015101, 1318015101);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getLong), com::wilutions::byps::test::api::BSerializer_2091295080, 2091295080);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getObject), com::wilutions::byps::test::api::BSerializer_236358869, 236358869);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getPrimitiveTypes), com::wilutions::byps::test::api::BSerializer_1881962430, 1881962430);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getShort), com::wilutions::byps::test::api::BSerializer_411895568, 411895568);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_getString), com::wilutions::byps::test::api::BSerializer_104976387, 104976387);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_sendAllTypes), com::wilutions::byps::test::api::BSerializer_1794219594, 1794219594);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setBool), com::wilutions::byps::test::api::BSerializer_143860510, 143860510);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setByte), com::wilutions::byps::test::api::BSerializer_143850752, 143850752);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setChar), com::wilutions::byps::test::api::BSerializer_143837874, 143837874);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setDouble), com::wilutions::byps::test::api::BSerializer_753565751, 753565751);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setFloat), com::wilutions::byps::test::api::BSerializer_161104028, 161104028);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setInt), com::wilutions::byps::test::api::BSerializer_974465289, 974465289);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setLong), com::wilutions::byps::test::api::BSerializer_143562636, 143562636);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setObject), com::wilutions::byps::test::api::BSerializer_450975945, 450975945);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setPrimitiveTypes), com::wilutions::byps::test::api::BSerializer_941809610, 941809610);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setShort), com::wilutions::byps::test::api::BSerializer_149216892, 149216892);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_setString), com::wilutions::byps::test::api::BSerializer_319593463, 319593463);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemotePrimitiveTypes_voidFunctionVoid), com::wilutions::byps::test::api::BSerializer_1856936054, 1856936054);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteReferences_getNode), com::wilutions::byps::test::api::BSerializer_655936732, 655936732);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteReferences_setNode), com::wilutions::byps::test::api::BSerializer_1404172848, 1404172848);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_getPublishedRemote), com::wilutions::byps::test::api::BSerializer_1216543212, 1216543212);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_publishRemote), com::wilutions::byps::test::api::BSerializer_1776814809, 1776814809);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteServerCtrl_removePublishedRemote), com::wilutions::byps::test::api::BSerializer_1302703010, 1302703010);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getBoolean1), com::wilutions::byps::test::api::BSerializer_1690813926, 1690813926);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getByte1), com::wilutions::byps::test::api::BSerializer_2125684552, 2125684552);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getByte2), com::wilutions::byps::test::api::BSerializer_2125684551, 2125684551);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getChar1), com::wilutions::byps::test::api::BSerializer_2125285334, 2125285334);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getDouble1), com::wilutions::byps::test::api::BSerializer_1183778993, 1183778993);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getFloat1), com::wilutions::byps::test::api::BSerializer_1369351514, 1369351514);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getInt1), com::wilutions::byps::test::api::BSerializer_68372557, 68372557);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getInt2), com::wilutions::byps::test::api::BSerializer_68372556, 68372556);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getLong1), com::wilutions::byps::test::api::BSerializer_2116752956, 2116752956);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getObj1), com::wilutions::byps::test::api::BSerializer_68205653, 68205653);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getPrimitiveTypes1), com::wilutions::byps::test::api::BSerializer_1802821742, 1802821742);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getShort1), com::wilutions::byps::test::api::BSerializer_1000850298, 1000850298);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_getString1), com::wilutions::byps::test::api::BSerializer_615539953, 615539953);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setBoolean1), com::wilutions::byps::test::api::BSerializer_1779393754, 1779393754);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setByte1), com::wilutions::byps::test::api::BSerializer_1608170284, 1608170284);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setByte2), com::wilutions::byps::test::api::BSerializer_1608170285, 1608170285);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setChar1), com::wilutions::byps::test::api::BSerializer_1608569502, 1608569502);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setDouble1), com::wilutions::byps::test::api::BSerializer_753026243, 753026243);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setFloat1), com::wilutions::byps::test::api::BSerializer_1583968590, 1583968590);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setInt1), com::wilutions::byps::test::api::BSerializer_1991737023, 1991737023);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setInt2), com::wilutions::byps::test::api::BSerializer_1991737024, 1991737024);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setLong1), com::wilutions::byps::test::api::BSerializer_1617101880, 1617101880);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setObj1), com::wilutions::byps::test::api::BSerializer_1991903927, 1991903927);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setPrimitiveTypes1), com::wilutions::byps::test::api::BSerializer_1572111902, 1572111902);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setShort1), com::wilutions::byps::test::api::BSerializer_1215467374, 1215467374);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteSetTypes_setString1), com::wilutions::byps::test::api::BSerializer_1321265283, 1321265283);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getImage), com::wilutions::byps::test::api::BSerializer_1902276204, 1902276204);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getImages), com::wilutions::byps::test::api::BSerializer_1158979935, 1158979935);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_getTextStream), com::wilutions::byps::test::api::BSerializer_1083407988, 1083407988);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_setImage), com::wilutions::byps::test::api::BSerializer_1831578632, 1831578632);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_setImages), com::wilutions::byps::test::api::BSerializer_944362859, 944362859);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BRequest_RemoteStreams_throwLastException), com::wilutions::byps::test::api::BSerializer_2047657918, 2047657918);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BStub_RemoteArrayTypes1dim), com::wilutions::byps::test::api::BSerializer_1557084481, 1557084481);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BStub_RemoteArrayTypes23), com::wilutions::byps::test::api::BSerializer_2081058997, 2081058997);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BStub_RemoteArrayTypes4dim), com::wilutions::byps::test::api::BSerializer_1557173854, 1557173854);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BStub_RemoteConstants), com::wilutions::byps::test::api::BSerializer_431648293, 431648293);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BStub_RemoteEnums), com::wilutions::byps::test::api::BSerializer_359349400, 359349400);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BStub_RemoteInlineInstance), com::wilutions::byps::test::api::BSerializer_1206670536, 1206670536);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BStub_RemoteListTypes), com::wilutions::byps::test::api::BSerializer_380156079, 380156079);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BStub_RemoteMapTypes), com::wilutions::byps::test::api::BSerializer_80483097, 80483097);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BStub_RemotePrimitiveTypes), com::wilutions::byps::test::api::BSerializer_1341983932, 1341983932);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BStub_RemoteReferences), com::wilutions::byps::test::api::BSerializer_2086824050, 2086824050);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BStub_RemoteServerCtrl), com::wilutions::byps::test::api::BSerializer_1124545992, 1124545992);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BStub_RemoteSetTypes), com::wilutions::byps::test::api::BSerializer_1156008353, 1156008353);
	registerClass(typeid(com::wilutions::byps::test::api::remote::BStub_RemoteStreams), com::wilutions::byps::test::api::BSerializer_2028487863, 2028487863);
	registerClass(typeid(com::wilutions::byps::test::api::set::SetTypes), com::wilutions::byps::test::api::BSerializer_5001, 5001);
	registerClass(typeid(com::wilutions::byps::test::api::srvr::BRequest_ClientIF_getStreams), com::wilutions::byps::test::api::BSerializer_865920738, 865920738);
	registerClass(typeid(com::wilutions::byps::test::api::srvr::BRequest_ClientIF_incrementInt), com::wilutions::byps::test::api::BSerializer_1461829915, 1461829915);
	registerClass(typeid(com::wilutions::byps::test::api::srvr::BRequest_ClientIF_putStreams), com::wilutions::byps::test::api::BSerializer_242798857, 242798857);
	registerClass(typeid(com::wilutions::byps::test::api::srvr::BRequest_ClientIF_sendChat), com::wilutions::byps::test::api::BSerializer_1352392091, 1352392091);
	registerClass(typeid(com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientIncrementInt), com::wilutions::byps::test::api::BSerializer_1252575894, 1252575894);
	registerClass(typeid(com::wilutions::byps::test::api::srvr::BRequest_ServerIF_callClientParallel), com::wilutions::byps::test::api::BSerializer_1340180893, 1340180893);
	registerClass(typeid(com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClient), com::wilutions::byps::test::api::BSerializer_2107407220, 2107407220);
	registerClass(typeid(com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getClientIds), com::wilutions::byps::test::api::BSerializer_2063368540, 2063368540);
	registerClass(typeid(com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getPartner), com::wilutions::byps::test::api::BSerializer_748402113, 748402113);
	registerClass(typeid(com::wilutions::byps::test::api::srvr::BRequest_ServerIF_getStreamsFromClient), com::wilutions::byps::test::api::BSerializer_1415283169, 1415283169);
	registerClass(typeid(com::wilutions::byps::test::api::srvr::BRequest_ServerIF_putStreamsOnClient), com::wilutions::byps::test::api::BSerializer_1367013829, 1367013829);
	registerClass(typeid(com::wilutions::byps::test::api::srvr::BRequest_ServerIF_registerWithClientMap), com::wilutions::byps::test::api::BSerializer_1921080901, 1921080901);
	registerClass(typeid(com::wilutions::byps::test::api::srvr::BRequest_ServerIF_setPartner), com::wilutions::byps::test::api::BSerializer_1188403123, 1188403123);
	registerClass(typeid(com::wilutions::byps::test::api::srvr::BStub_ClientIF), com::wilutions::byps::test::api::BSerializer_1784257353, 1784257353);
	registerClass(typeid(com::wilutions::byps::test::api::srvr::BStub_ServerIF), com::wilutions::byps::test::api::BSerializer_1313562065, 1313562065);
	registerClass(typeid(com::wilutions::byps::test::api::srvr::ChatStructure), com::wilutions::byps::test::api::BSerializer_7007, 7007);
	registerClass(typeid(com::wilutions::byps::test::api::strm::Stream1), com::wilutions::byps::test::api::BSerializer_1541129345, 1541129345);
	registerClass(typeid(com::wilutions::byps::test::api::ver::BRequest_EvolveIF_getClient), com::wilutions::byps::test::api::BSerializer_98720592, 98720592);
	registerClass(typeid(com::wilutions::byps::test::api::ver::BRequest_EvolveIF_getEvolve), com::wilutions::byps::test::api::BSerializer_32041374, 32041374);
	registerClass(typeid(com::wilutions::byps::test::api::ver::BRequest_EvolveIF_sendEvolveToClient), com::wilutions::byps::test::api::BSerializer_1425170268, 1425170268);
	registerClass(typeid(com::wilutions::byps::test::api::ver::BRequest_EvolveIF_setClient), com::wilutions::byps::test::api::BSerializer_313337668, 313337668);
	registerClass(typeid(com::wilutions::byps::test::api::ver::BRequest_EvolveIF_setEvolve), com::wilutions::byps::test::api::BSerializer_246658450, 246658450);
	registerClass(typeid(com::wilutions::byps::test::api::ver::BStub_EvolveIF), com::wilutions::byps::test::api::BSerializer_2078696281, 2078696281);
	registerClass(typeid(com::wilutions::byps::test::api::ver::Evolve), com::wilutions::byps::test::api::BSerializer_1391985860, 1391985860);
	registerClass(typeid(com::wilutions::byps::test::api::ver::Evolve2), com::wilutions::byps::test::api::BSerializer_573592593, 573592593);
	registerClass(typeid(BArray1< double > ), com::wilutions::byps::test::api::BSerializer_1359468275, 1359468275);
	registerClass(typeid(BArray4< double > ), com::wilutions::byps::test::api::BSerializer_2087445849, 2087445849);
	registerClass(typeid(BArray1< float > ), com::wilutions::byps::test::api::BSerializer_766441794, 766441794);
	registerClass(typeid(BArray4< float > ), com::wilutions::byps::test::api::BSerializer_1516687588, 1516687588);
	registerClass(typeid(BArray1< int32_t > ), com::wilutions::byps::test::api::BSerializer_100361105, 100361105);
	registerClass(typeid(BArray2< int32_t > ), com::wilutions::byps::test::api::BSerializer_1957744307, 1957744307);
	registerClass(typeid(BArray3< int32_t > ), com::wilutions::byps::test::api::BSerializer_196606293, 196606293);
	registerClass(typeid(BArray4< int32_t > ), com::wilutions::byps::test::api::BSerializer_39910537, 39910537);
	registerClass(typeid(BArray1< PContentStream > ), com::wilutions::byps::test::api::BSerializer_1950626768, 1950626768);
	registerClass(typeid(BArray1< PSerializable > ), com::wilutions::byps::test::api::BSerializer_183594037, 183594037);
	registerClass(typeid(BArray2< PSerializable > ), com::wilutions::byps::test::api::BSerializer_340213335, 340213335);
	registerClass(typeid(BArray3< PSerializable > ), com::wilutions::byps::test::api::BSerializer_527503353, 527503353);
	registerClass(typeid(BArray4< PSerializable > ), com::wilutions::byps::test::api::BSerializer_124584219, 124584219);
	registerClass(typeid(BArray1< std::wstring > ), com::wilutions::byps::test::api::BSerializer_1888107655, 1888107655);
	registerClass(typeid(BArray2< std::wstring > ), com::wilutions::byps::test::api::BSerializer_1995260457, 1995260457);
	registerClass(typeid(BArray3< std::wstring > ), com::wilutions::byps::test::api::BSerializer_1889888075, 1889888075);
	registerClass(typeid(BArray4< std::wstring > ), com::wilutions::byps::test::api::BSerializer_588723219, 588723219);
	registerClass(typeid(std::vector< com::wilutions::byps::test::api::enu::EnumPlanets >), com::wilutions::byps::test::api::BSerializer_1590740862, 1590740862);
	registerClass(typeid(std::map< double , int8_t >), com::wilutions::byps::test::api::BSerializer_1972793385, 1972793385);
	registerClass(typeid(std::set< int8_t >), com::wilutions::byps::test::api::BSerializer_31512998, 31512998);
	registerClass(typeid(std::vector< PBytes >), com::wilutions::byps::test::api::BSerializer_1174971318, 1174971318);
	registerClass(typeid(std::vector< com::wilutions::byps::test::api::inherit::PClass1 >), com::wilutions::byps::test::api::BSerializer_317887457, 317887457);
	registerClass(typeid(std::vector< com::wilutions::byps::test::api::inl::Point2D >), com::wilutions::byps::test::api::BSerializer_172221196, 172221196);
	registerClass(typeid(std::vector< com::wilutions::byps::test::api::prim::PPrimitiveTypes >), com::wilutions::byps::test::api::BSerializer_1544333227, 1544333227);
	registerClass(typeid(std::vector< com::wilutions::byps::test::api::refs::PNode >), com::wilutions::byps::test::api::BSerializer_202657921, 202657921);
	registerClass(typeid(std::vector< byps_ptr< BArray1< int32_t > > >), com::wilutions::byps::test::api::BSerializer_1752158699, 1752158699);
	registerClass(typeid(std::vector< byps_ptr< BArray4< int32_t > > >), com::wilutions::byps::test::api::BSerializer_1088217157, 1088217157);
	registerClass(typeid(std::vector< PContentStream >), com::wilutions::byps::test::api::BSerializer_1218831438, 1218831438);
	registerClass(typeid(std::vector< bool >), com::wilutions::byps::test::api::BSerializer_1617670280, 1617670280);
	registerClass(typeid(std::vector< int8_t >), com::wilutions::byps::test::api::BSerializer_1059148284, 1059148284);
	registerClass(typeid(std::vector< wchar_t >), com::wilutions::byps::test::api::BSerializer_1661807911, 1661807911);
	registerClass(typeid(std::vector< double >), com::wilutions::byps::test::api::BSerializer_1555345627, 1555345627);
	registerClass(typeid(std::vector< float >), com::wilutions::byps::test::api::BSerializer_1628501332, 1628501332);
	registerClass(typeid(std::vector< int32_t >), com::wilutions::byps::test::api::BSerializer_181681714, 181681714);
	registerClass(typeid(std::vector< int64_t >), com::wilutions::byps::test::api::BSerializer_1050216688, 1050216688);
	registerClass(typeid(std::vector< int16_t >), com::wilutions::byps::test::api::BSerializer_1997002548, 1997002548);
	registerClass(typeid(std::vector< std::wstring >), com::wilutions::byps::test::api::BSerializer_2123584667, 2123584667);
	registerClass(typeid(std::vector< byps_ptr< std::vector< com::wilutions::byps::test::api::inl::Point2D > > >), com::wilutions::byps::test::api::BSerializer_1463615848, 1463615848);
	registerClass(typeid(std::vector< byps_ptr< std::vector< byps_ptr< BArray4< int32_t > > > > >), com::wilutions::byps::test::api::BSerializer_1865834185, 1865834185);
	registerClass(typeid(std::vector< byps_ptr< std::vector< int32_t > > >), com::wilutions::byps::test::api::BSerializer_1746702954, 1746702954);
	registerClass(typeid(std::vector< byps_ptr< std::map< int32_t , byps_ptr< std::vector< byps_ptr< std::set< int32_t > > > > > > >), com::wilutions::byps::test::api::BSerializer_1633500852, 1633500852);
	registerClass(typeid(std::vector< byps_ptr< std::set< int32_t > > >), com::wilutions::byps::test::api::BSerializer_724129228, 724129228);
	registerClass(typeid(std::map< int8_t , double >), com::wilutions::byps::test::api::BSerializer_1487265161, 1487265161);
	registerClass(typeid(std::map< wchar_t , float >), com::wilutions::byps::test::api::BSerializer_94341197, 94341197);
	registerClass(typeid(std::map< int32_t , PBytes >), com::wilutions::byps::test::api::BSerializer_1799280818, 1799280818);
	registerClass(typeid(std::map< int32_t , com::wilutions::byps::test::api::inl::Point2D >), com::wilutions::byps::test::api::BSerializer_1851881336, 1851881336);
	registerClass(typeid(std::map< int32_t , com::wilutions::byps::test::api::prim::PPrimitiveTypes >), com::wilutions::byps::test::api::BSerializer_703065817, 703065817);
	registerClass(typeid(std::map< int32_t , byps_ptr< BArray1< int32_t > > >), com::wilutions::byps::test::api::BSerializer_1633750383, 1633750383);
	registerClass(typeid(std::map< int32_t , PContentStream >), com::wilutions::byps::test::api::BSerializer_779528402, 779528402);
	registerClass(typeid(std::map< int32_t , int32_t >), com::wilutions::byps::test::api::BSerializer_1347703734, 1347703734);
	registerClass(typeid(std::map< int32_t , byps_ptr< std::vector< std::wstring > > >), com::wilutions::byps::test::api::BSerializer_132175071, 132175071);
	registerClass(typeid(std::map< int32_t , byps_ptr< std::vector< byps_ptr< std::set< int32_t > > > > >), com::wilutions::byps::test::api::BSerializer_49984088, 49984088);
	registerClass(typeid(std::map< int64_t , int16_t >), com::wilutions::byps::test::api::BSerializer_601099730, 601099730);
	registerClass(typeid(std::map< int16_t , int64_t >), com::wilutions::byps::test::api::BSerializer_1973996106, 1973996106);
	registerClass(typeid(std::map< std::wstring , com::wilutions::byps::test::api::enu::EnumPlanets >), com::wilutions::byps::test::api::BSerializer_252873856, 252873856);
	registerClass(typeid(std::map< std::wstring , com::wilutions::byps::test::api::inherit::PClass1 >), com::wilutions::byps::test::api::BSerializer_981592984, 981592984);
	registerClass(typeid(std::map< std::wstring , com::wilutions::byps::test::api::refs::PNode >), com::wilutions::byps::test::api::BSerializer_1768677016, 1768677016);
	registerClass(typeid(std::map< std::wstring , bool >), com::wilutions::byps::test::api::BSerializer_1279823631, 1279823631);
	registerClass(typeid(std::map< std::wstring , PSerializable >), com::wilutions::byps::test::api::BSerializer_1488550492, 1488550492);
	registerClass(typeid(std::map< std::wstring , std::wstring >), com::wilutions::byps::test::api::BSerializer_1710660846, 1710660846);
	registerClass(typeid(std::set< PBytes >), com::wilutions::byps::test::api::BSerializer_2052431866, 2052431866);
	registerClass(typeid(std::set< com::wilutions::byps::test::api::inherit::PClass1 >), com::wilutions::byps::test::api::BSerializer_2114305573, 2114305573);
	registerClass(typeid(std::set< com::wilutions::byps::test::api::prim::PPrimitiveTypes >), com::wilutions::byps::test::api::BSerializer_1280571537, 1280571537);
	registerClass(typeid(std::set< byps_ptr< BArray1< int32_t > > >), com::wilutions::byps::test::api::BSerializer_1406124761, 1406124761);
	registerClass(typeid(std::set< bool >), com::wilutions::byps::test::api::BSerializer_1365696060, 1365696060);
	registerClass(typeid(std::set< double >), com::wilutions::byps::test::api::BSerializer_1320560671, 1320560671);
	registerClass(typeid(std::set< float >), com::wilutions::byps::test::api::BSerializer_1898022288, 1898022288);
	registerClass(typeid(std::set< int32_t >), com::wilutions::byps::test::api::BSerializer_1493282670, 1493282670);
	registerClass(typeid(std::set< int64_t >), com::wilutions::byps::test::api::BSerializer_1457164460, 1457164460);
	registerClass(typeid(std::set< int16_t >), com::wilutions::byps::test::api::BSerializer_2028443792, 2028443792);
	registerClass(typeid(std::set< std::wstring >), com::wilutions::byps::test::api::BSerializer_1888799711, 1888799711);
	registerClass(typeid(std::map< float , wchar_t >), com::wilutions::byps::test::api::BSerializer_8789515, 8789515);
	registerClass(typeid(std::map< int32_t , PContentStream >), com::wilutions::byps::test::api::BSerializer_476459792, 476459792);
	registerClass(typeid(std::set< wchar_t >), com::wilutions::byps::test::api::BSerializer_936607009, 936607009);
	registerClass(typeid(std::set< int32_t >), com::wilutions::byps::test::api::BSerializer_855786668, 855786668);
	registerClass(typeid(BArray1< int64_t > ), com::wilutions::byps::test::api::BSerializer_1097129250, 1097129250);
	registerClass(typeid(BArray4< int64_t > ), com::wilutions::byps::test::api::BSerializer_846419204, 846419204);
	registerClass(typeid(BArray1< int16_t > ), com::wilutions::byps::test::api::BSerializer_2067161310, 2067161310);
	registerClass(typeid(BArray4< int16_t > ), com::wilutions::byps::test::api::BSerializer_1859644668, 1859644668);
}
