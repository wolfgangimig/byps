package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getFloat
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
public class JSerializer_743953224 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_743953224();
	
	
	public JSerializer_743953224() {
		super(743953224);
	}
	
	public JSerializer_743953224(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemotePrimitiveTypes_getFloat obj = (BResult_RemotePrimitiveTypes_getFloat)obj1;		
		bbuf.putFloat("result", obj.result);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemotePrimitiveTypes_getFloat obj = (BResult_RemotePrimitiveTypes_getFloat)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemotePrimitiveTypes_getFloat()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = js.getFloat("result");
		
		return obj;
	}
	
}
