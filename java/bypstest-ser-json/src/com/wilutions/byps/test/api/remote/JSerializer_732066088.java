package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getShort
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
public class JSerializer_732066088 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_732066088();
	
	
	public JSerializer_732066088() {
		super(732066088);
	}
	
	public JSerializer_732066088(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemotePrimitiveTypes_getShort obj = (BResult_RemotePrimitiveTypes_getShort)obj1;		
		bbuf.putShort("result", obj.result);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemotePrimitiveTypes_getShort obj = (BResult_RemotePrimitiveTypes_getShort)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemotePrimitiveTypes_getShort()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = js.getShort("result");
		
		return obj;
	}
	
}
