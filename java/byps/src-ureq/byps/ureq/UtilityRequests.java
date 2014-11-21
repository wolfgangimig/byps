package byps.ureq;

import byps.BRemote;
import byps.RemoteException;

public interface UtilityRequests extends BRemote {

  public void cancelMessage(long messageId) throws RemoteException;
}
