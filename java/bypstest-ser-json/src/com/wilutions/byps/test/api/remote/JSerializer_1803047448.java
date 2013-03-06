package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setInt4
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
public class JSerializer_1803047448 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1803047448();
	
	
	public JSerializer_1803047448() {
		super(1803047448);
	}
	
	public JSerializer_1803047448(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteListTypes_setInt4 obj = (BResult_RemoteListTypes_setInt4)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteListTypes_setInt4()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
