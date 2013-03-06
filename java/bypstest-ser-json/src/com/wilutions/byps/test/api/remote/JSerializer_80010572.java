package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setObject
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
public class JSerializer_80010572 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_80010572();
	
	
	public JSerializer_80010572() {
		super(80010572);
	}
	
	public JSerializer_80010572(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteArrayTypes1dim_setObject obj = (BResult_RemoteArrayTypes1dim_setObject)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteArrayTypes1dim_setObject()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
