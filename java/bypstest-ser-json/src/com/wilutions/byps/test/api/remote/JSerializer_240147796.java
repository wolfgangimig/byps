package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActorArray4dim
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
public class JSerializer_240147796 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_240147796();
	
	
	public JSerializer_240147796() {
		super(240147796);
	}
	
	public JSerializer_240147796(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteInlineInstance_setActorArray4dim obj = (BRequest_RemoteInlineInstance_setActorArray4dim)obj1;		
		bout.writeObj("actorArray",obj.actorArray, false, com.wilutions.byps.test.api.JSerializer_193284349.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteInlineInstance_setActorArray4dim obj = (BRequest_RemoteInlineInstance_setActorArray4dim)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setActorArray4dim()));
		
		final BJsonObject js = bin.currentObject;
		obj.actorArray = (com.wilutions.byps.test.api.inl.Actor[][][][])bin.readObj("actorArray", false, com.wilutions.byps.test.api.JSerializer_193284349.instance);
		
		return obj;
	}
	
}
