package byps.http.client.jcnn11;

import java.net.CookieManager;

public class HttpGetRequest11 extends HttpRequest11 {

  protected HttpGetRequest11(long trackingId, String url, CookieManager cookieManager) {
    super(trackingId, url, cookieManager);
  }

}
