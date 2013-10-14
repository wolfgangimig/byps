package com.wilutions.byps.test.api.inherit;

import com.wilutions.byps.RemoteException;

/**
 * 
 * @BClientRemote
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
 */
public interface BioLemonService extends BioFruitService, LemonService {

  int useParing() throws RemoteException;
}
