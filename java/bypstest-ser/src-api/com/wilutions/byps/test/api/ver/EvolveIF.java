package com.wilutions.byps.test.api.ver;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
 * @BRemote 
*/
public interface EvolveIF extends BRemote {

	/**
	*/
	public void setEvolve(Evolve obj) throws BException, InterruptedException;
	public void async_setEvolve(Evolve obj, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public Evolve getEvolve() throws BException, InterruptedException;
	public void async_getEvolve(final BAsyncResult<Evolve> asyncResult) ;
	
	/**
	*/
	public void setClient(EvolveIF partner) throws BException, InterruptedException;
	public void async_setClient(EvolveIF partner, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public EvolveIF getClient() throws BException, InterruptedException;
	public void async_getClient(final BAsyncResult<EvolveIF> asyncResult) ;
	
	/**
	*/
	public void sendEvolveToClient() throws BException, InterruptedException;
	public void async_sendEvolveToClient(final BAsyncResult<Object> asyncResult) ;
	
	
}
