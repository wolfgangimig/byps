﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getChar
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
public class JSerializer_1645626823 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1645626823();
	
	
	public JSerializer_1645626823() {
		super(1645626823);
	}
	
	public JSerializer_1645626823(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteArrayTypes1dim_getChar obj = (BRequest_RemoteArrayTypes1dim_getChar)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes1dim_getChar()));
		
		return obj;
	}
	
}