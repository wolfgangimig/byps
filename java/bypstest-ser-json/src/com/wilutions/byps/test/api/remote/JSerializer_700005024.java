package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getActorArray4dim
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
public class JSerializer_700005024 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_700005024();
	
	
	public JSerializer_700005024() {
		super(700005024);
	}
	
	public JSerializer_700005024(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteInlineInstance_getActorArray4dim obj = (BRequest_RemoteInlineInstance_getActorArray4dim)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_getActorArray4dim()));
		
		return obj;
	}
	
}
