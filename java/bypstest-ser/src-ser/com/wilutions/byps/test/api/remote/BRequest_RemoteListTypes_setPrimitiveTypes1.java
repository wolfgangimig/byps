﻿package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteListTypes_setPrimitiveTypes1 implements BMethodRequest, BSerializable {

	public java.util.List<com.wilutions.byps.test.api.prim.PrimitiveTypes> primitiveTypes1;
	
	private final static long serialVersionUID = 1434361404L;
	
	@Override
	public int getRemoteId() { return 380156079; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteListTypes remoteT = (RemoteListTypes)remote;			
			BAsyncResultSendMethod<Object> outerResult = new BAsyncResultSendMethod<Object>(asyncResult, new BResult_RemoteListTypes_setPrimitiveTypes1());			
			remoteT.async_setPrimitiveTypes1(primitiveTypes1, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}