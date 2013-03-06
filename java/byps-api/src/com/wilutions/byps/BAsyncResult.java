package com.wilutions.byps;


public interface BAsyncResult<T> {
	public void setAsyncResult(T obj, Throwable e);
}
