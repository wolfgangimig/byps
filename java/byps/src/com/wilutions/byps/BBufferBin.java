package com.wilutions.byps;


import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class BBufferBin extends BBuffer {
	
	public final static int DISABLE_VERSION_CHECK = 0x7FFFFFFF; 
	
	
	public void putBoolean(boolean v) {
		putByte((byte)(v ? 1 : 0));
	}
	
	public void putByte(byte v) {
		ensureRemaining(1);
		buf.put(v);
	}
	
	public void putByte(char v) {
		ensureRemaining(1);
		buf.put((byte)v);
	}
	
	public void putChar(char v) {
		ensureRemaining(2);
		buf.putChar(v);
	}
	
	public void putShort(short v) {
		ensureRemaining(3);
		buf.putShort(v);
	}
	
	public void putInt(int v) {
		ensureRemaining(4);
		buf.putInt(v);
	}
	
	public void putLong(long v) {
		ensureRemaining(8);
		buf.putLong(v);
	}
	
	public void putFloat(float v) {
		ensureRemaining(4);
		buf.putFloat(v);
	}
	
	public void putDouble(double v) {
		ensureRemaining(8);
		buf.putDouble(v);
	}
	
	public void putString(String s) {
		try {
			if (s != null && s.length() != 0) {
				ensureRemaining(4 + s.length() * 4 + 1);
				byte[] bytes = s.getBytes("UTF-8");
				buf.putInt(bytes.length);
				buf.put(bytes);
			}
			else {
				ensureRemaining(4 + 1);
				buf.putInt(0);
			}

			// Always write a 0-termination.
			// This enables us to access the String in C programs directly inside the buffer. 
			buf.put((byte)0); 
			
		} catch (UnsupportedEncodingException e) {
		}
	}
	
	public String getString() {
		String s = "";
		int len = buf.getInt();
		if (len != 0) {
			byte[] bytes = new byte[len];
			buf.get(bytes);
			try {
				s = new String(bytes, "UTF-8");
			} catch (UnsupportedEncodingException e) {}
		}
		buf.get(); // 0-terminated
		return s;
	}
	
	public boolean getBoolean() {
		return getByte() != 0;
	}
			
	public byte getByte() {
		return buf.get();
	}
	
	public char getChar() {
		return buf.getChar();
	}
	
	public short getShort() {
		return buf.getShort();
	}
	
	public int getInt() {
		return buf.getInt();
	}
	
	public long getLong() {
		return buf.getLong();
	}
	
	public float getFloat() {
		return buf.getFloat();
	}
	
	public double getDouble() {
		return buf.getDouble();
	}
	
	public void putArrayByte(byte[] v) {
		ensureRemaining(v.length);
		buf.put(v);
	}
	public void getArrayByte(byte[] v) {
		buf.get(v);
	}
	
	public abstract void putPointer(int v);
	public abstract void putTypeId(int v);
	public abstract void putLength(int v);
	public abstract int getPointer(); 
	public abstract int getLength(); 
	public abstract int getTypeId(); 

	public BBuffer flip() {
		buf.flip();
		return this;
	}
	
	public void skip(int size) {
		position(buf.position() + size);
	}
	
	public void position(int pos) {
		int size = pos - buf.position();
		if (size > 0) {
			ensureRemaining(size);
		}
		buf.position(pos);
	}
	
	public int position() {
		return buf.position();
	}
	
	public void setObjSizeLimit(int size) {
		
		// set the limit to read at maximum size bytes
		if (size > 0) {
			ensureRemaining(size);
			buf.limit(buf.position() + size);
		}
		
		// remove the limit
		else if (size < 0) {
			buf.limit(buf.capacity());
		}
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

	static class Medium extends BBufferBin {

		protected Medium(BBinaryModel bmodel, ByteBuffer buf) {
			super(bmodel, buf);
		}
		@Override
		public void putLength(int v) {
			putInt(v);
		}
		@Override
		public void putPointer(int v) {
			putInt(v);
		}
		@Override
		public void putTypeId(int v) {
			putInt((int)v);
		}
		@Override
		public int getPointer() {
			return getInt();
		}
		@Override
		public int getLength() {
			return getInt();
		}
		@Override
		public int getTypeId() {
			return getInt();
		}
	}

	static class Small extends BBufferBin {

		protected Small(BBinaryModel bmodel, ByteBuffer buf) {
			super(bmodel, buf);
		}
		@Override
		public void putLength(int v) {
			putShort((short)v);
		}
		@Override
		public void putPointer(int v) {
			putShort((short)v);
		}
		@Override
		public void putTypeId(int v) {
			putShort((short)v);
		}
		@Override
		public int getPointer() {
			return getShort();
		}
		@Override
		public int getLength() {
			return getShort();
		}
		@Override
		public int getTypeId() {
			return getShort();
		}
	}

	static class Tiny extends BBufferBin {

		protected Tiny(BBinaryModel bmodel, ByteBuffer buf) {
			super(bmodel, buf);
		}
		@Override
		public void putLength(int v) {
			putByte((byte)v);
		}
		@Override
		public void putPointer(int v) {
			putByte((byte)v);
		}
		@Override
		public void putTypeId(int v) {
			putByte((byte)v);
		}
		@Override
		public int getPointer() {
			return getByte();
		}
		@Override
		public int getLength() {
			return getByte();
		}
		@Override
		public int getTypeId() {
			return getByte();
		}
	}
	
	static class Large extends BBufferBin {

		protected Large(BBinaryModel bmodel, ByteBuffer buf) {
			super(bmodel, buf);
		}
		@Override
		public void putLength(int v) {
			putLong(v);
		}
		@Override
		public void putPointer(int v) {
			putLong(v);
		}
		@Override
		public void putTypeId(int v) {
			putLong(v);
		}
		@Override
		public int getPointer() {
			return (int)getLong();
		}
		@Override
		public int getLength() {
			return (int)getLong();
		}
		@Override
		public int getTypeId() {
			return (int)getLong();
		}
	}
	
	@Override
	public String toString() {
		return buf.toString();
	}

	public int limit() {
		return buf.limit();
	}
	
	public void limit(int n) {
		buf.limit(n);
	}

	public void setByteOrder(ByteOrder bo) {
		buf.order(bo);
	}
	
	public ByteOrder getByteOrder() {
		return buf.order();
	}
	
	public int getLastChar() {
		throw new UnsupportedOperationException();
	}

	protected BBufferBin(BBinaryModel bmodel, ByteBuffer buf) {
		super(bmodel, buf);
	}

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
