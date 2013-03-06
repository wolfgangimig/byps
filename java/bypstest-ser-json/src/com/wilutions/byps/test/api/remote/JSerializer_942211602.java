package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_sendAllTypes
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
public class JSerializer_942211602 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_942211602();
	
	
	public JSerializer_942211602() {
		super(942211602);
	}
	
	public JSerializer_942211602(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemotePrimitiveTypes_sendAllTypes obj = (BResult_RemotePrimitiveTypes_sendAllTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemotePrimitiveTypes_sendAllTypes()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
