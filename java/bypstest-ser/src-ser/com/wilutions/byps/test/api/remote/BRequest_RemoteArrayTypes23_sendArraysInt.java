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
public final class BRequest_RemoteArrayTypes23_sendArraysInt implements BMethodRequest, Serializable {

	public int[][] arr2;
	public int[][][] arr3;
	public int[][][][] arr4;
	
	private final static long serialVersionUID = 1748523470L;
	
	@Override
	public int getRemoteId() { return 2081058997; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteArrayTypes23Async remoteT = (RemoteArrayTypes23Async)remote;			
			BAsyncResultSendMethod<int[]> outerResult = new BAsyncResultSendMethod<int[]>(asyncResult, new com.wilutions.byps.test.api.BResult_100361105());			
			remoteT.async_sendArraysInt(arr2, arr3, arr4, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
