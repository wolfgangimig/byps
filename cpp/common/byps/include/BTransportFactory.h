#ifndef BTRANSPORTFACTORY_H
#define BTRANSPORTFACTORY_H

#include "Byps.h"

namespace byps {

class BTransportFactory {
public:
    virtual PTransport createClientTransport() = 0;
    virtual PTransport createServerTransport() = 0;
    virtual PClient createClientR(PClient) = 0;
    virtual PServerR createServerR(PServer) = 0;
};

}

#endif // BTRANSPORTFACTORY_H
