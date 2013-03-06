package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getPrimitiveTypes
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
public class JSerializer_251124165 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_251124165();
	
	
	public JSerializer_251124165() {
		super(251124165);
	}
	
	public JSerializer_251124165(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteArrayTypes1dim_getPrimitiveTypes obj = (BResult_RemoteArrayTypes1dim_getPrimitiveTypes)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_801243127.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteArrayTypes1dim_getPrimitiveTypes obj = (BResult_RemoteArrayTypes1dim_getPrimitiveTypes)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteArrayTypes1dim_getPrimitiveTypes()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (com.wilutions.byps.test.api.prim.PrimitiveTypes[])bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_801243127.instance);
		
		return obj;
	}
	
}
