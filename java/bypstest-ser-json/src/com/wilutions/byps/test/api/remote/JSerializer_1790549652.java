package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getChar1
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
public class JSerializer_1790549652 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1790549652();
	
	
	public JSerializer_1790549652() {
		super(1790549652);
	}
	
	public JSerializer_1790549652(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteMapTypes_getChar1 obj = (BResult_RemoteMapTypes_getChar1)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_8789515.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteMapTypes_getChar1 obj = (BResult_RemoteMapTypes_getChar1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteMapTypes_getChar1()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.TreeMap<java.lang.Float,java.lang.Character>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_8789515.instance);
		
		return obj;
	}
	
}
