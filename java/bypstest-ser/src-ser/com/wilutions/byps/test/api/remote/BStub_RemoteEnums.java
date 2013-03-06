package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

public class BStub_RemoteEnums extends BStub implements RemoteEnums, java.io.Serializable {
	
	public final static long serialVersionUID = 359349400L;
	
	public BStub_RemoteEnums(final BTransport transport) {
		super(transport);		
	}
	
	public com.wilutions.byps.test.api.enu.EnumPlanets getPlanet() throws BException, InterruptedException {
		final BSyncResult<com.wilutions.byps.test.api.enu.EnumPlanets> asyncResult = new BSyncResult<com.wilutions.byps.test.api.enu.EnumPlanets>();		
		async_getPlanet(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getPlanet(final BAsyncResult<com.wilutions.byps.test.api.enu.EnumPlanets> asyncResult) {
		BRequest_RemoteEnums_getPlanet req = new BRequest_RemoteEnums_getPlanet();		
		BAsyncResultReceiveMethod<com.wilutions.byps.test.api.enu.EnumPlanets> outerResult = new BAsyncResultReceiveMethod<com.wilutions.byps.test.api.enu.EnumPlanets>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setPlanet(com.wilutions.byps.test.api.enu.EnumPlanets planet) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setPlanet(planet, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setPlanet(com.wilutions.byps.test.api.enu.EnumPlanets planet, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteEnums_setPlanet req = new BRequest_RemoteEnums_setPlanet();		
		req.planet = planet;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	
}
