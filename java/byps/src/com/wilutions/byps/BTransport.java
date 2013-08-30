package com.wilutions.byps;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BTransport {
	
	public final BApiDescriptor apiDesc;
	
  public final BWire wire;
  
  public final BAuthentication authentication; 
  
	public final BServerRegistry serverRegistry;
	
	private BTargetId targetId;
	
	private BProtocol protocol;

	public BTransport(BApiDescriptor apiDesc, BWire wire, BAuthentication authentication, BServerRegistry serverRegistry) {
		this.apiDesc = apiDesc;
		this.wire = wire;
		this.authentication = authentication;
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
    sendMaybeRelogin(0, obj, asyncResult);
  }
	 
	public <T> void sendMaybeRelogin(final int reloginCount, final Object obj, final BAsyncResult<T> asyncResult) {
		if (log.isDebugEnabled()) log.debug("sendMaybeRelogin(obj=" + obj + ", asyncResult=" + asyncResult);
		try {
			
      if (log.isDebugEnabled()) log.debug("store object");
			final BOutput bout = getOutput();
			bout.store(obj);
			
			final BAsyncResult<BMessage> outerResult = new BAsyncResult<BMessage>() {
	
				@SuppressWarnings("unchecked")
				@Override
				public void setAsyncResult(BMessage msgRecv, Throwable e) {
					if (log.isDebugEnabled()) log.debug("setAsyncResult(" + msgRecv + ", ex=" + e);
					try {
						
						if (e != null) {
						  
						  // Session expired?
						  boolean rlogin = authentication != null && authentication.isReloginException(reloginCount, e);
		          if (log.isDebugEnabled()) log.debug("isReloginException=" + rlogin);
						  if (rlogin) {
						    
						    // Authenticate and send the message again.
						    
						    final BAsyncResult<Boolean> loginResult = new BAsyncResult<Boolean>() {
						      public void setAsyncResult(Boolean succ, Throwable e2) {
		                if (log.isDebugEnabled()) log.debug("auth.login asyncResult=" + succ + ", ex=" + e2);
						        if (e2 != null) {
						          asyncResult.setAsyncResult(null, e2);
						        }
						        else {
						          // Send again
						          BTransport.this.sendMaybeRelogin(reloginCount+1, obj, asyncResult);
						        }
						      };
						    };
						    
						    // Negotiate, authenticate
			          if (log.isDebugEnabled()) log.debug("re-login");
						    negotiateProtocolClient(loginResult);
						    
						  }
						  else {
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
						if (log.isDebugEnabled()) log.debug("Received exception.", e);
						asyncResult.setAsyncResult(null, ex);
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
		
		if (log.isDebugEnabled()) log.debug(")sendMaybeRelogin");
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
						
            if (authentication != null) {
  						final BAsyncResult<Boolean> loginResult = new BAsyncResult<Boolean>() {
  						  public void setAsyncResult(Boolean result, Throwable exception) {
  	              asyncResult.setAsyncResult(true, exception);
  						  };
  						};
  
  						authentication.authenticate(loginResult);
            }
            else {
              asyncResult.setAsyncResult(false, e);
            }
            
					}
					else {
					  asyncResult.setAsyncResult(false, e);
					}
				}
				catch (Throwable ex) {
					asyncResult.setAsyncResult(null, ex);
				}
			}

		};
		
		BMessageHeader header = new BMessageHeader();
		header.messageId = wire.makeMessageId();
		final BMessage msg = new BMessage(header, buf, null);
		wire.send(msg, outerResult);
		
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
	
	private final Log log = LogFactory.getLog(BTransport.class);
	
}