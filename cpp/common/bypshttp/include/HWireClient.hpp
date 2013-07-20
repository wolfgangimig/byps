#ifndef HWIRECLIENT_HPP_
#define HWIRECLIENT_HPP_

#include "Byps.h"
#include "HWireClient.h"
#include "HWireClientI.h"
#include <strsafe.h>

namespace com { namespace wilutions { namespace byps { namespace http {

using namespace com::wilutions::byps;

#pragma comment( lib, "winhttp.lib" )

#undef min

BINLINE int64_t HWireClient::makeMessageId() {
	GUID guid;
	CoCreateGuid(&guid);
	int64_t* v = reinterpret_cast<int64_t*>(&guid);
	int64_t id = v[0] ^ v[1];
	return id >= 0 ? id : -id;
}

BINLINE PTestAdapter HWireClient::getTestAdapter() {
	return PTestAdapter(new HWireClient_TestAdapter(shared_from_this()));
}

BINLINE HWireClient_RequestsToCancel::HWireClient_RequestsToCancel(HINTERNET hSession, HINTERNET hConnection) 
	: hSession(hSession), hConnection(hConnection), isCanceled(false) {
}

BINLINE HINTERNET HWireClient_RequestsToCancel::getConnection() {
	return hConnection;
}

BINLINE bool HWireClient_RequestsToCancel::add(intptr_t id, PWireClient_RequestToCancel r) {
    byps_unique_lock lock(mutex);
	bool succ = !isCanceled;
	if (succ) {
		map[id] = r;
	}
	return succ;
}

BINLINE void HWireClient_RequestsToCancel::addCancelMessage(intptr_t id, PWireClient_RequestToCancel r) {
    byps_unique_lock lock(mutex);
	map[id] = r;
}

BINLINE void HWireClient_RequestsToCancel::remove(intptr_t id) {
    byps_unique_lock lock(mutex);
    map.erase(id);
}

BINLINE void HWireClient_RequestsToCancel::cancel() {
    byps_unique_lock lock(mutex);
    for (std::map<intptr_t, PWireClient_RequestToCancel>::iterator it = map.begin(); it != map.end(); it++) {
		(*it).second->cancel();
	}
	isCanceled = true;
}

BINLINE HWireClient_RequestsToCancel::~HWireClient_RequestsToCancel() {
	map.clear();

	if (hConnection) {
		WinHttpCloseHandle(hConnection);
		hConnection = NULL;
	}
	if (hSession) {
		WinHttpCloseHandle(hSession);
		hConnection = NULL;
	}
}

BINLINE HWireClient_RequestToCancel::HWireClient_RequestToCancel(
		const std::wstring& urlPath,
		DWORD urlFlags,
		DWORD timeoutMillisClient, DWORD timeoutMillisRequest,
		PWireClient_RequestsToCancel requestsToCancel,
		PAsyncResult asyncResult)
    : id(reinterpret_cast<intptr_t>(this))
	, urlPath(urlPath)
	, urlFlags(urlFlags)
	, timeoutMillisClient(timeoutMillisClient)
	, timeoutMillisRequest(timeoutMillisRequest)
	, requestsToCancel(requestsToCancel)
    , asyncResult(asyncResult)
	, hRequest(NULL)
	, statusCode(0)
	, contentLength(0) {

}

BINLINE void HWireClient_RequestToCancel::openRequest(LPCWSTR method) {

	HINTERNET hConnection = requestsToCancel->getConnection();
	if (!hConnection) {
		throw HException(L"Already disconnected", EX_CANCELED);
	}

	hRequest = WinHttpOpenRequest(hConnection, 
					method, 
					urlPath.c_str(), 
					NULL,
					WINHTTP_NO_REFERER,
					WINHTTP_DEFAULT_ACCEPT_TYPES, 
					urlFlags);

	if (!hRequest) {
		DWORD err = ::GetLastError();
		throw HException(L"WinHttpOpenRequest", err);
	}

	WinHttpSetTimeouts(hRequest, timeoutMillisClient, timeoutMillisClient, timeoutMillisRequest, timeoutMillisRequest);

	WINHTTP_STATUS_CALLBACK retcb = WinHttpSetStatusCallback(
		hRequest,
		winhttp_status_callback,
		WINHTTP_CALLBACK_FLAG_ALL_COMPLETIONS, 
		NULL );
	if (retcb == WINHTTP_INVALID_STATUS_CALLBACK) {
      DWORD err = GetLastError();
      throw HException(L"WinHttpSetStatusCallback", err);
	}

}

void HWireClient_RequestToCancel::getRequestHeaders(std::wstring& headers, DWORD& totalLength) {

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

BINLINE void HWireClient_RequestToCancel::sendRequest() {

	std::wstring headers;
	DWORD totalLength = 0;
	getRequestHeaders(headers, totalLength);

	BOOL succ = WinHttpSendRequest(hRequest, 
					headers.size() ? headers.c_str() : WINHTTP_NO_ADDITIONAL_HEADERS, 
					(DWORD)headers.size(), 
					NULL, 0,
					(DWORD)totalLength, 
					(DWORD_PTR)id);

	if( !succ ) {
		DWORD err = GetLastError();
		finishOnError(HException(L"WinHttpSendRequest", err));
	}
}

BINLINE void HWireClient_RequestToCancel::get() {
	openRequest(L"GET");
	sendRequest();
}

BINLINE void HWireClient_RequestToCancel::post(PBytes bytes) {
	openRequest(L"POST");
	sendRequest();
}

BINLINE void HWireClient_RequestToCancel::put(PContentStream stream) {
	openRequest(L"PUT");
	sendRequest();
}

BINLINE void HWireClient_RequestToCancel::cancel() {
	HINTERNET h = hRequest;
	hRequest = NULL;
	if (h) {
		WinHttpSetStatusCallback(h, NULL, NULL, NULL );
		WinHttpCloseHandle(h);
	}
}

BINLINE bool HWireClient_RequestToCancel::isCanceled() {
	return hRequest == NULL;
}

BINLINE void HWireClient_RequestToCancel::close() {

	cancel();

	PWireClient_RequestsToCancel r = requestsToCancel;
	if (r) {
		requestsToCancel.reset();
		r->remove(id); // delete this
		r.reset();
	}
}

BINLINE HWireClient_RequestToCancel::~HWireClient_RequestToCancel() {
}

BINLINE void CALLBACK HWireClient_RequestToCancel::winhttp_status_callback(
		IN HINTERNET hInternet,
		IN DWORD_PTR dwContext,
		IN DWORD dwInternetStatus,
		IN LPVOID lpvStatusInformation OPTIONAL,
		IN DWORD dwStatusInformationLength) {

	HWireClient_RequestToCancel* pThis = reinterpret_cast<HWireClient_RequestToCancel*>(dwContext);
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
		}
	}

}

BINLINE void HWireClient_RequestToCancel::onSendComplete() {
	writeDataOrReceiveResponse();
}

BINLINE void HWireClient_RequestToCancel::onHeadersAvailable() {
	
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

BINLINE void HWireClient_RequestToCancel::parseHeaders(LPWSTR lpszResponseHeaders) {
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

BINLINE void HWireClient_RequestToCancel::readData() {
}

BINLINE void HWireClient_RequestToCancel::writeDataOrReceiveResponse() {
	BOOL succ = WinHttpReceiveResponse(hRequest, NULL);
	if (!succ) {
		DWORD err = GetLastError();
		finishOnError(HException(L"WinHttpReceiveResponse", err));
	}
}

BINLINE void HWireClient_RequestToCancel::finishOnError(const BException& ex) {
	if (asyncResult) {
		asyncResult->setAsyncResult(BVariant(ex));
		asyncResult = NULL;
	}
	close();
}

BINLINE void HWireClient_RequestToCancel::finishOnOK() {
	close();
}

BINLINE void HWireClient_RequestToCancel::onDataAvailable(DWORD length) {
}

BINLINE void HWireClient_RequestToCancel::onReadComplete(BYTE* data, DWORD length) {
}

BINLINE void HWireClient_RequestToCancel::onWriteComplete(DWORD length) {
}

BINLINE void HWireClient_RequestToCancel::onRequestError(WINHTTP_ASYNC_RESULT* asyncInfo) {

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

BINLINE HWireClient_SendMessage::HWireClient_SendMessage(
		const std::wstring& urlPath,
		DWORD urlFlags,
		DWORD timeoutMillisClient,
		DWORD timeoutMillisRequest,
		PWireClient_RequestsToCancel requestsToCancel,
		PAsyncResult asyncResult,
        int64_t messageId, 
		PBytes bytes)
	: HWireClient_RequestToCancel(urlPath, urlFlags, timeoutMillisClient, timeoutMillisRequest, requestsToCancel, asyncResult)
	, messageId(messageId)
	, bytes(bytes)
	, sendIdx(0)
	, respIdx(0)
{
	contentLength = (int64_t)bytes->length;
}

BINLINE void HWireClient_SendMessage::send() {
	post(bytes);
}

BINLINE void HWireClient_SendMessage::writeDataOrReceiveResponse() {
	if (sendIdx >= bytes->length) {
		BOOL succ = WinHttpReceiveResponse(hRequest, NULL);
		if (!succ) {
			DWORD err = GetLastError();
			finishOnError(HException(L"WinHttpReceiveResponse", err));
		}
	}
	else {
		if (bytes->length < sendIdx) {
			DWORD err = ERROR_INVALID_PARAMETER;
			finishOnError(HException(L"Invalid state in writeDataOrReceiveResponse: bytes->length < sendIdx", err));
			return;
		}

		int8_t* data = bytes->data + sendIdx;
		size_t len = bytes->length - sendIdx;
		len = std::min((size_t)0x7FFFFFFF, len);

		BOOL succ = WinHttpWriteData(hRequest, data, (DWORD)len, NULL);
		if (!succ) {
			DWORD err = GetLastError();
			finishOnError(HException(L"WinHttpWriteData", err));
		}
	}
}

BINLINE void HWireClient_SendMessage::readData() {

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
		if (contentLength > 0x7FFFFFFF) {
			finishOnError(BException(EX_INTERNAL, L"Message tool large."));
			return;
		}

		// Kein Content-Length Header? dann mindestens 16 Bytes bereitstellen.
		if (contentLength < BHEADER_SIZE) {
			contentLength = BHEADER_SIZE;
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


BINLINE void HWireClient_SendMessage::onReadComplete(BYTE* , DWORD length) {
	if (length) {
		respIdx += length;
		readData();
	}
	else {
		finishOnOK();
	}
}

BINLINE void HWireClient_SendMessage::onWriteComplete(DWORD length) {
	sendIdx += length;
	writeDataOrReceiveResponse();
}

BINLINE void HWireClient_SendMessage::finishOnOK() {
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

		asyncResult->setAsyncResult(BVariant(msg));
		asyncResult = NULL;

		HWireClient_RequestToCancel::finishOnOK();

	} catch (const BException& ex) {
		finishOnError(ex);
	}
}

BINLINE HWireClient_PutStream::HWireClient_PutStream(
		const std::wstring& urlPath,
		DWORD urlFlags,
		DWORD timeoutMillisClient, DWORD timeoutMillisRequest,
		PWireClient_RequestsToCancel requestsToCancel,
		PAsyncResult asyncResult,
		PContentStream stream) 
	: HWireClient_RequestToCancel(urlPath, urlFlags, timeoutMillisClient, timeoutMillisRequest, requestsToCancel, asyncResult)
	, stream(stream)
	, bufferPos(0), bufferLimit(0)
	, m_eChunkState(EChunkState::NotChunked) {

	contentLength = (int64_t)stream->getContentLength();
	if (contentLength < 0) m_eChunkState = EChunkState::Chunked;

	contentType = stream->getContentType();

	memset(buffer, 0, sizeof(buffer));
}

BINLINE void HWireClient_PutStream::send() {
	put(stream);
}

BINLINE void HWireClient_PutStream::onWriteComplete(DWORD length) {
	bufferPos += length;
	writeDataOrReceiveResponse();
}

BINLINE void HWireClient_PutStream::beginChunk(int32_t chunkLength) {
	char szHttpChunkHeaderA[32]; 
	StringCchPrintfA(szHttpChunkHeaderA, ARRAYSIZE(szHttpChunkHeaderA), "%X\r\n", chunkLength ); 
	BOOL succ = WinHttpWriteData(hRequest, szHttpChunkHeaderA, (DWORD)strlen(szHttpChunkHeaderA), NULL);
	if (!succ) {
		DWORD err = GetLastError();
		finishOnError(HException(L"WinHttpWriteData", err));
	}	
}

BINLINE void HWireClient_PutStream::endChunk() {
	BOOL succ = WinHttpWriteData(hRequest, "\r\n", 2, NULL);
	if (!succ) {
		DWORD err = GetLastError();
		finishOnError(HException(L"WinHttpWriteData", err));
	}	
}
BINLINE void HWireClient_PutStream::onReadComplete(BYTE* , DWORD length) {
	if (length) {
		readData();
	}
	else {
		finishOnOK();
	}
}

BINLINE void HWireClient_PutStream::readData() {

	BOOL succ = WinHttpReadData(hRequest, 
								buffer, 
								sizeof(buffer), 
								NULL);
	if (!succ) {
		DWORD err = GetLastError();
		finishOnError(HException(L"WinHttpReadData", err));
	}
}

BINLINE void HWireClient_PutStream::writeDataOrReceiveResponse() {

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

BINLINE void HWireClient_PutStream::writeChunk() {
	char* data = buffer + bufferPos;
	int32_t length = bufferLimit - bufferPos;
	BOOL succ = WinHttpWriteData(hRequest, data, (DWORD)length, NULL);
	if (!succ) {
		DWORD err = GetLastError();
		finishOnError(HException(L"WinHttpWriteData", err));
	}
}

BINLINE void HWireClient_PutStream::finishOnOK() {
	BVariant var;
	var.setType(BTYPEID_VOID);
	asyncResult->setAsyncResult(var);
	asyncResult = NULL;
	HWireClient_RequestToCancel::finishOnOK();
}

BINLINE HWireClient_GetStream::HWireClient_GetStream(
		const std::wstring& urlPath,
		DWORD urlFlags,
		DWORD timeoutMillisClient, DWORD timeoutMillisRequest,
		PWireClient_RequestsToCancel requestsToCancel)
	: HWireClient_RequestToCancel(urlPath, urlFlags, timeoutMillisClient, timeoutMillisRequest, requestsToCancel, PAsyncResult())
	, bufferPos(sizeof(buffer)), bufferLimit(sizeof(buffer)) {
	memset(buffer, 0, sizeof(buffer));
}

BINLINE HWireClient_GetStream::~HWireClient_GetStream() {
}

BINLINE PWireClient_GetStream HWireClient_GetStream::create(
	const std::wstring& urlPath,
	DWORD urlFlags,
	DWORD timeoutMillisClient, DWORD timeoutMillisRequest,
	PWireClient_RequestsToCancel requestsToCancel) {

	PWireClient_GetStream streamRequest(new HWireClient_GetStream(urlPath, urlFlags, timeoutMillisClient, timeoutMillisRequest, requestsToCancel));
	streamRequest->stream = PContentStream(new HWireClient_GetStream::MyContentStream(streamRequest));
	streamRequest->asyncResult = PAsyncResult(new HWireClient_GetStream::MyAsyncResult(streamRequest));
	
	return streamRequest;
}

BINLINE void HWireClient_GetStream::send() {
	get();
}

BINLINE void HWireClient_GetStream::finishOnOK() {
	stream.reset();
	HWireClient_RequestToCancel::finishOnOK();
	asyncResult->setAsyncResult(BVariant());
	asyncResult = NULL;
}

BINLINE void HWireClient_GetStream::finishOnError(const BException& ex) {
	stream.reset();
	HWireClient_RequestToCancel::finishOnError(ex);
	asyncResult = NULL;
}

BINLINE void HWireClient_GetStream::onWriteComplete(DWORD length) {
	writeDataOrReceiveResponse();
}

BINLINE void HWireClient_GetStream::onReadComplete(BYTE* , DWORD length) {
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

BINLINE void HWireClient_GetStream::readData() {

	BOOL succ = WinHttpReadData(hRequest, 
								buffer, 
								sizeof(buffer), 
								NULL);
	if (!succ) {
		DWORD err = GetLastError();
		finishOnError(HException(L"WinHttpReadData", err));
	}
}

BINLINE void HWireClient_GetStream::MyContentStream::ensureOpen() const {
	if (pThis->hRequest == NULL && 
		pThis->stream != NULL) { // stream is set to NULL in finishOn*. 
		pThis->send();
	}
}

BINLINE const std::wstring& HWireClient_GetStream::MyContentStream::getContentType() const { 
	ensureOpen();
			
	{
		byps_unique_lock lock(pThis->mutex);
		pThis->waitForHeadersAvailable.wait(lock, [this](){ return pThis->statusCode != 0; });
	}

	return pThis->contentType; 
}

BINLINE int64_t HWireClient_GetStream::MyContentStream::getContentLength() const {
	ensureOpen();

	{
		byps_unique_lock lock(pThis->mutex);
		pThis->waitForHeadersAvailable.wait(lock, [this](){ return pThis->statusCode != 0; });
	}

	return pThis->contentLength; 
}

BINLINE int32_t HWireClient_GetStream::MyContentStream::read(char* buffer, int32_t offs, int32_t len) {
	
	ensureOpen();

	byps_unique_lock lock(pThis->mutex);

	int32_t ret = -1;

	// specify a timeout, thanks to the c++11 gurus: it couldn't be more complex to specify some milliseconds
	std::chrono::duration<int,std::milli> timeout(100 * 1000);

	if (pThis->waitForReadComplete.wait_for(lock, timeout, [this](){ 
			return pThis->ex || pThis->bufferLimit < 0 || pThis->bufferPos < pThis->bufferLimit; 
		}) 
			== std::cv_status::timeout) {

		pThis->ex = BException(EX_TIMEOUT, L"Read timeout");
		throw pThis->ex;
	}

	if (pThis->ex) {
		throw pThis->ex;
	}
	else if (pThis->bufferLimit < 0) {
		// End of stream
	}
	else {

		if (pThis->bufferPos > pThis->bufferLimit) {
			BException ex(EX_INTERNAL, L"Illegal state in HWireClient_GetStream::readData");
			throw pThis->ex;
		}

		ret = std::min(pThis->bufferLimit - pThis->bufferPos, len);
		memcpy(buffer + offs, pThis->buffer + pThis->bufferPos, ret);
		
		pThis->bufferPos += ret;

		if (pThis->bufferPos == pThis->bufferLimit) {
			pThis->waitForWriteComplete.notify_one();
		}
	}

	return ret;
}

BINLINE HWireClient_CancelMessage::HWireClient_CancelMessage(
		const std::wstring& urlPath,
		DWORD urlFlags,
		DWORD timeoutMillisClient,
		DWORD timeoutMillisRequest,
		PWireClient_RequestsToCancel requestsToCancel,
		PAsyncResult asyncResult,
        int64_t cancelMessageId)
	: HWireClient_RequestToCancel(L"", urlFlags, timeoutMillisClient, timeoutMillisRequest, requestsToCancel, asyncResult)
	, cancelMessageId(cancelMessageId)
{
	std::wstringstream ss;
	ss << urlPath << L"?cancel=1&messageid=" << cancelMessageId;
	this->urlPath = ss.str();
}

BINLINE HWireClient_CancelMessage::~HWireClient_CancelMessage() {
}

BINLINE void HWireClient_CancelMessage::send() {
	get();
}

BINLINE void HWireClient_CancelMessage::readData() {

	BOOL succ = WinHttpReadData(hRequest, 
								buffer, 
								sizeof(buffer), 
								NULL);
	if (!succ) {
		DWORD err = GetLastError();
		finishOnError(HException(L"WinHttpReadData", err));
	}
}

BINLINE void HWireClient_CancelMessage::onReadComplete(BYTE* , DWORD length) {
	if (length) {
		readData();
	}
	else {
		finishOnOK();
	}
}

BINLINE void HWireClient_CancelMessage::onWriteComplete(DWORD length) {
	writeDataOrReceiveResponse();
}

BINLINE void HWireClient_CancelMessage::finishOnOK() {
	if (asyncResult) {
		asyncResult->setAsyncResult(BVariant());
		asyncResult = NULL;
	}

	HWireClient_RequestToCancel::finishOnOK();
}

BINLINE PWire HWireClient::create(const std::wstring& url, int32_t flags, int32_t timeoutSeconds, PThreadPool tpool) {
	HWireClient* pThis = new HWireClient(url, flags, timeoutSeconds, tpool);
	pThis->init();
	return PWire(pThis);
}

BINLINE HWireClient::HWireClient(const std::wstring& surl, int32_t , int32_t timeoutSeconds, PThreadPool tpool)
	: url(surl)
	, urlFlags(0)
	, timeoutMillisClient((DWORD)timeoutSeconds * 1000)
	, tpool(tpool)
	, isMyThreadPool(!tpool)
{
	if (isMyThreadPool) {
		this->tpool = BThreadPool::create(10);
	}
}

BINLINE void HWireClient::init() {

	try {
		HINTERNET hSession = WinHttpOpen(L"BYPSWINHTTP", 
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

		HINTERNET hConnection = WinHttpConnect(
								hSession, 
								szHost, 
								UrlComps.nPort, 
								0);
		if (!hConnection) {
			DWORD err = GetLastError();
			throw HException(L"WinHttpConnect", err);
		}

		urlPath = UrlComps.lpszUrlPath;
		urlFlags = (INTERNET_SCHEME_HTTPS == UrlComps.nScheme) ? WINHTTP_FLAG_SECURE : 0;

		requestsToCancel = PWireClient_RequestsToCancel(new HWireClient_RequestsToCancel(hSession, hConnection));
	}
	catch (const BException& ex) {
		lastException = ex;
	}

}

BINLINE HWireClient::~HWireClient() {
	tpool.reset();
	requestsToCancel.reset();
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

		if (obj.getType() == BTYPEID_VOID) {
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
	internalSend(msg, asyncResult, timeoutMillisClient);
}

BINLINE void HWireClient::sendR(const PMessage& msg, PAsyncResult asyncResult) {
	internalSend(msg, asyncResult, INFINITE);
}

BINLINE void HWireClient::internalSend(const PMessage& msg, PAsyncResult asyncResult, DWORD timeoutMillisRequest) {
    
	// Convert the BMessage into single RequestToCancel objects.
	// One RequestToCancel is created for msg.buf.
	// For each stream in msg.streams further RequestToCancel objects are created.
		
	size_t nbOfRequests = 1 + msg->streams.size();
	std::vector<PWireClient_RequestToCancel> requests;
	requests.reserve(nbOfRequests);

	// If the BMessage contains streams, the given asyncResult is wrapped into a
	// BAsyncRequest object that sets the asynchronous result after the message and all streams
	// have been sent.
	PAsyncResult outerResult = asyncResult;
	if (nbOfRequests > 1) {
		outerResult = PAsyncResult(new HWireClient_AsyncResultAfterAllRequests(tpool, asyncResult, nbOfRequests));
	}

	// Create RequestToCancel for message
    PWireClient_RequestToCancel messageRequest(new HWireClient_SendMessage(
		urlPath, 
		urlFlags, 
		timeoutMillisClient, timeoutMillisRequest,
		requestsToCancel,
		outerResult, 
		msg->header.messageId,
		msg->buf));

	if (requestsToCancel->add(reinterpret_cast<intptr_t>(messageRequest.get()), messageRequest)) {

		requests.push_back(messageRequest);

		// Create RequestToCancel objects for each stream.
		for (unsigned i = 0; i < msg->streams.size(); i++) {
			PStreamRequest stream = msg->streams[i];
			std::wstringstream ssurl;
			ssurl << urlPath << L"?messageid=" << stream->messageId << L"&streamid=" << stream->streamId;
			PWireClient_RequestToCancel streamRequest(new HWireClient_PutStream(
				ssurl.str(),
				urlFlags,
				timeoutMillisClient, timeoutMillisRequest,
				requestsToCancel,
				outerResult,
				stream->strm));

			if (!requestsToCancel->add(reinterpret_cast<intptr_t>(streamRequest.get()), streamRequest)) {
				streamRequest->close();
				break;
			}

			requests.push_back(streamRequest);
		}

	}
	
	// Cannot add messageRequest, the connection was closed.
	else {
		messageRequest->close();
	}

	// Execute the RequestToCancel objects 
	if (requests.size() != 0) {
		for (size_t i = 0; i < requests.size(); i++) {
			PWireClient_RequestToCancel request = requests[i];
			request->send();
		}
	}
	else {
		asyncResult->setAsyncResult(BVariant(HException(L"Already disconnected", EX_CANCELED)));
	}
}

BINLINE void HWireClient::internalSendStreamsThenMessage(const PMessage& msg, PAsyncResult asyncResult, DWORD timeoutMillisRequest) {
    
	std::vector<PWireClient_RequestToCancel> requests;

    PWireClient_RequestToCancel messageRequest(new HWireClient_SendMessage(
		urlPath, 
		urlFlags, 
		timeoutMillisClient, timeoutMillisRequest,
		requestsToCancel,
		asyncResult, 
		msg->header.messageId,
		msg->buf));

	// Does the message contains streams?
	if (msg->streams.size()) {

		// Send the streams first and then send the message.
		// If the message would be sent before the streams, 
		// a timeout happened for the message if it takes 
		// more than timeoutMillisRequest to send the streams.
		
		PAsyncResult asyncSendMessage(new HWireClient_AsyncResultSendMessage(tpool, messageRequest));

		PAsyncResult outerResult = PAsyncResult(new HWireClient_AsyncResultAfterAllRequests(tpool, asyncSendMessage, msg->streams.size()));

		for (unsigned i = 0; i < msg->streams.size(); i++) {
			PStreamRequest stream = msg->streams[i];
			std::wstringstream ssurl;
			ssurl << urlPath << L"?messageid=" << stream->messageId << L"&streamid=" << stream->streamId;
			PWireClient_RequestToCancel streamRequest(new HWireClient_PutStream(
				ssurl.str(),
				urlFlags,
				timeoutMillisClient, timeoutMillisRequest,
				requestsToCancel,
				outerResult,
				stream->strm));

			if (!requestsToCancel->add(reinterpret_cast<intptr_t>(streamRequest.get()), streamRequest)) {
				streamRequest->close();
				break;
			}

			requests.push_back(streamRequest);
		}
	}

	// No streams to send: send the message
	else if (requestsToCancel->add(reinterpret_cast<intptr_t>(messageRequest.get()), messageRequest)) {
		requests.push_back(messageRequest);
	}

	// Cannot add messageRequest, the connection was closed.
	else {
		messageRequest->close();
	}

	// Sende alle Anfragen
	if (requests.size() != 0) {
		for (size_t i = 0; i < requests.size(); i++) {
			requests[i]->send();
		}
	}
	else {
		asyncResult->setAsyncResult(BVariant(HException(L"Already disconnected", EX_CANCELED)));
	}
}


BINLINE PContentStream HWireClient::getStream(int64_t messageId, int64_t streamId) {
	
	std::wstringstream ssurl;
	ssurl << urlPath << L"?messageid=" << messageId << L"&streamid=" << streamId;

	PWireClient_GetStream streamRequest = HWireClient_GetStream::create(
		ssurl.str(),
		urlFlags,
		timeoutMillisClient, timeoutMillisClient,
		requestsToCancel);

	if (!requestsToCancel->add(reinterpret_cast<intptr_t>(streamRequest.get()), streamRequest)) {
		streamRequest->close();
	}

	return streamRequest->stream;
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
		PWireClient_RequestToCancel cancelRequest(new HWireClient_CancelMessage(
			urlPath,
			urlFlags,
			timeoutMillisClient, timeoutMillisClient,
			requestsToCancel,
			asyncResult,
			cancelMessageId));

		requestsToCancel->addCancelMessage(reinterpret_cast<intptr_t>(cancelRequest.get()), cancelRequest);
		cancelRequest->send();
	}
}

HWireClient_ExecResult::HWireClient_ExecResult(PAsyncResult asyncResult, BVariant var) 
	: asyncResult(asyncResult)
	, var(var) {
}

void HWireClient_ExecResult::run() {
	asyncResult->setAsyncResult(var);
}


HWireClient_AsyncResultSendMessage::HWireClient_AsyncResultSendMessage(PThreadPool tpool, PWireClient_RequestToCancel messageRequest)
	: tpool(tpool)
	, messageRequest(messageRequest) {
}

HWireClient_AsyncResultSendMessage::~HWireClient_AsyncResultSendMessage() {
}

void HWireClient_AsyncResultSendMessage::setAsyncResult(const BVariant& result) {
	if (result.isException()) {
		PRunnable r(new HWireClient_ExecResult(messageRequest->asyncResult, result));
		tpool->execute(r);
	}
	else {
		if (messageRequest->requestsToCancel->add(reinterpret_cast<intptr_t>(messageRequest.get()), messageRequest)) {
			messageRequest->send();
		}
		else {
			BException ex(EX_CANCELED);
			PRunnable r(new HWireClient_ExecResult(messageRequest->asyncResult, BVariant(ex)));
			tpool->execute(r);
		}
	}
	delete this;
}

void HWireClient_TestAdapter::killClientConnections() {
	wire->internalCancelAllRequests(0, PAsyncResult());
}

}}}}

#endif

/*
BINLINE void HWireClient_RequestToCancel::sendRequest() {
	BOOL succ = FALSE;

	if (contentLength >= 0x100000000LL) {
		// Starting in Windows Vista and Windows Server 2008, 
		// WinHttp supports uploading files up to the size of a LARGE_INTEGER ...
		// http://msdn.microsoft.com/en-us/library/aa384110(v=vs.85).aspx
		OSVERSIONINFOEXW verInfo={0};
		verInfo.dwOSVersionInfoSize = sizeof(verInfo);
		::GetVersionExW((OSVERSIONINFOW*)&verInfo);

		if (verInfo.dwMajorVersion >= 6) {
			WCHAR contentLengthHeader[100] = {0};
			swprintf_s(contentLengthHeader, L"Content-Length: %I64d\r\n", contentLength);
      
			succ = WinHttpSendRequest(hRequest, 
									contentLengthHeader, 
									-1, 
									NULL, 
									0, 
									WINHTTP_IGNORE_REQUEST_TOTAL_LENGTH, 
									(DWORD_PTR)id);
		}
		else {
			// Cannot send requests > 2GB on OS older than Vista
			throw HException(L"WinHttpSendRequest", ERROR_INVALID_PARAMETER);
		}
	}
	else if (contentLength > 0) {
		succ = WinHttpSendRequest(hRequest, 
								WINHTTP_NO_ADDITIONAL_HEADERS, 0, 
								NULL, 0, (DWORD)contentLength, 
								(DWORD_PTR)id);
	}
	else if (contentLength < 0) {
		// Starting in Windows Vista and Windows Server 2008, WinHttp enables applications to 
		// perform chunked transfer encoding on data sent to the server. 
		OSVERSIONINFOEXW verInfo={0};
		verInfo.dwOSVersionInfoSize = sizeof(verInfo);
		::GetVersionExW((OSVERSIONINFOW*)&verInfo);

		if (verInfo.dwMajorVersion >= 6) {

			// Example: http://senthilvels.blogspot.de/2011/08/uploading-chunk-data-to-server-using.html

			LPCWSTR szTransferEncoding = L"Transfer-Encoding: chunked\r\n";

			succ = WinHttpSendRequest(hRequest, 
									szTransferEncoding, 
									-1, 
									NULL, 
									0, 
									WINHTTP_IGNORE_REQUEST_TOTAL_LENGTH, 
									(DWORD_PTR)id);
		}
		else {
			// Cannot send chunked data
			throw HException(L"WinHttpSendRequest", ERROR_INVALID_PARAMETER);
		}
	}
	else {
		// GET Request, no data to be sent
		succ = WinHttpSendRequest(hRequest, 
								WINHTTP_NO_ADDITIONAL_HEADERS, 0, 
								NULL, 0, 0, 
								(DWORD_PTR)id); 
	}

	if( !succ ) {
		DWORD err = GetLastError();
		throw HException(L"WinHttpSendRequest", err);
	}
}
*/