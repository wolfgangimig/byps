package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteSetTypes_setString1
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
public class JSerializer_1321265283 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_1321265283();
	
	
	public JSerializer_1321265283() {
		super(1321265283);
	}
	
	public JSerializer_1321265283(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteSetTypes_setString1 obj = (BRequest_RemoteSetTypes_setString1)obj1;		
		bout.writeObj("string1",obj.string1, false, com.wilutions.byps.test.api.JSerializer_1888799711.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteSetTypes_setString1 obj = (BRequest_RemoteSetTypes_setString1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteSetTypes_setString1()));
		
		final BJsonObject js = bin.currentObject;
		obj.string1 = (java.util.Set<java.lang.String>)bin.readObj("string1", false, com.wilutions.byps.test.api.JSerializer_1888799711.instance);
		
		return obj;
	}
	
}
