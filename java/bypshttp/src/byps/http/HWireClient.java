package byps.http;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BApiDescriptor;
import byps.BAsyncResult;
import byps.BBufferJson;
import byps.BContentStream;
import byps.BContentStreamAsyncCallback;
import byps.BException;
import byps.BExceptionC;
import byps.BHashMap;
import byps.BMessage;
import byps.BMessageHeader;
import byps.BNegotiate;
import byps.BSyncResult;
import byps.BTargetId;
import byps.BTestAdapter;
import byps.BTransport;
import byps.BTransportFactory;
import byps.BWire;
import byps.http.client.HHttpClient;
import byps.http.client.HHttpClientFactory;
import byps.http.client.HHttpRequest;
import byps.http.client.jcnn.JcnnClientFactory;
import byps.ureq.BApiDescriptor_BUtilityRequests;
import byps.ureq.BClient_BUtilityRequests;
import byps.ureq.BRegistry_BUtilityRequests;
import byps.ureq.JRegistry_BUtilityRequests;

/**
 * BWire implementation for HTTP.
 * By default, this class uses HttpURLConnection to communicate with the server.  
 * Set 
 * <code>System.setProperty(HWireClient.SYSTEM_PROPERTY_HTTP_CLIENT_FACTORY, "byps.http.client.asf.AsfClientFactory");</code>
 * in order to send messages by Apache HTTP Components 4.3.2.
 */
public class HWireClient extends BWire {

  /**
   * Full qualified name of the HTTP client factory class. The constructor reads
   * this value by System.getProperty() and instantiates an object in order to
   * create a HTTP client object and other necessary objects. If this system
   * property is not set, the factory
   * {@link byps.http.client.jcnn.JcnnClientFactory} is used.
   * The value of this property is "byps.http.client.factory".
   */
  public final static String SYSTEM_PROPERTY_HTTP_CLIENT_FACTORY = "byps.http.client.factory";

  protected final static long MESSAGEID_CANCEL_ALL_REQUESTS = -1;
  protected final static long MESSAGEID_DISCONNECT = -2;

  protected final String surl;
  protected final static int CHUNK_SIZE = 10 * 1000;
  protected final static int MAX_STREAM_PART_SIZE = 1000 * CHUNK_SIZE; // should
                                                                       // be a
                                                                       // multiple
                                                                       // of
                                                                       // CHUNK_SIZE
  protected final static Logger log = LoggerFactory.getLogger(HWireClient.class);
  protected final BHashMap<RequestToCancel, Boolean> openRequestsToCancel = new BHashMap<RequestToCancel, Boolean>();
  // protected final Map<RequestToCancel, Boolean> openRequestsToCancel =
  // Collections.synchronizedMap(new HashMap<RequestToCancel, Boolean>());
  protected final Executor threadPool;
  protected final boolean isMyThreadPool;
  protected final HTestAdapter testAdapter;
  protected volatile boolean isDone;
  protected final HHttpClient httpClient;

  protected Statistics stats = null;

  protected int timeoutSecondsClient;

  private enum ERequestDirection {
    FORWARD, REVERSE
  };

  /**
   * Initializes a new client-side HTTP communication.
   * 
   * @param url
   *          URL to server.
   * @param flags
   *          A combination of BWire.FLAG_* values.
   * @param timeoutSeconds
   *          Read timeout in seconds. A timeout of zero is interpreted as an
   *          infinite timeout.
   * @param threadPool
   *          Optional: A thread pool. If null, a thread pool is internally
   *          created.
   * @see BWire#FLAG_GZIP
   */
  public HWireClient(String url, int flags, int timeoutSeconds, Executor threadPool) {
    this(createHttpClient(url), url, flags, timeoutSeconds, threadPool);
  }

  /**
   * Initializes a new client-side HTTP communication. 
   * @param httpClient
   * @param url
   * @param flags
   * @param timeoutSeconds
   * @param threadPool
   */
  public HWireClient(HHttpClient httpClient, String url, int flags, int timeoutSeconds, Executor threadPool) {
    super(flags);
    if (log.isDebugEnabled()) log.debug("HWireClient(" + url + ", flags=" + flags + ", timeoutSeconds=" + timeoutSeconds + ", threadPool=" + threadPool);

    this.surl = url;
    this.timeoutSecondsClient = timeoutSeconds;
    this.isMyThreadPool = threadPool == null;
    if (threadPool == null) {
      threadPool = Executors.newCachedThreadPool();
    }
    this.threadPool = threadPool;
    this.testAdapter = new HTestAdapter(this);
    this.httpClient = httpClient;
    
    if (log.isDebugEnabled()) log.debug(")HWireClient");
  }

  private static HHttpClient createHttpClient(String url) {
    if (log.isDebugEnabled()) log.debug("createHttpClient(");

    if (url == null || url.length() == 0) throw new IllegalStateException("Missing URL");

    // The class name of the HHttpClientFactory is taken from the
    // System.properties.
    String factName = System.getProperty(SYSTEM_PROPERTY_HTTP_CLIENT_FACTORY);
    if (log.isDebugEnabled()) log.debug("factory from system.properties[" + SYSTEM_PROPERTY_HTTP_CLIENT_FACTORY + "]=" + factName);
    if (factName == null || factName.length() == 0) factName = JcnnClientFactory.class.getName();

    // Create a client factory object
    HHttpClientFactory fact = null;
    try {
      if (log.isDebugEnabled()) log.debug("instantiate factName=" + factName);
      Class<?> clazz = Class.forName(factName);
      fact = (HHttpClientFactory) clazz.newInstance();
      if (log.isDebugEnabled()) log.debug("fact=" + fact);
    }
    catch (Exception e) {
      if (log.isDebugEnabled()) log.debug("failed to create factory, factName=" + factName, e);
      throw new IllegalStateException(e);
    }

    if (log.isDebugEnabled()) log.debug("createHttpClient...");
    HHttpClient httpClient = fact.createHttpClient(url);
    if (log.isDebugEnabled()) log.debug("createHttpClient OK, " + httpClient);
    
    if (log.isDebugEnabled()) log.debug(")createHttpClient");
    return httpClient;
  }

  /**
   * This class is used to join stream upload results with their method call result. 
   * 
   */
  protected class AsyncResultAfterAllRequests implements BAsyncResult<BMessage> {
    
    /**
     * Message ID.
     * Used to cancel the method request and the stream requests if an error occurs.
     */
    final long messageId;
    
    /**
     * Method result.
     * If the method request and the stream requests are finished, the method result is passed to this object. 
     */
    private BAsyncResult<BMessage> methodResult;
    
    /**
     * Counter for currently running requests.
     * If this counter is 0, all requests belonging to "this" are finished.  
     */
    private int nbOfOutstandingResults;
    
    /**
     * Result received from the method request.
     * This result is passed to {@link #methodResult} if {@link #nbOfOutstandingResults} is 0.
     */
    private BMessage result;
    
    /**
     * Exception received from the method request or from one of the stream requests.
     * This exception is passed to {@link #methodResult} if {@link #nbOfOutstandingResults} is 0.
     */
    private Throwable ex;

    /**
     * Constructor.
     * @param messageId Message ID 
     * @param methodResult Receiver for the method result.
     * @param nbOfRequests Number of associated requests. Equals to number of stream requests plus one.
     */
    public AsyncResultAfterAllRequests(long messageId, BAsyncResult<BMessage> methodResult, final int nbOfRequests) {
      this.messageId = messageId;
      this.methodResult = methodResult;
      this.nbOfOutstandingResults = nbOfRequests;
    }

    /**
     * Tests, whether an exception has already been received.
     * Only the first exception is passed to {@link #methodResult}. 
     * @return true, if an exception ahs already been received.
     */
    private boolean hasException() {
      return ex != null || 
          (result != null && result.header != null && result.header.error != 0);
    }

    @Override
    public void setAsyncResult(BMessage msg, Throwable ex) {
      if (log.isDebugEnabled()) log.debug("setAsyncResult(msg=" + msg + ", ex=" + ex);

      // True, if an error has occurred and the message should be cancelled.
      boolean cancelMessage = false;

      // This variables are used to avoid processing of object in the synchronized block below.
      BMessage innerMsg = null;
      Throwable innerEx = null;
      BAsyncResult<BMessage> asyncResult = null;

      synchronized (this) {

        // Decrement counter of running requests.
        nbOfOutstandingResults--;

        // Received an exception of the underlying HTTP protocol?
        if (ex != null) {
          
          // If this exception is a BExceptionC#PROCESSING, the client has to send a 
          // processing message to supply a new TCP channel for the server.
          int code = ex instanceof BException ? ((BException)ex).code : 0;
          if (code == BExceptionC.PROCESSING) {
            if (log.isDebugEnabled()) log.debug("re-send message");
            
            // Revert counter, because a new request is started in BTransport.
            nbOfOutstandingResults++; 

            // Pass this exception to BTransport (after the synchronized block). 
            asyncResult = methodResult;
            innerEx = ex;
            
            // The processing message will assign a new BAsyncResult that receives the result of the method request.
            // This is done in HWireClient#replaceAsyncResultOfRequestForPollProcessing. 
            // See #setInnerMethodResult.
            methodResult = null;
          }
          else {
            
            // Only the first exception is taken into account.
            // If the first exception is received, the method request and stream requests will be cancelled. 
            cancelMessage = !hasException();
            if (cancelMessage) this.ex = ex;
            if (log.isDebugEnabled()) log.debug("cancelMessage=" + cancelMessage);
          }
        }

        // Result information passed?
        if (msg != null && msg.buf != null) {
          if (log.isDebugEnabled()) log.debug("set result=" + msg);
          
          // Received an exception from the server application?
          if (msg.header.error != 0) {
            if (log.isDebugEnabled()) log.debug("msg.header.error=" + msg.header.error);
            cancelMessage = !hasException();
          }
          
          this.result = msg;
        }
        else {
          
          // Response of a successfully uploaded stream. 
          
        }

        // Finished processing all requests?
        if (nbOfOutstandingResults == 0) {
          
          if (log.isDebugEnabled()) log.debug("finshed all requests");
          
          // Set result variables. 
          innerMsg = this.result;
          innerEx = this.ex;
          asyncResult = this.methodResult;
        }

      } // synchronized


      // Pass the result or (first) exception to BTransport? 
      if (asyncResult != null) {
        if (log.isDebugEnabled()) log.debug("setAsyncResult(result=" + innerMsg + ", ex=" + innerEx);
        asyncResult.setAsyncResult(innerMsg, innerEx);
      }
      
      // Cancel all associated requests? 
      else if (cancelMessage) {
        sendCancelMessage(messageId);
      }

      if (log.isDebugEnabled()) log.debug(")setAsyncResult");
    }

    /**
     * Replace the method result.
     * This function is called when sending a request that polls processing of a long running request.
     * @param asyncResult New method result
     */
    public synchronized void setInnerMethodResult(BAsyncResult<BMessage> asyncResult) {
      methodResult = asyncResult;
    }

  }

  @Override
  public synchronized void send(final BMessage msg, final BAsyncResult<BMessage> asyncResult) {
    internalSendMessage(msg, asyncResult);
  }

  @Override
  public void sendR(BMessage msg, BAsyncResult<BMessage> asyncResult) {
    internalSendMessage(msg, asyncResult);
  }

  protected void executeRequest(RequestToCancel r) throws BException {
    if (log.isDebugEnabled()) log.debug("executeRequest(" + r);

    if (isDone) {
      BException e = new BException(BExceptionC.CANCELLED, "HTTP Client already disconnected.");
      throw e;
    }

    for (int retry = 0; retry < 10 && !isDone; retry++) {
      try {
        threadPool.execute(r);
        if (log.isDebugEnabled()) log.debug(")executeRequest");
        return;
      }
      catch (RejectedExecutionException e) {
        if (log.isDebugEnabled()) log.debug("rejected execution, thread pool exausted? retry=" + retry);
        int retryAfterMillis = rand.nextInt(100);
        try {
          Thread.sleep((long) retryAfterMillis);
        }
        catch (InterruptedException e1) {
          break;
        }
      }
    }

    BException e = new BException(BExceptionC.TOO_MANY_REQUESTS, "Failed to send method or stream because too many requests are currently active.");
    throw e;
  }

  @Override
  public void putStreams(long trackingId, List<BContentStream> streams, BAsyncResult<BMessage> asyncResult) {
    try {
      for (BContentStream stream : streams) {
        RequestToCancel req = createRequestForPutStream(trackingId, stream, asyncResult);
        executeRequest(req);
      }
    }
    catch (BException e) {
      asyncResult.setAsyncResult(null, e);
    }
  }

  /**
   * Send a message and provide a result object.
   * 
   * @param msg Message to be sent.
   * @param asyncResult Result object to be called when the message is finished.
   */
  private synchronized void internalSendMessage(BMessage msg, BAsyncResult<BMessage> asyncResult) {
    if (log.isDebugEnabled()) log.debug("internalSendMessage(" + msg.header.messageId);
    try {

      // Helper variables for message options.
      boolean hasStreams = msg.streams != null && !msg.streams.isEmpty();
      boolean isProcessing = (msg.header.flags & BMessageHeader.FLAG_POLL_PROCESSING) != 0;
      if (log.isDebugEnabled()) log.debug("hasStreams=" + hasStreams + ", isProcessing=" + isProcessing);

      // Does the message send also streams?
      if (hasStreams) {
        internalSendMessageAndStreams(msg, asyncResult);
      }
      else {
        
        // Is this request following a BException#PROCESSING?
        if (isProcessing) {
          
          // BYPS-9.
          // Check, whether there is an active stream request and if so, replace the 
          // method result in this stream.
          BAsyncResult<BMessage> prevAsyncResult = replaceAsyncResultOfRequestForPollProcessing(msg.header.messageId, asyncResult);
          if (prevAsyncResult != null) {
            asyncResult = prevAsyncResult;
          }
        }

        // Send a message without streams.
        internalSendMessageWithoutStreams(msg, asyncResult);
      }
    }
    catch (BException e) {
      asyncResult.setAsyncResult(null, e);
    }
    if (log.isDebugEnabled()) log.debug(")internalSendMessage");
  }
  
  /**
   * Send a message that does not include streams.
   * @param msg Message object
   * @param asyncResult Result object
   * @throws BException
   */
  private synchronized void internalSendMessageWithoutStreams(final BMessage msg, final BAsyncResult<BMessage> asyncResult) throws BException {
    RequestToCancel req = createRequestForMessage(msg, asyncResult, timeoutSecondsClient);
    executeRequest(req);
  }
  
  /**
   * Send a message object that includes streams.
   * @param msg Message object
   * @param asyncResult Result object
   * @throws BException
   */
  private synchronized void internalSendMessageAndStreams(final BMessage msg, final BAsyncResult<BMessage> asyncResult) throws BException {
    if (log.isDebugEnabled()) log.debug("send(" + msg + ", asyncResult=" + asyncResult);

    // If the BMessage contains streams, the given asyncResult is wrapped into a
    // BAsyncRequest object that sets the asynchronous result after the
    // message and all streams
    // have been sent.
    if (log.isDebugEnabled()) log.debug("wrap asyncResult");
    BAsyncResult<BMessage> outerResult = new AsyncResultAfterAllRequests(msg.header.messageId, asyncResult, msg.streams.size() + 1);
    
    // Create RequestToCancel for message
    RequestToCancel req = createRequestForMessage(msg, outerResult, timeoutSecondsClient);
    executeRequest(req);

    // Create RequestToCancel objects for each stream.
    long trackingId = msg.header.getTrackingId();
    putStreams(trackingId, msg.streams, outerResult);

    if (log.isDebugEnabled()) log.debug(")send");
  }

  protected RequestToCancel createRequestForMessage(BMessage msg, BAsyncResult<BMessage> asyncResult, int timeoutSecondsRequest) {
    if (log.isDebugEnabled()) log.debug("createRequestForMessage(" + msg);
    ByteBuffer requestDataBuffer = msg.buf;

    if (log.isDebugEnabled()) {
      requestDataBuffer.mark();
      BBufferJson bbuf = new BBufferJson(requestDataBuffer);
      log.debug(bbuf.toDetailString());
      requestDataBuffer.reset();
    }

    final RequestToCancel requestToCancel = new RequestToCancel(msg.header.messageId, 0L, 0L, asyncResult);

    final boolean isNegotiate = BNegotiate.isNegotiateMessage(requestDataBuffer);
    final boolean isJson = isNegotiate || BMessageHeader.detectProtocol(requestDataBuffer) == BMessageHeader.MAGIC_JSON;
    if (log.isDebugEnabled()) log.debug("isJson=" + isJson);
    
    try {
      StringBuilder destUrl = null;

      // Negotiate?
      if (isNegotiate) {
        
        // Send a GET request and pass the negotiate string as parameter

        String negoStr = new String(requestDataBuffer.array(), requestDataBuffer.position(), requestDataBuffer.limit(), "UTF-8");
        negoStr = URLEncoder.encode(negoStr, "UTF-8");

        String negoServlet = getServletPathForNegotiationAndAuthentication();
        destUrl = getUrlStringBuilder(negoServlet);
        destUrl.append("&negotiate=").append(negoStr);
        
      }

      // Reverse request (long-poll) ?
      else if ((msg.header.flags & BMessageHeader.FLAG_RESPONSE) != 0) {
        
        String longpollServlet = getServletPathForReverseRequest();
        destUrl = getUrlStringBuilder(longpollServlet);
        
        timeoutSecondsRequest = 0; // timeout controlled by server, 10min by
                                   // default.
      }
      
      // Ordinary request
      else {
        destUrl = getUrlStringBuilder("");
      }
      
      long trackingId = msg.header.getTrackingId();

      if (log.isDebugEnabled()) log.debug("open connection, url=" + destUrl);
      final HHttpRequest httpRequest = isNegotiate ? 
          httpClient.get(trackingId, destUrl.toString(), requestToCancel) : 
          httpClient.post(trackingId, destUrl.toString(), requestDataBuffer, requestToCancel);

      httpRequest.setTimeouts(timeoutSecondsClient, timeoutSecondsRequest);
      
      requestToCancel.setHttpRequest(httpRequest);

      addRequest(requestToCancel);
    }
    catch (Throwable e) {
      if (log.isDebugEnabled()) log.debug("received Throwable: " + e);
      BException bex = new BException(BExceptionC.IOERROR, "IO error", e);
      asyncResult.setAsyncResult(null, bex);
    }

    if (log.isDebugEnabled()) log.debug(")createRequestForMessage=" + requestToCancel);
    return requestToCancel;
  }

  protected RequestToCancel createRequestForPutStream(long trackingId, BContentStream stream, BAsyncResult<BMessage> asyncResult) {
    if (log.isDebugEnabled()) log.debug("createRequestForPutStream(" + stream);

    final long messageId = stream.getTargetId().getMessageId();
    final long streamId = stream.getTargetId().getStreamId();
    StringBuilder destUrl = getUrlStringBuilder("");
    destUrl.append("&messageid=").append(messageId).append("&streamid=").append(streamId);

    final RequestToCancel requestToCancel = new RequestToCancel(messageId, streamId, 0L, asyncResult);
    final HHttpRequest httpRequest = httpClient.putStream(trackingId, destUrl.toString(), stream, requestToCancel);

    requestToCancel.setHttpRequest(httpRequest);
    addRequest(requestToCancel);

    if (log.isDebugEnabled()) log.debug(")createRequestForPutStream=" + requestToCancel);
    return requestToCancel;
  }

  protected RequestToCancel createRequestForGetStream(long trackingId, final BTargetId targetId, final BAsyncResult<BContentStream> asyncResult) {
    if (log.isDebugEnabled()) log.debug("createRequestForGetStream(" + targetId);

    final long messageId = targetId.getMessageId();
    final long streamId = targetId.getStreamId();
    
    StringBuilder destUrl = getUrlStringBuilder("");
    destUrl.append("&serverid=").append(targetId.getServerId())
      .append("&messageid=").append(messageId)
      .append("&streamid=").append(streamId);

    final RequestToCancel requestToCancel = new RequestToCancel(messageId, streamId, 0L, null);
    final HHttpRequest httpRequest = httpClient.getStream(trackingId, destUrl.toString(), new BAsyncResult<BContentStream>() {
      public void setAsyncResult(BContentStream stream, Throwable ex) {
        asyncResult.setAsyncResult(stream, ex);
        requestToCancel.setAsyncResult(null, ex);
      }
    });

    requestToCancel.setHttpRequest(httpRequest);
    addRequest(requestToCancel);

    if (log.isDebugEnabled()) log.debug(")createRequestForGetStream=" + requestToCancel);
    return requestToCancel;
  }

  protected RequestToCancel createRequestForCancelMessage(long messageId) {
    final RequestToCancel requestToCancel = new RequestToCancel(0L, 0L, messageId, new BAsyncResult<BMessage>() {
      public void setAsyncResult(BMessage msg, Throwable ex) {
      }
    });

    long trackingId = messageId;
    
    String destUrl = surl + "?messageid=" + messageId + "&cancel=1";
    final HHttpRequest httpRequest = httpClient.get(trackingId, destUrl, requestToCancel);

    requestToCancel.setHttpRequest(httpRequest);

    addRequest(requestToCancel);
    return requestToCancel;
  }
  
  protected class RequestToCancel implements Runnable, BAsyncResult<ByteBuffer>, Comparable<RequestToCancel> {

    final ERequestDirection requestDirection;
    final long messageId;
    final long streamId;
    final long cancelMessageId;
    final BAsyncResult<BMessage> asyncResult;
    final AtomicBoolean isOpen = new AtomicBoolean(true);
    final int timeoutSecondsRequest;
    HHttpRequest httpRequest;

    protected RequestToCancel(long messageId, long streamId, long cancelMessageId, BAsyncResult<BMessage> asyncResult) {
      this.requestDirection = ERequestDirection.FORWARD;
      this.messageId = messageId;
      this.streamId = streamId;
      this.cancelMessageId = cancelMessageId;
      this.timeoutSecondsRequest = 0;
      this.asyncResult = asyncResult;
    }

    public void setHttpRequest(HHttpRequest httpRequest) {
      this.httpRequest = httpRequest;
    }

    @Override
    public void run() {
      httpRequest.run();
    }

    public void setAsyncResult(ByteBuffer buf, Throwable e) {
      if (log.isDebugEnabled()) log.debug("setAsyncResult" + this + "(");
      try {
        if (isOpen.getAndSet(false) && asyncResult != null) {
          if (e == null && buf != null && buf.remaining() != 0) {
            BMessageHeader header = new BMessageHeader();
            try {
              if (BNegotiate.isNegotiateMessage(buf)) {
                
                BNegotiate nego = new BNegotiate();
                nego.read(buf);

                header.messageObject = nego;
                header.messageId = messageId;

                applyNegotiateForUtilityRequests(nego);
              }
              else {
                header.read(buf);
              }
              BMessage msg = new BMessage(header, buf, null);
              asyncResult.setAsyncResult(msg, null);
            }
            catch (BException ex) {
              asyncResult.setAsyncResult(null, ex);
            }
          }
          else {
            asyncResult.setAsyncResult(null, e);
          }
        }
      }
      catch (Exception ex) {
        log.error("Failed to read response.", ex);
      }
      finally {
        // Remove request from HWireClient's internal map of requests.
        HWireClient.this.removeRequest(this);
      }
      if (log.isDebugEnabled()) log.debug(")setAsyncResult");
    }

    public void cancel() {
      if (log.isDebugEnabled()) log.debug("cancel" + this + "(");
      httpRequest.cancel();
      if (log.isDebugEnabled()) log.debug(")cancel");
    }

    @Override
    public int compareTo(RequestToCancel o) {
      if (messageId < o.messageId) return -1;
      if (messageId > o.messageId) return 1;
      if (streamId < o.streamId) return -1;
      if (streamId > o.streamId) return 1;
      if (cancelMessageId < o.cancelMessageId) return -1;
      if (cancelMessageId > o.cancelMessageId) return 1;
      return 0;
    }

    @Override
    public String toString() {
      StringBuilder sbuf = new StringBuilder();
      sbuf.append("[").append(messageId);
      if (cancelMessageId != 0) sbuf.append(",cancelMessageId=").append(cancelMessageId);
      sbuf.append(",httpRequest=").append(System.identityHashCode(httpRequest));
      sbuf.append("]");
      return sbuf.toString();
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + getOuterType().hashCode();
      result = prime * result + (int) (cancelMessageId ^ (cancelMessageId >>> 32));
      result = prime * result + (int) (messageId ^ (messageId >>> 32));
      result = prime * result + (int) (streamId ^ (streamId >>> 32));
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null) return false;
      if (getClass() != obj.getClass()) return false;
      RequestToCancel other = (RequestToCancel) obj;
      if (!getOuterType().equals(other.getOuterType())) return false;
      if (cancelMessageId != other.cancelMessageId) return false;
      if (messageId != other.messageId) return false;
      if (streamId != other.streamId) return false;
      return true;
    }

    private HWireClient getOuterType() {
      return HWireClient.this;
    }
  }

  protected class MyInputStream extends InputStreamWrapper implements BAsyncResult<BContentStream> {

    volatile RequestToCancel request;
    volatile HttpURLConnection conn;
    volatile Throwable ex;
    private final long trackingId;

    public MyInputStream(long trackingId, BTargetId targetId) {
      super(targetId);
      this.trackingId = trackingId;
    }

    @Override
    public void setAsyncResult(BContentStream stream, Throwable e) {
      this.ex = e;
      if (e == null) {
        this.innerStream = stream;
        this.copyProperties(stream);
      }
    }

    void throwExceptionIf() throws IOException {
      Throwable e = ex;
      if (e == null) return;
      if (e instanceof IOException) {
        throw (IOException) e;
      }
      else {
        throw new BException(BExceptionC.CANCELLED, "", e);
      }
    }

    @Override
    public InputStream ensureStream() throws IOException {
      throwExceptionIf();
      return super.ensureStream();
    }
    
    @Override
    protected InputStream openStream() throws IOException {
      if (log.isDebugEnabled()) log.debug("openStream(");
      InputStream is = null;

      final BContentStreamAsyncCallback streamCallback = getAsyncCallback();
      if (streamCallback != null) {

        BAsyncResult<BContentStream> asyncResult = new BAsyncResult<BContentStream>() {

          public void setAsyncResult(BContentStream stream, Throwable ex) {
            if (ex == null) {
              try {
                streamCallback.onReceivedContentType(stream.getContentType());
                streamCallback.onReceivedContentLength(stream.getContentLength());

                byte[] buf = new byte[10 * 1000];
                int len = 0;
                boolean succ = true;
                while ((len = stream.read(buf)) != -1) {
                  if (succ) {
                    succ = streamCallback.onReceivedData(buf, len);
                  }
                }
              }
              catch (Throwable e) {
                streamCallback.onReceivedException(e);
              }

            }
            else {
              streamCallback.onReceivedException(ex);
            }

            streamCallback.onFinished();
          }
        };

        internalOpenStream(asyncResult);

        // Return empty stream to prevent NPE
        is = new InputStream() {
          public int read() throws IOException {
            return -1;
          }
        };

      }
      else {

        BSyncResult<BContentStream> syncResult = new BSyncResult<BContentStream>() {
          public void setAsyncResult(BContentStream stream, Throwable ex) {

            // Set members this.innerStream, this.contentType,
            // this.contentLength
            MyInputStream.this.setAsyncResult(stream, ex);

            // Release thread which is waiting in syncResult.getResult()
            super.setAsyncResult(stream, ex);
          }
        };

        internalOpenStream(syncResult);

        is = syncResult.getResult();
      }

      if (log.isDebugEnabled()) log.debug(")openStream=" + is);
      return is;
    }

    protected void internalOpenStream(BAsyncResult<BContentStream> asyncResult) throws IOException {
      if (log.isDebugEnabled()) log.debug("internalOpenStream(");
      RequestToCancel requestToCancel = createRequestForGetStream(trackingId, targetId, asyncResult);
      executeRequest(requestToCancel);
      if (log.isDebugEnabled()) log.debug(")internalOpenStream");
    }

    @Override
    public void close() throws IOException {
      super.close();
    }

  }

  @Override
  public BContentStream getStream(long trackingId, BTargetId targetId) throws IOException {
    if (log.isDebugEnabled()) log.debug("getStream(" + targetId);
    BContentStream is = new MyInputStream(trackingId, targetId);
    if (log.isDebugEnabled()) log.debug(")getStream=" + is);
    return is;
  }

  protected void internalCancelAllRequests(long cancelMessageId) {
    if (log.isDebugEnabled()) log.debug("internalCancelAllRequests(");

    ArrayList<RequestToCancel> arr = new ArrayList<RequestToCancel>(openRequestsToCancel.keys());
    openRequestsToCancel.clear();

    if (log.isDebugEnabled()) log.debug("cancel requests on client, #requests=" + arr.size());
    for (RequestToCancel robj : arr) {
      robj.cancel();
    }

    // Notify the server about the canceled messages
    if (cancelMessageId != 0) {
      sendCancelMessage(cancelMessageId);
    }

    if (log.isDebugEnabled()) log.debug(")internalCancelAllRequests");
  }

  @Override
  public void done() {

    internalCancelAllRequests(MESSAGEID_DISCONNECT);

    isDone = true;

    if (isMyThreadPool) {
      if (threadPool instanceof ExecutorService) {
        ExecutorService tp = (ExecutorService) threadPool;
        tp.shutdown();
      }
    }
    
    httpClient.done();
  }

  protected void addRequest(RequestToCancel robj) {
    if (log.isDebugEnabled()) log.debug("addRequest(robj=" + robj);
    openRequestsToCancel.put(robj, Boolean.TRUE);
    if (log.isDebugEnabled()) log.debug(")addRequest=" + robj);
  }

  protected void removeRequest(RequestToCancel robj) {
    if (log.isDebugEnabled()) log.debug("removeRequest(" + robj);
    if (robj == null) return;
    openRequestsToCancel.remove(robj);
    if (log.isDebugEnabled()) log.debug(")removeRequest");
  }
  
  protected RequestToCancel findRequest(long messageId) {
    RequestToCancel ret = null;
    Collection<RequestToCancel> copyOfRequests = openRequestsToCancel.keys();
    for (RequestToCancel req : copyOfRequests) {
      if (req.messageId == messageId) {
        ret = req;
        break;
      }
    }
    return ret;
  }
  
  protected BAsyncResult<BMessage> replaceAsyncResultOfRequestForPollProcessing(long messageId, BAsyncResult<BMessage> asyncResult) {
    BAsyncResult<BMessage> ret = null;
    RequestToCancel request = findRequest(messageId);
    if (request != null) {
      BAsyncResult<BMessage> allResults = request.asyncResult;
      if (allResults instanceof AsyncResultAfterAllRequests) {
        ((AsyncResultAfterAllRequests)allResults).setInnerMethodResult(asyncResult);
        ret = allResults;
      }
    }
    return ret;
  }

  /**
   * Cancel a message on the server side.
   * 
   * @param messageId
   *          Either a message ID or -1, if all messages of the session should
   *          be canceled
   */
  protected void sendCancelMessage(final long messageId) {
    if (log.isDebugEnabled()) log.debug("sendCancelMessage(messageId=" + messageId);
    try {
      BClient_BUtilityRequests bclientU = clientUtilityRequests;
      if (bclientU != null) {
        bclientU.getBUtilityRequests().cancelMessage(messageId);
      }
      else {
        RequestToCancel r = createRequestForCancelMessage(messageId);
        executeRequest(r);
      }
    }
    catch (Exception e) {
      log.debug("Exception", e);
    }
    if (log.isDebugEnabled()) log.debug(")sendCancelMessage");
  }

  String testAdapter(String fnct, String[] args) {
    if (log.isDebugEnabled()) log.debug("testAdapter(fnct=" + fnct + ", " + Arrays.toString(args));

    String ret = "";

    if (fnct.equals(HTestAdapter.KILL_CONNECTIONS)) {
      internalCancelAllRequests(0);
      return ret;
    }

    try {
      HashMap<String,String> map = new HashMap<String,String>();
      if (args != null) {
        for (int i = 0; i < args.length; i+=2) {
          map.put(args[i], i < args.length-1 ? args[i+1] : "");
        }
      }
      
      BClient_BUtilityRequests bclientU = clientUtilityRequests;
      Map<String,String> rmap = bclientU.getBUtilityRequests().testAdapter(fnct, map);
      ret = rmap != null && rmap.size() != 0 ? rmap.entrySet().iterator().next().getValue() : "";
    }
    catch (IOException ignored) {
      log.debug("ignored=" + ignored);
    }

    if (log.isDebugEnabled()) log.debug(")testAdapter=" + ret);
    return ret;
  }

  @Override
  public synchronized Statistics getStatistics() {
    return new Statistics(stats);
  }

  @Override
  public synchronized void clearStatistics() {
    stats = new Statistics();
  }

  @Override
  public BTestAdapter getTestAdapter() {
    return testAdapter;
  }

  /**
   * Gets the servlet path for negotiation and authentication. A request for
   * HTTP authentication should be sent to a different sub directory of the web
   * application. E.g. while http://server/app/byps is the URL for BYPS
   * communication, authentication requests are sent to
   * http://server/app/bypsauth/auth. The reason for this is that some browsers
   * initiate the authentication handshake in each request if the first one has
   * had to be authenticated.
   * In order to support HTTP authentication, this function has to be overridden.
   * The default implementation returns the servlet path.
   * 
   * @return servlet path of the URL that was passed in the constructor, e.g. "/byps". 
   */
  public String getServletPathForNegotiationAndAuthentication() {
    String authUrl = surl;
    int p = authUrl.lastIndexOf('/');
    if (p >= 0) {
      authUrl = authUrl.substring(p);
    }
    return authUrl;
  }

  /**
   * Gets the servlet path for reverse HTTP requests. Reverse requests can be
   * sent to a different sub directory of the web application. This is useful if
   * a load balancer or proxy redirects the requests, because it allows to
   * specify a special timeout for long polls.
   * 
   * @return servlet path of the URL that was passed in the constructor, e.g.
   *         /byps
   */
  public String getServletPathForReverseRequest() {
    String longUrl = surl;
    int p = longUrl.lastIndexOf('/');
    if (p >= 0) {
      longUrl = longUrl.substring(p);
    }
    return longUrl;
  }

  private StringBuilder getUrlStringBuilder(String servletPath) {
    StringBuilder sbuf = new StringBuilder();
    if (servletPath.length() != 0) {
      int p = surl.lastIndexOf("/");
      if (p < 0) p = surl.length();
      sbuf.append(surl.substring(0, p));
      sbuf.append(servletPath);
    }
    else {
      sbuf.append(surl);
    }

    // We always want to start adding new parameters with '&'.
    // That's why somthing has to be added to the url which currently ends with '?'
    sbuf.append("?a=a");
    
    return sbuf;
  }
  
  public String toString() {
    return "[url=" + surl + ", #openreq=" + openRequestsToCancel.size() + ", done=" + isDone + "]";
  }

  public HHttpClient getHttpClient() {
    return this.httpClient;
  }

  public String getHttpSession() {
    return getHttpClient().getHttpSession();
  }

  /**
   * Set HTTP cookie.
   * Adds or replaces a HTTP cookie.  
   * Ensure that at least name, value, domain, path are set in the given cookie.  
   * @param cookie Session cookie.
   */
  public void setHttpCookie(HttpCookie cookie) {
    getHttpClient().setHttpCookie(cookie);
  }

  /**
   * Get HTTP session cookie.
   * Gets the cookie with the given name. 
   * @param name Cookie name, e.g. HConstants.HTTP_COOKIE_JSESSIONID
   * @return Session cookie.
   */
  public HttpCookie getHttpCookie(String name) {
    return getHttpClient().getHttpCookie(name);
  }

  private volatile BClient_BUtilityRequests clientUtilityRequests;
  
  public void applyNegotiateForUtilityRequests(BNegotiate nego) throws BException {
    if (nego.sessionId != null && nego.sessionId.length() != 0 && !nego.sessionId.equals(BTargetId.SESSIONID_ZERO)) {
      if (log.isDebugEnabled()) log.debug("utility requests supported");
      BApiDescriptor apiDesc = BApiDescriptor_BUtilityRequests.instance();
      apiDesc.addRegistry(new BRegistry_BUtilityRequests());
      apiDesc.addRegistry(new JRegistry_BUtilityRequests());
      final BTransportFactory transportFactory = new HTransportFactoryClient(apiDesc, this, 0); 
      BClient_BUtilityRequests bclient = BClient_BUtilityRequests.createClient(transportFactory);
      BTransport utransport = bclient.getTransport(); 
      utransport.applyNegotiate(nego);
      clientUtilityRequests = bclient;
    }
  }

}
