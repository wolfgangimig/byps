﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setChar1
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
public class JSerializer_1608569502 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1608569502();
	
	
	public JSerializer_1608569502() {
		super(1608569502);
	}
	
	public JSerializer_1608569502(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteSetTypes_setChar1 obj = (BRequest_RemoteSetTypes_setChar1)obj1;		
		bout.writeObj("char1",obj.char1, false, com.wilutions.byps.test.api.JSerializer_936607009.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteSetTypes_setChar1 obj = (BRequest_RemoteSetTypes_setChar1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setChar1()));
		
		final BJsonObject js = bin.currentObject;
		obj.char1 = (java.util.TreeSet<java.lang.Character>)bin.readObj("char1", false, com.wilutions.byps.test.api.JSerializer_936607009.instance);
		
		return obj;
	}
	
}