﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getFloat
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
public class JSerializer_400008432 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_400008432();
	
	
	public JSerializer_400008432() {
		super(400008432);
	}
	
	public JSerializer_400008432(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemotePrimitiveTypes_getFloat obj = (BRequest_RemotePrimitiveTypes_getFloat)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_getFloat()));
		
		return obj;
	}
	
}