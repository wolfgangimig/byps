package byps.http.client.jcnn11;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.List;
import java.util.Map;
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
  private final MyCookieHandler cookieHandler;
  private final ProxySelector proxySelector;
  private final int connectTimeoutSeconds;
  private final HttpClient client;
  private final ThreadPoolExecutor tpool = (ThreadPoolExecutor)Executors.newCachedThreadPool();
  
  public static final int MAX_RETRIES = 1;
  
  public HttpClient11(String url, int timeoutSeconds) {
    cookieHandler = new MyCookieHandler(URI.create(url)); 
    
    proxySelector = ProxySelector.getDefault();
    connectTimeoutSeconds = timeoutSeconds;
    
    client = createHttpClient();
  }
  
  private HttpClient createHttpClient() {
    if (log.isDebugEnabled()) log.debug("createHttpClient, connectTimeout={}s", connectTimeoutSeconds);
    return HttpClient.newBuilder().version(Version.HTTP_1_1).followRedirects(Redirect.NORMAL).proxy(proxySelector)
        .executor(tpool)
        .connectTimeout(Duration.ofSeconds(connectTimeoutSeconds)).cookieHandler(cookieHandler).build();
  }

  @Override
  public void done() {
    //shutDownHttpClient(client);
    tpool.shutdownNow();
    
  }
  
  private static class MyCookieHandler extends CookieHandler {
    
    CookieManager cookieManager = new CookieManager(); 
    URI uri;
    
    MyCookieHandler(URI uri) {
      cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
      this.uri = uri;
    }

    @Override
    public Map<String, List<String>> get(URI uri, Map<String, List<String>> requestHeaders) throws IOException {
      Map<String, List<String>> value = cookieManager.get(uri, requestHeaders);
      return value;
    }

    @Override
    public void put(URI uri, Map<String, List<String>> responseHeaders) throws IOException {
      cookieManager.put(uri, responseHeaders);
    }
    
    String getHttpSession() {
      Optional<HttpCookie> opt = internalFindCookie(HConstants.HTTP_COOKIE_JSESSIONID);
      return opt.map(HttpCookie::getValue).orElse("");
    }

    HttpCookie getHttpCookie(String name) {
      Optional<HttpCookie> opt = internalFindCookie(name);
      return opt.orElse(null);
    }

    void setHttpCookie(HttpCookie cookie) {
      if (cookie != null) {
        Optional<HttpCookie> opt = internalFindCookie(cookie.getName());
        opt.ifPresent(c -> cookieManager.getCookieStore().remove(null, c));
        cookieManager.getCookieStore().add(uri, cookie);
      }
    }

    /**
     * Find cookie with given name.
     * @param name cookie name
     * @return Optional with requested cookie or empty.
     */
    Optional<HttpCookie> internalFindCookie(String name) {
      return cookieManager.getCookieStore().getCookies().stream()
        .filter(c -> c.getName().equalsIgnoreCase(name)).findFirst();
    }

  }
  
  private static void shutDownHttpClient(HttpClient httpClient)
  {
    
    // causes an Exception on stdout
    
//    https://stackoverflow.com/questions/53919721/close-java-http-client
    // --add-opens java.net.http/jdk.internal.net.http=ALL-UNNAMED
    
      try {
          Field implField = httpClient.getClass().getDeclaredField("impl");
          implField.setAccessible(true);
          Object implObj = implField.get(httpClient);
          Field selmgrField = implObj.getClass().getDeclaredField("selmgr");
          selmgrField.setAccessible(true);
          Object selmgrObj = selmgrField.get(implObj);
          Method shutDownMethod = selmgrObj.getClass().getDeclaredMethod("shutdown");
          shutDownMethod.setAccessible(true);
          shutDownMethod.invoke(selmgrObj);
      }
      catch (Exception e) {
          System.out.println("exception " + e.getMessage());
          e.printStackTrace();
      }

  }


  @Override
  public HHttpRequest get(long trackingId, String url, BAsyncResult<ByteBuffer> asyncResult) {
    return new HttpGetRequest11(client, trackingId, url, asyncResult);
  }

  @Override
  public HHttpRequest getStream(long trackingId, String url, BAsyncResult<BContentStream> asyncResult) {
    return new HttpGetStreamRequest11(client, trackingId, url, asyncResult);
  }

  @Override
  public HHttpRequest post(long trackingId, String url, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult) {
    return new HttpPostRequest11(client, trackingId, url, buf, asyncResult);
  }

  @Override
  public HHttpRequest putStream(long trackingId, String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult) {
    return new HttpPutStreamRequest11(client, trackingId, url, stream, asyncResult);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getHttpSession() {
    return cookieHandler.getHttpSession();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public HttpCookie getHttpCookie(String name) {
    return cookieHandler.getHttpCookie(name);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setHttpCookie(HttpCookie cookie) {
    cookieHandler.setHttpCookie(cookie);
  }

}
