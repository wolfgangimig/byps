package byps.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/**
 * Unsynchronized ByteArrayInputStream.
 */
public final class ByteArrayInputStream extends InputStream {

  final ByteBuffer bbuf;

  public ByteArrayInputStream() {
    bbuf = ByteBuffer.wrap(new byte[0]);
  }

  public ByteArrayInputStream(byte[] buf) {
    bbuf = ByteBuffer.wrap(buf);
  }

  public ByteArrayInputStream(byte[] buf, int count) {
    bbuf = ByteBuffer.wrap(buf, 0, count);
  }

  public ByteArrayInputStream(byte buf[], int offset, int length) {
    bbuf = ByteBuffer.wrap(buf, offset, length);
  }
  
  public ByteArrayInputStream(java.io.ByteArrayInputStream bis) {
    try {
      byte[] buf = (byte[])java.io.ByteArrayInputStream.class.getField("buf").get(bis);
      int pos = (Integer)java.io.ByteArrayInputStream.class.getField("pos").get(bis);
      int count = (Integer)java.io.ByteArrayInputStream.class.getField("count").get(bis);
      bbuf = ByteBuffer.wrap(buf, pos, count);
    } catch (Exception e) {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public final int available() {
    return bbuf.remaining();
  }

  @Override
  public final int read() {
    return bbuf.remaining() != 0 ? bbuf.get() : -1;
  }

  @Override
  public final int read(byte[] b, int off, int len) {
    int c = bbuf.remaining();
    if (c == 0) return -1;
    c = Math.min(len, c);
    bbuf.get(b, off, c);
    return c;
  }

  @Override
  public final long skip(long n) {
    int c = bbuf.remaining();
    if (c == 0) return 0;
    c = (int)Math.min(n, (long)c);
    bbuf.position(bbuf.position() + c);
    return (long)c;
  }

  @Override
  public boolean markSupported() {
    return false;
  }

  @Override
  public void mark(int readlimit) {
    throw new UnsupportedOperationException();
  }

  public void copyTo(OutputStream os, int max) throws IOException {
    byte[] buf = bbuf.array();
    int offset = bbuf.position();
    int length = Math.min(max, bbuf.remaining());
    os.write(buf, offset, length);
    bbuf.position(offset + length);
  }
  
}