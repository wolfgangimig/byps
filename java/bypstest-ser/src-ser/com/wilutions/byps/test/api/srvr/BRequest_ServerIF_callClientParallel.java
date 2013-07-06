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
public final class BRequest_ServerIF_callClientParallel implements BMethodRequest, Serializable {

	public int v;
	
	private final static long serialVersionUID = 1340180893L;
	
	@Override
	public int getRemoteId() { return 1313562065; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final ServerIFAsync remoteT = (ServerIFAsync)remote;			
			BAsyncResultSendMethod<Integer> outerResult = new BAsyncResultSendMethod<Integer>(asyncResult, new com.wilutions.byps.test.api.BResult_5());			
			remoteT.async_callClientParallel(v, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
