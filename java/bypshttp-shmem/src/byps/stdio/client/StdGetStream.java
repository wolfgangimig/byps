package byps.stdio.client;

import byps.BAsyncResult;
import byps.BContentStream;

public class StdGetStream extends StdRequest {
  
  private StdioClient stdioClient;
  private BAsyncResult<BContentStream> asyncResult;

  public StdGetStream(StdioClient stdioClient, String url, BAsyncResult<BContentStream> asyncResult) {
    super(url, stdioClient.transport);
    this.stdioClient = stdioClient;
    this.asyncResult = asyncResult;
  }

  @Override
  public void run() {
    StdContentStream contentStream = new StdContentStream(stdioClient, this);
    asyncResult.setAsyncResult(contentStream, null);
  }

  
}
