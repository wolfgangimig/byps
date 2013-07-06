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
public final class BRequest_RemoteSetTypes_getByte1 implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 2125684552L;
	
	@Override
	public int getRemoteId() { return 1156008353; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteSetTypesAsync remoteT = (RemoteSetTypesAsync)remote;			
			BAsyncResultSendMethod<java.util.HashSet<java.lang.Byte>> outerResult = new BAsyncResultSendMethod<java.util.HashSet<java.lang.Byte>>(asyncResult, new com.wilutions.byps.test.api.BResult_31512998());			
			remoteT.async_getByte1(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
