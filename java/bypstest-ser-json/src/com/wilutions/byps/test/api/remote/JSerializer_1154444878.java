﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_setString
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
public class JSerializer_1154444878 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1154444878();
	
	
	public JSerializer_1154444878() {
		super(1154444878);
	}
	
	public JSerializer_1154444878(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteArrayTypes1dim_setString obj = (BRequest_RemoteArrayTypes1dim_setString)obj1;		
		bout.writeObj("v",obj.v, true, com.wilutions.byps.test.api.JSerializer_1888107655.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteArrayTypes1dim_setString obj = (BRequest_RemoteArrayTypes1dim_setString)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes1dim_setString()));
		
		final BJsonObject js = bin.currentObject;
		obj.v = (java.lang.String[])bin.readObj("v", true, com.wilutions.byps.test.api.JSerializer_1888107655.instance);
		
		return obj;
	}
	
}