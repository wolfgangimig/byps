package byps.test.api.comp;

import byps.BRemote;
import byps.RemoteException;

/**
 * This interface with incompatible changes.
 * @since 793
 */
public interface IncompatibleChangeIF extends BRemote {

  /**
   * Function with changed return type.
   * The return type was int in version 793. In 794 it has been changed to String.
   * Calling this function must cause an exception.
   * @return value
   * @throws RemoteException
   */
  public int changedReturnType() throws RemoteException;

  /**
   * Function with changed parameter type.
   * The parameter type was int in version 793. In 794 it has been changed to String.
   * Calling this function must cause an exception.
   * @param intParamChangedToString value
   * @throws RemoteException
   */
  public void changedParameterType(int intParamChangedToString) throws RemoteException;
  
  /**
   * Function with changed parameter class.
   * The class has been incompatibly changed in version 794.
   * Calling this function must cause an exception.
   * @param param value
   * @throws RemoteException
   */
  public void changedClass(IncompatibleChangeInfo param) throws RemoteException;
}
