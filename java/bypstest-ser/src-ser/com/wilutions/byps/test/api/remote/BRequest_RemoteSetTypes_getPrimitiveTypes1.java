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
public final class BRequest_RemoteSetTypes_getPrimitiveTypes1 implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 1802821742L;
	
	@Override
	public int getRemoteId() { return 1156008353; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteSetTypesAsync remoteT = (RemoteSetTypesAsync)remote;			
			BAsyncResultSendMethod<java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>> outerResult = new BAsyncResultSendMethod<java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>>(asyncResult, new BResult_RemoteSetTypes_getPrimitiveTypes1());			
			remoteT.async_getPrimitiveTypes1(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
