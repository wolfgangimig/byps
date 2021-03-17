package byps.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BAsyncContentStream;
import byps.RemoteException;
import byps.test.api.BClient_Testser;
import byps.test.api.remote.RemoteStreams;

/**
 * Test class for {@link BAsyncContentStream}.
 */
public class TestBAsyncContentStream {

  private static final Logger log = LoggerFactory.getLogger(TestBAsyncContentStream.class);

  BClient_Testser client;
  RemoteStreams remote;
  ExecutorService threadPool = Executors.newFixedThreadPool(1);
  
  @Before
  public void setUp() throws RemoteException {
    client = TestUtilsHttp.createClient();
    TestUtils.purgeServerTempDir(client);
    remote = client.getRemoteStreams();
    
    // it may take too much time to start the first thread => warm up the thread
    // pool
    threadPool.execute(() -> log.info("warm up thread"));
  }

  @After
  public void tearDown() {
    if (client != null) {
      client.done();
    }
    threadPool.shutdown();
  }

  /**
   * This test ensures that the provided timeouts are met and the stream does not
   * mix up the data it has to transport.
   */
  @Test
  public void testDelayedStream() throws IOException {
    UnaryOperator<InputStream> sendReceive = stream -> stream;
    internalTestDelayedStreams(sendReceive);
  }

  /**
   * Check sending asynchronous streams to server.
   * BYPS-48 
   * @throws IOException
   */
  @Test
  public void testPutDelayedStream() throws IOException {
    UnaryOperator<InputStream> sendReceive = stream -> {
      try {
        remote.setImage(stream);
        return remote.getImage();
      }
      catch (Exception e) {
        throw new IllegalStateException(e);
      }
    };
    internalTestDelayedStreams(sendReceive);
  } 
  
  /**
   * Execute several cases that uses BAsyncContentStream.
   * @param sendReceive The internally generated async stream is passed to this function before it is read.
   * @throws IOException
   */
  private void internalTestDelayedStreams(UnaryOperator<InputStream> sendReceive) throws IOException {
    // produce data faster than consuming it
    testDelayedStream(50, 30, 2000, 500, sendReceive, threadPool);
    // produce data at the same rate as consuming it
    testDelayedStream(10, 10, 2000, 500, sendReceive, threadPool);
    // produce data way faster than consuming it
    testDelayedStream(100, 10, 2000, 500, sendReceive, threadPool);
    // produce data way slower than consuming it
    testDelayedStream(10, 100, 2000, 500, sendReceive, threadPool);
    // use a more conventional buffer size so the total amount of data is not a
    // whole-numer multiple of the buffer size
    testDelayedStream(10, 10, 2000, 1024, sendReceive, threadPool);
  }

  /**
   * Helper function for {@link #testDelayedStream()} to execute the same test
   * with different parameters.
   * 
   * @param readTimeout
   *          int Timeout for {@link BAsyncContentStream#read(byte[], int, int)}
   * @param writeTimeout
   *          int artificial timout for the production of data. Use this parameter
   *          to slow down the inner (data producing) InputStream.
   * @param totalBytes
   *          Amount of data to generate.
   * @param packageSize
   *          Amount of data the inner InputStream returns for each call of
   *          read(...).
   * @param sendReceive 
   *          This function is called before the BAsyncContentStream is read.
   * @throws IOException
   */
  void testDelayedStream(int readTimeout, int writeTimeout, int totalBytes, int packageSize, 
      UnaryOperator<InputStream> sendReceive,
      ExecutorService threadPool)
      throws IOException {
    // generate test data
    byte[] bytes = new byte[totalBytes];
    generateText(bytes, totalBytes % 10, 80);

    // create the inner InputStream
    InputStream dummyInputStream = new DelayingInputStream(bytes, writeTimeout, packageSize);

    // test the BAsyncContentStream
    try (BAsyncContentStream testInputStream = new BAsyncContentStream(dummyInputStream, "", -1, readTimeout,
        TimeUnit.MILLISECONDS, 1024, threadPool)) {
      
      InputStream inputStreamR = sendReceive.apply(testInputStream);
      
      byte[] result = readAllBytes(inputStreamR, readTimeout);
      // ensure that we read the data as we expected it
      assertArrayEquals(bytes, result);
    }
  }

  /**
   * Read all bytes from the provided {@link InputStream} and ensure that the
   * expected read duration is satisfied.
   * 
   * @return byte[] all read bytes
   * @throws IOException
   */
  private static byte[] readAllBytes(InputStream input, int expectedReadDuration) throws IOException {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    int read = 0;
    long start = 0;
    long duration = 0;
    byte[] buffer = new byte[1024];
    do {
      log.debug("read {}bytes in {}ms [expected={}ms]", read, duration, expectedReadDuration);
      start = System.currentTimeMillis();
      read = input.read(buffer);
      duration = System.currentTimeMillis() - start;
      log.debug("read {}bytes in {}ms [expected={}ms]", read, duration, expectedReadDuration);

      assertTrue(Math.abs(duration - expectedReadDuration) < 5 || duration < expectedReadDuration);
      if (read > 0)
        out.write(buffer, 0, read);
    } while (read >= 0);
    return out.toByteArray();
  }

  /**
   * Generates "text" - meaning it will generates bytes in the ASCII-range. All
   * fields of the given array will be filled by this method.
   */
  public static void generateText(byte[] bytes, int chunk, int lineLength) {
    boolean osUsesCrappyLineSeparator = System.lineSeparator().length() > 1;
    for (int i = 0; i < bytes.length; i++) {
      if (i > 0 && i % lineLength == 0) {
        bytes[i] = 0xa;
      } else {
        if (osUsesCrappyLineSeparator && i % lineLength == lineLength - 1) {
          bytes[i] = 0xd;
        } else {
          bytes[i] = (byte) (33 + i % 93);
        }
      }
    }
    if (chunk >= 0) {
      markChunk(bytes, chunk);
    }

  }

  /**
   * This function adds a String marker [n] to the given byte[] at position 0
   * where n is the parameter chunk as a String.
   */
  private static void markChunk(byte[] bytes, int chunk) {
    byte[] chunkAsString = Integer.toString(chunk).getBytes();
    if (chunkAsString.length < (bytes.length - 2) && bytes.length > 2) {
      System.arraycopy(chunkAsString, 0, bytes, 1, chunkAsString.length);
      bytes[0] = '[';
      bytes[chunkAsString.length + 1] = ']';
      bytes[bytes.length - 1] = (byte) 33 + 93;
    }
  }

  /**
   * This implementation of an {@link InputStream} simulates slow data sources by
   * delaying the {@link #read(byte[], int, int)} operation.
   */
  private class DelayingInputStream extends InputStream {

    private final int timeout;
    private final byte[] backend;
    private final int returnSize;
    private int position;

    /**
     * Constructor.
     * 
     * @param backend
     *          byte[] all data this stream should provide by its read function.
     * @param timeout
     *          int duration in milliseconds a call to read should take
     * @param returnSize
     *          amount of data a call to read should return at once. Must not be
     *          greater that the size of the backend.
     */
    protected DelayingInputStream(byte[] backend, int timeout, int returnSize) {
      this.backend = backend;
      this.timeout = timeout;
      this.returnSize = returnSize;
    }

    @Override
    public int read() throws IOException {
      return backend[position++];
    }

    @Override
    public int read(byte[] b, int offset, int length) throws IOException {
      if (position >= backend.length)
        return -1;

      int actualLength = Math.min(returnSize, Math.min(length, backend.length - position));

      // delay the call in case a timeout was given
      if (timeout > 0)
        try {
          log.debug("delay read by {}ms", timeout);
          synchronized (this) {
            this.wait(timeout);
          }

        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }

      // copy data from our backend to the given buffer
      log.debug("copy {} bytes [{}/{}] [{}]", actualLength, position, backend.length, backend[position]);
      System.arraycopy(backend, position, b, offset, actualLength);
      position += actualLength;
      return actualLength;
    }
  }
}
