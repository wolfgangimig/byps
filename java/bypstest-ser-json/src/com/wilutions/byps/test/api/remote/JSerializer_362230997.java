﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setString
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
public class JSerializer_362230997 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_362230997();
	
	
	public JSerializer_362230997() {
		super(362230997);
	}
	
	public JSerializer_362230997(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteArrayTypes4dim_setString obj = (BRequest_RemoteArrayTypes4dim_setString)obj1;		
		bout.writeObj("v",obj.v, true, com.wilutions.byps.test.api.JSerializer_588723219.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteArrayTypes4dim_setString obj = (BRequest_RemoteArrayTypes4dim_setString)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_setString()));
		
		final BJsonObject js = bin.currentObject;
		obj.v = (java.lang.String[][][][])bin.readObj("v", true, com.wilutions.byps.test.api.JSerializer_588723219.instance);
		
		return obj;
	}
	
}