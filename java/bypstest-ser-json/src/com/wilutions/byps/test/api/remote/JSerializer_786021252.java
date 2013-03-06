package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getShort1
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
public class JSerializer_786021252 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_786021252();
	
	
	public JSerializer_786021252() {
		super(786021252);
	}
	
	public JSerializer_786021252(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteMapTypes_getShort1 obj = (BResult_RemoteMapTypes_getShort1)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_601099730.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteMapTypes_getShort1 obj = (BResult_RemoteMapTypes_getShort1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteMapTypes_getShort1()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.Map<java.lang.Long,java.lang.Short>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_601099730.instance);
		
		return obj;
	}
	
}
