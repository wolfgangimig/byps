package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_getPrimitiveTypes1
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
public class JSerializer_1802821742 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1802821742();
	
	
	public JSerializer_1802821742() {
		super(1802821742);
	}
	
	public JSerializer_1802821742(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteSetTypes_getPrimitiveTypes1 obj = (BRequest_RemoteSetTypes_getPrimitiveTypes1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_getPrimitiveTypes1()));
		
		return obj;
	}
	
}
