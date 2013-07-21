#ifndef HWIRECLIENT_HPP_
#define HWIRECLIENT_HPP_

#include "Byps.h"
#include "HWireClient.h"
#include "HWireClientI.h"
#include <strsafe.h>

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
	bool succ = !isCanceled;
	if (succ) {
		map[id] = r;
	}
	return succ;
}

BINLINE void HWireClient_RequestsToCancel::addCancelMessage(intptr_t id, PHttpRequest r) {
    byps_unique_lock lock(mutex);
	map[id] = r;
}

BINLINE void HWireClient_RequestsToCancel::remove(intptr_t id) {
    byps_unique_lock lock(mutex);
	std::map<intptr_t, PHttpRequest>::iterator it = map.find(id);
	if (it != map.end()) {
		(*it).second->close();
		map.erase(it);
	}
}

BINLINE void HWireClient_RequestsToCancel::cancel() {
    byps_unique_lock lock(mutex);
    for (std::map<intptr_t, PHttpRequest>::iterator it = map.begin(); it != map.end(); it++) {
		(*it).second->close();
	}
	isCanceled = true;
}

BINLINE HWireClient_RequestsToCancel::~HWireClient_RequestsToCancel() {
	map.clear();
}


BINLINE PWire HWireClient::create(const std::wstring& url, int32_t flags, int32_t timeoutSeconds, PThreadPool tpool) {
	HWireClient* pThis = new HWireClient(url, flags, timeoutSeconds, tpool);
	pThis->init();
	return PWire(pThis);
}

BINLINE HWireClient::HWireClient(const std::wstring& surl, int32_t , int32_t timeoutSeconds, PThreadPool tpool)
	: url(surl)
	, timeoutSecondsClient(timeoutSeconds)
	, tpool(tpool)
	, isMyThreadPool(!tpool)
{
	if (isMyThreadPool) {
		this->tpool = BThreadPool::create(10);
	}
	
	
}

BINLINE void HWireClient::init() {

	try {
		httpClient = HttpClient_create();
		httpClient->init(url);

		requestsToCancel = PWireClient_RequestsToCancel(new HWireClient_RequestsToCancel());
	}
	catch (const BException& ex) {
		lastException = ex;
	}

}

BINLINE HWireClient::~HWireClient() {
	tpool.reset();
	requestsToCancel.reset();
	httpClient.reset();
}

BINLINE void HWireClient::throwLastException() {
	if (lastException.getCode()) {
		throw lastException;
	}
}

BINLINE HWireClient_AsyncResultAfterAllRequests::HWireClient_AsyncResultAfterAllRequests(PThreadPool tpool, PAsyncResult innerResult, size_t nbOfRequests)
    : tpool(tpool)
	, innerResult(innerResult)
	, nbOfRequests(nbOfRequests) {
}

BINLINE void HWireClient_AsyncResultAfterAllRequests::setAsyncResult(const BVariant& obj) {
	
	bool deleteThis = false;

	{
		byps_unique_lock lock(mutex);

		if (obj.getType() == BTYPEID_BOOL) {
			// stream sent successfully
		}
		else if (!result.isException()) {
			 result = obj;
		}

		if (--nbOfRequests == 0) {
			PRunnable r(new HWireClient_ExecResult(innerResult, result));
			tpool->execute(r);
			deleteThis = true;
		}
	}

	if (deleteThis) {
		delete this;
	}
}

BINLINE void HWireClient::send(const PMessage& msg, PAsyncResult asyncResult) {
	internalSend(msg, asyncResult, timeoutSecondsClient);
}

BINLINE void HWireClient::sendR(const PMessage& msg, PAsyncResult asyncResult) {
	internalSend(msg, asyncResult, 600); //timeout kontrollieren, behandelt ServerR das richtig?
}

class BMessageRequest_AsyncResult : public BAsyncResult {
	PWireClient_RequestsToCancel requests;
	PAsyncResult innerResult;
	int64_t messageId;

public:
	const intptr_t id;

	BMessageRequest_AsyncResult(PWireClient_RequestsToCancel requests, PAsyncResult innerResult, int64_t messageId) 
		: requests(requests)
		, innerResult(innerResult)
		, messageId(messageId)
		, id(reinterpret_cast<intptr_t>(this))
	{
	}

	virtual ~BMessageRequest_AsyncResult() {
	}

	virtual void setAsyncResult(const BVariant& var) {
		
		if (var.isException()) {
			innerResult->setAsyncResult(var);
		}
		else {
			PBytes respBytes;
			var.get(respBytes);

			if (respBytes) {
				BMessageHeader header;
				try {
					if (BNegotiate::isNegotiateMessage(respBytes)) {
						header.messageId = messageId;
					}
					else {
						BBuffer buf(BBinaryModel::MEDIUM(), respBytes, BBIG_ENDIAN);
						header.read(buf);
					}
		
					std::vector<PStreamRequest> streams;
					PMessage msg(new BMessage(header, respBytes, streams));

					innerResult->setAsyncResult(BVariant(msg));
					innerResult = NULL;

				} catch (const BException& ex) {
				
					innerResult->setAsyncResult(BVariant(ex));
				}
			}
			else {
				BException ex = BException(EX_IOERROR, L"No bytes received.");
				innerResult->setAsyncResult(BVariant(ex));
			}
		}

		requests->remove(id);
		delete this;
	}
};

class BPutRequest_AsyncResult : public BAsyncResult {
	PWireClient_RequestsToCancel requests;
	PAsyncResult innerResult;

public:
	const intptr_t id;

	BPutRequest_AsyncResult(PWireClient_RequestsToCancel requests, PAsyncResult innerResult) 
		: requests(requests)
		, innerResult(innerResult)
		, id(reinterpret_cast<intptr_t>(this))
	{
	}

	virtual void setAsyncResult(const BVariant& var) {
		innerResult->setAsyncResult(var);
		requests->remove(id);
		delete this;
	}
};


BINLINE void HWireClient::internalSend(const PMessage& msg, PAsyncResult asyncResult, int32_t timeoutSecondsRequest) {
    
	// Convert the BMessage into single RequestToCancel objects.
	// One RequestToCancel is created for msg.buf.
	// For each stream in msg.streams further RequestToCancel objects are created.
		
	size_t nbOfRequests = 1 + msg->streams.size();

	PAsyncResult outerResult(new HWireClient_AsyncResultAfterAllRequests(tpool, asyncResult, nbOfRequests));

	// Create request for message
    PHttpPost messageRequest = httpClient->post(url);
	messageRequest->setTimeouts(timeoutSecondsClient, timeoutSecondsRequest);

	BMessageRequest_AsyncResult* messageResult = new BMessageRequest_AsyncResult(requestsToCancel, outerResult, msg->header.messageId);

	if (requestsToCancel->add(messageResult->id, messageRequest)) {

		std::wstring contentType = msg->header.magic == BMAGIC_BINARY_STREAM ? L"application/byps" : L"application/json";
		messageRequest->send(msg->buf, contentType, messageResult);

		// Create requests for each stream.
		for (unsigned i = 0; i < msg->streams.size(); i++) {
			PStreamRequest stream = msg->streams[i];

			if (!stream) continue;
			if (!stream->streamId) continue;

			std::wstringstream ssurl;
			ssurl << url << L"?messageid=" << stream->messageId << L"&streamid=" << stream->streamId;

			PHttpPut streamRequest = httpClient->put(ssurl.str());
			streamRequest->setTimeouts(timeoutSecondsClient, timeoutSecondsRequest);

			BPutRequest_AsyncResult* streamResult = new BPutRequest_AsyncResult(requestsToCancel, outerResult);
			if (requestsToCancel->add(streamResult->id, streamRequest)) {
				streamRequest->send(stream->strm, streamResult);
			}
		}
	}
	
	// Cannot add messageRequest, the connection was closed.
	else {
		messageRequest.reset();
		asyncResult->setAsyncResult(BVariant(BException(EX_CANCELED, L"Already disconnected")));
	}

}

class MyContentStream : public BContentStream {
	PWireClient_RequestsToCancel requests;
	PContentStream innerStream;

public:
	const intptr_t id;

	MyContentStream(PWireClient_RequestsToCancel requests) 
		: requests(requests)
		, id(reinterpret_cast<intptr_t>(this))
	{
	}

	void setInnerStream(PContentStream innerStream) {
		this->innerStream = innerStream;
	}

	virtual ~MyContentStream() {
		requests->remove(id);
	}

	virtual const std::wstring& getContentType() const {
		return innerStream->getContentType();
	}

	virtual int64_t getContentLength() const {
		return innerStream->getContentLength();
	}

	virtual int32_t read(char* buf, int32_t offs, int32_t len) {
		return innerStream->read(buf, offs, len);
	}
	
};

BINLINE PContentStream HWireClient::getStream(int64_t messageId, int64_t streamId) {

	std::wstringstream ssurl;
	ssurl << url << L"?messageid=" << messageId << L"&streamid=" << streamId;

	PHttpGet streamRequest = httpClient->get(ssurl.str());

	MyContentStream* stream = new MyContentStream(requestsToCancel);
	if (!requestsToCancel->add(stream->id, streamRequest)) {
		throw BException(EX_CANCELED, L"Already disconnected");
	}

	stream->setInnerStream(streamRequest->send());

	PContentStream ret(stream);
	return ret;
}

BINLINE void HWireClient::done() {
	
	// already done?
	bool expectedDone = false;
	if (isDone.compare_exchange_strong(expectedDone, true)) {

		BSyncResultT<bool > syncResult;

		internalCancelAllRequests(MESSAGEID_DISCONNECT, &syncResult);

		try {
			syncResult.getResult();
		}
		catch (...) { 
			// maybe connect to server failed
		}

		if (isMyThreadPool && tpool) {
			tpool->done();
		}

		tpool.reset();
	}

}

BINLINE void HWireClient::cancelAllRequests() {
	BSyncResultT<bool > syncResult;
	internalCancelAllRequests(MESSAGEID_CANCEL_ALL_REQUESTS, &syncResult);
	syncResult.getResult();
}

BINLINE void HWireClient::internalCancelAllRequests(int64_t cancelMessageId, PAsyncResult asyncResult) {
	
	requestsToCancel->cancel();

	if (cancelMessageId) {

		std::wstringstream ss;
		ss << url << L"?cancel=1&messageid=" << cancelMessageId;
	
		PHttpGet cancelRequest = httpClient->get(ss.str());
		cancelRequest->setTimeouts(timeoutSecondsClient, timeoutSecondsClient);
		PContentStream strm = cancelRequest->send();
		strm.reset();
	}

	if (asyncResult) {
		asyncResult->setAsyncResult(BVariant(true));
	}
}

HWireClient_ExecResult::HWireClient_ExecResult(PAsyncResult asyncResult, BVariant var) 
	: asyncResult(asyncResult)
	, var(var) {
}

void HWireClient_ExecResult::run() {
	asyncResult->setAsyncResult(var);
}

void HWireClient_TestAdapter::killClientConnections() {
	wire->internalCancelAllRequests(0, PAsyncResult());
}

}}}}

#endif

