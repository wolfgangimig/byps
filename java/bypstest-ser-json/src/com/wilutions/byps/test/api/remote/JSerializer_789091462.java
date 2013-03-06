package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setChar
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
public class JSerializer_789091462 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_789091462();
	
	
	public JSerializer_789091462() {
		super(789091462);
	}
	
	public JSerializer_789091462(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemotePrimitiveTypes_setChar obj = (BResult_RemotePrimitiveTypes_setChar)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemotePrimitiveTypes_setChar()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
