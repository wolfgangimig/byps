package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setDouble
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
public class JSerializer_1899276253 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1899276253();
	
	
	public JSerializer_1899276253() {
		super(1899276253);
	}
	
	public JSerializer_1899276253(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteArrayTypes4dim_setDouble obj = (BResult_RemoteArrayTypes4dim_setDouble)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteArrayTypes4dim_setDouble()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
