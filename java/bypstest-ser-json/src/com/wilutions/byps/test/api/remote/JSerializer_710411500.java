﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setPrimitiveTypes
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
public class JSerializer_710411500 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_710411500();
	
	
	public JSerializer_710411500() {
		super(710411500);
	}
	
	public JSerializer_710411500(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteArrayTypes4dim_setPrimitiveTypes obj = (BRequest_RemoteArrayTypes4dim_setPrimitiveTypes)obj1;		
		bout.writeObj("v",obj.v, false, com.wilutions.byps.test.api.JSerializer_1503107601.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteArrayTypes4dim_setPrimitiveTypes obj = (BRequest_RemoteArrayTypes4dim_setPrimitiveTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_setPrimitiveTypes()));
		
		final BJsonObject js = bin.currentObject;
		obj.v = (com.wilutions.byps.test.api.prim.PrimitiveTypes[][][][])bin.readObj("v", false, com.wilutions.byps.test.api.JSerializer_1503107601.instance);
		
		return obj;
	}
	
}