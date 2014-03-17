package byps.http.client.asf;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.http.client.HHttpClient;
import byps.http.client.HHttpRequest;

/**
 * HHttpClient implementation using Apache HTTP Components.
 * 
 */
public class AsfClient implements HHttpClient {

  private volatile CloseableHttpClient httpclient;

  public AsfClient(String url) {

    httpclient = internalCreateHttpClient();

    // Braucht unter Notes sehr lang für Aufrufe!
    // httpclient = HttpClients.createSystem();

  }

  private static CloseableHttpClient internalCreateHttpClient() {

    String maxConnStr = System.getProperty("http.maxConnections");
    int maxConnections = maxConnStr != null && maxConnStr.length() != 0 ? Integer.parseInt(maxConnStr) : 100;

    PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
    cm.setMaxTotal(maxConnections);
    cm.setDefaultMaxPerRoute(maxConnections);

    CloseableHttpClient httpclient = HttpClients.custom()
            .setConnectionManager(cm)
            .build();
    
    return httpclient;
    
    //return HttpClients.createSystem();
  }

  @Override
  public void clearHttpSession() {
    done();
    httpclient = internalCreateHttpClient();
  }

  @Override
  public void done() {
    try {
      httpclient.close();
    }
    catch (IOException e) {
    }
  }

  @Override
  public HHttpRequest get(String url, BAsyncResult<ByteBuffer> asyncResult) {
    return new AsfGet(url, asyncResult, httpclient);
  }

  @Override
  public HHttpRequest getStream(String url,
      BAsyncResult<BContentStream> asyncResult) {
    return new AsfGetStream(url, asyncResult, httpclient);
  }

  @Override
  public HHttpRequest post(String url, ByteBuffer buf,
      BAsyncResult<ByteBuffer> asyncResult) {
    return new AsfPost(url, buf, asyncResult, httpclient);
  }

  @Override
  public HHttpRequest putStream(String url, InputStream stream,
      BAsyncResult<ByteBuffer> asyncResult) {
    return new AsfPutStream(url, stream, asyncResult, httpclient);
  }

}
