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
public final class BRequest_RemoteListTypes_getString1 implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 1173060367L;
	
	@Override
	public int getRemoteId() { return 380156079; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteListTypesAsync remoteT = (RemoteListTypesAsync)remote;			
			BAsyncResultSendMethod<java.util.List<java.lang.String>> outerResult = new BAsyncResultSendMethod<java.util.List<java.lang.String>>(asyncResult, new com.wilutions.byps.test.api.BResult_2123584667());			
			remoteT.async_getString1(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
