package com.wilutions.byps.test.api.inherit;

import com.wilutions.byps.RemoteException;

/**
 * 
 * @BClientRemote
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
 */
public interface BioFruitService extends FruitService {

  boolean certify(String param) throws RemoteException;
}
