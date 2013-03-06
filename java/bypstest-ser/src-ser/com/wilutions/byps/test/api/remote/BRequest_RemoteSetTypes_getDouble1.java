package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteSetTypes_getDouble1 implements BMethodRequest, BSerializable {

	
	private final static long serialVersionUID = 1183778993L;
	
	@Override
	public int getRemoteId() { return 1156008353; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteSetTypes remoteT = (RemoteSetTypes)remote;			
			BAsyncResultSendMethod<java.util.Set<java.lang.Double>> outerResult = new BAsyncResultSendMethod<java.util.Set<java.lang.Double>>(asyncResult, new BResult_RemoteSetTypes_getDouble1());			
			remoteT.async_getDouble1(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
