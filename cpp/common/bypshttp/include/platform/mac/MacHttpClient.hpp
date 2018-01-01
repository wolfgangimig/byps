#include "MacHttpClient.h"
#include "SwiftHttpClient-Bridging-Header.h"



class SwiftHttpClientFactory {
public:
    void* pthis;
    CreateHttpClientFunction func;
    void* invoke() {
        return func(pthis);
    }
};
static SwiftHttpClientFactory g_factory2;

static C_SwiftHttpClientFactory g_factory;


namespace byps { namespace http {
    
    PHttpClient HttpClient_create(void* app) {
        void* swiftHttpClient = g_factory.create(g_factory.pthis);
        
        return PHttpClient();
    }
    
}}

extern "C" {
    
    void byps_http_setFactory2(void* obj, CreateHttpClientFunction func) {
        g_factory2.pthis = obj;
        g_factory2.func = func;
    }

    void byps_http_setFactory(C_SwiftHttpClientFactory factory) {
        g_factory = factory;
    }
}

