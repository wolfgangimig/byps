package com.wilutions.byps;


public interface BMethodRequest extends BSerializable {
	
	public int getRemoteId();
	
	/**
	 * 
	 * @param target Target interface. 
	 * @param asyncResult a BAsyncResult of BMethodResult
	 * @throws Throwable
	 */
	public void execute(BRemote target, BAsyncResult<Object> asyncResult) throws Throwable;
}
