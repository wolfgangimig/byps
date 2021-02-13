package byps.http.client.jcnn11;

import java.io.InputStream;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.ProxySelector;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.http.HConstants;
import byps.http.client.HHttpClient;
import byps.http.client.HHttpRequest;

public class HttpClient11 implements HHttpClient {
  private static final Logger log = LoggerFactory.getLogger(HttpClient11.class);
  private final CookieManager cookieManager;
  private final ProxySelector proxySelector;
  private final int connectTimeoutSeconds;
  private final HttpClient client;
  private final ThreadPoolExecutor tpool = (ThreadPoolExecutor)Executors.newCachedThreadPool();
  
  public static final int MAX_RETRIES = 1;
  
  public HttpClient11(String url, int timeoutSeconds) {
    cookieManager = new CookieManager(); 
    cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
    
    proxySelector = ProxySelector.getDefault();
    connectTimeoutSeconds = timeoutSeconds;
    
    client = createHttpClient();
  }
  
  private HttpClient createHttpClient() {
    if (log.isDebugEnabled()) log.debug("createHttpClient, connectTimeout={}s", connectTimeoutSeconds);
    return HttpClient.newBuilder().version(Version.HTTP_1_1).followRedirects(Redirect.NORMAL).proxy(proxySelector)
        .executor(tpool)
        .connectTimeout(Duration.ofSeconds(connectTimeoutSeconds)).cookieHandler(cookieManager).build();
  }

  @Override
  public void done() {
    tpool.shutdownNow();
  }

  @Override
  public HHttpRequest get(long trackingId, String url, BAsyncResult<ByteBuffer> asyncResult) {
    return new HttpGetRequest11(client, trackingId, url, asyncResult, cookieManager, proxySelector);
  }

  @Override
  public HHttpRequest getStream(long trackingId, String url, BAsyncResult<BContentStream> asyncResult) {
    return new HttpGetStreamRequest11(client, trackingId, url, asyncResult, cookieManager, proxySelector);
  }

  @Override
  public HHttpRequest post(long trackingId, String url, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult) {
    return new HttpPostRequest11(client, trackingId, url, buf, asyncResult, cookieManager, proxySelector);
  }

  @Override
  public HHttpRequest putStream(long trackingId, String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult) {
    return new HttpPutStreamRequest11(client, trackingId, url, stream, asyncResult, cookieManager, proxySelector);
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
