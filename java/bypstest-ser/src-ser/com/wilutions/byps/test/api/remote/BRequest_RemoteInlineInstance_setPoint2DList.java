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
public final class BRequest_RemoteInlineInstance_setPoint2DList implements BMethodRequest, Serializable {

	public java.util.List<com.wilutions.byps.test.api.inl.Point2D> pointList;
	
	private final static long serialVersionUID = 224357548L;
	
	@Override
	public int getRemoteId() { return 1206670536; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteInlineInstanceAsync remoteT = (RemoteInlineInstanceAsync)remote;			
			BAsyncResultSendMethod<Object> outerResult = new BAsyncResultSendMethod<Object>(asyncResult, new com.wilutions.byps.test.api.BResult_19());			
			remoteT.async_setPoint2DList(pointList, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
