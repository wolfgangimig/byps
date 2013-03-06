package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_add
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
public class JSerializer_249123151 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_249123151();
	
	
	public JSerializer_249123151() {
		super(249123151);
	}
	
	public JSerializer_249123151(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemotePrimitiveTypes_add obj = (BResult_RemotePrimitiveTypes_add)obj1;		
		bbuf.putInt("result", obj.result);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemotePrimitiveTypes_add obj = (BResult_RemotePrimitiveTypes_add)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemotePrimitiveTypes_add()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = js.getInt("result");
		
		return obj;
	}
	
}
