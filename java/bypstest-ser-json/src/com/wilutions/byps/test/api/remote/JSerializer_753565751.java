﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_setDouble
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
public class JSerializer_753565751 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_753565751();
	
	
	public JSerializer_753565751() {
		super(753565751);
	}
	
	public JSerializer_753565751(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemotePrimitiveTypes_setDouble obj = (BRequest_RemotePrimitiveTypes_setDouble)obj1;		
		bbuf.putDouble("v", obj.v);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemotePrimitiveTypes_setDouble obj = (BRequest_RemotePrimitiveTypes_setDouble)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_setDouble()));
		
		final BJsonObject js = bin.currentObject;
		obj.v = js.getDouble("v");
		
		return obj;
	}
	
}