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
public final class BRequest_RemoteReferences_getNode implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 655936732L;
	
	@Override
	public int getRemoteId() { return 2086824050; }
	
	@Override
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteReferencesAsync __byps__remoteT = (RemoteReferencesAsync)__byps__remote;			
			BAsyncResultSendMethod<com.wilutions.byps.test.api.refs.Node> __byps__outerResult = new BAsyncResultSendMethod<com.wilutions.byps.test.api.refs.Node>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_9001());			
			__byps__remoteT.async_getNode(__byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
