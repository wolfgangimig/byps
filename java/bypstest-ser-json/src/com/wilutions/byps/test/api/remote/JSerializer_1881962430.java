﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getPrimitiveTypes
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
public class JSerializer_1881962430 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1881962430();
	
	
	public JSerializer_1881962430() {
		super(1881962430);
	}
	
	public JSerializer_1881962430(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemotePrimitiveTypes_getPrimitiveTypes obj = (BRequest_RemotePrimitiveTypes_getPrimitiveTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_getPrimitiveTypes()));
		
		return obj;
	}
	
}