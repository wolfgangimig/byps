package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
 * This class provides a skeleton implementation of the interface RemoteStreams.
 * Your interface implementation class has to be derived from this skeleton.
 * Either provide an asynchronous or a synchronous function in your subclass.
 * The framework calls only the asynchronous function.
 */
@SuppressWarnings("all")
public class BSkeleton_RemoteStreams extends BSkeleton implements RemoteStreamsAsync {
	
	public final static long serialVersionUID = 2028487863L;
	
	@Override
	public java.io.InputStream getImage() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getImage(final BAsyncResult<java.io.InputStream> asyncResult) {
		try {
			java.io.InputStream ret = getImage();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setImage(java.io.InputStream istrm) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setImage(java.io.InputStream istrm, final BAsyncResult<Object> asyncResult) {
		try {
			setImage(istrm);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public java.util.TreeMap<java.lang.Integer,java.io.InputStream> getImages() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getImages(final BAsyncResult<java.util.TreeMap<java.lang.Integer,java.io.InputStream>> asyncResult) {
		try {
			java.util.TreeMap<java.lang.Integer,java.io.InputStream> ret = getImages();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void setImages(java.util.Map<java.lang.Integer,java.io.InputStream> istrms, int doNotReadStreamAtKey) throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_setImages(java.util.Map<java.lang.Integer,java.io.InputStream> istrms, int doNotReadStreamAtKey, final BAsyncResult<Object> asyncResult) {
		try {
			setImages(istrms, doNotReadStreamAtKey);
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public void throwLastException() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_throwLastException(final BAsyncResult<Object> asyncResult) {
		try {
			throwLastException();
			asyncResult.setAsyncResult(null, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	@Override
	public java.io.InputStream getTextStream() throws BException, InterruptedException {
		throw new BException(BException.UNSUPPORTED_METHOD, "");
	}
	@Override
	public void async_getTextStream(final BAsyncResult<java.io.InputStream> asyncResult) {
		try {
			java.io.InputStream ret = getTextStream();
			asyncResult.setAsyncResult(ret, null);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
		}
	}
	
	
}
