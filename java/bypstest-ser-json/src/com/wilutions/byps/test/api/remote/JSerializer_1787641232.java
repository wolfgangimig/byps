﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setShort1
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
public class JSerializer_1787641232 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1787641232();
	
	
	public JSerializer_1787641232() {
		super(1787641232);
	}
	
	public JSerializer_1787641232(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteListTypes_setShort1 obj = (BRequest_RemoteListTypes_setShort1)obj1;		
		bout.writeObj("short1",obj.short1, false, com.wilutions.byps.test.api.JSerializer_1997002548.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteListTypes_setShort1 obj = (BRequest_RemoteListTypes_setShort1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setShort1()));
		
		final BJsonObject js = bin.currentObject;
		obj.short1 = (java.util.List<java.lang.Short>)bin.readObj("short1", false, com.wilutions.byps.test.api.JSerializer_1997002548.instance);
		
		return obj;
	}
	
}