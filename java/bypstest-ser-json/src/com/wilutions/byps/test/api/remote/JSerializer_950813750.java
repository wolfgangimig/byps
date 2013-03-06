package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getPrimitiveTypes1
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
public class JSerializer_950813750 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_950813750();
	
	
	public JSerializer_950813750() {
		super(950813750);
	}
	
	public JSerializer_950813750(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteSetTypes_getPrimitiveTypes1 obj = (BResult_RemoteSetTypes_getPrimitiveTypes1)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1280571537.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteSetTypes_getPrimitiveTypes1 obj = (BResult_RemoteSetTypes_getPrimitiveTypes1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteSetTypes_getPrimitiveTypes1()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.Set<com.wilutions.byps.test.api.prim.PrimitiveTypes>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1280571537.instance);
		
		return obj;
	}
	
}
