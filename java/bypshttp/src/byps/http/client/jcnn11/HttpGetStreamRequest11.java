package byps.http.client.jcnn11;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.BContentStreamWrapper;
import byps.BException;

public class HttpGetStreamRequest11 extends HttpRequest11 {

  private final BAsyncResult<BContentStream> asyncResult;

  protected HttpGetStreamRequest11(HttpClient client, long trackingId, String url,
      BAsyncResult<BContentStream> asyncResult) {
    super(client, trackingId, url);
    this.asyncResult = asyncResult;
  }

  @Override
  public void run() {

    HttpRequest request = createRequest();

    try {
      HttpResponse<InputStream> response = client.send(request, buildBodyHandlerInputStream());
      handleResponse(response);
    } catch (Throwable e) {
      asyncResult.setAsyncResult(null, toBException(0, e));
    }
  }

  private boolean handleResponse(HttpResponse<InputStream> response) {
    BContentStream bstream = null;
    Throwable exception = null;

    int statusCode = response.statusCode();
    if (statusCode != HttpURLConnection.HTTP_OK) {
      exception = new BException(statusCode, "GET stream request failed");
    } else {
      bstream = new BContentStreamWrapper(response.body());
      HttpHeaders headers = response.headers();
      headers.firstValue("Content-Type").ifPresent(bstream::setContentType);
      headers.firstValueAsLong("Content-Length").ifPresent(bstream::setContentLength);
      headers.firstValue("Content-Disposition").ifPresent(bstream::setContentDisposition);
    }

    asyncResult.setAsyncResult(bstream, exception);
    return true;
  }

  protected HttpRequest createRequest() {
    HttpRequest.Builder builder = createRequestBuilder();
    builder.method("GET", BodyPublishers.noBody());
    return builder.build();
  }

}
