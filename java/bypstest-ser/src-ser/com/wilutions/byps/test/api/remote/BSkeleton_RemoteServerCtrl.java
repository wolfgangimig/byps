package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
 * This class provides a skeleton implementation of the interface RemoteServerCtrl.
 * Your interface implementation class has to be derived from this skeleton.
 * Either provide an asynchronous or a synchronous function in your subclass.
 * The framework calls only the asynchronous function.
 */
@SuppressWarnings("all")
public class BSkeleton_RemoteServerCtrl extends BSkeleton implements RemoteServerCtrlAsync {
	
	public final static long serialVersionUID = 1124545992L;
	
	@Override
	public void publishRemote(java.lang.String name, BRemote remote, boolean fowardToOtherServers) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_publishRemote(java.lang.String name, BRemote remote, boolean fowardToOtherServers, final BAsyncResult<Object> asyncResult) {
		try {
			publishRemote(name, remote, fowardToOtherServers);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public BRemote getPublishedRemote(java.lang.String name) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getPublishedRemote(java.lang.String name, final BAsyncResult<BRemote> asyncResult) {
		try {
			BRemote ret = getPublishedRemote(name);
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void removePublishedRemote(java.lang.String name) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_removePublishedRemote(java.lang.String name, final BAsyncResult<Object> asyncResult) {
		try {
			removePublishedRemote(name);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	
}
