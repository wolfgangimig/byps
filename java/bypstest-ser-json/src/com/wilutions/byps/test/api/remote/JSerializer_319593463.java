﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setString
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
public class JSerializer_319593463 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_319593463();
	
	
	public JSerializer_319593463() {
		super(319593463);
	}
	
	public JSerializer_319593463(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemotePrimitiveTypes_setString obj = (BRequest_RemotePrimitiveTypes_setString)obj1;		
		bbuf.putString("v", obj.v);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemotePrimitiveTypes_setString obj = (BRequest_RemotePrimitiveTypes_setString)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_setString()));
		
		final BJsonObject js = bin.currentObject;
		obj.v = js.getString("v");
		
		return obj;
	}
	
}