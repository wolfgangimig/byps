﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_getBool
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
public class JSerializer_2032852344 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_2032852344();
	
	
	public JSerializer_2032852344() {
		super(2032852344);
	}
	
	public JSerializer_2032852344(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteArrayTypes4dim_getBool obj = (BRequest_RemoteArrayTypes4dim_getBool)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_getBool()));
		
		return obj;
	}
	
}