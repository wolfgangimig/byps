package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getObject
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
public class JSerializer_134606504 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_134606504();
	
	
	public JSerializer_134606504() {
		super(134606504);
	}
	
	public JSerializer_134606504(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteArrayTypes1dim_getObject obj = (BResult_RemoteArrayTypes1dim_getObject)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_183594037.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteArrayTypes1dim_getObject obj = (BResult_RemoteArrayTypes1dim_getObject)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteArrayTypes1dim_getObject()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.lang.Object[])bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_183594037.instance);
		
		return obj;
	}
	
}
