package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getChar
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
public class JSerializer_1716411137 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1716411137();
	
	
	public JSerializer_1716411137() {
		super(1716411137);
	}
	
	public JSerializer_1716411137(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteArrayTypes1dim_getChar obj = (BResult_RemoteArrayTypes1dim_getChar)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1361632968.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteArrayTypes1dim_getChar obj = (BResult_RemoteArrayTypes1dim_getChar)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteArrayTypes1dim_getChar()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (char[])bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1361632968.instance);
		
		return obj;
	}
	
}
