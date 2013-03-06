package com.wilutions.byps.test.api.srvr;

/*
 * Serializer for com.wilutions.byps.test.api.srvr.BRequest_ServerIF_getClientIds
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
public class JSerializer_2063368540 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_2063368540();
	
	
	public JSerializer_2063368540() {
		super(2063368540);
	}
	
	public JSerializer_2063368540(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_ServerIF_getClientIds obj = (BRequest_ServerIF_getClientIds)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_ServerIF_getClientIds()));
		
		return obj;
	}
	
}
