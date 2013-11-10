#include "Testser-impl.h"
using namespace ::std;
using namespace ::byps;

namespace byps { namespace test { namespace api { 

PApiDescriptor BApiDescriptor_Testser::instance() {
	return PApiDescriptor((new BApiDescriptor(
	"Testser",
	"byps.test.api",
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
	serverR->server->addRemote(363642571, remoteSkeleton);
}

void BClient_Testser::addRemote(byps::test::api::inherit::PSkeleton_BioLemonService remoteSkeleton) {
	if (!serverR) throw BException(EX_NO_REVERSE_CONNECTIONS, L"No reverse connections.");
	serverR->server->addRemote(474058508, remoteSkeleton);
}

void BClient_Testser::addRemote(byps::test::api::remote::PSkeleton_RemoteWithAuthentication remoteSkeleton) {
	if (!serverR) throw BException(EX_NO_REVERSE_CONNECTIONS, L"No reverse connections.");
	serverR->server->addRemote(1983670399, remoteSkeleton);
}

void BClient_Testser::addRemote(byps::test::api::srvr::PSkeleton_ClientIF remoteSkeleton) {
	if (!serverR) throw BException(EX_NO_REVERSE_CONNECTIONS, L"No reverse connections.");
	serverR->server->addRemote(2049072174, remoteSkeleton);
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
	if (remoteId == 363642571) return bioFruitService;
	if (remoteId == 474058508) return bioLemonService;
	if (remoteId == 715959905) return fruitService;
	if (remoteId == 605543968) return lemonService;
	if (remoteId == 1954605928) return plantService;
	if (remoteId == 963816328) return remoteArrayTypes1dim;
	if (remoteId == 769717182) return remoteArrayTypes23;
	if (remoteId == 963726955) return remoteArrayTypes4dim;
	if (remoteId == 2045242510) return remoteConstants;
	if (remoteId == 485761455) return remoteEnums;
	if (remoteId == 567395951) return remoteInlineInstance;
	if (remoteId == 1233438138) return remoteListTypes;
	if (remoteId == 664304990) return remoteMapTypes;
	if (remoteId == 1178916877) return remotePrimitiveTypes;
	if (remoteId == 568637225) return remoteReferences;
	if (remoteId == 1652234479) return remoteServerCtrl;
	if (remoteId == 1900796440) return remoteSetTypes;
	if (remoteId == 1043578866) return remoteStreams;
	if (remoteId == 1983670399) return remoteWithAuthentication;
	if (remoteId == 2049072174) return clientIF;
	if (remoteId == 1775199834) return serverIF;
	if (remoteId == 15377840) return evolveIF;
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
	BServer::addRemote(363642571, remoteSkeleton);
}

void BServer_Testser::addRemote(byps::test::api::inherit::PSkeleton_BioLemonService remoteSkeleton) {
	BServer::addRemote(474058508, remoteSkeleton);
}

void BServer_Testser::addRemote(byps::test::api::remote::PSkeleton_RemoteWithAuthentication remoteSkeleton) {
	BServer::addRemote(1983670399, remoteSkeleton);
}

void BServer_Testser::addRemote(byps::test::api::srvr::PSkeleton_ClientIF remoteSkeleton) {
	BServer::addRemote(2049072174, remoteSkeleton);
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

