package byps;

import byps.BAsyncResult;

/**
 * Implementations of this interface provide authentication.
 */
public interface BAuthentication {

  /**
   * Authenticate the current user. 
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
   * This object will be passed to every request class (e.g. BRequest_functionname) 
   * for remote interfaces tagged with @BSessionParamType.
   * If the function throws an exception, the isReloginException and maybe the authentication 
   * functions are called before the current method request is sent.
   * @param client
   *          BClient object
   * @param typeId
   *          Type ID (serialVersionUID) of the last request class, see {@link #isReloginException(BClient, Throwable, int)}.
   * @param asyncResult
   *          This object receives the session object or an exception.
   * @see BMethodRequest#setSession(Object)
   */
  public void getSession(BClient client, int typeId, BAsyncResult<Object> asyncResult);
}
