package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setDouble1
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
public class JSerializer_964554891 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_964554891();
	
	
	public JSerializer_964554891() {
		super(964554891);
	}
	
	public JSerializer_964554891(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteSetTypes_setDouble1 obj = (BResult_RemoteSetTypes_setDouble1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteSetTypes_setDouble1()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
