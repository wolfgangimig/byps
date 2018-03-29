package byps.http.client.asf;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;

import byps.http.client.HHttpRequest;

public abstract class AsfRequest implements HHttpRequest {

  protected AtomicReference<HttpURLConnection> conn = new AtomicReference<HttpURLConnection>();
  protected final String url;
  protected final CloseableHttpClient httpClient;
  protected final HttpClientContext context;
  protected volatile HttpRequestBase request;
  protected int connectTimeoutSeconds;
  protected int sendRecvTimeoutSeconds;
  protected Map<String,String> requestProperties;
  protected AtomicBoolean cancelled = new AtomicBoolean();
  private static Log log = LogFactory.getLog(AsfRequest.class);
  
  /**
   * HTTP status code. 
   */
  private int responseCode = -1;

  protected AsfRequest(String url, CloseableHttpClient httpClient, HttpClientContext context) {
    this.url = url;
    this.httpClient = httpClient;
    this.context = context;
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

  protected void applyTimeout() {
    RequestConfig.Builder requestBuilder = RequestConfig.custom();
    requestBuilder = requestBuilder.setConnectTimeout(this.connectTimeoutSeconds * 1000);
    requestBuilder = requestBuilder.setConnectionRequestTimeout(this.connectTimeoutSeconds * 1000);
    requestBuilder = requestBuilder.setSocketTimeout(this.sendRecvTimeoutSeconds * 1000);
    request.setConfig(requestBuilder.build());
  }
  
  protected void applyRequestProperties() {
    if (requestProperties == null) return;
    for (Map.Entry<String, String> prop : requestProperties.entrySet()) {
      request.setHeader(prop.getKey(), prop.getValue());
    }
  }

  @Override
  public void setRequestProperty(String name, String value) {
    if (requestProperties == null) requestProperties = new HashMap<String,String>();
    requestProperties.put(name, value);
  }
}
