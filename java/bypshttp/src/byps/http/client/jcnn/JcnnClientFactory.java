package byps.http.client.jcnn;

import byps.http.client.HHttpClient;
import byps.http.client.HHttpClientFactory;

public class JcnnClientFactory implements HHttpClientFactory {
  
  @Override
  public HHttpClient createHttpClient(String url) {
    return new JcnnClient(url, new JcnnSessionManager(null));
  }

}
