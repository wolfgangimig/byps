package com.wilutions.byps.test.api.srvr;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
 * This class provides a skeleton implementation of the interface ServerIF.
 * Your interface implementation class has to be derived from this skeleton.
 * Either provide an asynchronous or a synchronous function in your subclass.
 * The framework calls only the asynchronous function.
 */
@SuppressWarnings("all")
public class BSkeleton_ServerIF extends BSkeleton implements ServerIFAsync {
	
	public final static long serialVersionUID = 1313562065L;
	
	@Override
	public int callClientIncrementInt(int v) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_callClientIncrementInt(int v, final BAsyncResult<Integer> asyncResult) {
		try {
			int ret = callClientIncrementInt(v);
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setPartner(ClientIF client) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setPartner(ClientIF client, final BAsyncResult<Object> asyncResult) {
		try {
			setPartner(client);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public ClientIF getPartner() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getPartner(final BAsyncResult<ClientIF> asyncResult) {
		try {
			ClientIF ret = getPartner();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public java.util.List<java.io.InputStream> getStreamsFromClient() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getStreamsFromClient(final BAsyncResult<java.util.List<java.io.InputStream>> asyncResult) {
		try {
			java.util.List<java.io.InputStream> ret = getStreamsFromClient();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void putStreamsOnClient(java.util.List<java.io.InputStream> streams) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_putStreamsOnClient(java.util.List<java.io.InputStream> streams, final BAsyncResult<Object> asyncResult) {
		try {
			putStreamsOnClient(streams);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void registerWithClientMap(int id) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_registerWithClientMap(int id, final BAsyncResult<Object> asyncResult) {
		try {
			registerWithClientMap(id);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public ClientIF getClient(int id) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getClient(int id, final BAsyncResult<ClientIF> asyncResult) {
		try {
			ClientIF ret = getClient(id);
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public java.util.Set<java.lang.Integer> getClientIds() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getClientIds(final BAsyncResult<java.util.Set<java.lang.Integer>> asyncResult) {
		try {
			java.util.Set<java.lang.Integer> ret = getClientIds();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public int callClientParallel(int v) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_callClientParallel(int v, final BAsyncResult<Integer> asyncResult) {
		try {
			int ret = callClientParallel(v);
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	
}
