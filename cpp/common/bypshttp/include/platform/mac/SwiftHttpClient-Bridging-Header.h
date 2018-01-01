//
//  SwiftHttpClient-Bridging-Header.h
//  bypslib
//
//  Created by Wolfgang Imig on 01.01.18.
//  Copyright © 2018 Wolfgang Imig. All rights reserved.
//

#ifndef SwiftHttpClient_Bridging_Header_h
#define SwiftHttpClient_Bridging_Header_h

#ifdef __cplusplus
extern "C" {
#endif
    
    struct _C_SwiftHttpClientFactory {
        void* pthis;
        void* (*create)(void*);
    };
    typedef struct _C_SwiftHttpClientFactory C_SwiftHttpClientFactory;
    
    struct _C_SwiftHttpClient {
        void* pthis;
        void (*init)();
    };
    
    void byps_http_setFactory(C_SwiftHttpClientFactory factory);

    typedef void*(*CreateHttpClientFunction)(void*);
    void byps_http_setFactory2(void* obj, void*(*funct)(void*));
    
#ifdef __cplusplus
}
#endif

#endif /* SwiftHttpClient_Bridging_Header_h */
