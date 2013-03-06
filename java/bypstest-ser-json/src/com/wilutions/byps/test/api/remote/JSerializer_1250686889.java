package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_getString
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
public class JSerializer_1250686889 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1250686889();
	
	
	public JSerializer_1250686889() {
		super(1250686889);
	}
	
	public JSerializer_1250686889(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteArrayTypes4dim_getString obj = (BResult_RemoteArrayTypes4dim_getString)obj1;		
		bout.writeObj("result",obj.result, true, com.wilutions.byps.test.api.JSerializer_588723219.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteArrayTypes4dim_getString obj = (BResult_RemoteArrayTypes4dim_getString)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteArrayTypes4dim_getString()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.lang.String[][][][])bin.readObj("result", true, com.wilutions.byps.test.api.JSerializer_588723219.instance);
		
		return obj;
	}
	
}
