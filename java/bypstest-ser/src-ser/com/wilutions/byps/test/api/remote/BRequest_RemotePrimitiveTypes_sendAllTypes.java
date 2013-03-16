﻿package com.wilutions.byps.test.api.remote;

/*
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;
import java.io.Serializable;

/**
*/
@SuppressWarnings("all")
public final class BRequest_RemotePrimitiveTypes_sendAllTypes implements BMethodRequest, Serializable {

	public boolean b;
	public char c;
	public short s;
	public int i;
	public long l;
	public float f;
	public double d;
	public java.lang.String str;
	public com.wilutions.byps.test.api.prim.PrimitiveTypes pt;
	public java.lang.Object o;
	
	private final static long serialVersionUID = 1794219594L;
	
	@Override
	public int getRemoteId() { return 1341983932; }
	
	@Override
	public void execute(BRemote remote, BAsyncResult<Object> asyncResult) throws Throwable {
		try {
			final RemotePrimitiveTypesAsync remoteT = (RemotePrimitiveTypesAsync)remote;			
			BAsyncResultSendMethod<Object> outerResult = new BAsyncResultSendMethod<Object>(asyncResult, new BResult_RemotePrimitiveTypes_sendAllTypes());			
			remoteT.async_sendAllTypes(b, c, s, i, l, f, d, str, pt, o, outerResult);
		} catch (Throwable e) {
			asyncResult.setAsyncResult(null, e);
			throw e;
		}
	}	
	
}
