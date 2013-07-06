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
public final class BRequest_RemoteStreams_getTextStream implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 1083407988L;
	
	@Override
	public int getRemoteId() { return 2028487863; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteStreamsAsync remoteT = (RemoteStreamsAsync)remote;			
			BAsyncResultSendMethod<java.io.InputStream> outerResult = new BAsyncResultSendMethod<java.io.InputStream>(asyncResult, new com.wilutions.byps.test.api.BResult_15());			
			remoteT.async_getTextStream(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
