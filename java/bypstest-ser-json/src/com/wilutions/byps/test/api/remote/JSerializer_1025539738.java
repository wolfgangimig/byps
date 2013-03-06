package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteException_throwFirstException
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
public class JSerializer_1025539738 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1025539738();
	
	
	public JSerializer_1025539738() {
		super(1025539738);
	}
	
	public JSerializer_1025539738(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteException_throwFirstException obj = (BResult_RemoteException_throwFirstException)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteException_throwFirstException()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
