#include "AllTests.h"
#include <stdio.h>
#include <thread>
#include "AllTests.h"

using namespace com::wilutions::byps;
using namespace com::wilutions::test;

using namespace com::wilutions::byps::test::api;
using namespace com::wilutions::byps::test::api::strm;
using namespace com::wilutions::byps::test::api::remote;

#ifdef _MSC_VER
#pragma warning( disable : 4996 ) 
#endif

const int64_t INCOMING_STREAM_BUFFER = 1000 * 1000;

class TestRemoteStreams : public TestBase {
	static BLogger log;

public:

	/**
	 * Use class BContentStreamFile to transfer a stream.
	 */
	void testRemoteStreamsOneFileStream() {
		l_info << L"testRemoteStreamsOneFileStream(";

		char fname[L_tmpnam] = {0};
		tmpnam(fname);
		FILE *file = fopen(fname, "w");
		fputs("hello", file);
		fclose(file);
		
        PContentStream strm(new BContentStreamFile(fname));

		std::remove(fname);

		PRemoteStreams remote = client->remoteStreams;
		l_info << L"remote->setImage ...";
		remote->setImage(strm);
		l_info << L"remote->setImage OK";

		l_info << L"remote->getImage ...";
		PContentStream strmR = remote->getImage();
		char buf[1000] = {0};
		int32_t len = strmR->read(buf, 0, sizeof(buf));
        l_info << L"remote->getImage OK, len=" << len;

		TASSERT(L"wrong stream content", std::string("hello"), std::string(buf));

		l_info << L")testRemoteStreamsOneFileStream";
	}

	/**
	 * Generates a stream with the given number of bytes.
	 * The stream is transmitted with chunked encoding or with content length. 
	 */
	class MyContentStreamBytes : public BContentStream {
		int64_t nbOfBytes;
		bool chunked;
		std::wstring contentType;
		volatile int64_t pos;
	public:
		MyContentStreamBytes(int64_t nbOfBytes, bool chunked) : nbOfBytes(nbOfBytes), chunked(chunked), contentType(L"application/octet-stream"), pos(0) {}
		virtual const std::wstring& getContentType() const { return contentType; }
		virtual int64_t getContentLength() const { return chunked ? -1 : nbOfBytes; }
		virtual int32_t read(char* buf, int32_t offs, int32_t len) {
			int64_t p = pos;
			if (p >= nbOfBytes) return -1;
			if (p + len > nbOfBytes) len = (int32_t)(nbOfBytes - p);
			for (int32_t i = 0; i < len; i++) {
				buf[offs + i] = p & 0xFF;
				p++;
			}
			pos += len;
			return len;
		}
	};

	/**
	 * This helper function sends a stream with the given number of bytes.
	 * After the stream is sent, it is read back and compared.
	 * @param nbOfBytes Stream length
	 * @param chunked If true, the stream is sent with chunked encoding. If false, the HTTP request is sent with the Content-Length header.
	 */
	void internalTestStreams(int64_t nbOfBytes, bool chunked) {
		l_info << L"internalTestStreams(chunked=" << chunked << L", nbOfBytes=" << nbOfBytes;
		PContentStream strm(new MyContentStreamBytes(nbOfBytes, chunked));

		// send stream
		PRemoteStreams remote = client->remoteStreams;
		l_info << L"remote->setImage...";
		remote->setImage(strm);
		strm.reset();
		l_info << L"remote->setImage OK";

		// read stream and compare bytes
		l_info << L"remote->getImage...";
		PContentStream strmR = remote->getImage();
		l_info << L"remote->getImage OK";

		l_info << L"read bytes...";
		char buf[10000] = {0};
		int64_t pos = 0;
		int32_t len  = 0;
		while ((len = strmR->read(buf, 0, sizeof(buf))) > 0) {
			for (int32_t i = 0; i < len; i++) {
				unsigned b1 = (unsigned)(pos & 0xFF);
				unsigned b2 = (unsigned)(buf[i] & 0xFF);
				if (b1 != b2) {
					std::wstringstream msg;
					msg << L"Wrong byte at pos=" << pos;
					TASSERT(msg.str(), b1, b2);
				}
				pos++;
			}
		}
		l_info << L"read bytes OK";

		TASSERT(L"#bytes", nbOfBytes, pos);
		
		strmR.reset();

		l_info << L")internalTestStreams";
	}

	/**
	 * Send streams of different sizes with chunked encoding.
	 */
	void testRemoteStreamsChunked() {
		l_info << L"testRemoteStreamsChunked(";
		internalTestStreams(INCOMING_STREAM_BUFFER - 1, true);
		internalTestStreams(INCOMING_STREAM_BUFFER, true);
		internalTestStreams(INCOMING_STREAM_BUFFER + 1, true);
		internalTestStreams(2 * INCOMING_STREAM_BUFFER, true);
		internalTestStreams(0, true);
		internalTestStreams(1, true);
		l_info << L")testRemoteStreamsChunked";
	}

	/**
	 * Send a stream of 4GB with chunked encoding.
	 */
	void testRemoteStream4GBChunked() {
		l_info << L"testRemoteStream4GBChunked(";
		internalTestStreams(0x100000000, true);
		l_info << L")testRemoteStream4GBChunked";
	}

	/**
	 * Send streams of different sizes with Content-Length header.
	 */
	void testRemoteStreamsContentLength() {
		l_info << L"testRemoteStreamsContentLength(";
		internalTestStreams(INCOMING_STREAM_BUFFER - 1, false);
		internalTestStreams(INCOMING_STREAM_BUFFER, false);
		internalTestStreams(INCOMING_STREAM_BUFFER + 1, false);
		internalTestStreams(2 * INCOMING_STREAM_BUFFER, false);
		internalTestStreams(0, false);
		internalTestStreams(1, false);
		l_info << L")testRemoteStreamsContentLength";
	}

	/**
	 * Send a stream of 4GB with Content-Length header.
	 */
	void testRemoteStream4GBContentLength() {
		l_info << L"testRemoteStream4GBContentLength(";
		internalTestStreams(0x100000000, false);
		l_info << L")testRemoteStream4GBContentLength";
	}


	struct TestAsyncResult {
		BException bex;
		AssertException aex;
		bool done;
		byps_mutex mutex;
		byps_condition_variable finished;
		TestAsyncResult() : done(false) {}
	};


	/**
	 * Test send/receive stream asynchronously.
	 */
	void testRemoteStreamAsync() {
		l_info << L"testRemoteStreamsAsync";

		int64_t nbOfBytes = 123456;
		PContentStream strm(new MyContentStreamBytes(nbOfBytes, false));

		TestAsyncResult testResult;

		// send stream
		PRemoteStreams remote = client->remoteStreams;
		l_info << L"remote->async_setImage...";
		remote->async_setImage(strm, [this, remote, nbOfBytes, &testResult](bool, BException ex) {
	
			l_info << L"remote->async_setImage OK";

			// read stream and compare bytes
			l_info << L"remote->async_getImage...";
			remote->async_getImage([this, nbOfBytes, &testResult](PContentStream strmR, BException ex) {

				l_info << L"remote->async_getImage OK";

				if (ex) {
					l_info << L"exception=" << ex.toString();
					byps_unique_lock lock(testResult.mutex);
					testResult.bex = ex;
				}
				else {
					try {
						l_info << L"read bytes...";
						char buf[10000] = {0};
						int64_t pos = 0;
						int32_t len  = 0;
						while ((len = strmR->read(buf, 0, sizeof(buf))) > 0) {
							for (int32_t i = 0; i < len; i++) {
								unsigned b1 = (unsigned)(pos & 0xFF);
								unsigned b2 = (unsigned)(buf[i] & 0xFF);
								if (b1 != b2) {
									std::wstringstream msg;
									msg << L"Wrong byte at pos=" << pos;
									TASSERT(msg.str(), b1, b2);
								}
								pos++;
							}
						}
						l_info << L"read bytes OK";
			
						TASSERT(L"#bytes", nbOfBytes, pos);
					}
					catch (const AssertException& e) {
						byps_unique_lock lock(testResult.mutex);
						testResult.aex = e;
					}
					catch (const BException& e) {
						byps_unique_lock lock(testResult.mutex);
						testResult.bex = e;
					}
				}

				l_info << L"finished checking result";

				// Notify waiting thread at (1)
				byps_unique_lock lock(testResult.mutex);
				testResult.done = true;
				testResult.finished.notify_all();

			});

		});

		// (1) Wait until asynchronous calls and tests have finished
		{
			l_info << L"wait for test result";

			std::chrono::duration<int,std::milli> timeout(100 * 1000);
			byps_unique_lock lock(testResult.mutex);
			testResult.finished.wait_for(lock, timeout, [&testResult]() { return testResult.done; });
			if (testResult.aex) {
				throw testResult.aex;
			}
			else if (testResult.bex) {
				throw AssertException(__FILE__, __LINE__, testResult.bex.toString());
			}
		}
		l_info << L")testRemoteStreamsAsync";
	}

	virtual void init() {
		ADD_TEST(testRemoteStreamsOneFileStream);
		ADD_TEST(testRemoteStreamAsync);
		ADD_TEST(testRemoteStreamsChunked);
		ADD_TEST(testRemoteStreamsContentLength);

#ifdef TEST_LARGE_STREAMS
		ADD_TEST(testRemoteStream4GBChunked);
		ADD_TEST(testRemoteStream4GBContentLength);
#endif

	}
};

BLogger TestRemoteStreams::log(typeid(TestRemoteStreams).name());

TestCase* TestRemoteStreams_create() {
	return new TestRemoteStreams();
}
