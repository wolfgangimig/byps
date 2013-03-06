package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getShort1
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
public class JSerializer_1825310786 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1825310786();
	
	
	public JSerializer_1825310786() {
		super(1825310786);
	}
	
	public JSerializer_1825310786(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteSetTypes_getShort1 obj = (BResult_RemoteSetTypes_getShort1)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_2028443792.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteSetTypes_getShort1 obj = (BResult_RemoteSetTypes_getShort1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteSetTypes_getShort1()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.Set<java.lang.Short>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_2028443792.instance);
		
		return obj;
	}
	
}
