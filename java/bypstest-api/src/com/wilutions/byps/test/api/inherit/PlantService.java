package com.wilutions.byps.test.api.inherit;

import com.wilutions.byps.Remote;
import com.wilutions.byps.RemoteException;

/**
 * 
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
 *
 */
public interface PlantService extends Remote {
  public String grow() throws RemoteException;
}
