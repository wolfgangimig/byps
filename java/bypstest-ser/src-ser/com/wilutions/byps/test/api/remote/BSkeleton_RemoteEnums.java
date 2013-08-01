﻿package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED BY class com.wilutions.byps.gen.j.GenRemoteSkeleton DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
 * This class provides a skeleton implementation of the interface RemoteEnums.
 * Your interface implementation class has to be derived from this skeleton.
 * Either provide an asynchronous or a synchronous function in your subclass.
 * The framework calls only the asynchronous function.
 */
@SuppressWarnings("all")
public class BSkeleton_RemoteEnums extends BSkeleton implements RemoteEnumsAsync {
	
	public final static long serialVersionUID = 359349400L;
	
	public com.wilutions.byps.test.api.enu.EnumPlanets getPlanet() throws RemoteException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	public void async_getPlanet(final BAsyncResult<com.wilutions.byps.test.api.enu.EnumPlanets> asyncResult) {
		try {
			com.wilutions.byps.test.api.enu.EnumPlanets ret = getPlanet();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	public void setPlanet(com.wilutions.byps.test.api.enu.EnumPlanets planet) throws RemoteException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	public void async_setPlanet(com.wilutions.byps.test.api.enu.EnumPlanets planet, final BAsyncResult<Object> asyncResult) {
		try {
			setPlanet(planet);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	
}
