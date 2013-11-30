/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BLOSTCONNECTIONHANDLER_HPP_
#define BLOSTCONNECTIONHANDLER_HPP_

#include "BLostConnectionHandler.h"

namespace byps {
	
#ifdef CPP11_LAMBDA

BINLINE BLostConnectionHandlerL::BLostConnectionHandlerL(std::function<void (BException ex)> lambdaFunction)
	: lambdaFunction(lambdaFunction) {
}

BINLINE void BLostConnectionHandlerL::onLostConnection(BException ex) {
	lambdaFunction(ex);
};

#endif

}

#endif