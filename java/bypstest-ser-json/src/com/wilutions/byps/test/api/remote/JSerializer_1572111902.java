﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setPrimitiveTypes1
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
public class JSerializer_1572111902 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1572111902();
	
	
	public JSerializer_1572111902() {
		super(1572111902);
	}
	
	public JSerializer_1572111902(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteSetTypes_setPrimitiveTypes1 obj = (BRequest_RemoteSetTypes_setPrimitiveTypes1)obj1;		
		bout.writeObj("primitiveTypes1",obj.primitiveTypes1, false, com.wilutions.byps.test.api.JSerializer_1280571537.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteSetTypes_setPrimitiveTypes1 obj = (BRequest_RemoteSetTypes_setPrimitiveTypes1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setPrimitiveTypes1()));
		
		final BJsonObject js = bin.currentObject;
		obj.primitiveTypes1 = (java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>)bin.readObj("primitiveTypes1", false, com.wilutions.byps.test.api.JSerializer_1280571537.instance);
		
		return obj;
	}
	
}