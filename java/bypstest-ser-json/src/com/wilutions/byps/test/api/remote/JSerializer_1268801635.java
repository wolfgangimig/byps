﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setString1
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
public class JSerializer_1268801635 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1268801635();
	
	
	public JSerializer_1268801635() {
		super(1268801635);
	}
	
	public JSerializer_1268801635(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteListTypes_setString1 obj = (BResult_RemoteListTypes_setString1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteListTypes_setString1()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}