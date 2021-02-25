package byps.stdio.client;

import byps.http.client.HHttpClient;
import byps.http.client.HHttpClientFactory;

public class StdioClientFactory implements HHttpClientFactory {
  
  @Override
  public HHttpClient createHttpClient(String programPath, int timeoutSeconds) {
    return new StdioClient(programPath);
  }

}
