﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getPoint2DArray4dim
 * 
 * THIS FILE HAS BEEN GENERATED BY class com.wilutions.byps.gen.j.GenSerStructJson DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=0

@SuppressWarnings("all")
public class JSerializer_1012059475 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1012059475();
	
	
	public JSerializer_1012059475() {
		super(1012059475);
	}
	
	public JSerializer_1012059475(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteInlineInstance_getPoint2DArray4dim obj = (BRequest_RemoteInlineInstance_getPoint2DArray4dim)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_getPoint2DArray4dim()));
		
		return obj;
	}
	
}
