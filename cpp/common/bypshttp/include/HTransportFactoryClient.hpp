/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef HTRANSPORTFACTORYCLIENT_HPP_
#define HTRANSPORTFACTORYCLIENT_HPP_

#include "HTransportFactoryClient.h"

namespace byps { namespace http {

using namespace byps;

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
	return nbOfServerRConns ? 
		PServerR( new HServerR(transport, server, nbOfServerRConns) ) : 
		PServerR();
}



}}

#endif
