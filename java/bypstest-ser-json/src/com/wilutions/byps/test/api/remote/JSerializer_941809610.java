﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setPrimitiveTypes
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

@SuppressWarnings("all")
public class JSerializer_941809610 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_941809610();
	
	
	public JSerializer_941809610() {
		super(941809610);
	}
	
	public JSerializer_941809610(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemotePrimitiveTypes_setPrimitiveTypes obj = (BRequest_RemotePrimitiveTypes_setPrimitiveTypes)obj1;		
		bout.writeObj("v",obj.v, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemotePrimitiveTypes_setPrimitiveTypes obj = (BRequest_RemotePrimitiveTypes_setPrimitiveTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_setPrimitiveTypes()));
		
		final BJsonObject js = bin.currentObject;
		obj.v = (com.wilutions.byps.test.api.prim.PrimitiveTypes)bin.readObj("v", false, null);
		
		return obj;
	}
	
}