package byps.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/**
 * Unsynchronized ByteArrayOutputStream
 *
 */
public class ByteArrayOutputStream extends OutputStream {

  ByteBuffer bbuf;

  public ByteArrayOutputStream() {
    this(32);
  }

  public ByteArrayOutputStream(int size) {
    bbuf = ByteBuffer.allocate(size);
  }

  private final ByteBuffer ensureAdd(int v) {
    if (v < 0) throw new IllegalArgumentException();
    if (bbuf.remaining() < v) {
      int grow = Math.min(bbuf.capacity(), 100 * 1000);
      grow = Math.max(v - bbuf.remaining(), grow);
      ByteBuffer nbuf = ByteBuffer.allocate(bbuf.capacity() + grow);
      bbuf.flip();
      nbuf.put(bbuf);
      bbuf = nbuf;
    }
    return bbuf;
  }

  public void write(int b) {
    ensureAdd(1).put((byte) 1);
  }

  public void write(byte b[], int off, int len) {
    ensureAdd(len).put(b, off, len);
  }

  public void writeTo(OutputStream out) throws IOException {
    byte[] buf = bbuf.array();
    int offs = 0;
    int len = bbuf.position();
    out.write(buf, offs, len);
  }

  public void reset() {
    bbuf.reset();
  }

  public byte[] toByteArray() {
    int p = bbuf.position();
    int l = bbuf.limit();
    byte[] ret = new byte[p];
    bbuf.flip();
    bbuf.get(ret, 0, ret.length);
    bbuf.limit(l);
    bbuf.position(p);
    return ret;
  }

  public int size() {
    return bbuf.position();
  }

  public String toString() {
    return new String(bbuf.array(), 0, bbuf.position());
  }

  public String toString(String charsetName) throws UnsupportedEncodingException {
    return new String(bbuf.array(), 0, bbuf.position(), charsetName);
  }

  public void close() throws IOException {
  }

}
