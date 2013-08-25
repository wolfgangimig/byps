
#include "TestUtilHttp.h"
#include <string.h>

#undef min

static std::wstring url = L"http://192.168.0.178:8080/bypstest-srv/bypsservlet";

using namespace com::wilutions::byps;
using namespace com::wilutions::byps::http;
using namespace com::wilutions::byps::test::api;

PClient_Testser TestUtilHttp::createClient(void* app) {
	PApiDescriptor apiDesc = BApiDescriptor_Testser::instance();

	PWire wire(HWireClient::create(app, url, 0, 600, PThreadPool()));

    PTransportFactory transportFactory(new HTransportFactoryClient(apiDesc, wire, 2));

	PClient_Testser client = BClient_Testser::createClient(transportFactory);

	client->start();
	
	return client;
}

class MyContentStreamBytes : public BContentStream {
	int64_t nbOfBytes;
	std::wstring contentType;
	int64_t pos;
	bool chunked;
	int v;
public:
    MyContentStreamBytes(int64_t nbOfBytes, bool chunked) : nbOfBytes(nbOfBytes), pos(0), chunked(chunked) {
		std::wstringstream wss;
		wss << L"application/byps-" << (nbOfBytes%3);
		contentType = wss.str();
	}
	
	virtual const std::wstring& getContentType() const { 
		return contentType;
	}
	
	virtual int64_t getContentLength() const { 
		return chunked ? -1 : nbOfBytes; 
	}

	virtual int32_t read(char* buf, int32_t offs, int32_t len) {
		if (pos == nbOfBytes) {
			return -1;
		}
		else {
			len = (int32_t)std::min(nbOfBytes - pos, (int64_t)len);
			for (int32_t i = 0; i < len; i++) {
				buf[offs + i] = (char)(pos++ & 0xFF);
			}
			return len;
		}
	}
};

const int INCOMING_STREAM_BUFFER = 1000 * 1000;
	
byps_ptr<std::vector<PContentStream> > TestUtilHttp::makeTestStreams() {
	byps_ptr<std::vector<PContentStream> > ret(new std::vector<PContentStream>());
	ret->push_back(PContentStream(new MyContentStreamBytes(0, false)));
	ret->push_back(PContentStream(new MyContentStreamBytes(1, false)));
	ret->push_back(PContentStream(new MyContentStreamBytes(INCOMING_STREAM_BUFFER-1, false)));
	ret->push_back(PContentStream(new MyContentStreamBytes(INCOMING_STREAM_BUFFER, false)));
	ret->push_back(PContentStream(new MyContentStreamBytes(INCOMING_STREAM_BUFFER+1, false)));
	ret->push_back(PContentStream(new MyContentStreamBytes(INCOMING_STREAM_BUFFER*2, false)));

#ifdef TEST_LARGE_STREAMS
	ret->push_back(PContentStream(new MyContentStreamBytes(0x100000000, false)));
#endif

	return ret;
}


void TestUtilHttp::tassert(const char* file, int line, const std::wstring& msg, 
			 PContentStream strm,
			 PContentStream strmR)
{
	com::wilutions::test::tassert(file, line, msg + L".contentLength", strm->getContentLength(), strmR->getContentLength());

	char buf[2345], bufR[2345];
	int32_t len = 0, lenR;
	while ((len = strm->read(buf, 0, sizeof(buf))) != -1) {
		com::wilutions::test::tassert(file, line, msg + L" read len != 0", true, len != 0);
		int32_t offsR = 0;
		while ((lenR = strmR->read(bufR, offsR, len - offsR)) != -1) {
			com::wilutions::test::tassert(file, line, msg + L" read lenR != 0", true, lenR != 0);
			if (lenR + offsR == len) break;
			offsR += lenR;
		}

		if (memcmp(buf, bufR, len)) {
			com::wilutions::test::tassert(file, line, msg + L".content-diff", 0, 1);
		}
	}

	if (strmR->getContentLength() != 0) {
		com::wilutions::test::tassert(file, line, msg + L".contentType", strm->getContentType(), strmR->getContentType());
	}
}
