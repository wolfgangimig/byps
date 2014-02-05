package byps.http.client.asf;

import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.nio.ByteBuffer;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.http.client.HHttpClient;
import byps.http.client.HHttpRequest;

public class AsfClient implements HHttpClient {
  
  private CloseableHttpClient httpclient;
  
  public AsfClient(String url) {
    httpclient = HttpClients.createDefault();
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
  public HHttpRequest getStream(String url, BAsyncResult<BContentStream> asyncResult) {
    return new AsfGetStream(url, asyncResult, httpclient);
  }

  @Override
  public HHttpRequest post(String url, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult) {
    return new AsfPost(url, buf, asyncResult, httpclient);
  }

  @Override
  public HHttpRequest putStream(String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult) {
    return new AsfPutStream(url, stream, asyncResult, httpclient);
  }

}
