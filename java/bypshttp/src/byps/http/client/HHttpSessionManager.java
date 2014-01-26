package byps.http.client;


public interface HHttpSessionManager {
  
  public void applySession(HHttpRequest req);
  
  public void saveSession(HHttpRequest req);
}
