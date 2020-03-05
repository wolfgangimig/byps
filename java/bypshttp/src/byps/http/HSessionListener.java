package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import javax.servlet.annotation.WebListener;
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
  public void sessionCreated(HttpSessionEvent arg0) {
  }

  @Override
  public void sessionDestroyed(HttpSessionEvent arg0) {
  }
}
