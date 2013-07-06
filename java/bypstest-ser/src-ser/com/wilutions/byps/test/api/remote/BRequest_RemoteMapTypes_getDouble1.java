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
public final class BRequest_RemoteMapTypes_getDouble1 implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 1836864439L;
	
	@Override
	public int getRemoteId() { return 80483097; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteMapTypesAsync remoteT = (RemoteMapTypesAsync)remote;			
			BAsyncResultSendMethod<java.util.Map<java.lang.Byte,java.lang.Double>> outerResult = new BAsyncResultSendMethod<java.util.Map<java.lang.Byte,java.lang.Double>>(asyncResult, new com.wilutions.byps.test.api.BResult_1487265161());			
			remoteT.async_getDouble1(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
