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
public final class BRequest_RemoteArrayTypes4dim_getDouble implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 581586209L;
	
	@Override
	public int getRemoteId() { return 1557173854; }
	
	@Override
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteArrayTypes4dimAsync __byps__remoteT = (RemoteArrayTypes4dimAsync)__byps__remote;			
			BAsyncResultSendMethod<double[][][][]> __byps__outerResult = new BAsyncResultSendMethod<double[][][][]>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_2087445849());			
			__byps__remoteT.async_getDouble(__byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
