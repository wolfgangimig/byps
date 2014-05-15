/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
#include "AllTests.h"
#include <stdio.h>
#include <thread>
#include "AllTests.h"

using namespace byps;
using namespace com::wilutions::test;

using namespace byps::test::api;
using namespace byps::test::api::strm;
using namespace byps::test::api::remote;

#ifdef _MSC_VER
#pragma warning( disable : 4996 ) 
#endif

const int64_t INCOMING_STREAM_BUFFER = 1000 * 1000;

class TestRemoteStreams : public TestBase {
  static BLogger log;

public:
  TestRemoteStreams(void* app) : TestBase(app) {}

  /**
  * Use class BContentStreamFile to transfer a stream.
  */
  void testRemoteStreamsOneFileStream() {
    l_info << L"testRemoteStreamsOneFileStream(";

    std::string fileContent = "hello";

    BFile file = BFile::createTempFile(L"byps", L".txt");
    byps_ptr<ofstream> fos = file.openWrite();
    (*fos) << fileContent;
    fos->close();

    PContentStream strm(new BContentStreamWrapper(file));

    PRemoteStreams remote = client->getRemoteStreams();
    l_info << L"remote->setImage ...";
    remote->setImage(strm);
    l_info << L"remote->setImage OK";

    strm.reset();
    file.delet();

    l_info << L"remote->getImage ...";
    PContentStream strmR = remote->getImage();
    l_info << L"remote->getImage OK";

    //TASSERT(L"Content-Type", "text/plain", strmR->getContentType()); // there is currently no Content-Type detection in BContentStreamFile

    l_info << L"getContentLength ...";
    int64_t contentLengthR = strmR->getContentLength();
    l_info << L"getContentLength OK, #=" << contentLengthR;
    TASSERT(L"wrong content length", fileContent.size(), (size_t)contentLengthR);

    TASSERT(L"FileName", file.getName(), strmR->getFileName());

    l_info << L"read ...";
    char buf[1000] = {0};
    int32_t len = strmR->read(buf, 0, sizeof(buf));
    l_info << L"read OK, len=" << len;

    TASSERT(L"wrong stream content", fileContent, std::string(buf));
    TASSERT(L"FileName", file.getName(), strmR->getFileName());
    TASSERT(L"wrong content length", fileContent.size(), (size_t)strmR->getContentLength());

    l_info << L")testRemoteStreamsOneFileStream";
  }

  /**
  * Generates a stream with the given number of bytes.
  * The stream is transmitted with chunked encoding or with content length. 
  */
  class MyContentStreamBytes : public BContentStream {
    int64_t nbOfBytes;
    bool chunked;
    volatile int64_t pos;
  public:
    MyContentStreamBytes(int64_t nbOfBytes, bool chunked)
      : nbOfBytes(nbOfBytes)
      , chunked(chunked)
      , pos(0) {

        contentType = L"application/octet-byps-1";
    }

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
    PRemoteStreams remote = client->getRemoteStreams();
    l_info << L"remote->setImage...";
    remote->setImage(strm);
    l_info << L"remote->setImage OK";

    bool checkContent = true;
    if (checkContent) {

      // read stream and compare bytes
      l_info << L"remote->getImage...";
      PContentStream strmR = remote->getImage();
      l_info << L"remote->getImage OK";

      checkStreamContent(strm, strmR);


      strmR.reset();

    }

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
    internalTestStreams(2*INCOMING_STREAM_BUFFER, false);
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
    PRemoteStreams remote = client->getRemoteStreams();
    l_info << L"remote->setImage...";
    remote->setImage(strm, [this, remote, nbOfBytes, &testResult](bool, BException ex) {

      if (ex) {
        testResult.bex = ex;
        return;
      }

      l_info << L"remote->setImage OK";

      // read stream and compare bytes
      l_info << L"remote->getImage...";
      remote->getImage([this, nbOfBytes, &testResult](PContentStream strmR, BException ex) {

        l_info << L"remote->getImage OK";

        if (ex) {
          l_info << L"exception=" << ex.toString();
          byps_unique_lock lock(testResult.mutex);
          testResult.bex = ex;
        }
        else {
          try {
            l_info << L"read bytes...";
            PContentStream strm(new MyContentStreamBytes(nbOfBytes, false));
            checkStreamContent(strm, strmR);
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
        {
          byps_unique_lock lock(testResult.mutex);
          testResult.done = true;
          testResult.finished.notify_all();
        }
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

  class BContentStreamWrapperFailOpen : public BContentStreamWrapper
  {
    PContentStream strmFromServer;
  public:
    BContentStreamWrapperFailOpen(PContentStream strmFromServer) 
      : BContentStreamWrapper(PStream()) {
      copyProperties(strmFromServer);
    }
    virtual int32_t read(char* buf, int32_t offs, int32_t len) {
      throw BException(BExceptionC::IOERROR, L"Stream should be passed without beeing read.");
    }

  };

  void testHandOverStream() {
    l_info << L"testHandOverStream(";

    int64_t nbOfBytes = 123;
    PContentStream strm(new MyContentStreamBytes(nbOfBytes, false));

    // send stream
    PRemoteStreams remote = client->getRemoteStreams();
    l_info << L"remote->setImage...";
    remote->setImage(strm);

    // Get from server and hand over to server
    PContentStream streamFromServer = remote->getImage();
    PContentStream streamFailOpen(new BContentStreamWrapperFailOpen(streamFromServer));
    remote->setImage(streamFailOpen);

    for (int j = 0; j < 2; j++) {
      PContentStream strm(new MyContentStreamBytes(nbOfBytes, false));
      PContentStream strmR = remote->getImage();
      checkStreamContent(strm, strmR);
    }

    l_info << L")testHandOverStream";
  }

  int64_t checkStreamContent(PContentStream strm, PContentStream strmR) {
    l_info << L"checkStreamContent(";
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

    int64_t nbOfBytes = strm->getContentLength();
    if (nbOfBytes != -1) {
      TASSERT(L"#bytes", nbOfBytes, pos);
      TASSERT(L"contentLength", nbOfBytes, strmR->getContentLength());
    }

    wstring csR = strmR->getContentType();
    TASSERT(L"contentType", strm->getContentType(), csR);

    l_info << L")checkStreamContent=" << pos;
    return pos;
  }

  virtual void init() {
    ADD_TEST(testHandOverStream);
    ADD_TEST(testRemoteStreamsOneFileStream);
    ADD_TEST(testRemoteStreamsContentLength);
    ADD_TEST(testRemoteStreamsChunked);
    ADD_TEST(testRemoteStreamAsync);

#ifdef TEST_LARGE_STREAMS
    ADD_TEST(testRemoteStream4GBChunked);
    ADD_TEST(testRemoteStream4GBContentLength);
#endif

  }
};

BLogger TestRemoteStreams::log(typeid(TestRemoteStreams).name());

TestCase* TestRemoteStreams_create(void* app) {
  return new TestRemoteStreams(app);
}
