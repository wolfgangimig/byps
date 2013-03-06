package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteMapTypes_getBoolean1 implements BMethodRequest, BSerializable {

	
	private final static long serialVersionUID = 461626272L;
	
	@Override
	public int getRemoteId() { return 80483097; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteMapTypes remoteT = (RemoteMapTypes)remote;			
			BAsyncResultSendMethod<java.util.Map<java.lang.String,java.lang.Boolean>> outerResult = new BAsyncResultSendMethod<java.util.Map<java.lang.String,java.lang.Boolean>>(asyncResult, new BResult_RemoteMapTypes_getBoolean1());			
			remoteT.async_getBoolean1(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
