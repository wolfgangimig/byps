package byps.http.client.jcnn;

import java.io.IOException;
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
import byps.BBufferJson;
import byps.BException;
import byps.BExceptionC;
import byps.BMessageHeader;
import byps.BWire;
import byps.BWire.OutputStreamByteCount;

public class JcnnPost extends JcnnRequest {

  private static Logger log = LoggerFactory.getLogger(JcnnPost.class);
  private final BAsyncResult<ByteBuffer> asyncResult;
  private ByteBuffer buf;
  
  protected JcnnPost(long trackingId, String url, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult, CookieManager cookieManager) {
    super(trackingId, url, cookieManager);
    this.buf = buf;
    this.asyncResult = asyncResult;
  }

  @Override
  public void run() {
    MDC.put("NDC", "jcnnpost-" + trackingId);
    HttpURLConnection c = null;
    ByteBuffer returnBuffer = null;
    BException returnException = null;
    int statusCode = BExceptionC.CONNECTION_TO_SERVER_FAILED;
    final boolean isJson = BMessageHeader.detectProtocol(buf) == BMessageHeader.MAGIC_JSON;
    final String contentType = isJson ? "application/json;charset=UTF-8" : "application/byps";
    int retry = 0; 
    
    do {
      try {
        c = createConnection(url);
        
        c.setDoInput(true);
        c.setDoOutput(true);
  
        c.setRequestMethod("POST");
        c.setRequestProperty("Accept", "application/json, application/byps");
        c.setRequestProperty("Accept-Encoding", "gzip");
        c.setRequestProperty("Content-Type", contentType);
        if (isJson) {
          c.setRequestProperty("Content-Encoding", "gzip");
        }

        if (log.isDebugEnabled()) log.debug("write to output stream");
        OutputStreamByteCount osbc = new OutputStreamByteCount(c.getOutputStream());
        BWire.bufferToStream(buf, isJson, osbc);
        if (log.isDebugEnabled()) log.debug("written #bytes=" + osbc.sum + ", wait for response");
        
        statusCode = getResponseCode(c);
  
        if (statusCode != HttpURLConnection.HTTP_OK) {
          returnException = new BException(statusCode, "Send message failed.");
          cleanupInputStream(c);
        }
        else {
          buf = null; // Speicher freigeben
          saveSession(this);
          returnBuffer = readResponse(c);
        }
        
      }
      catch (SocketException e) {
        if (log.isDebugEnabled()) log.debug("received exception=" + e);
        returnException = new BException(BExceptionC.CONNECTION_TO_SERVER_FAILED, "Socket error", e);
      }
      catch (SocketTimeoutException e) {
        if (log.isDebugEnabled()) log.debug("received exception=" + e);
        returnException = new BException(BExceptionC.TIMEOUT, "Socket timeout", e);
      }
      catch (Throwable e) {
        if (log.isDebugEnabled()) log.debug("received exception=" + e);
        returnException = new BException(statusCode, "Send message failed", e);
      }
      finally {
        cleanupErrorStream(c);
        done();
      }

      retry++;
      
    } while(retry < JcnnClient.MAX_RETRIES &&
        buf != null && 
        returnException != null && 
        returnException.code == BExceptionC.CONNECTION_TO_SERVER_FAILED);

    buf = null; // Speicher freigeben

    asyncResult.setAsyncResult(returnBuffer, returnException);
    
    MDC.remove("NDC");
  }
  
}
