package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
 * This class provides a skeleton implementation of the interface RemoteReferences.
 * Your interface implementation class has to be derived from this skeleton.
 * Either provide an asynchronous or a synchronous function in your subclass.
 * The framework calls only the asynchronous function.
 */
@SuppressWarnings("all")
public class BSkeleton_RemoteReferences extends BSkeleton implements RemoteReferencesAsync {
	
	public final static long serialVersionUID = 2086824050L;
	
	@Override
	public com.wilutions.byps.test.api.refs.Node getNode() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getNode(final BAsyncResult<com.wilutions.byps.test.api.refs.Node> asyncResult) {
		try {
			com.wilutions.byps.test.api.refs.Node ret = getNode();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setNode(com.wilutions.byps.test.api.refs.Node v) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setNode(com.wilutions.byps.test.api.refs.Node v, final BAsyncResult<Object> asyncResult) {
		try {
			setNode(v);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	
}
