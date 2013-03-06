package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteInlineInstance_setActor
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
public class JSerializer_299289599 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_299289599();
	
	
	public JSerializer_299289599() {
		super(299289599);
	}
	
	public JSerializer_299289599(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteInlineInstance_setActor obj = (BRequest_RemoteInlineInstance_setActor)obj1;		
		bout.writeObj("act",obj.act, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteInlineInstance_setActor obj = (BRequest_RemoteInlineInstance_setActor)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteInlineInstance_setActor()));
		
		final BJsonObject js = bin.currentObject;
		obj.act = (com.wilutions.byps.test.api.inl.Actor)bin.readObj("act", false, null);
		
		return obj;
	}
	
}
