﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getLong
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
public class JSerializer_2091295080 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_2091295080();
	
	
	public JSerializer_2091295080() {
		super(2091295080);
	}
	
	public JSerializer_2091295080(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemotePrimitiveTypes_getLong obj = (BRequest_RemotePrimitiveTypes_getLong)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_getLong()));
		
		return obj;
	}
	
}