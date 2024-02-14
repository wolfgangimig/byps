package byps.http.client.jcnn;

import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import byps.BAsyncResult;
import byps.BException;
import byps.BExceptionC;

public class JcnnGet extends JcnnRequest {

  private static Logger log = LoggerFactory.getLogger(JcnnGet.class);
  private final BAsyncResult<ByteBuffer> asyncResult;

  protected JcnnGet(long trackingId, String url, BAsyncResult<ByteBuffer> asyncResult, CookieManager cookieManager) {
    super(trackingId, url, cookieManager);
    this.asyncResult = asyncResult;
  }

  @Override
  public void run() {
    MDC.put("NDC", "jcnnget-" + trackingId);
    
    HttpURLConnection c = null;
    InputStream is = null;
    ByteBuffer returnBuffer = null;
    BException returnException = null;
    int statusCode = BExceptionC.CONNECTION_TO_SERVER_FAILED;
    int retry = 0;
    
    do {
      
      try {
        c = createConnection(url);
  
        c.setDoInput(true);
        c.setDoOutput(false);
  
        c.setRequestMethod("GET");
        c.setRequestProperty("Accept", "application/json, application/byps, text/plain, text/html");
        c.setRequestProperty("Accept-Encoding", "gzip");
  
        statusCode = getResponseCode(c);
  
        if (statusCode != HttpURLConnection.HTTP_OK) {
          returnException = new BException(statusCode, "Send message failed.");
          cleanupInputStream(c);
        }
        else {
          saveSession(this);
          returnBuffer = readResponse(c);
        }
      }
      catch (SocketException e) {
        if (log.isInfoEnabled()) log.debug("Received exception=" + e);
        returnException = new BException(BExceptionC.CONNECTION_TO_SERVER_FAILED, "Socket error, url=" + url, e);
      }
      catch (SocketTimeoutException e) {
        if (log.isDebugEnabled()) log.debug("received exception=" + e);
        returnException = new BException(BExceptionC.TIMEOUT, "Socket timeout", e);
      }
      catch (Throwable e) {
        if (log.isInfoEnabled()) log.debug("Received exception=" + e);
        returnException = new BException(statusCode, "Send message failed, url=" + url, e);
      }
      finally {
        cleanupErrorStream(c);
        done();
      }
      
      retry++;

    } while(retry < JcnnClient.MAX_RETRIES && 
        returnException != null && 
        returnException.code == BExceptionC.CONNECTION_TO_SERVER_FAILED);   

    asyncResult.setAsyncResult(returnBuffer, returnException);
    
    MDC.remove("NDC");
  }

}
