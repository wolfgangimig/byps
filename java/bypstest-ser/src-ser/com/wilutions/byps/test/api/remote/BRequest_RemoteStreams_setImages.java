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
public final class BRequest_RemoteStreams_setImages implements BMethodRequest, Serializable {

	public java.util.Map<java.lang.Integer,java.io.InputStream> istrms;
	public int doNotReadStreamAtKey;
	
	private final static long serialVersionUID = 944362859L;
	
	@Override
	public int getRemoteId() { return 2028487863; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteStreamsAsync remoteT = (RemoteStreamsAsync)remote;			
			BAsyncResultSendMethod<Object> outerResult = new BAsyncResultSendMethod<Object>(asyncResult, new BResult_RemoteStreams_setImages());			
			remoteT.async_setImages(istrms, doNotReadStreamAtKey, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
