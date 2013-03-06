package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
public interface RemoteStreams extends BRemote {

	/**
	*/
	public java.io.InputStream getImage() throws BException, InterruptedException;
	public void async_getImage(final BAsyncResult<java.io.InputStream> asyncResult) ;
	
	/**
	*/
	public void setImage(java.io.InputStream istrm) throws BException, InterruptedException;
	public void async_setImage(java.io.InputStream istrm, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public java.util.TreeMap<java.lang.Integer,java.io.InputStream> getImages() throws BException, InterruptedException;
	public void async_getImages(final BAsyncResult<java.util.TreeMap<java.lang.Integer,java.io.InputStream>> asyncResult) ;
	
	/**
	*/
	public void setImages(java.util.Map<java.lang.Integer,java.io.InputStream> istrms, int doNotReadStreamAtKey) throws BException, InterruptedException;
	public void async_setImages(java.util.Map<java.lang.Integer,java.io.InputStream> istrms, int doNotReadStreamAtKey, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public void throwLastException() throws BException, InterruptedException;
	public void async_throwLastException(final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public java.io.InputStream getTextStream() throws BException, InterruptedException;
	public void async_getTextStream(final BAsyncResult<java.io.InputStream> asyncResult) ;
	
	
}
