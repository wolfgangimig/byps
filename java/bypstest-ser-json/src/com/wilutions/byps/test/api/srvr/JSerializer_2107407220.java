﻿package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BRequest_ServerIF_getClient
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
public class JSerializer_2107407220 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_2107407220();
	
	
	public JSerializer_2107407220() {
		super(2107407220);
	}
	
	public JSerializer_2107407220(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_ServerIF_getClient obj = (BRequest_ServerIF_getClient)obj1;		
		bbuf.putInt("id", obj.id);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_ServerIF_getClient obj = (BRequest_ServerIF_getClient)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_getClient()));
		
		final BJsonObject js = bin.currentObject;
		obj.id = js.getInt("id");
		
		return obj;
	}
	
}