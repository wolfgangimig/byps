package byps.http.client.jcnn;

import byps.http.client.HHttpClient;
import byps.http.client.HHttpClientFactory;
import byps.http.client.HHttpSessionManager;

public class JcnnClientFactory implements HHttpClientFactory {
  
  @Override
  public HHttpClient createHttpClient(String url, HHttpSessionManager sessionManager) {
    return new JcnnClient(url, sessionManager);
  }

  @Override
  public HHttpSessionManager createSessionManager() {
    return new JcnnSessionManager(null);
  }

}
