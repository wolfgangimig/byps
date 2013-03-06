package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_setActorArray4dim
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
public class JSerializer_333929444 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_333929444();
	
	
	public JSerializer_333929444() {
		super(333929444);
	}
	
	public JSerializer_333929444(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteInlineInstance_setActorArray4dim obj = (BResult_RemoteInlineInstance_setActorArray4dim)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteInlineInstance_setActorArray4dim()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
