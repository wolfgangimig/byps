package com.wilutions.byps.test.api.srvr;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
 * This class provides a skeleton implementation of the interface ClientIF.
 * Your interface implementation class has to be derived from this skeleton.
 * Either provide an asynchronous or a synchronous function in your subclass.
 * The framework calls only the asynchronous function.
 */
@SuppressWarnings("all")
public class BSkeleton_ClientIF extends BSkeleton implements ClientIF {
	
	public final static long serialVersionUID = 1784257353L;
	
	@Override
	public int incrementInt(int a) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_incrementInt(int a, final BAsyncResult<Integer> asyncResult) {
		try {
			int ret = incrementInt(a);
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public java.util.List<java.io.InputStream> getStreams(int ctrl) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getStreams(int ctrl, final BAsyncResult<java.util.List<java.io.InputStream>> asyncResult) {
		try {
			java.util.List<java.io.InputStream> ret = getStreams(ctrl);
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void putStreams(java.util.List<java.io.InputStream> strm, int ctrl) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_putStreams(java.util.List<java.io.InputStream> strm, int ctrl, final BAsyncResult<Object> asyncResult) {
		try {
			putStreams(strm, ctrl);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public ChatStructure sendChat(ChatStructure cs) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_sendChat(ChatStructure cs, final BAsyncResult<ChatStructure> asyncResult) {
		try {
			ChatStructure ret = sendChat(cs);
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	
}
