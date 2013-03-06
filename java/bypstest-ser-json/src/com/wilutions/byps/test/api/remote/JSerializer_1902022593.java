package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActorList
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
public class JSerializer_1902022593 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1902022593();
	
	
	public JSerializer_1902022593() {
		super(1902022593);
	}
	
	public JSerializer_1902022593(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteInlineInstance_setActorList obj = (BRequest_RemoteInlineInstance_setActorList)obj1;		
		bout.writeObj("actorList",obj.actorList, false, com.wilutions.byps.test.api.JSerializer_494001343.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteInlineInstance_setActorList obj = (BRequest_RemoteInlineInstance_setActorList)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setActorList()));
		
		final BJsonObject js = bin.currentObject;
		obj.actorList = (java.util.List<com.wilutions.byps.test.api.inl.Actor>)bin.readObj("actorList", false, com.wilutions.byps.test.api.JSerializer_494001343.instance);
		
		return obj;
	}
	
}
