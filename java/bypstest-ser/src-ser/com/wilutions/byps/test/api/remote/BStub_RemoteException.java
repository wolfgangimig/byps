package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

public class BStub_RemoteException extends BStub implements RemoteException, java.io.Serializable {
	
	public final static long serialVersionUID = 1959416539L;
	
	public BStub_RemoteException(final BTransport transport) {
		super(transport);		
	}
	
	public void throwBException(int code, java.lang.String msg) throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_throwBException(code, msg, asyncResult);
		asyncResult.getResult();		
	}
	public void async_throwBException(int code, java.lang.String msg, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteException_throwBException req = new BRequest_RemoteException_throwBException();		
		req.code = code;
		req.msg = msg;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void throwFirstException() throws BException, InterruptedException, FirstException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_throwFirstException(asyncResult);
		try {
			asyncResult.getResult();			
		} 
		catch (BException e) {
			Throwable cause = e.getCause();
			if (cause != null) {
				if (cause instanceof FirstException) throw (FirstException)cause;
			}
			throw e;
		}
	}
	public void async_throwFirstException(final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteException_throwFirstException req = new BRequest_RemoteException_throwFirstException();		
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void throwException(int what) throws BException, InterruptedException, FirstException, SecondException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_throwException(what, asyncResult);
		try {
			asyncResult.getResult();			
		} 
		catch (BException e) {
			Throwable cause = e.getCause();
			if (cause != null) {
				if (cause instanceof FirstException) throw (FirstException)cause;
				if (cause instanceof SecondException) throw (SecondException)cause;
			}
			throw e;
		}
	}
	public void async_throwException(int what, final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteException_throwException req = new BRequest_RemoteException_throwException();		
		req.what = what;
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	public void throwNullPointerException() throws BException, InterruptedException {
		final BSyncResult<Object> asyncResult = new BSyncResult<Object>();		
		async_throwNullPointerException(asyncResult);
		asyncResult.getResult();		
	}
	public void async_throwNullPointerException(final BAsyncResult<Object> asyncResult) {
		BRequest_RemoteException_throwNullPointerException req = new BRequest_RemoteException_throwNullPointerException();		
		BAsyncResultReceiveMethod<Object> outerResult = new BAsyncResultReceiveMethod<Object>(asyncResult);
		transport.send(req, outerResult);
	}
	
	
}
