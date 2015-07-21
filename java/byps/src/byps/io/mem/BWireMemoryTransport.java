package byps.io.mem;

import java.io.InputStream;
import java.lang.reflect.Method;

public class BWireMemoryTransport {
  
  private Object impl;

  public BWireMemoryTransport(Object impl) {
    this.impl = impl;
  }

  public void putMessage(long messageId, byte[] buf) {
    try {
      Class<?> clazz = impl.getClass();
      Method m = clazz.getDeclaredMethod("putMessage", long.class, byte[].class);
      m.invoke(impl, messageId, buf);
    }
    catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }

  public byte[] waitForMessage() throws InterruptedException {
    byte[] ret = null;
    try {
      Class<?> clazz = impl.getClass();
      Method m = clazz.getDeclaredMethod("waitForMessage");
      ret = (byte[])m.invoke(impl);
    }
    catch (Exception e) {
      throw new IllegalStateException(e);
    }
    return ret;
  }

  public void cancel(long messageId) {
    try {
      Class<?> clazz = impl.getClass();
      Method m = clazz.getDeclaredMethod("cancel", long.class);
      m.invoke(impl, messageId);
    }
    catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }

  public void done() {
    try {
      Class<?> clazz = impl.getClass();
      Method m = clazz.getDeclaredMethod("done");
      m.invoke(impl);
    }
    catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }

  public void putStream(long messageId, long streamId, InputStream istream) {
    try {
      Class<?> clazz = impl.getClass();
      Method m = clazz.getDeclaredMethod("putStream", long.class, long.class, InputStream.class);
      m.invoke(impl, messageId, streamId, istream);
    }
    catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }

  public InputStream waitForStream(long messageId, long streamId)
      throws InterruptedException {
    InputStream ret = null;
    try {
      Class<?> clazz = impl.getClass();
      Method m = clazz.getDeclaredMethod("waitForStream", long.class, long.class);
      ret = (InputStream)m.invoke(impl, messageId, streamId);
    }
    catch (Exception e) {
      throw new IllegalStateException(e);
    }
    return ret;
  }

  public void putResponse(long messageId, byte[] buf) {
    try {
      Class<?> clazz = impl.getClass();
      Method m = clazz.getDeclaredMethod("putResponse", long.class, byte[].class);
      m.invoke(impl, messageId, buf);
    }
    catch (Exception e) {
      throw new IllegalStateException(e);
    }
  }

  public byte[] waitForResponse(long messageId) throws InterruptedException {
    byte[] ret = null;
    try {
      Class<?> clazz = impl.getClass();
      Method m = clazz.getDeclaredMethod("waitForResponse", long.class);
      ret = (byte[])m.invoke(impl, messageId);
    }
    catch (Exception e) {
      throw new IllegalStateException(e);
    }
    return ret;
  }

}
