package com.wilutions.byps;



public abstract class BMethodRequest {
	
	public abstract int getRemoteId();
	
	public void setSession(Object sess) {}
	
	/**
	 * 
	 * @param target Target interface. 
	 * @param asyncResult a BAsyncResult of BMethodResult
	 * @throws Throwable
	 */
	public abstract void execute(BRemote target, BAsyncResult<Object> asyncResult) throws Throwable;
}
