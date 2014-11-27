package byps.ureq;

import java.util.Map;

import byps.BRemote;
import byps.RemoteException;

/**
 * Interface with internally used utility functions.
 * 
 * Hint: This API does not support versioning.   
 */
public interface BUtilityRequests extends BRemote {
  
  public void cancelMessage(long messageId) throws RemoteException;
  
  public Map<String,String> testAdapter(String functionName, Map<String,String> params) throws RemoteException;
  
  public Map<String,String> execute(String functionName, Map<String,String> params) throws RemoteException;
  
}
