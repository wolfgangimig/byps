package byps.http.client.jcnn;

import java.io.InputStream;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.nio.ByteBuffer;
import java.util.Optional;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.http.HConstants;
import byps.http.client.HHttpClient;
import byps.http.client.HHttpRequest;

public class JcnnClient implements HHttpClient {
  
  private final CookieManager cookieManager;
  
  public final static int MAX_RETRIES = 1;
  
  public JcnnClient(String url) {
    cookieManager = new CookieManager(); 
    cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
  }

  @Override
  public void done() {
  }

  @Override
  public HHttpRequest get(long trackingId, String url, BAsyncResult<ByteBuffer> asyncResult) {
    return new JcnnGet(trackingId, url, asyncResult, cookieManager);
  }

  @Override
  public HHttpRequest getStream(long trackingId, String url, BAsyncResult<BContentStream> asyncResult) {
    return new JcnnGetStream(trackingId, url, asyncResult, cookieManager);
  }

  @Override
  public HHttpRequest post(long trackingId, String url, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult) {
    return new JcnnPost(trackingId, url, buf, asyncResult, cookieManager);
  }

  @Override
  public HHttpRequest putStream(long trackingId, String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult) {
    return new JcnnPutStream(trackingId, url, stream, asyncResult, cookieManager);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getHttpSession() {
    Optional<HttpCookie> opt = internalFindCookie(HConstants.HTTP_COOKIE_JSESSIONID);
    return opt.map(HttpCookie::getValue).orElse("");
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public HttpCookie getHttpCookie(String name) {
    Optional<HttpCookie> opt = internalFindCookie(name);
    return opt.orElse(null);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setHttpCookie(HttpCookie cookie) {
    if (cookie != null) {
      Optional<HttpCookie> opt = internalFindCookie(cookie.getName());
      opt.ifPresent(c -> cookieManager.getCookieStore().remove(null, c));
      cookieManager.getCookieStore().add(null, cookie);
    }
  }

  /**
   * Find cookie with given name.
   * @param name cookie name
   * @return Optional with requested cookie or empty.
   */
  private Optional<HttpCookie> internalFindCookie(String name) {
    return cookieManager.getCookieStore().getCookies().stream()
      .filter(c -> c.getName().equalsIgnoreCase(name)).findFirst();
  }
  
}
