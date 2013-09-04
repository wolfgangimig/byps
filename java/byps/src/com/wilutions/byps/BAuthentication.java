package com.wilutions.byps;

/**
 * Implementations of this interface provide authentication.
 */
public interface BAuthentication {

  /**
   * Authenticate the current user. An implementation can call
   * BTransport.isReloginException if there are no application specific
   * exceptions that should trigger an authentication.
   * 
   * @param client
   *          BClient object
   * @param asyncResult
   *          Result object, only the exception is evaluated.
   */
  void authenticate(final BClient client, final BAsyncResult<Boolean> asyncResult);

  /**
   * Return true, if the given exception has to trigger authentication.
   * 
   * @param client
   *          BClient object
   * @param ex
   *          Exception returned from the last request.
   * @param typeId
   *          Type ID (serialVersionUID) of the last request.
   * @return true triggers authentication, false forwards the exception to the
   *         caller.
   */
  boolean isReloginException(BClient client, Throwable ex, int typeId);

  Object getSession();
}
