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
public final class BRequest_EvolveIF_getEvolve implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 32041374L;
	
	@Override
	public int getRemoteId() { return 2078696281; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final EvolveIFAsync remoteT = (EvolveIFAsync)remote;			
			BAsyncResultSendMethod<Evolve> outerResult = new BAsyncResultSendMethod<Evolve>(asyncResult, new com.wilutions.byps.test.api.BResult_1391985860());			
			remoteT.async_getEvolve(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
