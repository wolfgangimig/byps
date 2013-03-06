package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteReferences_setNode
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
public class JSerializer_579712360 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_579712360();
	
	
	public JSerializer_579712360() {
		super(579712360);
	}
	
	public JSerializer_579712360(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteReferences_setNode obj = (BResult_RemoteReferences_setNode)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteReferences_setNode()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
