﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_setPrimitiveTypes1
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
public class JSerializer_842962140 extends JSerializer_Object {
	
	public final static BSerializer instance = new JSerializer_842962140();
	
	
	public JSerializer_842962140() {
		super(842962140);
	}
	
	public JSerializer_842962140(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public void internalWrite(final Object obj1, final BOutputJson bout, final BBufferJson bbuf) throws BException {
		final BRequest_RemoteMapTypes_setPrimitiveTypes1 obj = (BRequest_RemoteMapTypes_setPrimitiveTypes1)obj1;		
		bout.writeObj("primitiveTypes1",obj.primitiveTypes1, false, com.wilutions.byps.test.api.JSerializer_703065817.instance);
	}
	
	@Override
	public Object internalRead(final Object obj1, final BInputJson bin) throws BException {
		final BRequest_RemoteMapTypes_setPrimitiveTypes1 obj = (BRequest_RemoteMapTypes_setPrimitiveTypes1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_setPrimitiveTypes1()));
		
		final BJsonObject js = bin.currentObject;
		obj.primitiveTypes1 = (java.util.Map<java.lang.Integer,com.wilutions.byps.test.api.prim.PrimitiveTypes>)bin.readObj("primitiveTypes1", false, com.wilutions.byps.test.api.JSerializer_703065817.instance);
		
		return obj;
	}
	
}