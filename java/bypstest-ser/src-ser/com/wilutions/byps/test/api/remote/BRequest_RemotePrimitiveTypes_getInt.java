﻿package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemotePrimitiveTypes_getInt implements BMethodRequest, BSerializable {

	
	private final static long serialVersionUID = 1318015101L;
	
	@Override
	public int getRemoteId() { return 1341983932; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemotePrimitiveTypes remoteT = (RemotePrimitiveTypes)remote;			
			BAsyncResultSendMethod<Integer> outerResult = new BAsyncResultSendMethod<Integer>(asyncResult, new BResult_RemotePrimitiveTypes_getInt());			
			remoteT.async_getInt(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}