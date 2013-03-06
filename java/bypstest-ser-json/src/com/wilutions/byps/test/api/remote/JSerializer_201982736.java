package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteArrayTypes4dim_setChar
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
public class JSerializer_201982736 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_201982736();
	
	
	public JSerializer_201982736() {
		super(201982736);
	}
	
	public JSerializer_201982736(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteArrayTypes4dim_setChar obj = (BRequest_RemoteArrayTypes4dim_setChar)obj1;		
		bout.writeObj("v",obj.v, false, com.wilutions.byps.test.api.JSerializer_769021986.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteArrayTypes4dim_setChar obj = (BRequest_RemoteArrayTypes4dim_setChar)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteArrayTypes4dim_setChar()));
		
		final BJsonObject js = bin.currentObject;
		obj.v = (char[][][][])bin.readObj("v", false, com.wilutions.byps.test.api.JSerializer_769021986.instance);
		
		return obj;
	}
	
}
