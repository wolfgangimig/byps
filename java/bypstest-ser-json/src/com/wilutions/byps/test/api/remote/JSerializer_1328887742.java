﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getLong
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

@SuppressWarnings("all")
public class JSerializer_1328887742 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1328887742();
	
	
	public JSerializer_1328887742() {
		super(1328887742);
	}
	
	public JSerializer_1328887742(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteArrayTypes4dim_getLong obj = (BResult_RemoteArrayTypes4dim_getLong)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_846419204.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteArrayTypes4dim_getLong obj = (BResult_RemoteArrayTypes4dim_getLong)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteArrayTypes4dim_getLong()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (long[][][][])bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_846419204.instance);
		
		return obj;
	}
	
}