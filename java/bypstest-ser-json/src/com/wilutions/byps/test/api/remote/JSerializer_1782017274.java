package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getLong1
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
public class JSerializer_1782017274 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1782017274();
	
	
	public JSerializer_1782017274() {
		super(1782017274);
	}
	
	public JSerializer_1782017274(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteMapTypes_getLong1 obj = (BResult_RemoteMapTypes_getLong1)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1973996106.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteMapTypes_getLong1 obj = (BResult_RemoteMapTypes_getLong1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteMapTypes_getLong1()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.Map<java.lang.Short,java.lang.Long>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1973996106.instance);
		
		return obj;
	}
	
}
