package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
public interface RemoteReferences extends BRemote {

	/**
	*/
	public com.wilutions.byps.test.api.refs.Node getNode() throws BException, InterruptedException;
	public void async_getNode(final BAsyncResult<com.wilutions.byps.test.api.refs.Node> asyncResult) ;
	
	/**
	*/
	public void setNode(com.wilutions.byps.test.api.refs.Node v) throws BException, InterruptedException;
	public void async_setNode(com.wilutions.byps.test.api.refs.Node v, final BAsyncResult<Object> asyncResult) ;
	
	
}
