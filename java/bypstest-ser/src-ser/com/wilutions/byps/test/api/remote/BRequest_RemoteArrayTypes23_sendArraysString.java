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
public final class BRequest_RemoteArrayTypes23_sendArraysString implements BMethodRequest, Serializable {

	public java.lang.String[][] arr2;
	public java.lang.String[][][] arr3;
	public java.lang.String[][][][] arr4;
	
	private final static long serialVersionUID = 607451410L;
	
	@Override
	public int getRemoteId() { return 2081058997; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteArrayTypes23Async remoteT = (RemoteArrayTypes23Async)remote;			
			BAsyncResultSendMethod<java.lang.String[]> outerResult = new BAsyncResultSendMethod<java.lang.String[]>(asyncResult, new com.wilutions.byps.test.api.BResult_1888107655());			
			remoteT.async_sendArraysString(arr2, arr3, arr4, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
