package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setLong
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
public class JSerializer_789366700 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_789366700();
	
	
	public JSerializer_789366700() {
		super(789366700);
	}
	
	public JSerializer_789366700(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemotePrimitiveTypes_setLong obj = (BResult_RemotePrimitiveTypes_setLong)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemotePrimitiveTypes_setLong()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
