package byps.test.api.inherit;

import byps.BRemote;
import byps.RemoteException;

/**
 * 
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
 *
 */
public interface PlantService extends BRemote {
  public String grow() throws RemoteException;
}
