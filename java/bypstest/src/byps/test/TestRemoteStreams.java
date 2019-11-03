package byps.test;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

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
import junit.framework.Assert;

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
   * Send file stream.
   * A file stream has the fileName property set.
   * @throws InterruptedException
   * @throws IOException
   */
  @Test
  public void testRemoteStreamsFileStream() throws InterruptedException, IOException {
    log.info("testRemoteStreamsFileStream(");
    
    File file = File.createTempFile("byps ä € ß", ".txt");
    String str = "hello";
    
    FileOutputStream fos = null;
    try {
      fos = new FileOutputStream(file);
      fos.write(str.getBytes());
    }
    finally {
      if (fos != null) fos.close();
    }
    
    // setImage
    {
      InputStream istrm = new BContentStreamWrapper(file);
      long startTime = System.currentTimeMillis();
      log.info("setImage...");
      remote.setImage(istrm);
      long endTime = System.currentTimeMillis();
      log.info("setImage OK " + (endTime-startTime) + "ms");
    }

    // getImage
    BContentStream istrmR = null;
    {
      long startTime = System.currentTimeMillis();
      log.info("getImage...");
      istrmR = (BContentStream)remote.getImage();
      long endTime = System.currentTimeMillis();
      log.info("getImage OK " + (endTime-startTime) + "ms");
    }
    
    TestUtils.assertEquals(log,  "Content-Type", "text/plain", istrmR.getContentType());
    TestUtils.assertEquals(log,  "Content-Length", file.length() , istrmR.getContentLength());
    TestUtils.assertEquals(log,  "FileName", file.getName(), istrmR.getFileName());
    
    ByteBuffer buf = BWire.bufferFromStream(istrmR);
    String strR = new String(buf.array(), buf.position(), buf.remaining());
    TestUtils.assertEquals(log, "stream", str, strR);

    TestUtils.assertEquals(log,  "Content-Type", "text/plain", istrmR.getContentType());
    TestUtils.assertEquals(log,  "Content-Length", file.length() , istrmR.getContentLength());
    TestUtils.assertEquals(log,  "FileName", file.getName(), istrmR.getFileName());
    
    remote.setImage(null);
    TestUtils.checkTempDirEmpty(client);

    log.info(")testRemoteStreamsFileStream");
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
      TestUtils.assertEquals(log, "stream-" +i , istrm, istrmR);
      istrmR.close();
    }
  }
  
  /**
   * Read/write large stream, 120GB
   * @throws InterruptedException
   * @throws IOException
   */
  @Test
  public void testRemoteStreamsLargeStream() throws InterruptedException, IOException {
    log.info("testRemoteStreamsLargeStream(");
    if (TestUtils.TEST_LARGE_STREAMS) {
      long contentLength = Double.valueOf(120.0e9).longValue() + 1;
      InputStream istrm = new TestUtils.MyContentStream(contentLength, false);
      remote.setImage(istrm);
  
      InputStream istrmR = remote.getImage();
      InputStream istrmE = new TestUtils.MyContentStream(contentLength, false);
      TestUtils.assertEquals(log, "stream", istrmE, istrmR);
    }
    else {
      log.info("skipped");
    }
    log.info(")testRemoteStreamsLargeStream");
  }

  /**
   * Read/write stream slowly.
   * Ensure that the function call is finished after the server detects that the stream is not available.
   * This test lasts about 7s. 
   * Tomcat has to be started with JVM argument: -Dbyps.http.incomingStreamTimeoutSeconds=5
   * @throws InterruptedException
   * @throws IOException
   */
  @Test
  public void testRemoteStreamsSlowStream() throws InterruptedException, IOException {
    log.info("testRemoteStreamsSlowStream(");
    try {
      long contentLength = 123456; 
      InputStream istrm = new MySlowStream(contentLength, 7000); // Tomcat -Dbyps.http.incomingStreamTimeoutSeconds=5 
      remote.setImage(istrm);
      TestUtils.fail(log, "Exception expected");
    }
    catch (BException e){
      log.info("exception "+ e);
      TestUtils.assertTrue(log, "Expected Exception \"Wait for stream failed\"", e.toString().indexOf("Wait for stream") >= 0);
    }
    log.info(")testRemoteStreamsSlowStream");
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
    int count = 1;

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
    
    // Stream at index 1 has not been read by the server.
    // The internal cleanup thread has to read the stream and close it 
    // after the message is sent.
    // Now wait for at most HConstants.CLEANUP_MILLIS until HActiveMessages.cleanup()
    // closes the stream and returns a response for this stream.
    // Then, the client will return from remote.setImages().

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

    for (int i = 0; i < 1; i++) {
      internalTestThrowExOnRead(true, false);
      internalTestThrowExOnRead(false, true);
    }

    client.getTransport().getWire().getTestAdapter().cancelAllRequests();

    try {
    	
      // There should be no active messages on the server after the client side has been finished.
      long timeoutMillis = 2 * Math.max(HConstants.KEEP_MESSAGE_AFTER_FINISHED, HConstants.CLEANUP_MILLIS);
      long timeoutAt = timeoutMillis + System.currentTimeMillis();
      
      long[] messageIds = new long[1];
      while (messageIds.length != 0 && timeoutAt > System.currentTimeMillis()) {
    	  
    	  Thread.sleep(HConstants.CLEANUP_MILLIS/10);
    	  
    	  messageIds = client.getTransport().getWire().getTestAdapter().getAcitveMessagesOnServer(false);
    	  log.info("messageIds=" + Arrays.toString(messageIds));
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
    for (int i = 0; i < 3; i++) {
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
      
      // The server waits for the stream in HActiveMessages.getIncomingOrOutgoingStream().
      // But the stream is never sent due to the text exception.
      // The client handles the exception by sending a cancel message.
      // This message interrupts the server. It needs at most HConstants.CLEANUP_MILLIS
      // until all streams of the message are internally released. 
      // Then the remote.setImages() will return.
      
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
  
  /**
   * A stream returned from the server can be passed as input parameter
   * to another call to the same server. The stream must not be downloaded/uploaded therefore.
   * @throws IOException 
   */
  @Test
  public void testHandoverStream() throws IOException {
    log.info("testHandoverStream(");
    
    ArrayList<InputStream> streams = TestUtilsHttp.makeTestStreams();
    
    for (int i = 0; i < streams.size(); i++) {
    
      InputStream istrm = streams.get(i);
      
      remote.setImage(istrm);
      
      InputStream strmFromServer = remote.getImage();
      BContentStream streamFailOpen = new BContentStreamWrapper((BContentStream)strmFromServer, 0L) {
        @Override
        protected InputStream openStream() throws IOException {
          log.error("Stream must not be opened");
          throw new IOException("Stream should be passed without beeing read.");
        }
      };
      
      remote.setImage(streamFailOpen);
      
      for (int j = 0; j < 2; j++) {
        ArrayList<InputStream> estreams = TestUtilsHttp.makeTestStreams();
        InputStream estrm = estreams.get(i);
        InputStream rstrm = remote.getImage();
        TestUtils.assertEquals(log, "stream[" + i + "]=" + estrm, estrm, rstrm);
      }
      
      remote.setImage(null);
      TestUtils.checkTempDirEmpty(client);
    }
    
    log.info(")testHandoverStream");
  }

  /**
   * Test with a stream class which properties are unavailable until the stream is opened.
   * @throws IOException 
   */
  @Test
  public void testStreamWithDeferedProperties() throws IOException {
    log.info("testStreamWithDeferedProperties(");
    
    BContentStream bstrm = (BContentStream)remote.getStreamDeferedProperies();
    TestUtils.assertEquals(log, "contentType", "", bstrm.getContentType());
    TestUtils.assertEquals(log, "contentLength", -1L, bstrm.getContentLength());
    TestUtils.assertEquals(log, "fileName", "", bstrm.getFileName());
    TestUtils.assertEquals(log, "attachmentCode", 0, bstrm.getAttachmentCode());
    
    bstrm.ensureProperties();
    TestUtils.assertEquals(log, "contentType", "application/mycontentype", bstrm.getContentType());
    TestUtils.assertEquals(log, "contentLength", 5L, bstrm.getContentLength());
    TestUtils.assertEquals(log, "fileName", "myfilename", bstrm.getFileName());
    TestUtils.assertEquals(log, "attachmentCode", BContentStream.ATTACHMENT, bstrm.getAttachmentCode());
 
    log.info(")testStreamWithDeferedProperties");
  }

  /**
   * Test with a stream class which properties are unavailable until the stream is opened.
   * The stream is passed back to the server and in turn read from the server. 
   * The stream properties must be unavailable until ensureProperties is called.
   * @throws IOException 
   */
  @Test
  public void testHandoverStreamWithDeferedProperties() throws IOException {
    log.info("testHandoverStreamWithDeferedProperties(");
    
    BContentStream bstrm1 = (BContentStream)remote.getStreamDeferedProperies();
    TestUtils.assertEquals(log, "contentType", "", bstrm1.getContentType());
    TestUtils.assertEquals(log, "contentLength", -1L, bstrm1.getContentLength());
    TestUtils.assertEquals(log, "fileName", "", bstrm1.getFileName());
    TestUtils.assertEquals(log, "attachmentCode", 0, bstrm1.getAttachmentCode());
    
    remote.setStreamDoNotMaterialize(bstrm1);
    BContentStream bstrm = (BContentStream)remote.getStreamDoNotClone();

    TestUtils.assertEquals(log, "contentType", "", bstrm.getContentType());
    TestUtils.assertEquals(log, "contentLength", -1L, bstrm.getContentLength());
    TestUtils.assertEquals(log, "fileName", "", bstrm.getFileName());
    TestUtils.assertEquals(log, "attachmentCode", 0, bstrm.getAttachmentCode());

    bstrm.ensureProperties();
    TestUtils.assertEquals(log, "contentType", "application/mycontentype", bstrm.getContentType());
    TestUtils.assertEquals(log, "contentLength", 5L, bstrm.getContentLength());
    TestUtils.assertEquals(log, "fileName", "myfilename", bstrm.getFileName());
    TestUtils.assertEquals(log, "attachmentCode", BContentStream.ATTACHMENT, bstrm.getAttachmentCode());
 
    log.info(")testHandoverStreamWithDeferedProperties");
  }

  public static class MySlowStream extends InputStream {
    private long pos;
    private final long nbOfBytes;
    private final long waitMillis;
    
    public MySlowStream(long nbOfBytes, long waitMillis) {
      this.nbOfBytes = nbOfBytes;
      this.waitMillis = waitMillis;
    }

    @Override
    public int read() throws IOException {
      if (nbOfBytes == pos) {
        return -1;
      }
      else {
        if (pos == 0 && waitMillis != 0) {
          try {
            Thread.sleep(waitMillis);
          }
          catch (InterruptedException e) {
            throw new InterruptedIOException();
          }
        }
        int ret = (int)(pos++ & 0xFF);
        if ((ret % 5) == 0) ret = 0; 
        return ret;
      }
    }
  }

  /**
   * Cancel reading a stream.
   * The stream must be closed on the server side.
   * Network connections must not increase permanently.
   * OutOfMemory exceptions must not occur.
   * 
   * @throws InterruptedException
   * @throws IOException
   */
  @Test
  @SuppressWarnings("rawtypes")
  public void testRemoteStreamsCancelDownload() throws InterruptedException, IOException {
    log.info("testRemoteStreamsCancelDownload(");

    InputStream istrm = new TestUtils.MyContentStream(101, false);
    remote.setImage(istrm);

    final int NB_OF_DOWNLOADS = 1000;
    final int NB_OF_PARALLEL_DOWNLOADS = 10;
    try {
      for (int i = 0; i < NB_OF_DOWNLOADS/NB_OF_PARALLEL_DOWNLOADS; i++) {
        CompletableFuture[] completableFutures = new CompletableFuture[NB_OF_PARALLEL_DOWNLOADS];
        for (int j = 0; j < completableFutures.length; j++) {
          completableFutures[j] = CompletableFuture.supplyAsync(new Supplier<Object>() {
            public Object get() {
              try {
                InputStream istrmR = remote.getImage();
                istrmR.read(); // read only one byte
                istrmR.close();
              }
              catch (Exception e) {
                throw new IllegalStateException(e);
              }
              return true;
            }
          });
        }
        CompletableFuture all = CompletableFuture.allOf(completableFutures);
        all.get();
        if ((i % 1000) == 0) log.info("#downloads=" + (i));
      }
    }
    catch (Exception e) {
      log.error("Download failed", e);
      TestUtils.fail(log, e.toString());
    }

    remote.setImage(null);
    TestUtils.checkTempDirEmpty(client);

    log.info(")testRemoteStreamsCancelDownload");
  }

}
