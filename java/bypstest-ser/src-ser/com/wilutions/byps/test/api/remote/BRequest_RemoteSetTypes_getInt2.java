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
public final class BRequest_RemoteSetTypes_getInt2 implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 68372556L;
	
	@Override
	public int getRemoteId() { return 1156008353; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteSetTypesAsync remoteT = (RemoteSetTypesAsync)remote;			
			BAsyncResultSendMethod<java.util.Set<int[]>> outerResult = new BAsyncResultSendMethod<java.util.Set<int[]>>(asyncResult, new com.wilutions.byps.test.api.BResult_1406124761());			
			remoteT.async_getInt2(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
