﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setInt3
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
public class JSerializer_1803047449 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1803047449();
	
	
	public JSerializer_1803047449() {
		super(1803047449);
	}
	
	public JSerializer_1803047449(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteListTypes_setInt3 obj = (BResult_RemoteListTypes_setInt3)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteListTypes_setInt3()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}