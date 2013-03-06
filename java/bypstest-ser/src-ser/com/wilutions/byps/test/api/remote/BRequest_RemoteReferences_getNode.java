package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteReferences_getNode implements BMethodRequest, BSerializable {

	
	private final static long serialVersionUID = 655936732L;
	
	@Override
	public int getRemoteId() { return 2086824050; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteReferences remoteT = (RemoteReferences)remote;			
			BAsyncResultSendMethod<com.wilutions.byps.test.api.refs.Node> outerResult = new BAsyncResultSendMethod<com.wilutions.byps.test.api.refs.Node>(asyncResult, new BResult_RemoteReferences_getNode());			
			remoteT.async_getNode(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
