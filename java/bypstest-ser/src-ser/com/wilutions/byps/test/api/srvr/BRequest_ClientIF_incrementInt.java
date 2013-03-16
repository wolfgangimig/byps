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
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final ClientIFAsync remoteT = (ClientIFAsync)remote;			
			BAsyncResultSendMethod<Integer> outerResult = new BAsyncResultSendMethod<Integer>(asyncResult, new BResult_ClientIF_incrementInt());			
			remoteT.async_incrementInt(a, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
