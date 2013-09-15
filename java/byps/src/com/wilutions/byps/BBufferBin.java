package com.wilutions.byps;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class BBufferBin extends BBuffer {

  public final static int DISABLE_VERSION_CHECK = 0x7FFFFFFF;
  private byte[] helpBufferInt = new byte[9];
  private byte[] helpBufferStr = new byte[0];
  protected boolean compressInteger = true;

  public void putBoolean(boolean v) {
    putByte((byte) (v ? 1 : 0));
  }

  public void putByte(byte v) {
    ensureRemaining(1);
    buf.put(v);
  }

  public void putByte(char v) {
    ensureRemaining(1);
    buf.put((byte) v);
  }

  public void putChar(char v) {
    ensureRemaining(2);
    buf.putChar(v);
  }

  public void putShort(short v) {
    ensureRemaining(2);
    buf.putShort(v);
  }

  private void putIntCompressed(int v) {
    ensureRemaining(5);

    if (v == 0) {
      buf.put((byte) 0);
    }
    else {
      boolean neg = v < 0;
      if (neg) v = -v;

      int i = 0;
      for (; i < 4 && v != 0; i++) {
        helpBufferInt[i + 1] = (byte) (v & 0xFF);
        v >>= 8;
      }

      helpBufferInt[0] = (byte) (neg ? -i : i);
      buf.put(helpBufferInt, 0, i + 1);
    }

  }

  public void putInt(int v) {

    if (compressInteger) {
      putIntCompressed(v);
    }
    else {
      ensureRemaining(4);
      buf.putInt(v);
    }
  }

  private void putLongCompressed(long v) {
    ensureRemaining(9);

    if (v == 0) {
      buf.put((byte) 0);
    }
    else {
      boolean neg = v < 0;
      if (neg) v = -v;

      int i = 0;
      for (; i < 8 && v != 0; i++) {
        helpBufferInt[i + 1] = (byte) (v & 0xFF);
        v >>= 8;
      }

      helpBufferInt[0] = (byte) (neg ? -i : i);
      buf.put(helpBufferInt, 0, i + 1);
    }

  }

  public void putLong(long v) {
    if (compressInteger) {
      putLongCompressed(v);
    }
    else {
      ensureRemaining(8);
      buf.putLong(v);
    }
  }

  public void putFloat(float v) {
    ensureRemaining(4);
    buf.putFloat(v);
  }

  public void putDouble(double v) {
    ensureRemaining(8);
    buf.putDouble(v);
  }

  public void putString(String str) {
    // Always write a 0-termination.
    // This enables us to access the String in C programs directly inside the
    // buffer.
    
    if (str != null && str.length() != 0) {
      
      int len = 3 * str.length();
      if (helpBufferStr.length < len) helpBufferStr = new byte[len];
      
      int j = 0;
      for (int i = 0; i < str.length(); i++) {
        
        char c = str.charAt(i);

        if (c <= 0x7F) {
          helpBufferStr[j++] = ((byte)c);
        }
        else if (c >= 0x80 && c <= 0x07FF) {
          helpBufferStr[j++] = ((byte)(((c >> 6) & 0x1F) | 0xC0));
          helpBufferStr[j++] = ((byte)((c & 0x3F) | 0x80));
        }
        else { // if (c >= 0x800 && c <= 0xFFFF) {
          helpBufferStr[j++] = ((byte)(((c >> 12) & 0xF) | 0xE0));
          helpBufferStr[j++] = ((byte)(((c >> 6) & 0x3F) | 0x80));
          helpBufferStr[j++] = ((byte)((c & 0x3F) | 0x80));
        }

      }
 
      ensureRemaining(4 + j + 1);
      putInt(j);
      buf.put(helpBufferStr, 0, j);
      buf.put((byte) 0);
   }
    else {
      ensureRemaining(4+1);
      putInt(0);
      buf.put((byte) 0);
    }

  }

  public String getString() {
    String s = "";
    int len = getInt();
    if (len != 0) {
      if (helpBufferStr.length < len) helpBufferStr = new byte[len];
      buf.get(helpBufferStr, 0, len);
      try {
        s = new String(helpBufferStr, 0, len, "UTF-8");
      } catch (UnsupportedEncodingException e) {
        throw new IllegalStateException("Corrupt string.");
      }
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

  private int getIntCompressed() {
    int i = buf.get();
    if (i == 0) return 0;

    int v = 0;
    boolean neg = i < 0;
    if (neg) i = -i;

    buf.get(helpBufferInt, 0, i);

    while (i-- > 0) {
      v <<= 8;
      v |= ((int) (helpBufferInt[i])) & 0xFF;
    }

    return neg ? -v : v;
  }

  public int getInt() {
    if (compressInteger) {
      return getIntCompressed();
    }
    else {
      return buf.getInt();
    }
  }

  public long getLongCompressed() {
    int i = buf.get();
    if (i == 0) return 0;

    long v = 0;
    boolean neg = i < 0;
    if (neg) i = -i;

    buf.get(helpBufferInt, 0, i);

    while (i-- > 0) {
      v <<= 8;
      v |= ((int) (helpBufferInt[i])) & 0xFF;
    }

    return neg ? -v : v;
  }

  public long getLong() {
    if (compressInteger) {
      return getLongCompressed();
    }
    else {
      return buf.getLong();
    }
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
      putInt((int) v);
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
      putShort((short) v);
    }

    @Override
    public void putPointer(int v) {
      putShort((short) v);
    }

    @Override
    public void putTypeId(int v) {
      putShort((short) v);
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
      putByte((byte) v);
    }

    @Override
    public void putPointer(int v) {
      putByte((byte) v);
    }

    @Override
    public void putTypeId(int v) {
      putByte((byte) v);
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
      return (int) getLong();
    }

    @Override
    public int getLength() {
      return (int) getLong();
    }

    @Override
    public int getTypeId() {
      return (int) getLong();
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

  public static void main(String[] args) {
    int n = 10 * 1000 * 1000;

    BBufferBin bbuf = new BBufferBin.Medium(BBinaryModel.MEDIUM, null);
    sendrecv(bbuf, n);

    bbuf = new BBufferBin.Medium(BBinaryModel.MEDIUM, null);
    bbuf.compressInteger = false;
    sendrecv(bbuf, n);

  }

  protected static void sendrecv(BBufferBin bbuf, int n) {
    long t1 = System.currentTimeMillis();
    for (int i = 0; i < n; i++) {
      long v = 1 << (i % 64);
      bbuf.putLong(-v);
    }

    bbuf.buf.flip();

    for (int i = 0; i < n; i++) {
      bbuf.getLong();
    }
    long t2 = System.currentTimeMillis();
    System.out.println("dt=" + (t2 - t1) + ", #bytes=" + bbuf.buf.position());
  }

  public boolean isCompressInteger() {
    return compressInteger;
  }

  public boolean setCompressInteger(boolean compressInteger) {
    boolean ret = this.compressInteger;
    this.compressInteger = compressInteger;
    return ret;
  }

}

// 2,5 times slower for strings with 30 characters.
// public void putString1(String s) {
// ensureRemaining(s.length() << 1);
// char[] chars = s.toCharArray();
// for(char c : chars) buf.putChar(c);
// }
//
// Best for strings shorter 10 characters. 3 times slower for strings with 30
// characters.
// public void putString2(String s) {
// ensureRemaining(s.length() << 1);
// for(int i = 0; i < s.length(); i++) buf.putChar(s.charAt(i));
// }
//
// 3 times slower for strings with 30 characters. Conversion to UTF-8 is faster
// than to UTF-16.
// public void putString3(String s) {
// ensureRemaining(s.length() << 1);
// try {
// byte[] bytes = s.getBytes(buf.order() == ByteOrder.LITTLE_ENDIAN ? "UTF-16LE"
// : "UTF-16BE");
// buf.put(bytes);
// } catch (UnsupportedEncodingException e) {
// }
// }
//
