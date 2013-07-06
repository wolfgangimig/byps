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
public final class BRequest_RemoteMapTypes_getByte1 implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 1348711374L;
	
	@Override
	public int getRemoteId() { return 80483097; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteMapTypesAsync remoteT = (RemoteMapTypesAsync)remote;			
			BAsyncResultSendMethod<java.util.HashMap<java.lang.Double,java.lang.Byte>> outerResult = new BAsyncResultSendMethod<java.util.HashMap<java.lang.Double,java.lang.Byte>>(asyncResult, new com.wilutions.byps.test.api.BResult_1972793385());			
			remoteT.async_getByte1(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
