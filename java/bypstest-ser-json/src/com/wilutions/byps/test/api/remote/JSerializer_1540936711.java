package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_setActorList
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
public class JSerializer_1540936711 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1540936711();
	
	
	public JSerializer_1540936711() {
		super(1540936711);
	}
	
	public JSerializer_1540936711(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteInlineInstance_setActorList obj = (BResult_RemoteInlineInstance_setActorList)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteInlineInstance_setActorList()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
