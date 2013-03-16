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
public final class BRequest_ServerIF_getClientIds implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 2063368540L;
	
	@Override
	public int getRemoteId() { return 1313562065; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final ServerIFAsync remoteT = (ServerIFAsync)remote;			
			BAsyncResultSendMethod<java.util.Set<java.lang.Integer>> outerResult = new BAsyncResultSendMethod<java.util.Set<java.lang.Integer>>(asyncResult, new BResult_ServerIF_getClientIds());			
			remoteT.async_getClientIds(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
