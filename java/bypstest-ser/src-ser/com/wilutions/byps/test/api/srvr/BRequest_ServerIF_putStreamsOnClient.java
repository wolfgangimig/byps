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
public final class BRequest_ServerIF_putStreamsOnClient implements BMethodRequest, Serializable {

	public java.util.List<java.io.InputStream> streams;
	
	private final static long serialVersionUID = 1367013829L;
	
	@Override
	public int getRemoteId() { return 1313562065; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final ServerIFAsync remoteT = (ServerIFAsync)remote;			
			BAsyncResultSendMethod<Object> outerResult = new BAsyncResultSendMethod<Object>(asyncResult, new BResult_ServerIF_putStreamsOnClient());			
			remoteT.async_putStreamsOnClient(streams, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
