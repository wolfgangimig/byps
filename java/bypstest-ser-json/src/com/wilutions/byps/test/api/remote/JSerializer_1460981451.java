package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_setObj1
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
public class JSerializer_1460981451 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1460981451();
	
	
	public JSerializer_1460981451() {
		super(1460981451);
	}
	
	public JSerializer_1460981451(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteMapTypes_setObj1 obj = (BResult_RemoteMapTypes_setObj1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteMapTypes_setObj1()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
