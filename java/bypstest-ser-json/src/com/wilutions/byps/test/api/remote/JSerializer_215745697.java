package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActorSet
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
public class JSerializer_215745697 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_215745697();
	
	
	public JSerializer_215745697() {
		super(215745697);
	}
	
	public JSerializer_215745697(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteInlineInstance_setActorSet obj = (BRequest_RemoteInlineInstance_setActorSet)obj1;		
		bout.writeObj("actorSet",obj.actorSet, false, com.wilutions.byps.test.api.JSerializer_797794691.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteInlineInstance_setActorSet obj = (BRequest_RemoteInlineInstance_setActorSet)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setActorSet()));
		
		final BJsonObject js = bin.currentObject;
		obj.actorSet = (java.util.Set<com.wilutions.byps.test.api.inl.Actor>)bin.readObj("actorSet", false, com.wilutions.byps.test.api.JSerializer_797794691.instance);
		
		return obj;
	}
	
}
