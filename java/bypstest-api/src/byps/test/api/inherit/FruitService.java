package byps.test.api.inherit;

import byps.RemoteException;

/**
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
 *
 *
 */
public interface FruitService extends PlantService {

  public String squeeze() throws RemoteException;
  
  
}
