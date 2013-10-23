#ifndef WINHTTPCLIENT_H_
#define WINHTTPCLIENT_H_


#include "Byps.h"
#include "Bypshttp.h"

namespace byps { namespace http { 

PHttpClient HttpClient_create(void* app);

}}



#endif
