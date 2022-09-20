package byps.http.cotest;

import byps.BAsyncResult;
import byps.BClient;

public interface CoTestRunnable {

  public void run(BClient client, BAsyncResult<Boolean> asyncResult);
}
