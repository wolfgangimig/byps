package com.wilutions.byps;

/**
 * This class wraps a BMethodResult object into an BAsyncResult.
 * Objects of this class are used in generated stubs.
 *
 * @param <T> The method's result type.
 */
public class BAsyncResultReceiveMethod<T> implements BAsyncResult<BMethodResult<T>> {
	
	private final BAsyncResult<T> innerResult;
	
	public BAsyncResultReceiveMethod(BAsyncResult<T> innerResult) {
		this.innerResult = innerResult;
	}
	
	@Override
	public void setAsyncResult(BMethodResult<T> methodResult, Throwable e)  {
		T result = methodResult != null ? methodResult.result : null;
		innerResult.setAsyncResult(result, e);
	}
	
}
