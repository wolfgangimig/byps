package byps.http;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import byps.BHashMap;

// @WebListener
// BYPS-27: This class is no more annotated with @WebListener.
// It should not be instantiated automatically because of side effects
// in web applications that only use the client side of BYPS.


public class HSessionListener implements HttpSessionListener {

  //private final static Logger log = LoggerFactory.getLogger(HSessionListener.class);
  private final static BHashMap<String, HSession> sessions = new BHashMap<String, HSession>();
  
  public HSessionListener() {
  }

  public static BHashMap<String, HSession> getAllSessions() {
    return sessions;
  }
  
  /**
   * Add an instance of HHttpSessionObject to the Tomcat session.  
   * @param hsess Tomcat session.
   * @return HHttpSessionObject
   */
  public static HHttpSessionObject initHttpSession(HttpSession hsess) {
    HHttpSessionObject obj = new HHttpSessionObject();
    
    // BYPS-19: ensure that the HHttpSessionObject is uniquely created for a Tomcat session.  
    
    // Assign a set of BYPS session objects to the app server's session.
    hsess.setAttribute(HConstants.HTTP_SESSION_BYPS_SESSIONS, obj);

    // Constrain the lifetime of the session to 10s. It is extended, if the
    // session gets authenticated.
    hsess.setMaxInactiveInterval(HConstants.MAX_INACTIVE_SECONDS_BEFORE_AUTHENTICATED);
    
    return obj;
  }

  @Override
  public void sessionCreated(HttpSessionEvent sessionEvent) {
    HttpSession hsess = sessionEvent.getSession();
    initHttpSession(hsess);
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent arg0) {
  }
}
