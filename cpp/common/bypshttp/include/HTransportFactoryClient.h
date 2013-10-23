#ifndef HTRANSPORTFACTORYCLIENT_H_
#define HTRANSPORTFACTORYCLIENT_H_

#include "Bypshttp.h"

namespace byps { namespace http {

using namespace byps;

class HTransportFactoryClient : public BTransportFactory {
public:
	HTransportFactoryClient(PApiDescriptor apiDesc, PWire wire, int nbOfServerRConns);

    virtual PTransport createClientTransport();
    virtual PTransport createServerTransport();
    virtual PClient createClientR(PClient);
    virtual PServerR createServerR(PServer);

private:
	const PTransport transport;
	const int nbOfServerRConns;
};

}}

#endif
