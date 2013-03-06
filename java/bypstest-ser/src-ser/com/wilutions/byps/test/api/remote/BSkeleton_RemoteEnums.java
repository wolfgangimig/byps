package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
 * This class provides a skeleton implementation of the interface RemoteEnums.
 * Your interface implementation class has to be derived from this skeleton.
 * Either provide an asynchronous or a synchronous function in your subclass.
 * The framework calls only the asynchronous function.
 */
@SuppressWarnings("all")
public class BSkeleton_RemoteEnums extends BSkeleton implements RemoteEnums {
	
	public final static long serialVersionUID = 359349400L;
	
	@Override
	public com.wilutions.byps.test.api.enu.EnumPlanets getPlanet() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getPlanet(final BAsyncResult<com.wilutions.byps.test.api.enu.EnumPlanets> asyncResult) {
		try {
			com.wilutions.byps.test.api.enu.EnumPlanets ret = getPlanet();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setPlanet(com.wilutions.byps.test.api.enu.EnumPlanets planet) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setPlanet(com.wilutions.byps.test.api.enu.EnumPlanets planet, final BAsyncResult<Object> asyncResult) {
		try {
			setPlanet(planet);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	
}
