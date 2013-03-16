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
public final class BRequest_EvolveIF_setClient implements BMethodRequest, Serializable {

	public EvolveIF partner;
	
	private final static long serialVersionUID = 313337668L;
	
	@Override
	public int getRemoteId() { return 2078696281; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final EvolveIFAsync remoteT = (EvolveIFAsync)remote;			
			BAsyncResultSendMethod<Object> outerResult = new BAsyncResultSendMethod<Object>(asyncResult, new BResult_EvolveIF_setClient());			
			remoteT.async_setClient(partner, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
