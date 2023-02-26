package byps.stdio.client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpCookie;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import byps.BAsyncResult;
import byps.BContentStream;
import byps.BTransport;
import byps.http.client.HHttpClient;
import byps.http.client.HHttpRequest;

public class StdioClient extends StdioCommunication implements HHttpClient {

  private HashMap<Integer, BAsyncResult<ByteBuffer>> expectingResults = new HashMap<Integer, BAsyncResult<ByteBuffer>>();
  private int nextMessageId = 0;
  public final BTransport transport;

  public StdioClient(String programPath) {
    super(programPath);
    this.transport = StdioTransport.createTransport();
  }
  
  public StdioClient(InputStream system_in, OutputStream system_out) {
    super(system_in, system_out);
    this.transport = StdioTransport.createTransport();
  }
  
  protected void send(int method, ByteBuffer request, BAsyncResult<ByteBuffer> asyncResult) {
    Exception ex = null;
    try {
      if (stopEvent) {
        throw new IllegalStateException("Disconnected");
      }
      
      int messageId = pushAsyncResult(asyncResult);
      sendChannel.send(method, messageId, request);
      
    }
    catch (Exception e) {
      ex = e;
      asyncResult.setAsyncResult(null, ex);
    }
  }
  
  @Override
  public void done() {
    super.done();
  }
  
  @Override
  public HHttpRequest get(long trackingId, String url, BAsyncResult<ByteBuffer> asyncResult) {
    return new StdGet(this, url, asyncResult);
  }

  @Override
  public HHttpRequest getStream(long trackingId, String url, BAsyncResult<BContentStream> asyncResult) {
    return new StdGetStream(this, url, asyncResult);
  }

  @Override
  public HHttpRequest post(long trackingId, String url, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult) {
    return new StdPost(this, url, buf, asyncResult);
  }

  @Override
  public HHttpRequest putStream(long trackingId, String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult) {
    return new StdPutStream(this, url, stream, asyncResult);  
  }

  @Override
  protected synchronized void handleException(Throwable e) {
    ArrayList<BAsyncResult<ByteBuffer>> results = new ArrayList<BAsyncResult<ByteBuffer>>();
    synchronized(expectingResults) {
      results.addAll(expectingResults.values());
      expectingResults.clear();
    }
    for (BAsyncResult<ByteBuffer> result : results) {
      result.setAsyncResult(null, e);
    }
  }
  
  @Override
  protected void handleReceivedMessage(int messageId, int method, ByteBuffer bbuf) {
    BAsyncResult<ByteBuffer> result = null;
    synchronized(expectingResults) {
      result = expectingResults.remove(messageId);
    }
    if (result != null) { 
      result.setAsyncResult(bbuf, null);
    }
    else {
      handleException(new IllegalStateException("Unknown message " + messageId));
    }
  }

  private int pushAsyncResult(BAsyncResult<ByteBuffer> asyncResult) {
    int messageId = 0;
    synchronized(expectingResults) {
      if (nextMessageId == Integer.MAX_VALUE) nextMessageId = 0;
      messageId = ++nextMessageId;
      expectingResults.put(messageId, asyncResult);
    }
    return messageId;
  }

  /**
   * Unsupported function.
   * @return Throws always an UnsupportedOperationException 
   */
  @Override
  public String getHttpSession() {
    throw new UnsupportedOperationException("HttpClient.getHttpSession is not supported for stdio communication.");
  }

  /**
   * Unsupported function.
   * @param name ignored
   * @return Throws always an UnsupportedOperationException 
   */
  @Override
  public HttpCookie getHttpCookie(String name) {
    throw new UnsupportedOperationException("HttpClient.getHttpSession is not supported for stdio communication.");
  }
  
  /**
   * Unsupported function.
   * Throws always an UnsupportedOperationException.
   * @param cookie ignored
   */
  @Override
  public void setHttpCookie(HttpCookie cookie) {
    throw new UnsupportedOperationException("HttpClient.setHttpSession is not supported for stdio communication.");
  }
  
  @Override
  public List<HttpCookie> getHttpCookies() {
    return Collections.emptyList();
  }
  
  @Override
  public void setHttpCookies(List<HttpCookie> cookies) {
  }
}
