package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BResult_RemoteSetTypes_getObj1
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
public class JSerializer_1718643939 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1718643939();
	
	
	public JSerializer_1718643939() {
		super(1718643939);
	}
	
	public JSerializer_1718643939(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BResult_RemoteSetTypes_getObj1 obj = (BResult_RemoteSetTypes_getObj1)obj1;		
		bout.writeObj("result",obj.result, false, com.wilutions.byps.JSerializer_14.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BResult_RemoteSetTypes_getObj1 obj = (BResult_RemoteSetTypes_getObj1)(obj1 != null ? obj1 : bin.onObjectCreated(new BResult_RemoteSetTypes_getObj1()));
		
		final BJsonObject js = bin.currentObject;
		obj.result = (java.util.Set<java.lang.Object>)bin.readObj("result", false, com.wilutions.byps.JSerializer_14.instance);
		
		return obj;
	}
	
}
