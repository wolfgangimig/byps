package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

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
  
  protected AtomicLong requestCounter = new AtomicLong();
  
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
    
    // This constructor is called, if a stub maybe from another client is deserialized.
    // We cannot use the same authentication here, because the other client can only 
    // authenticate this stub.
    this.authentication = null;
    
    this.serverRegistry = null;
  
    // Still connected to the server given by rhs.
    this.connectedServerId = rhs.targetId.getServerId();
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
    BOutput bout = protocol.getOutput(this, null);
    return bout;
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

  protected <T> void send(final Object obj, final BAsyncResult<T> asyncResult) {
    if (log.isDebugEnabled()) log.debug("send(obj=" + obj + ", asyncResult=" + asyncResult);
    
    final long requestId = requestCounter.incrementAndGet(); 
    if (printRequestIntoLogger && log.isInfoEnabled()) log.info("send-" + requestId + " Request=" + obj);
    final long t0 = System.currentTimeMillis();
    
    try {
      final BOutput bout = getOutput();
      final int typeId = protocol.getRegistry().getSerializer(obj, true).typeId;
      
      if (log.isDebugEnabled()) log.debug("store object");
      bout.store(obj);
      
      final BAsyncResult<BMessage> outerResult = new BAsyncResult<BMessage>() {

        @SuppressWarnings("unchecked")
        @Override
        public void setAsyncResult(BMessage msgRecv, Throwable e) {
          if (log.isDebugEnabled()) log.debug("setAsyncResult(" + msgRecv + ", ex=" + e);

          boolean relogin = false;

          try {

            if (e != null) {

              // BYPS relogin error? (HTTP 401)
              relogin = internalIsReloginException(e, typeId);
              long t1 = System.currentTimeMillis();
              if (printRequestIntoLogger && log.isInfoEnabled()) log.info("send-" + requestId + " [" + (t1-t0) + "] Response=" + e + ", relogin=" + relogin);

              if (!relogin) {
                asyncResult.setAsyncResult(null, e);
              }

            }
            else {
              final BInput bin = getInput(msgRecv.header, msgRecv.buf);
              if (log.isDebugEnabled()) log.debug("load object");
              T ret = (T) bin.load();
              long t1 = System.currentTimeMillis();
              if (printRequestIntoLogger && log.isInfoEnabled()) log.info("send-" + requestId + " [" + (t1-t0) + "] Response=" + ret);
              asyncResult.setAsyncResult(ret, e);
            }

          } catch (Throwable ex) {
            if (log.isDebugEnabled()) log.debug("Received exception.", ex);

            // Application relogin error?
            relogin = internalIsReloginException(ex, typeId);
            if (log.isDebugEnabled()) log.debug("isReloginException=" + relogin);

            if (!relogin) {
              long t1 = System.currentTimeMillis();
              if (printRequestIntoLogger && log.isInfoEnabled()) log.info("send-" + requestId + " [" + (t1-t0) + "] Response=" + ex);
              asyncResult.setAsyncResult(null, ex);
            }

          }

          if (relogin) {

            // Authenticate and send the message again.
            
            // The server is responsible for killing long-polls of invalid sessions.
            // So we do not need to stop the serverR before re-login.
            
            if (log.isInfoEnabled()) log.debug("Re-login");
            reloginAndRetrySend((BMethodRequest)obj, asyncResult);

          }

          if (log.isDebugEnabled()) log.debug(")setAsyncResult");
        }

      };

      final BMessage msgSend = bout.toMessage();
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
            final BMessage msg = bout.toMessage();
            asyncResult.setAsyncResult(msg, null);
          } catch (BException ex) {
            
            // Try to send the exception to the other part
            try {
              BOutput bout = getResponse(bin.header);
              bout.setException(ex);
              final BMessage msg = bout.toMessage();
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
        // Server the message here.
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

  private final static Log log = LogFactory.getLog(BTransport.class);

}