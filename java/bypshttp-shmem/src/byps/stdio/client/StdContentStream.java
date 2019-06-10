package byps.stdio.client;

import java.io.IOException;
import java.nio.ByteBuffer;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.BException;
import byps.BHttpRequest;
import byps.BSyncResult;
import byps.stdio.common.StdioChannel;

public class StdContentStream extends BContentStream {

  private StdioClient stdioClient;
  private StdRequest stdRequest;
  private long offset;
  private ByteBuffer bbuf;
  private boolean endOfStream;
    
  public StdContentStream(StdioClient stdioClient, StdRequest request) {
    this.stdioClient = stdioClient;
    this.stdRequest = request;
    this.bbuf = ByteBuffer.allocate(0);
  }
  
  @Override
  public synchronized void close() throws IOException {
    endOfStream = true;
    super.close();
  }
  
  @Override
  public synchronized int read(byte[] b, int off, int len) throws IOException {
    int ret = -1;
    
    while (!bbuf.hasRemaining() && !endOfStream) {
      BSyncResult<ByteBuffer> syncResult = new BSyncResult<ByteBuffer>();
      readNextBytes(offset, syncResult);
      endOfStream = true;
      bbuf = syncResult.getResult(stdRequest.timeoutSeconds * 1000);
      endOfStream = !bbuf.hasRemaining();
    }
    
    if (!endOfStream) {
      ret = Math.min(bbuf.remaining(), len);
      bbuf.get(b, off, ret);
      offset += ret;
    }
    return ret;
  }

  @Override
  public int read() throws IOException {
    byte[] buf = new byte[1];
    int r = read(buf);
    if (r >= 0) {
      r = ((int)buf[0]) & 0xFF;
    }
    return r;
  }
  
  private void readNextBytes(long offset, final BAsyncResult<ByteBuffer> resultBytes) {
    try {
      BHttpRequest httpRequest = stdRequest.makeHttpRequest();
      httpRequest.setOffset(offset);
      ByteBuffer msg = StdRequest.serializeHttpRequest(stdioClient.transport, httpRequest);
      
      BAsyncResult<ByteBuffer> asyncResponse = new BAsyncResult<ByteBuffer>() {
        @Override
        public void setAsyncResult(ByteBuffer bbuf, Throwable exception) {
          ByteBuffer response = null;
          if (exception == null) {
            try {
              BHttpRequest httpResponse = StdRequest.deserializeHttpRequest(stdioClient.transport, bbuf);
              
              String contentTypeStr = httpResponse.getHeaders().get("Content-Type");
              if (contentTypeStr != null && !contentTypeStr.isEmpty()) {
                setContentType(contentTypeStr);
              }
              
              String contentLengthStr = httpResponse.getHeaders().get("Content-Length");
              try {
                long contentLength = (contentLengthStr != null) ? Long.parseLong(contentLengthStr) : -1; 
                setContentLength(contentLength);
              }
              catch (Exception ignored) {}
              
              response = httpResponse.getBody();
              
            } catch (BException e) {
              exception = e;
            }
          }
          resultBytes.setAsyncResult(response, exception);
        }
      };
      
      stdioClient.send(StdioChannel.HTTP_GET_STREAM, msg, asyncResponse);
    }
    catch (Exception e) {
      resultBytes.setAsyncResult(null, e);
    }

  }

}
