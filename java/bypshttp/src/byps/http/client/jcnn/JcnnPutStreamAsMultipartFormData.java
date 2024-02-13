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
import byps.BException;
import byps.BExceptionC;
import byps.BWire.OutputStreamByteCount;
import byps.http.client.HHttpPutStreamHelper;

/**
 * Send the contents of an InputStream as a multipart/form-data request.
 * The InputStream contents are split over 10MB separate requests by {@link HHttpPutStreamHelper}. 
 * BYPS-83: Solve Azure file upload problem with large POST request.
 */
public class JcnnPutStreamAsMultipartFormData extends JcnnRequest implements HHttpPutStreamHelper.PutBytes {
  
  private static Logger log = LoggerFactory.getLogger(JcnnPutStreamAsMultipartFormData.class);
  private final InputStream stream;
  private final BAsyncResult<ByteBuffer> asyncResult;
  
  protected JcnnPutStreamAsMultipartFormData(long trackingId, String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult, CookieManager cookieManager) {
    super(trackingId, url, cookieManager);
    this.stream = stream;
    this.asyncResult = asyncResult;
  }

  @Override
  public void run() {
    MDC.put("NDC", "jcnnputmultipart-" + trackingId);
    try {
      
      // Create helper object to send stream in several requests.
      HHttpPutStreamHelper helper = new HHttpPutStreamHelper(this, url, stream, asyncResult);
      helper.run();
    }
    finally {
      done();
      MDC.remove("NDC");
    }
  }
  
  @Override
  public int putBytes(String url, byps.io.ByteArrayInputStream sendBuffer, String contentType, String contentDisposition, boolean lastRetry) throws BException {
    if (log.isDebugEnabled()) log.debug("putBytes(url={}, sendBuffer={}, contentType={}, contentDisposition={}, lastRetry={}");
    HttpURLConnection conn = null;
    int statusCode = BExceptionC.CONNECTION_TO_SERVER_FAILED;
    
    try {
      
      boolean cancelled = isCancelled();
      if (log.isDebugEnabled()) log.debug("cancelled={}", cancelled);
      if (cancelled) {
        throw new BException(BExceptionC.CANCELLED, "");
      }
      
      if (log.isDebugEnabled()) log.debug("createConnection");
      conn = createConnection(url);

      // Provide header values.
      long contentLength = sendBuffer.available();
      String contentEncoding = "";
      
      // This function sends the buffer as contents of a multipart part.
      PostMultipartFormdata.WriteFunction writeFnct = os-> {
        if (log.isDebugEnabled()) log.debug("write to output stream");
        OutputStreamByteCount osbc = new OutputStreamByteCount(os);
        sendBuffer.copyTo(osbc, sendBuffer.available());
        if (log.isDebugEnabled()) log.debug("written #bytes=" + osbc.getContentLength() + ", wait for response");
      };
      
      // Send request as multipart/form-data
      PostMultipartFormdata.send(conn, contentLength, contentType, contentDisposition, contentEncoding, writeFnct);

      if (log.isDebugEnabled()) log.debug("getResponseCode...");
      statusCode = getResponseCode(conn);
      if (log.isDebugEnabled()) log.debug("statusCode={}", statusCode);
      
      if (statusCode != HttpURLConnection.HTTP_OK) {
        throw new BException(statusCode, "Put stream failed.");
      }

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
    finally {
      
      cleanupConnection(conn);
     
    }
    
    if (log.isDebugEnabled()) log.debug(")putBytes");
    return statusCode;
  }
  
  private void cleanupConnection(HttpURLConnection conn) {
    if (log.isDebugEnabled()) log.debug("clanupConnection(");
    if (conn != null) {
      
      cleanupInputStream(conn);
      
      cleanupErrorStream(conn);

      if (log.isDebugEnabled()) log.debug("conn.disconnect()");
      conn.disconnect();
    }
    if (log.isDebugEnabled()) log.debug(")clanupConnection");
  }


}


