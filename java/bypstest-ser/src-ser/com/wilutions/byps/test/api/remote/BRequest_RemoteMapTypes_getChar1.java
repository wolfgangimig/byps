﻿package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteMapTypes_getChar1 implements BMethodRequest, BSerializable {

	
	private final static long serialVersionUID = 1348312156L;
	
	@Override
	public int getRemoteId() { return 80483097; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteMapTypes remoteT = (RemoteMapTypes)remote;			
			BAsyncResultSendMethod<java.util.TreeMap<java.lang.Float,java.lang.Character>> outerResult = new BAsyncResultSendMethod<java.util.TreeMap<java.lang.Float,java.lang.Character>>(asyncResult, new BResult_RemoteMapTypes_getChar1());			
			remoteT.async_getChar1(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}