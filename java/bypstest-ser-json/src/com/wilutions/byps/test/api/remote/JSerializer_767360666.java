﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setLong1
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
public class JSerializer_767360666 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_767360666();
	
	
	public JSerializer_767360666() {
		super(767360666);
	}
	
	public JSerializer_767360666(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteListTypes_setLong1 obj = (BRequest_RemoteListTypes_setLong1)obj1;		
		bout.writeObj("long1",obj.long1, false, com.wilutions.byps.test.api.JSerializer_1050216688.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteListTypes_setLong1 obj = (BRequest_RemoteListTypes_setLong1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setLong1()));
		
		final BJsonObject js = bin.currentObject;
		obj.long1 = (java.util.List<java.lang.Long>)bin.readObj("long1", false, com.wilutions.byps.test.api.JSerializer_1050216688.instance);
		
		return obj;
	}
	
}