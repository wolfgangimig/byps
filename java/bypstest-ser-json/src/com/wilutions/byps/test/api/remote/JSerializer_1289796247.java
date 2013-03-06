package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getInt
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
public class JSerializer_1289796247 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1289796247();
	
	
	public JSerializer_1289796247() {
		super(1289796247);
	}
	
	public JSerializer_1289796247(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteArrayTypes4dim_getInt obj = (BResult_RemoteArrayTypes4dim_getInt)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_39910537.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteArrayTypes4dim_getInt obj = (BResult_RemoteArrayTypes4dim_getInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteArrayTypes4dim_getInt()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (int[][][][])bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_39910537.instance);
		
		return obj;
	}
	
}
