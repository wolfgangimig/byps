﻿package com.wilutions.byps.test.api.remote;

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
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteArrayTypes23Async __byps__remoteT = (RemoteArrayTypes23Async)__byps__remote;			
			BAsyncResultSendMethod<com.wilutions.byps.test.api.prim.PrimitiveTypes[]> __byps__outerResult = new BAsyncResultSendMethod<com.wilutions.byps.test.api.prim.PrimitiveTypes[]>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_801243127());			
			__byps__remoteT.async_sendArraysClass(arr2, arr3, arr4, __byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}