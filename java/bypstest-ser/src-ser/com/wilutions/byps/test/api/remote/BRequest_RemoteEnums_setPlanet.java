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
public final class BRequest_RemoteEnums_setPlanet implements BMethodRequest, Serializable {

	public com.wilutions.byps.test.api.enu.EnumPlanets planet;
	
	private final static long serialVersionUID = 412393386L;
	
	@Override
	public int getRemoteId() { return 359349400; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteEnumsAsync remoteT = (RemoteEnumsAsync)remote;			
			BAsyncResultSendMethod<Object> outerResult = new BAsyncResultSendMethod<Object>(asyncResult, new BResult_RemoteEnums_setPlanet());			
			remoteT.async_setPlanet(planet, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
