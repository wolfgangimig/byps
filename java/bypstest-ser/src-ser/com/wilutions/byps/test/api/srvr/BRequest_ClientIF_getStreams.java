package com.wilutions.byps.test.api.srvr;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_ClientIF_getStreams implements BMethodRequest, BSerializable {

	public int ctrl;
	
	private final static long serialVersionUID = 865920738L;
	
	@Override
	public int getRemoteId() { return 1784257353; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final ClientIF remoteT = (ClientIF)remote;			
			BAsyncResultSendMethod<java.util.List<java.io.InputStream>> outerResult = new BAsyncResultSendMethod<java.util.List<java.io.InputStream>>(asyncResult, new BResult_ClientIF_getStreams());			
			remoteT.async_getStreams(ctrl, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
