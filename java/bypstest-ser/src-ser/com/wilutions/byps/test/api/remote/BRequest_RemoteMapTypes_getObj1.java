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
public final class BRequest_RemoteMapTypes_getObj1 implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 1012973327L;
	
	@Override
	public int getRemoteId() { return 80483097; }
	
	@Override
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteMapTypesAsync __byps__remoteT = (RemoteMapTypesAsync)__byps__remote;			
			BAsyncResultSendMethod<java.util.Map<java.lang.String,java.lang.Object>> __byps__outerResult = new BAsyncResultSendMethod<java.util.Map<java.lang.String,java.lang.Object>>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1488550492());			
			__byps__remoteT.async_getObj1(__byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
