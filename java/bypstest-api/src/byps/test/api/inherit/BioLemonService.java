package byps.test.api.inherit;

import byps.RemoteException;

/**
 * 
 * @BClientRemote
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
 */
public interface BioLemonService extends BioFruitService, LemonService {

  int useParing() throws RemoteException;
}
