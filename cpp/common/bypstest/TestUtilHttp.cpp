/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

#include "TestUtilHttp.h"
#include <string.h>
#include <algorithm>
#undef min

static std::wstring url = L"http://localhost:6080/bypstest-srv/bypsservlet";
//static std::wstring url = L"http://localhost:5080/bypstest-srv/bypsservlet";

using namespace byps;
using namespace byps::http;
using namespace byps::test::api;

PClient_Testser TestUtilHttp::createClient(void* app) {
	PApiDescriptor apiDesc = BApiDescriptor_Testser::instance();

    PWire wire(HWireClient::create(app, url, 0, 60, PThreadPool()));

    PTransportFactory transportFactory(new HTransportFactoryClient(apiDesc, wire, 1));

	PClient_Testser client = BClient_Testser::createClient(transportFactory);

	client->start();
	
	return client;
}

class MyContentStreamBytes : public BContentStream {
	int64_t nbOfBytes;
	int64_t pos;
	bool chunked;
	int v;
public:
    MyContentStreamBytes(int64_t nbOfBytes, bool chunked) : nbOfBytes(nbOfBytes), pos(0), chunked(chunked) {
		std::wstringstream wss;
		wss << L"application/byps-" << (nbOfBytes%3);
		contentType = wss.str();
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
	while ((lenR = strm->read(bufR, 0, sizeof(bufR))) != -1) {
		com::wilutions::test::tassert(file, line, msg + L" read lenR != 0", true, lenR != 0);
		int32_t offs = 0;
		while ((len = strmR->read(buf, offs, lenR - offs)) != -1) {
			com::wilutions::test::tassert(file, line, msg + L" read len != 0", true, len != 0);
			if (len + offs == lenR) break;
			offs += len;
		}

		if (memcmp(buf, bufR, len)) {
			com::wilutions::test::tassert(file, line, msg + L".content-diff", 0, 1);
		}
	}

	if (strmR->getContentLength() != 0) {
		com::wilutions::test::tassert(file, line, msg + L".contentType", strm->getContentType(), strmR->getContentType());
	}
}
