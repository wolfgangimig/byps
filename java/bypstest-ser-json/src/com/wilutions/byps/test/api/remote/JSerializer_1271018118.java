package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getChar
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
public class JSerializer_1271018118 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1271018118();
	
	
	public JSerializer_1271018118() {
		super(1271018118);
	}
	
	public JSerializer_1271018118(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemotePrimitiveTypes_getChar obj = (BResult_RemotePrimitiveTypes_getChar)obj1;		
		bbuf.putChar("result", obj.result);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemotePrimitiveTypes_getChar obj = (BResult_RemotePrimitiveTypes_getChar)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemotePrimitiveTypes_getChar()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = js.getChar("result");
		
		return obj;
	}
	
}
