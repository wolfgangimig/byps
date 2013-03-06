package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes4dim_setByte
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
public class JSerializer_730933722 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_730933722();
	
	
	public JSerializer_730933722() {
		super(730933722);
	}
	
	public JSerializer_730933722(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteArrayTypes4dim_setByte obj = (BResult_RemoteArrayTypes4dim_setByte)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteArrayTypes4dim_setByte()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
