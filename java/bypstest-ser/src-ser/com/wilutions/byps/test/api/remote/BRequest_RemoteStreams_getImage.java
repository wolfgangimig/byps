package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteStreams_getImage implements BMethodRequest, BSerializable {

	
	private final static long serialVersionUID = 1902276204L;
	
	@Override
	public int getRemoteId() { return 2028487863; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteStreams remoteT = (RemoteStreams)remote;			
			BAsyncResultSendMethod<java.io.InputStream> outerResult = new BAsyncResultSendMethod<java.io.InputStream>(asyncResult, new BResult_RemoteStreams_getImage());			
			remoteT.async_getImage(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
