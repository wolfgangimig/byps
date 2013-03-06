package com.wilutions.byps;


public class BAsyncResultSendMethod<T> implements BAsyncResult<T> {

	private BAsyncResult<Object> innerResult;
	BMethodResult<T> methodResult;

	public BAsyncResultSendMethod(BAsyncResult<Object> innerResult, BMethodResult<T> methodResult) {
		this.innerResult = innerResult;
		this.methodResult = methodResult;
	}

	@Override
	public void setAsyncResult(T obj, Throwable e) {
		methodResult.result = obj;
		innerResult.setAsyncResult(methodResult, e);
	}

}
