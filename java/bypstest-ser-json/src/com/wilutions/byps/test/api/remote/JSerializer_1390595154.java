﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getShort
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=0

@SuppressWarnings("all")
public class JSerializer_1390595154 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1390595154();
	
	
	public JSerializer_1390595154() {
		super(1390595154);
	}
	
	public JSerializer_1390595154(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteArrayTypes4dim_getShort obj = (BRequest_RemoteArrayTypes4dim_getShort)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_getShort()));
		
		return obj;
	}
	
}