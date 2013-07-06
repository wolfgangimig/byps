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
public final class BRequest_RemoteArrayTypes23_sendArraysClass implements BMethodRequest, Serializable {

	public com.wilutions.byps.test.api.prim.PrimitiveTypes[][] arr2;
	public com.wilutions.byps.test.api.prim.PrimitiveTypes[][][] arr3;
	public com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][] arr4;
	
	private final static long serialVersionUID = 1004457221L;
	
	@Override
	public int getRemoteId() { return 2081058997; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteArrayTypes23Async remoteT = (RemoteArrayTypes23Async)remote;			
			BAsyncResultSendMethod<com.wilutions.byps.test.api.prim.PrimitiveTypes[]> outerResult = new BAsyncResultSendMethod<com.wilutions.byps.test.api.prim.PrimitiveTypes[]>(asyncResult, new com.wilutions.byps.test.api.BResult_801243127());			
			remoteT.async_sendArraysClass(arr2, arr3, arr4, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
