﻿package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BRequest_ClientIF_sendChat
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
public class JSerializer_1352392091 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1352392091();
	
	
	public JSerializer_1352392091() {
		super(1352392091);
	}
	
	public JSerializer_1352392091(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_ClientIF_sendChat obj = (BRequest_ClientIF_sendChat)obj1;		
		bout.writeObj("cs",obj.cs, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_ClientIF_sendChat obj = (BRequest_ClientIF_sendChat)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ClientIF_sendChat()));
		
		final BJsonObject js = bin.currentObject;
		obj.cs = (com.wilutions.byps.test.api.srvr.ChatStructure)bin.readObj("cs", false, null);
		
		return obj;
	}
	
}