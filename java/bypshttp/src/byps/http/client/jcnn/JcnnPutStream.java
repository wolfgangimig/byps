package byps.http.client.jcnn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import byps.BAsyncResult;
import byps.BException;
import byps.BExceptionC;
import byps.BWire;
import byps.http.client.HHttpPutStreamHelper;

public class JcnnPutStream extends JcnnRequest implements HHttpPutStreamHelper.PutBytes {
  
  private static Logger log = LoggerFactory.getLogger(JcnnPutStream.class);
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

  protected JcnnPutStream(long trackingId, String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult, CookieManager cookieManager) {
    super(trackingId, url, cookieManager);
    this.stream = stream;
    this.asyncResult = asyncResult;
  }

  @Override
  public void run() {
    MDC.put("NDC", "jcnnputstream-" + trackingId);
    try {
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
    
    HttpURLConnection conn = null;
    OutputStream os = null;
    int statusCode = BExceptionC.CONNECTION_TO_SERVER_FAILED;
    
    try {
      
      if (isCancelled()) {
        throw new BException(BExceptionC.CANCELLED, "");
      }
      
      conn = createConnection(url);
      conn.setDoInput(true);
      conn.setDoOutput(true);
      conn.setRequestMethod(sendAsPost ? "POST" : "PUT");
      conn.setRequestProperty("Content-Type", contentType);
      
      if (!contentDisposition.isEmpty()) {
        conn.setRequestProperty("Content-Disposition", contentDisposition);
      }
      
      applySession(this);
      
      os = conn.getOutputStream();
      sendBuffer.copyTo(os, sendBuffer.available());
      os.flush();
      os.close();
      os = null;
      
      statusCode = getResponseCode(conn);
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
      
      cleanupConnection(conn, os);
     
    }
    
    return statusCode;
  }
  

  private void cleanupConnection(HttpURLConnection conn, OutputStream os) {
    if (conn != null) {
      
      cleanupInputStream(conn);
      
      cleanupErrorStream(conn);

      cleanupOutputStream(os);
      
      conn.disconnect();
    }
  }

  private void cleanupOutputStream(OutputStream os) {
    if (os != null) {
      try {
        os.close();
      }
      catch (Exception ignored) {
        // Ignore exception to continue with cleanup.
      }
    }
  }

}


// Cannot use neither setFixedLengthStreamingMode nor setChunkedStreamMode
// due to a concurrency bug in JVM, Bug ID 9005601
// Concurrent requests with setFixedLengthStreamingMode or setChunkedStreamMode
// cause Socket read timeout exceptions in Tomcat.

//if (contentLength >= 0) {
//  conn.setFixedLengthStreamingMode((int)contentLength);
//  try {
//    conn.setFixedLengthStreamingMode(contentLength);
//    if (log.isDebugEnabled()) log.debug("Content-Length=" + contentLength);
//  }
//  catch (NoSuchMethodError ignored) { // Java 6
//    if (contentLength <= Integer.MAX_VALUE) {
//      conn.setFixedLengthStreamingMode((int)contentLength);
//      if (log.isDebugEnabled()) log.debug("Content-Length=" + contentLength);
//    }
//    else {
//      conn.setChunkedStreamingMode(CHUNK_SIZE); 
//      if (log.isDebugEnabled()) log.debug("Content-Length > 2GB, Java 6 -> Chunked-Encoding");
//    }
//  }
//}
//else {
//  if (log.isDebugEnabled()) log.debug("Content-Length < 0 -> Chunked-Encoding");
//  conn.setChunkedStreamingMode(CHUNK_SIZE); // Chunked-Encoding + AsyncServlet erst ab Tomcat 7.0.28: https://issues.apache.org/bugzilla/show_bug.cgi?id=52055
//}


