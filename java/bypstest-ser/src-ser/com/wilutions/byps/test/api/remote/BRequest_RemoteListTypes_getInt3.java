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
public final class BRequest_RemoteListTypes_getInt3 implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 874047763L;
	
	@Override
	public int getRemoteId() { return 380156079; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteListTypesAsync remoteT = (RemoteListTypesAsync)remote;			
			BAsyncResultSendMethod<java.util.List<java.util.List<java.lang.Integer>>> outerResult = new BAsyncResultSendMethod<java.util.List<java.util.List<java.lang.Integer>>>(asyncResult, new com.wilutions.byps.test.api.BResult_1746702954());			
			remoteT.async_getInt3(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
