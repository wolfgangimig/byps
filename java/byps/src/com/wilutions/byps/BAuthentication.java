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
   *          Type ID (serialVersionUID) of the last request class. For each API function,
   *          the generator has created a request class named BRequest_functionname.
   *          The passed type ID is the serialVersionUID of this class.
   * @return true triggers authentication, false forwards the exception to the
   *         caller.
   */
  boolean isReloginException(BClient client, Throwable ex, int typeId);

  /**
   * Return the object representing the current session.
   * If the API manages its own session, this object will be passed to every request class for remote interfaces 
   * tagged with @authparam.
   * @return Session object
   * @see BMethodRequest#setSession(Object)
   */
  Object getSession();
}
