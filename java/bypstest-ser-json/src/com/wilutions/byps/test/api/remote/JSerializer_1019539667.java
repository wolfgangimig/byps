package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_setActorMap
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
public class JSerializer_1019539667 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1019539667();
	
	
	public JSerializer_1019539667() {
		super(1019539667);
	}
	
	public JSerializer_1019539667(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteInlineInstance_setActorMap obj = (BResult_RemoteInlineInstance_setActorMap)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteInlineInstance_setActorMap()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
