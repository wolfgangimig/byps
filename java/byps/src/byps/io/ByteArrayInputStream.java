package byps.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    return ((int) b) & 0xFF;
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
    c = (int) Math.min(n, (long) c);
    bbuf.position(bbuf.position() + c);
    return (long) c;
  }

  @Override
  public boolean markSupported() {
    return false;
  }

  @Override
  public synchronized void mark(int readlimit) {
    throw new UnsupportedOperationException();
  }

  private static Logger log = LoggerFactory.getLogger(ByteArrayInputStream.class);
  
  public void copyTo(OutputStream os, int max) throws IOException {
    if (log.isDebugEnabled()) log.debug("copyTo(os={}, max={}", os, max);
    byte[] buf = bbuf.array();
    int offset = bbuf.position();
    int length = Math.min(max, bbuf.remaining());
    if (log.isDebugEnabled()) log.debug("os.write(buf, {}, {})", offset, length);
    os.write(buf, offset, length);
    bbuf.position(offset + length);
    if (log.isDebugEnabled()) log.debug(")copyTo");
  }

  public ByteBuffer getBuffer() {
    return bbuf;
  }

  @Override
  public String toString() {
    return "[bbuf=" + bbuf + "]";
  }
}