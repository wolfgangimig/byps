﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setChar1
 * 
 * THIS FILE HAS BEEN GENERATED BY class com.wilutions.byps.gen.j.GenSerStructJson DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=1

@SuppressWarnings("all")
public class JSerializer_758828288 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_758828288();
	
	
	public JSerializer_758828288() {
		super(758828288);
	}
	
	public JSerializer_758828288(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteListTypes_setChar1 obj = (BRequest_RemoteListTypes_setChar1)obj1;		
		bout.writeObj("char1",obj.char1, false, com.wilutions.byps.test.api.JSerializer_1661807911.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteListTypes_setChar1 obj = (BRequest_RemoteListTypes_setChar1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setChar1()));
		
		final BJsonObject js = bin.currentObject;
		obj.char1 = (java.util.List<java.lang.Character>)bin.readObj("char1", false, com.wilutions.byps.test.api.JSerializer_1661807911.instance);
		
		return obj;
	}
	
}
