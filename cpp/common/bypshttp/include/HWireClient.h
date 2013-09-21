#ifndef HWIRECLIENT_H_
#define HWIRECLIENT_H_

#include "Byps.h"
#include "Bypshttp.h"
#include "BLogger.h"
#include <random>

namespace com { namespace wilutions { namespace byps { namespace http {

using namespace com::wilutions::byps;

class HWireClient_RequestsToCancel;
typedef byps_ptr<HWireClient_RequestsToCancel> PWireClient_RequestsToCancel;

const int64_t MESSAGEID_CANCEL_ALL_REQUESTS = -1;
const int64_t MESSAGEID_DISCONNECT = -2;

class HWireClient : public BWire, public std::enable_shared_from_this<HWireClient> {
	std::mt19937_64 rand;
	PHttpClient httpClient;
	void* app;
    static BLogger log;

public:
	const std::wstring url;

    static PWire create(void* app, const std::wstring& url, int32_t flags, int32_t timeoutSeconds, PThreadPool tpool);

	virtual ~HWireClient();

    virtual void send(const PMessage& msg, PAsyncResult asyncResult);

    virtual void sendR(const PMessage& msg, PAsyncResult asyncResult);

	virtual PContentStream getStream(int64_t messageId, int64_t streamId);

    virtual int64_t makeMessageId();

	virtual void done();
	
	virtual void cancelAllRequests();

	void throwLastException();

	virtual PTestAdapter getTestAdapter();

protected:
	HWireClient(void* app, const std::wstring& url, int32_t flags, int32_t timeoutSeconds, PThreadPool tpool);

	void init();

	PWireClient_RequestsToCancel requestsToCancel;

	BException lastException;
	int32_t timeoutSecondsClient;
	PThreadPool tpool;
	bool isMyThreadPool;
	byps_atomic<bool> isDone;

	void internalCancelAllRequests(int64_t cancelMessageId, PAsyncResult asyncResult);

	void internalSend(const PMessage& msg, PAsyncResult asyncResult, int32_t timeoutSeconds);
	void sendCancelMessage(int64_t messageId);

	friend class HWireClient_TestAdapter;
	friend class HWireClient_AsyncResultAfterAllRequests;
};

}}}}

#endif
