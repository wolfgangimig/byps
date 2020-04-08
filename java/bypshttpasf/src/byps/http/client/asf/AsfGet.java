package byps.http.client.asf;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.nio.ByteBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;

import byps.BAsyncResult;
import byps.BBufferJson;
import byps.BException;
import byps.BExceptionC;
import byps.BWire;

public class AsfGet extends AsfRequest {

  private static Logger log = LoggerFactory.getLogger(AsfGet.class);
  private final BAsyncResult<ByteBuffer> asyncResult;
  
  protected AsfGet(long trackingId, String url, BAsyncResult<ByteBuffer> asyncResult, CloseableHttpClient httpClient, HttpClientContext context) {
    super(trackingId, url, httpClient, context);
    this.asyncResult = asyncResult;
  }

  @Override
  public void run() {
    MDC.put("NDC", "asfget-" + trackingId);
    request = new HttpGet(url);
    applyTimeout();
    applyRequestProperties();
    
    CloseableHttpResponse response = null; 
    InputStream is = null;
    ByteBuffer returnBuffer = null;
    Throwable returnException = null;
    int statusCode = BExceptionC.CONNECTION_TO_SERVER_FAILED;
    
    try {

      request.setHeader("Accept", "application/json, application/byps, text/plain, text/html");
      request.setHeader("Accept-Encoding", "gzip");

      response = execute();

      statusCode = response.getStatusLine().getStatusCode();
      if (statusCode != HttpURLConnection.HTTP_OK) {
        returnException = new BException(statusCode, "Send message failed.");
      }

      HttpEntity entity = response.getEntity();
      returnBuffer = readEntity(entity);
    }
    catch (SocketException e) {
      if (log.isDebugEnabled()) log.debug("received exception=" + e);
      returnException = new BException(BExceptionC.CONNECTION_TO_SERVER_FAILED, "Socket error, url=" + url, e);
    }
    catch (Throwable e) {
      if (log.isDebugEnabled()) log.debug("received exception=" + e);
      returnException = new BException(statusCode, "Send message failed, url=" + url, e);
    }
    finally {
      if (response != null) {
        try {
          response.close();
        }
        catch (IOException e) {
        }
      }
      
      asyncResult.setAsyncResult(returnBuffer, returnException);
      done();

      MDC.remove("NDC");
    }

  }


}
