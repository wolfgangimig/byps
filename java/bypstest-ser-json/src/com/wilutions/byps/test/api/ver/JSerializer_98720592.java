﻿package com.wilutions.byps.test.api.ver;

/*
 * Serializer for com.wilutions.byps.test.api.ver.BRequest_EvolveIF_getClient
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
public class JSerializer_98720592 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_98720592();
	
	
	public JSerializer_98720592() {
		super(98720592);
	}
	
	public JSerializer_98720592(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_EvolveIF_getClient obj = (BRequest_EvolveIF_getClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_EvolveIF_getClient()));
		
		return obj;
	}
	
}