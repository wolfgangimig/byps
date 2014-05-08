/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef BWIRE_H_
#define BWIRE_H_

#include "Byps.h"

namespace byps {


class BWire {
public:
	virtual ~BWire();

    virtual void send(const PMessage& bytes, PAsyncResult asyncResult);

	virtual void sendR(const PMessage& msg, PAsyncResult asyncResult);

	virtual PContentStream getStream(const BTargetId& targetId);

    virtual int64_t makeMessageId();

	virtual void done();

	virtual void cancelAllRequests();

	virtual PTestAdapter getTestAdapter();
};


}

#endif
