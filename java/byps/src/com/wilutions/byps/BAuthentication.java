package com.wilutions.byps;

/**
 * Implementations of this interface provide authentication.
 */
public interface BAuthentication {
  
  /**
   * Authenticate the current user.
   * @param client
   * @param asyncResult Result object, only the exception is evaluated.
   */
  void authenticate(final BClient client, final BAsyncResult<Boolean> asyncResult);

  boolean isReloginException(Throwable ex);

  Object getSession();
}
