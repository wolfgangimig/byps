package byps.test;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import byps.BContentStream;
import byps.BContentStreamAsyncCallback;
import byps.BContentStreamWrapper;
import byps.BException;
import byps.BExceptionC;
import byps.BWire;
import byps.RemoteException;
import byps.http.HConstants;
import byps.test.api.BClient_Testser;
import byps.test.api.remote.RemoteStreams;

/**
 * Tests for interface functions with stream types. This test requires the
 * webapp bypstest-srv to be started.
 */
public class TestRemoteStreams {

  BClient_Testser client;
  RemoteStreams remote;
  private Log log = LogFactory.getLog(TestRemoteStreams.class);

  @Before
  public void setUp() throws RemoteException {
    client = TestUtilsHttp.createClient();
    remote = client.getRemoteStreams();
  }

  @After
  public void tearDown() throws InterruptedException {
    if (client != null) {
      client.done();
    }
  }

  /**
   * Send and receive a stream with content length information.
   * 
   * @throws InterruptedException
   * @throws IOException
   */
  @Test
  public void testRemoteStreamsOneStreamContentLength() throws InterruptedException, IOException {
    log.info("testRemoteStreamsOneStreamContentLength(");

    String str = "hello";
    InputStream istrm = new ByteArrayInputStream(str.getBytes());
    remote.setImage(istrm);

    InputStream istrmR = remote.getImage();
    ByteBuffer buf = BWire.bufferFromStream(istrmR);
    String strR = new String(buf.array(), buf.position(), buf.remaining());
    TestUtils.assertEquals(log, "stream", str, strR);

    remote.setImage(null);
    TestUtils.checkTempDirEmpty(client);

    log.info(")testRemoteStreamsOneStreamContentLength");
  }

  /**
   * Send and receive a stream without content length information
   * 
   * @throws InterruptedException
   * @throws IOException
   */
  @Test
  public void testRemoteStreamsOneStreamChunked() throws InterruptedException, IOException {
    log.info("testRemoteStreamsOneStreamChunked(");

    String str = "hello";
    final ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes());
    InputStream istrm = new BContentStream() {

      @Override
      public long getContentLength() {
        return -1L;
      }

      @Override
      public int read() throws IOException {
        return bis.read();
      }

    };

    remote.setImage(istrm);

    InputStream istrmR = remote.getImage();
    ByteBuffer buf = BWire.bufferFromStream(istrmR);
    String strR = new String(buf.array(), buf.position(), buf.remaining());
    TestUtils.assertEquals(log, "stream", str, strR);

    remote.setImage(null);
    TestUtils.checkTempDirEmpty(client);

    log.info(")testRemoteStreamsOneStreamChunked");
  }

  /**
   * Send and receive many streams.
   * 
   * @throws InterruptedException
   * @throws IOException
   */
  @Test
  public void testRemoteStreamsManyStreams() throws InterruptedException, IOException {
    log.info("testRemoteStreamsManyStreams(");
    int nbOfStreams = 10;

    for (int i = 0; i < 10; i++) {
      internalTestRemoteStreamsManyStreams(nbOfStreams);
    }

    log.info(")testRemoteStreamsManyStreams");
  }

  private void internalTestRemoteStreamsManyStreams(int nbOfStreams) throws InterruptedException, IOException {
    Map<Integer, InputStream> streams = new TreeMap<Integer, InputStream>();
    Map<Integer, byte[]> streamBytes = new TreeMap<Integer, byte[]>();
    for (int i = 0; i < nbOfStreams; i++) {

      byte[] bytes = new byte[1];
      ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
      streamBytes.put(i, bytes);

      InputStream istrm = new BContentStreamWrapper(bis, "application/octet-stream", bytes.length);

      streams.put(i, istrm);
    }
    remote.setImages(streams, -1);
    TreeMap<Integer, InputStream> istrmsR = remote.getImages();

    TestUtils.assertEquals(log, "streams", streams, istrmsR); // Does not
                                                              // compare
                                                              // streams.
    for (int i = 0; i < nbOfStreams; i++) {
      InputStream istrm = new ByteArrayInputStream(streamBytes.get(i));
      InputStream istrmR = istrmsR.get(i);
      TestUtils.assertEquals(log, "stream", istrm, istrmR);
      istrmR.close();
    }
  }

  /**
   * Wrapper class for ByteArrayInputStream. - helps to check that all streams
   * are closed after the request - helps to check that an Exception thrown in
   * read() is correctly handled.
   */
  private class MyInputStream extends BContentStream {

    private volatile boolean isClosed;
    boolean throwEx;
    boolean throwError;
    byte[] buf;
    int idx;

    /**
     * Constructor
     * 
     * @param buf
     *          Buffer to read from
     * @param throwEx
     *          true, if an IOException has to be thrown
     * @param throwError
     *          true, if an IllegalStateException has to be thrown
     */
    public MyInputStream(byte[] buf, boolean throwEx, boolean throwError) {
      this.buf = buf;
      this.throwEx = throwEx;
      this.throwError = throwError;
    }

    @Override
    public void close() throws IOException {
      isClosed = true;
      super.close();
    }

    @Override
    public int read() throws IOException {
      if (throwEx) {
        log.info("throw IOException");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        throw new IOException("Test Exception");
      }
      if (throwError) {
        log.info("throw IllegalStateException");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        throw new IllegalStateException("Test Error");
      }
      if (idx < buf.length) {
        return ((int) buf[idx++]) & 0xFF;
      }
      return -1;
    }

    @Override
    public String getContentType() {
      return null;
    }

    @Override
    public long getContentLength() {
      return buf.length;
    }
  }

  /**
   * All the input streams sent are closed by the transport layer. Streams not
   * requested from the server must be closed too.
   * 
   * @throws InterruptedException
   * @throws BException
   */
  @Test
  public void testRemoteStreamsCloseStreamAfterSend() throws RemoteException {
    log.info("testRemoteStreamsCloseStreamAfterSend(");
    int count = 10;

    for (int i = 0; i < count; i++) {
      internalTestRemoteStreamsClosed();

      String logLine = "testRemoteStreamsCloseStreamAfterSend-" + i;
      client.getTransport().getWire().getTestAdapter().printServerLog(logLine);
    }

    log.info(")testRemoteStreamsCloseStreamAfterSend");
  }

  protected void internalTestRemoteStreamsClosed() throws RemoteException {
    if (log.isDebugEnabled()) log.debug("internaltestRemoteStreamsClosed(");
    int nbOfStreams = 10;
    Map<Integer, InputStream> mystreams = new TreeMap<Integer, InputStream>();
    for (int i = 0; i < nbOfStreams; i++) {
      final String str = "" + i;
      byte[] buf = str.getBytes();
      MyInputStream mystrm = new MyInputStream(buf, false, false) {
        public String getContentType() {
          return "strm-" + str;
        }
      };
      mystreams.put(i, mystrm);
    }

    if (log.isDebugEnabled()) log.debug("setImages...");
    remote.setImages(mystreams, 1);
    if (log.isDebugEnabled()) log.debug("setImages OK");

    for (int i = 0; i < nbOfStreams; i++) {
      MyInputStream istrm = (MyInputStream) mystreams.get(i);
      TestUtils.assertEquals(log, "InputStream[" + i + "].isClosed, istrm=" + istrm, true, istrm.isClosed);
    }
    if (log.isDebugEnabled()) log.debug(")internaltestRemoteStreamsClosed");
  }

  /**
   * Handle an Exception thrown in InputStream.read correctly. The Exception
   * must be encapsulated in an BException. It must be passed to the caller. All
   * streams have to be closed. The server must have received an exception too.
   * This function tests the handling of an IOException and
   * IllegalStateException. All messages must have been finished after a while
   * when the client connection has been closed.
   * 
   * @throws InterruptedException
   * @throws IOException
   * @see MyInputStream
   */
  @Test
  public void testRemoteStreamsThrowExceptionOnRead() throws InterruptedException, IOException {
    log.info("testRemoteStreamsThrowExceptionOnRead(");

    for (int i = 0; i < 10; i++) {
      internalTestThrowExOnRead(true, false);
      internalTestThrowExOnRead(false, true);
    }

    client.getTransport().getWire().cancelAllRequests();

    try {
      // There should be no active messages on the server after the client side
      // has been finished.
      long[] messageIds = null;
      int keepMessageSeconds = ((int) HConstants.KEEP_MESSAGE_AFTER_FINISHED / 1000);
      int cleanupSeconds = (int) HConstants.CLEANUP_MILLIS / 1000;
      int waitUntilMessagesExpired = 2 * Math.max(cleanupSeconds, keepMessageSeconds) + 1;
      for (int retry = 0; retry < waitUntilMessagesExpired; retry++) {
        messageIds = client.getTransport().getWire().getTestAdapter().getAcitveMessagesOnServer(false);
        if (messageIds.length == 0) break;
        Thread.sleep(1000);
      }
      TestUtils.assertEquals(log, "active messages: ", new long[0], messageIds);
    } finally {
      client.done();
      client = null;
    }
    log.info(")testRemoteStreamsThrowExceptionOnRead");

  }

  private void internalTestThrowExOnRead(boolean throwEx, boolean throwError) throws InterruptedException, IOException {
    log.info("internalTestThrowExOnRead(throwEx=" + throwEx + ", throwError=" + throwError);

    Map<Integer, InputStream> streams = new TreeMap<Integer, InputStream>();
    for (int i = 0; i < 10; i++) {
      String str = "hello-" + i;
      byte[] buf = str.getBytes();
      InputStream istrm = new MyInputStream(buf, i == 1 && throwEx, i == 1 && throwError);
      streams.put(i, istrm);
      log.info("strm[" + i + "]=" + str);
    }

    // An exception is thrown in HWireClient.
    try {
      log.info("setImages...");
      remote.setImages(streams, -1);
      Assert.fail("Exception expected");
    } catch (BException e) {
      log.info("setImages ex=" + e + ", OK");

      // The exception is an IOERROR, if the exception thrown in the stream is
      // received first.
      // This exception cancels the message and it might happen, that we receive
      // the CANCELLED
      // exception from first.
      TestUtils.assertTrue(log, "Exception Code", e.code == BExceptionC.IOERROR || e.code == BExceptionC.CANCELLED);
    }

    // All streams must have been closed
    log.info("streams must be closed");
    int nbOfClosed = 0;
    int keepMessageSeconds = ((int) HConstants.KEEP_MESSAGE_AFTER_FINISHED / 1000) + 1;
    for (int retry = 0; retry < 10 * keepMessageSeconds; retry++) {
      for (int i = 0; i < streams.size(); i++) {
        MyInputStream istrm = (MyInputStream) streams.get(i);
        log.info("InputStream[" + i + "].isClosed=" + istrm.isClosed);
        if (istrm.isClosed) nbOfClosed++;
      }
      if (nbOfClosed == streams.size()) break;
      nbOfClosed = 0;
      Thread.sleep(100);
    }
    for (int i = 0; i < streams.size(); i++) {
      MyInputStream istrm = (MyInputStream) streams.get(i);
      TestUtils.assertEquals(log, "InputStream[" + i + "].isClosed, stream=" + istrm, true, istrm.isClosed);
    }

    log.info(")internalTestThrowExOnRead");
  }

  /**
   * Test for cloning streams inside the server. The server can read a stream as
   * long as the request (message with ByteBuffer) is not finished. If streams
   * have to be stored in member variables of the server objects, they have to
   * be cloned.
   * 
   * @throws InterruptedException
   * @throws IOException
   */
  @Test
  public void testRemoteStreamsCloneStream() throws InterruptedException, IOException {
    log.info("testRemoteStreamsCloneStream(");

    ArrayList<InputStream> streams = TestUtilsHttp.makeTestStreams();
    ArrayList<InputStream> streams2 = TestUtilsHttp.makeTestStreams();
    for (int i = 0; i < streams.size(); i++) {
      internalTestCloneStream(streams.get(i), streams2.get(i));
    }

    log.info(")testRemoteStreamsCloneStream");
  }

  protected void internalTestCloneStream(InputStream istrm, InputStream istrm2) throws BException, InterruptedException, IOException {

    log.info("internalTestCloneStream(" + istrm);
    
    // setImage clones the stream for reuse
    remote.setImage(istrm);

    log.info("start download");
    InputStream istrmR = remote.getImage();

    log.info("compare streams");
    TestUtils.assertEquals(log, "stream", istrm2, istrmR);

    remote.setImage(null);
    TestUtils.checkTempDirEmpty(client);

    log.info(")internalTestCloneStream");
  }

  /**
   * Check receiving streams asynchronously.
   * @throws IOException 
   * 
   */
  @Test
  public void testRemoteStreamsAsyncCallback() throws IOException {
    log.info("testRemoteStreamsAsyncCallback(");
    
    final String text = "abcdef";
    final CountDownLatch waitForFinished= new CountDownLatch(4);

    remote.setImage(new ByteArrayInputStream(text.getBytes()));

    log.info("start download");
    InputStream istrmR = remote.getImage();
    BContentStream.assignAsyncCallback(istrmR, new BContentStreamAsyncCallback() {

      @Override
      public boolean onReceivedData(byte[] buf, int len) {
        TestUtils.assertEquals(log, "stream content", text, new String(buf, 0, len));
        waitForFinished.countDown();
        return true;
      }

      @Override
      public void onReceivedContentLength(long contentLength) {
        TestUtils.assertEquals(log, "stream length", text.length(), (int)contentLength);
        waitForFinished.countDown();
      }

      @Override
      public void onReceivedContentType(String contentType) {
        TestUtils.assertEquals(log, "stream content type", "application/octet-stream", contentType);
        waitForFinished.countDown();
      }

      @Override
      public void onReceivedException(Throwable ex) {
        TestUtils.fail(log, "Exception " + ex);
      }

      @Override
      public void onFinished() {
        waitForFinished.countDown();
      }

    });

    try {
      waitForFinished.await(10, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
    }
    
    TestUtils.assertTrue(log, "Timeout", waitForFinished.getCount() == 0);
    
    log.info(")testRemoteStreamsAsyncCallback");
  }
}
