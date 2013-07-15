#ifndef HWIRECLIENTI_H_
#define HWIRECLIENTI_H_


#include "HWireClient.h"

namespace com { namespace wilutions { namespace byps { namespace http {

using namespace com::wilutions::byps;

class HWireClient_AsyncResultAfterAllRequests;
class HWireClient_RequestToCancel;
class HWireClient_RequestsToCancel;
typedef byps_ptr<HWireClient_RequestToCancel> PWireClient_RequestToCancel;
typedef byps_ptr<HWireClient_RequestsToCancel> PWireClient_RequestsToCancel;

class HWireClient_RequestsToCancel {
public:
	HWireClient_RequestsToCancel(HINTERNET hSession, HINTERNET hConnection);

	virtual ~HWireClient_RequestsToCancel();
    bool add(intptr_t id, PWireClient_RequestToCancel r);
    void addCancelMessage(intptr_t id, PWireClient_RequestToCancel r);
    void remove(intptr_t id);
	void cancel();

	HINTERNET getConnection();

private:
	HINTERNET hSession;
	HINTERNET hConnection;

	bool isCanceled;
    byps_mutex mutex;
    std::map<intptr_t, PWireClient_RequestToCancel> map;
};

class HWireClient_RequestToCancel {
public:
	const intptr_t id;

    HWireClient_RequestToCancel(
		const std::wstring& urlPath,
		DWORD urlFlags,
		DWORD timeoutMillisClient, DWORD timeoutMillisRequest,
		PWireClient_RequestsToCancel requestsToCancel,
		PAsyncResult asyncResult);

	virtual ~HWireClient_RequestToCancel();

    virtual void send() = 0;

	virtual void cancel();

	virtual void close();
	
	bool isCanceled();

    PWireClient_RequestsToCancel requestsToCancel;
	PAsyncResult asyncResult;

protected:
	std::wstring urlPath;
	DWORD urlFlags;
	DWORD timeoutMillisClient;
	DWORD timeoutMillisRequest;

	volatile HINTERNET hRequest;

	std::wstring contentType;
	int64_t contentLength;
	DWORD statusCode;

	void parseHeaders(LPWSTR lpszResponseHeaders);

	static void CALLBACK winhttp_status_callback(
		IN HINTERNET hInternet,
		IN DWORD_PTR dwContext,
		IN DWORD dwInternetStatus,
		IN LPVOID lpvStatusInformation OPTIONAL,
		IN DWORD dwStatusInformationLength);

	byps_mutex mutex;
	byps_condition_variable waitForReadComplete;
	byps_condition_variable waitForWriteComplete;
	byps_condition_variable waitForHeadersAvailable;

	virtual void getRequestHeaders(std::wstring& headers, DWORD& totalLength);
	virtual void onSendComplete();
	virtual void onHeadersAvailable();
	virtual void onDataAvailable(DWORD length);
	virtual void onReadComplete(BYTE* data, DWORD length);
	virtual void onWriteComplete(DWORD length);
	virtual void onRequestError(WINHTTP_ASYNC_RESULT* asyncInfo);
	virtual void readData();
	virtual void writeDataOrReceiveResponse();

	void openRequest(LPCWSTR method);
	void sendRequest();

	void get();
	void post(PBytes bytes);
	void put(PContentStream stream);

	virtual void finishOnError(const BException& ex);
	virtual void finishOnOK();
};

class HWireClient_SendMessage : public HWireClient_RequestToCancel {
public:
    HWireClient_SendMessage(
		const std::wstring& urlPath,
		DWORD urlFlags,
		DWORD sendTimeout, DWORD receiveTimeout,
		PWireClient_RequestsToCancel requestsToCancel,
		PAsyncResult asyncResult,
        int64_t messageId, 
		PBytes bytes);
	virtual ~HWireClient_SendMessage() {}

	virtual void send();

protected:
	const int64_t messageId;
	const PBytes bytes;

	size_t sendIdx;

	size_t respIdx;
	PBytes respBytes;

	virtual void onReadComplete(BYTE* data, DWORD length);
	virtual void onWriteComplete(DWORD length);

	virtual void writeDataOrReceiveResponse();
	void readData();
	virtual void finishOnOK();
};

class HWireClient_PutStream : public HWireClient_RequestToCancel {
public:
    HWireClient_PutStream(
		const std::wstring& urlPath,
		DWORD urlFlags,
		DWORD sendTimeout, DWORD receiveTimeout,
		PWireClient_RequestsToCancel requestsToCancel,
		PAsyncResult asyncResult,
		PContentStream stream);
	virtual ~HWireClient_PutStream() {}

	virtual void send();

protected:
	const PContentStream stream;

	int32_t bufferPos, bufferLimit;
	char buffer[0xFFF0]; // writeDataOrReceiveResponse assumes that buffer size is smaller or equal to 0xFFFF

	enum EChunkState { NotChunked, Chunked, FinishChunks } m_eChunkState;

	void beginChunk(int32_t chunkLength);
	void writeChunk();
	void endChunk();

	virtual void onReadComplete(BYTE* data, DWORD length);
	virtual void onWriteComplete(DWORD length);

	virtual void writeDataOrReceiveResponse();

	virtual void readData();
	virtual void finishOnOK();
};

class HWireClient_GetStream;
typedef byps_ptr<HWireClient_GetStream> PWireClient_GetStream;

class HWireClient_GetStream : public HWireClient_RequestToCancel {
public:

	friend class HWireClient;

	virtual void send();

	static PWireClient_GetStream create(
		const std::wstring& urlPath,
		DWORD urlFlags,
		DWORD sendTimeout, DWORD receiveTimeout,
		PWireClient_RequestsToCancel requestsToCancel);

	virtual ~HWireClient_GetStream();

protected:
    HWireClient_GetStream(
		const std::wstring& urlPath,
		DWORD urlFlags,
		DWORD sendTimeout, DWORD receiveTimeout,
		PWireClient_RequestsToCancel requestsToCancel);
	
	friend class MyContentStream;

	class MyContentStream : public BContentStream {
		PWireClient_GetStream pThis;
	public:
		MyContentStream(PWireClient_GetStream pThis) : pThis(pThis) {};
		virtual ~MyContentStream() {}
		virtual const std::wstring& getContentType() const;
		virtual int64_t getContentLength() const;
		virtual int32_t read(char* buf, int32_t offs, int32_t len);
		void ensureOpen() const;
	};
	PContentStream stream;

	friend class MyAsyncResult;

	class MyAsyncResult : public BAsyncResult {
		PWireClient_GetStream pThis;
	public:
		MyAsyncResult(PWireClient_GetStream pThis) : pThis(pThis) {
		};
		virtual ~MyAsyncResult() {}
		virtual void setAsyncResult(const BVariant& obj) { 
			pThis->ex = obj.getException(); 
			delete this;
		}
	};

	int32_t bufferPos, bufferLimit;
	char buffer[8 * 1024]; // Buffer size should be 8k or larger: see MSDN documentation of WinHttpReadData
	BException ex;

	virtual void onReadComplete(BYTE* data, DWORD length);
	virtual void onWriteComplete(DWORD length);

	virtual void readData();
	virtual void finishOnOK();
	virtual void finishOnError(const BException& ex);
};


const int64_t MESSAGEID_CANCEL_ALL_REQUESTS = -1;
const int64_t MESSAGEID_DISCONNECT = -2;

class HWireClient_CancelMessage : public HWireClient_RequestToCancel {
public:
    HWireClient_CancelMessage(
		const std::wstring& urlPath,
		DWORD urlFlags,
		DWORD sendTimeout, DWORD receiveTimeout,
		PWireClient_RequestsToCancel requestsToCancel,
		PAsyncResult asyncResult,
        int64_t cancelMessageId);
	virtual ~HWireClient_CancelMessage();

	virtual void send();

protected:
	const int64_t cancelMessageId;

	char buffer[1*1000];

	virtual void readData();
	virtual void onReadComplete(BYTE* data, DWORD length);
	virtual void onWriteComplete(DWORD length);
	virtual void finishOnOK();
};


class HWireClient_AsyncResultAfterAllRequests : public BAsyncResult {
public:
    HWireClient_AsyncResultAfterAllRequests(PThreadPool tpool, PAsyncResult innerResult, size_t nbOfRequests);
	virtual ~HWireClient_AsyncResultAfterAllRequests() {}
    virtual void setAsyncResult(const BVariant& obj);

private:
	PThreadPool tpool;
    PAsyncResult innerResult;
    size_t nbOfRequests;
    byps_mutex mutex;
    BVariant result;
};

class HWireClient_AsyncResultSendMessage : public BAsyncResult {
public:
    HWireClient_AsyncResultSendMessage(PThreadPool tpool, PWireClient_RequestToCancel messageRequest);
	virtual ~HWireClient_AsyncResultSendMessage();
    virtual void setAsyncResult(const BVariant& obj);

private:
	PThreadPool tpool;
	PWireClient_RequestToCancel messageRequest;
};

class HWireClient_ExecResult : public BRunnable {
	PAsyncResult asyncResult;
	BVariant var;
public:
	HWireClient_ExecResult(PAsyncResult asyncResult, BVariant var);
	virtual void run();
};

class HWireClient_TestAdapter : public BTestAdapter {
	byps_ptr<HWireClient> wire;
public:

	HWireClient_TestAdapter(byps_ptr<HWireClient> wire) : wire(wire) {
	}

	virtual ~HWireClient_TestAdapter() {}

	virtual void killClientConnections();

};

}}}}

#endif