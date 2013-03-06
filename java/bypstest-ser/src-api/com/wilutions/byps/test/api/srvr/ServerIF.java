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
	public void async_callClientIncrementInt(int v, final BAsyncResult<Integer> asyncResult) ;
	
	/**
	*/
	public void setPartner(ClientIF client) throws BException, InterruptedException;
	public void async_setPartner(ClientIF client, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public ClientIF getPartner() throws BException, InterruptedException;
	public void async_getPartner(final BAsyncResult<ClientIF> asyncResult) ;
	
	/**
	*/
	public java.util.List<java.io.InputStream> getStreamsFromClient() throws BException, InterruptedException;
	public void async_getStreamsFromClient(final BAsyncResult<java.util.List<java.io.InputStream>> asyncResult) ;
	
	/**
	*/
	public void putStreamsOnClient(java.util.List<java.io.InputStream> streams) throws BException, InterruptedException;
	public void async_putStreamsOnClient(java.util.List<java.io.InputStream> streams, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public void registerWithClientMap(int id) throws BException, InterruptedException;
	public void async_registerWithClientMap(int id, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public ClientIF getClient(int id) throws BException, InterruptedException;
	public void async_getClient(int id, final BAsyncResult<ClientIF> asyncResult) ;
	
	/**
	*/
	public java.util.Set<java.lang.Integer> getClientIds() throws BException, InterruptedException;
	public void async_getClientIds(final BAsyncResult<java.util.Set<java.lang.Integer>> asyncResult) ;
	
	
}
