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
public final class BRequest_RemoteException_throwNullPointerException implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 1888829108L;
	
	@Override
	public int getRemoteId() { return 1959416539; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteExceptionAsync remoteT = (RemoteExceptionAsync)remote;			
			BAsyncResultSendMethod<Object> outerResult = new BAsyncResultSendMethod<Object>(asyncResult, new BResult_RemoteException_throwNullPointerException());			
			remoteT.async_throwNullPointerException(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
