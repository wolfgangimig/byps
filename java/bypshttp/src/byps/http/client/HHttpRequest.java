package byps.http.client;

/**
 * Interface for HTTP requests. 
 *
 */
public interface HHttpRequest extends Runnable {

  /**
   * Set request timeout values.
   * @param connectTimeoutSeconds
   * @param sendRecvTimeoutSeconds
   */
  public void setTimeouts(int connectTimeoutSeconds, int sendRecvTimeoutSeconds);
  
  /**
   * Abort request.
   */
  public void cancel();
  
  /**
   * Return true, if request 
   * @return
   */
  public boolean isCancelled();
}
