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
public final class BRequest_RemoteArrayTypes23_sendArraysInt implements BMethodRequest, Serializable {

	public int[][] arr2;
	public int[][][] arr3;
	public int[][][][] arr4;
	
	private final static long serialVersionUID = 1748523470L;
	
	@Override
	public int getRemoteId() { return 2081058997; }
	
	@Override
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteArrayTypes23Async __byps__remoteT = (RemoteArrayTypes23Async)__byps__remote;			
			BAsyncResultSendMethod<int[]> __byps__outerResult = new BAsyncResultSendMethod<int[]>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_100361105());			
			__byps__remoteT.async_sendArraysInt(arr2, arr3, arr4, __byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
