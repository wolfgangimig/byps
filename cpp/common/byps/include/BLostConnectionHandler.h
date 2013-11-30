/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BLOSTCONNECTIONHANDLER_H_
#define BLOSTCONNECTIONHANDLER_H_

#include "Byps.h"

namespace byps {

class BLostConnectionHandler {
public:
	virtual ~BLostConnectionHandler() {}
	virtual void onLostConnection(BException ex) = 0;
};

#ifdef CPP11_LAMBDA

class BLostConnectionHandlerL : public BLostConnectionHandler {
	std::function<void (BException ex)> lambdaFunction;
public:
	BLostConnectionHandlerL(std::function<void (BException ex)> lambdaFunction);
	virtual ~BLostConnectionHandlerL() {}
	virtual void onLostConnection(BException ex);
};

#endif

}

#endif