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
public final class BRequest_RemoteEnums_getPlanet implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 627010462L;
	
	@Override
	public int getRemoteId() { return 359349400; }
	
	@Override
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteEnumsAsync __byps__remoteT = (RemoteEnumsAsync)__byps__remote;			
			BAsyncResultSendMethod<com.wilutions.byps.test.api.enu.EnumPlanets> __byps__outerResult = new BAsyncResultSendMethod<com.wilutions.byps.test.api.enu.EnumPlanets>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1042475995());			
			__byps__remoteT.async_getPlanet(__byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
