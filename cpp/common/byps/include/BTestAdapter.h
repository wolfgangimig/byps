/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BTESTADAPTER_H_
#define BTESTADAPTER_H_

namespace byps {

class BTestAdapter {
public:
	virtual ~BTestAdapter() {}

	virtual void killClientConnections() = 0;
};

}

#endif