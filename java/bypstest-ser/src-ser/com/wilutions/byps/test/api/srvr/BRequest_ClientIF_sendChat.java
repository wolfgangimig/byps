package com.wilutions.byps.test.api.srvr;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_ClientIF_sendChat implements BMethodRequest, BSerializable {

	public ChatStructure cs;
	
	private final static long serialVersionUID = 1352392091L;
	
	@Override
	public int getRemoteId() { return 1784257353; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final ClientIF remoteT = (ClientIF)remote;			
			BAsyncResultSendMethod<ChatStructure> outerResult = new BAsyncResultSendMethod<ChatStructure>(asyncResult, new BResult_ClientIF_sendChat());			
			remoteT.async_sendChat(cs, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
