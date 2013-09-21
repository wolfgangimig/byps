#ifndef HWIRECLIENT_HPP_
#define HWIRECLIENT_HPP_

#include "Byps.h"
#include "HWireClient.h"
#include "HWireClientI.h"
#include <thread>

namespace com { namespace wilutions { namespace byps { namespace http {

using namespace com::wilutions::byps;


BINLINE int64_t HWireClient::makeMessageId() {
    int64_t v = rand();
    return v >= 0 ? v : -v;
}

BINLINE PTestAdapter HWireClient::getTestAdapter() {
	return PTestAdapter(new HWireClient_TestAdapter(shared_from_this()));
}

BINLINE HWireClient_RequestsToCancel::HWireClient_RequestsToCancel() 
	: isCanceled(false) {
}


BINLINE bool HWireClient_RequestsToCancel::add(intptr_t id, PHttpRequest r) {
    byps_unique_lock lock(mutex);
    l_debug << L"add(" << id;
	bool succ = !isCanceled;
	if (succ) {
		map[id] = r;
	}
    l_debug << L")add=" << succ;
	return succ;
}

BINLINE void HWireClient_RequestsToCancel::addCancelMessage(intptr_t id, PHttpRequest r) {
    byps_unique_lock lock(mutex);
	map[id] = r;
}

BINLINE void HWireClient_RequestsToCancel::remove(intptr_t id) {
    byps_unique_lock lock(mutex);
    l_debug << L"remove(" << id;
	std::map<intptr_t, PHttpRequest>::iterator it = map.find(id);
	if (it != map.end()) {
        (*it).second->close();
		map.erase(it);
	}
    l_debug << L")remove";
}

BINLINE void HWireClient_RequestsToCancel::cancel() {
    l_debug << L"cancel(";
    std::vector<PHttpRequest> requests;

    {
        byps_unique_lock lock(mutex);
        isCanceled = true;
        for (std::map<intptr_t, PHttpRequest>::iterator it = map.begin(); it != map.end(); it++) {
            requests.push_back((*it).second);
        }
        map.clear();
    }

    for (std::vector<PHttpRequest>::iterator it = requests.begin(); it != requests.end(); it++) {
        (*it)->close();
    }

    l_debug << L")cancel";
}

BINLINE HWireClient_RequestsToCancel::~HWireClient_RequestsToCancel() {
    l_debug << L"dtor(";
	map.clear();
    l_debug << L")dtor";
}


BINLINE PWire HWireClient::create(void* app, const std::wstring& url, int32_t flags, int32_t timeoutSeconds, PThreadPool tpool) {
    l_debug << L"create(" << url << L", flags=" << flags << L", timeoutSeconds=" << timeoutSeconds;
	HWireClient* pThis = new HWireClient(app, url, flags, timeoutSeconds, tpool);
	pThis->init();
    PWire ret = PWire(pThis);
    l_debug << L")create=" << pThis;
    return ret;
}

BINLINE HWireClient::HWireClient(void* app, const std::wstring& surl, int32_t , int32_t timeoutSeconds, PThreadPool tpool)
	: app(app)
	, url(surl)
	, timeoutSecondsClient(timeoutSeconds)
	, tpool(tpool)
	, isMyThreadPool(!tpool)
    , isDone(false)
{
    l_debug << L"ctor(";
	if (isMyThreadPool) {
        l_debug << L"create thread pool";
        this->tpool = BThreadPool::create(app, 10);
	}
    l_debug << L")ctor";
}

BINLINE void HWireClient::init() {
    l_debug << L"init(";
	try {
		httpClient = HttpClient_create(app);
		httpClient->init(url);

		requestsToCancel = PWireClient_RequestsToCancel(new HWireClient_RequestsToCancel());
	}
	catch (const BException& ex) {
		lastException = ex;
	}
    l_debug << L")init";
}

BINLINE HWireClient::~HWireClient() {
    l_debug << L"dtor(";
    if (isMyThreadPool && tpool) {
        tpool->done();
    }
	tpool.reset();
	requestsToCancel.reset();
	httpClient.reset();
    l_debug << L")dtor";
}

BINLINE void HWireClient::throwLastException() {
    l_debug<< L"throwLastException(";
    if (lastException) {
        l_debug << L"throw " << lastException.toString();
		throw lastException;
	}
    l_debug << L")throwLastException";
}

BINLINE HWireClient_AsyncResultAfterAllRequests::HWireClient_AsyncResultAfterAllRequests(byps_ptr<HWireClient> wire, PThreadPool tpool, int64_t messageId, PAsyncResult innerResult, size_t nbOfRequests)
    : wire(wire)
	, tpool(tpool)
	, messageId(messageId)
	, innerResult(innerResult)
	, nbOfRequests(nbOfRequests) {
    l_debug << L"ctor(), messageId=" << messageId << L", nbOfRequests=" << nbOfRequests;
}

BINLINE void HWireClient_AsyncResultAfterAllRequests::setAsyncResult(const BVariant& obj) {
    l_debug << L"setAsyncResult(";
	bool deleteThis = false;
	bool cancelMessage = false;

	{
		byps_unique_lock lock(mutex);

		if (obj.getType() == BTYPEID_BOOL) {
			// stream sent successfully
            l_debug << L"stream sent successfully";
		}
		else if (!result.isException()) {
             l_debug << L"set obj=" << obj.toString();
			 result = obj;
			 cancelMessage = obj.isException();
             l_debug << L"cancelMessage=" << cancelMessage;
		}

        nbOfRequests--;
        l_debug << L"nbOfRequests=" << nbOfRequests;

        if (nbOfRequests == 0) {
            l_debug << L"execute result in tpool";
			PRunnable r(new HWireClient_ExecResult(innerResult, result));
			tpool->execute(r);
			deleteThis = true;
		}

		if (cancelMessage) {
			byps_ptr<HWireClient> wire = this->wire.lock();
			if (wire) {
                l_debug << L"sendCancelMessage messageId=" << messageId;
				wire->sendCancelMessage(messageId);
			}
		}
	}

	if (deleteThis) {
        l_debug << L"delete this";
		delete this;
	}

    l_debug << L")setAsyncResult";
}

BINLINE void HWireClient::send(const PMessage& msg, PAsyncResult asyncResult) {
    l_debug << L"send()";
	internalSend(msg, asyncResult, timeoutSecondsClient);
}

BINLINE void HWireClient::sendR(const PMessage& msg, PAsyncResult asyncResult) {
    l_debug << L"sendR()";
	internalSend(msg, asyncResult, 600); //timeout kontrollieren, behandelt ServerR das richtig?
}

class BMessageRequest_AsyncResult : public BAsyncResult {
	PWireClient_RequestsToCancel requests;
    byps_atomic<PAsyncResult> innerResult;
	int64_t messageId;
    static BLogger log;

public:
	const intptr_t id;

	BMessageRequest_AsyncResult(PWireClient_RequestsToCancel requests, PAsyncResult innerResult, int64_t messageId) 
		: requests(requests)
		, innerResult(innerResult)
		, messageId(messageId)
		, id(reinterpret_cast<intptr_t>(this))
	{
        l_debug << L"ctor(messageId=" << messageId << L")";
	}

	virtual ~BMessageRequest_AsyncResult() {
        l_debug << L"dtor()";
	}

    void internalSetAsyncResult(const BVariant& var) {
        l_debug << L"internalSetAsyncResult(" << var.toString();
        PAsyncResult r = innerResult.exchange(NULL);
        if (r) {
            r->setAsyncResult(var);
        }
        l_debug << L")internalSetAsyncResult";
    }

	virtual void setAsyncResult(const BVariant& var) {
        l_debug << L"setAsyncResult(" << var.toString();
        if (var.isException()) {
            l_debug << L"set exception";
            internalSetAsyncResult(var);
		}
		else {
            l_debug << L"process bytes";
			PBytes respBytes;
			var.get(respBytes);

            l_debug << L"respBytes=" << respBytes;
            if (respBytes && respBytes->length) {

				try {
                    l_debug << L"read header";
                    BMessageHeader header;

                    bool nego = BNegotiate::isNegotiateMessage(respBytes);
                    l_debug << L"isNegotiate=" << nego;
                    if (nego) {
                        header.messageId = messageId;
					}
					else {
						BBuffer buf(BBinaryModel::MEDIUM(), respBytes, BBIG_ENDIAN);
						header.read(buf);
                        l_debug << L"messageId=" << header.messageId;
                    }
		
                    l_debug << L"init BMessage";
                    std::vector<PStreamRequest> streams;
					PMessage msg(new BMessage(header, respBytes, streams));

                    internalSetAsyncResult(BVariant(msg));

				} catch (const BException& ex) {
				
                    internalSetAsyncResult(BVariant(ex));
				}
			}
			else {
				BException ex = BException(EX_IOERROR, L"No bytes received.");
                internalSetAsyncResult(BVariant(ex));
			}
		}

        l_debug << L"remove from requests";
        requests->remove(id);

        l_debug << L"delete this";
		delete this;

        l_debug << L")setAsyncResult";
	}
};

class BPutRequest_AsyncResult : public BAsyncResult {
	PWireClient_RequestsToCancel requests;
	PAsyncResult innerResult;
    static BLogger log;

public:
	const intptr_t id;

	BPutRequest_AsyncResult(PWireClient_RequestsToCancel requests, PAsyncResult innerResult) 
		: requests(requests)
		, innerResult(innerResult)
		, id(reinterpret_cast<intptr_t>(this))
	{
        l_debug << L"ctor(id=" << id << L")";
	}

	virtual void setAsyncResult(const BVariant& var) {
        l_debug << L"setAsyncResult(" << var.toString();
		innerResult->setAsyncResult(var);
        l_debug << L"remove from requests";
		requests->remove(id);
        l_debug << L"delete this";
		delete this;
        l_debug << L")setAsyncResult";
	}
};


BINLINE void HWireClient::internalSend(const PMessage& msg, PAsyncResult asyncResult, int32_t timeoutSecondsRequest) {
    l_debug << L"internalSend(";

	// Convert the BMessage into single RequestToCancel objects.
	// One RequestToCancel is created for msg.buf.
	// For each stream in msg.streams further RequestToCancel objects are created.
		
	size_t nbOfRequests = 1 + msg->streams.size();
    l_debug << L"nbOfRequests=" << nbOfRequests;

    l_debug << L"create outerResult";
	PAsyncResult outerResult(new HWireClient_AsyncResultAfterAllRequests(shared_from_this(), tpool, msg->header.messageId, asyncResult, nbOfRequests));

	// Create request for message
    l_debug << L"create post request";
    PHttpPost messageRequest = httpClient->post(url);
	messageRequest->setTimeouts(timeoutSecondsClient, timeoutSecondsRequest);

    l_debug << L"create message result";
	BMessageRequest_AsyncResult* messageResult = new BMessageRequest_AsyncResult(requestsToCancel, outerResult, msg->header.messageId);

    bool succ = requestsToCancel->add(messageResult->id, messageRequest);
    l_debug << L"requests added";
    if (succ) {

        l_debug << L"send message buf";
		std::wstring contentType = msg->header.magic == BMAGIC_BINARY_STREAM ? L"application/byps" : L"application/json";
		messageRequest->send(msg->buf, contentType, messageResult);

		// Create requests for each stream.
		for (unsigned i = 0; i < msg->streams.size(); i++) {
			PStreamRequest stream = msg->streams[i];

			if (!stream) continue;
			if (!stream->streamId) continue;

			std::wstringstream ssurl;
			ssurl << url << L"?messageid=" << stream->messageId << L"&streamid=" << stream->streamId;

            l_debug << L"put stream url=" << url;
			PHttpPut streamRequest = httpClient->put(ssurl.str());
			streamRequest->setTimeouts(timeoutSecondsClient, timeoutSecondsRequest);

            l_debug << L"create stream result";
			BPutRequest_AsyncResult* streamResult = new BPutRequest_AsyncResult(requestsToCancel, outerResult);

            l_debug << L"add put request";
            succ = requestsToCancel->add(streamResult->id, streamRequest);

            if (succ) {
                l_debug << L"put stream";
				streamRequest->send(stream->strm, streamResult);
			}
		}
	}
	
	// Cannot add messageRequest, the connection was closed.
	else {
        l_debug << L"Already disconnected";
		messageRequest.reset();
		asyncResult->setAsyncResult(BVariant(BException(EX_CANCELLED, L"Already disconnected")));
	}

    l_debug << L")internalSend";
}

class MyContentStream : public BContentStream {
    std::wstring url;
    PWireClient_RequestsToCancel requestsToCancel;
	PContentStream innerStream;
    int64_t messageId;
    int64_t streamId;
    byps_weak_ptr<HHttpClient> httpClient;
    int32_t timeoutSeconds;
    static BLogger log;

public:
	const intptr_t id;

    MyContentStream(const std::wstring& url,
                    PWireClient_RequestsToCancel requestsToCancel,
                    int64_t messageId, int64_t streamId,
                    PHttpClient httpClient,
                    int32_t timeoutSeconds)
        : url(url)
        , requestsToCancel(requestsToCancel)
        , messageId(messageId)
        , streamId(streamId)
        , httpClient(httpClient)
        , timeoutSeconds(timeoutSeconds)
		, id(reinterpret_cast<intptr_t>(this))
	{
        l_debug << L"ctor(messageId=" << messageId << L", streamId=" << streamId << L")";
	}

    void ensureOpen() const {

		if (innerStream) return;
        l_debug << L"ensureOpen(";

        PHttpClient httpClient = this->httpClient.lock();
        if (httpClient) {
            MyContentStream* pThis = const_cast<MyContentStream*>(this);

            std::wstringstream ssurl;
            ssurl << url << L"?messageid=" << messageId << L"&streamid=" << streamId;
            l_debug << L"get url=" << ssurl.str();

            PHttpGet streamRequest = httpClient->get(ssurl.str());
            streamRequest->setTimeouts(timeoutSeconds, timeoutSeconds);

            bool succ = requestsToCancel->add(id, streamRequest);
            l_debug << L"add to requests =" << succ;
            if (!succ) {
                throw BException(EX_CANCELLED, L"Already disconnected");
            }

            l_debug << L"send stream request";
            pThis->innerStream = streamRequest->send();
        }
        else {
            l_debug << L"HTTP client already released";
            throw BException(EX_CANCELLED, L"HTTP client already released.");
        }
        l_debug << L")ensureOpen";
	}

	virtual ~MyContentStream() {
        l_debug << L"dtor(";
        requestsToCancel->remove(id);
        l_debug << L")dtor";
	}

	virtual const std::wstring& getContentType() const {
        ensureOpen();
        const std::wstring& ret = innerStream->getContentType();
        l_debug << L"getContentType()="<<ret;
        return ret;
	}

	virtual int64_t getContentLength() const {
        ensureOpen();
        int64_t ret = innerStream->getContentLength();
        l_debug << L"getContentLength()=" << ret;
        return ret;
	}

	virtual int32_t read(char* buf, int32_t offs, int32_t len) {
        ensureOpen();
        l_debug << L"read(buf=" << (void*)buf << L", offs=" << offs << L", len=" << len;
        int32_t ret = innerStream->read(buf, offs, len);
        l_debug << L")read=" << ret;
        return ret;
	}
	
};

BINLINE PContentStream HWireClient::getStream(int64_t messageId, int64_t streamId) {
    l_debug << L"getStream(messageId=" << messageId << L", streamId=" << streamId;
    MyContentStream* stream = new MyContentStream(url, requestsToCancel, messageId, streamId, httpClient, timeoutSecondsClient);
    PContentStream ret = PContentStream(stream);
    l_debug << L")getStream=" << (void*)stream;
    return ret;
}

BINLINE void HWireClient::done() {
    l_debug << L"done(";

	// already done?
	bool expectedDone = false;
	if (isDone.compare_exchange_strong(expectedDone, true)) {

        l_debug << L"cancel requests";

		BSyncResultT<bool > syncResult;
		internalCancelAllRequests(MESSAGEID_DISCONNECT, &syncResult);

		try {
			syncResult.getResult();
		}
		catch (...) { 
			// maybe connect to server failed
		}

		if (isMyThreadPool && tpool) {
            l_debug << L"tpool->done";
			tpool->done();
		}

		tpool.reset();

        l_debug << L"httpClient->done";
        httpClient->done();
	}

    l_debug << L")done";
}

BINLINE void HWireClient::cancelAllRequests() {
    l_debug << L"cancelAllRequests(";
	BSyncResultT<bool > syncResult;
	internalCancelAllRequests(MESSAGEID_CANCEL_ALL_REQUESTS, &syncResult);
	syncResult.getResult();
    l_debug << L")cancelAllRequests";
}

BINLINE void HWireClient::sendCancelMessage(int64_t cancelMessageId) {
    l_debug << L"sendCancelMessage(" << cancelMessageId;
	std::wstringstream ss;
	ss << url << L"?cancel=1&messageid=" << cancelMessageId;
	
	PHttpGet cancelRequest = httpClient->get(ss.str());
	cancelRequest->setTimeouts(timeoutSecondsClient, timeoutSecondsClient);
	PContentStream strm = cancelRequest->send();
	strm.reset();

    l_debug << L")sendCancelMessage";
}

BINLINE void HWireClient::internalCancelAllRequests(int64_t cancelMessageId, PAsyncResult asyncResult) {
    l_debug << L"internalCancelAllRequests(cancelMessageId=" << cancelMessageId;

	if (cancelMessageId) {
		sendCancelMessage(cancelMessageId);
	}

	requestsToCancel->cancel();

	if (asyncResult) {
        l_debug << L"setAsyncResult";
        asyncResult->setAsyncResult(BVariant(true));
	}

	// Wait a moment until all requests have been finished.
	// I could manage this with a lot of condition variables,
	// but it's not worth the effort. 
	// If the reqeuests are not finished when the function returns,
	// we leek some memory.
	std::chrono::milliseconds ms( 100 );
    std::this_thread::sleep_for( ms );

    l_debug << L")internalCancelAllRequests";
}

HWireClient_ExecResult::HWireClient_ExecResult(PAsyncResult asyncResult, BVariant var) 
	: asyncResult(asyncResult)
	, var(var) {
    l_debug << L"ctor()";
}

void HWireClient_ExecResult::run() {
    l_debug << L"run(";
	asyncResult->setAsyncResult(var);
    l_debug << L")run";
}

void HWireClient_TestAdapter::killClientConnections() {
    l_debug << L"killClientConnections(";
	wire->internalCancelAllRequests(0, PAsyncResult());
    l_debug << L")killClientConnections";
}


BLogger HWireClient::log("HWireClient");
BLogger HWireClient_AsyncResultAfterAllRequests::log("HWireClient_AsyncResultAfterAllRequests");
BLogger HWireClient_RequestsToCancel::log("HWireClient_RequestsToCancel");
BLogger BMessageRequest_AsyncResult::log("BMessageRequest_AsyncResult");
BLogger MyContentStream::log("MyContentStream");
BLogger HWireClient_TestAdapter::log("HWireClient_TestAdapter");
BLogger HWireClient_ExecResult::log("HWireClient_ExecResult");
BLogger BPutRequest_AsyncResult::log("BPutRequest_AsyncResult");
}}}}

#endif

