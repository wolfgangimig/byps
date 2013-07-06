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
public final class BRequest_RemoteInlineInstance_getPoint2DMap implements BMethodRequest, Serializable {

	
	private final static long serialVersionUID = 1321082494L;
	
	@Override
	public int getRemoteId() { return 1206670536; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteInlineInstanceAsync remoteT = (RemoteInlineInstanceAsync)remote;			
			BAsyncResultSendMethod<java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D>> outerResult = new BAsyncResultSendMethod<java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Point2D>>(asyncResult, new com.wilutions.byps.test.api.BResult_1851881336());			
			remoteT.async_getPoint2DMap(outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
