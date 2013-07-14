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
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteStreamsAsync __byps__remoteT = (RemoteStreamsAsync)__byps__remote;			
			BAsyncResultSendMethod<java.util.TreeMap<java.lang.Integer,java.io.InputStream>> __byps__outerResult = new BAsyncResultSendMethod<java.util.TreeMap<java.lang.Integer,java.io.InputStream>>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_476459792());			
			__byps__remoteT.async_getImages(__byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
