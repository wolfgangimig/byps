package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteSetTypes_getString1 implements BMethodRequest, BSerializable {

	
	private final static long serialVersionUID = 615539953L;
	
	@Override
	public int getRemoteId() { return 1156008353; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteSetTypes remoteT = (RemoteSetTypes)remote;			
			BAsyncResultSendMethod<java.util.Set<java.lang.String>> outerResult = new BAsyncResultSendMethod<java.util.Set<java.lang.String>>(asyncResult, new BResult_RemoteSetTypes_getString1());			
			remoteT.async_getString1(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
