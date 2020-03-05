package byps.http.client.asf;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.nio.ByteBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;

import byps.BAsyncResult;
import byps.BException;
import byps.BExceptionC;
import byps.BMessageHeader;
import byps.BWire;
import byps.io.ByteArrayOutputStream;

public class AsfPost extends AsfRequest {

  private static Logger log = LoggerFactory.getLogger(AsfPost.class);
  private ByteBuffer buf;
  private final BAsyncResult<ByteBuffer> asyncResult;
  
  protected AsfPost(long trackingId, String url, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult, CloseableHttpClient httpClient, HttpClientContext context) {
    super(trackingId, url, httpClient, context);
    this.buf = buf;
    this.asyncResult = asyncResult;
  }

  @Override
  public void run() {
    MDC.put("NDC", "asfpost-" + trackingId);
    request = new HttpPost(url);
    applyTimeout();
    applyRequestProperties();
   
    CloseableHttpResponse response = null; 
    ByteBuffer returnBuffer = null;
    BException returnException = null;
    int statusCode = BExceptionC.CONNECTION_TO_SERVER_FAILED;
    final boolean isJson = BMessageHeader.detectProtocol(buf) == BMessageHeader.MAGIC_JSON;
    final String contentType = isJson ? "application/json;charset=UTF-8" : "application/byps";
    
    try {

      request.setHeader("Accept", "application/json, application/byps");
      request.setHeader("Accept-Encoding", "gzip");
      request.setHeader("Content-Type", contentType);
      if (isJson) {
        request.setHeader("Content-Encoding", "gzip");
      }
      
      byte[] content = buf.array();
      if (isJson || buf.position() != 0) {
        buf.mark();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        BWire.bufferToStream(buf, isJson, bos);
        content = bos.toByteArray();
        buf.reset();
      }
      
      ((HttpPost)request).setEntity(new ByteArrayEntity(content));
      
      response = httpClient.execute(request, context);

      statusCode = response.getStatusLine().getStatusCode();
      if (statusCode != HttpURLConnection.HTTP_OK) {
        returnException = new BException(statusCode, "Send message failed.");
      }

      HttpEntity entity = response.getEntity();
      returnBuffer = readEntity(entity);
      
    }
    catch (SocketException e) {
      if (log.isDebugEnabled()) log.debug("received exception=", e);
      returnException = new BException(BExceptionC.CONNECTION_TO_SERVER_FAILED, "Socket error", e);
    }
    catch (Throwable e) {
      if (log.isDebugEnabled()) log.debug("received exception=", e);
      returnException = new BException(statusCode, "Send message failed", e);
    }
    finally {
      
      if (response != null) {
        try {
          response.close();
        }
        catch (IOException e) {
        }
      }
      
      done();
      buf = null; // Speicher freigeben
      
      asyncResult.setAsyncResult(returnBuffer, returnException);
      
      MDC.remove("NDC");
    }

  }

  
}
