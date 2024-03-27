package byps.http.client.jcnn;

import java.io.IOException;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.http.HConstants;
import byps.http.HHttpServlet;
import byps.http.client.HHttpClient;
import byps.http.client.HHttpRequest;

public class JcnnClient implements HHttpClient {
  
  private static Logger log = LoggerFactory.getLogger(JcnnClient.class);
  
  /**
   * Cookies are stored by this CookieHandler.
   * This is either the object returned by {@link CookieHandler#getDefault()}. 
   * Or, if there is no default handler set, a {@link CookieManager} is created for {@link #myCookieManager} 
   * and assigned to this member.
   * BYPS-83  
   */
  private final CookieHandler cookieHandler;
  
  /**
   * A {@link CookieManager} created in the constructor, if no default cookie handler is registered.
   * BYPS-83  
   */
  private final CookieManager myCookieManager;

  /**
   * Base URI of the server.
   * This URI is used to get the cookies from the {@link #cookieHandler}.
   * BYPS-83
   * @see #getHttpCookies()
   */
  private final URI uri;
  
  /**
   * This value specifies if POST requests should send data with content type multipart/form-data.
   * It is set as true, if the response header {@link HConstants#HTTP_HEADER_BYPS_MULTIPART} is received.
   * BYPS-85
   * @see JcnnRequest#saveSession(HHttpRequest)
   * @see #isMultipartRequestEnabled()
   */
  private final AtomicBoolean multipartEnabled = new AtomicBoolean();
  
  public final static int MAX_RETRIES = 1;
  
  public JcnnClient(String url) {
    
    // BYPS-72: use registered default CookieManager.
    // JavaFX-WebView registeres a CookieManager which should be used here instead of a custom CookieManager.
    // Otherwise, the cookies will be sent twice in JcnnRequest.

    // BYPS-83: JavaFX-WebView's cookie handler is not of type java.net.CookieManager
    // Thus, the CookieHandler interface has to be used to extract or set cookies.
    
    CookieHandler handler = CookieHandler.getDefault();
    if (handler != null) {
      cookieHandler = handler;
      myCookieManager = null;
    }
    else {
      myCookieManager = new CookieManager(); 
      myCookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
      cookieHandler = myCookieManager;
    }
    
    uri = toUriNoEx(url);
  }
  
  /**
   * Create an URI object for the given URL string.
   * BYPS-83
   * @param url URL string
   * @return URI object
   */
  private URI toUriNoEx(String url) {
    URI uri = null;
    try {
      uri = new URI(url);
    }
    catch (Exception e) {
    }
    return uri;
  }

  @Override
  public void done() {
  }

  @Override
  public HHttpRequest get(long trackingId, String url, BAsyncResult<ByteBuffer> asyncResult) {
    return new JcnnGet(trackingId, url, asyncResult, getMyCookieManagerOrNull(), multipartEnabled);
  }

  @Override
  public HHttpRequest getStream(long trackingId, String url, BAsyncResult<BContentStream> asyncResult) {
    return new JcnnGetStream(trackingId, url, asyncResult, getMyCookieManagerOrNull(), multipartEnabled);
  }

  @Override
  public HHttpRequest post(long trackingId, String url, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult) {
    HHttpRequest request;
    
    // BYPS-83: send buffer as multipart/form-data 
    
    if (isMultipartRequestEnabled()) {
      request = new JcnnPostAsMultipartFormdata(trackingId, url, buf, asyncResult, getMyCookieManagerOrNull(), multipartEnabled);
    } else {
      request = new JcnnPost(trackingId, url, buf, asyncResult, getMyCookieManagerOrNull(), multipartEnabled);
    }
    
    return request;
  }

  @Override
  public HHttpRequest putStream(long trackingId, String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult) {
    HHttpRequest request;
    
    // BYPS-83: send buffer as multipart/form-data
    
    if (isMultipartRequestEnabled()) {
      request = new JcnnPutStreamAsMultipartFormData(trackingId, url, stream, asyncResult, getMyCookieManagerOrNull(), multipartEnabled);
    } else {
      request = new JcnnPutStream(trackingId, url, stream, asyncResult, getMyCookieManagerOrNull(), multipartEnabled);
    }

    return request;
  }
  
  private CookieManager getMyCookieManagerOrNull() {
    return myCookieManager;
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
      setHttpCookies(List.of(cookie));
    }
  }

  /**
   * Find cookie with given name.
   * @param name cookie name
   * @return Optional with requested cookie or empty.
   */
  private Optional<HttpCookie> internalFindCookie(String name) {
    List<HttpCookie> cookies = getHttpCookies();
    return cookies.stream().filter(c -> c.getName().equalsIgnoreCase(name)).findAny();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public List<HttpCookie> getHttpCookies() {
    // Cookie manager of JavaFX Webview e.g. returns:
    // cookieMap.toString() = "{Cookie=[JSESSIONID=9AB879649812D627F3E18E844FA9666C.ELO-PCIMIGELO21-1; BYPSMULTIPART=true; JSESSIONID=]}"

    // BYPS-83: use the CookieHandler interface to get cookies.

    List<HttpCookie> cookies = Collections.emptyList();
    try {
      Map<String, List<String>> cookieMap = cookieHandler.get(uri, Collections.emptyMap());
      
      cookies = cookieMap.values().stream()
          .flatMap(list -> list.stream())
          .map(s -> s.split(";")).flatMap(ss -> Stream.of(ss)).map(String::trim) 
          .flatMap(s -> HttpCookie.parse(s).stream()).collect(Collectors.toList());
      
      if (log.isDebugEnabled()) log.debug("getHttpCookies()={}", cookies);
      
    } catch (IOException e) {
      log.warn("Cannot get cookies for uri={} from cookieHandler={}", uri, cookieHandler, e);
    }
    
    return Collections.unmodifiableList(cookies);
  }
  
  /**
   * {@inheritDoc}
   */
  @Override
  public void setHttpCookies(List<HttpCookie> cookies) {
    
    if (myCookieManager != null) {
      synchronized(myCookieManager) {
        myCookieManager.getCookieStore().removeAll();
      }
    }
    
    // BYPS-83: use the CookieHandler interface to set cookies.
    
    if (cookies != null && !cookies.isEmpty()) {
      try {
        Map<String, List<String>> headers = new HashMap<String, List<String>>();
        for (HttpCookie cookie : cookies) {
          headers.put("Set-Cookie", Arrays.asList(cookie.toString()));
        }
        cookieHandler.put(uri, headers);
      }
      catch (IOException e) {
        log.warn("Cannot set cookies={} for uri={} into cookieHandler={}", cookies, uri, cookieHandler, e);
      }
    }
  }
  
  /**
   * Return true if the server accepts multipart/form-data requests.
   * This function checks whether the header {@link HConstants#HTTP_HEADER_BYPS_MULTIPART} has been received before. 
   * New versions of BYPS servers return this header in a negotiate request, see {@link HHttpServlet}.
   * BYPS-83
   * @return true, if multipart/form-data requests are enabled.
   */
  private boolean isMultipartRequestEnabled() {
    boolean ret = multipartEnabled.get();
    if (log.isDebugEnabled()) log.debug("isMultipartRequestEnabled()={}", ret);
    return ret;
  }
}
