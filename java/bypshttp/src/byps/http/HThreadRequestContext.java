package byps.http;

import byps.BProtocol;
import byps.BTransport;

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
  private static final ThreadLocal<HRequestContext> threadRequestContext = ThreadLocal.withInitial(()->null);
  
  private static final ThreadLocal<BTransport> threadTransport = ThreadLocal.withInitial(() -> null);
  
  /**
   * Return request context of current thread.
   * @return Request context or null.
   */
  public static HRequestContext get() {
    return threadRequestContext.get();
  }

  /**
   * Return negotiated protocol.
   * @return Protocol or null.
   */
  public static BProtocol getProtocol() {
    BTransport transport = threadTransport.get();
    return transport != null ? transport.getProtocol() : null;
  }

  /**
   * Set request context of current thread.
   * @param requestContext HRequestContext
   * @param transport BTransport
   */
  public static void set(HRequestContext requestContext, BTransport transport) {
    threadRequestContext.set(requestContext);
    threadTransport.set(transport);
  }
  
  /**
   * Remove request context of current thread.
   */
  public static void remove() {
    threadRequestContext.remove();
    threadTransport.remove();
  }
  
  @Override
  public void close() throws Exception {
    remove();
  }
  
}
