package com.wilutions.byps;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public abstract class BBuffer {
	
	public static BBuffer create(BBinaryModel bmodel, ByteBuffer buf) {
		
		if (bmodel == BBinaryModel.MEDIUM) {
			return new BBufferBin.Medium(bmodel, buf);
		}
		if (bmodel == BBinaryModel.JSON) {
			return new BBufferJson(buf);
		}
		if (bmodel == BBinaryModel.SMALL) {
			return new BBufferBin.Small(bmodel, buf);
		}
		if (bmodel == BBinaryModel.TINY) {
			return new BBufferBin.Tiny(bmodel, buf);
		}
		if (bmodel == BBinaryModel.LARGE) {
			return new BBufferBin.Large(bmodel, buf);
		}
		throw new IllegalStateException();
	}
	
	public ByteBuffer getBuffer() {
		return this.buf;
	}
	
	public void writeTo(OutputStream os) throws IOException  {
		buf.flip();
		os.write(buf.array(), 0, buf.limit());
	}
	
	public void readFrom(InputStream is) throws IOException {
		byte[] arr = new byte[1000];
		int len = 0;
		while ((len = is.read(arr)) != -1) {
			buf.put(arr, 0, len);
		}
		buf.flip();
	}
	
	public void clear() {
		this.buf.clear();
	}
	
	private static boolean isJSON(byte[] arr) {
		boolean ret = false;
		if (arr.length >= 1) {
			ret = arr[0] == '{';
		}
		return ret;
	}
	
	public static String toDetailString(ByteBuffer buf) {
		byte[] arr = buf.array();
		if (isJSON(arr)) {
			return toDetailStringJSON(arr, buf.limit());
		}
		else {
			return toDetailStringBinary(arr, buf.limit());
		}
	}

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
	
	public String toDetailString() {
		return toDetailString(this.buf);
	}

	protected BBuffer(BBinaryModel bmodel, ByteBuffer buf) {
		this.bmodel = bmodel;
		this.buf = buf != null ? buf : ByteBuffer.allocate(10 * 1000);
	}

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
