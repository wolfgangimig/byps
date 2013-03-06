package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getDouble
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
public class JSerializer_1642021643 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1642021643();
	
	
	public JSerializer_1642021643() {
		super(1642021643);
	}
	
	public JSerializer_1642021643(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemotePrimitiveTypes_getDouble obj = (BResult_RemotePrimitiveTypes_getDouble)obj1;		
		bbuf.putDouble("result", obj.result);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemotePrimitiveTypes_getDouble obj = (BResult_RemotePrimitiveTypes_getDouble)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemotePrimitiveTypes_getDouble()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = js.getDouble("result");
		
		return obj;
	}
	
}
