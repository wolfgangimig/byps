﻿package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteStreams_setImage implements BMethodRequest, BSerializable {

	public java.io.InputStream istrm;
	
	private final static long serialVersionUID = 1831578632L;
	
	@Override
	public int getRemoteId() { return 2028487863; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteStreams remoteT = (RemoteStreams)remote;			
			BAsyncResultSendMethod<Object> outerResult = new BAsyncResultSendMethod<Object>(asyncResult, new BResult_RemoteStreams_setImage());			
			remoteT.async_setImage(istrm, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}