package byps.http.client.jcnn;

import java.io.InputStream;
import java.nio.ByteBuffer;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.http.client.HHttpClient;
import byps.http.client.HHttpRequest;
import byps.http.client.HHttpSessionManager;

public class JcnnClient implements HHttpClient {
  
  private HHttpSessionManager sessionManager;
  
  public JcnnClient(String url, HHttpSessionManager sessManager) {
    this.sessionManager = sessManager;
  }

  @Override
  public void done() {
  }

  @Override
  public HHttpRequest get(String url, BAsyncResult<ByteBuffer> asyncResult) {
    return new JcnnGet(url, asyncResult, sessionManager);
  }

  @Override
  public HHttpRequest getStream(String url, BAsyncResult<BContentStream> asyncResult) {
    return new JcnnGetStream(url, asyncResult, sessionManager);
  }

  @Override
  public HHttpRequest post(String url, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult) {
    return new JcnnPost(url, buf, asyncResult, sessionManager);
  }

  @Override
  public HHttpRequest putStream(String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult) {
    return new JcnnPutStream(url, stream, asyncResult, sessionManager);
  }

  @Override
  public HHttpSessionManager getSessionManager() {
    return sessionManager;
  }

}
