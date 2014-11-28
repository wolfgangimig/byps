package byps.http;

import java.util.ArrayList;

public class HHttpSessionObject {

  private ArrayList<HSession> sessions = new ArrayList<HSession>();

  public void addSession(HSession s) {
    sessions.add(s);
  }
  
  public void removeSession(HSession s) {
    for (int i = 0; i < sessions.size(); i++) {
      HSession o = sessions.get(i);
      if (o == s) {
        sessions.remove(i);
        break;
      }
    }
  }
  
  public HSession getFirstSessionOrNull() {
    return sessions.size() != 0 ? sessions.get(0) : null;
  }
  
  public boolean isEmpty() {
    return sessions.size() == 0;
  }
}
