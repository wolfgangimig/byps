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
public final class BRequest_RemotePrimitiveTypes_getFloat implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 400008432L;
	
	@Override
	public int getRemoteId() { return 1341983932; }
	
	@Override
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemotePrimitiveTypesAsync __byps__remoteT = (RemotePrimitiveTypesAsync)__byps__remote;			
			BAsyncResultSendMethod<Float> __byps__outerResult = new BAsyncResultSendMethod<Float>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_7());			
			__byps__remoteT.async_getFloat(__byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
