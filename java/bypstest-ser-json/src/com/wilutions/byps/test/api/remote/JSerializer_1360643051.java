﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setObj1
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
public class JSerializer_1360643051 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1360643051();
	
	
	public JSerializer_1360643051() {
		super(1360643051);
	}
	
	public JSerializer_1360643051(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteListTypes_setObj1 obj = (BRequest_RemoteListTypes_setObj1)obj1;		
		bout.writeObj("obj1",obj.obj1, false, com.wilutions.byps.JSerializer_12.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteListTypes_setObj1 obj = (BRequest_RemoteListTypes_setObj1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setObj1()));
		
		final BJsonObject js = bin.currentObject;
		obj.obj1 = (java.util.List<java.lang.Object>)bin.readObj("obj1", false, com.wilutions.byps.JSerializer_12.instance);
		
		return obj;
	}
	
}