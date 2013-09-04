package com.wilutions.byps;

public class BAsyncResultIgnored<T> implements BAsyncResult<T> {

  @Override
  public void setAsyncResult(T result, Throwable exception) {
  }

}
