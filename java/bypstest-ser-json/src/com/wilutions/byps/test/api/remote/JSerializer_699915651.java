package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getActorArray1dim
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
public class JSerializer_699915651 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_699915651();
	
	
	public JSerializer_699915651() {
		super(699915651);
	}
	
	public JSerializer_699915651(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteInlineInstance_getActorArray1dim obj = (BRequest_RemoteInlineInstance_getActorArray1dim)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_getActorArray1dim()));
		
		return obj;
	}
	
}
