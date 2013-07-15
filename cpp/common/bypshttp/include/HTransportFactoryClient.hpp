#ifndef HTRANSPORTFACTORYCLIENT_HPP_
#define HTRANSPORTFACTORYCLIENT_HPP_

#include "HTransportFactoryClient.h"

namespace com { namespace wilutions { namespace byps { namespace http {

using namespace com::wilutions::byps;

BINLINE HTransportFactoryClient::HTransportFactoryClient(PApiDescriptor apiDesc, PWire wire, int nbOfServerRConns) 
	: transport(new BTransport(apiDesc, wire, PRemoteRegistry()))
    , nbOfServerRConns(nbOfServerRConns) {
}

BINLINE PTransport HTransportFactoryClient::createClientTransport() {
	return transport;
}

BINLINE PTransport HTransportFactoryClient::createServerTransport() {
	return transport;
}

BINLINE PClient HTransportFactoryClient::createClientR(PClient) {
	return PClient();
}

BINLINE PServerR HTransportFactoryClient::createServerR(PServer server) {
	return PServerR( new HServerR(transport, server, nbOfServerRConns) );
}



}}}}

#endif
