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
public final class BRequest_RemoteInlineInstance_getPoint2DMap implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 1321082494L;
	
	@Override
	public int getRemoteId() { return 1206670536; }
	
	@Override
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteInlineInstanceAsync __byps__remoteT = (RemoteInlineInstanceAsync)__byps__remote;			
			BAsyncResultSendMethod<java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D>> __byps__outerResult = new BAsyncResultSendMethod<java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D>>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1851881336());			
			__byps__remoteT.async_getPoint2DMap(__byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
