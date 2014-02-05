package byps.http.client.asf;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;

import byps.http.client.HHttpRequest;

public abstract class AsfRequest implements HHttpRequest {

  protected AtomicReference<HttpURLConnection> conn = new AtomicReference<HttpURLConnection>();
  protected String url;
  protected CloseableHttpClient httpClient;
  protected volatile HttpRequestBase request;
  protected int connectTimeoutSeconds;
  protected int sendRecvTimeoutSeconds;
  protected AtomicBoolean cancelled = new AtomicBoolean();
  private Log log = LogFactory.getLog(AsfRequest.class);
  
  /**
   * HTTP status code. 
   */
  private int responseCode = -1;

  protected AsfRequest(String url, CloseableHttpClient httpClient) {
    this.url = url;
    this.httpClient = httpClient;
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
    if (request != null) {
      request.abort();
    }
    done();
    if (log.isDebugEnabled()) log.debug(")cancel");
  }

  @Override
  public boolean isCancelled() {
    return cancelled.get();
  }

  public void done() {
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
  
  protected void applyTimeout() {
    RequestConfig.Builder requestBuilder = RequestConfig.custom();
    requestBuilder = requestBuilder.setConnectTimeout(this.connectTimeoutSeconds);
    requestBuilder = requestBuilder.setConnectionRequestTimeout(this.connectTimeoutSeconds);
    requestBuilder = requestBuilder.setSocketTimeout(this.sendRecvTimeoutSeconds);
    request.setConfig(requestBuilder.build());
  }

}
