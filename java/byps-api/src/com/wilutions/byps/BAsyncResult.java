package com.wilutions.byps;

/**
 * This is the base class for handling asynchronous results.
 * @param <T> Result type.
 */
public interface BAsyncResult<T> {
	
	/**
	 * This function is called to set the result.
	 * Either result or exception is supplied.
	 * @param result Result object
	 * @param exception Exception
	 */
	public void setAsyncResult(T result, Throwable exception);
}
