package com.wilutions.byps;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.atomic.AtomicBoolean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BTransport {
	
	public final BApiDescriptor apiDesc;
	
  public final BWire wire;
  
	public final BServerRegistry serverRegistry;
	
	private BTargetId targetId;
	
	private BProtocol protocol;

  protected BAuthentication authentication;
  
	public BTransport(BApiDescriptor apiDesc, BWire wire, BServerRegistry serverRegistry) {
		this.apiDesc = apiDesc;
		this.wire = wire;
		this.targetId = new BTargetId();
		this.serverRegistry = serverRegistry;
	}
	
	public BTransport(BTransport rhs, BTargetId targetId) {
		this.apiDesc = rhs.apiDesc;
		this.wire = rhs.wire;
    this.authentication = rhs.authentication;
		this.targetId = targetId;
		this.protocol = rhs.getProtocol();
		this.serverRegistry = rhs.serverRegistry;
	}
	
	public synchronized void setProtocol(BProtocol protocol) {
		this.protocol = protocol;
	}
	
	public synchronized BProtocol getProtocol() {
		return protocol;
	}
	
	public synchronized BOutput getOutput() throws BException {
		if (protocol == null) throw new BException(BExceptionO.INTERNAL, "No protocol negotiated.");
		BOutput bout = protocol.getOutput(this, null);
		return bout;
	}

	public synchronized BOutput getResponse(BMessageHeader requestHeader) throws BException {
		if (protocol == null) throw new BException(BExceptionO.INTERNAL, "No protocol negotiated.");
		BMessageHeader responseHeader = requestHeader.createResponse();
		BOutput bout = protocol.getOutput(this, responseHeader);
		return bout;
	}

	public synchronized BInput getInput(BMessageHeader header, ByteBuffer buf) throws BException {
		if (protocol == null) throw new BException(BExceptionO.INTERNAL, "No protocol negotiated.");
		
		// header is null in the test cases that check the serialization.
		if (header == null) {
			header = new BMessageHeader();
			header.read(buf);
		}
		
		return protocol.getInput(this, header, buf);
	}

  public <T> void send(final Object obj, final BAsyncResult<T> asyncResult) {
		if (log.isDebugEnabled()) log.debug("send(obj=" + obj + ", asyncResult=" + asyncResult);
		try {
		  
		  final BMethodRequest methodRequest = (BMethodRequest)obj;
		  final Object sess = authentication != null ? authentication.getSession() : null;
		  methodRequest.setSession(sess);
			
      if (log.isDebugEnabled()) log.debug("store object");
			final BOutput bout = getOutput();
			bout.store(methodRequest);
			
			final BAsyncResult<BMessage> outerResult = new BAsyncResult<BMessage>() {
	
				@SuppressWarnings("unchecked")
				@Override
				public void setAsyncResult(BMessage msgRecv, Throwable e) {
					if (log.isDebugEnabled()) log.debug("setAsyncResult(" + msgRecv + ", ex=" + e);
					
					boolean relogin = false; 
					
					try {
						
						if (e != null) {
						  
						  // BYPS relogin error? (HTTP 403)
						  relogin = authentication != null && isReloginException(e);
						  if (!relogin) { 
						    asyncResult.setAsyncResult(null, e);
						  }
						  
						}
						else {
							final BInput bin = getInput(msgRecv.header, msgRecv.buf);
							if (log.isDebugEnabled()) log.debug("load object");
							T ret = (T)bin.load();
							if (log.isDebugEnabled()) log.debug("ret = " + ret);
	            asyncResult.setAsyncResult(ret, e);
						}
						
					} catch (Throwable ex) {
						if (log.isDebugEnabled()) log.debug("Received exception.", ex);
						
            // App relogin error?
            relogin = authentication != null && authentication.isReloginException(ex);
            if (log.isDebugEnabled()) log.debug("isReloginException=" + relogin);
            
            if (!relogin) {
              asyncResult.setAsyncResult(null, ex);
            }
            
					}
					
          if (relogin) {
            
            // Authenticate and send the message again.
            
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
                    BTransport.this.send(methodRequest, asyncResult);
                  }
                };
              };
              
              negotiateProtocolClient(loginResult);
             
            }
            catch (Throwable ex2) {
              asyncResult.setAsyncResult(null, ex2);
            }
            
          }						
          
					if (log.isDebugEnabled()) log.debug(")setAsyncResult");
				}
			};
			
      final BMessage msgSend = bout.toMessage();
			wire.send(msgSend, outerResult);
		}
		catch (Throwable e) {
	    if (log.isDebugEnabled()) log.debug("Failed to serialize object", e);
		  asyncResult.setAsyncResult(null, e);
		}
		
		if (log.isDebugEnabled()) log.debug(")send");
	}

	public void recv(BServer server, BMessage msg, final BAsyncResult<BMessage> asyncResult) throws Throwable {
		if (log.isDebugEnabled()) log.debug("recv(");
		
		final BInput bin = getInput(msg.header, msg.buf);
		final BTargetId clientTargetId = bin.header.targetId;
	
		final BAsyncResult<Object> methodResult = new BAsyncResult<Object>() {
			
			@Override
			public void setAsyncResult(Object obj, Throwable e) {
				if (log.isDebugEnabled()) log.debug("setAsyncResultOrException(");
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
				}
				catch (BException ex) {
					asyncResult.setAsyncResult(null, ex);
				}
				if (log.isDebugEnabled()) log.debug(")setAsyncResultOrException");
			}

		};
	
		try {
			// Does the clientTargetId belong to another server? 
			// If so, get the BClient object to forward the message.
			final BClient client = (serverRegistry != null) ?
				 serverRegistry.getForwardClientIfForeignTargetId(clientTargetId) : null;
			
			// Read message
			final Object methodObj = bin.load();
			if (log.isDebugEnabled()) log.debug("messageId=" + bin.header.messageId);
						
			// Forward message to other server?
			if (client != null) {
				forwardMessage(client, clientTargetId, methodObj, methodResult);
			}
			else {
				// Server the message here.
				server.recv(clientTargetId, methodObj, methodResult);
			}
		}
		catch (Exception e) {
			methodResult.setAsyncResult(null, e);
		}
		
		if (log.isDebugEnabled()) log.debug(")recv");
	}

	protected void forwardMessage(final BClient client,
			final BTargetId clientTargetId, final Object methodObj,
			final BAsyncResult<Object> methodResult) throws BException {
		BOutput bout = client.transport.getOutput();
		bout.header.targetId = clientTargetId;
		bout.store(methodObj);
		BMessage forwardMessage = bout.toMessage();
		
		BAsyncResult<BMessage> messageResult = new BAsyncResult<BMessage>() {
			public void setAsyncResult(BMessage result, Throwable ex) {
				try {
					if (ex != null) {
						methodResult.setAsyncResult(null, ex);
					}
					else {
						BInput bin = client.transport.getInput(result.header, result.buf);
						Object obj = bin.load();
						methodResult.setAsyncResult(obj, null);
					}
				}
				catch (Exception e) {
					methodResult.setAsyncResult(null, e);
				}
			}
		};
		
		client.transport.wire.send(forwardMessage, messageResult);
	}

	public void negotiateProtocolClient(final BAsyncResult<Boolean> asyncResult) throws RemoteException {
		
		ByteBuffer buf = ByteBuffer.allocate(BNegotiate.NEGOTIATE_MAX_SIZE);
		final BNegotiate nego = new BNegotiate(apiDesc);
		nego.write(buf);
		buf.flip();

		BAsyncResult<BMessage> outerResult = new BAsyncResult<BMessage>() {

      @Override
			public void setAsyncResult(BMessage msg, Throwable e) {
				try {
					if (e == null) {
						nego.read(msg.buf);
						synchronized(BTransport.this) {
							protocol = createNegotiatedProtocol(nego);
							targetId = nego.targetId;
						}
						
						authenticate(asyncResult);
					}
					else {
					  asyncResult.setAsyncResult(Boolean.FALSE, e);
					}
				}
				catch (Throwable ex) {
					asyncResult.setAsyncResult(Boolean.FALSE, ex);
				}
			}

		};
		
		BMessageHeader header = new BMessageHeader();
		header.messageId = wire.makeMessageId();
		final BMessage msg = new BMessage(header, buf, null);
		wire.send(msg, outerResult);
		
	}
	
	private AtomicBoolean doingAuth = new AtomicBoolean();
	
	private void authenticate(final BAsyncResult<Boolean> asyncResult) {
	  
	  if (log.isDebugEnabled()) log.debug("authenticate(");
    
	  // Authentication enabled?
	  if (authentication != null) {
      
	    // First thread in this block is allowed to authenticate 
      if (doingAuth.compareAndSet(false, true)) {
        
        BAsyncResult<Boolean> authResult = new BAsyncResult<Boolean>() {
          public void setAsyncResult(Boolean ignored, Throwable ex) {
            
            asyncResult.setAsyncResult(ignored, ex);

            // Notify other threads waiting in else block below
            doingAuth.notifyAll();
          }
        };
        
        authentication.authenticate(null, authResult);
        
      }
      else {

        das muss in einem hintergrundprozess passieren... 
        andernfalls blockiere ich den aktuellen Thread.
        
        // Other threads wait until authentication has finished by first thread. 
        while (doingAuth.get()) {
          try {
            doingAuth.wait(10*1000);
          } catch (InterruptedException e) {
            asyncResult.setAsyncResult(Boolean.FALSE, e);
          }
        }

        asyncResult.setAsyncResult(Boolean.TRUE, null);
      }
      
    }
    else {
      asyncResult.setAsyncResult(Boolean.TRUE, null);
    }
	  
    if (log.isDebugEnabled()) log.debug(")authenticate");
	}
	
	private BProtocol createNegotiatedProtocol(BNegotiate nego) throws BException {
		BProtocol protocol = null;
		
		if (nego.protocols.startsWith(BProtocolS.BINARY_MODEL.getProtocolId())) {
			long negotiatedVersion = Math.min(apiDesc.version, nego.version);
			nego.protocols = BProtocolS.BINARY_MODEL.getProtocolId();
			if (nego.byteOrder == null) nego.byteOrder = ByteOrder.BIG_ENDIAN; 
			nego.version = negotiatedVersion;
			protocol = new BProtocolS(apiDesc, negotiatedVersion, nego.byteOrder);
		}
		else if (nego.protocols.startsWith(BProtocolJson.BINARY_MODEL.getProtocolId())){
			nego.protocols = BProtocolJson.BINARY_MODEL.getProtocolId();
			protocol = new BProtocolJson(apiDesc);
		}
		else {
			throw new BException(BExceptionO.CORRUPT, "Protocol negotiation failed.");
		}

		return protocol;
	}
	
	public BProtocol negotiateProtocolServer(BTargetId targetId, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult)  {
		BProtocol ret = null;
		try {
			BNegotiate nego = new BNegotiate();
			nego.read(buf);
			
			synchronized(this) {
				this.protocol = ret = createNegotiatedProtocol(nego);
				this.targetId = targetId;
			}
			
			ByteBuffer bout = ByteBuffer.allocate(BNegotiate.NEGOTIATE_MAX_SIZE);
			try {
				nego.targetId = targetId;
				nego.write(bout);
				bout.flip();
				asyncResult.setAsyncResult(bout, null);
			} 
			finally {
			}
			
		}
		catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
		return ret;
	}
	
	public synchronized BTargetId getTargetId() {
		return targetId;
	}
	
	public synchronized void setTargetId(BTargetId v) {
		this.targetId = v;
	}
	
	public String toString() {
		return "[" + targetId + "]";
	}
	
  public boolean isReloginException(Throwable ex) {
    log.info("isReloginException(ex=" + ex);
    
    boolean ret = false;
    
    // Check exception
    if (ex instanceof BException) {
      BException bex = (BException)ex;
      ret = (bex.code == BExceptionO.AUTHENTICATION_REQUIRED);
      log.info("is relogin exception=" + ret);
      if (!ret) {
        // The negotiated Tomcat session lives for 10 seconds. 
        // If we are slow in debugging and the session expires, 
        // we receive a BExceptionO.IOERRROR with the message "HTTP 403"
        ret = (bex.code == BExceptionO.IOERROR) && bex.toString().indexOf("403") >= 0; 
      }
    }

    log.info(")isReloginException=" + ret);
    return ret;
  }

	private final Log log = LogFactory.getLog(BTransport.class);

}