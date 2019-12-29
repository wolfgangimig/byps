package byps.http.client.jcnn;

import java.io.InputStream;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.nio.ByteBuffer;

import byps.BAsyncResult;
import byps.BContentStream;
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

  @Override
  public String getHttpSession() {
    String ret = "";
    for (HttpCookie cookie : cookieManager.getCookieStore().getCookies()) {
      if (cookie.getName().equals("JSESSIONID")) {
        ret = cookie.getValue();
        break;
      }
    }
    return ret;
  }
}
