package com.wilutions.byps;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BTransport {
	
	public final BWire wire;
	
	public final BApiDescriptor apiDesc;
	
	public final BRemoteRegistry remoteRegistry;
	
	private BTargetId targetId;
	
	private BProtocol protocol;
	
	
	public BTransport(BApiDescriptor apiDesc, BWire wire, BRemoteRegistry remoteRegistry) {
		this.apiDesc = apiDesc;
		this.wire = wire;
		this.targetId = new BTargetId();
		this.remoteRegistry = remoteRegistry;
	}
	
	public BTransport(BTransport rhs, BTargetId targetId) {
		this.apiDesc = rhs.apiDesc;
		this.wire = rhs.wire;
		this.targetId = targetId;
		this.protocol = rhs.getProtocol();
		this.remoteRegistry = rhs.remoteRegistry;
	}
	
	public synchronized void setProtocol(BProtocol protocol) {
		this.protocol = protocol;
	}
	
	public synchronized BProtocol getProtocol() {
		return protocol;
	}
	
	public synchronized BOutput getOutput() throws BException {
		if (protocol == null) throw new BException(BException.INTERNAL, "No protocol negotiated.");
		BOutput bout = protocol.getOutput(this, null);
		return bout;
	}

	public synchronized BOutput getResponse(BMessageHeader requestHeader) throws BException {
		if (protocol == null) throw new BException(BException.INTERNAL, "No protocol negotiated.");
		BMessageHeader responseHeader = requestHeader.createResponse();
		BOutput bout = protocol.getOutput(this, responseHeader);
		return bout;
	}

	public synchronized BInput getInput(BMessageHeader header, ByteBuffer buf) throws BException {
		if (protocol == null) throw new BException(BException.INTERNAL, "No protocol negotiated.");
		
		// header is null in the test cases that check the serialization.
		if (header == null) {
			header = new BMessageHeader();
			header.read(buf);
		}
		
		return protocol.getInput(this, header, buf);
	}

	public <T> void send(Object obj, final BAsyncResult<T> asyncResult) {
		if (log.isDebugEnabled()) log.debug("send(obj=" + obj + ", asyncResult=" + asyncResult);
		try {
			
			final BOutput bout = getOutput();
			
			if (log.isDebugEnabled()) log.debug("store object");
			bout.store(obj);
			
			final BAsyncResult<BMessage> outerResult = new BAsyncResult<BMessage>() {
	
				@SuppressWarnings("unchecked")
				@Override
				public void setAsyncResult(BMessage msg, Throwable e) {
					if (log.isDebugEnabled()) log.debug("setAsyncResult(" + msg);
					try {
						T ret = null;
						if (e == null) {
							final BInput bin = getInput(msg.header, msg.buf);
							if (log.isDebugEnabled()) log.debug("load object");
							ret = (T)bin.load();
							if (log.isDebugEnabled()) log.debug("ret = " + ret);
						}
						asyncResult.setAsyncResult(ret, e);
					} catch (Throwable ex) {
						if (log.isDebugEnabled()) log.debug("Received exception.", e);
						asyncResult.setAsyncResult(null, ex);
					}
					if (log.isDebugEnabled()) log.debug(")setAsyncResult");
				}
	
				
			};
			
			final BMessage msg = bout.toMessage();
			wire.send(msg, outerResult);
		}
		catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}

	public void recv(BServer server, BMessage msg, final BAsyncResult<BMessage> asyncResult) throws Throwable {
		if (log.isDebugEnabled()) log.debug("recv(");
		
		final BInput bin = getInput(msg.header, msg.buf);
		
		BAsyncResult<Object> methodResult = new BAsyncResult<Object>() {
			
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
			final Object methodObj = bin.load();
			if (log.isDebugEnabled()) log.debug("messageId=" + bin.header.messageId);
			
			final BTargetId clientTargetId = bin.header.targetId;
			server.recv(clientTargetId, methodObj, methodResult);
		}
		catch (Exception e) {
			methodResult.setAsyncResult(null, e);
		}
		
		if (log.isDebugEnabled()) log.debug(")recv");
	}

	public void negotiateProtocolClient(final BAsyncResult<Boolean> asyncResult) throws BException, InterruptedException {
		
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
					}
					asyncResult.setAsyncResult(true, e);
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
		
		if (nego.protocols.startsWith(BNegotiate.BINARY_STREAM)) {
			int negotiatedVersion = Math.min(apiDesc.version, nego.version);
			nego.protocols = BNegotiate.BINARY_STREAM;
			if (nego.byteOrder == null) nego.byteOrder = ByteOrder.BIG_ENDIAN; 
			nego.version = negotiatedVersion;
			protocol = new BProtocolS(apiDesc, negotiatedVersion, nego.byteOrder);
		}
		else if (nego.protocols.startsWith(BNegotiate.JSON)){
			nego.protocols = BNegotiate.JSON;
			protocol = new BProtocolJson(apiDesc);
		}
		else {
			throw new BException(BException.CORRUPT, "Protocol negotiation failed.");
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