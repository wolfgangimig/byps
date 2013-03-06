package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteListTypes_setDouble1
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
public class JSerializer_1837040675 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1837040675();
	
	
	public JSerializer_1837040675() {
		super(1837040675);
	}
	
	public JSerializer_1837040675(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteListTypes_setDouble1 obj = (BResult_RemoteListTypes_setDouble1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteListTypes_setDouble1()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
