package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_getActorMap
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
public class JSerializer_1108119495 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1108119495();
	
	
	public JSerializer_1108119495() {
		super(1108119495);
	}
	
	public JSerializer_1108119495(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteInlineInstance_getActorMap obj = (BResult_RemoteInlineInstance_getActorMap)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1930448581.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteInlineInstance_getActorMap obj = (BResult_RemoteInlineInstance_getActorMap)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteInlineInstance_getActorMap()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.inl.Actor>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1930448581.instance);
		
		return obj;
	}
	
}
