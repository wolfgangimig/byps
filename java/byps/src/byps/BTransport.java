package byps;

import java.lang.ref.WeakReference;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BTransport {

  private final BApiDescriptor apiDesc;

  private final BWire wire;

  private final BServerRegistry serverRegistry;

  private BTargetId targetId;
  
  private String sessionId;
  
  /**
   * Server ID to which this BTransport is connected.
   * If this object belongs to a foreign interface, 
   * the connectedServerId is not equal to targetId.serverId.
   * This value is used as serverId for streams to be sent.
   */
  private int connectedServerId;

  private BProtocol protocol;

  protected BAuthentication authentication;
  
  protected WeakReference<BClient> clientHelperToInjectInBValueClass;
  
  protected static final AtomicLong requestCounter = new AtomicLong();
  
  public BTransport(BApiDescriptor apiDesc, BWire wire, BServerRegistry serverRegistry) {
    this.apiDesc = apiDesc;
    this.wire = wire;
    this.targetId = BTargetId.ZERO;
    this.sessionId = BTargetId.SESSIONID_ZERO;
    this.serverRegistry = serverRegistry;
  }

  public BTransport(BTransport rhs, BTargetId targetId) {
    this.apiDesc = rhs.apiDesc;
    this.wire = rhs.wire;
    this.targetId = targetId;
    this.sessionId = rhs.sessionId;
    this.protocol = rhs.getProtocol();
    this.clientHelperToInjectInBValueClass = rhs.clientHelperToInjectInBValueClass;
    
    // This constructor is called, if a stub maybe from another client is deserialized.
    // We cannot use the same authentication here, because the other client can only 
    // authenticate this stub.
    this.authentication = null;
    
    this.serverRegistry = null;
  
    // Still connected to the server given by rhs.
    this.connectedServerId = rhs.targetId.getServerId();
  }
  
  /**
   * Initialization to obtain a transport for a BProxy_* class inside a server.
   * @param rhs Base transport object. 
   * @param wire Wire object maybe with its own cookie manager.  
   */
  public BTransport(BTransport rhs, BWire wire) {
    
    // Values that can be copied.
    this.apiDesc = rhs.apiDesc;
    this.protocol = rhs.protocol;
    this.serverRegistry = rhs.serverRegistry;
    this.targetId = rhs.targetId;
    this.clientHelperToInjectInBValueClass = rhs.clientHelperToInjectInBValueClass;

    // A new authenticator should be obtained via BTransport.setAuthentication()  
    // if authentication is required in your scenario.
    this.authentication = null;

    // BTransport.negotiateProtocolClient should follow this copy constructor
    // to set user specific session.  
    this.sessionId = null;

    this.wire = wire;
  }
  
  public BWire getWire() {
    return wire;
  }
  
  public BApiDescriptor getApiDesc() {
    return apiDesc;
  }

  public BServerRegistry getServerRegistry() {
    return serverRegistry;
  }
  
  public synchronized void setProtocol(BProtocol protocol) {
    this.protocol = protocol;
  }

  public synchronized BProtocol getProtocol() {
    return protocol;
  }

  public synchronized void applyNegotiate(BNegotiate negoResponse) throws BException {
    BNegotiate nego = new BNegotiate(negoResponse);
    protocol = createNegotiatedProtocol(nego);
    setSessionId(negoResponse.sessionId);
    setTargetId(negoResponse.targetId);
    if (log.isDebugEnabled()) log.debug("targetId=" + targetId + ", protocol=" + protocol);
  }
  
  public synchronized BOutput getOutput() throws BException {
    if (protocol == null) throw new BException(BExceptionC.INTERNAL, "No protocol negotiated.");
    return protocol.getOutput(this, null);
  }

  public synchronized BOutput getResponse(BMessageHeader requestHeader) throws BException {
    if (protocol == null) throw new BException(BExceptionC.INTERNAL, "No protocol negotiated.");
    BMessageHeader responseHeader = requestHeader.createResponse();
    BOutput bout = null;
    
    if (protocol instanceof BProtocolS) {
      if (!responseHeader.isBinaryMessage()) {
        bout = new BOutputJson(this, responseHeader);
      }
    }
    else {
      if (responseHeader.isBinaryMessage()) {
        throw new BException(BExceptionC.CORRUPT, "JSON protocol expected.");
      }
    }
    
    if (bout == null) {
      bout = protocol.getOutput(this, responseHeader);
    }
    
    return bout;
  }

  public synchronized BInput getInput(BMessageHeader header, ByteBuffer buf) throws BException {
    BInput bin = null;

    // header is null in the test cases that check serialization.
    if (header == null) {
      header = new BMessageHeader();
      header.read(buf);
    }

    if (protocol == null) throw new BException(BExceptionC.INTERNAL, "No protocol negotiated.");
    
    if (protocol instanceof BProtocolS) {
      if (!header.isBinaryMessage()) {
        bin = new BInputJson(header, buf, this);
      }
    }
    else {
      if (header.isBinaryMessage()) {
        throw new BException(BExceptionC.CORRUPT, "JSON protocol expected.");
      }
    }

    if (bin == null) {
      bin = protocol.getInput(this, header, buf);
    }
    
    return bin;
  }
  
  public <T> void sendMethod(final BMethodRequest methodRequest, final BAsyncResult<T> asyncResult) {
    BAsyncResultReceiveMethod<T> outerResult = new BAsyncResultReceiveMethod<T>(asyncResult);
    assignSessionThenSendMethod(methodRequest, outerResult);
  }
  
  protected <T> void assignSessionThenSendMethod(final BMethodRequest methodRequest, final BAsyncResult<T> asyncResult) {
    
    if (protocol == null) {
      Throwable exception = new BException(BExceptionC.INTERNAL, "No protocol negotiated.");
      asyncResult.setAsyncResult(null, exception);
    }
    else if (authentication != null) {

      try {
        final int typeId = protocol.getRegistry().getSerializer(methodRequest, true).typeId;

        BAsyncResult<Object> sessionResult = new BAsyncResult<Object>() {
          
          public void setAsyncResult(Object session, Throwable ex) {
            
            if (ex != null) {
              
              boolean relogin = internalIsReloginException(ex, typeId);
              if (relogin) {
                reloginAndRetrySend(methodRequest, asyncResult);
              }
              else {
                asyncResult.setAsyncResult(null, ex);
              }
            }
            else {
              
              methodRequest.setSession(session);
              BTransport.this.send(methodRequest, asyncResult);
            }
          }
        };
        
        authentication.getSession(null, typeId, sessionResult);
      }
      catch (BException e) {
        asyncResult.setAsyncResult(null, e);
      }
      
    }
    else {
      BTransport.this.send(methodRequest, asyncResult);
    }
  }
  
  /**
   * This class processes a BMessage received from the server.
   * In {@link BTransport#send(Object, BAsyncResult)} the object to sent is 
   * serialized into a BMessage and sent to the server. The server receives
   * a BMessage as response which is de-serialized in this class to a 
   * result object. The result is passed to the BAsyncResult provied in the
   * constructor.
   * If the server sends a re-login exception a new authentication is processed
   * and the message is sent again. If the server sends a {@link BExceptionC#PROCESSING} 
   * exception, an empty message with the same header is sent to provide a
   * new channel to receive the response. 
   * BYPS-9: Avoid socket exception while uploading large files.
   * @param <T> Type of result object
   */
  private class SendMessageResult<T> implements BAsyncResult<BMessage> {
    
    /**
     * Header of the request message.
     */
    private final BMessageHeader header;
    /**
     * Object to be sent.
     * This object is casted to a BMethodRequest.
     */
    private final Object obj;
    /**
     * Request number.
     * Used for logging.
     */
    private final long requestId;
    /**
     * Asynchronous result.
     */
    private final BAsyncResult<T> asyncResult;
    /**
     * Start time of processing.
     */
    private final long t0 = System.currentTimeMillis();
    
    /**
     * Initialize by parameters from within {@link BTransport#send(Object, BAsyncResult)}.
     * @param header Message header.
     * @param obj Object to be sent. Must be a BMethodRequest.
     * @param requestId Request number, used for logging.
     * @param asyncResult Asynchronous result.
     */
    public SendMessageResult(BMessageHeader header, Object obj, long requestId, BAsyncResult<T> asyncResult) {
      this.header = header;
      this.obj = obj;
      this.requestId = requestId;
      this.asyncResult = asyncResult;
    }

    /**
     * This constructor is used to clone the previous result object if a {@link BExceptionC#PROCESSING} has occured.
     * @param prevResult Previous result object.
     */
    public SendMessageResult(SendMessageResult<T> prevResult) {
      this.header = prevResult.header;
      this.obj = prevResult.obj;
      this.requestId = prevResult.requestId;
      this.asyncResult = prevResult.asyncResult;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setAsyncResult(BMessage msgRecv, Throwable e) {
      if (log.isDebugEnabled()) log.debug("setAsyncResult(" + msgRecv + ", ex=" + e);

      T ret = null;
      Throwable rex = e;
      int typeId = 0;

      try {
        
        // Get typeId of request object. Required to process a re-login exception.
        typeId = protocol.getRegistry().getSerializer(obj, true).typeId;
        
        // If there was no Socket exception and HTTP response code was 200...
        if (e == null) {
          
          // De-serialize the result object.
          final BInput bin = getInput(msgRecv.header, msgRecv.buf);
          if (log.isDebugEnabled()) log.debug("load object");
          ret = (T) bin.load();
        }

      } catch (Throwable ex) {
        
        // The server sent an exception in the request body.
        // This is the ordinary way for the server to pass an error result.
        
        if (log.isDebugEnabled()) log.debug("Received exception.", ex);
        rex = ex;
      }

      // BYPS or Application relogin error? (HTTP 401)
      if (internalIsReloginException(rex, typeId)) {

        logResponse(ret, rex, "relogin");
        
        // Authenticate and send the message again.
        
        // The server is responsible for killing long-polls of invalid sessions.
        // So we do not need to stop the serverR before re-login.
        
        reloginAndRetrySend((BMethodRequest)obj, asyncResult);

      }
      
      // Processing exception, HTTP 202
      else if (isProcessingException(rex)) {
        
        logResponse(ret, rex, "processing");
        
        // The server still works on the message.
        // Send a poll message with the same message ID and a dummy object to have a payload.
        // The server responds to this message, when it has finished.
        // BYPS-9: Avoid socket exception while uploading large files.
        
        try {
          BMessageHeader pollHeader = new BMessageHeader(header);
          pollHeader.flags &= ~BMessageHeader.FLAG_RESPONSE;
          pollHeader.flags |= BMessageHeader.FLAG_POLL_PROCESSING;
          BOutput bout = protocol.getOutput(BTransport.this, pollHeader);
          bout.store(new BValueClass());
          BMessage pollMsg = bout.toMessage(requestId);
          wire.send(pollMsg, new SendMessageResult<T>(this));
        }
        catch (Exception ex) {
          if (log.isWarnEnabled()) log.warn("Processing status cannot be polled", ex);
          asyncResult.setAsyncResult(ret, rex);
        }
      }
      
      // Success or other error.
      else {
        
        logResponse(ret, rex, null);

        asyncResult.setAsyncResult(ret, rex);
      }
      
      if (log.isDebugEnabled()) log.debug(")setAsyncResult");
    }
    
    /**
     * Print response data into log file.
     * @param ret Response object
     * @param rex Exception
     * @param hint "relogin" or "processing" or empty
     */
    private void logResponse(T ret, Throwable rex, String hint) {
      if (printRequestIntoLogger && log.isInfoEnabled()) {
        long t1 = System.currentTimeMillis();
        StringBuilder sbuf = new StringBuilder();
        sbuf.append("send-").append(requestId).append(" [").append(t1 - t0).append("]");
        sbuf.append(" Response=");
        if (hint != null && !hint.isEmpty()) {
          sbuf.append(hint);
        }
        else if (rex != null) {
          sbuf.append(rex);
        }
        else {
          sbuf.append(ret);
        }
        log.info("{}", sbuf);
      }
    }

    /**
     * Test whether the given exception is a {@link BExceptionC#PROCESSING}.
     * @param e Exception
     * @return true, if e is a {@link BExceptionC#PROCESSING}.
     */
    private boolean isProcessingException(Throwable e) {
      boolean ret = false;
      if (e instanceof BException) {
        BException bex = (BException)e;
        ret = bex.code == BExceptionC.PROCESSING;
      }
      return ret;
    }
    
  }

  public <T> void send(final Object obj, final BAsyncResult<T> asyncResult) {
    if (log.isDebugEnabled()) log.debug("send(obj=" + obj + ", asyncResult=" + asyncResult);
    
    final long requestId = requestCounter.incrementAndGet(); 
    if (printRequestIntoLogger && log.isInfoEnabled()) log.info("send-" + requestId + " Request=" + obj);
    
    try {
      
      // Store object into message.
      if (log.isDebugEnabled()) log.debug("store object");
      final BOutput bout = getOutput();
      bout.store(obj);
      final BMessage msgSend = bout.toMessage(requestId);
      
      // Wrap asyncResult to handle re-login and processing response.
      final BAsyncResult<BMessage> outerResult = new SendMessageResult<T>(bout.header, obj, requestId, asyncResult);

      // Send request.
      wire.send(msgSend, outerResult);
      
    } catch (Throwable e) {
      if (log.isDebugEnabled()) log.debug("Failed to serialize object", e);
      asyncResult.setAsyncResult(null, e);
    }

    if (log.isDebugEnabled()) log.debug(")send");
  }

  protected <T> void reloginAndRetrySend(final BMethodRequest methodRequest, final BAsyncResult<T> asyncResult) {
    if (log.isDebugEnabled()) log.debug("re-login");
    try {
      final BAsyncResult<Boolean> loginResult = new BAsyncResult<Boolean>() {
        
        public void setAsyncResult(Boolean succ, Throwable e2) {
          if (log.isDebugEnabled()) log.debug("auth.login asyncResult=" + succ + ", ex=" + e2);
          if (e2 != null) {
            asyncResult.setAsyncResult(null, e2);
          }
          else {
            // Send again
            BTransport.this.assignSessionThenSendMethod(methodRequest, asyncResult);
          }
        };
      };

      negotiateProtocolClient(loginResult);

    } catch (Throwable ex2) {
      asyncResult.setAsyncResult(null, ex2);
    }
  }
  
  public void recv(BServer server, BMessage msg, final BAsyncResult<BMessage> asyncResult) {
    if (log.isDebugEnabled()) log.debug("recv(");
    final long requestId = requestCounter.incrementAndGet(); 
    final long t0 = System.currentTimeMillis();
    BAsyncResult<?> asyncResultForException = asyncResult;
    try {
      
      final BInput bin = getInput(msg.header, msg.buf);
  
      final BAsyncResult<Object> methodResult = new BAsyncResult<Object>() {
  
        @Override
        public void setAsyncResult(Object obj, Throwable e) {
          if (log.isDebugEnabled()) log.debug("setAsyncResultOrException(");
          
          if (printRequestIntoLogger && log.isInfoEnabled()) {
            long t1 = System.currentTimeMillis();
            Object resp = e != null ? e : obj;
            log.info("recv-" + requestId + " [" + (t1-t0) + "] Response=" + resp);
            if (e != null) {
              log.info("exception", e);
            }
          }

          try {
            BOutput bout = getResponse(bin.header);
            if (e != null) {
              if (log.isDebugEnabled()) log.debug("exception:", e);
              bout.setException(e);
            }
            else {
              bout.store(obj);
            }
            final BMessage msg = bout.toMessage(requestId);
            asyncResult.setAsyncResult(msg, null);
            
          } catch (BException ex) {
            
            // Try to send the exception to the other part
            try {
              BOutput bout = getResponse(bin.header);
              bout.setException(ex);
              final BMessage msg = bout.toMessage(requestId);
              asyncResult.setAsyncResult(msg, null);
            }
            catch (BException ex2) {
              
              // Process the error in this part. 
              // The server side will return a HTTP 500.
              asyncResult.setAsyncResult(null, ex2);
            }
          }
          if (log.isDebugEnabled()) log.debug(")setAsyncResultOrException");
        }
  
      };
      
      asyncResultForException = methodResult;

      // server-side: Target ID might be encrypted
      final BTargetId targetIdEncr = bin.header.targetId;
      final BTargetId clientTargetId = (serverRegistry != null) ? serverRegistry.encryptTargetId(targetIdEncr, false) : targetIdEncr;
      
      // Does the clientTargetId belong to another server?
      // If so, get the BClient object to forward the message.
      final BClient client = (serverRegistry != null) ? serverRegistry.getForwardClientIfForeignTargetId(clientTargetId) : null;

      // Read message
      final Object methodObj = bin.load();
      if (log.isDebugEnabled()) log.debug("messageId=" + bin.header.messageId);
      if (printRequestIntoLogger && log.isInfoEnabled()) log.info("recv-" + requestId + " Request=" + methodObj);
      
      // Forward message to other server?
      if (client != null) {
        forwardMessage(client, clientTargetId, methodObj, methodResult);
      }
      else {
        // Serve the message here.
        server.recv(clientTargetId, methodObj, methodResult);
      }
      
    } catch (Exception e) {
      
      if (printRequestIntoLogger && asyncResultForException == asyncResult && log.isInfoEnabled()) {
        long t1 = System.currentTimeMillis();
        log.info("recv-" + requestId + " [" + (t1-t0) + "] Response=" + e);
      }

      asyncResultForException.setAsyncResult(null, e);
    }

    if (log.isDebugEnabled()) log.debug(")recv");
  }

  protected void forwardMessage(final BClient client, final BTargetId clientTargetId, final Object methodObj, final BAsyncResult<Object> methodResult) throws BException {
//    BOutput bout = client.getTransport().getOutput();
//    bout.header.targetId = clientTargetId;
//    bout.store(methodObj);
//    BMessage forwardMessage = bout.toMessage();
//
//    BAsyncResult<BMessage> messageResult = new BAsyncResult<BMessage>() {
//      public void setAsyncResult(BMessage result, Throwable ex) {
//        try {
//          if (ex != null) {
//            methodResult.setAsyncResult(null, ex);
//          }
//          else {
//            BInput bin = client.getTransport().getInput(result.header, result.buf);
//            Object obj = bin.load();
//            methodResult.setAsyncResult(obj, null);
//          }
//        } catch (Exception e) {
//          methodResult.setAsyncResult(null, e);
//        }
//      }
//    };
//
//    client.getTransport().wire.send(forwardMessage, messageResult);
    
    BAsyncResult<Object> outerResult = new BAsyncResult<Object>() {

      @Override
      public void setAsyncResult(Object result, Throwable exception) {
        methodResult.setAsyncResult(result, exception);
      }
      
    };
    
    client.getTransport().send(methodObj, outerResult);
  }

  public void negotiateProtocolClient(final BAsyncResult<Boolean> asyncResult) {
    if (log.isDebugEnabled()) log.debug("negotiateProtocolClient(");
    
    try {
      if (log.isDebugEnabled()) log.debug("build nego message");
      ByteBuffer buf = ByteBuffer.allocate(BNegotiate.NEGOTIATE_MAX_SIZE);
      final BNegotiate negoRequest = new BNegotiate(apiDesc);
      negoRequest.write(buf);
      buf.flip();
  
      BAsyncResult<BMessage> outerResult = new BAsyncResult<BMessage>() {
  
        @Override
        public void setAsyncResult(BMessage msg, Throwable e) {
          try {
            if (log.isDebugEnabled()) log.debug("nego result=" + msg + ", ex=" + e);
            if (e == null) {
              
              BNegotiate negoResponse = null;
              if (msg.header.messageObject != null) {
                negoResponse = (BNegotiate)msg.header.messageObject;
              }
              else {
                negoResponse = new BNegotiate();
                negoResponse.read(msg.buf);
              }

              applyNegotiate(negoResponse);
  
              internalAuthenticate(asyncResult);
            }
            else {
              asyncResult.setAsyncResult(Boolean.FALSE, e);
            }
          } catch (Throwable ex) {
            asyncResult.setAsyncResult(Boolean.FALSE, ex);
          }
        }
  
      };
  
      if (log.isDebugEnabled()) log.debug("send nego");
      BMessageHeader header = new BMessageHeader();
      header.messageId = wire.makeMessageId();
      final BMessage msg = new BMessage(header, buf, null);
      wire.send(msg, outerResult);
      
    }
    catch (Throwable e) {
      if (log.isDebugEnabled()) log.debug("nego failed, ", e);
      asyncResult.setAsyncResult(Boolean.FALSE, e);
    }

    if (log.isDebugEnabled()) log.debug(")negotiateProtocolClient");
 }

  protected void internalAuthenticate(final BAsyncResult<Boolean> asyncResult) {

    if (log.isDebugEnabled()) log.debug("internalAuthenticate(");

    // Authentication enabled?
    if (authentication != null) {

      if (log.isDebugEnabled()) log.debug("call authenticate");
      authentication.authenticate(null, asyncResult);
    }
    
    // Authentication is not used. The session is valid per definition.
    else {
      asyncResult.setAsyncResult(Boolean.FALSE, null);
    }

    if (log.isDebugEnabled()) log.debug(")internalAuthenticate");
  }

  private BProtocol createNegotiatedProtocol(BNegotiate nego) throws BException {
    BProtocol protocol = null;

    if (nego.protocols.startsWith(BProtocolS.BINARY_MODEL.getProtocolId())) {
      int negotiatedBypsVersion = Math.min(BMessageHeader.BYPS_VERSION_CURRENT, nego.bversion);
      long negotiatedVersion = Math.min(apiDesc.version, nego.version);
      nego.protocols = BProtocolS.BINARY_MODEL.getProtocolId();
      if (nego.byteOrder == null) nego.byteOrder = ByteOrder.BIG_ENDIAN;
      nego.version = negotiatedVersion;
      nego.bversion = negotiatedBypsVersion;
      protocol = new BProtocolS(apiDesc, negotiatedBypsVersion, negotiatedVersion, nego.byteOrder);
    }
    else if (nego.protocols.startsWith(BProtocolJson.BINARY_MODEL.getProtocolId())) {
      nego.protocols = BProtocolJson.BINARY_MODEL.getProtocolId();
      protocol = new BProtocolJson(apiDesc);
    }
    else {
      throw new BException(BExceptionC.CORRUPT, "Protocol negotiation failed.");
    }

    return protocol;
  }

  protected BProtocol negotiateProtocolServer(BTargetId targetId, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult) {
    BProtocol ret = null;
    try {
      BNegotiate nego = new BNegotiate();
      nego.read(buf);

      synchronized (this) {
        this.protocol = ret = createNegotiatedProtocol(nego);
        setSessionId(targetId.toSessionId());
        setTargetId(targetId);
      }

      ByteBuffer bout = ByteBuffer.allocate(BNegotiate.NEGOTIATE_MAX_SIZE);
      try {
        nego.targetId = targetId;
        nego.sessionId = targetId.toSessionId();
        nego.write(bout);
        bout.flip();
        asyncResult.setAsyncResult(bout, null);
      } finally {
      }

    } catch (Throwable e) {
      asyncResult.setAsyncResult(null, e);
    }
    return ret;
  }

  public synchronized BTargetId getTargetId() {
    return targetId;
  }

  public synchronized void setTargetId(BTargetId v) {
    this.targetId = v;
    this.connectedServerId = v.getServerId();
  }
  
  public synchronized String getSessionId() {
    return sessionId;
  }

  public synchronized void setSessionId(String sessionId) {
    this.sessionId = sessionId;
  }

  public synchronized int getConnectedServerId() {
    return this.connectedServerId;
  }

  public String toString() {
    return "[" + targetId + ", wire=" + wire + "]";
  }
  
  protected boolean internalIsReloginException(Throwable ex, int typeId) {
    if (log.isDebugEnabled()) log.debug("isReloginException(ex=" + ex);

    boolean ret = false;
    
    if (authentication != null && ex != null) {
      ret = authentication.isReloginException(null, ex, typeId);
    }

    if (log.isDebugEnabled()) log.debug(")internalIsReloginException=" + ret);
    return ret;
  }

  /**
   * Returns true, if a re-login should be performed.
   * This function can be called from an implementation of the BAuthentication interface.
   * It returns true, if the given exception was caused by a HTTP 403 error or
   * if it is a BException and contains the code BExceptionO.AUTHENTICATION_REQUIRED.
   * @param ex Exception
   * @param typeId Type ID (serialVersionUID) of the BMethodRequest class.
   * @return true, if re-login should be performed.
   */
  public boolean isReloginException(Throwable ex, int typeId) {
    if (log.isDebugEnabled()) log.debug("isReloginException(ex=" + ex);

    boolean ret = false;
    
    // Check exception
    if (ex instanceof BException) {
      BException bex = (BException) ex;
      ret = (bex.code == BExceptionC.UNAUTHORIZED);
    }
      
    if (log.isDebugEnabled()) log.debug(")isReloginException=" + ret);
    return ret;
  }
  
  /**
   * Assing authentication object.
   * @param auth Authentication object
   */
  protected void setAuthentication(BAuthentication auth) {
    authentication = auth;
  }
  
  public WeakReference<BClient> getClientHelperToInjectInBValueClass() {
    return clientHelperToInjectInBValueClass;
  }
  
  public void setClientHelperToInjectInBValueClass(WeakReference<BClient> v) {
    this.clientHelperToInjectInBValueClass = v;
  }

  public boolean isPrintRequestIntoLogger() {
    return printRequestIntoLogger;
  }

  public void setPrintRequestIntoLogger(boolean printRequestIntoLogger) {
    this.printRequestIntoLogger = printRequestIntoLogger;
  }

  /**
   * Last authentication result is assumed to be valid for this time.
   */
  public final static long RETRY_AUTHENTICATION_AFTER_MILLIS = 1 * 1000;
  
  /**
   * Print requests into logger.
   */
  protected boolean printRequestIntoLogger = true;

  private final static Logger log = LoggerFactory.getLogger(BTransport.class);

}