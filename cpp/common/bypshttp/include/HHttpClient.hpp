#ifndef HHTTPCLIENT_HPP_
#define HHTTPCLIENT_HPP_

#include "HHttpClient.h"

namespace com { namespace wilutions { namespace byps { namespace http {

using namespace com::wilutions::byps;

BINLINE HHttpClientParams::HHttpClientParams() 
	: flags(0)
	, sendTimeoutSeconds(0)
	, receiveTimeoutSeconds(0) 
{
}

BINLINE HHttpClientParams::HHttpClientParams(const std::wstring& url, int32_t flags, int32_t sendTimeoutSeconds, int32_t receiveTimeoutSeconds) 
	: url(url)
	, flags(flags)
	, sendTimeoutSeconds(sendTimeoutSeconds) 
	, receiveTimeoutSeconds(receiveTimeoutSeconds)
{
}



}}}}

#endif