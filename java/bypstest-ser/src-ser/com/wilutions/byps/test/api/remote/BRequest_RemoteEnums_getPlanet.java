package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteEnums_getPlanet implements BMethodRequest, BSerializable {

	
	private final static long serialVersionUID = 627010462L;
	
	@Override
	public int getRemoteId() { return 359349400; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteEnums remoteT = (RemoteEnums)remote;			
			BAsyncResultSendMethod<com.wilutions.byps.test.api.enu.EnumPlanets> outerResult = new BAsyncResultSendMethod<com.wilutions.byps.test.api.enu.EnumPlanets>(asyncResult, new BResult_RemoteEnums_getPlanet());			
			remoteT.async_getPlanet(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
