package byps.io;

import java.io.InputStream;
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

}