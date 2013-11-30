package byps;

/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */

import byps.BAsyncResult;

public class BAsyncResultIgnored<T> implements BAsyncResult<T> {

  @Override
  public void setAsyncResult(T result, Throwable exception) {
  }

}
