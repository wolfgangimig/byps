package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_setActorArray1dim
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
public class JSerializer_333840071 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_333840071();
	
	
	public JSerializer_333840071() {
		super(333840071);
	}
	
	public JSerializer_333840071(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteInlineInstance_setActorArray1dim obj = (BResult_RemoteInlineInstance_setActorArray1dim)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteInlineInstance_setActorArray1dim()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
