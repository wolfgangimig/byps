package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
 * @BRemote 
*/
public interface RemoteException extends BRemote {

	/**
	*/
	public void throwBException(int code, java.lang.String msg) throws BException, InterruptedException;
	public void async_throwBException(int code, java.lang.String msg, final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public void throwFirstException() throws BException, InterruptedException, FirstException;
	public void async_throwFirstException(final BAsyncResult<Object> asyncResult) ;
	
	/**
	*/
	public void throwException(int what) throws BException, InterruptedException, FirstException, SecondException;
	public void async_throwException(int what, final BAsyncResult<Object> asyncResult) ;
	
	/**
	 * Throw an exception that cannot be serialized.
	 * The exception message is wrapped into a BException.
	*/
	public void throwNullPointerException() throws BException, InterruptedException;
	public void async_throwNullPointerException(final BAsyncResult<Object> asyncResult) ;
	
	
}
