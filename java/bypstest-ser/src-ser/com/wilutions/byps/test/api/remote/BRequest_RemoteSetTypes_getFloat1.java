package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteSetTypes_getFloat1 implements BMethodRequest, BSerializable {

	
	private final static long serialVersionUID = 1369351514L;
	
	@Override
	public int getRemoteId() { return 1156008353; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteSetTypes remoteT = (RemoteSetTypes)remote;			
			BAsyncResultSendMethod<java.util.Set<java.lang.Float>> outerResult = new BAsyncResultSendMethod<java.util.Set<java.lang.Float>>(asyncResult, new BResult_RemoteSetTypes_getFloat1());			
			remoteT.async_getFloat1(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
