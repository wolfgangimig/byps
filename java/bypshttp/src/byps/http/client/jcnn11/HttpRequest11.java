package byps.http.client.jcnn11;

import java.net.CookieManager;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.http.client.HHttpRequest;

public class HttpRequest11 implements HHttpRequest {
  
  protected String url;
  protected CookieManager cookieManager;
  protected int connectTimeoutSeconds;
  protected int sendRecvTimeoutSeconds;
  protected Map<String,String> requestProperties = new HashMap<String,String>();
  protected final long trackingId;
  private static Logger log = LoggerFactory.getLogger(HttpRequest11.class);
  
  protected HttpRequest11(long trackingId, String url, CookieManager cookieManager) {
    this.trackingId = trackingId;
    this.url = url;
    this.cookieManager = cookieManager;
  }


  @Override
  public void run() {
    // TODO Auto-generated method stub

  }

  @Override
  public void setTimeouts(int connectTimeoutSeconds, int sendRecvTimeoutSeconds) {
    // TODO Auto-generated method stub

  }

  @Override
  public void cancel() {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean isCancelled() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public void setRequestProperty(String name, String value) {
    // TODO Auto-generated method stub

  }

}
