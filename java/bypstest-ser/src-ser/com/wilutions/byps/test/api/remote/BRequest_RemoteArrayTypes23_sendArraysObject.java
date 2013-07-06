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
public final class BRequest_RemoteArrayTypes23_sendArraysObject implements BMethodRequest, Serializable {

	public java.lang.Object[][] arr2;
	public java.lang.Object[][][] arr3;
	public java.lang.Object[][][][] arr4;
	
	private final static long serialVersionUID = 738833892L;
	
	@Override
	public int getRemoteId() { return 2081058997; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteArrayTypes23Async remoteT = (RemoteArrayTypes23Async)remote;			
			BAsyncResultSendMethod<java.lang.Object[]> outerResult = new BAsyncResultSendMethod<java.lang.Object[]>(asyncResult, new com.wilutions.byps.test.api.BResult_183594037());			
			remoteT.async_sendArraysObject(arr2, arr3, arr4, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
