package byps.http.client.jcnn;

import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BAsyncResult;
import byps.BBufferJson;
import byps.BException;
import byps.BExceptionC;
import byps.BMessageHeader;
import byps.BWire;
import byps.BWire.OutputStreamByteCount;

public class JcnnPost extends JcnnRequest {

  private static Log log = LogFactory.getLog(JcnnPost.class);
  private final BAsyncResult<ByteBuffer> asyncResult;
  private ByteBuffer buf;
  
  protected JcnnPost(String url, ByteBuffer buf, BAsyncResult<ByteBuffer> asyncResult, CookieManager cookieManager) {
    super(url, cookieManager);
    this.buf = buf;
    this.asyncResult = asyncResult;
  }

  @Override
  public void run() {
    HttpURLConnection c = null;
    InputStream is = null;
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
  
        if (log.isDebugEnabled()) log.debug("write to output stream");
        OutputStreamByteCount osbc = new OutputStreamByteCount(c.getOutputStream());
        BWire.bufferToStream(buf, isJson, osbc);
        if (log.isDebugEnabled()) log.debug("written #bytes=" + osbc.sum + ", wait for response");
        
        statusCode = getResponseCode(c);
  
        if (statusCode != HttpURLConnection.HTTP_OK) {
          throw new IOException("HTTP status " + statusCode);
        }

        buf = null; // Speicher freigeben

        saveSession(this);
  
        is = c.getInputStream();
  
        String enc = c.getHeaderField("Content-Encoding");
        boolean gzip = enc != null && enc.equals("gzip");
  
        if (log.isDebugEnabled()) log.debug("read stream");
        ByteBuffer obuf = BWire.bufferFromStream(is, gzip);
        if (log.isDebugEnabled()) {
          log.debug("received #bytes=" + obuf.remaining());
          obuf.mark();
          BBufferJson bbuf = new BBufferJson(obuf);
          log.debug(bbuf.toDetailString());
          obuf.reset();
        }
  
        is = null;
        returnBuffer = obuf;
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
  
        try {
          if (c != null) {
            is = c.getErrorStream();
            BWire.bufferFromStream(is, false);
            is = null;
          }
        }
        catch (IOException ignored) {
        }
  
        returnException = new BException(statusCode, "Send message failed", e);
      }
      finally {
        if (is != null) {
          try {
            is.close();
          }
          catch (IOException ignored) {
          }
        }
        
        done();
      }

      retry++;
      
    } while(retry < JcnnClient.MAX_RETRIES &&
        buf != null && 
        returnException != null && 
        returnException.code == BExceptionC.CONNECTION_TO_SERVER_FAILED);

    buf = null; // Speicher freigeben

    asyncResult.setAsyncResult(returnBuffer, returnException);
    
  }
  
}
