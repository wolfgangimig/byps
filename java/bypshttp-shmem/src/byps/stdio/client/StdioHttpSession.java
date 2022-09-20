package byps.stdio.client;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionContext;

@SuppressWarnings("deprecation")
public class StdioHttpSession implements HttpSession {
  
  private Map<String, Object> attributes = new HashMap<String, Object>();
  private long createTime = System.currentTimeMillis();
  private long lastAccessTime = createTime;
  private String id = Long.toString(rand.nextLong() & Long.MAX_VALUE);
  private int maxInactive = 30 * 60;
  
  public StdioHttpSession() {
  }
  
  public void touch() {
    lastAccessTime = System.currentTimeMillis();
  }

  @Override
  public Object getAttribute(String arg0) {
    return attributes.get(arg0);
  }

  @Override
  public Enumeration<String> getAttributeNames() {
    return Collections.enumeration(attributes.keySet());
  }

  @Override
  public long getCreationTime() {
    return createTime;
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public long getLastAccessedTime() {
    return lastAccessTime;
  }

  @Override
  public int getMaxInactiveInterval() {
    return maxInactive;
  }

  @Override
  public ServletContext getServletContext() {
    throw new UnsupportedOperationException();
  }

  @Override
  public HttpSessionContext getSessionContext() {
    throw new UnsupportedOperationException();
  }

  @Override
  public Object getValue(String arg0) {
    return getAttribute(arg0);
  }

  @Override
  public String[] getValueNames() {
    return attributes.keySet().toArray(new String[0]);
  }

  @Override
  public void invalidate() {
    createTime = 0;
  }

  @Override
  public boolean isNew() {
    return createTime == lastAccessTime;
  }

  @Override
  public void putValue(String arg0, Object arg1) {
    setAttribute(arg0, arg1);
  }

  @Override
  public void removeAttribute(String arg0) {
    attributes.remove(arg0);
  }

  @Override
  public void removeValue(String arg0) {
    removeAttribute(arg0);
  }

  @Override
  public void setAttribute(String arg0, Object arg1) {
    attributes.put(arg0, arg1);
  }

  @Override
  public void setMaxInactiveInterval(int arg0) {
    maxInactive = arg0;
  }

  private final static SecureRandom rand = new SecureRandom();
//  private final static Map<String, StdioHttpSession> sessions = new HashMap<>();
//  
//  public static StdioHttpSession getSession(String id, boolean createIfNotExists) {
//    StdioHttpSession ret = sessions.get(id);
//    if (ret != null) {
//      long now = System.currentTimeMillis();
//      if (ret.lastAccessTime + ret.getMaxInactiveInterval() * 1000 < now) {
//        ret = null;
//      }
//      else {
//        ret.lastAccessTime = now;
//      }
//    }
//    if (ret == null && createIfNotExists) {
//      ret = new StdioHttpSession();
//      sessions.put(id, ret);
//    }
//    return ret;
//  }
}
