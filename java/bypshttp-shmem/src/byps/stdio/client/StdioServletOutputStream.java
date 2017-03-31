package byps.stdio.client;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;

import byps.io.ByteArrayOutputStream;

public class StdioServletOutputStream extends ServletOutputStream {
  
  private final OnClose onClose;
  private final ByteArrayOutputStream ostream = new ByteArrayOutputStream();
  private final AtomicBoolean closed = new AtomicBoolean();
  
  public static interface OnClose {
    public void handle(ByteBuffer bbuf);
  }
  
  StdioServletOutputStream(OnClose onClose) {
    this.onClose = onClose;
  }
  
  public ByteBuffer toByteBuffer() {
    return ostream.toByteBuffer();
  }
  
  @Override
  public void close() throws IOException {
    if (closed.compareAndSet(false, true)) {
      onClose.handle(toByteBuffer());
    }
  }

  @Override
  public boolean isReady() {
    return false;
  }

  @Override
  public void setWriteListener(WriteListener arg0) {
  }

  @Override
  public void write(int arg0) throws IOException {
    ostream.write(arg0);
  }

  @Override
  public void write(byte[] b) throws IOException {
    ostream.write(b);
  }
  
  @Override
  public void write(byte[] b, int off, int len) throws IOException {
    ostream.write(b, off, len);
  }
}
