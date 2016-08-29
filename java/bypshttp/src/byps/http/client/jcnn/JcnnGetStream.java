package byps.http.client.jcnn;

import java.io.IOException;
import java.io.InputStream;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.SocketException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BAsyncResult;
import byps.BContentStream;
import byps.BContentStreamWrapper;
import byps.BException;
import byps.BExceptionC;
import byps.BWire;

public class JcnnGetStream extends JcnnRequest {

  private static Log log = LogFactory.getLog(JcnnGetStream.class);
  private final BAsyncResult<BContentStream> asyncResult;

  protected JcnnGetStream(String url, BAsyncResult<BContentStream> asyncResult,
      CookieManager cookieManager) {
    super(url, cookieManager);
    this.asyncResult = asyncResult;
  }

  @Override
  public void run() {

    HttpURLConnection c = null;
    InputStream is = null;
    BException returnException = null;
    int statusCode = BExceptionC.CONNECTION_TO_SERVER_FAILED;
    String contentType = null;
    long contentLength = -1;
    String contentDisposition = null;
    int retry = 0;

    do {
      try {
        c = createConnection(url);
  
        c.setDoInput(true);
        c.setDoOutput(false);
  
        c.setRequestMethod("GET");
  
        statusCode = getResponseCode(c);
  
        if (statusCode != HttpURLConnection.HTTP_OK && statusCode != HttpURLConnection.HTTP_PARTIAL) {
          throw new IOException("HTTP status " + statusCode);
        }
  
        contentType = c.getContentType();
        contentDisposition = c.getHeaderField("Content-Disposition");
  
        contentLength = -1L;
        try {
          String s = c.getHeaderField("Content-Length");
          if (s != null && s.length() != 0) {
            contentLength = Long.parseLong(s);
          }
        }
        catch (NumberFormatException ex) {
        }
  
        is = c.getInputStream();
      }
      catch (SocketException e) {
        if (log.isDebugEnabled()) log.debug("received exception=" + e);
        returnException = new BException(BExceptionC.CONNECTION_TO_SERVER_FAILED,
            "Socket error", e);
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
      }
      
      retry++;
      
    } while(retry < JcnnClient.MAX_RETRIES && 
      returnException != null && 
      returnException.code == BExceptionC.CONNECTION_TO_SERVER_FAILED);   

    final BException ex2 = returnException;
    BContentStream stream = new BContentStreamWrapper(is, contentType,
        contentLength) {
      public InputStream ensureStream() throws IOException {
        if (ex2 != null) throw ex2;
        return super.ensureStream();
      }

      public void close() throws IOException {
        super.close();
        JcnnGetStream.this.done();
      }
    };
    stream.setContentDisposition(contentDisposition);

    asyncResult.setAsyncResult(stream, null);
  }

}
