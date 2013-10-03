package com.wilutions.byps.test.api.inherit;

import com.wilutions.byps.RemoteException;

/**
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
 *
 *
 */
public interface FruitService extends PlantService {

  public String squeeze() throws RemoteException;
  
  
}
