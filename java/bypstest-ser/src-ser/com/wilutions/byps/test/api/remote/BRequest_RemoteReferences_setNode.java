package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteReferences_setNode implements BMethodRequest, BSerializable {

	public com.wilutions.byps.test.api.refs.Node v;
	
	private final static long serialVersionUID = 1404172848L;
	
	@Override
	public int getRemoteId() { return 2086824050; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteReferences remoteT = (RemoteReferences)remote;			
			BAsyncResultSendMethod<Object> outerResult = new BAsyncResultSendMethod<Object>(asyncResult, new BResult_RemoteReferences_setNode());			
			remoteT.async_setNode(v, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
