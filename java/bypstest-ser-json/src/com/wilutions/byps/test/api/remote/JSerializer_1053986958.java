package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteEnums_setPlanet
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
public class JSerializer_1053986958 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1053986958();
	
	
	public JSerializer_1053986958() {
		super(1053986958);
	}
	
	public JSerializer_1053986958(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteEnums_setPlanet obj = (BResult_RemoteEnums_setPlanet)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteEnums_setPlanet()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
