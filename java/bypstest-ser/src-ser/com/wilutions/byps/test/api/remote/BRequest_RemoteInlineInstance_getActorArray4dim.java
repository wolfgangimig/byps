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
public final class BRequest_RemoteInlineInstance_getActorArray4dim implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 700005024L;
	
	@Override
	public int getRemoteId() { return 1206670536; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteInlineInstanceAsync remoteT = (RemoteInlineInstanceAsync)remote;			
			BAsyncResultSendMethod<com.wilutions.byps.test.api.inl.Actor[][][][]> outerResult = new BAsyncResultSendMethod<com.wilutions.byps.test.api.inl.Actor[][][][]>(asyncResult, new BResult_RemoteInlineInstance_getActorArray4dim());			
			remoteT.async_getActorArray4dim(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
