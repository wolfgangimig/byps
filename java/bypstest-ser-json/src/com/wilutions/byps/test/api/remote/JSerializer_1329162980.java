package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getChar
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
public class JSerializer_1329162980 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1329162980();
	
	
	public JSerializer_1329162980() {
		super(1329162980);
	}
	
	public JSerializer_1329162980(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteArrayTypes4dim_getChar obj = (BResult_RemoteArrayTypes4dim_getChar)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_769021986.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteArrayTypes4dim_getChar obj = (BResult_RemoteArrayTypes4dim_getChar)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteArrayTypes4dim_getChar()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (char[][][][])bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_769021986.instance);
		
		return obj;
	}
	
}
