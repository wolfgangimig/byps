package com.wilutions.byps.http;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.wilutions.byps.BTargetId;

@WebListener
public class HSessionListener implements HttpSessionListener {

    private final static ConcurrentHashMap<BTargetId, HSession> sessions = new ConcurrentHashMap<BTargetId, HSession>();
    
    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
    	HttpSession hsess = arg0.getSession();
    	if (hsess == null) return;

		HSession sess = (HSession)hsess.getAttribute(HConstants.HTTP_SESSION_ATTRIBUTE_NAME);
		if (sess != null) {
			BTargetId targetId = sess.getTargetId();
			sessions.remove(targetId);
	    	sess.done();
		}
    	
    }

    public static void attachBSession(HttpSession hsess, HSession sess) {
		hsess.setAttribute(HConstants.HTTP_SESSION_ATTRIBUTE_NAME, sess);
		BTargetId targetId = sess.getTargetId();
		sessions.put(targetId, sess);
    }
    
    public static Map<BTargetId, HSession> getAllSessions() {
    	return sessions;
    }
}
