package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setChar1
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
public class JSerializer_1166332006 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1166332006();
	
	
	public JSerializer_1166332006() {
		super(1166332006);
	}
	
	public JSerializer_1166332006(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteSetTypes_setChar1 obj = (BResult_RemoteSetTypes_setChar1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteSetTypes_setChar1()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
