﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setDouble1
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
public class JSerializer_753026243 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_753026243();
	
	
	public JSerializer_753026243() {
		super(753026243);
	}
	
	public JSerializer_753026243(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteSetTypes_setDouble1 obj = (BRequest_RemoteSetTypes_setDouble1)obj1;		
		bout.writeObj("double1",obj.double1, false, com.wilutions.byps.test.api.JSerializer_1320560671.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteSetTypes_setDouble1 obj = (BRequest_RemoteSetTypes_setDouble1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setDouble1()));
		
		final BJsonObject js = bin.currentObject;
		obj.double1 = (java.util.Set<java.lang.Double>)bin.readObj("double1", false, com.wilutions.byps.test.api.JSerializer_1320560671.instance);
		
		return obj;
	}
	
}