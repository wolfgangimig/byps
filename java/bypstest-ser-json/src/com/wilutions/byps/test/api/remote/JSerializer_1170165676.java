package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteException_throwException
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
public class JSerializer_1170165676 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1170165676();
	
	
	public JSerializer_1170165676() {
		super(1170165676);
	}
	
	public JSerializer_1170165676(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteException_throwException obj = (BResult_RemoteException_throwException)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteException_throwException()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
