package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_getString
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
public class JSerializer_265988986 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_265988986();
	
	
	public JSerializer_265988986() {
		super(265988986);
	}
	
	public JSerializer_265988986(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteArrayTypes1dim_getString obj = (BResult_RemoteArrayTypes1dim_getString)obj1;		
		bout.writeObj("result",obj.result, true, com.wilutions.byps.test.api.JSerializer_1888107655.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteArrayTypes1dim_getString obj = (BResult_RemoteArrayTypes1dim_getString)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteArrayTypes1dim_getString()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.lang.String[])bin.readObj("result", true, com.wilutions.byps.test.api.JSerializer_1888107655.instance);
		
		return obj;
	}
	
}
