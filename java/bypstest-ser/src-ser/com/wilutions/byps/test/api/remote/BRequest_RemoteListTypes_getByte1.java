﻿package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class com.wilutions.byps.gen.j.GenApiClass DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.io.Serializable;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteListTypes_getByte1 implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 1319541530L;
	
	public int getRemoteId() { return 380156079; }
	
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteListTypesAsync __byps__remoteT = (RemoteListTypesAsync)__byps__remote;			
			BAsyncResultSendMethod<java.util.List<java.lang.Byte>> __byps__outerResult = new BAsyncResultSendMethod<java.util.List<java.lang.Byte>>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1059148284());			
			__byps__remoteT.async_getByte1(__byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
