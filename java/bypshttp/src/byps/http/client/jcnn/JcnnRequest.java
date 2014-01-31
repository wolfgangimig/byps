package byps.http.client.jcnn;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import byps.BException;
import byps.BExceptionC;
import byps.http.client.HHttpRequest;
import byps.http.client.HHttpSessionManager;

public abstract class JcnnRequest implements HHttpRequest {

  protected AtomicReference<HttpURLConnection> conn = new AtomicReference<HttpURLConnection>();
  protected String url;
  protected BException ex;
  protected HHttpSessionManager sessionManager;
  protected int connectTimeoutSeconds;
  protected int sendRecvTimeoutSeconds;
  protected AtomicBoolean cancelled = new AtomicBoolean();
  private Log log = LogFactory.getLog(JcnnRequest.class);
  
  /**
   * HTTP status code. 
   */
  private int responseCode = -1;

  protected JcnnRequest(String url, HHttpSessionManager sessManager) {
    this.url = url;
    this.sessionManager = sessManager;
  }

  protected HttpURLConnection createConnection(String destUrl) throws IOException {
    if (cancelled.get()) throw new BException(BExceptionC.CANCELLED, "Request cancelled");
    HttpURLConnection c = (HttpURLConnection) new URL(destUrl).openConnection();
    conn.set(c);
    sessionManager.applySession(this);
    return c;
  }

  @Override
  public void setTimeouts(int connectTimeoutSeconds, int sendRecvTimeoutSeconds) {
    this.connectTimeoutSeconds = connectTimeoutSeconds;
    this.sendRecvTimeoutSeconds = sendRecvTimeoutSeconds;
  }

  @Override
  public void cancel() {
    if (log.isDebugEnabled()) log.debug("cancel(");
    cancelled.set(true);
    done();
    if (log.isDebugEnabled()) log.debug(")cancel");
  }

  @Override
  public boolean isCancelled() {
    return cancelled.get();
  }

  public void done() {
    if (log.isDebugEnabled()) log.debug("done(" + this);
    HttpURLConnection c = conn.getAndSet(null);
    if (c != null) {
      if (log.isDebugEnabled()) log.debug("disconnect");
      try {
        c.disconnect();
      }
      catch (Throwable npe) {
      }
      c = null;
    }
    if (log.isDebugEnabled()) log.debug(")done");
  }

  /**
   * Return HTTP status code.
   * Android throws an exception in getResponseCode, if code is 401.
   * BYPS does not understand this exception and does not perform a re-authentication.
   * That's why we cannot use getResponseCode in Android.
   * @param c HTTP connection object.
   * @return Response code.
   * @throws IOException
   */
  protected int getResponseCode(HttpURLConnection c) throws IOException {
    
    /*
     * Ensure that we have connected to the server. Record
     * exception as we need to re-throw it if there isn't
     * a status line.
     */
    Exception exc = null;
    try {
        c.getInputStream();
    } catch (Exception e) {
        exc = e;
    }

    /*
     * If we can't a status-line then re-throw any exception
     * that getInputStream threw.
     */
    String statusLine = c.getHeaderField(0);
    if (statusLine == null) {
        if (exc != null) {
            if (exc instanceof RuntimeException)
                throw (RuntimeException)exc;
            else
                throw (IOException)exc;
        }
        return -1;
    }

    /*
     * Examine the status-line - should be formatted as per
     * section 6.1 of RFC 2616 :-
     *
     * Status-Line = HTTP-Version SP Status-Code SP Reason-Phrase
     *
     * If status line can't be parsed return -1.
     */
    if (statusLine.startsWith("HTTP/1.")) {
        int codePos = statusLine.indexOf(' ');
        if (codePos > 0) {

            int phrasePos = statusLine.indexOf(' ', codePos+1);
//            if (phrasePos > 0 && phrasePos < statusLine.length()) {
//                responseMessage = statusLine.substring(phrasePos+1);
//            }

            // deviation from RFC 2616 - don't reject status line
            // if SP Reason-Phrase is not included.
            if (phrasePos < 0)
                phrasePos = statusLine.length();

            try {
                responseCode = Integer.parseInt
                        (statusLine.substring(codePos+1, phrasePos));
                return responseCode;
            } catch (NumberFormatException e) { }
        }
    }
    return -1;

  }
}
