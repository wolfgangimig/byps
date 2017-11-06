package byps.http.client.jcnn;

import java.io.IOException;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BException;
import byps.BExceptionC;
import byps.http.client.HHttpRequest;

public abstract class JcnnRequest implements HHttpRequest {

  protected AtomicReference<HttpURLConnection> conn = new AtomicReference<HttpURLConnection>();
  protected String url;
  protected BException ex;
  protected CookieManager cookieManager;
  protected int connectTimeoutSeconds;
  protected int sendRecvTimeoutSeconds;
  protected AtomicBoolean cancelled = new AtomicBoolean();
  private static Log log = LogFactory.getLog(JcnnRequest.class);
  
  /**
   * HTTP status code. 
   */
  private int responseCode = -1;

  protected JcnnRequest(String url, CookieManager cookieManager) {
    this.url = url;
    this.cookieManager = cookieManager;
  }

  protected HttpURLConnection createConnection(String destUrl) throws IOException {
    if (cancelled.get()) throw new BException(BExceptionC.CANCELLED, "Request cancelled");
    HttpURLConnection c = (HttpURLConnection) new URL(destUrl).openConnection();
    conn.set(c);
    c.setConnectTimeout(connectTimeoutSeconds * 1000);
    c.setReadTimeout(connectTimeoutSeconds * 1000);
    applySession(this);
    return c;
  }

  @Override
  public void setTimeouts(int connectTimeoutSeconds, int sendRecvTimeoutSeconds) {
    this.connectTimeoutSeconds = connectTimeoutSeconds;
    this.sendRecvTimeoutSeconds = sendRecvTimeoutSeconds;
  }

  @Override
  public void cancel() {
    if (log.isDebugEnabled()) log.debug("cancel(");
    cancelled.set(true);
    done();
    if (log.isDebugEnabled()) log.debug(")cancel");
  }

  @Override
  public boolean isCancelled() {
    return cancelled.get();
  }

  public void done() {
    if (log.isDebugEnabled()) log.debug("done(" + this);
    HttpURLConnection c = conn.getAndSet(null);
    if (c != null && isCloseConnectionAfterRequest()) {
      if (log.isDebugEnabled()) log.debug("disconnect");
      try {
        c.disconnect();
      }
      catch (Throwable npe) {
      }
      c = null;
    }
    if (log.isDebugEnabled()) log.debug(")done");
  }

  /**
   * Return HTTP status code.
   * Android 4.0 throws an exception in getResponseCode, if code is 401.
   * BYPS does not understand this exception and does not perform a re-authentication.
   * That's why we cannot use getResponseCode in Android 4.0.
   * Android 4.1 does not throw an exception if code is 401.
   * @param c HTTP connection object.
   * @return Response code.
   * @throws IOException
   */
  protected int getResponseCode(HttpURLConnection c) throws IOException {
    if (log.isDebugEnabled()) log.debug("getResponseCode(");
    if (responseCode == -1) {
      try {
        responseCode = c.getResponseCode();
      }
      catch (IOException ex) {
        if (ex.toString().indexOf("authentication challenge is null") < 0) throw ex;
        responseCode = HttpURLConnection.HTTP_UNAUTHORIZED;
      }
    }
    if (log.isDebugEnabled()) log.debug(")getResponseCode=" + responseCode);
    return responseCode;
  }
  
  public void applySession(HHttpRequest req1) {
    JcnnRequest req = (JcnnRequest)req1;
    HttpURLConnection c = req.conn.get();
    if (c != null) {
      CookieStore cookies = cookieManager.getCookieStore();
      for (HttpCookie cookie : cookies.getCookies()) {
        c.setRequestProperty("Cookie", cookie.toString());
      }
    }
  }

  public void saveSession(HHttpRequest req1) {
    JcnnRequest req = (JcnnRequest)req1;
    HttpURLConnection c = req.conn.get();
    if (c != null) {
      try {
        URI uri = new URI(req.url);
        
        // CookieManager.put writes a SEVERE log output if server sends an empty cookie.
        // To circumvent this log entry, skip all empty cookies.
        Map<String, List<String>> responseCookies = extractCookieHeaders(c);
        
        cookieManager.put(uri, responseCookies);
      }
      catch (Exception e) {
        req.ex = new BException(BExceptionC.IOERROR, "Cannot set session cookie.", e);
      }
    }
  }

  private Map<String, List<String>> extractCookieHeaders(HttpURLConnection c) {
    Map<String, List<String>> responseHeaders = c.getHeaderFields();
    Map<String, List<String>> responseCookies = new HashMap<String, List<String>>(responseHeaders.size());
    for (String headerKey : responseHeaders.keySet()) {
      if (headerKey == null) continue;
      if (headerKey.equalsIgnoreCase("Set-Cookie2") || headerKey.equalsIgnoreCase("Set-Cookie")) {
        List<String> cookies = new ArrayList<String>();
        for (String headerValue : responseHeaders.get(headerKey)) {
          if (!headerValue.isEmpty()) {
            cookies.add(headerValue);
          }
        }
        if (!cookies.isEmpty()) {
          responseCookies.put(headerKey, cookies);
        }
      }
    }
    return responseCookies;
  }
  
  /**
   * Soll HttpURLConnection.disconnect zum Abschluss der Anfrage aufgerufen werden.
   * Meinen Untersuchungen nach macht es zumindest unter Windows keinen Unterschied. 
   * Die javadoc zu Android verlangt aber ein disconnect().
   * @return
   */
  private boolean isCloseConnectionAfterRequest() {
    if (closeConnectionAfterRequest == null) {
      String s = System.getProperty("de.elo.ix.closeConnectionAfterRequest", "true");
      closeConnectionAfterRequest = new Boolean(Boolean.parseBoolean(s));
    }
    return closeConnectionAfterRequest.booleanValue();
  }
  
  private Boolean closeConnectionAfterRequest;
  
}
