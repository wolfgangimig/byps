package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getObject
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
public class JSerializer_1382069371 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1382069371();
	
	
	public JSerializer_1382069371() {
		super(1382069371);
	}
	
	public JSerializer_1382069371(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteArrayTypes4dim_getObject obj = (BResult_RemoteArrayTypes4dim_getObject)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_124584219.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteArrayTypes4dim_getObject obj = (BResult_RemoteArrayTypes4dim_getObject)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteArrayTypes4dim_getObject()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.lang.Object[][][][])bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_124584219.instance);
		
		return obj;
	}
	
}
