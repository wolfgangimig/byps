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
public final class BRequest_RemoteMapTypes_setBoolean1 implements BMethodRequest, Serializable {

	public java.util.Map<java.lang.String,java.lang.Boolean> boolean1;
	
	private final static long serialVersionUID = 550206100L;
	
	@Override
	public int getRemoteId() { return 80483097; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteMapTypesAsync remoteT = (RemoteMapTypesAsync)remote;			
			BAsyncResultSendMethod<Object> outerResult = new BAsyncResultSendMethod<Object>(asyncResult, new com.wilutions.byps.test.api.BResult_19());			
			remoteT.async_setBoolean1(boolean1, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
