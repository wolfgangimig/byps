﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setDouble1
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
public class JSerializer_195505829 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_195505829();
	
	
	public JSerializer_195505829() {
		super(195505829);
	}
	
	public JSerializer_195505829(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteListTypes_setDouble1 obj = (BRequest_RemoteListTypes_setDouble1)obj1;		
		bout.writeObj("double1",obj.double1, false, com.wilutions.byps.test.api.JSerializer_1555345627.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteListTypes_setDouble1 obj = (BRequest_RemoteListTypes_setDouble1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setDouble1()));
		
		final BJsonObject js = bin.currentObject;
		obj.double1 = (java.util.List<java.lang.Double>)bin.readObj("double1", false, com.wilutions.byps.test.api.JSerializer_1555345627.instance);
		
		return obj;
	}
	
}