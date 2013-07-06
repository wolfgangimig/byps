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
public final class BRequest_RemoteArrayTypes23_sendArraysInline implements BMethodRequest, Serializable {

	public com.wilutions.byps.test.api.inl.Point2D[][] arr2;
	public com.wilutions.byps.test.api.inl.Point2D[][][] arr3;
	public com.wilutions.byps.test.api.inl.Point2D[][][][] arr4;
	
	private final static long serialVersionUID = 899462794L;
	
	@Override
	public int getRemoteId() { return 2081058997; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteArrayTypes23Async remoteT = (RemoteArrayTypes23Async)remote;			
			BAsyncResultSendMethod<com.wilutions.byps.test.api.inl.Point2D[]> outerResult = new BAsyncResultSendMethod<com.wilutions.byps.test.api.inl.Point2D[]>(asyncResult, new com.wilutions.byps.test.api.BResult_2049740106());			
			remoteT.async_sendArraysInline(arr2, arr3, arr4, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
