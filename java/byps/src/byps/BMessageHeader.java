package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


/**
 * Stream Header
 *
 * Binary Stream Big Endian:
 * BYPS + version  + error  + flags  + messageId 
 * 
 * Binary Stream Little Endian:
 * SPYB + version + error + flags + messageId 
 *
 * JSON
 * ["J", "version as stirng", "error as string","flags as string","messageId as string"
 *
 */


public class BMessageHeader {
	
	public final static int MAGIC_BINARY_STREAM = ((int)'B' << 24) | ((int)'Y' << 16) | ((int)'P' << 8) | ((int)'S');
	private final static int MAGIC_BINARY_STREAM_LE = ((int)'S' << 24) | ((int)'P' << 16) | ((int)'Y' << 8) | ((int)'B');
	
	public final static int MAGIC_JSON = ((int)'{' << 24) | ((int)'\"' << 16) | ((int)'h' << 8) | ((int)'e');
	// unused private final static int MAGIC_JSON_SINGLE_QUOTE = ((int)'{' << 24) | ((int)'\'' << 16) | ((int)'h' << 8) | ((int)'e');
		
  public final static int BYPS_VERSION_EXTENDED_STREAM_INFORMATION = 1;
  public final static int BYPS_VERSION_ENCRYPTED_TARGETID = 2;
  public final static int BYPS_VERSION_WITH_SESSIONID = 3;
  public static int BYPS_VERSION_CURRENT = BYPS_VERSION_WITH_SESSIONID;
		
	public final static int FLAG_BYPS_VERSION = 1;
	public final static int FLAG_RESPONSE = 2; 
	public final static int FLAG_LONGPOLL = 2;
	public final static int FLAG_TIMEOUT = 4;
	public final static int FLAG_LONGPOLL_WITH_TIMEOUT = FLAG_LONGPOLL + 4;
	
	/**
	 * This flag indicates that the message is to provide a new response 
	 * object after {@link BExceptionC#PROCESSING}.
	 * @since 5.28
	 */
	public static final int FLAG_POLL_PROCESSING = 8;
	
	public final static int SESSIONID_LENGTH = 16;
	
	public int magic;
	public int error;
	public int flags;
	public int bversion;
	public long version;
	public BTargetId targetId;
	public long messageId;
	public String sessionId = BTargetId.SESSIONID_ZERO;
	
	/**
	 * Timeout.
	 * This field is only valid if {@link #flags} contains {@link #FLAG_TIMEOUT}.
	 */
	public int timeoutSeconds;
	
	//ublic long streamId; 
	//public BInt128 sessionId;
	
	public transient ByteOrder byteOrder;
	
	/**
	 * The deserialized message.
	 * With JSON serialization, the entire message has to be deserialized in read() 
	 * in order to read the header values. In order to avoid a second deserialization
	 * in BInputJson.load, we store the message object in this value.
	 */
	public Object messageObject;
	
	/**
	 * ID for request tracking.
	 * BYPS-11
	 */
	private transient long trackingId;

	public BMessageHeader(int magic, final int bversion, final long version, ByteOrder byteOrder, long mid) {
		this.magic = magic;
		this.bversion = bversion;
		if (bversion != 0) {
		  this.flags = FLAG_BYPS_VERSION;
		}
		this.version = version;
		this.byteOrder = byteOrder;
		this.messageId = mid;
	}
	
	public BMessageHeader() {
	}
	
	public BMessageHeader(BMessageHeader rhs) {
		this.magic = rhs.magic;
		this.bversion = rhs.bversion;
		this.version = rhs.version;
		this.byteOrder = rhs.byteOrder;
		this.error = rhs.error;
		this.flags = rhs.flags;
		this.messageId = rhs.messageId;
		this.targetId = rhs.targetId;
		this.timeoutSeconds = rhs.timeoutSeconds;
		this.sessionId = rhs.sessionId;
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
			default: {
			  magic = MAGIC_JSON;
				buf.position(pos);
				return magic;
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

    if ((flags & FLAG_BYPS_VERSION) != 0) {
      buf.putInt(bversion);
    }

    buf.putLong(version);
		targetId.write(buf, bversion);
		buf.putLong(messageId);
		
		if ((flags & FLAG_TIMEOUT) != 0) {
		  buf.putInt(timeoutSeconds);
		}
		
		if (bversion >= BYPS_VERSION_WITH_SESSIONID) {
		  BTargetId.writeSessionId(buf, sessionId);
		}
	}

	protected void writeJson(BBufferJson bbuf) {
		bbuf.beginObject();
		bbuf.putInt("error", error);
		bbuf.putInt("flags", flags);
		bbuf.putInt("bversion", bversion);
		bbuf.putString("targetId", targetId.makeSerializeString(bversion));
		bbuf.putLong("messageId", messageId);
   
		if ((flags & FLAG_TIMEOUT) != 0) {
      bbuf.putInt("timeout", timeoutSeconds);
    }

    if (bversion >= BYPS_VERSION_WITH_SESSIONID) {
      bbuf.putString("sessionId", sessionId);
    }
    
		bbuf.endObject();
	}
	
	protected void readBinaryWithoutMagic(ByteBuffer buf) {
		error = buf.getInt();
		flags = buf.getInt();
		
		if ((flags & FLAG_BYPS_VERSION) != 0) {
		  bversion = buf.getInt();
		}
		
		version = buf.getLong();
		targetId = BTargetId.read(buf, bversion);
		messageId = buf.getLong();
		
    if ((flags & FLAG_TIMEOUT) != 0) {
      timeoutSeconds = buf.getInt();
    }

    if (bversion >= BYPS_VERSION_WITH_SESSIONID) {
      sessionId = BTargetId.readSessionId(buf); 
    }
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
			if (!(messageObject instanceof BJsonObject)) throw new BException(BExceptionC.CORRUPT, "Invalid protocol");
			BJsonObject headerObject = ((BJsonObject)messageObject).getJsonObject("header");
			if (headerObject == null) throw new BException(BExceptionC.CORRUPT, "Invalid protocol");
			fromJson(headerObject);
			break;
		}
		default: 
			throw new BException(BExceptionC.CORRUPT, "Invalid protocol.");
		}
	}
	
	public final void fromJson(BJsonObject jsonObj) throws BException {
		byteOrder = ByteOrder.BIG_ENDIAN;
		
		error = jsonObj.getInt("error");
		flags = jsonObj.getInt("flags");
		bversion = jsonObj.getInt("bversion");
		if (bversion == 0) {
		  bversion = BMessageHeader.BYPS_VERSION_CURRENT;
		}
		
		String targetIdStr = jsonObj.getString("targetId");
		targetId = BTargetId.parseString(targetIdStr);

		messageId = jsonObj.getLong("messageId");
		
		if ((flags & FLAG_TIMEOUT) != 0) {
		  timeoutSeconds = jsonObj.getInt("timeout");
		}

    if (bversion >= BYPS_VERSION_WITH_SESSIONID) {
      sessionId = jsonObj.getString("sessionId");
    }
	}
	
//	public final boolean isStreamRequest() {
//		return (flags & FLAG_STREAM) != 0;
//	}

	public String toString() {
		StringBuilder sbuf = new StringBuilder();
		sbuf.append("[magic=").append(magic)
			.append(", error=").append(error)
			.append(", flags=").append(flags)
			.append(", bversion=").append(bversion)
			.append(", version=").append(version)
			.append(", targetId=").append(targetId)
			.append(", messageId=").append(messageId)
      .append(", timeout=").append(timeoutSeconds)
      .append(", sessionId=").append(sessionId)
      .append(", trackingId=").append(trackingId)
			.append(", messageObject=").append(messageObject)
			.append("]");
		return sbuf.toString();
	}
	
	public boolean isBinaryMessage() {
	  boolean ret = false;
	  switch (magic) {
    case MAGIC_BINARY_STREAM:
      // fall through
    case MAGIC_BINARY_STREAM_LE:
      ret = true;
      break;
	  }
	  return ret;
	}

  public long getTrackingId() {
    return trackingId;
  }

  public void setTrackingId(long trackingId) {
    this.trackingId = trackingId;
  }
	
}
