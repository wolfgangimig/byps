package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
 * @BRemote 
*/
public interface RemoteEnums extends BRemote {

	/**
	*/
	public com.wilutions.byps.test.api.enu.EnumPlanets getPlanet() throws BException, InterruptedException;
	public void async_getPlanet(final BAsyncResult<com.wilutions.byps.test.api.enu.EnumPlanets> asyncResult) ;
	
	/**
	*/
	public void setPlanet(com.wilutions.byps.test.api.enu.EnumPlanets planet) throws BException, InterruptedException;
	public void async_setPlanet(com.wilutions.byps.test.api.enu.EnumPlanets planet, final BAsyncResult<Object> asyncResult) ;
	
	
}
