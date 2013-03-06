package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteException_throwNullPointerException
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
public class JSerializer_2113544940 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_2113544940();
	
	
	public JSerializer_2113544940() {
		super(2113544940);
	}
	
	public JSerializer_2113544940(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteException_throwNullPointerException obj = (BResult_RemoteException_throwNullPointerException)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteException_throwNullPointerException()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
