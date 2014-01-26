package byps.http.client.jcnn;

import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URI;

import byps.BException;
import byps.BExceptionC;
import byps.http.client.HHttpRequest;
import byps.http.client.HHttpSessionManager;

public class JcnnSessionManager implements HHttpSessionManager {
  
  private CookieManager cookieManager;
  
  public JcnnSessionManager(CookieManager cookieManager) {
    if (cookieManager == null) {
      cookieManager = new CookieManager(); 
      cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
    }
    this.cookieManager = cookieManager;
  }

  public CookieManager getCookieManager() {
    return cookieManager;
  }

  public void setCookieManager(CookieManager cookieManager) {
    this.cookieManager = cookieManager;
  }

  @Override
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

  @Override
  public void saveSession(HHttpRequest req1) {
    JcnnRequest req = (JcnnRequest)req1;
    HttpURLConnection c = req.conn.get();
    if (c != null) {
      try {
        URI uri = new URI(req.url);
        cookieManager.put(uri, c.getHeaderFields());
      }
      catch (Exception e) {
        req.ex = new BException(BExceptionC.IOERROR, "Cannot set session cookie.", e);
      }
    }
  }
  
  
}
