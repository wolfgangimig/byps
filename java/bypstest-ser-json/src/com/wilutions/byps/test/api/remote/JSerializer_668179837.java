﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setString1
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
public class JSerializer_668179837 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_668179837();
	
	
	public JSerializer_668179837() {
		super(668179837);
	}
	
	public JSerializer_668179837(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteMapTypes_setString1 obj = (BRequest_RemoteMapTypes_setString1)obj1;		
		bout.writeObj("string1",obj.string1, false, com.wilutions.byps.test.api.JSerializer_1710660846.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteMapTypes_setString1 obj = (BRequest_RemoteMapTypes_setString1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setString1()));
		
		final BJsonObject js = bin.currentObject;
		obj.string1 = (java.util.Map<java.lang.String,java.lang.String>)bin.readObj("string1", false, com.wilutions.byps.test.api.JSerializer_1710660846.instance);
		
		return obj;
	}
	
}