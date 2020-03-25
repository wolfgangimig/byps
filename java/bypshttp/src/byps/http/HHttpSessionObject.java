package byps.http;

import java.util.ArrayList;
import java.util.Optional;

public class HHttpSessionObject {

  private ArrayList<HSession> sessions = new ArrayList<HSession>();

  public synchronized void addSession(HSession s) {
    sessions.add(s);
  }
  
  public synchronized void removeSession(HSession s) {
    for (int i = 0; i < sessions.size(); i++) {
      HSession o = sessions.get(i);
      if (o == s) {
        sessions.remove(i);
        break;
      }
    }
  }
  
  public synchronized Optional<HSession> getSession(String sessionId) {
    HSession bypsSession = HSessionListener.getAllSessions().get(sessionId);
    return sessions.stream().filter(s -> s == bypsSession).findAny();
  }
  
  public synchronized Optional<HSession> getFirstSession() {
    return sessions.stream().findFirst();
  }
  
  public synchronized boolean isEmpty() {
    return sessions.isEmpty();
  }

  public synchronized int size() {
    return sessions.size();
  }
  
  public String toString() {
    StringBuilder sbuf = new StringBuilder();
    sbuf.append("[");
    boolean first = true;
    for (HSession o : sessions) {
      if (first) first = false; else sbuf.append(","); 
      sbuf.append(System.identityHashCode(o));
    }
    sbuf.append("]");
    return sbuf.toString();
  }
}
