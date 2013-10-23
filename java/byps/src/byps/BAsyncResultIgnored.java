package byps;

import byps.BAsyncResult;

public class BAsyncResultIgnored<T> implements BAsyncResult<T> {

  @Override
  public void setAsyncResult(T result, Throwable exception) {
  }

}
