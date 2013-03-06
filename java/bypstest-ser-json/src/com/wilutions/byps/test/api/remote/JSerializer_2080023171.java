package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActorListList
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
public class JSerializer_2080023171 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_2080023171();
	
	
	public JSerializer_2080023171() {
		super(2080023171);
	}
	
	public JSerializer_2080023171(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteInlineInstance_setActorListList obj = (BRequest_RemoteInlineInstance_setActorListList)obj1;		
		bout.writeObj("actorListList",obj.actorListList, false, com.wilutions.byps.test.api.JSerializer_1398598597.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteInlineInstance_setActorListList obj = (BRequest_RemoteInlineInstance_setActorListList)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setActorListList()));
		
		final BJsonObject js = bin.currentObject;
		obj.actorListList = (java.util.List<java.util.List<com.wilutions.byps.test.api.inl.Actor>>)bin.readObj("actorListList", false, com.wilutions.byps.test.api.JSerializer_1398598597.instance);
		
		return obj;
	}
	
}
