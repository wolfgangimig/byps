package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteInlineInstance_setActor
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
public class JSerializer_1443251255 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1443251255();
	
	
	public JSerializer_1443251255() {
		super(1443251255);
	}
	
	public JSerializer_1443251255(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteInlineInstance_setActor obj = (BResult_RemoteInlineInstance_setActor)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteInlineInstance_setActor()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
