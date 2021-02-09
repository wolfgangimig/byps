package byps.io;

import java.io.IOException;
import java.io.InputStream;

public class BInputStreamByteCount extends InputStream {
  
  private final InputStream innerStream;
  private long byteCount;
  
  public BInputStreamByteCount(InputStream innerStream) {
    this.innerStream = innerStream;
  }

  @Override
  public int read() throws IOException {
    int ret = innerStream.read();
    if (ret != -1) byteCount++;
    return ret;
  }

  @Override
  public int read(byte[] b) throws IOException {
    return this.read(b, 0, b.length);
  }
  
  @Override
  public int read(byte[] b, int off, int len) throws IOException {
    int ret = innerStream.read(b, off, len);
    if (ret != -1) byteCount += ret;
    return ret;
  }
  
  @Override
  public void close() throws IOException {
    innerStream.close();
  }
  
  public long getByteCount() {
    return byteCount;
  }
}
