﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes1dim_getInt
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
public class JSerializer_1609477282 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1609477282();
	
	
	public JSerializer_1609477282() {
		super(1609477282);
	}
	
	public JSerializer_1609477282(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteArrayTypes1dim_getInt obj = (BRequest_RemoteArrayTypes1dim_getInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes1dim_getInt()));
		
		return obj;
	}
	
}