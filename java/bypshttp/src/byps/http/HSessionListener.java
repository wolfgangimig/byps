package byps.http;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import javax.servlet.annotation.WebListener;

import byps.BHashMap;
import byps.BTargetId;

@WebListener
public class HSessionListener {

  //private final static Log log = LogFactory.getLog(HSessionListener.class);
  private final static BHashMap<BTargetId, HSession> sessions = new BHashMap<BTargetId, HSession>();
  
  public HSessionListener() {
    sessions.clear(); // just to be able to set a breakpoint
  }

  public static BHashMap<BTargetId, HSession> getAllSessions() {
    return sessions;
  }
}
