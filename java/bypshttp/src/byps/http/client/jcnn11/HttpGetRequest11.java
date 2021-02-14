package byps.http.client.jcnn11;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.ByteBuffer;

import byps.BAsyncResult;

public class HttpGetRequest11 extends HttpRequest11 {

  private final BAsyncResult<ByteBuffer> asyncResult;

  protected HttpGetRequest11(HttpClient client, long trackingId, String url, BAsyncResult<ByteBuffer> asyncResult) {
    super(client, trackingId, url);
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
    builder.method("GET", BodyPublishers.noBody());
    return builder.build();
  }

}
