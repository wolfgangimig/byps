﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getDouble
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
public class JSerializer_538948675 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_538948675();
	
	
	public JSerializer_538948675() {
		super(538948675);
	}
	
	public JSerializer_538948675(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemotePrimitiveTypes_getDouble obj = (BRequest_RemotePrimitiveTypes_getDouble)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_getDouble()));
		
		return obj;
	}
	
}