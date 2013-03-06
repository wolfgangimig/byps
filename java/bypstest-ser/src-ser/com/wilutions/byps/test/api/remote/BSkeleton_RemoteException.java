package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
 * This class provides a skeleton implementation of the interface RemoteException.
 * Your interface implementation class has to be derived from this skeleton.
 * Either provide an asynchronous or a synchronous function in your subclass.
 * The framework calls only the asynchronous function.
 */
@SuppressWarnings("all")
public class BSkeleton_RemoteException extends BSkeleton implements RemoteException {
	
	public final static long serialVersionUID = 1959416539L;
	
	@Override
	public void throwBException(int code, java.lang.String msg) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_throwBException(int code, java.lang.String msg, final BAsyncResult<Object> asyncResult) {
		try {
			throwBException(code, msg);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void throwFirstException() throws BException, InterruptedException, FirstException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_throwFirstException(final BAsyncResult<Object> asyncResult) {
		try {
			throwFirstException();
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void throwException(int what) throws BException, InterruptedException, FirstException, SecondException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_throwException(int what, final BAsyncResult<Object> asyncResult) {
		try {
			throwException(what);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void throwNullPointerException() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_throwNullPointerException(final BAsyncResult<Object> asyncResult) {
		try {
			throwNullPointerException();
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	
}
