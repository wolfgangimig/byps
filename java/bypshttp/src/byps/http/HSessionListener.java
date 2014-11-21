package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import javax.servlet.annotation.WebListener;

import byps.BHashMap;

@WebListener
public class HSessionListener {

  //private final static Log log = LogFactory.getLog(HSessionListener.class);
  private final static BHashMap<String, HSession> sessions = new BHashMap<String, HSession>();
  
  public HSessionListener() {
    sessions.clear(); // just to be able to set a breakpoint
  }

  public static BHashMap<String, HSession> getAllSessions() {
    return sessions;
  }
}
