/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef HWIRECLIENTI_H_
#define HWIRECLIENTI_H_


#include "HWireClient.h"

namespace byps { namespace http {

using namespace byps;

class HWireClient_AsyncResultAfterAllRequests;
class HWireClient_RequestToCancel;
class HWireClient_RequestsToCancel;
typedef byps_ptr<HWireClient_RequestToCancel> PWireClient_RequestToCancel;
typedef byps_ptr<HWireClient_RequestsToCancel> PWireClient_RequestsToCancel;

class HWireClient_RequestsToCancel {
public:

	HWireClient_RequestsToCancel();

	virtual ~HWireClient_RequestsToCancel();
    void add(intptr_t id, PHttpRequest r);
    void addCancelMessage(intptr_t id, PHttpRequest r);
    void remove(intptr_t id);
	void cancelAllRequests();

private:

    byps_mutex mutex;
    std::map<intptr_t, PHttpRequest> map;
    static BLogger log;
};

class HWireClient_AsyncResultAfterAllRequests : public BAsyncResult {
public:
    HWireClient_AsyncResultAfterAllRequests(byps_ptr<HWireClient> wire, PThreadPool tpool, int64_t messageId, PAsyncResult innerResult, size_t nbOfRequests);
	virtual ~HWireClient_AsyncResultAfterAllRequests() {}
    virtual void setAsyncResult(const BVariant& obj);

private:
	byps_weak_ptr<HWireClient> wire;
	PThreadPool tpool;
	int64_t messageId;
    PAsyncResult innerResult;
    size_t nbOfRequests;
	size_t countRequests;
    byps_mutex mutex;
    BVariant result;
    static BLogger log;
};

class HWireClient_ExecResult : public BRunnable {
	PAsyncResult asyncResult;
	BVariant var;
    static BLogger log;
public:
	HWireClient_ExecResult(PAsyncResult asyncResult, BVariant var);
	virtual void run();
};

class HWireClient_TestAdapter : public BTestAdapter {
	byps_ptr<HWireClient> wire;
    static BLogger log;
public:

	HWireClient_TestAdapter(byps_ptr<HWireClient> wire) : wire(wire) {
	}

	virtual ~HWireClient_TestAdapter() {}

	virtual void killClientConnections();

};

}}

#endif
