package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteMapTypes_getInt2
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
public class JSerializer_773709362 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_773709362();
	
	
	public JSerializer_773709362() {
		super(773709362);
	}
	
	public JSerializer_773709362(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteMapTypes_getInt2 obj = (BResult_RemoteMapTypes_getInt2)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.test.api.JSerializer_1633750383.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteMapTypes_getInt2 obj = (BResult_RemoteMapTypes_getInt2)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteMapTypes_getInt2()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.Map<java.lang.Integer,int[]>)bin.readObj("result", false, com.wilutions.byps.test.api.JSerializer_1633750383.instance);
		
		return obj;
	}
	
}
