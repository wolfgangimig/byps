#ifndef HHTTPCLIENT_H_
#define HHTTPCLIENT_H_

#include "Byps.h"
#include "Bypshttp.h"

namespace com { namespace wilutions { namespace byps { namespace http {

using namespace com::wilutions::byps;

class HHttpClient;
typedef byps_ptr<HHttpClient> PHttpClient;

struct HHttpClientParams {
	std::wstring url;
	int32_t flags;
	int32_t sendTimeoutSeconds;
	int32_t receiveTimeoutSeconds;
	HHttpClientParams();
	HHttpClientParams(const std::wstring& url, int32_t flags, int32_t sendTimeoutSeconds, int32_t receiveTimeoutSeconds);
};

class HHttpClient {
public:
	virtual ~HHttpClient() {}
	
	virtual void init(HHttpClientParams& params) = 0;
	virtual void done() = 0;

	virtual PContentStream get(const HHttpClientParams& params) = 0;
	virtual void post(const HHttpClientParams& params, PBytes bytes, PAsyncResult asyncBytesReceived) = 0;
	virtual void put(const HHttpClientParams& params, PContentStream stream, PAsyncResult asyncBoolFinished) = 0;

};

}}}}

#endif
