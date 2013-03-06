package com.wilutions.byps;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;



public abstract class BOutput {
	
	public final BMessageHeader header;
	public final BTransport transport;
	public final BRegistry registry;
	
	public BOutput(BTransport transport, BRegistry registry, int streamHeaderMagic, int negotiatedVersion, ByteOrder negotiatedByteOrder) {
		super();
		this.objMap = transport.apiDesc.uniqueObjects ? null : new BObjMap();
		this.header = new BMessageHeader(streamHeaderMagic, negotiatedVersion, negotiatedByteOrder, transport.wire.makeMessageId());
		this.header.targetId = transport.getTargetId();
		this.transport = transport;
		this.registry = registry;
		this.streams = null;
	}
	
	public BOutput(BTransport transport, BRegistry registry, BMessageHeader messageHeader) {
		this.objMap = transport.apiDesc.uniqueObjects ? null : new BObjMap();
		this.header = messageHeader;
		this.header.targetId = transport.getTargetId();
		this.transport = transport;
		this.registry = registry;
		this.streams = null;
	}

	public abstract ByteBuffer toByteBuffer();
	
	public BMessage toMessage() {
		final BMessage msg = new BMessage(header, toByteBuffer(), getStreamRequests());
		return msg;
	}
	
	// obj muss von einer Klasse sein, die der Generator erstellt hat.
	// String oder Map usw. geht nicht.
	
	/**
	 * Store an object.
	 * @param bserializable An Object that implements BSerializable or that is tagged by the javadoc comment @BSerializable
	 * @throws BException
	 */
	public void store(Object bserializable) throws BException {
		internalStore(bserializable);
	}
	
	public void setException(Throwable ex) throws BException {
		if (ex instanceof BException) {
			header.error = ((BException)ex).code;
		} 
		else {
			header.error = BException.REMOTE_ERROR;
			BSerializer ser = registry.getSerializer(ex, false);
			if (ser == null) {
				ex = new BException(BException.REMOTE_ERROR, "", ex);
			}
		}
		store(ex);
		
		// Alle Streams schlieﬂen. Sie werden nicht gesendet.
		if (streams != null) {
			for (BStreamRequest streamRequest : streams) {
				try { 
					streamRequest.strm.close(); 
				} catch (IOException ignored) {}
			}
			streams = null;
		}
	}
	
	public abstract void beginObject();
	public abstract void endObject();
	public abstract void putBoolean(String name, boolean value);
	public abstract void putShort(String name, short value);
	public abstract void putInt(String name, int value);
	public abstract void putLong(String name, long value);
	public abstract void putFloat(String name, float value);
	public abstract void putDouble(String name, double value);
	public abstract void putString(String name, String value);
	
	protected abstract void internalStore(Object bserializable) throws BException;
	
	BStreamRequest createStreamRequest(InputStream strm) throws BException {
		if (streams == null) streams = new ArrayList<BStreamRequest>();
		BStreamRequest streamRequest = new BStreamRequest();
		streamRequest.messageId = header.messageId;
		streamRequest.streamId = transport.wire.makeMessageId();
		streamRequest.strm = strm;
		streams.add(streamRequest);
		return streamRequest;
	}
	
	public List<BStreamRequest> getStreamRequests() {
		return streams;
	}
		
	protected BObjMap objMap;
	protected List<BStreamRequest> streams;

}
