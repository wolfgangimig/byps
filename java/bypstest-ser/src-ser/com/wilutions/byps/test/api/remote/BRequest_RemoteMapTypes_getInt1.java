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
public final class BRequest_RemoteMapTypes_getInt1 implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 1013140231L;
	
	@Override
	public int getRemoteId() { return 80483097; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteMapTypesAsync remoteT = (RemoteMapTypesAsync)remote;			
			BAsyncResultSendMethod<java.util.Map<java.lang.Integer,java.lang.Integer>> outerResult = new BAsyncResultSendMethod<java.util.Map<java.lang.Integer,java.lang.Integer>>(asyncResult, new com.wilutions.byps.test.api.BResult_1347703734());			
			remoteT.async_getInt1(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
