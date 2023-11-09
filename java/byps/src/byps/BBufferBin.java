package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public abstract class BBufferBin extends BBuffer {

  public final static int DISABLE_VERSION_CHECK = 0x7FFFFFFF;
  private byte[] helpBufferInt = new byte[10];
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
  
  public void putInt(int v) {

    if (compressInteger) {
      putLongCompressed(v);
    }
    else {
      ensureRemaining(4);
      buf.putInt(v);
    }
  }

  // EIX-1145 
  public void putTargetId(BTargetId targetId, int bversion) {
    ensureRemaining(40);
    targetId.write(buf, bversion);
  }
  
  // EIX-1145 
  public BTargetId getTargetId(int bversion) {
    return BTargetId.read(buf, bversion);
  }

  // https://developers.google.com/protocol-buffers/docs/encoding#varints
  private void putLongCompressed(long v) {
    ensureRemaining(10);

    if (v == 0) {
      buf.put((byte) 0);
    }
    else {
      boolean neg = v < 0;
      if (neg) v = -(v+1);
      v <<= 1;
      if (neg) v |= 1;

      int i = 0;
      for (; i < 10 && v != 0; i++) {
        boolean moreBytes = (v & ~0x7F) != 0;
        int h = ((int)v) & 0x7F;
        if (moreBytes) h |= 0x80; 
        helpBufferInt[i] = (byte)h;
        v >>>= 7;
      }

      buf.put(helpBufferInt, 0, i);
    }

  }

  private long getLongCompressed() {
    
    long v = 0;
    
    int shift = 0;
    boolean moreBytes = true;
    while (moreBytes) {
      int h = buf.get();
      moreBytes = (h & 0x80) != 0;
      v |= ((long)(h & 0x7F)) << shift;
      shift += 7;
    }

    boolean neg = (v & 0x01) != 0;
    v >>>= 1;
      
    if (neg) v = -(v+1);
    
    return v;
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
    
    // BYPS-74: support 4-byte UTF-8 characters.
    
    if (str != null && str.length() != 0) {
      
      int maxByteLength = 4 * str.length();
      if (helpBufferStr.length < maxByteLength) helpBufferStr = new byte[maxByteLength];
      ByteBuffer hbuf = ByteBuffer.wrap(helpBufferStr);
      
//      Also possible ... but allocates an IntStream for codePoints() and is most likely slower than the while-loop below.
//      str.codePoints().forEach(c -> {
//
//        if (c <= 0x7F) {
//          hbuf.put((byte)c);
//        }
//        else if (c >= 0x80 && c <= 0x07FF) {
//          hbuf.put((byte)(((c >> 6) & 0x1F) | 0xC0));
//          hbuf.put((byte)((c & 0x3F) | 0x80));
//        }
//        else if (c >= 0x800 && c <= 0xFFFF) {
//          hbuf.put((byte)(((c >> 12) & 0xF) | 0xE0));
//          hbuf.put((byte)(((c >> 6) & 0x3F) | 0x80));
//          hbuf.put((byte)((c & 0x3F) | 0x80));
//        }
//        else { 
//          hbuf.put((byte)(((c >> 18) & 0xF) | 0xF0));
//          hbuf.put((byte)(((c >> 12) & 0x3F) | 0x80));
//          hbuf.put((byte)(((c >> 6) & 0x3F) | 0x80));
//          hbuf.put((byte)((c & 0x3F) | 0x80));
//        }
//
//      });
      

      int i = 0;
      while (i < str.length()) {
        char c = str.charAt(i++);
        
        if (c <= 0x7F) {
          hbuf.put((byte)c);
        }
        else if (c >= 0x80 && c <= 0x07FF) {
          hbuf.put((byte)(((c >> 6) & 0x1F) | 0xC0));
          hbuf.put((byte)((c & 0x3F) | 0x80));
        }
        else if (Character.isHighSurrogate(c) && i < str.length()) {
          char cL = str.charAt(i);
          if (Character.isLowSurrogate(cL)) {
            int cp = Character.toCodePoint(c, cL);
            hbuf.put((byte)(((cp >> 18) & 0xF) | 0xF0));
            hbuf.put((byte)(((cp >> 12) & 0x3F) | 0x80));
            hbuf.put((byte)(((cp >> 6) & 0x3F) | 0x80));
            hbuf.put((byte)((cp & 0x3F) | 0x80));
            i++;
            continue;
          }
        }
        
        if (c >= 0x800 && c <= 0xFFFF) {
          hbuf.put((byte)(((c >> 12) & 0xF) | 0xE0));
          hbuf.put((byte)(((c >> 6) & 0x3F) | 0x80));
          hbuf.put((byte)((c & 0x3F) | 0x80));
        }
      }


      hbuf.flip();
      int byteLength = hbuf.limit();
      ensureRemaining(4 + byteLength + 1);
      putInt(byteLength);
      buf.put(hbuf);
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
    int byteLength = getInt();
    if (byteLength != 0) {
      if (helpBufferStr.length < byteLength) helpBufferStr = new byte[byteLength];
      buf.get(helpBufferStr, 0, byteLength);
      s = new String(helpBufferStr, 0, byteLength, StandardCharsets.UTF_8);
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
    if (compressInteger) {
      return (int)getLongCompressed();
    }
    else {
      return buf.getInt();
    }
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
  
  public void putDate(Date v) {
    if (v == null ) v = new Date(0);
    GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    calendar.setTime(v);
      
    final int year = calendar.get(Calendar.YEAR);
    final int month = calendar.get(Calendar.MONTH) + 1;
    final int day = calendar.get(Calendar.DAY_OF_MONTH);
    final int hour = calendar.get(Calendar.HOUR_OF_DAY);
    final int minute = calendar.get(Calendar.MINUTE);
    final int second = calendar.get(Calendar.SECOND);
    final int millis = calendar.get(Calendar.MILLISECOND);
    
    final short _year = (short)year;
    final short _mmdd = (short)((month << 8) | day);
    final short _hhmm = (short)((hour << 8) | minute);
    final short _ssuu = (short)((second << 10) | millis);
    
    ensureRemaining(10);
    putShort(_year);
    putShort(_mmdd);
    putShort(_hhmm);
    putShort(_ssuu);
  }
  
  public Date getDate() {
    final short _year = getShort();
    final short _mmdd = getShort();
    final short _hhmm = getShort();
    final short _ssuu = getShort();
    
    final int year = _year;
    final int month = _mmdd >>> 8;
    final int day = _mmdd & 0xFF;
    final int hour = _hhmm >>> 8;
    final int minute = _hhmm & 0xFF;
    final int second = ((int)_ssuu >>> 10) & 0x3F; 
    final int millis = _ssuu & 0x3FF;
    
    GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
    calendar.set(Calendar.YEAR, year);
    calendar.set(Calendar.MONTH, month-1);
    calendar.set(Calendar.DAY_OF_MONTH, day);
    calendar.set(Calendar.HOUR_OF_DAY, hour);
    calendar.set(Calendar.MINUTE, minute);
    calendar.set(Calendar.SECOND, second);
    calendar.set(Calendar.MILLISECOND, millis);
    
    Date date = calendar.getTime();
    return date;
  }

  public void putArrayByte(byte[] v) {
    ensureRemaining(v.length);
    buf.put(v);
  }

  public void getArrayByte(byte[] v) {
    buf.get(v);
  }

  public void putByteBuffer(ByteBuffer v) {
    ensureRemaining(v.remaining());
    buf.put(v);
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
