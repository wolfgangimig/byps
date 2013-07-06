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
public final class BRequest_ServerIF_getPartner implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 748402113L;
	
	@Override
	public int getRemoteId() { return 1313562065; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final ServerIFAsync remoteT = (ServerIFAsync)remote;			
			BAsyncResultSendMethod<ClientIF> outerResult = new BAsyncResultSendMethod<ClientIF>(asyncResult, new com.wilutions.byps.test.api.BResult_1784257353());			
			remoteT.async_getPartner(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
