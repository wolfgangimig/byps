﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemotePrimitiveTypes_getShort
 * 
 * THIS FILE HAS BEEN GENERATED BY class com.wilutions.byps.gen.j.GenSerStruct DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=0

@SuppressWarnings("all")
public class BSerializer_411895568 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_411895568();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* padding up to multiple of alignment */ + 0;		
	}
	
	public BSerializer_411895568() {
		super(411895568);
	}
	
	public BSerializer_411895568(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final long version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemotePrimitiveTypes_getShort obj = (BRequest_RemotePrimitiveTypes_getShort)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemotePrimitiveTypes_getShort()));
		
		return obj;
	}
	
}
