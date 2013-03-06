package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActorArray1dim
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
public class JSerializer_240237169 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_240237169();
	
	
	public JSerializer_240237169() {
		super(240237169);
	}
	
	public JSerializer_240237169(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteInlineInstance_setActorArray1dim obj = (BRequest_RemoteInlineInstance_setActorArray1dim)obj1;		
		bout.writeObj("actorArray",obj.actorArray, false, com.wilutions.byps.test.api.JSerializer_1784131613.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteInlineInstance_setActorArray1dim obj = (BRequest_RemoteInlineInstance_setActorArray1dim)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setActorArray1dim()));
		
		final BJsonObject js = bin.currentObject;
		obj.actorArray = (com.wilutions.byps.test.api.inl.Actor[])bin.readObj("actorArray", false, com.wilutions.byps.test.api.JSerializer_1784131613.instance);
		
		return obj;
	}
	
}
