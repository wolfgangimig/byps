package com.wilutions.byps;

public interface BAuthentication {
  
  /**
   * Tests, whether the given exception is thrown because of an expired or invalid session.
   * @param reloginCount Number of re-logins tried before this function is called.
   * @param ex Exception throw by the last request.
   * @return true, if function authenticate should be called to login. 
   */
  boolean isReloginException(int reloginCount, Throwable ex);
  
  /**
   * Authenticate the current user.
   * @param asyncResult
   */
  void authenticate(BAsyncResult<Boolean> asyncResult);
  
  /**
   * Returns the object that represents the current session.
   * @return Session object
   */
  Object getSessionObject();
}
