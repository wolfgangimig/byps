package byps.stdio.client;

import java.nio.ByteBuffer;

import byps.BAsyncResult;
import byps.BHttpRequest;
import byps.stdio.common.StdioChannel;

public class StdPost extends StdGet {

  private final ByteBuffer buf;
  
  public StdPost(StdioClient stdioClient, String url, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult) {
    super(stdioClient, url, StdioChannel.HTTP_POST, asyncResult);
    this.buf = buf;
  }

  @Override
  protected BHttpRequest makeHttpRequest() {
    BHttpRequest request = super.makeHttpRequest();
    request.setBody(buf);
    return request;
  }
}
