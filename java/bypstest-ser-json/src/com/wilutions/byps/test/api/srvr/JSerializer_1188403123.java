﻿package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BRequest_ServerIF_setPartner
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
public class JSerializer_1188403123 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1188403123();
	
	
	public JSerializer_1188403123() {
		super(1188403123);
	}
	
	public JSerializer_1188403123(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_ServerIF_setPartner obj = (BRequest_ServerIF_setPartner)obj1;		
		bout.writeObj("client",obj.client, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_ServerIF_setPartner obj = (BRequest_ServerIF_setPartner)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_setPartner()));
		
		final BJsonObject js = bin.currentObject;
		obj.client = (com.wilutions.byps.test.api.srvr.ClientIF)bin.readObj("client", false, null);
		
		return obj;
	}
	
}