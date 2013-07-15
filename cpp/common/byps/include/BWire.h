#ifndef BWIRE_H_
#define BWIRE_H_

#include "Byps.h"

namespace com { namespace wilutions { namespace byps {


class BWire {
public:
	virtual ~BWire();

    virtual void send(const PMessage& bytes, PAsyncResult asyncResult);

	virtual void sendR(const PMessage& msg, PAsyncResult asyncResult);

	virtual PContentStream getStream(int64_t messageId, int64_t streamId);

    virtual int64_t makeMessageId();

	virtual void done();

	virtual void cancelAllRequests();

	virtual PTestAdapter getTestAdapter();
};


}}}

#endif
