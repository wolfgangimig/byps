﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getLong1
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
public class JSerializer_2116752956 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_2116752956();
	
	
	public JSerializer_2116752956() {
		super(2116752956);
	}
	
	public JSerializer_2116752956(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteSetTypes_getLong1 obj = (BRequest_RemoteSetTypes_getLong1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_getLong1()));
		
		return obj;
	}
	
}