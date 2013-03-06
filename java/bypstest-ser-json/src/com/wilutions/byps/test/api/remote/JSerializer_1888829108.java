package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteException_throwNullPointerException
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
public class JSerializer_1888829108 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1888829108();
	
	
	public JSerializer_1888829108() {
		super(1888829108);
	}
	
	public JSerializer_1888829108(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteException_throwNullPointerException obj = (BRequest_RemoteException_throwNullPointerException)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteException_throwNullPointerException()));
		
		return obj;
	}
	
}
