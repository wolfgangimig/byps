﻿package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteArrayTypes4dim_setObject implements BMethodRequest, BSerializable {

	public java.lang.Object[][][][] v;
	
	private final static long serialVersionUID = 493613479L;
	
	@Override
	public int getRemoteId() { return 1557173854; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteArrayTypes4dim remoteT = (RemoteArrayTypes4dim)remote;			
			BAsyncResultSendMethod<Object> outerResult = new BAsyncResultSendMethod<Object>(asyncResult, new BResult_RemoteArrayTypes4dim_setObject());			
			remoteT.async_setObject(v, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}