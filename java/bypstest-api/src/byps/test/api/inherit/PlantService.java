package byps.test.api.inherit;

import byps.Remote;
import byps.RemoteException;

/**
 * 
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
 *
 */
public interface PlantService extends Remote {
  public String grow() throws RemoteException;
}
