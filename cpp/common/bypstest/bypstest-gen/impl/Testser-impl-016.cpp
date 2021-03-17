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
void BClient_Testser::addRemote(byps::test::api::srvr::PSkeleton_ClientIF remoteSkeleton) {
	if (!serverR) throw BException(BExceptionC::NO_REVERSE_CONNECTIONS, L"No reverse connections.");
	serverR->server->addRemote(2049072174, remoteSkeleton);
}

BClient_Testser::BClient_Testser(PTransportFactory transportFactory) 
	: BClient(
		transportFactory->createClientTransport(), 
		transportFactory->createServerR(
			BServer_Testser::createServerR(transportFactory->createServerTransport())
		)
	)
	{
	initStubs(transport);
}
BClient_Testser::BClient_Testser(PTransport transport) 
	: BClient(transport, NULL)
	{
	initStubs(transport);
}
BINLINE byps::test::api::inherit::PBioFruitServiceAuth BClient_Testser::getBioFruitService() {
	return bioFruitService;
}
BINLINE byps::test::api::inherit::PBioLemonServiceAuth BClient_Testser::getBioLemonService() {
	return bioLemonService;
}
BINLINE byps::test::api::inherit::PFruitServiceAuth BClient_Testser::getFruitService() {
	return fruitService;
}
BINLINE byps::test::api::inherit::PLemonServiceAuth BClient_Testser::getLemonService() {
	return lemonService;
}
BINLINE byps::test::api::inherit::PPlantServiceAuth BClient_Testser::getPlantService() {
	return plantService;
}
BINLINE byps::test::api::remote::PRemoteArrayTypes1dim BClient_Testser::getRemoteArrayTypes1dim() {
	return remoteArrayTypes1dim;
}
BINLINE byps::test::api::remote::PRemoteArrayTypes23 BClient_Testser::getRemoteArrayTypes23() {
	return remoteArrayTypes23;
}
BINLINE byps::test::api::remote::PRemoteArrayTypes4dim BClient_Testser::getRemoteArrayTypes4dim() {
	return remoteArrayTypes4dim;
}
BINLINE byps::test::api::remote::PRemoteConstants BClient_Testser::getRemoteConstants() {
	return remoteConstants;
}
BINLINE byps::test::api::remote::PRemoteEnums BClient_Testser::getRemoteEnums() {
	return remoteEnums;
}
BINLINE byps::test::api::remote::PRemoteInlineInstance BClient_Testser::getRemoteInlineInstance() {
	return remoteInlineInstance;
}
BINLINE byps::test::api::remote::PRemoteListTypes BClient_Testser::getRemoteListTypes() {
	return remoteListTypes;
}
BINLINE byps::test::api::remote::PRemoteMapTypes BClient_Testser::getRemoteMapTypes() {
	return remoteMapTypes;
}
BINLINE byps::test::api::remote::PRemotePrimitiveTypes BClient_Testser::getRemotePrimitiveTypes() {
	return remotePrimitiveTypes;
}
BINLINE byps::test::api::remote::PRemoteProcessingEx BClient_Testser::getRemoteProcessingEx() {
	return remoteProcessingEx;
}
BINLINE byps::test::api::remote::PRemoteReferences BClient_Testser::getRemoteReferences() {
	return remoteReferences;
}
BINLINE byps::test::api::remote::PRemoteServerCtrl BClient_Testser::getRemoteServerCtrl() {
	return remoteServerCtrl;
}
BINLINE byps::test::api::remote::PRemoteSetTypes BClient_Testser::getRemoteSetTypes() {
	return remoteSetTypes;
}
BINLINE byps::test::api::remote::PRemoteStreams BClient_Testser::getRemoteStreams() {
	return remoteStreams;
}
BINLINE byps::test::api::remote::PRemoteWithAuthenticationAuth BClient_Testser::getRemoteWithAuthentication() {
	return remoteWithAuthentication;
}
BINLINE byps::test::api::srvr::PClientIF BClient_Testser::getClientIF() {
	return clientIF;
}
BINLINE byps::test::api::srvr::PServerIF BClient_Testser::getServerIF() {
	return serverIF;
}
BINLINE byps::test::api::ver::PEvolveIF BClient_Testser::getEvolveIF() {
	return evolveIF;
}
PRemote BClient_Testser::getStub(int remoteId) {
	if (remoteId == 363642571) return bioFruitService;
	if (remoteId == 474058508) return bioLemonService;
	if (remoteId == 715959905) return fruitService;
	if (remoteId == 605543968) return lemonService;
	if (remoteId == 1954605928) return plantService;
	if (remoteId == 123123) return remoteArrayTypes1dim;
	if (remoteId == 769717182) return remoteArrayTypes23;
	if (remoteId == 963726955) return remoteArrayTypes4dim;
	if (remoteId == 2045242510) return remoteConstants;
	if (remoteId == 485761455) return remoteEnums;
	if (remoteId == 567395951) return remoteInlineInstance;
	if (remoteId == 1233438138) return remoteListTypes;
	if (remoteId == 664304990) return remoteMapTypes;
	if (remoteId == 456456) return remotePrimitiveTypes;
	if (remoteId == 790485113) return remoteProcessingEx;
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
BINLINE void BClient_Testser::initStubs(PTransport transport) {
	bioFruitService = byps::test::api::inherit::PBioFruitServiceAuth(new byps::test::api::inherit::BStub_BioFruitService(transport));
	bioLemonService = byps::test::api::inherit::PBioLemonServiceAuth(new byps::test::api::inherit::BStub_BioLemonService(transport));
	fruitService = byps::test::api::inherit::PFruitServiceAuth(new byps::test::api::inherit::BStub_FruitService(transport));
	lemonService = byps::test::api::inherit::PLemonServiceAuth(new byps::test::api::inherit::BStub_LemonService(transport));
	plantService = byps::test::api::inherit::PPlantServiceAuth(new byps::test::api::inherit::BStub_PlantService(transport));
	remoteArrayTypes1dim = byps::test::api::remote::PRemoteArrayTypes1dim(new byps::test::api::remote::BStub_RemoteArrayTypes1dim(transport));
	remoteArrayTypes23 = byps::test::api::remote::PRemoteArrayTypes23(new byps::test::api::remote::BStub_RemoteArrayTypes23(transport));
	remoteArrayTypes4dim = byps::test::api::remote::PRemoteArrayTypes4dim(new byps::test::api::remote::BStub_RemoteArrayTypes4dim(transport));
	remoteConstants = byps::test::api::remote::PRemoteConstants(new byps::test::api::remote::BStub_RemoteConstants(transport));
	remoteEnums = byps::test::api::remote::PRemoteEnums(new byps::test::api::remote::BStub_RemoteEnums(transport));
	remoteInlineInstance = byps::test::api::remote::PRemoteInlineInstance(new byps::test::api::remote::BStub_RemoteInlineInstance(transport));
	remoteListTypes = byps::test::api::remote::PRemoteListTypes(new byps::test::api::remote::BStub_RemoteListTypes(transport));
	remoteMapTypes = byps::test::api::remote::PRemoteMapTypes(new byps::test::api::remote::BStub_RemoteMapTypes(transport));
	remotePrimitiveTypes = byps::test::api::remote::PRemotePrimitiveTypes(new byps::test::api::remote::BStub_RemotePrimitiveTypes(transport));
	remoteProcessingEx = byps::test::api::remote::PRemoteProcessingEx(new byps::test::api::remote::BStub_RemoteProcessingEx(transport));
	remoteReferences = byps::test::api::remote::PRemoteReferences(new byps::test::api::remote::BStub_RemoteReferences(transport));
	remoteServerCtrl = byps::test::api::remote::PRemoteServerCtrl(new byps::test::api::remote::BStub_RemoteServerCtrl(transport));
	remoteSetTypes = byps::test::api::remote::PRemoteSetTypes(new byps::test::api::remote::BStub_RemoteSetTypes(transport));
	remoteStreams = byps::test::api::remote::PRemoteStreams(new byps::test::api::remote::BStub_RemoteStreams(transport));
	remoteWithAuthentication = byps::test::api::remote::PRemoteWithAuthenticationAuth(new byps::test::api::remote::BStub_RemoteWithAuthentication(transport));
	clientIF = byps::test::api::srvr::PClientIF(new byps::test::api::srvr::BStub_ClientIF(transport));
	serverIF = byps::test::api::srvr::PServerIF(new byps::test::api::srvr::BStub_ServerIF(transport));
	evolveIF = byps::test::api::ver::PEvolveIF(new byps::test::api::ver::BStub_EvolveIF(transport));
}
}}}

namespace byps { namespace test { namespace api { 

PServer_Testser BServer_Testser::createServer(PTransportFactory transportFactory) {
	return PServer_Testser(new BServer_Testser(transportFactory));
}
PServer_Testser BServer_Testser::createServerR(PTransport transport) {
	return PServer_Testser(new BServer_Testser(transport));
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

