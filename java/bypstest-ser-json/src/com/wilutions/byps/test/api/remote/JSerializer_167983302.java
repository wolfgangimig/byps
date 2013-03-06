package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getDouble
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
public class JSerializer_167983302 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_167983302();
	
	
	public JSerializer_167983302() {
		super(167983302);
	}
	
	public JSerializer_167983302(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteArrayTypes1dim_getDouble obj = (BResult_RemoteArrayTypes1dim_getDouble)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1359468275.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteArrayTypes1dim_getDouble obj = (BResult_RemoteArrayTypes1dim_getDouble)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteArrayTypes1dim_getDouble()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (double[])bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1359468275.instance);
		
		return obj;
	}
	
}
