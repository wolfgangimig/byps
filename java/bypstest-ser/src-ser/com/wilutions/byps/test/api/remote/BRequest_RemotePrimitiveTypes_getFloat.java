﻿package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemotePrimitiveTypes_getFloat implements BMethodRequest, BSerializable {

	
	private final static long serialVersionUID = 400008432L;
	
	@Override
	public int getRemoteId() { return 1341983932; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemotePrimitiveTypes remoteT = (RemotePrimitiveTypes)remote;			
			BAsyncResultSendMethod<Float> outerResult = new BAsyncResultSendMethod<Float>(asyncResult, new BResult_RemotePrimitiveTypes_getFloat());			
			remoteT.async_getFloat(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}