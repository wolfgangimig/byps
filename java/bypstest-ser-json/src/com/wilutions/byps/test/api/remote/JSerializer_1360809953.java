﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteListTypes_setInt3
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
public class JSerializer_1360809953 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1360809953();
	
	
	public JSerializer_1360809953() {
		super(1360809953);
	}
	
	public JSerializer_1360809953(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteListTypes_setInt3 obj = (BRequest_RemoteListTypes_setInt3)obj1;		
		bout.writeObj("int3",obj.int3, false, com.wilutions.byps.test.api.JSerializer_1746702954.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteListTypes_setInt3 obj = (BRequest_RemoteListTypes_setInt3)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteListTypes_setInt3()));
		
		final BJsonObject js = bin.currentObject;
		obj.int3 = (java.util.List<java.util.List<java.lang.Integer>>)bin.readObj("int3", false, com.wilutions.byps.test.api.JSerializer_1746702954.instance);
		
		return obj;
	}
	
}