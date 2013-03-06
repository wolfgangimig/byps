package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setInt1
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
public class JSerializer_1803047451 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1803047451();
	
	
	public JSerializer_1803047451() {
		super(1803047451);
	}
	
	public JSerializer_1803047451(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteListTypes_setInt1 obj = (BResult_RemoteListTypes_setInt1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteListTypes_setInt1()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
