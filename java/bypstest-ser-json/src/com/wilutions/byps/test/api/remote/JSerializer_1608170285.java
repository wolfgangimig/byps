﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setByte2
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
public class JSerializer_1608170285 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1608170285();
	
	
	public JSerializer_1608170285() {
		super(1608170285);
	}
	
	public JSerializer_1608170285(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteSetTypes_setByte2 obj = (BRequest_RemoteSetTypes_setByte2)obj1;		
		bout.writeObj("byte2",obj.byte2, false, com.wilutions.byps.test.api.JSerializer_2052431866.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteSetTypes_setByte2 obj = (BRequest_RemoteSetTypes_setByte2)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setByte2()));
		
		final BJsonObject js = bin.currentObject;
		obj.byte2 = (java.util.Set<byte[]>)bin.readObj("byte2", false, com.wilutions.byps.test.api.JSerializer_2052431866.instance);
		
		return obj;
	}
	
}