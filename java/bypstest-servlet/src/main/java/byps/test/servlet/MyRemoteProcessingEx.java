package byps.test.servlet;

import byps.RemoteException;
import byps.test.api.remote.BSkeleton_RemoteProcessingEx;

public class MyRemoteProcessingEx extends BSkeleton_RemoteProcessingEx {

  @Override
  public boolean getValueAfterProcessingExceptions(int sleepSeconds) throws RemoteException {
    try {
      Thread.sleep((long) sleepSeconds * 1000L);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new RemoteException(e.toString());
    }
    return true;
  }

}
