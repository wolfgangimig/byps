package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_getActorArray1dim
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
public class JSerializer_1273992891 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1273992891();
	
	
	public JSerializer_1273992891() {
		super(1273992891);
	}
	
	public JSerializer_1273992891(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteInlineInstance_getActorArray1dim obj = (BResult_RemoteInlineInstance_getActorArray1dim)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1784131613.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteInlineInstance_getActorArray1dim obj = (BResult_RemoteInlineInstance_getActorArray1dim)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteInlineInstance_getActorArray1dim()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (com.wilutions.byps.test.api.inl.Actor[])bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1784131613.instance);
		
		return obj;
	}
	
}
