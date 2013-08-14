#include "Testser-impl.h"
using namespace std;
using namespace com::wilutions::byps;

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

PApiDescriptor BApiDescriptor_Testser::instance() {
	return PApiDescriptor((new BApiDescriptor(
	"Testser",
	"com.wilutions.byps.test.api",
	VERSION,
	false)) // uniqueObjects
	->addRegistry(PRegistry(new BRegistry_Testser()))
	);
};

}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

PClient_Testser BClient_Testser::createClient(PTransportFactory transportFactory) {
	return PClient_Testser(new BClient_Testser(transportFactory));
}
PClient_Testser BClient_Testser::createClientR(PTransport transport) {
	return PClient_Testser(new BClient_Testser(transport));
}
void BClient_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteArrayTypes1dim remoteSkeleton) {
	if (!serverR) throw BException(EX_INTERNAL, L"Missing reverse server. It should have been created by TransportFactory::createServerR().");
	serverR->server->addRemote(1557084481, remoteSkeleton);
}
void BClient_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteArrayTypes23 remoteSkeleton) {
	if (!serverR) throw BException(EX_INTERNAL, L"Missing reverse server. It should have been created by TransportFactory::createServerR().");
	serverR->server->addRemote(2081058997, remoteSkeleton);
}
void BClient_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteArrayTypes4dim remoteSkeleton) {
	if (!serverR) throw BException(EX_INTERNAL, L"Missing reverse server. It should have been created by TransportFactory::createServerR().");
	serverR->server->addRemote(1557173854, remoteSkeleton);
}
void BClient_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteConstants remoteSkeleton) {
	if (!serverR) throw BException(EX_INTERNAL, L"Missing reverse server. It should have been created by TransportFactory::createServerR().");
	serverR->server->addRemote(431648293, remoteSkeleton);
}
void BClient_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteEnums remoteSkeleton) {
	if (!serverR) throw BException(EX_INTERNAL, L"Missing reverse server. It should have been created by TransportFactory::createServerR().");
	serverR->server->addRemote(359349400, remoteSkeleton);
}
void BClient_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteInlineInstance remoteSkeleton) {
	if (!serverR) throw BException(EX_INTERNAL, L"Missing reverse server. It should have been created by TransportFactory::createServerR().");
	serverR->server->addRemote(1206670536, remoteSkeleton);
}
void BClient_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteListTypes remoteSkeleton) {
	if (!serverR) throw BException(EX_INTERNAL, L"Missing reverse server. It should have been created by TransportFactory::createServerR().");
	serverR->server->addRemote(380156079, remoteSkeleton);
}
void BClient_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteMapTypes remoteSkeleton) {
	if (!serverR) throw BException(EX_INTERNAL, L"Missing reverse server. It should have been created by TransportFactory::createServerR().");
	serverR->server->addRemote(80483097, remoteSkeleton);
}
void BClient_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemotePrimitiveTypes remoteSkeleton) {
	if (!serverR) throw BException(EX_INTERNAL, L"Missing reverse server. It should have been created by TransportFactory::createServerR().");
	serverR->server->addRemote(1341983932, remoteSkeleton);
}
void BClient_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteReferences remoteSkeleton) {
	if (!serverR) throw BException(EX_INTERNAL, L"Missing reverse server. It should have been created by TransportFactory::createServerR().");
	serverR->server->addRemote(2086824050, remoteSkeleton);
}
void BClient_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteServerCtrl remoteSkeleton) {
	if (!serverR) throw BException(EX_INTERNAL, L"Missing reverse server. It should have been created by TransportFactory::createServerR().");
	serverR->server->addRemote(1124545992, remoteSkeleton);
}
void BClient_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteSetTypes remoteSkeleton) {
	if (!serverR) throw BException(EX_INTERNAL, L"Missing reverse server. It should have been created by TransportFactory::createServerR().");
	serverR->server->addRemote(1156008353, remoteSkeleton);
}
void BClient_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteStreams remoteSkeleton) {
	if (!serverR) throw BException(EX_INTERNAL, L"Missing reverse server. It should have been created by TransportFactory::createServerR().");
	serverR->server->addRemote(2028487863, remoteSkeleton);
}
void BClient_Testser::addRemote(com::wilutions::byps::test::api::srvr::PSkeleton_ClientIF remoteSkeleton) {
	if (!serverR) throw BException(EX_INTERNAL, L"Missing reverse server. It should have been created by TransportFactory::createServerR().");
	serverR->server->addRemote(1784257353, remoteSkeleton);
}
void BClient_Testser::addRemote(com::wilutions::byps::test::api::srvr::PSkeleton_ServerIF remoteSkeleton) {
	if (!serverR) throw BException(EX_INTERNAL, L"Missing reverse server. It should have been created by TransportFactory::createServerR().");
	serverR->server->addRemote(1313562065, remoteSkeleton);
}
void BClient_Testser::addRemote(com::wilutions::byps::test::api::ver::PSkeleton_EvolveIF remoteSkeleton) {
	if (!serverR) throw BException(EX_INTERNAL, L"Missing reverse server. It should have been created by TransportFactory::createServerR().");
	serverR->server->addRemote(2078696281, remoteSkeleton);
}
BClient_Testser::BClient_Testser(PTransportFactory transportFactory) 
	: BClient(
		transportFactory->createClientTransport(), 
		transportFactory->createServerR(
			BServer_Testser::createServerR(transportFactory->createServerTransport())
		)
	)
	, remoteArrayTypes1dim(new com::wilutions::byps::test::api::remote::BStub_RemoteArrayTypes1dim(transport))
	, remoteArrayTypes23(new com::wilutions::byps::test::api::remote::BStub_RemoteArrayTypes23(transport))
	, remoteArrayTypes4dim(new com::wilutions::byps::test::api::remote::BStub_RemoteArrayTypes4dim(transport))
	, remoteConstants(new com::wilutions::byps::test::api::remote::BStub_RemoteConstants(transport))
	, remoteEnums(new com::wilutions::byps::test::api::remote::BStub_RemoteEnums(transport))
	, remoteInlineInstance(new com::wilutions::byps::test::api::remote::BStub_RemoteInlineInstance(transport))
	, remoteListTypes(new com::wilutions::byps::test::api::remote::BStub_RemoteListTypes(transport))
	, remoteMapTypes(new com::wilutions::byps::test::api::remote::BStub_RemoteMapTypes(transport))
	, remotePrimitiveTypes(new com::wilutions::byps::test::api::remote::BStub_RemotePrimitiveTypes(transport))
	, remoteReferences(new com::wilutions::byps::test::api::remote::BStub_RemoteReferences(transport))
	, remoteServerCtrl(new com::wilutions::byps::test::api::remote::BStub_RemoteServerCtrl(transport))
	, remoteSetTypes(new com::wilutions::byps::test::api::remote::BStub_RemoteSetTypes(transport))
	, remoteStreams(new com::wilutions::byps::test::api::remote::BStub_RemoteStreams(transport))
	, clientIF(new com::wilutions::byps::test::api::srvr::BStub_ClientIF(transport))
	, serverIF(new com::wilutions::byps::test::api::srvr::BStub_ServerIF(transport))
	, evolveIF(new com::wilutions::byps::test::api::ver::BStub_EvolveIF(transport))
	{
}
BClient_Testser::BClient_Testser(PTransport transport) 
	: BClient(transport, NULL)
	, remoteArrayTypes1dim(new com::wilutions::byps::test::api::remote::BStub_RemoteArrayTypes1dim(transport))
	, remoteArrayTypes23(new com::wilutions::byps::test::api::remote::BStub_RemoteArrayTypes23(transport))
	, remoteArrayTypes4dim(new com::wilutions::byps::test::api::remote::BStub_RemoteArrayTypes4dim(transport))
	, remoteConstants(new com::wilutions::byps::test::api::remote::BStub_RemoteConstants(transport))
	, remoteEnums(new com::wilutions::byps::test::api::remote::BStub_RemoteEnums(transport))
	, remoteInlineInstance(new com::wilutions::byps::test::api::remote::BStub_RemoteInlineInstance(transport))
	, remoteListTypes(new com::wilutions::byps::test::api::remote::BStub_RemoteListTypes(transport))
	, remoteMapTypes(new com::wilutions::byps::test::api::remote::BStub_RemoteMapTypes(transport))
	, remotePrimitiveTypes(new com::wilutions::byps::test::api::remote::BStub_RemotePrimitiveTypes(transport))
	, remoteReferences(new com::wilutions::byps::test::api::remote::BStub_RemoteReferences(transport))
	, remoteServerCtrl(new com::wilutions::byps::test::api::remote::BStub_RemoteServerCtrl(transport))
	, remoteSetTypes(new com::wilutions::byps::test::api::remote::BStub_RemoteSetTypes(transport))
	, remoteStreams(new com::wilutions::byps::test::api::remote::BStub_RemoteStreams(transport))
	, clientIF(new com::wilutions::byps::test::api::srvr::BStub_ClientIF(transport))
	, serverIF(new com::wilutions::byps::test::api::srvr::BStub_ServerIF(transport))
	, evolveIF(new com::wilutions::byps::test::api::ver::BStub_EvolveIF(transport))
	{
}
PRemote BClient_Testser::getStub(int remoteId) {
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
	if (remoteId == 1784257353) return clientIF;
	if (remoteId == 1313562065) return serverIF;
	if (remoteId == 2078696281) return evolveIF;
	return PRemote();
}
}}}}}

namespace com { namespace wilutions { namespace byps { namespace test { namespace api { 

PServer_Testser BServer_Testser::createServer(PTransportFactory transportFactory) {
	return PServer_Testser(new BServer_Testser(transportFactory));
}
PServer_Testser BServer_Testser::createServerR(PTransport transport) {
	return PServer_Testser(new BServer_Testser(transport));
}
void BServer_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteArrayTypes1dim remoteSkeleton) {
	BServer::addRemote(1557084481, remoteSkeleton);
}
void BServer_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteArrayTypes23 remoteSkeleton) {
	BServer::addRemote(2081058997, remoteSkeleton);
}
void BServer_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteArrayTypes4dim remoteSkeleton) {
	BServer::addRemote(1557173854, remoteSkeleton);
}
void BServer_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteConstants remoteSkeleton) {
	BServer::addRemote(431648293, remoteSkeleton);
}
void BServer_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteEnums remoteSkeleton) {
	BServer::addRemote(359349400, remoteSkeleton);
}
void BServer_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteInlineInstance remoteSkeleton) {
	BServer::addRemote(1206670536, remoteSkeleton);
}
void BServer_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteListTypes remoteSkeleton) {
	BServer::addRemote(380156079, remoteSkeleton);
}
void BServer_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteMapTypes remoteSkeleton) {
	BServer::addRemote(80483097, remoteSkeleton);
}
void BServer_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemotePrimitiveTypes remoteSkeleton) {
	BServer::addRemote(1341983932, remoteSkeleton);
}
void BServer_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteReferences remoteSkeleton) {
	BServer::addRemote(2086824050, remoteSkeleton);
}
void BServer_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteServerCtrl remoteSkeleton) {
	BServer::addRemote(1124545992, remoteSkeleton);
}
void BServer_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteSetTypes remoteSkeleton) {
	BServer::addRemote(1156008353, remoteSkeleton);
}
void BServer_Testser::addRemote(com::wilutions::byps::test::api::remote::PSkeleton_RemoteStreams remoteSkeleton) {
	BServer::addRemote(2028487863, remoteSkeleton);
}
void BServer_Testser::addRemote(com::wilutions::byps::test::api::srvr::PSkeleton_ClientIF remoteSkeleton) {
	BServer::addRemote(1784257353, remoteSkeleton);
}
void BServer_Testser::addRemote(com::wilutions::byps::test::api::srvr::PSkeleton_ServerIF remoteSkeleton) {
	BServer::addRemote(1313562065, remoteSkeleton);
}
void BServer_Testser::addRemote(com::wilutions::byps::test::api::ver::PSkeleton_EvolveIF remoteSkeleton) {
	BServer::addRemote(2078696281, remoteSkeleton);
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
}}}}}

