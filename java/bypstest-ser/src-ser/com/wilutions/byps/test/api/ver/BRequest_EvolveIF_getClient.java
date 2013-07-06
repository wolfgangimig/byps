package com.wilutions.byps.test.api.ver;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.io.Serializable;

/**
*/
@SuppressWarnings("all")
public final class BRequest_EvolveIF_getClient implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 98720592L;
	
	@Override
	public int getRemoteId() { return 2078696281; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final EvolveIFAsync remoteT = (EvolveIFAsync)remote;			
			BAsyncResultSendMethod<EvolveIF> outerResult = new BAsyncResultSendMethod<EvolveIF>(asyncResult, new com.wilutions.byps.test.api.BResult_2078696281());			
			remoteT.async_getClient(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
