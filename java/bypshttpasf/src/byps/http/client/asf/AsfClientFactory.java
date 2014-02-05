package byps.http.client.asf;

import byps.http.client.HHttpClient;
import byps.http.client.HHttpClientFactory;

public class AsfClientFactory implements HHttpClientFactory {
  
  @Override
  public HHttpClient createHttpClient(String url) {
    return new AsfClient(url);
  }

}
