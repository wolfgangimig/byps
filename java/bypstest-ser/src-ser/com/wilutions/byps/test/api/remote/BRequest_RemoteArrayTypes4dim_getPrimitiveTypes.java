package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.io.Serializable;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteArrayTypes4dim_getPrimitiveTypes implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 1650564320L;
	
	@Override
	public int getRemoteId() { return 1557173854; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteArrayTypes4dimAsync remoteT = (RemoteArrayTypes4dimAsync)remote;			
			BAsyncResultSendMethod<com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][]> outerResult = new BAsyncResultSendMethod<com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][]>(asyncResult, new com.wilutions.byps.test.api.BResult_1503107601());			
			remoteT.async_getPrimitiveTypes(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
