package com.wilutions.byps.test.api.ver;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
public interface EvolveIF extends BRemote {

	/**
	*/
	public void setEvolve(Evolve obj) throws BException, InterruptedException;
	
	/**
	*/
	public Evolve getEvolve() throws BException, InterruptedException;
	
	/**
	*/
	public void setClient(EvolveIF partner) throws BException, InterruptedException;
	
	/**
	*/
	public EvolveIF getClient() throws BException, InterruptedException;
	
	/**
	*/
	public void sendEvolveToClient() throws BException, InterruptedException;
	
	
}
