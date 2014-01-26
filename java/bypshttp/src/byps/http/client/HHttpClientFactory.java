package byps.http.client;

public interface HHttpClientFactory {

  /**
   * Create a HTTP client object.
   * 
   * @param url
   *          URL, only server and port is required.
   * @param sessionManager
   *          An object to handle application server sessions.
   * @return
   */
  HHttpClient createHttpClient(String url, HHttpSessionManager sessionManager);

  /**
   * Create session manager object.
   * This object stores the application server session ID.
   * @return session manager object.
   */
  HHttpSessionManager createSessionManager();
}
