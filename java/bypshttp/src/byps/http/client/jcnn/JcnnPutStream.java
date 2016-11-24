package byps.http.client.jcnn;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.nio.ByteBuffer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.BException;
import byps.BExceptionC;
import byps.BWire;
import byps.BWire.OutputStreamByteCount;
import byps.io.ByteArrayInputStream;

public class JcnnPutStream extends JcnnRequest {
  
  private static Log log = LogFactory.getLog(JcnnPutStream.class);
  private final InputStream stream;
  private final BAsyncResult<ByteBuffer> asyncResult;
  private final static int CHUNK_SIZE = 10 * 1000;
  private final static int MAX_STREAM_PART_SIZE = 1000 * CHUNK_SIZE; // should be a multiple of CHUNK_SIZE
  
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
      String contentType = null;
      long totalLength = -1L;
      String contentDisposition = null;
      
      if (stream instanceof BContentStream) {
        BContentStream cstream = (BContentStream)stream;
        contentType = cstream.getContentType();
        totalLength = cstream.getContentLength();
        contentDisposition = cstream.getContentDisposition();
      }
      else if (stream instanceof ByteArrayInputStream) {
        contentType = BContentStream.DEFAULT_CONTENT_TYPE;
        totalLength = ((ByteArrayInputStream)stream).available();
      }

      if (contentType == null || contentType.length() == 0) {
        contentType = BContentStream.DEFAULT_CONTENT_TYPE;
      }
      if (log.isDebugEnabled()) log.debug("Content-Type=" + contentType);
      
        // Cannot use neither setFixedLengthStreamingMode nor setChunkedStreamMode
        // due to a concurrency bug in JVM, Bug ID 9005601
        // Concurrent requests with setFixedLengthStreamingMode or setChunkedStreamMode
        // cause Socket read timeout exceptions in Tomcat.
      
//        if (contentLength >= 0) {
//          conn.setFixedLengthStreamingMode((int)contentLength);
//          try {
//            conn.setFixedLengthStreamingMode(contentLength);
//            if (log.isDebugEnabled()) log.debug("Content-Length=" + contentLength);
//          }
//          catch (NoSuchMethodError ignored) { // Java 6
//            if (contentLength <= Integer.MAX_VALUE) {
//              conn.setFixedLengthStreamingMode((int)contentLength);
//              if (log.isDebugEnabled()) log.debug("Content-Length=" + contentLength);
//            }
//            else {
//              conn.setChunkedStreamingMode(CHUNK_SIZE); 
//              if (log.isDebugEnabled()) log.debug("Content-Length > 2GB, Java 6 -> Chunked-Encoding");
//            }
//          }
//        }
//        else {
//          if (log.isDebugEnabled()) log.debug("Content-Length < 0 -> Chunked-Encoding");
//          conn.setChunkedStreamingMode(CHUNK_SIZE); // Chunked-Encoding + AsyncServlet erst ab Tomcat 7.0.28: https://issues.apache.org/bugzilla/show_bug.cgi?id=52055
//        }
        
      
      // Compute number of stream parts
      long nbOfParts = 1; 
      if (totalLength > 0) {
        nbOfParts = totalLength / MAX_STREAM_PART_SIZE;
        if ((totalLength % MAX_STREAM_PART_SIZE) != 0) {
          nbOfParts++;
        }
        if (log.isDebugEnabled()) log.debug("send stream in #parts=" + nbOfParts);
      }
      else if (totalLength < 0) {
        nbOfParts = Long.MAX_VALUE;
      }
      
      boolean lastPart = false;
      
      for (long partId = 0; partId < nbOfParts && !lastPart; partId++) {
        
        if (isCancelled()) {
          if (log.isDebugEnabled()) log.debug("request is cancelled.");
          break;
        }
        
        // Read the first chunk to find out, 
        // whether it is the last part to be sent.
        byte[] buf = new byte[CHUNK_SIZE];
        int len = stream.read(buf, 0, buf.length);
        
        if (totalLength >= 0) {
          lastPart = partId == nbOfParts-1;
        }
        else {
          lastPart = len < CHUNK_SIZE;
        }
        
        StringBuilder destUrl = new StringBuilder();
        destUrl.append(url)
          .append("&putstream=1")
          .append("&partid=").append(partId)
          .append("&last=").append(lastPart ? 1 : 0)
          .append("&total=").append(totalLength);
          
        int retry = 0;
        do {

          if (isCancelled()) {
            if (log.isDebugEnabled()) log.debug("request is cancelled.");
            break;
          }

          if (log.isDebugEnabled()) log.debug("open connection, url=" + destUrl);
          
          HttpURLConnection conn = createConnection(destUrl.toString());
          OutputStream os = null;
          OutputStreamByteCount osbc = null;
          
          conn.setConnectTimeout(super.connectTimeoutSeconds * 1000);
          conn.setReadTimeout(sendRecvTimeoutSeconds * 1000);
    
          conn.setDoInput(true);
          conn.setDoOutput(true);
          conn.setRequestMethod(sendAsPost ? "POST" : "PUT");
          conn.setRequestProperty("Content-Type", contentType);
          
          if (contentDisposition != null && contentDisposition.length() != 0) {
            conn.setRequestProperty("Content-Disposition", contentDisposition);
          }
          
          applySession(this);
          
          if (log.isDebugEnabled()) log.debug("write to output stream");
          
          os = osbc = new OutputStreamByteCount(conn.getOutputStream());      
          
          long sum = 0;
          while (len != -1) {
            os.write(buf, 0, len);
            sum += len;
            if (sum >= MAX_STREAM_PART_SIZE) break;
            len = stream.read(buf, 0, buf.length);
          }
          
          os.flush();
          os.close();
          os = null;
          if (log.isDebugEnabled()) log.debug("written #bytes=" + osbc.sum + ", wait for response");
          
          int statusCode = BExceptionC.CONNECTION_TO_SERVER_FAILED;
          try {
            statusCode = getResponseCode(conn);
            if (statusCode != HttpURLConnection.HTTP_OK) {
              throw new IOException("HTTP " + statusCode); 
            }
            
            InputStream isResp = conn.getInputStream();
            BWire.bufferFromStream(isResp, false); // closes isResp
          }
          catch (SocketException e) {
            if (log.isDebugEnabled()) log.debug("received exception=" + e);
            returnException = new BException(BExceptionC.CONNECTION_TO_SERVER_FAILED, "Socket error", e);
          }
          catch (IOException e) {
            if (conn != null) {
              if (log.isDebugEnabled()) log.debug("Failed to read response", e);
              InputStream errStrm = conn.getErrorStream();
              BWire.bufferFromStream(errStrm, false);
            }          
            throw new BException(statusCode, "Put stream failed", e);
          }
          finally {
            if (conn != null) {
              conn.disconnect();
            }
          }
          
          retry++;
          
        } while(retry < JcnnClient.MAX_RETRIES && 
          returnException != null && 
          returnException.code == BExceptionC.CONNECTION_TO_SERVER_FAILED);
        
      } // for ...part...
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
        try { stream.close(); } catch (IOException ignored) {}
      }
      
      asyncResult.setAsyncResult(null, returnException);
      done();
    }
    
  }

}
