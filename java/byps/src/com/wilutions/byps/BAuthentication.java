package com.wilutions.byps;

/**
 * Implementations of this interface provide authentication.
 *
 * @param <T> BClient class.
 */
public interface BAuthentication<T extends BClient> {
  
  /**
   * Authenticate the current user.
   * @param client
   * @param asyncResult with session object
   */
  void authenticate(final T client, final BAsyncResult<Object> asyncResult);

}
