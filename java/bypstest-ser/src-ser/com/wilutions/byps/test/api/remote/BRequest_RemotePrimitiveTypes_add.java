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
public final class BRequest_RemotePrimitiveTypes_add implements BMethodRequest, Serializable {

	public int a;
	public int b;
	
	private final static long serialVersionUID = 1073583639L;
	
	@Override
	public int getRemoteId() { return 1341983932; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemotePrimitiveTypesAsync remoteT = (RemotePrimitiveTypesAsync)remote;			
			BAsyncResultSendMethod<Integer> outerResult = new BAsyncResultSendMethod<Integer>(asyncResult, new com.wilutions.byps.test.api.BResult_5());			
			remoteT.async_add(a, b, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
