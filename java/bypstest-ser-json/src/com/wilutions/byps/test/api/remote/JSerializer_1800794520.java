package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getBoolean1
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
public class JSerializer_1800794520 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1800794520();
	
	
	public JSerializer_1800794520() {
		super(1800794520);
	}
	
	public JSerializer_1800794520(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteMapTypes_getBoolean1 obj = (BResult_RemoteMapTypes_getBoolean1)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1279823631.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteMapTypes_getBoolean1 obj = (BResult_RemoteMapTypes_getBoolean1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteMapTypes_getBoolean1()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.Map<java.lang.String,java.lang.Boolean>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1279823631.instance);
		
		return obj;
	}
	
}
