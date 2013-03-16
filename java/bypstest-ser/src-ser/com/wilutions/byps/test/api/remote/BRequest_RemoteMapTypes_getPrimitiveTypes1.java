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
public final class BRequest_RemoteMapTypes_getPrimitiveTypes1 implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 77071512L;
	
	@Override
	public int getRemoteId() { return 80483097; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteMapTypesAsync remoteT = (RemoteMapTypesAsync)remote;			
			BAsyncResultSendMethod<java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>> outerResult = new BAsyncResultSendMethod<java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>>(asyncResult, new BResult_RemoteMapTypes_getPrimitiveTypes1());			
			remoteT.async_getPrimitiveTypes1(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
