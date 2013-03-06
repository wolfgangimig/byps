package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_getActorList
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
public class JSerializer_843952075 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_843952075();
	
	
	public JSerializer_843952075() {
		super(843952075);
	}
	
	public JSerializer_843952075(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteInlineInstance_getActorList obj = (BRequest_RemoteInlineInstance_getActorList)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_getActorList()));
		
		return obj;
	}
	
}
