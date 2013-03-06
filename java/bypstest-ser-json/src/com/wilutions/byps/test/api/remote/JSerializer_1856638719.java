package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setDouble
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
public class JSerializer_1856638719 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1856638719();
	
	
	public JSerializer_1856638719() {
		super(1856638719);
	}
	
	public JSerializer_1856638719(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemotePrimitiveTypes_setDouble obj = (BResult_RemotePrimitiveTypes_setDouble)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemotePrimitiveTypes_setDouble()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
