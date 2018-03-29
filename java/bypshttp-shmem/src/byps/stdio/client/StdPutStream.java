package byps.stdio.client;

import java.io.InputStream;
import java.nio.ByteBuffer;

import byps.BAsyncResult;

public class StdPutStream extends StdRequest {

  public StdPutStream(StdioClient stdioClient, String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult) {
    super(url, stdioClient.transport);
  }

  @Override
  public void run() {
    
  }
}
