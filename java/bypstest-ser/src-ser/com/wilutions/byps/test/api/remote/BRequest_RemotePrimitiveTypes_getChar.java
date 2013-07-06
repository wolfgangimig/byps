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
public final class BRequest_RemotePrimitiveTypes_getChar implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 2091019842L;
	
	@Override
	public int getRemoteId() { return 1341983932; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemotePrimitiveTypesAsync remoteT = (RemotePrimitiveTypesAsync)remote;			
			BAsyncResultSendMethod<Character> outerResult = new BAsyncResultSendMethod<Character>(asyncResult, new com.wilutions.byps.test.api.BResult_4());			
			remoteT.async_getChar(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
