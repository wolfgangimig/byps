package byps.http.client.jcnn11;

import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.nio.ByteBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import byps.BAsyncResult;
import byps.BException;
import byps.BExceptionC;
import byps.http.client.HHttpPutStreamHelper;
import byps.io.ByteArrayInputStream;

public class HttpPutStreamRequest11 extends HttpRequest11 implements HHttpPutStreamHelper.PutBytes {
  
  private final InputStream stream;
  private final BAsyncResult<ByteBuffer> asyncResult;
  private static final Logger log = LoggerFactory.getLogger(HttpPutStreamRequest11.class);

  protected HttpPutStreamRequest11(HttpClient client, long trackingId, String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult, CookieManager cookieManager, ProxySelector proxySelector) {
    super(client, trackingId, url, cookieManager, proxySelector);
    this.stream = stream;
    this.asyncResult = asyncResult;
  }

  @Override
  public void run() {
    MDC.put("NDC", "jcnn11putstream-" + trackingId);
    try {
      HHttpPutStreamHelper helper = new HHttpPutStreamHelper(this, url, stream, asyncResult);
      helper.run();
    }
    finally {
      MDC.remove("NDC");
    }
  }
  
  protected HttpRequest createRequest(String urlPart, ByteArrayInputStream sendBuffer, String contentType, String contentDisposition) {
    HttpRequest.Builder builder = createRequestBuilderForUri(URI.create(urlPart));
    ByteBuffer bbuf = sendBuffer.getBuffer();
    builder.method("PUT", BodyPublishers.ofByteArray(bbuf.array(), bbuf.position(), bbuf.remaining()));
    builder.header("Content-Type", contentType);
    builder.header("Content-Disposition", contentDisposition);
    return builder.build();
  }
  
  @Override
  public int putBytes(String urlPart, ByteArrayInputStream sendBuffer, String contentType, String contentDisposition,
      boolean lastRetry) throws BException {
    
    HttpRequest request = createRequest(urlPart, sendBuffer, contentType, contentDisposition);
    int statusCode = BExceptionC.CONNECTION_TO_SERVER_FAILED;
    
    try {
      boolean cancelled = isCancelled();
      if (log.isDebugEnabled()) log.debug("cancelled={}", cancelled);
      if (cancelled) {
        throw new BException(BExceptionC.CANCELLED, "");
      }

      HttpResponse<byte[]> response = client.send(request, buildBodyHandlerBytes());
      
      statusCode = response.statusCode();
      if (statusCode != HttpURLConnection.HTTP_OK) {
        throw new BException(statusCode, "Put stream failed.");
      }

    }
    catch (IOException e) {
      throw toBException(statusCode, e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new BException(BExceptionC.CANCELLED, "Put stream interrupted.", e);
    }

    return statusCode;
  }

}
