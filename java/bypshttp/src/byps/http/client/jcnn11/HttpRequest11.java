package byps.http.client.jcnn11;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.net.http.HttpResponse.BodySubscriber;
import java.net.http.HttpResponse.ResponseInfo;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import byps.BAsyncResult;
import byps.BException;
import byps.BExceptionC;
import byps.http.client.HHttpRequest;

public abstract class HttpRequest11 implements HHttpRequest {
  
  private static final int DEFAULT_TIMEOUT_SECONDS = 120; 

  protected String url;
  protected int connectTimeoutSeconds = DEFAULT_TIMEOUT_SECONDS;
  protected int sendRecvTimeoutSeconds = DEFAULT_TIMEOUT_SECONDS;
  protected final Map<String, String> requestProperties = new HashMap<>();
  protected AtomicReference<BodyHandlerToCancel> cancellableBodyHandler = new AtomicReference<>();
  protected AtomicBoolean cancelled = new AtomicBoolean();
  protected final long trackingId;
  protected final HttpClient client;
  private static final Logger log = LoggerFactory.getLogger(HttpRequest11.class);

  protected HttpRequest11(HttpClient client, long trackingId, String url) {
    this.client = client;
    this.trackingId = trackingId;
    this.url = url;
    if (log.isDebugEnabled()) log.debug("HttpRequest11({}{})", trackingId, url);
  }

  protected HttpRequest.Builder createRequestBuilder() {
    return createRequestBuilderForUri(URI.create(url));
  }

  protected HttpRequest.Builder createRequestBuilderForUri(URI uri) {
    if (log.isDebugEnabled()) log.debug("createRequestBuilder, uri={}, timeout={}s, headers{}", uri, sendRecvTimeoutSeconds, requestProperties);
    HttpRequest.Builder builder = HttpRequest.newBuilder(uri)
        .timeout(Duration.ofSeconds(sendRecvTimeoutSeconds));
    requestProperties.entrySet().forEach(e -> builder.header(e.getKey(), e.getValue()));
    return builder;
  }

  @Override
  public void setTimeouts(int connectTimeoutSeconds, int sendRecvTimeoutSeconds) {
    this.connectTimeoutSeconds = connectTimeoutSeconds != 0 ? connectTimeoutSeconds : DEFAULT_TIMEOUT_SECONDS;
    this.sendRecvTimeoutSeconds = sendRecvTimeoutSeconds != 0 ? sendRecvTimeoutSeconds : DEFAULT_TIMEOUT_SECONDS;
  }

  @Override
  public void cancel() {
    if (log.isDebugEnabled()) log.debug("cancel");
    cancelled.set(true);
    BodyHandlerToCancel bodyHandler = cancellableBodyHandler.getAndSet(null);
    if (bodyHandler != null) bodyHandler.cancel();
  }

  @Override
  public boolean isCancelled() {
    return cancelled.get();
  }

  @Override
  public void setRequestProperty(String name, String value) {
    requestProperties.put(name, value);
  }

  protected BodyHandler<byte[]> buildBodyHandlerBytes() {
    BodyHandlerWrapper<byte[]> handler = new BodyHandlerWrapper<>(BodyHandlers.ofByteArray());
    cancellableBodyHandler.set(handler);
    return handler;
  }
  
  protected BodyHandler<InputStream> buildBodyHandlerInputStream() {
    BodyHandlerWrapper<InputStream> handler = new BodyHandlerWrapper<>(BodyHandlers.ofInputStream());
    cancellableBodyHandler.set(handler);
    return handler;
  }
  
  protected boolean handleResponseBytes(HttpResponse<byte[]> response, BAsyncResult<ByteBuffer> asyncResult) {
    ByteBuffer rbuf = null;
    Throwable exception = null;
    
    int statusCode = response.statusCode();
    if (statusCode != HttpURLConnection.HTTP_OK) {
      exception = new BException(statusCode, "Request failed");
    }
    else {
      rbuf = ByteBuffer.wrap(response.body());
    }
    
    asyncResult.setAsyncResult(rbuf, exception);
    return true;
  }
  
  BException toBException(int statusCode, Throwable e) {
    BException ret;
    if (log.isDebugEnabled()) log.debug("received exception={}", e.toString());
  
    if (e instanceof SocketException) {
      ret = new BException(BExceptionC.CONNECTION_TO_SERVER_FAILED, "Socket error.", e);
    }
    else if (e instanceof SocketTimeoutException) {
      if (log.isDebugEnabled()) log.debug("received exception={}", e.toString());
      ret = new BException(BExceptionC.TIMEOUT, "Socket timeout.", e);
    }
    else if (e instanceof InterruptedException) {
      Thread.currentThread().interrupt();
      ret = new BException(BExceptionC.CANCELLED, "Request interrupted.", e);
    }
    else {
      ret = new BException(statusCode, "Request failed.", e);
    }
    return ret;
  }

  
  //https://stackoverflow.com/questions/55209385/cancellation-of-http-request-in-java-11-httpclient/55258556
  
  
  private static class SubscriberWrapper<T> implements BodySubscriber<T> {
    private final CountDownLatch latch;
    private final BodySubscriber<T> subscriber;
    private Subscription subscription;

    private SubscriberWrapper(BodySubscriber<T> subscriber, CountDownLatch latch) {
      this.subscriber = subscriber;
      this.latch = latch;
    }

    @Override
    public CompletionStage<T> getBody() {
      return subscriber.getBody();
    }

    @Override
    public void onSubscribe(Subscription subscription) {
      subscriber.onSubscribe(subscription);
      this.subscription = subscription;
      latch.countDown();
    }

    @Override
    public void onNext(List<ByteBuffer> item) {
      subscriber.onNext(item);
    }

    @Override
    public void onError(Throwable throwable) {
      subscriber.onError(throwable);
    }

    @Override
    public void onComplete() {
      subscriber.onComplete();
    }

    public void cancel() {
      subscription.cancel();
    }
  }
  
  private static interface BodyHandlerToCancel {
    void cancel();
  }

  private static class BodyHandlerWrapper<T> implements BodyHandler<T>, BodyHandlerToCancel {
    private final CountDownLatch latch = new CountDownLatch(1);
    private final BodyHandler<T> handler;
    private SubscriberWrapper<T> subscriberWrapper;

    protected BodyHandlerWrapper(BodyHandler<T> handler) {
      this.handler = handler;
    }

    @Override
    public BodySubscriber<T> apply(ResponseInfo responseInfo) {
      subscriberWrapper = new SubscriberWrapper<>(handler.apply(responseInfo), latch);
      return subscriberWrapper;
    }

    @Override
    public void cancel() {
      CompletableFuture.runAsync(() -> {
        try {
          latch.await();
          subscriberWrapper.cancel();
        } catch (InterruptedException e) {
        }
      });
    }
  }

}
