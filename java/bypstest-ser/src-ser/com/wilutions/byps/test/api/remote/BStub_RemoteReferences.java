package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

public class BStub_RemoteReferences extends BStub implements RemoteReferences, java.io.Serializable {
	
	public final static long serialVersionUID = 2086824050L;
	
	public BStub_RemoteReferences(final BTransport transport) {
		super(transport);		
	}
	
	public com.wilutions.byps.test.api.refs.Node getNode() throws BException, InterruptedException {
		final BSyncResult<com.wilutions.byps.test.api.refs.Node> asyncResult = new BSyncResult<com.wilutions.byps.test.api.refs.Node>();		
		async_getNode(asyncResult);
		return asyncResult.getResult();		
	}
	public void async_getNode(final BAsyncResult<com.wilutions.byps.test.api.refs.Node> asyncResult) {
		BRequest_RemoteReferences_getNode req = new BRequest_RemoteReferences_getNode();		
		BAsyncResultReceiveMethod<com.wilutions.byps.test.api.refs.Node> outerResult = new BAsyncResultReceiveMethod<com.wilutions.byps.test.api.refs.Node>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void setNode(com.wilutions.byps.test.api.refs.Node v) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_setNode(v, asyncResult);
		asyncResult.getResult();		
	}
	public void async_setNode(com.wilutions.byps.test.api.refs.Node v, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteReferences_setNode req = new BRequest_RemoteReferences_setNode();		
		req.v = v;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	
}
