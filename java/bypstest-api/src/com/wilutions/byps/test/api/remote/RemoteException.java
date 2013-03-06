package com.wilutions.byps.test.api.remote;

/**
 * 
 * @BRemote
 *
 */
public interface RemoteException {
	public void throwBException(int code, String msg);
	public void throwFirstException() throws FirstException;
	public void throwException(int what) throws FirstException, SecondException;
	
	/**
	 * Throw an exception that cannot be serialized.
	 * The exception message is wrapped into a BException.
	 */
	public void throwNullPointerException();
}
