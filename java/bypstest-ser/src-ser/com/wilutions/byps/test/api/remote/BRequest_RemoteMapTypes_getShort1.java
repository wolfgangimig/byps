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
public final class BRequest_RemoteMapTypes_getShort1 implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 1610481740L;
	
	@Override
	public int getRemoteId() { return 80483097; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteMapTypesAsync remoteT = (RemoteMapTypesAsync)remote;			
			BAsyncResultSendMethod<java.util.Map<java.lang.Long,java.lang.Short>> outerResult = new BAsyncResultSendMethod<java.util.Map<java.lang.Long,java.lang.Short>>(asyncResult, new BResult_RemoteMapTypes_getShort1());			
			remoteT.async_getShort1(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
