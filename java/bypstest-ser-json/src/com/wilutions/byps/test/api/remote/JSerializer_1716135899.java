package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getLong
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
public class JSerializer_1716135899 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1716135899();
	
	
	public JSerializer_1716135899() {
		super(1716135899);
	}
	
	public JSerializer_1716135899(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteArrayTypes1dim_getLong obj = (BResult_RemoteArrayTypes1dim_getLong)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1097129250.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteArrayTypes1dim_getLong obj = (BResult_RemoteArrayTypes1dim_getLong)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteArrayTypes1dim_getLong()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (long[])bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1097129250.instance);
		
		return obj;
	}
	
}
