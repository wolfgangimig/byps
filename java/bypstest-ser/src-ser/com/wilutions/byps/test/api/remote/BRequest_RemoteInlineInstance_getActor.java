﻿package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteInlineInstance_getActor implements BMethodRequest, BSerializable {

	
	private final static long serialVersionUID = 261822861L;
	
	@Override
	public int getRemoteId() { return 1206670536; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteInlineInstance remoteT = (RemoteInlineInstance)remote;			
			BAsyncResultSendMethod<com.wilutions.byps.test.api.inl.Actor> outerResult = new BAsyncResultSendMethod<com.wilutions.byps.test.api.inl.Actor>(asyncResult, new BResult_RemoteInlineInstance_getActor());			
			remoteT.async_getActor(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}