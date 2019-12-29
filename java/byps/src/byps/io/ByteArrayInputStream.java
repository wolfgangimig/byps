package byps.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/**
 * Unsynchronized ByteArrayInputStream.
 */
public final class ByteArrayInputStream extends InputStream {

  private final ByteBuffer bbuf;

  public ByteArrayInputStream() {
    bbuf = ByteBuffer.wrap(new byte[0]);
  }

  public ByteArrayInputStream(byte[] buf) {
    bbuf = ByteBuffer.wrap(buf);
  }

  public ByteArrayInputStream(byte[] buf, int count) {
    bbuf = ByteBuffer.wrap(buf, 0, count);
  }

  public ByteArrayInputStream(byte[] buf, int offset, int length) {
    bbuf = ByteBuffer.wrap(buf, offset, length);
  }
  
  @Override
  public final int available() {
    return bbuf.remaining();
  }

  @Override
  public final int read() {
    if (bbuf.remaining() == 0) return -1;
    byte b = bbuf.get();
    return ((int)b) & 0xFF;
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
  public synchronized void mark(int readlimit) {
    throw new UnsupportedOperationException();
  }

  public void copyTo(OutputStream os, int max) throws IOException {
    byte[] buf = bbuf.array();
    int offset = bbuf.position();
    int length = Math.min(max, bbuf.remaining());
    os.write(buf, offset, length);
    bbuf.position(offset + length);
  }
  
  public ByteBuffer getBuffer() {
    return bbuf;
  }
}