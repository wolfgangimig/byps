package com.wilutions.byps.test.api.srvr;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.io.Serializable;

/**
*/
@SuppressWarnings("all")
public final class BRequest_ServerIF_getStreamsFromClient implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 1415283169L;
	
	@Override
	public int getRemoteId() { return 1313562065; }
	
	@Override
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final ServerIFAsync __byps__remoteT = (ServerIFAsync)__byps__remote;			
			BAsyncResultSendMethod<java.util.List<java.io.InputStream>> __byps__outerResult = new BAsyncResultSendMethod<java.util.List<java.io.InputStream>>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1218831438());			
			__byps__remoteT.async_getStreamsFromClient(__byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
