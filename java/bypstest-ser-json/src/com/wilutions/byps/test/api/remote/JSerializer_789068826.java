package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_setBool
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
public class JSerializer_789068826 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_789068826();
	
	
	public JSerializer_789068826() {
		super(789068826);
	}
	
	public JSerializer_789068826(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemotePrimitiveTypes_setBool obj = (BResult_RemotePrimitiveTypes_setBool)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemotePrimitiveTypes_setBool()));
		
		final BJsonObject js = bin.currentObject;
		// void result		
		return obj;
	}
	
}
