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

}
