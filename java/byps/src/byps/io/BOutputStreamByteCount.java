package byps.io;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Wraps an OutputStream and counts the bytes written.
 *
 */
public class BOutputStreamByteCount extends OutputStream {

  private final OutputStream innerStream;
  private long byteCount;

  public BOutputStreamByteCount(OutputStream innerStream) {
    this.innerStream = innerStream;
  }

  @Override
  public void write(int b) throws IOException {
    innerStream.write(b);
    byteCount++;
  }

  @Override
  public void write(byte[] b) throws IOException {
    this.write(b, 0, b.length);
  }

  @Override
  public void write(byte[] b, int offs, int len) throws IOException {
    innerStream.write(b, offs, len);
    byteCount += len;
  }

  @Override
  public void close() throws IOException {
    innerStream.close();
  }
  
  public long getByteCount() {
    return byteCount;
  }


}
