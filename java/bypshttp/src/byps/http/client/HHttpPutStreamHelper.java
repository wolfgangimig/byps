package byps.http.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.nio.ByteBuffer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.BException;
import byps.BExceptionC;
import byps.http.client.jcnn.JcnnClient;

public class HHttpPutStreamHelper {

  public interface PutBytes {
    
    public int putBytes(String url, byps.io.ByteArrayInputStream sendBuffer, String contentType, String contentDisposition, boolean lastRetry) throws BException;
    
    public boolean isCancelled();
  }
  
  private final PutBytes putBytesImpl;
  private final String url;
  private final InputStream stream;
  private final BAsyncResult<ByteBuffer> asyncResult;
  private static final int MAX_STREAM_PART_SIZE = 10*1000*1000; 
  private static Log log = LogFactory.getLog(HHttpPutStreamHelper.class);
  
  public HHttpPutStreamHelper(PutBytes putBytesImpl, String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult) {
    this.putBytesImpl = putBytesImpl;
    this.url = url;
    this.stream = stream;
    this.asyncResult = asyncResult;
  }
  
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
      }

      contentType = defaultValue(contentType, BContentStream.DEFAULT_CONTENT_TYPE);
      contentDisposition = defaultValue(contentDisposition, "");
      if (log.isDebugEnabled()) log.debug("Content-Type=" + contentType);
      
      // Compute number of stream parts
      long nbOfParts = computeNbOfParts(totalLength);
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
      returnException = makeBExceptionFromThrowable(e);
    }
    finally {
      
      if (stream != null) {
        if (log.isDebugEnabled()) log.debug("close stream, url=" + url + ", stream=" + stream);
        try { stream.close(); } catch (IOException ignored) {
          // Ignored, continue cleanup
        }
      }
      
      asyncResult.setAsyncResult(null, returnException);
    }
    
  }

  private BException makeBExceptionFromThrowable(Throwable e) {
    BException returnException;
    if (isCancelled()) {
      BException bex = new BException(BExceptionC.CANCELLED, "");
      returnException = bex;
    }
    else {
      BException bex = new BException(BExceptionC.IOERROR, e.getMessage(), e);
      returnException = bex;
    }
    return returnException;
  }
  
  private String defaultValue(String s, String d) {
    return s == null || s.isEmpty() ? d : s;
  }

  private long computeNbOfParts(long totalLength) {
    long nbOfParts = totalLength / MAX_STREAM_PART_SIZE;
    if ((totalLength % MAX_STREAM_PART_SIZE) != 0) {
      nbOfParts++;
    }
    return nbOfParts;
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
    for (int retry = 0; retry < JcnnClient.MAX_RETRIES; retry++) {
      boolean lastRetry = retry == JcnnClient.MAX_RETRIES-1;
      if (log.isDebugEnabled()) log.debug("putBytesRetry url=" + url + ", retry=" + retry + ", lastRetry=" + lastRetry);
      if (putBytes(url, sendBuffer, contentType, contentDisposition, lastRetry) == HttpURLConnection.HTTP_OK) {
        break;
      }
    }
  }
  
  
  private int putBytes(String url, byps.io.ByteArrayInputStream sendBuffer, String contentType, String contentDisposition, boolean lastRetry) throws BException {
    return putBytesImpl.putBytes(url, sendBuffer, contentType, contentDisposition, lastRetry);
  }
  
  private boolean isCancelled() {
    return putBytesImpl.isCancelled();
  }


}
