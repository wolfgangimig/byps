package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.io.Serializable;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemoteMapTypes_getChar1 implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 1348312156L;
	
	@Override
	public int getRemoteId() { return 80483097; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteMapTypesAsync remoteT = (RemoteMapTypesAsync)remote;			
			BAsyncResultSendMethod<java.util.TreeMap<java.lang.Float,java.lang.Character>> outerResult = new BAsyncResultSendMethod<java.util.TreeMap<java.lang.Float,java.lang.Character>>(asyncResult, new com.wilutions.byps.test.api.BResult_8789515());			
			remoteT.async_getChar1(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
