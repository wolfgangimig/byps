package byps.http.client.jcnn11;

import java.io.InputStream;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.nio.ByteBuffer;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.http.client.HHttpClient;
import byps.http.client.HHttpRequest;

public class HttpClient11 implements HHttpClient {
  
  private final CookieManager cookieManager;
  
  public final static int MAX_RETRIES = 1;
  
  public HttpClient11(String url) {
    cookieManager = new CookieManager(); 
    cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
  }

  @Override
  public void done() {
    // TODO Auto-generated method stub
    
  }

  @Override
  public HHttpRequest get(long trackingId, String url, BAsyncResult<ByteBuffer> asyncResult) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public HHttpRequest getStream(long trackingId, String url, BAsyncResult<BContentStream> asyncResult) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public HHttpRequest post(long trackingId, String url, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public HHttpRequest putStream(long trackingId, String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getHttpSession() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public HttpCookie getHttpCookie(String name) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setHttpCookie(HttpCookie cookie) {
    // TODO Auto-generated method stub
    
  }

  

}
