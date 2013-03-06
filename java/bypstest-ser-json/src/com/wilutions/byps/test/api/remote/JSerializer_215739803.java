package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActorMap
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
public class JSerializer_215739803 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_215739803();
	
	
	public JSerializer_215739803() {
		super(215739803);
	}
	
	public JSerializer_215739803(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteInlineInstance_setActorMap obj = (BRequest_RemoteInlineInstance_setActorMap)obj1;		
		bout.writeObj("actorMap",obj.actorMap, false, com.wilutions.byps.test.api.JSerializer_1930448581.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteInlineInstance_setActorMap obj = (BRequest_RemoteInlineInstance_setActorMap)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setActorMap()));
		
		final BJsonObject js = bin.currentObject;
		obj.actorMap = (java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor>)bin.readObj("actorMap", false, com.wilutions.byps.test.api.JSerializer_1930448581.instance);
		
		return obj;
	}
	
}
