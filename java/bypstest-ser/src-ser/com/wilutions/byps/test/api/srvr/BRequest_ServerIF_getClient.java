package com.wilutions.byps.test.api.srvr;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_ServerIF_getClient implements BMethodRequest, BSerializable {

	public int id;
	
	private final static long serialVersionUID = 2107407220L;
	
	@Override
	public int getRemoteId() { return 1313562065; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final ServerIF remoteT = (ServerIF)remote;			
			BAsyncResultSendMethod<ClientIF> outerResult = new BAsyncResultSendMethod<ClientIF>(asyncResult, new BResult_ServerIF_getClient());			
			remoteT.async_getClient(id, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
