package com.wilutions.byps;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


/**
 * Stream Header
 *
 * Binary Stream Big Endian:
 * BYPS + version binär + error binär + flags binär + messageId binär
 * 
 * Binary Stream Little Endian:
 * SPYB + version binär + error binär + flags binär + messageId binär
 *
 * JSON
 * ["J", "version as stirng", "error as string","flags as string","messageId as string"
 *
 */


public class BMessageHeader {
	
	public final static int MAGIC_BINARY_STREAM = ((int)'B' << 24) | ((int)'Y' << 16) | ((int)'P' << 8) | ((int)'S');
	private final static int MAGIC_BINARY_STREAM_LE = ((int)'S' << 24) | ((int)'P' << 16) | ((int)'Y' << 8) | ((int)'B');
	
	public final static int MAGIC_JSON = ((int)'{' << 24) | ((int)'\"' << 16) | ((int)'h' << 8) | ((int)'e');
	private final static int MAGIC_JSON_SINGLE_QUOTE = ((int)'{' << 24) | ((int)'\'' << 16) | ((int)'h' << 8) | ((int)'e');
		
	//public final static int FLAG_STREAM = 1;
	public final static int FLAG_RESPONSE = 2;
	
	public int magic;
	public int error;
	public int flags;
	public int version;
	public BTargetId targetId;
	public long messageId;
//	public long streamId; // if (flags & FLAG_STREAM)
	//public BInt128 sessionId;
	
	public transient ByteOrder byteOrder;
	
	/**
	 * The deserialized message.
	 * With JSON serialization, the entire message has to be deserialized in read() 
	 * in order to read the header values. In order to avoid a second deserialization
	 * in BInputJson.load, we store the message object in this value.
	 */
	public Object messageObject;

	public BMessageHeader(int magic, final int version, ByteOrder byteOrder, long mid) {
		this.magic = magic;
		this.version = version;
		this.byteOrder = byteOrder;
		this.messageId = mid;
	}
	
	public BMessageHeader() {
	}
	
	public BMessageHeader(BMessageHeader rhs) {
		this.magic = rhs.magic;
		this.version = rhs.version;
		this.byteOrder = rhs.byteOrder;
		this.error = rhs.error;
		this.flags = rhs.flags;
		this.messageId = rhs.messageId;
//		this.streamId = rhs.streamId;
		this.targetId = rhs.targetId;
	}
	
	public final BMessageHeader createResponse() {
		BMessageHeader hdr = new BMessageHeader(this);
		hdr.flags |= FLAG_RESPONSE;
		return hdr;
	}
	
	public static int detectProtocol(ByteBuffer buf) {
		buf.mark();
		int magic = readProtocol(buf);
		if (magic == MAGIC_BINARY_STREAM_LE) magic = MAGIC_BINARY_STREAM;
		buf.reset();
		return magic;
	}
	
	private static int readProtocol(ByteBuffer buf) {
		ByteOrder bo = buf.order();
		buf.order(ByteOrder.BIG_ENDIAN);
		try {
			int pos = buf.position();
			int magic = buf.getInt();
			
			switch (magic) {
			case MAGIC_BINARY_STREAM: return magic; 
			case MAGIC_BINARY_STREAM_LE: return magic;
			case MAGIC_JSON: {
				buf.position(pos);
				return magic;
			}
			case MAGIC_JSON_SINGLE_QUOTE: {
				buf.position(pos);
				return MAGIC_JSON;
			}
			default: {
				buf.position(pos);
				BBufferJson bbuf = new BBufferJson(buf);
				char c = bbuf.nextJsonChar(true);
				if (c != '{') return 0;
				c = bbuf.nextJsonChar(true);
				if (c != '\"' || c != '\'') return 0;
				c = bbuf.nextJsonChar(true);
				if (c != 'h') return 0;
				buf.position(pos);
				return MAGIC_JSON;
			}
			}
		}
		finally {
			buf.order(bo);
		}
	}
	
	protected void writeBin(ByteBuffer buf) {
		
		buf.order(byteOrder);
		buf.putInt(MAGIC_BINARY_STREAM);
		buf.putInt(error); 
		buf.putInt(flags); 
		buf.putInt(version);
		targetId.write(buf);
		buf.putLong(messageId);
//		if ((flags & FLAG_STREAM) != 0) {
//			buf.putLong(streamId);
//		}
		
	}

	protected void writeJson(BBufferJson bbuf) {
		bbuf.beginObject();
		bbuf.putInt("error", error);
		bbuf.putInt("flags", flags);
		bbuf.putString("targetId", targetId.toString());
		bbuf.putLong("messageId", messageId);
		bbuf.endObject();
	}
	
	private void readBinaryWithoutMagic(ByteBuffer buf) {
		error = buf.getInt();
		flags = buf.getInt();
		version = buf.getInt();
		targetId = BTargetId.read(buf);
		messageId = buf.getLong();
//		if (isStreamRequest()) {
//			streamId = buf.getLong();
//		}
	}
	
	public final void read(ByteBuffer buf) throws BException {
		magic = readProtocol(buf);
		switch (magic) {
		case MAGIC_BINARY_STREAM_LE: 
			byteOrder = ByteOrder.LITTLE_ENDIAN;
			buf.order(ByteOrder.LITTLE_ENDIAN);
			readBinaryWithoutMagic(buf);
			break;
		case MAGIC_BINARY_STREAM: 
			byteOrder = ByteOrder.BIG_ENDIAN;
			buf.order(ByteOrder.BIG_ENDIAN);
			readBinaryWithoutMagic(buf);
			break;
		case MAGIC_JSON: 
		{
			BBufferJson bbuf = new BBufferJson(buf);
			messageObject = bbuf.parseJsonValue();
			if (!(messageObject instanceof BJsonObject)) throw new BException(BException.CORRUPT, "Invalid protocol");
			BJsonObject headerObject = ((BJsonObject)messageObject).getJsonObject("header");
			if (headerObject == null) throw new BException(BException.CORRUPT, "Invalid protocol");
			fromJson(headerObject);
			break;
		}
		default: 
			throw new BException(BException.CORRUPT, "Invalid protocol.");
		}
	}
	
	public final void fromJson(BJsonObject jsonObj) throws BException {
		byteOrder = ByteOrder.BIG_ENDIAN;
		
		error = jsonObj.getInt("error");
		flags = jsonObj.getInt("flags");
		
		String targetIdStr = jsonObj.getString("targetId");
		targetId = BTargetId.parseString(targetIdStr);

		messageId = jsonObj.getLong("messageId");
	}
	
//	public final boolean isStreamRequest() {
//		return (flags & FLAG_STREAM) != 0;
//	}

	public String toString() {
		StringBuilder sbuf = new StringBuilder();
		sbuf.append("[magic=").append(magic)
			.append(", error=").append(error)
			.append(", flags=").append(flags)
			.append(", targetId=").append(targetId)
			.append(", messageId=").append(messageId)
			.append(", messageObject=").append(messageObject)
			.append("]");
		return sbuf.toString();
	}
}
