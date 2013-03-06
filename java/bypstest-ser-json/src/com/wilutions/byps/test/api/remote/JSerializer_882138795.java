package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_getActor
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
public class JSerializer_882138795 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_882138795();
	
	
	public JSerializer_882138795() {
		super(882138795);
	}
	
	public JSerializer_882138795(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteInlineInstance_getActor obj = (BResult_RemoteInlineInstance_getActor)obj1;		
		bout.writeObj("result",obj.result, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteInlineInstance_getActor obj = (BResult_RemoteInlineInstance_getActor)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteInlineInstance_getActor()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (com.wilutions.byps.test.api.inl.Actor)bin.readObj("result", false, null);
		
		return obj;
	}
	
}
