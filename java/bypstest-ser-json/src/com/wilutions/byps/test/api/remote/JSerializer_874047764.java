﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_getInt4
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
public class JSerializer_874047764 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_874047764();
	
	
	public JSerializer_874047764() {
		super(874047764);
	}
	
	public JSerializer_874047764(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteListTypes_getInt4 obj = (BRequest_RemoteListTypes_getInt4)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_getInt4()));
		
		return obj;
	}
	
}