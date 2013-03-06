package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteArrayTypes1dim_setString
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
public class JSerializer_51371910 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_51371910();
	
	
	public JSerializer_51371910() {
		super(51371910);
	}
	
	public JSerializer_51371910(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteArrayTypes1dim_setString obj = (BResult_RemoteArrayTypes1dim_setString)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteArrayTypes1dim_setString()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
