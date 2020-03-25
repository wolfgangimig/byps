package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import byps.BHashMap;

@WebListener
public class HSessionListener implements HttpSessionListener {

  //private final static Logger log = LoggerFactory.getLogger(HSessionListener.class);
  private final static BHashMap<String, HSession> sessions = new BHashMap<String, HSession>();
  
  public HSessionListener() {
    sessions.clear(); // just to be able to set a breakpoint
  }

  public static BHashMap<String, HSession> getAllSessions() {
    return sessions;
  }

  @Override
  public void sessionCreated(HttpSessionEvent sessionEvent) {
    
    HttpSession hsess = sessionEvent.getSession();
    
    // BYPS-19: ensure that the HHttpSessionObject is uniquely created for a Tomcat session.  
    
    // Assign a set of BYPS session objects to the app server's session.
    hsess.setAttribute(HConstants.HTTP_SESSION_BYPS_SESSIONS, new HHttpSessionObject());

    // Constrain the lifetime of the session to 10s. It is extended, if the
    // session gets authenticated.
    hsess.setMaxInactiveInterval(HConstants.MAX_INACTIVE_SECONDS_BEFORE_AUTHENTICATED);

  }

  @Override
  public void sessionDestroyed(HttpSessionEvent arg0) {
  }
}
