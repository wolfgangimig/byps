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
public final class BRequest_RemoteInlineInstance_getActor implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 261822861L;
	
	@Override
	public int getRemoteId() { return 1206670536; }
	
	@Override
	public void execute(BRemote __byps__remote, BAsyncResult<Object> __byps__asyncResult) throws Throwable {
		try {
			final RemoteInlineInstanceAsync __byps__remoteT = (RemoteInlineInstanceAsync)__byps__remote;			
			BAsyncResultSendMethod<com.wilutions.byps.test.api.inl.Actor> __byps__outerResult = new BAsyncResultSendMethod<com.wilutions.byps.test.api.inl.Actor>(__byps__asyncResult, new com.wilutions.byps.test.api.BResult_171948703());			
			__byps__remoteT.async_getActor(__byps__outerResult);
		} catch (Throwable e) {
			__byps__asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
