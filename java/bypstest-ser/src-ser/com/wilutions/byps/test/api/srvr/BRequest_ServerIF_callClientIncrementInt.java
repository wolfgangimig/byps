﻿package com.wilutions.byps.test.api.srvr;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.io.Serializable;

/**
*/
@SuppressWarnings("all")
public final class BRequest_ServerIF_callClientIncrementInt implements BMethodRequest, Serializable {

	public int v;
	
	private final static long serialVersionUID = 1252575894L;
	
	@Override
	public int getRemoteId() { return 1313562065; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final ServerIFAsync remoteT = (ServerIFAsync)remote;			
			BAsyncResultSendMethod<Integer> outerResult = new BAsyncResultSendMethod<Integer>(asyncResult, new BResult_ServerIF_callClientIncrementInt());			
			remoteT.async_callClientIncrementInt(v, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
