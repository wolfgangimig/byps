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
public final class BRequest_ClientIF_putStreams implements BMethodRequest, Serializable {

	public java.util.List<java.io.InputStream> strm;
	public int ctrl;
	
	private final static long serialVersionUID = 242798857L;
	
	@Override
	public int getRemoteId() { return 1784257353; }
	
	@Override
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final ClientIFAsync __byps__remoteT = (ClientIFAsync)__byps__remote;			
			BAsyncResultSendMethod<Object> __byps__outerResult = new BAsyncResultSendMethod<Object>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_19());			
			__byps__remoteT.async_putStreams(strm, ctrl, __byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
