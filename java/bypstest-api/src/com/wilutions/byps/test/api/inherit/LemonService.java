package com.wilutions.byps.test.api.inherit;

import com.wilutions.byps.RemoteException;
import com.wilutions.byps.test.api.auth.SessionInfo;

/**
 * 
 * @BSessionParamType com.wilutions.byps.test.api.auth.SessionInfo
 * 
 */
public interface LemonService extends FruitService {

  public String pick(SessionInfo sess, String fromTree) throws RemoteException;
  
}
