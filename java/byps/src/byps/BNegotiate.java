package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * 
 * Negotiate request consists of:
 * ["N","SCJ","version","{B,L,_}", "targetId", "bversion"]
 *
 */
public class BNegotiate {
	
	private final static int NEGOTIATE_MIN_SIZE = 13;  // ["N","J","1"]
	public final static int NEGOTIATE_MAX_SIZE = 1000;
	
	private final static int MAGIC_DOUBLE_QUOTES = ((int)'[' << 24) | ((int)'\"' << 16) | ((int)'N' << 8) | ((int)'\"');
	private final static int MAGIC_SINGLE_QUOTES = ((int)'[' << 24) | ((int)'\'' << 16) | ((int)'N' << 8) | ((int)'\'');
	
	public String protocols;
	public long version;
	public ByteOrder byteOrder; 
	public BTargetId targetId;
	public int bversion;
	public String sessionId = BTargetId.SESSIONID_ZERO;
	
	public BNegotiate() {
	}
	
	public BNegotiate(BNegotiate rhs) {
	  this.protocols = rhs.protocols;
	  this.version = rhs.version;
	  this.byteOrder = rhs.byteOrder;
	  this.targetId = rhs.targetId;
	  this.bversion = rhs.bversion;
	  this.sessionId = rhs.sessionId;
	}

	/**
	 * 
	 * @param protocols
	 * @param version
	 * @param byteOrder null, if Big Endian and Little Endian is supported
	 */
	public BNegotiate(BApiDescriptor apiDesc) {
		this.version = apiDesc.version;
		this.protocols = apiDesc.getProtocolIds();
		this.bversion = BMessageHeader.BYPS_VERSION_CURRENT;
	}
	
	/**
	 * A negotiate request starts with ["N" .
	 * ... or ['N' or [ 'N' or [ "N" or [\r\n\t N etf.
	 * @param buf
	 * @return
	 */
	public static boolean isNegotiateMessage(ByteBuffer buf) {
		if (buf.remaining() >= BNegotiate.NEGOTIATE_MIN_SIZE) {
			buf.mark();
			
			ByteOrder bo = buf.order();
			if (bo != ByteOrder.BIG_ENDIAN) buf.order(ByteOrder.BIG_ENDIAN);
			try {

				// Fast check for ["N" or ['N'
				
				int magic = buf.getInt();
				if (magic == MAGIC_DOUBLE_QUOTES || magic == MAGIC_SINGLE_QUOTES) return true;
				
				buf.reset();
				buf.mark();

				// Second try:
				// Read with BBufferJson
				
				BBufferJson bbuf = new BBufferJson(buf);
				char c = bbuf.nextJsonChar(true);
				if (c != '[') return false;
				c = bbuf.nextJsonChar(true);
				if (c != '\"' && c != '\'') return false;
				c = bbuf.nextJsonChar(true);
				if (c != 'N') return false;
				c = bbuf.nextJsonChar(true);
				if (c != '\"' && c != '\'') return false;
				return true;
			}
			catch (BufferUnderflowException e) {
			}
			finally {
				buf.reset();
				if (bo != ByteOrder.BIG_ENDIAN) buf.order(bo);
			}
		}
		return false;
	}
	
	public void write(ByteBuffer buf) throws BException {
		
		buf.order(ByteOrder.BIG_ENDIAN);
		
		BBufferJson bbuf = new BBufferJson(buf);
		bbuf.beginArray();
		
		bbuf.putChar('N');
		bbuf.putString(protocols);
		bbuf.putString(BVersioning.longToString(version));

		if (byteOrder == null) {
			bbuf.putChar('_');
		}
		else if (byteOrder == ByteOrder.BIG_ENDIAN) {
			bbuf.putChar('B');
		}
		else {
			bbuf.putChar('L');
		}

		final BTargetId tid = (targetId != null ? targetId : BTargetId.ZERO);
		bbuf.putString(tid.makeSerializeString(bversion));
		
		if (bversion != 0) {
		  bbuf.putInt(bversion);
		}
		
		if (sessionId != null) {
		  bbuf.putString(sessionId);
		}
		
		bbuf.endArray();

	}
	
	public void read(ByteBuffer buf) throws BException {
		
		buf.order(ByteOrder.BIG_ENDIAN);
		
		BBufferJson bbuf = new BBufferJson(buf);
		bbuf.nextExpectedJsonChar('[', true);
		
		// Magic
		bbuf.nextExpectedJsonChar('\"', true);
		bbuf.nextExpectedJsonChar('N', true);
		bbuf.nextExpectedJsonChar('\"', true);
		bbuf.nextExpectedJsonChar(',', true);
		
		// Protocols
		protocols = bbuf.getString();
		bbuf.nextExpectedJsonChar(',', true);
		
		// Version
		version = BVersioning.stringToLong(bbuf.getString());
		bbuf.nextExpectedJsonChar(',', true);
		
		// Byte Order
		char c = bbuf.getChar();
		if (c == '_') byteOrder = null;
		else if (c == 'B') byteOrder = ByteOrder.BIG_ENDIAN;
		else byteOrder = ByteOrder.LITTLE_ENDIAN;
		bbuf.nextExpectedJsonChar(',', true);
		
		// Target ID
		targetId = BTargetId.parseString(bbuf.getString());

		// BYPS Version.
		// Due to a bug in versions before BYPS_VERSION_WITH_SESSIONID, 
		// this value is not correctly negotiated. If no sessionId is
		// found, the bversion is ignored and set to the version number
		// prior to BYPS_VERSION_WITH_SESSIONID.
		if (bbuf.nextJsonChar(true) == ',') {
		  bversion = bbuf.getInt();
		}
		else {
		  bversion = 0;
		}
		
    if (bbuf.nextJsonChar(true) == ',') {
      sessionId = bbuf.getString();
    }
    else if (bversion >= BMessageHeader.BYPS_VERSION_WITH_SESSIONID) {
      bversion = BMessageHeader.BYPS_VERSION_WITH_SESSIONID-1;
    }
    
	}
	
}
