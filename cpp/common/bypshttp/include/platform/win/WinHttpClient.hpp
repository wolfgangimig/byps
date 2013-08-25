#ifndef WINHTTPCLIENT_HPP_
#define WINHTTPCLIENT_HPP_

#include "WinHttpClient.h"
#include <Windows.h>
#include <Winhttp.h>
#include "HException.hpp"
#include <strsafe.h>

#undef min

#pragma comment( lib, "winhttp.lib" )

namespace com { namespace wilutions { namespace byps { namespace http { namespace winhttp {

using namespace com::wilutions::byps;
using namespace com::wilutions::byps::http;

class WinHttpRequest;
typedef byps_ptr<WinHttpRequest> PWinHttpRequest;

class WinHttpGet;
typedef byps_ptr<WinHttpGet> PWinHttpGet;

class WinHttpPost;
typedef byps_ptr<WinHttpPost> PWinHttpPost;

class WinHttpPut;
typedef byps_ptr<WinHttpPut> PWinHttpPut;


class WinHttpRequest : public virtual HHttpRequest, public byps_enable_shared_from_this<WinHttpRequest> {
protected:
	HINTERNET hRequest;
	byps_atomic<bool> handleClosed;

	std::wstring contentType;
	int64_t contentLength;
	DWORD statusCode;
	PAsyncResult asyncResult;
	std::wstring url; 

	byps_mutex mutex;
	byps_condition_variable waitForHeadersAvailable;

	PWinHttpRequest holdReferenceForWinHTTP;

	//static LONG openRequests;

public:

	WinHttpRequest(HINTERNET hRequest, const std::wstring& url) 
		: hRequest(hRequest)
		, contentLength(0)
		, statusCode(0)
		, url(url)
	{
		//InterlockedIncrement(&openRequests);
	}

	~WinHttpRequest() {
		close();
	}

	virtual void close() {
		bool expectedClosed = false;
		if (handleClosed.compare_exchange_strong(expectedClosed, true)) {
			WinHttpCloseHandle(hRequest);
			//assert(InterlockedDecrement(&openRequests) >= 0);
		}
	}

	virtual void finishOnError(const BException& ex) throw() {
		if (asyncResult) {
			asyncResult->setAsyncResult(BVariant(ex));
			asyncResult = NULL;
		}
	}

	virtual void finishOnOK() = 0;

	virtual void readData() = 0;

	virtual void writeDataOrReceiveResponse() = 0;

	virtual void setTimeouts(int32_t connectTimeoutSeconds, int32_t sendrecvTimeoutSeconds) {
		WinHttpSetTimeouts(hRequest, 
			connectTimeoutSeconds * 1000, 
			connectTimeoutSeconds * 1000, 
			sendrecvTimeoutSeconds * 1000, 
			sendrecvTimeoutSeconds * 1000);
	}

	void getRequestHeaders(std::wstring& headers, DWORD& totalLength) {

		std::wstringstream wssHeaders;

		if (contentLength >= 0x100000000LL) {
			// Starting in Windows Vista and Windows Server 2008, 
			// WinHttp supports uploading files up to the size of a LARGE_INTEGER ...
			// http://msdn.microsoft.com/en-us/library/aa384110(v=vs.85).aspx
			OSVERSIONINFOEXW verInfo={0};
			verInfo.dwOSVersionInfoSize = sizeof(verInfo);
			::GetVersionExW((OSVERSIONINFOW*)&verInfo);

			if (verInfo.dwMajorVersion >= 6) {
				wssHeaders << L"Content-Length: " << contentLength << "\r\n";
				totalLength = WINHTTP_IGNORE_REQUEST_TOTAL_LENGTH;
			}
			else {
				// Cannot send requests > 2GB on OS older than Vista
				throw HException(L"WinHttpSendRequest", ERROR_INVALID_PARAMETER);
			}
		}
		else if (contentLength > 0) {
			totalLength = (DWORD)contentLength;
		}
		else if (contentLength < 0) {
			// Starting in Windows Vista and Windows Server 2008, WinHttp enables applications to 
			// perform chunked transfer encoding on data sent to the server. 
			OSVERSIONINFOEXW verInfo={0};
			verInfo.dwOSVersionInfoSize = sizeof(verInfo);
			::GetVersionExW((OSVERSIONINFOW*)&verInfo);

			if (verInfo.dwMajorVersion >= 6) {

				// Example: http://senthilvels.blogspot.de/2011/08/uploading-chunk-data-to-server-using.html

				wssHeaders << L"Transfer-Encoding: chunked\r\n";
				totalLength = WINHTTP_IGNORE_REQUEST_TOTAL_LENGTH;

			}
			else {
				// Cannot send chunked data
				throw HException(L"WinHttpSendRequest", ERROR_INVALID_PARAMETER);
			}
		}

		if (contentLength != 0) {
			if (contentType.size()) {
				wssHeaders << L"Content-Type: " << contentType << L"\r\n";
			}
		}
		else {
			totalLength = 0;
		}

		headers = wssHeaders.str();
	}

	void sendRequest() {

		std::wstring headers;
		DWORD totalLength = 0;
		getRequestHeaders(headers, totalLength);

		holdReferenceForWinHTTP = shared_from_this();

		BOOL succ = WinHttpSendRequest(hRequest, 
						headers.size() ? headers.c_str() : WINHTTP_NO_ADDITIONAL_HEADERS, 
						(DWORD)headers.size(), 
						NULL, 0,
						(DWORD)totalLength, 
						(DWORD_PTR) this);

		if( !succ ) {
			if (asyncResult) {
				DWORD err = GetLastError();
				finishOnError(HException(L"WinHttpSendRequest", err));
			}
		}
	}

	virtual void onHandleClosing(HINTERNET handle) throw() {
		if (hRequest == handle) {
			holdReferenceForWinHTTP.reset();
		}
	}

	virtual void onSendComplete() throw() {
		writeDataOrReceiveResponse();
	}
	
	virtual void onHeadersAvailable() throw() {
		LPWSTR lpszResponseHeaders = NULL;
		DWORD dwResponseHeadersSize = 0;

		BOOL succ = WinHttpQueryHeaders(hRequest, 
								 WINHTTP_QUERY_RAW_HEADERS_CRLF,
								 WINHTTP_HEADER_NAME_BY_INDEX, NULL, 
								 &dwResponseHeadersSize, 
								 WINHTTP_NO_HEADER_INDEX );

		if (!succ )  {

			DWORD err = GetLastError();
			if (err == ERROR_INSUFFICIENT_BUFFER){
        
				err = 0;
				lpszResponseHeaders = new WCHAR[dwResponseHeadersSize];

				succ = WinHttpQueryHeaders(hRequest, 
									WINHTTP_QUERY_RAW_HEADERS_CRLF,
									WINHTTP_HEADER_NAME_BY_INDEX, 
									lpszResponseHeaders, 
									&dwResponseHeadersSize, 
									WINHTTP_NO_HEADER_INDEX );
			}

		}

		if (!succ) {
			DWORD err = GetLastError();
			finishOnError(HException(L"WinHttpQueryHeaders", err));
		}
		else {

			parseHeaders(lpszResponseHeaders);

			if (statusCode != HTTP_STATUS_OK) {
				finishOnError(HException(statusCode));
			}
			else {
				readData();
			}
		}

		if (lpszResponseHeaders) {
			delete[] lpszResponseHeaders;
		}
	}

	virtual void onDataAvailable(DWORD length) throw() {
	}

	virtual void onReadComplete(BYTE* data, DWORD length) throw() {
	}

	virtual void onWriteComplete(DWORD length) throw() {
		writeDataOrReceiveResponse();
	}

	virtual void onRequestError(WINHTTP_ASYNC_RESULT* asyncInfo) throw() {
		LPCWSTR fnctName = L"";

		switch (asyncInfo->dwResult) {
		case API_RECEIVE_RESPONSE:		fnctName = L"WinHttpReceiveResponse"; break;
		case API_QUERY_DATA_AVAILABLE:	fnctName = L"WinHttpQueryDataAvailable"; break;
		case API_READ_DATA:				fnctName = L"WinHttpReadData"; break;
		case API_WRITE_DATA:			fnctName = L"WinHttpWriteData"; break;
		case API_SEND_REQUEST:			fnctName = L"WinHttpSendRequest"; break;
		};

		HException ex(fnctName, asyncInfo->dwError);
		finishOnError(ex);

	}

	void parseHeaders(LPWSTR lpszResponseHeaders) throw() {
		byps_unique_lock lock(mutex);

		if (lpszResponseHeaders) {

			//HTTP/1.1 200 OK
			//Server: Apache/1.3.29 (Unix) PHP/4.3.4
			//Content-Length: 1234
			//Content-Language: de 
			//Connection: close
			//Content-Type: text/html
	
			LPWSTR ctxt = NULL;
			LPWSTR t = wcstok_s(lpszResponseHeaders, L"\r\n", &ctxt);

			while (t != NULL) {

				if (statusCode == 0) {
					LPWSTR p = wcschr(t, L' ');
					if (p != NULL) {
						statusCode = _wtoi(p);
					}
					else {
						statusCode = HTTP_STATUS_SERVER_ERROR;
					}
				}
				else {
					LPWSTR p = wcschr(t, L':');
					if (p != NULL) {
						*p = 0; p++;
						if (_wcsicmp(L"Content-Length", t) == 0) {
							contentLength = _wtoi64(p);
						}
						else if (_wcsicmp(L"Content-Type", t) == 0) {
							while (*p == ' ') p++;
							contentType = p; 
						}
					}
				}

				t = wcstok_s(NULL, L"\r\n", &ctxt);
			}
		}
		else {
			statusCode = HTTP_STATUS_SERVER_ERROR;
		}

		waitForHeadersAvailable.notify_all();
	}
};

class GetRequestContentStream : public BContentStream {
	PWinHttpGet request;
public:
	GetRequestContentStream(PWinHttpGet request) : request(request) {
	};
	virtual ~GetRequestContentStream();
	virtual const std::wstring& getContentType() const;
	virtual int64_t getContentLength() const;
	virtual int32_t read(char* buf, int32_t offs, int32_t len);
};


class WinHttpGet : public HHttpGet, public virtual WinHttpRequest {

	int32_t bufferPos, bufferLimit;
	char buffer[8 * 1024]; // Buffer size should be 8k or larger: see MSDN documentation of WinHttpReadData
	BException ex;
	bool sendComplete;

	byps_condition_variable waitForReadComplete;
	byps_condition_variable waitForWriteComplete;
	byps_condition_variable waitForSendComplete;

	friend class GetRequestContentStream;

public:
	WinHttpGet(HINTERNET hRequest, const std::wstring& url) 
		: WinHttpRequest(hRequest, url)
		, bufferPos(sizeof(buffer))
		, bufferLimit(sizeof(buffer))
		, sendComplete(false) {

		memset(buffer, 0, sizeof(buffer));
	}

	~WinHttpGet() {}

	virtual void finishOnError(const BException& ex) throw() {
		this->ex = ex;
	}

	virtual void finishOnOK() throw() {
	}

	virtual void onSendComplete() throw() {
		{
			byps_unique_lock lock(this->mutex);
			sendComplete = true;
			waitForSendComplete.notify_one();
		}

		writeDataOrReceiveResponse();
	}

	virtual void writeDataOrReceiveResponse() throw() {
		if (!hRequest) return; 
		BOOL succ = WinHttpReceiveResponse(hRequest, NULL);
		if (!succ) {
			DWORD err = GetLastError();
			finishOnError(HException(L"WinHttpReceiveResponse", err));
		}
	}

	virtual void onReadComplete(BYTE* , DWORD length) throw() {
		byps_unique_lock lock(this->mutex);

		if (length) {
			bufferPos = 0;
			bufferLimit = length;
			waitForReadComplete.notify_one();

			this->waitForWriteComplete.wait(lock, [this](){ return bufferPos == bufferLimit; });
			readData();
		}
		else {
			bufferPos = 0;
			bufferLimit = -1;
			waitForReadComplete.notify_one();

			finishOnOK();

		}
	}

	virtual void readData() throw() {
		if (!hRequest) return; 

		BOOL succ = WinHttpReadData(hRequest, 
									buffer, 
									sizeof(buffer), 
									NULL);
		if (!succ) {
			DWORD err = GetLastError();
			finishOnError(HException(L"WinHttpReadData", err));
		}
	}

	virtual PContentStream send() {
		sendRequest();

		{
			byps_unique_lock lock(this->mutex);
			this->waitForSendComplete.wait(lock, [this](){ return sendComplete; });
		}

		byps_ptr<WinHttpRequest> pRequest = shared_from_this();
		PContentStream stream = PContentStream(new GetRequestContentStream(byps_ptr_cast<WinHttpGet>(pRequest)));
		return stream;
	}
};

BINLINE GetRequestContentStream::~GetRequestContentStream() {
	request->close();
}

BINLINE const std::wstring& GetRequestContentStream::getContentType() const { 
	byps_unique_lock lock(request->mutex);
	if (request->ex) throw request->ex;
	request->waitForHeadersAvailable.wait(lock, [this](){ return request->statusCode != 0; });
	return request->contentType; 
}

BINLINE int64_t GetRequestContentStream::getContentLength() const {
	byps_unique_lock lock(request->mutex);
	if (request->ex) throw request->ex;
	request->waitForHeadersAvailable.wait(lock, [this](){ return request->statusCode != 0; });
	return request->contentLength; 
}

BINLINE int32_t GetRequestContentStream::read(char* buffer, int32_t offs, int32_t len) {
	byps_unique_lock lock(request->mutex);
	if (request->ex) throw request->ex;

	int32_t ret = -1;

	std::chrono::milliseconds timeout(100 * 1000);

	if (request->waitForReadComplete.wait_for(lock, timeout, [this](){ 
			return request->ex || request->bufferLimit < 0 || request->bufferPos < request->bufferLimit; 
		}) 
			== std::cv_status::timeout) {

		request->ex = BException(EX_TIMEOUT, L"Read timeout");
		throw request->ex;
	}

	if (request->ex) {
		throw request->ex;
	}
	else if (request->bufferLimit < 0) {
		// End of stream
	}
	else {

		if (request->bufferPos > request->bufferLimit) {
			BException ex(EX_INTERNAL, L"Illegal state in WinHttpClient::ContentStream::readData");
			throw request->ex;
		}

		ret = std::min(request->bufferLimit - request->bufferPos, len);
		memcpy(buffer + offs, request->buffer + request->bufferPos, ret);
		
		request->bufferPos += ret;

		if (request->bufferPos == request->bufferLimit) {
			request->waitForWriteComplete.notify_one();
		}
	}

	return ret;
}


class WinHttpPost : public HHttpPost, public virtual  WinHttpRequest {
	PBytes sendBytes;
	size_t sendIdx;

	PBytes respBytes;
	size_t respIdx;

public:
	WinHttpPost(HINTERNET hRequest, const std::wstring& url) 
		: WinHttpRequest(hRequest, url)
		, sendIdx(0)
		, respIdx(0) 
	{
	}

	~WinHttpPost() {}

	virtual void finishOnOK() throw() {
		if (asyncResult) {
			if (respBytes) { // shoud not be null
				respBytes->length = respIdx;
				asyncResult->setAsyncResult(BVariant(respBytes));
			}
			else {
				asyncResult->setAsyncResult(BVariant(BException(EX_IOERROR, L"No bytes received")));
			}
			asyncResult = NULL;
		}
	}

	virtual void send(PBytes bytes, const std::wstring& contentType, PAsyncResult asyncBytesReceived) {
		this->asyncResult = asyncBytesReceived;
		this->sendBytes = bytes;
		this->contentLength = bytes->length;
		this->contentType = contentType;
		sendRequest();
	}

	virtual void writeDataOrReceiveResponse() throw() {
		if (!hRequest) return; 

		if (sendIdx >= sendBytes->length) {
			BOOL succ = WinHttpReceiveResponse(hRequest, NULL);
			if (!succ) {
				DWORD err = GetLastError();
				finishOnError(HException(L"WinHttpReceiveResponse", err));
			}
		}
		else {
			if (sendBytes->length < sendIdx) {
				DWORD err = ERROR_INVALID_PARAMETER;
				finishOnError(HException(L"Invalid state in writeDataOrReceiveResponse: bytes->length < sendIdx", err));
				return;
			}

			int8_t* data = sendBytes->data + sendIdx;
			size_t len = sendBytes->length - sendIdx;
			len = std::min((size_t)0x7FFFFFFF, len);

			BOOL succ = WinHttpWriteData(hRequest, data, (DWORD)len, NULL);
			if (!succ) {
				DWORD err = GetLastError();
				finishOnError(HException(L"WinHttpWriteData", err));
			}
		}
	}

	virtual void readData() throw() {
		if (!hRequest) return; 

		if (respBytes) {

			if (respBytes->length < respIdx) {
				finishOnError(BException(EX_INTERNAL, L"Read-buffer overflow"));
				return;
			}

			// Falls kein richtiger Content-Length Header kam, 
			// haben wir nicht genügend reserviert.
			if (respBytes->length == respIdx) {
				respBytes = BBytes::create(respBytes, respBytes->length * 2);
			}
		}
		else {
			// A post message must fit into memory. 
			// Since Java does not support byte arrays > 2GB, we also do not allow
			// them for C++.
			if (contentLength > 0x7FFFFFFF) {
				finishOnError(BException(EX_INTERNAL, L"Message tool large."));
				return;
			}

			// Kein Content-Length Header? dann mindestens 16 Bytes bereitstellen.
			if (contentLength < 16) {
				contentLength = 16;
			}

			respBytes = BBytes::create(respBytes, (int32_t)contentLength + 4); 
				// Etwas mehr reservieren, damit length > als respIdx bleibt.
				// Sonst wird onReadComplete nicht mit 0 aufgerufen .
		}

		BOOL succ = WinHttpReadData(hRequest, 
									respBytes->data + respIdx, 
									(DWORD)(respBytes->length - respIdx), 
									NULL);
		if (!succ) {
			DWORD err = GetLastError();
			finishOnError(HException(L"WinHttpReadData", err));
		}
	}


	virtual void onReadComplete(BYTE* , DWORD length) throw() {
		if (length) {
			respIdx += length;
			readData();
		}
		else {
			finishOnOK();
		}
	}

	virtual void onWriteComplete(DWORD length) throw() {
		sendIdx += length;
		writeDataOrReceiveResponse();
	}

};

class WinHttpPut : public HHttpPut, public virtual WinHttpRequest {
	PContentStream stream;
	enum EChunkState { NotChunked, Chunked, FinishChunks } m_eChunkState;
	
	int32_t bufferPos, bufferLimit;
	char buffer[0xFFF0]; // writeDataOrReceiveResponse assumes that buffer size is smaller or equal to 0xFFFF

public:
	WinHttpPut(HINTERNET hRequest, const std::wstring& url) 
		: WinHttpRequest(hRequest, url)
		, bufferPos(0), bufferLimit(0)
		, m_eChunkState(EChunkState::NotChunked) 
	{
		memset(buffer, 0, sizeof(buffer));
	}

	~WinHttpPut() {}

	virtual void finishOnOK() throw() {
		if (asyncResult) {
			asyncResult->setAsyncResult(BVariant(true));
			asyncResult = NULL;
		}
	}

	virtual void send(PContentStream stream, PAsyncResult asyncBoolFinished) {
		asyncResult = asyncBoolFinished;
		this->stream = stream;
		contentLength = (int64_t)stream->getContentLength();
		if (contentLength < 0) m_eChunkState = EChunkState::Chunked;
		contentType = stream->getContentType();
		sendRequest();
	}

	virtual void onWriteComplete(DWORD length) throw() {
		bufferPos += (int32_t)length;
		writeDataOrReceiveResponse();
	}

	void beginChunk(int32_t chunkLength) throw() {
		char szHttpChunkHeaderA[32]; 
		StringCchPrintfA(szHttpChunkHeaderA, ARRAYSIZE(szHttpChunkHeaderA), "%X\r\n", chunkLength ); 
		BOOL succ = WinHttpWriteData(hRequest, szHttpChunkHeaderA, (DWORD)strlen(szHttpChunkHeaderA), NULL);
		if (!succ) {
			DWORD err = GetLastError();
			finishOnError(HException(L"WinHttpWriteData", err));
		}	
	}

	void writeChunk() throw() {
		char* data = buffer + bufferPos;
		int32_t length = bufferLimit - bufferPos;
		BOOL succ = WinHttpWriteData(hRequest, data, (DWORD)length, NULL);
		if (!succ) {
			DWORD err = GetLastError();
			finishOnError(HException(L"WinHttpWriteData", err));
		}
	}

	void endChunk() throw() {
		BOOL succ = WinHttpWriteData(hRequest, "\r\n", 2, NULL);
		if (!succ) {
			DWORD err = GetLastError();
			finishOnError(HException(L"WinHttpWriteData", err));
		}	
	}

	virtual void onReadComplete(BYTE* , DWORD length) throw() {
		if (length) {
			readData();
		}
		else {
			finishOnOK();
		}
	}

	virtual void readData() throw() {
		BOOL succ = WinHttpReadData(hRequest, 
									buffer, 
									sizeof(buffer), 
									NULL);
		if (!succ) {
			DWORD err = GetLastError();
			finishOnError(HException(L"WinHttpReadData", err));
		}
	}

	virtual void writeDataOrReceiveResponse() throw() {

		// Buffer completely send?
		if (bufferPos == bufferLimit) {

			// Read next bytes from stream into buffer
			if (m_eChunkState == EChunkState::Chunked) {

				// Chunked encoding: send chunk bytes as:
				// <nbOfBytes in HEX>\r\n
				// ...chunk bytes...
				// \r\n
				bufferPos = 0;
				int32_t chunkLength = stream->read(buffer + 6, 0, sizeof(buffer) - 6 - 2);
				if (chunkLength > 0) {
					if (chunkLength <= 0xF) bufferPos = 3;
					else if (chunkLength <= 0xFF) bufferPos = 2;
					else if (chunkLength <= 0xFFF) bufferPos = 1;
					else bufferPos = 0;
					StringCchPrintfA(buffer + bufferPos, 5 - bufferPos, "%X", chunkLength );
					buffer[4] = '\r';
					buffer[5] = '\n';

					bufferLimit = 6 + chunkLength + 2;
					buffer[bufferLimit-2] = '\r';
					buffer[bufferLimit-1] = '\n';
				}
				else {
					StringCchPrintfA(buffer, 6, "0\r\n\r\n", chunkLength );
					bufferPos = 0;
					bufferLimit = 5;
					m_eChunkState = EChunkState::FinishChunks;
				}
			}
			else if (m_eChunkState == EChunkState::FinishChunks) {
				bufferLimit = -1;
			}
			else {
				bufferPos = 0;
				bufferLimit = stream->read(buffer, 0, sizeof(buffer));
			}
		}

		// End of stream?
		if (bufferLimit <= 0) {
			BOOL succ = WinHttpReceiveResponse(hRequest, NULL);
			if (!succ) {
				DWORD err = GetLastError();
				finishOnError(HException(L"WinHttpReceiveResponse", err));
			}
		}
		// Check for invalid internal state
		else if (bufferLimit < bufferPos) {
			DWORD err = ERROR_INVALID_PARAMETER;
			finishOnError(HException(L"Invalid state in writeDataOrReceiveResponse: bytes->length < sendIdx", err));
			return;
		}
		else {
			// Write buffer data
			writeChunk();
		}
	}
};

class WinHttpClient : public HHttpClient {

	HINTERNET hSession;
	HINTERNET hConnection;

public:
	WinHttpClient() 
		: hSession(NULL)
		, hConnection(NULL)
	{
	}

	virtual ~WinHttpClient() {
		if (hConnection) {
			WinHttpCloseHandle(hConnection);
			hConnection = NULL;
		}
		if (hSession) {
			WinHttpCloseHandle(hSession);
			hConnection = NULL;
		}
	}

	virtual void init(const std::wstring& url) {

		// WinHttpOpen just seem to leak handles.
		// http://stackoverflow.com/questions/12652868/winhttpopen-leaking-memory

		hSession = WinHttpOpen(L"BYPSWINHTTP", 
						WINHTTP_ACCESS_TYPE_DEFAULT_PROXY,
						WINHTTP_NO_PROXY_NAME, 
						WINHTTP_NO_PROXY_BYPASS, 
						WINHTTP_FLAG_ASYNC);

		if (!hSession) {
			DWORD err = GetLastError();
			throw HException(L"WinHttpOpen", err);
		}

		WCHAR szHost[256]={0};
		URL_COMPONENTS UrlComps = {0};
		UrlComps.dwStructSize = sizeof(UrlComps);
		UrlComps.dwSchemeLength    = -1;
		UrlComps.lpszHostName = szHost;
		UrlComps.dwHostNameLength  = ARRAYSIZE(szHost)-1;
		UrlComps.dwUrlPathLength   = -1;
		UrlComps.dwExtraInfoLength = -1;

		BOOL succ = WinHttpCrackUrl(
								url.c_str(), 
								(DWORD)url.size(), 
								0, 
								&UrlComps);
		if (!succ) {
			DWORD err = GetLastError();
			throw HException(L"WinHttpCrackUrl", err);
		}

		hConnection = WinHttpConnect(
								hSession, 
								szHost, 
								UrlComps.nPort, 
								0);
		if (!hConnection) {
			DWORD err = GetLastError();
			throw HException(L"WinHttpConnect", err);
		}

	}
	
	HINTERNET openRequest(LPCWSTR method, const std::wstring& url) {

		WCHAR szHost[256]={0};
		URL_COMPONENTS UrlComps = {0};
		UrlComps.dwStructSize = sizeof(UrlComps);
		UrlComps.dwSchemeLength    = -1;
		UrlComps.lpszHostName = szHost;
		UrlComps.dwHostNameLength  = ARRAYSIZE(szHost)-1;
		UrlComps.dwUrlPathLength   = -1;
		UrlComps.dwExtraInfoLength = -1;

		BOOL succ = WinHttpCrackUrl(
								url.c_str(), 
								(DWORD)url.size(), 
								0, 
								&UrlComps);
		if (!succ) {
			DWORD err = GetLastError();
			throw HException(L"WinHttpCrackUrl", err);
		}

		DWORD flags = (INTERNET_SCHEME_HTTPS == UrlComps.nScheme) ? WINHTTP_FLAG_SECURE : 0;
		HINTERNET hRequest = WinHttpOpenRequest(hConnection, 
						method, 
						UrlComps.lpszUrlPath, 
						NULL,
						WINHTTP_NO_REFERER,
						WINHTTP_DEFAULT_ACCEPT_TYPES, 
						flags);

		if (!hRequest) {
			DWORD err = ::GetLastError();
			throw HException(L"WinHttpOpenRequest", err);
		}

		WINHTTP_STATUS_CALLBACK retcb = WinHttpSetStatusCallback(
			hRequest,
			winhttp_status_callback,
			WINHTTP_CALLBACK_FLAG_ALL_COMPLETIONS | WINHTTP_CALLBACK_STATUS_HANDLE_CLOSING, 
			NULL );
		if (retcb == WINHTTP_INVALID_STATUS_CALLBACK) {
		  DWORD err = GetLastError();
		  throw HException(L"WinHttpSetStatusCallback", err);
		}

		return hRequest;
	}

	virtual PHttpGet get(const std::wstring& url) {
		HINTERNET hRequest = openRequest(L"GET", url);
		PWinHttpGet req(new WinHttpGet(hRequest, url));
		return req;
	}

	virtual PHttpPost post(const std::wstring& url) {
		HINTERNET hRequest = openRequest(L"POST", url);
		PWinHttpPost req(new WinHttpPost(hRequest, url));
		return req;
	}

	virtual PHttpPut put(const std::wstring& url) {
		HINTERNET hRequest = openRequest(L"PUT", url);
		PWinHttpPut req(new WinHttpPut(hRequest, url));
		return req;
	}

	BINLINE static void CALLBACK winhttp_status_callback(
			IN HINTERNET hInternet,
			IN DWORD_PTR dwContext,
			IN DWORD dwInternetStatus,
			IN LPVOID lpvStatusInformation OPTIONAL,
			IN DWORD dwStatusInformationLength) {

		WinHttpRequest* pThis = reinterpret_cast<WinHttpRequest*>(dwContext);

		if (pThis) {
			switch (dwInternetStatus) {
			case WINHTTP_CALLBACK_STATUS_SENDREQUEST_COMPLETE:
				pThis->onSendComplete();
				break;
			case WINHTTP_CALLBACK_STATUS_HEADERS_AVAILABLE:
				pThis->onHeadersAvailable();
				break;
			case WINHTTP_CALLBACK_STATUS_DATA_AVAILABLE:
				pThis->onDataAvailable(*((DWORD*)lpvStatusInformation));
				break;
			case WINHTTP_CALLBACK_STATUS_READ_COMPLETE:
				pThis->onReadComplete((BYTE*)lpvStatusInformation, dwStatusInformationLength);
				break;
			case WINHTTP_CALLBACK_STATUS_WRITE_COMPLETE:
				pThis->onWriteComplete(*((DWORD*)lpvStatusInformation));
				break;
			case WINHTTP_CALLBACK_STATUS_REQUEST_ERROR:
				pThis->onRequestError((WINHTTP_ASYNC_RESULT*)lpvStatusInformation);
				break;
			case WINHTTP_CALLBACK_STATUS_GETPROXYFORURL_COMPLETE:
		
				break;
			case WINHTTP_CALLBACK_STATUS_HANDLE_CLOSING:
				pThis->onHandleClosing(*((HINTERNET*)lpvStatusInformation));
				break;
			}
		}
	}
};

}}}}}

namespace com { namespace wilutions { namespace byps { namespace http { 

BINLINE PHttpClient HttpClient_create(void* app) {
	return PHttpClient(new com::wilutions::byps::http::winhttp::WinHttpClient());
}

}}}}



#endif