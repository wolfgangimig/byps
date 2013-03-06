package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getChar1
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=0

@SuppressWarnings("all")
public class JSerializer_1348312156 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1348312156();
	
	
	public JSerializer_1348312156() {
		super(1348312156);
	}
	
	public JSerializer_1348312156(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteMapTypes_getChar1 obj = (BRequest_RemoteMapTypes_getChar1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_getChar1()));
		
		return obj;
	}
	
}
