package byps.http;

import java.util.function.Supplier;

/**
 * This class provides a thread local store for a HRequestContext.
 * BYPS-9
 * 
 *
 */
public class HThreadRequestContext implements AutoCloseable {
  
  /**
   * Provide HttpServletRequest and -Response as thread local variable.
   * BYPS-9
   */
  private static final ThreadLocal<HRequestContext> threadRequestContext = ThreadLocal.withInitial(
      new Supplier<HRequestContext>() {
        @Override
        public HRequestContext get() {
          return null;
        }
      });
  
  /**
   * Initialize thread local request context.
   * @param requestContext HRequestContext
   */
  public HThreadRequestContext(HRequestContext requestContext) {
    threadRequestContext.set(requestContext);
  }
  
  /**
   * Return request context of current thread.
   * @return Request context or null.
   */
  public static HRequestContext get() {
    return threadRequestContext.get();
  }

  /**
   * Set request context of current thread.
   * @param requestContext HRequestContext
   */
  public static void set(HRequestContext requestContext) {
    threadRequestContext.set(requestContext);
  }
  
  /**
   * Remove request context of current thread.
   */
  public static void remove() {
    threadRequestContext.remove();
  }
  
  @Override
  public void close() throws Exception {
    remove();
  }
  
}
