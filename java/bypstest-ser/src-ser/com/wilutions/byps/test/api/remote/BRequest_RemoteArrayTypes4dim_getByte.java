﻿package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteArrayTypes4dim_getByte implements BMethodRequest, BSerializable {

	
	private final static long serialVersionUID = 2032862102L;
	
	@Override
	public int getRemoteId() { return 1557173854; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteArrayTypes4dim remoteT = (RemoteArrayTypes4dim)remote;			
			BAsyncResultSendMethod<byte[][][][]> outerResult = new BAsyncResultSendMethod<byte[][][][]>(asyncResult, new BResult_RemoteArrayTypes4dim_getByte());			
			remoteT.async_getByte(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}