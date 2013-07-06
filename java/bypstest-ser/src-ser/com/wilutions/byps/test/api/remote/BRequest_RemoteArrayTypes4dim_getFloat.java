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
public final class BRequest_RemoteArrayTypes4dim_getFloat implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 1402482290L;
	
	@Override
	public int getRemoteId() { return 1557173854; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteArrayTypes4dimAsync remoteT = (RemoteArrayTypes4dimAsync)remote;			
			BAsyncResultSendMethod<float[][][][]> outerResult = new BAsyncResultSendMethod<float[][][][]>(asyncResult, new com.wilutions.byps.test.api.BResult_1516687588());			
			remoteT.async_getFloat(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
