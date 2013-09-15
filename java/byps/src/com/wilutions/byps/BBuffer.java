package com.wilutions.byps;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * This is the base class for writing protocol messages in binary or JSON format. 
 *
 */
public abstract class BBuffer {
	
	/**
	 * Create a buffer for the given binary model.
	 * @param bmodel
	 * @param buf Received message bytes or null, if a message has to be send.
	 * @return Either a BBufferBin or a BBufferJson.
	 */
	public static BBuffer create(BBinaryModel bmodel, ByteBuffer buf) {
		
		if (bmodel == BBinaryModel.MEDIUM) {
			return new BBufferBin.Medium(bmodel, buf);
		}
		if (bmodel == BBinaryModel.JSON) {
			return new BBufferJson(buf);
		}
//		if (bmodel == BBinaryModel.SMALL) {
//			return new BBufferBin.Small(bmodel, buf);
//		}
//		if (bmodel == BBinaryModel.TINY) {
//			return new BBufferBin.Tiny(bmodel, buf);
//		}
//		if (bmodel == BBinaryModel.LARGE) {
//			return new BBufferBin.Large(bmodel, buf);
//		}
		throw new IllegalStateException();
	}
	
	/**
	 * Return internal buffer.
	 * @return Internal buffer.
	 */
	public ByteBuffer getBuffer() {
		return this.buf;
	}
	
	/**
	 * Clear internal buffer.
	 */
	public void clear() {
		this.buf.clear();
	}
	
	/**
	 * Returns true, if the supplied array holds a JSON message.
	 * @param arr Message data.
	 * @return true, if it is a JSON message.
	 */
	private static boolean isJSON(byte[] arr) {
		boolean ret = false;
		if (arr.length >= 1) {
			ret = arr[0] == '{';
		}
		return ret;
	}
	
	/**
	 * Format buffer content in order to print it into the log file.
	 * @param buf Message buffer.
	 * @return Buffer content as String.
	 */
	public static String toDetailString(ByteBuffer buf) {
		byte[] arr = buf.array();
		if (isJSON(arr)) {
			return toDetailStringJSON(arr, buf.limit());
		}
		else {
			return toDetailStringBinary(arr, buf.limit());
		}
	}

	/**
	 * Format JSON message in order to print it into the log file.
	 * @param arr Message bytes.
	 * @param limit Length of message bytes.
	 * @return Buffer content as String.
	 */
	private static String toDetailStringJSON(byte[] arr, int limit) {
		StringBuilder sbuf = new StringBuilder();
		final String CRLF = "\r\n";
		try {
			String text = new String(arr, 0, limit, "UTF-8");
			sbuf.append(CRLF).append("String json = \"").append(text).append("\";");
			
			sbuf.append(CRLF).append(CRLF).append("var json = ");
			
			StringBuilder indent = new StringBuilder();
			String indentChar = "";
			String appendCRLF = "";
			char quote = 0;
			for (int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);
				boolean esc = false;
				if (c == '\'' || c == '\"') {
					if (quote == 0) {
						quote = c;
					}
					else if (quote == c) {
						quote = 0;
					}
				}
				else if (c == '\\') {
					i++;
					c = text.charAt(i);
				}
				else if (quote == 0 && (c == '{' || c == '[')) {
					sbuf.append(c);
					indent.append("  ");
					c = 0;
					indentChar = indent.toString();
					appendCRLF = CRLF;
				}
				else if (quote == 0 && (c == '}' || c == ']')) {
					indent.setLength(indent.length()-2);
					sbuf.append(CRLF).append(indent).append(c);
					c = 0;
					indentChar = indent.toString();
					appendCRLF = CRLF;
				}
				else if (quote == 0 && c == ',') {
					sbuf.append(c);
					c = 0;
					indentChar = indent.toString();
					appendCRLF = CRLF;
				}
				else {
					if (quote != 0 && (c == '\'' || c == '\"' || c == '\\')) {
						esc = true;
					}
				}
				
				if (c != 0) {
					sbuf.append(appendCRLF).append(indentChar);
					if (esc) sbuf.append("\\");
					sbuf.append(c);
					indentChar = "";
					appendCRLF = "";
				}
			}
			
			
		} catch (UnsupportedEncodingException e) {
		}
		sbuf.append(";");
		return sbuf.toString();
	}

	/**
	 * Format binary message in order to print it into the log file.
	 * @param arr Message bytes.
	 * @param limit Length of message bytes.
	 * @return Buffer content as String.
	 */
	private static String toDetailStringBinary(byte[] arr, int limit) {
		StringBuilder sbuf = new StringBuilder();
		sbuf.append("\r\nbyte[] bytes = new byte[] {");
		int n = 0;
		int u = (limit % 16) != 0 ? (limit/16 + 1)*16 : limit;
		for (int i = 0; i <= u; i++, n++) {
			if ((n % 16) == 0) {
				if (n != 0) {
					StringBuilder rbuf = new StringBuilder();
					rbuf.append("    // ");
					for (int j = i-16; j < i && j < limit; j++) {
						char c = (char)(arr[j] & 0xFF);
						if (Character.isLetterOrDigit(c) ||
							c == '[' || c == ']' || c == '{' || c == '}' || c == '\"' || c == '\''|| 
							c == ':' || c == '=' || c == ',' || c == '_' || c == '*' || c == '\\' ||
							c == '-' || c == ' ' || c == '+' || c == '/' || c == '?') {
							rbuf.append(c);
						}
						else {
							rbuf.append('.');
						}
					}
					sbuf.append(rbuf.toString());
				}
				sbuf.append("\r\n");
				if (n > limit) break;
			}

			sbuf.append(" ");
			if (i < limit) {
				int c = arr[i] & 0xFF;
				String s = Integer.toHexString(c);
				if (s.length() < 2) sbuf.append("0");
				sbuf.append(s);
			}
			else {
				sbuf.append("  ");
			}
		}
		sbuf.append("};");
		return sbuf.toString();
	}
	
	/**
	 * Format message data into String.
	 * @return Content of the internal buffer as String.
	 */
	public String toDetailString() {
		return toDetailString(this.buf);
	}

	/**
	 * Protected constructor.
	 * The create function should be used to create a BBuffer object.
	 * @param bmodel Binary model.
	 * @param buf Message bytes or null.
	 */
	protected BBuffer(BBinaryModel bmodel, ByteBuffer buf) {
		this.bmodel = bmodel;
		this.buf = buf != null ? buf : ByteBuffer.allocate(10 * 1000);
	}

	// This functions are used in TestSerializePrimitiveTypes.
	// They allow to use the same test function for JSON and binary serialization.
	public abstract BBuffer flip();
	public abstract char getChar();
	public abstract void putChar(char v);
	public abstract String getString();
	public abstract void putString(String v);
	public abstract double getDouble();
	public abstract void putDouble(double v);
	public abstract float getFloat();
	public abstract void putFloat(float v);

	protected final BBinaryModel bmodel;
	protected ByteBuffer buf;

}
