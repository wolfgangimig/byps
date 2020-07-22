package byps;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A {@link BAsyncContentStream} behaves comparable to a
 * {@link BufferedInputStream} but allows setting a custom timeout for the
 * {@link #read(byte[], int, int)} operation. That operation responds with the
 * available data so far in case
 */
public class BAsyncContentStream extends BContentStream {

  private static final Logger log = LoggerFactory.getLogger(BAsyncContentStream.class);

  private final InputStream in;
  /**
   * This class uses this thread pool to handle the asynchronous read-requests.
   */
  private final ExecutorService threadPool;

  /**
   * Maximum duration the {@link #read(byte[], int, int)} operation may take time
   * to wait until the requested amount of data is available. The default value is
   * {@value #DEFAULT_TIMEOUT} {@value #DEFAULT_TIMEUNIT}. Its unit is specified
   * in {@link #timeoutUnit}.
   */
  private final long timeout;

  /**
   * Default value for {@link #timeout}.
   */
  public static final long DEFAULT_TIMEOUT = 1;

  /**
   * Time unit for {@link #timeout}. Default value is {@value #DEFAULT_TIMEUNIT}.
   */
  private final TimeUnit timeoutUnit;

  /**
   * Default value for {@link #timeoutUnit}
   */
  public static final TimeUnit DEFAULT_TIMEUNIT = TimeUnit.SECONDS;

  /**
   * Buffer for data read in parallel.
   */
  private final byte[] buffer;

  /**
   * Position of the first byte in {@link #buffer} that was not read yet.
   */
  private int bufferReadOffset;

  /**
   * Amount of data remaining in {@link #buffer}.
   */
  private int bufferRemaining;

  /**
   * {@link Future} that holds a reference to a pending read-request (to the
   * underlying {@link InputStream} {@link #in}).
   */
  private Future<Integer> pendingRequest = null;

  /**
   * Default value for the size of {@link #buffer}.
   */
  public static final int DEFAULT_BUFFER_SIZE = 1 << 16;

  /**
   * Default thread pool to use ({@link ForkJoinPool#commonPool()}).
   */
  public static final ExecutorService DEFAULT_THREAD_POOL = ForkJoinPool.commonPool();

  /**
   * Minimal constructor. Uses the default values for buffer size, timeout, and
   * time unit.
   * 
   * @param in
   *          {@link InputStream} which is decoupled by this class.
   */
  public BAsyncContentStream(InputStream in, String contentType, long contentLength) {
    this(in, contentType, contentLength, DEFAULT_TIMEOUT, DEFAULT_TIMEUNIT, DEFAULT_BUFFER_SIZE);
  }

  /**
   * Constructor. Uses the default value for timeout and time unit.
   * 
   * @param in
   *          {@link InputStream} which is decoupled by this class.
   * @param maxRequestSize
   *          size of the internal buffer in bytes.
   */
  public BAsyncContentStream(InputStream in, String contentType, long contentLength, int maxRequestSize) {
    this(in, contentType, contentLength, DEFAULT_TIMEOUT, DEFAULT_TIMEUNIT, maxRequestSize);
  }

  /**
   * 
   * Constructor.
   * 
   * @param in
   *          {@link InputStream} which is decoupled by this class.
   * @param maxRequestSize
   *          size of the internal buffer in bytes.
   * @param timeout
   *          how long the {@link #read(byte[], int, int)} may take time to
   *          complete.
   * @param timeUnit
   *          time unit for {@link #timeout}
   */
  public BAsyncContentStream(InputStream in, String contentType, long contentLength, long timeout, TimeUnit timeUnit,
      int maxRequestSize) {
    this(in, contentType, contentLength, timeout, timeUnit, maxRequestSize, DEFAULT_THREAD_POOL);
  }

  /**
   * 
   * Constructor.
   * 
   * @param in
   *          {@link InputStream} which is decoupled by this class.
   * @param maxRequestSize
   *          size of the internal buffer in bytes.
   * @param timeout
   *          how long the {@link #read(byte[], int, int)} may take time to
   *          complete.
   * @param timeUnit
   *          time unit for {@link #timeout}
   * @param threadPool
   *          {@link ExecutorService} which is used to start reading from
   *          {@link #in} asynchronously. Defaults to {@link DEFAULT_THREAD_POOL}.
   */
  public BAsyncContentStream(InputStream in, String contentType, long contentLength, long timeout, TimeUnit timeUnit,
      int maxRequestSize, ExecutorService threadPool) {
    super(contentType, contentLength);
    this.in = in;
    this.timeout = timeout;
    this.threadPool = threadPool;
    this.buffer = new byte[maxRequestSize];
    this.timeoutUnit = timeUnit;
  }

  @Override
  public int read(byte[] b, int offset, int length) throws IOException {
    if (log.isTraceEnabled())
      log.trace("request {} bytes @{}", length, offset);

    if (length == 0) {
      return 0;
    }

    int readTotal = 0;
    int read = 0;
    // the whole call to read must complete before end:
    long end = System.currentTimeMillis() + timeout;
    // remember the timeout for the next internal call to read, the value may
    // decrease in case subsequent calls are required.
    long currentTimeout = timeout;

    // forward to the internal read-method with a timeout
    while (readTotal < length && currentTimeout > 0
        && (read = read(b, offset + readTotal, length - readTotal, currentTimeout)) >= 0) {
      if (log.isTraceEnabled())
        log.trace("read: {} bytes", read);

      currentTimeout = end - System.currentTimeMillis();
      readTotal += read;
    }

    if (log.isTraceEnabled())
      log.trace("read {} bytes", readTotal);
    return readTotal > 0 ? readTotal : read;
  }

  /**
   * Helper method for {@link #read(byte[], int, int)} that returns after the
   * given timeout at the latest.
   */
  private int read(byte[] b, int offset, int length, long timeout) throws IOException {
    try {
      int read = -1;
      if (log.isTraceEnabled())
        log.trace("try read {} bytes @{} in {}{}", length, offset, timeout, timeoutUnit);

      // In case a read request is already startet and has not yet finished we try to
      // resume that request. This may happen in case the previous call to this
      // function ran into a timeout.
      Future<Integer> pending = this.pendingRequest;

      // Do not start a new read request if there are data available in our buffer or
      // there is pending a request.
      if (pending == null && bufferRemaining == 0) {
        pending = threadPool.submit(() -> readBuffered(length));
        this.pendingRequest = pending;
      }

      // get Data from the pending request...
      if (pending != null) {
        read = pending.get(timeout, timeoutUnit);
        if (log.isTraceEnabled())
          log.trace("read {} bytes [{}]", read, b[offset]);
      }

      // ... and return them to the caller.
      return readFromBuffer(read, b, offset, length);

    } catch (TimeoutException e) {
      // We return 0 in case of a timeout. Then, the caller must recall this function.
      if (log.isDebugEnabled())
        log.debug("timed out after {}{}", timeout, timeoutUnit);
      return 0;
    } catch (InterruptedException e) {
      if (log.isDebugEnabled())
        log.debug("interrupted");
      Thread.currentThread().interrupt();
      throw new IOException(e);
    } catch (ExecutionException e) {
      if (log.isDebugEnabled())
        log.debug("cannot execute");
      throw new IOException(e);
    }
  }

  /**
   * Read from the internal buffer.
   * 
   * @param readParallel
   *          Amount of data that were read in parallel.
   * @return int Amount of data written into the parameter b or -1 if the end of
   *         the stream has been reached.
   * @see InputStream#read(byte[], int, int)
   */
  private int readFromBuffer(int readParallel, byte[] b, int offset, int length) {
    if (canReadFromBuffer(readParallel)) {
      return offerFromBuffered(b, offset, length);
    } else {
      return -1;
    }
  }

  /**
   * Returns <tt>true</tt> only if data can be read from the internal buffer.
   * 
   * @param readParallel
   *          Amount of data that were read in parallel.
   * 
   * @return <tt>true</tt> if data are available <tt>false</tt> otherwise.
   */
  private boolean canReadFromBuffer(int readParallel) {
    return readParallel >= 0 || bufferReadOffset < bufferRemaining && bufferRemaining > 0;
  }

  /**
   * Reads 'length' of data from {@link #in} into {@link #buffer}.
   * 
   * @param length
   *          Amount of data to read.
   * @return Actual amount of data read from {@link #in}.
   * @throws IOException
   */
  private int readBuffered(int length) throws IOException {
    int read = in.read(buffer, 0, length);
    if (log.isTraceEnabled())
      log.trace("readBuffered: {} bytes", read);
    this.bufferReadOffset = 0;
    this.bufferRemaining = read;
    this.pendingRequest = null;
    return read;
  }

  /**
   * Read data from {@link #buffer} into the given byte[].
   * 
   * @return Amount of data written into the given byte[].
   * @see InputStream#read(byte[], int, int)
   */
  private int offerFromBuffered(byte[] b, int offset, int length) {
    int copyLength = Math.min(length, bufferRemaining);
    System.arraycopy(buffer, bufferReadOffset, b, offset, copyLength);
    if (log.isTraceEnabled())
      log.trace("from buffer: offset={} remaining={}", bufferReadOffset, bufferRemaining);
    this.bufferReadOffset += copyLength;
    this.bufferRemaining -= copyLength;
    return copyLength;
  }

  public InputStream getInputStream() {
    return in;
  }

  @Override
  public int read() throws IOException {
    byte[] b = new byte[1];
    int read = read(b, 0, 1);
    if (read >= 0) {
      return 0xff & b[0];
    } else {
      return -1;
    }
  }

  @Override
  public long skip(long n) throws IOException {
    return in.skip(n);
  }

  @Override
  public int available() throws IOException {
    return in.available();
  }

  @Override
  public void close() throws IOException {
    in.close();
  }

  @Override
  public boolean markSupported() {
    return in.markSupported();
  }

  @Override
  public synchronized void mark(int readlimit) {
    in.mark(readlimit);
  }

  @Override
  public synchronized void reset() throws IOException {
    in.reset();
  }

}
