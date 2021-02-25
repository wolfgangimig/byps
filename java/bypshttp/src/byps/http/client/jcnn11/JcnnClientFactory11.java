package byps.http.client.jcnn11;

import byps.http.client.HHttpClient;
import byps.http.client.HHttpClientFactory;

public class JcnnClientFactory11 implements HHttpClientFactory {
  
  @Override
  public HHttpClient createHttpClient(String url, int timeoutSeconds) {
    return new HttpClient11(url, timeoutSeconds);
  }

}
