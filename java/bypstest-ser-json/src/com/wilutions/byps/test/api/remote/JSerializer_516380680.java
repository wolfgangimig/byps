package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_setInt2
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
public class JSerializer_516380680 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_516380680();
	
	
	public JSerializer_516380680() {
		super(516380680);
	}
	
	public JSerializer_516380680(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteSetTypes_setInt2 obj = (BResult_RemoteSetTypes_setInt2)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteSetTypes_setInt2()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
