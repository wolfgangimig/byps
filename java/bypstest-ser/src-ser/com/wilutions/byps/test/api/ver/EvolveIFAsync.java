package com.wilutions.byps.test.api.ver;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

public interface EvolveIFAsync extends EvolveIF {

	public void async_setEvolve(Evolve obj, final BAsyncResult<Object> asyncResult) ;
	
	public void async_getEvolve(final BAsyncResult<Evolve> asyncResult) ;
	
	public void async_setClient(EvolveIF partner, final BAsyncResult<Object> asyncResult) ;
	
	public void async_getClient(final BAsyncResult<EvolveIF> asyncResult) ;
	
	public void async_sendEvolveToClient(final BAsyncResult<Object> asyncResult) ;
	
	
}
