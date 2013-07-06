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
public final class BRequest_RemoteReferences_getNode implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 655936732L;
	
	@Override
	public int getRemoteId() { return 2086824050; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteReferencesAsync remoteT = (RemoteReferencesAsync)remote;			
			BAsyncResultSendMethod<com.wilutions.byps.test.api.refs.Node> outerResult = new BAsyncResultSendMethod<com.wilutions.byps.test.api.refs.Node>(asyncResult, new com.wilutions.byps.test.api.BResult_9001());			
			remoteT.async_getNode(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
