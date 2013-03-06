package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setFloat1
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
public class JSerializer_1027363448 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1027363448();
	
	
	public JSerializer_1027363448() {
		super(1027363448);
	}
	
	public JSerializer_1027363448(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteMapTypes_setFloat1 obj = (BRequest_RemoteMapTypes_setFloat1)obj1;		
		bout.writeObj("float1",obj.float1, false, com.wilutions.byps.test.api.JSerializer_94341197.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteMapTypes_setFloat1 obj = (BRequest_RemoteMapTypes_setFloat1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setFloat1()));
		
		final BJsonObject js = bin.currentObject;
		obj.float1 = (java.util.Map<java.lang.Character,java.lang.Float>)bin.readObj("float1", false, com.wilutions.byps.test.api.JSerializer_94341197.instance);
		
		return obj;
	}
	
}
