package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteSetTypes_getShort1 implements BMethodRequest, BSerializable {

	
	private final static long serialVersionUID = 1000850298L;
	
	@Override
	public int getRemoteId() { return 1156008353; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteSetTypes remoteT = (RemoteSetTypes)remote;			
			BAsyncResultSendMethod<java.util.Set<java.lang.Short>> outerResult = new BAsyncResultSendMethod<java.util.Set<java.lang.Short>>(asyncResult, new BResult_RemoteSetTypes_getShort1());			
			remoteT.async_getShort1(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
