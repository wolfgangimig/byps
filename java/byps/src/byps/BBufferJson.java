package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */


import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BBufferJson extends BBuffer {
	
	public BBufferJson(ByteBuffer buf) {
		super(BBinaryModel.MEDIUM, buf);
		if (buf != null) {
		  buf.order(ByteOrder.BIG_ENDIAN);
		}
	}
	
	public ByteBuffer getBuffer() {
		return this.buf;
	}
	
	public void clear() {
		this.buf.clear();
		addComma = false;
	}
	
	private boolean addComma = false;
	
	public void beginObject() {
		ensureRemaining(2);
		if (addComma) buf.put((byte)',');
		buf.put((byte)'{');
		addComma = false;
	}
	
	public void endObject() {
		ensureRemaining(1);
		buf.put((byte)'}');
		addComma = true;
	}

	public void beginArray() {
		ensureRemaining(2);
		if (addComma) buf.put((byte)',');
		buf.put((byte)'[');
		addComma = false;
	}
	
	public void endArray() {
		ensureRemaining(1);
		buf.put((byte)']');
		addComma = true;
	}
	
	public void putRef(int id) {
		beginObject();
		putInt("*i", -id);
		endObject();
	}
	
	public void putBoolean(boolean v) {
		putJsonValueAscii(null, v ? "true" : "false", STRING_WITHOUT_QUOTE);
	}
	
	public void putByte(byte v) {
		putJsonValueAscii(null, Byte.toString(v), STRING_WITHOUT_QUOTE);
	}
	
	public void putByte(char v) {
		putJsonValueAscii(null, Character.toString(v), STRING_WITHOUT_QUOTE);
	}
	
	public void putChar(char v) {
		putString(null, v != 0 ? Character.toString(v) : "");
	}
	
	public void putShort(short v) {
		putJsonValueAscii(null, Short.toString(v), STRING_WITHOUT_QUOTE);
	}
	
	public void putInt(int v) {
		putJsonValueAscii(null, Integer.toString(v), STRING_WITHOUT_QUOTE);
	}
	
	/**
	 * Long values are written as strings with a "." as suffix.
	 * @param v
	 */
	public void putLong(long v) {
		putJsonValueAscii(null, Long.toString(v), STRING_WITH_QUOTE|STRING_LONG_VALUE);  // Long als String
	}
	
	public void putFloat(float v) {
		putJsonValueAscii(null, Float.toString(v), STRING_WITHOUT_QUOTE);
	}
	
	public void putDouble(double v) {
		putJsonValueAscii(null, Double.toString(v), STRING_WITHOUT_QUOTE);
	}
	
	public void putBoolean(String name, boolean v) {
		putJsonValueAscii(name, Boolean.toString(v), STRING_WITHOUT_QUOTE);
	}
	public void putByte(String name, byte v) {
		putJsonValueAscii(name, Byte.toString(v), STRING_WITHOUT_QUOTE);
	}
	public void putChar(String name, char v) {
		putString(name, v != 0 ? Character.toString(v) : "");
	}
	public void putShort(String name, short v) {
		putJsonValueAscii(name, Short.toString(v), STRING_WITHOUT_QUOTE);
	}
	public void putInt(String name, int v) {
		putJsonValueAscii(name, Integer.toString(v), STRING_WITHOUT_QUOTE);
	}
	
	/**
	 * Long values are written as strings with a "." as suffix.
	 * @param name
	 * @param v
	 */
	public void putLong(String name, long v) {
		putJsonValueAscii(name, Long.toString(v), STRING_WITH_QUOTE|STRING_LONG_VALUE);
	}
	public void putFloat(String name, float v) {
		putJsonValueAscii(name, Float.toString(v), STRING_WITHOUT_QUOTE);
	}

	public void putDouble(String name, double v) {
		putJsonValueAscii(name, Double.toString(v), STRING_WITHOUT_QUOTE);
	}
	
//	public void putBooleanIf(String name, boolean value) {
//		if (value) putBoolean(name, value);
//	}
//	public void putByteIf(String name, byte value) {
//		if (value != 0) putByte(name, value);
//	}
//	public void putCharIf(String name, char value) {
//		if (value != 0) putChar(name, value);
//	}
//	public void putShortIf(String name, short value) {
//		if (value != 0) putShort(name, value);
//	}
//	public void putIntIf(String name, int value) {
//		if (value != 0) putInt(name, value);
//	}
//	public void putLongIf(String name, long value){
//		if (value != 0) putLong(name, value);
//	}
//	public void putFloatIf(String name, float value) {
//		if (value != 0) putFloat(name, value);
//	}
//	public void putDoubleIf(String name, double value) {
//		if (value != 0) putDouble(name, value);
//	}
//	public void putStringIf(String name, String value) {
//		if (value != null && value.length() != 0) putString(name, value);
//	}
//	public void putArrayByteIf(String name, byte[] value) {
//		if (value != null) putArrayByte(name, value);
//	}

	
//	public static String base64(byte[] v) {
//		if (v == null) return null;
//		return javax.xml.bind.DatatypeConverter.printBase64Binary(v);
//	}
//	
//	public static byte[] base64(String v) {
//		if (v == null) return null;
//		return javax.xml.bind.DatatypeConverter.parseBase64Binary(v);
//	}
	
	public void putArrayByte(byte[] v) {
		putArrayByte(null, v);
	}
	
	public byte[] getArrayByte() {
		byte[] ret = null;
		int i = 0;
		
		char quote = nextJsonChar(true);
		if (quote == '\"' || quote == '\'') {
			ret = new byte[10];
			
			for (;;) {

				if (i + 3 >= ret.length) {
					byte[] w = new byte[ret.length<<1];
					System.arraycopy(ret, 0, w, 0, i);
					ret = w;
				}
				
				int c1 = getBase64Byte(buf.get());
				if (c1 < 0) {
					break;
				}
	
				int c2 = getBase64Byte(buf.get());

				ret[i++] = (byte) ((c1 << 2) | (c2 >> 4));

				int c3 = getBase64Byte(buf.get());
				if (c3 < 0) {
					// assume ==
					internalSkip(1);
					break;
				}
				
				ret[i++] = (byte) (((c2 & 0x0F) << 4) | (c3 >> 2));
				
				int c4 = getBase64Byte(buf.get());
				if (c4 < 0) {
					// assume =
					break;
				}
				
				ret[i++] = (byte) (((c3 & 0x3) << 6) | c4);
			}
			
			if (i != ret.length){
				byte[] w = new byte[i];
				System.arraycopy(ret, 0, w, 0, i);
				ret = w;
			}
			
		}
		else {
			// assume null
			internalSkip(3);
		}
		
		return ret;
	}
	
	private int internalBase64Length(byte[] v) {
		int n = 0;
		if (v != null) {
			n += ((v.length + 2) * 4) / 3 + 2;
		}
		else {
			n = 4;
		}
		return n;
	}
	
	public void putArrayByte(String name, byte[] v) {
		ensureRemaining(
				+ 1 + // comma
				internalUtf8Length(name)
				+ 1 + // :
				internalBase64Length(v)); 

		if (name != null) {
			if (addComma) buf.put((byte)',');
			internalPutString(name, true);
			buf.put((byte)':');
			addComma = false;
		}
		
		if (v == null) {
			putNull();
		}
		else {
			
			if (addComma) buf.put((byte)',');
			buf.put((byte)'\"');
			
			int i = 0;
			while (i < v.length) {
				int x = 0;
				int b1 = v[i++] & 0xFF;
				
				//int c = (b1 & 0xFC) >> 2;
				//buf.put((byte)BASE64_CHARS[c]);
				x |= BASE64_CHARS[(b1 & 0xFC) >> 2] << 24;
				//c = ((b1 & 0x03) << 4);
				
				if (i == v.length) {
	//				buf.put((byte)BASE64_CHARS[c]);
	//				buf.put((byte)'=');
	//				buf.put((byte)'=');
					x |= (BASE64_CHARS[((b1 & 0x03) << 4)] << 16) | ('=' << 8) | '=';
					buf.putInt(x);
					break;
				}
				
				int b2 = v[i++] & 0xFF;
	//			c |= ((b2 & 0xF0) >> 4);
	//			buf.put((byte)BASE64_CHARS[c]);
				x |= (BASE64_CHARS[((b1 & 0x03) << 4) | ((b2 & 0xF0) >> 4)] << 16);
	//			c = ((b2 & 0x0F) << 2);
				
				if (i == v.length) {
	//				buf.put((byte)BASE64_CHARS[c]);
	//				buf.put((byte)'=');
					x |= (BASE64_CHARS[((b2 & 0x0F) << 2)] << 8) | '=';
					buf.putInt(x);
					break;
				}
				
				int b3 = (v[i++] & 0xFF);
				
	//			c = ((b2 & 0x0F) << 2);
	//			c |= ((b3 & 0xC0) >> 6);
				//buf.put((byte)BASE64_CHARS[c]);
				x |= BASE64_CHARS[((b2 & 0x0F) << 2) | ((b3 & 0xC0) >> 6)] << 8;
		
	//			c = (b3 & 0x3F);
				//buf.put((byte)BASE64_CHARS[c]);
				x |= BASE64_CHARS[(b3 & 0x3F)];
				
				buf.putInt(x);
			}
			
			buf.put((byte)'\"');
		}
		
		addComma = true;
	}
	
	private int getBase64Byte(int c) {
		c &= 0xFF;
		if (c >= 'A' && c <= 'Z') return c - 'A';
		if (c >= 'a' && c <= 'z') return c - 'a' + 26;
		if (c >= '0' && c <= '9') return c - '0' + 52;
		if (c == '+') return 62;
		if (c == '/') return 63;
		return -1;
	}
	
	private final static byte[] BASE64_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".getBytes();

	private int internalUtf8Length(String s) {
		int n = 2; // quotes
		if (s != null && s.length() != 0) {
			// s could be \u0000\u0000...
			n += (s.length() * 6);
		}
		return n;
	}
	
	public void putString(String name, String value) {
		ensureRemaining(internalUtf8Length(name) + internalUtf8Length(value) + 2);

		if (addComma) buf.put((byte)','); 
		if (name != null) {
			internalPutString(name, true);
			buf.put((byte)':');
		}
		addComma = false;
		putString(value);
		addComma = true;
	}
	
	public void putJsonValueAscii(String name, String value, int flags) {
		ensureRemaining(internalUtf8Length(name) + internalUtf8Length(value) + 2);
		
		if (addComma) buf.put((byte)',');
		if (name != null) {
			internalPutString(name, true);
			buf.put((byte)':');
		}
		internalPutSimpleAsciiString(value, flags);
		addComma = true;
	}
	
	public void beginElement(String s) {
		ensureRemaining(internalUtf8Length(s) + 2);
		if (addComma) buf.put((byte)',');
		internalPutString(s, true);
		buf.put((byte)':');
		addComma = false;
	}
	
	public void endElement() {
		addComma = true;
	}

	public void putString(String s) {
		ensureRemaining(internalUtf8Length(s) + 1);
		if (addComma) buf.put((byte)','); else addComma = true;
		internalPutString(s, true);
	}
	
	protected void internalPutString(String s, boolean quote) {
		if (s != null && s.length() != 0) {
			if (quote) buf.put((byte)'\"');
			StringTokenizer stok = new StringTokenizer(s, "\t\r\n\"\'\\", true);
			while (stok.hasMoreTokens()) {
				String t = stok.nextToken();
				char c = t.charAt(0);
				if (c == '\t') buf.putShort((short)(('\\' << 8) | 't'));
				else if (c == '\r') buf.putShort((short)(('\\' << 8) | 'r'));
				else if (c == '\n') buf.putShort((short)(('\\' << 8) | 'n'));
				else if (c == '\"') buf.putShort((short)(('\\' << 8) | '\"'));
				else if (c == '\\') buf.putShort((short)(('\\' << 8) | '\\'));
				else {
					for (int i = 0; i < t.length(); i++) {
						internalPutCharUtf8(t.charAt(i));
					}
				}
			}
			if (quote) buf.put((byte)'\"');
		}
		else {
			// put empty string, null values are not supported
			buf.putShort((short)((('\"') << 8) | ('\"')));
		}
	}

	// Crockford
//	private final void internalPutCharUtf8(char z) {
//        if (z < ' ' || (z >= '\u0080' && z < '\u00a0') ||
//                (z >= '\u2000' && z < '\u2100')) {
//			String s = Integer.toHexString((int)z);
//			buf.putShort((short)(('\\' << 8) | 'u'));
//			for (int i = 4; i > s.length(); i--) buf.put((byte)'0');
//			for (int i = 0; i < s.length(); i++) buf.put((byte)s.charAt(i));
//		}
//		else {
//			buf.put((byte)z);
//		}
//	}
	
	private final void internalPutCharUtf8(char z) {
		if (z > 0x800) {
			int a = (z & 0x3F) | 0x80;
			int b = ((z >> 6) & 0x3F) | 0x80;
			int c = ((z >> 12) & 0xF) | 0xE0;
			buf.putShort((short)((c << 8) | b));
			buf.put((byte)a);
		}
		else if (z >= 0x80) {
			int a = (z & 0x3F) | 0x80;
			int b = ((z >> 6) & 0x3F) | 0xC0;
			buf.putShort((short)((b << 8) | a));
		}
		else if (z < 0x20) {
			buf.putInt(('\\' << 24) | ('u' << 16) | ('0' << 8) | '0');
      buf.put(hexCharBytes[(z & 0xF0) >> 4]);
      buf.put(hexCharBytes[z & 0x0F]);
		}
		else {
			buf.put((byte)z);
		}
	}
	
	private final static byte hexCharBytes[] = "0123456789ABCDEF".getBytes(); 
	
	/**
	 * Write a null value.
	 * Used to write the first element of the object table.
	 */
	public final void putNull() {
		ensureRemaining(5);
		if (addComma) buf.put((byte)','); else addComma = true;
		final int n = ('n' << 24) | ('u' << 16) | ('l' << 8) | ('l');
		buf.putInt(n);
	}
	
  private final int STRING_WITHOUT_QUOTE = 0;
	private final int STRING_WITH_QUOTE = 1;
	private final int STRING_LONG_VALUE = 2;
	
	private final void internalPutSimpleAsciiString(String s, int flags) {
	  boolean quote = (flags & STRING_WITH_QUOTE) != 0;
	  boolean isLongValue = (flags & STRING_LONG_VALUE) != 0;
		int n = s.length();
		if (isLongValue) n++;
		if (quote) n += 2;
		ensureRemaining(n);
		if (quote) buf.put((byte)'\"');
		for (int i = 0; i < s.length(); i++) {
			buf.put((byte)s.charAt(i));
		}
		if (isLongValue) buf.put((byte)'.');
		if (quote) buf.put((byte)'\"');
	}
	
	public boolean getBoolean() {
		char c = nextJsonChar(true);
		boolean v = c == 't'; 
		internalSkip(v ? 3 : 4); // skip <rue> or <alse>
		return v;
	}
	
	public char getChar() {
		String s = getString();
		return s != null && s.length() != 0 ? s.charAt(0) : 0;
	}
	
	public short getShort() {
		return (short)getInt();
	}
	
	public int getInt() {
		int v = 0;
		int c = 0;
		boolean neg = false;
		for (;;) {
			c = nextJsonChar(true);
			if (c >= '0' && c <= '9') {
				v *= 10;
				v += (int)(c - '0');
			}
			else if (c == '+') {
			}
			else if (c == '-') {
				neg = true;
			}
			else {
				oneCharBack();
				break;
			}
		}
		return neg ? -v : v;
	}
	
	public long getLong() {
		long v = 0;
		int c = 0;
		boolean neg = false;
		for (;;) {
			c = nextJsonChar(true);
			if (c >= '0' && c <= '9') {
				v *= 10;
				v += (int)(c - '0');
			}
			else if (c == '\'' || c == '\"' || c == '.') {
			}
			else if (c == '+') {
			}
			else if (c == '-') {
				neg = true;
			}
			else {
				oneCharBack();
				break;
			}
		}
		return neg ? -v : v;
	}
	
	public float getFloat() {
		return (float)getDouble();
	}
	
	public double getDouble() {
		StringBuilder sbuf = new StringBuilder(30);
		for (;;) {
			char c = nextJsonChar(true);
			if ((c >= '0' && c <= '9') || (c == '.') || (c == 'e') || (c == 'E') || (c == '-') || (c == '+')) {
				sbuf.append(c);
			}
			else if (c == 'N') {
				internalSkip(2);
				nextJsonChar(false); // update this.lastChar
				return Double.NaN;
			}
			else if (c == 'I') {
				boolean neg = sbuf.length() != 0 && sbuf.charAt(0) == '-'; 
				internalSkip(7);
				nextJsonChar(false); // update this.lastChar
				return neg ? Double.NEGATIVE_INFINITY : Double.POSITIVE_INFINITY;
			}
			else {
				oneCharBack();
				break;
			}
		}
		return Double.parseDouble(sbuf.toString());
	}
	
	public String getString() {
		StringBuilder sbuf = new StringBuilder();

		char quote = nextJsonChar(true);
		if (quote == '\"' || quote == '\'') {
			boolean esc = false;
			for (;;) {
				int c = buf.get() & 0xFF;
				if ((c & 0xE0) == 0xE0) {
					int v = (c & 0xF) << 12;
					c = buf.get() & 0xFF;
					v |= (c & 0x3F) << 6;
					c = buf.get() & 0xFF;
					v |= (c & 0x3F);
					sbuf.append((char)v);
				}
				else if ((c & 0xC0) == 0xC0) {
					int v = (c & 0x1F) << 6;
					c = buf.get() & 0xFF;
					v |= (c & 0x3F);
					sbuf.append((char)v);
				}
				else {
					if (!esc && c == '\\') {
						esc = true;
					}
					else {
						if (esc && c == 't') {
							sbuf.append('\t');
						}
						else if (esc && c == 'r') {
							sbuf.append('\r');
						}
						else if (esc && c == 'n') {
							sbuf.append('\n');
						}
						else if (esc && c == '\\') {
							sbuf.append('\\');
						}
						else if (esc && c == 'u') {
							// \u0001
							int n = buf.getInt();
							StringBuilder sn = new StringBuilder(4);
							sn.append((char)((n >> 24) & 0xFF));
							sn.append((char)((n >> 16) & 0xFF));
							sn.append((char)((n >> 8) & 0xFF));
							sn.append((char)((n >> 0) & 0xFF));
							sbuf.append((char)Integer.parseInt(sn.toString(), 16));
						}
						else if (c == '\"' || c == '\'') {
							if (!esc && c == quote) {
								break;
							}
							sbuf.append((char)c);
						}
						else {
							sbuf.append((char)c);
						}
						esc = false;
					}
				}
			}
		}
		else {
			// null
			buf.position(buf.position()+3);
			return ""; // null-values for Strings are not supported
		}
		
		return sbuf.toString();
	}
	
	private void internalPutDate(String name, Date date) {
	  if (date != null) {
	    putJsonValueAscii(name, dateFormats[0].format(date), STRING_WITH_QUOTE);
	  }
	  else {
	    putJsonValueAscii(name, "null", STRING_WITHOUT_QUOTE);
	  }
	}
	
	public void putDate(Date date) {
	  internalPutDate(null, date);
	}
	
	public void putDate(String name, Date date) {
	  internalPutDate(name, date);
	}
	
	public static Date toDate(Object value) {
    Date date = null;
    if (value != null) {
      String svalue = (String)value;
      if (svalue.length() != 0) {
        for (SimpleDateFormat df : dateFormats) {
          try {
             date = df.parse(svalue);
             break;
          } catch (ParseException ignored) {
          }
        }
      }
     }
    return date;	  
	}
	
	public Date getDate() {
	  return toDate(getString());
	}
	
	public void putTypeId(int v) {
		putInt("_typeId", v);
	}

	public BBufferJson flip() {
		buf.flip();
		return this;
	}
	
	private void internalSkip(int size) {
		buf.position(buf.position() + size);
	}
	
	public int position() {
		return buf.position();
	}
	
	private final void ensureRemaining(int size) {
		
		if (buf.position() + size > buf.capacity()) {
			int cap = Math.max(buf.capacity() << 1, buf.position() + size);
			ByteBuffer nbuf = ByteBuffer.allocate(cap);
			nbuf.order(buf.order());
			buf.flip();
			nbuf.put(buf);
			buf = nbuf;
		}
		
	}

	@Override
	public String toString() {
		return buf.toString();
	}

	private char lastChar;

	public char nextJsonChar(boolean eat) {
		char c = 0;
		try {
			for (;buf.remaining() != 0;) {
				int v = eat ? buf.get() : buf.get(buf.position());
				c = (char)(v & 0xFF);
				switch (c) {
				case ' ':
				case '\n':
				case '\r':
				case '\t':
				  if (!eat) {
				    buf.position(buf.position()+1);
				  }
					break;
				default: {
					lastChar = c;
					return c;
				}
				}
			}
		}
		catch (BufferUnderflowException e) {
			c = 0;
		}
		lastChar = c;
		return c;
	}

	public void nextExpectedJsonChar(char expectedChar, boolean eat) throws BException {
		char c = nextJsonChar(eat);
		if (c != expectedChar) {
			int pos = eat ? buf.position() : (buf.position()-1);
			BException e = new BException(BExceptionC.CORRUPT, "Expecting character " + expectedChar + " at position " + pos);
			log.error(e);
			log.info(this.toDetailString());
			throw e;
		}
	}
	
	public void oneCharBack() {
		int p = buf.position();
		if (p != 0) {
			buf.position(p-1);
		}
	}
	
	public int getLastChar() {
		return lastChar;
	}
	
	private BJsonObject parseJsonObject() throws BException {		
		char c = nextJsonChar(true);
		if (c == '[') {
			return parseJsonArray();
		}
		else if (c == '{') {
			HashMap<String, Object> map = new HashMap<String, Object>();

			c = nextJsonChar(false);
			if (c == '}') {
				internalSkip(1);
			}
			else {
				while (c != '}') {
									
					if (c != '\"' && c != '\'' && c != ',') {
						BException e = new BException(BExceptionC.CORRUPT,
								"Unexpected character " + c + "(" + Integer.toString((int)c & 0xFFFF) + ") at position " + buf.position() + ", expecting element name or array value.");
						log.error(e);
						String s = this.toDetailString();
						log.info(s);
						throw e;
					}
					
					String key = getString();
					if (key == null) {
						BException e = new BException(BExceptionC.CORRUPT, "Expecting element name at position " + buf.position());
						log.error(e);
						log.info(this.toDetailString());
						throw e;
					}
					// key.length() == 0 für eine Map mit key-Wert=""
	
					nextExpectedJsonChar(':', true);
					
					Object value = parseJsonValue();
					
					map.put(key, value);
		
					c = nextJsonChar(true);
				}
			}
			
			return new BJsonObject(map);
		}
		else {
			return new BJsonObject();
		}
	}
	
	public Object parseJsonValue() throws BException {
		Object value = null;
		
		char c = nextJsonChar(false);
		if (c == 0) {
		}
		else if (c == '[') {
			value = parseJsonArray();
		}
		else if (c == '{') {
			value = parseJsonObject();
		}
		else if (c == '\"' || c == '\'') {
			value = getString();
		}
		else if ((c >= '0' && c <= '9') || (c == '-') || (c == '+') || (c == '.') || (c == 'N') || (c == 'I')) {
			value = getDouble();
		}
		else if (c == 't' || c == 'f') {
			value = getBoolean();
		}
		else if (c == 'n') {
			// null
			buf.position(buf.position() + 4);
		}
		else if (c == 'u') {
			// undefined
			buf.position(buf.position() + 9);
		}
		else {
			BException e = new BException(BExceptionC.CORRUPT, "Unexpected character " + c + " at position " + buf.position());
			log.error(e);
			log.info(this.toString());
			throw e;
		}

		return value;
	}
	
	private BJsonObject parseJsonArray() throws BException {
		ArrayList<Object> arr = new ArrayList<Object>();
		nextExpectedJsonChar('[', true);
		char c = nextJsonChar(false);
		if (c == ']') {
			internalSkip(1);
		}
		else {
			while (c != ']' && c != 0) {
				Object value = parseJsonValue();
				arr.add(value);
				c = nextJsonChar(true);
			}
		}
		return new BJsonObject(arr);
	}
	
	/**
	 * Long values are written as strings with a "." as suffix.
	 * The segments are ORed together. 
	 * E.g. longValue = "1.2.4.8." represents value 15.
	 * @param s
	 * @return
	 * @throws NumberFormatException
	 */
	public static long parseLong(String s) throws NumberFormatException{
	  long ret = 0;
    if (s != null && s.length() != 0) {
      String[] arr = s.split("\\.");
      for (int i = 0; i < arr.length; i++) {
        if (arr[i].length() == 0) continue;
    		try {
  	      ret |= Long.parseLong(arr[i]);
    		}
    		catch (NumberFormatException e) {
    			if (!s.startsWith("0x")) throw e; 
    			s = s.substring(2);
    			ret |= Long.valueOf(s, 16);
    		}
      }
    }
    return ret;
	}

  private static SimpleDateFormat[] dateFormats;
  static {
    try {
      dateFormats = new SimpleDateFormat[] {
        // JSON Date format e.g.: 2013-11-09T20:35:16.596Z
        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"),
        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"),
        new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"),
        new SimpleDateFormat("yyyy-MM-dd"),
      };
      for (SimpleDateFormat df : dateFormats) {
        df.setTimeZone(TimeZone.getTimeZone("UTC"));
      }
    }
    catch (Throwable e) {
      System.err.println(e);
    }
  }

	
	private static Log log = LogFactory.getLog(BBufferJson.class);
}

//2,5 times slower for strings with 30 characters.
//public void putString1(String s) {
//	ensureRemaining(s.length() << 1);
//	char[] chars = s.toCharArray();
//	for(char c : chars) buf.putChar(c);
//}
//
//Best for strings shorter 10 characters. 3 times slower for strings with 30 characters.
//public void putString2(String s) {
//	ensureRemaining(s.length() << 1);
//	for(int i = 0; i < s.length(); i++) buf.putChar(s.charAt(i));
//}
//
//3 times slower for strings with 30 characters. Conversion to UTF-8 is faster than to UTF-16.
//public void putString3(String s) {
//	ensureRemaining(s.length() << 1);
//	try {
//		byte[] bytes = s.getBytes(buf.order() == ByteOrder.LITTLE_ENDIAN ? "UTF-16LE" : "UTF-16BE");
//		buf.put(bytes);
//	} catch (UnsupportedEncodingException e) {
//	}
//}
//
