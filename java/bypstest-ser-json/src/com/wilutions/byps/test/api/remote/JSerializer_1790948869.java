package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getByte2
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
public class JSerializer_1790948869 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1790948869();
	
	
	public JSerializer_1790948869() {
		super(1790948869);
	}
	
	public JSerializer_1790948869(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteMapTypes_getByte2 obj = (BResult_RemoteMapTypes_getByte2)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1799280818.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteMapTypes_getByte2 obj = (BResult_RemoteMapTypes_getByte2)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteMapTypes_getByte2()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.Map<java.lang.Integer,byte[]>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1799280818.instance);
		
		return obj;
	}
	
}
