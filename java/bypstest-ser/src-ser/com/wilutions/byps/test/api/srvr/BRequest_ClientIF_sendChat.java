﻿package com.wilutions.byps.test.api.srvr;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.io.Serializable;

/**
*/
@SuppressWarnings("all")
public final class BRequest_ClientIF_sendChat implements BMethodRequest, Serializable {

	public ChatStructure cs;
	
	private final static long serialVersionUID = 1352392091L;
	
	@Override
	public int getRemoteId() { return 1784257353; }
	
	@Override
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final ClientIFAsync __byps__remoteT = (ClientIFAsync)__byps__remote;			
			BAsyncResultSendMethod<ChatStructure> __byps__outerResult = new BAsyncResultSendMethod<ChatStructure>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_7007());			
			__byps__remoteT.async_sendChat(cs, __byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
