package com.wilutions.byps.http;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.wilutions.byps.BTargetId;

@WebListener
public class HSessionListener implements HttpSessionListener {

  private final Log log = LogFactory.getLog(HSessionListener.class);
  private final static ConcurrentHashMap<BTargetId, HSession> sessions = new ConcurrentHashMap<BTargetId, HSession>();

  @Override
  public void sessionCreated(HttpSessionEvent arg0) {
    if (log.isDebugEnabled()) log.debug("sessionCreated()");
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent arg0) {
    if (log.isDebugEnabled()) log.debug("sessionDestroyed(");
    HttpSession hsess = arg0.getSession();
    if (hsess == null) return;

    HSession sess = (HSession) hsess.getAttribute(HConstants.HTTP_SESSION_ATTRIBUTE_NAME);
    if (sess != null) {
      BTargetId targetId = sess.getTargetId();
      sessions.remove(targetId);
      sess.done();
    }
    if (log.isDebugEnabled()) log.debug(")sessionDestroyed");
  }

  public static void attachBSession(HttpSession hsess, HSession sess) {
    Log log = LogFactory.getLog(HSessionListener.class);
    if (log.isDebugEnabled()) log.debug("sessionDestroyed(");
    hsess.setAttribute(HConstants.HTTP_SESSION_ATTRIBUTE_NAME, sess);
    BTargetId targetId = sess.getTargetId();
    sessions.put(targetId, sess);
    if (log.isDebugEnabled()) log.debug(")sessionDestroyed");

  }

  public static Map<BTargetId, HSession> getAllSessions() {
    return sessions;
  }
}
