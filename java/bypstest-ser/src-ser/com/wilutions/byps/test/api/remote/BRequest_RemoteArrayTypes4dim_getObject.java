package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.io.Serializable;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteArrayTypes4dim_getObject implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 278996403L;
	
	@Override
	public int getRemoteId() { return 1557173854; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteArrayTypes4dimAsync remoteT = (RemoteArrayTypes4dimAsync)remote;			
			BAsyncResultSendMethod<java.lang.Object[][][][]> outerResult = new BAsyncResultSendMethod<java.lang.Object[][][][]>(asyncResult, new com.wilutions.byps.test.api.BResult_124584219());			
			remoteT.async_getObject(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
