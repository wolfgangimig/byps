#ifndef BTESTADAPTER_H_
#define BTESTADAPTER_H_

namespace com { namespace wilutions { namespace byps {

class BTestAdapter {
public:
	virtual ~BTestAdapter() {}

	virtual void killClientConnections() = 0;
};

}}}

#endif