﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_add
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=2

@SuppressWarnings("all")
public class JSerializer_1073583639 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1073583639();
	
	
	public JSerializer_1073583639() {
		super(1073583639);
	}
	
	public JSerializer_1073583639(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemotePrimitiveTypes_add obj = (BRequest_RemotePrimitiveTypes_add)obj1;		
		bbuf.putInt("a", obj.a);
		bbuf.putInt("b", obj.b);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemotePrimitiveTypes_add obj = (BRequest_RemotePrimitiveTypes_add)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_add()));
		
		final BJsonObject js = bin.currentObject;
		obj.a = js.getInt("a");
		obj.b = js.getInt("b");
		
		return obj;
	}
	
}