﻿package com.wilutions.byps.test.api.remote;

/*
 * Serializer for com.wilutions.byps.test.api.remote.BRequest_RemoteMapTypes_getChar1
 * 
 * THIS FILE HAS BEEN GENERATED. DO NOT MODIFY.
 */

import com.wilutions.byps.*;

// DEBUG
// isEnum=false
// isFinal=true
// isInline=false
// #members=0

@SuppressWarnings("all")
public class BSerializer_1348312156 extends BSerializer {
	
	public final static BSerializer instance = new BSerializer_1348312156();
	
	public int size(final Object obj, final BBinaryModel bmodel) throws BException {
		return 0
		       /* size of base class */ + 0
		       /* padding up to multiple of alignment */ + 0;		
	}
	
	public BSerializer_1348312156() {
		super(1348312156);
	}
	
	public BSerializer_1348312156(int typeId) {
		super(typeId);
	}
	
	
	@Override
	public Object read(final Object obj1, final BInput bin1, final int version) throws BException {
		final BInputBin bin = (BInputBin)bin1;
		final BRequest_RemoteMapTypes_getChar1 obj = (BRequest_RemoteMapTypes_getChar1)(obj1 != null ? obj1 : bin.onObjectCreated(new BRequest_RemoteMapTypes_getChar1()));
		
		return obj;
	}
	
}