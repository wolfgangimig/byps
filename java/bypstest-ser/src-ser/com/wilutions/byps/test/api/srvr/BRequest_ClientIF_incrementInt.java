package com.wilutions.byps.test.api.srvr;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.io.Serializable;

/**
*/
@SuppressWarnings("all")
public final class BRequest_ClientIF_incrementInt implements BMethodRequest, Serializable {

	public int a;
	
	private final static long serialVersionUID = 1461829915L;
	
	@Override
	public int getRemoteId() { return 1784257353; }
	
	@Override
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final ClientIFAsync __byps__remoteT = (ClientIFAsync)__byps__remote;			
			BAsyncResultSendMethod<Integer> __byps__outerResult = new BAsyncResultSendMethod<Integer>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_5());			
			__byps__remoteT.async_incrementInt(a, __byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
