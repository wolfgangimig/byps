﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteException_throwFirstException
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
public class JSerializer_533533486 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_533533486();
	
	
	public JSerializer_533533486() {
		super(533533486);
	}
	
	public JSerializer_533533486(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteException_throwFirstException obj = (BRequest_RemoteException_throwFirstException)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteException_throwFirstException()));
		
		return obj;
	}
	
}