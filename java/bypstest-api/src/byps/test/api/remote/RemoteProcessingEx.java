package byps.test.api.remote;

import byps.BRemote;
import byps.RemoteException;

/**
 * Interface used to check BExceptionC#PROCESSING.
 */
public interface RemoteProcessingEx extends BRemote {

  /**
   * This function sleeps the given number of seconds and returns true.
   * @param sleepSeconds Time in seconds to sleep.
   * @return true
   * @throws RemoteException
   */
	public boolean getValueAfterProcessingExceptions(int sleepSeconds) throws RemoteException;
	
}