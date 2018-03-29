package byps.stdio.client;

import java.nio.ByteBuffer;

import byps.BAsyncResult;
import byps.BException;
import byps.BHttpRequest;
import byps.stdio.common.StdioChannel;

public class StdGet extends StdRequest {
  
  private final int method;
  private StdioClient stdioClient;
  private BAsyncResult<ByteBuffer> asyncResult;

  public StdGet(StdioClient stdioClient, String url, BAsyncResult<ByteBuffer> asyncResult) {
    this(stdioClient, url, StdioChannel.HTTP_GET, asyncResult);
  }

  protected StdGet(StdioClient stdioClient, String url, int method, BAsyncResult<ByteBuffer> asyncResult) {
    super(url, stdioClient.transport);
    this.method = method;
    this.stdioClient = stdioClient;
    this.asyncResult = asyncResult;
  }

  @Override
  public void run() {
    try {
      BHttpRequest request = makeHttpRequest();
      ByteBuffer msg = serializeHttpRequest(transport, request);
      
      BAsyncResult<ByteBuffer> asyncResponse = new BAsyncResult<ByteBuffer>() {
        @Override
        public void setAsyncResult(ByteBuffer bbuf, Throwable exception) {
          ByteBuffer response = null;
          if (exception == null) {
            try {
              BHttpRequest httpResponse = deserializeHttpRequest(transport, bbuf);
              response = httpResponse.getBody();
            } catch (BException e) {
              exception = e;
            }
          }
          asyncResult.setAsyncResult(response, exception);
        }
      };
      
      stdioClient.send(method, msg, asyncResponse);
    }
    catch (Exception e) {
      asyncResult.setAsyncResult(null, e);
    }
  }

  
}
