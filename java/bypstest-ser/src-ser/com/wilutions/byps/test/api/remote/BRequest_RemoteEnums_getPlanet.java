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
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteEnumsAsync remoteT = (RemoteEnumsAsync)remote;			
			BAsyncResultSendMethod<com.wilutions.byps.test.api.enu.EnumPlanets> outerResult = new BAsyncResultSendMethod<com.wilutions.byps.test.api.enu.EnumPlanets>(asyncResult, new com.wilutions.byps.test.api.BResult_1042475995());			
			remoteT.async_getPlanet(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
