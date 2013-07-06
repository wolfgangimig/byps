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
public final class BRequest_RemoteSetTypes_getInt1 implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 68372557L;
	
	@Override
	public int getRemoteId() { return 1156008353; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteSetTypesAsync remoteT = (RemoteSetTypesAsync)remote;			
			BAsyncResultSendMethod<java.util.Set<java.lang.Integer>> outerResult = new BAsyncResultSendMethod<java.util.Set<java.lang.Integer>>(asyncResult, new com.wilutions.byps.test.api.BResult_1493282670());			
			remoteT.async_getInt1(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
