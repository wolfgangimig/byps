﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getChar1
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
public class JSerializer_2125285334 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_2125285334();
	
	
	public JSerializer_2125285334() {
		super(2125285334);
	}
	
	public JSerializer_2125285334(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteSetTypes_getChar1 obj = (BRequest_RemoteSetTypes_getChar1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_getChar1()));
		
		return obj;
	}
	
}