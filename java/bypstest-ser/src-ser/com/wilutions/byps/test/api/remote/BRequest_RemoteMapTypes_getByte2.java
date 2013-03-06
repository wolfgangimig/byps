package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteMapTypes_getByte2 implements BMethodRequest, BSerializable {

	
	private final static long serialVersionUID = 1348711373L;
	
	@Override
	public int getRemoteId() { return 80483097; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteMapTypes remoteT = (RemoteMapTypes)remote;			
			BAsyncResultSendMethod<java.util.Map<java.lang.Integer,byte[]>> outerResult = new BAsyncResultSendMethod<java.util.Map<java.lang.Integer,byte[]>>(asyncResult, new BResult_RemoteMapTypes_getByte2());			
			remoteT.async_getByte2(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
