﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setInt2
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
public class JSerializer_1046969350 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1046969350();
	
	
	public JSerializer_1046969350() {
		super(1046969350);
	}
	
	public JSerializer_1046969350(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteMapTypes_setInt2 obj = (BRequest_RemoteMapTypes_setInt2)obj1;		
		bout.writeObj("int2",obj.int2, false, com.wilutions.byps.test.api.JSerializer_1633750383.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteMapTypes_setInt2 obj = (BRequest_RemoteMapTypes_setInt2)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setInt2()));
		
		final BJsonObject js = bin.currentObject;
		obj.int2 = (java.util.Map<java.lang.Integer,int[]>)bin.readObj("int2", false, com.wilutions.byps.test.api.JSerializer_1633750383.instance);
		
		return obj;
	}
	
}