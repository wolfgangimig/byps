/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef HSERVERR_H_
#define HSERVERR_H_

#include "Bypshttp.h"

namespace byps { namespace http {

using namespace byps;

class HServerR_SendLongPoll;
typedef byps_ptr<HServerR_SendLongPoll> PServerR_SendLongPoll;

class HServerR : public BServerR {
public:
	HServerR(PTransport transport, PServer server, int nbOfConns);
	virtual ~HServerR();
	virtual void start();
	virtual void done();
	virtual void setLostConnectionHandler(PLostConnectionHandler lostConnectionHandler);
protected:
	int nbOfConns;
	PServerR_SendLongPoll sendLongPoll;
};

}}
#endif