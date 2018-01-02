package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

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
	
	public BOutput(BTransport transport, BRegistry registry, int streamHeaderMagic, int negotiatedBypsVersion, long negotiatedVersion, ByteOrder negotiatedByteOrder) {
		super();
		this.objMap = transport.getApiDesc().uniqueObjects ? null : new BObjMap();
		this.header = new BMessageHeader(streamHeaderMagic, negotiatedBypsVersion, negotiatedVersion, negotiatedByteOrder, transport.getWire().makeMessageId());
		this.header.targetId = transport.getTargetId();
		this.header.sessionId = transport.getSessionId();
		this.transport = transport;
		this.registry = registry;
		this.streams = null;
	}
	
	public BOutput(BTransport transport, BRegistry registry, BMessageHeader messageHeader) {
		this.objMap = transport.getApiDesc().uniqueObjects ? null : new BObjMap();
		this.header = messageHeader;
		this.header.targetId = transport.getTargetId();
		this.header.sessionId = transport.getSessionId();
		this.transport = transport;
		this.registry = registry;
		this.streams = null;
	}

	public abstract ByteBuffer toByteBuffer();
	
	public BMessage toMessage() {
		final BMessage msg = new BMessage(header, toByteBuffer(), streams);
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
			header.error = BExceptionC.REMOTE_ERROR;
			BSerializer ser = registry.getSerializer(ex, false);
			if (ser == null) {
				ex = new BException(BExceptionC.REMOTE_ERROR, "", ex);
			}
		}
		store(ex);
		
		// Close all streams. They will not be sent.
		if (streams != null) {
			for (BContentStream stream : streams) {
				try { 
				  stream.close(); 
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
	
	BContentStream createStreamRequest(InputStream strm) throws BException {
		if (streams == null) streams = new ArrayList<BContentStream>();
		BContentStream bstrm = null;
		
		if (strm instanceof BContentStream) {
		  bstrm = (BContentStream)strm;
		}
		else {
		  bstrm = new BContentStreamWrapper(strm);
		}
		
		// If the stream has already a streamId, it has been received
		// from the server. In this case, the application obviously
		// wants to forward the stream to another client. Thus 
		// we do not have to upload the stream.
		
		if (bstrm.getTargetId().isZero()) {
		  BTargetId targetId = new BTargetId(
		      transport.getConnectedServerId(),
		      header.messageId,
		      transport.getWire().makeMessageId());
		  bstrm.setTargetId(targetId);
      streams.add(bstrm);
		}
		
		return bstrm;
	}
	
	protected BObjMap objMap;
	protected List<BContentStream> streams;

}
