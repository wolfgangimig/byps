/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#ifndef HHTTPCLIENT_H_
#define HHTTPCLIENT_H_

#include "Byps.h"
#include "Bypshttp.h"

namespace byps { namespace http {

using namespace byps;

class HHttpClient;
typedef byps_ptr<HHttpClient> PHttpClient;
class HHttpRequest;
typedef byps_ptr<HHttpRequest> PHttpRequest;
class HHttpGet;
typedef byps_ptr<HHttpGet> PHttpGet;
class HHttpGetStream;
typedef byps_ptr<HHttpGetStream> PHttpGetStream;
class HHttpPost;
typedef byps_ptr<HHttpPost> PHttpPost;
class HHttpPutStream;
typedef byps_ptr<HHttpPutStream> PHttpPutStream;
class HHttpCredentials;
typedef byps_ptr<HHttpCredentials> PHttpCredentials;

class HHttpRequest {
public:
	virtual ~HHttpRequest() {}

	virtual void setTimeouts(int32_t connectTimeoutSeconds, int32_t sendrecvTimeoutSeconds) = 0;
	virtual void close() = 0;

};

class HHttpGetStream : public virtual HHttpRequest {
public:
	virtual ~HHttpGetStream() {}

	virtual PContentStream send() = 0;
};

class HHttpGet : public virtual HHttpRequest {
public:
	virtual ~HHttpGet() {}

	virtual void send(PAsyncResult asyncBytesReceived) = 0; // Negotiate
};

class HHttpPost : public virtual  HHttpRequest {
public:
	virtual ~HHttpPost() {}

	virtual void send(PBytes bytes, const std::wstring& contentType, PAsyncResult asyncBytesReceived) = 0;
};

class HHttpPutStream : public virtual HHttpRequest {
public:
	virtual ~HHttpPutStream() {}

	virtual void send(PContentStream strm, PAsyncResult asyncBoolFinished) = 0;
};

class HHttpCredentials {
public:
	std::wstring name;
	std::wstring pwd;
	std::wstring nameProxy;
	std::wstring pwdProxy;
};

class HHttpClient {
public:
	virtual ~HHttpClient() {}
	
	virtual void init(const std::wstring& url, PHttpCredentials creds = PHttpCredentials()) = 0;
    virtual void done() = 0;

	virtual PHttpGet get(const std::wstring& url) = 0;
	virtual PHttpGetStream getStream(const std::wstring& url) = 0;
	virtual PHttpPost post(const std::wstring& url) = 0;
	virtual PHttpPutStream putStream(const std::wstring& url) = 0;

};

}}

#endif
