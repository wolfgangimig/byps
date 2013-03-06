package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteListTypes_getBoolean1 implements BMethodRequest, BSerializable {

	
	private final static long serialVersionUID = 1794077576L;
	
	@Override
	public int getRemoteId() { return 380156079; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteListTypes remoteT = (RemoteListTypes)remote;			
			BAsyncResultSendMethod<java.util.List<java.lang.Boolean>> outerResult = new BAsyncResultSendMethod<java.util.List<java.lang.Boolean>>(asyncResult, new BResult_RemoteListTypes_getBoolean1());			
			remoteT.async_getBoolean1(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
