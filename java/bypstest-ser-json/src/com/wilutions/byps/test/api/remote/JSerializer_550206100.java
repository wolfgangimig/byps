﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setBoolean1
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
public class JSerializer_550206100 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_550206100();
	
	
	public JSerializer_550206100() {
		super(550206100);
	}
	
	public JSerializer_550206100(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteMapTypes_setBoolean1 obj = (BRequest_RemoteMapTypes_setBoolean1)obj1;		
		bout.writeObj("boolean1",obj.boolean1, false, com.wilutions.byps.test.api.JSerializer_1279823631.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteMapTypes_setBoolean1 obj = (BRequest_RemoteMapTypes_setBoolean1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setBoolean1()));
		
		final BJsonObject js = bin.currentObject;
		obj.boolean1 = (java.util.Map<java.lang.String,java.lang.Boolean>)bin.readObj("boolean1", false, com.wilutions.byps.test.api.JSerializer_1279823631.instance);
		
		return obj;
	}
	
}