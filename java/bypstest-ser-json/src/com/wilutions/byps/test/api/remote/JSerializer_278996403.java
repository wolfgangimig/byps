﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getObject
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
public class JSerializer_278996403 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_278996403();
	
	
	public JSerializer_278996403() {
		super(278996403);
	}
	
	public JSerializer_278996403(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteArrayTypes4dim_getObject obj = (BRequest_RemoteArrayTypes4dim_getObject)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_getObject()));
		
		return obj;
	}
	
}