package byps.http.client.jcnn11;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.ByteBuffer;

import byps.BAsyncResult;

public class HttpPostRequest11 extends HttpRequest11 {

  private final BAsyncResult<ByteBuffer> asyncResult;
  private final ByteBuffer bbuf;

  protected HttpPostRequest11(HttpClient client, long trackingId, String url, ByteBuffer bbuf, BAsyncResult<ByteBuffer> asyncResult) {
    super(client, trackingId, url);
    this.bbuf = bbuf;
    this.asyncResult = asyncResult;
  }

  @Override
  public void run() {

    HttpRequest request = createRequest();

    try {
      HttpResponse<byte[]> response = client.send(request, buildBodyHandlerBytes());
      handleResponseBytes(response, asyncResult);
    }
    catch (Throwable e) {
      asyncResult.setAsyncResult(null, toBException(0, e));
    }
  }

  protected HttpRequest createRequest() {
    HttpRequest.Builder builder = createRequestBuilder();
    builder.method("POST", BodyPublishers.ofByteArray(bbuf.array()));
    return builder.build();
  }

}
