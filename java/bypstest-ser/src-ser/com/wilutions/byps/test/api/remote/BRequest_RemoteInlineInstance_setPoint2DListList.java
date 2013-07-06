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
public final class BRequest_RemoteInlineInstance_setPoint2DListList implements BMethodRequest, Serializable {

	public java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Point2D>> pointListList;
	
	private final static long serialVersionUID = 1097161578L;
	
	@Override
	public int getRemoteId() { return 1206670536; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemoteInlineInstanceAsync remoteT = (RemoteInlineInstanceAsync)remote;			
			BAsyncResultSendMethod<Object> outerResult = new BAsyncResultSendMethod<Object>(asyncResult, new com.wilutions.byps.test.api.BResult_19());			
			remoteT.async_setPoint2DListList(pointListList, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
