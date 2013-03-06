package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_getActorSet
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
public class JSerializer_1108125389 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1108125389();
	
	
	public JSerializer_1108125389() {
		super(1108125389);
	}
	
	public JSerializer_1108125389(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteInlineInstance_getActorSet obj = (BResult_RemoteInlineInstance_getActorSet)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_797794691.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteInlineInstance_getActorSet obj = (BResult_RemoteInlineInstance_getActorSet)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteInlineInstance_getActorSet()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.Set<com.wilutions.byps.test.api.inl.Actor>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_797794691.instance);
		
		return obj;
	}
	
}
