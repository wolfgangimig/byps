package byps.stdio.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;

public class StdioServletInputStream extends ServletInputStream {
  
  private InputStream istream;
  
  protected StdioServletInputStream(ByteBuffer bbuf) {
    this.istream = new ByteArrayInputStream(bbuf.array(), bbuf.position(), bbuf.limit());
  }

  @Override
  public boolean isFinished() {
    return false;
  }

  @Override
  public boolean isReady() {
    return false;
  }

  @Override
  public void setReadListener(ReadListener arg0) {
  }
  
  @Override
  public int read(byte[] b) throws IOException {
    return istream.read(b);
  }
  
  @Override
  public int read(byte[] b, int off, int len) throws IOException {
    return istream.read(b, off, len);
  }
  
  @Override
  public int read() throws IOException {
    return istream.read();
  }

}
