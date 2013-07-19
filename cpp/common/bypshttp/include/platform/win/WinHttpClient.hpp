#ifndef WINHTTPCLIENT_HPP_
#define WINHTTPCLIENT_HPP_

//
// s. WinHttpClient.h
//
//#include "WinHttpClient.h"
//
//namespace com { namespace wilutions { namespace byps { namespace http { namespace winhttp {
//
//using namespace com::wilutions::byps;
//using namespace com::wilutions::byps::http;
//
//class WinHttpClient : public HHttpClient {
//
//	std::wstring urlPath;
//	DWORD urlFlags;
//	HINTERNET hSession;
//	HINTERNET hConnection;
//
//public:
//	WinHttpClient() 
//		: urlFlags(0) 
//		, hSession(NULL)
//		, hConnection(NULL)
//	{
//	}
//
//	virtual ~WinHttpClient() {
//	}
//
//	virtual void init(HHttpClientParams& params) {
//
//		const std::wstring url = params.url;
//
//		hSession = WinHttpOpen(L"BYPSWINHTTP", 
//						WINHTTP_ACCESS_TYPE_DEFAULT_PROXY,
//						WINHTTP_NO_PROXY_NAME, 
//						WINHTTP_NO_PROXY_BYPASS, 
//						WINHTTP_FLAG_ASYNC);
//		if (!hSession) {
//			DWORD err = GetLastError();
//			throw HException(L"WinHttpOpen", err);
//		}
//
//		WCHAR szHost[256]={0};
//		URL_COMPONENTS UrlComps = {0};
//		UrlComps.dwStructSize = sizeof(UrlComps);
//		UrlComps.dwSchemeLength    = -1;
//		UrlComps.lpszHostName = szHost;
//		UrlComps.dwHostNameLength  = ARRAYSIZE(szHost)-1;
//		UrlComps.dwUrlPathLength   = -1;
//		UrlComps.dwExtraInfoLength = -1;
//
//		BOOL succ = WinHttpCrackUrl(
//								url.c_str(), 
//								(DWORD)url.size(), 
//								0, 
//								&UrlComps);
//		if (!succ) {
//			DWORD err = GetLastError();
//			throw HException(L"WinHttpCrackUrl", err);
//		}
//
//		hConnection = WinHttpConnect(
//								hSession, 
//								szHost, 
//								UrlComps.nPort, 
//								0);
//		if (!hConnection) {
//			DWORD err = GetLastError();
//			throw HException(L"WinHttpConnect", err);
//		}
//
//		urlPath = UrlComps.lpszUrlPath;
//		urlFlags = (INTERNET_SCHEME_HTTPS == UrlComps.nScheme) ? WINHTTP_FLAG_SECURE : 0;
//
//	}
//	
//	virtual void done() {
//		if (hConnection) {
//			WinHttpCloseHandle(hConnection);
//			hConnection = NULL;
//		}
//		if (hSession) {
//			WinHttpCloseHandle(hSession);
//			hConnection = NULL;
//		}
//	}
//
//	virtual PContentStream get(const HHttpClientParams& params) {
//		return PContentStream();
//	}
//
//	virtual void post(const HHttpClientParams& params, PBytes bytes, PAsyncResult asyncBytesReceived) {
//	}
//
//	virtual void put(const HHttpClientParams& params, PContentStream stream, PAsyncResult asyncBoolFinished) {
//	}
//
//};
//
//
//BINLINE PHttpClient WinHttpClient_create() {
//	return PHttpClient(new WinHttpClient());
//}
//
//
//}}}}}
//




#endif