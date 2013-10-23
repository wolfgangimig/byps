#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { 

PApiDescriptor BApiDescriptor_Testser::instance() {
	return PApiDescriptor((new BApiDescriptor(
	"Testser",
	"com.wilutions.byps.test.api",
	VERSION,
	false)) // uniqueObjects
	->addRegistry(PRegistry(new BRegistry_Testser()))
	);
};

}}}

namespace byps { namespace test { namespace api { 

PClient_Testser BClient_Testser::createClient(PTransportFactory transportFactory) {
	return PClient_Testser(new BClient_Testser(transportFactory));
}
PClient_Testser BClient_Testser::createClientR(PTransport transport) {
	return PClient_Testser(new BClient_Testser(transport));
}
void BClient_Testser::addRemote(byps::test::api::inherit::PSkeleton_BioFruitService remoteSkeleton) {
	if (!serverR) throw BException(EX_NO_REVERSE_CONNECTIONS, L"No reverse connections.");
	serverR->server->addRemote(1881829396, remoteSkeleton);
}

void BClient_Testser::addRemote(byps::test::api::inherit::PSkeleton_BioLemonService remoteSkeleton) {
	if (!serverR) throw BException(EX_NO_REVERSE_CONNECTIONS, L"No reverse connections.");
	serverR->server->addRemote(1992245333, remoteSkeleton);
}

void BClient_Testser::addRemote(byps::test::api::remote::PSkeleton_RemoteWithAuthentication remoteSkeleton) {
	if (!serverR) throw BException(EX_NO_REVERSE_CONNECTIONS, L"No reverse connections.");
	serverR->server->addRemote(1677934392, remoteSkeleton);
}

void BClient_Testser::addRemote(byps::test::api::srvr::PSkeleton_ClientIF remoteSkeleton) {
	if (!serverR) throw BException(EX_NO_REVERSE_CONNECTIONS, L"No reverse connections.");
	serverR->server->addRemote(1784257353, remoteSkeleton);
}

BClient_Testser::BClient_Testser(PTransportFactory transportFactory) 
	: BClient(
		transportFactory->createClientTransport(), 
		transportFactory->createServerR(
			BServer_Testser::createServerR(transportFactory->createServerTransport())
		)
	)
	, bioFruitService(new byps::test::api::inherit::BStub_BioFruitService(transport))
	, bioLemonService(new byps::test::api::inherit::BStub_BioLemonService(transport))
	, fruitService(new byps::test::api::inherit::BStub_FruitService(transport))
	, lemonService(new byps::test::api::inherit::BStub_LemonService(transport))
	, plantService(new byps::test::api::inherit::BStub_PlantService(transport))
	, remoteArrayTypes1dim(new byps::test::api::remote::BStub_RemoteArrayTypes1dim(transport))
	, remoteArrayTypes23(new byps::test::api::remote::BStub_RemoteArrayTypes23(transport))
	, remoteArrayTypes4dim(new byps::test::api::remote::BStub_RemoteArrayTypes4dim(transport))
	, remoteConstants(new byps::test::api::remote::BStub_RemoteConstants(transport))
	, remoteEnums(new byps::test::api::remote::BStub_RemoteEnums(transport))
	, remoteInlineInstance(new byps::test::api::remote::BStub_RemoteInlineInstance(transport))
	, remoteListTypes(new byps::test::api::remote::BStub_RemoteListTypes(transport))
	, remoteMapTypes(new byps::test::api::remote::BStub_RemoteMapTypes(transport))
	, remotePrimitiveTypes(new byps::test::api::remote::BStub_RemotePrimitiveTypes(transport))
	, remoteReferences(new byps::test::api::remote::BStub_RemoteReferences(transport))
	, remoteServerCtrl(new byps::test::api::remote::BStub_RemoteServerCtrl(transport))
	, remoteSetTypes(new byps::test::api::remote::BStub_RemoteSetTypes(transport))
	, remoteStreams(new byps::test::api::remote::BStub_RemoteStreams(transport))
	, remoteWithAuthentication(new byps::test::api::remote::BStub_RemoteWithAuthentication(transport))
	, clientIF(new byps::test::api::srvr::BStub_ClientIF(transport))
	, serverIF(new byps::test::api::srvr::BStub_ServerIF(transport))
	, evolveIF(new byps::test::api::ver::BStub_EvolveIF(transport))
	{
}
BClient_Testser::BClient_Testser(PTransport transport) 
	: BClient(transport, NULL)
	, bioFruitService(new byps::test::api::inherit::BStub_BioFruitService(transport))
	, bioLemonService(new byps::test::api::inherit::BStub_BioLemonService(transport))
	, fruitService(new byps::test::api::inherit::BStub_FruitService(transport))
	, lemonService(new byps::test::api::inherit::BStub_LemonService(transport))
	, plantService(new byps::test::api::inherit::BStub_PlantService(transport))
	, remoteArrayTypes1dim(new byps::test::api::remote::BStub_RemoteArrayTypes1dim(transport))
	, remoteArrayTypes23(new byps::test::api::remote::BStub_RemoteArrayTypes23(transport))
	, remoteArrayTypes4dim(new byps::test::api::remote::BStub_RemoteArrayTypes4dim(transport))
	, remoteConstants(new byps::test::api::remote::BStub_RemoteConstants(transport))
	, remoteEnums(new byps::test::api::remote::BStub_RemoteEnums(transport))
	, remoteInlineInstance(new byps::test::api::remote::BStub_RemoteInlineInstance(transport))
	, remoteListTypes(new byps::test::api::remote::BStub_RemoteListTypes(transport))
	, remoteMapTypes(new byps::test::api::remote::BStub_RemoteMapTypes(transport))
	, remotePrimitiveTypes(new byps::test::api::remote::BStub_RemotePrimitiveTypes(transport))
	, remoteReferences(new byps::test::api::remote::BStub_RemoteReferences(transport))
	, remoteServerCtrl(new byps::test::api::remote::BStub_RemoteServerCtrl(transport))
	, remoteSetTypes(new byps::test::api::remote::BStub_RemoteSetTypes(transport))
	, remoteStreams(new byps::test::api::remote::BStub_RemoteStreams(transport))
	, remoteWithAuthentication(new byps::test::api::remote::BStub_RemoteWithAuthentication(transport))
	, clientIF(new byps::test::api::srvr::BStub_ClientIF(transport))
	, serverIF(new byps::test::api::srvr::BStub_ServerIF(transport))
	, evolveIF(new byps::test::api::ver::BStub_EvolveIF(transport))
	{
}
PRemote BClient_Testser::getStub(int remoteId) {
	if (remoteId == 1881829396) return bioFruitService;
	if (remoteId == 1992245333) return bioLemonService;
	if (remoteId == 506940662) return fruitService;
	if (remoteId == 617356599) return lemonService;
	if (remoteId == 1117460801) return plantService;
	if (remoteId == 1557084481) return remoteArrayTypes1dim;
	if (remoteId == 2081058997) return remoteArrayTypes23;
	if (remoteId == 1557173854) return remoteArrayTypes4dim;
	if (remoteId == 431648293) return remoteConstants;
	if (remoteId == 359349400) return remoteEnums;
	if (remoteId == 1206670536) return remoteInlineInstance;
	if (remoteId == 380156079) return remoteListTypes;
	if (remoteId == 80483097) return remoteMapTypes;
	if (remoteId == 1341983932) return remotePrimitiveTypes;
	if (remoteId == 2086824050) return remoteReferences;
	if (remoteId == 1124545992) return remoteServerCtrl;
	if (remoteId == 1156008353) return remoteSetTypes;
	if (remoteId == 2028487863) return remoteStreams;
	if (remoteId == 1677934392) return remoteWithAuthentication;
	if (remoteId == 1784257353) return clientIF;
	if (remoteId == 1313562065) return serverIF;
	if (remoteId == 2078696281) return evolveIF;
	return PRemote();
}
}}}

namespace byps { namespace test { namespace api { 

PServer_Testser BServer_Testser::createServer(PTransportFactory transportFactory) {
	return PServer_Testser(new BServer_Testser(transportFactory));
}
PServer_Testser BServer_Testser::createServerR(PTransport transport) {
	return PServer_Testser(new BServer_Testser(transport));
}
void BServer_Testser::addRemote(byps::test::api::inherit::PSkeleton_BioFruitService remoteSkeleton) {
	BServer::addRemote(1881829396, remoteSkeleton);
}

void BServer_Testser::addRemote(byps::test::api::inherit::PSkeleton_BioLemonService remoteSkeleton) {
	BServer::addRemote(1992245333, remoteSkeleton);
}

void BServer_Testser::addRemote(byps::test::api::remote::PSkeleton_RemoteWithAuthentication remoteSkeleton) {
	BServer::addRemote(1677934392, remoteSkeleton);
}

void BServer_Testser::addRemote(byps::test::api::srvr::PSkeleton_ClientIF remoteSkeleton) {
	BServer::addRemote(1784257353, remoteSkeleton);
}

BServer_Testser::BServer_Testser(PTransportFactory transportFactory) 
	: BServer(
		transportFactory->createServerTransport(), 
		transportFactory->createClientR(
			BClient_Testser::createClientR(transportFactory->createClientTransport())
		)
	)
	{
}
BServer_Testser::BServer_Testser(PTransport transport) 
	: BServer(transport, NULL)
	{
}
}}}

