package byps.http.client.jcnn;

import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BBufferJson;
import byps.BException;
import byps.BExceptionC;
import byps.BWire;
import byps.http.client.HHttpRequest;
import byps.io.BInputStreamByteCount;

public abstract class JcnnRequest implements HHttpRequest {

  protected AtomicReference<HttpURLConnection> conn = new AtomicReference<HttpURLConnection>();
  protected String url;
  protected BException ex;
  protected final CookieManager cookieManager;
  protected int connectTimeoutSeconds;
  protected int sendRecvTimeoutSeconds;
  protected AtomicBoolean cancelled = new AtomicBoolean();
  protected Map<String,String> requestProperties = new HashMap<String,String>();
  protected final long trackingId;
  private static Logger log = LoggerFactory.getLogger(JcnnRequest.class);
  
  /**
   * HTTP status code. 
   */
  private int responseCode = -1;

  protected JcnnRequest(long trackingId, String url, CookieManager cookieManager) {
    this.trackingId = trackingId;
    this.url = url;
    this.cookieManager = cookieManager;
  }

  protected HttpURLConnection createConnection(String destUrl) throws IOException {
    if (cancelled.get()) throw new BException(BExceptionC.CANCELLED, "Request cancelled");
    HttpURLConnection c = (HttpURLConnection) new URL(destUrl).openConnection();
    conn.set(c);
    c.setConnectTimeout(connectTimeoutSeconds * 1000);
    c.setReadTimeout(sendRecvTimeoutSeconds * 1000); 
    
    if (requestProperties != null) {
      for (Map.Entry<String, String> prop : requestProperties.entrySet()) {
        c.setRequestProperty(prop.getKey(), prop.getValue());
      }
    }
    
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
    if (log.isDebugEnabled()) log.debug("applySession(");
    JcnnRequest req = (JcnnRequest)req1;
    HttpURLConnection c = req.conn.get();
    
    // BYPS-72: explicitly send cookie header only for non-default cookie handler.
    
    if (c != null && cookieManager != null) {
      
      List<HttpCookie> httpCookies;
      synchronized(cookieManager) {
        CookieStore cookies = cookieManager.getCookieStore();
        
        // BYPS-2: copy cookies to circumvent ConcurrentModificationException
        httpCookies = new ArrayList<>(cookies.getCookies());
      }

      if (!httpCookies.isEmpty()) {
        String cookiesAsString = httpCookies.stream().map(HttpCookie::toString).distinct().collect(Collectors.joining(";"));
        c.setRequestProperty("Cookie", cookiesAsString);
        if (log.isDebugEnabled()) log.debug("request cookies={}", cookiesAsString);
      }
      
    }
    if (log.isDebugEnabled()) log.debug(")applySession");
  }

  public void saveSession(HHttpRequest req1) {
    JcnnRequest req = (JcnnRequest)req1;
    HttpURLConnection c = req.conn.get();
    
    // BYPS-72: save cookies only for non-default cookie handler.

    if (c != null && cookieManager != null) {
      try {
        URI uri = new URI(req.url);
        
        // CookieManager.put writes a SEVERE log output if server sends an empty cookie.
        // To circumvent this log entry, skip all empty cookies.
        Map<String, List<String>> responseCookies = extractCookieHeaders(c);
        if (log.isDebugEnabled()) log.debug("responseCookies={}", responseCookies);

        if (!responseCookies.isEmpty()) {
          synchronized(cookieManager) {
            cookieManager.put(uri, responseCookies);
          }
        }
      }
      catch (Exception e) {
        req.ex = new BException(BExceptionC.IOERROR, "Cannot set session cookie.", e);
      }
    }
  }

  private Map<String, List<String>> extractCookieHeaders(HttpURLConnection c) {
    Map<String, List<String>> responseCookies = Collections.emptyMap();
    Map<String, List<String>> responseHeaders = c.getHeaderFields();
    if (responseHeaders != null) {
      responseCookies = new HashMap<String, List<String>>(responseHeaders.size());
      for (String headerKey : responseHeaders.keySet()) {
        if (headerKey == null) continue;
        if (headerKey.equalsIgnoreCase("Set-Cookie2") || headerKey.equalsIgnoreCase("Set-Cookie")) {
          List<String> cookies = new ArrayList<String>();
          for (String headerValue : responseHeaders.get(headerKey)) {
            if (log.isDebugEnabled()) log.debug("response cookie=" + headerValue);
            if (!headerValue.isEmpty()) {
              cookies.add(headerValue);
            }
          }
          if (!cookies.isEmpty()) {
            responseCookies.put(headerKey, cookies);
          }
        }
      }
    }
    return responseCookies;
  }
  
  @Override
  public void setRequestProperty(String name, String value) {
    if (requestProperties == null) requestProperties = new HashMap<String,String>();
    requestProperties.put(name, value);
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
      closeConnectionAfterRequest = Boolean.parseBoolean(s);
    }
    return closeConnectionAfterRequest.booleanValue();
  }
  
  private Boolean closeConnectionAfterRequest;
  
  
  protected ByteBuffer readResponse(HttpURLConnection c) throws IOException {
    ByteBuffer obuf = null;
    InputStream is = c.getInputStream();
    if (is != null) {
      
      BInputStreamByteCount isByteCount = new BInputStreamByteCount(is);
      
      String enc = c.getHeaderField("Content-Encoding");
      boolean gzip = enc != null && enc.equals("gzip");
  
      if (log.isDebugEnabled()) log.debug("read stream");
      obuf = BWire.bufferFromStream(isByteCount, gzip);
      if (log.isDebugEnabled()) {
        log.debug("received #bytes={}, msg-size={}", isByteCount.getByteCount(), obuf.remaining());
        obuf.mark();
        BBufferJson bbuf = new BBufferJson(obuf);
        log.debug(bbuf.toDetailString());
        obuf.reset();
      }
    }
    return obuf;
  }
  
  protected void cleanupInputStream(HttpURLConnection conn) {
    try {
      InputStream respStrm = conn.getInputStream();
      if (respStrm != null) {
        ByteBuffer bbuf = BWire.bufferFromStream(respStrm, false);
        if (log.isDebugEnabled()) log.debug("Put stream succeeded " + new String(bbuf.array(), bbuf.position(), bbuf.remaining(), StandardCharsets.UTF_8));
      }
    }
    catch (Exception e) {
      // Ignore exception to continue with cleanup.
    }
  }

  protected void cleanupErrorStream(HttpURLConnection conn) {
    try {
      InputStream errStrm = conn.getErrorStream();
      if (errStrm != null) {
        ByteBuffer bbuf = BWire.bufferFromStream(errStrm, false);
        if (log.isInfoEnabled()) log.info("Put stream failed " + new String(bbuf.array(), bbuf.position(), bbuf.remaining(), StandardCharsets.UTF_8));
      }
    }
    catch (Exception e) {
      // Ignore exception to continue with cleanup.
    }
  }
}
