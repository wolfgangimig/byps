﻿package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BRequest_ServerIF_getPartner
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=0

@SuppressWarnings("all")
public class JSerializer_748402113 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_748402113();
	
	
	public JSerializer_748402113() {
		super(748402113);
	}
	
	public JSerializer_748402113(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_ServerIF_getPartner obj = (BRequest_ServerIF_getPartner)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_getPartner()));
		
		return obj;
	}
	
}