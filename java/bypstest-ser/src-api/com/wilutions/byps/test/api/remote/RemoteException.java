package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

/**
*/
public interface RemoteException extends BRemote {

	/**
	*/
	public void throwBException(int code, java.lang.String msg) throws BException, InterruptedException;
	
	/**
	*/
	public void throwFirstException() throws BException, InterruptedException, FirstException;
	
	/**
	*/
	public void throwException(int what) throws BException, InterruptedException, FirstException, SecondException;
	
	/**
	 * Throw an exception that cannot be serialized.
	 * The exception message is wrapped into a BException.
	*/
	public void throwNullPointerException() throws BException, InterruptedException;
	
	
}
