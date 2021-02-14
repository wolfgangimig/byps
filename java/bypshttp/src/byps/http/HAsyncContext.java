package byps.http;

import java.util.concurrent.atomic.AtomicInteger;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import javax.servlet.AsyncContext;
import javax.servlet.AsyncListener;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HAsyncContext implements HRequestContext {

  private AsyncContext actxt;
  
  private static final Logger log = LoggerFactory.getLogger(HAsyncContext.class);

  /**
   * Request is completed. This value is set as true in {@link #complete()}. It
   * helps to avoid calling {@link AsyncContext#complete()} more than once (which
   * would generate an error on stdout or in the log file).
   * BYPS-39
   */
  private AtomicInteger completed = new AtomicInteger();

  public HAsyncContext(AsyncContext actxt) {
    this.actxt = actxt;
  }

  @Override
  public void addListener(AsyncListener arg0) {
    actxt.addListener(arg0);
  }

  @Override
  public void complete() {
    
    boolean alreadyCompleted = completed.incrementAndGet() != 1;
    if (alreadyCompleted) {
      if (log.isDebugEnabled()) log.debug("Obsolete call #{} to complete {}", completed, System.identityHashCode(this), new Exception());
    }
    
    if (log.isDebugEnabled()) log.debug("Complete {}", System.identityHashCode(this));
    actxt.complete();
  }

  @Override
  public ServletRequest getRequest() {
    return actxt.getRequest();
  }

  @Override
  public ServletResponse getResponse() {
    return actxt.getResponse();
  }

  @Override
  public void setTimeout(long arg0) {
    actxt.setTimeout(arg0);
  }

  @Override
  public void start(Runnable arg0) {
    actxt.start(arg0);
  }

  @Override
  public boolean isAsync() {
    return true;
  }
  
  @Override
  public boolean isCompleted() {
    return completed.get() != 0;
  }
}
