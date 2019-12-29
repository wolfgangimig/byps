package byps.http.client.asf;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.log4j.NDC;

import byps.BAsyncResult;
import byps.BException;
import byps.BExceptionC;
import byps.http.client.HHttpPutStreamHelper;

public class AsfPutStream extends AsfRequest implements HHttpPutStreamHelper.PutBytes {
  
  private static Log log = LogFactory.getLog(AsfPutStream.class);
  private final InputStream stream;
  private final BAsyncResult<ByteBuffer> asyncResult;

  /**
   * Send stream as POST message.
   */
  private static boolean sendAsPost = false;
  
  static {
    String s = System.getProperty("byps.http.putStreamAsPost", "");
    if (s != null && !s.isEmpty()) sendAsPost = Boolean.parseBoolean(s);
  }

  protected AsfPutStream(long trackingId, String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult, CloseableHttpClient httpClient, HttpClientContext context) {
    super(trackingId, url, httpClient, context);
    this.stream = stream;
    this.asyncResult = asyncResult;
  }

  @Override
  public void run() {
    NDC.push("asfput-" + trackingId);
    try {
      HHttpPutStreamHelper helper = new HHttpPutStreamHelper(this, url, stream, asyncResult);
      helper.run();
    }
    finally {
      done();
      NDC.pop();
    }
  }
  
  private void put(CloseableHttpClient client, String baseUrl) {
    String url = baseUrl;
    HttpPut put = new HttpPut(url);
    byte[] bytes = new byte[10*1000*1000];
    put.setEntity(new ByteArrayEntity(bytes));
    try (CloseableHttpResponse response = client.execute(put)) {
      int responseStatus = response.getStatusLine().getStatusCode();
      readEntity(response.getEntity());
      if (responseStatus != 200) {
        log.info("put: url=" + url + ", response.status=" + responseStatus);
      }
      asyncResult.setAsyncResult(ByteBuffer.allocate(0), null);
    }
    catch (Exception e) {
      log.error("put: url=" + url + ", response.exception=" + e);
      asyncResult.setAsyncResult(ByteBuffer.allocate(0), e);
    }
  }

  private int putBytes_off(String url, byps.io.ByteArrayInputStream sendBuffer, String contentType, String contentDisposition, boolean lastRetry) throws BException {
    int responseStatus = 0;
    HttpPut put = new HttpPut(url);
    byte[] bytes = new byte[10*1000*1000];
    put.setEntity(new ByteArrayEntity(bytes));
    try (CloseableHttpResponse response = httpClient.execute(put)) {
      responseStatus = response.getStatusLine().getStatusCode();
      readEntity(response.getEntity());
      if (responseStatus != 200) {
        log.info("put: url=" + url + ", response.status=" + responseStatus);
      }
      asyncResult.setAsyncResult(ByteBuffer.allocate(0), null);
    }
    catch (Exception e) {
      log.error("put: url=" + url + ", response.exception=" + e);
      asyncResult.setAsyncResult(ByteBuffer.allocate(0), e);
    }
    return responseStatus;
  }


  @Override
  public int putBytes(String url, byps.io.ByteArrayInputStream sendBuffer, String contentType, String contentDisposition, boolean lastRetry) throws BException {
   
    int statusCode = 0;
    
    if (isCancelled()) {
      throw new BException(BExceptionC.CANCELLED, "");
    }
    
    request = sendAsPost ? new HttpPost(url) : new HttpPut(url);
    request.setHeader("Content-Type", contentType);
    
    if (contentDisposition != null && contentDisposition.length() != 0) {
      request.setHeader("Content-Disposition", contentDisposition);
    }
    
    applyTimeout();
    applyRequestProperties();
    
    ByteBuffer bbuf = sendBuffer.getBuffer();
    byte[] content = bbuf.array();
    int offset = bbuf.position();
    int length = bbuf.remaining();
    ((HttpEntityEnclosingRequestBase)request).setEntity(new ByteArrayEntity(content, offset, length));

    try (CloseableHttpResponse response = httpClient.execute(request)) {
      
      request = null;
      
      // Check status code.
      statusCode = response.getStatusLine().getStatusCode();
      if (statusCode != HttpURLConnection.HTTP_OK) {
        throw new BException(statusCode, "Put stream failed.");
      }
      
      HttpEntity entity = response.getEntity();
      readEntity(entity);
      
    }
    catch (SocketException e) {
      if (log.isDebugEnabled()) log.debug("received exception=" + e);
      if (lastRetry) {
        throw new BException(BExceptionC.CONNECTION_TO_SERVER_FAILED, "Socket error.", e);
      }
    }
    catch (SocketTimeoutException e) {
      if (log.isDebugEnabled()) log.debug("received exception=" + e);
      throw new BException(BExceptionC.TIMEOUT, "Socket timeout.", e);
    }
    catch (IOException e) {
      throw new BException(statusCode, "Put stream failed.", e);
    }
    
    return statusCode;
  }

}
