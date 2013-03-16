package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

public interface RemoteExceptionAsync extends RemoteException {

	public void async_throwBException(int code, java.lang.String msg, final BAsyncResult<Object> asyncResult) ;
	
	public void async_throwFirstException(final BAsyncResult<Object> asyncResult) ;
	
	public void async_throwException(int what, final BAsyncResult<Object> asyncResult) ;
	
	public void async_throwNullPointerException(final BAsyncResult<Object> asyncResult) ;
	
	
}
