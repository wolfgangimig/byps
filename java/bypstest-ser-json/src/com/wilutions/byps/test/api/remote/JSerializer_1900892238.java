﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setLong1
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
public class JSerializer_1900892238 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1900892238();
	
	
	public JSerializer_1900892238() {
		super(1900892238);
	}
	
	public JSerializer_1900892238(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteMapTypes_setLong1 obj = (BRequest_RemoteMapTypes_setLong1)obj1;		
		bout.writeObj("long1",obj.long1, false, com.wilutions.byps.test.api.JSerializer_1973996106.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteMapTypes_setLong1 obj = (BRequest_RemoteMapTypes_setLong1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setLong1()));
		
		final BJsonObject js = bin.currentObject;
		obj.long1 = (java.util.Map<java.lang.Short,java.lang.Long>)bin.readObj("long1", false, com.wilutions.byps.test.api.JSerializer_1973996106.instance);
		
		return obj;
	}
	
}