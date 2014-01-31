package byps.http.client.asf;

import java.io.InputStream;
import java.nio.ByteBuffer;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.http.client.HHttpClient;
import byps.http.client.HHttpRequest;
import byps.http.client.HHttpSessionManager;


/**
 * HHttpClient implementation using Apache HttpComponents.
 */
public class AsfClient implements HHttpClient {

  @Override
  public void done() {
  }

  @Override
  public HHttpRequest get(String url, BAsyncResult<ByteBuffer> asyncResult) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public HHttpRequest getStream(String url, BAsyncResult<BContentStream> asyncResult) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public HHttpRequest post(String url, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public HHttpRequest putStream(String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public HHttpSessionManager getSessionManager() {
    // TODO Auto-generated method stub
    return null;
  }

}
