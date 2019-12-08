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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.BException;
import byps.BExceptionC;
import byps.BWire;

public class JcnnPutStream extends JcnnRequest {
  
  private static Log log = LogFactory.getLog(JcnnPutStream.class);
  private final InputStream stream;
  private final BAsyncResult<ByteBuffer> asyncResult;
  private static final int MAX_STREAM_PART_SIZE = 10*1000*1000; 
  
  /**
   * Send stream as POST message.
   */
  private static boolean sendAsPost = false;
  
  static {
    String s = System.getProperty("byps.http.putStreamAsPost", "");
    if (s != null && !s.isEmpty()) sendAsPost = Boolean.parseBoolean(s);
  }

  protected JcnnPutStream(String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult, CookieManager cookieManager) {
    super(url, cookieManager);
    this.stream = stream;
    this.asyncResult = asyncResult;
  }

  @Override
  public void run() {
    
    BException returnException = null;
    
    try {
      
      // Try to get content type and stream length
      String contentType = BContentStream.DEFAULT_CONTENT_TYPE;
      long totalLength = Long.MAX_VALUE;
      String contentDisposition = "";
      byps.io.ByteArrayInputStream sendBuffer = null;
      
      if (stream instanceof BContentStream) {
        BContentStream cstream = (BContentStream)stream;
        contentType = cstream.getContentType();
        contentDisposition = cstream.getContentDisposition();
        long contentLength = cstream.getContentLength();
        if (contentLength >= 0) totalLength = contentLength;
      }
      else if (stream instanceof byps.io.ByteArrayInputStream) {
        contentType = BContentStream.DEFAULT_CONTENT_TYPE;
        byps.io.ByteArrayInputStream bis = ((byps.io.ByteArrayInputStream)stream);
        totalLength = bis.available();
        sendBuffer = bis;
      }
      else if (stream instanceof java.io.ByteArrayInputStream) {
        contentType = BContentStream.DEFAULT_CONTENT_TYPE;
        java.io.ByteArrayInputStream bis = ((java.io.ByteArrayInputStream)stream);
        totalLength = bis.available();
        sendBuffer = new byps.io.ByteArrayInputStream(bis);
      }

      if (contentType == null) contentType = BContentStream.DEFAULT_CONTENT_TYPE;
      if (contentDisposition == null) contentDisposition = "";
      if (log.isDebugEnabled()) log.debug("Content-Type=" + contentType);
      
      // Compute number of stream parts
      long nbOfParts = totalLength / MAX_STREAM_PART_SIZE;
      if ((totalLength % MAX_STREAM_PART_SIZE) != 0) {
        nbOfParts++;
      }
      if (log.isDebugEnabled()) log.debug("send stream in #parts=" + nbOfParts);
      
      if (sendBuffer != null) {
        
        putBytesFromMemory(contentType, totalLength, contentDisposition, sendBuffer, nbOfParts);
        
      }
      else {
        
        putBytesFromStream(contentType, totalLength, contentDisposition, nbOfParts);
      }
      
    }
    catch (BException e) {
      // thrown in RequestToCancel.setConnection
      if (log.isDebugEnabled()) log.debug("received BException: " + e);
      returnException = e;
    }
    catch (Throwable e) {
      if (log.isDebugEnabled()) log.debug("received Throwable: " + e);
      if (isCancelled()) {
        BException bex = new BException(BExceptionC.CANCELLED, "");
        returnException = bex;
      }
      else {
        BException bex = new BException(BExceptionC.IOERROR, e.getMessage(), e);
        returnException = bex;
      }
    }
    finally {
      
      if (stream != null) {
        if (log.isDebugEnabled()) log.debug("close stream, url=" + url + ", stream=" + stream);
        try { stream.close(); } catch (IOException ignored) {
          // Ignored, continue cleanup
        }
      }
      
      asyncResult.setAsyncResult(null, returnException);
      done();
    }
    
  }

  private void putBytesFromStream(String contentType, long totalLength, String contentDisposition, long nbOfParts)
      throws IOException {
    int bufferSize = MAX_STREAM_PART_SIZE;
    if (totalLength < MAX_STREAM_PART_SIZE) bufferSize = (int)totalLength;
    byte[] buf = new byte[bufferSize];
    
    boolean lastPart = false;
    for (long partId = 0; partId < nbOfParts && !lastPart; partId++) {
      
      int len = 0;
      while (len < buf.length) {
        int n = stream.read(buf, len, buf.length - len);
        if (n < 0) break;
        len += n;
      }
      lastPart = len < MAX_STREAM_PART_SIZE;
      
      putBytesRetry(partId, lastPart, totalLength, new byps.io.ByteArrayInputStream(buf, 0, len), contentType, contentDisposition);
      
    }
    while(!lastPart);
  }

  private void putBytesFromMemory(String contentType, long totalLength, String contentDisposition,
      byps.io.ByteArrayInputStream sendBuffer, long nbOfParts) throws IOException {
    for (long partId = 0; partId < nbOfParts; partId++) {
      boolean lastPart = partId == nbOfParts-1;
      putBytesRetry(partId, lastPart, totalLength, sendBuffer, contentType, contentDisposition);
    }
  }

  private void putBytesRetry(long partId, boolean lastPart, long totalLength, byps.io.ByteArrayInputStream sendBuffer, String contentType,
      String contentDisposition) throws IOException {
    StringBuilder destUrl = new StringBuilder();

    destUrl.append(url)
    .append("&putstream=1")
    .append("&partid=").append(partId)
    .append("&last=").append(lastPart ? 1 : 0)
    .append("&total=").append(totalLength);
    
    putBytesRetry(destUrl.toString(), sendBuffer, contentType, contentDisposition);
  }
  
  
  private void putBytesRetry(String url, byps.io.ByteArrayInputStream sendBuffer, String contentType, String contentDisposition) throws IOException {
    for (int retry = JcnnClient.MAX_RETRIES-1; retry >= 0; retry--) {
      if (putBytes(url, sendBuffer, contentType, contentDisposition, retry == 0) == HttpURLConnection.HTTP_OK) {
        break;
      }
    }
  }
  
  private int putBytes(String url, byps.io.ByteArrayInputStream sendBuffer, String contentType, String contentDisposition, boolean lastRetry) throws BException {
    
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
      sendBuffer.copyTo(os, MAX_STREAM_PART_SIZE);
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

  private void cleanupErrorStream(HttpURLConnection conn) {
    try {
      InputStream errStrm = conn.getErrorStream();
      if (errStrm != null) {
        ByteBuffer bbuf = BWire.bufferFromStream(errStrm, false);
        if (log.isInfoEnabled()) log.info("Put stream failed " + new String(bbuf.array(), StandardCharsets.UTF_8));
      }
    }
    catch (Exception e) {
      // Ignore exception to continue with cleanup.
    }
  }

  private void cleanupInputStream(HttpURLConnection conn) {
    try {
      InputStream respStrm = conn.getInputStream();
      if (respStrm != null) {
        ByteBuffer bbuf = BWire.bufferFromStream(respStrm, false);
        if (log.isDebugEnabled()) log.debug("Put stream succeeded " + new String(bbuf.array(), StandardCharsets.UTF_8));
      }
    }
    catch (Exception e) {
      // Ignore exception to continue with cleanup.
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


