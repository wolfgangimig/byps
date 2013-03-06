package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getByte
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
public class JSerializer_1271030996 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1271030996();
	
	
	public JSerializer_1271030996() {
		super(1271030996);
	}
	
	public JSerializer_1271030996(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemotePrimitiveTypes_getByte obj = (BResult_RemotePrimitiveTypes_getByte)obj1;		
		bbuf.putByte("result", obj.result);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemotePrimitiveTypes_getByte obj = (BResult_RemotePrimitiveTypes_getByte)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemotePrimitiveTypes_getByte()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = js.getByte("result");
		
		return obj;
	}
	
}
