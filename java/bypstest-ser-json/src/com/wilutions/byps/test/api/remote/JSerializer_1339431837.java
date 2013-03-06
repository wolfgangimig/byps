package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemotePrimitiveTypes_getObject
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
public class JSerializer_1339431837 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1339431837();
	
	
	public JSerializer_1339431837() {
		super(1339431837);
	}
	
	public JSerializer_1339431837(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemotePrimitiveTypes_getObject obj = (BResult_RemotePrimitiveTypes_getObject)obj1;		
		bout.writeObj("result",obj.result, false, null);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemotePrimitiveTypes_getObject obj = (BResult_RemotePrimitiveTypes_getObject)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemotePrimitiveTypes_getObject()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.lang.Object)bin.readObj("result", false, null);
		
		return obj;
	}
	
}
