package com.wilutions.byps;

import java.io.Serializable;


public interface BMethodRequest extends Serializable {
	
	public int getRemoteId();
	
	/**
	 * 
	 * @param target Target interface. 
	 * @param asyncResult a BAsyncResult of BMethodResult
	 * @throws Throwable
	 */
	public void execute(BRemote target, BAsyncResult<Object> asyncResult) throws Throwable;
}
