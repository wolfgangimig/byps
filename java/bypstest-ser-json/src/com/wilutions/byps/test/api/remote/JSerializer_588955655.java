﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setLong
 * 
 * THIS FILE HAS BEEN GENERATED BY class com.wilutions.byps.gen.j.GenSerStructJson DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

@SuppressWarnings("all")
public class JSerializer_588955655 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_588955655();
	
	
	public JSerializer_588955655() {
		super(588955655);
	}
	
	public JSerializer_588955655(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteArrayTypes1dim_setLong obj = (BRequest_RemoteArrayTypes1dim_setLong)obj1;		
		bout.writeObj("v",obj.v, false, com.wilutions.byps.test.api.JSerializer_1097129250.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteArrayTypes1dim_setLong obj = (BRequest_RemoteArrayTypes1dim_setLong)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes1dim_setLong()));
		
		final BJsonObject js = bin.currentObject;
		obj.v = (long[])bin.readObj("v", false, com.wilutions.byps.test.api.JSerializer_1097129250.instance);
		
		return obj;
	}
	
}
