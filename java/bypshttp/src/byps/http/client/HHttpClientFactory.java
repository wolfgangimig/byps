package byps.http.client;

public interface HHttpClientFactory {

  /**
   * Create a HTTP client object.
   * 
   * @param url
   *          URL, only server and port is required.
   * @param timeoutSeconds Connection timeout seconds.
   * @return
   */
  HHttpClient createHttpClient(String url, int timeoutSeconds);

}
