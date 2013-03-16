package com.wilutions.byps.test.api.remote;

import com.wilutions.byps.BException;
import com.wilutions.byps.BRemote;

/**
 *
 */
public interface RemoteException extends BRemote {
	public void throwBException(int code, String msg) throws BException, InterruptedException;
	public void throwFirstException() throws FirstException, BException, InterruptedException;
	public void throwException(int what) throws FirstException, SecondException, BException, InterruptedException;
	
	/**
	 * Throw an exception that cannot be serialized.
	 * The exception message is wrapped into a BException.
	 */
	public void throwNullPointerException() throws BException, InterruptedException;
}
