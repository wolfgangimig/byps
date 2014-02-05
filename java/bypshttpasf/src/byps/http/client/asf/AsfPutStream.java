package byps.http.client.asf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.nio.ByteBuffer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.CloseableHttpClient;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.BException;
import byps.BExceptionC;
import byps.BWire;
import byps.BWire.OutputStreamByteCount;

public class AsfPutStream extends AsfRequest {
  
  private Log log = LogFactory.getLog(AsfPutStream.class);
  private final InputStream stream;
  private final BAsyncResult<ByteBuffer> asyncResult;
  private final static int CHUNK_SIZE = 10 * 1000;
  private final static int MAX_STREAM_PART_SIZE = 1000 * CHUNK_SIZE; // should be a multiple of CHUNK_SIZE

  protected AsfPutStream(String url, InputStream stream, BAsyncResult<ByteBuffer> asyncResult, CloseableHttpClient httpClient) {
    super(url, httpClient);
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
      if (stream instanceof BContentStream) {
        BContentStream cstream = (BContentStream)stream;
        contentType = cstream.getContentType();
        totalLength = cstream.getContentLength();
      }
      else if (stream instanceof ByteArrayInputStream) {
        contentType = BContentStream.DEFAULT_CONTENT_TYPE;
        totalLength = ((ByteArrayInputStream)stream).available();
      }

      if (contentType == null || contentType.length() == 0) {
        contentType = BContentStream.DEFAULT_CONTENT_TYPE;
      }
      if (log.isDebugEnabled()) log.debug("Content-Type=" + contentType);
        
      
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
        // wether it is the last part to be sent.
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
          .append("&partid=").append(partId)
          .append("&last=").append(lastPart ? 1 : 0)
          .append("&total=").append(totalLength);
          
        if (log.isDebugEnabled()) log.debug("open connection, url=" + destUrl);
       
        request = new HttpPut(url);
        applyTimeout();
        
        HttpEntity entity = new HttpEntity() {

          public void consumeContent() throws IOException {
            throw new IOException(new UnsupportedOperationException());
          }

          public InputStream getContent() throws IOException, IllegalStateException {
            throw new IllegalStateException();
          }

          public Header getContentEncoding() {
            return null;
          }

          public long getContentLength() {
            return buf.remaining();
          }

          public Header getContentType() {
            return null;
          }

          public boolean isChunked() {
            return false;
          }

          public boolean isRepeatable() {
            return true;
          }

          public boolean isStreaming() {
            return false;
          }

          public void writeTo(OutputStream os) throws IOException {
            int pos = buf.position();
            BWire.bufferToStream(buf, isJson, os);
            buf.position(pos); // to be repeatable
          }
          
        };
        
        ((HttpPost)request).setEntity(entity);
        
        OutputStream os = null;
        OutputStreamByteCount osbc = null;
        
        conn.setConnectTimeout(super.connectTimeoutSeconds * 1000);
        conn.setReadTimeout(sendRecvTimeoutSeconds * 1000);
  
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setRequestMethod("PUT");
        conn.setRequestProperty("Content-Type", contentType);
        
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
          if (log.isDebugEnabled()) log.debug("Failed to read response", e);
          InputStream errStrm = conn.getErrorStream();
          BWire.bufferFromStream(errStrm, false);
          
          throw new BException(statusCode, "Put stream failed", e);
        }
        finally {
          if (conn != null) {
            conn.disconnect();
          }
        }
  
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
        try { stream.close(); } catch (IOException ignored) {}
      }
      
      asyncResult.setAsyncResult(null, returnException);
      done();
    }
    
  }

}
