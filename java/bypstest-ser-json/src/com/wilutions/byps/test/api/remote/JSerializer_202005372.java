﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setBool
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
public class JSerializer_202005372 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_202005372();
	
	
	public JSerializer_202005372() {
		super(202005372);
	}
	
	public JSerializer_202005372(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteArrayTypes4dim_setBool obj = (BRequest_RemoteArrayTypes4dim_setBool)obj1;		
		bout.writeObj("v",obj.v, false, com.wilutions.byps.test.api.JSerializer_945713488.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteArrayTypes4dim_setBool obj = (BRequest_RemoteArrayTypes4dim_setBool)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_setBool()));
		
		final BJsonObject js = bin.currentObject;
		obj.v = (boolean[][][][])bin.readObj("v", false, com.wilutions.byps.test.api.JSerializer_945713488.instance);
		
		return obj;
	}
	
}