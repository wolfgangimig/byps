﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setByte1
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
public class JSerializer_1608170284 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1608170284();
	
	
	public JSerializer_1608170284() {
		super(1608170284);
	}
	
	public JSerializer_1608170284(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteSetTypes_setByte1 obj = (BRequest_RemoteSetTypes_setByte1)obj1;		
		bout.writeObj("byte1",obj.byte1, false, com.wilutions.byps.test.api.JSerializer_31512998.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteSetTypes_setByte1 obj = (BRequest_RemoteSetTypes_setByte1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setByte1()));
		
		final BJsonObject js = bin.currentObject;
		obj.byte1 = (java.util.HashSet<java.lang.Byte>)bin.readObj("byte1", false, com.wilutions.byps.test.api.JSerializer_31512998.instance);
		
		return obj;
	}
	
}