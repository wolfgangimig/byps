package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteListTypes_getPrimitiveTypes1 implements BMethodRequest, BSerializable {

	
	private final static long serialVersionUID = 1940572240L;
	
	@Override
	public int getRemoteId() { return 380156079; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteListTypes remoteT = (RemoteListTypes)remote;			
			BAsyncResultSendMethod<java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes>> outerResult = new BAsyncResultSendMethod<java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes>>(asyncResult, new BResult_RemoteListTypes_getPrimitiveTypes1());			
			remoteT.async_getPrimitiveTypes1(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
