package com.wilutions.byps.test.api.srvr;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
public interface ServerIF extends BRemote {

	/**
	*/
	public int callClientIncrementInt(int v) throws BException, InterruptedException;
	
	/**
	*/
	public void setPartner(ClientIF client) throws BException, InterruptedException;
	
	/**
	*/
	public ClientIF getPartner() throws BException, InterruptedException;
	
	/**
	*/
	public java.util.List<java.io.InputStream> getStreamsFromClient() throws BException, InterruptedException;
	
	/**
	*/
	public void putStreamsOnClient(java.util.List<java.io.InputStream> streams) throws BException, InterruptedException;
	
	/**
	*/
	public void registerWithClientMap(int id) throws BException, InterruptedException;
	
	/**
	*/
	public ClientIF getClient(int id) throws BException, InterruptedException;
	
	/**
	*/
	public java.util.Set<java.lang.Integer> getClientIds() throws BException, InterruptedException;
	
	
}
