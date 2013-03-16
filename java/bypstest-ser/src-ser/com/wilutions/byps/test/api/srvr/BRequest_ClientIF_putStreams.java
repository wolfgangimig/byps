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
public final class BRequest_ClientIF_putStreams implements BMethodRequest, Serializable {

	public java.util.List<java.io.InputStream> strm;
	public int ctrl;
	
	private final static long serialVersionUID = 242798857L;
	
	@Override
	public int getRemoteId() { return 1784257353; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final ClientIFAsync remoteT = (ClientIFAsync)remote;			
			BAsyncResultSendMethod<Object> outerResult = new BAsyncResultSendMethod<Object>(asyncResult, new BResult_ClientIF_putStreams());			
			remoteT.async_putStreams(strm, ctrl, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
