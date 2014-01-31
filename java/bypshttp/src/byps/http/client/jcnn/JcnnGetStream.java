package byps.http.client.jcnn;

import java.io.IOException;
import java.io.InputStream;
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
import byps.http.client.HHttpSessionManager;

public class JcnnGetStream extends JcnnRequest {

  private Log log = LogFactory.getLog(JcnnGetStream.class);
  private final BAsyncResult<BContentStream> asyncResult;

  protected JcnnGetStream(String url, BAsyncResult<BContentStream> asyncResult, HHttpSessionManager sessManager) {
    super(url, sessManager);
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

    try {
      c = createConnection(url);

      c.setDoInput(true);
      c.setDoOutput(false);

      c.setRequestMethod("GET");

      statusCode = getResponseCode(c);

      if (statusCode != HttpURLConnection.HTTP_OK) {
        throw new IOException("HTTP status " + statusCode);
      }

      contentType = c.getContentType();

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
      returnException = new BException(BExceptionC.CONNECTION_TO_SERVER_FAILED, "Socket error", e);
    }
    catch (IOException e) {
      if (log.isDebugEnabled()) log.debug("received exception=" + e);

      try {
        is = c.getErrorStream();
        BWire.bufferFromStream(is, false);
        is = null;
      }
      catch (IOException ignored) {
      }

      returnException = new BException(statusCode, "Send message failed", e);
    }
    finally {
    }

    final BException ex2 = returnException;
    BContentStream stream = new BContentStreamWrapper(is, contentType, contentLength) {
      public InputStream ensureStream() throws IOException {
        if (ex2 != null) throw ex2;
        return super.ensureStream();
      }
      public void close() throws IOException {
        super.close();
        done();
      }
    };

    asyncResult.setAsyncResult(stream, null);
  }

}
