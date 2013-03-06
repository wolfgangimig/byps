package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setInt
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
public class JSerializer_946246435 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_946246435();
	
	
	public JSerializer_946246435() {
		super(946246435);
	}
	
	public JSerializer_946246435(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteArrayTypes4dim_setInt obj = (BResult_RemoteArrayTypes4dim_setInt)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteArrayTypes4dim_setInt()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
