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
public final class BRequest_RemoteListTypes_getInt3 implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 874047763L;
	
	@Override
	public int getRemoteId() { return 380156079; }
	
	@Override
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteListTypesAsync __byps__remoteT = (RemoteListTypesAsync)__byps__remote;			
			BAsyncResultSendMethod<java.util.List<java.util.List<java.lang.Integer>>> __byps__outerResult = new BAsyncResultSendMethod<java.util.List<java.util.List<java.lang.Integer>>>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_1746702954());			
			__byps__remoteT.async_getInt3(__byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
