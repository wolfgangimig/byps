package byps.http.client.jcnn;

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
import byps.BMessageHeader;
import byps.BWire;
import byps.BWire.OutputStreamByteCount;

/**
 * This class sends a ByteBuffer in a POST request with content type multipart/form-data.
 * BYPS-83: Solve Azure file upload problem with large POST request.
 */
public class JcnnPostAsMultipartFormdata extends JcnnRequest {

  private static Logger log = LoggerFactory.getLogger(JcnnPostAsMultipartFormdata.class);
  private final BAsyncResult<ByteBuffer> asyncResult;
  private ByteBuffer buf;
  
  protected JcnnPostAsMultipartFormdata(long trackingId, String url, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult, CookieManager cookieManager) {
    super(trackingId, url, cookieManager);
    this.buf = buf;
    this.asyncResult = asyncResult;
  }

  @Override
  public void run() {
    MDC.put("NDC", "jcnnpost-" + trackingId);
    HttpURLConnection conn = null;
    ByteBuffer returnBuffer = null;
    BException returnException = null;
    int statusCode = BExceptionC.CONNECTION_TO_SERVER_FAILED;
    boolean isJson = BMessageHeader.detectProtocol(buf) == BMessageHeader.MAGIC_JSON;
    final String contentType = isJson ? "application/json;charset=UTF-8" : "application/byps";
    int retry = 0; 
    
    do {
      try {
        conn = createConnection(url);
        
        // Tell the client application that we accept BYPS formats.
        conn.setRequestProperty("Accept", "application/json, application/byps");
        conn.setRequestProperty("Accept-Encoding", "gzip");

        // Provide header values.
        long contentLength = buf.remaining();
        String contentDisposition = "";
        String contentEncoding = isJson ? "gzip" : "";
        
        // This callback function writes the buffer into the POST request stream.
        PostMultipartFormdata.WriteFunction writeFnct = os-> {
          if (log.isDebugEnabled()) log.debug("write to output stream");
          OutputStreamByteCount osbc = new OutputStreamByteCount(os);
          BWire.bufferToStream(buf, isJson, osbc);
          if (log.isDebugEnabled()) log.debug("written #bytes=" + osbc.getContentLength() + ", wait for response");
        };

        // Send the POST request as multipart/form-data.
        PostMultipartFormdata.send(conn, contentLength, contentType, contentDisposition, contentEncoding, writeFnct);
         
        statusCode = getResponseCode(conn);
        if (statusCode != HttpURLConnection.HTTP_OK) {
          returnException = new BException(statusCode, "Send message failed.");
          cleanupInputStream(conn);
        }
        else {
          buf = null; // Speicher freigeben
          saveSession(this);
          returnBuffer = readResponse(conn);
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
        cleanupErrorStream(conn);
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
