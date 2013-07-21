#ifndef HHTTPCLIENT_H_
#define HHTTPCLIENT_H_

#include "Byps.h"
#include "Bypshttp.h"

namespace com { namespace wilutions { namespace byps { namespace http {

using namespace com::wilutions::byps;

class HHttpClient;
typedef byps_ptr<HHttpClient> PHttpClient;
class HHttpRequest;
typedef byps_ptr<HHttpRequest> PHttpRequest;
class HHttpGet;
typedef byps_ptr<HHttpGet> PHttpGet;
class HHttpPost;
typedef byps_ptr<HHttpPost> PHttpPost;
class HHttpPut;
typedef byps_ptr<HHttpPut> PHttpPut;

class HHttpRequest {
public:
	~HHttpRequest() {}

	virtual void setTimeouts(int32_t connectTimeoutSeconds, int32_t sendrecvTimeoutSeconds) = 0;
	virtual void close() = 0;

};

class HHttpGet : public virtual HHttpRequest {
public:
	~HHttpGet() {}

	virtual PContentStream send() = 0;
};

class HHttpPost : public virtual  HHttpRequest {
public:
	~HHttpPost() {}

	virtual void send(PBytes bytes, const std::wstring& contentType, PAsyncResult asyncBytesReceived) = 0;
};

class HHttpPut : public virtual HHttpRequest {
public:
	~HHttpPut() {}

	virtual void send(PContentStream strm, PAsyncResult asyncBoolFinished) = 0;
};

class HHttpClient {
public:
	virtual ~HHttpClient() {}
	
	virtual void init(const std::wstring& url) = 0;

	virtual PHttpGet get(const std::wstring& url) = 0;
	virtual PHttpPost post(const std::wstring& url) = 0;
	virtual PHttpPut put(const std::wstring& url) = 0;

};

}}}}

#endif
