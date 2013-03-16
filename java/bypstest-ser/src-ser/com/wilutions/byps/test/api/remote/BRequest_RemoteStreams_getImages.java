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
public final class BRequest_RemoteStreams_getImages implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 1158979935L;
	
	@Override
	public int getRemoteId() { return 2028487863; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteStreamsAsync remoteT = (RemoteStreamsAsync)remote;			
			BAsyncResultSendMethod<java.util.TreeMap<java.lang.Integer,java.io.InputStream>> outerResult = new BAsyncResultSendMethod<java.util.TreeMap<java.lang.Integer,java.io.InputStream>>(asyncResult, new BResult_RemoteStreams_getImages());			
			remoteT.async_getImages(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
