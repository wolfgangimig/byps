package byps.test.api.inherit;

import byps.RemoteException;
import byps.test.api.auth.SessionInfo;

/**
 * 
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
 * 
 */
public interface LemonService extends FruitService {

  public String pick(SessionInfo sess, String fromTree) throws RemoteException;
  
}
